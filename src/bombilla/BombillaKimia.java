package bombilla;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

public class BombillaKimia {

	// Declarando las variable
	protected boolean encendido = false;
	private boolean fundido = false;
	private int contEncender = 0;
	private int contApagar = 0;
	int cont =0;
	LocalTime hora1;
	LocalTime hora2;
	long sec;
	int i ;
	private String nombre;
	private String marca;
	private String modelo;
	private int vidaUtil;
	private static double precioLuz;
	private int vatHora;
	private long tiempoEncendido;
	private int vatConsumido=0;
	long horaMasUno =1;
	long horaEncen;
	double precioTotal;
	private long encendidoRest;
	

	public BombillaKimia() {
		
	}
	
	public BombillaKimia(String nombre, int vidaUtil , String modelo) {
		this.nombre = nombre;
		this.vidaUtil= vidaUtil;
		if( modelo.equalsIgnoreCase("GU10")) {
			vatHora = 7;
		}else if ( modelo.equalsIgnoreCase("MR16")) {
			vatHora = 5;
		}else if ( modelo.equalsIgnoreCase("E14")) {
			vatHora = 4;
		}
		this.modelo = modelo;
		 i =0;
	}

	

	/**
	 * método para encender la bombilla
	 */
	public void encender() {
		
		if (encendido == true) {
			System.out.println("La bombilla ya estaba encendida.");
		} else {
			cont++;
			encendido = true;
			estado();
			LocalDateTime time = LocalDateTime.now();
			hora1 = time.toLocalTime();
			if(cont>1) {
				long sec = ChronoUnit.SECONDS.between(hora2,hora1);
				if(sec <20) {
					i++;
					if(i ==3) {
						i=0;
					}
					cambiarColor(true , i);
				}else {
					cambiarColor(false , i);
			}}else {
				cambiarColor(false , i);
			}
			//Recoger la hora del sistema
			
			contEncender++;
		}
	}

	public void cambiarColor(boolean cambiaColor , int i ) {
		if(cambiaColor == true) {
			BombillaLEDKimia.setColor(i);
			System.out.println("El color de la bombilla es : " + BombillaLEDKimia.getColor());
		}else {
			i=0;
			BombillaLEDKimia.setColor(i);
			System.out.println("El color de la bombilla es : " + BombillaLEDKimia.getColor());
			}
	}
	
	public boolean getEncendido() {
		return encendido;
	}
	
	/**
	 * Método para apagar la bombilla
	 */
	public void apagar() {

		if (encendido == false) {
			System.out.println("La bombilla ya estaba apagada.");
		} else {
			encendido = false;
			estado();
			//Recoger la hora del sistema
			LocalDateTime time2 = LocalDateTime.now();
			hora2 = time2.toLocalTime();
			//Calculando los segundo transcurridos entre las dos horas
			 sec = ChronoUnit.SECONDS.between(hora1,hora2);
			 tiempoEncendido= tiempoEncendido + sec;
			System.out.println("La bombilla estuvo encendida durante: " + sec + " segundos.") ;
			contApagar++;
		}
	}
	/**
	 * Definiendo el estado de la bombilla
	 */
	public void estado() {
		
		if(encendido == false) {
			System.out.println("Apagado");
		}else {
			System.out.println("Encendido");
		}
	}
	
	


	public final String getNombre() {
		return nombre;
	}

	public final void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public final String getMarca() {
		return marca;
	}

	public final void setMarca(String marca) {
		
		this.marca = marca;
	}

	public final String getModelo() {
		return modelo;
	}

	public final void setModelo(String modelo) {
		this.modelo = modelo;
	}
	

	
	public final int getVidaUtil() {
		return vidaUtil;
	}

	public final void setVidaUtil(int vidaUtil) {
		this.vidaUtil = vidaUtil;
	}

	/**
	 * 
	 * @param fundido recibe un boolean
	 */
	public void setFundir(boolean fundido) {
		this.fundido = fundido;
	}

	/**
	 * 
	 * @return fundido. devuelve si está fundido
	 */
	public String getFundir() {
		if(fundido == true) {
			return "Se ha fundido";
		}else {
			return "No está fundida";
		}
	}

	/**
	 * 
	 * @return contEncender. devuelve contEncender
	 */
	public int getContadorEncender() {
		return contEncender;
	}

	/**
	 * 
	 * @return conApagar. duvuelve conApagar
	 */
	public int getContadorApagar() {
		return contApagar;
	}
	
	public final static double getPrecioLuz() {
		return precioLuz;
	}

	public final static void setPrecioLuz(double precioLuz) {
		BombillaKimia.precioLuz = precioLuz;
	}
	
	public final double getPrecioTotal() {
		precioTotal = getVatConsumido() * getPrecioLuz();
		return precioTotal;
	}
	
	public final int getVatConsumido() {
		 horaMasUno = horaEncen+1; 
		 horaEncen= TimeUnit.SECONDS.toHours(tiempoEncendido);
		 if(horaEncen == horaMasUno) {
			 vatConsumido = vatConsumido +vatHora;
		 }
		 return vatConsumido;
	}
	public final long getEncendidoRest() {
		long vidaSec = TimeUnit.MINUTES.toSeconds(vidaUtil);
		encendidoRest = vidaSec - tiempoEncendido;
		return encendidoRest;
	}



	@Override
	public String toString() {
		return " [Nombre=" + nombre + ", Marca=" + marca + ", Modelo=" + modelo + ", Estado= " + encendido + ", Tiempo encendido= " 
	+ sec + ", Encendido Restante= " + getEncendidoRest()+ ", Vatios por hora= "+ vatHora + ", Consumo total en vatios= "+
				getVatConsumido() + " vatios" + ", Precio total consumido= " + getPrecioTotal() + "€ ]";
	}


}


