<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Course</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <div class="container">
        <div class="navbar">
            <a href="${pageContext.request.contextPath}/students">Students</a>
            <a href="${pageContext.request.contextPath}/courses">Courses</a>
        </div>
        
        <h1>Add New Course</h1>
        
        <c:if test="${not empty error}">
            <div class="error">${error}</div>
        </c:if>
        
        <form action="${pageContext.request.contextPath}/courses/add" method="post">
            <div class="form-group">
                <label>Course Code:</label>
                <input type="text" name="courseCode" required>
            </div>
            <div class="form-group">
                <label>Course Name:</label>
                <input type="text" name="courseName" required>
            </div>
            <div class="form-group">
                <label>Credits:</label>
                <input type="number" name="credits" required>
            </div>
            <div class="form-group">
                <label>Instructor:</label>
                <input type="text" name="instructor" required>
            </div>
            <button type="submit">Save Course</button>
        </form>
    </div>
</body>
</html>
