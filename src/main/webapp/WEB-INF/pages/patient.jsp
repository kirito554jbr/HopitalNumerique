<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Patient Management</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="index.jsp">Accueil</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link active" href="docteur">Docteurs</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="department">Départements</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="salle">Salles</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="patient">Patients</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<section class="d-flex ">

    <!-- Sidebar -->
    <div class="bg-white border-start bg-primary-subtle" style="width: 300px; min-height: calc(100vh - 56px);">
        <div class="p-3">
            <h4>Statistiques</h4>
            <hr>
            <ul class="list-unstyled">
                <li class="mb-2">Total des docteurs: ${docteurs.size()}</li>
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



    <div class="container mt-5">
        <div class="d-flex justify-content-between align-items-center">
            <h1>Patient Management</h1>
            <button class="btn btn-success mb-4" data-bs-toggle="modal" data-bs-target="#addModal">Ajouter une Patient</button>
        </div>
        <table class="table table-striped table-bordered">
            <thead class="table-dark">
                <tr>
                    <th>ID</th>
                    <th>Nom</th>
                    <th>Prenom</th>
                    <th>Email</th>
                    <th>Poids</th>
                    <th>Taille</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="patient" items="${patients}">
                    <tr>
                        <td>${patient.id}</td>
                        <td>${patient.nom}</td>
                        <td>${patient.prenom}</td>
                        <td>${patient.email}</td>
                        <td>${patient.poids}</td>
                        <td>${patient.taille}</td>
                        <td>
                                <!-- EDIT BUTTON -->
                            <button type="button" class="btn btn-warning btn-sm"
                                    data-bs-toggle="modal"
                                    data-bs-target="#editModal"
                                    data-id="${patient.id}"
                                    data-nom="${patient.nom}"
                                    data-prenom="${patient.prenom}"
                                    data-email="${patient.email}"
                                    data-password="${patient.password}"
                                    data-poids="${patient.poids}"
                                    data-taille="${patient.taille}">
                                Modifier
                            </button>

                            <form action="patient" method="post" style="display:inline;">
                                <input type="hidden" name="action" value="delete">
                                <input type="hidden" name="id" value="${patient.id}">
                                <button type="submit" class="btn btn-danger btn-sm"
                                        onclick="return confirm('Supprimer cette patient ?');">
                                    Supprimer
                                </button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</section>




<!-- MODAL SECTION -->


<!-- 🔵 ADD MODAL -->
<div class="modal fade" id="addModal" tabindex="-1" aria-labelledby="addModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="patient" method="post">
                <div class="modal-header">
                    <h5 class="modal-title" id="addModalLabel">Ajouter une Salle</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>

                <div class="modal-body">
                    <input type="hidden" name="action" value="create">

                    <div class="mb-3">
                        <label class="form-label">Nom :</label>
                        <input type="text" name="nom" class="form-control" required>
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Prenom :</label>
                        <input type="text" name="prenom" class="form-control" required>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Email :</label>
                        <input type="email" name="email" class="form-control" required>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Password :</label>
                        <input type="password" name="password" class="form-control" required>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Poids (kg) :</label>
                        <input type="number" step="0.1" name="poids" class="form-control" required>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Taille (cm) :</label>
                        <input type="number" step="0.1" name="taille" class="form-control" required>
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
            <form action="patient" method="post">
                <div class="modal-header">
                    <h5 class="modal-title" id="editModalLabel">Modifier la Salle</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>

                <div class="modal-body">
                    <input type="hidden" name="action" value="update">
                    <input type="hidden" name="id" id="editId">
                    <div class="mb-3">
                        <label class="form-label">Nom :</label>
                        <input type="text" name="nom" id="editNom" class="form-control" required>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Prenom :</label>
                        <input type="text" name="prenom" id="editPrenom" class="form-control" required>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Email :</label>
                        <input type="email" name="email" id="editEmail" class="form-control" required>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Password :</label>
                        <input type="password" name="password" id="editPassword" class="form-control" required>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Poids (kg) :</label>
                        <input type="number" step="0.1" name="poids" id="editPoids" class="form-control" required>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Taille (cm) :</label>
                        <input type="number" step="0.1" name="taille" id="editTaille" class="form-control" required>
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
        const prenom = button.getAttribute('data-prenom');
        const email = button.getAttribute('data-email');
        const password = button.getAttribute('data-password');
        const poids = button.getAttribute('data-poids');
        const taille = button.getAttribute('data-taille');

        // Fill modal fields
        document.getElementById('editId').value = id;
        document.getElementById('editNom').value = nom;
        document.getElementById('editPrenom').value = prenom;
        document.getElementById('editEmail').value = email;
        document.getElementById('editPassword').value = password;
        document.getElementById('editPoids').value = poids;
        document.getElementById('editTaille').value = taille;
    });
</script>


</body>
</html>