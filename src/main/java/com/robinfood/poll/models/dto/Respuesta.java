package com.robinfood.poll.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Respuesta {

    private int idQuestion;

    private int id;

    private String value;
}
