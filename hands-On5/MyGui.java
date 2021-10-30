package handson4slr;

import jade.core.AID;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MyGui extends JFrame {	
	private SLRAgent myAgent;
	
	private JTextField b0Field, b1Field, alphaField;
	
	MyGui(SLRAgent a) {
		super(a.getLocalName());
		
		myAgent = a;
		
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(3, 3));
		p.add(new JLabel("B0 Value:"));
		b0Field = new JTextField(15);
		p.add(b0Field);
		
		p.add(new JLabel("B1 Value:"));
		b1Field = new JTextField(15);
		p.add(b1Field);
		
		p.add(new JLabel("Alpha:"));
		alphaField = new JTextField(15);
		p.add(alphaField);
		
		getContentPane().add(p, BorderLayout.CENTER);
		
		//boton agragar valores x y
		JButton addButton = new JButton("Ejecutar");
		addButton.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				try {
					String b0 = b0Field.getText().trim();
					String b1 = b1Field.getText().trim();
					String alpha = alphaField.getText().trim();
					myAgent.updateValues(Double.parseDouble(b0), Double.parseDouble(b1),  Double.parseDouble(alpha));
					b0Field.setText("");
					b1Field.setText("");
					alphaField.setText("");;
				}
				catch (Exception e) {
					JOptionPane.showMessageDialog(MyGui.this, "Invalid values. "+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE); 
				}
			}
		} );
		


		p = new JPanel();
		p.add(addButton);
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
