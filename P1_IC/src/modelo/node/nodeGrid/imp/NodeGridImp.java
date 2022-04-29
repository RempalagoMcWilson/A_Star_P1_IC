package modelo.node.nodeGrid.imp;

import java.util.ArrayList;
import modelo.node.NodeEnum;
import modelo.node.Position;
import modelo.node.nodeGrid.NodeGrid;

public class NodeGridImp extends NodeGrid {

	private NodeEnum[][] grid;
	private ArrayList<Position> aWayPoints;
	private ArrayList<Position> aStarts;
	private ArrayList<Position> aBlocks;
	private Position end;
	private int _I;
	private int _J;

	public NodeGridImp() {
		generaGrid(10, 10);
	}

	private void generaGrid(int I, int J) {
		grid = new NodeEnum[I][J];
		for (int i = 0; i < I; i++) {
			for (int j = 0; j < J; j++) {
				grid[i][j] = NodeEnum.Empty;
			}
		}
		aWayPoints = new ArrayList<Position>();
		aStarts = new ArrayList<Position>();
		aBlocks = new ArrayList<Position>();
		end = null;
		_I = I;
		_J = J;
	}

	@Override
	public void insertNode(NodeEnum n, int i, int j) {
		grid[i][j] = n;
		switch (n) {
		case Start:
			aStarts.add(new Position(i, j));
			break;
		case End:
			if (end == null)
				end = new Position(i, j);
			break;
		/*
		 * case Hazard:
		 * 
		 * break;
		 */
		case Block:
			aBlocks.add(new Position(i, j));
			break;
		case WayPoint:
			aWayPoints.add(new Position(i, j));
			break;
		default:

			break;
		}
	}

	@Override
	public void resetGrid(int i, int j) {
		generaGrid(i, j);
	}

	@Override
	public NodeEnum[][] getGrid() {
		return grid;
	}

	@Override
	public ArrayList<Position> getWayPoints() {
		return aWayPoints;
	}

	@Override
	public ArrayList<Position> getStarts() {
		return aStarts;
	}

	@Override
	public Position getEnd() {
		return end;
	}

	@Override
	public ArrayList<Position> getBlocks() {
		return aBlocks;
	}

	@Override
	public int getI() {
		return _I;
	}

	@Override
	public int getJ() {
		return _J;
	}

}
