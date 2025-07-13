package com.shahinkhalajestani.reservations;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDto {

	private LocalDateTime from;

	private LocalDateTime to;

	private String username;

	private String slotId;

}
