<%@page pageEncoding="utf-8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
choose prefered language? <a href="loginPage.form?lang=en"> <spring:message code="label.english"/></a>
&nbsp; &nbsp; &nbsp; &nbsp;
<a href="loginPage.form?lang=hi"> <spring:message code="label.hindi"/></a>
&nbsp; &nbsp; &nbsp; &nbsp;

<a href="loginPage.form?lang=te"><spring:message code="label.telugu"></spring:message></a>
&nbsp; &nbsp; &nbsp; &nbsp;

<form action="checkLogin.form" method="post" style="border:2px solid red; width:500px;">
<table>
<tr>
<td><spring:message code="label.username"/></td><td><input type="text" name="username"></td>
</tr>
<tr>
<td><spring:message code="label.password"/></td><td><input type="password" name="password"></td>
</tr>
<tr>
<td colspan="2" align="center">
<input type="submit"  value='<spring:message code="label.submit"/>'>
</td>
</tr>
</table>
</form>