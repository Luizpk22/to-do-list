package com.luizhendasilva.toDoList.service;

import com.luizhendasilva.toDoList.dto.TarefaCreateDTO;
import com.luizhendasilva.toDoList.dto.TarefaResponseDTO;
import com.luizhendasilva.toDoList.mapper.TarefaMapper;
import com.luizhendasilva.toDoList.model.Tarefa;
import com.luizhendasilva.toDoList.repository.TarefaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class TarefaService {
    private final TarefaRepository tarefaRepository;

    @Autowired
    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    public TarefaResponseDTO salvarTarefa(TarefaCreateDTO dto) {
        Tarefa tarefa = TarefaMapper.toEntity(dto);
        tarefa = tarefaRepository.save(tarefa);
        return TarefaMapper.toDTO(tarefa);
    }

    public Iterable<TarefaResponseDTO> salvarTarefas(Iterable<TarefaCreateDTO> dtoLista) {

        List<TarefaResponseDTO> response = new ArrayList<>();
        List<Tarefa> listaSave = new ArrayList<>();

        for (TarefaCreateDTO tarefaDto : dtoLista) {
            Tarefa tarefa = TarefaMapper.toEntity(tarefaDto);
            listaSave.add(tarefa);
        }
        tarefaRepository.saveAll(listaSave);
        for (Tarefa tarefa: listaSave) {
            TarefaResponseDTO tarefaResponseDTO = TarefaMapper.toDTO(tarefa);
            response.add(tarefaResponseDTO);
        }
        return response;
    }

    public List<TarefaResponseDTO> buscarTodos() {
        Iterable<Tarefa> tarefas = tarefaRepository.findAll();
        List<TarefaResponseDTO> dto = StreamSupport
                .stream(tarefas.spliterator(), false)
                .map(TarefaMapper::toDTO).toList();
        return dto;
    }

    public TarefaResponseDTO buscarPorId(Long id) {
        return TarefaMapper.toDTO(tarefaRepository.findById(id).get());
    }

    public List<TarefaResponseDTO> listarPorStatus(Boolean status) {
        Iterable<Tarefa> tarefas = tarefaRepository.findByStatus(status);
        List<TarefaResponseDTO> dto = StreamSupport
                .stream(tarefas.spliterator(), false)
                .map(TarefaMapper::toDTO).toList();
        return dto;
    }

    public List<TarefaResponseDTO> listarPorNome(String nome) {
        Iterable<Tarefa> tarefas = tarefaRepository.findByNomeContainingIgnoreCase(nome);
        List<TarefaResponseDTO> dto = StreamSupport
                .stream(tarefas.spliterator(), false)
                .map(TarefaMapper::toDTO).toList();
        return dto;
    }

    public void atualizarStatus(Long id, Boolean status) {
        if (tarefaRepository.existsById(id)) {
            tarefaRepository.atualizarStatus(id, status);
        } else {
            throw new RuntimeException("Tarefa não encontrada.");
        }
    }

    @Transactional
    public TarefaResponseDTO atualizarConteudo(Long id, TarefaCreateDTO dto) {

        Tarefa tarefaBanco = tarefaRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada."));

        tarefaBanco.setNome(dto.getNome());
        tarefaBanco.setDescricao(dto.getDescricao());
        tarefaBanco.setStatus(dto.getStatus());

        tarefaBanco = tarefaRepository.save(tarefaBanco);

        return TarefaMapper.toDTO(tarefaBanco);
    }

    public long count() {
        return tarefaRepository.count();
    }

    public void deletePorId(Long id) {
        if (tarefaRepository.existsById(id)) {
            tarefaRepository.deleteById(id);
        } else {
            throw new RuntimeException("Tarefa não encontrada.");
        }
    }

    public void deleteAll() {
        tarefaRepository.deleteAll();
    }
}
