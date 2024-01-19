package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Appointment;
import com.app.service.AppointmentService;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;
	
	@PostMapping
	public String arrangeAppointment(@RequestBody Appointment appointment) {
		return appointmentService.arrangeAppointment(appointment);
	}
	
	@DeleteMapping("/{id}")
	public void cancleAppointment(@PathVariable Long id) {
		appointmentService.cancleAppointment(id);
	}
	
	@GetMapping
	public List<Appointment> getAllAppointments(){
		return appointmentService.getAllAppointments();
	}
}
