package com.carniceria.cashflow.utils;

public class Pair {

	private String padre;
	private String hijo;
	
	public Pair(String padre, String hijo) {
		this.padre = padre;
		this.hijo = hijo;
	}

	public String getPadre() {
		return padre;
	}

	public void setPadre(String padre) {
		this.padre = padre;
	}

	public String getHijo() {
		return hijo;
	}

	public void setHijo(String hijo) {
		this.hijo = hijo;
	}

	@Override
	public String toString() {
		return "Pair [padre=" + padre + ", hijo=" + hijo + "]";
	}
	
	@Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final Pair other = (Pair) obj;
        if ((this.padre == null) ? (other.padre != null) : !this.padre.equals(other.padre)) {
            return false;
        }

        if ((this.hijo == null) ? (other.hijo != null) : !this.hijo.equals(other.hijo)) {
            return false;
        }


        return true;
    }
}
