package it.polito.tdp.nobel.db;

public class TestDB {

	public static void main(String[] args) {
		/*
		 * This is a main to check the DB connection
		 */

		try {
			EsameDAO vdao = new EsameDAO();
			vdao.getTuttiEsami();
			System.out.println("TestDB passed");

		} catch (RuntimeException e) {
			System.err.println("TestDB failed");
		}
	}

}
