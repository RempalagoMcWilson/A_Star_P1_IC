package presentacion.panels;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import modelo.node.NodeEnum;
import modelo.node.nodeGrid.NodeGrid;
import presentacion.mainFrame.MainFrame;

public class GridPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton[][] botones;
	private boolean hayFinal;

	public GridPanel() {
		iniGUI(10, 10);
	}

	public GridPanel(int i, int j) {
		iniGUI(i, j);
	}

	private void iniGUI(int i, int j) {
		setLayout(new GridLayout(i, j));
		setBackground(new Color(61, 153, 0));
		setBounds(50, 100, 400, 400);
		generaGrid(i, j);
	}

	private void generaGrid(int I, int J) {
		botones = new JButton[I][J];
		hayFinal = false;
		for (int i = 0; i < I; i++) {
			for (int j = 0; j < J; j++) {
				botones[i][j] = new JButton();
				botones[i][j].setBackground(new Color(96, 209, 84));
				bListener(i,j);
				add(botones[i][j]);

			}
		}
	}

	private void bListener(int i, int j) {
		botones[i][j].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				NodeEnum n = MainFrame.getInstance().getNodeType();
				switch (n) {
				case Start:
					botones[i][j].setBackground(new Color(213, 224, 227));
					NodeGrid.getInstance().insertNode(n, i, j);
					break;
				case End:
					if(!hayFinal) {
						botones[i][j].setBackground(new Color(0, 59, 74));
						NodeGrid.getInstance().insertNode(n, i, j);
						hayFinal = true;
					}
					break;
				case Hazard:
					botones[i][j].setBackground(new Color(255, 213, 0));
					NodeGrid.getInstance().insertNode(n, i, j);
					break;
				case Block:
					botones[i][j].setBackground(new Color(235, 47, 72));
					NodeGrid.getInstance().insertNode(n, i, j);
					break;
				case WayPoint:
					botones[i][j].setBackground(new Color(59, 215, 255));
					NodeGrid.getInstance().insertNode(n, i, j);
					break;
				default:
					botones[i][j].setBackground(new Color(174, 235, 134));
					NodeGrid.getInstance().insertNode(n, i, j);
					break;
				}

			}
		});
	}
	
	public void hazloCamino(int i, int j) {
		botones[i][j].setBackground(new Color(237, 203, 128));
		NodeGrid.getInstance().insertNode(NodeEnum.Path, i, j);
	}
}
