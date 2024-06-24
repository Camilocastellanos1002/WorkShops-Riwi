package com.riwi.Library_BooksNow.infrastructure.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.riwi.Library_BooksNow.api.dto.request.UserReq;
import com.riwi.Library_BooksNow.api.dto.response.UserResp;
import com.riwi.Library_BooksNow.domain.entities.User;
import com.riwi.Library_BooksNow.domain.repositories.UserRepository;
import com.riwi.Library_BooksNow.infrastructure.abstract_services.IUserService;
import com.riwi.Library_BooksNow.util.enums.SortType;
import com.riwi.Library_BooksNow.util.exceptions.BadRequestException;
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

    /* CRUD */
        @Override
        public UserResp create(UserReq request) {
            
        User user = this.userMapper.requestToGetEntity(request);

        user.setLoans(new ArrayList<>());
        user.setReservations(new ArrayList<>());

        return this.userMapper.entityToGetResp(userRepository.save(user));
        }

        @SuppressWarnings("null")
        @Override
        public Page<UserResp> getAll(int page, int size, SortType sortType) {
            if (page<0) page =0;

            PageRequest pagination = null;
                switch (sortType) {
                    case NONE -> pagination = PageRequest.of(page, size); 
                    case ASC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).ascending()); //organizar de forma ascendente por full name de user
                    case DESC -> pagination  = PageRequest.of(page, size,Sort.by(FIELD_BY_SORT).descending()); //organizar de forma descendente por nombre de user
                }
            return this.userRepository.findAll(pagination).map(user->userMapper.entityToGetResp(user));
        }

        @Override
        public UserResp getById(Long id) {
            return this.userMapper.entityToGetResp(this.findUser(id));
        }

        @Override
        public UserResp update(UserReq request, Long id) {
            User user = this.findUser(id);

            User userUpdate = this.userMapper.requestToGetEntity(request);

            userUpdate.setLoans(user.getLoans());
            userUpdate.setReservations(user.getReservations());
            
            return this.userMapper.entityToGetResp(this.userRepository.save(userUpdate));
        }

        @Override
        public void delete(Long id) {
            this.userRepository.delete(this.findUser(id));
        }


    /* funciones de buscadores propios */
        private User findUser(Long id){ //funcion para buscar usuario
            return this.userRepository.findById(id).orElseThrow(()-> new BadRequestException(com.riwi.Library_BooksNow.util.messages.ErrorMessage.idNotFound("User")));
        }
}
