package ru.mattakvshi.SpringBoot.PostgreSQL.RedisCach.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.mattakvshi.SpringBoot.PostgreSQL.RedisCach.model.base.User;

import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<User, UUID> {
}
