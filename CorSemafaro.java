package projetoSemafaro;

	public enum CorSemafaro {

/* Constantes do Enum */		
		VERDE(1000), AMARELO(300), VERMELHO(2000);

/* Atributo */		
		private int tempoEspera;
		
/* Construtor */		
		CorSemafaro(int tempoEspera){
			this.tempoEspera = tempoEspera;
		}

/* Métodos Especiais */		
		public int getTempoEspera() {
			return tempoEspera;
		}
}
