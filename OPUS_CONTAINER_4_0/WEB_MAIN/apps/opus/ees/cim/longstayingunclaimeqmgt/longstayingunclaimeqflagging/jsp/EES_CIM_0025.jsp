<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CIM_0025.js
*@FileTitle  : Land Inventory With CNTR List
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/23 
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.event.EesCim0025Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<% 
	EesCim0025Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	
    String cnmv_sts_cd = "";
    String cnmv_sts_nm = "";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EesCim0025Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		//MVMT Status multi combo
	    String temp_cnmv_sts_cd = JSPUtil.getIBCodeCombo("", "", "CD02086", 0, "");
	    if(temp_cnmv_sts_cd != null && temp_cnmv_sts_cd.length() > 8) {
	    	cnmv_sts_cd = temp_cnmv_sts_cd.substring(temp_cnmv_sts_cd.indexOf("Code = \"")+8, temp_cnmv_sts_cd.lastIndexOf("\""));
	    	cnmv_sts_nm = temp_cnmv_sts_cd.substring(temp_cnmv_sts_cd.indexOf("Text = \"")+8, temp_cnmv_sts_cd.indexOf("\";")); 
	    }						
	    
		
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">

    function setupPage(){  

	    loadPage("<%=cnmv_sts_cd%>", "<%=cnmv_sts_nm%>");
    }

</script>

<form name="form"> 
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="head_cntr_tpsz_cd" value="" id="head_cntr_tpsz_cd" />
<input type="hidden" name="cnt_cd" value="" id="cnt_cd" />
<input type="hidden" name="inquiryLevel" value="" id="inquiryLevel" />
<input type="hidden" name="location" value="" id="location" />

<!-- page_title_area(S) -->
<div class="page_title_area clear ">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button><!--
			--><button class="btn_normal" name="btn_new" id="btn_new" type="button">New</button><!--
			--><button class="btn_normal" name="btn_downexcel" id="btn_downexcel" type="button">Down&nbsp;Excel</button><!--
			--></div>
		<!-- opus_design_btn (E) -->
	    <!-- page_location(S) -->
	<div class="location">
    <!-- location 내용 동적생성 (별도 코딩 불필요) -->
    <span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->
<!-- wrap_area(S) -->
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="100px" />
				<col width="200" />
				<col width="100" />
				<col width="50px" />
				<col width="73px" />
				<col width="50px" />
				<col width="50px" />
				<col width="50px" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<th>Location</th>
					<td><select style="width:60px;" name="loc_type_code" id="loc_type_code" class="input" ><!-- LOC_TYPE_CODE --><option value="1"> RCC</option><option value="2"> LCC</option><option value="3" selected> ECC</option><option value="4"> SCC</option><option value="5"> Yard</option></select><input type="text" class="input1" name="loc_cd" id="loc_cd" style="ime-mode:inactive" dataformat="engup" size="7" maxlength="7" fulfill  style="width:65px;" class="input" value=""><button type="button" id="btn_loc_cd" name="btn_loc_cd" class="input_seach_btn"></button></td>
					<th>Cargo type</th>
					<td><select name="full_flg" style="width:80px;" class="input"><option value="" selected></option><option value="Y">Full</option><option value="N">MTY</option></select></td>
					<th>DMG</th>
					<td><select name="dmg_flg" style="width:75px;" class="input"><option value="" selected>Include</option><option value="N">Exclude</option><option value="Y">Only</option></select></td>
					<th>Speed</th>
					<td><input type="checkbox" name="speed" checked value="Y" id="speed" /> </td>
					<td></td>
				</tr> 
			</tbody>
		</table>
		<table>
			<colgroup>
				<col width="100px" />
				<col width="200" />
				<col width="100" />
				<col width="50px" />
				<col width="78px" />
				<col width="50px" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<th>TP/SZ</th>
					<td><script type="text/javascript">ComComboObject('cntr_tpsz_cd', 1, 147, 1);</script></td>
					<th>S.O.C</th>
					<td><select name="soc_cd" style="width:75px;" class="input"><option value="1">Exclude</option><option value=""selected>Include</option><option value="2">Only</option></select></td>
					<th>Unclaim</th>
					<td><select name="uclm_ls_div_cd" style="width:70px;" class="input"><option value="E">Exclude</option><option value="I" selected>Include</option><option value="O">Only</option></select></td>
					<td></td>
				</tr> 
			</tbody>
		</table>
		<table>
			<colgroup>
				<col width="100px" />
				<col width="200" />
				<col width="100" />
				<col width="50px" />
				<col width="50px" />
				<col width="50px" />
				<col width="50px" />
				<col width="50px" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<th>MVMT Status</th>
					<td><script type="text/javascript">ComComboObject('cnmv_sts_cd', 1, 147, 1);</script></td>
					<th>Staying Day</th>
					<td><input type="text" name="over_stay_days" style="width:40px; text-align:right;" dataformat="num" class="input" value="" id="over_stay_days" />or over</td>
					<th>&nbsp;&nbsp;&nbsp;Free-Days</th>
					<td><input type="text" name="over_free_days" style="width:40px; text-align:right;" dataformat="num" class="input" value="" id="over_free_days" />or over</td>
					<th>Prefix</th>
					<td><input type="text" name="cntr_no" style="width:40px;" dataformat="engup" size="4" maxlength="4" fulfill="" class="input" value="" id="cntr_no" /> </td>
					<td></td>
				</tr> 
			</tbody>
		</table>
		<table>
			<colgroup>
				<col width="100px" />
				<col width="273" />
				<col width="1" />
				<col width="65" />
				<col width="50px" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<th>Lease Term</th>
					<td><script type="text/javascript">ComComboObject('lstm_cd', 1, 147, 1);</script></td>
					<th><input type="checkbox" name="ts_cntr_behind" class="trans" value="Y" id="ts_cntr_behind" /> T/S Behind ATD of Load VVD <input type="text" name="next_vvd" dataformat="engup" size="9" maxlength="9" fulfill style="width:80px;" class="input2" value="" id="next_vvd" /> </th>
					<th>Add Info</th>
					<td><input type="checkbox" name="view_vvd" value="Y" class="trans" id="view_vvd" /><label>VVD</label><input type="checkbox" name="view_customer" value="Y" class="trans" id="view_customer" /><label>CUST</label><input type="checkbox" name="view_commodity" value="Y" class="trans" id="view_commodity" /><label>CMDT</label><input type="checkbox" name="view_salesrep" value="Y" class="trans" id="view_salesrep" /><label>S.REP</label></td>
					<td></td>
				</tr> 
			</tbody>
		</table>
	<!-- opus_design_inquiry(E) -->
	</div>
</div>
<!-- wrap_area(E) -->
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<!-- opus_design_btn (S) -->
			<div class="opus_design_btn">
				<button class="btn_accent" name="btn_bkginq" id="btn_bkginq" type="button">BKG Inquiry</button><!--
				--><button class="btn_normal" name="btn_movement" id="btn_movement" type="button">Movement</button><!--
				--><button class="btn_normal" name="btn_master" id="btn_master" type="button">&nbsp;&nbsp;&nbsp;Master&nbsp;&nbsp;&nbsp;</button><!--
				--></div>
			<!-- opus_design_btn (E) -->
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	<!-- opus_design_grid(E) -->
</div>
<!-- result_area(E) -->
</form>
