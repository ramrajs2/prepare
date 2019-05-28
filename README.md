Run the command below to generate the questions file

```
curl https://www.geeksforgeeks.org/fundamentals-of-algorithms/ | grep href | grep "<li><a title" | cut -d"\"" -f4,7 | cut -d">" -f1,2 > /tmp/questions.txt
```

Run the java class file
```
java PreparationTest
```

This will randomly choose a question for you.

    Enter - Skip and Move to next question
    y - Load this question

Once the quesiton is loaded, 

    Enter - display the page line by line. (avoids displaying the whole page / solution)
    'n' and press enter - close the current question. 

Before moving to the next question, link to the previous question for referring to the solution.

Good luck!
