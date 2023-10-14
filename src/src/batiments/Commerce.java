package src.batiments;
import src.carte.*;

public abstract class Commerce extends Batiment {	

	// private static String img = "../Images/img_commerce.jpg";

    private String nom;
    private int nbEmployes;
    private int valorisationEmplois;
    private int maxEmployes;


	public Commerce(String nom, Case coin, int rotation, Carte carte, Parcelle[] parcelles,int[] accesRoutes,
			int attractivite, int valorisationEmplois, int maxEmployes, int niveau, int tempsConstruction, int coutConstruction) {
		
		super(coin, rotation, carte, parcelles, accesRoutes, attractivite, niveau, tempsConstruction, coutConstruction);
		this.nom = nom;
		this.nbEmployes = 0;
        this.valorisationEmplois = valorisationEmplois;
        this.maxEmployes = maxEmployes;
	}

	
	public Commerce(String nom, Case coin, Carte carte, Parcelle[] parcelles, 
			int[] accesRoutes, int niveau, int tempsConstruction, int coutConstruction) {
		
		super(coin, 1, carte, parcelles, accesRoutes, 5, niveau, tempsConstruction, coutConstruction);
		this.nom = nom;
		setCommerceNiveau(niveau);
	}
	
	
	public void setCommerceNiveau(int niveau) {
		switch (niveau) {
			case 1 : 
				this.nbEmployes = 0;
				this.valorisationEmplois = 3;
				this.maxEmployes = 20;
				break;
			case 2 :
				this.nbEmployes = 0;
				this.valorisationEmplois = 5;
				this.maxEmployes = 50;
				break;
			case 3 : 
				this.nbEmployes = 0;
				this.valorisationEmplois = 7;
				this.maxEmployes = 100;
				break;
			default :
				throw new NiveauInvalideException("niveau " + niveau + " inconnu", niveau);
		}
		
	}
	

	@Override
	public void ameliorer() {
		switch (this.getNiveau()) {
			case 1:
			case 2:
			case 3:
			default :
				throw new NiveauInvalideException("niveau " + this.getNiveau() + " inconnu", this.getNiveau());
		}
	}


	/* Il faudra définir un certain nombre d'employé, attractivité et valorisation de
	l'emploi en fonction du commerce soit en créant des sous-classes de commerce,
	soit en créant directement ces commerces à l'aide du 1er constructeur*/
	
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

    public int getValorisationEmplois() {
		return this.valorisationEmplois;
	}

	public void setValorisationEmplois(int valorisationEmplois) {
		this.valorisationEmplois = valorisationEmplois;
	}

	public int getNbEmployes() {
		return this.nbEmployes;
	}

	public void setNbEmployes(int nbEmployes) {
		this.nbEmployes = nbEmployes;
	}

	public int getMaxEmployes() {
		return this.maxEmployes;
	}

	public void setMaxEmployes(int capaciteMaxEmployes) {
		this.maxEmployes = capaciteMaxEmployes;
	}
	

}