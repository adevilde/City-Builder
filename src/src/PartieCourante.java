package src;

import src.carte.Carte;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.time.*;
import java.util.*;
import javax.imageio.*;
import javax.swing.*;
import src.menus.*;
import src.carte.*;


public class PartieCourante extends JPanel implements ComponentListener {

	private int nbTotHab;
	
	private Carte carte;

	private Finances finances;
	
	private JFrame fenetre;
	
	private final JLabel[][] cases;
	
	private Instant instant;
	
	private double tempsTotal;
	
	
	public PartieCourante(int nbTotHab, Carte carte, Finances finances, JFrame fenetre) {
		this.nbTotHab = nbTotHab;
		this.carte = carte;
		this.finances = finances;
		this.cases = new JLabel[Carte.getHauteur()][Carte.getLargeur()];
		
		this.fenetre = fenetre;
		this.setBounds(0, 0, this.fenetre.getWidth(), this.fenetre.getHeight()); 
		this.setLayout(null);
		
		Container contenu = this.fenetre.getContentPane();
		contenu.setLayout(null);
		
		for (int i = 0; i < this.cases.length; i++) {
			for (int j = 0; j < this.cases[i].length; j++) {
				this.cases[i][j] = new JLabel();
				this.add(this.cases[i][j]);
				cases[i][j].addMouseListener(new ActionCliquerCase(i,j));
			}
		}
		
		contenu.add(this);
		this.fenetre.addComponentListener((ComponentListener) this);
		
		this.setVisible(true);
		this.instant = Instant.now();
		this.tempsTotal = 0;
	}
	public PartieCourante(JFrame fenetre) {
		this(0, new Carte(1000, 1000), new Finances(100000), fenetre);
	}
	
	public PartieCourante() {
		this(new JFrame());
	}
	
	
	public void jouer() {

	}
	@Override
	public void paintComponent(Graphics g)
    {
        //Chargement de l"image de fond
        try {
        	super.paintComponent(g);
            Image imgprinc = ImageIO.read(new File("src/Images/Carte.png"));
            g.drawImage(imgprinc, 0, 0, this.fenetre.getWidth(), this.fenetre.getHeight(), this.fenetre);
        } catch (IOException e) {
            System.out.println("Erreur image carte : " + e.getMessage());
        }
    }
	
	@Override
	public void componentHidden(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentMoved(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentResized(ComponentEvent arg0) {
		this.setBounds(0, 0, this.fenetre.getWidth(), this.fenetre.getHeight()); 
		
		int largeur = 460*this.getWidth()/960;
		int hauteur = 87*this.getHeight()/540;
		int align_gauche = 250*this.getWidth()/960;
		
		//this.jouer.setBounds(align_gauche, 100*this.getHeight()/540, largeur, hauteur);
		//this.parametre.setBounds(align_gauche, 236*this.getHeight()/540, largeur, hauteur);
		//this.quitter.setBounds(align_gauche, 383*this.getHeight()/540, largeur, hauteur);
		
	}

	@Override
	public void componentShown(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	private class ActionCliquerCase implements MouseListener {

		private int x;
		private int y;
		
		ActionCliquerCase(int x, int y){
			this.x = x;
			this.y = y;
		}
		
		@Override
		public void mouseClicked(MouseEvent arg0) {
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {}

		@Override
		public void mouseExited(MouseEvent arg0) {}

		@Override
		public void mousePressed(MouseEvent arg0) {}

		@Override
		public void mouseReleased(MouseEvent arg0) {}
		
	}
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				JFrame fenetre = new JFrame();

				fenetre.setTitle("City-Builder");
				fenetre.setSize(960, 540);
				fenetre.setLocationRelativeTo(null);
				fenetre.setLayout(null);

				new PartieCourante(fenetre);

				fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				fenetre.setVisible(true);
			}
		});
	}*/
	
}
