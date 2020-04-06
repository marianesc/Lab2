package lab2;

public class Lazer {
	
	private String tipo;
	private int limite;
	private int somaTempo;
	private int numAtividades;
	private String saida;
	
	public Lazer(String tipo, int limite) {
		this.tipo = tipo;
		this.limite = limite;
		this.saida = "";
		this.numAtividades = 0;
		this.somaTempo = 0;
	}
	
	public Lazer(String tipo) {
		this.tipo = tipo;
		this.limite = 60;
		this.saida = "";
		this.numAtividades = 0;
		this.somaTempo = 0;
	}
	
	public void cadastraAtividade(String nome, int minutos) {
		this.somaTempo += minutos;
		this.numAtividades++;
		if (this.somaTempo <= this.limite && this.numAtividades <= this.limite) {
			if (this.saida.equals("")) this.saida += nome;
			else this.saida += ", " + nome;
		}
		else {
			this.somaTempo -= minutos;
			this.numAtividades--;
		}
	}
	
	public int totalAtividades() {
		return this.numAtividades;
	}

	public int tempoTotal() {
		return this.somaTempo;
	}
	
	public String toString() {
		return this.tipo + ": " + this.saida;
	}
}
