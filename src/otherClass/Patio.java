/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otherClass;

import Excecoes.DadosIncompletos;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author lucas
 */
public class Patio {

    private String nome;
    private String codigo;
    private double diariaCar;
    private double diariaCam;
    private int capacidade;
    private int vagaDisponivel;
    private Endereco endereco;

    public Patio() {
    }

    public Patio(String nome, String codigo, double diariaCar, double diariaCam, int capacidade, int vagas, Endereco endereco) {
        this.nome = nome;
        this.codigo = codigo;
        this.diariaCar = diariaCar;
        this.diariaCam = diariaCam;
        this.capacidade = capacidade;
        this.endereco = endereco;
        this.vagaDisponivel = vagas;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public int getVagaDisponivel() {
        return vagaDisponivel;
    }

    public void setVagaDisponivel(int vagaDisponivel) {
        this.vagaDisponivel = vagaDisponivel;
    }

    public double getDiariaCar() {
        return diariaCar;
    }

    public void setDiariaCar(double diariaCar) {
        this.diariaCar = diariaCar;
    }

    public double getDiariaCam() {
        return diariaCam;
    }

    public void setDiariaCam(double diariaCam) {
        this.diariaCam = diariaCam;
    }

    /*os métodos liberaVaga e ocupaVaga são para controle na classe conta da quantidade veículos que podem ser
    estacionados em determinado pátio*/
    public void ocupaVaga() {
        this.vagaDisponivel -= 1;
    }

    public void liberaVaga() {
        this.vagaDisponivel += 1;
    }

    /*no cadatra antes de coletar o restante dos dados, é verificado se algum pátio já tem um 
    código cadastrado. Se houver não é possivel fazer o cadastrado.*/
    public void cadastra(ArrayList patios) throws DadosIncompletos {
        Scanner in = new Scanner(System.in);
        System.out.println();
        Patio busca = null;
        System.out.printf("Código do Pátio: ");
        this.codigo = in.nextLine();
        for (int cont = 0; cont < patios.size(); cont++) {
            busca = (Patio) patios.get(cont);
            if (this.codigo.equals(busca.getCodigo())) {
                busca = (Patio) patios.get(cont);
            } else {
                busca = null;
            }
        }
        if (busca != null) {
            System.out.println("Pátio com mesmo código já existe!");
        } else {
            //nome
            System.out.printf("Nome: ");
            this.nome = in.nextLine();
            //rua
            System.out.printf("Logradouro: ");
            String rua = in.nextLine();
            //numero
            System.out.printf("Número: ");
            int numero = (Integer.parseInt(in.nextLine()));
            //bairro
            System.out.printf("Bairro: ");
            String bairro = in.nextLine();
            //minicipio
            System.out.printf("Municipio: ");
            String municipio = in.nextLine();
            //Estado
            System.out.printf("Estado: ");
            String estado = in.nextLine();
            //CEP
            System.out.printf("CEP: ");
            String cep = in.nextLine();
            //telefone
            System.out.printf("Telefone: ");
            String telefone = in.nextLine();
            //capacidade de veiculos para carros
            System.out.printf("Valor da diária para carros: ");
            this.diariaCar = (Double.parseDouble(in.nextLine()));
            //valor da diaria para caminhões
            System.out.printf("Valor da diária para caminhões: ");
            this.diariaCam = (Double.parseDouble(in.nextLine()));
            //valor da diaria
            System.out.printf("Capacidade de veiculos: ");
            this.capacidade = (Integer.parseInt(in.nextLine()));
            System.out.printf("Vagas disponíveis para uso: ");
            this.vagaDisponivel = (Integer.parseInt(in.nextLine()));
            if (this.codigo.equals("") || this.nome.equals("") || rua.equals("") || bairro.equals("") || municipio.equals("") || estado.equals("") || cep.equals("") || telefone.equals("") || numero == 0) {
                throw new DadosIncompletos("Dados não foram inseridos corretamente");
            } else {
                this.endereco = new Endereco(rua, numero, bairro, municipio, estado, cep, telefone);
                Patio patio = new Patio(this.nome, this.codigo, this.diariaCar, this.diariaCam, this.capacidade, this.vagaDisponivel, this.endereco);
                patios.add(patio);
                System.out.println("\nPátio cadastrado com sucesso!");
            }
        }
    }

    public Patio verifica(ArrayList<Patio> patios) {
        Scanner in = new Scanner(System.in);
        Patio busca = null;
        boolean verifica = patios.isEmpty();
        boolean ver = false;
        if (!verifica) {
            System.out.printf("\nConfirme o código do pátio: ");
            this.codigo = in.nextLine();
            for (Patio patio : patios) {
                while (!ver) {
                    if (this.codigo.equals(patio.getCodigo())) {
                        busca = patio;
                        ver = true;
                    }
                }
            }
            if(!ver){
                busca = null;
            }
        } else {
            System.out.println("\nNão há pátios cadastrados.");
        }
        return busca;
    }

    public void exclui(ArrayList<Patio> patios) {
        Scanner in = new Scanner(System.in);
        Patio exc = new Patio();
        boolean verifica = patios.isEmpty();
        if (!verifica) {
            if (exc.verifica(patios) != null) {
                System.out.printf("\nDeseja realmente excluir? 1 para sim / 2 para não.:");
                int selec = (Integer.parseInt(in.nextLine()));
                switch (selec) {
                    case 1:
                        patios.remove(exc);
                        System.out.println("\nPátio excluído com sucesso!");
                        break;
                    case 2:
                        System.out.println("\nOperação Cancelada.");
                        break;
                }
            } else {
                System.out.println("\nPátio não existe!");
            }
        } else {
            System.out.println("\nNão há pátios cadastrados.");
        }
    }

    public void imprimir() {
        System.out.println("\nCódigo de busca: " + this.codigo);
        System.out.println("Nome: " + this.nome);
        System.out.println("Logradouro: " + this.endereco.getRua());
        System.out.println("Número: " + this.endereco.getNumero());
        System.out.println("Bairro: " + this.endereco.getBairro());
        System.out.println("Município: " + this.endereco.getMunicipio());
        System.out.println("Estado: " + this.endereco.getEstado());
        System.out.println("CEP: " + this.endereco.getCep());
        System.out.println("Telefone: " + this.endereco.getTelefone());
        System.out.println("Capaciade de veículos: " + this.capacidade);
        System.out.println("Vagas disponivéis no estacionamento: " + this.vagaDisponivel);
        System.out.println("Diária para carros: R$" + this.diariaCar);
        System.out.println("Diária para caminhões: R$" + this.diariaCam);
        System.out.println("");
    }

    public void imprimeUm(ArrayList patios) {
        Scanner in = new Scanner(System.in);
        Patio busca = null;
        boolean verifica = patios.isEmpty();
        boolean ver = true;
        if (!verifica) {
            System.out.printf("Confirme o código do pátio: ");
            String plac = in.nextLine();
            for (int cont = 0; cont < patios.size(); cont++) {
                while (ver) {
                    busca = (Patio) patios.get(cont);
                    if (plac.equals(busca.getCodigo())) {
                        busca = (Patio) patios.get(cont);
                        busca.imprimir();
                        ver = false;
                    } else {
                        ver = false;
                        System.out.println("\nPátio não encontrado!");
                    }
                }
            }

        } else {
            System.out.println("\nNão há pátios cadastrados.");
        }
    }
}
