package handson4slr;
import java.util.ArrayList;
import java.util.List;

public class SLR {

	private List<Double> xValues;
	private List<Double> yValues;
	private int n=0;
	private double sumX=0;
	private double sumY=0;
	private double sumXY=0;
	private double sumXPow2=0;
	private double B0=0;
	private double B1=0;
	
	

	public SLR() {
		this.xValues= new  ArrayList<Double>();
		this.yValues= new   ArrayList<Double>();		
	}
	public void setxValues(double xValue) {
		this.xValues.add( xValue);
		n++;
	}

	public void setyValues(double yValue) {
		this.yValues.add(yValue);
	}
	public int getN() {
		return n;
	}
	public double getB0() {
		return B0;
	}
	public double getB1() {
		return B1;
	}
	public void sumatoriaX() {
		int j=0;
		double sum=0;
		while(j<this.xValues.size()) {
			sum +=this.xValues.get(j);
			j++;
		}
		this.sumX= sum;
	}

	public void sumatoriaY() {
		int j=0;
		double sum=0;
		while(j<this.yValues.size()) {
			sum +=this.yValues.get(j);
			j++;
		}
		this.sumY= sum;
	}
	public void sumatoriaXY() {
		int j=0;
		double sum=0;
		while(j<n) {
			sum +=(this.xValues.get(j)* this.yValues.get(j));
			j++;
		}
		this.sumXY= sum;
	}
	public void sumatoriaXPow2() {
		int j=0;
		double sum=0;
		while(j<n) {
			sum +=Math.pow(this.xValues.get(j),2);;
			j++;
			
		}
		this.sumXPow2= sum;
	}
	
	public void calcularB0AndB1() {
		sumatoriaX();
		sumatoriaY();
		sumatoriaXY();
		sumatoriaXPow2();
		this.B1 = ((this.n * this.sumXY) - (this.sumX * this.sumY ) )/( (this.n * this.sumXPow2 )- (this.sumX*this.sumX) );
		this.B0 = (this.sumY/n)- (this.B1 * (this.sumX/n));
	}
	public double calcularPrediccion(double x) {
		calcularB0AndB1();
		return this.B0 + (this.B1*x);
		
	}

	

	
	
	
	
}
