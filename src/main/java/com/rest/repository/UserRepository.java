package com.rest.repository;

import org.springframework.data.repository.CrudRepository;

import com.rest.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
