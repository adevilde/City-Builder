package src.batiments;

import src.Structure;
import src.carte.Carte;
import src.carte.Case;


public abstract class Batiment extends Structure {

	private Case coin;
	private int rotation;
	private Carte carte;
	private Parcelle[] parcelles;
	private int[] accesRoutes;
	private int attractivite;
	private int energieConsomme;
	private int niveau;

	private int tempsConstruction;
	private int coutConstruction;
	
	
	public Batiment(Case coin, int rotation, Carte carte, Parcelle[] parcelles,
			int[] accesRoutes, int attractivite, int niveau, int temps, int cout) {
		super();
		this.coin = coin;
		this.rotation = rotation;
		this.carte = carte;
		this.parcelles = parcelles;
		this.accesRoutes = accesRoutes;
		this.attractivite = attractivite;
		this.energieConsomme = 50;
		this.niveau = niveau;
		this.tempsConstruction = temps;
		this.coutConstruction = cout;
	}

	public abstract void ameliorer();


	private Case getCaseCarte(int x, int y) {
		int cx;
		int cy;
		switch (this.rotation) {
			case 1 :
				cx = x;
				cy = y;
				break;
			case 2 :
				cx = -y;
				cy = x;
				break;
			case 3 :
				cx = -x;
				cy = -y;
				break;
			case 4 :
				cx = y;
				cy = -x;
				break;
			default :
				throw new IllegalArgumentException();
		}
		return this.carte.getCase(this.coin.getX() + cx,
				this.coin.getY() + cy);
	}

	
	public Case[] getAccesRoutes() {
		int nbAcces = this.accesRoutes.length / 2;
		Case[] ret = new Case[nbAcces];
		for (int i = 0; i < nbAcces;  i++) {
			ret[i] = getCaseCarte(this.accesRoutes[2 * i],
					this.accesRoutes[2 * i + 1]);
		}
		return ret;
	}

	public Parcelle[] getParcelles() {
		return this.parcelles;
	}

	public Case[] getCases() {
		int nbCases = 0;
		for (int i = 0; i < this.parcelles.length; i++) {
			nbCases += this.parcelles[i].superficie();
		}
		Case[] cases = new Case[nbCases];
		for (int i = 0; i < this.parcelles.length; i++) {
			Case[] casesParcelle = this.parcelles[i].getCases();
			for (int j = 0; j < casesParcelle.length; j++) {
				cases [i + j] = casesParcelle[j];
			}
		}
		return cases;
	}

	public int getRotation() {
		return this.rotation;
	}

	public void setRotation(int rotation) {
		this.rotation = rotation;
		for(int i = 0; i < this.parcelles.length; i++) {
		this.parcelles[i].setCoin1(
				getCaseCarte(
					this.parcelles[i].getCoin1().getX(),
					this.parcelles[i].getCoin1().getY()));
		this.parcelles[i].setCoin2(
				getCaseCarte(
					this.parcelles[i].getCoin1().getX(),
					this.parcelles[i].getCoin1().getY()));
		}
	}

	// public void setRotation(int rotation) {
	// 	this.rotation = rotation;
	// 	for(int i = 0; i < this.parcelles.length; i++) {
	// 	this.parcelles.setCoin1(
	// 			getCaseCarte(
	// 				this.parcelles[i].getCoin1().getX(),
	// 				this.parcelles[i].getCoin1().getY()));
	// 	this.parcelles.setCoin2(
	// 			getCaseCarte(
	// 				this.parcelles[i].getCoin1().getX(),
	// 				this.parcelles[i].getCoin1().getY()));
	// 	}
	// }

	public Case getCoin() {
		return this.coin;
	}

	public void setCoin(Case coin) {
		this.coin = coin;
	}

	public int getAttractivite() {
		return this.attractivite;
	}

	public void setAttractivite(int attractivite) {
		this.attractivite = attractivite;
	}
	
	public int getEnergieConsomme() {
		return this.energieConsomme;
	}

	public void setEnergieConsomme(int energie) {
		this.energieConsomme = energie;
	}

	public int getNiveau() {
		return this.niveau;
	}

	public int getTempsConstruction() {
		return this.tempsConstruction;
	}

	public void setTempsConstruction(int tempsConstruction) {
		this.tempsConstruction = tempsConstruction;
	}
	
	public int getCoutConstruction() {
		return this.coutConstruction;
	}
	
	public void setCoutConstruction(int coutConstruction) {
		this.coutConstruction = coutConstruction;
	}
}


// 3 niveau habitation

// commerces :	alimentaire			(Alice)
// 		mode						Les différents types de commerces seront créés à l'aide du constructeur 
// 		santé						notament le nom et les paramètres liés aux emplois.
// 		centre commercial
// 		biens manufacturés
// 		loisir (parc d'attraction, cinema, salle de sport, restaurant, karaoke, bowling, billard, laser game, bar à jeux, bar)

// centre de soin :	clinique		(Alice)
// 			hopital					J'ai mis des remarques notamment au niveau de la façon dont on va 
//									implémanter les batiments et questions autour des camions

// Pole emploi ?

/** Envoie des messages ex. "Il faut créer des commerces, bureaux etc ou améliorer les batiments commerciaux lorsque nbHabitant > nbEmployes" 
et "Il faut créer des habitations ou améliorer les batiments de logement lorsque nbHabitant < nbEmployes" **/

// Mairie	?					

/** Mairie enregistre le nb de batiments dans la ville , nbHabitant et nbEmployes, et budget de la ville.
La mairie gère les entrées et pertes d'argent. En effet, chaque bâtiment rapporte de l'argent en fonction du nb d'habitants 
dans la ville. Habitation : rapporte plus ou moins d'argent en fonction du nb d'habitants par rapport au nb d'emplois,
cad s'il y a plus d'habitants que d'emplois, le gain est inférieur (avec un certain coeff)
que le gain lorsque nbHabitant <= nbEmployes 

De plus, les commerces rapportent loyers + un certain montant qui varie : s'il n'y a pas assez d'habitants, ie nbHabitant < nbEmployes, 
Les commerces perdent de l'argent (avec un certain coeff) **/


// pompier :	2 niveaux

// police :	police municipale
// 			gendarmerie

// energie :	

// bureaux :	3 niveaux

// industrie :	3 niveaux

// ecoles :	primaire
// 		collège / lycée
// 		université
// 		enseeiht

// Banques :
// Parc :	
// Décharges

// Parking : voiture/velo

// tourisme :	hotel
// 		musées
// 		eglise
