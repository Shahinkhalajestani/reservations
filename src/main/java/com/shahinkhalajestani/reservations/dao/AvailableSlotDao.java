package com.shahinkhalajestani.reservations.dao;

import java.util.Optional;

import com.shahinkhalajestani.reservations.model.AvailableSlot;
import jakarta.persistence.LockModeType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

public interface AvailableSlotDao extends JpaRepository<AvailableSlot, Long> {



	@Lock(LockModeType.PESSIMISTIC_WRITE)
	@Query("SELECT s FROM AvailableSlot s WHERE s.isReserved = false ORDER BY s.startTime ASC LIMIT 1")
	Optional<AvailableSlot> findNextAvailableSlot();


}
