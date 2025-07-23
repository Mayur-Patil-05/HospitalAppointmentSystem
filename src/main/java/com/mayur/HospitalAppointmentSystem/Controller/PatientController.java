package com.mayur.HospitalAppointmentSystem.Controller;

import com.mayur.HospitalAppointmentSystem.Dto.PatientDto;
import com.mayur.HospitalAppointmentSystem.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patients")
public class PatientController {

    public final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping
    public ResponseEntity<PatientDto> registerPatient(@RequestBody PatientDto patientDto) {
        return new ResponseEntity<>(patientService.registerPatient(patientDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<PatientDto>> getPatients(@RequestParam(defaultValue = "0") int size,
                                                        @RequestParam(defaultValue = "3") int page,
                                                        @RequestParam(defaultValue = "asc") String direction,
                                                        @RequestParam(defaultValue = "patientId") String sortBy) {
        return new ResponseEntity<>(patientService.getPatients(size, page, direction, sortBy), HttpStatus.OK);
    }

    @GetMapping("/{patientId}")
    public ResponseEntity<PatientDto> getPatientById(@PathVariable Long patientId) {
        return new ResponseEntity<>(patientService.getPatientById(patientId), HttpStatus.OK);
    }

    @PutMapping("/{patientId}")
    public ResponseEntity<PatientDto> updatePatient(@PathVariable Long patientId, @RequestBody PatientDto patientDto) {
        return new ResponseEntity<>(patientService.updatePatient(patientId, patientDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{patientId}")
    public ResponseEntity<Void> deletePatientById(@PathVariable Long patientId) {
        patientService.deletePatientById(patientId);
        return ResponseEntity.noContent().build();
    }
}
