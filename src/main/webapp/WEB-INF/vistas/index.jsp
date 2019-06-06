<%@include file="../../includes/head.jsp"%>


<body>
	<div class="container">

		<%@include file="../../includes/header.jsp"%>

		<section>

			<form method="GET" action="cargar-grafo">
				<div class="form-group">
					<label for="vertices"> Vertices </label> <input type="text"
						class="form-control" name="vertices" aria-describedby="verticesHelp">
						<small id="verticesHelp" class="form-text text muted"> Ingrese cantidad de Vertices</small>
				</div>
				<div class="form-group">
					<label for="aristas"> Aristas </label> <input type="text"
						class="form-control" name="aristas" aria-describedby="aristaHelp">
						<small id="aristaHelp" class="form-text text muted"> Ingrese cantidad de Aristas</small>
				</div>
				<div class="form-group">
					<button class="btn btn-primary" type="submit">Procesar</button>
				</div>

			</form>

		</section>
		<aside>
			<%@include file="../../includes/mensaje.jsp"%>	
		</aside>
	</div>
</body>
</html>