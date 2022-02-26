import java.util.ArrayList;
import java.util.*;
import java.io.*;

public class ToDo2 {
  ArrayList<ToDoItem> entries = new ArrayList<ToDoItem>();
  String filename;

  public ToDo2(String filename) {
    this.filename = filename;
  }

  public void add(String task){
    ToDoItem newItem = new ToDoItem(task);
    entries.add(newItem);
  }

    public void add(String task, String priority){
    ToDoItem newItem = new ToDoItem(task,priority);
    entries.add(newItem);
  }

  public void done(int entryNo){
    entries.remove(entryNo);
  }

  public void printToDos(){
    System.out.println("ToDo List");
    System.out.println("=========");
    String priors[] = {"should", "could", "maybe"};
    for (String pr : priors){            
      for (int i=0; i< entries.size();i++){           
        if (pr.equals(entries.get(i).getPriority())){          
          System.out.println(i + ". " + entries.get(i).getTask() + " " + entries.get(i).getPriority());
        }
      }
    }
    System.out.println("=========");
    System.out.println("[add] [task description]");
    System.out.println("[done] [task number]");
    System.out.println("[priority] [task number] [could/should/maybe]");
    System.out.println("");
    System.out.println("");
    System.out.flush();
  }

  public void setPriority(int taskNo, String priority)
  {
    entries.get(taskNo).setPriority(priority);
  }


  public void writeToFile()
  {
    String text;
    try {
      FileWriter fw = new FileWriter(filename);
      BufferedWriter bw = new BufferedWriter(fw);

      for (int i=0; i< entries.size();i++){        
        text = i + " " + entries.get(i).getPriority() + " " + entries.get(i).getTask();
          bw.write(text);
          bw.newLine();
      }
      
      
      bw.close();
      fw.close();
    }
    catch (Exception ex) {
      System.out.println(ex.getMessage());
    } 
  }

  public void readFromFile(){
  
  String commands[];     
  this.entries.clear();
  int taskNo;
  String task;
  String priority;

  try {
    FileReader fr = new FileReader(filename);
    BufferedReader br = new BufferedReader(fr);
  
    String line = br.readLine();
  
    // Loop until no more lines are in the file
    while (line != null) {
      commands = line.split(" ");
      //commands[0] = task numbert
      // commands[1] = priority
      // comands[2+] = task


      taskNo = Integer.parseInt(commands[0]);      
      priority = commands[1].trim();
      task = commands[2];
      for (int i=3;i<commands.length; i++){
        task = task + " " + commands[i];
      }
      add(task, priority);


      // Get the next line
      line = br.readLine();
    }    
    br.close();    
    fr.close();
  }
  catch (Exception ex) {
    System.out.println(ex.getMessage());
  }



  }



}