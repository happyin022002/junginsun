<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0361_06.jsp
*@FileTitle  : Export / Import Information (Canada)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event.EsmBkg036101Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List" %>
<%@ page import="com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.XptImpLicVO" %>
<%@ page import="com.clt.apps.opus.esm.bkg.common.*" %>

<%

	EsmBkg036101Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";				//error message
	int rowCount	 = 0;				//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.outboundblmgt.bldocumentation");

	/*
	*/
	String bkg_no = "";
	String io_bnd_cd = "";
	String pol_cd = "";
	String pod_cd = "";
	String go_cnt_cd = "";
	String pkg_qty = "";
	String wgt_qty = "";
	String pkg_tp = "";
	String wgt_tp = "";

	String popUpTpCd   = "";
    String xter_sndr_id  = "";
    String xter_rqst_no  = "";
    String xter_rqst_seq = "";

	List<XptImpLicVO> xptImpLicVO = null;

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg036101Event)request.getAttribute("Event");
		bkg_no       = event.getBkgNo();
		io_bnd_cd    = event.getIoBndCd();

		pol_cd		 = event.getPolCd();
		pod_cd       = event.getPodCd();
		go_cnt_cd    = (event.getGoCntCd()==null ||event.getGoCntCd().length()==0) ? "" : event.getGoCntCd();
		pkg_qty		 = (event.getPkgQty()==null ||event.getPkgQty().length()==0) ? "0" : event.getPkgQty();
		wgt_qty		 = (event.getWgtQty()==null ||event.getWgtQty().length()==0) ? "0" : event.getWgtQty();
		pkg_tp		 = event.getPkgTp();
		wgt_tp       = event.getWgtTp();

		popUpTpCd       = event.getPopUpTpCd();
		xter_sndr_id    = event.getXterSndrId();
		xter_rqst_no    = event.getXterRqstNo();
		xter_rqst_seq   = event.getXterRqstSeq();

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		xptImpLicVO = (List<XptImpLicVO>) eventResponse.getCustomData("xptImpLicVO");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<base target="_self">

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Export/Import Information</span></h2>
	</div>
</div>

