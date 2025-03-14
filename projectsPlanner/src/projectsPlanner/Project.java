package projectsPlanner;

public class Project {
 
  private String title;
  private String description;
  private String responsiblePerson;
  public Project() {}
  public Project(String title,String description){
   this.title=title;
   this.description=description;
  }
  public String getTitle() {
   return title;
  }
  public void setTitle(String title) {
   this.title = title;
  }
  public String getDescription() {
   return description;
  }
  public void setDescription(String description) {
   this.description = description;
  }
  public String getResponsiblePerson() {
   return responsiblePerson;
  }
  public void setResponsiblePerson(String responsiblePerson) {
   this.responsiblePerson = responsiblePerson;
  }
  
  
 


}

