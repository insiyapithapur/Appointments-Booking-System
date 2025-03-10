package com.training.project.model;

import java.sql.Blob;
import java.time.*;
import java.util.Objects;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "medical_records")
public class MedicalRecord {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "record_id")
    private Integer recordId;
	
	@Column(name = "diagnosis", columnDefinition = "CLOB")
    private String diagnosis;
    
    @Lob
    @Column(name = "medical_report")
    private Blob medicalReport;
    
    @Column(name = "treatment", columnDefinition = "CLOB")
    private String treatment;
    
    @Column(name = "notes", columnDefinition = "CLOB")
    private String notes;
    
    @Column(name="created_at",updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;
    
    @OneToOne
    @JoinColumn(name = "appointment_id", referencedColumnName = "appointment_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Appointment appointment;

	public MedicalRecord() {
		super();
	}

	public MedicalRecord(Integer recordId, String diagnosis, Blob medicalReport, String treatment, String notes,
			LocalDateTime createdAt, Appointment appointment) {
		super();
		this.recordId = recordId;
		this.diagnosis = diagnosis;
		this.medicalReport = medicalReport;
		this.treatment = treatment;
		this.notes = notes;
		this.createdAt = createdAt;
		this.appointment = appointment;
	}

	public MedicalRecord(String diagnosis, Blob medicalReport, String treatment, String notes, LocalDateTime createdAt,
			Appointment appointment) {
		super();
		this.diagnosis = diagnosis;
		this.medicalReport = medicalReport;
		this.treatment = treatment;
		this.notes = notes;
		this.createdAt = createdAt;
		this.appointment = appointment;
	}

	/**
	 * @return the recordId
	 */
	public Integer getRecordId() {
		return recordId;
	}

	/**
	 * @param recordId the recordId to set
	 */
	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
	}

	/**
	 * @return the diagnosis
	 */
	public String getDiagnosis() {
		return diagnosis;
	}

	/**
	 * @param diagnosis the diagnosis to set
	 */
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	/**
	 * @return the medicalReport
	 */
	public Blob getMedicalReport() {
		return medicalReport;
	}

	/**
	 * @param medicalReport the medicalReport to set
	 */
	public void setMedicalReport(Blob medicalReport) {
		this.medicalReport = medicalReport;
	}

	/**
	 * @return the treatment
	 */
	public String getTreatment() {
		return treatment;
	}

	/**
	 * @param treatment the treatment to set
	 */
	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}

	/**
	 * @return the notes
	 */
	public String getNotes() {
		return notes;
	}

	/**
	 * @param notes the notes to set
	 */
	public void setNotes(String notes) {
		this.notes = notes;
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
	 * @return the appointment
	 */
	public Appointment getAppointment() {
		return appointment;
	}

	/**
	 * @param appointment the appointment to set
	 */
	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	@Override
	public int hashCode() {
		return Objects.hash(recordId);
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
		MedicalRecord other = (MedicalRecord) obj;
		return Objects.equals(recordId, other.recordId);
	}

	@Override
	public String toString() {
		return "MedicalRecords [recordId=" + recordId + ", diagnosis=" + diagnosis + ", medicalReport=" + medicalReport
				+ ", treatment=" + treatment + ", notes=" + notes + ", createdAt=" + createdAt + ", appointment="
				+ appointment + "]";
	}
    
    
}
