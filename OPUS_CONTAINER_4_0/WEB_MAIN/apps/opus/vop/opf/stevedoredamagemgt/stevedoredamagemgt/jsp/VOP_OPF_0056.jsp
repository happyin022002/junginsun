<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : vop_opf_0056.jsp
*@FileTitle  : SDMS Report
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/02 
=========================================================
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.event.VopOpf0056Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.Date"%>

<%
	VopOpf0056Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.StevedoreDamageMgt.StevedoreDamageMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopOpf0056Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// adding logic to get data from server when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<!-- Developer Performance	-->
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
	</h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button>
	</div>
	<!-- opus_design_btn(E) -->
	
	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->
<div class= "wrap_search_tab">
<!-- opus_design_inquiry (S) -->
<div class= "opus_design_inquiry wFit">
	<table class="search_in">
		<tbody>
			<colgroup>
				<col width="100"/>
				<col width="340"/>
				<col width="105"/>
				<col width="210"/>
				<col width="60"/>
				<col width="*">
			</colgroup>
			<tr>
				<td style="text-align:left;"><strong>Period</strong><span style="padding-left:45px;">From</span></td>
				<td><input type="text" name="stv_dmg_evnt_dt_from" id="stv_dmg_evnt_dt_from" caption="Period From" style="width:80px;" class="input1" value="<%=DateTime.addDays(DateTime.getFormatDate(new Date(),"yyyyMMdd"),-30)%>" dataformat="ymd" maxlength="8" required onkeyup="obj_keyup()" onsubmit="ComKeyEnter()">&nbsp;&nbsp;~&nbsp;&nbsp;To&nbsp;<input type="text" name="stv_dmg_evnt_dt_to" id="stv_dmg_evnt_dt_to" caption="Period To" style="width:80px;" class="input1" value="<%=DateTime.getFormatDate(new Date(),"yyyyMMdd")%>" dataformat="ymd" maxlength="8" required onsubmit="ComKeyEnter()"><!--  
					--><button type="button" class="calendar ir" name="cal_stv_dmg_evnt_dt_to" id="cal_stv_dmg_evnt_dt_to"></button>
				</td>
				<th style="text-align:left;">Vessel Category</th>
				<td><script type="text/javascript">ComComboObject('vsl_oshp_cntr_blk_tp_cd',1,160,1,0,0);</script></td>
				<th style="text-align:left;">Group By</th>
				<td align="right"><script type="text/javascript">ComComboObject('group_by',1,165,1,0,0);</script></td>
			</tr> 
			<tr>
				<th style="text-align:left;">Country</th>
				<td><input type="text" name="loc_cd" id="loc_cd" caption="Country Code" style="width:96px;ime-mode:disabled;" class="input" maxlength="2" onblur="blur_event()" onkeypress="eng_keypress()" onfocus="focus_event()" onsubmit="ComKeyEnter()"/><!--  
					--><button type="button" name="loc_cd_pop" id="loc_cd_pop" class="input_seach_btn" onClick="openPopup('cust_cd')"></button>
				</td>
				<th style="text-align:left;">Port</th>
				<td><input type="text" name="vps_port_cd" id="vps_port_cd" caption="Port Code" style="width:96px;ime-mode:disabled;" class="input" maxlength="5" onblur="blur_event()" onkeypress="eng_keypress()" onfocus="focus_event()" onsubmit="ComKeyEnter()"/><!--  
					--><button type="button" name="vps_port_cd_pop" id="vps_port_cd_pop" class="input_seach_btn" onClick="openPopup('cust_cd')"></button></td>
				<th style="text-align:left;">Lane</th>
				<td><input type="text" name="slan_cd" id="slan_cd" caption="Lane Code" style="width:96px;ime-mode:disabled;" class="input" maxlength="3" onblur="blur_event()" onkeypress="eng_keypress()" onfocus="focus_event()" onsubmit="ComKeyEnter()"/><!--  
					--><button type="button" name="slan_cd_pop" id="slan_cd_pop" class="input_seach_btn" onClick="openPopup('cust_cd')"></button></td>
				<th style="text-align:left;">Vessel</th>
				<td><input type="text" name="vsl_cd" id="vsl_cd" caption="Vessel Code" style="width:96px;ime-mode:disabled;" class="input" maxlength="4" onblur="blur_event()" onkeypress="eng_keypress()" onfocus="focus_event()"/><!--  
					--><button type="button" name="vsl_cd_pop" id="vsl_cd_pop" class="input_seach_btn" onClick="openPopup('cust_cd')"></button></td>
			</tr> 
			<tr>
				<th style="text-align:left;">Damage Category</th>
				<td><script type="text/javascript">ComComboObject('stv_dmg_prt_cate_cd',1,120,0,0,0);</script></td>
				<th style="text-align:left;">Damage Part</th>
				<td><script type="text/javascript">ComComboObject('stv_dmg_prt_cd',2,296,0,0,0);</script></td>
				<th style="text-align:left;">Damage Type</th>
				<td><script type="text/javascript">ComComboObject('stv_dmg_tp_cd',2,142,0,0,0);</script></td>
			</tr> 
			<!-- <tr class="h23">
				<th style="text-align:left;">Responsible Party</th>
				<td><script type="text/javascript">ComComboObject('stv_dmg_respb_pty_kwn_flg',1,120,0,0,0);</script></td>
				<th style="text-align:left;">Damage</th>
				<td><script type="text/javascript">ComComboObject('stv_dmg_step_cd',1,96,0,0,0);</script></td>
				<th style="text-align:left;">Repair</th>
				<td><script type="text/javascript">ComComboObject('stv_dmg_rpr_proc_sts_cd',1,96,0,0,0);</script></td>
				<th style="text-align:left;">Compensation</th>
				<td><script type="text/javascript">ComComboObject('stv_dmg_cmpn_proc_sts_cd',1,96,0,0,0);</script></td>
				<th style="text-align:left;">Settlement	</th>
				<td><script type="text/javascript">ComComboObject('stv_dmg_stl_proc_sts_cd',1,96,0,0,0);</script></td>
			</tr> -->
		</tbody> 
	</table>
	<table class="search_in">
		<tbody>
			<colgroup>
				<col width="114"/>
				<col width="190"/>
				<col width="60"/>
				<col width="150"/>
				<col width="60"/>
				<col width="150"/>
				<col width="110"/>
				<col width="150"/>
				<col width="80"/>
				<col width="*">
			</colgroup>			 
			<tr class="h23">
				<th style="text-align:left;">Responsible Party</th>
				<td><script type="text/javascript">ComComboObject('stv_dmg_respb_pty_kwn_flg',1,120,0,0,0);</script></td>
				<th style="text-align:left;">Damage</th>
				<td><script type="text/javascript">ComComboObject('stv_dmg_step_cd',1,96,0,0,0);</script></td>
				<th style="text-align:left;">Repair</th>
				<td><script type="text/javascript">ComComboObject('stv_dmg_rpr_proc_sts_cd',1,96,0,0,0);</script></td>
				<th style="text-align:left;">Compensation</th>
				<td><script type="text/javascript">ComComboObject('stv_dmg_cmpn_proc_sts_cd',1,96,0,0,0);</script></td>
				<th style="text-align:left;">Settlement	</th>
				<td><script type="text/javascript">ComComboObject('stv_dmg_stl_proc_sts_cd',1,96,0,0,0);</script></td>
			</tr>
		</tbody> 
	</table>
