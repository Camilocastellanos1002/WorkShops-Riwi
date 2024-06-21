package com.riwi.Library_BooksNow.api.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookResp {
    
    private Long id;

    private String title;

    private String author;

    private int publication_year;

    private String genre;

    private String isbn;

    //private UserBasicResp user;

    private List<LoanBasicResp> loans;

    private List<ReservationBasicResp> reservations;






}
