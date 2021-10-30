package handson4slr;
import java.util.ArrayList;
import java.util.List;

public class SLR {

	
	private int iterationX=0;
	private int iterationY=0;
	private ArrayList<Double> xValues;
	private ArrayList<Double> yValues;
	private double b1;
	private double b0;
	private double error;
	private double learningRate;
	public double getLearningRate() {
		return learningRate;
	}
	public void setLearningRate(double learningRate) {
		this.learningRate = learningRate;
	}
	private int n=9;
	private int iteraciones=0;
	

	
	public SLR() {
		this.xValues =  new ArrayList<Double>();
		this.yValues =  new ArrayList<Double>();
	}
	public double getB1() {
		return b1;
	}
	public void setB1(double b1) {
		this.b1 = b1;
	}
	public double getB0() {
		return b0;
	}
	public void setB0(double b0) {
		this.b0 = b0;
	}
	public void setxValues(double xValues) {
		this.xValues.add(xValues);
	}

	public void setyValues(double yValues) {
		this.yValues.add(yValues);
	}

	public void agregarValores() {
		this.xValues.add((double)23);
		this.yValues.add((double)651);
		this.xValues.add((double)26);
		this.yValues.add((double)762);
		this.xValues.add((double)30);
		this.yValues.add((double)856);
		this.xValues.add((double)34);
		this.yValues.add((double)1063);
		this.xValues.add((double)43);
		this.yValues.add((double)1190);
		this.xValues.add((double)48);
		this.yValues.add((double)1298);
		this.xValues.add((double)52);
		this.yValues.add((double)1421);
		this.xValues.add((double)57);
		this.yValues.add((double)1440);
		this.xValues.add((double)58);
		this.yValues.add((double)1518);
	}
	public void executeOptimization() {
		agregarValores();
		iteraciones++;
		double aux=0;
		error=0;
		double sum=0;
		
		// get  B0 derived
		double sumB0=0;
		double derivadaB0=0;
		for(int k=0; k<n; k++) {
			sumB0 = yValues.get(k)-(this.b0 + ( this.b1 * xValues.get(k)));
		}
		derivadaB0 = -(2/(double)n) * sumB0;
		
		// get  B1 derived
		double sumB1=0;
		double derivadaB1=0;
		for(int j=0; j<n; j++) {
			sumB1 =xValues.get(j) *( (yValues.get(j)- (this.b0+ (this.b1 * xValues.get(j)))) );
		}
		derivadaB1= -(2/(double)n)* sumB1;
		
		while(true) {

				
			//get error
			sum=0;
			aux=0;
			for(int i=0; i<n; i++) {
				aux = (this.yValues.get(i) - (this.b0 + (this.b1* this.xValues.get(i)) ));
				sum +=  Math.pow(aux, 2);
			}

			this.error= (float)this.n/ sum;
						
			if(this.error < this.learningRate ) {
				System.out.println("Termino la ejecucion");			
				System.out.printf("\nerror: %.50f ", this.error);
				break;
			}else {
				this.b0 =(double)this.b0 - ((double)this.learningRate * ((double)this.error/(double)derivadaB0));
				this.b1 = (double)this.b1 - ((double)this.learningRate * ((double)this.error/derivadaB1));
					System.out.println("\nReintentando : "+iteraciones++);	
					System.out.printf("\nerror: %.50f ", this.error);
					
			}
		
		}
		
	}
	public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;

	}
	public double calcularPrediccion(double x) {
		return this.b0 + (this.b1*x);
		
	}
	
	
	
}
