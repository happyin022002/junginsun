<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0753.jsp
*@FileTitle : bookingReport
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.01
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.06.01 강동윤
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.event.EsmBkg0895Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0895Event  event = null;					
	Exception serverException   = null;			
	String strErrMsg = "";						
	int rowCount	 = 0;						
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String rptId			= "";
	String bkgRptKndCd		= "";
	String editYn			= "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.BookingCommon.BookingUtil");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		rptId 		= request.getParameter("rpt_id");
		bkgRptKndCd = request.getParameter("bkg_rpt_knd_cd");
		editYn		= request.getParameter("edit_yn");
		//editYn		= "N";
		if (rptId == null){
			rptId 		= "SELHO00011";
			bkgRptKndCd = "V";
		}
		
		event = (EsmBkg0895Event)request.getAttribute("Event");
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
<title>bookingReport</title>
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
<input type="hidden" name="pagerows">
<input type="hidden" name="rpt_id" value="<%= rptId %>">
<input type="hidden" name="bkg_rpt_knd_cd" value="<%= bkgRptKndCd %>">
<input type="hidden" name="edit_yn" value="<%= editYn %>">
<!-- 개발자 작업	-->

<!-- OUTER - POPUP (S)tart -->
<table width="500" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp; Report Item Option</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 		<table class="search"> 
  		<tr><td class="bg">

			
			<table class="search" border="0" style="width:746;"> 
			<tr class="h23">
				<td width="340">
				
					<!-- : ( Grid ) (S) -->
					<table width="100%"  id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table>
					<!-- : ( Grid ) (E) -->	
				</td>
				<td width="50">
					<table class="search" border="0">
						<tr><td align="center"><img class="cursor" src="img/btns_add.gif" width="26" height="26" border="0" align="absmiddle" name="btns_add"></td></tr>
						<tr><td height="10"></td></tr>
						<tr><td align="center"><img class="cursor" src="img/btns_del.gif" width="26" height="26" border="0" align="absmiddle" name="btns_del"></td></tr>
						<tr><td height="10"></td></tr>
						<tr><td align="center"><img class="cursor" src="img/btn_calendar_next.gif" width="19" height="10" border="0" align="absmiddle" name="btns_up"></td></tr>
						<tr><td height="10"></td></tr>
						<tr><td align="center"><img class="cursor" src="img/btn_calendar_back.gif" width="19" height="10" border="0" align="absmiddle" name="btns_down"></td></tr>
					</table>
				</td>
				<td width="340">
				
					<!-- : ( Grid ) (S) -->
					<table width="100%"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet2');</script>
							</td>
						</tr>
					</table>

					<!-- : ( Grid ) (E) -->	
					
				</td></tr>
		</table>
				<!-- : ( Button : Grid ) (S) -->
				<!--  Button_Sub (S) -->
			
	    	<!-- Button_Sub (E) -->
		    <!-- : ( Button : Grid ) (E) -->	
			
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->
</td></tr>
</table> 

<table class="height_5"><tr><td></td></tr></table>
	
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td width="">
					<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_OK">Save</td>
						<td class="btn1_right"></td>
						</tr>
					</table>
				</td>

				<td width="">
					<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_Close">Close</td>
						<td class="btn1_right"></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>