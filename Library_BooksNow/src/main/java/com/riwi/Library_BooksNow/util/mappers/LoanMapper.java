package com.riwi.Library_BooksNow.util.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.riwi.Library_BooksNow.api.dto.request.LoanReq;
import com.riwi.Library_BooksNow.api.dto.response.LoanResp;
import com.riwi.Library_BooksNow.domain.entities.Loan;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface LoanMapper {
    
    LoanResp entityToGetResp(Loan loan);

    @Mapping(target = "book", ignore = true)
    @Mapping(target = "user", ignore = true)
    Loan requestToGetEntity(LoanReq request);
}
