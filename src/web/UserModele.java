package web;

import java.util.ArrayList;

import java.util.List;

import metier.User;

public class UserModele {

	private String nom;
	private List <User> li=new ArrayList<>();
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public List<User> getLi() {
		return li;
	}
	public void setLi(List<User> li) {
		this.li = li;
	}
	
}
