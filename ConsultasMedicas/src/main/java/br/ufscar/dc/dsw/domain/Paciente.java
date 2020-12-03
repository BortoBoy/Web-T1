package br.ufscar.dc.dsw.domain;

public class Paciente extends BaseUser{
    public static enum Sexos{
        MASCULINO, FEMININO, OUTRO
    }
    
    private String cpf;
    private Sexos sexo;
    private String telefone;
    private int dia;
    private int mes;
    private int ano;
    
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

    public String getAniversario() {
        return this.dia+"/"+this.mes+"/"+this.ano;
    }

    public void setAniversario(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAno() {
        return ano;
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
        + "\taniversario: "+this.getAniversario()+"\n"
        + ">";
    }
}
