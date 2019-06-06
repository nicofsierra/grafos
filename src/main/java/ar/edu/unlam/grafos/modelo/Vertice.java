package ar.edu.unlam.grafos.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Vertice {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private Integer nombre;
	
	@ManyToOne
	@JoinColumn(name="grafo")
	private Grafo grafo;// = new Grafo();
	
	@OneToMany(mappedBy="vertice1")
	private List<Par> parInicio;// = new ArrayList<>();
	
	@OneToMany(mappedBy="vertice2")
	private List<Par> parFinal;// = new ArrayList<>();
	
	public Vertice() {}

	

	public Vertice(Long id, Integer nombre, Grafo grafo, List<Par> parInicio, List<Par> parFinal) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.grafo = grafo;
		this.parInicio = parInicio;
		this.parFinal = parFinal;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNombre() {
		return nombre;
	}

	public void setNombre(Integer nombre) {
		this.nombre = nombre;
	}

	public Grafo getGrafo() {
		return grafo;
	}

	public void setGrafo(Grafo grafo) {
		this.grafo = grafo;
	}

	public List<Par> getParInicio() {
		return parInicio;
	}

	public void setParInicio(List<Par> parInicio) {
		this.parInicio = parInicio;
	}

	public List<Par> getParFinal() {
		return parFinal;
	}

	public void setParFinal(List<Par> parFinal) {
		this.parFinal = parFinal;
	}
	
}