package bombilla;

import java.util.Scanner;

/**
 * Creando una bombilla para encenderla y apagarla
 * @author Kimia
 *
 */
public class PruebaBombillaKimia {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int resBom;
		do {
			System.out.println("Cuántas bombillas quieres crear? (1 hasta 10)");
			resBom= sc.nextInt();
		}while(resBom<1 || resBom >10);

		BombillaKimia[] bombillas = new BombillaKimia[resBom];
		for(int i =0 ; i<resBom; i++) {
			System.out.println("Escribe los datos de la bombilla " + i );
			System.out.print("Nombre: ");
			String nombre= sc.next();
			System.out.println("Vida útil (Solo el número de minutos:1, 2, 3 ...): ");
			int vida = sc.nextInt();
			System.out.print("Modelo de bombilla LED (GU10 - MR16 - E14): ");
			String modelo= sc.next();
			BombillaKimia b= new BombillaKimia(nombre, vida , modelo);
			bombillas[i] = b;
		}
		System.out.println("Establece el precio de la luz: ");
		double precio = sc.nextDouble();
		BombillaKimia.setPrecioLuz(precio);
		String resRep;
		do {
		System.out.println("Qué quieres hacer?(Elige una opción)");
		System.out.println("1: Encender \n2: Apagar \n3: Obtener un informe de la bombilla\n4: Obtener información acerca del color y las características de las bombillas ");
		int opcion = sc.nextInt();
		String resTodas;
		
		switch(opcion) {
		
		case 1:
			System.out.println("Quieres encender todas las bombillas o solo una?(una/todas)");
			resTodas= sc.next();
			if(resTodas.equalsIgnoreCase("Todas")) {
				for(int i = 0; i<bombillas.length ; i++) {
					if(bombillas[i] != null) {
						if(bombillas[i].getContadorEncender()> 3) {
							bombillas[i].setFundir(true);
							System.out.println("La bombilla " + i + bombillas[i].getFundir());
							System.out.println("Quieres sustituir la bombilla " +i +" por una nueva? (Si/No)");
							String resBomFund = sc.next();
							if(resBomFund.equalsIgnoreCase("Si")) {
								System.out.println("Escribe los datos de la bombilla " + i );
								System.out.print("Nombre: ");
								String nombre= sc.next();
								System.out.println("Vida útil (Solo el número de minutos:1, 2, 3 ...): ");
								int vida = sc.nextInt();
								System.out.print("Modelo de bombilla LED (GU10 - MR16 - E14): ");
								String modelo= sc.next();
								bombillas[i]= new BombillaKimia(nombre, vida , modelo);
							}else {
								bombillas[i] = null;
							}
						}else {
					System.out.print("Bombilla " + i + ": ");
					bombillas[i].encender();
					}
				}else{
					System.out.println("La bombilla " + i +" está fundida, no puedes encenderla.");
					}
				}
			}
			if(resTodas.equalsIgnoreCase("una")) {
				System.out.println("Qué bombilla quieres encender? (0 hasta " + (resBom-1) + ")");
				int numBom = sc.nextInt();
				if(bombillas[numBom] != null) {
					if(bombillas[numBom].getContadorEncender()> 3) {
						bombillas[numBom].setFundir(true);
						System.out.println("La bombilla " + numBom + bombillas[numBom].getFundir());
						System.out.println("Quieres sustituir la bombilla " +numBom +" por una nueva? (Si/No)");
						String resBomFund = sc.next();
						if(resBomFund.equalsIgnoreCase("Si")) {
							System.out.println("Escribe los datos de la bombilla " + numBom);
							System.out.print("Nombre: ");
							String nombre= sc.next();
							System.out.println("Vida útil (Solo el número de minutos:1, 2, 3 ...): ");
							int vida = sc.nextInt();
							System.out.print("Modelo de bombilla LED (GU10 - MR16 - E14): ");
							String modelo= sc.next();
							bombillas[numBom]= new BombillaKimia(nombre, vida , modelo);
						}else {
							bombillas[numBom] = null;
						}
						
					}else {
							System.out.print("Bombilla " + numBom + ": ");
							bombillas[numBom].encender();
						}
					}else {
						System.out.println("Esta bombilla está fundida, no puedes encenderla");
					}
			}
			break;
				
		case 2:
			System.out.println("Quieres apagar todas las bombillas o solo una?(una/todas)");
			resTodas= sc.next();
			if(resTodas.equalsIgnoreCase("Todas")) {
				for(int i = 0 ; i<bombillas.length ; i++) {
					System.out.print("Bombilla " + i + ": "); 
					bombillas[i].apagar();
				}
			}
			if(resTodas.equalsIgnoreCase("una")) {
				System.out.println("Qué bombilla quieres apagar? (0 hasta " + (resBom-1) + ")");
				int numBom = sc.nextInt();
				System.out.print("Bombilla " + numBom + ": ");
				bombillas[numBom].apagar();
				}
			break;
			
		case 3: 
			System.out.println("De qué bombilla quieres informe?(0 hasta " + (resBom-1) + ")");
			int numBomInf= sc.nextInt();
			System.out.print("Bombilla " + numBomInf + ": ");
			System.out.println(bombillas[numBomInf].toString());
			break;
			
		case 4:
			System.out.println("De qué bombilla quieres informe?(0 hasta " + (resBom-1) + ")");
			int numBomInf2= sc.nextInt();
			System.out.print("Bombilla " + numBomInf2 + ": ");
			BombillaKimia b = bombillas[numBomInf2];
			BombillaLEDKimia bLED = new BombillaLEDKimia(b.getNombre(), b.getVidaUtil(), b.getModelo());
			if(bombillas[numBomInf2].getEncendido()==true) {
				bLED.setEstadoBombilla(true);
			}
			System.out.println(bLED.toString());
			break;
		}
		System.out.println("Quieres hacerlo otra vez?");
		resRep = sc.next();
	}while(resRep.equalsIgnoreCase("Si"));
	
		System.out.println("Hasta luego");
	
	}
}

