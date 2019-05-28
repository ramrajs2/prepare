import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class PreparationTest {


  public static void main(String[] args) throws IOException {
    List<String> strings = new LinkedList<>();

    /*
    Run the command below to generate the questions file
    curl https://www.geeksforgeeks.org/fundamentals-of-algorithms/ | grep href | grep "<li><a title" | cut -d"\"" -f4,7 | cut -d">" -f1,2 > /tmp/questions.txt
     */
    BufferedReader reader = new BufferedReader(
      new FileReader("/tmp/questions.txt"));

    String readline;
    while((readline = reader.readLine()) != null) {
      strings.add(readline);
    }

    play(strings);
  }

    private static BufferedReader cmdReader =
      new BufferedReader(new InputStreamReader(System.in));
  private static void play(List<String> strings) throws IOException {

    try {
      while (true) {
        printOneRandomString(strings);
      }
    }
    catch (Throwable t) {
      t.printStackTrace();
    }
  }

  private static void printOneRandomString(List<String> strings)
    throws IOException {
    Random random = new Random();
    String question[] = strings.get(random.nextInt(strings.size())).split("\"");
    System.out.println(question[1]);

    System.out.println("continue? (y/n[Enter])");
    if(cmdReader.readLine().equalsIgnoreCase("y")) {
      System.out.println("loading url: " + question[0]);
      readUrl3(question[0]);
      System.out.println("question url: " + question[0]);
      System.out.println("===============================================================");
      System.out.println("\n\n\nnext? ");
      cmdReader.readLine();
    }
  }

  public static void readUrl3(String question) throws IOException {
    URL google = new URL(question);
    URLConnection yc = google.openConnection();
    BufferedReader in = new BufferedReader(new InputStreamReader(yc
      .getInputStream()));
    String inputLine;

    // skip all header parts
    while ((inputLine = in.readLine()) != null) {
      if(inputLine.contains("<div class=\"entry-content\">")){
        break;
      }
    }

    System.out.println("Instructions: \n    Keep pressing enter to read line "
      + "by line!!");
    System.out.println("    Press n to stop printing the questions and move to "
      + "next");
    while (!cmdReader.readLine().equalsIgnoreCase("n") &&
      (inputLine = in.readLine()) != null) {
      if (inputLine.contains("Recommended:") || inputLine
        .contains("strongly recommend") || inputLine.contains("try this")) {
        break;
      }
      System.out.println(inputLine);
    }

  }
  public static void readUrl2(String question) {
    try {
      URL google = new URL(question);
      URLConnection yc = google.openConnection();
      BufferedReader in = new BufferedReader(new InputStreamReader(yc
        .getInputStream()));
      String inputLine;
      boolean questionStarted = false;
      while ((inputLine = in.readLine()) != null) {
        if(inputLine.contains("<div class=\"entry-content\">")) {
          questionStarted = true;
        }
        if(inputLine.contains("Recommended: Please solve it")) {
          questionStarted = false;
        }
        if(inputLine.equalsIgnoreCase("&nbsp;<br />")) {
          continue;
        }
        if(questionStarted) {
          System.out.println(inputLine);
        }
      }
      in.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static void readUrl(String question) throws IOException {
    URL url = new URL(question);
    BufferedReader urlReader =
      new BufferedReader(new InputStreamReader(url.openStream()));

    String line;
    while (!cmdReader.readLine().equalsIgnoreCase("n") &&
      (line = urlReader.readLine()) != null) {
      System.out.println(line);
    }
  }

}
