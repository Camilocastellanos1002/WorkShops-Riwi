package com.riwi.Library_BooksNow.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.Library_BooksNow.domain.entities.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long>{
    
}
