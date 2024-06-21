package com.riwi.Library_BooksNow.infrastructure.abstract_services;

import com.riwi.Library_BooksNow.api.dto.request.UserReq;
import com.riwi.Library_BooksNow.api.dto.response.UserResp;

public interface IUserService extends CRUDService<UserReq, UserResp,Long>{
    
}
