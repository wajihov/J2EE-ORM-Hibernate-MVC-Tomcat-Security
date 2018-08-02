package com.tn.dao;

import java.util.List;

import com.tn.entities.Produit;

public interface IProduitDAO {

	public void addProduit(Produit produit);

	public void deleteProduit(Long id);

	public void upDateProduit(Produit produit);

	public List<Produit> produits();

	public Produit getProduitById(Long id);

	public List<Produit> getProduitByMC(String mc);
}
