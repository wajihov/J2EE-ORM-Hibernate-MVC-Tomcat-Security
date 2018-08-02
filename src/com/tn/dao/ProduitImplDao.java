package com.tn.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.tn.entities.Produit;

import util.HibernateUtil;

public class ProduitImplDao implements IProduitDAO {

	@Override
	public void addProduit(Produit produit) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			session.save(produit);
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		session.getTransaction().commit();
	}

	@Override
	public void deleteProduit(Long id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Object object = session.get(Produit.class, id);
		if (object == null)
			throw new RuntimeException("Produit introuvable");
		session.delete(object);
		session.getTransaction().commit();
	}

	@Override
	public void upDateProduit(Produit produit) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(produit);
		session.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Produit> produits() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("Select p from Produit p");
		List<Produit> produits = query.list();
		session.getTransaction().commit();
		return produits;
	}

	@Override
	public Produit getProduitById(Long id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Object prod = session.get(Produit.class, id);
		if (prod == null)
			throw new RuntimeException("Produit introuvable");
		session.getTransaction().commit();
		return (Produit) prod;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Produit> getProduitByMC(String mc) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("Select p from Produit p where p.designation like :x ");
		query.setParameter("x", "%" + mc + "%");
		List<Produit> produits = query.list();
		session.getTransaction().commit();
		return produits;
	}

}