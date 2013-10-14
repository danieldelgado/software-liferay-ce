<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html" isELIgnored="false"
	import="javax.portlet.*,it.techannotation.warehouse.utils.Constants"%>

<fmt:setLocale value="<%=request.getLocale()%>" />
<fmt:setBundle basename="content.Language-ext" />
<portlet:defineObjects />

<table>

	<c:forEach var="order" items="${orders}">
		<tr class="header">
			<td colspan="4">Order</td>
			<td><a href='<portlet:renderURL><portlet:param name="<%=Constants.MYACTION_PARAM%>" value="addOrder"/></portlet:renderURL>'><img src="<%=request.getContextPath()%>/images/addorder.jpg"></a></td>
		</tr>
		<tr class="header">
			<td>OrderId</td>
			<td>Description</td>
			<td colspan="3">&nbsp;</td>
		</tr>
		<tr>
			<td valign="top"><c:out value="${order.order_id}" /></td>
			<td valign="top"><c:out value="${order.description}" /></td>
			<td><a href="top" colspan="3"><a href='<portlet:actionURL name="removeOrderAction"><portlet:param name="productId" value="${product.product_id}" /></portlet:actionURL>'><img src="<%=request.getContextPath()%>/images/remove.jpg"></a></a></td>
		</tr>
		<tr class="header">
			<td colspan="4">Products</td>			
			<td><a href='<portlet:renderURL><portlet:param name="<%=Constants.MYACTION_PARAM%>" value="addProduct"/></portlet:renderURL>'><img src="<%=request.getContextPath()%>/images/addproduct.jpg"></a></td>
		</tr>
		<tr class="headersublevel">
			<td>ProductId</td>
			<td>Description</td>
			<td>Price</td>
			<td>Available</td>
			<td>&nbsp;</td>
		</tr>
		<c:forEach var="product" items="${order.products}">
			<tr>
				<td valign="top"><c:out value="${product.product_id}" /></td>
				<td valign="top"><c:out value="${product.description}" /></td>
				<td valign="top"><c:out value="${product.price}" /></td>
				<td valign="top"><c:out value="${product.qtaAvailable}" /></td>
				<td><a href="top" colspan="3"><a href='<portlet:actionURL name="removeProductAction"><portlet:param name="productId" value="${product.product_id}" /></portlet:actionURL>'><img src="<%=request.getContextPath()%>/images/remove.jpg"></a></a></td>				
			</tr>
		</c:forEach>
	</c:forEach>
</table>