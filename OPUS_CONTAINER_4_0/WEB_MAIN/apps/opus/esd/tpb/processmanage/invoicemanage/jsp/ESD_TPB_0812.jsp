<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TPB_0812.jsp
*@FileTitle  : Taxation Control
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/22
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.event.EsdTpb0812Event"%>
<%@ page import="com.clt.apps.opus.esd.tpb.common.TPBUtils"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.apps.opus.esd.tpb.common.combo.basic.CommonCodeBCImpl"%>

<%
	String ofc_cd = "";
	String cnt_cd = "";
	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	ofc_cd = account.getOfc_cd();
	//cnt_cd = account.getCnt_cd();
	cnt_cd = JSPUtil.getNull(new CommonCodeBCImpl().getMDMCntCd(ofc_cd));
%>

<head>
<title>Taxation Control</title>


<script type="text/javascript">
	function setupPage(){
		loadPage();
	}
</script>
</head>

<form method="post" name="form" >
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />

<input type="hidden" name="iPage" id="iPage">
<input type="hidden" name="s_ofc_grd" id="s_ofc_grd" value="T">
<input type="hidden" name="s_cnt_cd" id="s_cnt_cd" value="<%=cnt_cd %>">

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_save" id="btn_save" type="button">Save</button><!--
		--></div>
	<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="100" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
		   			<th>Effective Date</th>
		   			<td><input type="text" name="s_calendar_date1" style="width:75px;" value="" id="s_calendar_date1" /><button type="button" id="btns_calendar1" name="btns_calendar1" class="calendar ir"></button></td>
		   			<td style="display:none"><select name="s_ofc_cd" id="s_ofc_cd" style="width:100px;display:none"></select></td>
		   		</tr>
		   </tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn_add" id="btn_add" type="button">Row Add</button><!--
			--><button class="btn_normal" name="btn_reset" id="btn_reset" type="button">Reset</button><!--
			--></div>
		<!-- opus_design_btn (E) -->
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->
</div>

</form>