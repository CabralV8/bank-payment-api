package com.cabral.portifoliobank.domain.models;

import com.cabral.portifoliobank.domain.enums.EstadoCivilEnum;
import com.cabral.portifoliobank.domain.enums.GeneroEnum;
import com.cabral.portifoliobank.domain.enums.NacionalidadeEnum;
import com.cabral.portifoliobank.util.IsCpfCnpj;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome é obrigatório.")
    @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres.")
    private String nome;

    @NotNull(message = "A data de nascimento é obrigatória.")
    @Past(message = "A data de nascimento não deve corresponder uma data futura.")
    private Date dataNascimento;

    @NotNull(message = "O gênero é obrigatório.")
    private GeneroEnum genero;

    @NotBlank(message = "O endereço é obrigatório.")
    @Size(max = 255, message = "O endereço deve ter no máximo 255 caracteres.")
    private String endereco;

    @Size(max = 20, message = "O telefone deve ter no máximo 20 digitos.")
    private String telefone;

    @NotBlank(message = "O e-mail é obrigatório.")
    @Email(message = "O e-mail deve ser válido.")
    private String email;

    @NotBlank(message = "O CPF é obrigatório")
    @Pattern(regexp = "\\d{11}", message = "O CPF deve conter apenas 11 dígitos")
    private String cpf;

    @NotBlank(message = "O RG é obrigatório.")
    @Size(max = 20, message = "O RG deve ter no máximo 20 caracteres.")
    private String rg;

    @NotNull(message = "O estado civil é obrigatório")
    private EstadoCivilEnum estadoCivil;

    @NotNull(message = "Nacionalidade é obrigatória.")
    private NacionalidadeEnum nacionalidade;

    @NotBlank(message = "O nome do pai é obrigatório")
    @Size(max = 100, message = "O nome do pai deve ter no máximo 100 caracteres")
    private String nomePai;

    @NotBlank(message = "O nome da mãe é obrigatório")
    @Size(max = 100, message = "O nome da mãe deve ter no máximo 100 caracteres")
    private String nomeMae;

    @NotBlank(message = "O estado é obrigatório")
    @Size(max = 2, message = "O estado deve ter no máximo 2 caracteres")
    private String estado;

    @NotBlank(message = "O país é obrigatório")
    @Size(max = 50, message = "O país deve ter no máximo 50 caracteres")
    private String pais;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public GeneroEnum getGenero() {
        return genero;
    }

    public void setGenero(GeneroEnum genero) {
        this.genero = genero;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (IsCpfCnpj.isCpf(cpf)) {
            this.cpf = cpf;
            return;
        }
        throw new IllegalArgumentException("CPF inválido");
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public EstadoCivilEnum getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivilEnum estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public NacionalidadeEnum getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(NacionalidadeEnum nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}

