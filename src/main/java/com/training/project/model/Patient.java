package com.training.project.model;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "patients")
public class Patient {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "patient_id")
    private Integer patientId;
	
	@Column(name = "blood_grp")
    private String bloodGrp;
	
	@Column(name="created_at",updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;
    
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

	public Patient() {
		super();
	}

	public Patient(Integer patientId, String bloodGrp, LocalDateTime createdAt, User user) {
		super();
		this.patientId = patientId;
		this.bloodGrp = bloodGrp;
		this.createdAt = createdAt;
		this.user = user;
	}

	public Patient(String bloodGrp, LocalDateTime createdAt, User user) {
		super();
		this.bloodGrp = bloodGrp;
		this.createdAt = createdAt;
		this.user = user;
	}

	/**
	 * @return the patientId
	 */
	public Integer getPatientId() {
		return patientId;
	}

	/**
	 * @param patientId the patientId to set
	 */
	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}

	/**
	 * @return the bloodGrp
	 */
	public String getBloodGrp() {
		return bloodGrp;
	}

	/**
	 * @param bloodGrp the bloodGrp to set
	 */
	public void setBloodGrp(String bloodGrp) {
		this.bloodGrp = bloodGrp;
	}

	/**
	 * @return the createdAt
	 */
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		return Objects.hash(patientId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Patient other = (Patient) obj;
		return Objects.equals(patientId, other.patientId);
	}

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", bloodGrp=" + bloodGrp + ", createdAt=" + createdAt + ", user="
				+ user + "]";
	}
    
    
}