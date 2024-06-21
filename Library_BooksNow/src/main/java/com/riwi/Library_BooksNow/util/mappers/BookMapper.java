package com.riwi.Library_BooksNow.util.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.riwi.Library_BooksNow.api.dto.request.BookReq;
import com.riwi.Library_BooksNow.api.dto.response.BookBasicResp;
import com.riwi.Library_BooksNow.domain.entities.Book;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BookMapper {
    
    
    BookBasicResp entityToGetResp(Book book);

    BookReq entityToGetReq(Book book);

    @Mapping(target = "loans", ignore = true)
    @Mapping(target = "reservations", ignore = true)
    Book requestToGetEntity(BookReq request);
}
