<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : CPS_CNI_9999.jsp
*@FileTitle  : [CPS_CNI_9999] Rd View 공통 파일
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/03
=========================================================*/
%>     
     
     
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger"%>
<% 
String param = JSPUtil.getParameter(request,"com_mrdArguments","");
String title = JSPUtil.getParameter(request,"com_mrdBodyTitle","");
String mrd = JSPUtil.getParameter(request,"com_mrdPath","");
%>

<script type="text/javascript" src="/opuscntr/rpt/script/common_rd.js"></script>
<script type="text/javascript">
    function setupPage(){      
        loadPage();
    }
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd"> 
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="param" id="param" value="<%=param%>">
<input type="hidden" name="title" id="title" value="<%=title%>">
<input type="hidden" name="mrd" id="mrd" value="<%=mrd%>">

<div class="layer_popup_title">
<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><span id="title"><%=title%></span></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button type="button" id="btn_Close" name="btn_Close" class="btn_normal">Close</button><!--
		--></div>
	<!-- opus_design_btn (E) -->
</div>
<!-- page_title_area(E) -->
</div>

<div class="layer_popup_contents">
	<div class="wrap_result">
       	<div class="opus_design_RD">
       		<script type="text/javascript">rdViewerObject();</script>                	
       	</div>
     </div>
</div>
</form>