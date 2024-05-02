<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ui_bkg_0020.jsp
*@FileTitle : ACI_Vessel Information
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.24
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2009.04.24 김민정
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.canada.event.EsmBkg0020Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0020Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.ManifestListDownload");
	String vvdCd = "";
	String etaDt = "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		vvdCd = StringUtil.xssFilter(request.getParameter("vvd_cd"));
		etaDt = StringUtil.xssFilter(request.getParameter("eta_dt"));
        
		event = (EsmBkg0020Event)request.getAttribute("Event");
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
<title>Advice Notes</title>
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

<body  onLoad="setupPage();">
<form name="form" method="post">
<input type="hidden" name="f_cmd">
<table width="100%" class="popup" cellpadding="10" border="0"> 
	<tr><td class="top"></td></tr>
	<tr>
		<td valign="top">
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">
				Advice Note Type Setup Pop-up</td></tr>
			</table>
			<table class="search" id="mainTable"> 
				<tr> 
					<td class="bg">
						<table class="search" border="0" style="width:100%;"> 
							<tr class="h23">
								<td width="25"><input type="checkbox" class="trans" name="vvd_flg" checked></td>
								<td width="66">VVD</td>
								<td width=""><input type="text" style="width:315;" class="input" readonly="readonly"
									name="vvd_cd" maxlength="9" dataformat="eng" minlength="9" caption="VVD" value="<%=vvdCd%>"></td>
							</tr> 
							</table>	
							<table class="search" border="0" style="width:100%;"> 
							<tr class="h23">
								<td width="25"><input type="checkbox" class="trans" name="eta_flg" checked></td>
								<td width="66">ETA</td>
								<td width=""><input type="text" style="width:315;" class="input" readonly="readonly"
									name="eta_dt" dataformat="ymd" caption="ETA" value="<%=etaDt%>"></td>
							</tr> 
							</table>
							<table class="search" border="0" style="width:100%;"> 
							<tr class="h23">
								<td width="25"><input type="checkbox" class="trans" name="antype_flg" checked></td>
								<td width="66">A/N Type</td>
								<td width="" style="padding-left:2">
									<script language="javascript">ComComboObject('cnd_an_tp_cd', 1, 315, 1);</script>
								</td>
							</tr> 
						</table>
					</td>
				</tr>
			</table>
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
				<tr>
					<td class="btn1_bg">
					    <table border="0" cellpadding="0" cellspacing="0">
						    <tr>
						    	<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td>
									<td class="btn1" name="btn_Setup">Setup</td>
									<td class="btn1_right"></td>
									</tr></table>
								</td>	
							</tr>
						</table>
					</td>
				</tr>
			</table>
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
									<tr><td class="btn1_left"></td>
										<td class="btn1" name="btn_close" onclick="window.close()">Close</td>
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
<script language="javascript">ComSheetObject('sheet1');</script>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>