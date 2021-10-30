import java.util.Scanner;

public class Prediccion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int  i=0;
		String aux="s";
		double prediccion=0;
		Scanner s = new Scanner(System.in);
		SLR slr = new SLR();
		System.out.print("Ingresa el tamaño de la muestra(n):");
		slr.setN( Integer.parseInt( s.nextLine()));
		
		//pedir datos
		while(i<slr.getN()) {
			System.out.print("Ingresa X: ");
			slr.setxValues( Double.parseDouble( s.nextLine()));
			System.out.print("Ingresa Y: ");
			slr.setyValues( Double.parseDouble( s.nextLine()));
			i++;
		}
		
		//calcular B0 y B1
		slr.calcularB0AndB1();
		
		// hacer prediccion
		System.out.println("\n\ty = β0 + β1 X");
		System.out.println("\ty = "+slr.getB0()+" + "+slr.getB1()+" X\n");
		
		while(aux!="n") {
		System.out.print("Ingresa el valor a predecir(x): ");
		prediccion = slr.calcularPrediccion(Double.parseDouble(s.nextLine()));
		System.out.println("La prediccion del valor es: "+prediccion);
		System.out.println("\nPresiona n para salir o cualquier otra tecla para continuar");
		aux= s.nextLine();
		}
		
	}

}
