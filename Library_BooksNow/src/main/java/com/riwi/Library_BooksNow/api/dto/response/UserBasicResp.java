package com.riwi.Library_BooksNow.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserBasicResp {
    
    private Long id;

    private String user_name;

    private String password;

    private String email;

    private String full_name;

    private String role;
}
