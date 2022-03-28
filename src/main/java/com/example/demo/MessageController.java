package com.example.demo;

import com.example.demo.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("messages")
public class MessageController {

    private final MessageRepository messageRepository;

    public MessageController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @GetMapping(produces= MediaType.APPLICATION_XML_VALUE)
    public List<Message> getMessages() {
        return StreamSupport.stream(messageRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @PostMapping(produces= MediaType.APPLICATION_XML_VALUE, consumes= MediaType.APPLICATION_XML_VALUE)
    private Message save(@RequestBody Message message){
        return messageRepository.save(message);
    }



}
