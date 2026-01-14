package com.nerzon.restcource1.controller;

//import com.nerzon.restcource1.kafka.KafkaProducer;
import com.nerzon.restcource1.repository.CatRepo;
import org.springframework.web.bind.annotation.*;

//@RestController
//public class Controller {
//
//    private final KafkaProducer kafkaProducer;
//    private final CatRepo catRepo;
//
//    public Controller(KafkaProducer kafkaProducer, CatRepo catRepo) {
//        this.kafkaProducer = kafkaProducer;
//        this.catRepo = catRepo;
//    }
//
//    @PostMapping("kafka/send") //при обращении по указ пути, будем отправлять сообщение, кот получили в кач парам при помочи кафка продюссера на брокер и кафка консьюмер дб ловить это сообщение
//    public String send(@RequestParam int id) {
//        var cat = catRepo.findById(id);
//        kafkaProducer.sendMessage(cat.toString());
//        return "Success";
//    }
//}
