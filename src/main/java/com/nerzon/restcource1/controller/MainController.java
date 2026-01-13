package com.nerzon.restcource1.controller;


import com.nerzon.restcource1.DTO.CatDTO;
import com.nerzon.restcource1.entity.Cat;
import com.nerzon.restcource1.repository.CatRepo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tools.jackson.core.JacksonException;
import tools.jackson.databind.ObjectMapper;

import java.util.List;

@Tag(name = "main_methods") //нужен для работы swaggerConfig, где мы создаем бины. в скобках указано имя контроллера
@Slf4j //для логирования
@RestController// вместо @Controller. используется для создания RESTful веб-сервисо
@RequiredArgsConstructor //аннотация нужна для замены @Autowired. И добавили final к catRepo и objectMapper
public class MainController {

    //@Autowired //с помощью этой аннотации мы позволяем спрингу сюда положить экземляр этого класса
    //private ObjectMapper objectMapper; //объект библиотеки Jackson. Помжет объект класса cat отправить в виде json объекта
    //Jackson - библиотека, которая работает с сериализацией и десериализацией json объектов
    private final CatRepo catRepo;
    //private final ObjectMapper objectMapper;


    @Operation(
            summary = "кладет нового кота в базу", //краткое описание метода
            description = "Получает DTO кота и билдером собирает и сохраняет сущность в базу" //подробное описание метода
    ) //нужна для более подробного описания метода в swagger. Есть и другие свойста помимо этих двух
    @PostMapping("/api/add")
    public void addCat(@RequestBody CatDTO catDTO) { //аннотация нужна для сериализации

        log.info(
                "New row: " + catRepo.save(
                        Cat.builder()
                            .age(catDTO.getAge())
                            .weight(catDTO.getWeight())
                            .name(catDTO.getName())
                            .build())
        ); //собираем инфу о коте из переданной дто контейнера в данные
    }

    @SneakyThrows //заставляет исключение выбросить без обработки
    @GetMapping("/api/all")
    public List<Cat> getAll() {
        return catRepo.findAll();
    }

    @GetMapping("/api")
    public Cat getCat(@RequestParam int id) {
        //return catRepo.findById(id).get(); //findById возвращает optional. это контейнер который может быть или не быть. метод get нужен когда мы уверены что значение есть
        return catRepo.findById(id).orElseThrow(); //альтернатива на случай если нет значения.
    }

    @DeleteMapping("/api")
    public void deleteCat(@RequestParam int id) {
        catRepo.deleteById(id);
    }

    @PutMapping("/api/add")
    public String changeCat(@RequestBody Cat cat) {
        if (!catRepo.existsById(cat.getId())) {
            return "no such row";
        }
        return catRepo.save(cat).toString();
    }

//    @GetMapping(path = "/api/main")
//    public String mainListener() {
//        return "Hello World!";
//    }
//
//    @GetMapping(path = "/api/cat")
//    public String giveCat() {
//        Cat cat = new Cat("Barsik", 5, 10);
//        String jsonData = null;
//
//        try {
//            jsonData = objectMapper.writeValueAsString(cat);
//        } catch (JacksonException e) {
//            System.out.println("Error with cat");
//        }
//
//        return jsonData;
//    }
//
//    @PostMapping("/api/special")
//    public String giveSpecialCat(@RequestParam String name, int age, int weight) { //аннотация позволяет передавать какие-то параметры в сервис с кот. мы работаем (постман в дан. случае)
//        Cat cat = new Cat(name, age, weight);
//        String jsonData = null;
//
//        try {
//            jsonData = objectMapper.writeValueAsString(cat);
//        } catch (JacksonException e) {
//            System.out.println("Error with cat");
//        }
//
//        return jsonData;
//    }

}