</div>
</div>
<!-- wrap_result(S) -->
<div class="wrap_result">
    <div class="opus_design_tab sm" >
		<script type="text/javascript">ComTabObject("tab1")</script>
	</div>
	<div class="opus_design_grid"  id="tabLayer" style="display:inline">
		<div class="opus_design_btn" id="excelDiv" style="display:none">
		<button type="button" class="btn_normal" name="btn_t1DownExcel" id="btn_t1DownExcel">Down Excel</button>
		</div>
    	<script type="text/javascript">ComSheetObject('sheet1');</script>
    </div>
    
    <div class="opus_design_grid"  id="tabLayer" style="display:inline">
		<div class="opus_design_btn" id="excelDiv" style="display:none">
		<button type="button" class="btn_normal" name="btn_t2DownExcel" id="btn_t2DownExcel">Down Excel</button>
		</div>
    	<script type="text/javascript">ComSheetObject('sheet2');</script>
    </div>
    
    <div class="opus_design_grid"  id="tabLayer" style="display:inline">
		<div class="opus_design_btn" id="excelDiv" style="display:none">
		<button type="button" class="btn_normal" name="btn_t3DownExcel" id="btn_t3DownExcel">Down Excel</button>
		</div>
    	<script type="text/javascript">ComSheetObject('sheet3');</script>
    </div>
    
    <div class="opus_design_grid"  id="tabLayer" style="display:inline">
		<div class="opus_design_btn" id="excelDiv" style="display:none">
		<button type="button" class="btn_normal" name="btn_t4DownExcel" id="btn_t4DownExcel">Down Excel</button>
		</div>
    	<script type="text/javascript">ComSheetObject('sheet4');</script>
    </div>
    
    <div class="opus_design_grid"  id="tabLayer" style="display:inline">
		<div class="opus_design_btn" id="excelDiv" style="display:none">
		<button type="button" class="btn_normal" name="btn_t5DownExcel" id="btn_t5DownExcel">Down Excel</button>
		</div>
    	<script type="text/javascript">ComSheetObject('sheet5');</script>
    </div>
</div>
</form>