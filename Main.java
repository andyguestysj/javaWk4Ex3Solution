import java.util.Scanner;
import java.io.*;

class Main {
  public static void main(String[] args) {   

    boolean running = true;
    String inputString;
    //ToDo toDoList = new ToDo();
    ToDo2 toDoList = new ToDo2("AndyFile.txt");

    /*toDoList.add("Mark essays");
    toDoList.add("Drink Coffee");
    toDoList.add("Sleep");*/

    toDoList.readFromFile();

    Scanner scanner = new Scanner(System.in);
    
    while (running){
      toDoList.printToDos();
       
      running = processInput(inputString, toDoList);
         
      
    }

    System.out.println("bye");
  }

    /*
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
    */

  public static boolean processInput(String inputString, ToDo2 toDoList){
    // process input, updates ToDo list, returns false if quit select, true otherwise
    String commands[];
    String taskString;

    commands = inputString.split(" ");

    switch(commands[0]){
      case "quit":
      case "q":
                  // exit
                  toDoList.writeToFile();
                  return false;
      case "done":
                  // complete task no in commands[1]
                  toDoList.done(Integer.parseInt(commands[1]));
                  toDoList.writeToFile();
                  return true;
      case "add":
                  taskString=commands[1];
                  for (int i=2;i<commands.length; i++){
                    taskString = taskString + " " + commands[i];
                  }
                  toDoList.add(taskString);
                  toDoList.writeToFile();
                  return true;
      case "priority":
                  // Integer.parseInt(commands[1])
                  switch(commands[2]){
                    case "should":
                        toDoList.setPriority(Integer.parseInt(commands[1]),"should");
                        break;
                    case "could":
                        toDoList.setPriority(Integer.parseInt(commands[1]),"could");
                        break;
                    default:
                        toDoList.setPriority(Integer.parseInt(commands[1]),"maybe");
                        break;
                  }
                  toDoList.writeToFile();
                  return true;
      default:
                return true;
    }  
}


}

 