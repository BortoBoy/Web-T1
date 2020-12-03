package br.ufscar.dc.dsw.domain;

import java.time.LocalDateTime;

public class Consulta {
    String crm_medico;
    String cpf_paciente;
    int ano;
    int mes;
    int dia;
    int hora;
    int minuto;
    long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCrm_medico() {
        return crm_medico;
    }

    public void setCrm_medico(String crm_medico) throws Exception {
        Medico.validateCrm(crm_medico);
        this.crm_medico = crm_medico;
    }

    public String getCpf_paciente() {
        return cpf_paciente;
    }

    public void setCpf_paciente(String cpf_paciente) throws Exception {
        Paciente.validateCpf(cpf_paciente);
        this.cpf_paciente = cpf_paciente;
    }

    public String getData() {
        return this.dia+"/"+this.mes+"/"+this.ano+" - "+this.hora+":"+this.minuto;
    }

    public void setNewData(int ano, int mes, int dia, int hora, int minuto)
    throws Exception{
        LocalDateTime current_time = LocalDateTime.now();
        LocalDateTime data = LocalDateTime.of(ano, mes, dia, hora, minuto);
        
        if(current_time.isAfter(data)){
            throw new Exception("Data deve ser maior que a data atual");
        }
        else if (minuto != 0 && minuto!= 30){
            throw new Exception("Minutos devem ser somente 0 ou 30");
        }
        
        this.setData(ano, mes, dia, hora, minuto);
    }
    
    public void setData(int ano, int mes, int dia, int hora, int minuto){
        this.ano = ano;
        this.mes = mes;
        this.dia = dia;
        this.hora = hora;
        this.minuto = minuto;
    }

    public int getAno() {
        return ano;
    }

    public int getMes() {
        return mes;
    }

    public int getDia() {
        return dia;
    }

    public int getHora() {
        return hora;
    }

    public int getMinuto() {
        return minuto;
    }

    
    @Override
    public String toString() {
        return "Consulta <\n"
        + "\tid: "+this.id+"\n"
        + "\tpaciente: "+this.cpf_paciente+"\n"
        + "\tmedico: "+this.crm_medico+"\n"
        + "\tdata: "+this.getData()+"\n"
        + ">";
    }
}
