/**
* É na classe Main que vamos executar e testar o código da classe Singleton. Note que
* usarei 3 Threads para instanciar a classe usando Strings distintas, mas somente um conseguirá fazer isso. 
* Os outros Threads irão somente utilizar a instância que já foi criada por algum outro Thread e irão imprimir 
* tela a palavra que o primeiro Thread usou para instanciar a classe Singleton.
*/
public class Main {

	public static void main(String[] args) {
		Thread a = new Thread(()-> {
			Singleton s = Singleton.getInstance("FOO");
			s.printData();
		});
		
		Thread b = new Thread(()-> {
			Singleton s = Singleton.getInstance("BAR");
			s.printData();
		});
		
		Thread c = new Thread(()-> {
			Singleton s = Singleton.getInstance("JAVA");
			s.printData();
		});
		
		a.start();
		b.start();
		c.start();
	}
}
