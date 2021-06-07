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
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
class QuizServiceTest {

    @InjectMocks
    private QuizService quizService;

    @Mock
    private QuizRepository quizRepository;

    @Mock
    private QuestionRepository questionRepository;

    @Mock
    private AnswerRepository answerRepository;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAllQuizTest(){
        Quiz quiz= Quiz.builder().id(1).name("temp").build();
        ArrayList<Quiz> list= new ArrayList();
        list.add(quiz);
        Mockito.when(quizRepository.findAll()).thenReturn(list);
        List<Encuesta> testResultList=quizService.getAllQuiz();

        Assertions.assertEquals(1, testResultList.get(0).getId());
    }

    @Test
    public void getAllQuestionsTest(){
        int idQuiz=1;
        List<Question> questionList= new ArrayList<>();
        Question question= Question.builder().id(1).value("test").build();
        questionList.add(question);
        Mockito.when(quizRepository.findById(Long.valueOf(idQuiz)))
                .thenReturn(Optional.of(Quiz.builder().id(1).name("test").questionList(questionList).build()));
        List<Pregunta> listPregunta= quizService.getAllQuestions(idQuiz);
        Assertions.assertEquals("test", listPregunta.get(0).getValue());
    }

    @Test
    public void saveAnswerTest(){
        Question question= Question.builder().id(1).value("Question").build();
        Answer answer= Answer.builder().question(question).value("test").build();
        Respuesta respuesta= Respuesta.builder().id(1).idQuestion(1).value("test").build();
        Mockito.when(questionRepository.findById(respuesta.getIdQuestion())).thenReturn(Optional.of(question));
        Mockito.when(answerRepository.save(answer)).thenReturn(answer);
        Respuesta respuesta1= quizService.saveAnswer(respuesta);
    }
}