package com.riwi.Library_BooksNow.infrastructure.abstract_services;

import com.riwi.Library_BooksNow.api.dto.request.ReservationReq;
import com.riwi.Library_BooksNow.api.dto.response.ReservationResp;

public interface IReservationService extends CRUDService<ReservationReq, ReservationResp, Long>{
    public final String FIELD_BY_SORT = "reservation_date";
}
