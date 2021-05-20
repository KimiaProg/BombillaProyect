package DC;

/**
 * La clase Triangulo heredando de la clase FiguraGeometrica 
 * @author Kimia
 *
 */
public class TrianguloKimia extends FiguraGeometrica {

	private float base;
	private float altura;
	
	/**
	 * El constructor vacío
	 */
	public TrianguloKimia() {
	}

	/**
	 * El constructor con valores
	 * @param base Recibe la base del triángulo
	 * @param altura Recibe la altura del triángulo
	 * @param nombre Recibe el nombre del triángulo
	 */
	public TrianguloKimia(float base , float altura, String nombre) {
		super(nombre); //Metiendo e valor nombre en el constructor de la clase padre
		this.base= base;
		this.altura=altura;
	}
	
	//Los setters y getters
	public final float getBase() {
		return base;
	}

	public final void setBase(float base) {
		this.base = base;
	}

	public final float getAltura() {
		return altura;
	}

	public final void setAltura(int altura) {
		this.altura = altura;
	}


	/**
	 * Calculando el area del triángulo
	 */
	@Override
	public float area() {
		float area = (base * altura) /2;
		return area;
	}

	/**
	 * Calculando el perímetro del triángulo
	 */
	@Override
	public float perímetro() {
		double lado3NCompleto = (Math.pow(altura, 2)) + (Math.pow(base, 2));
		float lado3 = (float) Math.sqrt(lado3NCompleto);
		float peri = altura + lado3 +base;
		return peri;
	}

	/**
	 * Dibuja el triángulo
	 */
	@Override
	public void imprimeFigura() {
		int alturaInt = (int) altura;
		int baseInt = (int) base;
		if(altura>base) {
			for(int i=1 ; i<alturaInt+1 ; i++) {
				
				for(int j =0; j<i ; j++) {
					System.out.print(" #");
					
					if(j==baseInt-1) {//Hasta llegar a la base que salga del bucle 
						break;
					}
				}
				System.out.println("");
			}
		}else {
			int j;
			for(int i = alturaInt ; i>0 ; i --) {
				
				for( j = i-1; j<baseInt; j++) {

					System.out.print( "# ");
				}
				System.out.println("");
			}
		}
	}
			
}
		


