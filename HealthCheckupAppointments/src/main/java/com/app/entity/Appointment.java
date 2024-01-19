package com.app.entity;


import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="appointments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="appointment_id")
	private Long id;
	
	@Column(name="patients_name",length = 50,nullable = false)
	private String paitentsName;
	
	@Column
	private int doctor;
	
	@Column(name="appointment_date")
	private LocalDate appointmentDate;
	
	@Column(name="appointment_time")
	private LocalTime appointmentTime;
	//hour:minute:seconds
}
