package presentacion.panels.options;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import modelo.aEstrella.AEstrella;

public class ExecutePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton executeB;

	public ExecutePanel() {
		iniGUI();
	}
	
	private void iniGUI() {
		setLayout(null);
		setBounds(0,210,300, 75);		
		//setBackground(Color.LIGHT_GRAY);
		
		Border b = BorderFactory.createLineBorder(Color.black, 2);
		setBorder(BorderFactory.createTitledBorder(b, "EXECUTE ALGORITHM      ", TitledBorder.LEFT, TitledBorder.TOP));
		
		executeB = new JButton();
		executeB.setBounds(25, 25, 250, 25);
		executeB.setText("EXECUTE");
		executeBListener();
		
		add(executeB);
	}
	
	private void executeBListener() {
        executeB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                AEstrella a = new AEstrella();
                //a.ensennaDatos();
            }
        });
    }
}
