<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />

This is the <b>Spring Demo Controller</b> portlet in View mode.${msg}
  
<portlet:actionURL var="userNameUrl">  
<portlet:param name="action" value="addUserName"></portlet:param>  
</portlet:actionURL>  
  
<form action="${userNameUrl}" method="post">  
 Name :- <input type="text" name="userName">  
  
 <input type="submit">  
</form>  