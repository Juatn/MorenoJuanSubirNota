package Contenedor;


import Models.ListaOrdenadaNoRepetida;

import Models.pokemon;


public class Lista {

	public static ListaOrdenadaNoRepetida<pokemon> pokedex = new ListaOrdenadaNoRepetida<pokemon>((pokemon a, pokemon b) -> b.getNumero() - a.getNumero());;
	
}
