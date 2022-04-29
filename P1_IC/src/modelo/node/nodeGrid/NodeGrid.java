package modelo.node.nodeGrid;

import java.util.ArrayList;

import modelo.node.NodeEnum;
import modelo.node.Position;
import modelo.node.nodeGrid.imp.NodeGridImp;

public abstract class NodeGrid {

	private static NodeGrid instance;
	
	public synchronized static NodeGrid getInstance()  {
		if (instance == null)
			instance = new NodeGridImp();
		return instance;
	}
	
	public abstract void insertNode(NodeEnum n, int i, int j);
	public abstract void resetGrid(int i, int j);
	public abstract NodeEnum[][] getGrid();
	public abstract ArrayList<Position> getWayPoints();
	public abstract ArrayList<Position> getStarts();
	public abstract Position getEnd();
	public abstract ArrayList<Position> getBlocks();
	public abstract int getI();
	public abstract int getJ();
}
