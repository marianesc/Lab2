package lab2;

import java.util.Scanner;

public class Main {
	
	/**Devem ser usadas apenas letras maiúsculas para teste.
	 * 
	 * Modelo de criação do objeto: 
	 * CRIAR_<objeto> <parâmetros de criação do objeto>
	 * Ex: CRIAR_ESTUDO INTEGRAIS
	 * 
	 * Modelo de manipulação do objeto: 
	 * <objeto> <ação que deseja fazer> <parâmetros para determinada ação> 
	 * Ex: ESTUDO INTEGRAIS ADICIONAR_MINUTOS 10
	*/
	
	// Método Principal de execução do programa.
	public static void main(String[] args) {
		
		Estudo[] arrayDeEstudo = new Estudo[1000];
		String[] nomesEstudo = new String[1000];
		Organizacao[] arrayDeOrganizacao = new Organizacao[1000];
		String[] nomesOrganizacao = new String[1000];
		Lazer[] arrayDeLazer = new Lazer[1000];
		String[] nomesLazer = new String[1000];
		EstudoDirigido[] arrayDeEstudoDirigido = new EstudoDirigido[1000];
		String[] nomesEstudoDirigido = new String[1000];
		
		Scanner sc = new Scanner(System.in);
        
        while (true) {
        	System.out.println("Comando: ");
        	String comando = sc.nextLine();
        	// Saída do programa.
        	if (comando.equals("SAIR")) break;
        	String[] base = comando.split(" ");
        	if (base[0].equals("CRIAR_ESTUDO")) criarEstudo(base, arrayDeEstudo, nomesEstudo);
        	else if (base[0].equals("CRIAR_ORGANIZACAO")) criarOrganizacao(base, arrayDeOrganizacao, nomesOrganizacao);
        	else if (base[0].equals("CRIAR_LAZER")) criarLazer(base, arrayDeLazer, nomesLazer);
        	else if (base[0].equals("CRIAR_ESTUDO_DIRIGIDO")) criarEstudoDirigido(base, arrayDeEstudoDirigido, nomesEstudoDirigido);
        	else if (base[0].equals("ESTUDO")) manipularEstudo(base, arrayDeEstudo, nomesEstudo);
        	else if (base[0].equals("ORGANIZACAO")) manipularOrganizacao(base, arrayDeOrganizacao, nomesOrganizacao);
        	else if (base[0].equals("LAZER")) manipularLazer(base, arrayDeLazer, nomesLazer);
        	else if (base[0].equals("ESTUDO_DIRIGIDO")) manipularEstudoDirigido(base, arrayDeEstudoDirigido, nomesEstudoDirigido, arrayDeEstudo, nomesEstudo);
        }
	}
	
	// Método para adicionar um novo objeto e nome à lista de objetos e nomes.
	private static void adicionaNovo(Object objeto, Object[] objetos, String nome, String[] nomes) {
        for (int i = 0; i < objetos.length; i++) {
            if (objetos[i] == null) {
                objetos[i] = objeto;
                nomes[i] = nome;
                break;
            }
        }
    }
	
	//Métodos para criação de objetos.
	//trechos[i], sendo i >= 1, são os parâmetros para criação do objeto de acordo com a necessidade de cada um. Ex: nome, tempo...
	
	private static void criarEstudo(String[] trechos, Estudo[] objeto, String[] nomes) {
		Estudo novo = new Estudo(trechos[1]);
		adicionaNovo(novo, objeto, trechos[1], nomes);
		System.out.println("Estudo criado.");
	}
	
	private static void criarOrganizacao(String[] trechos, Organizacao[] objeto, String[] nomes) {
		Organizacao novo = new Organizacao(trechos[1],Integer.parseInt(trechos[2]));
		adicionaNovo(novo, objeto, trechos[1], nomes);
		System.out.println("Organização criada.");
	}
	
	private static void criarLazer(String[] trechos, Lazer[] objeto, String[] nomes) {
		Lazer novo;
		if (trechos.length == 2) {
			novo = new Lazer(trechos[1]);
		}
		else {
			novo = new Lazer(trechos[1],Integer.parseInt(trechos[2]));
		}
		adicionaNovo(novo, objeto, trechos[1], nomes);
		System.out.println("Lazer criado.");
	}
	
	private static void criarEstudoDirigido(String[] trechos, EstudoDirigido[] objeto, String[] nomes) {
		EstudoDirigido novo = new EstudoDirigido(trechos[1]);
		adicionaNovo(novo, objeto, trechos[1], nomes);
		System.out.println("Estudo dirigido criado.");
	}
	
