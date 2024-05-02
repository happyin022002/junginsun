<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0767.jsp
*@FileTitle  : Booking Report
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/28
=========================================================
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingreport.performancereport.event.EsmBkg0767Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0767Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//serverException
	String strErrMsg = "";						//error massage
	int rowCount	 = 0;						//DB ResultSet list count

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

		//bkgRptKndCd = request.getParameter("bkg_rpt_knd_cd");
		
		event = (EsmBkg0767Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//when open screen, get data in server..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
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

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<!-- Developer Work	-->

<input type="hidden" name="bkg_rpt_knd_cd" id="bkg_rpt_knd_cd" value="<%= bkgRptKndCd %>">
<!-- page_title_area(S) -->
<div class="layer_popup_title">
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><span>C/A Summary Template</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
	</div>
	<!-- opus_design_btn(E) -->
</div>
</div>
<div class="layer_popup_contents">
<div class= "wrap_search">
<!-- opus_design_inquiry(S) -->
	<div class= "opus_design_inquiry wFit">
	<table>
		<colgroup>
			<col width="50"/>
			<col width="50"/>
			<col width="50"/>
			<col width="50"/>
			<col width="*" />
		</colgroup>
		<tbody>
			<tr>
				<th>Template Name</th>
				<td><select name="rpt_nm" id="rpt_nm" style="width:200px;"class="input" onChange="javascript:changeNm()"></select></td>
				<td><input type="text" name="add_value" id="add_value" style="width:150px;" class="input" value="" ></td>
				<td><button type="button" class="btn_etc" name="btn_add" id="btn_add" >Add</button></td>
				<td><button type="button" class="btn_etc" name="btn_delete" id="btn_delete" >Delete</button></td>
			</tr>
		</tbody>
	</table>
	<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
	<h3 style="margin-bottom:0" class="title_design">By Date & VVD</h3>
	<table>
		<colgroup>
			<col width="50"/>
			<col width="50"/>
			<col width="50"/>
			<col width="*" />
		</colgroup>
		<tbody>
			<tr>
				<th>Correction Date</th>
				<td><input type="text" name="corr_from_dt" style="width:75px;" value="" caption="Correction Date" dataformat="ymd" maxlength="10" onbeforedeactivate="ComAddSeparator(this)" onbeforeactivate="ComClearSeparator(this)" id="corr_from_dt" /><!-- 
				     --><button type="button" id="btn_corr_sdate" name="btn_corr_sdate" class="calendar ir"></button>~ <input type="text" name="corr_to_dt" style="width:75px;" value="" caption="Correction Date" dataformat="ymd" maxlength="10" onbeforedeactivate="ComAddSeparator(this)" onbeforeactivate="ComClearSeparator(this)" id="corr_to_dt" /><!--   
				 	 --><button type="button" id="btn_corr_edate" name="btn_corr_edate" class="calendar ir"></button></td>
				<th>Booking Date</th>
				<td><input type="text" name="cre_from_dt" style="width:75px;" value="" caption="Booking Date" dataformat="ymd" maxlength="10" onbeforedeactivate="ComAddSeparator(this)" onbeforeactivate="ComClearSeparator(this)" id="cre_from_dt" /><!-- 
				     --><button type="button" id="btn_cre_sdate" name="btn_cre_sdate" class="calendar ir"></button>~ <input type="text" name="cre_to_dt" style="width:75px;" value="" caption="Booking Date" dataformat="ymd" maxlength="10" onbeforedeactivate="ComAddSeparator(this)" onbeforeactivate="ComClearSeparator(this)" id="cre_to_dt" /><!--   
				 	 --><button type="button" id="btn_cre_edate" name="btn_cre_edate" class="calendar ir"></button></td>
			</tr>
			<tr>
				<th title="Vessel Voyage Direction">VVD</th>
				<td><input type="text" name="vvd" style="width:80px;" value="" dataformat="engup" fulfill="" maxlength="9" id="vvd" /> </td>
			</tr>
		</tbody>
		</table>
		<h3 style="margin-bottom:0" class="title_design">Reason & Type</h3>
		<table class="grid2" border="0">
		<colgroup>
			<col width="50"/>
			<col width="*" />
		</colgroup>
			<tbody>
				<tr>
					<th>C/A Reason</th>
					<td>
						<input type="checkbox" name="ca_reason_m" value="" class="trans" id="ca_reason_m" /><label for = "ca_reason_m">M</label><!-- 
						 --><input type="checkbox" name="ca_reason_c" value="" class="trans" id="ca_reason_c" /><label for = "ca_reason_c">C</label><!-- 
						 --><input type="checkbox" name="ca_reason_g" value="" class="trans" id="ca_reason_g" /><label for = "ca_reason_g">G</label><!-- 
						 --><input type="checkbox" name="ca_reason_a" value="" class="trans" id="ca_reason_a" /><label for = "ca_reason_a">A</label><!-- 
						 --><input type="checkbox" name="ca_reason_o" value="" class="trans" id="ca_reason_o" /><label for = "ca_reason_o">O</label>
					</td>
				</tr>
				<tr>
					<th>C/A Class</th>
					<td class="stm">
						<input type="checkbox" name="ca_class_1" id="ca_class_1" value="" class="trans"><label for = "ca_class_1">Revenue</label><!-- 
						 --><input type="checkbox" name="ca_class_2" id="ca_class_2" value="" class="trans"><label for = "ca_class_2">Non-Revenue</label><!-- 
						 --><input type="checkbox" name="ca_class_3" id="ca_class_3" value="" class="trans"><label for = "ca_class_3">Expense</label> 
					</td>
				</tr>
				<tr>
					<td><button type="button" class="btn_etc" name="btn_cakind" id="btn_cakind" >C/A Kind</button></td>
					<td class="stm">
						<input type="checkbox" name="ca_kind_a" value="" class="trans" id="ca_kind_a" /><label for = "ca_kind_a">A</label><!-- 
						 --><input type="checkbox" name="ca_kind_b" value="" class="trans" id="ca_kind_b" /><label for = "ca_kind_b">B</label><!-- 
						 --><input type="checkbox" name="ca_kind_c" value="" class="trans" id="ca_kind_c" /><label for = "ca_kind_c">C</label><!-- 
						 --><input type="checkbox" name="ca_kind_d" value="" class="trans" id="ca_kind_d" /><label for = "ca_kind_d">D</label><!-- 
						 --><input type="checkbox" name="ca_kind_e" value="" class="trans" id="ca_kind_e" /><label for = "ca_kind_e">E</label><!-- 
						 --><input type="checkbox" name="ca_kind_f" value="" class="trans" id="ca_kind_f" /><label for = "ca_kind_f">F</label><!-- 
						 --><input type="checkbox" name="ca_kind_g" value="" class="trans" id="ca_kind_g" /><label for = "ca_kind_g">G</label><!-- 
						 --><input type="checkbox" name="ca_kind_h" value="" class="trans" id="ca_kind_h" /><label for = "ca_kind_h">H</label><!-- 
						 --><input type="checkbox" name="ca_kind_i" value="" class="trans" id="ca_kind_i" /><label for = "ca_kind_i">I</label><!-- 
						 --><input type="checkbox" name="ca_kind_j" value="" class="trans" id="ca_kind_j" /><label for = "ca_kind_j">J</label><!-- 
						 --><input type="checkbox" name="ca_kind_k" value="" class="trans" id="ca_kind_k" /><label for = "ca_kind_k">K</label>
					</td>
				</tr>
			</tbody>
		</table>
	<h3 style="margin-bottom:0" class="title_design">Office & Staff</h3>
	<table class="search" border="0"> 
	<colgroup>
	<col width="50"/>
	<col width="50"/>
	<col width="50"/>
	<col width="50"/>
	<col width="50"/>
	<col width="*" />
	</colgroup>
		<tbody>
			<tr>
				<th>C/A Issue Office</th>
				<td><input type="text" name="ca_issue_off" style="width:60px;" class="input" value="" dataformat="engup" fulfill="" maxlength="6" id="ca_issue_off" /> </td>
				<th>BKG Office</th>
				<td><input type="text" name="bkg_off" style="width:60px;" class="input" value="" dataformat="engup" fulfill="" maxlength="6" id="bkg_off" /> </td>
				<th>DEL Office</th>
				<td><input type="text" name="del_off" style="width:60px;" class="input" value="" dataformat="engup" fulfill="" maxlength="6" id="del_off" /> </td>
			</tr>
			<tr>
				<th>Contract Office</th>
				<td><input type="text" name="contract_off" style="width:60px;" class="input" value="" dataformat="engup" fulfill="" maxlength="6" id="contract_off" /> </td>
				<th>DEL Cont</th>
				<td><script type="text/javascript">ComComboObject('dlv_ctnt_cd', 1, 80, '');</script></td>
			</tr>
			<tr>
				<th>C/A Issue Staff</th>
				<td><input type="text" name="ca_issue_staff" id="ca_issue_staff" style="width:255px" class="input" value="" maxlength="20"></td>
			</tr>
		</table>
		<table class="grid2" border="0">
		<colgroup>
			<col width="50"/>
			<col width="*" />
		</colgroup>
		<tbody>
			<tr>
				<th rowspan="2">Office Display Option</th>
				<td class="stm"><input type="checkbox" name="off_dis_op_1" value="" class="trans" id="off_dis_op_1" /><label for = "off_dis_op_1">RHQ of C/A OFC</label><!-- 
					 --><input type="checkbox" name="off_dis_op_2" value="" class="trans" id="off_dis_op_2" /><label for = "off_dis_op_2">BKG OFC</label><!-- 
					 --><input type="checkbox" name="off_dis_op_3" value="" class="trans" id="off_dis_op_3" /><label for = "off_dis_op_3">C/A OFC</label><!-- 
					 --><input type="checkbox" name="off_dis_op_4" value="" class="trans" id="off_dis_op_4" /><label for = "off_dis_op_4">Contract</label>
				</td>
			</tr>
			<tr>
				<td class="stm"><input type="checkbox" name="off_dis_op_5" id="off_dis_op_5" value="" class="trans"><label for = "off_dis_op_5">Sub office of C/A  Issue Office</label><!-- 
					 --><input type="checkbox" name="off_dis_op_6" id="off_dis_op_6" value="" class="trans"><label for = "off_dis_op_6">Sub Office of DEL Office</label>
				</td>
			</tr>				
		</table>
		<h3 style="margin-bottom:0" class="title_design">Route</h3>
		<table class="search" border="0"> 
		<colgroup>
			<col width="50"/>
			<col width="50"/>
			<col width="50"/>
			<col width="50"/>
			<col width="50"/>
			<col width="50"/>
			<col width="50"/>
			<col width="*" />
		</colgroup>
		<tbody>
			<tr>
				<th title="Place of Receipt">POR</th>
				<td><input type="text" name="por" style="width:55px;" class="input" value="" dataformat="engup" fulfill="" maxlength="5" id="por" /> </td>
				<th title="Port of Loading">POL</th>
				<td><input type="text" name="pol" style="width:55px;" class="input" value="" dataformat="engup" fulfill="" maxlength="5" id="pol" /> </td>
				<th title="Port of Discharging">POD</th>
				<td><input type="text" name="pod" style="width:55px;" class="input" value="" dataformat="engup" fulfill="" maxlength="5" id="pod" /> </td>
				<th title="Place of Delivery">DEL</th>
				<td><input type="text" name="del" style="width:55px;" class="input" value="" dataformat="engup" fulfill="" maxlength="5" id="del" /> </td>
			</tr>
		</tbody>
		</table>
		<h3 style="margin-bottom:0" class="title_design">Other Options</h3>
		<table class="search_sm2" border="0" > 
		<colgroup>
			<col width="150"/>
			<col width="150"/>
			<col width="100" />
			<col width="*" />
		</colgroup>
		<tbody>
		<tr>
			<th><input type="checkbox" name="other_op_1" id="other_op_1" value="" class="trans"><label for = "other_op_1">Include Carrier Haulage</label></th><!-- 
			 --><th><input type="checkbox" name="other_op_2" id="other_op_2" value="" class="trans"><label for = "other_op_2">Include Merchant Haulage</label></th><!-- 
			 --><th><input type="checkbox" name="other_op_3" id="other_op_3" value="" class="trans"><label for = "other_op_3">Exempt</label></th><!-- 
			 --><td></td>
		</tr>
		</table>
</div>
</div>	
</div>			
<div class="layout_wrap">
	<div class="opus_design_grid clear">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
</div>
</form>