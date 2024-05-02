<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0229_04.jsp
*@FileTitle  : e-Booking & SI Process Detail(M&D)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/05
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkg022904Event"%>
<%@ page import="com.clt.apps.opus.esm.bkg.common.*" %>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO" %>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.*" %>
<%@ page import="com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.MndVO" %>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.core.controller.DefaultViewAdapter" %>
<%@ page import="java.util.List" %>

<%
	EsmBkg022904Event event = null;			//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	String sXml = "";

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.clt.apps.EBookingConduct.EBookingReceipt");

	List<BkgComboVO> wgt_cd = null;
	List<BkgComboVO> meas_cd = null;
	MndVO opusMndVO = null;
	List<XterMndVO> xterMndList = null;
	XterMndVO xterMndVO = null;
	List<XterInnerPackageVO> xterInnerPackageVO = null;
	XterXptLicVO xterXptLicVO = null;

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg022904Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		DefaultViewAdapter adapter = new DefaultViewAdapter();
		sXml = adapter.makeXML(request, response);

		ExternalRqstMndVO rqstMndVo = (ExternalRqstMndVO) eventResponse.getCustomData("externalRqstMndVO");
		opusMndVO = (MndVO) eventResponse.getCustomData("MndVO");
		xterMndList = rqstMndVo.getXterMndVO();
		xterXptLicVO = rqstMndVo.getXterXptLicVO();
		if (null!= xterMndList && xterMndList.size() > 0) xterMndVO = (XterMndVO) xterMndList.get(0);

		wgt_cd = (List<BkgComboVO>) eventResponse.getCustomData("wgt_cd");
		meas_cd = (List<BkgComboVO>) eventResponse.getCustomData("meas_cd");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<style type="text/css">
	.specialCls {
		float: right;
	}
	.specialCls:after {
		display: block;
		content: " ";
		clear: both;
	}
</style>
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="rqst_seq" id="rqst_seq" value="<%=StringUtil.xssFilter(request.getParameter("rqst_seq"))%>">
<input type="hidden" name="sender_id" id="sender_id" value="<%=StringUtil.xssFilter(request.getParameter("sender_id"))%>">
<input type="hidden" name="mnd_opus" id="mnd_opus" value="<%=(opusMndVO==null)?"Y":"N"%>">
<input type="hidden" name="mnd_esvc" id="mnd_esvc" value="<%=(null!=xterMndList && xterMndList.size() > 0)?"Y":"N"%>">

<input type="hidden" name="bdr_flg" id="bdr_flg">
<input type="hidden" name="sXml" id="sXml" value="<%=JSPUtil.replace(sXml, "\"", "&quot;")%>">
<input type="hidden" name="cstms_clr_cd" id="cstms_clr_cd">
<input type="hidden" name="cntr_desc" id="cntr_desc" value="<%=null!=opusMndVO ? replaceNull(opusMndVO.getCntrDesc()) : ""%>">
<input type="hidden" name="rc_flg" id="rc_flg">
<input type="hidden" name="xpt_imp_seq" id="xpt_imp_seq" value="1">
<input type="hidden" name="po_cust_flag" id="po_cust_flag" value="<%=null!=opusMndVO ? replaceNull(opusMndVO.getPoCustFlag()) : ""%>">
<input type="hidden" name="po_ref_flag" id="po_ref_flag" value="<%=null!=opusMndVO ? replaceNull(opusMndVO.getPoRefFlag()) : ""%>">
<input type="hidden" name="po_ref_dtl_flag" id="po_ref_dtl_flag" value="<%=null!=opusMndVO ? replaceNull(opusMndVO.getPoRefDtlFlag()) : ""%>">
<input type="hidden" name="obl_iss_flg" id="obl_iss_flg">
<input type="hidden" name="xpt_imp2" id="xpt_imp2" value="<%=null!=opusMndVO ? replaceNull(xterMndVO.getXptImp()) : ""%>">
<input type="hidden" name="po_no2" id="po_no2" value="<%=null!=opusMndVO ? replaceNull(xterMndVO.getPoNo()) : ""%>">
<input type="hidden" name="misc2" id="misc2" value="<%=null!=opusMndVO ? replaceNull(xterMndVO.getMisc()) : ""%>">
<input type="hidden" name="rider2" id="rider2" value="<%=null!=opusMndVO ? replaceNull(xterMndVO.getRider()) : ""%>">

<input type="hidden" name="brz_decl_no" >
<input type="hidden" name="brz_decl_cpy_desc_flg" >
<input type="hidden" name="shpr_tax_cpy_desc_flg" >
<input type="hidden" name="ntfy_tax_cpy_desc_flg" >
<input type="hidden" name="cnee_tax_cpy_desc_flg" >

<!-- eSvc Misc.Information btn click -->
<div id="showMisc" style="position:absolute;visibility:hidden;z-index:1;margin-top:364px;margin-left:774px;border:solid;border-color:#b8d6f6">
	<table class="sm">
		<tr>
		    <td><textarea name="misc_desc" id="misc_desc" cols="45" rows="7" class="textarea" readOnly><%=null!=opusMndVO ? replaceNull(xterMndVO.getMiscDesc()) : ""%></textarea></td>				
	  	</tr>			
	</table>
</div>

