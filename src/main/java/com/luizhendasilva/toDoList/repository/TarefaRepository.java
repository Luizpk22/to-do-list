package com.luizhendasilva.toDoList.repository;

import com.luizhendasilva.toDoList.dto.TarefaResponseDTO;
import com.luizhendasilva.toDoList.model.Tarefa;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TarefaRepository extends CrudRepository<Tarefa, Long> {

    @Override
    <S extends Tarefa> S save(S tarefa);

    @Override
    <S extends Tarefa> Iterable<S> saveAll(Iterable<S> tarefas);

    @Override
    Iterable<Tarefa> findAll();

    @Override
    Optional<Tarefa> findById(Long id);

    Iterable<Tarefa> findByStatus(Boolean status);

    Iterable<Tarefa> findByNomeContainingIgnoreCase(String nome);

    @Override
    boolean existsById(Long id);

    @Transactional
    @Modifying
    @Query("UPDATE Tarefa t SET t.status = :status WHERE t.id = :id")
    void atualizarStatus(@Param("id") Long id, @Param("status") Boolean status);

    @Override
    long count();

    @Override
    void deleteById(Long id);

    @Override
    void deleteAll();
}
