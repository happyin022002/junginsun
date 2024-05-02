<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ui_bkg_0793.jsp
*@FileTitle  : Advice notes _ List Print _ Printing
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/17
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
<script type="text/javascript" src="/opuscntr/rpt/script/common_rd.js"></script>
<script type="text/javascript">
	function setupPage(){
		loadPage('<%=JSPUtil.getParameter(request, "vvd")%>'
				,'<%=JSPUtil.getParameter(request, "pod_cd")%>'
				,'<%=JSPUtil.getParameter(request, "pol_cd")%>'
				,'<%=JSPUtil.getParameter(request, "bkg_cust_tp_cd")%>'
				,'<%=JSPUtil.getParameter(request, "bkg_sts_cd")%>'
				,'<%=JSPUtil.getParameter(request, "rt_teu")%>'
				,'<%=JSPUtil.getParameter(request, "rt_feu")%>'
				,'<%=JSPUtil.getParameter(request, "rt_hcb")%>'
				,'<%=JSPUtil.getParameter(request, "ttl_amt")%>'
				,'<%=JSPUtil.getParameter(request, "bl_cnt")%>'
				,'<%=JSPUtil.getParameter(request, "bkg_teu")%>'
				,'<%=JSPUtil.getParameter(request, "bkg_feu")%>'
				,'<%=JSPUtil.getParameter(request, "bkg_hcb")%>'
				,'<%=JSPUtil.getParameter(request, "sub_title")%>'
				,'<%=JSPUtil.getParameter(request, "sub_title2")%>');
	}
</script>
<form name="form">
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><span>Wharfage Charge List Print</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!--
	--><button type="button" class="btn_accent" name="btn_Print" id="btn_Print">Print</button><!--
	--><button type="button" class="btn_normal" name="btn_Close"  	id="btn_Close">Close</button>			</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
</div>

	<!-- page_title_area(E) -->

<div class="opus_design_RD">
		<script type="text/javascript">rdViewerObject();</script></script>
</div>
</form>