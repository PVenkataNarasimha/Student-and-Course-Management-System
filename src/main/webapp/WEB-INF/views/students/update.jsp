<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Update Student</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <div class="container">
        <h1>Update Student</h1>
        
        <c:if test="${not empty error}">
            <div class="error">${error}</div>
        </c:if>
        
        <form action="${pageContext.request.contextPath}/students/update/${student.id}" method="post">
            <div class="form-group">
                <label>First Name:</label>
                <input type="text" name="firstName" value="${student.firstName}" required>
            </div>
            <div class="form-group">
                <label>Last Name:</label>
                <input type="text" name="lastName" value="${student.lastName}" required>
            </div>
            <div class="form-group">
                <label>Email:</label>
                <input type="email" name="email" value="${student.email}" required>
            </div>
            <div class="form-group">
                <label>Enrollment Year:</label>
                <input type="number" name="enrollmentYear" value="${student.enrollmentYear}" required>
            </div>
            <button type="submit">Update Student</button>
            <a href="${pageContext.request.contextPath}/students" class="btn">Cancel</a>
        </form>
    </div>
</body>
</html>
