<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESD_PRD_0038.jsp
*@FileTitle  : Inland Cut Off Time Management
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/22 
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse" %>
<%@ page import="java.util.List" %>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%@ page import="com.clt.apps.opus.esd.prd.networknodemanage.inlandcutoff.event.EsdPrd0038Event"%>
<%
	GeneralEventResponse eventResponse = null;
	Exception serverException   = null;
	String strErrMsg = "";
	EsdPrd0038Event  event = null;
	try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
			eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">
	<%= JSPUtil.getIBCodeCombo("spcl_cgo_cntr_tp_cd",     	"", "CD01507", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("inlnd_cct_tp_cd",     	 	"", "CD30050", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("cct_dy_cd",     	  		"", "CD00131", 0, "")%>
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		}
		loadPage();
	}
</script>
<form method="post" name="form">
<input	type="hidden" name="f_cmd">
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
		--><button type="button" class="btn_normal" name="btn_new"  	id="btn_new">New</button><!-- 
		--><button type="button" class="btn_normal" name="btn_save" 	id="btn_save">Save</button>			
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- opus_design_inquiry(S) -->
<div class= "wrap_search">
	<div class="opus_design_inquiry">
		<table>
			<tbody>
				<tr class="h23" id="search_1">
					<th style="width:60px;">Lane Code</th>
					<td style="width:140px;"><input name="lane_cd" id="lane_cd" type="text" style="width:70px;text-align:center" maxlength="3" value="" dataformat="engup" style="text-align:center"><!-- 
						 --><button type="button" class="input_seach_btn" name="btn_lane_cd" id="btn_lane_cd"></button>
					</td>
					<th style="width:60px;">Cargo Nature</th>
					<td style="width:160px;"><script type="text/javascript">ComComboObject('spcl_cgo_cntr_tp_cd', 1, 150, 1, 0);</script></td>
					<th style="width:60px;">Origin Yard</th>
					<td style="width:140px;"><input name="org_yd_cd" id="org_yd_cd" type="text" style="width:70px;text-align:center" maxlength="7" value="" dataformat="engup" style="text-align:center"><!-- 
						 --><button type="button" class="input_seach_btn" name="btn_org_yd" id="btn_org_yd"></button>
					</td>
					<th style="width:60px;">DEST Yard</th>
					<td style="width:140px;"><input name="dest_yd_cd" id="dest_yd_cd" type="text" style="width:70px;text-align:center" maxlength="7" value="" dataformat="engup" style="text-align:center"><!-- 
						 --><button type="button" class="input_seach_btn" name="btn_dest_yd" id="btn_dest_yd"></button>
					</td>
					<th style="width:60px;">Date</th>
					<td style="width:140px;"><input type="text" id="eff_fm_dt" name="eff_fm_dt" dataformat="ymd" style="width:75px;text-align:center;ime-mode:disabled;" value="" maxlength="10" size="10"/><!--  
						--><button type="button" id="btn_seff_fm_dt" name="btn_s_dt" class="calendar ir"></button>
					</td>
					<td></td>				
				</tr>			
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->				
<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<div class="opus_design_grid" id="mainTable">
		<div class="opus_design_btn opus_design_normal">
			<button type="button" class="btn_accent" name="btng_rowadd" id="btng_rowadd">Row Add</button><!-- 
			--><button type="button" class="btn_normal" name="btng_rowcopy" 	id="btng_rowcopy">Row Copy</button>
		</div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
<div class="header_fixed"></div>
<!-- opus_design_grid(E) -->	
</form>
