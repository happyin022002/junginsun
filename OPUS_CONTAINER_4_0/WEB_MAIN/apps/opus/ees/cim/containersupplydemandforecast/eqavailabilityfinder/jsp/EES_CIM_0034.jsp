<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CIM_0034.jsp
*@FileTitle  : EQ Availability
*@author     : CLT
*@version    : 1.0
*@since      : 2014/
=========================================================
*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.cim.containersupplydemandforecast.eqavailabilityfinder.event.EesCim0034Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesCim0034Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.EqavailAbilityFinder.EqavailAbilityFinder");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesCim0034Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
	strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

	}catch(Exception e) {
		out.println(e.toString());
	}
	
	// change to table name
	String ruLableTp   = JSPUtil.getCodeCombo("ru_lable_type", "01", "style='width:120'", "CD20097", 0, "000020:ALL:ALL");

%>


<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<form name="form"> 
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />

<input type="hidden" name="inquiryLevel" value="" id="inquiryLevel" />
<input type="hidden" name="location" value="" id="location" />

<input type="hidden" name="param_loc_type_code" value="" id="param_loc_type_code" />
<input type="hidden" name="param_loc_cd" value="" id="param_loc_cd" />
<input type="hidden" name="param_cntr_tpsz_cd_val1" value="" id="param_cntr_tpsz_cd_val1" />
<input type="hidden" name="param_cntr_tpsz_cd_val2" value="" id="param_cntr_tpsz_cd_val2" />
<input type="hidden" name="param_cntr_tpsz_cd_val3" value="" id="param_cntr_tpsz_cd_val3" />
<input type="hidden" name="param_cntr_tpsz_cd_val4" value="" id="param_cntr_tpsz_cd_val4" />
<input type="hidden" name="hid_rulabel_type" id="hid_rulabel_type" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" 		id="btn_Retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_new" 			id="btn_new">New</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_downexcel" 			id="btn_downexcel">Down Excel</button>			
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
	
</div>
<!-- page_title_area(E) -->
<!-- wrap_search(S) -->
<div class="wrap_search">
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry wFit" id="showMin" style="display:inline">
	<table style="margin-bottom:8px !important;">
		<tbody>
			<colgroup>
				<col width="100" />
				<col width="80" />
				<col width="100" />
				<col width="80" />
				<col width="100" />
				<col width="10" />
				<col width="70" />
				<col width="10" />
				<col width="10" />
				<col width="*" />
			</colgroup>
			<tr class="h23">
				<th>Location Level</th>
				<td><select style="width:80px;" name="loc_type_code" class="input" >
						<option value="R">RCC</option>
						<option value="L">LCC</option>
						<option value="E">ECC</option>
						<option value="S" selected>SCC</option>
						<option value="Y">Yard</option>
						</select><input type="text" class="input1" name="loc_cd" style="ime-mode:inactive" id="loc_cd" maxlength="7" dataformat="engup" size="7" value="" id="loc_cd" /><button type="button" id="btn_loc_cd" name="btn_loc_cd" class="input_seach_btn"></button></td>
				<th>RU Label</th>
				<!-- <td><input type="text"  name="rstr_usg_lbl" id="rstr_usg_lbl"  readonly="true" style="ime-mode:inactive;background-color:#ffffff"  style="width:150px;" class="input" value=""> <button type="button" id="btn_rulabel_cd" name="btn_rulabel_cd" class="input_seach_btn"></button></td> -->
				<td>&nbsp;<%=ruLableTp %>
				<script language="javascript" >ComComboObject('rstr_usg_lbl', 1, 140, 1 );</script></td>
				<th>TP/SZ</th>
				<td><script type="text/javascript">ComComboObject('cntr_tpsz_cd', 1, 100, 1);</script><input type="text" name="cntr_tpsz_cd_val1" id="cntr_tpsz_cd_val1" dataformat="engup" size="2" maxlength="2" fulfill style="width: 30px;" class="input1" value="D2"><input type="text" name="cntr_tpsz_cd_val2" id="cntr_tpsz_cd_val2" dataformat="engup" size="2" maxlength="2" fulfill style="width:30px;" class="input" value="D4"><input type="text" name="cntr_tpsz_cd_val3" id="cntr_tpsz_cd_val3" dataformat="engup" size="2" maxlength="2" fulfill style="width:30px;" class="input" value="D5"><input type="text" name="cntr_tpsz_cd_val4" id="cntr_tpsz_cd_val4" dataformat="engup" size="2" maxlength="2" fulfill style="width:30px;" class="input" value="D7"></td>
				<th>Period</th>
				<td class="sm"><input type="text" name="fm_fcast_dt" style="width:80px;" readonly="" class="input2" value="" id="fm_fcast_dt" />~&nbsp;<input type="text" name="to_fcast_dt" style="width:80px;" readonly="" class="input2" value="" id="to_fcast_dt" /></td>
				<td></td>
				<td style="text-align: right;"><button type="button" class="btn_etc" id="past_Br" name="past_Br">Past BR</button></td>
			</tr>
		</tbody>
	</table>
</div>
<!-- opus_design_inquiry(E) -->
</div>
<!-- wrap_search(E) -->

<!-- wrap_result(S) -->
<div class="wrap_result">
	<div id="showsheet1" style="display:block">
		<div class="opus_design_inquiry wFit">
		<table>
			<tr><td><button type="button" class="btn_up" name="btn_minimize1" id="btn_minimize1"></button></td></tr>
		</table>	
		</div>
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<!-- opus_design_grid(E) -->
	</div>
	
	<div id="showsheet2" style="display:block">
		<div class="opus_design_inquiry wFit">
			<table>
				<tr><td><button type="button" class="btn_up" name="btn_minimize2" id="btn_minimize2"></button></td></tr>
			</table>	
		</div>
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet2');</script>
		</div>
		<!-- opus_design_grid(E) -->
	</div>
	
	 <div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet3');</script>
		</div> 
</div>
<!-- wrap_result(E) -->

</form>

