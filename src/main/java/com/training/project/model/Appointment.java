package com.training.project.model;

import java.time.*;
import java.util.Objects;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "appointments")
public class Appointment {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "appointment_id")
    private Integer appointmentId;
	
	@Column(name = "appointment_date")
    private LocalDate appointmentDate;
	
	@Column(name = "apt_time")
    private LocalDateTime aptTime;
	
	@Column(name = "token_no")
    private Integer tokenNo;
	
	@Column(name = "reason", columnDefinition = "CLOB")
    private String reason;
    
    @Column(name="created_at",updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;
    
    @ManyToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "patient_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Patient patient;
    
    @ManyToOne
    @JoinColumn(name = "schedule_id", referencedColumnName= "schedule_id", nullable = false)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Schedule schedule;
    
    @ManyToOne
    @JoinColumn(name = "status_id",referencedColumnName="status_id")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private AppointmentsStatus status;

	public Appointment() {
		super();
	}

	public Appointment(Integer appointmentId, LocalDate appointmentDate, LocalDateTime aptTime, Integer tokenNo,
			String reason, LocalDateTime createdAt, Patient patient, Schedule schedule, AppointmentsStatus status) {
		super();
		this.appointmentId = appointmentId;
		this.appointmentDate = appointmentDate;
		this.aptTime = aptTime;
		this.tokenNo = tokenNo;
		this.reason = reason;
		this.createdAt = createdAt;
		this.patient = patient;
		this.schedule = schedule;
		this.status = status;
	}

	public Appointment(LocalDate appointmentDate, LocalDateTime aptTime, Integer tokenNo, String reason,
			LocalDateTime createdAt, Patient patient, Schedule schedule, AppointmentsStatus status) {
		super();
		this.appointmentDate = appointmentDate;
		this.aptTime = aptTime;
		this.tokenNo = tokenNo;
		this.reason = reason;
		this.createdAt = createdAt;
		this.patient = patient;
		this.schedule = schedule;
		this.status = status;
	}
	
	public Integer getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Integer appointmentId) {
		this.appointmentId = appointmentId;
	}

	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public LocalDateTime getAptTime() {
		return aptTime;
	}

	public void setAptTime(LocalDateTime aptTime) {
		this.aptTime = aptTime;
	}

	public Integer getTokenNo() {
		return tokenNo;
	}

	public void setTokenNo(Integer tokenNo) {
		this.tokenNo = tokenNo;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public AppointmentsStatus getStatus() {
		return status;
	}

	public void setStatus(AppointmentsStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", appointmentDate=" + appointmentDate + ", aptTime="
				+ aptTime + ", tokenNo=" + tokenNo + ", reason=" + reason + ", createdAt=" + createdAt + ", patient="
				+ patient + ", schedule=" + schedule + ", status=" + status + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(appointmentId);
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
		Appointment other = (Appointment) obj;
		return Objects.equals(appointmentId, other.appointmentId);
	}
}