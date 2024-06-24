package com.riwi.Library_BooksNow.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.Library_BooksNow.api.dto.request.UserReq;
import com.riwi.Library_BooksNow.api.dto.response.UserResp;
import com.riwi.Library_BooksNow.infrastructure.services.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import lombok.Data;

@RestController
@RequestMapping(path = "/users")
@Data
@AllArgsConstructor
public class UserController {
     
    @Autowired
    private final UserService userService;

    @PostMapping
    @Operation(summary = "Crear un usuario")
    @ApiResponse()
    public ResponseEntity<UserResp> create(
        @Validated UserReq request
    ){
        return ResponseEntity.ok(this.userService.create(request));
    }
}
