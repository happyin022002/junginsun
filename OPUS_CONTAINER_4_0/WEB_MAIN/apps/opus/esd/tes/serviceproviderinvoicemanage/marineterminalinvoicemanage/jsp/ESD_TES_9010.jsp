<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TES_9010.jsp
*@FileTitle  : Get Container List Pop Up
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/13
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event.EsdTes9010Event"%>
<%
	EsdTes9010Event  event = null;						//PDTO(Data Transfer Object including Parameters)
	//ESD_TES_901EventResponse eventResponse = null;	//RDTO(Data Transfer Object including DB ResultSet)
	//Request req = null;
	Exception serverException   = null;					//Server Exception
	DBRowSet rowSet	  = null;							//DB ResultSet
	String strErrMsg = "";								//Error Message
	int rowCount	 = 0;								//DB ResultSet Count
	String ofcCd = "";
	String cntr_tpsz_cd = "";
	String cost_cd_ftr_rmk = ""; //2016.09.09 AGMT COST CD Add

	try { 
	   SignOnUserAccount account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   ofcCd = account.getOfc_cd()!=null&&!account.getOfc_cd().equals("")?account.getOfc_cd():"";

	   cntr_tpsz_cd	= request.getParameter("cntr_tpsz_cd")!=null&&!request.getParameter("cntr_tpsz_cd").equals("")?request.getParameter("cntr_tpsz_cd"):"";
	   cost_cd_ftr_rmk	= request.getParameter("cost_cd_ftr_rmk")!=null&&!request.getParameter("cost_cd_ftr_rmk").equals("")?request.getParameter("cost_cd_ftr_rmk"):"";


		event = (EsdTes9010Event)request.getAttribute("Event");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
		
		} // end else
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">
<%= JSPUtil.getIBCodeCombo("io_bnd_cd"		, "01", "CD00592", 0, "")%>
<%= JSPUtil.getIBCodeCombo("cntr_sty_cd"	, "01", "CD00136", 0, "")%>
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="vvd" id="vvd" />
<input type="hidden" name="vndr_seq" id="vndr_seq" />
<input type="hidden" name="yd_cd" id="yd_cd" />
<input type="hidden" name="rcv_dt" id="rcv_dt" />
<input type="hidden" name="iss_dt" id="iss_dt" />
<input type="hidden" name="verify_chk" id="verify_chk" />
<input type="hidden" name="excel_chk" id="excel_chk" />
<input type="hidden" name="tml_so_ofc_cty_cd" id="tml_so_ofc_cty_cd" />
<input type="hidden" name="tml_so_seq" id="tml_so_seq" />
<input type="hidden" name="io_bnd_cd" id="io_bnd_cd" />
<input type="hidden" name="vvd_type" id="vvd_type" />
<input type="hidden" name="atb_dt" id="atb_dt" />
<input type="hidden" name="fbp_exist" id="fbp_exist" />
<input type="hidden" name="all_tp" id="all_tp" />
<input type="hidden" name="fm_tp" id="fm_tp" />
<input type="hidden" name="ts_tp" id="ts_tp" />
<input type="hidden" name="cntr_tpsz_cd" value="<%=JSPUtil.getNull(cntr_tpsz_cd)%>" id="cntr_tpsz_cd" />
<input type="hidden" name="cntr_no" id="cntr_no" />
<input type="hidden" name="tmp_cntr_tpsz_cd" id="tmp_cntr_tpsz_cd" />
<input type="hidden" name="row" id="row" />
<input type="hidden" name="call_yd_ind_seq" id="call_yd_ind_seq" /> <!-- 2016.07.13 Add -->
<input type="hidden" name="cost_cd_ftr_rmk" value="<%=JSPUtil.getNull(cost_cd_ftr_rmk)%>" id="cost_cd_ftr_rmk" /> <!-- 2016.09.09 AGMT COST CD Add -->


