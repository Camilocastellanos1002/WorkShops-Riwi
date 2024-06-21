package com.riwi.Library_BooksNow.infrastructure.abstract_services;

public interface CRUDService <RQ, RS, ID>{
    
    public RS create(RQ request);

    public RS getAll();
    public RS getById(ID id);

    public RS update(RQ request, ID id);

    public void delete(ID id);
}
