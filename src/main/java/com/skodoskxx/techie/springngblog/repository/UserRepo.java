package com.skodoskxx.techie.springngblog.repository;

import com.skodoskxx.techie.springngblog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

}
