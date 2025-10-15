<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header class="bg-white border-b border-gray-200 sticky top-0 z-40">
    <div class="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
        <div class="flex items-center justify-between h-16">
            <div class="flex items-center">
                <a href="${pageContext.request.contextPath}/doctor/dashboard" class="flex items-center">
                    <div class="bg-green-600 rounded-lg p-2">
                        <svg class="w-6 h-6 text-white" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M19 21V5a2 2 0 00-2-2H7a2 2 0 00-2 2v16m14 0h2m-2 0h-5m-9 0H3m2 0h5M9 7h1m-1 4h1m4-4h1m-1 4h1m-5 10v-5a1 1 0 011-1h2a1 1 0 011 1v5m-4 0h4"></path>
                        </svg>
                    </div>
                    <span class="ml-3 text-xl font-bold text-gray-900">Clinique</span>
                </a>
            </div>

            <nav class="hidden md:flex items-center space-x-8">
                <a href="${pageContext.request.contextPath}/doctor/dashboard" class="text-gray-700 hover:text-green-600 font-medium transition">
                    Tableau de bord
                </a>
                <a href="${pageContext.request.contextPath}/doctor/schedule" class="text-gray-700 hover:text-green-600 font-medium transition">
                    Planning
                </a>
                <a href="${pageContext.request.contextPath}/doctor/patients" class="text-gray-700 hover:text-green-600 font-medium transition">
                    Patients
                </a>
            </nav>

            <div class="flex items-center gap-4">
                <span class="text-sm text-gray-700">
                    Dr. ${sessionScope.userConnecte.nom}
                </span>
                <a href="${pageContext.request.contextPath}/logout"
                   class="text-gray-700 hover:text-red-600 transition">
                    <svg class="w-6 h-6" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                        <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M17 16l4-4m0 0l-4-4m4 4H7m6 4v1a3 3 0 01-3 3H6a3 3 0 01-3-3V7a3 3 0 013-3h4a3 3 0 013 3v1"></path>
                    </svg>
                </a>
            </div>
        </div>
    </div>
</header>
