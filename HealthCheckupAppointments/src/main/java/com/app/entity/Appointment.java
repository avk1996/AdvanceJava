package com.app.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "appointments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "appointment_id")
	private Long id;

	@Column(name = "patients_name", length = 50, nullable = false)
	private String paitentsName;

	@Column
	private int doctor;

	@Column(name = "appointment_date")
	private LocalDate appointmentDate;

	@Column(name = "appointment_time")
	private String appointmentTime;

	public String getPaitentsName() {
		return paitentsName;
	}

	public void setPaitentsName(String paitentsName) {
		this.paitentsName = paitentsName;
	}

	public int getDoctor() {
		return doctor;
	}

	public void setDoctor(int doctor) {
		this.doctor = doctor;
	}

	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentTime(LocalTime appointmentTime) {
		if (appointmentTime != null) {
			this.appointmentTime = appointmentTime.format(DateTimeFormatter.ofPattern("HH:mm:ss.SSSX"));
		} else {
			this.appointmentTime = null;
		}
	}

	public String getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(String appointmentTime) {
		this.appointmentTime = appointmentTime;
	}

	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public Long getId() {
		return id;
	}

}
