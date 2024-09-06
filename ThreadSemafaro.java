package projetoSemafaro;

/* Essa classe simula o comportamento do semáforo em uma thread separada: CONTROLADOR DO SIMULADOR*/
	public class ThreadSemafaro implements Runnable {

/* Atributos */		
		private CorSemafaro cor;
		private boolean parar;
		private boolean corMudou;

/* Construtor */		
		public ThreadSemafaro(){
			this.cor = CorSemafaro.VERMELHO;
			this.parar = false;
			this.corMudou = false;
			new Thread(this).start();
		}

/* Método Run */		
		@Override
		public void run() {

			while(!parar){
				try {
					Thread.sleep(this.cor.getTempoEspera());
					this.mudarCor();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	
		
/* Método mudarCor */ 		
		private synchronized void mudarCor(){
			switch (this.cor) {
			case VERMELHO:
				this.cor = CorSemafaro.VERDE;
				break;
			case AMARELO:
				this.cor = CorSemafaro.VERMELHO;
				break;
			case VERDE:
				this.cor = CorSemafaro.AMARELO;
				break;
			default:
				break;
			}
			this.corMudou = true;
			notify();
		}
		
/* Método esperarCorMudar */	
		public synchronized void esperaCorMudar(){
			while(!this.corMudou){
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			this.corMudou = false;
		}
		
/* Método desligarSemafaro */		
		public synchronized void desligarSemafaro(){
			this.parar = true;
		}

/* Método Especial: Retornar a cor atual do Semafaro */		
		public CorSemafaro getCor() {
			return cor;
		}
}
