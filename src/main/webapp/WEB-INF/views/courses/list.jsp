<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Course Management</title>
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
        
        <h1>Course Management System</h1>
        
        <c:if test="${not empty success}">
            <div class="success">${success}</div>
        </c:if>
        <c:if test="${not empty error}">
            <div class="error">${error}</div>
        </c:if>
        
        <h2>All Courses</h2>
        <table>
            <thead>
                <tr>
                    <th>ID</th><th>Course Code</th><th>Course Name</th>
                    <th>Credits</th><th>Instructor</th><th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="course" items="${courses}">
                    <tr>
                        <td>${course.id}</td>
                        <td>${course.courseCode}</td>
                        <td>${course.courseName}</td>
                        <td>${course.credits}</td>
                        <td>${course.instructor}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/courses/update/${course.id}" 
                               class="btn btn-edit" style="padding:5px 10px;">Edit</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
