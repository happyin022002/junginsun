<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : EES_MNR_0054.jsp
*@FileTitle  : Vessel Reefer Spare Part Purchase W/O Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/20
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.event.EesMnr0054Event" %>
<%@ page import="org.apache.log4j.Logger" %>

<%

	EesMnr0054Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Occurred error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//Row count of retrieved database data

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String rhqOfcCd         = "";
	String currOfcCd        = "";
	String currOfcEngNm     = "";
	Logger log = Logger.getLogger("com.clt.apps.OperationManage.RepairMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id       = account.getUsr_id();
		strUsr_nm       = account.getUsr_nm();
		rhqOfcCd        = account.getRhq_ofc_cd();
		currOfcCd       = account.getOfc_cd();
		currOfcEngNm    = account.getOfc_eng_nm();

		event = (EesMnr0054Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//Extracting retrieved data from server on load screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>


<script type="text/javascript">
    var currOfcCd = "<%=currOfcCd.trim() %>";
    var selectOfc  = "<% out.print(currOfcCd + "|" + currOfcEngNm); %>";
    var rhqOfcCd  = "<%=rhqOfcCd.trim() %>";
    var HOOfc     = "";
    var self_usr_nm = "<%=strUsr_nm%>";
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}

</script>


<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="f_gubuns" id="f_gubuns">
<input type="hidden" name="mnr_grp_tp_cd" id="mnr_grp_tp_cd" value="RPR">
<input type="hidden" name="mnr_wo_tp_cd" id="mnr_wo_tp_cd" value="RFS">
<input type="hidden" name="spr_prt_no" id="spr_prt_no" value="">
<input type="hidden" name="agmt_ofc_cty_cd" id="agmt_ofc_cty_cd" value="">
<input type="hidden" name="agmt_seq" id="agmt_seq" value="">
<input type="hidden" name="agmt_ver_no" id="agmt_ver_no" value="">
<input type="hidden" name="sel_type" id="sel_type" value="S">
<input type="hidden" name="cost_cd" id="cost_cd" value="MRRUSP">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button>
		<button type="button" class="btn_normal" name="btn_New"  	id="btn_New">New</button>
		<button type="button" class="btn_normal" name="btn_W/O_Creation" 	id="btn_W/O_Creation">W/O Creation</button>
		<button type="button" class="btn_normal" name="btn_W/O_Send" 	id="btn_W/O_Send">W/O Send</button>
		<button type="button" class="btn_normal" name="btn_save" 	id="btn_save">Delete</button>
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->

<div class= "wrap_search">
		<div class= "opus_design_inquiry wFit">
<!-- opus_design_inquiry(S) -->
		<table>
			<colgroup>
				<col width="105">
				<col width="270">
				<col width="60">
				<col width="200">
				<col width="110">
				<col width="105">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>W/O No.</th>
					<td><input type="text" style="width:90px;" class="input1" value="" name="mnr_ord_seq" id="mnr_ord_seq"  required dataformat="engup"><!--  
						--><button type="button" name="btn_WONo" id="btn_WONo" class="input_seach_btn" ></button>
					</td>
					<th>Date</th>
					<td><input type="text" style="width:75px;" class="input2" value="" name="showDate" id="showDate" readonly></td>
					<td colspan="3"></td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="opus_design_inquiry"><table class="line_bluedot"><tr><td></td></tr></table></div>
	<div class= "opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="105">
				<col width="270">
				<col width="60">
				<col width="200">
				<col width="110">
				<col width="105">
				<col width="*">
			</colgroup>
			<tbody>
				<tr class="h23">
					<th>Agreement No.</td>
					<td><script type="text/javascript">ComComboObject('combo_vndr_seq',9, 250, 1, 1,2,false,1);</script><!--  
						--><input type="hidden" name="vndr_seq" id="vndr_seq"></td>
					<th>EQ Type</th>
					<td><script type="text/javascript">ComComboObject('combo_eq_knd_cd',6, 80, 1, 1,1,false,1);</script><!-- 
						 --><input type="hidden" name="eq_knd_cd" id="eq_knd_cd"></td>
					<th>Cost CTRL Office</th>
					<td><input type="text" style="width:80px;text-align:center;" class="input2" value="" name="cost_ofc_cd" id="cost_ofc_cd" readonly></td>
					<td></td>
				</tr>
				<tr class="h23">
					<th>Service Provider</th>
					<td><input type="text" style="width:250px;" class="input2" value="" name="pic_eng_nm" id="pic_eng_nm" readonly></td>
					<th>Effective</th>
					<td><input type="text" style="width:80px;" class="input2" value="" name="eff_dt" id="eff_dt"  readonly>&nbsp;~&nbsp;&nbsp;<input type="text" style="width:80px;" class="input2" value="" name="exp_dt" id="exp_dt"  readonly></td>
					<th>Currency</th>
					<td><input type="text" style="width:80px;text-align:center;" class="input2" value="" name="curr_cd" id="curr_cd" readonly></td>
					<td></td>
				</tr>
				<tr class="h23">
					<th>Supply To</th>
					<td><script type="text/javascript">ComComboObject('combo_spr_prt_spl_tp_cd',2, 70 , 1, 0,0,false,1);</script><input type="hidden" name="spr_prt_spl_tp_cd" id="spr_prt_spl_tp_cd"></td>
					<th>VVD Code </th>
					<td><input type="text" name="vsl_vvd" id="vsl_vvd" maxlength=9 style="width:120px;" class="input" dataformat="engup"><!-- CNTC0810MM --><!--  
						--><input type="hidden" name="vsl_cd" id="vsl_cd"><input type="hidden" name="skd_voy_no" id="skd_voy_no"><input type="hidden" name="skd_dir_cd" id="skd_dir_cd">
					</td>
					<th>Supply Date</th>
					<td><input type="text" name="spr_prt_spl_dt" id="spr_prt_spl_dt" style="width:80px;" class="input1" dataformat="ymd"><!--  
						--><button type="button" class="calendar ir" name="btn_calendar" id="btn_calendar"></button>
					</td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->
<div class="wrap_result">
<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_add" 	id="btn_add">Row Add</button>
			<button type="button" class="btn_normal" name="btn_delete"  id="btn_delete">Row Delete</button>
			<button type="button" class="btn_normal" name="btn_downExcel" 	id="btn_downExcel">Down Excel</button>
		</div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>

<!-- opus_design_grid(E) -->
<!-- opus_design_data(S) -->
	<div class="opus_design_inquiry">
		<table>
			<colgroup>
				<col width="100">
				<col width="120">
				<col width="80">
				<col width="120">
				<col width="80">
				<col width="120">
				<col width="80">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<td colspan="2"><h3 class="title_design">Recent Supply Information</h3></td>
					<td colspan="6"><button type="button" class="btn_etc" name="btn_Detail" id="btn_Detail">Detail(s)</button></td>
				</tr>
				<tr>
					<th>Supply Vessel</th>
					<td><input type="text"  name="vsl_cd2" id="vsl_cd2" style="width:100px; text-align:center;" class="input2" value="" readonly></td>
					<th>Supply Yard</th>
					<td><input type="text" name="spr_prt_spl_yd_cd2" id="spr_prt_spl_yd_cd2" style="width:100px;" class="input2" value=""  readonly></td>
					<th>Supply Date</th>
					<td><input type="text" name="spr_prt_spl_dt2" id="spr_prt_spl_dt2" style="width:100px; text-align:center;" class="input2" value=""  readonly></td>
					<th>Supply S/P</th>
					<td><input type="text" name="pic_eng_nm2" id="pic_eng_nm2" style="width:230px;" class="input2" value=""  readonly></td>
				</tr>
				<tr>
					<td><h3 class="title_design">Remark(s)</h3></td>
					<td colspan="7"></td>
				</tr>
				<tr>
					<td colspan="8"><textarea name="ord_hdr_rmk" id="ord_hdr_rmk" style="ime-mode:disabled; width:100%;height:60px; resize:none;"></textarea></td>
				</tr>
			</tbody>
		</table>
	</div>
<!-- opus_design_data(E) -->
<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="hideTable" name="hideTable" style="display:none;">
			<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
<!-- opus_design_grid(E) -->
<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="hideTable" name="hideTable" style="display:none;">
			<script type="text/javascript">ComSheetObject('sheet3');</script>
	</div>
<!-- opus_design_grid(E) -->
</div>
</form>

<%@include file="/bizcommon/include/common_opus.jsp" %>