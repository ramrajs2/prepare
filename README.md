Run the command below to generate the questions file
curl https://www.geeksforgeeks.org/fundamentals-of-algorithms/ | grep href | grep "<li><a title" | cut -d"\"" -f4,7 | cut -d">" -f1,2 > /tmp/questions.txt

Run the java class file
java PreparationTest

This will randomly choose a question for you.
Enter - Skip and Move to next question
y - Load this question

Once the quesiton is loaded, Keep pressing enter key to display the page line by line. This is done to avoid displaying the whole page in a single shot which will show you the solution also. 

Type 'n' and press enter to close the current question. Before moving to the next question, link to the previous question for referring to the solution.

Good luck!
