<span style="font-family:SimSun;font-size:18px;"><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
  <head>
    <title>Demo</title>
    <link rel="stylesheet"
          type="text/css"
          href="<c:url value="/resources/style.css" />" >
  </head>
  <body>
    <h1>Welcome to Examples</h1>

    <a href="<c:url value="/examples" />">Examples</a> |
    <a href="<c:url value="/examples/details" />">Details</a>
  </body>
</html></span>