package DC;

import DC.TrianguloKimia;
import DC.RectanguloKimia;

import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * La clase Main que conlleva el método main para utlizar las clases creadas en este paquete
 * @author Kimia
 *
 */
public class MainKimia {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean format = true;
		float lado1 = 0;
		float lado2 = 0;
		float base = 0;
		float altura = 0;
		String res = "";
		do {//Lanzar una excepción por si no se introducen las palabras pedidas
			System.out.println("Quieres crear un triángulo o un rectángulo? (rec / tri)");
			String tipo = sc.next();
			if (tipo.equalsIgnoreCase("tri") || tipo.equalsIgnoreCase("rec")) {
				System.out.println("Aquí tienes que introducir los datos de tu dibujo:");
			} else {
				InputMismatchException ex = new InputMismatchException("El formato es falso");
				throw ex;
			}

			//Pidiendo los datos del dibujo y capturando las excepciones de cada uno
			do {
				if (tipo.equalsIgnoreCase("tri")) {
					try {
						System.out.println("Escribe la base de triángulo");
						base = sc.nextFloat();
						format = true;
					} catch (InputMismatchException e) {
						format = false;
						sc.next();
						System.out.println("El formato introducido es falso");
					}
				} else if (tipo.equalsIgnoreCase("rec")) {
					try {
						System.out.println("Escribe el lado 1 del rectángulo");
						lado1 = sc.nextFloat();
						format = true;
					} catch (InputMismatchException e) {
						format = false;
						sc.next();
						System.out.println("El formato introducido es falso");

					}
				}

			} while (format == false); //Si el formato es falso lo vuelve a pedir

			//Pidiendo los datos del dibujo y capturando las excepciones de cada uno
			do {
				if (tipo.equalsIgnoreCase("tri")) {
					try {
						System.out.println("Escribe la altura");
						altura = sc.nextFloat();
						format = true;
					} catch (InputMismatchException ex) {
						System.out.println("El formato introducido es falso");
						sc.next();
						format = false;
					}
				} else if (tipo.equalsIgnoreCase("rec")) {
					try {
						System.out.println("Escribe el lado 2 del rectángulo");
						lado2 = sc.nextFloat();
						format = true;
					} catch (InputMismatchException e) {
						format = false;
						sc.next();
						System.out.println("El formato introducido es falso");
					}
				}
			} while (format == false); //Si el formato es falso lo vuelve a pedir

			//Creando un objeto de la clase correspondiente con los valores introducido 
			//e imprimiendo en la pantalla el area, el perímetro y el dibujo de la figura correspondiente
			if (tipo.equalsIgnoreCase("tri")) {
				TrianguloKimia trianguloKimia = new TrianguloKimia(base, altura, "El primer triángulo");
				System.out.println("El area del triangulo: " + trianguloKimia.area());
				System.out.println("El perímetro del triángulo: " + trianguloKimia.perímetro());
				trianguloKimia.imprimeFigura();
			} else if (tipo.equalsIgnoreCase("rec")) {
				RectanguloKimia rec = new RectanguloKimia(lado1, lado2, "El primer ractángulo");
				System.out.println("El area del rectángulo: " + rec.area());
				System.out.println("El perímetro del rectángulo: " + rec.perímetro());
				rec.imprimeFigura();
			}

			System.out.println("Quieres dibujar otra vez?(Si/No)");
			res = sc.next();
		} while (res.equalsIgnoreCase("Si")); //Repite el programa en el caso de querer repetirlo

		System.out.println("Gracias, Hasta luego.");
		sc.close();
	}
}
