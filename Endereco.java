public class Endereco {
    private String cep;

    public Endereco(String cep, String logradouro,
                    String numeroResidencia, String bairro, String localidade, String uf) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.numeroResidencia = numeroResidencia;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
    }

    private String logradouro;
    private String numeroResidencia;
    private String bairro;
    private String localidade;
    private String uf;

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumeroResidencia() {
        return numeroResidencia;
    }

    public void setNumeroResidencia(String numeroResidencia) {
        this.numeroResidencia = numeroResidencia;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }


    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

}
