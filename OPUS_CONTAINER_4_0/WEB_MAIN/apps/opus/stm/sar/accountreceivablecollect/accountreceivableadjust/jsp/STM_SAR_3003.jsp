<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAR_3003.jsp
*@FileTitle  : Autosettlement Entry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/06
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%> 
<%@ page import="com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.event.StmSar3003Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	SignOnUserAccount account = null; //Session Information
    StmSar3003Event event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;			//error from server
	String strErrMsg = "";						//error message

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.clt.apps.opus.stm.sar.accountreceivablecollect.AccountReceivableCollectSC");

	try {
	   	account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (StmSar3003Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

	} catch(Exception ex) {
		log.error("err " + ex.toString(), ex);
		//out.println(e.toString());
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

<link href="css/opus_contents.css" rel="stylesheet" type="text/css">
<link href="css/opus_menu.css" rel="stylesheet" type="text/css">


<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="adj_tj_tp_cd" value="ADJ" id="adj_tj_tp_cd" />
<input type="hidden" name="adj_tj_tp_key_cd" value="ADJKEY" id="adj_tj_tp_key_cd" />
<input type="hidden" name="xcld_ots_tp_cd" id="xcld_ots_tp_cd" />
<input type="hidden" name="xcld_ots_src_cd" id="xcld_ots_src_cd" />
<input type="hidden" name="backendjob_key">
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!-- 
		 --><button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_new"  	id="btn_new">New</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_save" 	id="btn_save">Save</button>
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
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
				<col width="70">
				<col width="120">
				<col width="646">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th><input type="radio" name="auto_tp_cd" id="auto_tp_cd_1" class="trans" value="S" checked /><label for="auto_tp_cd_1">Small OTS</label></th>
                	<th><input type="radio" name="auto_tp_cd" id="auto_tp_cd_2" class="trans" value="O" /><label for="auto_tp_cd_2">Overpayment</label></th>
                	<th>Office</th>
                	<td><input type="text" style="width:100px;" class="input1" name="multi_ofc_cd" readonly tabindex="-1" id="multi_ofc_cd" /><!-- 
                  	 --><button type="button" id="btn_multi_office_popup" name="btn_multi_office_popup" class="input_seach_btn"></button></td>
				</tr>
			</tbody>
		</table>
		<table>
			<colgroup>
				<col width="110">
				<col width="30">
				<col width="120">
				<col width="30">
				<col width="80">
				<col width="140">
				<col width="100">
				<col width="140">
				<col width="100">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>OTS Type Exclude</th>
					<td><button type="button" id="btns_xcld_ots_tp" name="btns_xcld_ots_tp" class="input_seach_btn"></button></td>
              		<th>Source Exclude</th>
              		<td><button type="button" id="btns_xcld_ots_src" name="btns_xcld_ots_src" class="input_seach_btn"></button></td>
                	<th>S/A Date</th>
                	<td><input type="text" style="width:100px;text-align:center" name="sail_arr_dt" dataformat="ymd" maxlength="10" class="input1" id="sail_arr_dt" /><!-- 
                	 --><button type="button" id="btns_sail_arr_dt_cal" name="btns_sail_arr_dt_cal" class="calendar ir"></button></td>
                	<th>Adjust Date</th>
                	<td><input type="text" style="width:100px;text-align:center" name="adj_dt" dataformat="ymd" maxlength="10" class="input1" id="adj_dt" /><!-- 
                	 --><button type="button" id="btns_adj_dt_cal" name="btns_adj_dt_cal" class="calendar ir"></button></td>
                	<th>Update Date</th>
                	<td> <input type="text" style="width:100px;text-align:center" name="bal_upd_dt" dataformat="ymd" maxlength="10" class="input1" id="bal_upd_dt" /><!-- 
                	 --><button type="button" id="btns_bal_upd_dt_cal" name="btns_bal_upd_dt_cal" class="calendar ir"></button></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(S) -->
	<!-- opus_design_grid(S) -->
	
	<div class="opus_design_grid">
	<div class="layout_flex_fixed" style="width:55%">
	<table>
		<tr> 
			<th width="100%">&nbsp;</th>
		</tr>
		</table>
	</div>
	
	<div class="layout_flex_fixed" style="width:45%">
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
	</div>
	<!-- opus_design_grid(S) -->
	<div class="opus_design_inquiry">
		<table>
			<colgroup>
				<col width="*">
				<col width="60">
				<col width="120">
				<col width="60">
				<col width="120">
				<col width="60">
				<col width="120">
			</colgroup>
			<tr>
	      		<th style="display:none">Total LCL</th>
	      		<td style="display:none"><input type="text" style="width:100px;text-align:right" name="tot_lcl_amt" dataformat="num" maxlength="12" pointcount="3" maxnum="99999999.999" class="input1" readonly id="tot_lcl_amt" /></td>
	      		<th>Total USD</th>
	      		<td><input type="text" style="width:100px;text-align:right" name="tot_usd_amt" dataformat="num" maxlength="12" pointcount="3" maxnum="99999999.999" class="input1" readonly id="tot_usd_amt" /></td>
	      		<th>Total Count</th>
	      		<td><input type="text" style="width:100px;text-align:right" name="tot_cnt_amt" dataformat="num" maxlength="12" pointcount="3" maxnum="99999999.999" class="input1" readonly id="tot_cnt_amt" /></td>
	      	</tr>
		</table>
	</div>
</div>
</form>