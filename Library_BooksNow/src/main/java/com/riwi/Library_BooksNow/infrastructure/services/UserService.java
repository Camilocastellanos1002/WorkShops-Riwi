package com.riwi.Library_BooksNow.infrastructure.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riwi.Library_BooksNow.api.dto.request.UserReq;
import com.riwi.Library_BooksNow.api.dto.response.UserResp;
import com.riwi.Library_BooksNow.domain.entities.User;
import com.riwi.Library_BooksNow.domain.repositories.UserRepository;
import com.riwi.Library_BooksNow.infrastructure.abstract_services.IUserService;
import com.riwi.Library_BooksNow.util.mappers.UserMapper;

import lombok.AllArgsConstructor;
import lombok.Data;

@Service
@Data
@AllArgsConstructor
public class UserService implements IUserService{

    /* inyeccion de dependencias */
    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final UserMapper userMapper;



    @Override
    public UserResp create(UserReq request) {
        
       User user = this.userMapper.requestToGetEntity(request);

       user.setLoans(new ArrayList<>());
       user.setReservations(new ArrayList<>());

       return this.userMapper.entityToGetResp(userRepository.save(user));
    }

    @Override
    public UserResp getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public UserResp getById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");

        //User user = userRepository.findAll(id)
    }

    @Override
    public UserResp update(UserReq request, Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
