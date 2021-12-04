/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otherClass;

import Excecoes.DadosIncompletos;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author lucas
 */
public class Cliente {

    private String codigo;
    private String nome;
    private Endereco endereco;

    public Cliente() {
    }

    public Cliente(String codigo, String nome, Endereco endereco) {
        this.codigo = codigo;
        this.nome = nome;
        this.endereco = endereco;
    }

    public void criaCliente() {

    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void cadastra(ArrayList clientes) throws DadosIncompletos {
        Scanner in = new Scanner(System.in);
        System.out.println();
        Cliente busca = null;

        System.out.printf("Código do Cliente: ");
        this.codigo = in.nextLine();
        for (int cont = 0; cont < clientes.size(); cont++) {
            busca = (Cliente) clientes.get(cont);
            if (this.codigo.equals(busca.getCodigo())) {
                busca = (Cliente) clientes.get(cont);
            } else {
                busca = null;
            }
        }
        if (busca != null) {
            System.out.println("Cliente com mesmo código já existe!");
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
            if(this.codigo.equals("") || this.nome.equals("") || rua.equals("") || bairro.equals("") || municipio.equals("") || estado.equals("") || cep.equals("") || telefone.equals("") || numero == 0){
                throw new DadosIncompletos("Dados não foram inseridos corretamente");                
            } else {
            this.endereco = new Endereco(rua, numero, bairro, municipio, estado, cep, telefone);
            Cliente cliente = new Cliente(this.codigo, this.nome, this.endereco);
            clientes.add(cliente);
            System.out.println("\nCliente cadastrado com sucesso!");
            }
        }

    }


    /*
    sobre o método verificar
    * Recebe como parametro um Array de clientes e um código para procura dos dados;
    * Instância um objeto nulo para que seja um auxilio para selecionar o objeto procurado dentro do ArrayList;
    * Há um contador que percorre o ArrayList e dentro dele é chamado o método
      "instanceof" para comparar se o que está dentro do Array é um objeto pertencente à classe "Cliente".
    * Se essa comparação for compátivel o objeto auxiliar receberá os dados do cliente procurado e
      a posição a qual ele pertence, se não, ele retorna o bjeto nulo como foi instânciado.*/
    public Cliente verifica(ArrayList<Cliente> clientes) {

        Scanner in = new Scanner(System.in);
        Cliente busca = null;
        //consultar dados do cliente
        boolean verifica = clientes.isEmpty();
        boolean ver = false;
        if (!verifica) {
            System.out.printf("\nConfirme o código do Cliente: ");
            this.codigo = in.nextLine();
            for (Cliente cliente : clientes) {
                while (!ver) {
                    if (this.codigo.equals(cliente.getCodigo())) {
                        busca = cliente;
                        ver = true;
                    } 
                }
            }
            if(!ver){
                busca = null;
            }
        } else {
            System.out.println("\nNão há clientes cadastrados.");
        }

        return busca;
    }

    public void exclui(ArrayList clientes) {
        Scanner in = new Scanner(System.in);
        Cliente exc = this.verifica(clientes);
        if (exc != null) {
            System.out.print("\nDeseja realmente excluir? 1 para sim / 2 para não.:");
            int selec = (Integer.parseInt(in.nextLine()));
            switch (selec) {
                case 1:
                    clientes.remove(exc);
                    System.out.println("\nCliente excluído com sucesso!");
                    break;
                case 2:
                    System.out.println("\nOperação Cancelada.");
                    break;
                default:
                    System.out.println("\nOpção inválida, tente novamente!");
            }
        } else {
            System.out.println("\nCliente não encontrado.");
        }
    }

    public void imprimir() {
        System.out.println("\nCódigo: " + this.codigo);
        System.out.println("Nome: " + this.nome);
        System.out.println("Logradouro: " + this.endereco.getRua());
        System.out.println("Número: " + this.endereco.getNumero());
        System.out.println("Bairro: " + this.endereco.getBairro());
        System.out.println("Município: " + this.endereco.getMunicipio());
        System.out.println("Estado: " + this.endereco.getEstado());
        System.out.println("CEP: " + this.endereco.getCep());
        System.out.println("Telefone: " + this.endereco.getTelefone());
        System.out.printf("\n\n");
    }

    public void imprimeUm(ArrayList clientes) {
        Scanner in = new Scanner(System.in);
        Cliente busca = null;
        boolean verifica = clientes.isEmpty();
        boolean ver = true;
        if (!verifica) {
            System.out.printf("Confirme o código do cliente: ");
            String cod = in.nextLine();
            for (int cont = 0; cont < clientes.size(); cont++) {
                while (ver) {
                    busca = (Cliente) clientes.get(cont);
                    if (cod.equals(busca.getCodigo())) {
                        busca = (Cliente) clientes.get(cont);
                        busca.imprimir();
                        ver = false;
                    } else {
                        ver = false;
                        System.out.println("\nCliente não encontrado!");
                    }
                }
            }

        } else {
            System.out.println("\nNão há clientes cadastrados.");
        }
    }
}
