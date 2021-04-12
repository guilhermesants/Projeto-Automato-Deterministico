package Automato;

public class Transicao {
	
	private String estado; 
	private char simbolo;
	private String estado2;
	private String Final;
	
	public Transicao(String estado, char simbolo, String estado2) {
		this.estado = estado;
		this.simbolo = simbolo;
		this.estado2 = estado2;
	}
	
	public Transicao(String estado, char simbolo, String estado2, String estadoFinal) {
		this(estado, simbolo, estado2);
		this.Final = estadoFinal;
	}

	public boolean isFinal() {
		if (Final != null) return true;
		return false;
	}

	public String getEstado() {
		return estado;
	}

	public String getEstado2() {
		return estado2;
	}

	public char getSimbolo() {
		return simbolo;
	}
	
}
