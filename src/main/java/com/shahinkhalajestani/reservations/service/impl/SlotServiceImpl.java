package com.shahinkhalajestani.reservations.service.impl;

import com.shahinkhalajestani.reservations.base.exception.RecordNotFoundException;
import com.shahinkhalajestani.reservations.dao.AvailableSlotDao;
import com.shahinkhalajestani.reservations.model.AvailableSlot;
import com.shahinkhalajestani.reservations.service.SlotService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class SlotServiceImpl implements SlotService {

	private final AvailableSlotDao availableSlotDao;

	@Override
	public AvailableSlot getNextAvailableSlot() {
		log.info("Fetching next available slot");
		return availableSlotDao.findNextAvailableSlot()
				.orElseThrow(() -> new RecordNotFoundException("No available available slot found"));
	}

	@Override
	@Transactional
	public void updateSlot(AvailableSlot availableSlot) {
		log.info("Updating slot with id: {} to reserved: {}", availableSlot.getId(), availableSlot.getIsReserved());
		availableSlotDao.save(availableSlot);
	}

}
