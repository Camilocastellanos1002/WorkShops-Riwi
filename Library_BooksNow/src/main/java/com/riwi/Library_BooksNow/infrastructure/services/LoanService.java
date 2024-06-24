package com.riwi.Library_BooksNow.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riwi.Library_BooksNow.api.dto.request.LoanReq;
import com.riwi.Library_BooksNow.api.dto.response.LoanResp;
import com.riwi.Library_BooksNow.domain.entities.Loan;
import com.riwi.Library_BooksNow.domain.repositories.LoanRepository;
import com.riwi.Library_BooksNow.infrastructure.abstract_services.ILoanService;
import com.riwi.Library_BooksNow.util.mappers.LoanMapper;

import lombok.AllArgsConstructor;
import lombok.Data;

@Service
@Data
@AllArgsConstructor
public class LoanService implements ILoanService{
    
    @Autowired
    private final LoanRepository loanRepository;

    @Autowired
    private final LoanMapper loanMapper;
    
    @Override
    public LoanResp create(LoanReq request) {
        Loan loan = this.loanMapper.requestToGetEntity(request);

        return this.loanMapper.entityToGetResp(loanRepository.save(loan));
    }

    @Override
    public LoanResp getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public LoanResp getById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public LoanResp update(LoanReq request, Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
