<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ui_bkg_1112.jsp
*@FileTitle : ACI_Vessel Information
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.10
*@LastModifier : 계기훈
*@LastVersion : 1.0
* 2010.11.10 계기훈
* 1.0 Creation
=========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.event.EsmBkg1112Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EsmBkg1112Event  event = null;		//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;	//서버에서 발생한 에러
	String strErrMsg = "";				//에러메세지
	int rowCount	 = 0;				//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.ManifestListDownload");

	try {
	   	SignOnUserAccount account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
		event = (EsmBkg1112Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Eur24 Hour : View MSG</title>
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
<body class="popup_bg"  onLoad="setupPage();" >
<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="vvd" value='<%= request.getParameter("vvd")%>'>
<input type="hidden" name="bl_no" value='<%= request.getParameter("bl_no")%>'>
<input type="hidden" name="cstms_port_cd" value='<%= request.getParameter("cstms_port_cd")%>'>
<input type="hidden" name="edi_rcv_dt" value='<%= request.getParameter("edi_rcv_dt")%>'>
<input type="hidden" name="edi_rcv_seq" value='<%= request.getParameter("edi_rcv_seq")%>'>
<input type="hidden" name="cnt_cd" value='<%= request.getParameter("cnt_cd")%>'>
<table width="100%" class="popup" cellpadding="10" border="0"> 
	<tr><td class="top"></td></tr>
	<tr>
		<td valign="top">
			<table width="100%" border="0">
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">
				Eur24 Hour : View MSG</td></tr>
			</table>
			<!-- <table class="search">
				<tr>
					<td class="bg">
						<table class="search" border="0" width='480'>
							<tr class="h23">
								<td width='100'>Status</td>
								<td width='380' style="padding-left: 1">
									<input type="text" style="width: 70" name='form_ack_rcv_sts_cd' class="input2">
								</td>
							</tr>
							<tr class="h23">
								<td>Reject Code</td>
								<td style="padding-left: 1">
									<input type="text" style="width: 80"  name='form_eur_cstms_rjct_cd'  class="input2">
								</td>
							</tr>
							<tr class="h23">
								<td valign="top">Reject Description</td>
								<td><textarea style="width: 100%; height: 70" name='form_rjct_rsn_rmk'  class="input2"></textarea>
							</td>
							</tr>
							<tr class="h23">
								<td valign="top">Message Text</td>
								<td><textarea style="width: 100%; height: 70" name='form_edi_rcv_msg_ctnt'  class="input2"></textarea></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>-->
<!--biz page 2 (S)-->
			<table width="100%" id="mainTable" >
				<tr>
					<td width="100%"><script language="javascript">ComSheetObject('sheet1');</script></td>
				</tr>
			</table>
<!--biz page 2 (E)-->
<table class="height_5"><tr><td></td></tr></table>
		</td>
	</tr>
</table>

<table width="100%" class="sbutton">
	<tr>
		<td height="" class="popup">
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
				<tr>
					<td class="btn3_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Close" onClick="window.close()">Close</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</form>
</body>
</html>