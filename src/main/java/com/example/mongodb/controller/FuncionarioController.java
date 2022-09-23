package com.example.mongodb.controller;

import com.example.mongodb.model.Funcionario;
import com.example.mongodb.model.FuncionarioDTO;
import com.example.mongodb.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;
    private List<FuncionarioDTO> funcionarioDTOS;

    @GetMapping
    public List<Funcionario> obterTodos() {
        return this.funcionarioService.obterTodos();
    }

    @GetMapping("/{codigo}")
    public FuncionarioDTO obterPorCodigo(@PathVariable String codigo) {
        Funcionario funcionario = this.funcionarioService.obterPorCodigo(codigo);

        FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
        funcionario.setCodigo(funcionario.getCodigo());
        funcionarioDTO.setNome(funcionario.getNome());
        funcionarioDTO.setIdade(funcionario.getIdade());
        funcionarioDTO.setSalario(funcionario.getSalario());
        funcionarioDTO.setChefe(funcionario.getChefe());

        return funcionarioDTO;

    }

    @PostMapping
    public FuncionarioDTO criar(@RequestBody Funcionario funcionario) {
        Funcionario funcionarioNovo = this.funcionarioService.criar(funcionario);

        FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
        funcionarioDTO.setCodigo(funcionarioNovo.getCodigo());
        funcionarioDTO.setNome(funcionarioNovo.getNome());
        funcionarioDTO.setSalario(funcionarioNovo.getSalario());
        funcionarioDTO.setIdade(funcionarioNovo.getIdade());
        funcionarioDTO.setChefe(funcionarioNovo.getChefe());

        return funcionarioDTO;
    }

    @GetMapping("/periodo")
    public List<FuncionarioDTO> obterFunicionariosPorIdadade(@RequestParam("idadeIni") Integer idadeIni, @RequestParam("idadeFim") Integer idadeFim) {
        List<Funcionario> funcionarios = this.funcionarioService.obterFunicionariosPorIdadade(idadeIni, idadeFim);
        funcionarioDTOS = new ArrayList<>();

        for (Funcionario funcionario: funcionarios) {
            FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
            funcionarioDTO.setCodigo(funcionario.getCodigo());
            funcionarioDTO.setNome(funcionario.getNome());
            funcionarioDTO.setSalario(funcionario.getSalario());
            funcionarioDTO.setIdade(funcionario.getIdade());
            funcionarioDTO.setChefe(funcionario.getChefe());

            funcionarioDTOS.add(funcionarioDTO);
        }

        return funcionarioDTOS;
    }

    @GetMapping("/nome")
    public List<FuncionarioDTO> obterFunicionariosPorNome(@RequestParam("nome") String nome) {
        List<Funcionario> funcionarios = this.funcionarioService.obterFuncionarioPorNome(nome);
        funcionarioDTOS = new ArrayList<>();

        for (Funcionario funcionario: funcionarios) {
            FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
            funcionarioDTO.setCodigo(funcionario.getCodigo());
            funcionarioDTO.setNome(funcionario.getNome());
            funcionarioDTO.setSalario(funcionario.getSalario());
            funcionarioDTO.setIdade(funcionario.getIdade());
            funcionarioDTO.setChefe(funcionario.getChefe());

            funcionarioDTOS.add(funcionarioDTO);
        }

        return funcionarioDTOS;
    }

}