	// Método para encontrar o índice de algum objeto a partir do seu nome.
	private static int encontraItem(String nome, String[] nomes) {
        for (int i = 0; i < nomes.length; i++) {
            if (nome.equals(nomes[i])) return i;
        }
        return -1;
    }
	
	//Métodos para manipulação de objetos.
	//trechos[i], sendo i >= 1, são os parâmetros para manipulação do objeto de acordo com o que deseja realizar. Ex: nome, ação desejada, dados
	
	private static void manipularEstudo(String[] trechos, Estudo[] objeto, String[] nomes) {
		int indice = encontraItem(trechos[1], nomes);
        Estudo atual = objeto[indice];
        
        if (trechos[2].equals("ADICIONAR_MINUTOS")) {
        	int minutos = Integer.parseInt(trechos[3]);
            atual.adicionaMinutos(minutos);
            System.out.println("Minutos adicionados.");
        }
        else if (trechos[2].equals("DEVE_DESCANSAR")) {
        	System.out.println(atual.deveDescansar());
        }
        else if (trechos[2].equals("VER_MINUTOS")) {
        	System.out.println(atual.getMinutos());
        }
        else if (trechos[2].equals("IMPRIMIR")) {
        	System.out.println(atual.toString());
        }
	}
	
	private static void manipularOrganizacao(String[] trechos, Organizacao[] objeto, String[] nomes) {
		int indice = encontraItem(trechos[1], nomes);
        Organizacao atual = objeto[indice];
        
        if (trechos[2].equals("CADASTRAR_TAREFA") && trechos.length == 5) {
        	int minutos = Integer.parseInt(trechos[4]);
        	int idTarefa = Integer.parseInt(trechos[3]);
        	atual.cadastraTarefa(idTarefa, minutos);
        	System.out.println("Tarefa cadastrada.");
        }
        else if (trechos[2].equals("CADASTRAR_TAREFA") && trechos.length == 6) {
        	int minutos = Integer.parseInt(trechos[5]);
        	int idTarefa = Integer.parseInt(trechos[3]);
        	atual.cadastraTarefa(idTarefa, trechos[4], minutos);
        	System.out.println("Tarefa cadastrada.");
        }
        else if (trechos[2].equals("VER_DESCRICAO")) {
        	int idTarefa = Integer.parseInt(trechos[3]);
        	System.out.println(atual.getDescricao(idTarefa));
        }
        else if (trechos[2].equals("VER_DURACAO")) {
        	int idTarefa = Integer.parseInt(trechos[3]);
        	System.out.println(atual.getDuracaoTarefa(idTarefa));
        }
        else if (trechos[2].equals("MEDIA")) {
        	System.out.println(atual.mediaTarefa());
        }
        else if (trechos[2].equals("IMPRIMIR")) {
        	System.out.println(atual.toString());
        }
	}
	
	private static void manipularLazer(String[] trechos, Lazer[] objeto, String[] nomes) {
		int indice = encontraItem(trechos[1], nomes);
        Lazer atual = objeto[indice];
        
        if (trechos[2].equals("CADASTRAR_ATIVIDADE")) {
        	int minutos = Integer.parseInt(trechos[4]);
        	atual.cadastraAtividade(trechos[3], minutos);
        	System.out.println("Atividade cadastrada.");
        }
        else if (trechos[2].equals("TOTAL_ATIVIDADES")) {
        	System.out.println(atual.totalAtividades());
        }
        else if (trechos[2].equals("TEMPO_TOTAL")) {
        	System.out.println(atual.tempoTotal());
        }
        else if (trechos[2].equals("MAIOR_ATIVIDADE")) {
        	System.out.println(atual.maiorAtividade());
        }
        else if (trechos[2].equals("MENOR_ATIVIDADE")) {
        	System.out.println(atual.menorAtividade());
        }
        else if (trechos[2].equals("IMPRIMIR")) {
        	System.out.println(atual.toString());
        }
	}
	
	private static void manipularEstudoDirigido(String[] trechos, EstudoDirigido[] objeto, String[] nomes, Estudo[] estudos, String[] nomesEstudos) {
		int indice = encontraItem(trechos[1], nomes);
        EstudoDirigido atual = objeto[indice];
        
        if (trechos[2].equals("CADASTRAR_ESTUDO")) {
        	Estudo estudo = estudos[encontraItem(trechos[3], nomesEstudos)];
        	atual.cadastraEstudo(estudo);
        	System.out.println("Estudo cadastrado.");
        }
        else if (trechos[2].equals("TEMPO_TOTAL")) {
        	System.out.println(atual.contaTempoTotal());
        }
        else if (trechos[2].equals("IMPRIMIR")) {
        	System.out.println(atual.toString());
        }
	}
}