<div id="showXptLicNo" style="position:absolute; visibility:hidden;z-index:1;margin-top:64px; margin-left:6px; height:450px; width:567px;overflow-y:scroll;border:solid;border-color:#b8d6f6">
	<div class="wrap_search sm">
		<div class="opus_design_inquiry">
			<table>
				<tr>
					<td><input type="text"  style="width:60px;" class="input2" value="USA"></td>
				</tr>
			</table>
			<table>
				<colgroup>
					<col width="150"/>
					<col width="90"/>
					<col width="90"/>
					<col width="90"/>
					<col width="*" />				
				</colgroup> 
				<tr>
					<td><input type="checkbox" value="AE" class="trans" name="aes_tp_cd" onClick="javascript:radioBtnSet(this)">&nbsp;AES (AES ITN)</td>
					<td><input type="text" style="width:90px;" class="input2" value="AES ITN" name="aes_inlnd_trns_pfx_ctnt" readOnly></td>
					<td colspan="3"><input type="text" style="width:183px;" class="input" size="15" value="" name="aes_inlnd_trns_no" dataformat="exceptengdn" maxlength="15"></td>
				</tr>
				<tr>
					<td><input type="checkbox" value="PA" class="trans" name="aes_tp_cd" onClick="javascript:radioBtnSet(this)">&nbsp;PTA (Post Agent)</td>
					<td><input type="text" style="width:90px;" class="input2" value="AESPOST" name="aes_pta_pfx_ctnt" readOnly></td>
					<td><input type="text" style="width:90px;" class="input" minlength="9" maxlength="11" name="aes_pta_no1" dataformat="num"></td>
					<td><input type="text" style="width:90px;" class="input" minlength="9" maxlength="11" name="aes_pta_no2" dataformat="num"></td>
					<td><input type="text" style="width:72px;" class="input" name="aes_pta_dt" dataformat="mdy" maxlength="8" ></td>
				</tr>	
				<tr>
					<td><input type="checkbox" value="PU" class="trans" name="aes_tp_cd" onClick="javascript:radioBtnSet(this)">&nbsp;PTU (Post USPPI)</td>
					<td><input type="text" style="width:90px;" class="input2" value="AESPOST" name="aes_ptu_pfx_ctnt" readOnly></td>
					<td><input type="text" style="width:90px;" class="input" minlength="9" maxlength="11" name="aes_ptu_no" dataformat="num"></td>
					<td colspan="2"><input type="text" style="width:72px;" class="input" name="aes_ptu_dt" dataformat="mdy" maxlength="8">&nbsp;</td>
				</tr>
				<tr>
					<td><input type="checkbox" value="DN" class="trans" name="aes_tp_cd" onClick="javascript:radioBtnSet(this)">&nbsp;Down (AES Down)</td>
					<td><input type="text" style="width:90px;" class="input2" value="AESDOWN" name="aes_dwn_pfx_ctnt" readOnly></td>
					<td><input type="text" style="width:90px;" class="input" minlength="9" maxlength="11" name="aes_dwn_no" dataformat="num"></td>
					<td colspan="2"><input type="text" style="width:72px;" class="input" name="aes_dwn_dt" dataformat="mdy" maxlength="8">&nbsp;</td>
				</tr>
				<tr>
					<td><input type="checkbox" value="EX" class="trans" name="aes_tp_cd" onClick="javascript:radioBtnSet(this)">Exception</td>
					<td colspan="4"><script type="text/javascript">ComComboObject("aes_expt_id", 1, 278, 1);</script></td>
				</tr>
				<tr>
					<th>(Manual Input)</th>
					<td colspan="4"><textarea cols="10" rows="2" style="width:370px;resize:none" class="" name="aes_expt_ctnt" id="aes_expt_ctnt maxlength="30"></textarea></td>
				</tr>
			</table>
			<table>
				<tr>
					<td><input type="text"  style="width:60px;" class="input2" value="Canada"></td>
				</tr>
			</table>
			<table>
				<colgroup>
					<col width="150"/>
					<col width="*" />				
				</colgroup>
				<tr>
					<td><input type="checkbox" value="CE" class="trans" name="caed_tp_cd" onClick="javascript:radioBtnSet(this)">CAED No.</td>
					<td><input type="text" style="width:90px" class="input2" value=" P.O.R: CAED" name="caed_pfx_ctnt" readOnly><input type="text" style="width:248px;" class="input" name="caed_ctnt" dataformat="exceptengdn" maxlength="23" onblur="javascript:ChkComIsCaedNo(this);"></td>
				</tr>
				<tr>
					<td><input type="checkbox" value="G7" class="trans" name="caed_tp_cd" onClick="javascript:radioBtnSet(this)">G7 EDI No.</td>
					<td><input type="text" style="width:90px;" class="input2" value=" P.O.R: G7 EDI" name="g7_edi_pfx_ctnt" readOnly><input type="text" style="width:248px;" class="input" name="g7_edi_ctnt" dataformat="exceptengdn" maxlength="17" onblur="javascript:ChkComIsG7EdiNo(this);"></td>
				</tr>
				<tr>
					<td><input type="checkbox" value="SM" class="trans" name="caed_tp_cd" onClick="javascript:radioBtnSet(this)">Summary Report</td>
		 			<td><input type="text" style="width:90px;" class="input2" value=" P.O.R: SUM" name="mf_smry_rpt_pfx_ctnt" readOnly><input type="text" style="width:248px;" class="input" name="mf_smry_rpt_no" maxlength="4" dataformat="num"></td> 
				</tr>
				<tr>
					<td><input type="checkbox" value="EX" class="trans" name="caed_tp_cd" onClick="javascript:radioBtnSet(this)">EXD (Form B13A)</td>
					<td><input type="text" style="width:90px;" class="input2" value=" P.O.R: B13A" name="b13a_xpt_pfx_ctnt" readOnly><input type="text" style="width:248px;" class="input" name="b13a_xpt_ctnt" dataformat="exceptengdn" maxlength="21" onblur="javascript:ChkComIsB13aXptNo(this);"></td>
				</tr>
				<tr>
					<td><input type="checkbox" value="IT" class="trans" name="caed_tp_cd" onClick="javascript:radioBtnSet(this)">In-Transit Cargo</td>
					<td><input type="text" style="width:130px;" class="input2" value=" P.O.R: In-Bond Cargo" name="cgo_ctrl_pfx_ctnt" readOnly><input type="text" style="width:208px;" class="input" name="cgo_ctrl_no" maxlength="18"></td>
				</tr>
				<tr>
					<td><input type="checkbox" value="ND" class="trans" name="caed_tp_cd" onClick="javascript:radioBtnSet(this)">No Declaration</td>
					<td style="padding-left:0"><input type="text" style="width:50px;" class="input2" value=" P.O.R:" name="ndr_ref_pfx_ctnt" readOnly><script type="text/javascript">ComComboObject('ndr_ref_id',3,288,1,0,2);</script></td>
				</tr>
				<tr>
					<th>(Manual Input)</th>
					<td><textarea cols="10" rows="2" style="width:341px;"class="" name="ndr_ref_ctnt" id="ndr_ref_ctnt"></textarea></td>
				</tr>
			</table>
			<table>
				<tr>
					<td><input type="text"  style="width:60px;" class="input2" value="Mexico"></td>
				</tr>
			</table>
			<table>
				<colgroup>
					<col width="120"/>
					<col width="*" />				
				</colgroup>
				<tr>
					<th>Shipper Tax ID</th>
					<td><input type="text" style="width:200px;" class="input" name="mx_shpr_tax_id" dataformat="engup"  maxlength="20" value=""></td>
				</tr>
				<tr>
					<th>Consignee Tax ID</th>
					<td><input type="text" style="width:200px;" class="input" name="mx_cnee_tax_id" dataformat="engup"  maxlength="20" value=""></td>
				</tr>
				<tr>
					<th>Notify Tax ID</th>
					<td><input type="text" style="width:200px;" class="input" name="mx_ntfy_tax_id" dataformat="engup"  maxlength="20" value=""></td>
				</tr>
			</table>
			<!-- Turkey, Israel, Lebanon, Brazil -->
			<table style="display: none;">
				<tr>
					<td><input type="text"  style="width:60px;" class="input2" value="Turkey"></td>
				</tr>
			</table>
			<table style="display: none;">
				<colgroup>
					<col width="120"/>
					<col width="*" />				
				</colgroup>
				<tr>
					<th>Shipper Tax ID</th>
					<td><input type="text" style="width:200px;" class="input" name="tr_shpr_tax_id" dataformat="engup"  maxlength="20" value=""></td>
				</tr>
				<tr>
					<th>Consignee Tax ID</th>
					<td><input type="text" style="width:200px;" class="input" name="tr_cnee_tax_id" dataformat="engup"  maxlength="20" value=""></td>
				</tr>
				<tr>
					<th>Notify Tax ID</th>
					<td><input type="text" style="width:200px;" class="input" name="tr_ntfy_tax_id" dataformat="engup"  maxlength="20" value=""></td>
				</tr>
			</table>
			<table>
				<tr>
					<td><input type="text"  style="width:60px;" class="input2" value="Israel"></td>
				</tr>
			</table>
			<table>
				<colgroup>
					<col width="120"/>
					<col width="*" />				
				</colgroup>
				<tr>
					<th>Shipper VAT ID</th>
					<td><input type="text" style="width:200px;" class="input" name="il_shpr_tax_id" dataformat="engup"  maxlength="20" value=""></td>
				</tr>
				<tr>
					<th>Consignee VAT ID</th>
					<td><input type="text" style="width:200px;" class="input" name="il_cnee_tax_id" dataformat="engup"  maxlength="20" value=""></td>
				</tr>
				<tr>
					<th>Notify VAT ID</th>
					<td><input type="text" style="width:200px;" class="input" name="il_ntfy_tax_id" dataformat="engup"  maxlength="20" value=""></td>
				</tr>
			</table>
			<table>
				<tr>
					<td><input type="text"  style="width:60px;" class="input2" value="Lebanon"></td>
				</tr>
			</table>
			<table>
				<colgroup>
					<col width="120"/>
					<col width="*" />				
				</colgroup>
				<tr>
					<th>Shipper VAT ID</th>
					<td><input type="text" style="width:200px;" class="input" name="lb_shpr_tax_id" dataformat="engup"  maxlength="20" value=""></td>
				</tr>
				<tr>
					<th>Consignee VAT ID</th>
					<td><input type="text" style="width:200px;" class="input" name="lb_cnee_tax_id" dataformat="engup"  maxlength="20" value=""></td>
				</tr>
				<tr>
					<th>Notify VAT ID</th>
					<td><input type="text" style="width:200px;" class="input" name="lb_ntfy_tax_id" dataformat="engup"  maxlength="20" value=""></td>
				</tr>
			</table>
			<table>
				<tr>
					<td><input type="text"  style="width:60px;" class="input2" value="Brazil"></td>
				</tr>
			</table>
			<table>
				<colgroup>
					<col width="120"/>
					<col width="*" />				
				</colgroup>
				<tr>
					<th>Shipper CNPJ</th>
					<td><input type="text" style="width:200px;" class="input" name="br_shpr_tax_id" dataformat="engup"  maxlength="20" value=""></td>
				</tr>
				<tr>
					<th>Consignee CNPJ</th>
					<td><input type="text" style="width:200px;" class="input" name="br_cnee_tax_id" dataformat="engup"  maxlength="20" value=""></td>
				</tr>
				<tr>
					<th>Notify CNPJ</th>
					<td><input type="text" style="width:200px;" class="input" name="br_ntfy_tax_id" dataformat="engup"  maxlength="20" value=""></td>
				</tr>
			</table>
			<table>
				<tr>
					<td><input type="text"  style="width:60px;" class="input2" value="Korea"></td>
				</tr>
			</table>
			<table>
				<tr>
					<td>
						<div class="opus_design_grid" style="width:500px">	
							<div class="opus_design_btn"><!-- 
								--><button type="button" id="btn_krRowAdd" name="btn_krRowAdd" class="btn_accent">Row Add</button><!--
								--><button type="button" id="btn_krRowDelete" name="btn_krRowDelete" class="btn_normal">Delete</button><!--
							--></div>
							<script type="text/javascript">ComSheetObject('div1sheet1');</script>		
						</div>
					</td>
				</tr>
			</table>
		</div>
	</div>
