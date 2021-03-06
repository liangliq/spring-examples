<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>spittle</head>
<body>
<c:forEach items="${spittleList}" var="spittle">
    <li id="spittle_<c:out value="spittle.id"/>">
        <div class="spittleMessage">
            <c:out value="${spittle.message}" />
        </div>
        <div>
            <span class="spittleTime"><c:out value="${spittle.time}" /></span>
            <span class="spittleLocation"> (<c:out
                    value="${spittle.latitude}" />, <c:out
                    value="${spittle.longitude}" />)
            </span>
        </div>
    </li>
</c:forEach>

<div class="spittleView">
    <div class="spittleMessage">
        <c:out value="${spittle.message}" />
    </div>
    <div>
        <span class="spittleTime"><c:out value="${spittle.time}" /></span>
    </div>
</div>
</body>
</html>
