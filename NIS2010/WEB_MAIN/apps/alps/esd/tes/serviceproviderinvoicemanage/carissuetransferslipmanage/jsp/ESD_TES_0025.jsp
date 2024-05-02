<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%

	String csr_no="";
	String vndr_no="";
	String inv_desc="";
	String no_of_inv="";
	String csr_curr_cd="";
	String csr_amt="";
	String attr_ctnt2="";
	String iss_dt="";
	String rcv_dt="";
	String vndr_term_nm="";
	String due_dt="";
	csr_no = JSPUtil.getNull(request.getParameter("csr_no"));
	vndr_no = JSPUtil.getNull(request.getParameter("vndr_no"));
	inv_desc = JSPUtil.getNull(request.getParameter("inv_desc"));
	no_of_inv = JSPUtil.getNull(request.getParameter("no_of_inv"));
	csr_curr_cd = JSPUtil.getNull(request.getParameter("csr_curr_cd"));
	csr_amt = JSPUtil.getNull(request.getParameter("csr_amt"));
	attr_ctnt2 = JSPUtil.getNull(request.getParameter("attr_ctnt2"));
	iss_dt = JSPUtil.getNull(request.getParameter("iss_dt"));
	rcv_dt = JSPUtil.getNull(request.getParameter("rcv_dt"));
	vndr_term_nm = JSPUtil.getNull(request.getParameter("vndr_term_nm"));
	due_dt = JSPUtil.getNull(request.getParameter("due_dt"));

	String ofc_cd = "";
	try {
	   SignOnUserAccount account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   ofc_cd = account.getOfc_cd()!=null&&!account.getOfc_cd().equals("")?account.getOfc_cd():"";
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
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
	<!-- OUTER FRAME : "to make sum of components' HEIGHTS 100%" (S)tart -->
	<table width="100%"  border="0" cellpadding="0" cellspacing="0">
		<tr>
					<td class="bodyright">
					<!-- ####### TABLE '#D' ::: 'RIGHT' FRAME (START) ####### -->
					<!-- Put your 'STYLESHEET' into the <HEAD> tag on the corresponding page if you make 'FRAMESET's -->
					<!-- CSS for 'RIGHT' frame -->
					<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
					<table width="100%" class="title">
						<tr>
							<td class="history" height=5></td>
						</tr>
						<tr>
							<td class="title"><img src="/hanjin/img/ico_t1.gif" width="20" height="12">Rejected CSR Cancellation</td>
						</tr>
					</table>
					<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->
					<!-- TABLE '#D' : ( Button : Main ) (S) -->
					<table width="100%" class="button">
						<tr>
							<td class="align" height=10></td>
						</tr>
					</table>
					<!-- TABLE '#D' : ( Button : Main ) (E) -->
					<!-- TABLE '#D' : ( Search Options ) (S) -->
					<table class="search">
						<tr>
							<td class="bg">
							<table class="search_in" border="0" style="width:870;">
								<tr class="h23">
									<td width="8%">CRS No.</td>
									<td width="43%">&nbsp;<input name="csr_no" type="text" style="width:235;" value='<%=csr_no%>' class="input" readonly></td>
									<td width="10%">Payment S/P</td>
									<td>&nbsp;<input name="vndr_no" type="text" style="width:80;" value='<%=vndr_no%>' class="input" readonly>
									<input name="inv_desc" type="text" style="width:250;" value='<%=inv_desc%>' class="input" readonly></td>
								</tr>
							</table>
							<table class="search_in" border="0" style="width:870;">
								<tr class="h23">
									<td width="8%">No. of INV</td>
									<td width="6%">&nbsp;<input name="no_of_inv" type="text" style="width:25;" value='<%=no_of_inv%>' class="input" readonly></td>
									<td width="10%">INV Currency</td>
									<td width="8%">&nbsp;<input name="csr_curr_cd" type="text" style="width:40;" value='<%=csr_curr_cd%>' class="input" readonly></td>
									<td width="8%">Total AMT</td>
									<td width="14%">&nbsp;<input name="csr_amt" type="text" style="width:80;text-align:right;" value='<%=csr_amt%>' class="input" readonly></td>
									<td width="7%">ASA No.</td>
									<td width="21%">&nbsp;<input name="attr_ctnt2" type="text" style="width:120;" value='<%=attr_ctnt2%>' class="input" readonly></td>
									<td width="8%">Cost OFC</td>
									<td>&nbsp;<input name="ofc_cd" type="text" style="width:61;" value="<%=ofc_cd%>" class="input" readonly></td>
								</tr>
							</table>
							<table class="search_in" border="0" style="width:870;">
								<tr class="h23">
									<td width="8%">Issue DT</td>
									<td width="15%">&nbsp;<input name="iss_dt" type="text" style="width:75;" value='<%=iss_dt%>' class="input" readonly></td>
									<td width="9%">Receive DT</td>
									<td width="20%">&nbsp;<input name="rcv_dt" type="text" style="width:75;" value='<%=rcv_dt%>' class="input" readonly></td>
									<td width="12%">Payment Term</td>
									<td width="18%">&nbsp;<input name="vndr_term_nm" type="text" style="width:120;" value='<%=vndr_term_nm%>' class="input" readonly></td>
									<td width="13%">Payment Due DT</td>
									<td>&nbsp;<input name="due_dt" type="text" style="width:75;" value='<%=due_dt%>' class="input" readonly></td>
								</tr>
							</table>
							</td>
						</tr>
					</table>
					<!-- TABLE '#D' : ( Search Options ) (E) -->
					<table class="height_15">
						<tr>
							<td></td>
						</tr>
					</table>
					<!-- TABLE '#D' : ( Gird BG Box ) (S) -->
					<table class="search" border="0" >
						<tr>
							<td class="bg_b1">
							<table class="height_10">
								<tr>
									<td></td>
								</tr>
							</table>
							<table width="100%" id="mainTable">
								<tr>
									<td>
									<script language="javascript">ComSheetObject('sheet1');</script>
									</td>
								</tr>
							</table>
							<!-- : ( Grid ) (E) -->
							
							<!-- : ( Button_ Sub ) (S) 
							<table width="100%" class="sbutton">
								<tr>
									<td class="align">
									<table class="sbutton">
										<tr>
											<td class="bt">
											<img class="cursor" src="/hanjin/img/button/btng_save.gif" width="65" height="19" border="0" name="btng_save"></td>
										</tr>
									</table>
									</td>
								</tr>
							</table>
							<!-- : ( Button_ Sub ) (E) -->
							
							<table border=0 width=100% class="sbutton">
							<tr>
								<td width=90%></td>
								<td class="align">
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
									<td class="btn2" name="btng_save" id="btng_save">Save</td>
									<td class="btn2_right"></td>
								</tr>
								</table>
								</td>
							</tr>
							</table>							
							
							</td>
						</tr>
					</table>
					<!-- TABLE '#D' : ( Grid BG Box ) (E) -->
					<!-- ####### TABLE '#D' ::: 'RIGHT' FRAME (END) ####### -->
					</td>
				</tr>
			</table>
			<!-- TABLE '#B' : 'Left + Right Body' Table (E)nd -->
			<!-- ################# TABLE '#B' ::: 'LEFT + RIGHT' FRAME (END) ################## -->
			</td>
		</tr>
	</table>
	<!-- OUTER FRAME : "to make sum of components' HEIGHTS 100%" (E)nd -->
</form>
</body>
</html>
