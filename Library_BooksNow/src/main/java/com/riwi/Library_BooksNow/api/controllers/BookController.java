package com.riwi.Library_BooksNow.api.controllers;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.Library_BooksNow.api.dto.errors.ErrorResponse;
import com.riwi.Library_BooksNow.api.dto.request.BookReq;
import com.riwi.Library_BooksNow.api.dto.response.BookResp;
import com.riwi.Library_BooksNow.infrastructure.services.BookService;
import com.riwi.Library_BooksNow.util.enums.SortType;
import com.riwi.Library_BooksNow.util.messages.ErrorMessage;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
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

    /*read */
        @PostMapping
        @Operation(summary = "crear un libro")
        @ApiResponse()
        public ResponseEntity<BookResp> create(
            @Validated BookReq request
        ){
            return ResponseEntity.ok(this.bookService.create(request));
        }
    
    /* read */
        
        @GetMapping
        @Operation(summary = "Obtiene los libros de forma paginada y organizada por el nombre")
        public ResponseEntity<Page<BookResp>>getAll(
                @RequestParam(defaultValue = "1") int page,
                @RequestParam(defaultValue = "2") int size,
                @RequestHeader(required = false)SortType sortType
            ){
                if (Objects.isNull(sortType)) {
                    sortType = SortType.NONE;
                }
                return ResponseEntity.ok(this.bookService.getAll(page, size, sortType));
            }
        
            @GetMapping(path = "/{id}")
            @Operation(summary = "Obtiene el libro por id")
            @ApiResponse(
                responseCode = "400", 
                description = "el id no es valido", 
                content = {
                    @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = ErrorMessage.class)
                    )
                }
            )
            public ResponseEntity<BookResp>getById(@PathVariable Long id){
            return ResponseEntity.ok(this.bookService.getById(id));
        }
    
    /* update */
        @PutMapping(path = "/{id}")
        @Operation(summary = "Actualiza el libro por id")
        @ApiResponse(
            responseCode = "400", 
            description = "Cuando el id no es valido", 
            content = { 
                @Content(
                    mediaType = "application/json", 
                    schema = @Schema(implementation = ErrorResponse.class))
                }
        )
        public ResponseEntity<BookResp> update(
          @PathVariable Long id,
          @Validated @RequestBody BookReq request  
        ){
            return ResponseEntity.ok(this.bookService.update(request, id));
        }
    /* delete */
        @DeleteMapping(path = "/{id}")
        @Operation(summary = "Elimina el libro por id")
        @ApiResponse(
            responseCode = "400", 
            description = "Cuando el id no es valido", 
            content = { 
                @Content(
                    mediaType = "application/json", 
                    schema = @Schema(implementation = ErrorResponse.class))
                }
        )
        public ResponseEntity<Void>delete(@PathVariable Long id){
            this.bookService.delete(id);
            return ResponseEntity.noContent().build();
        }
}
