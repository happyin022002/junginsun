<%
	/*=========================================================
	 *Copyright(c) 2012 CyberLogitec
	 *@FileName : ESM_PRI_7024.jsp
	 *@FileTitle : Special cargo Surcharge for IHC tariff
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 
	 *@LastModifier : 
	 *@LastVersion : 
      * 2013.02.26 [CHM-201323107] 전윤주 화면 이름 변경
      * 2013.08.07 [CHM-201326196] 전윤주 USD 표시를 특정 경우에만 보이도록 변경 
	 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.event.EsmPri7024Event"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%
	EsmPri7024Event event = null;
	Exception serverException = null;
	String strErrMsg = "";
	int rowCount = 0;

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.hanjin.apps.SCGuideline.SCGuidelineMain");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmPri7024Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Special cargo Surcharge for IHC tariff</title>
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

<!-- 개발자 작업	-->
<input type="hidden" name="svc_scp_cd" value="<%= JSPUtil.getParameter(request, "svcScpCd") %>" required="required">
<input type="hidden" name="ihc_trf_no" value="<%= JSPUtil.getParameter(request, "ihcTrfNo") %>" required="required">
<input type="hidden" name="org_dest_tp_cd" value="<%= JSPUtil.getParameter(request, "org_dest_tp_cd") %>" required="required">
<input type="hidden" name=open_page value="<%= JSPUtil.getParameter(request, "opn") %>" >
<table width="100%" class="popup" cellpadding="10" border="0">
	<tr>
		<td class="top"></td>
	</tr>
	<tr>
		<td valign="top"><!-- : ( Title ) (S) -->
		<table width="100%" border="0">
			<tr>
				<td class="title"><img src="img/icon_title_dot.gif"
					align="absmiddle">&nbsp;Special cargo Surcharge for IHC tariff</td>
			</tr>
		</table>
	<!--Page Title, Historical (E)-->
	
	<!--biz page (S)-->
	    <table class="search" border="0" style="width:100%;">        	
			<tr class="h23" id="usd_display" style="display">  
				<td width="">* USD</td>																	
			</tr>                                                                                                                                                                                                                                                                                                                                                                                          
		</table>
	
		<table class="search"> 
       	<tr><td class="bg">
			<!-- Grid  (S) -->
			<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
					<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
			</table>
			<!-- Grid (E) -->
			</td></tr>
		</table>
	<!--  biz_1   (E) -->
	</td></tr>
</table>
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
			    <table border="0" cellpadding="0" cellspacing="0">
			    	<tr>
						<td>
							<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
									<td class="btn1" name="btn_Close">Close</td>
									<td class="btn1_right"></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</td></tr>
		</table>
	</td></tr>
</table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>