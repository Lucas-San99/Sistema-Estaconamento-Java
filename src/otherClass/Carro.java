/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otherClass;

import Excecoes.AlteraVeiculo;
import Excecoes.DadosIncompletos;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author lucas
 */
public class Carro extends Veiculo {

    //numero de portas e quantidade de passageiros
    private int NPortas, qtdPass;

    public Carro(int NPortas, int qtdPass, String marca, String modelo, int anoFabricacao, int anoModelo, String chassi, String placa) {
        super(marca, modelo, anoFabricacao, anoModelo, chassi, placa);
        this.NPortas = NPortas;
        this.qtdPass = qtdPass;
    }

    public Carro() {

    }

    public int getNPortas() {
        return NPortas;
    }

    public void setNPortas(int NPortas) {
        this.NPortas = NPortas;
    }

    public int getQtdPass() {
        return qtdPass;
    }

    public void setQtdPass(int qtdPass) {
        this.qtdPass = qtdPass;
    }

    /*no cadastramento tanto do carro quanto do caminhão NÃO é possivel cadastrar mias de uma vez a mesma placa, ou seja, 
    após cadastrar um carro com placa "1" não é possível cadastrar um caminhão com placa "1". A placa é atributo da classe veículo
    sendo assim não é possivel que existam duas placas da mesma classe, talvez esse erro podesse ser contornado movendo a placa para as classes 
    carro e caminhão. Mas não foi feito.*/
    public void cadastraCarro(ArrayList<Veiculo> carros) throws DadosIncompletos {
        Scanner in = new Scanner(System.in);
        Carro carro;
        Veiculo busca = null;
        System.out.printf("\nPlaca do Carro: ");
        this.placa = in.nextLine();
        for (int cont = 0; cont < carros.size(); cont++) {
            busca = (Veiculo) carros.get(cont);
            if (this.placa.equals(busca.getPlaca())) {
                busca = (Veiculo) carros.get(cont);
            } else {
                busca = null;
            }
        }
        if (busca != null) {
            System.out.println("\nVeículo com mesma placa já existe!");
        } else {

            super.cadastra(carros);
            System.out.printf("Quantidade de portas: ");
            this.NPortas = (Integer.parseInt(in.nextLine()));
            System.out.printf("Quantidade de passageiros: ");
            this.qtdPass = (Integer.parseInt(in.nextLine()));
            if (this.placa.equals("") || this.marca.equals("") || this.modelo.equals("") || this.chassi.equals("")) {
                throw new DadosIncompletos("Dados não foram inseridos corretamente");
            } else {
                carro = new Carro(this.NPortas, this.qtdPass, this.marca, this.modelo, this.anoFabricacao, this.anoModelo, this.chassi, this.placa);
                carros.add(carro);
                System.out.println("\nCarro cadastrado com sucesso!");
            }
        }
    }

    /*
    o tratamento de exceção foi forçosamente aplicado no alteraDados.
    Foi exageradamente usado o throw, porém foi uma boa ideia tendo em vista que não é recomendado que os
    campos fiquem vazios, apesar de que fora os campos numéricos, os erros não são considerados. Onde aparentemente não há 
    lançamento de exceção na verdade é porque é uma exceção já verificada, então foi tratada diretamente na classe principal.*/