</div>

<div id="showXptLicNo2" style="position:absolute; visibility:hidden; z-index:1;margin-top:225px; margin-left:615px; height:250px; width:567px;overflow-y:scroll;border:solid;border-color:#b8d6f6">
	<div class="wrap_search sm">
		<div class="opus_design_inquiry">
			<table>
				<tr>
					<td border="1"><input type="text"  style="width:60px;" class="input2" value="USA"></td>
				</tr>
			</table>
			<table>
				<colgroup>
					<col width="150"/>
					<col width="90"/>
					<col width="90"/>
					<col width="90"/>
					<col width="*" />				
				</colgroup> 
				<tr>
					<th>AES (AES ITN)</th>
					<td><input type="text" style="width:90px;" class="input2" value="AES ITN" name="aes_inlnd_trns_pfx_ctnt2" readOnly></td>
					<td colspan="3"><input type="text" style="width:183px;" class="input2" size="15" value="<%=null!=xterXptLicVO ? xterXptLicVO.getAesInlndTrnsNo2() : ""%>" name="aes_inlnd_trns_no2" dataformat="exceptengdn" maxlength="15"></td>
				</tr>
				<tr>
					<th>PTA (Post Agent)</th>
					<td><input type="text" style="width:90px;" class="input2" value="AESPOST" name="aes_pta_pfx_ctnt2" readOnly></td>
					<td><input type="text" style="width:90px;" class="input2" minlength="9" maxlength="11" value="<%=null!=xterXptLicVO ? xterXptLicVO.getAesPtaNo12() : ""%>" name="aes_pta_no12" dataformat="num"></td>
					<td><input type="text" style="width:90px;" class="input2" minlength="9" maxlength="11" value="<%=null!=xterXptLicVO ? xterXptLicVO.getAesPtaNo22() : ""%>" name="aes_pta_no22" dataformat="num"></td>
					<td><input type="text" style="width:72px;" class="input2" value="<%=null!=xterXptLicVO ? xterXptLicVO.getAesPtaDt2() : ""%>" name="aes_pta_dt2" dataformat="mdy" maxlength="8" ></td>
				</tr>
				<tr>
					<th>PTU (Post USPPI)</th>
					<td><input type="text" style="width:90px;" class="input2" value="AESPOST" name="aes_ptu_pfx_ctnt2" readOnly></td>
					<td><input type="text" style="width:90px;" class="input2" minlength="9" maxlength="11" value="<%=null!=xterXptLicVO ? xterXptLicVO.getAesPtuNo2() : ""%>" name="aes_ptu_no2" dataformat="num"></td>
					<td colspan="2"><input type="text" style="width:72px;" class="input2" value="<%=null!=xterXptLicVO ? xterXptLicVO.getAesPtuDt2() : ""%>" name="aes_ptu_dt2" dataformat="mdy" maxlength="8"></td>
				</tr>
				<tr>
					<th>Down (AES Down)</th>
					<td><input type="text" style="width:90px;" class="input2" value="AESDOWN" name="aes_dwn_pfx_ctnt2" readOnly></td>
					<td><input type="text" style="width:90px;" class="input2" minlength="9" maxlength="11" value="<%=null!=xterXptLicVO ? xterXptLicVO.getAesDwnNo2() : ""%>" name="aes_dwn_no2" dataformat="num"></td>
					<td colspan="2"><input type="text" style="width:72px;" class="input2" value="<%=null!=xterXptLicVO ? xterXptLicVO.getAesDwnDt2() : ""%>" name="aes_dwn_dt2" dataformat="mdy" maxlength="8"></td>
				</tr>
				<tr>
					<th>Exception</th>
					<td colspan="4"><input type="text" style="width:278px;" value="<%=null!=xterXptLicVO ? xterXptLicVO.getAesExptId2() : ""%>" class="input2" name="aes_expt_id2"></td>
				</tr>					
			</table>
			<table>
				<tr>
					<td border="1"><input type="text"  style="width:60px;" class="input2" value="Canada"></td>
				</tr>
			</table>	
			<table>
				<colgroup>
					<col width="150"/>
					<col width="*" />				
				</colgroup> 
				<tr>
					<th>CAED No.</th>
					<td><input type="text" style="width:90px;" class="input2" value=" P.O.R: CAED" name="caed_pfx_ctnt2" readOnly><input type="text" style="width:248px;" class="input2" value="<%=null!=xterXptLicVO ? xterXptLicVO.getCaedCtnt2() : ""%>" name="caed_ctnt2" dataformat="" maxlength="23" ></td>
				</tr>
				<tr>
					<th>G7 EDI No.</th>
					<td><input type="text" style="width:90px;" class="input2" value=" P.O.R: G7 EDI" name="g7_edi_pfx_ctnt2" readOnly><input type="text" style="width:248px;" class="input2" value="<%=null!=xterXptLicVO ? xterXptLicVO.getG7EdiNo2() : ""%>" name="g7_edi_no2" dataformat="" maxlength="17"></td>
				</tr>
				<tr>
					<th>Summary Report</th>
		 			<td><input type="text" style="width:90px;" class="input2" value=" P.O.R: SUM" name="mf_smry_rpt_pfx_ctnt2" readOnly><input type="text" style="width:248px;" class="input2" value="<%=null!=xterXptLicVO ? xterXptLicVO.getSmryRptCtnt2() : ""%>" name="mf_smry_rpt_ctnt2" maxlength="4" dataformat="num"></td> 
				</tr>
				<tr>
					<th>EXD (Form B13A)</th>
					<td><input type="text" style="width:90px;" class="input2" value=" P.O.R: B13A" name="b13a_xpt_pfx_ctnt" readOnly><input type="text" style="width:248px;" class="input2" value="<%=null!=xterXptLicVO ? xterXptLicVO.getB13aCtnt2() : ""%>" name="b13a_xpt_ctnt2" dataformat="" maxlength="21"></td>
				</tr>
				<tr>
					<th>In-Transit Cargo</th>
					<td><input type="text" style="width:130px;" class="input2" value=" P.O.R: In-Bond Cargo" name="cgo_ctrl_pfx_ctnt2" readOnly><input type="text" style="width:208px;" class="input2" value="<%=null!=xterXptLicVO ? xterXptLicVO.getInlndTzCgoCtnt2() : ""%>" name="cgo_ctrl_no2" maxlength="18"></td>
				</tr>
				<tr>
					<th>No Declaration</th>
					<td><input type="text" style="width:50px;" class="input2" value=" P.O.R:" name="ndr_ref_pfx_ctnt2" readOnly><input type="text" style="width:288px;" class="input2" value="<%=null!=xterXptLicVO ? xterXptLicVO.getNonDeclCtnt2() : ""%>" name="ndr_ref_id2"></td>
				</tr>
				<tr>
					<th>(Manual Input)</th>
					<td colspan="4"><input type="text" style="width:341px;" value="<%=null!=xterXptLicVO ? xterXptLicVO.getMnlInpCtnt2() : ""%>" class="input2" name="ndr_ref_ctnt2" ></td>
				</tr>
			</table>					
			<table>
				<tr>
					<td><input type="text"  style="width:60px;" class="input2" value="Mexico"></td>
				</tr>
			</table>
			<table>
				<colgroup>
					<col width="120"/>
					<col width="*" />				
				</colgroup>
				<tr>
					<th>Shipper Tax ID</th>
					<td><input type="text" style="width:200px;" class="input" value="<%=null!=xterXptLicVO ? xterXptLicVO.getShprTaxNo2() : ""%>" name="mx_shpr_tax_id2" dataformat="engup"  maxlength="20" value=""></td>
				</tr>
				<tr>
					<th>Consignee Tax ID</th>
					<td><input type="text" style="width:200px;" class="input" value="<%=null!=xterXptLicVO ? xterXptLicVO.getCneeTaxNo2() : ""%>" name="mx_cnee_tax_id2" dataformat="engup"  maxlength="20" value=""></td>
				</tr>
				<tr>
					<th>Notify Tax ID</th>
					<td><input type="text" style="width:200px;" class="input" value="<%=null!=xterXptLicVO ? xterXptLicVO.getNtfyTaxNo2() : ""%>" name="mx_ntfy_tax_id2" dataformat="engup"  maxlength="20" value=""></td>
				</tr>				
			</table>
			<!-- Turkey, Israel, Lebanon, Brazil -->
			<table style="display: none;">
				<tr>
					<td><input type="text"  style="width:60px;" class="input2" value="Turkey"></td>
				</tr>
			</table>
			<table style="display: none;">
				<colgroup>
					<col width="120"/>
					<col width="*" />				
				</colgroup>
				<tr>
					<th>Shipper Tax ID</th>
					<td><input type="text" style="width:200px;" class="input" value="<%=null!=xterXptLicVO ? xterXptLicVO.getTrShprTaxId() : ""%>" name="tr_shpr_tax_id2" dataformat="engup"  maxlength="20" value=""></td>
				</tr>
				<tr>
					<th>Consignee Tax ID</th>
					<td><input type="text" style="width:200px;" class="input" value="<%=null!=xterXptLicVO ? xterXptLicVO.getTrCneeTaxId() : ""%>" name="tr_cnee_tax_id2" dataformat="engup"  maxlength="20" value=""></td>
				</tr>
				<tr>
					<th>Notify Tax ID</th>
					<td><input type="text" style="width:200px;" class="input" value="<%=null!=xterXptLicVO ? xterXptLicVO.getTrNtfyTaxId() : ""%>" name="tr_ntfy_tax_id2" dataformat="engup"  maxlength="20" value=""></td>
				</tr>				
			</table>
			<table>
				<tr>
					<td><input type="text"  style="width:60px;" class="input2" value="Israel"></td>
				</tr>
			</table>
			<table>
				<colgroup>
					<col width="120"/>
					<col width="*" />				
				</colgroup>
				<tr>
					<th>Shipper VAT ID</th>
					<td><input type="text" style="width:200px;" class="input" value="<%=null!=xterXptLicVO ? xterXptLicVO.getIlShprTaxId() : ""%>" name="il_shpr_tax_id2" dataformat="engup"  maxlength="20" value=""></td>
				</tr>
				<tr>
					<th>Consignee VAT ID</th>
					<td><input type="text" style="width:200px;" class="input" value="<%=null!=xterXptLicVO ? xterXptLicVO.getIlCneeTaxId() : ""%>" name="il_cnee_tax_id2" dataformat="engup"  maxlength="20" value=""></td>
				</tr>
				<tr>
					<th>Notify VAT ID</th>
					<td><input type="text" style="width:200px;" class="input" value="<%=null!=xterXptLicVO ? xterXptLicVO.getIlNtfyTaxId() : ""%>" name="il_ntfy_tax_id2" dataformat="engup"  maxlength="20" value=""></td>
				</tr>				
			</table>
			<table>
				<tr>
					<td><input type="text"  style="width:60px;" class="input2" value="Lebanon"></td>
				</tr>
			</table>
			<table>
				<colgroup>
					<col width="120"/>
					<col width="*" />				
				</colgroup>
				<tr>
					<th>Shipper VAT ID</th>
					<td><input type="text" style="width:200px;" class="input" value="<%=null!=xterXptLicVO ? xterXptLicVO.getLbShprTaxId() : ""%>" name="lb_shpr_tax_id2" dataformat="engup"  maxlength="20" value=""></td>
				</tr>
				<tr>
					<th>Consignee VAT ID</th>
					<td><input type="text" style="width:200px;" class="input" value="<%=null!=xterXptLicVO ? xterXptLicVO.getLbCneeTaxId() : ""%>" name="lb_cnee_tax_id2" dataformat="engup"  maxlength="20" value=""></td>
				</tr>
				<tr>
					<th>Notify VAT ID</th>
					<td><input type="text" style="width:200px;" class="input" value="<%=null!=xterXptLicVO ? xterXptLicVO.getLbNtfyTaxId() : ""%>" name="lb_ntfy_tax_id2" dataformat="engup"  maxlength="20" value=""></td>
				</tr>				
			</table>
			<table>
				<tr>
					<td><input type="text"  style="width:60px;" class="input2" value="Brazil"></td>
				</tr>
			</table>
			<table>
				<colgroup>
					<col width="120"/>
					<col width="*" />				
				</colgroup>
				<tr>
					<th>Shipper CNPJ</th>
					<td><input type="text" style="width:200px;" class="input" value="<%=null!=xterXptLicVO ? xterXptLicVO.getBrShprTaxId() : ""%>" name="br_shpr_tax_id2" dataformat="engup"  maxlength="20" value=""></td>
				</tr>
				<tr>
					<th>Consignee CNPJ</th>
					<td><input type="text" style="width:200px;" class="input" value="<%=null!=xterXptLicVO ? xterXptLicVO.getBrCneeTaxId() : ""%>" name="br_cnee_tax_id2" dataformat="engup"  maxlength="20" value=""></td>
				</tr>
				<tr>
					<th>Notify CNPJ</th>
					<td><input type="text" style="width:200px;" class="input" value="<%=null!=xterXptLicVO ? xterXptLicVO.getBrNtfyTaxId() : ""%>" name="br_ntfy_tax_id2" dataformat="engup"  maxlength="20" value=""></td>
				</tr>				
			</table>
			<table>
				<tr>
					<td><input type="text"  style="width:60px;" class="input2" value="Korea"></td>
				</tr>
			</table>
			<table>
				<tr>
					<td>
						<div class="opus_design_grid" style="width: 500px">	
							<script type="text/javascript">ComSheetObject('div2sheet1');</script>		
						</div>
					</td>
				</tr>
			</table>
		</div>
	</div>
