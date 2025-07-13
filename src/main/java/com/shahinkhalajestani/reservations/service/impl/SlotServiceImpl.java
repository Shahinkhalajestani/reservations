package com.shahinkhalajestani.reservations.service.impl;

import com.shahinkhalajestani.reservations.base.exception.RecordNotFoundException;
import com.shahinkhalajestani.reservations.dao.AvailableSlotDao;
import com.shahinkhalajestani.reservations.model.AvailableSlot;
import com.shahinkhalajestani.reservations.service.SlotService;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
