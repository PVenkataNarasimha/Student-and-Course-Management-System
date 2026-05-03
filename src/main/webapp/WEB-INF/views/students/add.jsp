<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Student</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <div class="container">
        <div class="navbar">
            <a href="${pageContext.request.contextPath}/students">Students</a>
            <a href="${pageContext.request.contextPath}/courses">Courses</a>
        </div>
        
        <h1>Add New Student</h1>
        
        <c:if test="${not empty error}">
            <div class="error">${error}</div>
        </c:if>
        
        <form action="${pageContext.request.contextPath}/students/add" method="post">
            <div class="form-group">
                <label>First Name:</label>
                <input type="text" name="firstName" required>
            </div>
            <div class="form-group">
                <label>Last Name:</label>
                <input type="text" name="lastName" required>
            </div>
            <div class="form-group">
                <label>Email:</label>
                <input type="email" name="email" required>
            </div>
            <div class="form-group">
                <label>Enrollment Year:</label>
                <input type="number" name="enrollmentYear" required>
            </div>
            <button type="submit">Save Student</button>
        </form>
    </div>
</body>
</html>