</div>

<div id="innerPackage" style="position:absolute; visibility:hidden; z-index:1;margin-top:354px;margin-left:774px; height:120px; width:305px ;border:solid;border-color:#b8d6f6">
	<table class="sm">
		<tr>
			<td width="300px">
				<div class="opus_design_grid" id="mainTable" name="mainTable">		
					<script type="text/javascript">ComSheetObject('sheet2');</script>		
				</div>		
			</td>
		</tr>
	</table>
</div>

<div id="poOther" style="position:absolute; visibility:hidden; z-index:1;margin-top:227px; margin-left:6px; height:287px; width:774px;border:solid;border-color:#b8d6f6">	
	<div class="wrap_search sm">
		<div class="opus_design_inquiry">
			<table>
				<colgroup>
					<col width="100"/>
					<col width="90"/>
					<col width="110"/>
					<col width="100"/>
					<col width="90"/>
					<col width="*" />				
				</colgroup>
				<tr>
					<th>P/O No.</th>	
					<td><input type="text" style="width:100px;" class="input" name="bkpo" maxlength="50" value=""></td>		
					<td><input type="checkbox" value="" name='check_bkpo' class="trans" onClick="javascript:copyToDesc(this);">copy to desc </td>						
					<th>L/C No.</th>	
					<td><input type="text" style="width:100px;" class="input" name="lcno" maxlength="50" value=""></td>	
					<td><input type="checkbox" value="" name='check_lcno' class="trans" onClick="javascript:copyToDesc(this);">copy to desc </td>						
				</tr>
				<tr>
					<th>Invoice No.</th>	
					<td><input type="text" style="width:100px;" class="input" name="hinv" maxlength="50" value=""></td>		
					<td><input type="checkbox" value="" name='check_hinv' class="trans" onClick="javascript:copyToDesc(this);">copy to desc </td>						
					<th>L/C Date</th>	
					<td><input type="text" style="width:100px;" class="input" name="lcdt" value="" maxlength="10" dataformat="ymd" style="ime-mode:disabled" caption="L/C Date"  ><button class="calendar ir" name="btn_Calendar" id="btn_Calendar" type="button"></button></td>		
					<td><input type="checkbox" value="" name='check_lcdt' class="trans" onClick="javascript:copyToDesc(this);">copy to desc </td>						
				</tr>
				<tr>
					<th>Department No.</th>	
					<td><input type="text" style="width:100px;" class="input" name="hpdp" maxlength="50" value=""></td>		
					<td><input type="checkbox" value="" name='check_hpdp' class="trans" onClick="javascript:copyToDesc(this);">copy to desc </td>						
					<th>Other Ref. No.</th>	
					<td><input type="text" style="width:100px;" class="input" name="othr" maxlength="50" value=""></td>		
					<td><input type="checkbox" value="" name='check_othr' class="trans" onClick="javascript:copyToDesc(this);">copy to desc </td>	
				</tr> 
			</table>
			<div class="layout_wrap">
				<div class="layout_vertical_2">
					<div class="opus_design_grid pad_rgt_4" style="margin-top: 33px;">
						<script type="text/javascript">ComSheetObject('div3sheet1');</script>
					</div>
				</div>
				<div class="layout_vertical_2">
					<div class="opus_design_grid">
						<div class="opus_design_btn"><!-- 
							--><button type="button" id="btn_Po_Add" name="btn_Po_Add" class="btn_accent">Row Add</button><!--
							--><button type="button" id="btn_Po_Delete" name="btn_Po_Delete" class="btn_normal">Delete</button><!--
						--></div>
						<script type="text/javascript">ComSheetObject('div3sheet2');</script>
					</div>
				</div>
				<div class="opus_design_grid" style="display: none">
					<script type="text/javascript">ComSheetObject('div3sheet3');</script>
				</div>
			</div>
		</div>	 
	</div>      	
