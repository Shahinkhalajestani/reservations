package com.shahinkhalajestani.reservations.controller;

import com.shahinkhalajestani.reservations.service.ReservationService;
import com.shahinkhalajestani.reservations.ReservationDto;
import com.shahinkhalajestani.reservations.base.model.ResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reservations")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping("/reserve/{username}")
    public ResponseEntity<ResponseModel> reserveNextAvailableSlot(@PathVariable String username) {
        ReservationDto reservationDto = reservationService.reserveNextAvailableSlot(username);
        return ResponseEntity.ok(reservationDto);
    }

    @DeleteMapping("/cancel/{reservationId}")
    public ResponseEntity<ResponseModel> cancelReservation(@PathVariable String reservationId) {
        reservationService.cancelReservation(reservationId);
        return ResponseEntity.ok(ResponseModel.success());
    }
}
