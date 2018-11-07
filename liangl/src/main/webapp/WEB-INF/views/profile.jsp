<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<h1>Your profile</h1>
<c:out value="${spitter.username}" /><br/>
<c:out value="${spitter.firstname}" />
<c:out value="${spitter.lastname}" />
</html>