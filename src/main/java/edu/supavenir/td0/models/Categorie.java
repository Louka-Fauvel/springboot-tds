package edu.supavenir.td0.models;

import java.util.ArrayList;
import java.util.List;

public class Categorie {
	
	private String nom;
	private List<Element> itemsCategorie;

	public Categorie(String nom) {
		this.nom = nom;
		itemsCategorie = new ArrayList<Element>();
		
	}
	
	public Element getElementByName(String nom) {
		int index = itemsCategorie.indexOf(new Element(nom));
		return itemsCategorie.get(index);
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Element> getItemsCategorie() {
		return itemsCategorie;
	}

	public void setItemsCategorie(List<Element> itemsCategorie) {
		this.itemsCategorie = itemsCategorie;
	}
	
	public boolean addItem(Element elm) {
		
		if(!itemsCategorie.contains(elm)) {
			return itemsCategorie.add(elm);
		}
		return false;
	}
	
	public boolean deleteItem(Element elm) {
		// il manque des information
		return false;
		
	}
	
	@Override
	public boolean equals(Object obj) {

		if(!(obj instanceof Categorie)) {
			return false;
		}
		return ((Categorie)obj).getNom().equals(this.nom);
	}
}
