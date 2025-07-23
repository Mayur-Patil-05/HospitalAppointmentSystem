package com.mayur.HospitalAppointmentSystem.Service;

import com.mayur.HospitalAppointmentSystem.Dto.PrescriptionDto;
import com.mayur.HospitalAppointmentSystem.Exception.AppointmentNotFoundException;
import com.mayur.HospitalAppointmentSystem.Mapper.PrescriptionMapper;
import com.mayur.HospitalAppointmentSystem.Model.Appointment;
import com.mayur.HospitalAppointmentSystem.Model.Prescription;
import com.mayur.HospitalAppointmentSystem.Repository.AppointmentRepository;
import com.mayur.HospitalAppointmentSystem.Repository.PrescriptionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrescriptionService {
    private final PrescriptionRepository prescriptionRepository;
    private final AppointmentRepository appointmentRepository;

    @Autowired
    public PrescriptionService(PrescriptionRepository prescriptionRepository, AppointmentRepository appointmentRepository) {
        this.prescriptionRepository = prescriptionRepository;
        this.appointmentRepository = appointmentRepository;
    }

    @Transactional
    public PrescriptionDto addPrescription(Long appointmentId, PrescriptionDto prescriptionDto) {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new AppointmentNotFoundException("Appointment not found with id : " + appointmentId));
        Prescription prescription = PrescriptionMapper.toEntity(prescriptionDto);
        prescription.setAppointment(appointment);
        Prescription savedPrescription = prescriptionRepository.save(prescription);
        return PrescriptionMapper.toDto(savedPrescription);
    }
}
