package com.riwi.Library_BooksNow.api.dto.response;

import java.util.Date;

import com.riwi.Library_BooksNow.util.enums.Status;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanResp {

    private Long id;

    private Date loan_date;
    
    private Date return_date;

    private Status status;

    private UserBasicResp user;

    private BookBasicResp book;
}
