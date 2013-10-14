package it.techannotation.warehouse.portlet;

import it.techannotation.warehouse.jpa.Order;
import it.techannotation.warehouse.jpa.Product;
import it.techannotation.warehouse.service.OrderService;
import it.techannotation.warehouse.service.ProductService;
import it.techannotation.warehouse.utils.Constants;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.MimeResponse;
import javax.portlet.PortalContext;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderMode;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.portlet.context.PortletApplicationContextUtils;
import org.w3c.dom.Element;

public class OrderPortlet extends GenericPortlet {

	private Logger logger = Logger.getLogger(OrderPortlet.class);
	private OrderService orderService;
	private ProductService productService;

	public void initDaoService() {

		if (orderService == null) {
			synchronized (OrderPortlet.class) {
				if (orderService == null) {
					ApplicationContext springCtx = PortletApplicationContextUtils
							.getWebApplicationContext(getPortletContext());
					orderService = (OrderService) springCtx
							.getBean("orderService");

					productService = (ProductService) springCtx
							.getBean("productService");
				}
			}
		}
	}

	protected void doHeaders(RenderRequest request, RenderResponse response) {
		Element cssElement = response.createElement("link");
		// --encoding URLs is important
		cssElement.setAttribute("href", response.encodeURL((request
				.getContextPath() + "/css/warehouse.css")));
		cssElement.setAttribute("rel", "stylesheet");
		cssElement.setAttribute("type", "text/css");
		response.addProperty(MimeResponse.MARKUP_HEAD_ELEMENT, cssElement);
	}

	@RenderMode(name = "VIEW")
	public void showOrders(RenderRequest request, RenderResponse response)
			throws IOException, PortletException {

		logger.info("Show Orders and Products");

		// Load Dao resources
		initDaoService();

		// get action
		String myaction = request.getParameter(Constants.MYACTION_PARAM);
		// Set title
		response.setTitle(getResourceBundle(request.getLocale()).getString(
				"portlet.title.showOrder"));

		// --set the myaction parameter in session for debugging purposes
		request.getPortletSession().setAttribute("myaction", myaction);

		// Default home page
		String jspPage = "home.jsp";

		if ("addOrder".equalsIgnoreCase(myaction)) {
			jspPage = "addOrder.jsp";
		} else {
			List<Order> orders = orderService.getOrders();

			request.setAttribute("orders", orders);

			if ("addProduct".equalsIgnoreCase(myaction)) {
				jspPage = "addProduct.jsp";
			}
		}
		// Render the page
		getPortletContext().getRequestDispatcher(
				response.encodeURL(Constants.PATH_TO_JSP_PAGE + jspPage))
				.include(request, response);
	}

	@ProcessAction(name = "addOrderAction")
	public void addOrder(ActionRequest request, ActionResponse response)
			throws PortletException, IOException {
		logger.info("Add Order action invoked");
		int order_id = 0;
		String description = request.getParameter("description");

		// --contains map of field names to error message
		String errorMessage = "";

		Pattern integerPattern = Pattern.compile("^\\d*$");
		Matcher matchesInteger = integerPattern.matcher(request
				.getParameter("orderId"));
		boolean isInteger = matchesInteger.matches();

		if (!isInteger) {
			errorMessage = getResourceBundle(request.getLocale()).getString(
					"portlet.addorder.error");
		} else
			order_id = Integer.parseInt(request.getParameter("orderId"));

		if (description == null || description.trim().equalsIgnoreCase("")) {
			errorMessage = getResourceBundle(request.getLocale()).getString(
					"portlet.addorder.error");
		}

		// --if no error found, go ahead and save
		if (errorMessage.equals("")) {
			logger.info("adding order to the data store");
			try {
				orderService.insertOrder(new Order(order_id, description));
			} catch (Exception ex) {
				response.setRenderParameter(Constants.MYACTION_PARAM, "");
				ex.printStackTrace();

				return;
			}
			response.setRenderParameter(Constants.MYACTION_PARAM, "");
		} else {
			logger.info("validation error occurred. re-showing the add order form");
			request.setAttribute("error", errorMessage);

			// Set the value already send
			Map<String, String> valuesMap = new HashMap<String, String>();
			valuesMap.put("orderId", request.getParameter("orderId"));
			valuesMap.put("description", description);

			request.setAttribute("order", valuesMap);
			response.setRenderParameter(Constants.MYACTION_PARAM, "addOrder");
		}
	}

