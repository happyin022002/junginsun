<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ui_bkg_1027.jsp
*@FileTitle : View Sent/Received Log Popup
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.02
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.04.24 임재택
* 1.0 Creation
* 1.1 2015.04.27 소스 보안 [CWE-080]으로 수정 
=========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>

<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>

<%
	 
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
    String rcv_snd_div_cd = "";
    String sheet_msg_snd_dt = "";
    String sheet_bl_no = "";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.ManifestListDownload");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		
		rcv_snd_div_cd = StringUtil.xssFilter(request.getParameter("rcv_snd_div_cd"))==null?"":StringUtil.xssFilter(request.getParameter("rcv_snd_div_cd"));
		sheet_msg_snd_dt = StringUtil.xssFilter(request.getParameter("sheet_msg_snd_dt"))==null?"":StringUtil.xssFilter(request.getParameter("sheet_msg_snd_dt"));
		sheet_bl_no = StringUtil.xssFilter(request.getParameter("sheet_bl_no"))==null?"":StringUtil.xssFilter(request.getParameter("sheet_bl_no"));
		
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
<title>ROCS: View Sent/Received Log</title>
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

<body class="popup_bg" onLoad="setupPage();">
<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="rcv_snd_div_cd" value="<%=rcv_snd_div_cd%>">
<input type="hidden" name="sheet_msg_snd_dt" value="<%=sheet_msg_snd_dt%>">
<input type="hidden" name="sheet_bl_no" value="<%=sheet_bl_no%>"> 

<table width="100%" class="popup" cellpadding="10" border="0"> 
	<tr>
		<td class="top"></td>
	</tr>
	<tr>
		<td valign="top">
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"> View Sent/Received Log</td></tr>
		</table>	
			<table class="search">
       			<tr>
       				<td class="bg">
						<table width="100%"  id="mainTable">
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>

<table class="height_5"><tr><td></td></tr></table>
		</td>
	</tr>
</table> 
	
<table width="100%" class="sbutton">
	<tr>
		<td height="71" class="popup">
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
	       		<tr>
	       			<td class="btn3_bg">
					    <table border="0" cellpadding="0" cellspacing="0">
						   <tr>						    	 						    	
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
		</td>
	</tr>
	 
</table>
</form>
</body>
</html>