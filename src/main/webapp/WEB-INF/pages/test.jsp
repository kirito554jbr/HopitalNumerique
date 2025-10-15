<%--
  Created by IntelliJ IDEA.
  User: Youcode
  Date: 10/14/2025
  Time: 10:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body class="bg-light d-flex">
<!-- Main Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container-fluid">
        <a class="navbar-brand" href="index.jsp">Accueil</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="docteur.jsp">Docteurs</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="departement.jsp">Départements</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="salle">Salles</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- Main Content -->
<div class="d-flex w-100" style="margin-top: 56px;"><!-- Main Content Area -->
    <section class="container-fluid p-4" style="flex: 1;">
        <h1 class="mb-4">Gestion des Salles</h1>

        <!-- Formulaire d'ajout ou de modification -->
        <form action="salle" method="post" class="bg-white p-4 mb-4 rounded shadow-sm">
            <input type="hidden" name="action" value="create">
            <div class="mb-3">
                <label class="form-label">Nom :</label>
                <input type="text" name="nomSalle" class="form-control" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Capacité :</label>
                <input type="number" name="capacite" class="form-control" required>
            </div>
            <button type="submit" class="btn btn-primary">Enregistrer</button>
        </form>

        <table class="table table-striped table-bordered">
            <thead class="table-primary">
            <tr>
                <th>ID</th>
                <th>Nom de la Salle</th>
                <th>Capacité</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="s" items="${salles}">
                <tr>
                    <td>${s.idSalle}</td>
                    <td>${s.nomSalle}</td>
                    <td>${s.capacite}</td>
                    <td>
                        <button type="button" class="btn btn-warning btn-sm"
                                data-bs-toggle="modal"
                                data-bs-target="#editModal"
                                data-id="${s.idSalle}"
                                data-nom="${s.nomSalle}"
                                data-capacite="${s.capacite}">
                            Modifier
                        </button>

                        <form action="salle" method="post" style="display:inline;">
                            <input type="hidden" name="action" value="delete">
                            <input type="hidden" name="idSalle" value="${s.idSalle}">
                            <button type="submit" class="btn btn-danger btn-sm"
                                    onclick="return confirm('Supprimer cette salle ?');">
                                Supprimer
                            </button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <a href="index.jsp" class="m-2">⬅ Retour à l'accueil</a>
    </section>

    <!-- Sidebar -->
    <div class="bg-white border-start" style="width: 300px; min-height: calc(100vh - 56px);">
        <div class="p-3">
            <h4>Statistiques</h4>
            <hr>
            <ul class="list-unstyled">
                <li class="mb-2">Total des salles: ${salles.size()}</li>
                <li class="mb-2">Capacité moyenne: XX places</li>
                <li class="mb-2">Salles disponibles: XX</li>
            </ul>
            <hr>
            <h5>Actions rapides</h5>
            <div class="d-grid gap-2">
                <button class="btn btn-outline-primary btn-sm">Exporter les données</button>
                <button class="btn btn-outline-secondary btn-sm">Imprimer la liste</button>
            </div>
        </div>
    </div>
</div>

<div class="m-2" style="position: absolute; bottom: 0; width: 100%;">
    <a href="index.jsp" class="btn btn-outline-primary btn-sm w-100">⬅ Retour à l’accueil</a>
</div>


</section>
        <div class="m-2" style="position: absolute; bottom: 0; width: 100%;">
            <a href="index.jsp" class="btn btn-outline-primary btn-sm w-100">⬅ Retour à l’accueil</a>
        </div>
</section>

    <div class="bg-white border-start bg-primary-subtle" style="width: 300px; min-height: calc(100vh - 56px); position: relative;">
        <div class="m-2" style="position: absolute; bottom: 0; width: calc(100% - 1rem);">
            <a href="index.jsp" class="btn btn-outline-primary btn-sm w-100">⬅ Retour à l'accueil</a>
        </div>
    </div>

</script>
</body>
</html>
</html>
