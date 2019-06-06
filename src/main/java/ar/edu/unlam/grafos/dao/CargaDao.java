package ar.edu.unlam.grafos.dao;

import java.util.List;

import ar.edu.unlam.grafos.modelo.Arista;
import ar.edu.unlam.grafos.modelo.FuncionIncidencia;
import ar.edu.unlam.grafos.modelo.Grafo;
import ar.edu.unlam.grafos.modelo.Par;
import ar.edu.unlam.grafos.modelo.Vertice;

public interface CargaDao {
	
	public Long cargaGrafo(Grafo grafo);
	public Long cargarVertices(Vertice vertice);
	public Long cargaAristas(Arista arista);
	public Long cargaIncidencia(FuncionIncidencia incidencia);
	public Long cargaPares(Par par);
	
	public Vertice buscarVertices(Long idGrafo,Integer vertice);
	public Arista buscarArista(Long idGrafo,Integer arista);
	public FuncionIncidencia buscarFuncIncidencia( Long idGrafo);
	public Integer buscarVerticeMaximo(Long idGrafo);
	public Integer buscarAristaMaxima(Long idGrafo);

	public List<Par> buscarTodosLosParesDeUnGrafo( Long idFuncInc);


}
