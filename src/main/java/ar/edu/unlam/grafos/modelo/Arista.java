package ar.edu.unlam.grafos.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Arista {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private Integer nombre;
	
	@ManyToOne
	@JoinColumn(name="grafo")
	private Grafo grafo;// = new Grafo();
	
	public Arista() {}
	
	public Arista(Long id, Integer nombre, Grafo grafo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.grafo = grafo;
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

}
