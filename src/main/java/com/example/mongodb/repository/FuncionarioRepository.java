package com.example.mongodb.repository;

import com.example.mongodb.model.Funcionario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface FuncionarioRepository extends MongoRepository<Funcionario, String> {

    @Query("{ $and: [{'idade': {$gte: ?0}}, {'idade': {$lte: ?1}}] }")
    public List<Funcionario> obterFunicionariosPorIdadade(Integer idadeIni, Integer idadeFim);

    public List<Funcionario> findByNome(String nome);
}
