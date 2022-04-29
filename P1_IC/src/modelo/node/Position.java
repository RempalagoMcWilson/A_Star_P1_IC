package modelo.node;

public class Position {

	private int i;
	private int j;

	private double f;
	private double g;// dist hasta la meta
	private double h;// coste actual

	private Position padre;

	public Position(int i, int j) {
		this.i = i;
		this.j = j;
		f = 0;
		g = 0;
		h = 0;
		padre = null;
	}

	public int getI() {
		return i;
	}

	public int getJ() {
		return j;
	}

	public double getF() {
		return f;
	}

	public void setH(double h) {
		this.h = h;
	}

	public double getH() {
		return h;
	}

	public void setPadre(Position p) {
		padre = p;
	}

	public Position getPadre() {
		return padre;
	}

	public void calculaF(Position end) {
		g = Math.sqrt(Math.pow(Math.abs(i - end.getI()), 2) + Math.pow(Math.abs(j - end.getJ()), 2));
		f = h + g;
	}

	@Override
	public String toString() {
		return "Position [i=" + i + ", j=" + j + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + i + 1;// añadido 1
		result = prime * result + j + 2;// añadido 2
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (i != other.i)
			return false;
		if (j != other.j)
			return false;
		return true;
	}

	public boolean esMejor(Position p, Position e, double c) {
		double hN = p.getH() + c;
		double gN = Math.sqrt(Math.pow(Math.abs(i - e.getI()), 2) + Math.pow(Math.abs(j - e.getJ()), 2));
		double fN = hN + gN;
		
		if(fN < f) {
			h = hN;
			g = gN;
			f = fN;
			padre = p;
			return true;
		}
		else
			return false;
	}

}
