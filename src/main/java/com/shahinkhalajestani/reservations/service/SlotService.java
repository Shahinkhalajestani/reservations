package com.shahinkhalajestani.reservations.service;

import com.shahinkhalajestani.reservations.model.AvailableSlot;

public interface SlotService {

	AvailableSlot getNextAvailableSlot();


	void updateSlot(AvailableSlot availableSlot);



}
