package Modelo;
public class Clinica {
    private int cnpj;
    private String nome;
    private String end;
    private int tel;
    private int fk_cpf_sec;
    private int fk_cpf_m;
    private int fk_cpf_p;
    private int fk_rg_a;

    public Clinica(int cnpj, String nome, String end, int tel, int fk_cpf_sec, int fk_cpf_m, int fk_cpf_p, int fk_rg_a) {
        this.cnpj = cnpj;
        this.nome = nome;
        this.end = end;
        this.tel = tel;
        this.fk_cpf_sec = fk_cpf_sec;
        this.fk_cpf_m = fk_cpf_m;
        this.fk_cpf_p = fk_cpf_p;
        this.fk_rg_a = fk_rg_a;
    }

    public Clinica() {
        this.cnpj = 0;
        this.nome = "";
        this.end = "";
        this.tel = 0;
        this.fk_cpf_sec = 0;
        this.fk_cpf_m = 0;
        this.fk_cpf_p = 0;
        this.fk_rg_a = 0;
    }

    public Clinica(int cnpj, String nome, String endereço, int tel) {
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

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public int getFk_cpf_sec() {
        return fk_cpf_sec;
    }

    public void setFk_cpf_sec(int fk_cpf_sec) {
        this.fk_cpf_sec = fk_cpf_sec;
    }

    public int getFk_cpf_m() {
        return fk_cpf_m;
    }

    public void setFk_cpf_m(int fk_cpf_m) {
        this.fk_cpf_m = fk_cpf_m;
    }

    public int getFk_cpf_p() {
        return fk_cpf_p;
    }

    public void setFk_cpf_p(int fk_cpf_p) {
        this.fk_cpf_p = fk_cpf_p;
    }

    public int getFk_rg_a() {
        return fk_rg_a;
    }

    public void setFk_rg_a(int fk_rg_a) {
        this.fk_rg_a = fk_rg_a;
    }
    
    
    
    
    
    
    
    
}
