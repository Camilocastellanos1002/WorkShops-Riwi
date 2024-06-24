package com.riwi.Library_BooksNow.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.Library_BooksNow.api.dto.request.BookReq;
import com.riwi.Library_BooksNow.api.dto.response.BookResp;
import com.riwi.Library_BooksNow.infrastructure.services.BookService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import lombok.Data;

@RestController
@RequestMapping(path = "/books")
@Data
@AllArgsConstructor
public class BookController {
    
    @Autowired
    private final BookService bookService;

    @PostMapping
    @Operation(summary = "crear un libro")
    @ApiResponse()
    public ResponseEntity<BookResp> create(
        @Validated BookReq request
    ){
        return ResponseEntity.ok(this.bookService.create(request));
    }
}
