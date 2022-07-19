package com.fresh_produce.fresh_produce_api.repositories;

import com.fresh_produce.fresh_produce_api.repositories.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
