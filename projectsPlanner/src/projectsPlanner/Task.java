package projectsPlanner;
import java.util.Date;

public class Task {
	private String title;
	private String description;
	private Date startDate;
	private Date endDate;
	private String status;
	private int duration;
	private String responsiblePerson;
	
	public Task() {}
	public Task(String title, String description, Date startDate, Date endDate, String status) {
		this.title = title;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
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


	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public Date getEndDate() {
		return endDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public int getDuration() {
		return duration;
	}

	public String getResponsiblePerson() {
		return responsiblePerson;
	}


	public void setResponsiblePerson(String responsiblePerson) {
		this.responsiblePerson = responsiblePerson;
	}

	
}
