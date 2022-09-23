package com.example.mongodb.service;

import com.example.mongodb.model.Funcionario;
import com.example.mongodb.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Override
    public List<Funcionario> obterTodos() {
        return this.funcionarioRepository.findAll();
    }

    @Override
    public Funcionario obterPorCodigo(String codigo) {
        return this.funcionarioRepository
                .findById(codigo)
                .orElseThrow(() -> new IllegalArgumentException("Funcionário não existe"));
    }

    @Override
    public Funcionario criar(Funcionario funcionario) {
        Funcionario chefe = this.funcionarioRepository
                .findById(funcionario.getChefe().getCodigo())
                .orElseThrow(() -> new IllegalArgumentException("Chefe não encontrado"));

        funcionario.setChefe(chefe);
        return this.funcionarioRepository.save(funcionario);
    }

    @Override
    public List<Funcionario> obterFunicionariosPorIdadade(Integer idadeIni, Integer idadeFim) {
        return this.funcionarioRepository.obterFunicionariosPorIdadade(idadeIni, idadeFim);
    }

    @Override
    public List<Funcionario> obterFuncionarioPorNome(String nome) {
        return this.funcionarioRepository.findByNome(nome);
    }
}
