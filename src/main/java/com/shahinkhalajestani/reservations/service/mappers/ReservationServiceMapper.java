package com.shahinkhalajestani.reservations.service.mappers;

import com.shahinkhalajestani.reservations.model.AvailableSlot;
import com.shahinkhalajestani.reservations.model.Reservation;
import com.shahinkhalajestani.reservations.model.User;
import com.shahinkhalajestani.reservations.ReservationDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import java.util.UUID;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ReservationServiceMapper {

    @Mapping(target = "reservationId", expression = "java(UUID.randomUUID().toString())")
    @Mapping(target = "user", source = "user")
    @Mapping(target = "slot", source = "slot")
    @Mapping(target = "createdAt", expression = "java(LocalDateTime.now())")
    Reservation toReservation(AvailableSlot slot, User user);
}