<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><span>Get Container List</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
			<button class="btn_accent" type="button" name="btn_tmpdown" id="btn_tmpdown">Down Excel</button><!--
		--><button class="btn_accent" type="button" name="btn_loadexcel" id="btn_loadexcel">Load Excel</button><!--
	    --><button class="btn_normal" type="button" name="btn_rowadd" id="btn_rowadd">Add</button><!--
		--><button class="btn_normal" type="button"  name="btn_rowdel" id="btn_rowdel">Delete</button><!--
		--><button class="btn_normal" type="button"  name="btn_chkdigit" id="btn_chkdigit">CHK Digit</button><!--
		--><button class="btn_normal" type="button"  name="btn_verify" id="btn_verify">Verify</button>
	</div>
	<!-- opus_design_btn (E) -->
</div>
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="80">
				<col width="90">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>File Import</th>
					<td><input type="radio" name="file_import_yn" id="radio_com_list_yn" value="Y"  class="trans" onclick="com_list_only_sts()" ><label for="radio_com_list_yn">Yes</label></td>
					<td><input type="radio" name="file_import_yn" id="radio_com_list_yn2" value="N"  class="trans" onclick="com_list_only_sts()"><label for="radio_com_list_yn2">No</label></td>
				</tr>
				<tr>
					<th>COM List Only</th>
					<td><input type="radio" name="com_list_yn" id="radio_radio_com_list_yn" value="Y"  class="trans" ><label for="radio_radio_com_list_yn">Show</label></td>
					<td><input type="radio" name="com_list_yn" id="radio_radio_com_list_yn2" value="N"  class="trans" ><label for="radio_radio_com_list_yn2">Hide</label></td>
				</tr>
				<tr>
					<th><span title='It is possible to input the CNTR No. manually by selecting YES'>Manual Input</span></th>
					<td><input type="radio" name="manual_input_yn" id="radio_manual_input_yn" value="Y"  class="trans" onclick="com_list_only_sts()" ><label for="radio_manual_input_yn">Yes</label></td>
					<td><input type="radio" name="manual_input_yn" id="radio_manual_input_yn2" value="N"  class="trans" onclick="com_list_only_sts()"><label for="radio_manual_input_yn2">No</label></td>
				</tr>
			</tbody>
		</table>
		<table>
			<colgroup>
				<col width="130">
				<col width="60">
				<col width="50">
				<col width="50">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>Cargo Type <label for="radio_import_tp_all">ALL</label><input type="checkbox" value="" desc="ALL" class="trans" name="import_tp_all" id="radio_import_tp_all"></th>
					<td><label for="radio_import_ts_tp">Local</label><input type="checkbox" value="L" desc="L" class="trans" name="import_ts_tp" id="radio_import_ts_tp"></td>
					<td><label for="radio_import_ts_tp2">T/S</label><input type="checkbox" value="T" desc="T" class="trans" name="import_ts_tp" id="radio_import_ts_tp2"></td>
					<td><label for="radio_import_fm_tp">Full</label><input type="checkbox" value="F" desc="F" class="trans" name="import_fm_tp" id="radio_import_fm_tp"></td>
					<td><label for="radio_import_fm_tp2">MTY</label><input type="checkbox" value="M" desc="M" class="trans" name="import_fm_tp" id="radio_import_fm_tp2"></td>
				</tr>
			</tbody>
		</table>
		<table>
			<colgroup>
				<col width="80">
				<col width="150">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>W/O No.</th>
					<td><input type="text" name="wo_no" id="wo_no" value="" style="width:150px"><button class="btn_etc" type="button"  name="btn_retrieve" id="btn_retrieve">Retrieve</button></td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<div class="wrap_result">
	<div class="opus_design_grid"  id="mainTable">
		<script type="text/javascript">ComSheetObject('sheet');</script>
	</div>
</div>
<div class="wrap_result">
	<div class="opus_design_grid"  id="hidden" style="display:none">
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>	
</div>	
</form>