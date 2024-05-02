<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EXP_SPP_0001.jsp
*@FileTitle : Canal Invoice
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
<%@ page import="com.clt.apps.opus.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.event.ExpSpp0001Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	ExpSpp0001Event  event = null;				//PDTO(Data Transfer Object including Parameters)
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
	Logger log = Logger.getLogger("com.clt.apps.opus.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();  //100870	  2132  //<--session vndr_seq  //"2132";  //
		strVndr_seq = account.getOfc_eng_nm();
		strVndr_nm	= account.getOfc_krn_nm();


		event = (ExpSpp0001Event)request.getAttribute("Event");
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
<title>Canal Invoice</title>
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

<input type="hidden" name="revyrmon">
<input type="hidden" name="vndr_seq" value="<%=strVndr_seq%>">
<input type="hidden" name="vndr_nm"  value="<%=strVndr_nm%>">

<input type="hidden" name="transymd">

<input type="hidden" name="cnl_tz_bztp_cd" value="E" />

<table width="760" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle" border="0"><span id="title">&nbsp;Canal Transit List</span></td></tr>
		</table>
	<!--Page Title, Historical (E)-->
	<br>
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
       	
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="30">Year</td>
					<td width="120"><input name="revyr" type="text" dataformat="yyyy" maxlength="4" style="width:40" >&nbsp;<img class="cursor" name="btns_calendar" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="210">Canal Transit  List  working Month</td>
					<td width=""><select style="width:40;" name="revmon">
						<option value="01">01</option>
						<option value="02">02</option>
						<option value="03">03</option>
						<option value="04">04</option>
						<option value="05">05</option>
						<option value="06">06</option>
						<option value="07">07</option>
						<option value="08">08</option>
						<option value="09">09</option>
						<option value="10">10</option>
						<option value="11">11</option>
						<option value="12">12</option>					
						</select>&nbsp;<input name="vvdstatus" type="text" style="width:90" class="input2" readonly></td>
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
				<!--  Button_Sub (S) -->
				<table width="100%" class="button"> 
	       		<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Add">Row Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Delete">Row Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
				</td></tr>
				</table>
	    		<!-- Button_Sub (E) -->		
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