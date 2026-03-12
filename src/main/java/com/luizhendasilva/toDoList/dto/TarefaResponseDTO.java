package com.luizhendasilva.toDoList.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TarefaResponseDTO {
    private Long id;
    private String nome;
    private String descricao;
    private Boolean status;
    private LocalDate dataCriacao;
}
