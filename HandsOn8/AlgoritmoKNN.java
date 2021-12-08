package examples.knn;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class AlgoritmoKNN {

	ArrayList<Persona> personas;
	List<Double> distancias;
	Integer kNeighbors = 3;
		
	public AlgoritmoKNN() {
		personas = new ArrayList<Persona>();
		distancias= new ArrayList<Double>();
		personas.add(new Persona((double)5,(double)45,(double)77));
		personas.add(new Persona((double)5.11,(double)26,(double)47));
		personas.add(new Persona((double)5.6,(double)30,(double)55));
		personas.add(new Persona((double)5.9,(double)34,(double)59));
		personas.add(new Persona((double)4.8,(double)40,(double)72));
		personas.add(new Persona((double)5.8,(double)36,(double)60));
		personas.add(new Persona((double)5.3,(double)19,(double)40));
		personas.add(new Persona((double)5.8,(double)28,(double)60));
		personas.add(new Persona((double)5.5,(double)23,(double)45));
		personas.add(new Persona((double)5.6,(double)32,(double)58));
		
	}
			
	public void calcularDistancias() {
		Double nuevaEstatura =5.5;
		Double nuevaEdad = (double)38;
		Double nuevoPeso =0.0;
		for (int i = 0; i < personas.size(); i++) {
			personas.get(i).setDistancia(calcularDistEucli(nuevaEstatura,nuevaEdad,personas.get(i)));
		}
		Collections.sort(personas, new Comparator<Persona>() {
			@SuppressWarnings("removal")
			@Override
			public int compare(Persona p1, Persona p2) {
				return new Double(p1.getDistancia()).compareTo(new Double(p2.getDistancia()));
			}
		});		
		
		for (int k = 0; k < personas.size(); k++) {
			System.out.println(personas.get(k));
		}
		for (int aux = 0; aux < kNeighbors; aux++) {
			nuevoPeso +=  personas.get(aux).getPeso();
		}
		System.out.println("el nuevo peso es: "+ nuevoPeso / kNeighbors);
		
		

	}
	public Double calcularDistEucli(Double nuevaEstatura, Double nuevaEdad, Persona person) {
		return Math.sqrt(
				Math.pow((nuevaEstatura- person.getEstatura()) , 2) 
				+ Math.pow((nuevaEdad - person.getEdad()), 2));
		
		
	}
}
