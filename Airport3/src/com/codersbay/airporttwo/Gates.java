package com.codersbay.airporttwo;

public class Gates {
	int gate_id;
	Terminals terminal;
	String name;
	
	public Gates(int gate_id, Terminals terminal, String name) {
		this.gate_id = gate_id;
		this.terminal = terminal;
		this.name = name;
	}

	public Gates() {
	}

	public int getGate_id() {
		return gate_id;
	}

	public void setGate_id(int gate_id) {
		this.gate_id = gate_id;
	}

	public Terminals getTerminal() {
		return terminal;
	}

	public void setTerminal(Terminals terminal) {
		this.terminal = terminal;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
