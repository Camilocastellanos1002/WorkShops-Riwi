package com.riwi.Library_BooksNow.infrastructure.abstract_services;

import org.springframework.data.domain.Page;

import com.riwi.Library_BooksNow.util.enums.SortType;

public interface CRUDService <RQ, RS, ID>{
    
    public RS create(RQ request);

    public Page<RS> getAll(int page, int size, SortType sortType);
    public RS getById(ID id);

    public RS update(RQ request, ID id);

    public void delete(ID id);
}
