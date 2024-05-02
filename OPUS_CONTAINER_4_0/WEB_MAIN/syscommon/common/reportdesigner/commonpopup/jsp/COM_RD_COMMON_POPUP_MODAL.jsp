<%@page import="com.clt.framework.component.util.StringUtil"%>
<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : COM_RD_COMMON_POPUP.jsp
*@FileTitle  : COM_RD_COMMON_POPUP
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/15
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<link href="/opuscntr/css/opus_contents.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
	function setupPage(){
		setModalValues();
		rdOpen();
	}
</script>

<script type="text/javascript" src="/opuscntr/rpt/script/rdviewer50.js"></script>
<script type="text/javascript" src="/opuscntr/syscommon/common/reportdesigner/commonpopup/script/COM_RD_COMMON_POPUP_MODAL.js"></script>

<form name="form">
<input type="hidden" id="f_cmd" />
<input type="hidden" id="pagerows" />
<input type="hidden" id="com_mrdSaveDialogDir" value="<%=StringUtil.xssFilter(request.getParameter("com_mrdSaveDialogDir"))%>"/>
<input type="hidden" id="com_mrdSaveDialogFileName" value="<%=StringUtil.xssFilter(request.getParameter("com_mrdSaveDialogFileName"))%>"/>
<input type="hidden" id="com_mrdSaveDialogFileExt" value="<%=StringUtil.xssFilter(request.getParameter("com_mrdSaveDialogFileExt"))%>"/>
<input type="hidden" id="com_mrdSaveDialogFileExtLimit" value="<%=StringUtil.xssFilter(request.getParameter("com_mrdSaveDialogFileExtLimit"))%>"/>
<input type="hidden" id="com_mrdDisableToolbar" value="<%=StringUtil.xssFilter(request.getParameter("com_mrdDisableToolbar"))%>" />
<input type="hidden" id="com_zoomIn" value="<%=StringUtil.xssFilter(request.getParameter("com_zoomIn"))%>"/>
<input type="hidden" id="com_isBatch" value="<%=StringUtil.xssFilter(request.getParameter("com_isBatch"))%>"/>
<input type="hidden" id="com_mrdPath" value="<%=StringUtil.xssFilter(request.getParameter("com_mrdPath"))%>"/>
<input type="hidden" id="com_mrdArguments" value="<%=StringUtil.xssFilter(request.getParameter("com_mrdArguments"))%>"/>
<input type="hidden" id="com_mrdPrintPaperSize" value="<%=StringUtil.xssFilter(request.getParameter("com_mrdPrintPaperSize"))%>"/>

<div class="layer_popup_title">	
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span id="com_mrdBodyTitle"></span></h2>
		<!-- page_title(E) -->
		
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_Close" onclick="ComClosePopup()"	id="btn_Close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->
	</div>
	<!-- page_title_area(E) -->
</div>

<div class="layer_popup_contents">
	<div class="wrap_result" style="overflow:hidden">	
		<div class="opus_design_RD"> 
			<script type="text/javascript">comRdObjectPopup("Rdviewer");</script>
	    </div>
	</div>
</div>

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
</form>