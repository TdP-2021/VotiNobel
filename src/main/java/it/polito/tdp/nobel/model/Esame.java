package it.polito.tdp.nobel.model;

public class Esame {

	private String codins;
	private String nomeCorso;
	private int voto;
	private int crediti;

	public Esame() {

	}

	public Esame(String codins, String nomecorso, int crediti, int voto) {
		this.codins = codins;
		this.nomeCorso = nomecorso;
		this.voto = voto;
		this.crediti = crediti;
	}

	public String getCodins() {
		return codins;
	}

	public void setCodins(String codins) {
		this.codins = codins;
	}

	public int getVoto() {
		return voto;
	}

	public void setVoto(int voto) {
		this.voto = voto;
	}
	
	public int getCrediti() {
		return crediti;
	}

	public void setCrediti(int crediti) {
		this.crediti = crediti;
	}
	
	public String getNomeCorso() {
		return nomeCorso;
	}

	public void setNomeCorso(String nomeCorso) {
		this.nomeCorso = nomeCorso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codins == null) ? 0 : codins.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Esame other = (Esame) obj;
		if (codins == null) {
			if (other.codins != null)
				return false;
		} else if (!codins.equals(other.codins))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("codins: %-6s  crediti: %-2d  voto: %-2d  %s", codins, crediti, voto, nomeCorso);
	}

}
