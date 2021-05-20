package DC;

public abstract class FiguraGeometrica {
		
		private String nombre;
		
		public FiguraGeometrica() {
			nombre="Sin Nombre";
		}
		
		public FiguraGeometrica(String nombre) {
			this.nombre=nombre;
		}

		/**
		 * @return the nombre
		 */
		public String getNombre() {
			return nombre;
		}

		/**
		 * @param nombre the nombre to set
		 */
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		
		/**
		 * Método que devuelve el área de la figura geométrica
		 * @return área de la figura geométrica en centímetros cuadrados
		 */
		public abstract float area();
		
		/**
		 * Método que devuelve el perímetros de la figura geométrica
		 * @return perímetro de la figura geométrica en centímetros
		 */
		public abstract float perímetro();
		
		/**
		 * Método que realiza una representación de la figura por Consola.
		 */
		public abstract void imprimeFigura();
		
		@Override
		public String toString() {
			return "Figura Geométrica: " + nombre + ". " + super.toString();
		}

}
