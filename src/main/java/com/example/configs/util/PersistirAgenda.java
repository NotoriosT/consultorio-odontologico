package com.example.configs.util;

import com.example.configs.dao.DAO;
import com.example.configs.entidades.Agenda;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class PersistirAgenda {
 private DAO<Object> dao=new DAO<>();
  private   String horaInicial;
   private String consulta ;
 private    String dataInicial ;
    private    String datafinal ;
    private    String horaFinal ;
    private   String horaInicioAlmoco ;
    private   String horaFinalAlmoco;

    public PersistirAgenda(String horaInicial, String consulta, String dataInicial, String datafinal, String horaFinal, String horaInicioAlmoco, String horaFinalAlmoco) {
        this.horaInicial = horaInicial;
        this.consulta = consulta;
        this.dataInicial = dataInicial;
        this.datafinal = datafinal;
        this.horaFinal = horaFinal;
        this.horaInicioAlmoco = horaInicioAlmoco;
        this.horaFinalAlmoco = horaFinalAlmoco;
    }

   public void prencher(){

        LocalTime inicioMolco = LocalTime.parse(horaInicioAlmoco);
        LocalTime finalMolco = LocalTime.parse(horaFinalAlmoco);
        LocalDateTime localDateTimeInicial;
        LocalDateTime localDateTimeFinal;
        localDateTimeFinal = LocalDateTime.parse(datafinal + "T" + horaFinal);
        localDateTimeInicial = LocalDateTime.parse(dataInicial + "T" + horaInicial);

        long dias = ChronoUnit.DAYS.between(localDateTimeInicial, localDateTimeFinal);
        long horasDiferenca = Math.abs(ChronoUnit.HOURS.between(LocalTime.parse(horaInicial), LocalTime.parse(horaFinal)));

        long minutos = ChronoUnit.MINUTES.between(LocalTime.parse("01:00"), LocalTime.parse(consulta));


        if (minutos == 0) {
            minutos = 60;
        } else if (minutos > 1) {
            minutos = minutos + 60;
        }
        if (minutos < -1) {
            minutos = minutos * -1;
        }
        int tempoConsulta = (int) ((horasDiferenca * 60) / minutos);

        LocalDateTime localDateTime;
        for (int i = 0; i <= dias; i++) {
            localDateTime = localDateTimeInicial.plusDays(i);

            for (int j = 0; j <= (tempoConsulta); j++) {

                String minutosAlmoco = String.valueOf(localDateTime.getMinute());
                String horasAlmoco = String.valueOf(localDateTime.getHour());
                if (minutosAlmoco.equals("0")) {
                    minutosAlmoco = minutosAlmoco + "0";
                }
                if (horasAlmoco.length() == 1) {
                    horasAlmoco = "0" + horasAlmoco;
                }
                horasAlmoco = horasAlmoco + ":" + minutosAlmoco;
                LocalTime timeAtuatl = LocalTime.parse(horasAlmoco);
                if (inicioMolco.isAfter(timeAtuatl)| finalMolco.isBefore(timeAtuatl)| finalMolco.equals(timeAtuatl) | inicioMolco.equals(timeAtuatl)){
                    Agenda agenda=new Agenda();
                    DateTimeFormatter format = DateTimeFormatter.ISO_DATE_TIME;
                    agenda.setData(format.format(localDateTime));
                    dao.persistirCompleto(agenda);

                }

                localDateTime = localDateTime.plusMinutes(minutos);
            }

        }
    }

}
