/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import Excecoes.AlteraVeiculo;
import Excecoes.DadosIncompletos;
import java.util.*;
import otherClass.*;

public class Principal {

    public static void cadastroAutomatico(ArrayList clientes, ArrayList<Conta> contas, ArrayList<Patio> patios, ArrayList<Veiculo> veiculos) {
        //criando clientes
        Cliente cli01 = new Cliente("123P", "Lucas Lima", new Endereco("Rua Gaviota", 35, "Monte Azul", "Belo Horizonte", "MG", "31872-520", "(31)3436-5529"));
        clientes.add(cli01);
        Cliente cli02 = new Cliente("234P", "Eliana Souza", new Endereco("Rua Gertrudes", 85, "Monte Belo", "Belo Horizonte", "MG", "31872-752", "(31)3333-8888"));
        clientes.add(cli02);
        //criando carros
        Carro car01 = new Carro(5, 4, "Fiat", "Siena", 2019, 2018, "J0I8L7765", "bbb0001");
        veiculos.add(car01);
        Carro car02 = new Carro(5, 4, "Honda", "HB-20", 2019, 2020, "L9L7U4DD1", "aaa0002");
        veiculos.add(car02);
        //criando caminhão
        Caminhao cam01 = new Caminhao(2, 3, "Scania", "F-10800", 2019, 2019, "VVI78K0", "ccc0003");
        veiculos.add(cam01);
        Caminhao cam02 = new Caminhao(2, 2, "Scania", "D-1010", 2006, 2007, "VVIO8J678K0", "ddd0004");
        veiculos.add(cam02);
        //criando pátios
        Patio patio01 = new Patio("Pátio 1", "123PT", 15.50, 25.50, 100, 98, new Endereco("Rua Lavras", 42, "Funcionários", "Belo Horizonte", "MG", "31852-960", "(31) 98888-5252"));
        patios.add(patio01);
        Patio patio02 = new Patio("Pátio 2", "234PT", 50.00, 90.00, 15, 13, new Endereco("Av. Rio manso", 42, "Gaviotas", "Vale do Mucurí", "MG", "48852-960", "(32) 96693-3586"));
        patios.add(patio02);
        Patio patio03 = new Patio("Pátio 3", "456PT", 40.00, 55.00, 10, 8, new Endereco("Rua arruda", 42, "Bom Jesus", "Matozinhos", "MG", "31205-642", "(31) 3222-6978"));
        patios.add(patio03);
        //criando contas com carro
        /*Para informação: os booleanos nos objetos contas referem-se à situação da conta
        quando o booleando estiver como "true" quer dizer que a conta consta como paga, mas seus valores ainda não foram zerados
        caso esteja como "false" que dizer que a conta está aberta esperando para ser paga.*/
 /*Conta conta01 = new Conta(cli01, patio01, car01, 1, 2018, 2, false);
        contas.add(conta01);*/
        Conta conta02 = new Conta(cli01, patio02, car01, 2, 2018, 3, true);
        contas.add(conta02);
        Conta conta03 = new Conta(cli01, patio03, car01, 3, 2018, 4, false);
        contas.add(conta03);
        Conta conta04 = new Conta(cli01, patio01, cam01, 4, 2018, 10, true);
        contas.add(conta04);
        Conta conta05 = new Conta(cli01, patio02, cam02, 5, 2018, 5, false);
        contas.add(conta05);
        Conta conta06 = new Conta(cli01, patio03, cam02, 6, 2018, 5, true);
        contas.add(conta06);
        //criando contas com caminhão
        Conta conta07 = new Conta(cli02, patio01, car01, 1, 2018, 2, true);
        contas.add(conta07);
        Conta conta08 = new Conta(cli02, patio02, car01, 2, 2019, 3, false);
        contas.add(conta08);
        Conta conta09 = new Conta(cli02, patio03, car01, 3, 2019, 4, true);
        contas.add(conta09);
        Conta conta10 = new Conta(cli02, patio01, cam01, 4, 2019, 10, false);
        contas.add(conta10);
        Conta conta11 = new Conta(cli02, patio02, cam02, 5, 2019, 5, true);
        contas.add(conta11);
        Conta conta12 = new Conta(cli02, patio03, cam02, 6, 2019, 5, false);
        contas.add(conta12);

    }

