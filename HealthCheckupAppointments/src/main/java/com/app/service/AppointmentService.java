package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.AppointmentDao;
import com.app.entity.Appointment;

@Transactional
@Service
public class AppointmentService {

	@Autowired
	private AppointmentDao appointmentRepo;

	public String arrangeAppointment(Appointment appointment) {
		appointmentRepo.save(appointment);
		return "Appointment added successfully";
	}
	
	public void cancleAppointment(Long id) {
		appointmentRepo.deleteById(id);
	}

	public List<Appointment> getAllAppointments() {
		// TODO Auto-generated method stub
		return appointmentRepo.findAll();
	}
}
