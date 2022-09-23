package com.example.mongodb.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class FuncionarioDTO {
    private String codigo;
    private String nome;
    private Integer idade;
    private BigDecimal salario;
    private Funcionario chefe;

}
