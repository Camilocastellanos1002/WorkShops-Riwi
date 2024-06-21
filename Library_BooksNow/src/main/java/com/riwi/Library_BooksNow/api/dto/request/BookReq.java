package com.riwi.Library_BooksNow.api.dto.request;

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
public class BookReq {
    

    private Long id;

    @NotBlank(message = "the book title is required")
    @Size(max = 100, message = "the book title maximum lenght is 100 characters")
    private String title;

    @NotBlank(message = "the book author name is required")
    @Size(max = 100, message = "the book author name maximum lenght is 100 characters")
    private String author;

    @NotBlank(message = "the book publication year is required")
    @Size(max = 11, message = "the book publication year maximum lenght is 11 characters")
    private int publication_year;

    @NotBlank(message = "the book genre  is required")
    @Size(max = 50, message = "the book genre maximum lenght is 50 characters")
    private String genre;

    @NotBlank(message = "the book isbn code is required")
    @Size(max = 20, message = "the book isbn code maximum lenght is 20 characters")
    private String isbn;
}
