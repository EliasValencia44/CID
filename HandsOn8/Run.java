package examples.knn;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

public class Run extends Agent {

  protected void setup() {
    System.out.println("Agent "+getLocalName()+" started.");
    addBehaviour(new MyOneShotBehaviour());
  } 

  private class MyOneShotBehaviour extends OneShotBehaviour {

    public void action() {
    	AlgoritmoKNN algoritmoKNN = new AlgoritmoKNN();
		algoritmoKNN.calcularDistancias();

    } 
    
    public int onEnd() {
      myAgent.doDelete();   
      return super.onEnd();
    } 
  }    // END of inner class ...Behaviour
}