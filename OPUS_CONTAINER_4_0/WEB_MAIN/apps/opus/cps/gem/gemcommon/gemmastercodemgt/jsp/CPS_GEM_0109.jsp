<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : cps_gem_0109.jsp
	 *@FileTitle : Office code history
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2009.05.15
	 *@LastModifier : 최정미
	 *@LastVersion : 1.0
	 * 2009.05.15 최정미
	 * 1.0 Creation
	 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.event.CpsGem0109Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	CpsGem0109Event event = null;			//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	
	String strUsr_id = "";
	String strUsr_nm = "";
	String strOfcCd = request.getParameter("ofc_cd");
	
	Logger log = Logger.getLogger("com.clt.apps.TimeCharterInOutAccounting.TCharterIOBunkerRegister");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
		event = (CpsGem0109Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
				
	} catch(Exception ex) {
		log.error("err " + ex.toString(), ex);
		//out.println(e.toString());
	}
%>
<html>
<head>
<title>Office code history</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
function setupPage(){
	var errMessage = "<%=strErrMsg%>";
	if (errMessage.length >= 1) {
		showErrMessage(errMessage);
	} // end if
	loadPage();
}
</script>
</head>

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows"> 

<!-- 개발자 작업 -->
<input type="hidden" name="ofc_cd" value="<%=strOfcCd %>">

<!-- OUTER - POPUP (S)tart -->
<table width="700" class="popup" cellpadding="10" border="0">
	<tr>
		<td class="top"></td>
	</tr>
	<tr>
		<td valign="top">
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
			<tr>
				<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Office code history</td>
			</tr>
		</table>
		<!-- : ( Title ) (E) --> 
		
		<!--biz page (S)-->
		<table class="search" id="mainTable">
			<tr>
				<td class="bg">
				<!-- Grid  (S) -->
				<table width="100%" id="mainTable">
					<tr>
						<td width="100%"><script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- Grid (E) -->
				</td>
			</tr>
		</table>
		<!--biz page (E)-->
		</td>
	</tr>
</table>

<table class="height_5">
	<tr>
		<td></td>
	</tr>
</table>

<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
	<tr>
		<td height="71" class="popup">
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
			<tr>
				<td class="btn3_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_RowAdd">Row Add</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_Save">Save</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td class="btn1_line"></td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_Close">Close</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		<!--Button (E) -->
		</td>
	</tr>
</table>
<!-- : ( Button : pop ) (E) -->

</form>
</body>
</html>