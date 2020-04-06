package lab2;

public class Estudo {
	
	private String assunto;
	private int minutos;
	
	public Estudo(String assunto) {
		this.assunto = assunto;
		this.minutos = 0;
	}
	
	public void adicionaMinutos(int minutos) {
		this.minutos += minutos;
	}
	
	public boolean deveDescansar() {
		if (this.minutos > 120) return true;
		else return false;
	}

	public String toString() {
		return this.assunto + " (" + this.minutos + " min)";
	}
}
