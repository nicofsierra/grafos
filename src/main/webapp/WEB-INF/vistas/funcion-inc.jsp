<%@include file="../../includes/head.jsp"%>


<body>
	<div class="container">

		<%@include file="../../includes/header.jsp"%>

		<section>
			<c:set var="aristaActual" scope="session" value="${aristaActual}"></c:set>
			<h3>Vertices: ${vertices} - Aristas: ${aristas}</h3>

			<form method="GET" action="carga-func-incidencia">
				<div class="form-group">
					<label for="vertice1"> Vertice 1 </label> <input type="text"
						class="form-control" name="vertice1"
						aria-describedby="verticesHelp"> <small id="verticesHelp"
						class="form-text text muted"> Ingrese vertice 1</small>
				</div>
				<div class="form-group">
					<label for="aristas"> Vertice 2 </label> <input type="text"
						class="form-control" name="vertice2" aria-describedby="aristaHelp">
					<small id="aristaHelp" class="form-text text muted">
						Ingrese vertice 2</small>
				</div>
				<input type="hidden" name="idGrafo" value="${grafo}" />
				<div class="form-group">
					<button class="btn btn-primary" type="submit">Agregar</button>
				</div>

			</form>

			<table class="table table-dark">
				<thead>
					<tr>
						<th scope="col">Arista</th>
						<th scope="col">Extremo</th>
						<th scope="col">Extremo</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${extremos }" var="extremo">
						<tr>
							<td>${arista }</td>
							<td>${extremo.vertice1 }</td>
							<td>${extremo.vertice2 }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</section>
		
		<aside>
			<%@include file="../../includes/mensaje.jsp"%>
		</aside>
	</div>
</body>
</html>