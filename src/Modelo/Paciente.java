package Modelo;
public class Paciente {
    private int cpf;
    private String nome;
    private String end;
    private int tel;
    private int rg;
    private String sexo;
    private String convenio;
    private int fk_cpf_sec;
    private int fk_cnpj_conevnio;

    public Paciente(int cpf, String nome, String end, int tel, int rg, String sexo, String convenio, int fk_cpf_sec, int fk_cnpj_conevnio) {
        this.cpf = cpf;
        this.nome = nome;
        this.end = end;
        this.tel = tel;
        this.rg = rg;
        this.sexo = sexo;
        this.convenio = convenio;
        this.fk_cpf_sec = fk_cpf_sec;
        this.fk_cnpj_conevnio = fk_cnpj_conevnio;
    }

    public Paciente() {
        this.cpf = 0;
        this.nome = "";
        this.end = "";
        this.tel = 0;
        this.rg = 0;
        this.sexo = "";
        this.convenio = "";
        this.fk_cpf_sec = 0;
        this.fk_cnpj_conevnio = 0;
    
    
    }

    public Paciente(int cpf, String nome, String end, int tel, int rg, String sexo, String convenio) {
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

    public int getRg() {
        return rg;
    }

    public void setRg(int rg) {
        this.rg = rg;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    public int getFk_cpf_sec() {
        return fk_cpf_sec;
    }

    public void setFk_cpf_sec(int fk_cpf_sec) {
        this.fk_cpf_sec = fk_cpf_sec;
    }

    public int getFk_cnpj_conevnio() {
        return fk_cnpj_conevnio;
    }

    public void setFk_cnpj_conevnio(int fk_cnpj_conevnio) {
        this.fk_cnpj_conevnio = fk_cnpj_conevnio;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
            
            
    
}
