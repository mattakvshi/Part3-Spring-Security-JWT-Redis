package ru.mattakvshi.redisdbcach.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.mattakvshi.redisdbcach.model.User;

import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
