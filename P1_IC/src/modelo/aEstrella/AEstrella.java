package modelo.aEstrella;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

import modelo.node.NodeEnum;
import modelo.node.Position;
import modelo.node.nodeGrid.NodeGrid;
import presentacion.mainFrame.MainFrame;

public class AEstrella {

	// Datos
	private NodeEnum[][] grid;
	private ArrayList<Position> aWayPoints;
	private ArrayList<Position> aStarts;
	private ArrayList<Position> aBlocks;
	private Position end;
	private int I;
	private int J;
	private final double r2 = Math.sqrt(2);
	private double hazardCost;

	// Algoritmo
	private PriorityQueue<Position> abierta;
	private Set<Position> cerrada;

	// Solucion
	private ArrayList<Position> camino;

	public AEstrella() {
		grid = NodeGrid.getInstance().getGrid();
		aWayPoints = NodeGrid.getInstance().getWayPoints();
		aStarts = NodeGrid.getInstance().getStarts();
		end = NodeGrid.getInstance().getEnd();
		aBlocks = NodeGrid.getInstance().getBlocks();
		I = NodeGrid.getInstance().getI();
		J = NodeGrid.getInstance().getJ();
		hazardCost = ((Math.sqrt(Math.pow(I,2)) + Math.sqrt(Math.pow(J,2))) / 100) * 10;
		if (end != null)
			algoritmo();
	}

	public ArrayList<Position> getCaminos() {
		return camino;
	}

	private void algoritmo() {
		int contWP;
		Position iniAct;
		for (Position st : aStarts) {
			iniListas();
			iniAct = st;
			abierta.add(iniAct);
			iniAct.setH(0);
			contWP = 0;
			if (aWayPoints.isEmpty())
				iniAct.calculaF(end);
			for (Position wp : aWayPoints) {
				if(contWP != aWayPoints.size()) {
					iniAct.calculaF(wp);
					algSim(iniAct, wp);
					iniAct = wp;
					iniAct.setH(0);
					iniListas();
					abierta.add(iniAct);
					contWP++;
				}
				else {
					iniAct = wp;
					iniAct.setH(0);
					iniAct.calculaF(end);
					iniListas();
					abierta.add(iniAct);
				}
			}
			algSim(iniAct, end);
		}
	}

	private void algSim(Position st, Position end) {
		boolean encontrado = false;
		while (!encontrado && !abierta.isEmpty()) {
			Position aux = abierta.poll();
			cerrada.add(aux);
			if (aux.equals(end)) {
				meteSol(st, aux);
				encontrado = true;
			} else {
				meteNodosAd(aux, end);
			}
		}
	}

	private void meteSol(Position st, Position end2) {
		MainFrame mFAux = MainFrame.getInstance();
		Position aux = end2.getPadre();
		while(!aux.equals(st)) {
			camino.add(aux);
			aBlocks.add(aux);
			mFAux.hazloCamino(aux.getI(), aux.getJ());
			aux = aux.getPadre();
		}
	}

	private void meteNodosAd(Position p, Position e) {
		if (p.getI() > 0) {
			meteN(p, e, p.getI() - 1, p.getJ(), 1);// ARRIBA
		}
		if (p.getI() < I - 1) {
			meteN(p, e, p.getI() + 1, p.getJ(), 1);// ABAJO
		}
		if (p.getJ() < J - 1) {
			meteN(p, e, p.getI(), p.getJ() + 1, 1);// DERECHA
		}
		if (p.getJ() > 0) {
			meteN(p, e, p.getI(), p.getJ() - 1, 1);// IZQUIERDA
		}
		if (p.getJ() < J - 1 && p.getI() < I - 1) {
			meteN(p, e, p.getI() + 1, p.getJ() + 1, r2);// ABAJO-DERECHA
		}
		if (p.getJ() > 0 && p.getI() > 0) {
			meteN(p, e, p.getI() - 1, p.getJ() - 1, r2);// ARRIBA-IZQUIERDA
		}
		if (p.getJ() > 0 && p.getI() < I - 1) {
			meteN(p, e, p.getI() + 1, p.getJ() - 1, r2);// ABAJO-IZQUIERDA
		}
		if (p.getI() > 0 && p.getJ() < J - 1) {
			meteN(p, e, p.getI() - 1, p.getJ() + 1, r2);// ARRIBA-DERECHA
		}
	}

	public void meteN(Position p, Position e, int i, int j, double c) {
		Position aux = new Position(i, j);
		if(grid[i][j] == NodeEnum.Hazard) {
			c+= hazardCost;
		}
		if(!cerrada.contains(aux)) {
			if(!abierta.contains(aux)) {
				aux.setH(p.getH() + c);
				aux.calculaF(e);
				aux.setPadre(p);
				abierta.add(aux);
			}
			else {
				boolean mejor = aux.esMejor(p, e, c);
				if(mejor) {
					abierta.remove(aux);
					abierta.add(aux);
				}
			}
		}
	}

	private void iniListas() {
		abierta = new PriorityQueue<Position>(1, new Comparator<Position>() {
			@Override
			public int compare(Position p1, Position p2) {
				if (p1.getF() < p2.getF())
					return -1;
				else
					return 1;
			}
		});
		camino = new ArrayList<Position>();
		cerrada = new HashSet<Position>();
		for (Position p : aBlocks) {
			cerrada.add(p);
		}
	}
}
