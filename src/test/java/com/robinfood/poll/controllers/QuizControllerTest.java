package com.robinfood.poll.controllers;

import com.robinfood.poll.models.dto.Encuesta;
import com.robinfood.poll.models.dto.Pregunta;
import com.robinfood.poll.models.dto.Respuesta;
import com.robinfood.poll.services.QuizService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
class QuizControllerTest {

    @InjectMocks
    private QuizController quizController;

    @Mock
    private QuizService quizService;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAllQuizTest(){
        ArrayList<Encuesta> tempList= new ArrayList<>();
        Mockito.when(quizService.getAllQuiz()).thenReturn(tempList);
        ResponseEntity<List<Encuesta>> listaEncuesta =quizController.getAllQuiz();
        Assertions.assertEquals(HttpStatus.OK, listaEncuesta.getStatusCode());
    }

    @Test
    public void getQuestionTest(){
        int id=1;
        ArrayList<Pregunta> preguntas= new ArrayList<>();
        Mockito.when(quizService.getAllQuestions(id)).thenReturn(preguntas);
        ResponseEntity<List<Pregunta>> response= quizController.getQuestion(id);
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void saveResponseTest(){
        Respuesta respuesta= Respuesta.builder().id(1).value("test").build();
        Mockito.when(quizService.saveAnswer(respuesta)).thenReturn(respuesta);
        ResponseEntity<Respuesta> response = quizController.saveResponse(respuesta);
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}