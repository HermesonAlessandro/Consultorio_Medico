package Modelo;
public class Atestado {
    private int id;
    private String dias_ausentes;
    private int fk_cpf_m;
    private int fk_cpf_p;

    public Atestado(int id, String dias_ausentes, int fk_cpf_m, int fk_cpf_p) {
        this.id = id;
        this.dias_ausentes = dias_ausentes;
        this.fk_cpf_m = fk_cpf_m;
        this.fk_cpf_p = fk_cpf_p;
    }

    public Atestado() {
        this.id =0;
        this.dias_ausentes = "";
        this.fk_cpf_m = 0;
        this.fk_cpf_p = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDias_ausentes() {
        return dias_ausentes;
    }

    public void setDias_ausentes(String dias_ausentes) {
        this.dias_ausentes = dias_ausentes;
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
