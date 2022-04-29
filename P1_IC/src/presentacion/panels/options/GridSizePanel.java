package presentacion.panels.options;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import presentacion.mainFrame.MainFrame;

public class GridSizePanel extends JPanel{
	
	private JButton okB;
	private JSpinner iS;
	private JSpinner jS;
	
	public GridSizePanel() {
		iniGUI();
	}

	private void iniGUI() {
		setLayout(null);
		setBounds(0,60,300, 150);
		//setBackground(Color.LIGHT_GRAY);
		
		Border b = BorderFactory.createLineBorder(Color.black, 2);
		setBorder(BorderFactory.createTitledBorder(b, "CHANGE GRID SIZE      ", TitledBorder.LEFT, TitledBorder.TOP));
		
		okB = new JButton();
		okB.setBounds(100, 100, 100, 25);
        okB.setText("CHANGE");
		okBListener();
		
		SpinnerNumberModel modeloSpinner1 = new SpinnerNumberModel(10, 2, 30, 1);
		SpinnerNumberModel modeloSpinner2 = new SpinnerNumberModel(10, 2, 30, 1);
		
        iS = new JSpinner(modeloSpinner1);
        iS.setBounds(50, 25, 70, 25);
        iS.setToolTipText("Seleccionar numero de fila");
        
        jS = new JSpinner(modeloSpinner2);
        jS.setBounds(200, 25, 70, 25);
        jS.setToolTipText("Seleccionar numero de columna");
        
        add(okB);
        add(iS);
        add(jS);
	}

	private void okBListener() {
        okB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                MainFrame.getInstance().changeGrid((int) iS.getValue(), (int) jS.getValue());
            }
        });
    }
}
