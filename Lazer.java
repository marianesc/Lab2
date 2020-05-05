package lab2;

import java.util.ArrayList;

public class Lazer {
	
	private String tipo;
	private int limite;
	private ArrayList<String> descricoes;
	private ArrayList<Integer> tempo;

	public Lazer(String tipo, int limite) {
		this.tipo = tipo;
		this.limite = limite;
		this.descricoes = new ArrayList<String>();
		this.tempo = new ArrayList<Integer>();
	}
	
	public Lazer(String tipo) {
		this.tipo = tipo;
		this.limite = 60;
		this.descricoes = new ArrayList<String>();
		this.tempo = new ArrayList<Integer>();
	}
	
	
	public void cadastraAtividade(String nome, int minutos) {
		if (!this.descricoes.contains(nome)) {
			int somaTempo = tempoTotal() + minutos;
			int numAtividades = totalAtividades() + 1;
			if (somaTempo <= this.limite && numAtividades <= this.limite) {
				this.descricoes.add(nome);
				this.tempo.add(minutos);
			}
		}
			
	}
	
	public int totalAtividades() {
		return this.descricoes.size();
	}

	public int tempoTotal() {
		int tempoTotal = 0;
		for (int elem : this.tempo) {
			tempoTotal += elem;
		}
		return tempoTotal;
	}
	
	public String maiorAtividade() {
		String ehMaior = "";
		int maior = 0;
		for (int i = 0; i < this.tempo.size(); i++) {
			if (this.tempo.get(i) >= maior) {
				maior = this.tempo.get(i);
				ehMaior = this.descricoes.get(i);
			}
		}
		return ehMaior;
	}
	
	public String menorAtividade() {
		String ehMenor = "";
		int menor = this.limite;
		for (int i = 0; i < this.tempo.size(); i++) {
			if (this.tempo.get(i) <= menor) {
				menor = this.tempo.get(i);
				ehMenor = this.descricoes.get(i);
			}
		}
		return ehMenor;
	}
	
	public String toString() {
		String saida = "";
		for (String elem : this.descricoes) {
			if (saida.equals("")) saida += elem;
			else saida += ", " + elem;
		}
		return this.tipo + ": " + saida;
	}
}
