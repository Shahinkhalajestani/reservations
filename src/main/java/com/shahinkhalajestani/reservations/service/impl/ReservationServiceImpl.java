package com.shahinkhalajestani.reservations.service.impl;

import com.shahinkhalajestani.reservations.ReservationDto;
import com.shahinkhalajestani.reservations.base.exception.RecordNotFoundException;
import com.shahinkhalajestani.reservations.dao.ReservationDao;
import com.shahinkhalajestani.reservations.service.ReservationService;
import com.shahinkhalajestani.reservations.service.SlotService;
import com.shahinkhalajestani.reservations.service.UserService;
import com.shahinkhalajestani.reservations.service.mappers.ReservationServiceMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

	private final UserService userService;
	private final SlotService slotService;
	private final ReservationDao dao;
	private final ReservationServiceMapper mapper;

	@Override
	@Transactional
	public ReservationDto reserveNextAvailableSlot(String username) {
		log.info("Attempting to reserve next available slot for user: {}", username);
		var user = userService.findByUsername(username);
		var availableSlot = slotService.getNextAvailableSlot();
		var reservation = mapper.toReservation(availableSlot,user);
		availableSlot.setIsReserved(true);
		slotService.updateSlot(availableSlot);
		dao.save(reservation);
		log.info("Reservation successful for user: {} with reservationId: {}", username, reservation.getReservationId());
		return mapper.toReservationDto(availableSlot.getStartTime(), availableSlot.getEndTime(), user.getUsername(), reservation.getReservationId());
	}

	@Override
	@Transactional
	public void cancelReservation(String reservationId) {
		log.info("Cancelling reservation with reservationId: {}", reservationId);
		var reservation = dao.findByReservationId(reservationId)
				.orElseThrow(() -> new RecordNotFoundException("Reservation with ID " + reservationId + " not found"));
		var slot = reservation.getSlot();
		slot.setIsReserved(false);
		slotService.updateSlot(slot);
		dao.delete(reservation);
		log.info("Reservation with reservationId: {} cancelled successfully", reservationId);
	}
}
