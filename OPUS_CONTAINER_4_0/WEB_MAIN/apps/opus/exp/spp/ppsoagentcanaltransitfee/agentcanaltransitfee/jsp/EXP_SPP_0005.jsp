<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EXP_SPP_0005.jsp
*@FileTitle : Canal booking status for Panama
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
<%@ page import="com.clt.apps.opus.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.event.ExpSpp0005Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	ExpSpp0005Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//The count of DB ResultSet list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";					//The showing data count per page

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";	
	String strVndr_seq		= "";
	
	Logger log = Logger.getLogger("com.clt.apps.opus.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id 	=	account.getUsr_id();
		strUsr_nm 	= 	account.getUsr_nm();
		strOfc_cd 	= 	account.getOfc_cd();  
		strVndr_seq = 	account.getOfc_eng_nm();
		
		event = (ExpSpp0005Event)request.getAttribute("Event");
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
<title>Canal booking status for Panama</title>
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
<!-- use it if retrieves -->
<input type="hidden" name="vndr_seq" value="<%=strVndr_seq%>">

<table width="760" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Canal booking status for Panama</td></tr>
		</table>
	<!--Page Title, Historical (E)-->
	<br>
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
       	
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="50">Period</td>
					<td width="">
						  <input type="text" name="str_dt" 	 dataformat="ymd"    caption="Start Date"    maxlength="8"  size="10"  cofield="end_dt" value="">   
                  		~ <input type="text" name="end_dt"   dataformat="ymd"    caption="End Date"    maxlength="8"  size="10"  cofield="str_dt">
                  		&nbsp;<img name="btns_Calendar" class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"> 
					</td>
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
							<td class="btn2" name="btn_DownExcel">Down Excel</td>
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
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save">Save</td>
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