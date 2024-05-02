<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0174.jsp
*@FileTitle  : Booking Report
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/03
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
<%@ page import="com.clt.apps.opus.esm.bkg.bookingreport.performancereport.event.EsmBkg0174Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0174Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//occurring error in server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//list count of DB resultSet
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String bkgRptKndCd 		= "C";
	Logger log = Logger.getLogger("com.clt.apps.BookingReport.PerformanceReport");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EsmBkg0174Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	} catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if

		loadPage();
	}
</script>

<form name="form" id="form">
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="pagerows" name="pagerows" type="hidden" />
<input id="ca_reason" name="ca_reason" type="hidden" />
<input id="ca_reason_val" name="ca_reason_val" type="hidden" />
<input id="ca_class" name="ca_class" type="hidden" />
<input id="ca_class_val" name="ca_class_val" type="hidden" />
<input id="ca_kind" name="ca_kind" type="hidden" />
<input id="ca_kind_val" name="ca_kind_val" type="hidden" />
<input id="off_dis_op" name="off_dis_op" type="hidden" />
<input id="off_dis_op_val" name="off_dis_op_val" type="hidden" />
<input id="off_dis_op_sql" name="off_dis_op_sql" type="hidden" />
<input id="off_dis_op_cnt" name="off_dis_op_cnt" type="hidden" />
<input id="other_op" name="other_op" type="hidden" />
<input id="other_op_val" name="other_op_val" type="hidden" />
<input id="route" name="route" type="hidden" />
<input id="com_mrdTitle" name="com_mrdTitle" type="hidden" />
<input id="com_mrdBodyTitle" name="com_mrdBodyTitle" type="hidden" />
<input id="com_mrdPath" name="com_mrdPath" type="hidden" />
<input id="com_mrdArguments" name="com_mrdArguments" type="hidden" />
<input id="bkg_rpt_knd_cd" name="bkg_rpt_knd_cd" value="<%= bkgRptKndCd %>" type="hidden" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button type="button" id="btn_Retrieve" name="btn_Retrieve" class="btn_accent">Retrieve</button><!--
		--><button type="button" id="btn_new" name="btn_new" class="btn_normal">New</button><!--
		--><button type="button" id="btn_sum_excel" name="btn_sum_excel" class="btn_normal">Summary Down Excel</button><!--
		--><button type="button" id="btn_bl_excel" name="btn_bl_excel" class="btn_normal">B/L List Down Excel</button><!--
		--><button type="button" id="btn_rd" name="btn_rd" class="btn_normal">Cor/Inq List Print</button><!--
		--><button type="button" id="btn_Print" name="btn_Print" class="btn_normal">Print</button><!--
		--></div>
	<!-- opus_design_btn (E) -->
	<!-- page_location(S) -->
	<div class="location"><span id="navigation"></span></div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_search_tab">
