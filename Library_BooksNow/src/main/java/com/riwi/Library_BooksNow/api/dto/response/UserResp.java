package com.riwi.Library_BooksNow.api.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResp {
    
    private Long id;

    private String user_name;

    private String password;

    private String email;

    private String full_name;

    private String role;

    private List<LoanBasicResp> loans;

    private List<ReservationBasicResp> reservations;
}
