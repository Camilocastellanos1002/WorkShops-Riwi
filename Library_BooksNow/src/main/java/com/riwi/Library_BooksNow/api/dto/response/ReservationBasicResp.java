package com.riwi.Library_BooksNow.api.dto.response;

import java.sql.Date;

import com.riwi.Library_BooksNow.util.enums.Status;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationBasicResp {
    
    private Long id;

    private Date reservation_date;
    
    private Status status;
}
