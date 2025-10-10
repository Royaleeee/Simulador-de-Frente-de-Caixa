
import java.util.Scanner;

public class FinalizarCompra {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int clienteCadastrado, cpf = 0, quantidade, codigoProduto, formaPagamento;
        double ps5 = 2999.99, xboxSeriesX = 1999.99, nintendoSwitch = 3999.99, total = 0.0, limiteCredito = 0.0, debito = 0.0, pix = debito, valorDinheiro = 0.0;

        while (true) { // Loop principal para verificar se o cliente é cadastrado
            System.out.println("Cliente tem cadastro na loja?");
            System.out.println("1 - Sim");
            System.out.println("2 - Não");
            clienteCadastrado = scan.nextInt();

            if (clienteCadastrado == 1) {
                System.out.println("Digite o CPF do cliente cadastrado:");
                cpf = scan.nextInt();
                limiteCredito = 20000.00;
                debito = 10000.00;
                

            } else if (clienteCadastrado == 2) {
                System.out.println("cliente Não cadastrado.");
                limiteCredito = 5000.00;
                debito = 8000.00;
                

            } else if (clienteCadastrado < 1 || clienteCadastrado > 2) {
                System.out.println("Opção inválida. Digite 1 para Sim ou 2 para Não.");
                continue; // Volta para perguntar novamente
                
            }

            System.out.println("Quantos produtos deseja passar? ");
            quantidade = scan.nextInt();

            for (int i = 0; i < quantidade; i++) { // Loop para ler todos os produtos
                codigoProduto = 0;

                while (codigoProduto < 1 || codigoProduto > 3) { // Loop até o usuário digitar um código válido
                    System.out.print("Digite o código do produto:");
                    codigoProduto = scan.nextInt();

                    switch (codigoProduto) { // Verifica o código do produto e adiciona ao total
                        case 1:
                            System.out.println("Produto selecionado: PS5 - R$ " + ps5);
                            total += ps5;
                            break;
                        case 2:
                            System.out.println("Produto selecionado: Xbox Series X - R$ " + xboxSeriesX);
                            total += xboxSeriesX;
                            break;
                        case 3:
                            System.out.println("Produto selecionado: Nintendo Switch - R$ " + nintendoSwitch);
                            total += nintendoSwitch;
                            break;
                        default:
                            System.out.println("Produto inválido.");
                    }

                }

            }

            System.out.println("O total da compra é: R$ " + total);

            while (true) {
                System.out.println("Selecione a forma de pagamento:");
                System.out.println("1 - Cartão de Crédito");
                System.out.println("2 - Cartão de Débito");
                System.out.println("3 - Pix");
                System.out.println("4 - Dinheiro");

                formaPagamento = scan.nextInt();

                if (formaPagamento < 1 || formaPagamento > 4) {
                    System.out.println("Opção inválida. Digite um número de 1 a 4.");
                    continue; // Volta para perguntar novamente
                }

                boolean compraAprovada = limiteCredito >= total || debito >= total || valorDinheiro >= total;
                boolean compraRecusada = limiteCredito < total || debito < total || valorDinheiro < total;

                if (formaPagamento == 1) {
                    System.out.println("Pagamento com Cartão de Crédito selecionado.");
                    System.out.println("Checando limite do cartão...");
                    if (compraAprovada) {
                        System.out.println("Compra aprovada! Obrigado por comprar conosco.");
                    } else {
                        System.out.println("Compra recusada. Limite de crédito insuficiente.");
                    }

                } else if (formaPagamento == 2) {
                    System.out.println("Pagamento com Cartão de Débito selecionado.");
                    System.out.println("Checando saldo para pagamento...");
                    if (compraAprovada) {
                        System.out.println("Compra aprovada! Obrigado por comprar conosco.");
                    } else {
                        System.out.println("Compra recusada. Saldo insuficiente.");
                    }

                } else if (formaPagamento == 3) {
                    System.out.println("Pagamento com Pix selecionado.");
                    System.out.println("Checando saldo para pagamento...");
                    if (compraAprovada) {
                        System.out.println("Compra aprovada! Obrigado por comprar conosco.");
                    } else {
                        System.out.println("Compra recusada. Saldo insuficiente.");
                    }

                } else if (formaPagamento == 4) {
                    System.out.println("Pagamento em Dinheiro selecionado.");
                    System.out.println("Aguardando pagamento...");

                    System.out.println("Digite o valor em dinheiro entregue pelo cliente:");
                    valorDinheiro = scan.nextDouble();

                    while (true) {
                        if (valorDinheiro >= total) {
                            System.out.println("Compra aprovada! Obrigado por comprar conosco.");
                            if (valorDinheiro > total) {
                                double troco = valorDinheiro - total;
                                System.out.printf("Troco: R$ %.2f%n", troco);
                            }
                            break;
                        } else {
                        System.out.println("Valor insuficiente");
                        return;
                            
                        }
                    }

                    break; // sai do loop de pagamento

                }

                scan.close();
                break; 

            }

            break; // sai do while principal
        }
    }
}
