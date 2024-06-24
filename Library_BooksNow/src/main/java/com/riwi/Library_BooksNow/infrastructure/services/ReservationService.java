package com.riwi.Library_BooksNow.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.riwi.Library_BooksNow.api.dto.request.ReservationReq;
import com.riwi.Library_BooksNow.api.dto.response.ReservationResp;
import com.riwi.Library_BooksNow.domain.entities.Reservation;
import com.riwi.Library_BooksNow.domain.repositories.ReservationRepository;
import com.riwi.Library_BooksNow.infrastructure.abstract_services.IReservationService;
import com.riwi.Library_BooksNow.util.enums.SortType;
import com.riwi.Library_BooksNow.util.exceptions.BadRequestException;
import com.riwi.Library_BooksNow.util.mappers.ReservationMapper;
import com.riwi.Library_BooksNow.util.messages.ErrorMessage;

import lombok.AllArgsConstructor;
import lombok.Data;

@Service
@Data
@AllArgsConstructor
public class ReservationService implements IReservationService {
    
    /* inyeccion de dependencias */
        @Autowired
        private final ReservationRepository reservationRepository;

        @Autowired 
        private final ReservationMapper reservationMapper;

    /* CRUD */
        @Override
        public ReservationResp create(ReservationReq request) {

            Reservation reservation = this.reservationMapper.requestToGetEntity(request);

            return this.reservationMapper.entityToGetResp(reservationRepository.save(reservation));
        }

        @SuppressWarnings("null")
        @Override
        public Page<ReservationResp> getAll(int page, int size, SortType sortType) {
            if (page<0) page =0;

            PageRequest pagination = null;
                switch (sortType) {
                    case NONE -> pagination = PageRequest.of(page, size); 
                    case ASC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).ascending());
                    case DESC -> pagination  = PageRequest.of(page, size,Sort.by(FIELD_BY_SORT).descending()); 
                }
            return this.reservationRepository.findAll(pagination).map(reservation -> reservationMapper.entityToGetResp(reservation));
        }
        
        @Override
        public ReservationResp getById(Long id) {
            return this.reservationMapper.entityToGetResp(this.findReservation(id));
        }

        @Override
        public ReservationResp update(ReservationReq request, Long id) {
  
            Reservation reservationUpdate = this.reservationMapper.requestToGetEntity(request);

            return this.reservationMapper.entityToGetResp(this.reservationRepository.save(reservationUpdate));
        }

        @Override
        public void delete(Long id) {
           this.reservationRepository.delete(this.findReservation(id));
        }
    /*funciones propias */
        private Reservation findReservation(Long id){
            return this.reservationRepository.findById(id).orElseThrow(()-> new BadRequestException(ErrorMessage.idNotFound("Reservation")));
        }

}
