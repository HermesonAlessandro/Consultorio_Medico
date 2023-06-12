package Modelo;
public class Administrador {
    private int rg_a;
    private String  nome_func;
    private int cpf;
    private String senha;
    private String sexo;
    private String clin;
    private int tel;

    public Administrador(int rg_a, String nome_func, int cpf, String senha, String sexo, String clin, int tel) {
        this.rg_a = rg_a;
        this.nome_func = nome_func;
        this.cpf = cpf;
        this.senha = senha;
        this.sexo = sexo;
        this.clin = clin;
        this.tel = tel;
    }

    public Administrador() {
        this.rg_a = 0;
        this.nome_func = "";
        this.cpf = 0;
        this.senha = "";
        this.sexo = "";
        this.clin = "";
        this.tel = 0;
    }

    public int getRg_a() {
        return rg_a;
    }

    public void setRg_a(int rg_a) {
        this.rg_a = rg_a;
    }

    public String getNome_func() {
        return nome_func;
    }

    public void setNome_func(String nome_func) {
        this.nome_func = nome_func;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getClin() {
        return clin;
    }

    public void setClin(String clin) {
        this.clin = clin;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }
    
    
   
}
