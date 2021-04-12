package Principal;

import java.util.Scanner;

import Automato.AutomatoDeterministico;
import Automato.Transicao;

public class ConfiguracaoAutomato {
	
	static Scanner scan = new Scanner(System.in);
	
	public static String DefineAutomato(String alfabeto, String palavra, String contemSequencia, boolean aceita) {
		
		var automato = new AutomatoDeterministico(alfabeto, palavra, contemSequencia, aceita);
		
		automato.setTransicoes(DefinirTransicoes());

		if (automato.VerificaPalavra()) {
			return "Palavra aceita.";
		} else {
			return "Palavra n�o aceita.";
		}
		
	}
	
	private static Transicao[][] DefinirTransicoes() {
		
		System.out.print("Informe a quantidade de transi��es que o aut�mato possui: ");
		var qtdTransicoes = scan.nextInt();
		var ListaDeTransicao = new Transicao[qtdTransicoes][2];
		
		MostrarInformacao();
		
		int i = 0;

		do {
			if (i == 0) System.out.println("Este � o estado inicial, n�o precisa informar que � inicial");
			
			var posicao = i + 1;
			
			System.out.println("\n*lembre-se: 'estado, simbolo, estado'. Se for uma transic�o para um estado final, informe");
			System.out.print("Informe a primeira regra da " + posicao +"� " + "transicao: ");
 
			var transicao = scan.next();
			var arrayTransicao = transicao.split(","); //crio um array separado pelas virgulas para poder instanciar um objeto(Transicao)
			
			if (arrayTransicao.length == 3) {
				ListaDeTransicao[i][0] = new Transicao(arrayTransicao[0], arrayTransicao[1].charAt(0), arrayTransicao[2]);
			} else {
				// se � passado como final, esta informa��o fica no index 3;
				ListaDeTransicao[i][0] = new Transicao(arrayTransicao[0], arrayTransicao[1].charAt(0), arrayTransicao[2], arrayTransicao[3]);
			}
			
			System.out.print("Informe a segunda regra da " + posicao +"� " + "transicao: ");
			var transicao2 = scan.next();
			var arrayTransicao2 = transicao2.split(",");
			
			if (arrayTransicao2.length == 3) {
				ListaDeTransicao[i][1] = new Transicao(arrayTransicao2[0], arrayTransicao2[1].charAt(0), arrayTransicao2[2]);
			} else {
				// se � passado como final, esta informa��o fica no index 3;
				ListaDeTransicao[i][1] = new Transicao(arrayTransicao2[0], arrayTransicao2[1].charAt(0), arrayTransicao2[2], arrayTransicao2[3]);
			}
			
			
			i++;
			
		} while (i < qtdTransicoes);

		scan.close();
		return ListaDeTransicao;
		
	}
	
	private static void MostrarInformacao() {
		System.out.println("####### INFORMACAO INICIAL ######");
		System.out.println("*Informe da seguinte maneira as transi��es:\n"
						+ "*Exemplo com alfabeto 'ab'"
						+ "Informe o estado e a transi��o lendo um simbolo para outro estado,"
						+ " separado por virgula.\n*Veja o exemplo: q0,a,q1. "
						+ "Neste exemplo do estado 'q0' leu o simbolo 'a' e foi para 'q1'\n"
						+ "*Note que, se o estado for um estado final deve-se tamb�m informar.\n"
						+ "*Como por exemplo: q0,a,q1,final");
		System.out.println("#################################");
	}
	
	public static void main(String[] args) {
		
		System.out.print(DefineAutomato("ab", "aababb", "aa", true));
		
	}

}
