package com.shahinkhalajestani.reservations.dao;

import java.util.Optional;

import com.shahinkhalajestani.reservations.model.Reservation;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationDao extends JpaRepository<Reservation, Long> {

	Optional<Reservation> findByReservationId(String reservationId);
}
