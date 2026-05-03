<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Update Course</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <div class="container">
        <h1>Update Course</h1>
        
        <c:if test="${not empty error}">
            <div class="error">${error}</div>
        </c:if>
        
        <form action="${pageContext.request.contextPath}/courses/update/${course.id}" method="post">
            <div class="form-group">
                <label>Course Code:</label>
                <input type="text" name="courseCode" value="${course.courseCode}" required>
            </div>
            <div class="form-group">
                <label>Course Name:</label>
                <input type="text" name="courseName" value="${course.courseName}" required>
            </div>
            <div class="form-group">
                <label>Credits:</label>
                <input type="number" name="credits" value="${course.credits}" required>
            </div>
            <div class="form-group">
                <label>Instructor:</label>
                <input type="text" name="instructor" value="${course.instructor}" required>
            </div>
            <button type="submit">Update Course</button>
            <a href="${pageContext.request.contextPath}/courses" class="btn">Cancel</a>
        </form>
    </div>
</body>
</html>
