<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<h1>This is Default Render Jsp</h1>

<portlet:defineObjects/>

<portlet:renderURL var="renderOneMethodURL">
	<portlet:param name="action" value="renderOne"></portlet:param>
</portlet:renderURL>

<portlet:actionURL var="actionOneMethodURL">
<portlet:param name="action" value="actionOne"></portlet:param>
</portlet:actionURL>

<a href="${renderOneMethodURL}">Call RenderOne method</a>

<form action="${actionOneMethodURL}" method="post">
	User Name: <input type="text" name="userName">
	<input type="submit">  
</form>
