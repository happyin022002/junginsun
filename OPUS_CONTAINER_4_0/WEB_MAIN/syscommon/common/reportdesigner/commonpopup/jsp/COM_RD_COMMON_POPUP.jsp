<%@page import="com.clt.framework.component.util.StringUtil"%>
<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : COM_RD_COMMON_POPUP.jsp
*@FileTitle : COM_RD_COMMON_POPUP
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/09
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.syscommon.common.reportdesigner.commonpopup.event.ComRdCommonPopupEvent"%>
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
	Logger log = Logger.getLogger("com.clt.apps.ReportDesigner.CommonPopup");

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
<title><%=StringUtil.xssFilter(request.getParameter("com_mrdTitle")) %></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		rdOpen();
	}
</script>
<script type="text/javascript" src="/opuscntr/rpt/script/rdviewer50.js"></script>
</head>
<!-- 
showErrMessage를 써주지 않으면 에러 발생시 처리가 불가합니다.
그리고 지금은 showErrMessage()으로 되어있지만 추후에 고객님이 변덕을 일으켜서 웹페이지를 호출하라고 할경우를 
대비해서 직접 showErrMessage() 하지 마시고 꼭 showErrMessage를 써주십시오. 한방에 바꾸게요. 표준을 안따르면 나중에 후회합니다.  
-->

<form name="form" onkeyup="ComKeyEnter('lengthnextfocus');">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows">
<%
	String[] mrdParameters = request.getParameterValues("com_mrdArguments");
	int i=0;
	for(String comMrdPath:request.getParameterValues("com_mrdPath")){
		if(!comMrdPath.equals("") && !comMrdPath.equals(" ") && comMrdPath != null){
			out.print("<input type=\"hidden\" name=\"com_mrdPath\" id=\"com_mrdPath\" value=\""+comMrdPath+"\"/>");
			out.print("<input type=\"hidden\" name=\"com_mrdArguments\" id=\"com_mrdArguments\" value=\""+mrdParameters[i++]+"\"/>");
		}
	}
%>
<input type="hidden" id="com_mrdSaveDialogDir" value="<%=StringUtil.xssFilter(request.getParameter("com_mrdSaveDialogDir"))%>" />
<input type="hidden" id="com_mrdSaveDialogFileName" value="<%=StringUtil.xssFilter(request.getParameter("com_mrdSaveDialogFileName"))%>" />
<input type="hidden" id="com_mrdSaveDialogFileExt" value="<%=StringUtil.xssFilter(request.getParameter("com_mrdSaveDialogFileExt"))%>" />
<input type="hidden" id="com_mrdSaveDialogFileExtLimit" value="<%=StringUtil.xssFilter(request.getParameter("com_mrdSaveDialogFileExtLimit"))%>" />
<input type="hidden" id="com_mrdDisableToolbar" value="<%=StringUtil.xssFilter(request.getParameter("com_mrdDisableToolbar"))%>" />
<input type="hidden" id="com_zoomIn" value="<%=StringUtil.xssFilter(request.getParameter("com_zoomIn"))%>" />
<input type="hidden" id="com_isBatch" value="<%=StringUtil.xssFilter(request.getParameter("com_isBatch"))%>" />
<input type="hidden" id="com_mrdPrintPaperSize" value="<%=StringUtil.xssFilter(request.getParameter("com_mrdPrintPaperSize"))%>" />
<!-- OUTER - POPUP (S)tart -->

	<div class="layer_popup_title">	
		<div class="page_title_area clear">
		   	<h2 class="page_title"><span><%=StringUtil.xssFilter(request.getParameter("com_mrdBodyTitle"))%></span></h2>
		    <div class="opus_design_btn" id="btnArea">
				<button type="button" class="btn_normal" name="btn_Close"	id="btn_Close">Close</button>
		    </div>
		</div>
	</div>


	<div class="layer_popup_contents" style="overflow:hidden;">
		<div class="wrap_result">
			<div class="opus_design_RD"> 
				<script type="text/javascript">comRdObjectPopup("Rdviewer");</script>
		    </div>
		</div>
	</div>

<!-- : ( Button : Sub ) (E) -->
</form>
<script>
$(window).bind("load",function(){
	var popupCont		= $(this.document.body).find(".layer_popup_contents");
	var popupContHeight = $(this.document.body).innerHeight();
	var popTitleHeight	= $(this.document.body).find(".layer_popup_title").innerHeight();
	
	var resultHeight 	= popupContHeight - $(popupCont).children(".wrap_result").position().top;
	
	
	// layer_popup_contents DIV가 최상위 부모가 아닐 경우 height 100% 처리
	if($(popupCont).parent()[0].tagName != "BODY") {
		$(popupCont).parent().css("height","100%");
	}
	
	// wrap_result Height 지정.
	$(popupCont).css("padding-top",popTitleHeight)
	.children(".wrap_result").css("height",resultHeight-1);//border-bottom-width 1px
});
</script>