<div class="layer_popup_contents" style="overflow:hidden">
<div class="wrap_search_tab">
	<div class="opus_design_tab">
		<script >ComTabObject('tab1')</script>
	</div>
	<div id="tabLayer" style="display:inline">
		<form name="form" style="margin:0px;">
			<input type="hidden" name="f_cmd" id="f_cmd" />
			<input type="hidden" name="pagerows" id="pagerows" />
			<input type="hidden" name="bkg_no" value="<%=bkg_no%>" id="bkg_no" />
			<input type="hidden" name="io_bnd_cd" value="O" id="io_bnd_cd" />
			<input type="hidden" name="exp_io_bnd_cd" value="O" id="exp_io_bnd_cd" />
			<input type="hidden" name="exp_xpt_imp_seq" value="1" id="exp_xpt_imp_seq" />
			<input type="hidden" name="go_cnt_cd" value="<%=go_cnt_cd%>" id="go_cnt_cd" />
			<input type="hidden" name="pkg_tp" value="<%=pkg_tp%>" id="pkg_tp" />
			<input type="hidden" name="wgt_tp" value="<%=wgt_tp%>" id="wgt_tp" />
			
			<input type="hidden" name="popUpTpCd" value="<%=popUpTpCd%>" id="popUpTpCd" />
			<input type="hidden" name="xter_sndr_id" value="<%=xter_sndr_id%>" id="xter_sndr_id" />
			<input type="hidden" name="xter_rqst_no" value="<%=xter_rqst_no%>" id="xter_rqst_no" />
			<input type="hidden" name="xter_rqst_seq" value="<%=xter_rqst_seq%>" id="xter_rqst_seq" />
			<!-- page_title_area(S) -->
			<!-- opus_design_btn (S) -->
			<div class="opus_design_btn">
				<button class="btn_accent" type="button" name="btn_delete" id="btn_delete">Delete</button><!--
				--><button class="btn_normal" type="button" name="btn_save" id="btn_save" >Save</button><!--
				--><button class="btn_normal" type="button" name="btn_close" id="btn_close" >Close</button>
			</div>
			<!-- opus_design_btn (E) -->

			<!-- wrap_search(S) -->
			<div class="wrap_search">
				<!-- opus_design_inquiry(S) -->
				<div class="opus_design_inquiry wFit">
					<table>
						<colgroup>
							<col width="130" />
							<col width="*" />
						</colgroup>
						<tbody>
							<tr>
								<th>Country</th>
								<td><%=JSPUtil.getCodeCombo("exp_cnt_cd", "CA", "onChange='javascript:goCtnCd(this);'", "CD20055", 0, "")%></td>
							</tr>
						</tbody>
					</table>
					<table class="line_bluedot"><tr><td></td></tr></table>	
					<h3 class="title_design">Export Declaration Number for Canadian Customs</h3>
					<table>
						<colgroup>
							<col width="130" />
							<col width="*" />
						</colgroup>
						<tbody>
							<tr>
								<th>Booking No.</th>
								<td><input type="text" name="exp_bkg_no" style="width:110px;" class="input2" value="<%=bkg_no%>" readonly id="exp_bkg_no" /></td>
							</tr>
							<tr>
								<th><input type="checkbox" id="exp_caed_tp_cd" value="CE" class="trans" name="exp_caed_tp_cd" onclick="javascript:radioBtnSet(this)" /><label id="CHK01">CAED No.</label> </th>
								<td><input type="text" style="width:90px;" class="input2" value=" P.O.R: CAED" name="caed_pfx_ctnt" readonly id="caed_pfx_ctnt" /><input type="text" style="width:248px;" class="input" name="caed_no" dataformat="eng" maxlength="23" onblur="javascript:ChkComIsCaedNo(this);" id="caed_no" /></td>
								
							</tr>
							<tr>
								<th><input type="checkbox" value="G7" class="trans" name="exp_caed_tp_cd" onclick="javascript:radioBtnSet(this)" id="exp_caed_tp_cd" /><label id="CHK02">G7 EDI No.</label> </th>
								<td><input type="text" style="width:90px;" class="input2" value=" P.O.R: G7 EDI" name="g7_edi__pfx_ctnt" readonly id="g7_edi__pfx_ctnt" /><!--
								--><input type="text" style="width:248px;" class="input" name="g7_edi_no" maxlength="17" onblur="javascript:ChkComIsG7EdiNo(this);" id="g7_edi_no" /></td>
							</tr>
							<tr>
								<th><input type="checkbox" value="SM" class="trans" name="exp_caed_tp_cd" id="exp_caed_tp_cd" onclick="javascript:radioBtnSet(this)" /><label id="CHK03">Summary Report</label> </th>
								<td><input type="text" style="width:90px;" class="input2" value=" P.O.R: SUM" name="mf_smry_rpt_pfx_ctnt" readonly id="mf_smry_rpt_pfx_ctnt" /><!--
								--><input type="text" style="width:248px;" class="input" name="exp_mf_smry_rpt_no" maxlength="4" dataformat="num" id="exp_mf_smry_rpt_no" /></td>
							</tr>
							<tr>
								<th><input type="checkbox" value="EX" class="trans" name="exp_caed_tp_cd" id="exp_caed_tp_cd" onclick="javascript:radioBtnSet(this)" /><label id="CHK04">EXD (Form B13A)</label> </th>
								<td><input type="text" style="width:90px;" class="input2" value=" P.O.R: B13A" name="b13a_xpt_pfx_ctnt" readonly id="b13a_xpt_pfx_ctnt" /><!--
								--><input type="text" style="width:248px;" class="input" name="b13a_xpt_no" dataformat="eng" maxlength="21" onblur="javascript:ChkComIsB13aXptNo(this);" id="b13a_xpt_no" /></td>
							</tr>
							<tr>
								<th><input type="checkbox" value="IT" class="trans" name="exp_caed_tp_cd" id="exp_caed_tp_cd" onclick="javascript:radioBtnSet(this)" /><label id="CHK05">In-Transit Cargo</label> </th>
								<td><input type="text" style="width:130px;" class="input2" value=" P.O.R: In-Bond Cargo" name="cgo_ctrl_pfx_ctnt" readonly id="cgo_ctrl_pfx_ctnt" /><!--
								--><input type="text" style="width:208px;" class="input" name="exp_cgo_ctrl_no" maxlength="21" id="exp_cgo_ctrl_no" /></td>
							</tr>
							<tr>
								<th><input type="checkbox" value="ND" class="trans" name="exp_caed_tp_cd" id="exp_caed_tp_cd" onclick="javascript:radioBtnSet(this)" /><label id="CHK06">No Declaration</label> </th>
								<td><input type="text" style="width:50px;" class="input2" value=" P.O.R:" name="ndr_ref_pfx_ctnt" readonly id="ndr_ref_pfx_ctnt" /><!--
								--><script type="text/javascript">ComComboObject('exp_ndr_ref_id',3,288,1,0,2);</script></td>
							</tr>
							<tr>
								<th>(Manual Input)</th>
								<td><textarea cols="10" rows="2" style="width:341px;"class="" name="exp_ndr_ref_ctnt" id="exp_ndr_ref_ctnt"></textarea></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</form>
	</div>
	
	<div id="tabLayer" style="display:none">
		<form name="form2" style="margin:0px;">
			<input type="hidden" name="f_cmd" id="f_cmd" />
			<input type="hidden" name="pagerows" id="pagerows" />
			<input type="hidden" name="bkg_no" value="<%=bkg_no%>" id="bkg_no" />
			<input type="hidden" name="io_bnd_cd" value="I" id="io_bnd_cd" />
			<input type="hidden" name="imp_io_bnd_cd" value="I" id="imp_io_bnd_cd" />
			<input type="hidden" name="imp_xpt_imp_seq" value="1" id="imp_xpt_imp_seq" />
			<input type="hidden" name="go_cnt_cd" value="<%=go_cnt_cd%>" id="go_cnt_cd" />
			<input type="hidden" name="pkg_tp" value="<%=pkg_tp%>" id="pkg_tp" />
			<input type="hidden" name="wgt_tp" value="<%=wgt_tp%>" id="wgt_tp" />
	
			<input type="hidden" name="popUpTpCd" value="<%=popUpTpCd%>" id="popUpTpCd" />
			<input type="hidden" name="xter_sndr_id" value="<%=xter_sndr_id%>" id="xter_sndr_id" />
			<input type="hidden" name="xter_rqst_no" value="<%=xter_rqst_no%>" id="xter_rqst_no" />
			<input type="hidden" name="xter_rqst_seq" value="<%=xter_rqst_seq%>" id="xter_rqst_seq" />
			
			<div class="opus_design_btn"><!--
				--><button type="button" class="btn_normal" name="btn_delete2" id="btn_delete2">Delete</button><!--
				--><button type="button" class="btn_normal" name="btn_save2" id="btn_save2">Save</button><!--
				--><button type="button" class="btn_normal" name="btn_close2" id="btn_close2">Close</button>
			</div>
			<div class="opus_design_inquiry">
				<table>
					<colgroup>
						<col width="130" />
						<col width="*" />
					</colgroup>
					<tbody>
						<tr>
							<th>Country</th>
							<td><%=JSPUtil.getCodeCombo("imp_cnt_cd", "CA", "onChange='javascript:goCtnCd(this);'", "CD30017", 0, "")%></td>
						</tr>
					</tbody>
				</table>
				<table class="line_bluedot"><tr><td></td></tr></table>
				<h3 class="title_design">Export Declaration Number for Canadian Customs</h3>
					<table>
						<colgroup>
							<col width="130" />
							<col width="*" />
						</colgroup>
					<tbody>
						<tr>
							<th>Booking No.</th>
							<td><input type="text" name="imp_bkg_no" id="imp_bkg_no" style="width:110px;" class="input2" value="<%=bkg_no%>" readOnly></td>
						</tr>
						<tr>
							<th><input type="checkbox" value="CE" class="trans" name="imp_caed_tp_cd" id="imp_caed_tp_cd" onClick="javascript:radioBtnSet(this)"><label id="CHK11">CAED No.</label></th>
							<td><input type="text" style="width:90px;" class="input2" value=" P.O.R: CAED" name="caed_pfx_ctnt" id="caed_pfx_ctnt" readOnly><!--
							--><input type="text" style="width:248px;" class="input" name="caed_no" id="caed_no" dataformat="eng" maxlength="23" onblur="javascript:ChkComIsCaedNo(this);"></td>
						</tr>
						<tr>
							<th><input type="checkbox" value="G7" class="trans" name="imp_caed_tp_cd"  id="imp_caed_tp_cd" onClick="javascript:radioBtnSet(this)"><label id="CHK12">G7 EDI No.</label></th>
							<td><input type="text" style="width:90px;" class="input2" value=" P.O.R: G7 EDI" name="g7_edi__pfx_ctnt" id="g7_edi__pfx_ctnt" readOnly><!--
							--><input type="text" style="width:248px;" class="input" name="g7_edi_no" id="g7_edi_no" maxlength="17" onblur="javascript:ChkComIsG7EdiNo(this);" dataformat="eng"></td>
						</tr>
						<tr>
							<th><input type="checkbox" value="SM" class="trans" name="imp_caed_tp_cd"  id="imp_caed_tp_cd" onClick="javascript:radioBtnSet(this)"><label id="CHK13">Summary Report</label></th>
							<td><input type="text" style="width:90px;" class="input2" value=" P.O.R: SUM" name="mf_smry_rpt_pfx_ctnt" id="mf_smry_rpt_pfx_ctnt" readOnly><!--
							--><input type="text" style="width:248px;" class="input" name="imp_mf_smry_rpt_no" id="imp_mf_smry_rpt_no" maxlength="4" dataformat="num"></td>
						</tr>
						<tr>
							<th><input type="checkbox" value="EX" class="trans" name="imp_caed_tp_cd" id="imp_caed_tp_cd" id="CHK14" onClick="javascript:radioBtnSet(this)"><label id="CHK14">EXD (Form B13A)</label></th>
							<td><input type="text" style="width:90px;" class="input2" value=" P.O.R: B13A" name="b13a_xpt_pfx_ctnt" id="b13a_xpt_pfx_ctnt" readOnly><!--
							--><input type="text" style="width:248px;" class="input" name="b13a_xpt_no" id="b13a_xpt_no" maxlength="21" onblur="javascript:ChkComIsB13aXptNo(this);" dataformat="eng">
							</td>
						</tr>
						<tr>
							<th><input type="checkbox" value="IT" class="trans" name="imp_caed_tp_cd" id="imp_caed_tp_cd" onClick="javascript:radioBtnSet(this)"><label id="CHK15">In-Transit Cargo</label></th>
							<td><input type="text" style="width:130px;" class="input2" value=" P.O.R: In-Bond Cargo" name="cgo_ctrl_pfx_ctnt" readOnly><!--
							--><input type="text" style="width:208px;" class="input" name="imp_cgo_ctrl_no" maxlength="18"></td>
						</tr>
						<tr>
							<th><input type="checkbox" value="ND" class="trans" name="imp_caed_tp_cd" id="imp_caed_tp_cd" onClick="javascript:radioBtnSet(this)"><label id="CHK16">No Declaration</label></th>
							<td><input type="text" style="width:50px;" class="input2" value=" P.O.R:" name="ndr_ref_pfx_ctnt" id="ndr_ref_pfx_ctnt" readOnly><!--
							--><script type="text/javascript">ComComboObject('imp_ndr_ref_id',3,288,1,0,2);</script></td> 
						</tr>
						<tr>
							<th>(Manual Input)</th>
							<td><textarea cols="10" rows="2" style="width:341px;"class="" name="imp_ndr_ref_ctnt" id="imp_ndr_ref_ctnt"></textarea></td>
						</tr>
					</tbody>
				</table>
			</div>	
		</form>
	</div>
	<!-- wrap_result(S) -->
	<div class="wrap_result">
		<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
			<script type="text/javascript">ComSheetObject('sheet2');</script>
		</div>
	</div>
