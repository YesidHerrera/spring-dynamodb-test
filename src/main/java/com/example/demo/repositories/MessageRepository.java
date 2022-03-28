package com.example.demo.repositories;

import com.example.demo.Message;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface MessageRepository extends CrudRepository<Message, String> {
}