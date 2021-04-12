package Automato;

public class AutomatoDeterministico implements IAutomato {

	private final String alfabeto;
	private final String palavra;
	private final char[] arraySimbolos;
	private String contemSequencia;
	private boolean aceita;
	
	private Transicao[][] transicoes;
	
	public AutomatoDeterministico(String alfabeto, String palavra, String contemSequencia, boolean aceita) {
		this.alfabeto = alfabeto;
		this.palavra = palavra;
		this.contemSequencia = contemSequencia;
		this.aceita = aceita;
		
		this.arraySimbolos = this.palavra.toCharArray();
	}
	
	@Override
	public boolean VerificaPalavra() {
		
		int i = 0;
		int j = 0;
		
		Transicao ondeLeituraEsta = null;

		while (i != arraySimbolos.length) {
			
			var simbolo = arraySimbolos[i];
			
			var transicao = transicoes[j][0];
			var transicao2 = transicoes[j][1];
			
			var permaneceNoMesmoEstado = transicao.getEstado().equals(transicao.getEstado2());
				
			if (transicao.getSimbolo() == simbolo) {
				ondeLeituraEsta = transicao;
				if (!permaneceNoMesmoEstado) {
					j++;
				} 
			} else if (transicao2.getSimbolo() == simbolo) {
				ondeLeituraEsta = transicao2;
			}
			
			i++;
		}
		return ondeLeituraEsta.isFinal();
	}
	

	public Transicao[][] getTransicoes() {
		return transicoes;
	}
	public void setTransicoes(Transicao[][] vetor) {
		this.transicoes = vetor;
	}

}
