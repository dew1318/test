<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Einloggen</title>
     <link rel="stylesheet" type="text/css" href="../css/login.css" >
</head>
<body>
    <div id="container">
     <nav>
    	<a href="../../index.jsp"><img src="../../startseite/images/logoBaum.jpg" alt="Logo" id="logo" width="25" height="25"></a>
        </nav>
        <header>
            <h1>Einloggen</h1>
        </header>
        <main>
            <form action="${pageContext.request.contextPath}/login" method="post">
   			 <label for="username">Benutzername:</label>
   			 <input type="text" id="username" name="username" required>
   			 <label for="password">Passwort:</label>
   			 <input type="password" id="password" name="password" required>
   			 <button type="submit">Einloggen</button>
</form>
        </main>
        <footer>
            <p>Willkommen in Ihrer Nachbarschaft!</p>
        </footer>
    </div>
</body>

</body>
</html>