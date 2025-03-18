package projectsPlanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Task {
	private String title;
	private String description;
	private String startDate;
	private String endDate;
	private String status;
	private long duration;
	private String responsiblePerson;
	
	public Task() {}
	public Task(String title, String description, String responsiblePerson,String status,String startDate, String endDate) {
		this.title = title;
		this.description = description;
		this.responsiblePerson= responsiblePerson;
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


	public String getStartDate() {
		return startDate;
	}


	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}


	public String getEndDate() {
		return endDate;
	}


	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public long getDuration() {
		       SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		       try {
		           Date start = dateFormat.parse(startDate);
		           Date end = dateFormat.parse(endDate);
		            long diffInMillies = end.getTime() - start.getTime();
		            return TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
           } catch (ParseException e) {
		            e.printStackTrace();
		            return 0; 
		       }
		   }
		

	public String getResponsiblePerson() {
		return responsiblePerson;
	}


	public void setResponsiblePerson(String responsiblePerson) {
		this.responsiblePerson = responsiblePerson;
	}

	
}
