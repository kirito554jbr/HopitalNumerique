<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Consultation</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-50">
<%@ include file="./includes/doctor-header.jsp" %>

<div class="max-w-5xl mx-auto px-4 sm:px-6 lg:px-8 py-8">
    <div class="mb-8">
        <a href="${pageContext.request.contextPath}/doctor/dashboard" class="text-indigo-600 hover:text-indigo-700 font-medium inline-flex items-center">
            <svg class="w-5 h-5 mr-2" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M15 19l-7-7 7-7"></path>
            </svg>
            Retour au tableau de bord
        </a>
        <h1 class="text-3xl font-bold text-gray-900 mt-4">Consultation</h1>
    </div>

    <div class="grid grid-cols-1 lg:grid-cols-3 gap-6">
        Patient Info
        <div class="lg:col-span-1">
            <div class="bg-white rounded-xl shadow-sm p-6 border border-gray-100 sticky top-8">
                <h2 class="text-lg font-bold text-gray-900 mb-4">Informations patient</h2>
                <div class="space-y-3">
                    <div>
                        <p class="text-sm text-gray-600">Nom complet</p>
                        <p class="font-semibold text-gray-900">${consultation.patient.nom} ${consultation.patient.prenom}</p>
                    </div>
                    <div>
                        <p class="text-sm text-gray-600">Email</p>
                        <p class="text-gray-900">${consultation.patient.email}</p>
                    </div>
                    <div class="grid grid-cols-2 gap-3">
                        <div>
                            <p class="text-sm text-gray-600">Poids</p>
                            <p class="font-semibold text-gray-900">${consultation.patient.poids} kg</p>
                        </div>
                        <div>
                            <p class="text-sm text-gray-600">Taille</p>
                            <p class="font-semibold text-gray-900">${consultation.patient.taille} cm</p>
                        </div>
                    </div>
                    <div>
                        <p class="text-sm text-gray-600">IMC</p>
                        <p class="font-semibold text-gray-900">
                            <fmt:formatNumber value="${consultation.patient.poids / ((consultation.patient.taille / 100) * (consultation.patient.taille / 100))}" maxFractionDigits="1"/>
                        </p>
                    </div>
                </div>

                <div class="mt-6 pt-6 border-t border-gray-200">
                    <h3 class="text-sm font-semibold text-gray-900 mb-2">Rendez-vous</h3>
                    <p class="text-sm text-gray-600">
                        <fmt:formatDate value="${consultation.date}" pattern="dd/MM/yyyy"/> à
                        <fmt:formatDate value="${consultation.heure}" pattern="HH:mm"/>
                    </p>
                    <p class="text-sm text-gray-600 mt-1">Salle: ${consultation.salle.nomSalle}</p>
                </div>

                <c:if test="${not empty patientHistory}">
                    <div class="mt-6 pt-6 border-t border-gray-200">
                        <h3 class="text-sm font-semibold text-gray-900 mb-3">Historique récent</h3>
                        <div class="space-y-2">
                            <c:forEach var="past" items="${patientHistory}" end="2">
                                <div class="text-sm">
                                    <p class="text-gray-600">
                                        <fmt:formatDate value="${past.date}" pattern="dd/MM/yyyy"/>
                                    </p>
                                    <p class="text-gray-900 line-clamp-2">${past.compteRendu}</p>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </c:if>
            </div>
        </div>

        Consultation Form
        <div class="lg:col-span-2">
            <div class="bg-white rounded-xl shadow-sm p-6 border border-gray-100">
                <h2 class="text-lg font-bold text-gray-900 mb-4">Compte rendu médical</h2>

                <div class="bg-blue-50 border border-blue-200 rounded-lg p-4 mb-6">
                    <p class="text-sm font-medium text-blue-900 mb-1">Motif de consultation</p>
                    <p class="text-blue-800">${consultation.motif}</p>
                </div>

                <form action="${pageContext.request.contextPath}/doctor/complete-consultation" method="post" class="space-y-6">
                    <input type="hidden" name="consultationId" value="${consultation.idConsultation}">

                    <div>
                        <label for="diagnostic" class="block text-sm font-medium text-gray-700 mb-2">Diagnostic</label>
                        <textarea id="diagnostic" name="diagnostic" rows="6" required
                                  class="w-full px-4 py-3 border border-gray-300 rounded-lg focus:ring-2 focus:ring-indigo-500 focus:border-transparent transition"
                                  placeholder="Décrivez le diagnostic..."></textarea>
                    </div>

                    <div>
                        <label for="traitement" class="block text-sm font-medium text-gray-700 mb-2">Traitement prescrit</label>
                        <textarea id="traitement" name="traitement" rows="6" required
                                  class="w-full px-4 py-3 border border-gray-300 rounded-lg focus:ring-2 focus:ring-indigo-500 focus:border-transparent transition"
                                  placeholder="Décrivez le traitement et les prescriptions..."></textarea>
                    </div>

                    <div>
                        <label for="observations" class="block text-sm font-medium text-gray-700 mb-2">Observations complémentaires</label>
                        <textarea id="observations" name="observations" rows="4"
                                  class="w-full px-4 py-3 border border-gray-300 rounded-lg focus:ring-2 focus:ring-indigo-500 focus:border-transparent transition"
                                  placeholder="Observations, recommandations, suivi..."></textarea>
                    </div>

                    <div class="flex gap-4">
                        <button type="submit"
                                class="flex-1 bg-indigo-600 text-white py-3 rounded-lg font-semibold hover:bg-indigo-700 transition shadow-lg hover:shadow-xl">
                            Terminer la consultation
                        </button>
                        <a href="${pageContext.request.contextPath}/doctor/dashboard"
                           class="px-6 py-3 border-2 border-gray-300 text-gray-700 rounded-lg font-semibold hover:bg-gray-50 transition">
                            Annuler
                        </a>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
