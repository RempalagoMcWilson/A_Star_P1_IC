package presentacion.mainFrame;

import javax.swing.JFrame;


import modelo.node.NodeEnum;
import presentacion.mainFrame.imp.MainFrameImp;


public abstract class MainFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	private static MainFrame instance;
	
	public synchronized static MainFrame getInstance()  {
		if (instance == null)
			instance = new MainFrameImp();
		return instance;
	}
	public abstract void changeGrid(int i, int j);
	public abstract NodeEnum getNodeType();
	public abstract void hazloCamino(int i, int j);
}
