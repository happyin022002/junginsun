<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ui_bkg_0023.jsp
*@FileTitle : Advice notes _ List Print _ Printing
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.24
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2009.04.24 김민정
* 1.0 Creation
=========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%

	String title = JSPUtil.getParameter(request,"rd_title","");

%>
<html>
<head>
<title>Advice notes List Print</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/opuscntr/rpt/script/common_rd.js"></script>
<script language="javascript">
	function setupPage(){
		loadPage('<%=StringUtil.xssFilter(request.getParameter("vvd_cd"))%>'
		,'<%=StringUtil.xssFilter(request.getParameter("pod_cd"))%>'
		,'<%=StringUtil.xssFilter(request.getParameter("del_cd"))%>'
		,'<%=StringUtil.xssFilter(request.getParameter("bl_no"))%>');
	}
</script>
</head>
<body onload="setupPage();">
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span><%=title %></span></h2>
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_Print" id="btn_Print">Print</button>
			<button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>		
	</div>
</div>

<div class="layer_popup_contents">
	
	<div class="wrap_result">
		<div class="opus_design_RD"> 
			<script language="javascript">rdViewerObject('Rdviewer');</script>
		</div>
	</div>
</div>
</form>