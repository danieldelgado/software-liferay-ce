<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>  
  
<portlet:defineObjects />  
  
<portlet:actionURL var="userNameUrl">  
<portlet:param name="action" value="addUserName"></portlet:param>  
</portlet:actionURL>  
  
<portlet:renderURL var="viewUserUrl">  
<portlet:param name="action" value="viewUser"></portlet:param>  
</portlet:renderURL>  
  
<portlet:renderURL var="editUserUrl">  
<portlet:param name="action" value="editUser"></portlet:param>  
</portlet:renderURL>  
  
<form action="${userNameUrl}" method="post">  
 Name :- <input type="text" name="userName">  
  
 <a href="${viewUserUrl}">view User</a>  
 <a href="${editUserUrl}">edit User</a>  
 <input type="submit">  
</form>  