<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0361_01.jsp
*@FileTitle  : Export / Import Information (USA)
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
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

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

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<span>Export / Import Information</span>
	</h2>
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<div class="opus_design_tab">
		<script >ComTabObject('tab1')</script>
	</div>
	<div id="tabLayer" style="display:inline">
		<form name="form" style="margin: 0px;">
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
		
		<div class="opus_design_btn">
		 	<button type="button" class="btn_normal" name="btn_delete" id="btn_delete">Delete</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
	<div class= "wrap_search">
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="130" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<th>Country</th>
						<td><%=JSPUtil.getCodeCombo("exp_cnt_cd", "US", "onChange='javascript:goCtnCd(this);'", "CD20055", 0, "")%></td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="opus_design_inquiry">
		<h3 class="title_design">Automated Export System Internal Transaction Number (for USA)</h3>
			<table>
				<colgroup>
					<col width="130" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<th>Booking No.</th>
						<td><input type="text" name="exp_bkg_no" style="width:110px;" class="input2" value="<%=bkg_no%>" readOnly></td>
					</tr>
					<tr>
						<th><input type="checkbox" value="AE" class="trans" name="exp_aes_tp_cd" id="CHK01" onClick="javascript:radioBtnSet(this)"><label id="CHK01">AES (AES ITN)</label></th>
						<td><input type="text" style="width:90px;" class="input2" value="AES ITN" name="aes_inlnd_trns_pfx_ctnt" readOnly><input type="text" style="width:183px;" class="input" size="15" value="" name="exp_aes_inlnd_trns_no"  maxlength="15"></td>
						<td class="stm">
							<input type="checkbox" name="exp_cpy_desc_flg" class="trans" id="CHK11" value="Y" onClick="javascript:copyToDesc(this);"><label id="CHK11">Copy to Description</label>
						</td>
					</tr>
					<tr>
						<th><input type="checkbox" value="PA" class="trans" name="exp_aes_tp_cd" id="CHK02" onClick="javascript:radioBtnSet(this)"><label id="CHK02">PTA (Post Agent)</label></th>
						<td><input type="text" style="width:91px;" class="input2" value="AESPOST" name="aes_pta_pfx_ctnt" readonly id="aes_pta_pfx_ctnt" /><!--
						--><input type="text" style="width:90px;" class="input" minlength="9" maxlength="11" name="exp_aes_pta_no1" id="exp_aes_pta_no1"  dataformat="num"/ ><!--
						--><input type="text" style="width:90;" class="input" minlength="9" maxlength="11" name="exp_aes_pta_no2" id="exp_aes_pta_no2" dataformat="num"><!--
						--><input type="text" style="width:75px;" class="input" name="exp_aes_pta_dt" maxlength="8" id="exp_aes_pta_dt" /></td>
					</tr>
					<tr>
						<th><input type="checkbox" value="PU" class="trans" name="exp_aes_tp_cd" id="CHK03" onClick="javascript:radioBtnSet(this)"><label id="CHK03">PTU (Post USPPI)</label></th>
						<td><input type="text" style="width:90px;" class="input2" value="AESPOST" name="aes_ptu_pfx_ctnt" readonly id="aes_ptu_pfx_ctnt" /><!--
						--><input type="text" style="width:90px;" class="input" minlength="9" maxlength="11" name="exp_aes_ptu_no" id="exp_aes_ptu_no"  dataformat="num"/><!--
						--><input type="text" style="width:75px;" class="input" name="exp_aes_ptu_dt" maxlength="8" id="exp_aes_ptu_dt" /></td>
					</tr>
					<tr>
						<th><input type="checkbox" value="DN" class="trans" name="exp_aes_tp_cd" id="CHK04" onClick="javascript:radioBtnSet(this)"><label id="CHK04">Down(AES Down)</label></th>
						<td><input type="text" style="width:90px;" class="input2" value="AESDOWN" name="aes_dwn_pfx_ctnt" readonly id="aes_dwn_pfx_ctnt" /><!--
						--><input type="text" style="width:90px;" class="input" minlength="9" maxlength="11" name="exp_aes_dwn_no" id="exp_aes_dwn_no"  dataformat="num" /><!--
						--><input type="text" style="width:75px;" class="input" name="exp_aes_dwn_dt" maxlength="8" id="exp_aes_dwn_dt" /><!--
						--></td>
					</tr>
					<tr>
						<th><input type="checkbox" value="EX" class="trans" name="exp_aes_tp_cd" id="CHK05" onClick="javascript:radioBtnSet(this)"><label id="CHK05">Exception</label></th>
						<td  style="padding-left:4"><script type="text/javascript">ComComboObject("exp_aes_expt_id", 1, 278, 1);</script></td>
					</tr>
					<tr class="smt">
						<th style="text-align:right">(Manual Input)</th>
						<td><textarea cols="10" rows="2" style="width:375px;" class="" name="exp_aes_expt_ctnt" maxlength="30"></textarea></td>
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

