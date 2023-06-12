package Modelo;
public class Receita {
    private int id;
    private String descricao;
    private int fk_cpf_m;
    private int fk_cpf_p;

    public Receita(int id, String descricao, int fk_cpf_m, int fk_cpf_p) {
        this.id = id;
        this.descricao = descricao;
        this.fk_cpf_m = fk_cpf_m;
        this.fk_cpf_p = fk_cpf_p;
    }

    public Receita() {
        this.id = 0;
        this.descricao = "";
        this.fk_cpf_m = 0;
        this.fk_cpf_p = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
    
    
}
