<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : EES_CIM_0021.jsp
*@FileTitle  : Container Staying Days (Summary)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/18
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.event.EesCim0021Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesCim0021Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

    String cnmv_sts_cd = "";
    String cnmv_sts_nm = "";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.LongstayingUnclaimEQMgt.LongstayingUnclaimEQFlagging");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesCim0021Event)request.getAttribute("Event");
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
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="cnmv_sts_cd1" id="cnmv_sts_cd1" value="IC">
<input type="hidden" name="cnmv_sts_cd2" id="cnmv_sts_cd2" value="ID">
<input type="hidden" name="cnmv_sts_cd3" id="cnmv_sts_cd3" value="MT">
<input type="hidden" name="cnmv_sts_cd4" id="cnmv_sts_cd4" value="OP">
<input type="hidden" name="cnmv_sts_cd5" id="cnmv_sts_cd5" value="OC">
<input type="hidden" name="cnmv_sts_cd6" id="cnmv_sts_cd6" value="TN">
<input type="hidden" name="cnmv_sts_cd7" id="cnmv_sts_cd7" value="EN">
<input type="hidden" name="cnmv_sts_cd8" id="cnmv_sts_cd8" value="TS">
<input type="hidden" name="param_loc_type_code" id="param_loc_type_code" value="">
<input type="hidden" name="param_loc_cd" id="param_loc_cd" value="">
<input type="hidden" name="param_cntr_tpsz_cd" id="param_cntr_tpsz_cd" value="">
<input type="hidden" name="param_dmg_flg" id="param_dmg_flg" value="">
<input type="hidden" name="param_cntr_use_co_cd" id="param_cntr_use_co_cd" value="">
<input type="hidden" name="param_over_stay_days" id="param_over_stay_days" value="">
<input type="hidden" name="param_cnmv_sts_cd" id="param_cnmv_sts_cd" value="">
<input type="hidden" name="param_uclm_ls_div_cd" id="param_uclm_ls_div_cd" value="">
<input type="hidden" name="param_full_flg" id="param_full_flg" value="">
<input type="hidden" name="param_lstm_cd" id="param_lstm_cd" value="">
<input type="hidden" name="param_soc_cd" id="param_soc_cd" value="">
<input type="hidden" name="inquiryLevel" id="inquiryLevel" value=""> 
<input type="hidden" name="location" id="location" value=""> 
<input type="hidden" name="cntr_tpsz_cd" id="cntr_tpsz_cd" />
<input type="hidden" name="cnmv_sts_cd" id="cnmv_sts_cd" />
<input type="hidden" name="lstm_cd" id="lstm_cd" />