    public static void main(String[] args) throws DadosIncompletos, AlteraVeiculo {
        //instanciação dos ArrayList necessários
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        ArrayList<Conta> contas = new ArrayList<Conta>();
        ArrayList<Patio> patios = new ArrayList<Patio>();
        ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
        //váriaveis usadas para fazer buscas
        String nome;
        //variável de seleção
        int selec;
        //verificação do vetor
        boolean verifica;
        //objetos criados para busca, alteração e chamada de métodos
        Cliente cliente = new Cliente();
        Patio patio = new Patio();
        Caminhao caminhao = new Caminhao();
        Carro carro = new Carro();
        Conta conta = new Conta();
        Scanner in = new Scanner(System.in);
        //variáveis para controlar menu principal e submenus
        boolean menu_Inicial = true, sub_Menu = true;
        int menuInicial, subMenu;

        while (menu_Inicial != false) {
            /*esse try é para todos os menus, caso seja digitado algo diferente de um numero*/
            try {
                Menus.menuPrincipal();
                menuInicial = (Integer.parseInt(in.nextLine()));
                while (sub_Menu != false) {
                    switch (menuInicial) {
                        case 1://CLIENTE
                            try {
                                Menus.menuCliente();
                                subMenu = (Integer.parseInt(in.nextLine()));
                                /*EXIBINDO MENU INTERNO PARA CADASTRO DE NOVO CLIENTE */
                                switch (subMenu) {
                                    case 1://cadastrar cliente
                                        System.out.printf("Deseja realmente cadastrar um cliente? S-1 / Ñ-2: ");
                                        selec = (Integer.parseInt(in.nextLine()));
                                        switch (selec) {
                                            case 1:
                                                try {
                                                    cliente.cadastra(clientes);
                                                } catch (DadosIncompletos e) {
                                                    System.out.println("\nCampos não preenchidos, preencha todos os campos. Cliente não pode ser criado.");
                                                } catch (NumberFormatException e) {
                                                    System.out.println("\nInsira um valor válido no campo número. Cliente não pode ser criado.");
                                                }
                                                break;
                                            case 2:
                                                System.out.println("\nOperação cancelada");
                                                break;
                                        }

                                        break;

                                    case 2://altera dados do cliente
                                        if (!clientes.isEmpty()) {
                                            cliente = cliente.verifica(clientes);
                                            if (cliente != null) {
                                                Menus.subMenuCliente();
                                                selec = (Integer.parseInt(in.nextLine()));
                                                try {
                                                    switch (selec) {
                                                        case 1://alterar nome
                                                            System.out.printf("\nDigite o novo nome: ");
                                                            nome = in.nextLine();
                                                            cliente.setNome(nome);
                                                            System.out.println("\nAlterado com sucesso!");
                                                            break;
                                                        case 2://alterar logradouro
                                                            System.out.printf("Digite o novo logradouro: ");
                                                            cliente.getEndereco().setRua(in.nextLine());
                                                            System.out.println("\nAlterado com sucesso!");
                                                            break;
                                                        case 3://alterar número
                                                            System.out.printf("Digite o novo número: ");
                                                            cliente.getEndereco().setNumero((Integer.parseInt(in.nextLine())));
                                                            //this.endereco.setNumero(numero);
                                                            System.out.println("\nAlterado com sucesso!");
                                                            break;
                                                        case 4://alterar bairro
                                                            System.out.printf("Digite o novo bairro: ");
                                                            cliente.getEndereco().setBairro(in.nextLine());
                                                            System.out.println("\nAlterado com sucesso!");
                                                            break;
                                                        case 5://alterar município
                                                            System.out.printf("Digite o novo município: ");
                                                            cliente.getEndereco().setMunicipio(in.nextLine());
                                                            System.out.println("\nAlterado com sucesso!");
                                                            break;
                                                        case 6://alterar estado
                                                            System.out.printf("Digite o novo estado: ");
                                                            cliente.getEndereco().setEstado(in.nextLine());
                                                            System.out.println("\nAlterado com sucesso!");
                                                            break;
                                                        case 7://alterar cep
                                                            System.out.printf("Digite o novo cep: ");
                                                            cliente.getEndereco().setCep(in.nextLine());
                                                            System.out.println("\nAlterado com sucesso!");
                                                            break;
                                                        case 8://alterar telefone
                                                            System.out.printf("Digite o novo telefone: ");
                                                            cliente.getEndereco().setTelefone(in.nextLine());
                                                            System.out.println("\nAlterado com sucesso!");
                                                            break;
                                                        case 9://voltar ao menu principal
                                                            break;
                                                        default://mensagem de erro
                                                            System.out.println("\nOpção inválida, tente novamente!");
                                                    }
                                                } catch (NumberFormatException e) {
                                                    System.out.println("\nPor favor, digite um número válido.");
                                                }
                                            } else {
                                                System.out.println("\nCliente não encontrado.");
                                                cliente = new Cliente();
                                            }
                                        } else {
                                            System.out.println("\nNão há clientes cadastrados.");
                                        }
                                        break;
                                    case 3://excluir dados do  cliente (um único cliente)
                                        cliente.exclui(clientes);
                                        break;
                                    case 4://consultar cadastro (um único cliente)
                                        cliente.imprimeUm(clientes);
                                        break;
                                    case 5://relatório (todos os clientes)
                                        verifica = clientes.isEmpty();
                                        if (!verifica) {
                                            for (int i = 0; i < clientes.size(); i++) {
                                                clientes.get(i).imprimir();
                                            }
                                        } else {
                                            System.out.println("\nNão há clientes cadastrados.");
                                        }
                                        break;
                                    case 6://voltar a o menu principal
                                        sub_Menu = false;
                                        break;
                                    default://mensagem de erro
                                        System.out.println("\nOpção inválida, tente novamente!");

                                }
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("\nErro de leitura do menu. Por favor digite um número.");
                            }
                        case 2://PATIO
                            /*há tratamento de tratamento de exceção no cadastrar patio, não é permitido ao usuário
                            cadastrar um pátio com pampos vazios*/
                            Menus.menuPatio();
                            subMenu = (Integer.parseInt(in.nextLine()));
                            try {
                                switch (subMenu) {
                                    case 1://cadastrar pátio
                                        System.out.printf("Deseja realmente cadastrar um cliente? S-1 / Ñ-2: ");
                                        selec = (Integer.parseInt(in.nextLine()));
                                        switch (selec) {
                                            case 1:
                                                try {
                                                    patio.cadastra(patios);
                                                } catch (DadosIncompletos e) {
                                                    System.out.println("\nCampos não preenchidos, preencha todos os campos. Pátio não pode ser criado.");
                                                } catch (NumberFormatException e) {
                                                    System.out.println("\nPor favor, digite valores válidos nos campos numéricos. Pátio não pode ser criado.");
                                                }
                                                break;
                                            case 2:
                                                System.out.println("\nOperação cancelada");
                                                break;
                                        }

                                        break;
                                    case 2://alterar dados do pátio
                                        /*não há tratamento de exceção aqui.*/
                                        if (!patios.isEmpty()) {
                                            patio = patio.verifica(patios);
                                            if (patio != null) {
                                                Menus.subMenuPatio();
                                                selec = (Integer.parseInt(in.nextLine()));

                                                switch (selec) {
                                                    case 1://alterar nome
                                                        System.out.printf("\nDigite o novo nome: ");
                                                        patio.setNome(in.nextLine());
                                                        System.out.println("\nAlterado com sucesso!");
                                                        break;
                                                    case 2://alterar logradouro
                                                        System.out.printf("Digite o novo logradouro: ");
                                                        patio.getEndereco().setRua(in.nextLine());
                                                        System.out.println("\nAlterado com sucesso!");
                                                        break;
                                                    case 3://alterar número
                                                        System.out.printf("Digite o novo número: ");
                                                        patio.getEndereco().setNumero((Integer.parseInt(in.nextLine())));
                                                        System.out.println("\nAlterado com sucesso!");
                                                        break;
                                                    case 4://alterar bairro
                                                        System.out.printf("Digite o novo bairro: ");
                                                        patio.getEndereco().setBairro(in.nextLine());
                                                        System.out.println("\nAlterado com sucesso!");
                                                        break;
                                                    case 5://alterar município
                                                        System.out.printf("Digite o novo município: ");
                                                        patio.getEndereco().setMunicipio(in.nextLine());
                                                        System.out.println("\nAlterado com sucesso!");
                                                        break;
                                                    case 6://alterar estado
                                                        System.out.printf("Digite o novo estado: ");
                                                        patio.getEndereco().setEstado(in.nextLine());
                                                        System.out.println("\nAlterado com sucesso!");
                                                        break;
                                                    case 7://alterar cep
                                                        System.out.printf("Digite o novo cep: ");
                                                        patio.getEndereco().setCep(in.nextLine());
                                                        System.out.println("\nAlterado com sucesso!");
                                                        break;
                                                    case 8://alterar telefone
                                                        System.out.printf("Digite o novo telefone: ");
                                                        patio.getEndereco().setTelefone(in.nextLine());
                                                        System.out.println("\nAlterado com sucesso!");
                                                        break;
                                                    case 9://alterar capacidade de veiculos
                                                        System.out.printf("Digite a nova capacidade: ");
                                                        patio.setCapacidade((Integer.parseInt(in.nextLine())));
                                                        System.out.println("\nAlterado com sucesso!");
                                                        break;
                                                    case 10://alterar capacidade de veiculos
                                                        System.out.printf("Digite a quantidade de vagas disponíveis: ");
                                                        patio.setVagaDisponivel((Integer.parseInt(in.nextLine())));
                                                        System.out.println("\nAlterado com sucesso!");
                                                        break;
                                                    case 11://alterar valor da diaria para carros
                                                        System.out.printf("Digite o novo valor da diária para carros: ");
                                                        patio.setDiariaCar((Double.parseDouble(in.nextLine())));
                                                        System.out.println("\nAlterado com sucesso!");
                                                        break;
                                                    case 12://alterar valor da diaria para cmainhões
                                                        System.out.printf("Digite o novo valor da diária para caminhão: ");
                                                        patio.setDiariaCar((Double.parseDouble(in.nextLine())));
                                                        System.out.println("\nAlterado com sucesso!");
                                                        break;
                                                    case 13://voltar ao menu principal
                                                        break;
                                                    default://mensagem de erro
                                                        System.out.println("\nOpção inválida, tente novamente!");
                                                }
                                            } else {
                                                patio = new Patio();
                                            }
                                        } else {
                                            System.out.println("\nNão existem pátios cadastrados.\n");
                                        }
                                        break;

                                    case 3://excluir dados do  patio
                                        patio.exclui(patios);
                                        break;
                                    case 4://consultar cadastro (um único patio)
                                        patio.imprimeUm(patios);
                                        break;
                                    case 5://relatório (todos os patios)
                                        verifica = patios.isEmpty();
                                        if (!verifica) {
                                            for (int i = 0; i < patios.size(); i++) {
                                                patios.get(i).imprimir();
                                            }
                                        } else {
                                            System.out.println("\nNão existem pátios cadastrados.\n");
                                        }
                                        break;
                                    case 6://voltar ao menu principal
                                        sub_Menu = false;
                                        break;
                                    default://mensagem de erro
                                        System.out.println("\nOpção inválida, tente novamente!");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("\nErro de leitura do menu. Por favor digite um número.");
                            }
                            break;

                        case 3: //VEICULO
                            /*na seção do veículo foram tratadas exceções que podem ser causadas pelo usuário
                            que podem ser o não preenchimento de dados causando um preenchimento vazio (por serem strings).
                            Para isso foram criadas lançadas exceções dentro da classe veículo e tratadas aqui no menu inicial.
                             */
                            Menus.menuVeiculo();
                            selec = (Integer.parseInt(in.nextLine()));
                            try {
                                switch (selec) {
                                    case 1://cadastrar veiculo
                                        Menus.subVeiculos();
                                        selec = (Integer.parseInt(in.nextLine()));
                                        switch (selec) {
                                            case 1://cadastrar carro
                                                System.out.printf("Deseja realmente cadastrar um Carro? S-1 / Ñ-2: ");
                                                selec = (Integer.parseInt(in.nextLine()));
                                                switch (selec) {
                                                    case 1://caso queira realmente cadastrar o carro
                                                        try {
                                                            carro.cadastraCarro(veiculos);
                                                        } catch (DadosIncompletos e) {
                                                            System.out.println("\nCampos não preenchidos, preencha todos os campos. Carro não pode ser criado.");
                                                        } catch (NumberFormatException e) {
                                                            System.out.println("\nPor favor, digite valores válidos nos campos numéricos. Carro não pode ser criado.");
                                                        }
                                                        break;
                                                    case 2://caso não queira cadastrar o carro
                                                        System.out.printf("Operação cancelada.");
                                                        break;
                                                    default:
                                                        System.out.println("\nOpção inválida, tente novamente!");
                                                }
                                                break;
                                            case 2://cadastrar caminhão
                                                System.out.printf("Deseja realmente cadastrar um caminhão? S-1 / Ñ-2: ");
                                                selec = (Integer.parseInt(in.nextLine()));
                                                switch (selec) {
                                                    case 1://caso queira realmente cadastrar o caminhão
                                                        try {
                                                            caminhao.cadastraCam(veiculos);
                                                        } catch (DadosIncompletos e) {
                                                            System.out.println("\nCampos não preenchidos, preencha todos os campos. Caminhão não pode ser criado.");
                                                        } catch (NumberFormatException e) {
                                                            System.out.println("\nPor favor, digite valores válidos nos campos numéricos. Caminhão não pode ser criado.");
                                                        }
                                                        break;
                                                    case 2://cancelar cadastramento do caminhão
                                                        System.out.printf("Operação cancelada.");
                                                        break;
                                                    default:
                                                        System.out.println("\nOpção inválida, tente novamente!");
                                                }
                                                break;
                                            case 3://voltar
                                                break;
                                            default:
                                                System.out.println("\nOpção inválida, tente novamente!");
                                        }
                                        break;
                                    case 2://alterar dados do veiculo
                                        Menus.subVeiculos();
                                        selec = (Integer.parseInt(in.nextLine()));
                                        switch (selec) {
                                            case 1://alterar dados do carro
                                                try {
                                                    carro.alteraDados(veiculos);
                                                } catch (AlteraVeiculo | NumberFormatException e) {
                                                    System.out.println("\nItem não preenchido corretamente, o item não pode ficar vazio. Valores não alterados.");
                                                }
                                                break;
                                            case 2://alterar dados do caminhão
                                                try {
                                                    caminhao.alteraDados(veiculos);
                                                } catch (AlteraVeiculo | NumberFormatException e) {
                                                    System.out.println("\nItem não preenchido corretamente, o item não pode ficar vazio. Valores não alterados.");
                                                }
                                                break;
                                            case 3://voltar
                                                break;
                                            default:
                                                System.out.println("\nOpção inválida, tente novamente.");
                                        }
                                        break;
                                    case 3://excluir veiculo
                                        Menus.subVeiculos();
                                        selec = (Integer.parseInt(in.nextLine()));
                                        switch (selec) {
                                            case 1://excluir carro
                                                carro.exclui(veiculos);
                                                break;
                                            case 2://excluir caminhão
                                                caminhao.exclui(veiculos);
                                                break;
                                            case 3://voltar ao submenu
                                                break;
                                            default:
                                                System.out.println("\nOpção inválida, tente novamente!");
                                        }
                                        break;
                                    case 4://consultar dados do veículo (um único veículo)
                                        Menus.subVeiculos();
                                        selec = (Integer.parseInt(in.nextLine()));
                                        switch (selec) {
                                            case 1://exibir dados de um carro
                                                carro.imprimeUm(veiculos);
                                                break;
                                            case 2://exibir dados de um caminhão
                                                caminhao.imprimeUm(veiculos);
                                                break;
                                            case 3://voltar
                                                break;
                                            default:
                                                System.out.println("\nOpção inválida, tente novamente!");
                                        }
                                        break;
                                    case 5: //relatório
                                        verifica = veiculos.isEmpty();
                                        if (!verifica) {
                                            Menus.subVeiculos();
                                            selec = (Integer.parseInt(in.nextLine()));
                                            switch (selec) {
                                                case 1://exibir todos os carros
                                                    carro.listarTodosOsCarros(veiculos);
                                                    break;
                                                case 2://exibir todos os caminhoes
                                                    caminhao.listarTodosCams(veiculos);
                                                    break;
                                                case 3://voltar
                                                    break;
                                                default:
                                                    System.out.println("\nOpção inválida, tente novamente!");
                                            }
                                        } else {
                                            System.out.println("\nNão há veículos cadastrados.");
                                        }
                                        break;
                                    case 6://voltar ao menu inicial
                                        sub_Menu = false;
                                        break;
                                    default:
                                        System.out.println("\nOpção inválida, tente novamente.");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("\nErro de leitura do menu. Por favor digite um número.");
                            }
                            break;

                        case 4://CONTA
                            Menus.menuConta();
                            selec = (Integer.parseInt(in.nextLine()));
                            try {
                                switch (selec) {
                                    case 1://cadastrar conta
                                        /*aqui pergunta se quer cadastrar uma conta na categoria de caminhões ou de carros*/
                                        System.out.println("\nDeseja criar uma conta em qual categoria?");
                                        Menus.subVeiculos();
                                        selec = (Integer.parseInt(in.nextLine()));
                                        switch (selec) {
                                            case 1://criar conta na categoria carro
                                                conta.criaConta(contas, clientes, patios, veiculos, cliente, patio, carro);
                                                break;
                                            case 2://criar conta na categoria caminhão
                                                conta.criaConta(contas, clientes, patios, veiculos, cliente, patio, caminhao);
                                                break;
                                            case 3://voltar
                                                break;
                                            default:
                                                System.out.println("\nOpção inválida, tente novamente.");

                                        }
                                        break;
                                    case 2://incluir diária
                                        conta.incluirDiaria(contas, clientes, patios, veiculos, cliente, patio, caminhao, carro);
                                        break;
                                    case 3://excluir diária
                                        conta.excluirDiaria(contas, clientes, patios, veiculos, cliente, patio, caminhao, carro);
                                        break;
                                    case 4://total a pagar
                                        conta.imprimeUm(contas, clientes, patios, veiculos, cliente, patio, caminhao, carro);
                                        break;
                                    case 5://alterar situação da fatura
                                        conta.alteraSituacao(contas, clientes, patios, veiculos, cliente, patio, caminhao, carro);
                                        break;
                                    case 6://relatórios (todas as faturas)
                                        if (!contas.isEmpty()) {
                                            for (int i = 0; i < contas.size(); i++) {
                                                contas.get(i).resumoFatura(carro, caminhao);
                                            }
                                        } else {
                                            System.out.println("\nNão há contas cadastradas");
                                        }
                                        break;
                                    case 7:
                                        System.out.println("\nDeseja excluir uma conta de qual categoria:");
                                        Menus.subVeiculos();
                                        selec = (Integer.parseInt(in.nextLine()));
                                        switch (selec) {
                                            case 1://excluir uma conta da caregoria carro
                                                conta.excluiConta(contas, clientes, patios, veiculos, cliente, patio, carro);
                                                break;
                                            case 2://excluir uma conta da categoria caminhão
                                                conta.excluiConta(contas, clientes, patios, veiculos, cliente, patio, caminhao);
                                                break;
                                            case 3://voltar
                                                break;
                                            default:
                                                System.out.println("\nOpção inválida, tente novamente.");

                                        }
                                        break;
                                    case 8:
                                        sub_Menu = false;
                                        break;
                                    default:
                                        System.out.println("\nOpção inválida, tente novamente.");

                                }
                            } catch (NumberFormatException e) {
                                System.out.println("\nErro de leitura do menu. Por favor digite um número.");
                            }
                            break;
                        case 5://teste
                            System.out.println("\nNOTA: Para níveis de teste estes objetos podem ser adicionados quanttas vezes quiser. "
                                    + "\nCUIDADO! a duplicidade de dados, principalmente os códigos de busca e placas não é recomendada.");
                            Principal.cadastroAutomatico(clientes, contas, patios, veiculos);
                            System.out.println("\nForam criados PARA FINS DE TESTE, 2 clientes, 3 pátios, 2 carros, 2 caminhões e 11 contas");
                            sub_Menu = false;
                            break;
                        case 6://sair do programa
                            System.exit(0);
                            break;
                        default://mensagem de erro
                            System.out.println("\nOpção inválida, tente novamente!");
                            sub_Menu = false;
                    }
                }
                sub_Menu = true;
            } catch (NumberFormatException e) {
                System.out.println("\nErro de leitura do menu. Por favor digite um número.");
                menu_Inicial = true;
            }
        }
    }
}
