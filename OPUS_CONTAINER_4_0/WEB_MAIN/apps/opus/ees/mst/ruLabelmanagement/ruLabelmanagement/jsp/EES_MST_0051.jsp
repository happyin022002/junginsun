<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MST_0051.jsp
*@FileTitle  : RU Label Attatchment / Detachment
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/15
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mst.ruLabelmanagement.ruLabelmanagement.event.EesMst0051Event"%>
<%
	EesMst0051Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error occurred on the server
	DBRowSet rowSet	  = null;							   //DB ResultSet
	String strErrMsg = "";								 //Error message
	int rowCount	 = 0;								  //DB ResultSet List the number of

	SignOnUserAccount account = null;

	try {

		account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);

		event = (EesMst0051Event)request.getAttribute("Event");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		} // end if


	}catch(Exception e) {
		out.println(e.toString());
	}

    // change to table name
	//String cntr_sts_cd       = JSPUtil.getCodeCombo("cntr_sts_cd", "01", "width='80' class='input' style='text-align:center'", "CD30097", 0, "000020:ALL:ALL");

%>
<script type="text/javascript">

	<%= JSPUtil.getIBCodeCombo("s_ru_lable_type", "", "CD20097", 0, "")%>
	
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="f_cre_usr_id" id="f_cre_usr_id" value="<%=account.getUsr_id()%>">

<input type="hidden" name="cntr_lot_tpsz_cd" id="cntr_lot_tpsz_cd">
<input type="hidden" name="lot_pln_yr" id="lot_pln_yr">
<input type="hidden" name="lot_loc_cd" id="lot_loc_cd">
<input type="hidden" name="lot_seq" id="lot_seq">
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="h_cntr_no" id="h_cntr_no" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_new" id="btn_new" type="button">New</button><!--
		--><button class="btn_normal" name="btn_save" id="btn_save" type="button">Save</button><!--
		--><button class="btn_normal" name="btn_loadexcel" id="btn_loadexcel" type="button">Load Excel</button><!--
		--><button class="btn_normal" name="btn_downexcel" id="btn_downexcel" type="button">Down Excel</button>
	</div>
	<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="90">
				<col width="330">
				<col width="130">
				<col width="300">
				<col width="90">
                <col width="150">		
                <col width="150">		
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<td><input type="radio" name="f_r_check" id="f_r_check1" value="1" class="trans" checked onclick="javascript:chk_SearchType(1);"> <label for="f_r_check1"><strong>RU Label</strong></label></td>
					<td><script type="text/javascript" >ComComboObject('s_ru_label_type', 1, 100, 1 );</script><!--  
						--><input type="text" style="width:150px;" class="input2" id="s_ru_label_text"  name="s_ru_label_text" dataformat="engup" value="" readonly><button type="button" id="btn_ru_label" name="btn_ru_label" class="input_seach_btn"></button><!--  
						--><span style="display:none"><script type="text/javascript" >ComComboObject('s_ru_label_value', 1, 100, 1 );</script></span><input type="hidden" name="lstm_cd" id="lstm_cd" value="" ></td>
					<td><input type="radio" name="f_r_check" id="f_r_check2" value="2" class="trans" onclick="javascript:chk_SearchType(2);"> <label for="f_r_check2"><strong>Container No.</strong></label></td>
					<td><input type="text" style="width:157px;" class="input1" id="s_cntr_no"  name="s_cntr_no" dataformat="engup" maxlength='11' value=""><!--  
						--><button type="button" class="multiple_inq ir" id="btn_popup1" name="btn_popup1"></button></td>
					<th>Type Size</th>
					<td><script type="text/javascript" >ComComboObject('s_tp_cd', 1, 130, 1 );</script><!--  
						--><input type="hidden" name="cntr_tpsz_cd" id="cntr_tpsz_cd" value="" ></td>
	                <th>Status Code</th>
                    <td><script type="text/javascript" >ComComboObject('s_cntr_sts_cd', 1, 130, 1 );</script><!--  
                        --><input type="hidden" name="cntr_sts_cd" id="cntr_sts_cd" value="" ></td>					
				</tr>
				<tr>
					<th style="text-align:left;padding-left:25px">AGMT No.</th>
					<td>
						<input type="text" style="width:253px;text-align:left;" name="s_multi_agmt_seq" id="s_multi_agmt_seq"  class="input2"  value="" readonly><!--  
						--><button type="button" class="input_seach_btn" name="btns_agmt_search" id="btns_agmt_search"></button>
					</td>
					<td style="display:none"><input type="text" style="width:35px;text-align:center;" name="s_agmt_cty_cd" id="s_agmt_cty_cd" class="input2" value="HHO" maxlength="3" readonly ><!--  
						--><input type="text" style="width:60px;text-align:right;" name="s_agmt_seq" id="s_agmt_seq"  class="input"  value="" maxlength="6" dataformat="num"><!--  
						--><button type="button" class="input_seach_btn" name="btns_search3" id="btns_search3"></button><!--  
						--><input type="text" name="s_contract_no" id="s_contract_no" style="width:150px;" class="input2" readonly></td>
					<th style="text-align:left;padding-left:25px">Spec No.</th>
					<td><input type="text" style="width:157px;" class="input" id="cntr_spec_no"  name="cntr_spec_no" maxlength='17'   readonly style="text-align:center" value=""><button type="button" id="btn_Popup" name="btn_Popup" class="input_seach_btn"></button></td>
					<th>Lot No.</th>
					<td><input type="text" style="width: 130px" class="input" value="" name="lot_no" id="lot_no" style="text-align:center" readonly><button type="button" id="ComOpenPopupWithTarget1" name="ComOpenPopupWithTarget1" class="input_seach_btn"></button></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>	

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="mainTable">
		<div class="opus_design_btn"><!-- 
		--><button type="button" class="btn_accent" name="btn_more" id="btn_more">More</button><!--
		--><button class="btn_normal" name="btn_history" id="btn_history" type="button">History</button><!--  
			--><button class="btn_normal" name="btn_rowadd" id="btn_rowadd" type="button">Row Add</button><!--  
			--><button class="btn_normal" name="btn_rowdelete" id="btn_rowdelete" type="button">Row Delete</button>
		</div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>
