package com.robinfood.poll.models.persistence;

import com.robinfood.poll.models.persistence.Question;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name ="quiz")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy="quiz")
    private List<Question> questionList;

}
