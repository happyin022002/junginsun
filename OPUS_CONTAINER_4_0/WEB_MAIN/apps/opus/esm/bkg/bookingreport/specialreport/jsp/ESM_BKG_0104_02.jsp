
<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_BKG_0104_02.js
*@FileTitle  : Report Template
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/07
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingreport.specialreport.event.EsmBkg0104Event"%>	
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0104Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//serverException
	String strErrMsg = "";						//error massage
	int rowCount	 = 0;						//DB ResultSet list count

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String rpt_nm = JSPUtil.getNull(request.getParameter("rpt_nm")); ;
	int rpt_index_temp = Integer.parseInt(JSPUtil.getNull(request.getParameter("rpt_index")));
	String rpt_index = Integer.toString(rpt_index_temp-1);
	
	String edit_yn = JSPUtil.getNull(request.getParameter("edit_yn"));
	boolean bBtn_Disabled = true;
	Logger log = Logger.getLogger("com.clt.apps.opus.esm.bkg.bookingreport.statusreport");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0104Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}

		//when open screen, get data in server..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request
				.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<script  type="text/javascript">
	paramReportName="<%=rpt_nm%>";
	paramReportIndex="<%=rpt_index%>";
	
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<div class="layer_popup_contents">
	<div class="layer_popup_title">
		<!-- page_title_area(S) -->
		<div class="page_title_area clear">
		   <!-- page_title(S) -->
			<h2 class="page_title"><span>VIP Customer Report</span></h2>
			<!-- page_title(E) -->
			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_OK" 		id="btn_OK">Ok</button><!--
				--><button type="button" class="btn_normal" name="btn_New" 	id="btn_New">New</button><!--
				--><button type="button" class="btn_normal" name="btn_Close"  		id="btn_Close">Close</button>	
			</div>
			<!-- opus_design_btn(E) -->
			<!-- page_location(S) -->
			<div class="location">
				<span id="navigation"></span>
			</div>
			<!-- page_location(E) -->
		</div>
		<!-- page_title_area(E) -->
	</div>
	<!-- opus_design_inquiry(S) -->
	<div class= "wrap_search">
		<div class= "opus_design_inquiry wFit">
			<table>
			<form method="post" name="tempform" onSubmit="return false;">
				<colgroup>
					<col width="80"/>
					<col width="*"/>
				</colgroup>
				<tbody>
					<tr>
						<th>Report Type</th>
						<td><script  type="text/javascript">ComComboObject('report_type', 2, 240, '');</script></td>
					</tr>
					<tr class="line_bluedot"><td colspan="2"></td></tr>	
				</tbody>
				</form>
			</table>
			
			<table>	
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="p_bkg_rpt_knd_cd" value="V" id="p_bkg_rpt_knd_cd" />
<input type="hidden" name="edit_yn" value="<%= edit_yn %>" id="edit_yn" />					
				<colgroup>
					<col width="80"/>
					<col width="40"/>
					<col width="80"/>
					<col width="60"/>
					<col width="40"/>
					<col width="60"/>
					<col width="40"/>
					<col width="60"/>
					<col width="40"/>
					<col width="60"/>
					<col width="40"/>
					<col width="60"/>
					<col width="40"/>
					<col width="60"/>
					<col width="60"/>
					<col width="*"/>
				</colgroup>
				<tbody>
					<tr>
						<td class="sm pad_left_8"><input type="radio" name="in_out_cd" value="IN" class="trans" checked id="in_out_cd_2" /><label for="in_out_cd_2"><b>Inbound</b></label></td>
						<th id="eta_id" name="eta_id" >ETA</th>
						<td colspan="2"><input type="text" style="width:75px;" class="input1" maxlength="10" dataformat="ymd" name="vps_eta_dt" value="" id="vps_eta_dt" />-&nbsp;<input type="text" style="width:75px;" class="input1" maxlength="10" dataformat="ymd" name="vps_etd_dt" value="" id="vps_etd_dt" /><button type="button" id="btn_eta_date" name="btn_eta_date" class="calendar ir"></button></td>
						<th title="Vessel Voyage Direction">VVD</th>
						<td><input type="text" style="width:75px;" class="input1" name="vvd_cd" value="" maxlength="9" required fullfill="" dataformat="engup" id="vvd_cd" /> </td>
						<th title="Port of Loading">POL</th>
						<td><input type="text" style="width:60px;" class="input" name="pol_cd" value="" maxlength="5" dataformat="engup" id="pol_cd" /><input type="text" style="width:25px;" value="" class="input" name="pol_yard_cd" maxlength="2" dataformat="engup" id="pol_yard_cd" /> </td>
						<th title="Port of Discharging">POD</th>
						<td><input type="text" style="width:60px;" value="" name="pod_cd" maxlength="5" dataformat="engup" class="input" id="pod_cd" /><input type="text" style="width:25px;" value="" class="input" name="pod_yard_cd" maxlength="2" dataformat="engup" id="pod_yard_cd" /> </td>
						<th title="Place of Receipt">POR</th>
						<td><input type="text" style="width:60px;" class="input" name="por_cd" maxlength="5" dataformat="engup" value="" id="por_cd" /> </td>
						<th title="Place of Delivery">DEL</th>
						<td><input type="text" style="width:60px;" class="input" name="del_cd" maxlength="5" dataformat="engup" value="" id="del_cd" /> </td>
						<th>EQ Office</th>
						<td><input type="text" style="width:45px;" class="input" name="eq_ofc_cd" maxlength="6" dataformat="enguponly" value="" id="eq_ofc_cd" /></td>												
					</tr>
					<tr>
						<td class="sm pad_left_8"><input type="radio" name="in_out_cd" value="OUT" class="trans" id="in_out_cd_1" /><label for="in_out_cd_1"><b>Outbound</b></label></td>
						<th>S/C</th>
						<td><input type="text" style="width:80px;" class="input1" name="sc_no" value="" maxlength="20" dataformat="engup" id="sc_no" /> </td>
						<th>Customer</th>
						<td colspan="5"><script type="text/javascript">ComComboObject('cust_tp_cd', 2, 50, true, '');</script><!-- 
						 --><input type="text" style="width:25px;" class="input1" name="cust_cnt_cd" value=""  maxlength='2'  dataformat='engup' style="ime-mode:disabled"><!-- 
						 --><input type="text" style="width:50px;" class="input1" maxlength='6' dataformat='num' name="cust_seq" style="ime-mode:disabled"  value=""><!-- 
						 --><input type="text" style="width:135px;" class="input" maxlength='50' dataformat='engup' name="cust_nm" value="" readonly><!-- 
						 --><button type="button" id="btn_customer_pop" name="btn_customer_pop" class="input_seach_btn"></button></td>
						<th>EDI ID</th>
						<td colspan="7"><input type="text" style="width:68px;" class="input" name="edi_id" value="" maxlength="9" dataformat="engup" id="edi_id" /><input type="text" style="width:87px;" class="input2" maxlength="50" dataformat="engup" name="edi_gr_cd" value="" readonly id="edi_gr_cd" /><input type="text" style="width:96px;" class="input2" maxlength="50" dataformat="engup" name="edi_gr_nm" value="" readonly id="edi_gr_nm" /><button type="button" id="btn_Edi_Id" name="btn_Edi_Id" class="input_seach_btn"></button></td>
					</tr>
					<tr>
						<th colspan="3">Special Cargo</th>
						<td colspan="2"><input type="checkbox" class="trans" name="sp_cargo_rf" value="RF" id="sp_cargo_rf" /><!--
							--><label for="sp_cargo_rf"><b>RF</b></label><!--
							--><input type="checkbox" class="trans" name="sp_cargo_dg" value="DG" id="sp_cargo_dg" /><!--
							--><label for="sp_cargo_dg"><b>DG</b></label><!--
							--><input type="checkbox" class="trans" name="sp_cargo_ak" value="AK" id="sp_cargo_ak" /><!--
							--><label for="sp_cargo_ak"><b>AK</b></label><!--
							--><input type="checkbox" class="trans" name="sp_cargo_bb" value="BB" id="sp_cargo_bb" /><!--
							--><label for="sp_cargo_bb"><b>BB</b></label>
						</td>
						<th colspan="2">Group Customer</th>
						<td colspan="2"><input type="text" style="width:90px;" class="input" name="gcust" value="" maxlength="10" dataformat="engup" otherchar="#&*()., -" id="gcust" /></td>
						<th colspan="3">Assign Credit Term</th>
						<td colspan="4"><input type="text" style="width:20px;" class="input" name="credit" value="" maxlength="2" dataformat="num" id="credit" /></td>
					</tr>
				</tbody>
			</form>
			</table>
		</div>
	</div>
	<!-- opus_design_inquiry(E) -->
	<!-- opus_design_grid(S) -->
	<div style="display: none;">
		<div class="wrap_result">
			<div class="opus_design_grid clear" >
				<script type="text/javascript">ComSheetObject('sheet1');</script>
			</div>
		</div>
	</div>
	<!-- opus_design_grid(E) -->

</div>
<%@include file="/bizcommon/include/common_opus.jsp"%>