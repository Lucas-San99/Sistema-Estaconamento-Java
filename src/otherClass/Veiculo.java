/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otherClass;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author lucas
 */
public class Veiculo {

    protected String marca;
    protected String modelo;
    protected int anoFabricacao;
    protected int anoModelo;
    protected String chassi;
    protected String placa;

    public Veiculo() {
    }

    public Veiculo(String marca, String modelo, int anoFabricacao, int anoModelo, String chassi, String placa) {
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
        this.anoModelo = anoModelo;
        this.chassi = chassi;
        this.placa = placa;
    }

    /*CRIANDO SETTERS*/
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public void setAnoModelo(int anoModelo) {
        this.anoModelo = anoModelo;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
    
    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAnoFabfabricao() {
        return anoFabricacao;
    }

    public int getAnoModelo() {
        return anoModelo;
    }

    public String getChassi() {
        return chassi;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void cadastra(ArrayList veiculos) {
        Scanner in = new Scanner(System.in);
        System.out.printf("Marca: ");
        this.marca = in.nextLine();
        System.out.printf("Modelo: ");
        this.modelo = in.nextLine();
        System.out.printf("Ano do modelo: ");
        this.anoModelo = (Integer.parseInt(in.nextLine()));
        System.out.printf("Ano de fabricação: ");
        this.anoFabricacao = (Integer.parseInt(in.nextLine()));
        System.out.printf("Chassi: ");
        this.chassi = in.nextLine();
    }

    public void imprimir() {
        System.out.println();
        System.out.println("Placa: " + this.placa);
        System.out.println("Marca: " + this.marca);
        System.out.println("Modelo: " + this.modelo);
        System.out.println("Ano de Fabricação: " + this.anoFabricacao);
        System.out.println("Ano do modelo: " + this.anoModelo);
        System.out.println("Chassi: " + this.chassi);

    }
    
}
