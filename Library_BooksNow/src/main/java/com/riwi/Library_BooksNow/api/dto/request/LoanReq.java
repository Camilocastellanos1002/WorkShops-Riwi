package com.riwi.Library_BooksNow.api.dto.request;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.riwi.Library_BooksNow.util.enums.Status;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoanReq {

    private Long id;
    
    @NotBlank(message = "the user id is required")
    private Long user_id;

    @NotBlank(message = "the book id is required")
    private Long book_id;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @FutureOrPresent(message = "the date can't be in the past")
    private Date loan_date;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @FutureOrPresent(message = "the date can't be in the past")
    private Date return_date;

    private Status status;

}
