<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : COM_CSR_0011.jsp
*@FileTitle : Invoice List Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.20
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2009.07.20 함대성
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.event.ComCsr0011Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	ComCsr0011Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String csr_no = JSPUtil.getNull(request.getParameter("csr_no"));
	String cost_ofc_cd = JSPUtil.getNull(request.getParameter("cost_ofc_cd")); 
	String inv_sub_sys_cd = JSPUtil.getNull(request.getParameter("inv_sub_sys_cd")); 
	String curr_cd = JSPUtil.getNull(request.getParameter("curr_cd")); 
	
	String ofc_cd = "";
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.ConsultationSlipRequestMgt.ConsultationSlipRequestMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

	    ofc_cd = account.getOfc_cd()!=null&&!account.getOfc_cd().equals("")?account.getOfc_cd():"";

		event = (ComCsr0011Event)request.getAttribute("Event");
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
<input type="hidden" name="inv_sub_sys_cd" value="<%=inv_sub_sys_cd%>">
<input type="hidden" name="curr_cd" value="<%=curr_cd%>">
<input type="hidden" name="so_if_cd">

<!-- 개발자 작업	-->
	<!-- OUTER - POPUP (S)tart -->
	<table width="100%" class="popup" cellpadding="10" border="0">
		<tr>
			<td class="top"></td>
		</tr>
		<tr>
			<td valign="top">
			<!-- : ( Title ) (S) -->
			<table width="100%" border="0">
				<tr>
					<td height="79" class="title">
					<img src="img/ico_t1.gif" width="20" height="12">Invoice 
					List Inquiry</td>
				</tr>
			</table>
			<!-- : ( Title ) (E) -->
			<!-- : ( Search Options ) (S) -->
			<table class="search">
				<tr>
					<td class="bg">
					<table class="search" border="0" style="width:100%;">
						<tr class="h23">
							<td width="8%">CSR No.</td>
							<td width="40%" style="padding-left:2">&nbsp;<input name="csr_no" type="text" style="width:180;" value='<%=csr_no%>' ></td>
							<td width="12%">Payment S/P</td>
							<td>&nbsp;<input name="vndr_no" type="text" style="width:75;" value="" >
							<input name="inv_desc" type="text" style="width:213;" value="" ></td>
						</tr>
					</table>
					<div id="srLayer" style="display:none">  
					<table class="search" border="0" style="width:100%;">
						<tr class="h23">
							<td width="8%">No. of INV</td>
							<td width="7%" style="padding-left:2">&nbsp;<input name="no_of_inv" type="text" style="width:30;text-align:right;" value="" ></td>
							<td width="11%">INV Currency</td>
							<td width="8%">&nbsp;<input name="csr_curr_cd" type="text" style="width:42;text-align:center;" value="" ></td>
							<td width="8%">Total AMT</td>
							<td width="19%">&nbsp;<input name="csr_amt" type="text" style="width:100;text-align:right;"  value="" ></td>  
								<td width="7%">ASA No.</td>
							<td width="13%">&nbsp;<input name="attr_ctnt2" type="text" style="width:80;" value="" ></td>
							<td width="8%">Cost OFC</td>
							<td>&nbsp;<input name="ofc_cd" type="text" style="width:64;text-align:center;" value="<%=cost_ofc_cd%>" ></td>
						</tr>
					</table>
					</div>
					<div id="srLayer" style="display:none">  
					<table class="search" border="0" style="width:100%;">
						<tr class="h23">
							<td width="8%">No. of INV</td>
							<td width="7%" style="padding-left:2">&nbsp;<input name="no_of_inv" type="text" style="width:30;text-align:right;" value="" ></td>
							<td width="11%">INV Currency</td>
							<td width="8%">&nbsp;<input name="csr_curr_cd" type="text" style="width:42;text-align:center;" value="" ></td>
							<td width="8%">Total AMT</td>
							<td width="19%">&nbsp;<input name="csr_amt" type="text" style="width:100;text-align:right;"  value="" ></td>  
								<td width="8%">RGST No.</td>
							<td width="13%">&nbsp;<input name="attr_ctnt2" type="text" style="width:80;" value="" ></td>
							<td width="8%">Cost OFC</td>
							<td>&nbsp;<input name="ofc_cd" type="text" style="width:57;text-align:center;" value="<%=cost_ofc_cd%>" ></td>
						</tr>
					</table>
					</div>
					<table class="search" border="0" style="width:100%;">
						<tr class="h23">
							<td width="8%">Issue DT</td>
							<td width="14%">&nbsp;<input name="iss_dt" type="text" style="width:75;text-align:center;" value="" ></td>
							<td width="9%">Receive DT</td>
							<td width="17%" style="padding-left:3">&nbsp;<input name="rcv_dt" type="text" style="width:75;text-align:center;" value="" ></td>
							<td width="12%">Payment Term</td>
							<td width="14%">&nbsp;<input name="vndr_term_nm" type="text" style="width:40;text-align:right;"" value="" ></td>
							<td width="14%">Payment Due DT</td>
							<td>&nbsp;<input name="due_dt" type="text" style="width:74;text-align:center;" value="" ></td>
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
<DIV style="display:none"> 
		<!-- Grid  (S) -->
		<table width="100%" class="search"  id="mainTable"> 
			<tr>
				<td width="100%">
				<script language="javascript">ComSheetObject('sheet2');</script>
				</td>
			</tr>
		</table> 			
		<!-- Grid (E) --> 
</DIV>

<!-- 개발자 작업  끝 --> 