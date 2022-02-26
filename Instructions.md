## To-Do List

### 1 Skills
This exercise should help you with:

1. Member variables and member methods.
2. Use of multiple classes in one program.
3. Writing a useful program from scratch.

### 2 Task

Your task is to make a program to manage a to-do list. It should work on the console (i.e. in text mode). When you run your program, it should do the following:

1. Ask the user for a command, which can be something like
  * `add mow the lawn` — to add ‘mow the lawn’ to the to-do list.
  * `done 4` — to remove the 4th task from the to-do list.
  *	`quit` — quit the program.
2. Display the current to-do list.
3. Go back and ask for another command.

Hint: store the to-do list in a class called **ToDo** which has methods `add(String s)` to add an item and `done(int n)` to remove an item.

### 3 Extra Task If You Have Time

Add a new command `priority` which sets a task’s priority to "could", "should" or "maybe". An example of its use would be:
* `priority 4 could`
which would set the 4th to-do list item to priority "could". When listing the to-do items, make the program group them according to priority.

Hint: you may want to add a **ToDoItem** class to hold your items with their text and priority, then think about how to display your items in order of priority.

### 4 Extra Extra Task If You Have Far Too Much Time

Save the to-do list to a text file on disk whenever it changes.  Load this text file back into the  program when it starts. You can write a text file in Java using something like:

```java
import java.io.*;

try {
  FileWriter fw = new FileWriter("output.txt");
  BufferedWriter bw = new BufferedWriter(fw);
  bw.write("Hello World!");
  bw.close();
  fw.close();
}
catch (Exception ex) {
  System.out.println(ex.getMessage());
}
```
and read it back in using something like

```java
import java.io.*;

try {
  FileReader fr = new FileReader("output.txt");
  BufferedReader br = new BufferedReader(br);

  String line = br.readLine();

  // Loop until no more lines are in the file
  while (line != null) {
    // Print out the line you read in (just to
    // show that it's working)
    System.out.println(line);
    // Get the next line
    line = br.readLine();
  }

  br.close();
  fr.close();
}
catch (Exception ex) {
  System.out.println(ex.getMessage());
}
```




