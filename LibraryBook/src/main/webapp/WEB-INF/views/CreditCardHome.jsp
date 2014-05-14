<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>
<html>
<head>

<title>Credit Card Payment</title>
</head>
<h2>Credit Card Payment</h2>
<a href="/LibraryBook/logout">Logout</a>
<form:form method="POST" action="/LibraryBook/paypal-checkout/return">
	<table>
		<tr>
			<td>BILLING_FIRST_NAME:<input type="text"
				name="BILLING_FIRST_NAME"></td>
		</tr>

		<tr>
			<td>BILLING_LAST_NAME:<input type="text"
				name="BILLING_LAST_NAME"></td>
		</tr>

		<tr>
			<td>BILLING_ADDRESS_LINE1:<input type="text"
				name="BILLING_ADDRESS_LINE1"></td>
		</tr>
		<tr>
			<td>BILLING_ADDRESS_LINE2:<input type="text"
				name="BILLING_ADDRESS_LINE2"></td>
		</tr>
		<tr>
			<td>BILLING_STATE:<input type="text" name="BILLING_STATE"></td>
		</tr>
		<tr>
			<td>BILLING_CITY:<input type="text" name="BILLING_CITY"></td>
		</tr>
		
		<tr>
			<td>BILLING_ZIP:<input type="text" name="BILLING_ZIP"></td>
		</tr>
		<tr>
			<td>BILLING_COUNTRY:<input type="text" name="BILLING_COUNTRY"></td>
		</tr>
		<tr>
			<td>SHIPPING_FIRST_NAME<input type="text"
				name="SHIPPING_FIRST_NAME"></td>
		</tr>
		<tr>
			<td>SHIPPING_ADDRESS_LINE1:<input type="text"
				name="SHIPPING_ADDRESS_LINE1"></td>
		</tr>

		<tr>
			<td>SHIPPING_ADDRESS_LINE2:<input type="text"
				name="SHIPPING_ADDRESS_LINE2"></td>
		</tr>

		<tr>
			<td>SHIPPING_CITY:<input type="text" name="SHIPPING_CITY"></td>
		</tr>
		<tr>
			<td>SHIPPING_STATE:<input type="text" name="SHIPPING_STATE"></td>
		</tr>
		<tr>
			<td>SHIPPING_ZIP:<input type="text" name="SHIPPING_ZIP"></td>
		</tr>
		<tr>
			<td>SHIPPING_COUNTRY:<input type="text" name="SHIPPING_COUNTRY"></td>
		</tr>
		<tr>
			<td>CREDIT_CARD_NAME:<input type="text" name="CREDIT_CARD_NAME"></td>
		</tr>
		<tr>
			<td>CREDIT_CARD_NUMBER:<input type="text"
				name="CREDIT_CARD_NUMBER"></td>
		</tr>
		<tr>
			<td>CREDIT_CARD_EXP_DATE:<input type="text"
				name="CREDIT_CARD_EXP_DATE"></td>
		</tr>
		<tr>
			<td>CREDIT_CARD_CVV:<input type="text" name="CREDIT_CARD_CVV"></td>
		</tr>
		<tr>
			<td>CREDIT_CARD_LAST_FOUR:<input type="text"
				name="CREDIT_CARD_LAST_FOUR"></td>
		</tr>
		<tr>
			<td>CREDIT_CARD_TYPE:<input type="text" name="CREDIT_CARD_TYPE"></td>
		</tr>
		<tr>
			<td>TRANSACTION_AMT:<input type="text" name="TRANSACTION_AMT"></td>
		</tr>
		<tr>
			<td>ORDER_ID:<input type="text" name="ORDER_ID"></td>
		</tr>

		<tr>
			<td>GATEWAY_TRANSACTION_ID:<input type="text"
				name="GATEWAY_TRANSACTION_ID"></td>
		</tr>
		
		<tr>
			<td>RESULT_MESSAGE:<input type="text"
				name="MESSAGE"></td>
		</tr>
		
		<tr>
			<td>RESULT_SUCCESS:<input type="text"
				name="SUCCESS"></td>
		</tr>
		

		<tr>
	</table>
	<input type="submit" value="Payment">

</form:form>


</body>
</html>
