//package examples.bookTrading;
package handson4slr;

import jade.core.Agent;
import jade.core.behaviours.*;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;

import java.util.*;

public class SLRAgent extends Agent {

	private SLR slr;
	private MyGui myGui;

	protected void setup() {
		slr= new SLR();
		

		// Create and show the GUI 
		myGui = new MyGui(this);
		myGui.showGui();

		// Register the book-selling service in the yellow pages
		DFAgentDescription dfd = new DFAgentDescription();
		dfd.setName(getAID());
		ServiceDescription sd = new ServiceDescription();
		sd.setType("SLRAgent");
		sd.setName("SLRAgent 1");
		dfd.addServices(sd);
		try {
			DFService.register(this, dfd);
		}
		catch (FIPAException fe) {
			fe.printStackTrace();
		}

	}

	// Put agent clean-up operations here
	protected void takeDown() {
		// Deregister from the yellow pages
		try {
			DFService.deregister(this);
		}
		catch (FIPAException fe) {
			fe.printStackTrace();
		}
		// Close the GUI
		myGui.dispose();
		// Printout a dismissal message
		System.out.println("SLRAgent "+getAID().getName()+" terminating.");
	}

	//setup values
	public void updateValues(final double b0, final double b1, final double alpha) {
		addBehaviour(new OneShotBehaviour() {
			public void action() {
				slr.setB0(b0);
				slr.setB1(b1);
				slr.setLearningRate(alpha);
				slr.executeOptimization();

				//System.out.println(x+" inserted into catalogue. Price = "+y);  
			}
		} );
	}
	//valueXToPredict
	public void valueXToPredict(final double x) {
		addBehaviour(new OneShotBehaviour() {
			public void action() {				
				slr.executeOptimization();
				System.out.println("\n\ty = B0 + B1 X");
			}
		} );
	}
	
}

