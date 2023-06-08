package com.example.learningdatabase.repository;

import com.example.learningdatabase.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.stream.Stream;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

//    @Modifying
//    @Query(value = "select a.id from account a where a.username =:username and a.password = :password")
//    @Transactional
//    public Integer getIDAccountByUsername(@Param("username") String username, @Param("password") String password) throws Exception;
//
//    @Modifying
//    @Query(value = "select a.id from account a where a.username = :username")
//    @Transactional
//    public Integer existAccountByUsername(@Param("username") String username) throws Exception;
//
//    public Account findByUsername(String username);

//    @Query("select a from account a")
//    Stream<Account> test();
}
