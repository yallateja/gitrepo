package com.teja.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.teja.mvc.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

public User findByLoginName(String loginName);

@Query("select u from User u where loginName=:loginName and password=:password")
public User QuerOne(@Param("loginName") String loginName,@Param("password") String password);

@Query("update User u set u.loginStatus=:status where userId=:userId")
public void updateLoginStatus(@Param("status") int status,@Param("userId") int id);

}
