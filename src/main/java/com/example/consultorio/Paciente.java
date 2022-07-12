package com.example.consultorio;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
    @Column(unique = true)
    private List<Agenda> agenda;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String nome;
    private String cpf;
    private String genero;
    private String RG;
    private String EstadoCivil;
    private String Celular="*";
    private String numero="*";
    private String email="*";
    private Boolean doenca=false;
    private String doencas="não";
    private String doencasObservacoes="*";
    private  String logradouro="*";
    private String numroDaCasa="*";
    private String cidade="*";
    private String estado="*";
    private String bairro="*";
    private String cep="*";
    private String coplemento="*";


    public List<Agenda> getAgenda() {
        if (this.agenda==null){
            return new ArrayList<>();
        }

        return agenda;
    }

    public void setAgenda(List<Agenda> agenda) {
        this.agenda = agenda;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getEstadoCivil() {
        return EstadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        EstadoCivil = estadoCivil;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String celular) {
        Celular = celular;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getDoenca() {
        return doenca;
    }

    public void setDoenca(Boolean doenca) {
        this.doenca = doenca;
    }

    public String getDoencas() {
        return doencas;
    }

    public void setDoencas(String doencas) {
        this.doencas = doencas;
    }

    public String getDoencasObservacoes() {
        return doencasObservacoes;
    }

    public void setDoencasObservacoes(String doencasObservacoes) {
        this.doencasObservacoes = doencasObservacoes;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumroDaCasa() {
        return numroDaCasa;
    }

    public void setNumroDaCasa(String numroDaCasa) {
        this.numroDaCasa = numroDaCasa;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCoplemento() {
        return coplemento;
    }

    public void setCoplemento(String coplemento) {
        this.coplemento = coplemento;
    }
}
