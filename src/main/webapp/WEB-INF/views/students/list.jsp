<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Management</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <div class="container">
        <div class="navbar">
            <a href="${pageContext.request.contextPath}/students">Students</a>
            <a href="${pageContext.request.contextPath}/courses">Courses</a>
            <a href="${pageContext.request.contextPath}/students/add">Add Student</a>
            <a href="${pageContext.request.contextPath}/courses/add">Add Course</a>
        </div>
        
        <h1>Student Management System</h1>
        
        <c:if test="${not empty success}">
            <div class="success">${success}</div>
        </c:if>
        <c:if test="${not empty error}">
            <div class="error">${error}</div>
        </c:if>
        
        <h2>All Students</h2>
        <table>
            <thead>
                <tr>
                    <th>ID</th><th>First Name</th><th>Last Name</th>
                    <th>Email</th><th>Year</th><th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="student" items="${students}">
                    <tr>
                        <td>${student.id}</td>
                        <td>${student.firstName}</td>
                        <td>${student.lastName}</td>
                        <td>${student.email}</td>
                        <td>${student.enrollmentYear}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/students/update/${student.id}" 
                               class="btn btn-edit" style="padding:5px 10px;">Edit</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        
        <div class="card join-result">
            <h2>Student-Course Enrollment (Inner Join Result)</h2>
            <table>
                <thead><tr><th>Student Name</th><th>Course Name</th></tr></thead>
                <tbody>
                    <c:forEach var="row" items="${joinResult}">
                        <tr><td>${row[0]} ${row[1]}</td><td>${row[2]}</td></tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
