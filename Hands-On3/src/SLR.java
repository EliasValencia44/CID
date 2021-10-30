
public class SLR {

	private int iterationX=0;
	private int iterationY=0;
	private double[] xValues;
	private double[] yValues;
	private int n=0;
	private double sumX=0;
	private double sumY=0;
	private double sumXY=0;
	private double sumXPow2=0;
	private double B0=0;
	private double B1=0;
	
	

	public void setxValues(double xValues) {
		this.xValues[iterationX++] = xValues;
	}

	public void setyValues(double yValues) {
		this.yValues[iterationY++] = yValues;
	}
	public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
		this.xValues= new  double[n];
		this.yValues= new  double[n];
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
		while(j<n) {
			sum +=this.xValues[j];
			j++;
		}
		this.sumX= sum;
	}

	public void sumatoriaY() {
		int j=0;
		double sum=0;
		while(j<n) {
			sum +=this.yValues[j];
			j++;
		}
		this.sumY= sum;
	}
	public void sumatoriaXY() {
		int j=0;
		double sum=0;
		while(j<n) {
			sum +=(this.xValues[j]* this.yValues[j]);
			j++;
		}
		this.sumXY= sum;
	}
	public void sumatoriaXPow2() {
		int j=0;
		double sum=0;
		while(j<n) {
			sum +=Math.pow(this.xValues[j],2);;
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
		return this.B0 + (this.B1*x);
		
	}

	

	
	
	
	
}
