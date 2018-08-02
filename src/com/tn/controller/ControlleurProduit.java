package com.tn.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tn.dao.IProduitDAO;
import com.tn.dao.ProduitImplDao;
import com.tn.entities.Produit;

/**
 * Servlet implementation class ControlleurProduit
 */
@WebServlet("/ControlleurProduit")
public class ControlleurProduit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IProduitDAO metier;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControlleurProduit() {
		super();
	}

	@Override
	public void init() throws ServletException {
		metier = new ProduitImplDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action != null) {
			if (action.equals("Save")) {
				try {
					String design = request.getParameter("design");
					float prix = Float.parseFloat(request.getParameter("prix"));
					int quantite = Integer.parseInt(request.getParameter("quantite"));
					metier.addProduit(new Produit(design, quantite, prix));
				} catch (Exception e) {
					e.printStackTrace();
					request.setAttribute("erreur", e.getMessage());
				}
			} else if (action.equals("delete")) {
				Long id = Long.parseLong(request.getParameter("id"));
				metier.deleteProduit(id);
			} else if (action.equals("edit")) {
				Long id = Long.parseLong(request.getParameter("id"));
				Produit prod = metier.getProduitById(id);
				request.setAttribute("produit", prod);
			} else if (action.equals("Update")) {
				try {
					Long id = Long.parseLong(request.getParameter("id_prod"));
					String design = request.getParameter("design");
					float prix = Float.parseFloat(request.getParameter("prix"));
					int quantite = Integer.parseInt(request.getParameter("quantite"));
					Produit pro = new Produit(design, quantite, prix);
					pro.setIdProduit(id);
					metier.upDateProduit(pro);
				} catch (Exception e) {
					request.setAttribute("erreur", e.getMessage());
					e.printStackTrace();
				}
			}
		}
		request.setAttribute("produits", metier.produits());
		request.getRequestDispatcher("views/produit.jsp").forward(request, response);
	}

}
