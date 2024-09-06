package projetoSemafaro;

/* Essa é a classe principal que inicia a simulação: IMPRIME A COR ATUAL E ESPERA ATÉ QUE A COR MUDE*/
public class SimuladorSemafaro {
 
	public static void main(String[] args) {

/* Instância da classe ThreadSemafaro*/		
		ThreadSemafaro semafaro = new ThreadSemafaro();
	
/* Loop para repetir 10x, imprime a cor atual do semafaro e chama o método esperarCorMudar()
 * que faz a thread principal esperar até que a cor do semafaro mude.*/
		for (int i=0; i<10; i++){
			System.out.println(semafaro.getCor());
			semafaro.esperaCorMudar();
		}
		
/* Após o loop, chama esse método para parar a simulação.*/		
		semafaro.desligarSemafaro();
	}
}
