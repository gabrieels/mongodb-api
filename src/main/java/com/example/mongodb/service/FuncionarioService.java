package com.example.mongodb.service;

import com.example.mongodb.model.Funcionario;

import java.util.List;

public interface FuncionarioService {

    public List<Funcionario> obterTodos();
    public Funcionario obterPorCodigo(String codigo);
    public Funcionario criar(Funcionario funcionario);
    public List<Funcionario> obterFunicionariosPorIdadade(Integer idadeIni, Integer idadeFim);
    public List<Funcionario> obterFuncionarioPorNome(String nome);
}
