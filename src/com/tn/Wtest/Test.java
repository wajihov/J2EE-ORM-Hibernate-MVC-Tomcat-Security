package com.tn.Wtest;

import java.util.List;

import com.tn.dao.ProduitImplDao;
import com.tn.entities.Produit;

public class Test {

	public static void main(String[] args) {
		ProduitImplDao dao = new ProduitImplDao();

		/*
		 * dao.addProduit(new Produit("PNBV", 150, 1600)); dao.addProduit(new
		 * Produit("MPLO", 850, 9600)); dao.addProduit(new Produit("AMPLO", 70, 6600));
		 * dao.addProduit(new Produit("PPMM", 50, 94200));
		 */

		/*
		 * System.out.println("************ All Produits **********"); List<Produit>
		 * produits = dao.produits(); for (Produit p : produits) {
		 * System.out.println(p.getIdProduit() + " le designation : " +
		 * p.getDesignation() + " / " + p.getPrix() + " / " + p.getQuantity()); }
		 */
		/*
		 * System.out.println("************ getBy ID  avant MJR*************"); Produit
		 * p = dao.getProduitById(5L);
		 * 
		 * p.setDesignation("ADMPLO"); p.setPrix(1588); p.setQuantity(650);
		 * dao.upDateProduit(p);
		 * System.out.println("************ getBy ID  apres MJR*************");
		 * System.out.println(p.getIdProduit() + " le designation : " +
		 * p.getDesignation() + " / " + p.getPrix() + " / " + p.getQuantity());
		 */
		System.out.println("************ All Produits by MC **********");
		List<Produit> produits = dao.getProduitByMC("m");
		for (Produit p : produits) {
			System.out.println(p.getIdProduit() + " le designation : " + p.getDesignation() + " / " + p.getPrix()
					+ " / " + p.getQuantity());
		}

		System.out.println("************ All Produits **********");
		List<Produit> produitsO = dao.produits();
		for (Produit p : produitsO) {
			System.out.println(p.getIdProduit() + " le designation : " + p.getDesignation() + " / " + p.getPrix()
					+ " / " + p.getQuantity());
		}
		// dao.deleteProduit(6L);
		System.out.println("************ getBy ID  avant MJR*************");
		Produit p = dao.getProduitById(8L);
		System.out.println(p.getIdProduit() + " le designation : " + p.getDesignation() + " / " + p.getPrix() + " / "
				+ p.getQuantity());
		
		System.out.println("************ getBy ID  avant MJR*************");
		Produit p4 = dao.getProduitById(8L);
		p4.setDesignation("PMLOI");
		p4.setPrix(4455);
		p4.setQuantity(56);
		dao.upDateProduit(p4);
		System.out.println(p.getIdProduit() + " le designation : " + p4.getDesignation() + " / " + p4.getPrix() + " / "
				+ p4.getQuantity());

	}

}
