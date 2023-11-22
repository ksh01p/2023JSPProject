<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>

<h1>Add New Post</h1>
<form action="addpost.jsp" method="post">
    <table>
        <tr><td>Title:</td><td><input type="text" name="title"/></td></tr>
        <tr><td>Writer:</td><td><input type="text" name="writer"/></td></tr>
        <tr><td>Content:</td><td><textarea cols="50" rows="5" name="content"></textarea></td></tr>
        <tr><td>Contact:</td><td><input type="text" name="contact" ></td></tr>
        <tr><td>Email:</td><td><input type="text" name="email"></td></tr>
        <tr><td>Age:</td><td><input type="text" name="age"></td></tr>
        <tr><td>Nation:</td><td><input type="text" name="nation"></td></tr>
        <tr><td>Relationship:</td><td><input type="text" name="relationship"></td></tr>
        <tr><td>Birthdate:</td><td><input type="text" name="birthdate"></td></tr>
        <tr><td><a href="posts.jsp">View All Records</a></td><td align="right"><input type="submit" value="Add Post"/></td></tr>
    </table>
</form>

</body>
</html>