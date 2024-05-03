/**
* Este é um exemplo da implementação do padrão Singleton, que dita que só deve haver uma instância 
* da classe na memória e esta deve conceder acesso global ao seus recursos. É útil quando necessita-se 
* de uma classe que faça tarefas que não se devem repetir toda vez que ela for instanciada, por exemplo, 
* carregar drivers para conexão com banco de dados.
*/
public class Singleton {
	/**
	* Uma das características mais importantes de uma classe singleton é uma instância privada 
	* dessa classe. Quando outras classes requisitam uma classe singleton, esta retorna uma instância estática, 
	* ou seja, única na memória.
	*/
	private static Singleton instance;
	private static String data;
	
	/**
	* É importante que o construtor seja privado, para impedir que outras classes criem várias instâncias 
	* de um classe que deveria ser singleton. Eu utilizei o método Thread.sleep() para simular a demora 
	* de um carregamento, por exemplo, um driver do banco de dados.
	*
	* @param data Usado somente para simular algum dado importante.
	*/
	private Singleton(String data) {
		try {
			Thread.sleep(1000);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		this.data = data;
	}
	
	/**
	* Para que a classe possa ser instanciada, é necessário criar um método estático e público para que outras 
	* classes possam usar seus métodos. Essa é a parte mais importante do código, pois é responsável por garantir 
	* que somente uma instância da classe seja criada. Primeiro, é verificado se a instância não é nula (ou seja, 
	* não foi criada na memória) e, se não for, é retornada a instância da classe. Caso contrário, usamos um código 
	* dentro de um synchronized (não se assuste, basicamente, synchronized permite que apenas um Thread execute o código 
	* para evitar mudança repentina no valor das variáveis) e verifica-se se a instância é nula novamente (caso algum
	* Thread tenha a instanciado do nada) e, se for nula, criamos a instância.
	*
	* @param data Dado usado para mostrar o thread-safe da classe em ação.
	* @return Retorna a instância dessa classe.
	*/
	public static Singleton getInstance(String data) {
		if (instance == null)
			synchronized (Singleton.class) {
				if (instance == null)
					instance = new Singleton(data);
			}
			
		return instance;
	}
	
	/**
	* Este método será útil para testarmos se há somente uma instância da classe na memória.
	*/
	public void printData() {
		System.out.println(data);
	}
}
