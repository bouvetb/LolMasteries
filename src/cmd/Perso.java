package cmd;

import java.math.BigInteger;

public class Perso
{
	private String nom;
	private String image;
	private int niveau;
	private int point;
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getNiveau() {
		return niveau;
	}
	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	
	
	
	
	public Perso(String nom,String image, int niveau, int point) 
	{
		this.nom = nom;
		this.image = image;
		this.niveau = niveau;
		this.point = point;
	}
	
	public static void main(String[] args) 
	{
		
		// TODO Auto-generated method stub

	}

}
