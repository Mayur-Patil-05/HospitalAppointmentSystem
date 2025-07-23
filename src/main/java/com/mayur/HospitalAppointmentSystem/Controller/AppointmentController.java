package com.mayur.HospitalAppointmentSystem.Controller;

import com.mayur.HospitalAppointmentSystem.Dto.AppointmentDto;
import com.mayur.HospitalAppointmentSystem.Dto.DoctorDto;
import com.mayur.HospitalAppointmentSystem.Exception.AppointmentNotFoundException;
import com.mayur.HospitalAppointmentSystem.Mapper.AppointmentMapper;
import com.mayur.HospitalAppointmentSystem.Model.Appointment;
import com.mayur.HospitalAppointmentSystem.Service.AppointmentService;
import com.mayur.HospitalAppointmentSystem.Service.DoctorService;
import com.mayur.HospitalAppointmentSystem.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
    private final AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping("{patientId}/{doctorId}")
    public ResponseEntity<AppointmentDto> createAppointment(@PathVariable Long patientId,
                                                            @PathVariable Long doctorId,
                                                            @RequestBody AppointmentDto appointmentDto) {
        return new ResponseEntity<>(appointmentService.addAppointment(patientId, doctorId, appointmentDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<AppointmentDto>> getAppointments(@RequestParam(defaultValue = "0") int size,
                                                                @RequestParam(defaultValue = "3") int page,
                                                                @RequestParam(defaultValue = "asc") String direction,
                                                                @RequestParam(defaultValue = "appointmentId") String sortBy) {
        return new ResponseEntity<>(appointmentService.getAllAppointments(size, page, direction, sortBy), HttpStatus.OK);
    }

    @GetMapping("/{appointmentId}")
    public ResponseEntity<AppointmentDto> getAppointmentById(@PathVariable Long appointmentId) {
        return new ResponseEntity<>(appointmentService.getAppointmentById(appointmentId), HttpStatus.OK);
    }

    @PutMapping("/{appointmentId}")
    public ResponseEntity<AppointmentDto> updateAppointment(@PathVariable Long appointmentId, @RequestBody AppointmentDto appointmentDto) {
        return new ResponseEntity<>(appointmentService.updateAppointment(appointmentId, appointmentDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{appointmentId}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable Long appointmentId) {
        appointmentService.deleteAppointment(appointmentId);
        return ResponseEntity.noContent().build();
    }
}