    public void alteraDados(ArrayList<Veiculo> veiculos) throws AlteraVeiculo {
        Scanner in = new Scanner(System.in);
        boolean verifica = veiculos.isEmpty();
        if (!verifica) {
            Carro busca = this.verifica(veiculos);
            if (busca != null) {
                Menus.subMenuVeiculo();
                int selec = (Integer.parseInt(in.nextLine()));
                switch (selec) {
                    case 1://alterar marca
                        System.out.printf("\nNova marca: ");
                        String marca = in.nextLine();
                        if (marca.equals("")) {
                            throw new AlteraVeiculo("Item não foi preenchido");
                        } else {
                            busca.setMarca(marca);
                            System.out.println("\nAterado com sucesso!");
                        }
                        break;
                    case 2://alterar modelo
                        System.out.printf("\nNovo modelo: ");
                        String modelo = in.nextLine();
                        if (modelo.equals("")) {
                            throw new AlteraVeiculo("Item não foi preenchido");
                        } else {
                            busca.setModelo(modelo);
                            System.out.println("\nAterado com sucesso!");
                        }
                        break;
                    case 3://alterar Ano fab.
                        System.out.printf("\nAno de Fabricação: ");
                        busca.setAnoFabricacao((Integer.parseInt(in.nextLine())));
                        System.out.println("\nAterado com sucesso!");
                        break;
                    case 4://alterar ano modelo
                        System.out.printf("\nAno do modelo: ");
                        busca.setAnoModelo((Integer.parseInt(in.nextLine())));
                        System.out.println("\nAterado com sucesso!");
                        break;
                    case 5://alterar chassi
                        System.out.printf("\nNovo chassi: ");
                        String chassi = in.nextLine();
                        if (chassi.equals("")) {
                            throw new AlteraVeiculo("Item não foi preenchido");
                        } else {
                            busca.setChassi(chassi);
                            System.out.println("\nAterado com sucesso!");
                        }
                        break;
                    case 6://alterar placa
                        System.out.printf("\nNova placa: ");
                        String placa = in.nextLine();
                        if (placa.equals("")) {
                            throw new AlteraVeiculo("Item não foi preenchido");
                        } else {
                            busca.setPlaca(placa);
                            System.out.println("\nAterado com sucesso!");
                        }
                        break;
                    case 7://alterar numero de portas
                        System.out.printf("\nN° de portas: ");
                        busca.setNPortas((Integer.parseInt(in.nextLine())));
                        System.out.println("\nAterado com sucesso!");
                        break;
                    case 8://alterar numero de passageiros
                        System.out.printf("\nQuantidade de passageiros: ");
                        busca.setQtdPass((Integer.parseInt(in.nextLine())));
                        System.out.println("\nAterado com sucesso!");
                        break;
                    case 9://voltar
                        break;
                    default:
                        System.out.println("\nOpção inválida, tente novamente.");
                }
            } else {
                System.out.println("\nNão há Carros cadastrados com esta placa.");
            }
        } else {
            System.out.println("\nNão há veiculos cadastrados.");
        }
    }

    public Carro verifica(ArrayList<Veiculo> veiculos) {
        Scanner in = new Scanner(System.in);
        Carro busca = null;
        boolean verifica = veiculos.isEmpty();
        boolean ver = false;
        if (!verifica) {
            System.out.printf("Confirme a placa do veículo: ");
            String codigo = in.nextLine();
            for (int cont = 0; cont < veiculos.size(); cont++) {
                Veiculo veiculo = (Veiculo) veiculos.get(cont);
                if (veiculo instanceof Carro) {
                    if (codigo.equals(veiculo.getPlaca())) {
                        busca = (Carro) veiculo;
                        ver = true;
                    }
                }
            }

        } else {
            System.out.println("\nNão há veículos cadastrados.");
        }
        if (!ver) {
            busca = null;
            System.out.println("\nNão há carros cadastrados com essa placa.");
        }

        return busca;
    }

    public void exclui(ArrayList<Veiculo> veiculos) {
        Scanner in = new Scanner(System.in);
        Carro exc = this.verifica(veiculos);
        if (exc != null) {
            System.out.print("\nDeseja realmente excluir? 1 para sim / 2 para não.:");
            int selec = (Integer.parseInt(in.nextLine()));
            switch (selec) {
                case 1:
                    veiculos.remove(exc);
                    System.out.println("\nVeículo excluído com sucesso!");
                    break;
                case 2:
                    System.out.println("\nOperação Cancelada.");
                    break;
                default:
                    System.out.println("\nOpção inválida, tente novamente.");
            }
        }
    }

    public void imprimeUm(ArrayList<Veiculo> veiculos) {
        Scanner in = new Scanner(System.in);
        boolean verifica = veiculos.isEmpty();
        boolean encontrou = false;
        if (!verifica) {
            System.out.printf("Confirme a placa do veículo: ");
            String plac = in.nextLine();
            for (int i = 0; i < veiculos.size(); i++) {
                Veiculo busca = (Veiculo) veiculos.get(i);
                if (busca instanceof Carro) {
                    if (plac.equals(busca.getPlaca())) {
                        Carro carro = (Carro) busca;
                        carro.imprimir();
                        encontrou = true;
                    }
                }
            }
            if (!encontrou) {
                System.out.println("\nNão há carros cadastrados com essa placa.");
            }
        } else {
            System.out.println("\nNão há veículos cadastrados.");
        }

    }

    public void listarTodosOsCarros(ArrayList<Veiculo> veiculos) {
        for (int i = 0; i < veiculos.size(); i++) {
            Veiculo busca = (Veiculo) veiculos.get(i);
            if (busca instanceof Carro) {
                Carro todos = (Carro) busca;
                todos.imprimir();
            }
        }
    }

    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("Quantidade de portas: " + this.NPortas);
        System.out.println("Quantidade de passageiros: " + this.qtdPass);
    }

}
