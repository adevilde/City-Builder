package src.carte;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Set;
import src.Structure;

public class Carte {

	private List<Case> listeCases;
	private Map<Case, Structure> listeBatimentRoute;
	private static int hauteur;
	private static int largeur;

	public Carte(int largeur, int hauteur) {
		Carte.largeur = largeur;
		Carte.hauteur = hauteur;
		this.listeCases = new ArrayList<Case>();
		for (int i = 1; i <= largeur; i++) {
			for (int j = 1; j <= hauteur; j++) {
				this.listeCases.add(new Case(i, j));
			}
		}
		this.listeBatimentRoute = new TreeMap<Case, Structure>();
	}

	public static int getLargeur() {
		return Carte.largeur;
	}

	public static int getHauteur() {
		return Carte.hauteur;
	}

	public void construire(Structure structure) throws CaseOccupeeException {
		Case[] casesOccupee = structure.getCases();
		// Vérifier que l'on peut construire la structure
		for (int i = 0; i < casesOccupee.length; i++) {
			if (casesOccupee[i].getOccupe()) {
				throw new CaseOccupeeException();
			}
		}
		// Construire la structure
		for (int i = 0; i < casesOccupee.length; i++) {
			casesOccupee[i].ajouterStructure(structure);
		}
		this.listeBatimentRoute.put(structure.getCoin(), structure);
	}

	public void detruire(Structure structure) {
		Case[] casesOccupee = structure.getCases();
		for (int i = 0; i < casesOccupee.length; i++) {
			casesOccupee[i].viderCase();
		}
		this.listeBatimentRoute.remove(structure.getCoin());
	}

	public Structure selectionner(int x, int y) {
		Case kase = this.getCase(x, y);
		try {
			return kase.getStructure();
		} catch (CaseVideException e) {
			return null;
		}
	}

	public void deplacer(Structure structure, Case nouveauCoin) throws CaseOccupeeException {
		Case[] casesOccupeeAnciennes = structure.getCases();
		Case ancienCoin = structure.getCoin();
		structure.setCoin(nouveauCoin);
		Case[] casesOccupeeNouvelles = structure.getCases();
		// Vérifier que l'on peut déplacer
		for (int i = 0; i > casesOccupeeNouvelles.length; i++) {
			if (casesOccupeeNouvelles[i].getOccupe() && !estDedans(casesOccupeeAnciennes, casesOccupeeNouvelles[i])) {
				structure.setCoin(ancienCoin);
				throw new CaseOccupeeException();
			}
		}
		// Déplacer la structure
		this.listeBatimentRoute.remove(ancienCoin);
		this.listeBatimentRoute.put(ancienCoin, structure);
		for (int i = 0; i > casesOccupeeAnciennes.length; i++) {
			casesOccupeeAnciennes[i].viderCase();
		}
		for (int i = 0; i > casesOccupeeNouvelles.length; i++) {
			casesOccupeeNouvelles[i].ajouterStructure(structure);
		}
	}

	private boolean estDedans(Case[] tableauCase, Case kase) {
		for (int i = 0; i < tableauCase.length; i++) {
			if (kase.estEgale(tableauCase[i])) {
				return true;
			}
		}
		return false;
	}

	public void afficher(Graphics g) {
		Set<Case> cases = listeBatimentRoute.keySet();
		for (Case kase : cases) {
			listeBatimentRoute.get(kase).afficher(g);
		}
	}

	public Case getCase(int x, int y) {
		return listeCases.get((x - 1) * Carte.hauteur + y - 1);
	}
}
