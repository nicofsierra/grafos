package ar.edu.unlam.grafos.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.JDBCException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.grafos.modelo.Arista;
import ar.edu.unlam.grafos.modelo.FuncionIncidencia;
import ar.edu.unlam.grafos.modelo.Grafo;
import ar.edu.unlam.grafos.modelo.Par;
import ar.edu.unlam.grafos.modelo.Vertice;

@Repository("cargaDao")
public class CargaDaoImpl implements CargaDao{
	
	@Inject
	private SessionFactory sessionFactory;
	
	@Override
	public Long cargaGrafo(Grafo grafo){
		final Session session = sessionFactory.getCurrentSession();
		try{
			session.save(grafo);
			return grafo.getId();
		}catch(JDBCException e){
			return 0L;
		}
	}
	@Override
	public Long cargarVertices(Vertice vertice){
		final Session session = sessionFactory.getCurrentSession();
		try{
			session.save(vertice);
			return vertice.getId();
		}catch(JDBCException e){
			return 0L;
		}
	}
	@Override
	public Long cargaAristas(Arista arista){
		final Session session = sessionFactory.getCurrentSession();
		try{
			session.save(arista);
			return arista.getId();
		}catch(JDBCException e){
			return 0L;
		}
	}
	@Override
	public Long cargaIncidencia(FuncionIncidencia incidencia){
		final Session session = sessionFactory.getCurrentSession();
		try{
			session.save(incidencia);
			return incidencia.getId();
		}catch(JDBCException e){
			return 0L;
		}
	}
	@Override
	public Long cargaPares(Par par){
		final Session session = sessionFactory.getCurrentSession();
		try{
			session.save(par);
			return par.getId();
		}catch(JDBCException e){
			return 0L;
		}
	}
	@Override
	public Vertice buscarVertices(Long idGrafo,Integer vertice){
		final Session session = sessionFactory.getCurrentSession();
		return (Vertice) session.createCriteria(Vertice.class,"vertice")
				.createAlias("grafo", "grafo")
				.add(Restrictions.and(Restrictions.eq("grafo.id", idGrafo ),Restrictions.eq("vertice.nombre", vertice)))
				.uniqueResult();
	}
	@Override
	public Arista buscarArista(Long idGrafo,Integer arista){
		final Session session = sessionFactory.getCurrentSession();
		return (Arista) session.createCriteria(Arista.class,"arista")
				.createAlias("grafo", "grafo")
				.add(Restrictions.and(Restrictions.eq("grafo.id", idGrafo ),Restrictions.eq("arista.nombre", arista)))
				.uniqueResult();
	}
	
	@Override
	public Integer buscarVerticeMaximo(Long idGrafo){
		final Session session = sessionFactory.getCurrentSession();
		return (Integer) session.createCriteria(Vertice.class,"v").createAlias("grafo", "g").setProjection(Projections.max("v.nombre")).
				add(Restrictions.eq("g.id", idGrafo)).uniqueResult();
	}
	@Override
	public Integer buscarAristaMaxima(Long idGrafo){
		final Session session = sessionFactory.getCurrentSession();
		return (Integer) session.createCriteria(Arista.class,"a").createAlias("grafo", "g").setProjection(Projections.max("a.nombre")).
				add(Restrictions.eq("g.id", idGrafo)).uniqueResult();
	}
	@Override
	public FuncionIncidencia buscarFuncIncidencia( Long idGrafo ){
		final Session session = sessionFactory.getCurrentSession();
		return (FuncionIncidencia) session.createCriteria(FuncionIncidencia.class,"fi")
				.createAlias("grafo","g").add(Restrictions.eq("grafo.id", idGrafo)).uniqueResult();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Par> buscarTodosLosParesDeUnGrafo( Long idFuncInc){
		final Session session = sessionFactory.getCurrentSession();
		return (List<Par>) session.createCriteria(Par.class,"par").createAlias("funcionIncidencia", "fi")
				.add(Restrictions.eq("fi.id", idFuncInc)).list();
	}

}
