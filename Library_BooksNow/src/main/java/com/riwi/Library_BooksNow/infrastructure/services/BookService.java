package com.riwi.Library_BooksNow.infrastructure.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.riwi.Library_BooksNow.api.dto.request.BookReq;
import com.riwi.Library_BooksNow.api.dto.response.BookResp;
import com.riwi.Library_BooksNow.domain.entities.Book;
import com.riwi.Library_BooksNow.domain.repositories.BookRepository;
import com.riwi.Library_BooksNow.infrastructure.abstract_services.IBookService;
import com.riwi.Library_BooksNow.util.enums.SortType;
import com.riwi.Library_BooksNow.util.exceptions.BadRequestException;
import com.riwi.Library_BooksNow.util.mappers.BookMapper;
import com.riwi.Library_BooksNow.util.messages.ErrorMessage;

import lombok.AllArgsConstructor;
import lombok.Data;

@Service
@Data
@AllArgsConstructor
public class BookService implements IBookService{

    /* inyeccion */
        @Autowired
        private final BookRepository bookRepository;

        @Autowired
        private final BookMapper bookMapper;
    
    /* CRUD */

        @Override
        public BookResp create(BookReq request) {
            
            Book book = this.bookMapper.requestToGetEntity(request);

            book.setLoans(new ArrayList<>());
            book.setReservations(new ArrayList<>());

            return this.bookMapper.entityToGetResp(bookRepository.save(book));
        }

        @SuppressWarnings("null")
        @Override
        public Page<BookResp> getAll(int page, int size, SortType sortType) {
            if (page<0) page =0;

            PageRequest pagination = null;
                switch (sortType) {
                    case NONE -> pagination = PageRequest.of(page, size); 
                    case ASC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).ascending()); //organizar de forma ascendente por titulo de lesson
                    case DESC -> pagination  = PageRequest.of(page, size,Sort.by(FIELD_BY_SORT).descending()); //organizar de forma descendente por titulo de lesson
                }

            return this.bookRepository.findAll(pagination).map(book->bookMapper.entityToGetResp(book));
        }

        @Override
        public BookResp getById(Long id) {
            return this.bookMapper.entityToGetResp(this.findBook(id));
        }

        @Override
        public BookResp update(BookReq request, Long id) {
            Book book = this.findBook(id);

            Book bookUpdate = this.bookMapper.requestToGetEntity(request);

            bookUpdate.setLoans(book.getLoans());
            bookUpdate.setReservations(book.getReservations());

            return this.bookMapper.entityToGetResp(this.bookRepository.save(bookUpdate));
        }

        @Override
        public void delete(Long id) {
            this.bookRepository.delete(this.findBook(id));
        }

   /* propias */
    private Book findBook(Long id){ //funcion para buscar libro
        return this.bookRepository.findById(id).orElseThrow(()->new BadRequestException(ErrorMessage.idNotFound("Book")));
    }
    
}
