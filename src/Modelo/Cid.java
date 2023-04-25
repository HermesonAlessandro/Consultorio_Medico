package Modelo;
public class Cid {
    private int cod;
    private int capitulo;        
    private String descricao;
    private String cod_cid_10;

    public Cid(int cod, int capitulo, String descricao, String cod_cid_10) {
        this.cod = cod;
        this.capitulo = capitulo;
        this.descricao = descricao;
        this.cod_cid_10 = cod_cid_10;
    }

    public Cid() {
         this.cod = 0;
        this.capitulo = 0;
        this.descricao = "";
        this.cod_cid_10 = "";
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public int getCapitulo() {
        return capitulo;
    }

    public void setCapitulo(int capitulo) {
        this.capitulo = capitulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCod_cid_10() {
        return cod_cid_10;
    }

    public void setCod_cid_10(String cod_cid_10) {
        this.cod_cid_10 = cod_cid_10;
    }
    
    
    
    
    
    
            
}
