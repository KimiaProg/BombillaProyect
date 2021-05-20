package bombilla;

public class BombillaLEDKimia extends BombillaKimia {

	private static String amarillo = "Amarillo";
	private static String rojo = "Rojo";
	private static String verde = "Verde";
	private static String color = "";
	private static String[] colores= {amarillo, rojo , verde};
	private boolean EstadoBombilla=false;
	
	

	public BombillaLEDKimia() {
		super();
	}
	public BombillaLEDKimia(String nombre, int vidaUtil , String modelo) {
		super(nombre, vidaUtil , modelo);
		// TODO Auto-generated constructor stub
	}


	public static final String getAmarillo() {
		return amarillo;
	}


	public static final void setAmarillo(String amarillo) {
		BombillaLEDKimia.amarillo = amarillo;
	}

	

	public static final String getRojo() {
		return rojo;
	}


	public static final void setRojo(String rojo) {
		BombillaLEDKimia.rojo = rojo;
	}


	public static final String getVerde() {
		return verde;
	}


	public static final void setVerde(String verde) {
		BombillaLEDKimia.verde = verde;
	}

	/**
	 * 
	 * @param numColor 0 = amarillo , 1 = rojo , 2 = verde 
	 * @return
	 */
	public static void setColor(int numColor) {
		String color = colores[numColor];
		BombillaLEDKimia.color = color;
	}
	
	public static String getColor() {
		return color;
	}

	public final boolean isEstadoBombilla() {
		return EstadoBombilla;
	}
	public final void setEstadoBombilla(boolean estadoBombilla) {
		EstadoBombilla = estadoBombilla;
	}
	

	@Override
	public String toString() {
		if( isEstadoBombilla()== true) {
			return "BombillaLED [ El color actual de la bombilla :" + getColor() + " " + super.toString() + "]";
		}else {
				return "BombillaLED [ Actualmente la bombilla al estar apagada no tiene ningún color" + super.toString() + "]";
			}
		}
	}

	

