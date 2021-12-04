/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otherClass;

/**
 *
 * @author lucas
 */
public class Endereco {

    private String rua;
    private String bairro;
    private String municipio;
    private String estado;
    private String telefone;
    private String cep;
    private int numero;

    public Endereco(String rua, int numero, String bairro, String municipio, String estado, String telefone, String cep) {
        this.rua = rua;
        this.bairro = bairro;
        this.municipio = municipio;
        this.estado = estado;
        this.telefone = telefone;
        this.cep = cep;
        this.numero = numero;
    }

    public Endereco() {
    }

    public void setRua(String logradouro) {
        this.rua = logradouro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
    

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getRua() {
        return rua;
    }

    public String getBairro() {
        return bairro;
    }

    public String getMunicipio() {
        return municipio;
    }

    public String getEstado() {
        return estado;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }

    public int getNumero() {
        return numero;
    }
}