	@ProcessAction(name = "addProductAction")
	public void addProduct(ActionRequest request, ActionResponse response)
			throws PortletException, IOException {
		logger.info("Add Product action invoked");

		// --contains map of field names to error message
		String errorMessage = "";

		String productId = request.getParameter("productId");

		if (productId.trim().equalsIgnoreCase("")) {
			errorMessage = getResourceBundle(request.getLocale()).getString(
					"portlet.addorder.error");
		}

		String description = request.getParameter("description");
		if (description.trim().equalsIgnoreCase("")) {
			errorMessage = getResourceBundle(request.getLocale()).getString(
					"portlet.addorder.error");
		}

		double price = 0;

		Pattern doublePattern = Pattern.compile("\\d+\\.\\d+");
		Matcher matchesDouble = doublePattern.matcher(request.getParameter("price"));
		boolean isDoublePrice = matchesDouble.matches();

		if (isDoublePrice)
			price = Double.parseDouble(request.getParameter("price"));
		else
			errorMessage = getResourceBundle(request.getLocale()).getString("portlet.addorder.error");

		double qtaAvailable = 0;

		matchesDouble = doublePattern.matcher(request
				.getParameter("qtaAvailable"));
		boolean isDoubleQtaAvailable = matchesDouble.matches();

		if (isDoubleQtaAvailable)
			qtaAvailable = Double.parseDouble(request
					.getParameter("qtaAvailable"));
		else
			errorMessage = getResourceBundle(request.getLocale()).getString("portlet.addorder.error");

		int orderId = Integer.parseInt(request.getParameter("orderId"));

		// --if no error found, go ahead and save

		// --if no error found, go ahead and save
		if (errorMessage.equals("")) {
			logger.info("adding Product to the WareHouse");
			try {
				productService.insertProduct(orderId, new Product(productId,
						description, price, qtaAvailable));
			} catch (Exception ex) {
				response.setRenderParameter(Constants.MYACTION_PARAM, "");
				ex.printStackTrace();

				return;
			}
		} else {
			logger.info("validation error occurred. re-showing the add product form");
			request.setAttribute("error", errorMessage);

			// Set the value already send
			Map<String, String> valuesMap = new HashMap<String, String>();
			valuesMap.put("productId", productId);
			valuesMap.put("description", description);
			valuesMap.put("qtaAvailable", String.valueOf(qtaAvailable));
			valuesMap.put("price", String.valueOf(price));

			request.setAttribute("product", valuesMap);
			response.setRenderParameter(Constants.MYACTION_PARAM, "addProduct");
		}
		response.setRenderParameter(Constants.MYACTION_PARAM, "");

	}

	@ProcessAction(name = "removeProductAction")
	public void removeProduct(ActionRequest request, ActionResponse response)
			throws PortletException, IOException {
		logger.info("Remove Product action invoked");

		String productId = request.getParameter("productId");

		try {
			productService.deleteProduct(productId);
		} catch (Exception ex) {
			response.setRenderParameter(Constants.MYACTION_PARAM, "");
			ex.printStackTrace();

			return;
		}
		response.setRenderParameter(Constants.MYACTION_PARAM, "");
	}

	@ProcessAction(name = "removeOrderAction")
	public void removeOrder(ActionRequest request, ActionResponse response)
			throws PortletException, IOException {
		logger.info("Remove Product action invoked");

		int orderId = Integer.parseInt(request.getParameter("orderId"));

		try {
			orderService.deleteOrder(orderId);
		} catch (Exception ex) {
			response.setRenderParameter(Constants.MYACTION_PARAM, "");
			ex.printStackTrace();

			return;
		}
		response.setRenderParameter(Constants.MYACTION_PARAM, "");
	}

}
