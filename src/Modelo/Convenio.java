package Modelo;
public class Convenio {
    private int cnpj;
    private String nome;
    private int tel;
    private String planos;
    private String end;
    private int fk_cpf_sec;

    public Convenio(int cnpj, String nome, int tel, String planos, String end, int fk_cpf_sec) {
        this.cnpj = cnpj;
        this.nome = nome;
        this.tel = tel;
        this.planos = planos;
        this.end = end;
        this.fk_cpf_sec = fk_cpf_sec;
    }

    public Convenio() {
        this.cnpj = 0;
        this.nome = "";
        this.tel = 0;
        this.planos = "";
        this.end = "";
        this.fk_cpf_sec = 0;
    }

    public Convenio(int cnpj, String nome, int tel, String planos, String endereço) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getCnpj() {
        return cnpj;
    }

    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getPlanos() {
        return planos;
    }

    public void setPlanos(String planos) {
        this.planos = planos;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public int getFk_cpf_sec() {
        return fk_cpf_sec;
    }

    public void setFk_cpf_sec(int fk_cpf_sec) {
        this.fk_cpf_sec = fk_cpf_sec;
    }
    
    
    
}
