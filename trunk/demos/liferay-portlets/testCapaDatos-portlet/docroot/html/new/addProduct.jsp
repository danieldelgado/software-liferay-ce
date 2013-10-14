<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html" isELIgnored="false"
	import="javax.portlet.*,it.techannotation.warehouse.utils.Constants"%>

<fmt:setLocale value="<%=request.getLocale()%>" />
<fmt:setBundle basename="content.Language-ext" />
<portlet:defineObjects />

<form name="<portlet:namespace/>addProduct" method="post"
	action='<portlet:actionURL name="addProductAction"/>'>
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
			<td colspan="3">Product</td>
		</tr>
		<tr>
			<td class="headersublevel"><b>Order:</b></td>
			<td>
				<select name="<portlet:namespace/>orderId">
					<c:forEach var="order" items="${orders}">
						<option value='<c:out value="${order.order_id}" />'><c:out value="${order.description}" /></option>
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td class="headersublevel"><b>ProductId:</b><font
				style="color: #C11B17;">*</font></td>
			<td><input type="text" name="<portlet:namespace/>productId" /></td>
			<td><font style="color: #C11B17;"><c:out
						value="${requestScope.errors.productId}" /></font></td>
		</tr>
		<tr>
			<td class="headersublevel"><b>Description:</b></td>
			<td><input type="text" name="<portlet:namespace/>description" /></td>
			<td><font style="color: #C11B17;"><c:out
						value="${requestScope.errors.description}" /></font></td>
		</tr>
		<tr>
			<td class="headersublevel"><b>Price:</b></td>
			<td><input type="text" name="<portlet:namespace/>price" /></td>
			<td><font style="color: #C11B17;"><c:out
						value="${requestScope.errors.price}" /></font></td>
		</tr>
		<tr>
			<td class="headersublevel"><b>Quantity Available:</b></td>
			<td><input type="text" name="<portlet:namespace/>qtaAvailable" /></td>
			<td><font style="color: #C11B17;"><c:out
						value="${requestScope.errors.qtaAvailable}" /></font></td>
		</tr>

		<tr align="center">
			<td colspan="3"><input type="image" src="<%=request.getContextPath()%>/images/addproduct.jpg" /></td>
		</tr>
	</table>
</form>