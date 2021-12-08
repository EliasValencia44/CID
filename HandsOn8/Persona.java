package examples.knn;
public class Persona {

	Double peso;
	Double estatura;
	Double edad;
	Double distancia;
	public Double getPeso() {
		return peso;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	public Double getEstatura() {
		return estatura;
	}
	public void setEstatura(Double estatura) {
		this.estatura = estatura;
	}
	public Double getEdad() {
		return edad;
	}
	public void setEdad(Double edad) {
		this.edad = edad;
	}
	public Persona( Double estatura, Double edad, Double peso) {
		super();
		this.peso = peso;
		this.estatura = estatura;
		this.edad = edad;
	}
	public Double getDistancia() {
		return distancia;
	}
	public void setDistancia(Double distancia) {
		this.distancia = distancia;
	}
	@Override
	public String toString() {
		return "Persona [peso=" + peso + ", estatura=" + estatura + ", edad=" + edad + ", distancia=" + distancia + "]";
	}
	
}
