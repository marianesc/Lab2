package lab2;

public class EstudoDirigido {
	
	private String nome;
	private Estudo[] estudos;
	private int proximo;
	
	public EstudoDirigido(String nome) {
		this.nome = nome;
		this.estudos =  new Estudo[5];
		this.proximo = 0;
	}
	
	private boolean jaExiste(Estudo estudo) {
		boolean jaExiste = false;
		for (Estudo elem : this.estudos) {
			if (elem == estudo) {
				jaExiste = true;
				break;
			}
		}
		return jaExiste;
	}
	
	public void cadastraEstudo(Estudo estudo) {
		if (!jaExiste(estudo) && this.proximo <= 5) {
			this.estudos[this.proximo] = estudo;
			this.proximo++;
		}
	}
	
	public int contaTempoTotal() {
		int tempoTotal = 0;
		for (Estudo elem : this.estudos) {
			if(elem != null) tempoTotal += elem.getMinutos();
		}
		return tempoTotal;
	}
	
	public String toString() {
		StringBuilder msg = new StringBuilder();
		msg.append("Estudo Dirigido: ").append(this.nome).append("\n");
		for (Estudo elem : this.estudos) {
			if (elem != null) msg.append(elem.toString()).append("\n");
		}
		return msg.toString();
	}

}