</div>

<div id="poOther2" style="position:absolute; visibility:hidden; z-index:1;margin-top:194px; margin-left:535px; height:281px; width:667px;border:solid;border-color:#b8d6f6">	
	<div class="wrap_search sm">
		<div class="opus_design_inquiry">
			<table>
				<colgroup>
					<col width="100"/>
					<col width="110"/>
					<col width="100"/>
					<col width="*" />				
				</colgroup>				
				<tr>
					<th>P/O No.</th>	
					<td><input type="text" style="width:100px;" class="input2" name="bkpo2" maxlength="50" value="<%=null!=xterMndVO ? replaceNull(xterMndVO.getBkpo2()) : ""%>"></td>		
					<th>L/C No.</th>	
					<td><input type="text" style="width:130px;" class="input2" name="lcno2" maxlength="50" value="<%=null!=xterMndVO ? replaceNull(xterMndVO.getLcno2()) : ""%>"></td>	
				</tr>
				<tr>
					<th>Invoice No.</th>	
					<td><input type="text" style="width:100px;" class="input2" name="hinv2" maxlength="50" value="<%=null!=xterMndVO ? replaceNull(xterMndVO.getHinv2()) : ""%>"></td>								
					<th>L/C Date</th>	
					<td><input type="text" style="width:100px;" class="input2" name="lcdt2" value="<%=null!=xterMndVO ? replaceNull(xterMndVO.getLcdt2()) : ""%>" maxlength="10" dataformat="ymd" style="ime-mode:disabled" caption="L/C Date"  ></td>						
				</tr>
				<tr>
					<th>Department No.</th>	
					<td><input type="text" style="width:100px;" class="input2" name="hpdp2" maxlength="50" value=""></td>								
					<th>Other Ref. No.</th>	
					<td width=""><input type="text" style="width:100px;" class="input2" name="othr2" maxlength="50" value=""></td>	
				</tr> 
			</table>	 
			<div class="layout_wrap">
				<div class="layout_vertical_2 pad_rgt_4">
					<div class="opus_design_grid" id="mainTable">
						<script type="text/javascript">ComSheetObject('div4sheet1');</script>
					</div>
				</div>
				<div class="layout_vertical_2">
					<div class="opus_design_grid" id="mainTable">
						<script type="text/javascript">ComSheetObject('div4sheet2');</script>
					</div>
				</div>
			</div> 
		</div>
	</div>
