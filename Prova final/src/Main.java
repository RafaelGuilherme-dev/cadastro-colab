import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanText = new Scanner(System.in);
		Scanner scanNum = new Scanner(System.in);

		System.out.println("Ssitema de Cadastro de Colaboradores");
		System.out.println("");

		String nome, cpf, dataNasc, dataAdmissao, status;
		int escolha, posi, salario; 
		int estadoInf;
		Lista tempList = new Lista();
		Colaborador colaborador = null;
		boolean continuar = true;

		while (continuar) {
			System.out.println("-------------------------------------------");
			System.out.println("Escolha oque deseja realizar");
			System.out.println("1 - Cadastrar Colaborador");
			System.out.println("2 - Alterar Colaborador");
			System.out.println("3 - Deletar Colaborador");
			System.out.println("4 - Listar todos os Colaborador cadastrados");
			System.out.println("5 - Atualizar salario de todos os Colaborador");
			System.out.println("6 - Listar pagamento líquido de todos os Colaboradores");
			System.out.println("7 - Sair do sistema");
			System.out.println("-------------------------------------------");
			escolha = scanNum.nextInt();

			switch (escolha) {

			case 1:
				System.out.println("-------------------------------------------");
				System.out.println("Digite as Informações Necessarias");
				System.out.println("-------------------------------------------");


				System.out.println("Digite o nome do Colaborador: ");
				nome = scanText.nextLine();
				System.out.println("");

				System.out.println("Digite o CPF do Colaborador: ");
				cpf = scanText.nextLine();
				System.out.println("");
				
				if (Calculadora.validarCpf(cpf)) {
					System.out.println("CPF Valido");
				}else {
					System.out.println("CPF Invalido");
					break;
				}
					
				System.out.println("Digite a data de nascimento do Colaborador: (dd/mm/aaaa)");
				dataNasc = scanText.nextLine();
				System.out.println("");

				System.out.println("Digite a data de Admissao");
				dataAdmissao = scanText.nextLine();
				System.out.println("");

				System.out.println("Digite o salario do Colaborador");
				salario = scanNum.nextInt();
				
				System.out.println("O Colaborador esta Ativo ou Inativo?");
				System.out.println("Digite 0  para Inativo");
				System.out.println("Digite 1  para Ativo");
				estadoInf = scanNum.nextInt();
				
				if (estadoInf == 1) {
					colaborador = new Colaborador(nome, cpf, dataNasc, dataAdmissao, salario, Status.ATIVO);
				}else {
					colaborador = new Colaborador(nome, cpf, dataNasc, dataAdmissao, salario, Status.INATIVO);
				}
				
				tempList.adicionar(colaborador);
				System.out.println(colaborador);
				System.out.println(colaborador.getDtRegistro());

				System.out.println("");

				System.out.println("-------------------------------------------");

				System.out.println("");

				break;

			case 2:
				System.out.println("Digite o nome do Colaborador: ");
				nome = scanText.nextLine();
				System.out.println("");

				System.out.println("Digite o CPF do Colaborador: ");
				cpf = scanText.nextLine();
				System.out.println("");

				System.out.println(" Digite a data de nascimento do Colaborador: (dd/mm/aaaa)");
				dataNasc = scanText.nextLine();
				System.out.println("");

				System.out.println(" Digite a data de admissao ");
				dataAdmissao = scanText.nextLine();
				System.out.println("");

				System.out.println(" Digite o salario do Colaborador ");
				salario = scanNum.nextInt();

				System.out.println("O Colaborador esta ativo ou inativo?");
				System.out.println("Digite 0  para inativo");
				System.out.println("Digite 1  para ativo");
				estadoInf = scanNum.nextInt();
				
				if (estadoInf == 1) {
					colaborador = new Colaborador(nome, cpf, dataNasc, dataAdmissao, salario, Status.ATIVO);
				}else {
					colaborador = new Colaborador(nome, cpf, dataNasc, dataAdmissao, salario, Status.INATIVO);
				}
				
				posi = tempList.localizarPosicao(nome);
				tempList.alterar(posi, colaborador);
				
				break;

			case 3:
				System.out.println("Para Excluir um Colaborador, por favor informe seu nome");
				nome = scanText.nextLine();
				posi = tempList.localizarPosicao(nome);
				tempList.excluir(posi);
				System.out.println("");
				System.out.println("-------------------------------------------");

				break;

			case 4:
				for (int x = 0; x < tempList.tamanho(); x++) {
					colaborador = tempList.buscarcolaborador(x);
					System.out.println(colaborador);
					System.out.println("-------------------------------------------");
					break;
				}

			case 5:
				for (int i = 0; i < tempList.tamanho(); i++) {
					colaborador = tempList.buscarcolaborador(i);
					double salar1 = Calculadora.novoSalario(colaborador);
					System.out.println(" Colaborador " + colaborador.getNome() + " Novo salario " + salar1);
				}
				break;

			case 6:
				for (int y = 0; y < tempList.tamanho(); y++) {
					colaborador = tempList.buscarcolaborador(y);
					double salar2 = Calculadora.impostoRenda(colaborador);
					System.out.println(" colaborador " + colaborador.getNome() + " Salario Liquido " + salar2);
				}
				break;
				
			case 7:
				continuar = false;
				break;
			default:
				System.out.println("--- Opção Invalida, tente novamente --- ");
				
			}
		}
	}
}
