package com.robinfood.poll.models.persistence;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name ="question")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "value")
    private String value;

    @ManyToOne
    @JoinColumn(name="quiz_id", nullable=false)
    private Quiz quiz;

    @OneToMany(mappedBy="question")
    private List<Answer> answerList;
}
