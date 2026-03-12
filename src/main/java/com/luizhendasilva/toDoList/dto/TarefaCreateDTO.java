package com.luizhendasilva.toDoList.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TarefaCreateDTO {

    @NotBlank(message = "Campo obrigatório.")
    private String nome;
    private String descricao;
    private Boolean status;
    private LocalDate dataCriacao;
}