<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" 	id="btn_Retrieve">Retrieve</button><!--		
		--><button type="button" class="btn_normal" name="btn_new"  		id="btn_new">New</button><!--
		--><button type="button" class="btn_normal" name="btn_downexcel" 		id="btn_downexcel">Down Excel</button>
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->
<!-- opus_design_inquiry(S) -->
<div class= "wrap_search_tab">
	<div class= "opus_design_inquiry">
		<table>
			<tbody>
				<colgroup>
					<col width="80px"/>
					<col width="102px"/>
					<col width="160px"/>
					<col width="80px"/>
					<col width="200px"/>
					<col width="80px"/>
					<col width="*"/>	
			    </colgroup>
				<tr>
					<th>Location by</th>
					<td>
						<select style="width:110px;" name="loc_type_code" id="loc_type_code" class="input" ><!-- LOC_TYPE_CODE -->
							<option value="" selected>All (by RCC)</option>
							<option value="1">RCC (by LCC)</option>
							<option value="2">LCC (by ECC)</option>
							<option value="3">LCC (by SCC)</option>
							<option value="4">ECC (by SCC)</option>
							<option value="5">SCC (by Yard)</option>
							<option value="6">Yard</option>
							<!-- loc_cd --> 
						</select>
					</td>
					<td><input type="text" class="input2" name="loc_cd" id="loc_cd" style="ime-mode:inactive" readonly dataformat="engup" size="7" maxlength="7" fulfill  style="width:70;" class="input" value=""><button type="button" name="btn_loc_cd" id="btn_loc_cd" class="input_seach_btn"></button></td>					
					<th>TP/SZ</th>
					<td>
						<script type="text/javascript">ComComboObject('combo_cntr_tpsz_cd', 1, 115, 1);</script>					
					</td>
					<th>DMG</th> 
					<td>
						<select name="dmg_flg" id="dmg_flg" style="width:100px;" class="input">
							<option value="" selected>Include</option>
							<option value="N">Exclude</option>
							<option value="Y">Only</option>
						</select>
					</td>
				</tr>	
				<tr>
					<th>Staying Day</th>
					<td colspan="2">
						<input type="text" name="over_stay_days" id="over_stay_days" style="width:40px; text-align:right;" dataformat="num" class="input" value="31">&nbsp;&nbsp;or over
					</td>
					<th>MVMT Status</th>
					<td>
						<script type="text/javascript">ComComboObject('combo_cnmv_sts_cd', 1, 115, 1);</script>
					</td>
					<th>Unclaim</th> 
					<td><select name="uclm_ls_div_cd" id="uclm_ls_div_cd" style="width:100px;" class="input">
						<option value="E" selected>Exclude</option>	
						<option value="I">Include</option> 
						<option value="O">Only</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>F/M</th>
					<td colspan="2">
						<select name="full_flg" id="full_flg" style="width:80px;" class="input">
							<option value="" selected></option>
							<option value="Y">Full</option>
							<option value="N">MTY</option>
						</select>
					</td>
					<th>Lease Term</th>
					<td>
						<script type="text/javascript">ComComboObject('combo_lstm_cd', 1, 115, 1);</script>
					</td>
					<th>S.O.C</th> 
					<td>
						<select name="soc_cd" id="soc_cd" style="width:100px;" class="input">
							<option value="1"selected>Exclude</option>
							<option value="">Include</option>
							<option value="2">Only</option>
						</select>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->


<div class="wrap_result">
	<!-- opus_tab_btn(S) -->
		<div class="opus_design_tab sm">
			<script type="text/javascript">ComTabObject('tab1')</script>
		</div>
	<!-- opus_tab_btn(E) -->
	<div id="tabLayer" style="display:inline">	
		<!-- opus_design_grid(S) -->
			<div class="opus_design_grid clear" >
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_t1detail1" id="btn_t1detail1">Detail</button>
				<button type="button" class="btn_normal" name="btn_t1detail2" 	id="btn_t1detail2">L/S & U/C Creation</button>
			</div>
				<script type="text/javascript">ComSheetObject('sheet1');</script>
			</div>		
		<!-- opus_design_grid(E) -->
	</div>
	<div id="tabLayer" style="display:none">
		<!-- opus_design_grid(S) -->
			<div class="opus_design_grid clear" >
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_t1detail3" id="btn_t1detail3">Detail</button>
				<button type="button" class="btn_normal" name="btn_t1detail2" 	id="btn_t1detail2">L/S & U/C Creation</button>
			</div>
				<script type="text/javascript">ComSheetObject('sheet2');</script>
			</div>
		<!-- opus_design_grid(E) -->
	</div>
	<div id="tabLayer" style="display:none">
		<!-- opus_design_grid(S) -->
			<div class="opus_design_grid clear" >
			
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_t3ByMVMTStatus" id="btn_t3ByMVMTStatus">By MVMT Status</button>
				<button type="button" class="btn_normal" name="btn_t3detail" 	id="btn_t3detail">Detail</button>
			</div>
				<script type="text/javascript">ComSheetObject('sheet3');</script>
			</div>
		<!-- opus_design_grid(E) -->
	</div>
	
</div>
</form>

