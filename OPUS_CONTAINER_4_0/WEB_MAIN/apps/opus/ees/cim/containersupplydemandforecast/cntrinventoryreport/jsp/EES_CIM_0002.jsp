<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CIM_0002.js
*@FileTitle  : Total Inventory
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/16
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.event.EesCim0002Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesCim0002Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//list count of DB ResultSet 
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

    String cnmv_sts_cd = "";
    String cnmv_sts_nm = "";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strCnt_cd		= "";
	Logger log = Logger.getLogger("com.clt.apps.ContainerSupplyDemandForecast.CNTRInventoryReport");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strCnt_cd = account.getCnt_cd();
	   
		event = (EesCim0002Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		//multi commo for MVMT Status 
	    String temp_cnmv_sts_cd = JSPUtil.getIBCodeCombo("", "", "CD02086", 0, "");
	    if(temp_cnmv_sts_cd != null && temp_cnmv_sts_cd.length() > 8) {
	    	cnmv_sts_cd = temp_cnmv_sts_cd.substring(temp_cnmv_sts_cd.indexOf("Code = \"")+8, temp_cnmv_sts_cd.lastIndexOf("\""));
	    	cnmv_sts_nm = temp_cnmv_sts_cd.substring(temp_cnmv_sts_cd.indexOf("Text = \"")+8, temp_cnmv_sts_cd.indexOf("\";")); 
	    }						
	    
		
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript" src="/opuscntr/rpt/script/common_rd.js"></script>

<script type="text/javascript">

    function setupPage(){
	    loadPage("<%=cnmv_sts_cd%>", "<%=cnmv_sts_nm%>");
    }

</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="head_cntr_tpsz_cd" value="" id="head_cntr_tpsz_cd" />

<!-- print parameters for retrieving -->
<input type="hidden" name="prt_cntr_tpsz_cd" id="prt_cntr_tpsz_cd" />
<input type="hidden" name="cntr_tpsz_cd" id="cntr_tpsz_cd" />
<input type="hidden" name="prt_full_flg" id="prt_full_flg" />
<input type="hidden" name="prt_cntr_hngr_rck_cd" id="prt_cntr_hngr_rck_cd" />
<input type="hidden" name="prt_cntr_hngr_rck_cd_o" id="prt_cntr_hngr_rck_cd_o" />
<input type="hidden" name="prt_cntr_hngr_rck_cd_r" id="prt_cntr_hngr_rck_cd_r" />
<input type="hidden" name="prt_cntr_hngr_bar_atch_knt" id="prt_cntr_hngr_bar_atch_knt" />
<input type="hidden" name="prt_disp_flg" id="prt_disp_flg" />
<input type="hidden" name="prt_d2_payld_flg" id="prt_d2_payld_flg" />
<input type="hidden" name="prt_cnmv_sts_cd" id="prt_cnmv_sts_cd" />
<input type="hidden" name="cnmv_sts_cd" id="cnmv_sts_cd" />
<input type="hidden" name="prt_dmg_flg" id="prt_dmg_flg" />
<input type="hidden" name="prt_cntr_no" id="prt_cntr_no" />
<input type="hidden" name="prt_cntr_use_co_cd" id="prt_cntr_use_co_cd" />
<input type="hidden" name="prt_lstm_cd " id="prt_lstm_cd" />
<input type="hidden" name="lstm_cd" id="lstm_cd" />
<input type="hidden" name="prt_soc_cd" id="prt_soc_cd" />
<input type="hidden" name="prt_chk_cntr_tpsz_cd" id="prt_chk_cntr_tpsz_cd" />
<input type="hidden" name="prt_cnt_cd" value="<%=strCnt_cd%>" id="prt_cnt_cd" />

<!-- page_title_area(S) -->
<div class="page_title_area clear ">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button><!--
			--><button class="btn_normal" name="btn_New" id="btn_New" type="button">New</button><!--
			--><button class="btn_normal" name="btn_DownExcel" id="btn_DownExcel" type="button">Down&nbsp;Excel</button><!--
			--><button class="btn_normal" name="btn_Print" id="btn_Print" type="button">Print</button><!--
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
				<col width="50px" />
				<col width="200px" />
				<col width="50px" />
				<col width="200px" />
				<col width="70px" />
				<col width="50px" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<th>TP/SZ</th>
					<td><script type="text/javascript">ComComboObject('combo_cntr_tpsz_cd', 1, 115, 1);</script></td>
					<th>F/M</th>
					<td><select name="full_flg" style="width:100px;" class="input"><option value="" selected></option><option value="Y">Full</option><option value="N">MTY</option></select></td>
					<th class="sm">EQ MGMT</th>
					<td class="sm">
						<input type="checkbox" name="cntr_hngr_rck_cd" value="Y" class="trans" id="cntr_hngr_rck_cd" /><label for="cntr_hngr_rck_cd">Hanger Rack/Bar</label><!--  
						--><input type="checkbox" name="disp_flg" value="Y" class="trans" id="disp_flg" /><label for="disp_flg">DPSL</label><!-- 
						--><input type="checkbox" name="d2_payld_flg" value="Y" class="trans" id="d2_payld_flg" style="display:none;" /><label for="d2_payld_flg" style="display:none;">D2-HP</label>
					</td>
					<td></td>
				</tr> 
				<tr>
					<th>MVMT Status</th>
					<td><script type="text/javascript">ComComboObject('combo_cnmv_sts_cd', 1, 115, 1);</script></td> 
					<th>DMG </th>
					<td><select name="dmg_flg" style="width:100px;" class="input"><option value="" selected>Include</option><option value="N">Exclude</option><option value="Y">Only</option></select></td>
					<th>&nbsp;Prefix</th>
					<td><input type="text" name="cntr_no" style="width:40px;" dataformat="engup" size="4" maxlength="4" fulfill="" class="input" value="" id="cntr_no"/> </td>
					<td></td>
				</tr> 
				<tr>
					<th>Lease Term</th>
					<td><script type="text/javascript">ComComboObject('combo_lstm_cd', 1, 115, 1);</script></td>
					<th>S.O.C </th>
					<td><select name="soc_cd" style="width:100px;" class="input"><option value="1"selected>Exclude</option><option value="">Include</option><option value="2">Only</option></select></td>
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
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	<!-- opus_design_grid(E) -->
</div>
<!-- result_area(E) -->
</form>
