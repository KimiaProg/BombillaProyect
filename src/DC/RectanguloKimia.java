package DC;

/**
 * La clase Rectangulo heredando de la clase FiguraGeometrica 
 * @author Kimia
 *
 */
	public class RectanguloKimia extends FiguraGeometrica {
		private float lado1;
		private float lado2;
		
		/**
		 * El constructor vacío
		 */
		public RectanguloKimia() {
		}
		
		/**
		 * El constructor con valores al recibir
		 * @param lado1 Recibe uno de los lados del rectángulo
		 * @param lado2 Recibe uno de los lados del rectángulo
		 * @param nombre Recibe un nombre para el rectángulo
		 */
		public RectanguloKimia(float lado1, float lado2, String nombre) {
			super(nombre);  //Metiendo e valor nombre en el constructor de la clase padre
			this.lado1= lado1;
			this.lado2= lado2;
		}
		
		//Los getters y setters
		public float getLado1() {
			return lado1;
		}

		public void setLado1(float lado1) {
			this.lado1 = lado1;
		}

		public float getLado2() {
			return lado2;
		}

		public void setLado2(float lado2) {
			this.lado2 = lado2;
		}

		/**
		 * Calculando el area del rectángulo
		 */
		@Override
		public float area() {
			float area = lado1 * lado2;
			return area;
		}

		/**
		 * Calculando el perímetro del rectángulo
		 */
		@Override
		public float perímetro() {
			float peri = (lado1 + lado2) *2;
			return peri;
		}

		/**
		 * Dibuja el rectángulo 
		 */
		@Override
		public void imprimeFigura() {
			int lado1Int = (int) lado1;
			int lado2Int = (int) lado2;
			
			for(int i= 0; i<lado1Int ; i++) {
				
				for(int j = 0 ; j<lado2Int ; j++) {
					System.out.print(" #");
				}
				System.out.println("");
			}
			
		}

	}

