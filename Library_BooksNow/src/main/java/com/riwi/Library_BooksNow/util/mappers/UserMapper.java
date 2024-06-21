package com.riwi.Library_BooksNow.util.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.riwi.Library_BooksNow.api.dto.request.UserReq;
import com.riwi.Library_BooksNow.api.dto.response.UserBasicResp;
import com.riwi.Library_BooksNow.domain.entities.User;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    
    /*@Mappings({
        @Mapping(source = "id", target = "id"),
        @Mapping(source = "user_name", target = "user_name"),
        @Mapping(source = "password", target = "password"),
        @Mapping(source = "email", target = "email"),
        @Mapping(source = "full_name", target = "full_name"),
        @Mapping(source = "role", target = "role"),
    })*/
    UserBasicResp entityToGetResp(User user);

    UserReq entityToGetReq(User user);

    @Mapping(target = "loans", ignore = true)
    @Mapping(target = "reservations", ignore = true)
    User requestToGetEntity(UserReq request);

}
