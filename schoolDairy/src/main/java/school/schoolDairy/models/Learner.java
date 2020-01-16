package school.schoolDairy.models;

import java.io.Serializable;


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
@Table(name="learner")
public class Learner implements Serializable {

	private static final long serialVersionUID = -4112292093657028960L;

		@Id
		@GeneratedValue(strategy= GenerationType.AUTO)
		@Column(name="id")
		private Long id;
		
		@Column(name="first_name")
		private String firstName;
		
		@Column(name="last_name")
		private String lastname;
		
		@Column(name="level")
		private int level;
		
		@Column(name="department")
		private int department;
		
		
		@ManyToOne(fetch = FetchType.LAZY, optional = false)
		@JoinColumn(name = "school_class", nullable = false)
		private SchoolClass schoolClass;
		
		
		@ManyToOne(fetch = FetchType.LAZY, optional = false)
		@JoinColumn(name = "user_teacher_id", nullable = false)
		private User user;
		
		@ManyToOne(fetch = FetchType.LAZY, optional = false)
		@JoinColumn(name = "user_parent_id", nullable = false)
		private User userParent;
		
		
		
		
		

		public SchoolClass getSchoolClass() {
			return schoolClass;
		}

		public void setSchoolClass(SchoolClass schoolClass) {
			this.schoolClass = schoolClass;
		}

		public int getLevel() {
			return level;
		}

		public void setLevel(int level) {
			this.level = level;
		}

		public int getDepartment() {
			return department;
		}

		public void setDepartment(int department) {
			this.department = department;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastname() {
			return lastname;
		}

		public void setLastname(String lastname) {
			this.lastname = lastname;
		}


		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public User getUserParent() {
			return userParent;
		}

		public void setUserParent(User userParent) {
			this.userParent = userParent;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		
        
		
		

	
		
		
		
}
