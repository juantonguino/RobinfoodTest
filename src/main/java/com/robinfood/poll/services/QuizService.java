package com.robinfood.poll.services;

import com.robinfood.poll.models.dto.Encuesta;
import com.robinfood.poll.models.dto.Pregunta;
import com.robinfood.poll.models.dto.Respuesta;
import com.robinfood.poll.models.persistence.Answer;
import com.robinfood.poll.models.persistence.Question;
import com.robinfood.poll.models.persistence.Quiz;
import com.robinfood.poll.repository.AnswerRepository;
import com.robinfood.poll.repository.QuestionRepository;
import com.robinfood.poll.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizService {

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    public List<Encuesta> getAllQuiz(){
        List<Encuesta> encuestaList= new ArrayList<>();
        quizRepository.findAll().forEach(item->{
            Encuesta temp=Encuesta.builder()
                    .id(item.getId())
                    .name(item.getName())
                    .build();
            encuestaList.add(temp);
        });
        return encuestaList;
    }

    public List<Pregunta> getAllQuestions(int idQuiz){
        Quiz quiz = quizRepository.findById(Long.valueOf(idQuiz)).get();
        return quiz.getQuestionList().stream().map(item->
            Pregunta.builder().id(item.getId()).value(item.getValue()).build()
        ).collect(Collectors.toList());
    }

    public Respuesta saveAnswer(Respuesta respuesta){
        Question question= questionRepository.findById(respuesta.getIdQuestion()).get();
        Answer answer= Answer.builder().question(question).value(respuesta.getValue()).build();
        Answer retorno=answerRepository.save(answer);
        return Respuesta.builder().id(retorno.getId()).idQuestion(question.getId()).value(retorno.getValue()).build();
    }
}