</div>

<div id="shipIdPop2" style="position:absolute; visibility:hidden; z-index:-100 ;margin-top:308px;margin-left:535px; height:170px; width:600px ;border:solid; border-color:#b8d6f6">
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('shipIdSheet2');</script>
	</div>
</div>

<div id="shipIdPop1" style="position: absolute; visibility: hidden; z-index: 1; margin-top: 285px; margin-left: 6px; height: 220px; width: 580px; border:solid; border-color:#b8d6f6">
	<div class="wrap_search sm">
		<div class="opus_design_grid">
			<div class="opus_design_btn">
				<button type="button" class="btn_normal" name="btn2_Row_Add" id="btn2_Row_Add">Row Add</button>
				<button type="button" class="btn_normal" name="btn2_Row_Delete" id="btn2_Row_Delete">Row Delete</button>
			</div>
			<span class="clear"></span>
			<script type="text/javascript">ComSheetObject('shipIdSheet1');</script>
		</div>
	</div>
</div>

<!-- layout_wrap(S) -->
<div class="layout_wrap">
    <div class="layout_vertical_2 pad_rgt_8" >
    	<div class="wrap_search sm">
    		<div class="opus_design_grid">
		    	<h3 class="title_design">Booking Data OPUS</h3>
		    	<div class="specialCls">
					<button type="button" class="btn_etc" name="btn_cancelcopydata" id="btn_cancelcopydata">Cancel Copy Data</button>
				</div>
			</div>
			<div class="opus_design_inquiry">
				<table class="search_ssm" style="width:450px;">
					<colgroup>
						<col width="60">
						<col width="*">
					</colgroup>
					<tbody>
						<tr>
							<th>Booking No.</th>
							<td><input type="text" name="bkg_no" id="bkg_no" style="width:105px;" class="input2" value="<%=StringUtil.xssFilter(request.getParameter("bkg_no"))%>" readOnly></td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="layout_wrap">
			    <div class="layout_vertical_2 pad_rgt_12">
			    	<table style="table-layout:fixed">
						<colgroup>
							<col width="220">
							<col width="*">
						</colgroup>
						<tbody>
							<tr>
								<th style="text-align:left;">Mark & NOS<br><textarea name="mk_desc" id="mk_desc" style="width:160px; font-family:Courier New; font-size:15px; text-indent:0px;resize:none;" wrap="physical" cols="16" rows="7" class="textarea"  dataformat="engup" otherchar="<%=getSpecialChars()%>"><%=null != opusMndVO ? replaceNull(opusMndVO.getMkDesc()) : ""%></textarea></th>
							</tr>
						</tbody>
					</table>
			    </div>
			    <div class="layout_vertical_2">
			    	<div class="opus_design_inquiry">
				    	<table style="margin-top:5px;">
							<colgroup>
								<col width="70">
								<col width="*">
							</colgroup>
							<tr>
								<th>Package</th>
								<td><input type="text" name="pck_qty" id="pck_qty" style="width:100px;text-align:right" maxlength="9" dataformat="int" class="input" value="<%=null != opusMndVO ? replaceNull(opusMndVO.getPckQty()) : ""%>"><!--  
									--><input type="text" name="pck_tp_cd" id="pck_tp_cd" style="width:30px;text-align:left" maxlength="2" dataformat="engup" class="input" value="<%=null != opusMndVO ? replaceNull(opusMndVO.getPckTpCd()) : ""%>"><!--  
									--><button type="button" class="input_seach_btn" name="btn_find_package" id="btn_find_package"></button><!--  
									--><input type="hidden" name="pck_nm" id="pck_nm" value="<%=null != opusMndVO ? replaceNull(opusMndVO.getPckNm()) : ""%>">
								</td>
							</tr>
							<tr>
								<th>Weight</th>
								<td><input type="text" name="act_wgt" id="act_wgt" style="width:100px;text-align:right" maxlength="13" onBlur="makeComma2(this)" dataformat="float" pointcount="3" class="input" value="<%=null != opusMndVO ? replaceNull(opusMndVO.getActWgt()) : ""%>"><!--  
									--><%=HTMLUtil.getComboString("wgt_ut_cd", "width:60px;", "", "",null != opusMndVO ? replaceNull(opusMndVO.getWgtUtCd()) : "", wgt_cd)%>
								</td>
								<td style="text-align:right; padding-right:35px;">(Print&nbsp;<input type="checkbox" name="act_wgt_prn_flg" id="act_wgt_prn_flg" class="trans" value="Y" <%=(null != opusMndVO ? replaceNull(opusMndVO.getActWgtPrnFlg()) : "").equals("Y") ? "checked=\"checked\"" : ""%>>)</td>
							</tr>
							<tr>
								<th>Measure</th>
								<td><input type="text" name="meas_qty" id="meas_qty" style="width:100px;text-align:right" maxlength="12" onBlur="makeComma2(this)" dataformat="float" pointcount="3" class="input" value="<%=null != opusMndVO ? replaceNull(opusMndVO.getMeasQty()) : ""%>"><!--  
									--><%=HTMLUtil.getComboString("meas_ut_cd", "width:60px;", "", "",null != opusMndVO ? replaceNull(opusMndVO.getMeasUtCd()) : "", meas_cd)%>
								</td>
							</tr>
							<tr>
								<th>Frt Term</th>
								<td><script type="text/javascript">ComComboObject('frt_term_cd', 2, 80, 1, 0, 1)</script></td>
							</tr>
						</table>
					</div>
			    </div>
			</div>
			<div class="opus_design_inquiry">
				<table style="table-layout:fixed">
					<colgroup>
						<col width="100">
						<col width="420">
						<col width="*">
					</colgroup>
					<tbody>
						<tr>
							<th colspan="2" style="text-align:left;">Description of Goods</th>
						</tr>
						<tr>
							<td>No. of PKG/CNTR</td>
							<td><input type="text" name="pck_cmdt_desc" id="pck_cmdt_desc" class="input" style="ime-mode:disabled;width:100%" dataformat="engup" otherchar="<%=getSpecialChars()%>" value="<%=null != opusMndVO ? replaceNull(opusMndVO.getPckCmdtDesc()) : ""%>"></td>
						</tr>
						<tr>
							<td><button type="button" class="btn_etc" name="btn_copy" id="btn_copy">Copy</button></td>
							<td><input type="text" name="cntr_cmdt_desc" id="cntr_cmdt_desc" class="input" style="ime-mode:disabled;width:100%;" dataformat="engup" otherchar="<%=getSpecialChars()%>" value="<%=null != opusMndVO ? replaceNull(opusMndVO.getCntrCmdtDesc()) : ""%>"></td>
						</tr>
						<tr>
							<td style="text-align:left;"></td>
							<td style="text-align:left;"><textarea name="dg_cmdt_desc" id="dg_cmdt_desc" cols="49" rows="7" style="width:330px;font-family:Courier New;font-size:15px; text-indent:0px; overflow-x:hidden;overflow-y:scroll; resize:none;" wrap="physical" class="textarea" dataformat="engup" otherchar="<%=getSpecialChars()%>"><%=null != opusMndVO ? replaceNull(opusMndVO.getDgCmdtDesc()) : ""%></textarea></td>
						</tr>
						<tr>
							<th colspan="2" style="text-align:left;">Customs Description</th>
						</tr>
						<tr>
							<td style="text-align:right;padding-left: 5px;" colspan="2"><input type="text" name="cstms_desc" id="cstms_desc" class="input1" style="font-family:Courier New;ime-mode:disabled;width:100%" dataformat="engup" otherchar="<%=getSpecialChars()%>" value = "<%=null != opusMndVO ? replaceNull(opusMndVO.getCstmsDesc()) : ""%>"></td>
						</tr>
						<tr>
							<th colspan="2" style="text-align:left;">Total No. of PKG/CNTR in Word</th>
						</tr>
						<tr>
							<td style="text-align:right;padding-left: 5px;" colspan="2"><input type="text" name="ttl_pck_desc" id="ttl_pck_desc" class="input" style="ime-mode:disabled;width:100%" dataformat="engup" otherchar="<%=getSpecialChars()%>" value = "<%=null != opusMndVO ? replaceNull(opusMndVO.getTtlPckDesc()) : ""%>"></td>
						</tr>
					</tbody>
				</table>
				<table>
					<colgroup>
						<col width="120">
						<col width="*">
					</colgroup>
					<tbody>
						<tr>
							<td>
								<button type="button" class="btn_etc" name="btn_ExportInfo" id="btn_ExportInfo">Export Information</button>
								<button type="button" class="btn_etc" name="btn_POOtherNo" id="btn_POOtherNo">P/O Other(s) No.</button>
								<button type="button" class="btn_etc" name="btn_shipId1" id="btn_shipId" style="width:150px;">Ship ID.</button>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
    </div>
    <div id="div_right" class="layout_vertical_2" >
    	<div class="wrap_search sm">
    		<div class="opus_design_grid">
		    	<h3 class="title_design">From e- Service</h3>
		    	<div class="specialCls">
					<button type="button" class="btn_etc" name="btn_datacopytoopus" id="btn_datacopytoopus">Data Copy to OPUS</button>
				</div>
			</div>
	    	<div class="opus_design_inquiry">
	    		<div class="specialCls">
								<button type="button" class="btn_etc" name="btn_datacopyfromcm" id="btn_datacopyfromcm" style="width:150px;">Copy from C/M</button>
							</div>
		        <div class="layout_vertical_2 pad_rgt_12">
		        <table style="width:450px;">
					<colgroup>
						<col width="240">
						<col width="*">
					</colgroup>
					<tbody>
						<tr>
							<th style="text-align:left;">Request No.&nbsp;<input type="text" name="rqst_no" id="rqst_no" style="width:105px;" class="input2" value="<%=StringUtil.xssFilter(request.getParameter("rqst_no"))%>" readOnly></th>
						</tr>
					</tbody>
				</table>
		        	<table>
						<colgroup>
							<col width="*">
						</colgroup>
						<tbody>
							<tr>
								<th style="text-align:left;">Mark & NOS<br><textarea name="mk_desc2" id="mk_desc2" style="font-family:Courier New; font-size:15px; text-indent:0px; resize:none;" wrap="physical" cols="22" rows="7" class="textarea2" readOnly><%=null != xterMndVO ? replaceNull(xterMndVO.getMkDesc()) : ""%></textarea></td>
							</tr>
						</tbody>
					</table>
			    </div>
			    <div class="layout_vertical_2" style="height:145px;padding-top:15px;">
			    	<table style="width:450px;">
						<colgroup>
							<col width="50">
							<col width="*">
						</colgroup>
						<tbody>
							<tr>
								<th>Package</th>
								<td><input type="text" name="pck_qty2" id="pck_qty2" style="width:100px;text-align:right" class="input2" value="<%=null != xterMndVO ? replaceNull(xterMndVO.getPckQty()) : ""%>" readOnly><!--  
									--><input type="text" name="pck_tp_cd2" id="pck_tp_cd2" style="width:52px;" class="input2" value="<%=null != xterMndVO ? replaceNull(xterMndVO.getPckTpCd()) : ""%>" readOnly></td>
							</tr>
							<tr>
								<th>Weight</th>
								<td><input type="text" name="act_wgt2" id="act_wgt2" style="width:100px;text-align:right" class="input2" value="<%=null != xterMndVO ? replaceNull(xterMndVO.getActWgt()) : ""%>" readOnly><!--  
									--><input type="text" name="wgt_ut_cd2" id="wgt_ut_cd2" style="width:52px;" class="input2" value="<%=null != xterMndVO ? replaceNull(xterMndVO.getWgtUtCd()) : ""%>" readOnly></td>
							</tr>
							<tr>
								<th style="height:10px;"></th>
								<td></td>
							</tr>
							<tr>
								<th>Measure</th>
								<td><input type="text" name="meas_qty2" id="meas_qty2" style="width:100px;text-align:right" class="input2" value="<%=null != xterMndVO ? replaceNull(xterMndVO.getMeasQty()) : ""%>" readOnly><!--  
									--><input type="text" name="meas_ut_cd2" id="meas_ut_cd2" style="width:52px;" class="input2" value="<%=null != xterMndVO ? replaceNull(xterMndVO.getMeasUtCd()) : ""%>" readOnly></td>
							</tr>
							<tr>
								<th>Frt.Term</th>
								<td><input type="text" name="frt_term_cd2" id="frt_term_cd2" style="width:80px;text-align:left" class="input2" readOnly></td>
							</tr>
						</tbody>
					</table>
			    </div>
			<table class="search">
				<colgroup>
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th style="text-align:left;">Description of Goods</th>
					</tr>
					<tr>
						<td><textarea name="dg_cmdt_desc2" id="dg_cmdt_desc2" cols="49" rows="7" style="font-family:Courier New; font-size:15px; text-indent:0px;resize:none;" wrap="physical" class="textarea2" readOnly><%=null != xterMndVO ? replaceNull(xterMndVO.getCmdtDesc()) : ""%></textarea></td>
					</tr>
				</tbody>
			</table>
			<table>
				<tr><td style="height:120px;"></td></tr>
			</table>
			<table>
				<colgroup>
					<col width="150">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<td><button type="button" class="btn_etc" name="btn_MiscInfo2" id="btn_MiscInfo2" style="width:150px;">Misc. Information</button><button type="button" class="btn_etc" name="btn_InnerPackage2" id="btn_InnerPackage2" style="width:150px;">Inner Package</button></td>
					</tr>
				</tbody>
			</table>
			<table>
				<colgroup>
					<col width="150">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<td>
							<button type="button" class="btn_etc" name="btn_ExportInfo2" id="btn_ExportInfo2" style="width:150px;">Export Information</button>
							<button type="button" class="btn_etc" name="btn_POOtherNo2" id="btn_POOtherNo2" style="width:150px;">P/O Other(s) No.</button>
							<button type="button" class="btn_etc" name="btn_shipId2" id="btn_shipId2" style="width:150px;">Ship ID.</button>
						</td>
					</tr>
				</tbody>
			</table>
			
			</div>
	    </div>
    </div>
</div>
		<!-- layout_wrap(E) -->
<div class="wrap_result">
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
</form>
<%!    
	public String replaceNull(String str) {
        return (str==null)?"":str;
	}

	public String getSpecialChars() {
		return " ~!@#$%^&*()`_+-={}|[]\\\"\\':;,./?"; 
	}
%>