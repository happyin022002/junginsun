<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESD_PRD_0037.jsp
*@FileTitle  : Vessel Connect Time Management
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
<%@ page import="com.clt.apps.opus.esd.prd.networklinkmanage.vslconnbuffertime.event.EsdPrd0037Event"%>
<%
	GeneralEventResponse eventResponse = null;
	Exception serverException   = null;
	String strErrMsg = "";
	EsdPrd0037Event  event = null;
	try {
		event = (EsdPrd0037Event)request.getAttribute("Event");
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
<input type="hidden" name="iPage">

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
		--><button type="button" class="btn_normal" name="btn_save" 	id="btn_save">Save</button><!-- 
		--><button type="button" class="btn_normal" name="btn_loadexcel" 	id="btn_loadexcel">Load Excel</button><!-- 
		--><button type="button" class="btn_normal" name="btn_downexcel" 	id="btn_downexcel">Down Excel</button>			
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->

<!-- opus_design_inquiry(S) -->
<div class= "wrap_search">
	<div class="opus_design_inquiry">
		<table>
			<tbody>
				<tr class="h23">
					<th style="width:60px;text-align:left;">T/S Discharge Country</th>
					<td style="width:140px;"><input name="dchg_cnt_cd" id="dchg_cnt_cd" type="text" style="width:70px;text-align:center" value="" dataformat="engup" style="text-align:center"><!-- 
						 --><button type="button" class="input_seach_btn" name="btn_cnt" id="btn_cnt"></button>
					</td>
					<th style="width:60px;text-align:left;">T/S Discharge Port</th>
					<td style="width:140px;"><input name="dchg_tml_cd" id="dchg_tml_cd" type="text" style="width:70px;text-align:center" value="" dataformat="engup" style="text-align:center" maxlength="5"><!-- 
						 --><button type="button" class="input_seach_btn" name="btn_tml" id="btn_tml"></button>
					</td>
					<th style="width:60px;text-align:left;">Discharge Service</th>
					<td style="width:140px;"><input name="dchg_slan_cd" id="dchg_slan_cd" type="text" style="width:70px;text-align:center" value="" dataformat="engup" style="text-align:center"><!-- 
						 --><button type="button" class="input_seach_btn" name="btn_slan" id="btn_slan"></button>
					</td>
					<td>&nbsp;</td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->
<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<div class="opus_design_grid">
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btng_rowadd" id="btng_rowadd">Row Add</button>
			<button type="button" class="btn_normal" name="btng_rowcopy" 	id="btng_rowcopy">Row Copy</button>
			<button type="button" class="btn_normal" name="btng_rowdel" 	id="btng_rowdel">Row Delete</button>
		</div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
</form>
