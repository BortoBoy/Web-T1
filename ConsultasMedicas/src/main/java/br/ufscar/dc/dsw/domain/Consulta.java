package br.ufscar.dc.dsw.domain;

import java.time.LocalDateTime;

public class Consulta {
    private long medico;
    private long paciente;
    private int ano;
    private int mes;
    private int dia;
    private int hora;
    private int minuto;
    private long id;
    private String cpf;
    private String crm;
    private String nome_medico;
    private int especialidade_medico;
    private String nome_paciente;
    private int sexo_paciente;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getNome_paciente() {
        return nome_paciente;
    }

    public void setNome_paciente(String nome_paciente) {
        this.nome_paciente = nome_paciente;
    }

    public int getSexo_paciente() {
        return sexo_paciente;
    }

    public void setSexo_paciente(int sexo_paciente) {
        this.sexo_paciente = sexo_paciente;
    }

    public void setNome_medico(String nome_medico) {
        this.nome_medico = nome_medico;
    }

    public void setEspecialidade_medico(int especialidade_medico) {
        this.especialidade_medico = especialidade_medico;
    }

    public String getNome_medico() {
        return nome_medico;
    }

    public int getEspecialidade_medico() {
        return especialidade_medico;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getMedico() {
        return medico;
    }

    public void setMedico(long medico) {
        this.medico = medico;
    }

    public long getPaciente() {
        return paciente;
    }

    public void setPaciente(long paciente) {
        this.paciente = paciente;
    }


    public String getData() {
        return String.format("%02d/%02d/%04d - %02d:%02d", 
        this.dia, this.mes, this.ano, this.hora, this.minuto);
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
        + "\tpaciente: "+this.paciente+"\n"
        + "\tmedico: "+this.medico+"\n"
        + "\tdata: "+this.getData()+"\n"
        + ">";
    }
}
