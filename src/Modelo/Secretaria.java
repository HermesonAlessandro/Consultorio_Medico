package Modelo;
public class Secretaria {
    private int cpf;
    private String nome;
    private int rg;
    private int tel;
    private String end;
    private String sexo;
    private String senha;
    private int rg_adm;

    public Secretaria(int cpf, String nome, int rg, int tel, String end, String sexo, String senha, int rg_adm) {
        this.cpf = cpf;
        this.nome = nome;
        this.rg = rg;
        this.tel = tel;
        this.end = end;
        this.sexo = sexo;
        this.senha = senha;
        this.rg_adm = rg_adm;
    }

    public Secretaria() {
        this.cpf = 0;
        this.nome = "";
        this.rg = 0;
        this.tel = 0;
        this.end = "";
        this.sexo = "";
        this.senha = "";
        this.rg_adm = 0;
    }

    public Secretaria(int cpf, String nome, int rg, int tel, String end, String sexo, String senha) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getRg() {
        return rg;
    }

    public void setRg(int rg) {
        this.rg = rg;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getRg_adm() {
        return rg_adm;
    }

    public void setRg_adm(int rg_adm) {
        this.rg_adm = rg_adm;
    }
    
    
    
    
    
    
    
    
}
