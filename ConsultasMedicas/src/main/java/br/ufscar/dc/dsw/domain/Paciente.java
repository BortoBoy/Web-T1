package br.ufscar.dc.dsw.domain;

import java.sql.Date;

public class Paciente extends BaseUser{
    public enum Sexos{
        MASCULINO, FEMININO, OUTRO
    }
    
    private String cpf;
    private Sexos sexo;
    private String telefone;
    private Date aniversario;
    
    public String getCpf() {
        return cpf;
    }

    public static void validateCpf(String cpf) throws Exception{
        if(cpf.length() > 20){
            throw new Exception("CPF deve ter no máximo 20 caracteres");
        }
    }
    
    public void setCpf(String cpf) throws Exception {
        this.cpf = cpf;
    }

    public int getSexo() {
        return sexo.ordinal();
    }
    
    public String getSexoStr() {
        return sexo.name();
    }

    public void setSexo(int sexo) throws Exception {
        if(sexo < 0 || sexo > Sexos.values().length){
            String error_message = "Sexo só pode ser: ";
            for(Sexos opcao: Sexos.values()){
                error_message += "\n\t"+opcao.ordinal()+": "+opcao.name();
            }
            throw new Exception(error_message);
        }
        this.sexo = Sexos.values()[sexo];
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) throws Exception {
        if(telefone.length() > 20){
            throw new Exception("Telefone pode ter no máximo 20 caracteres");
        }
        this.telefone = telefone;
    }

    public Date getAniversario() {
        return aniversario;
    }

    public void setAniversario(Date aniversario) {
        this.aniversario = aniversario;
    }

    @Override
    public String toString() {
        return "Paciente <\n"
        + "\temail: "+this.email+"\n"
        + "\tsenha: "+this.senha+"\n"
        + "\tnome: "+this.nome+"\n"
        + "\tcpf: "+this.cpf+"\n"
        + "\ttelefone: "+this.telefone+"\n"
        + "\tsexo: "+this.sexo+"\n"
        + "\taniversario: "+this.aniversario+"\n"
        + ">";
    }
}
