package school.schoolDairy.models;

import java.io.Serializable;
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
@Table(name="grade")

public class Grade implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -432606137825922812L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="height_grade")
	private int heightGrade;
	
    
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
	@Column(name="created_date")
	private Date createdDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
	@Column(name="update_date")
	private Date updatedDate;
	
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "subject_id")
	private SchoolSubject schoolSubject;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "learner_id")
	private Learner idOfLerner;
	
	@Column(name = "final_grade", columnDefinition="tinyint(1) default 0")
	private boolean finalGrade;

	
	
	
	
	
	
	
	public boolean isFinalGrade() {
		return finalGrade;
	}

	public void setFinalGrade(boolean finalGrade) {
		this.finalGrade = finalGrade;
	}

	public SchoolSubject getSchoolSubject() {
		return schoolSubject;
	}

	public void setSchoolSubject(SchoolSubject schoolSubject) {
		this.schoolSubject = schoolSubject;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	public int getHeightGrade() {
		return heightGrade;
	}

	public void setHeightGrade(int heightGrade) {
		this.heightGrade = heightGrade;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	

	public Learner getIdOfLerner() {
		return idOfLerner;
	}

	public void setIdOfLerner(Learner idOfLerner) {
		this.idOfLerner = idOfLerner;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

	
	
	
	
	
}