<div class="opus_design_btn">
 	<button type="button" class="btn_normal" name="btn_delete2" id="btn_delete2">Delete</button><!-- 
	 --><button type="button" class="btn_normal" name="btn_save2" id="btn_save2">Save</button><!-- 
	 --><button type="button" class="btn_normal" name="btn_close2" id="btn_close2">Close</button>
</div>
<div class= "wrap_search">
		<div class="opus_design_inquiry wFit">
		
			<table>
				<colgroup>
					<col width="130" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<th>Country</th>
						<td>
							<%=JSPUtil.getCodeCombo("imp_cnt_cd", "US", "onChange='javascript:goCtnCd(this);'", "CD30017", 0, "")%>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="opus_design_inquiry wFit">
		<h3 class="title_design">Automated Export System Internal Transaction Number (for USA)</h3>
			<table>
			<colgroup>
					<col width="130" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<th>Booking No.</th>
						<td><input type="text" name="imp_bkg_no" style="width:110px;" class="input2" value="<%=bkg_no%>" readonly id="imp_bkg_no" /> </td>
					</tr>
					<tr>
						<th><input type="checkbox" value="AE" class="trans" name="imp_aes_tp_cd" id="CHK06" onClick="javascript:radioBtnSet(this)"><label id="CHK06">AES (AES ITN)</label></th>
						<td><input type="text" style="width:90px;" class="input2" value="AES ITN" name="aes_inlnd_trns_pfx_ctnt" id="aes_inlnd_trns_pfx_ctnt" readOnly><input type="text" style="width:183px;" class="input" size="15" value="" name="imp_aes_inlnd_trns_no" maxlength="15" id="imp_aes_inlnd_trns_no" /></td>
					</tr>
					<tr>
						<th><input type="checkbox" value="PA" class="trans" name="imp_aes_tp_cd"  id="CHK07" onClick="javascript:radioBtnSet(this)"><label id="CHK07">PTA (Post Agent)</label></th>
						<td><input type="text" style="width:91px;" class="input2" value="AESPOST" name="aes_pta_pfx_ctnt" readonly id="aes_pta_pfx_ctnt" /><!--
						--><input type="text" style="width:90px;" class="input" minlength="9" maxlength="11" name="imp_aes_pta_no1" id="imp_aes_pta_no1"  dataformat="num"/><!--
						--><input type="text" style="width:90px;" class="input" minlength="9" maxlength="11" name="imp_aes_pta_no2" id="imp_aes_pta_no2"  dataformat="num"/><!--
						--><input type="text" style="width:72px;" class="input" name="imp_aes_pta_dt" maxlength="8" id="imp_aes_pta_dt" /></td>
					</tr>
					<tr>
						<th><input type="checkbox" value="PU" class="trans" name="imp_aes_tp_cd"  id="CHK08" onClick="javascript:radioBtnSet(this)"><label id="CHK08">PTU (Post USPPI)</label></th>
						<td><input type="text" style="width:90px;" class="input2" value="AESPOST" name="aes_ptu_pfx_ctnt" readonly id="aes_ptu_pfx_ctnt" /><!--
						--><input type="text" style="width:90px;" class="input" minlength="9" maxlength="11" name="imp_aes_ptu_no" id="imp_aes_ptu_no"  dataformat="num"/><!--
						--><input type="text" style="width:72px;" class="input" name="imp_aes_ptu_dt" maxlength="8" id="imp_aes_ptu_dt" /></td>
					</tr>
					<tr>
						<th><input type="checkbox" value="DN" class="trans" name="imp_aes_tp_cd" id="CHK09" onClick="javascript:radioBtnSet(this)"><label id="CHK09">Down (AES Down)</label></th>
						<td><input type="text" style="width:90px;" class="input2" value="AESDOWN" name="aes_dwn_pfx_ctnt" readonly id="aes_dwn_pfx_ctnt" /><!--
						--><input type="text" style="width:90px;" class="input" minlength="9" maxlength="11" name="imp_aes_dwn_no" id="imp_aes_dwn_no"  dataformat="num"/><!--
						--><input type="text" style="width:72px;" class="input" name="imp_aes_dwn_dt" maxlength="8" id="imp_aes_dwn_dt" /></td>
					</tr>
					<tr>
						<th><input type="checkbox" value="EX" class="trans" name="imp_aes_tp_cd" id="CHK10" onClick="javascript:radioBtnSet(this)"><label id="CHK10">Exception</label></th>
						<td style="padding-left:4"><script type="text/javascript">ComComboObject("imp_aes_expt_id", 1, 278, 1);</script></td>
					</tr>
					<tr>
					<th>(Manual Input)</th>
					<td><textarea cols="10" rows="2" style="width:375px;" class="" name="imp_aes_expt_ctnt" id="imp_aes_expt_ctnt" maxlength="30"></textarea></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</form>
</div>
<!--TAB Import (E) -->
</div>
<div class="wrap_result">
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet2');</script>
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