package com.riwi.Library_BooksNow.util.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.riwi.Library_BooksNow.api.dto.request.ReservationReq;
import com.riwi.Library_BooksNow.api.dto.response.ReservationBasicResp;
import com.riwi.Library_BooksNow.domain.entities.Reservation;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ReservationMapper {
    
    ReservationBasicResp entityToGetResp(Reservation reservation);

    @Mapping(target = "book", ignore = true)
    @Mapping(target = "user", ignore = true)
    Reservation requestToGetEntity(ReservationReq request);
}
