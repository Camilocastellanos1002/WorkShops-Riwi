package com.riwi.Library_BooksNow.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.Library_BooksNow.api.dto.request.ReservationReq;
import com.riwi.Library_BooksNow.api.dto.response.ReservationResp;
import com.riwi.Library_BooksNow.infrastructure.services.ReservationService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import lombok.Data;

@RestController
@RequestMapping(path = "/reservations")
@Data
@AllArgsConstructor
public class ReservationController {
   
    @Autowired
    private final ReservationService reservationService;

    @PostMapping
    @Operation(summary = "Creacion de una reserva de un libro")
    @ApiResponse()
    public ResponseEntity<ReservationResp> create(
        @Validated ReservationReq request
    ){
        return ResponseEntity.ok(this.reservationService.create(request));
    }
}
