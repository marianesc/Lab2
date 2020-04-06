package lab2;


public class PlanD {


    public static void main(String[] args) {

           

            Estudo estudoP2 = new Estudo("Classes e Objetos");

            estudoP2.adicionaMinutos(10);

            System.out.println(estudoP2.deveDescansar()); // false

            estudoP2.adicionaMinutos(120);

            System.out.println(estudoP2.deveDescansar()); // true, estudo > 120 min

            System.out.println(estudoP2.toString()); // Classes e Objetos (130 min)


            System.out.println("====");


            Estudo estudoCalculo = new Estudo("Integrais");

            estudoCalculo.adicionaMinutos(1);

            System.out.println(estudoCalculo.deveDescansar()); // false

            System.out.println(estudoCalculo.toString()); // Integrais (10 min)


            System.out.println("====");


            int numTarefas = 3;

            Organizacao orgQuarto = new Organizacao("Quarto", numTarefas);

            orgQuarto.cadastraTarefa(0, 5);

            orgQuarto.cadastraTarefa(1, 20);

            orgQuarto.cadastraTarefa(2, 5);

            System.out.println(orgQuarto.getDuracaoTarefa(1)); // 20

            System.out.println(orgQuarto.mediaTarefa()); // 10

            orgQuarto.cadastraTarefa(1, 5);

            System.out.println(orgQuarto.mediaTarefa()); // 5

       System.out.println(orgQuarto.toString()); // Quarto (3 tarefas, 5 min/tarefa)

            System.out.println("====");

           
            Lazer tv = new Lazer("TV", 180);  // limite de 180 minutos e 180 atividades

            tv.cadastraAtividade("Fruit Basket", 24);

            tv.cadastraAtividade("BoJack Horseman", 22);

            tv.cadastraAtividade("Black Mirror", 48);

       tv.cadastraAtividade("Cidade de Deus", 135); // n vai ser cadastrado, passa do limite de minutos

            System.out.println(tv.totalAtividades());

            System.out.println(tv.tempoTotal());

            System.out.println(tv.toString());


            Lazer piano = new Lazer("Piano");  // limite padrão de 60 min

            System.out.println(piano.totalAtividades()); // 0

    }  

}