package presentacion.panels.options;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import modelo.node.NodeEnum;

public class TypePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JComboBox<String> cB;

	public TypePanel() {
		iniGUI();
	}

	private void iniGUI() {
		setLayout(null);
		setBounds(0,0,300, 60);		
		//setBackground(Color.LIGHT_GRAY);
		
		Border b = BorderFactory.createLineBorder(Color.black, 2);
		setBorder(BorderFactory.createTitledBorder(b, "SELECT NODE TYPE TO INSERT      ", TitledBorder.LEFT, TitledBorder.TOP));
		
		cB = new JComboBox<String>();
		cB.addItem("Start");
		cB.addItem("End");
		cB.addItem("Block");
		cB.addItem("Hazard");
		cB.addItem("Way Point");
		cB.setBounds(20,20, 260, 20);
		add(cB);
	}
	
	public NodeEnum getType() {
		switch ((String) cB.getSelectedItem()) {
		case "Start":
			return NodeEnum.Start;
		case "Block":
			return NodeEnum.Block;
		case "End":
			return NodeEnum.End;
		case "Hazard":
			return NodeEnum.Hazard;
		case "Way Point":
			return NodeEnum.WayPoint;
		default:
			return NodeEnum.Empty;
		}
	}
}
