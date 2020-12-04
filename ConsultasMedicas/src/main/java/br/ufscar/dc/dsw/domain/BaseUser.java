package br.ufscar.dc.dsw.domain;

public abstract class BaseUser {
    
    protected String nome;
    protected String email;
    protected String senha;
    protected long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws Exception {
        if(nome.length() > 256){
            throw new Exception("Nome deve ter no máximo 256 caracteres");
        }
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws Exception {
        if(email.length() > 256){
            throw new Exception("Email deve ter no máximo 256 caracteres");
        }
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) throws Exception {
        if(senha.length() > 48 || senha.length() < 6){
            throw new Exception("Senha deve ter no máximo 48 caracteres"
            + "e no mínimo 6");
        }
        this.senha = senha;
    }
}
