package br.com.pre.dojo.tests;

import br.com.pre.dojo.control.Printter;

/**
 * Classe responsável por iniciar a execução da aplicação.
 * @author Marcus Vinícius
 * @since 21/04/2015
 */
public class Execute {

	public static void main(String[] args) throws Exception {
		Printter printter = new Printter();
		printter.generateRanking();
	}
}
