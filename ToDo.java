import java.util.*;

public class ToDo {
  List<String> entries = new ArrayList<String>();

  public ToDo() {

  }

  public void add(String task){
    entries.add(task);
  }

  public void done(int entryNo){
    entries.remove(entryNo);
  }

  public void printToDos(){
    for (int i=0; i< entries.size();i++){
      System.out.println(i + ". " + entries.get(i));
    }
  }

}