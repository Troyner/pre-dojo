package br.com.pre.dojo.tests;

import br.com.pre.dojo.control.Printter;

/**
 * Classe respons�vel por iniciar a execu��o da aplica��o.
 * @author Marcus Vin�cius
 * @since 21/04/2015
 */
public class Execute {

	public static void main(String[] args) throws Exception {
		Printter printter = new Printter();
		printter.generateRanking();
	}
}
