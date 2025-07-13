package com.shahinkhalajestani.reservations.service.mappers;

import java.time.LocalDateTime;
import java.util.UUID;

import com.shahinkhalajestani.reservations.ReservationDto;
import com.shahinkhalajestani.reservations.base.model.ResultStatus;
import com.shahinkhalajestani.reservations.model.AvailableSlot;
import com.shahinkhalajestani.reservations.model.Reservation;
import com.shahinkhalajestani.reservations.model.User;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR, imports = { ResultStatus.class,UUID.class, LocalDateTime.class})
public interface ReservationServiceMapper {

	@Mapping(target = "id", ignore = true)
    @Mapping(target = "reservationId", expression = "java(UUID.randomUUID().toString())")
    @Mapping(target = "user", source = "user")
    @Mapping(target = "slot", source = "slot")
    @Mapping(target = "createdAt", expression = "java(LocalDateTime.now())")
    Reservation toReservation(AvailableSlot slot, User user);

	@BeanMapping(unmappedTargetPolicy = ReportingPolicy.IGNORE)
	@Mapping(target = "from", source = "from")
	@Mapping(target = "to", source = "to")
	@Mapping(target = "username", source = "username")
	@Mapping(target = "reservationId", source = "reservationId")
	@Mapping(target = "resultStatus", expression = "java(ResultStatus.SUCCESS)")
	ReservationDto toReservationDto(LocalDateTime from, LocalDateTime to, String username, String reservationId);
}
