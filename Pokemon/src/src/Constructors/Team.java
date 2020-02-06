package Constructors;

import java.util.LinkedList;

public class Team extends LinkedList<Pokemon>{

	private static final long serialVersionUID = -3938621188766515471L;

	public Team() {
			add(new Pokemon("Absol"));
			add(new Pokemon("Nidoking"));
			add(new Pokemon("Sandslash"));
			add(new Pokemon("Torterra"));
			add(new Pokemon("Pumpkaboo"));
			add(new Pokemon("Raichu"));
	}
}

