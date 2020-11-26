package br.ufscar.dc.dsw.domain;

import java.sql.Date;

public class Consulta {
    String crm_medico;
    String cpf_paciente;
    Date hora;
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

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) throws Exception {
        if(hora.getMinutes() != 0 && hora.getMinutes() != 0){
            throw new Exception("Minutos da horario da consulta podem ser somente 0 e 30");
        }
        this.hora = hora;
    }
    
    
}
