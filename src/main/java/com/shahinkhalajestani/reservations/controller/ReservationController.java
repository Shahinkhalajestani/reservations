package com.shahinkhalajestani.reservations.controller;

import com.shahinkhalajestani.reservations.service.ReservationService;
import com.shahinkhalajestani.reservations.model.ReservationDto;
import com.shahinkhalajestani.reservations.base.model.ResponseModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reservations")
@Slf4j
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping("/reserve/{username}")
    public ResponseEntity<ResponseModel> reserveNextAvailableSlot(@PathVariable String username) {
        log.info("Received reservation request for username: {}", username);
        ReservationDto reservationDto = reservationService.reserveNextAvailableSlot(username);
        log.info("Reservation created for username: {} with reservationId: {}", username, reservationDto.getReservationId());
        return ResponseEntity.ok(reservationDto);
    }

    @DeleteMapping("/cancel/{reservationId}")
    public ResponseEntity<ResponseModel> cancelReservation(@PathVariable String reservationId) {
        log.info("Received cancel reservation request for reservationId: {}", reservationId);
        reservationService.cancelReservation(reservationId);
        log.info("Reservation with reservationId: {} cancelled successfully", reservationId);
        return ResponseEntity.ok(ResponseModel.success());
    }
}
