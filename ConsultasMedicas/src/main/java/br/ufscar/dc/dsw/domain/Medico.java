package br.ufscar.dc.dsw.domain;

public class Medico extends BaseUser {
    public enum Especialidades{
        MASCULINO, FEMININO, OUTRO
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

    public Especialidades getEspecialidade() {
        return especialidade;
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
}
