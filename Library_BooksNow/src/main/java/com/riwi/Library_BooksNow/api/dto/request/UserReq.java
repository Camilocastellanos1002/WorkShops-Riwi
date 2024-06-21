package com.riwi.Library_BooksNow.api.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserReq {

    private Long id;

    @NotBlank(message = "the user name is required")
    @Size(max = 50, message = "the user name maximum lenght is 50 characters")
    private String user_name;

    @NotBlank(message = "the user password is required")
    @Size(max = 100, message = "the user name maximum lenght is 100 characters")
    private String password;

    @Email(message = "the user email is required")
    @Size(
        min = 5,
        max = 100,
        message = "the email must be between 5 and 100 characters"
    )
    private String email;

    @NotBlank(message = "the user full name is required")
    @Size(
        min= 10,
        max = 100, 
        message = "the user full name be between 10 and 100 characters")
    private String full_name;

    @NotBlank(message = "the user role is required")
    private String role;

    
}
