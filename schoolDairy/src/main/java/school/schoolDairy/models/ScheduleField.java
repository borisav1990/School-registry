package school.schoolDairy.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="schedule_field")
public class ScheduleField {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "day_id")
	private Day day;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "subject_id")
	private SchoolSubject subject;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "time_id")
	private OrdinalTime time;
	
	
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "schedule_id")
	private Schedule schedule;



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Day getDay() {
		return day;
	}



	public void setDay(Day day) {
		this.day = day;
	}



	public SchoolSubject getSubject() {
		return subject;
	}



	public void setSubject(SchoolSubject subject) {
		this.subject = subject;
	}



	public OrdinalTime getTime() {
		return time;
	}



	public void setTime(OrdinalTime time) {
		this.time = time;
	}



	public Schedule getSchedule() {
		return schedule;
	}



	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

   

	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
