package src.routes;

import src.Structure;
import src.carte.Case;

public class RouteGenerale extends Structure {

	private Cardinal cardinal;
	private Case kase;

	RouteGenerale(Case kase, Cardinal cardinal) {
		this.kase = kase;
		this.cardinal = cardinal;
	}

	public Cardinal getCardinal() {
		return this.cardinal;
	}

	public void setCardinal(Cardinal cardinal) {
		this.cardinal = cardinal;
	}

	@Override
	public Case[] getCases() {
		Case[] ret = new Case[1];
		ret[0] = this.kase;
		return ret;
	}

	@Override
	public Case getCoin() {
		return this.kase;
	}

	@Override
	public void setCoin(Case coin) {
		this.kase = coin;
	}
}
