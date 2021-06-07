package com.robinfood.poll.repository;

import com.robinfood.poll.models.persistence.Question;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Integer> {
}
