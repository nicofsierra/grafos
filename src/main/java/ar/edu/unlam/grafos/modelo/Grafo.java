package ar.edu.unlam.grafos.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Grafo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	
	@OneToMany(mappedBy="grafo")
	private List<Arista> arista; //= new ArrayList<>();
	
	@OneToMany(mappedBy="grafo")
	private List<Vertice> vertice;// = new ArrayList<>();
	
	@OneToOne(mappedBy="grafo")
	private FuncionIncidencia funcionIncidencia;// = new FuncionIncidencia();
	
	public Grafo() {}

	
	public Grafo(Long id, String nombre, List<Arista> arista, List<Vertice> vertice,
			FuncionIncidencia funcionIncidencia) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.arista = arista;
		this.vertice = vertice;
		this.funcionIncidencia = funcionIncidencia;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Arista> getArista() {
		return arista;
	}

	public void setArista(List<Arista> arista) {
		this.arista = arista;
	}

	public List<Vertice> getVertice() {
		return vertice;
	}

	public void setVertice(List<Vertice> vertice) {
		this.vertice = vertice;
	}

	public FuncionIncidencia getFuncionIncidencia() {
		return funcionIncidencia;
	}

	public void setFuncionIncidencia(FuncionIncidencia funcionIncidencia) {
		this.funcionIncidencia = funcionIncidencia;
	}
}