</div>
<div class="wrap_result">
	<!-- OPUS_DESIGN_TAB (S) -->
	<div class="opus_design_tab">
		<script type="text/javascript">ComTabObject('tab1')</script>
	</div>
	<!-- OPUS_DESIGN_TAB (E) -->
	
	<!-- OPUS_DESIGN_TAB (CONDITION) (S) -->
	<div id="tabLayer" style="display:inline">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<tbody>
					<colgroup>
						<col width="10" />
						<col width="30" />
						<col width="300" />
						<col width="*" />
					</colgroup>
					<tr>
						<td></td>
						<th>Template Name</th>
						<td><select name="rpt_nm" id="rpt_nm" style="width: 200px;" class="input" onChange="javascript:changeNm()"></select><button type="button" class="btn_etc" id="btn_addTemp" name="btn_addTemp">Add Template</button></td>
						<td></td>
					</tr>
				</tbody>
			</table>
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			<h3 class="title_design">By Date & VVD</h3>
			<table>
			<tbody>
				<colgroup>
					<col width="10" />
					<col width="70" />
					<col width="250" />
					<col width="70" />
					<col width="250" />
					<col width="*" />
				</colgroup>
				<tr>
					<td></td>
					<th>Correction Date</th>
					<td><input id="corr_from_dt" name="corr_from_dt" id="corr_from_dt" style="width:75px;" value="" caption="Correction Date" dataformat="ymd" maxlength="10" size="10" type="text" /><!-- 
						 -->~ <input id="corr_to_dt" name="corr_to_dt" style="width:75px;" value="" caption="Correction Date" dataformat="ymd" maxlength="10" size="10"  type="text" /><!-- 
						 --><button type="button" class="calendar ir" name="btn_corr_calendar" id="btn_corr_calendar"></button></td>
					<th>Booking Date</th>
					<td><input id="cre_from_dt" name="cre_from_dt" id="cre_from_dt" style="width:75px;" value="" caption="Booking Date" dataformat="ymd" maxlength="10" size="10" onbeforedeactivate="ComAddSeparator(this)" onbeforeactivate="ComClearSeparator(this)" type="text" /><!-- 
						 -->~ <input id="cre_to_dt" name="cre_to_dt" style="width:75px;" value="" caption="Booking Date" dataformat="ymd" maxlength="10" size="10" onbeforedeactivate="ComAddSeparator(this)" onbeforeactivate="ComClearSeparator(this)" type="text" /><!-- 
						 --><button class="calendar ir" name="btn_cre_calendar" id="btn_cre_calendar" type="button"></button></td>
					<td></td>
					</tr>
				</tbody>
			</table>
			<table>
				<tbody>
					<colgroup>
						<col width="75" />
						<col width="30" />
						<col width="300" />
						<col width="*" />
					</colgroup>
					<tr>
						<td></td>
						<th title="Vessel Voyage Direction">VVD</th>
						<td><input id="vvd" name="vvd" style="width:80px;" value="" dataformat="engup" fulfill maxlength="9" type="text" /> </td>
						<td></td>
					</tr>
				</tbody>
			</table>
			<h3 class="title_design">Reason & Type</h3>
			<table class="grid2" style="width: 600px">
				<tbody>
				<colgroup>
					<col width="74" />
					<col width="500" />
				</colgroup>
				<tr>
					<th><strong>C/A Reason</strong></th>
					<td width="380" class="sm">
						<input id="ca_reason_m" name="ca_reason_m" value="M" class="trans" type="checkbox" /><label for="ca_reason_m">M</label><!-- 
						 --><input id="ca_reason_c" name="ca_reason_c" value="C" class="trans" type="checkbox" /><label for="ca_reason_c">C</label><!-- 
						 --><input id="ca_reason_g" name="ca_reason_g" value="G" class="trans" type="checkbox" /><label for="ca_reason_g">G</label><!-- 
						 --><input id="ca_reason_a" name="ca_reason_a" value="A" class="trans" type="checkbox" /><label for="ca_reason_a">A</label><!-- 
						 --><input id="ca_reason_o" name="ca_reason_o" value="O" class="trans" type="checkbox" /><label for="ca_reason_o">R</label>
					</td>
				</tr>
				<tr><th><strong>C/A Class</strong></th>
					<td class="sm">
						<input id="ca_class_1" name="ca_class_1" value="Y" class="trans" type="checkbox" /><label for="ca_class_1">Revenue</label><!-- 
						 --><input id="ca_class_2" name="ca_class_2" value="N" class="trans" type="checkbox" /><label for="ca_class_2">Non-Revenue</label><!--  
						 --><input id="ca_class_3" name="ca_class_3" value="Y" class="trans" type="checkbox" /><label for="ca_class_3">Expense</label>  
					</td>
				</tr>
				<tr>
					<td><button type="button" class=btn_etc id="btn_cakind" name="btn_cakind">C/A Kind</button></td>
					<td class="sm">
						<input id="ca_kind_a" name="ca_kind_a" value="Y" class="trans" type="checkbox" /><label for="ca_kind_a">A</label><!-- 
						 --><input id="ca_kind_b" name="ca_kind_b" value="Y" class="trans" type="checkbox" /><label for="ca_kind_b">B</label><!-- 
						 --><input id="ca_kind_c" name="ca_kind_c" value="Y" class="trans" type="checkbox" /><label for="ca_kind_c">C</label><!-- 
						 --><input id="ca_kind_d" name="ca_kind_d" value="Y" class="trans" type="checkbox" /><label for="ca_kind_d">D</label><!-- 
						 --><input id="ca_kind_e" name="ca_kind_e" value="Y" class="trans" type="checkbox" /><label for="ca_kind_e">E</label><!-- 
						 --><input id="ca_kind_f" name="ca_kind_f" value="Y" class="trans" type="checkbox" /><label for="ca_kind_f">F</label><!-- 
						 --><input id="ca_kind_g" name="ca_kind_g" value="Y" class="trans" type="checkbox" /><label for="ca_kind_g">G</label><!-- 
						 --><input id="ca_kind_h" name="ca_kind_h" value="Y" class="trans" type="checkbox" /><label for="ca_kind_h">H</label><!-- 
						 --><input id="ca_kind_i" name="ca_kind_i" value="Y" class="trans" type="checkbox" /><label for="ca_kind_i">I</label><!-- 
						 --><input id="ca_kind_j" name="ca_kind_j" value="Y" class="trans" type="checkbox" /><label for="ca_kind_j">J</label><!-- 
						 --><input id="ca_kind_k" name="ca_kind_k" value="Y" class="trans" type="checkbox" /><label for="ca_kind_k">K</label>
					</td>
				</tr>
				</tbody>
			</table>
			
			<h3 class="title_design">Office & Staff</h3>
			
			<table>
				<tbody>
					<colgroup>
						<col width="10" />
						<col width="70" />
						<col width="100" />
						<col width="70" />
						<col width="100" />
						<col width="70" />
						<col width="100" />
						<col width="70" />
						<col width="100" />
						<col width="*" />
					</colgroup>
					<tr>
						<td></td>
						<th>C/A Issue Office</th>
						<td><input id="ca_issue_off" name="ca_issue_off" style="width:60px;" class="input" value="" dataformat="enguponly" fulfill="" maxlength="6" type="text" /> </td>
						<th>BKG Office</th>
						<td><input id="bkg_off" name="bkg_off" style="width:60px;" class="input" value="" dataformat="enguponly" fulfill="" maxlength="6" type="text" /> </td>
						<th>DEL Office</th>
						<td><input id="del_off" name="del_off" style="width:60px;" class="input" value="" dataformat="enguponly" fulfill="" maxlength="6" type="text" /> </td>
						<th>GSO</th>
						<td><input id="gso_ofc_cd" name="gso_ofc_cd" style="width:60px;" class="input" value="" dataformat="enguponly" fulfill="" maxlength="6" type="text" /> </td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<th>Contract Office</th>
						<td><input id="contract_off" name="contract_off" style="width:60px;" class="input" value="" dataformat="enguponly" fulfill="" maxlength="6" type="text" /> </td>
						<th>DEL Cont</th>
						<td><script type="text/javascript">ComComboObject('dlv_ctnt_cd', 1, 80, '');</script></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
				</tbody>
			</table>
			
			<table>
				<tbody>
					<colgroup>
						<col width="16" />
						<col width="70" />
						<col width="300" />
						<col width="*" />
					</colgroup>
					<tr>
						<td></td>
						<th>C/A Issue Staff</th>
						<td><input id="ca_issue_staff" name="ca_issue_staff" style="width:255px;" class="input" value="" maxlength="20" type="text" /></td>
						<td></td>
					</tr>
				</tbody>
			</table>
			
			<div class="opus_design_data">
				<table class="grid2" style="width: 600px">
					<tbody>
					<colgroup>
					<col width="74" />
					<col width="500" />
					</colgroup>
					<tr>
						<th rowspan="2"><strong>Office Display Option</strong></th>
						<td class="sm">
							<input id="off_dis_op_1" name="off_dis_op_1" value="Y" class="trans" onclick="javascript:setDisplayOP();" type="checkbox" /><label for="off_dis_op_1">RHQ of C/A OFC</label><!-- 
							 --><input id="off_dis_op_2" name="off_dis_op_2" value="Y" class="trans" onclick="javascript:setDisplayOP();" type="checkbox" /><label for="off_dis_op_2">BKG OFC</label><!-- 
							 --><input id="off_dis_op_3" name="off_dis_op_3" value="Y" class="trans" onclick="javascript:setDisplayOP();" type="checkbox" /><label for="off_dis_op_3">C/A OFC</label><!-- 
							 --><input id="off_dis_op_4" name="off_dis_op_4" value="Y" class="trans" onclick="javascript:setDisplayOP();" type="checkbox" /><label for="off_dis_op_4">Contract OFC</label>
						</td>
					</tr>
					<tr>
						<td class="sm">
							<input id="off_dis_op_5" name="off_dis_op_5" value="Y" class="trans" type="checkbox" /><label for="off_dis_op_5">Sub office of C/A Issue Office</label><!-- 
							 --><input id="off_dis_op_6" name="off_dis_op_6" value="Y" class="trans" type="checkbox" /><label for="off_dis_op_6">Sub Office of DEL Office </label>
						</td>
					</tr>	
					</tbody>			
				</table>
			</div>
			
			<h3 class="title_design">Route</h3>
			
			<table>
				<tbody>
					<colgroup>
						<col width="10" />
						<col width="30" />
						<col width="120" />
						<col width="30" />
						<col width="120" />
						<col width="30" />
						<col width="120" />
						<col width="30" />
						<col width="120" />
						<col width="*" />
					</colgroup>
					<tr>
						<td></td>
						<th title="Place of Receipt">POR</th>
						<td><input id="por" name="por" style="width:55px;" class="input" value="" dataformat="engup" fulfill="" maxlength="5" type="text" /> </td>
						<th title="Port of Loading">POL</th>
						<td><input id="pol" name="pol" style="width:55px;" class="input" value="" dataformat="engup" fulfill="" maxlength="5" type="text" /> </td>
						<th title="Port of Discharging">POD</th>
						<td><input id="pod" name="pod" style="width:55px;" class="input" value="" dataformat="engup" fulfill="" maxlength="5" type="text" /> </td>
						<th title="Place of Delivery">DEL</th>
						<td><input id="del" name="del" style="width:55px;" class="input" value="" dataformat="engup" fulfill="" maxlength="5" type="text" /> </td>
						<td></td>
					</tr>
				</tbody>
			</table>
			
			<h3 class="title_design">Other Options</h3>
			
			<table class="sm" style="width: 600px"> 
				<colgroup>
					<col width="10" />
					<col width="250" />
					<col width="250" />
					<col width="150" />
					<col width="*" />
				</colgroup>
				<tr>
					<td></td>
					<td><input id="other_op_1" name="other_op_1" value="Y" class="trans" type="checkbox" /><label for="other_op_1"><strong>Include Carrier Haulage</strong></label></td>
					<td><input id="other_op_2" name="other_op_2" value="Y" class="trans" type="checkbox" /><label for="other_op_2"><strong>Include Merchant Haulage</strong></label></td>
					<td><input id="other_op_3" name="other_op_3" value="Y" class="trans" type="checkbox" /><label for="other_op_3"><strong>Exempt</strong></label></td>
					<td></td>
				</tr>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
		
		<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>	
	<!-- OPUS_DESIGN_TAB (CONDITION) (E) -->
	
	<!-- OPUS_DESIGN_TAB (RESULT) (S) -->
	<div id="tabLayer" style="display:none">
		<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet2');</script>
		</div>
		<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet3');</script>
		</div>
	</div>	
	<!-- OPUS_DESIGN_TAB (RESULT) (E) -->		
</div>	
</form>