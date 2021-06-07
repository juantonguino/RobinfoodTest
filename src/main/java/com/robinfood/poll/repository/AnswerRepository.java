package com.robinfood.poll.repository;

import com.robinfood.poll.models.persistence.Answer;
import org.springframework.data.repository.CrudRepository;

public interface AnswerRepository extends CrudRepository<Answer, Integer> {
}
