package com.riwi.Library_BooksNow.infrastructure.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riwi.Library_BooksNow.api.dto.request.BookReq;
import com.riwi.Library_BooksNow.api.dto.response.BookResp;
import com.riwi.Library_BooksNow.domain.entities.Book;
import com.riwi.Library_BooksNow.domain.repositories.BookRepository;
import com.riwi.Library_BooksNow.infrastructure.abstract_services.IBookService;
import com.riwi.Library_BooksNow.util.mappers.BookMapper;

import lombok.AllArgsConstructor;
import lombok.Data;

@Service
@Data
@AllArgsConstructor
public class BookService implements IBookService{

    @Autowired
    private final BookRepository bookRepository;

    @Autowired
    private final BookMapper bookMapper;

    @Override
    public BookResp create(BookReq request) {
        
        Book book = this.bookMapper.requestToGetEntity(request);

        book.setLoans(new ArrayList<>());
        book.setReservations(new ArrayList<>());

        return this.bookMapper.entityToGetResp(bookRepository.save(book));
    }

    @Override
    public BookResp getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public BookResp getById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public BookResp update(BookReq request, Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
