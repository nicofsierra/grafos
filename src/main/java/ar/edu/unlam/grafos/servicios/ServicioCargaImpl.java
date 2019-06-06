package ar.edu.unlam.grafos.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.grafos.dao.CargaDao;
import ar.edu.unlam.grafos.modelo.Arista;
import ar.edu.unlam.grafos.modelo.FuncionIncidencia;
import ar.edu.unlam.grafos.modelo.Grafo;
import ar.edu.unlam.grafos.modelo.Par;
import ar.edu.unlam.grafos.modelo.Vertice;

@Service("servicioCarga")
@Transactional
public class ServicioCargaImpl implements ServicioCarga{
	
	@Inject
	private CargaDao cargaDao;
	
	@Override
	public Long cargaGrafo(Grafo grafo){
		return cargaDao.cargaGrafo(grafo);
	}
	@Override
	public Long cargarVertices(Vertice vertice){
		return cargaDao.cargarVertices(vertice);
	}
	@Override
	public Long cargaAristas(Arista arista){
		return cargaDao.cargaAristas(arista);
	}
	@Override
	public Long cargaIncidencia(FuncionIncidencia incidencia){
		return cargaDao.cargaIncidencia(incidencia);
	}
	@Override
	public Long cargaPares(Par par){
		return cargaDao.cargaPares(par);
	}
	@Override
	public Vertice buscarVertices(Long idGrafo,Integer vertice){
		return cargaDao.buscarVertices(idGrafo,vertice);
	}
	@Override
	public Arista buscarArista(Long idGrafo,Integer arista){
		return cargaDao.buscarArista(idGrafo,arista);
	}
	@Override
	public Integer buscarVerticeMaximo(Long idGrafo){
		return cargaDao.buscarVerticeMaximo(idGrafo);
	}
	@Override
	public Integer buscarAristaMaxima(Long idGrafo){
		return cargaDao.buscarAristaMaxima(idGrafo);
	}
	@Override
	public FuncionIncidencia buscarFuncIncidencia( Long idGrafo){
		return cargaDao.buscarFuncIncidencia(idGrafo);
	}
	@Override
	public List<Par> buscarTodosLosParesDeUnGrafo( Long idFuncInc){
		return cargaDao.buscarTodosLosParesDeUnGrafo(idFuncInc);
	}

}
