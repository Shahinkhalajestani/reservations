package com.shahinkhalajestani.reservations.model;

import java.time.LocalDateTime;

import com.shahinkhalajestani.reservations.base.model.ResponseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDto extends ResponseModel {

	private LocalDateTime from;

	private LocalDateTime to;

	private String username;

	private String reservationId;

}
