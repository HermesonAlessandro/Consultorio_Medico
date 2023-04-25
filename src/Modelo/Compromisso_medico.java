package Modelo;
public class Compromisso_medico {
    private int id_comp_medico;
    private String descricao;
    private String h_fim;
    private String h_ini;
    private int fk_cpf_sec;
    private int fk_cpf_m;

    public Compromisso_medico(int id_comp_medico, String descricao, String h_fim, String h_ini, int fk_cpf_sec, int fk_cpf_m) {
        this.id_comp_medico = id_comp_medico;
        this.descricao = descricao;
        this.h_fim = h_fim;
        this.h_ini = h_ini;
        this.fk_cpf_sec = fk_cpf_sec;
        this.fk_cpf_m = fk_cpf_m;
    }

    public Compromisso_medico() {
        this.id_comp_medico = 0;
        this.descricao = "";
        this.h_fim = "";
        this.h_ini = "";
        this.fk_cpf_sec = 0;
        this.fk_cpf_m = 0;
    }

    public int getId_comp_medico() {
        return id_comp_medico;
    }

    public void setId_comp_medico(int id_comp_medico) {
        this.id_comp_medico = id_comp_medico;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getH_fim() {
        return h_fim;
    }

    public void setH_fim(String h_fim) {
        this.h_fim = h_fim;
    }

    public String getH_ini() {
        return h_ini;
    }

    public void setH_ini(String h_ini) {
        this.h_ini = h_ini;
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
    
    
    
}
