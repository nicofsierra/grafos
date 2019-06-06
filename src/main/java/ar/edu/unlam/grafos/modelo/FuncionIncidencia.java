package ar.edu.unlam.grafos.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class FuncionIncidencia {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@JoinColumn(name="grafo")
	private Grafo grafo;// = new Grafo();
	
	@OneToMany(mappedBy="funcionIncidencia")
	private List<Par> par;// = new ArrayList<>();
	
	public FuncionIncidencia () {}

	public FuncionIncidencia(Long id, String nombre, Grafo grafo, List<Par> par) {
		super();
		this.id = id;
		this.grafo = grafo;
		this.par = par;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Grafo getGrafo() {
		return grafo;
	}

	public void setGrafo(Grafo grafo) {
		this.grafo = grafo;
	}

	public List<Par> getPar() {
		return par;
	}

	public void setPar(List<Par> par) {
		this.par = par;
	}
}
