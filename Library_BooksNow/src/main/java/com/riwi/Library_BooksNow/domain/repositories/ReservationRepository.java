package com.riwi.Library_BooksNow.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.Library_BooksNow.domain.entities.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long>{
    
}
