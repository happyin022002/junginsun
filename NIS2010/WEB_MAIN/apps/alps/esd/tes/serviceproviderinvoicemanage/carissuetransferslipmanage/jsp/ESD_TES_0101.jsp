<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%
	String csr_no = JSPUtil.getNull(request.getParameter("csr_no"));
	String cost_ofc_cd = JSPUtil.getNull(request.getParameter("cost_ofc_cd"));

	String ofc_cd = "";
	try {
	   SignOnUserAccount account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   ofc_cd = account.getOfc_cd()!=null&&!account.getOfc_cd().equals("")?account.getOfc_cd():"";
	}catch(Exception e) {
		out.println(e.toString());
	}
%><html>
<head>
<title>Welcome to ALPS!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	var csr_no = '<%=JSPUtil.getNull(csr_no)%>';
    function setupPage(){
        loadPage();
    }
</script>
</head>

<body onload="setupPage();">

<form name="form">
<input type="hidden" name="f_cmd"> 
	<!-- OUTER - POPUP (S)tart -->
	<table width="100%" class="popup" cellpadding="10" border="0">
		<tr>
			<td class="top"></td>
		</tr>
		<tr>
			<td valign="top">
			<!-- : ( Title ) (S) -->
			<table width="735" border="0">
				<tr>
					<td height="79" class="title">
					<img src="/hanjin/img/ico_t1.gif" width="20" height="12">Invoice 
					List Inquiry</td>
				</tr>
			</table>
			<!-- : ( Title ) (E) -->
			<!-- : ( Search Options ) (S) -->
			<table class="search">
				<tr>
					<td class="bg">
					<table class="search_in" border="0" style="width:870;">
						<tr class="h23">
							<td width="8%">CSR No.</td>
							<td width="45%">&nbsp;<input name="csr_no" type="text" style="width:250;" value='<%=csr_no%>' class="input" readonly></td>
							<td width="12%">Payment S/P</td>
							<td>&nbsp;<input name="vndr_no" type="text" style="width:75;" value="" class="input" readonly>
							<input name="inv_desc" type="text" style="width:200;" value="" class="input" readonly></td>
						</tr>
					</table>
					<table class="search_in" border="0" style="width:870;">
						<tr class="h23">
							<td width="8%">No. of INV</td>
							<td width="7%">&nbsp;<input name="no_of_inv" type="text" style="width:30;" value="" class="input" readonly></td>
							<td width="10%">INV Currency</td>
							<td width="8%">&nbsp;<input name="csr_curr_cd" type="text" style="width:40;" value="" class="input" readonly></td>
							<td width="8%">Total AMT</td>
							<td width="16%">&nbsp;<input name="csr_amt" type="text" style="width:80;text-align:right;"  value="" class="input" readonly></td>
							<td width="7%">ASA No.</td>
							<td width="13%">&nbsp;<input name="attr_ctnt2" type="text" style="width:80;" value="" class="input" readonly></td>
							<td width="8%">Cost OFC</td>
							<td>&nbsp;<input name="ofc_cd" type="text" style="width:65;" value="<%=cost_ofc_cd%>" class="input" readonly></td>
						</tr>
					</table>
					<table class="search_in" border="0" style="width:870;">
						<tr class="h23">
							<td width="8%">Issue DT</td>
							<td width="14%">&nbsp;<input name="iss_dt" type="text" style="width:75;" value="" class="input" readonly></td>
							<td width="9%">Receive DT</td>
							<td width="20%" style="padding-left:3">&nbsp;<input name="rcv_dt" type="text" style="width:75;" value="" class="input" readonly></td>
							<td width="12%">Payment Term</td>
							<td width="11%">&nbsp;<input name="vndr_term_nm" type="text" style="width:80;" value="" class="input" readonly></td>
							<td width="13%">Payment Due DT</td>
							<td>&nbsp;<input name="due_dt" type="text" style="width:80;" value="" class="input" readonly></td>
						</tr>
					</table>
					</td>
				</tr>
			</table>
			<table class="height_10">
				<tr>
					<td></td>
				</tr>
			</table>
			<!-- : ( Search Options ) (S) -->
			<table class="search">
				<tr>
					<td class="bg_a">
					<!-- : ( Grid ) (S) -->
					<table width="100%" id="mainTable">
						<tr>
							<td>
							<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table>
					<!-- : ( Grid ) (E) --></td>
				</tr>
			</table>
			<!-- : ( Search Options ) (E) --></td>
		</tr>
	</table>
	<!-- OUTER - POPUP (E)nd -->
	<table class="height_10">
		<tr>
			<td></td>
		</tr>
	</table>
	<!-- : ( Button : Sub ) (S) -->
	<!--
	<table width="100%" class="sbutton">
		<tr>
			<td height="71" class="popup">
			<table class="sbutton">
				<tr>
					<td class="p_bt">
					<img class="cursor" src="/hanjin/img/button/btn_close.gif" width="66" height="20" border="0" name="btn_close"></td>
				</tr>
			</table>
			</td>
		</tr>
	</table>  -->
	<!-- : ( Button : Sub ) (E) -->
	
<!-- : ( Button : Sub ) (S) -->
<table width="100%" class="sbutton">
<tr>
	<td height="71" class="popup">
		<table class="sbutton">
		<tr>
			<!-- <td class="p_bt"><img class="cursor" src="/hanjin/img/button/btn_close.gif" width="66" height="20" border="0" name="btn_close"></td>
			 -->
			<td>
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
			<tr>
				<td>
					<div id="EDILayer01" style="display:none">
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr>
					<td class="btn2_left"></td>
					<td class="btn2" name="btn_EDIinvoiceview" id="btn_EDIinvoiceview">EDI Invoice View</td>
					<td class="btn2_right"></td>
					</tr></table>
					</div>
				</td>
				<td class="btn2_left"></td><td class="btn2" name="btn_close" id="btn_close">Close</td>
				<td class="btn2_right"></td>
			</tr>
			</table>
			</td>
		</tr>
		</table>

	</td></tr>
</table>
<!-- : ( Button : Sub ) (E) -->
	
	
</form>
</body>
</html>
<DIV style="display:none">
<script language="javascript">ComSheetObject('sheet2');</script>
</DIV>