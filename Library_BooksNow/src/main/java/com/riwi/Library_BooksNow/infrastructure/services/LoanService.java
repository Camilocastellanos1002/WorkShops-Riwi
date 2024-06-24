package com.riwi.Library_BooksNow.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.riwi.Library_BooksNow.api.dto.request.LoanReq;
import com.riwi.Library_BooksNow.api.dto.response.LoanResp;
import com.riwi.Library_BooksNow.domain.entities.Loan;
import com.riwi.Library_BooksNow.domain.repositories.LoanRepository;
import com.riwi.Library_BooksNow.infrastructure.abstract_services.ILoanService;
import com.riwi.Library_BooksNow.util.enums.SortType;
import com.riwi.Library_BooksNow.util.mappers.LoanMapper;
import com.riwi.Library_BooksNow.util.messages.ErrorMessage;

import lombok.AllArgsConstructor;
import lombok.Data;

@Service
@Data
@AllArgsConstructor
public class LoanService implements ILoanService{
    
    /*inyecciones */
    @Autowired
        private final LoanRepository loanRepository;

        @Autowired
        private final LoanMapper loanMapper;
    /* CRUD */
        @Override
        public LoanResp create(LoanReq request) {
            Loan loan = this.loanMapper.requestToGetEntity(request);

            return this.loanMapper.entityToGetResp(loanRepository.save(loan));
        }
        
        @SuppressWarnings("null")
        @Override
        public Page<LoanResp> getAll(int page, int size, SortType sortType) {
            if (page<0) page =0;

                PageRequest pagination = null;
                    switch (sortType) {
                        case NONE -> pagination = PageRequest.of(page, size); 
                        case ASC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).ascending()); //organizar de forma ascendente por titulo de lesson
                        case DESC -> pagination  = PageRequest.of(page, size,Sort.by(FIELD_BY_SORT).descending()); //organizar de forma descendente por titulo de lesson
                    }
            
            return this.loanRepository.findAll(pagination).map(loan -> loanMapper.entityToGetResp(loan));
        }
        

        @Override
        public LoanResp getById(Long id) {
            return this.loanMapper.entityToGetResp(this.findLoan(id));
        }

        @Override
        public LoanResp update(LoanReq request, Long id) {

            Loan loanUpdate = this.loanMapper.requestToGetEntity(request);

            return this.loanMapper.entityToGetResp(this.loanRepository.save(loanUpdate));
        }

        @Override
        public void delete(Long id) {
            this.loanRepository.delete(this.findLoan(id));
        }


    /* funcion buscador propia */
        private Loan findLoan(Long id){
            return this.loanRepository.findById(id).orElseThrow(()-> new com.riwi.Library_BooksNow.util.exceptions.BadRequestException(ErrorMessage.idNotFound("loan")));
        }
}
