package com.mayur.HospitalAppointmentSystem.Controller;

import com.mayur.HospitalAppointmentSystem.Dto.PrescriptionDto;
import com.mayur.HospitalAppointmentSystem.Exception.AppointmentNotFoundException;
import com.mayur.HospitalAppointmentSystem.Mapper.PrescriptionMapper;
import com.mayur.HospitalAppointmentSystem.Model.Appointment;
import com.mayur.HospitalAppointmentSystem.Model.Prescription;
import com.mayur.HospitalAppointmentSystem.Service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prescriptions")
public class PrescriptionController {

    private final PrescriptionService prescriptionService;

    @Autowired
    public PrescriptionController(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }

    @PostMapping("/{appointmentId}")
    public ResponseEntity<PrescriptionDto> createPrescription(@PathVariable Long appointmentId, @RequestBody PrescriptionDto prescriptionDto) {
        return new ResponseEntity<>(prescriptionService.addPrescription(appointmentId, prescriptionDto), HttpStatus.CREATED);
    }
}
