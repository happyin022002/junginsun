<%
/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0278.jsp
 *@FileTitle : Hanjin Shipping Draft B/L Copies
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.04.12
 *@LastModifier : 나상보
 *@LastVersion : 1.0
 * 2009.08.14 나상보
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
<%@ page import="com.hanjin.syscommon.common.reportdesigner.commonpopup.event.ComRdCommonPopupEvent"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	ComRdCommonPopupEvent event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.hanjin.apps.ReportDesigner.CommonPopup");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (ComRdCommonPopupEvent) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}


%>
<html>
<head>
<title><%=request.getParameter("com_mrdTitle") %></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		rdOpen();
	}
</script>
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>
</head>
<!-- 
showErrMessage를 써주지 않으면 에러 발생시 처리가 불가합니다.
그리고 지금은 showErrMessage()으로 되어있지만 추후에 고객님이 변덕을 일으켜서 웹페이지를 호출하라고 할경우를 
대비해서 직접 showErrMessage() 하지 마시고 꼭 showErrMessage를 써주십시오. 한방에 바꾸게요. 표준을 안따르면 나중에 후회합니다.  
-->

<body class="popup_bg" onload="javascript:setupPage();">
<form name="form" onkeyup="ComKeyEnter('lengthnextfocus');">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows">
<%
	String[] mrdParameters = request.getParameterValues("com_mrdArguments");
	int i=0;
	for(String comMrdPath:request.getParameterValues("com_mrdPath")){
		if(!comMrdPath.equals("") && !comMrdPath.equals(" ") && comMrdPath != null){
			out.print("<input type=\"hidden\" id=\"com_mrdPath\" value=\""+comMrdPath+"\"/>");
			out.print("<input type=\"hidden\" id=\"com_mrdArguments\" value=\""+mrdParameters[i++]+"\"/>");
		}
	}
%>
<input type="hidden" id="com_mrdSaveDialogDir" value="<%=request.getParameter("com_mrdSaveDialogDir")%>" />
<input type="hidden" id="com_mrdSaveDialogFileName" value="<%=request.getParameter("com_mrdSaveDialogFileName")%>" />
<input type="hidden" id="com_mrdSaveDialogFileExt" value="<%=request.getParameter("com_mrdSaveDialogFileExt")%>" />
<input type="hidden" id="com_mrdSaveDialogFileExtLimit" value="<%=request.getParameter("com_mrdSaveDialogFileExtLimit")%>" />
<input type="hidden" id="com_mrdDisableToolbar" value="<%=request.getParameter("com_mrdDisableToolbar")%>" />
<input type="hidden" id="com_zoomIn" value="<%=request.getParameter("com_zoomIn")%>" />
<input type="hidden" id="com_isBatch" value="<%=request.getParameter("com_isBatch")%>" />
<input type="hidden" id="com_mrdPrintPaperSize" value="<%=request.getParameter("com_mrdPrintPaperSize")%>" />
<input type="hidden" id="bkgNoList" value="<%=request.getParameter("bkgNoList")%>" />
<input type="hidden" id="booking_por_cd" value="<%=request.getParameter("booking_por_cd")%>" />
<input type="hidden" id="strUsr_id" value="<%=request.getParameter("strUsr_id")%>" />
<!-- OUTER - POPUP (S)tart -->
<table class="popup" cellpadding="10" width="100%" height="570"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;<%=request.getParameter("com_mrdBodyTitle") %></td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		<table id="rdTable" width="100%" height="94%">
			<tr>
				<td height="100%" ><script language="javascript">
					comRdObjectPopup("Rdviewer");
				</script></td>
			</tr>
		</table>
		
		<!-- TABLE '#D' : ( Search Options : Scenario ID ) (S) -->
		
	<table class="height_5"><tr><td></td></tr></table>
<!-- OUTER - POPUP (E)nd -->
</td></tr>
</table>  
	
	
<!-- : ( Button : Sub ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
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

	</td></tr>
</table>
<!-- : ( Button : Sub ) (E) -->
</form>
</body>
</html>