public class ToDoItem{
  private String task;
  private String priority;

  public ToDoItem(String task){
    this.task = task;  
    this.priority = "maybe";
  }

  public ToDoItem(String task, String priority){
    this.task = task;  
    this.priority = priority;
  }

  public String getTask(){
    return task;
  }

  public void setPriority(String priority){
    this.priority = priority;
  }

  public String getPriority(){
    return priority;
  }

}