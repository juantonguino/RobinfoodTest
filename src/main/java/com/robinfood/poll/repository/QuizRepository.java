package com.robinfood.poll.repository;

import com.robinfood.poll.models.persistence.Quiz;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends CrudRepository<Quiz, Long> {

}
