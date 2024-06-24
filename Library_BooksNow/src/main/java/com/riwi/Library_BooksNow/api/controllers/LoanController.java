package com.riwi.Library_BooksNow.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.Library_BooksNow.api.dto.request.LoanReq;
import com.riwi.Library_BooksNow.api.dto.response.LoanResp;
import com.riwi.Library_BooksNow.infrastructure.services.LoanService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import lombok.Data;

@RestController
@RequestMapping(path = "/loans")
@Data
@AllArgsConstructor
public class LoanController {
    
    @Autowired
    private final LoanService loanService;

    @PostMapping
    @Operation(summary = "Crear un prestamo de un libro")
    @ApiResponse()
    public ResponseEntity<LoanResp> create(
        @Validated LoanReq request
    ){
        return ResponseEntity.ok(this.loanService.create(request));
    }
}
