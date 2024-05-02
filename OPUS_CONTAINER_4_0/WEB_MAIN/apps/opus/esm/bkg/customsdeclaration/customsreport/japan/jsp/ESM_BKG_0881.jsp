<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0881.jsp
*@FileTitle : ESM_BKG_0881
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.07
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.07.07 김승민
* 1.0 Creation
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>

<script language="javascript" src="/opuscntr/rpt/script/common_rd.js"></script>
<script language="javascript">
	function setupPage(){
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="jpMsgTpCd" value="<%=JSPUtil.getParameter(request, "jpMsgTpCd")%>">
<input type="hidden" name="userId" value="<%=JSPUtil.getParameter(request, "userId")%>">
<input type="hidden" name="errorCheck" value="<%=JSPUtil.getParameter(request, "errorCheck")%>">
<input type="hidden" name="dateCheck" value="<%=JSPUtil.getParameter(request, "dateCheck")%>">
<input type="hidden" name="inVvdCd" value="<%=JSPUtil.getParameter(request, "inVvdCd")%>">
<input type="hidden" name="inPodCd" value="<%=JSPUtil.getParameter(request, "inPodCd")%>">
<input type="hidden" name="startRcvDt" value="<%=JSPUtil.getParameter(request, "startRcvDt")%>">
<input type="hidden" name="startRcvDt2" value="<%=JSPUtil.getParameter(request, "startRcvDt2")%>">
<input type="hidden" name="endRcvDt" value="<%=JSPUtil.getParameter(request, "endRcvDt")%>">
<input type="hidden" name="endRcvDt2" value="<%=JSPUtil.getParameter(request, "endRcvDt2")%>">

<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>&nbsp;Receive History from SEA-NACCS Print</span></h2>
		<!-- page_title(E) -->

		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_Print" id="btn_Print">Print</button>
			<button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->
	</div>
	<!-- page_title_area(E) -->
</div>

<!-- layer_popup_contents(S) -->
<div class="layer_popup_contents">
	<div class="wrap_result">
		<div class="opus_design_RD">
			<script type="text/javascript">rdViewerObject();</script>
		</div>
	</div>
</div>
<!-- layer_popup_contents(S) -->
</form>
