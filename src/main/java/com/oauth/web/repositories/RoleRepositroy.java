package com.oauth.web.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.oauth.web.entities.Role;

@Repository
public interface RoleRepositroy extends CrudRepository<Role, Long> {

}