</div>
</div>
<form name="form3">
<input type="hidden" name="pol_cd" value="<%=pol_cd%>" id="pol_cd" />
<input type="hidden" name="pod_cd" value="<%=pod_cd%>" id="pod_cd" />
<input type="hidden" name="bkg_no" value="<%=bkg_no%>" id="bkg_no" />
<input type="hidden" name="get_io_bnd_cd" value="<%=io_bnd_cd%>" id="get_io_bnd_cd" />
<input type="hidden" name="pkg_qty" value="<%=pkg_qty%>" id="pkg_qty" />
<input type="hidden" name="wgt_qty" value="<%=wgt_qty%>" id="wgt_qty" />
<input type="hidden" name="pkg_tp" value="<%=pkg_tp%>" id="pkg_tp" />
<input type="hidden" name="wgt_tp" value="<%=wgt_tp%>" id="wgt_tp" />
<input type="hidden" name="popUpTpCd" value="<%=popUpTpCd%>" id="popUpTpCd" />
<input type="hidden" name="xter_sndr_id" value="<%=xter_sndr_id%>" id="xter_sndr_id" />
<input type="hidden" name="xter_rqst_no" value="<%=xter_rqst_no%>" id="xter_rqst_no" />
<input type="hidden" name="xter_rqst_seq" value="<%=xter_rqst_seq%>" id="xter_rqst_seq" />
</form>
<form name="form4">
<input type="hidden" name="tabclosechk">
<input type="hidden" name="savechk">
</form>
<form name="urlForm"></form>

