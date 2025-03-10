package com.training.project.model;

import java.time.*;
import java.util.Objects;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "doctors")
public class Doctor {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "doctor_id")
    private Integer doctorId;
	
    private String specialization;
    
    @Column(name = "license_number")
    private String licenseNumber;
    
    private Float experience;
    private String degree;
    
    @Column(name = "is_active", nullable = false)
    private Boolean isActive;
    
    @Column(name="created_at",updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;
    
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

	public Doctor() {
		super();
	}

	public Doctor(Integer doctorId, String specialization, String licenseNumber, Float experience, String degree,
			Boolean isActive, LocalDateTime createdAt, User user) {
		super();
		this.doctorId = doctorId;
		this.specialization = specialization;
		this.licenseNumber = licenseNumber;
		this.experience = experience;
		this.degree = degree;
		this.isActive = isActive;
		this.createdAt = createdAt;
		this.user = user;
	}

	public Doctor(String specialization, String licenseNumber, Float experience, String degree, Boolean isActive,
			LocalDateTime createdAt, User user) {
		super();
		this.specialization = specialization;
		this.licenseNumber = licenseNumber;
		this.experience = experience;
		this.degree = degree;
		this.isActive = isActive;
		this.createdAt = createdAt;
		this.user = user;
	}

	/**
	 * @return the doctorId
	 */
	public Integer getDoctorId() {
		return doctorId;
	}

	/**
	 * @param doctorId the doctorId to set
	 */
	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

	/**
	 * @return the specialization
	 */
	public String getSpecialization() {
		return specialization;
	}

	/**
	 * @param specialization the specialization to set
	 */
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	/**
	 * @return the licenseNumber
	 */
	public String getLicenseNumber() {
		return licenseNumber;
	}

	/**
	 * @param licenseNumber the licenseNumber to set
	 */
	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	/**
	 * @return the experience
	 */
	public Float getExperience() {
		return experience;
	}

	/**
	 * @param experience the experience to set
	 */
	public void setExperience(Float experience) {
		this.experience = experience;
	}

	/**
	 * @return the degree
	 */
	public String getDegree() {
		return degree;
	}

	/**
	 * @param degree the degree to set
	 */
	public void setDegree(String degree) {
		this.degree = degree;
	}

	/**
	 * @return the isActive
	 */
	public Boolean getIsActive() {
		return isActive;
	}

	/**
	 * @param isActive the isActive to set
	 */
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
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
		return Objects.hash(doctorId);
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
		Doctor other = (Doctor) obj;
		return Objects.equals(doctorId, other.doctorId);
	}

	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", specialization=" + specialization + ", licenseNumber="
				+ licenseNumber + ", experience=" + experience + ", degree=" + degree + ", isActive=" + isActive
				+ ", createdAt=" + createdAt + ", user=" + user + "]";
	}
    
    
}