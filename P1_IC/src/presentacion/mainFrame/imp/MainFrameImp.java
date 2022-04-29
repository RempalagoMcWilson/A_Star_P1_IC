package presentacion.mainFrame.imp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;

import modelo.node.NodeEnum;
import modelo.node.nodeGrid.NodeGrid;
import presentacion.mainFrame.MainFrame;
import presentacion.panels.GridPanel;
import presentacion.panels.OptionsPanel;

public class MainFrameImp extends MainFrame{
	
	private static final long serialVersionUID = 1L;
	private GridPanel gP;
	private OptionsPanel oP;
	private JLabel titulo;
	
	public MainFrameImp() {
		iniGUI();
	}

	
	private void iniGUI() {
		setVisible(true);
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(850,600));
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout (null);
		setBackground(Color.darkGray);
		
		gP = new GridPanel();
		add(gP);
		
		titulo = new JLabel("Algoritmo A*");
		titulo.setBounds(50,20,400,60);
		titulo.setFont(new Font("Arial", Font.BOLD, 40));
		add(titulo);
		
		oP = new OptionsPanel();
		add(oP);
		repaint();
		revalidate();
		
	}


	@Override
	public void changeGrid(int i, int j) {
		remove(gP);
		gP = new GridPanel(i,j);
		NodeGrid.getInstance().resetGrid(i, j);
		add(gP);
		repaint();
		revalidate();
	}


	@Override
	public NodeEnum getNodeType() {
		return oP.getNodeType();
	}


	@Override
	public void hazloCamino(int i, int j) {
		gP.hazloCamino(i, j);
	}
	
	
}
