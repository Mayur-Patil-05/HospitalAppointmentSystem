package com.mayur.HospitalAppointmentSystem.Controller;

import com.mayur.HospitalAppointmentSystem.Dto.PrescriptionDto;
import com.mayur.HospitalAppointmentSystem.Service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

    @GetMapping
    public ResponseEntity<Page<PrescriptionDto>> getPrescriptions(@RequestParam(defaultValue = "0") int size,
                                                                  @RequestParam(defaultValue = "3") int page,
                                                                  @RequestParam(defaultValue = "asc") String direction,
                                                                  @RequestParam(defaultValue = "prescriptionId") String sortBy) {
        return new ResponseEntity<>(prescriptionService.getAllPrescriptions(size, page, direction, sortBy), HttpStatus.OK);
    }

    @GetMapping("/{prescriptionId}")
    public ResponseEntity<PrescriptionDto> getPrescriptionById(@PathVariable Long prescriptionId) {
        return new ResponseEntity<>(prescriptionService.getPrescriptionById(prescriptionId), HttpStatus.OK);
    }

    @PutMapping("/{prescriptionId}")
    public ResponseEntity<PrescriptionDto> updatePrescription(@PathVariable Long prescriptionId, @RequestBody PrescriptionDto prescriptionDto) {
        return new ResponseEntity<>(prescriptionService.updatePrescription(prescriptionId, prescriptionDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{prescriptionId}")
    public ResponseEntity<Void> deletePrescription(@PathVariable Long prescriptionId) {
        prescriptionService.deletePrescription(prescriptionId);
        return ResponseEntity.noContent().build();
    }
}
