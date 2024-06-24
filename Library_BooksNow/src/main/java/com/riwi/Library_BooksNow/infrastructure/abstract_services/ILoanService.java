package com.riwi.Library_BooksNow.infrastructure.abstract_services;

import com.riwi.Library_BooksNow.api.dto.request.LoanReq;
import com.riwi.Library_BooksNow.api.dto.response.LoanResp;

public interface ILoanService extends CRUDService<LoanReq, LoanResp, Long> {
    public final String FIELD_BY_SORT = "full_name"; /*Variable a utilizar para la paginacion */

}
