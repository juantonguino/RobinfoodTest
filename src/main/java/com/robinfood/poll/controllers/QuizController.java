package com.robinfood.poll.controllers;

import com.robinfood.poll.models.dto.Encuesta;
import com.robinfood.poll.models.dto.Pregunta;
import com.robinfood.poll.models.dto.Respuesta;
import com.robinfood.poll.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @GetMapping()
    public ResponseEntity<List<Encuesta>> getAllQuiz(){
        return ResponseEntity.status(HttpStatus.OK).body(quizService.getAllQuiz());
    }

    @GetMapping("/{id}/question")
    public  ResponseEntity<List<Pregunta>> getQuestion(@PathVariable int id){
        return ResponseEntity.status(HttpStatus.OK).body(quizService.getAllQuestions(id));
    }

    @PostMapping("/question/answer")
    public ResponseEntity<Respuesta> saveResponse(@RequestBody Respuesta respuesta){
        return ResponseEntity.status(HttpStatus.OK).body(quizService.saveAnswer(respuesta));
    }
}
