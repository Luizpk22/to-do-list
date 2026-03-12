package com.luizhendasilva.toDoList.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tarefas")
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 256)
    private String nome;
    @Column(length = 256)
    private String descricao;
    @Column(nullable = false)
    private Boolean status = false;
    @Column(nullable = false)
    private LocalDate dataCriacao;
}
