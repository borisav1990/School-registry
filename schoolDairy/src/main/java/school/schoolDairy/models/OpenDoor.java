package school.schoolDairy.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name="open_door")
public class OpenDoor {
	
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "learner_id", nullable = false)
	private Learner forLearner;
	
	@Column(name="request_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date requestDate;
	
	@Column(name="time")
    private String time;
	
	
	
	@Column(name="created_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
	private Date createdDate;
	
	@Column(name = "accept", columnDefinition="tinyint(1) default 0")
	private boolean acceptOrnot;
	
	@Column(name="description")
	private String description;

	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Learner getForLearner() {
		return forLearner;
	}

	public void setForLearner(Learner forLearner) {
		this.forLearner = forLearner;
	}
	
	

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public boolean isAcceptOrnot() {
		return acceptOrnot;
	}

	public void setAcceptOrnot(boolean acceptOrnot) {
		this.acceptOrnot = acceptOrnot;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	

	
	

}
