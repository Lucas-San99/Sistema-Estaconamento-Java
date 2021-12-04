/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otherClass;

import java.util.ArrayList;
import java.util.Scanner;
import otherClass.*;

/**
 *
 * @author lucas
 */
public class Conta {

    //atributos
    private Cliente cliente;
    private Patio patio;
    private Veiculo veiculo;
    private int ano;
    private int mes;
    private int totalDiaria;
    private boolean paga;
    private String situacao;

    //metodos contrutores com e sem parametros
    //o uso do atributo diaria se refere a quantidade de diarias que serão add para o cliente.
    public Conta(Cliente cliente, Patio patio, Veiculo veiculo, int mes, int ano, int diaria, boolean paga) {
        this.cliente = cliente;
        this.patio = patio;
        this.veiculo = veiculo;
        this.ano = ano;
        this.mes = mes;
        this.totalDiaria = diaria;
        this.paga = paga;
    }

    public Conta() {
    }

    //setters
    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setPatio(Patio patio) {
        this.patio = patio;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public void setTotalDiaria(int diaria) {
        this.totalDiaria = this.totalDiaria + diaria;
    }

    public void setPaga(boolean paga) {
        this.paga = paga;
    }

    //getters
    public Cliente getCliente() {
        return cliente;
    }

    public Patio getPatio() {
        return patio;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public int getAno() {
        return ano;
    }

    public int getMes() {
        return mes;
    }

    public int getTotalDiaria() {
        return totalDiaria;
    }

    public boolean isPaga() {
        return paga;
    }

    public String getSituacao() {
        return situacao;
    }

    //metodos especiais
    public void criaConta(ArrayList<Conta> contas, ArrayList<Cliente> clientes, ArrayList<Patio> patios, ArrayList<Veiculo> veiculos, Cliente cli, Patio pa, Carro car) {
        Scanner in = new Scanner(System.in);
        System.out.println();
        //verificando se um cliente existe
        cli = cli.verifica(clientes);
        //verificando se um pátio existe 
        pa = pa.verifica(patios);
        //verificando se um veículo existe
        car = car.verifica(veiculos);
        if (cli != null && pa != null && car != null) {
            if (pa.getVagaDisponivel() != 0) {
                System.out.printf("Mês de entrada: ");
                this.mes = (Integer.parseInt(in.nextLine()));
                System.out.printf("Ano: ");
                this.ano = (Integer.parseInt(in.nextLine()));
                System.out.printf("Qtd. de diárias a serem adicionadas: ");
                this.totalDiaria = (Integer.parseInt(in.nextLine()));
                if (Conta.verificaConta(cli, car, pa, contas, this.totalDiaria) == null) {
                    Conta conta = new Conta(cli, pa, car, this.mes, this.ano, this.totalDiaria, false);
                    contas.add(conta);
                    pa.ocupaVaga();
                    System.out.println("\nConta cadastrada com sucesso!");
                }
            } else {
                System.out.println("\nPátio cheio, tente outro.");
            }
        } else {
            System.out.println("\nErro no cadastro dos dados iniciais da conta. Verifique os dados informados.");
        }

    }

    public void criaConta(ArrayList<Conta> contas, ArrayList<Cliente> clientes, ArrayList<Patio> patios, ArrayList<Veiculo> veiculos, Cliente cli, Patio pa, Caminhao cam) {
        Scanner in = new Scanner(System.in);
        System.out.println();
        //verificando se um cliente existe
        cli = cli.verifica(clientes);
        //verificando se um pátio existe 
        pa = pa.verifica(patios);
        //verificando se um veículo existe
        cam = cam.verifica(veiculos);
        if (cli != null && pa != null && cam != null) {
            System.out.printf("Mês de entrada: ");
            this.mes = (Integer.parseInt(in.nextLine()));
            System.out.printf("Ano: ");
            this.ano = (Integer.parseInt(in.nextLine()));
            System.out.printf("Qtd. de diárias a serem adicionadas: ");
            this.totalDiaria = (Integer.parseInt(in.nextLine()));
            if (Conta.verificaConta(cli, cam, pa, contas, this.totalDiaria) == null) {
                Conta conta = new Conta(cli, pa, cam, this.mes, this.ano, this.totalDiaria, false);
                contas.add(conta);
                pa.ocupaVaga();
                System.out.println("\nConta cadastrada com sucesso!");
            }
        } else {
            System.out.println("\nErro no cadastro dos dados iniciais da conta. Verifique os dados informados.");
        }

    }

    /*verificaConta diz respeito ao metodo principal da classe, tal metodo recebe como parametros objetos 
    cliente, veiculo e patio e também um vetor de contas (dentre outras coisas) para que sejam analisadas se há dentro do vetor
    de contas uma conta que possua os mesmos dados que foram passados como parametro. Caso exista, o metodo retorna um valor nulo 
    informando ao programa principal que já existe uma conta cadastrada para os dados informados. Caso onão exista ele retorna o 
    valor da qtd. de diárias que serão adicionadas à nova conta.*/
    public static Conta verificaConta(Cliente cliente, Veiculo veiculo, Patio patio, ArrayList<Conta> contas, int totalDiarias) {
        if (!contas.isEmpty()) {
            for (int i = 0; i < contas.size(); i++) {
                if (cliente.getCodigo().equals(contas.get(i).getCliente().getCodigo()) && veiculo.getPlaca().equals(contas.get(i).getVeiculo().getPlaca()) && patio.getNome().equals(contas.get(i).getPatio().getNome())) {
                    contas.get(i).setTotalDiaria(totalDiarias += totalDiarias);
                    return contas.get(i);
                }
            }
        }
        return null;
    }

    /*em diariaPaga o foco são alertas ao usuário na fatura, temos um booleano e uma String
    caso o booleano (paga) seja true (uma fatura paga) ele deve exibir para o usuário no detalhe da fatura sua situação
    e assim será feito para quandoa adiaria for zerada, a fatura automaticamente é fechada e é mostrada a mensagem 
    "Fatura não foi aberta", assim fica fácil de identificar que podem ser adicionadas novas diárias para um cliente.*/
    public String diariaPaga() {
        if (this.paga == true) {
            this.situacao = "Fatura paga";
        } else if (this.paga == false && this.totalDiaria != 0) {
            this.situacao = "Fatura pendente";
        }
        return this.situacao;
    }

    public void excluirDiaria(ArrayList<Conta> contas, ArrayList<Cliente> clientes, ArrayList<Patio> patios, ArrayList<Veiculo> veiculos, Cliente cliente, Patio patio, Caminhao cam, Carro car) {
        Scanner in = new Scanner(System.in);
        boolean verifica = false;
        if (!contas.isEmpty()) {
            cliente = cliente.verifica(clientes);
            patio = patio.verifica(patios);
            System.out.println("Qual categoria deseja acessar");
            Menus.subVeiculos();
            int selec = (Integer.parseInt(in.nextLine()));
            switch (selec) {
                case 1:
                    car = car.verifica(veiculos);
                    if (cliente != null && patio != null && car != null) {
                        System.out.printf("Digite a quanidade de diarias que deseja remover: ");
                        int removeDiaria = (Integer.parseInt(in.nextLine()));
                        for (int i = 0; i < contas.size(); i++) {
                            if (cliente.getCodigo().equals(contas.get(i).getCliente().getCodigo()) && car.getPlaca().equals(contas.get(i).getVeiculo().getPlaca()) && patio.getNome().equals(contas.get(i).getPatio().getNome())) {
                                contas.get(i).setTotalDiaria(this.totalDiaria - removeDiaria);
                                verifica = true;
                            }
                        }
                    }
                    break;
                case 2:
                    cam = cam.verifica(veiculos);
                    if (cliente != null && patio != null && cam != null) {
                        System.out.printf("Digite a quanidade de diarias que deseja remover: ");
                        int removeDiaria = (Integer.parseInt(in.nextLine()));
                        for (int i = 0; i < contas.size(); i++) {
                            if (cliente.getCodigo().equals(contas.get(i).getCliente().getCodigo()) && cam.getPlaca().equals(contas.get(i).getVeiculo().getPlaca()) && patio.getNome().equals(contas.get(i).getPatio().getNome())) {
                                contas.get(i).setTotalDiaria(this.totalDiaria - removeDiaria);
                                verifica = true;
                            }
                        }
                    }
                    break;
                default:
                    System.out.println("\nOpção inválida, tente novamente.");
            }
        } else {
            System.out.println("\nNão há contas cadastradas.");
        }
        if (!verifica) {
            System.out.println("\nNão foi possível localizar conta.");
        }
    }

    /*em incluirDiaria entende-se que o usuário vai atribuir ao veiculo uma diária, mas infelizmente não tendo outro 
    lugar para ser feita a atribuição foi colocado também os setters do mes e ano, para que já seja feita a 
    alteração no ato da adicção da diária, cabendo ao usuário fazer as devidas alterações*/
    public void incluirDiaria(ArrayList<Conta> contas, ArrayList<Cliente> clientes, ArrayList<Patio> patios, ArrayList<Veiculo> veiculos, Cliente cliente, Patio patio, Caminhao cam, Carro car) {
        Scanner in = new Scanner(System.in);

        if (!contas.isEmpty()) {
            boolean verifica = false;
            cliente = cliente.verifica(clientes);
            //verificando se um pátio existe 
            patio = patio.verifica(patios);
            System.out.printf("Mês de entrada: ");
            this.mes = (Integer.parseInt(in.nextLine()));
            System.out.printf("Ano: ");
            this.ano = (Integer.parseInt(in.nextLine()));
            System.out.println("Qual categoria deseja acessar");
            Menus.subVeiculos();
            int selec = (Integer.parseInt(in.nextLine()));
            switch (selec) {
                case 1:
                    //verificando se um veículo existe
                    car = car.verifica(veiculos);
                    if (cliente != null && patio != null && car != null) {
                        System.out.printf("Qtd. de diárias a serem adicionadas: ");
                        int novaDiaria = (Integer.parseInt(in.nextLine()));
                        for (int i = 0; i < contas.size(); i++) {
                            if (cliente.getCodigo().equals(contas.get(i).getCliente().getCodigo()) && car.getPlaca().equals(contas.get(i).getVeiculo().getPlaca()) && patio.getNome().equals(contas.get(i).getPatio().getNome())) {
                                contas.get(i).setPaga(false);
                                contas.get(i).setMes(this.mes);
                                contas.get(i).setAno(this.ano);
                                contas.get(i).setTotalDiaria(this.totalDiaria += novaDiaria);
                                verifica = true;
                            }
                        }
                    }
                    break;
                case 2:
                    cam = cam.verifica(veiculos);
                    if (cliente != null && patio != null && cam != null) {
                        System.out.printf("Qtd. de diárias a serem adicionadas: ");
                        int novaDiaria = (Integer.parseInt(in.nextLine()));
                        for (int i = 0; i < contas.size(); i++) {
                            if (cliente.getCodigo().equals(contas.get(i).getCliente().getCodigo()) && cam.getPlaca().equals(contas.get(i).getVeiculo().getPlaca()) && patio.getNome().equals(contas.get(i).getPatio().getNome())) {
                                contas.get(i).setPaga(false);
                                contas.get(i).setMes(this.mes);
                                contas.get(i).setAno(this.ano);
                                contas.get(i).setTotalDiaria(this.totalDiaria + novaDiaria);
                                verifica = true;
                            }
                        }
                    }
                    break;
                default:
                    System.out.println("\nOpção inválida, tente novamente.");
            }
            if (!verifica) {
                System.out.println("\nNão foi possível localizar conta.");
            }
        } else {
            System.out.println("\nNão há contas cadastradas.");
        }

    }

    public double totalAPagarCam(int totalDiarias) {
        return this.patio.getDiariaCam() * totalDiarias;
    }

    public double totalAPagarCar(int totalDiarias) {
        return this.patio.getDiariaCar() * totalDiarias;
    }

    /*
    alteraSituacao é usado para alternar entre paga e pendente as contas de cada mes, 
    esse metodo permite ao usuário ter mais controle 
    da abertura e fechamento da fatura.*/
    public void alteraSituacao(ArrayList<Conta> contas, ArrayList<Cliente> clientes, ArrayList<Patio> patios, ArrayList<Veiculo> veiculos, Cliente cliente, Patio patio, Caminhao cam, Carro car) {
        Scanner in = new Scanner(System.in);
        if (!contas.isEmpty()) {
            boolean verifica = false;
            cliente = cliente.verifica(clientes);
            patio = patio.verifica(patios);
            System.out.println("Qual categoria deseja acessar");
            Menus.subVeiculos();
            int selec = (Integer.parseInt(in.nextLine()));
            switch (selec) {
                case 1://verificar carro para alterar situação da fatura 
                    car = car.verifica(veiculos);
                    if (cliente != null && patio != null && car != null) {
                        System.out.println("\nDigite");
                        System.out.println("1. Abrir fatura");
                        System.out.println("2. Fechar fatura");
                        System.out.println("3. Fechar fatura e zerar valores");
                        System.out.printf("Deseja fechar ou abrir uma fatura:");
                        selec = (Integer.parseInt(in.nextLine()));
                        switch (selec) {
                            case 1://abrir fatura independente do valor para o CARRO
                                for (int i = 0; i < contas.size(); i++) {
                                    if (cliente.getCodigo().equals(contas.get(i).getCliente().getCodigo()) && car.getPlaca().equals(contas.get(i).getVeiculo().getPlaca()) && patio.getNome().equals(contas.get(i).getPatio().getNome())) {
                                        contas.get(i).paga = true;
                                        System.out.println("\nFatura aberta com sucesso");
                                        verifica = true;
                                    }
                                }
                                break;
                            case 2://fechar fatura e NÃO zerar valores para o CARRO
                                for (int i = 0; i < contas.size(); i++) {
                                    if (cliente.getCodigo().equals(contas.get(i).getCliente().getCodigo()) && car.getPlaca().equals(contas.get(i).getVeiculo().getPlaca()) && patio.getNome().equals(contas.get(i).getPatio().getNome())) {
                                        contas.get(i).paga = false;
                                        System.out.println("\nFatura fechada com sucesso");
                                        verifica = true;
                                    }
                                }
                                break;
                            case 3://fechar fatura do carro e zerar valores do CARRO
                                for (int i = 0; i < contas.size(); i++) {
                                    if (cliente.getCodigo().equals(contas.get(i).getCliente().getCodigo()) && car.getPlaca().equals(contas.get(i).getVeiculo().getPlaca()) && patio.getNome().equals(contas.get(i).getPatio().getNome())) {
                                        contas.get(i).totalDiaria = 0;
                                        contas.get(i).situacao = "Fatura não foi aberta";
                                        System.out.println("\nFatura fechada e valores zerados com sucesso");
                                        verifica = true;
                                    }
                                }
                                break;
                            default:
                                System.out.println("\nOpção inválida, tente novamente.");
                        }
                    }
                    break;

                case 2:
                    cam = cam.verifica(veiculos);
                    if (cliente != null && patio != null && cam != null) {
                        System.out.println("\nDigite");
                        System.out.println("1. Abrir fatura");
                        System.out.println("2. Fechar fatura");
                        System.out.println("3. Fechar e zerar valores");
                        System.out.printf("Deseja fechar ou abrir uma fatura:");
                        selec = (Integer.parseInt(in.nextLine()));
                        switch (selec) {
                            case 1://abrir fatura independente do valor para o CAMINHÃO
                                for (int i = 0; i < contas.size(); i++) {
                                    if (cliente.getCodigo().equals(contas.get(i).getCliente().getCodigo()) && cam.getPlaca().equals(contas.get(i).getVeiculo().getPlaca()) && patio.getNome().equals(contas.get(i).getPatio().getNome())) {
                                        contas.get(i).setPaga(false);
                                        System.out.println("\nFatura aberta com sucesso");
                                        verifica = true;
                                    }
                                }
                                break;
                            case 2://fechar fatura e NÃO zerar valores do CAMINHÃO
                                for (int i = 0; i < contas.size(); i++) {
                                    if (cliente.getCodigo().equals(contas.get(i).getCliente().getCodigo()) && cam.getPlaca().equals(contas.get(i).getVeiculo().getPlaca()) && patio.getNome().equals(contas.get(i).getPatio().getNome())) {
                                        contas.get(i).setPaga(true);
                                        System.out.println("\nFatura fechada com sucesso");
                                        verifica = true;
                                    }
                                }

                                break;
                            case 3://fechar fatura e NÃO zerar valores do CAMINHÃO
                                for (int i = 0; i < contas.size(); i++) {
                                    if (cliente.getCodigo().equals(contas.get(i).getCliente().getCodigo()) && cam.getPlaca().equals(contas.get(i).getVeiculo().getPlaca()) && patio.getNome().equals(contas.get(i).getPatio().getNome())) {
                                        contas.get(i).totalDiaria = 0;
                                        contas.get(i).situacao = "Fatura ainda não foi aberta";
                                        System.out.println("\nFatura fechada e valores zerados com sucesso");
                                        verifica = true;
                                    }
                                }
                                break;
                            default:
                                System.out.println("\nOpção inválida, tente novamente.");
                        }
                    }
                    break;
                default:
                    System.out.println("\nOpção inválida, tente novamente.");
            }

            if (!verifica) {
                System.out.println("\nNão foi possível localizar conta.");
            }
        } else {
            System.out.println("\nNão há contas cadastradas.");
        }
    }
    
    /*as exclusões de conta servem para excluir a conta de um cliente que já não usa mais 
    o pátio. O usuário deve preencher os dados do cliente, pátio e respectivo veículo, 
    depois disso será verificada a existencia de uma conta e então ela será excluida e a sua vaga no estacionamento será 
    liberada.
    */
    public void excluiConta(ArrayList<Conta> contas, ArrayList<Cliente> clientes, ArrayList<Patio> patios, ArrayList<Veiculo> veiculos, Cliente cli, Patio pa, Carro car) {
        Scanner in = new Scanner(System.in);
        System.out.println();
        //verificando se um cliente existe
        cli = cli.verifica(clientes);
        //verificando se um pátio existe 
        pa = pa.verifica(patios);
        //verificando se um veículo existe
        car = car.verifica(veiculos);
        if (cli != null && pa != null && car != null) {
            Conta conta = Conta.verificaConta(cli, car, pa, contas, this.totalDiaria);
            if (conta != null) {
                contas.remove(conta);
                pa.liberaVaga();
                System.out.println("\nConta excluida com sucesso!");

            } else {
                System.out.println("\nErro no cadastro dos dados iniciais da conta. Verifique os dados informados.");
            }

        }
    }
    public void excluiConta(ArrayList<Conta> contas, ArrayList<Cliente> clientes, ArrayList<Patio> patios, ArrayList<Veiculo> veiculos, Cliente cli, Patio pa, Caminhao cam) {
        Scanner in = new Scanner(System.in);
        System.out.println();
        //verificando se um cliente existe
        cli = cli.verifica(clientes);
        //verificando se um pátio existe 
        pa = pa.verifica(patios);
        //verificando se um veículo existe
        cam = cam.verifica(veiculos);
        if (cli != null && pa != null && cam != null) {
            Conta conta = Conta.verificaConta(cli, cam, pa, contas, this.totalDiaria);
            if (conta != null) {
                contas.remove(conta);
                pa.liberaVaga();
                System.out.println("\nConta excluida com sucesso!");

            } else {
                System.out.println("\nErro no cadastro dos dados iniciais da conta. Verifique os dados informados.");
            }

        }
    }
    

    public void imprimeUm(ArrayList<Conta> contas, ArrayList<Cliente> clientes, ArrayList<Patio> patios, ArrayList<Veiculo> veiculos, Cliente cli, Patio pa, Caminhao cam, Carro car) {
        Scanner in = new Scanner(System.in);
        System.out.println();
        //verificando se existe um cliente
        cli = cli.verifica(clientes);
        //verificando se existe um pátio
        pa = pa.verifica(patios);
        System.out.println("Qual categoria deseja acessar:");
        Menus.subVeiculos();
        int selec = (Integer.parseInt(in.nextLine()));
        switch (selec) {
            case 1:
                car = car.verifica(veiculos);
                if (cli != null && pa != null && car != null) {
                    for (int i = 0; i < contas.size(); i++) {
                        if (cli.getCodigo().equals(contas.get(i).getCliente().getCodigo()) && car.getPlaca().equals(contas.get(i).getVeiculo().getPlaca()) && pa.getNome().equals(contas.get(i).getPatio().getNome())) {
                            contas.get(i).faturaCompleta(car);
                        }
                    }
                } else {
                    System.out.println("\nNão existe conta cadastrada para os dados informados.");
                }
                break;
            case 2:
                cam = cam.verifica(veiculos);
                if (cli != null && pa != null && cam != null) {
                    for (int i = 0; i < contas.size(); i++) {
                        if (cli.getCodigo().equals(contas.get(i).getCliente().getCodigo()) && cam.getPlaca().equals(contas.get(i).getVeiculo().getPlaca()) && pa.getNome().equals(contas.get(i).getPatio().getNome())) {
                            contas.get(i).faturaCompleta(cam);
                        }
                    }
                } else {
                    System.out.println("\nNão existe conta cadastrada para os dados informados.");
                }
                break;
            default:
                System.out.println("\nOpção inválida, tente novamente.");
        }

    }
    /*A fatura completa é acessada com os dados específicos do cliente */
    public void faturaCompleta(Veiculo veiculo) {

        System.out.println("========================\nFATURA DETALHADA\n========================\n");
        System.out.println("========================\nDADOS DO CLIENTE\n========================");
        this.cliente.imprimir();
        System.out.println("========================\nDADOS DO PÁTIO\n========================");
        this.patio.imprimir();
        System.out.println("========================\nDADOS DO VEÍCULO\n========================");
        this.veiculo.imprimir();
        System.out.println("========================\nDADOS DA FATURA\n========================");
        System.out.println("Data de entrada mm/aaaa: " + this.mes + "/" + this.ano);
        if (veiculo instanceof Carro) {
            System.out.println("Tipo de Veículo: Carro");
            System.out.println("Total da fatura: R$" + this.totalAPagarCar(totalDiaria));
        } else if (veiculo instanceof Caminhao) {
            System.out.println("Tipo de Veículo: Caminhão");
            System.out.println("Total da fatura: R$" + this.totalAPagarCam(totalDiaria));
        }
        System.out.println("Situação da Conta: " + this.diariaPaga());
        System.out.println("=====================================================================================================================");
        System.out.println();

    }

    /*o resumo da fatura é exibido no relatório de todasa s faturas, ele contem as pricipais informações dos ususários
    como, códigos e placa. Serve para ter uma base de busca e também verificar se existe uma conta cadastrada para os dados informados
    ou ainda saber os códigos e placa dos itens pesquisados para exibir informações mais completas.*/
    public void resumoFatura(Carro car, Caminhao cam) {
        System.out.println("========================\nRESUMO DA FATURA\n========================");
        System.out.println("Nome do cliente: " + this.cliente.getNome());
        System.out.println("Código do cliente: " + this.cliente.getCodigo());
        System.out.println("Patio em uso: " + this.patio.getNome());
        System.out.println("Código do pátio: " + this.patio.getCodigo());
        System.out.println("Placa do veículo: " + this.veiculo.getPlaca());
        if (veiculo instanceof Carro) {
            System.out.println("Categoria do Veículo: Carro");
            System.out.println("Total da fatura: R$" + this.totalAPagarCar(totalDiaria));
        } else if (veiculo instanceof Caminhao) {
            System.out.println("Categoria do Veículo: Caminhão");
            System.out.println("Total da fatura: R$" + this.totalAPagarCam(totalDiaria));
        }
        System.out.println("Situação da Conta: " + this.diariaPaga());
        System.out.println("=====================================================================================================================");
        System.out.println();

    }
}
