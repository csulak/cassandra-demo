package com.example.cassandra.cassandrademo.repository;

import com.example.cassandra.cassandrademo.model.User;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface UserRepository extends CassandraRepository<User, Integer> {
}
