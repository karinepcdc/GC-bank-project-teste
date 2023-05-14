package front;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

import back.Banco;
import back.BancoServices;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean sair = false;
		Banco banco = new Banco();
		int numeroDaConta;
		boolean isValid = true;
		
		BancoServices bancoServices = new BancoServices(banco);
		int opcao;
		System.out.println("-------------Bem vindo ao banco GC---------------");	
		
		do {
		System.out.println("Por favor, digite a operação que deseja realizar:");
		System.out.println("1 - Criar conta");
		System.out.println("2 - Verificar saldo da conta");
		System.out.println("3 - Depositar valor");
		System.out.println("4 - Sacar valor");
		System.out.println("5 - Transferir valor");
		System.out.println("6 - Sair");
		
		
		opcao = sc.nextInt();
		
		switch(opcao) {	
		case 1:
			do {
				System.out.print("Por favor, digite o número da conta: ");
				numeroDaConta = sc.nextInt();
				System.out.println();
				isValid = bancoServices.criarConta(numeroDaConta);
				if(isValid) {
					System.out.println("Conta criada com sucesso!");
				}else {
					System.out.println("Número da conta já existe!!!");
				};
				
				
				
				
				
				
			}while(!isValid);

			
			break;
		case 2:
			//Aqui será chamado o serviço para verificar saldo da conta;
			break;
		case 3:
			//Aqui será chamado o serviço para depositar valor na conta;
			break;
		case 4:
			// Aqui será chamado o serviço para sacar valor da conta;
			Integer numeroConta = null;

			double valor = 0;
			try {
				boolean isInvalidNumber = true;
				do {
					System.out.println("Qual o número da conta?");
					try {
						numeroConta = sc.nextInt();
						isInvalidNumber = false;

					} catch (InputMismatchException e) {
						System.out.println("Erro: O número de conta deve ser um inteiro\n");
					}

				} while (isInvalidNumber);

				valor = 0;
				boolean isInvalidValue = true;
				do {
					System.out.println("Qual o valor deseja sacar?");

					try {
						valor = sc.nextDouble();
						isInvalidValue = false;

					} catch (InputMismatchException e) {
						System.out.println("Erro: O valor a ser sacado deve ser um número\n");

					}

				} while (isInvalidValue);

				if (bancoServices.debitar(numeroConta, valor)) {
					System.out.println("Operação realizada com sucesso!\n");
				} else {
					System.out.println("Conta não encontrada! Operação cancelada.\n");
				}

				break;

			} catch (Exception e) {
				System.out.println("Erro ao realizar operação, tente novamente.\n");
				break;
			}

		case 5:
			//Aqui será chamado o serviço para transferir valores entre contas;
			break;
		case 6:
			sair = true;
			break;
		default:
			sair = true;
		}
		
		System.out.println();
		}while(!sair);
		
		System.out.println("Obrigado por utilizar nossos serviços! Tenha um ótimo dia.");
		
		
		
		sc.close();
	}

}
