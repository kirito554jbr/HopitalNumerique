<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- replace lines 56 to 66 -->
<html>
<head>
    <title>Gestion des Salles</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body class="bg-light">

<nav class="navbar navbar-expand-lg navbar-dark bg-dark ">
    <div class="container-fluid">
        <a class="navbar-brand" href="index.jsp">Accueil</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="docteur">Docteurs</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="department">Départements</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="salle">Salles</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="patient">Patients</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<section class="d-flex">

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
        <div class="m-2" style="position: absolute; bottom: 0;width: 214px;">
            <a href="index.jsp" class="btn btn-outline-primary btn-sm w-100">⬅ Retour à l’accueil</a>
        </div>
    </div>


    <section class="container m-5">

        <div class="d-flex justify-content-between align-items-center">
            <h1 class="mb-4">Gestion des Salles</h1>
            <button class="btn btn-success mb-4" data-bs-toggle="modal" data-bs-target="#addModal">Ajouter une Salle
            </button>
        </div>


        <table class="table table-striped table-bordered">
            <thead class="table-dark">
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
                        <!-- EDIT BUTTON -->
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
    </section>


</section>

<!-- MODAL SECTION -->


<!-- 🔵 ADD MODAL -->
<div class="modal fade" id="addModal" tabindex="-1" aria-labelledby="addModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="salle" method="post">
                <div class="modal-header">
                    <h5 class="modal-title" id="addModalLabel">Ajouter une Salle</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>

                <div class="modal-body">
                    <input type="hidden" name="action" value="create">

                    <div class="mb-3">
                        <label class="form-label">Nom :</label>
                        <input type="text" name="nomSalle" class="form-control" required>
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Capacité :</label>
                        <input type="number" name="capacite" class="form-control" required>
                    </div>
                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Annuler</button>
                    <button type="submit" class="btn btn-primary">Ajouter</button>
                </div>
            </form>
        </div>
    </div>
</div>

<!-- 🟢 EDIT MODAL -->
<div class="modal fade" id="editModal" tabindex="-1" aria-labelledby="editModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="salle" method="post">
                <div class="modal-header">
                    <h5 class="modal-title" id="editModalLabel">Modifier la Salle</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>

                <div class="modal-body">
                    <input type="hidden" name="action" value="update">
                    <input type="hidden" name="idSalle" id="editId">

                    <div class="mb-3">
                        <label class="form-label">Nom :</label>
                        <input type="text" name="nomSalle" id="editNom" class="form-control" required>
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Capacité :</label>
                        <input type="number" name="capacite" id="editCapacite" class="form-control" required>
                    </div>
                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Annuler</button>
                    <button type="submit" class="btn btn-primary">Enregistrer les modifications</button>
                </div>
            </form>
        </div>
    </div>
</div>

<!-- 🧠 SCRIPT TO FILL MODAL -->
<script>
    const editModal = document.getElementById('editModal');
    editModal.addEventListener('show.bs.modal', function (event) {
        const button = event.relatedTarget;
        const id = button.getAttribute('data-id');
        const nom = button.getAttribute('data-nom');
        const capacite = button.getAttribute('data-capacite');

        // Fill modal fields
        document.getElementById('editId').value = id;
        document.getElementById('editNom').value = nom;
        document.getElementById('editCapacite').value = capacite;
    });
</script>
</body>
</html>