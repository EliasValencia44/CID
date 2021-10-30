package handson4slr;

import jade.core.AID;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MyGui extends JFrame {	
	private SLRAgent myAgent;
	
	private JTextField xField, yField, xToPredict;
	
	MyGui(SLRAgent a) {
		super(a.getLocalName());
		
		myAgent = a;
		
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(3, 3));
		p.add(new JLabel("X Value:"));
		xField = new JTextField(15);
		p.add(xField);
		
		p.add(new JLabel("Y Value:"));
		yField = new JTextField(15);
		p.add(yField);
		
		p.add(new JLabel("X to predict:"));
		xToPredict = new JTextField(15);
		p.add(xToPredict);
		
		getContentPane().add(p, BorderLayout.CENTER);
		
		//boton agragar valores x y
		JButton addButton = new JButton("Add");
		addButton.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				try {
					String x = xField.getText().trim();
					String y = yField.getText().trim();
					myAgent.updateValues(Double.parseDouble(x), Double.parseDouble(y));
					xField.setText("");
					yField.setText("");
				}
				catch (Exception e) {
					JOptionPane.showMessageDialog(MyGui.this, "Invalid values. "+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE); 
				}
			}
		} );
		

		//boton predecir valor
		JButton predictButton = new JButton("Predict");
		predictButton.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				try {
					String x2 = xToPredict.getText().trim();
					
					myAgent.valueXToPredict(Double.parseDouble(x2));
					xToPredict.setText("");					
				}
				catch (Exception e) {
					JOptionPane.showMessageDialog(MyGui.this, "Invalid values. "+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE); 
				}
			}
		} );
		p = new JPanel();
		p.add(addButton);
		p.add(predictButton);
		getContentPane().add(p, BorderLayout.SOUTH);
		//-------------------------------
		
		// Make the agent terminate when the user closes 
		// the GUI using the button on the upper right corner	
		addWindowListener(new	WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				myAgent.doDelete();
			}
		} );
		
		setResizable(false);
	}
	
	public void showGui() {
		pack();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int centerX = (int)screenSize.getWidth() / 2;
		int centerY = (int)screenSize.getHeight() / 2;
		setLocation(centerX - getWidth() / 2, centerY - getHeight() / 2);
		super.setVisible(true);
	}	
}
