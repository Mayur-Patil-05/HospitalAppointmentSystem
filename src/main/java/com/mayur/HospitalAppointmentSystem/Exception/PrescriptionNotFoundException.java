package com.mayur.HospitalAppointmentSystem.Exception;

public class PrescriptionNotFoundException extends RuntimeException {
    public PrescriptionNotFoundException(String message) {
        super(message);
    }
}
