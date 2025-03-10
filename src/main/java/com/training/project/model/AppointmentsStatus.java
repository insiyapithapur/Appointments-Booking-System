package com.training.project.model;

import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "appointments_status")
public class AppointmentsStatus {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name  = "status_id")
    private Integer statusId;
	
	@Column(name = "status_name")
    private String statusName;

	public AppointmentsStatus() {
		super();
	}

	public AppointmentsStatus(Integer statusId, String statusName) {
		super();
		this.statusId = statusId;
		this.statusName = statusName;
	}

	public AppointmentsStatus(String statusName) {
		super();
		this.statusName = statusName;
	}

	/**
	 * @return the statusId
	 */
	public Integer getStatusId() {
		return statusId;
	}

	/**
	 * @param statusId the statusId to set
	 */
	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	/**
	 * @return the statusName
	 */
	public String getStatusName() {
		return statusName;
	}

	/**
	 * @param statusName the statusName to set
	 */
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(statusId);
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
		AppointmentsStatus other = (AppointmentsStatus) obj;
		return Objects.equals(statusId, other.statusId);
	}

	@Override
	public String toString() {
		return "AppointmentsStatus [statusId=" + statusId + ", statusName=" + statusName + "]";
	}
	
	
}