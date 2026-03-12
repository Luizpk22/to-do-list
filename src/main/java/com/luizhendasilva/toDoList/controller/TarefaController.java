package com.luizhendasilva.toDoList.controller;

import com.luizhendasilva.toDoList.dto.TarefaCreateDTO;
import com.luizhendasilva.toDoList.dto.TarefaResponseDTO;
import com.luizhendasilva.toDoList.model.Tarefa;
import com.luizhendasilva.toDoList.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {
    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @PostMapping
    public TarefaResponseDTO salvarTarefa(@RequestBody TarefaCreateDTO dto) {
        return tarefaService.salvarTarefa(dto);
    }

    @PostMapping("/lista")
    public Iterable<TarefaResponseDTO> salvarTarefas(@RequestBody Iterable<TarefaCreateDTO> tarefas) {
        return tarefaService.salvarTarefas(tarefas);
    }

    @GetMapping
    public Iterable<TarefaResponseDTO> buscarTodos() {
        return tarefaService.buscarTodos();
    }

    @GetMapping("/{id}")
    public TarefaResponseDTO buscarPorId(@PathVariable Long id) {
        return tarefaService.buscarPorId(id);
    }

    @GetMapping("/status")
    public List<TarefaResponseDTO> listarPorStatus(@RequestParam Boolean status) {
        return tarefaService.listarPorStatus(status);
    }

    @GetMapping("/nome")
    public List<TarefaResponseDTO> listarPorNome(@RequestParam String nome) {
        return tarefaService.listarPorNome(nome);
    }

    @PutMapping("/{id}/status")
    public void atualizarStatus(@PathVariable Long id, @RequestParam Boolean status) {
        tarefaService.atualizarStatus(id, status);
    }

    @PutMapping("/{id}")
    public TarefaResponseDTO atualizarConteudo(@PathVariable Long id, @RequestBody TarefaCreateDTO tarefa) {
        return tarefaService.atualizarConteudo(id, tarefa);
    }

    @GetMapping("/count")
    public long count() {
        return tarefaService.count();
    }

    @DeleteMapping("/{id}")
    public void deletePorId(@PathVariable Long id) {
        tarefaService.deletePorId(id);
    }

    @DeleteMapping
    public void deleteAll() {
        tarefaService.deleteAll();
    }
}
