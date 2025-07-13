package com.shahinkhalajestani.reservations.service.impl;

import com.shahinkhalajestani.reservations.base.exception.RecordNotFoundException;
import com.shahinkhalajestani.reservations.dao.AvailableSlotDao;
import com.shahinkhalajestani.reservations.model.AvailableSlot;
import com.shahinkhalajestani.reservations.service.SlotService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SlotServiceImpl implements SlotService {

	private final AvailableSlotDao availableSlotDao;

	@Override
	public AvailableSlot getNextAvailableSlot() {
		return availableSlotDao.findNextAvailableSlot()
				.orElseThrow(() -> new RecordNotFoundException("No available available slot found"));
	}

	@Override
	@Transactional
	public void updateSlot(AvailableSlot availableSlot) {
		availableSlotDao.save(availableSlot);
	}

}
