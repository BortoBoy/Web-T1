package br.ufscar.dc.dsw.domain;

public class Medico extends BaseUser {
    public static enum Especialidades{
        CARDIO, PNEUMO, PEDIATRA, CIRURGIAO, DERMATO
    }
    
    private String crm;
    private Especialidades especialidade;
    
    public String getCrm() {
        return crm;
    }
    
    public static void validateCrm(String crm) throws Exception{
        if(crm.length() > 48){
            throw new Exception("Crm pode ter somente 48 caracteres");
        }
    }

    public void setCrm(String crm) throws Exception {
        validateCrm(crm);
        this.crm = crm;
    }

    public int getEspecialidade() {
        return especialidade.ordinal();
    }
    
    public String getEsepcialidadeStr(){
        return especialidade.name();
    }

    public void setEspecialidade(int especialidade) throws Exception {
        if(especialidade < 0 || especialidade > Especialidades.values().length){
            String error_message = "Especialidade só pode ser: ";
            for(Especialidades opcao: Especialidades.values()){
                error_message += "\n\t"+opcao.ordinal()+": "+opcao.name();
            }
            throw new Exception(error_message);
        }
        this.especialidade = Especialidades.values()[especialidade];
    }
    
    @Override
    public String toString() {
        return "Medico <\n"
        + "\temail: "+this.email+"\n"
        + "\tsenha: "+this.senha+"\n"
        + "\tnome: "+this.nome+"\n"
        + "\tcrm: "+this.crm+"\n"
        + "\tespecialidade: "+this.especialidade+"\n"
        + ">";
    }
}
