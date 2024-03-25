package com.example.flashcash.repository;

import com.example.flashcash.model.UserAccount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<UserAccount,Long> {

    @Query ("SELECT a FROM UserAccount a Where a.id= :id")
    UserAccount findAccountByUserId(Integer id);
}
