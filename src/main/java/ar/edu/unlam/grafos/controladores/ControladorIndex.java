package ar.edu.unlam.grafos.controladores;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.grafos.modelo.Arista;
import ar.edu.unlam.grafos.modelo.FuncionIncidencia;
import ar.edu.unlam.grafos.modelo.Grafo;
import ar.edu.unlam.grafos.modelo.Par;
import ar.edu.unlam.grafos.modelo.Vertice;
import ar.edu.unlam.grafos.servicios.ServicioCarga;

@Controller
public class ControladorIndex {

	@Inject
	private ServicioCarga servicioCarga;

	@RequestMapping("/")
	public ModelAndView index() {
		return new ModelAndView("index");
	}

	@RequestMapping("/index")
	public ModelAndView irAlIndex() {
		return new ModelAndView("index");
	}

	@RequestMapping("cargar-grafo")
	public ModelAndView cargarGrafos(@RequestParam("vertices") Integer vertices,
			@RequestParam("aristas") Integer aristas, HttpServletRequest request, HttpServletResponse response) {
		ModelMap modelo = new ModelMap();
		Grafo grafo = new Grafo();
		Vertice vertice = new Vertice();
		Arista arista = new Arista();
		FuncionIncidencia incidencia = new FuncionIncidencia();

		grafo.setNombre("provisorio");
		Long idGrafo = servicioCarga.cargaGrafo(grafo);
		incidencia.setGrafo(grafo);
		servicioCarga.cargaIncidencia(incidencia);
		if (idGrafo == 0L) {
			modelo.put("mensaje", "No se pude guardar el grafo");
			return new ModelAndView("index", modelo);
		}

		for (int i = 0; i < vertices; i++) {
			vertice.setGrafo(grafo);
			vertice.setNombre(i + 1);
			servicioCarga.cargarVertices(vertice);
		}
		for (int i = 0; i < aristas; i++) {
			arista.setGrafo(grafo);
			arista.setNombre(i + 1);
			servicioCarga.cargaAristas(arista);
		}

		modelo.put("grafo", idGrafo);
		modelo.put("vertices", vertices);
		modelo.put("aristas", servicioCarga.buscarAristaMaxima(grafo.getId()));
		modelo.put("arista", servicioCarga.buscarAristaMaxima(grafo.getId()));
		request.getSession().setAttribute("aristaActual", servicioCarga.buscarAristaMaxima(grafo.getId()));
		return new ModelAndView("funcion-inc", modelo);

	}

	@RequestMapping("carga-func-incidencia")
	public ModelAndView cargarFuncionIncidencia(@RequestParam("vertice1") Integer vertice1,
			@RequestParam("vertice2") Integer vertice2, @RequestParam("idGrafo") Integer idGrafo,HttpServletRequest request,HttpServletResponse response) {
		Par par = new Par();
		ModelMap modelo = new ModelMap();
		Integer arista = (Integer)request.getSession().getAttribute("aristaActual");
		arista -= 1;
		if( arista >0 ){
			Vertice v1 = servicioCarga.buscarVertices(idGrafo.longValue(), vertice1);
			Vertice v2 = servicioCarga.buscarVertices(idGrafo.longValue(), vertice2);
			par.setVertice1(v1);
			par.setVertice2(v2);
			par.setFuncionIncidencia(servicioCarga.buscarFuncIncidencia(idGrafo.longValue()));
			servicioCarga.cargaPares(par);
			modelo.put("grafo", idGrafo);
			modelo.put("aristas", servicioCarga.buscarAristaMaxima(idGrafo.longValue()));
			modelo.put("vertices",servicioCarga.buscarVerticeMaximo(idGrafo.longValue()));
			modelo.put("arista", arista);
			modelo.put("extremos", servicioCarga.buscarTodosLosParesDeUnGrafo(servicioCarga.buscarFuncIncidencia(idGrafo.longValue()).getId()));
			return new ModelAndView("funcion-inc",modelo);
		}else{
			modelo.put("mensaje","No existen mas aristas para cargar.");
			return new ModelAndView("funcion-inc",modelo);
		}
	}
}
