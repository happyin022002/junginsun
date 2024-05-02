<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESM_BKG_0352.jsp
*@FileTitle : ESM_BKG_0352
*Open Issues :
*Change history :
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%	 
	String bl_no = "";	  

	try {	 
		bl_no = (request.getParameter("bl_no") == null) ? "" : request.getParameter("bl_no");		 				
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript" src="/opuscntr/rpt/script/common_rd.js"></script>

<script type="text/javascript">
	function setupPage(){	
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="bl_no" value="<%= StringUtil.xssFilter(bl_no) %>">

<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>I/B B/L Print File_Print Preview</span></h2>
		
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_close" id="btn_close" >Close</button>
		</div>
	</div>
</div>
<div class="layer_popup_contents">
	<div class="wrap_result">
		<div class="opus_design_RD">
			<script language="javascript">rdViewerObject('report1');</script>
		</div>
	</div>	
</div>
</form>
