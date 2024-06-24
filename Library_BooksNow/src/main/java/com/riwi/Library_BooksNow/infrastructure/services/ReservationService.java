package com.riwi.Library_BooksNow.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riwi.Library_BooksNow.api.dto.request.ReservationReq;
import com.riwi.Library_BooksNow.api.dto.response.ReservationResp;
import com.riwi.Library_BooksNow.domain.entities.Reservation;
import com.riwi.Library_BooksNow.domain.repositories.ReservationRepository;
import com.riwi.Library_BooksNow.infrastructure.abstract_services.IReservationService;
import com.riwi.Library_BooksNow.util.mappers.ReservationMapper;

import lombok.AllArgsConstructor;
import lombok.Data;

@Service
@Data
@AllArgsConstructor
public class ReservationService implements IReservationService {
    
    @Autowired
    private final ReservationRepository reservationRepository;

    @Autowired 
    private final ReservationMapper reservationMapper;

    @Override
    public ReservationResp create(ReservationReq request) {

        Reservation reservation = this.reservationMapper.requestToGetEntity(request);

        return this.reservationMapper.entityToGetResp(reservationRepository.save(reservation));
    }

    @Override
    public ReservationResp getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public ReservationResp getById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public ReservationResp update(ReservationReq request, Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
    
}
