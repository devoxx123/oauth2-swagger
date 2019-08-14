package com.oauth.web.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.oauth.web.entities.User;

@Repository
public interface UserRepositroy extends CrudRepository<User, Long> {

	public User findByUsername(String username);

	public User findByUsernameAndActivationKey(String username, String activationKey);

}
