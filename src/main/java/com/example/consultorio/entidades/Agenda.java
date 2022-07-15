package com.example.consultorio.entidades;

import jakarta.persistence.*;


@Entity
public class Agenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAgenda", nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @Column(unique = true)
    private String data;

    @ManyToOne(cascade =CascadeType.ALL)
    private  Paciente paciente;
    @ManyToOne(cascade =CascadeType.ALL)
    private Procedimento procedimento;


    public Agenda() {
    }

    public void adcionaPaciente(Paciente paciente){
        if (paciente!=null){
            this.paciente=paciente;
            if (!paciente.getAgenda().contains(this)){
                paciente.getAgenda().add(this);
            }
        }

    }
    public void adcionaProcedimento(Procedimento procedimento){
        if (procedimento!=null){
            this.procedimento=procedimento;
            if (!procedimento.getAgenda().contains(this)){
                procedimento.getAgenda().add(this);
            }
        }
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Procedimento getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(Procedimento procedimento) {
        this.procedimento = procedimento;
    }
}
