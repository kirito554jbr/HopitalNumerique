
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Create Department</title>
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
                    <a class="nav-link" href="docteur">Docteurs</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="department">Départements</a>
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
                <li class="mb-2">Total des departements: ${departments.size()}</li>
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
            <h1>Gestion Department</h1>
            <button class="btn btn-success mb-4" data-bs-toggle="modal" data-bs-target="#addModal">Ajouter une departement</button>
        </div>

<%--        <div class="card">--%>
<%--            <div class="card-body">--%>
                <table class="table table-striped table-bordered">
                    <thead class="table-dark">

                    <tr>
                        <th>Id</th>
                        <th>Department Name</th>
                        <th>Actions</th>
                    </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="department" items="${departments}">
                            <tr>
                                <td>${department.idDepartment}</td>
                                <td>${department.nom}</td>
                                <td>
                                    <!-- EDIT BUTTON -->
                                    <button type="button" class="btn btn-warning btn-sm"
                                            data-bs-toggle="modal"
                                            data-bs-target="#editModal"
                                            data-id="${department.idDepartment}"
                                            data-nom="${department.nom}">
                                        Modifier
                                    </button>

                                    <form action="department" method="post" style="display:inline;">
                                        <input type="hidden" name="action" value="delete">
                                        <input type="hidden" name="deptId" value="${department.idDepartment}">
                                        <button type="submit" class="btn btn-danger btn-sm"
                                                onclick="return confirm('Supprimer ce département ?');">
                                            Supprimer
                                        </button>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
<%--                        <form action="createDepartment" method="post">--%>
<%--                            <label for="deptName">Department Name:</label>--%>
<%--                            <input type="text" id="deptName" name="deptName" required>--%>
<%--                            <br><br>--%>
<%--                            <label for="deptDesc">Description:</label>--%>
<%--                            <input type="text" id="deptDesc" name="deptDesc">--%>
<%--                            <br><br>--%>
<%--                            <input type="submit" value="Create">--%>
<%--                        </form>--%>

                </table>
<%--            </div>--%>
<%--        </div>--%>
    </section>
</section>




<!-- 🔵 ADD MODAL -->
<div class="modal fade" id="addModal" tabindex="-1" aria-labelledby="addModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="department" method="post">
                <div class="modal-header">
                    <h5 class="modal-title" id="addModalLabel">Ajouter une Departement</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>

                <div class="modal-body">
                    <input type="hidden" name="action" value="create">

                    <div class="mb-3">
                        <label class="form-label">Nom :</label>
                        <input type="text" name="nom" class="form-control" required>
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
            <form action="department" method="post">
                <div class="modal-header">
                    <h5 class="modal-title" id="editModalLabel">Modifier la Departement</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>

                <div class="modal-body">
                    <input type="hidden" name="action" value="update">
                    <input type="hidden" name="id" id="editId">

                    <div class="mb-3">
                        <label class="form-label">Nom :</label>
                        <input type="text" name="nom" id="editNom" class="form-control" required>
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

        // Fill modal fields
        document.getElementById('editId').value = id;
        document.getElementById('editNom').value = nom;
    });
</script>
</body>
</html>