package com.nerzon.restcource1.controller;

import com.nerzon.restcource1.entity.Cat;
import com.nerzon.restcource1.repository.CatRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)  //нужно для создания мок объектов
class MainControllerTest {

    @Mock
    private CatRepo catRepo; //забираем у спринга обязательство создавать объект и делегироем на мокито

    @InjectMocks
    private MainController controller;  //сюда инжектим мок
    //catRepo заинджектится в controller и будет выполняться поведение, кот мы опишем

    @Test
    void failedChangeCatTest() {
        int id = 1;
        Cat cat = new Cat();
        cat.setId(id);

        when(catRepo.existsById(id)).thenReturn(false); //описываем как будет себя вести репозиторий. в данном случае что в нем нет данных с id=1

        String expected = "no such row";
        assertEquals(expected, controller.changeCat(cat));
    }

    @Test
    void changeCatTest() {
        int id = 1;

        Cat cat = new Cat();
        cat.setId(id);
        cat.setName("Barsik");

        when(catRepo.existsById(id)).thenReturn(true );
        when(catRepo.save(cat)).thenReturn(cat); //когда репозиторий сохраняет кота, он его возвращает

        assertEquals(cat.toString(), controller.changeCat(cat));
    }


}