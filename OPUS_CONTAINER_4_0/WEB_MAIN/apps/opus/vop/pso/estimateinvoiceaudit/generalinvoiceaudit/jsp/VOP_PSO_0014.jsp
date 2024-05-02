<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_PSO_0014.jsp
*@FileTitle  : Port charge Invoice Creation ( Invoice > Port charge Invoice Creation ) 
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
<%@ page import="com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.event.VopPso0014Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopPso0014Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	String strCntCd 		= "";
	Logger log = Logger.getLogger("com.clt.apps.EstimateInvoiceAudit.GeneralInvoiceAudit");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		strCntCd  = account.getCnt_cd();
		event = (VopPso0014Event)request.getAttribute("Event");
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
	var gUsrId = "<%=strUsr_id%>";
	var gCntCd = "<%=strCntCd%>";
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
<input id="vsl_cd" name="vsl_cd" type="hidden" />
<input id="skd_voy_no" name="skd_voy_no" type="hidden" />
<input id="skd_dir_cd" name="skd_dir_cd" type="hidden" />
<input id="cost_cd" name="cost_cd" type="hidden" />
<input id="acct_cd" name="acct_cd" type="hidden" />
<input id="vndr_seq" name="vndr_seq" type="hidden" />
<input id="isdelete" name="isdelete" type="hidden" />
<input id="cnt_cd" name="cnt_cd" value="<%=strCntCd %>" type="hidden" />
<input id="usr_id" name="usr_id" value="<%=strUsr_id %>" type="hidden" />
<input id="ttl_loc_amt" name="ttl_loc_amt" value="" type="hidden" />
<input id="updateflag" name="updateflag" value="" type="hidden" />
<input id="iss_cty_cd" name="iss_cty_cd" value="" type="hidden" />
<input id="so_seq" name="so_seq" value="" type="hidden" />
<input id="cost_ofc_cd" name="cost_ofc_cd" value="" type="hidden" />
<input id="pso_chg_sts_cd" name="pso_chg_sts_cd" value="" type="hidden" />
<input id="io_flag" name="io_flag" value="" type="hidden" />
<input id="rowIdx" name="rowIdx" value="" type="hidden" />
<input id="net_amt" name="net_amt" value="" type="hidden" />
<input id="ddt_amt" name="ddt_amt" value="" type="hidden" />
<input id="spdeleted" name="spdeleted" value="" type="hidden" />
<input id="night" name="night" value="" type="hidden" />
<input id="holiday" name="holiday" value="" type="hidden" />
<input id="boat" name="boat" value="" type="hidden" />
<input id="tugrope" name="tugrope" value="" type="hidden" />
<input id="buoy" name="buoy" value="" type="hidden" />
<input id="sanitation" name="sanitation" value="" type="hidden" />
<input id="barge" name="barge" value="" type="hidden" />
<input id="inspection" name="inspection" value="" type="hidden" />
<input id="newservice" name="newservice" value="" type="hidden" />
<input id="arrtp" name="arrtp" value="" type="hidden" />
<input id="deptp" name="deptp" value="" type="hidden" />
<input id="arrnt" name="arrnt" value="" type="hidden" />
<input id="depnt" name="depnt" value="" type="hidden" />
<input id="arrtuh" name="arrtuh" value="" type="hidden" />
<input id="deptuh" name="deptuh" value="" type="hidden" />
<input id="arrlh" name="arrlh" value="" type="hidden" />
<input id="deplh" name="deplh" value="" type="hidden" />
<input id="usdhrs" name="usdhrs" value="" type="hidden" />
<input id="copilot" name="copilot" value="" type="hidden" />
<input id="sdr" name="sdr" value="" type="hidden" />
<input id="tier" name="tier" value="" type="hidden" />
<input id="limit_time" name="limit_time" value="" type="hidden" />
<input id="others" name="others" value="" type="hidden" />
<input id="other_value" name="other_value" value="" type="hidden" />
<!-- NYK Modify 2014.10.31 -->
<input id="spcalangflg" name="spcalangflg" value="" type="hidden" />
<input id="defExistsDtlYn" name="existDtlYn" value="" type="hidden" />
<input id="clpt_ind_seq" name="clpt_ind_seq" value="" type="hidden" /><!-- 2016.04.26 Double Calling Add -->

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
	</h2>
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_Delete" id="btn_Delete">Delete</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_Confirm" id="btn_Confirm">Confirm</button>
	</div>
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry wfit">
	<table>
		<tbody>
			<colgroup>
				<col width="72" />
				<col width="100" />
				<col width="80" />
				<col width="100" />
				<col width="79" />
				<col width="100" />
				<col width="*" />
			</colgroup>
			<tr>
				<th>S/P Code</th>
				<td><input id="spcode" name="spcode" dataformat="num" maxlength="6" style="width:60;text-align:center;ime-mode:disabled;" class="input1" value="" type="text"/><button class="input_seach_btn" name="btns_search" id="btns_search" type="button"></button></td>
				<th>S/P Name</th>
				<td><input id="spname" name="spname" style="width: 220px; text-align:left;" class="input2" value="" readonly type="text" /></td>
				<th id="td_inv_no">INV No.</th>
				<td><input id="inv_no" name="inv_no" dataformat="engup" otherchar=" -._/" maxlength="20" style="width: 200px; text-align:left; ime-mode:disabled;" class="input1" value="" type="text" /></td>
				<td></td>
				<td style="display: none;"><b>Transfer Slip</b>&nbsp;<input id="trnsf_slp" name="trnsf_slp" style="border:none;" type="checkbox" /></td>
				<td style="display: none;">Credit Memo<input name="credit_memo" style="border:none;" type="checkbox"></td>
			</tr>
		</tbody>
	</table>
	<table class="line_bluedot"><tr><td></td></tr></table>
		<table>
			<tbody>
				<colgroup>
					<col width="71" />
					<col width="162" />
					<col width="109" />
					<col width="240" />
					<col width="55" />
					<col width="80" />
					<col width="95" />
					<col width="" />
				</colgroup>
				<tr>
					<th>TMNL</th>
					<td><select id="sel_yd_cd" name="yd_cd" style="width:113px" class="input1" onChange="displayTmnlNm(this);"></select></td>
					<th>TMNL Name</th>
					<td><input id="tmnl_nm" name="tmnl_nm" style="width: 220px; text-align:left;" class="input2" value="" readonly type="text" /></td>
					<th>INV. Amt</th>
					<td><input id="inv_amt" name="inv_amt" style="width: 109px; text-align:right;ime-mode:disabled;" class="input1" dataformat="singledFloat" caption="Invoice Amount" maxlength="20" size="7" pointcount="2" value="" type="text" /></td>
					<th>V.A.T.</th>
					<td><input id="vat" name="vat" style="width: 110px; text-align:right; ime-mode:disabled;" class="input" dataformat="singledFloat" caption="V.A.T" maxlength="20" size="7" pointcount="2" value="" type="text" /><label></label><label style="font-weight: bold">W/T</label><input id="whld_tax" name="whld_tax" style="width: 90px; text-align:right; ime-mode:disabled;" class="input" dataformat="singledFloat" caption="Withholding Tax" title="Withholding Tax" maxlength="20" size="7" pointcount="2" value="" type="text" /></td>
				</tr>
				<tr>
					<th>Cost OFC</th>
					<td><input id="cost_ofc" name="cost_ofc" style="width: 85px; text-align:center" class="input1" value="" readonly="" type="text" /><button type="button" id="btn_search_cost_ofc" name="btn_search_cost_ofc" class="input_seach_btn"></button></td>
					<th>INV. Office</th>
					<td><input id="inv_ofc_cd" name="inv_ofc_cd" style="width: 80px; text-align:center; margin-right:13px" class="input2" value="<%=strOfc_cd%>" readonly type="text" /><!-- 
					 --><label style="font-weight: bold">Currency</label><!-- <script type="text/javascript">ComComboObject('curr_cd', 1, 60, 0, 1);</script> --><!-- 
					 --><select id="curr_cd" name="curr_cd" style="width: 60px; text-align:center;" class="input1" ></select></td>
					<th>Issue Date</th>
					<td><input id="iss_dt" name="iss_dt" style="width :80px; text-align:center;" class="input1" value="" dataformat="ymd" maxlength="8" size="10" type="text" /><button class="calendar ir" name="btns_calendar_s" id="btns_calendar_s" type="button"></button></td>
					<th>Receive Date</th>
					<td><input id="rcv_dt" name="rcv_dt" style="width: 80px; text-align: center;" class="input1" value="" dataformat="ymd" maxlength="8" size="10" type="text" /><button class="calendar ir" name="btns_calendar_r" id="btns_calendar_r" type="button"></button></td>
				</tr>
			</tbody>
		</table>
		<table class="line_bluedot"><tr><td></td></tr></table>
		<table>
			<tbody>
				<colgroup>
					<col width="72" />
					<col width="200" />
					<col width="70" />
					<col width="205" />
					<col width="100" />
					<col width="*" />
				</colgroup>
				<tr class="pad_left_8">
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input id="vvdband" name="vvdband" readonly style="width: 112px; text-align:center;" class="input2" value="" type="text" /></td>
					<th>ATD</th>
					<td><input id="atd" name="atd" readonly style="width: 140px; text-align:center;" class="input2" value="" type="text" />  </td>
					<th>AMT (VVD/TTL)</th>
					<td><input id="calc_amt_vvd" name="calc_amt_vvd" readonly style="width: 156px; text-align:right;" class="input2" dataformat="singledFloat" pointcount="2" value=" " type="text" />/ <input id="calc_amt_ttl" name="calc_amt_ttl" readonly style="width: 156px; text-align:right;" class="input2" dataformat="singledFloat" pointcount="2" value=" " type="text" /></td>

				</tr>
			</tbody>
		</table>

	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	
	        <div class="opus_design_grid">
	           <div class="opus_design_btn">
					<button type="button" class="btn_accent" name="btn_RowAdd" id="btn_RowAdd">Row Add</button><!-- 
					 --><button type="button" class="btn_normal" name="btn_RowDelete" id="btn_RowDelete">Row Delete</button><!-- 
					 --><button type="button" class="btn_normal" name="btn_Calculation" id="btn_Calculation">Calculation</button>
			</div>
			<script type="text/javascript">ComSheetObject('sheet1');</script>
	       </div>	
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry">
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			<table>
				<tbody>
					<colgroup>
						<col width="70" />
						<col width="200" />
						<col width="*" />
					</colgroup>
					<tr class="sm pad_left_8">
						<th>Add Information :</th>
						<td><input id="cbx_night" name="cbx_night" value="" class="trans" type="checkbox" /><label for = "cbx_night">Night</label><!--   
							 --><input id="cbx_holiday" name="cbx_holiday" value="" class="trans" type="checkbox"/><label for = "cbx_holiday">Holiday</label><!--  
							 --><input id="cbx_boat" name="cbx_boat" value="" class="trans" type="checkbox"/><label for = "cbx_boat">Boat</label><!--  
							 --><input id="cbx_tugrope" name="cbx_tugrope" value="" class="trans" type="checkbox"/><label for = "cbx_tugrope">TUG Rope</label><!--  
							 --><input id="cbx_buoy" name="cbx_buoy" value="" class="trans" type="checkbox"/><label for = "cbx_buoy">Buoy</label><!--  
							 --><input id="cbx_sanitation" name="cbx_sanitation" value="" class="trans" type="checkbox"/><label for = "cbx_sanitation">Sanitation</label><!--  
							 --><input id="cbx_barge" name="cbx_barge" value="" class="trans" type="checkbox"/><label for = "cbx_barge">Barge</label><!--  
							 --><input id="cbx_inspection" name="cbx_inspection" value="" class="trans" type="checkbox"/><label for = "cbx_inspection">Inspection</label><!--  
							 --><input id="cbx_newservice" name="cbx_newservice" value="" class="trans" type="checkbox"/><label for = "cbx_newservice">New Service</label><!--  
							 --><input id="cbx_copilot" name="cbx_copilot" value="" class="trans" type="checkbox"/><label for = "cbx_copilot">Co-Pilot</label><!-- 
							 --><input id="cbx_others" name="cbx_others" value="" class="trans" type="checkbox"/><label for = "cbx_others">Others</label> 
						</td>
						<td></td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet2');</script>		
		<div style="display: none">
			<script type="text/javascript">ComSheetObject('sheet3');</script>
		</div>
	</div>
</div>
</form>