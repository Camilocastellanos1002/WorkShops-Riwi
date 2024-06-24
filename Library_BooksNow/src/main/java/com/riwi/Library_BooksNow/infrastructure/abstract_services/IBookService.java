package com.riwi.Library_BooksNow.infrastructure.abstract_services;

import com.riwi.Library_BooksNow.api.dto.request.BookReq;
import com.riwi.Library_BooksNow.api.dto.response.BookResp;

public interface IBookService extends CRUDService<BookReq, BookResp, Long>{
    public final String FIELD_BY_SORT = "title"; /*Variable a utilizar para la paginacion */
}
