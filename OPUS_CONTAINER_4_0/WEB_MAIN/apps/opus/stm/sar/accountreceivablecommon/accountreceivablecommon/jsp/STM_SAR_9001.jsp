<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAR_9001.jsp
*@FileTitle  : [STM_SAR_9001] Rd View 공통 파일
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/11
=========================================================*/
--%>
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
String xmlData = JSPUtil.getParameter(request,"com_mrdXmlData","");
%>


<script type="text/javascript">
    function setupPage(){      
        loadPage();
    }
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="param" value="<%=param%>" id="param" />
<input type="hidden" name="title" value="<%=title%>" id="title" />
<input type="hidden" name="mrd" value="<%=mrd%>" id="mrd" />
<input type="hidden" name="xmlData" value="<%=xmlData%>" id="xmlData" />
<!-- 개발자 작업 -->
<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<h2 class="page_title"><span><%=title%></span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_Close" id="btn_Close">Close</button><!--
		--></div>
		<!-- opus_design_btn(E) -->
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