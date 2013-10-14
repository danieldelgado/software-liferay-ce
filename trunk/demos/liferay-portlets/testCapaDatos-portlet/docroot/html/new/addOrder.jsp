<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html" isELIgnored="false"
	import="javax.portlet.*,it.techannotation.warehouse.utils.Constants"%>

<fmt:setLocale value="<%=request.getLocale()%>" />
<fmt:setBundle basename="content.Language-ext" />
<portlet:defineObjects />

<form name="<portlet:namespace/>addOrder" method="post"
	action='<portlet:actionURL name="addOrderAction"/>'>
	<table>
		<tr>
			<td><a class="anchor"
				href='<portlet:renderURL portletMode="view"/>'><b>HOME</b></a></td>
		</tr>
		<tr>
			<td><font style="color: #C11B17;"><c:out
						value="${requestScope.error}" /></font></td>
		</tr>
	</table>
	<table>
		<tr class="header">
			<td colspan="2">Order</td>
		</tr>
		<tr>
			<td class="headersublevel"><b>OrderId:</b><font
				style="color: #C11B17;">*</font></td>
			<td><input type="text" name="<portlet:namespace/>orderId"
				value='<c:out value="${requestScope.order.orderId}"/>' /></td>			
		</tr>
		<tr>
			<td class="headersublevel"><b>Description:</b></td>
			<td><input type="text" name="<portlet:namespace/>description"
				value='<c:out value="${requestScope.order.description}"/>' /></td>
		</tr>
		<tr align="center">
			<td colspan="3"><input type="image" src="<%=request.getContextPath()%>/images/addorder.jpg" /></td>
		</tr>
	</table>
</form>