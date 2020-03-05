package cmd;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.NumberFormat;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.synth.SynthTextAreaUI;

//donn�es par perso
//image 
//niveau
//point
public class Fenetre1 extends JFrame
{

	 //Instanciation d'un objet Jpanel
     private JPanel panEntete = new JPanel();
     private JPanel panPremier = new JPanel();
     private JPanel panDeuxieme = new JPanel();
     private JPanel panTroisieme = new JPanel();
     private JPanel panQuatrieme = new JPanel();
     private JPanel panCinquieme = new JPanel();
     API api;
     ArrayList<Perso> p;
     private JSplitPane splitE_1;
     private JSplitPane split2_3;
     private JSplitPane split4_5;
     private JSplitPane split1_2e3; 
     private JSplitPane split2e3_4e5; 


     
    
     
	//Instanciation avec le libell�
	 private JButton boutonRechercher = new JButton ("Rechercher");
	 private JFormattedTextField zoneRecherche = new JFormattedTextField();
	 private JLabel labelNom = new JLabel("Nom du joueur : ");
	 
	

    
	
	
	public Fenetre1()
	{
		api = new API();
		p = new ArrayList<>();
		for(int i=0;i<5;i++){
			p.add(new Perso(null,null,0,0));
		}
	    JFrame fenetre = new JFrame();	             
	    //D�finit un titre pour notre fen�tre
	    fenetre.setTitle("Ma premi�re fen�tre Java");
	    //D�finit sa taille : 400 pixels de large et 100 pixels de haut
	    fenetre.setSize(400, 800);
	    //Nous demandons maintenant � notre objet de se positionner au centre
	    fenetre.setLocationRelativeTo(null);
	    //Termine le processus lorsqu'on clique sur la croix rouge
	    fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	 
	    
	   
	    
	    boutonRechercher.addActionListener(new ActionListener() {
			String rec;
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				rec = zoneRecherche.getText();
				p=api.Maitrise(rec);
				panPremier.removeAll();
				panDeuxieme.removeAll();
				panTroisieme.removeAll();
				panQuatrieme.removeAll();
				panCinquieme.removeAll();

				panPremier.add(Nom(p.get(0).getNom(),p.get(0).getPoint()));
				AfficheImage afi = new AfficheImage();
				try {
					panPremier.add(afi.affichageimage(new URL(p.get(0).getImage())));



				//panPremier.add(new AfficheImage("Vayne.png"));

					panDeuxieme.add(Nom(p.get(1).getNom(),p.get(1).getPoint()));
					panDeuxieme.add(afi.affichageimage(new URL(p.get(1).getImage())));
					panTroisieme.add(Nom(p.get(2).getNom(),p.get(2).getPoint()));
					panTroisieme.add(afi.affichageimage(new URL(p.get(2).getImage())));
					panQuatrieme.add(Nom(p.get(3).getNom(),p.get(3).getPoint()));
					panQuatrieme.add(afi.affichageimage(new URL(p.get(3).getImage())));
					panCinquieme.add(Nom(p.get(4).getNom(),p.get(4).getPoint()));
					panCinquieme.add(afi.affichageimage(new URL(p.get(4).getImage())));
				} catch (MalformedURLException ex) {
					ex.printStackTrace();
				}
				fenetre.setVisible(false);
				fenetre.setVisible(true);

				
			}
		});

	    
	    
	    
	    
	    //D�finition de sa couleur de fond
	    panEntete.setBackground(Color.LIGHT_GRAY);  
	    panPremier.setBackground(Color.PINK);
	    panDeuxieme.setBackground(Color.red);
	    panTroisieme.setBackground(Color.green);
	    panQuatrieme.setBackground(Color.cyan);
	    panCinquieme.setBackground(Color.YELLOW);
	   


	    
	    panEntete.add(labelNom);
	    zoneRecherche.setPreferredSize(new Dimension(150,30));
	    panEntete.add(zoneRecherche);
	    panEntete.add(boutonRechercher);
	    
	    /*
	    splitEntete = new JSplitPane(SwingConstants.HORIZONTAL,panEntete,panDeuxieme);
	    splitEntete.setDividerLocation(100);
	    fenetre.add(splitEntete);
	     */
	   
	    
	    
	    splitE_1 = new JSplitPane(SwingConstants.HORIZONTAL,panEntete,panPremier);
	    splitE_1.setDividerLocation(50);
	    fenetre.add(splitE_1);
	    
	    split2_3 = new JSplitPane(SwingConstants.VERTICAL,panDeuxieme,panTroisieme);
	    split2_3.setDividerLocation(200);
	    fenetre.add(split2_3);
	    
	    split1_2e3 = new JSplitPane(SwingConstants.HORIZONTAL,splitE_1,split2_3);
	    split1_2e3.setDividerLocation(300);
	    fenetre.add(split1_2e3);
	    
	    split4_5 = new JSplitPane(SwingConstants.VERTICAL,panQuatrieme,panCinquieme);
	    split4_5.setDividerLocation(200);
	    fenetre.add(split4_5);
	    
	    split2e3_4e5 = new JSplitPane(SwingConstants.HORIZONTAL,split1_2e3,split4_5);
	    split2e3_4e5.setDividerLocation(450);
	    fenetre.add(split2e3_4e5);
	    
	    
	    
	    



	    panPremier.add(Nom(p.get(0).getNom(),p.get(0).getPoint()));
	    panDeuxieme.add(Nom(p.get(1).getNom(),p.get(1).getPoint()));
	    panTroisieme.add(Nom(p.get(2).getNom(),p.get(2).getPoint()));
	    panQuatrieme.add(Nom(p.get(3).getNom(),p.get(3).getPoint()));
	    panCinquieme.add(Nom(p.get(4).getNom(),p.get(4).getPoint()));
	    
	    

	    
	
	    
	    
	   
	    fenetre.setVisible(true);
	}
	
	public JLabel Nom(String Nomp,int Pointp)
	{
		JLabel Nom = new JLabel("Nom du perso : "+Nomp + "\n Points : "+Pointp);
		return Nom;
	}
	

	
	public JLabel Niveau()
	{
		JLabel Niveau = new JLabel("Niveau : ");
		return Niveau;
	}
	
	
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		
		Fenetre1  premiere = new Fenetre1();
		

	}

}
