<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : COM_CSR_025.jsp
*@FileTitle : Rejected CSR Cancellation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.22
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2009.07.22 함대성
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.event.ComCsr0014Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	ComCsr0014Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String ofc_cd = "";
	
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
	String if_status="";
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
	if_status  = JSPUtil.getNull(request.getParameter("if_status"));

	Logger log = Logger.getLogger("com.hanjin.apps.ConsultationSlipRequestMgt.ConsultationSlipRequestMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		ofc_cd = account.getOfc_cd()!=null&&!account.getOfc_cd().equals("")?account.getOfc_cd():"";

		event = (ComCsr0014Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
	strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Invoice List Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" type="text/javascript" src="bizcommon/csr/CoCsr.js"></script>

<script language="javascript">
	var csr_no = '<%=JSPUtil.getNull(csr_no)%>';
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="if_status" value=<%=if_status %>>
<!-- 개발자 작업	-->
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
					<img src="img/ico_t1.gif" width="20" height="12">Rejected CSR Cancellation</td>
				</tr>
			</table>
			<!-- : ( Title ) (E) -->
			<!-- : ( Search Options ) (S) -->
			<table class="search">
				<tr>
					<td class="bg">
					<table class="search" border="0" style="width:100%;">
						<tr class="h23">
							<td width="70">CRS No.</td>
							<td width="270"><input name="csr_no" type="text" style="width:170;" value='<%=csr_no%>' class="input2" readonly></td>
							<td width="90">Payment S/P</td>
							<td><input name="vndr_no" type="text" style="width:80;text-align:center;" value='<%=vndr_no%>' class="input2" readonly> <input name="inv_desc" type="text" style="width:367;" value='<%=inv_desc%>' class="input2" readonly></td>
						</tr>
					</table>
					<table class="search" border="0" style="width:100%;">
						<tr class="h23">
							<td width="70">No. of INV</td>
							<td width="90"><input name="no_of_inv" type="text" style="width:25;" value='<%=no_of_inv%>' class="input2" readonly></td>
							<td width="80">INV Currency</td>
							<td width="100"><input name="csr_curr_cd" type="text" style="width:40;" value='<%=csr_curr_cd%>' class="input2" readonly></td>
							<td width="90">Total AMT</td>
							<td width="120"><input name="csr_amt" type="text" style="width:80;text-align:right;" value='<%=csr_amt%>' class="input2" readonly></td>
							<td width="50">ASA No.</td>
							<td width="150"><input name="attr_ctnt2" type="text" style="width:120;" value='<%=attr_ctnt2%>' class="input2" readonly></td>
							<td width="70">Cost OFC</td>
							<td><input name="ofc_cd" type="text" style="width:61;" value="<%=ofc_cd%>" class="input2" readonly></td>
						</tr>
					</table>
					<table class="search" border="0" style="width:100%;">
						<tr class="h23">
							<td width="70">Issue DT</td>
							<td width="90"><input name="iss_dt" type="text" style="width:75;" value='<%=iss_dt%>' class="input2" readonly></td>
							<td width="80">Receive DT</td>
							<td width="100"><input name="rcv_dt" type="text" style="width:75;" value='<%=rcv_dt%>' class="input2" readonly></td>
							<td width="90">Payment Term</td>
							<td width="175"><input name="vndr_term_nm" type="text" style="width:120;" value='<%=vndr_term_nm%>' class="input2" readonly></td>
							<td width="115">Payment Due DT</td>
							<td><input name="due_dt" type="text" style="width:75;" value='<%=due_dt%>' class="input2" readonly></td>
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
	       	<tr><td class="bg">
				
				<!-- Grid  (S) -->
				<table width="100%" class="search"  id="mainTable">
					<tr>
						<td width="100%">
						<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table> 			
				<!-- Grid (E) -->
				</td></tr>
			</table>
			<!-- : ( Search Options ) (E) -->
			<table class="height_10"><tr><td></td></tr></table>
			</td>
		</tr>
	</table>
	<!-- OUTER - POPUP (E)nd -->
	
 
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btng_save">OK</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>	
				<td class="btn1_line"></td>	    
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right"> 
				</tr></table></td>
			</tr>
		</table></td>
			</tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
</form>
</body>
</html> 

<!-- 개발자 작업  끝 --> 