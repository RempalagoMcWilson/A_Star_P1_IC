package presentacion.panels;
import javax.swing.JPanel;

import modelo.node.NodeEnum;
import presentacion.panels.options.ExecutePanel;
import presentacion.panels.options.GridSizePanel;
import presentacion.panels.options.TypePanel;

public class OptionsPanel  extends JPanel{

	private static final long serialVersionUID = 1L;
	private TypePanel tP;
	private GridSizePanel gSP;
	private ExecutePanel eP;

	public OptionsPanel() {
		iniGUI();
	}
	
	private void iniGUI() {
		setLayout(null);
		setBounds(500,100,300,500);
		
		tP = new TypePanel();
		gSP = new GridSizePanel();
		eP = new ExecutePanel();
		
		add(tP);
		add(gSP);
		add(eP);
	}
	
	public NodeEnum getNodeType() {
		return tP.getType();
	}
}
