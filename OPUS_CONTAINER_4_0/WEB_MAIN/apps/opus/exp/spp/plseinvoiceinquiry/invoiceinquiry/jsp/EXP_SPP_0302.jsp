<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EXP_SPP_0302.jsp
*@FileTitle : Rental payable invoice inquiry by Lessee via SPP
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.exp.spp.plseinvoiceinquiry.invoiceinquiry.event.ExpSpp0302Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	ExpSpp0302Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//The count of DB ResultSet list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	String strVndr_seq		= "";
	String strVndr_nm		= "";
	String strAdm_chk		= "0";
	Logger log = Logger.getLogger("com.clt.apps.opus.exp.spp.plseinvoiceinquiry.invoiceinquiry");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();  //100870	  2132  //<--session vndr_seq  //"105028";  //
		strVndr_seq	= account.getOfc_eng_nm();
		strVndr_nm	= account.getOfc_krn_nm();

		if( strVndr_seq.equals("0")){
			strAdm_chk = "1";
			strVndr_seq = "";
			strVndr_nm = "";
		}
		event = (ExpSpp0302Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<html>
<head>
<title>Payable Invoice Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();"> 

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows" value="<%=pageRows%>">
<input type="hidden" name="admCheck" value="<%=strAdm_chk %>">

<table width="760" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle" border="0"><span id="title">&nbsp;Payable Invoice Inquiry</span></td></tr>
		</table>
	<!--Page Title, Historical (E)-->
		
		<br>
		
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
       	
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="105">Lessor I/D</td>
					<td width=""><input name="vndr_seq" type="text" style="width:100;text-align:center;" class="input" style="ime-mode:disabled;" value="<%=strVndr_seq%>" dataformat="int" maxlength="6">
								<% if(strAdm_chk.equals("1")){ %>
								 <img class="cursor" name="btn_search2" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">&nbsp;
								<% }else{ %>
								<!--   <img name="btn_search2" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">&nbsp;-->
								<% } %>
								 <input name="vndr_nm" type="text" style="width:400;text-align:center;" class="input2" readonly value="<%=strVndr_nm%>">
					</td>
				</tr> 
				</table>
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="105">Invoice Issue date</td>
					<td width="">	<input type="text" name="str_dt"   caption="From Date" style="width:62;text-align:center;" class="input1" value="" dataformat="ymd" cofield="end_dt"   required>
									~
									<input type="text" name="end_dt"   caption="To Date"   style="width:62;text-align:center;" class="input1" value="" dataformat="ymd" cofield="str_dt"   required>
									
									<img class="cursor" src="img/btns_calendar.gif" name="btns_Calendar" width="19" height="20" border="0" align="absmiddle" dataformat="ymd"> 
									
									
									
					</td>
					
					
					
					<td width="75">Lease Term</td>
					<td width="165"><script language="javascript">ComComboObject('combo1', 1, 60, 1 );</script>&nbsp;
						            <input type="text" name="lstm_cd" style="width:90;text-align:center;" class="input2" readonly></td>
					<td width="70">Invoice No</td>
					<td width=""><input name="inv_no" type="text" style="width:140;text-align:center;ime-mode:disabled;" class="input" maxlength='20'></td>
				</tr> 
				</table>				
				<!--  biz_1   (E) -->
				
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>

				<!--  biz_2  (S) -->
				<!-- Grid  (S) -->
					<table width="100%"  id="mainTable">
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table>
				<!-- Grid (E) -->
				<!--  biz_2   (E) -->
				
				</td></tr>
			</table>
	<!--biz page (E)-->
	
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->	
	

	</td></tr>
</table>

</form>
</body>
</html>