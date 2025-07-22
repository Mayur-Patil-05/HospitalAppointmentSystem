package com.mayur.HospitalAppointmentSystem.Repository;

import com.mayur.HospitalAppointmentSystem.Model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}