package com.training.project.model;

import java.time.*;
import java.util.Objects;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "schedules")
public class Schedule {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "schedule_id")
    private Integer scheduleId;
	
	@Column(name  = "day_of_week")
    private Integer dayOfWeek;
	
	@Column(name  = "start_time")
    private LocalDateTime startTime;
	
	@Column(name  = "end_time")
    private LocalDateTime endTime;
	
	@Column(name = "max_tokens")
    private Integer maxTokens;
	
	@Column(name = "is_available")
    private Boolean isAvailable;
	
	@Column(name="created_at",updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;
    
    @ManyToOne
    @JoinColumn(name = "doctor_id",referencedColumnName = "doctor_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Doctor doctor;

	public Schedule() {
		super();
	}

	public Schedule(Integer scheduleId, Integer dayOfWeek, LocalDateTime startTime, LocalDateTime endTime,
			Integer maxTokens, Boolean isAvailable, LocalDateTime createdAt, Doctor doctor) {
		super();
		this.scheduleId = scheduleId;
		this.dayOfWeek = dayOfWeek;
		this.startTime = startTime;
		this.endTime = endTime;
		this.maxTokens = maxTokens;
		this.isAvailable = isAvailable;
		this.createdAt = createdAt;
		this.doctor = doctor;
	}

	public Schedule(Integer dayOfWeek, LocalDateTime startTime, LocalDateTime endTime, Integer maxTokens,
			Boolean isAvailable, LocalDateTime createdAt, Doctor doctor) {
		super();
		this.dayOfWeek = dayOfWeek;
		this.startTime = startTime;
		this.endTime = endTime;
		this.maxTokens = maxTokens;
		this.isAvailable = isAvailable;
		this.createdAt = createdAt;
		this.doctor = doctor;
	}

	/**
	 * @return the scheduleId
	 */
	public Integer getScheduleId() {
		return scheduleId;
	}

	/**
	 * @param scheduleId the scheduleId to set
	 */
	public void setScheduleId(Integer scheduleId) {
		this.scheduleId = scheduleId;
	}

	/**
	 * @return the dayOfWeek
	 */
	public Integer getDayOfWeek() {
		return dayOfWeek;
	}

	/**
	 * @param dayOfWeek the dayOfWeek to set
	 */
	public void setDayOfWeek(Integer dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	/**
	 * @return the startTime
	 */
	public LocalDateTime getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return the endTime
	 */
	public LocalDateTime getEndTime() {
		return endTime;
	}

	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	/**
	 * @return the maxTokens
	 */
	public Integer getMaxTokens() {
		return maxTokens;
	}

	/**
	 * @param maxTokens the maxTokens to set
	 */
	public void setMaxTokens(Integer maxTokens) {
		this.maxTokens = maxTokens;
	}

	/**
	 * @return the isAvailable
	 */
	public Boolean getIsAvailable() {
		return isAvailable;
	}

	/**
	 * @param isAvailable the isAvailable to set
	 */
	public void setIsAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
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
	 * @return the doctor
	 */
	public Doctor getDoctor() {
		return doctor;
	}

	/**
	 * @param doctor the doctor to set
	 */
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(scheduleId);
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
		Schedule other = (Schedule) obj;
		return Objects.equals(scheduleId, other.scheduleId);
	}

	@Override
	public String toString() {
		return "Schedule [scheduleId=" + scheduleId + ", dayOfWeek=" + dayOfWeek + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", maxTokens=" + maxTokens + ", isAvailable=" + isAvailable + ", createdAt="
				+ createdAt + ", doctor=" + doctor + "]";
	}
    
    
}