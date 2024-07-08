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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.Library_BooksNow.api.dto.request.UserReq;
import com.riwi.Library_BooksNow.api.dto.response.UserResp;
import com.riwi.Library_BooksNow.infrastructure.services.UserService;
import com.riwi.Library_BooksNow.util.enums.SortType;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.Data;

@RestController
@RequestMapping(path = "/users")
@Data
@AllArgsConstructor
public class UserController {
     
    @Autowired
    private final UserService userService;

    /* Crear */
        @PostMapping
        @Operation(summary = "crea un nuevo usuario", description = "crea un usuario ingresando los datos requeridos")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "201", description = "SUCCESSFUL"),
                @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
                @ApiResponse(responseCode = "401", description = "NOT AUTHORIZED"),
                @ApiResponse(responseCode = "403", description = "FORBIDDEN ACCESS"),
                @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
        })
        public ResponseEntity<UserResp> create(
            @Validated UserReq request
        ){
            return ResponseEntity.ok(this.userService.create(request));
        }
    
    /* Read */
        /*
         * @Operation(
    summary = "Get all roles", 
    description = "Retrieve a paginated list of all roles", 
    parameters = {
        @Parameter(name = "page", 
                   description = "Page number", 
                   schema = @Schema(
                    type = "integer", 
                    defaultValue = "1")),
        @Parameter(name = "size", 
                   description = "Page size", 
                   schema = @Schema(
                    type = "integer", 
                    defaultValue = "10")),
        @Parameter(name = "sort", 
                   description = "Sort criteria", 
                   array = @ArraySchema(
                    schema = @Schema(
                        type = "string", 
                        defaultValue = "status", 
                        allowableValues = {"id", "name", "description", "status"})))
    }, 
    responses = {
        @ApiResponse(responseCode = "200", description = "SUCCESSFUL"),
        @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
        @ApiResponse(responseCode = "401", description = "NOT AUTHORIZED"),
        @ApiResponse(responseCode = "403", description = "FORBIDDEN ACCESS"),
        @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
         */
        @GetMapping
        @Operation(summary = "Obtiene los usuarios de forma paginada y organizada por el nombre")
        public ResponseEntity<Page<UserResp>>getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "2") int size,
            @RequestHeader(required = false)SortType sortType
        ){
            if (Objects.isNull(sortType)) {
                sortType = SortType.NONE;
            }
            return ResponseEntity.ok(this.userService.getAll(page, size, sortType));
        }

        @GetMapping(path = "/{id}")
        @Operation(summary = "Obtiene el usuario por id")
        @ApiResponses(
            value = {
                @ApiResponse(responseCode = "200", description = "OK"),
                @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
                @ApiResponse(responseCode = "401", description = "NOT AUTHORIZED"),
                @ApiResponse(responseCode = "403", description = "FORBIDDEN ACCESS"),
                @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
        })
        public ResponseEntity<UserResp> getById(@PathVariable Long id){
            return ResponseEntity.ok(this.userService.getById(id));
        }
    
    /* update */
        @PutMapping(path = "/{id}")
        @Operation(summary = "Actualiza el usuario por id", description = "Actualiza un usuario creado previamente y los parametros seran enviados a travez de path")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "SUCCESSFUL"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "401", description = "NOT AUTHORIZED"),
            @ApiResponse(responseCode = "403", description = "FORBIDDEN ACCESS"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
        public ResponseEntity<UserResp> update(
            @PathVariable Long id,
            @Validated @RequestBody UserReq request
            ){
                return ResponseEntity.ok(this.userService.update(request, id));
        }

    /* delete */
        @DeleteMapping(path = "/{id}")
        @Operation(summary = "elimina usuario por id", description = "Elimina el registro de un usuario creado anteriormente")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200", description = "OK"),
                @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
                @ApiResponse(responseCode = "401", description = "NOT AUTHORIZED"),
                @ApiResponse(responseCode = "403", description = "FORBIDDEN ACCESS"),
                @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
        })
        public ResponseEntity<Void> delete(@PathVariable Long id){
            this.userService.delete(id);
            return ResponseEntity.noContent().build();
        }

}
