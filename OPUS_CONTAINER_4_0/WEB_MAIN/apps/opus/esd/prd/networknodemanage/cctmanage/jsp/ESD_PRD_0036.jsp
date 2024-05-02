<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESD_PRD_0036.jsp
*@FileTitle  : CCT Management by Yard for Export Booking 
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
<%@ page import="com.clt.apps.opus.esd.prd.networknodemanage.cctmanage.event.EsdPrd0036Event"%>
<%@ page import="java.util.List" %>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%
	GeneralEventResponse eventResponse = null;
	Exception serverException   = null;
    List list = null;
	String strErrMsg = "";
	String locCd ="";
	String mode = "";
	EsdPrd0036Event  event = null;
	String today = DateTime.getFormatString("yyyyMMdd");
	String afterOneMonth = DateTime.addMonths(today, 1);
	    
	try {
		event = (EsdPrd0036Event)request.getAttribute("Event");
	    mode = StringUtil.xssFilter(request.getParameter("mode"));
	    locCd = StringUtil.xssFilter(request.getParameter("loc_cd"));
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
			eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
			if (eventResponse != null) {
				list = eventResponse.getRsVoList();
			}
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">
	var afterOneMonth = '<%=afterOneMonth%>';
	var today = '<%=today%>';
	<%= JSPUtil.getIBCodeCombo("cct_day", "01", "CD00131", 0,  "000010::" )%>
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		locCd = "<%=locCd%>";
		mode = "<%=mode%>";
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
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->

<!-- opus_design_inquiry(S) -->
<div class= "wrap_search">
	<div class="opus_design_inquiry">
		<table>
			<tbody>
				<tr class="h23" id="search_1">
					<td style="width:30px"><input type="radio"  name="chk_t" value="T" checked="checked" onclick="fncRadioCheck(this)"></td>
					<th style="width:60px;">Country</th>
					<td style="width:140px;"><input name="country_code" id="country_code" type="text" style="width:70px;text-align:center" maxlength="2" value="" dataformat="engup" style="text-align:center"><!-- 
						 --><button type="button" class="input_seach_btn" name="btn_cnt" id="btn_cnt"></button>
					</td>
					<th style="width:60px;">Location</th>
					<td style="width:140px;"><input name="location_code" id="location_code" type="text" style="width:70px;text-align:center" maxlength="5" value="<%=locCd%>" dataformat="engup" style="text-align:center"><!--
						 --><button type="button" class="input_seach_btn" name="loc_btn" id="loc_btn"></button>
					<th style="width:30px;">Yard</th>
					<td style="width:140px;"><input name="yard_code" id="yard_code" type="text" style="width:70px;text-align:center" maxlength="7" value="" dataformat="engup" style="text-align:center"><!--
						 --><button type="button" class="input_seach_btn" name="node_btn" id="node_btn"></button>
					</td>
					<th style="width:30px;">Lane</th>
					<td style="width:140px;"><input name="lane_code" id="lane_code" type="text" style="width:70px;text-align:center" maxlength="3" value="" dataformat="engup" style="text-align:center"><!--
						 --><button type="button" class="input_seach_btn" name="btn_slan" id="btn_slan"></button>
					</td>
					<th style="width:40px;">Status</th>
					<td>
						<select name="status_code" id="status_code" style="width:100px">
							<option value="ALL" selected>All</option>
							<option value="N" >Live</option>
							<option value="Y" >Delete</option>
						</select>
					</td>	
					<td></td>		
				</tr>
		   		<tr class="h23" id="search_2">
		   			<td style="width:30px"><input type="radio"  name="chk_t" value="V" onclick="fncRadioCheck(this)"></td>
					<th>Period</th>
					<td><input type="text" name="fm_dt" dataformat="ymd" style="width:75px;text-align:center;ime-mode:disabled;" class="input1" value="" maxlength="8" size="10" id="fm_dt" />~&nbsp;<!-- 
					 --><input type="text" name="to_dt" dataformat="ymd" style="width:75px;text-align:center;" class="input1" value="" maxlength="8" size="10" id="to_dt" /><!-- 
					 --><button type="button" id="btn_period" name="btn_period" class="calendar ir"></button></td>
					<th>Port</th>
					<td><input type="text" name="vps_port_cd" style="width:70px;text-align:center;ime-mode:disabled;"  dataformat="engup" class="input" value="" maxlength="5" onfocus="this.select();" id="vps_port_cd" /><!-- 
					 --><button type="button" id="btn_port" name="btn_port" class="input_seach_btn"></button></td>
					<th>Vessel</th>
					<td><input type="text" name="vsl_cd" style="width:70px;text-align:center;ime-mode:disabled;" dataformat="engup" class="input" value="" maxlength="4" onfocus="this.select();" id="vsl_cd" /><!-- 
					 --><button type="button" id="btn_vsl_cd" name="btn_vsl_cd" class="input_seach_btn"></button></td>
					<th>Lane</th>
					<td><input type="text" name="vsl_slan_cd" style="width:70px;text-align:center;ime-mode:disabled;" dataformat="engup" value="" maxlength="3" onfocus="this.select();" id="vsl_slan_cd" /><!-- 
					 --><button type="button" id="btn_lane_cd" name="btn_lane_cd" class="input_seach_btn"></button></td>
					<th>Carrier</th>
					<td><input type="text" name="carrier_cd"  style="width:70px;ime-mode:disabled;text-align:center" class="input" maxlength="3" dataformat="engup" value="" onfocus="this.select();" id="carrier_cd" /><!-- 
					 --><button type="button" id="btn_carrier_cd" name="btn_carrier_cd" class="input_seach_btn"></button></td>
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
	<div class="opus_design_grid" id="div_grid1" style="display: ">
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btng_rowadd" id="btng_rowadd">Row Add</button>
			<button type="button" class="btn_normal" name="btng_rowcopy" 	id="btng_rowcopy">Row Copy</button>
		</div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<div class="opus_design_grid" id="div_grid2" style="display:">
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
	
</div>
<!-- opus_design_grid(E) -->	
</form>
