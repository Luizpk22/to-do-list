package com.luizhendasilva.toDoList.mapper;

import com.luizhendasilva.toDoList.dto.TarefaCreateDTO;
import com.luizhendasilva.toDoList.dto.TarefaResponseDTO;
import com.luizhendasilva.toDoList.model.Tarefa;

import java.time.LocalDate;

public class TarefaMapper {

    public static Tarefa toEntity(TarefaCreateDTO dto) {

        Tarefa tarefa = new Tarefa();

        tarefa.setNome(dto.getNome());
        tarefa.setDescricao(dto.getDescricao());
        tarefa.setDataCriacao(LocalDate.now());
        tarefa.setStatus(false);

        return tarefa;
    }

    public static Tarefa toEntity(TarefaResponseDTO dto) {

        Tarefa tarefa = new Tarefa();

        tarefa.setNome(dto.getNome());
        tarefa.setDescricao(dto.getDescricao());
        tarefa.setStatus(dto.getStatus());
        tarefa.setDataCriacao(dto.getDataCriacao());

        return tarefa;
    }

    public static TarefaResponseDTO toDTO(Tarefa tarefa) {

        TarefaResponseDTO dto = new TarefaResponseDTO();

        dto.setId(tarefa.getId());
        dto.setNome(tarefa.getNome());
        dto.setDescricao(tarefa.getDescricao());
        dto.setStatus(tarefa.getStatus());
        dto.setDataCriacao(tarefa.getDataCriacao());

        return dto;
    }
}
