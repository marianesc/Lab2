package lab2;

public class Organizacao {

	private String local;
	private int quantidade;
	private int[] minutos;
	private int media;
	
	public Organizacao(String local, int quantidade) {
		this.local = local;
		this.quantidade = quantidade;
		this.minutos = new int [quantidade];
		this.media = 0;
	}
	
	public void cadastraTarefa(int idTarefa, int minutos) {
		this.minutos[idTarefa] = minutos;
	}
	
	public int getDuracaoTarefa(int idTarefa) {
		return this.minutos[idTarefa];
	}
	
	public int mediaTarefa() {
		int contador = 0;
		for (int num : this.minutos) contador += num;
		int media = contador / this.minutos.length;
		this.media = media;
		return this.media;
	}
	
	public String toString() {
		return this.local + " (" + this.quantidade + " tarefas, " + this.media + " min/tarefa)";
	}
}
