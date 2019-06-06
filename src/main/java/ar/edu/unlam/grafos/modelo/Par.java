package ar.edu.unlam.grafos.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Par {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="funcionIncidencia")
	private FuncionIncidencia funcionIncidencia;// = new FuncionIncidencia();
	
	@ManyToOne
	@JoinColumn(name="vertice1")
	private Vertice vertice1;// = new Vertice();
	
	@ManyToOne
	@JoinColumn(name="vertice2")
	private Vertice vertice2;// = new Vertice();
	
	public Par() {}
	
	

	
	public Par(Long id, FuncionIncidencia funcionIncidencia, Vertice vertice1, Vertice vertice2) {
		super();
		this.id = id;
		this.funcionIncidencia = funcionIncidencia;
		this.vertice1 = vertice1;
		this.vertice2 = vertice2;
	}




	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public FuncionIncidencia getFuncionIncidencia() {
		return funcionIncidencia;
	}

	public void setFuncionIncidencia(FuncionIncidencia funcionIncidencia) {
		this.funcionIncidencia = funcionIncidencia;
	}

	public Vertice getVertice1() {
		return vertice1;
	}

	public void setVertice1(Vertice vertice1) {
		this.vertice1 = vertice1;
	}

	public Vertice getVertice2() {
		return vertice2;
	}

	public void setVertice2(Vertice vertice2) {
		this.vertice2 = vertice2;
	}
}
