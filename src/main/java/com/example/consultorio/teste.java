package com.example.consultorio;

import java.time.LocalDateTime;

public class teste {
    public static void main(String[] args) {
        DAO<Object>agendaDAO=new DAO<>(Object.class);

        Agenda agenda=new Agenda();
        agenda.setData(String.valueOf(LocalDateTime.of(2025,07,11,14,53)));

        agendaDAO.persistirCompleto(agenda);
    }
}

