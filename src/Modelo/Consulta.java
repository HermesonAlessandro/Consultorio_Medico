package Modelo;

import java.util.Date;
import javax.swing.JSpinner;


public class Consulta {
    private int id;
    private String nome_c;
    private Date data;
    private int fk_cpf_m;
    private int fk_cpf_sec;
    private int fk_cpf_p;

    public Consulta(int id, String nome_c, Date data, int fk_cpf_m, int fk_cpf_sec, int fk_cpf_p) {
        this.id = id;
        this.nome_c = nome_c;
        this.data = data;
        this.fk_cpf_m = fk_cpf_m;
        this.fk_cpf_sec = fk_cpf_sec;
        this.fk_cpf_p = fk_cpf_p;
    }

    public Consulta() {
        this.id = 0;
        this.nome_c = "";
        this.data = null;
        this.fk_cpf_m = 0;
        this.fk_cpf_sec = 0;
        this.fk_cpf_p = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome_c() {
        return nome_c;
    }

    public void setNome_c(String nome_c) {
        this.nome_c = nome_c;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getFk_cpf_m() {
        return fk_cpf_m;
    }

    public void setFk_cpf_m(int fk_cpf_m) {
        this.fk_cpf_m = fk_cpf_m;
    }

    public int getFk_cpf_sec() {
        return fk_cpf_sec;
    }

    public void setFk_cpf_sec(int fk_cpf_sec) {
        this.fk_cpf_sec = fk_cpf_sec;
    }

    public int getFk_cpf_p() {
        return fk_cpf_p;
    }

    public void setFk_cpf_p(int fk_cpf_p) {
        this.fk_cpf_p = fk_cpf_p;
    }
    
    
    
}
