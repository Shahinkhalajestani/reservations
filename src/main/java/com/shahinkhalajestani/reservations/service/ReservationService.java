package com.shahinkhalajestani.reservations.service;

import com.shahinkhalajestani.reservations.ReservationDto;

public interface ReservationService {

	ReservationDto reserveNextAvailableSlot(String username);
	void cancelReservation(String reservationId);

}
