<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0229_02.jsp
*@FileTitle  : e-Booking & S/I Detail (Customer)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/08
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
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkg022902Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List" %>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO" %>
<%@ page import="com.clt.apps.opus.esm.bkg.common.*" %>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstCustVO" %>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.BkgXterCustVO" %>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BlDocCustVO" %>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.CustEtcVO" %>
<%@ page import="com.clt.framework.core.controller.DefaultViewAdapter"%>

<%
	EsmBkg022902Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	String sXml		 = "";
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.EBookingConduct.EBookingReceipt");

	// SH
	String bkgNo = "";
	String shCustCntCd = "";
	String shCustSeq = "";
	String shCntSeq = "";
	String shCustNm = "";
	String shCustLglEngNm = "";
	String shCustCtyNm = "";
	String shCustSteCd = "";
	String shCstmsDeclCntCd = "";
	String shCustZipId = "";
	String shCustAddr = "";
	String shAddrPrnFlg = "";
	String shCustTp = "";
	String shMdmAddress = "";
	String shEurCstmsStNm = "";
	String shEurCstmsPstId = "";
	String shEoriNo = "";
	
	// CN
	String cnCustCntCd = "";
	String cnCntSeq = "";
	String cnCustSeq = "";
	String cnCustNm = "";
	String cnCustLglEngNm = "";
	String cnCustAddr = "";
	String cnCustCtyNm = "";
	String cnCustSteCd = "";
	String cnCstmsDeclCntCd = "";
	String cnCustZipId = "";
	String cnCustFaxNo = "";
	String cnCustEml = "";
	String cnAddrPrnFlg = "";
	String cnMdmAddress = "";
	String cnEurCstmsStNm = "";
	String cnEurCstmsPstId = "";
	String cnEoriNo = "";
	
	// NF
	String nfCustSteCd = "";
	String nfCustCntCd = "";
	String nfCustSeq = "";
	String nfCustZipId = "";
	String nfCstmsDeclCntCd = "";
	String nfAddrPrnFlg = "";
	String nfCntSeq = "";
	String nfCustLglEngNm = "";
	String nfCustNm = "";
	String nfCustCtyNm = "";
	String nfCustAddr = "";
	String nfCustEml = "";
	String nfCustFaxNo = "";
	String nfMdmAddress = "";
	String nfEurCstmsStNm = "";
	String nfEurCstmsPstId = "";
	String nfEoriNo = "";
	
	// FF
	String ffCustLglEngNm = "";
	String ffCustEml = "";
	String ffCustZipId = "";
	String ffCustSteCd = "";
	String ffAddrPrnFlg = "";
	String ffCustFaxNo = "";
	String ffCstmsDeclCntCd = "";
	String ffCustCtyNm = "";
	String ffCustSeq = "";
	String ffCntSeq = "";
	String ffCustNm = "";
	String ffCustAddr = "";
	String ffCustCntCd = "";
	String ffMdmAddress = "";
	
	// AN
	String anCntSeq = "";
	String anCustNm = "";
	String anCustSeq = "";
	String anAddrPrnFlg = "";
	String anCustLglEngNm = "";
	String anCustCntCd = "";
	String anCustAddr = "";
	String anMdmAddress = "";
	String anCustFaxNo = "";
	String anCustEml = "";
	
	// EX
	String exCustNm = "";
	String exAddrPrnFlg = "";
	
	// BR
	String brCustCntCd = "";
	String brCustNm = "";
	String brCustAddr = "";
	
	// flag
	String frobFlag = "";
	String samCneeNtfyFlg = "";
	String custToOrdFlg = "";

	// editable field at the 0079-05
	String ffRefNo = "";
	String exCustCntCd = "";
	String exCustSeq = "";
	String orgCntNm = "";
	String fmcCD = "";
	
	// for a/customer
	String scNo = "";
	String rfaNo = "";
	String svcScpCd = "";
	String applDt = "";
	String agmtActCntCd = "";
	String agmtActCustSeq = "";  

	String porCd = "";
	String polCd = "";
	String podCd = "";
	String delCd = "";
	//eSvc ------------------------------------------------------------------------
	// SH
	String xterRqstNo = "";
	String xterRqstSeq = "";
	String shCustCntCd2 = "";
	String shCustSeq2 = "";
	String shCntSeq2 = "";
	String shCustNm2 = "";
	String shCustLglEngNm2 = "";
	String shCustCtyNm2 = "";
	String shCustSteCd2 = "";
	String shCstmsDeclCntCd2 = "";
	String shCustZipId2 = "";
	String shCustAddr2 = "";
	String shEurCstmsStNm2 = "";
	String shEurCstmsPstId2 = "";
	String shEoriNo2 = "";
	
	// CN
	String cnCustCntCd2 = "";
	String cnCntSeq2 = "";
	String cnCustSeq2 = "";
	String cnCustNm2 = "";
	String cnCustLglEngNm2 = "";
	String cnCustAddr2 = "";
	String cnCustCtyNm2 = "";
	String cnCustSteCd2 = "";
	String cnCstmsDeclCntCd2 = "";
	String cnCustZipId2 = "";
	String cnCustFaxNo2 = "";
	String cnCustEml2 = "";
	String cnEurCstmsStNm2 = "";
	String cnEurCstmsPstId2 = "";
	String cnEoriNo2 = "";
	
	// NF
	String nfCustSteCd2 = "";
	String nfCustCntCd2 = "";
	String nfCustSeq2 = "";
	String nfCustZipId2 = "";
	String nfCstmsDeclCntCd2 = "";
	String nfCntSeq2 = "";
	String nfCustLglEngNm2 = "";
	String nfCustNm2 = "";
	String nfCustCtyNm2 = "";
	String nfCustAddr2 = "";
	String nfCustEml2 = "";
	String nfCustFaxNo2 = "";
	String nfEurCstmsStNm2 = "";
	String nfEurCstmsPstId2 = "";
	String nfEoriNo2 = "";
	
	// FF
	String ffCustLglEngNm2 = "";
	String ffCustEml2 = "";
	String ffCustZipId2 = "";
	String ffCustSteCd2 = "";
	String ffAddrPrnFlg2 = "";
	String ffCustFaxNo2 = "";
	String ffCstmsDeclCntCd2 = "";
	String ffCustCtyNm2 = "";
	String ffCustSeq2 = "";
	String ffCntSeq2 = "";
	String ffCustNm2 = "";
	String ffCustAddr2 = "";
	String ffCustCntCd2 = "";
	
	// AN
	String anCntSeq2 = "";
	String anCustNm2 = "";
	String anCustSeq2 = "";
	String anCustLglEngNm2 = "";
	String anCustCntCd2 = "";
	String anCustAddr2 = "";
	
	// EX
	String exCustNm2 = "";
	
	// BR
	String brCustCntCd2 = "";
	String brCustNm2 = "";
	String brCustAddr2 = "";
	
	// CBR
	String cbrCustNm2 = "";
	String cbrFaxNo12 = "";
	String cbrFaxNo22 = "";
	String cbrFaxNo32 = "";

	String shKrCstmsCustTpCd2 = "";
	String custToOrdFlg2 = "";
	String rvisCntrCustTpCd2 = "";
	
	String orgCntNm2 = "";

	List<BkgComboVO> tp_cd = null;
	BlDocCustVO blDocCust  = null;
	BkgXterCustVO xterCust = null;
	CustEtcVO custEtcVO	   = null;
	
	String nlFlag = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg022902Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		tp_cd = (List<BkgComboVO>) eventResponse.getCustomData("tp_cd");
		
		ExternalRqstCustVO rqstCustVo = (ExternalRqstCustVO) eventResponse.getCustomData("externalRqstCustVO");
		//blDocCust = rqstCustVo.getBlDocCustVO();
		//custEtcVO = rqstCustVo.getCustEtcVO();
		xterCust = rqstCustVo.getBkgXterCustVO();

		DefaultViewAdapter adapter = new DefaultViewAdapter();
		sXml = adapter.makeXML(request, response);
		blDocCust = null;
		
		if ( xterCust != null ) {
			xterRqstNo = xterCust.getXterRqstNo();
			xterRqstSeq = xterCust.getXterRqstSeq();
			shCustCntCd2 = xterCust.getShCustCntCd();
			shCustSeq2 = ("0".equals(xterCust.getShCustSeq()))?"":getZeroLpad(xterCust.getShCustSeq());
			shCntSeq2 = xterCust.getShCntSeq();
			shCustNm2 = xterCust.getShCustNm();
			shCustLglEngNm2 = xterCust.getShCustLglEngNm();
			shCustCtyNm2 = xterCust.getShCustCtyNm();
			shCustSteCd2 = xterCust.getShCustSteCd();
			shCstmsDeclCntCd2 = xterCust.getShCstmsDeclCntCd();
			shCustZipId2 = xterCust.getShCustZipId();
			shCustAddr2 = xterCust.getShCustAddr();
			shEurCstmsStNm2 = xterCust.getShEurCstmsStNm();
			shEurCstmsPstId2 = xterCust.getShEurCstmsPstId();
			shEoriNo2 = xterCust.getShEoriNo();

			cnCustCntCd2 = xterCust.getCnCustCntCd();
			cnCntSeq2 = xterCust.getCnCntSeq();
			cnCustSeq2 = ("0".equals(xterCust.getCnCustSeq()))?"":getZeroLpad(xterCust.getCnCustSeq());
			cnCustNm2 = xterCust.getCnCustNm();
			cnCustLglEngNm2 = xterCust.getCnCustLglEngNm();
			cnCustAddr2 = xterCust.getCnCustAddr();
			cnCustCtyNm2 = xterCust.getCnCustCtyNm();
			cnCustSteCd2 = xterCust.getCnCustSteCd();
			cnCstmsDeclCntCd2 = xterCust.getCnCstmsDeclCntCd();
			cnCustZipId2 = xterCust.getCnCustZipId();
			cnCustFaxNo2 = xterCust.getCnCustFaxNo();
			cnCustEml2 = xterCust.getCnCustEml();
			cnEurCstmsStNm2 = xterCust.getCnEurCstmsStNm();
			cnEurCstmsPstId2 = xterCust.getCnEurCstmsPstId();
			cnEoriNo2 = xterCust.getCnEoriNo();

			nfCustSteCd2 = xterCust.getNfCustSteCd();
			nfCustCntCd2 = xterCust.getNfCustCntCd();
			nfCustSeq2 = ("0".equals(xterCust.getNfCustSeq()))?"":getZeroLpad(xterCust.getNfCustSeq());
			nfCustZipId2 = xterCust.getNfCustZipId();
			nfCstmsDeclCntCd2 = xterCust.getNfCstmsDeclCntCd();
			nfCntSeq2 = xterCust.getNfCntSeq();
			nfCustLglEngNm2 = xterCust.getNfCustLglEngNm();
			nfCustNm2 = xterCust.getNfCustNm();
			nfCustCtyNm2 = xterCust.getNfCustCtyNm();
			nfCustAddr2 = xterCust.getNfCustAddr();
			nfCustEml2 = xterCust.getNfCustEml();
			nfCustFaxNo2 = xterCust.getNfCustFaxNo();
			nfEurCstmsStNm2 = xterCust.getNfEurCstmsStNm();
			nfEurCstmsPstId2 = xterCust.getNfEurCstmsPstId();
			nfEoriNo2 = xterCust.getNfEoriNo();

			ffCustCntCd2 = xterCust.getFfCustCntCd();
			ffCustSeq2 = ("0".equals(xterCust.getFfCustSeq()))?"":getZeroLpad(xterCust.getFfCustSeq());
			ffCntSeq2 = xterCust.getFfCntSeq();
			ffCustNm2 = xterCust.getFfCustNm();
			ffCustLglEngNm2 = xterCust.getFfCustLglEngNm();
			ffCustAddr2 = xterCust.getFfCustAddr();

			anCntSeq2 = xterCust.getAnCntSeq();
			anCustNm2 = xterCust.getAnCustNm();
			anCustSeq2 = ("0".equals(xterCust.getAnCustSeq()))?"":getZeroLpad(xterCust.getAnCustSeq());
			anCustLglEngNm2 = xterCust.getAnCustLglEngNm();
			anCustCntCd2 = xterCust.getAnCustCntCd();
			anCustAddr2 = xterCust.getAnCustAddr();

			exCustNm2 = xterCust.getExCustNm();

			brCustCntCd2 = xterCust.getBrCustCntCd();
			brCustNm2 = xterCust.getBrCustNm();
			brCustAddr2 = xterCust.getBrCustAddr();
			
			cbrCustNm2 = xterCust.getCbrCustNm();
			cbrFaxNo12 = xterCust.getCbrFaxNo1();
			cbrFaxNo22 = xterCust.getCbrFaxNo2();
			cbrFaxNo32 = xterCust.getCbrFaxNo3();

			shKrCstmsCustTpCd2 = xterCust.getShKrCstmsCustTpCd2();
			custToOrdFlg2 = xterCust.getCnCustToOrdFlg();
			rvisCntrCustTpCd2 = xterCust.getRvisCntrCustTpCd();
			
			orgCntNm2 = xterCust.getOrgCntNm();
		}

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();

	}
</script>

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

<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="sXml" value="<%=JSPUtil.replace(sXml, "\"", "&quot;")%>" id="sXml" />
<input type="hidden" name="sender_id" value="<%=StringUtil.xssFilter(request.getParameter("sender_id")) %>" id="sender_id" />
<input type="hidden" name="rqst_no" value="<%=StringUtil.xssFilter(request.getParameter("rqst_no")) %>" id="rqst_no" />
<input type="hidden" name="rqst_seq" value="<%=StringUtil.xssFilter(request.getParameter("rqst_seq")) %>" id="rqst_seq" />
<!-- input type="hidden" name="sh_kr_cstms_cust_tp_cd2" value="<%=shKrCstmsCustTpCd2%>" id="sh_kr_cstms_cust_tp_cd2" /-->
<input type="hidden" name="cn_cust_to_ord_flg2" value="<%=custToOrdFlg2%>" id="cn_cust_to_ord_flg2" />
<input type="hidden" name="rvis_cntr_cust_tp_cd2" value="<%=rvisCntrCustTpCd2%>" id="rvis_cntr_cust_tp_cd2" />

<input type="hidden" name="cust_opus" value="<%=(blDocCust != null)?" y":"n" %>" id="cust_opus" />
<input type="hidden" name="cust_esvc" value="<%=(xterCust != null)?" y":"n" %>" id="cust_esvc" />

<input type="hidden" name="sh_mdm_address" value="<%=shMdmAddress%>" id="sh_mdm_address" />
<input type="hidden" name="ff_mdm_address" value="<%=ffMdmAddress%>" id="ff_mdm_address" />
<input type="hidden" name="cn_mdm_address" value="<%=cnMdmAddress%>" id="cn_mdm_address" />
<input type="hidden" name="nf_mdm_address" value="<%=nfMdmAddress%>" id="nf_mdm_address" />
<input type="hidden" name="an_mdm_address" value="<%=anMdmAddress%>" id="an_mdm_address" />

<input type="hidden" name="modify_flag" value="N" id="modify_flag" />
<input type="hidden" name="same_as_flag" id="same_as_flag" />
<input type="hidden" name="order_found_flag" id="order_found_flag" />
<input type="hidden" name="ca_manifest_flag" id="ca_manifest_flag" />
<input type="hidden" name="frob_flag" value="<%=(frobFlag==null||frobFlag=="")?"N":frobFlag%>">

<input type="hidden" name="por_cd" value="<%=porCd%>" id="por_cd" />
<input type="hidden" name="pol_cd" value="<%=polCd%>" id="pol_cd" />
<input type="hidden" name="pod_cd" value="<%=podCd%>" id="pod_cd" />
<input type="hidden" name="del_cd" value="<%=delCd%>" id="del_cd" />
<!-- editable field at the 0079-05 -->
<input type="hidden" name="ff_ref_no" value="<%=ffRefNo%>" id="ff_ref_no" />
<input type="hidden" name="ex_cust_cnt_cd" value="<%=exCustCntCd%>" id="ex_cust_cnt_cd" />
<input type="hidden" name="ex_cust_seq" value="<%=exCustSeq%>" id="ex_cust_seq" />
<input type="hidden" name="sam_cnee_ntfy_flg" value="<%=(samCneeNtfyFlg==null||samCneeNtfyFlg=="")?"N":samCneeNtfyFlg%>">
<input type="hidden" name="cust_to_ord_flg" value="<%=(custToOrdFlg==null||custToOrdFlg=="")?"N":custToOrdFlg%>">
<input type="hidden" name="an_cust_eml" value="<%=anCustEml %>" id="an_cust_eml" />
<input type="hidden" name="an_cust_fax_no" value="<%=anCustFaxNo %>" id="an_cust_fax_no" />

<input type="hidden" name="sc_no" value="<%=scNo%>" id="sc_no" />
<input type="hidden" name="rfa_no" value="<%=rfaNo%>" id="rfa_no" />
<input type="hidden" name="svc_scp_cd" value="<%=svcScpCd%>" id="svc_scp_cd" />
<input type="hidden" name="appl_dt" value="<%=applDt%>" id="appl_dt" />
<input type="hidden" name="cn_cust_yn" value="N" id="cn_cust_yn" />

<input type="hidden" name="nl_flag" id="nl_flag" />
<input type="hidden" name="val_msg" id="val_msg" />
<input type="hidden" name="val_msg_chk" id="val_msg_chk" />
<input type="hidden" name="nm_and_addr_ovflw_flg" id="nm_and_addr_ovflw_flg" />

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
			<!-- opus_design_inquiry(S) -->
			<div class="opus_design_inquiry">
				<table>
					<colgroup>
						<col width="75" />				
						<col width="100"/>						
						<col width="500" />				
						<col width="*" />				
				   </colgroup> 
				   <tbody>
						<tr>
							<th>Booking No.</th>
							<td><input type="text" name="bkg_no" id="bkg_no" style="width:105px;" class="input2" value="<%=(!"".equals(bkgNo))?bkgNo:request.getParameter("bkg_no")%>"></td>
							<th >A/Customer</th>
							<td><input type="text" name="agmt_act_cnt_cd" id="agmt_act_cnt_cd" style="width:30px;" class="input" value="<%=agmtActCntCd%>"  maxlength=2 dataformat="engup" ><!-- 
							 --><input type="text" name="agmt_act_cust_seq" id="agmt_act_cust_seq" style="width:50px;" class="input" value="<%=agmtActCustSeq%>" maxlength=6 dataformat="int" ><!-- 
							 --><button type="button" id="btn_t7Sa0190" name="btn_t7Sa0190" class="input_seach_btn"></button>
							</td>
						</tr>
					</tbody>
				</table>
				<table>
					<colgroup>
						<col width="75" />				
						<col width="150" />				
						<col width="*" />				
				   </colgroup> 
				   <tbody>
				   		<tr>
							<th>Shipper</th>
							<td><input type="text" name="sh_cust_cnt_cd" id="sh_cust_cnt_cd" style="width:30px;" maxlength="2" dataformat="engup" class="input" value="<%=shCustCntCd%>"></input><!-- 
							 --><button type="button" id="btn_t7Sh0192" name="btn_t7Sh0192" class="input_seach_btn"></button><!-- 
							 --><input type="text" name="sh_cust_seq" id="sh_cust_seq" style="width:55px;" maxlength="6" dataformat="engup" class="input" value="<%=shCustSeq%>"></input><!-- 
							 --><button type="button" id="btn_t7ShMdmCustNm" name="btn_t7ShMdmCustNm" name="btn_splitPop" class="btn_down"></button><!-- 
							 --><input type="text" name="sh_cust_lgl_eng_nm"  id="sh_cust_lgl_eng_nm" style="width:140px;" class="input2" value="<%=shCustLglEngNm%>" readOnly></input><!-- 
							 --><input type="text" style="width:25px;" class="input2" value="<%=shCustTp%>" readonly name="sh_cust_tp" id="sh_cust_tp"><script type="text/javascript" >ComComboObject('kr_cstms_cust_tp_cd', 2, 100, 1, 0, 1)</script></td>
							 <td></td>
						</tr>
					</tbody>
				</table>
				<table style="table-layout:fixed">
					<colgroup>
						<col width="75" />				
						<col width="280" />				
						<col width="70" />						
						<col width="*" />				
				   </colgroup> 
				   <tbody>
						<tr>
							<td style="text-align:right">Name</td>
							<td colspan="2"><textarea class="textarea_img2" rows="2" style="resize:none;font-family:Courier New; font-size:15px; text-indent:0px;overflow-x:hidden;overflow-y:scroll"  wrap="physical" name="sh_cust_nm" id="sh_cust_nm" dataformat="engup" otherchar="<%=getSpecialChars()%>"><%=shCustNm%></textarea></td><!-- onBlur="javascript:validateCols('2','35',this);" -->
						</tr>
						<tr>
							<td style="text-align:right" rowspan="2">Address<br>(<label for = "sh_addr_prn_flg">Print</label><input type="checkbox" name="sh_addr_prn_flg" id="sh_addr_prn_flg" value="Y" class="trans" <%=("Y".equals(shAddrPrnFlg))?"checked":""%>>)</td>
							<td colspan="2"><textarea id="sh_cust_addr" name="sh_cust_addr" style="resize:none; font-family:Courier New; font-size:15px; text-indent:0px;overflow-x:hidden;overflow-y:scroll" class="textarea_img3" rows="3" dataformat="engup" otherchar="<%=getSpecialChars()%>"><%=shCustAddr%></textarea></td><!-- onBlur="javascript:validateCols('3','35',this);" -->
						</tr>
					</tbody>
				</table>
				<table>
					<colgroup>
						<col width="75">	
						<col width="90">				
						<col width="170">				
						<col width="100">	
						<col width="120">				
						<col width="*">					
				   </colgroup> 
				   <tbody>
						<tr>
							<td></td>
							<th>City/State</th>
							<td><input type="text" name="sh_cust_cty_nm" id="sh_cust_cty_nm" style="width:85px;" dataformat="exceptengdn" class="input" value="<%=shCustCtyNm%>"><!-- 
							 --><input type="text" name="sh_cust_ste_cd" id="sh_cust_ste_cd"  style="width:40px;" maxlength="3" dataformat="engup" class="input" value="<%=shCustSteCd%>"></td>
							<th>Country</th>
							<td><input type="text" name="sh_cstms_decl_cnt_cd" id="sh_cstms_decl_cnt_cd"  style="width:30px;" maxlength="2" dataformat="engup" class="input" value="<%=shCstmsDeclCntCd%>"><!-- 
							--><strong>Zip CD </strong><!-- 
							--><input type="text" name="sh_cust_zip_id" id="sh_cust_zip_id" style="width:69px;" maxlength="10" dataformat="engup" otherchar="-" class="input" value="<%=shCustZipId%>"><!-- 
							 --><button type="button" id="btn_t7ShZipCode" name="btn_t7ShZipCode" class="input_seach_btn"></button></td>
							 <td></td>
						</tr>
						<tr>
							<td></td>
							<th>Street/P.O.Box</th>
							<td><input type="text" name="sh_eur_cstms_st_nm" id="sh_eur_cstms_st_nm" style="width:130px;" class="input" value="" tabindex=19 dataformat="exceptengdn" maxlength=50 style="ime-mode:disabled" >
							<th>EORI#</th>
							<td><input type="text"  name="sh_eori_no" id="sh_eori_no" style="width:170px;" class="input" value="" tabindex=20 maxlength=20 style="ime-mode:disabled"  dataformat="engup"></td>
							<td></td>
						</tr>						
				   </tbody>
				</table>
				<table class="height_10"><tr><td colspan="8"></td></tr></table>
				<table>
					<colgroup>
						<col width="75" />				
						<col width="300" />						
						<col width="60" />	
						<col width="100" />	
						<col width="*" />				
				   </colgroup> 
					<tbody>
						<tr>
							<th>Consignee</th>
							<td><input type="text" name="cn_cust_cnt_cd" id="cn_cust_cnt_cd" style="width:30px;" maxlength="2" dataformat="engup" class="input" value="<%=cnCustCntCd%>"></input><!-- 
							 --><button type="button" id="btn_t7Cn0192" name="btn_t7Cn0192" class="input_seach_btn"></button><!-- 
						     --><input type="text" name="cn_cust_seq" id="cn_cust_seq" style="width:55px;" maxlength="6" dataformat="engup" class="input" value="<%=cnCustSeq%>"></input><!-- 
						     --><button type="button" class="btn_down" name="btn_t7CnMdmCustNm" name="btn_splitPop"></button><!-- 
							 --><input type="text" name="cn_cust_lgl_eng_nm" id="cn_cust_lgl_eng_nm" style="width:130px;" class="input2" value="<%=cnCustLglEngNm%>" readOnly></input>
							</td>
							<th>B/L TP</th>
							<td><select style="width:80px;" name="bl_tp_cd" id="bl_tp_cd"><!-- 
								 --><option value="N" <%=("N".equals(custToOrdFlg))?"selected":""%>>Straight</option><!-- 
								 --><option value="Y" <%=("Y".equals(custToOrdFlg))?"selected":""%>>Order</option></select></td>
							 <td></td>
						</tr>
					</tbody>
				</table>
				<table style="table-layout:fixed">
					<colgroup>
						<col width="75" />	
						<col width="100" />	
						<col width="100" />	
						<col width="50" />	
						<col width="50" />	
						<col width="50" />								
						<col width="*" />				
				   </colgroup> 
					<tbody>
						<tr>
							<td style="text-align:right">Name</td>
							<td colspan="5"><textarea name="cn_cust_nm" id="cn_cust_nm" style="resize:none;font-family:Courier New; font-size:15px; text-indent:0px;overflow-x:hidden;overflow-y:scroll" class="textarea_img2" rows="2" dataformat="engup" otherchar="<%=getSpecialChars()%>"><%=cnCustNm%></textarea></td><!-- onBlur="javascript:validateCols('2','35',this);"  -->
						</tr>
						<tr>
							<td style="text-align:right" rowspan="4">Address<br>(<label for ="cn_addr_prn_flg">Print</label><input type="checkbox" name="cn_addr_prn_flg" id="cn_addr_prn_flg" value="Y" class="trans" <%=("Y".equals(cnAddrPrnFlg))?"checked":""%>>)</td>
							<td colspan="5"><textarea name="cn_cust_addr" id="cn_cust_addr" style="resize:none;font-family:Courier New; font-size:15px; text-indent:0px;overflow-x:hidden;overflow-y:scroll" class="textarea_img3" rows="3" dataformat="engup" otherchar="<%=getSpecialChars()%>"><%=cnCustAddr%></textarea></td> <!-- onBlur="javascript:validateCols('3','35',this);"  -->
						</tr>
					</tbody>
				</table>
				<table>
					<colgroup>
						<col width="75">	
						<col width="90">				
						<col width="170">				
						<col width="100">	
						<col width="120">				
						<col width="*">				
				   </colgroup> 
					<tbody>
						<tr>
							<td></td>
							<th>City/State</th>
							<td><input type="text" name="cn_cust_cty_nm" id="cn_cust_cty_nm" style="width:85px;" dataformat="exceptengdn" class="input" value="<%=cnCustCtyNm%>"><!-- 
							 --><input type="text" name="cn_cust_ste_cd" id="cn_cust_ste_cd" style="width:40px;" maxlength="3" dataformat="engup" class="input" value="<%=cnCustSteCd%>"></td>
							<th>Country</th>
							<td><input type="text" id="cn_cstms_decl_cnt_cd" name="cn_cstms_decl_cnt_cd" style="width:30px;" maxlength="2" dataformat="engup" class="input" value="<%=cnCstmsDeclCntCd%>"><!-- 
							--><strong>Zip CD </strong><!-- 
							--><input type="text" name="cn_cust_zip_id" id="cn_cust_zip_id" style="width:69px;" maxlength="10" dataformat="engup" otherchar="-" class="input" value="<%=cnCustZipId%>"><!-- 
							--><button type="button" id="btn_t7CnZipCode" name="btn_t7CnZipCode" class="input_seach_btn" alt=""></button></td>
							<td></td>
						</tr>
					
						<tr>	
							<td></td>
							<th>Street/P.O.Box</th>
							<td><input type="text" name="cn_eur_cstms_st_nm" id="cn_eur_cstms_st_nm" style="width:130px;" class="input" value="" tabindex=19 dataformat="exceptengdn" maxlength=50 style="ime-mode:disabled" >
							<th>EORI#</th>
							<td><input type="text"  name="cn_eori_no" id="cn_eori_no" style="width:170px;" class="input" value="" tabindex=20 maxlength=20 style="ime-mode:disabled"  dataformat="engup"></td>
							<td></td>
						</tr>
					</tbody>
				</table>
				<table>
					<colgroup>
						<col width="75" />	
						<col width="90" />	
						<col width="188" />	
						<col width="82" />	
						<col width="*" />				
				   </colgroup> 
					<tbody>
						<tr>
							<td></td>
							<th>Fax</th>
							<td><input type="text" name="cn_cust_fax_no" id="cn_cust_fax_no" style="width:130px;" dataformat="engup" otherchar="-" class="input" maxlength="20" value="<%=cnCustFaxNo%>"></td>
							<th>E-mail</th>
							<td><input type="text" name="cn_cust_eml" id="cn_cust_eml" style="width:170px;" dataformat="engup" otherchar="<%=getSpecialChars()%>" class="input" value="<%=cnCustEml%>"></td>
						</tr>
					</tbody>
				</table>
				<table class="height_10"><tr><td colspan="7"></td></tr></table>
				<table>
					<colgroup>
						<col width="75" />	
						<col width="80" />	
						<col width="*" />				
				   </colgroup> 
					<tbody>
					<tr>
						<th>Notify</th>
						<td><input type="text" name="nf_cust_cnt_cd" style="width:30px;" maxlength="2" dataformat="engup" class="input" value="<%=nfCustCntCd%>" id="nf_cust_cnt_cd" /><!-- 				
							 --><button type="button" id="btn_t7Nf0192" name="btn_t7Nf0192" class="input_seach_btn"></button><!-- 		
							 --><input type="text" name="nf_cust_seq" style="width:55px;" maxlength="6" dataformat="engup" class="input" value="<%=nfCustSeq%>" id="nf_cust_seq" /><!-- 
							 --><button type="button" class="btn_down" name="btn_t7NfMdmCustNm" id="btn_t7NfMdmCustNm"></button><!-- 
							 --><input type="text" name="nf_cust_lgl_eng_nm" style="width:130px;" class="input2" value="<%=nfCustLglEngNm%>" readonly="" id="nf_cust_lgl_eng_nm" /></td>
						<td></td>
					</tr>
					</tbody>
				</table>
				<table  style="table-layout:fixed">
					<colgroup>
						<col width="75" />	
						<col width="350" />				
						<col width="*" />				
				   </colgroup> 
					<tbody>
					<tr>
						<td style="text-align:right">Name</td>
						<td colspan="1"><textarea name="nf_cust_nm" id="nf_cust_nm" style="font-family:Courier New; font-size:15px; text-indent:0px;overflow-x:hidden;overflow-y:scroll;resize:none" class="textarea_img2" rows="2" dataformat="engup" otherchar="<%=getSpecialChars()%>"><%=nfCustNm%></textarea></td><!-- onBlur="javascript:validateCols('2','35',this);" -->
					</tr>
					<tr>
						<td style="text-align:right" class="stm" rowspan="2" valign="top">Address<br>(<label for ="nf_addr_prn_flg">Print</label><input type="checkbox" name="nf_addr_prn_flg" id="nf_addr_prn_flg" value="Y" class="trans" <%=("Y".equals(nfAddrPrnFlg))?"checked":""%>>)</td>
						<td colspan="1"><textarea name="nf_cust_addr" id="nf_cust_addr" style="resize:none;font-family:Courier New; font-size:15px; text-indent:0px;overflow-x:hidden;overflow-y:scroll" class="textarea_img3" rows="3" dataformat="engup" otherchar="<%=getSpecialChars()%>"><%=nfCustAddr%></textarea></td><!--  onBlur="javascript:validateCols('3','35',this);" -->							</tr>
					<tr>
					</tbody>
				</table>
				<table>
					<colgroup>
						<col width="75">	
						<col width="90">				
						<col width="170">				
						<col width="100">	
						<col width="120">				
						<col width="*">				
				   </colgroup> 
					<tbody>
					<tr>
						<td></td>
						<th>City/State</th>
						<td><input type="text" name="nf_cust_cty_nm" style="width:85px;" dataformat="exceptengdn" class="input" value="<%=nfCustCtyNm%>" id="nf_cust_cty_nm" /><!-- 
							 --><input type="text" name="nf_cust_ste_cd" style="width:40px;" maxlength="3" dataformat="engup" class="input" value="<%=nfCustSteCd%>" id="nf_cust_ste_cd" /></td>
						<th>Country</th>
						<td><input type="text" name="nf_cstms_decl_cnt_cd" style="width:30px;" maxlength="2" dataformat="engup" class="input" value="<%=nfCstmsDeclCntCd%>" id="nf_cstms_decl_cnt_cd" /><!-- 
						--><strong>Zip CD </strong><!-- 
						--><input type="text" name="nf_cust_zip_id" style="width:69px;" maxlength="10" dataformat="engup" otherchar="-" class="input" value="<%=nfCustZipId%>" id="nf_cust_zip_id" /><!-- 
						--><button type="button" id="btn_t7NfZipCode" name="btn_t7NfZipCode" class="input_seach_btn"></button></td>
						<td></td>
					</tr>			
					<tr>
						<td></td>
						<th>Street/P.O.Box</th>
						<td><input type="text" name="nf_eur_cstms_st_nm" style="width:130px;" class="input" value="" tabindex="19" dataformat="exceptengdn" maxlength="50" id="nf_eur_cstms_st_nm" /> </td>
						<th>EORI#</th>
						<td><input type="text" name="nf_eori_no" style="width:170px;" class="input" value="" tabindex="20" maxlength="20" dataformat="engup" id="nf_eori_no" /> </td>
						<td></td>
					</tr>
					</tbody>
				</table>
				<table>
					<colgroup>
						<col width="75" />	
						<col width="90" />	
						<col width="188" />	
						<col width="82" />	
						<col width="*" />				
				   </colgroup> 
					<tbody>
					<tr>
						<td></td>
						<th>Fax</th>
						<td><input type="text" name="nf_cust_fax_no" style="width:130px;" dataformat="engup" otherchar="-" class="input" maxlength="20" value="<%=nfCustFaxNo%>" id="nf_cust_fax_no" /> </td>
						<th>E-mail</th>
						<td><input type="text" name="nf_cust_eml" style="width:170px;" dataformat="engup" otherchar="<%=getSpecialChars()%>" class="input" value="<%=nfCustEml%>" id="nf_cust_eml" /></td>
					</tr>
					</tbody>
				</table>
				<table class="height_10"><tr><td colspan="8"></td></tr></table>
				<table style="table-layout:fixed">
					<colgroup>
						<col width="75" />				
						<col width="300" />						
						<col width="50" />		
						<col width="100" />		
						<col width="*" />				
				   </colgroup> 
					<tbody>
						<tr>
							<th>Forwarder</th>
							<td><input type="text" name="ff_cust_cnt_cd" id="ff_cust_cnt_cd" style="width:30px;" maxlength="2" dataformat="engup" class="input" value="<%=ffCustCntCd%>"></input><!-- 
								 --><button type="button" id="btn_t7Ff0192" name="btn_t7Ff0192" class="input_seach_btn"></button><!-- 
								 --><input type="text" name="ff_cust_seq" id="ff_cust_seq" style="width:55px;" maxlength="6" dataformat="engup" class="input" value="<%=ffCustSeq%>"></input><!-- 
								 --><button type="button" class="btn_down" name="btn_t7FfMdmCustNm" id="btn_t7FfMdmCustNm"></button><!-- 
								 --><input type="text" name="ff_cust_lgl_eng_nm" id="ff_cust_lgl_eng_nm" style="width:130px;" class="input2" value="<%=ffCustLglEngNm%><%=ffCustAddr%>" readOnly></input>
							</td>
							<th>FMC No.</th>
							<td><input type="text" name="fmc_cd" id="fmc_cd" style="width:65px;" class="input" value="<%=fmcCD%>" tabindex=65></input></td>
							<td></td>
						</tr>
						<tr>
							<td style="text-align:right">Name&<br>Address<br>(<label for ="ff_addr_prn_flg">Print</label><input type="checkbox" name="ff_addr_prn_flg" id="ff_addr_prn_flg" value="Y" class="trans" <%=("Y".equals(ffAddrPrnFlg))?"checked":""%>>)</td>
							<td colspan="2"><textarea name="ff_cust_nm" id="ff_cust_nm" style="resize:none;font-family:Courier New; font-size:15px; text-indent:0px;overflow-x:hidden;overflow-y:scroll" class="textarea_img5" rows="5" dataformat="engup" otherchar="<%=getSpecialChars()%>"><%=ffCustNm%></textarea></td><!-- onBlur="javascript:validateCols('5','35',this);"  -->
						</tr>
					</tbody>	
				</table>
				<table class="height_10"><tr><td colspan="8"></td></tr></table>
				<table style="table-layout:fixed">
					<colgroup>
						<col width="75" />	
						<col width="350" />									
						<col width="*" />				
				   </colgroup> 
					<tbody>
						<tr>
							<th>Also NTFY</th>
							<td><input type="text" name="an_cust_cnt_cd" id="an_cust_cnt_cd" style="width:30px;" maxlength="2" dataformat="engup" class="input" value="<%=anCustCntCd%>"></input><!-- 
							 --><button type="button" id="btn_t7An0192" name="btn_t7An0192" class="input_seach_btn"></button><!-- 
							 --><input type="text" name="an_cust_seq" id="an_cust_seq" style="width:55px;" maxlength="6" dataformat="engup" class="input" value="<%=anCustSeq%>"></input><!-- 
							 --><button type="button" class="btn_down" name="btn_t7AnMdmCustNm" id="btn_t7AnMdmCustNm"></button><!-- 
							 --><input type="text" name="an_cust_lgl_eng_nm"  id="an_cust_lgl_eng_nm" style="width:130px;" class="input2" value="<%=anCustLglEngNm%><%=anCustAddr%>" readOnly></input>
							</td>
							<td></td>
						</tr>
						<tr>
							<td style="text-align:right">Name &<br>Address<br>(<label for ="an_addr_prn_flg">Print</label><input type="checkbox" name="an_addr_prn_flg" id="an_addr_prn_flg" value="Y" class="trans" <%=("Y".equals(anAddrPrnFlg))?"checked":""%>>)</td>
							<td colspan="1"><textarea name="an_cust_nm" id="an_cust_nm" style="resize:none;font-family:Courier New; font-size:15px; text-indent:0px;overflow-x:hidden;overflow-y:scroll" class="textarea_img5" rows="5" dataformat="engup" otherchar="<%=getSpecialChars()%>"><%=anCustNm%></textarea></td><!-- onBlur="javascript:validateCols('5','35',this);" -->
						</tr>
					</tbody>
				</table>
				<table class="height_10"><tr><td colspan="7"></td></tr></table>
				<table style="table-layout:fixed">
					<colgroup>
						<col width="75"/>
						<col width="350"/>
						<col width="*" />				
					</colgroup>
					<tbody>
						<tr>
							<th>Export<br>Ref.</th>
							<td rowspan="3"><textarea name="ex_cust_nm" id="ex_cust_nm" style="resize:none;font-family:Courier New; font-size:15px; text-indent:0px;overflow-x:hidden;overflow-y:scroll" class="textarea_img3" rows="3" dataformat="engup" otherchar="<%=getSpecialChars()%>"><%=exCustNm%></textarea></td><!-- onBlur="javascript:validateCols('3','35',this);"  -->
						</tr>
						<tr>
							<td style="text-align:right"><label for = "ex_addr_prn_flg">Print</label><input type="checkbox" name="ex_addr_prn_flg" id="ex_addr_prn_flg" value="Y" class="trans" <%=("Y".equals(exAddrPrnFlg))?"checked":""%>></td>
						</tr>
					</tbody>
				</table>
				<table> 
					<colgroup>
						<col width="75"/>
						<col width="*"/>
					</colgroup>
					<tbody>
						<tr>
							<td style="text-align:right" rowspan="3">Country<br>of Origin</td>
							<td rowspan="3"><input type="text" name="org_cnt_nm" id="org_cnt_nm" style="width:330px;" dataformat="engup" class="input" maxlength=35 value="<%=orgCntNm%>"></td>
						</tr>
					</tbody>
				</table>
				<table class="height_10"><tr><td colspan="2"></td></tr></table>
				<!-- table style="table-layout:fixed">
					<colgroup>
						<col width="75"/>
						<col width="350"/>
						<col width="*"/>
					</colgroup>
				<tbody>
					<tr>
						<th>Broker</th>
						<td><input type="text" name="br_cust_cnt_cd" id="br_cust_cnt_cd" style="width:250px;" dataformat="engup" class="input" value="<%//=brCustNm%>"></td>
					</tr>
					<tr>
						<td  rowspan="2"></td>
						<td><textarea name="br_cust_nm" id="br_cust_nm" style="resize:none;font-family:Courier New; font-size:15px; text-indent:0px;overflow-x:hidden;overflow-y:scroll" rows="4" dataformat="engup" otherchar="<%//=getSpecialChars()%>"><%//=brCustNm%></textarea><br></td>
					</tr>
					<tr>
						<td><textarea name="br_cust_addr"  id="br_cust_addr" style="resize:none;font-family:Courier New; font-size:15px; text-indent:0px;overflow-x:hidden;overflow-y:scroll" rows="4" dataformat="engup" otherchar="<%//=getSpecialChars()%>"><%//=brCustAddr%></textarea><br></td>
					</tr>
				</tbody>
			</table-->
			</div>
			<!-- opus_design_inquiry(E) -->
		</div>
   	</div>
	<div class="layout_vertical_2" >
		<div class="wrap_search sm">
			<div class="opus_design_grid">
				<h3 class="title_design">From e- Service</h3>
				<div class="specialCls">
					<button type="button" class="btn_etc" name="btn_datacopytoopus" id="btn_datacopytoopus">Data Copy to OPUS</button>
				</div>
			</div>
	      	<!-- opus_design_inquiry(S) -->
			<div class="opus_design_inquiry">
				<table>
					<colgroup>
						<col width="75"/>
						<col width="*"/>
					</colgroup>
					<tbody>
						<tr>
							<th>Request No.</th>
							<td><input type="text" name="xter_rqst_no" id="xter_rqst_no" style="width:105px;" class="input2" value="<%=xterRqstNo%>" readOnly></td>
						</tr>
					</tbody>
				</table>
				<table>
					<colgroup>
						<col width="75"/>
						<col width="70"/>
						<col width="*"/>
					</colgroup>
					<tbody>
						<tr>
							<th>Shipper</th>
							<td colspan="5"><input type="text" name="sh_cust_cnt_cd2" id="sh_cust_cnt_cd2" style="width:30px;" class="input2" value="<%=shCustCntCd2%>" readOnly><!-- 
							 --><input type="text" name="sh_cust_seq2" id="sh_cust_seq2" style="width:55px;" class="input2" value="<%=shCustSeq2%>" readOnly><!-- 
							 --><input type="text" name="sh_cust_lgl_eng_nm2" id="sh_cust_lgl_eng_nm2" style="width:140px;" class="input2" value="<%=shCustLglEngNm2%>" readOnly>
							    <input type="text" name="sh_kr_cstms_cust_tp_cd2" value="<%=shKrCstmsCustTpCd2%>" id="sh_kr_cstms_cust_tp_cd2" style="width:30px;" class="input2" readOnly></td>
						</tr>
						<tr>
							<td style="text-align:right">Name</td>
							<td colspan="6"><textarea name="sh_cust_nm2" id="sh_cust_nm2" cols="43" rows="2" style="resize:none;font-family:Courier New; font-size:15px; text-indent:0px;overflow-x:hidden;overflow-y:scroll" class="textarea2" readOnly><%=shCustNm2%></textarea></td>
						</tr>
						<tr>
							<td style="text-align:right">Address</td>
							<td colspan="6"><textarea name="sh_cust_addr2"  id="sh_cust_addr2" cols="43" rows="3" style="resize:none;font-family:Courier New; font-size:15px; text-indent:0px;overflow-x:hidden;overflow-y:scroll" class="textarea2" readOnly><%=shCustAddr2%></textarea></td>
						</tr>
					</tbody>
				</table>
				<table>
					<colgroup>
						<col width="75">	
						<col width="90">				
						<col width="150">				
						<col width="100">	
						<col width="120">				
						<col width="*">	
					</colgroup>
					<tbody>
						<tr>
							<td></td>
							<th>City/State</th>
							<td><input type="text" name="sh_cust_cty_nm2" id="sh_cust_cty_nm2" style="width:85px;" class="input2" value="<%=shCustCtyNm2%>" readOnly><!-- 
							 --><input type="text" name="sh_cust_ste_cd2" id="sh_cust_ste_cd2" style="width:40px;" class="input2" value="<%=shCustSteCd2%>" readOnly></td>
							<th>Country</th>
							<td><input type="text" name="sh_cstms_decl_cnt_cd2" id="sh_cstms_decl_cnt_cd2" style="width:30px;" class="input2" value="<%=shCstmsDeclCntCd2%>" readOnly><!-- 
							--><strong>Zip CD </strong><!-- 
							--><input type="text" name="sh_cust_zip_id2" id="sh_cust_zip_id2" style="width:60px;" class="input2" value="<%=shCustZipId2%>" readOnly><!-- 
							 --><button type="button" id="btn_t7ShZipCode" name="btn_t7ShZipCode" class="input_seach_btn"></button></td>
							 <td></td>
						</tr>
						<tr>
							<td></td>
							<th>Street/P.O.Box</th>
							<td><input type="text" name="sh_eur_cstms_st_nm2" id="sh_eur_cstms_st_nm2" style="width:130px;" class="input2" value="<%=shEurCstmsStNm2%>" readOnly>
							<th>EORI#</th>
							<td><input type="text"  name="sh_eori_no2" id="sh_eori_no2" style="width:163px;" class="input2" value="<%=shEoriNo2%>" tabindex=20 maxlength=20 style="ime-mode:disabled"  dataformat="engup" readOnly></td>
							<td></td>
						</tr>
					</tbody>
				</table>
				<table class="height_10"><tr><td colspan="8"></td></tr></table>
				<table>
					<colgroup>
						<col width="75"/>
						<col width="70"/>
						<col width="*"/>
					</colgroup>
					<tbody>
						<tr>
							<th>Consignee</th>
							<td colspan="5"><input type="text" name="cn_cust_cnt_cd2" id="cn_cust_cnt_cd2" style="width:30px;" class="input2" value="<%=cnCustCntCd2%>" readOnly><!-- 
							 --><input type="text" name="cn_cust_seq2" id="cn_cust_seq2" style="width:55px;" class="input2" value="<%=cnCustSeq2%>" readOnly><!-- 
							 --><input type="text" name="cn_cust_lgl_eng_nm2" id="cn_cust_lgl_eng_nm2" style="width:130px;" class="input2" value="<%=cnCustLglEngNm2%>" readOnly></td>
							<td align="right"></td>
						</tr>
						<tr>
							<td style="text-align:right">Name</td>
							<td colspan="6"><textarea name="cn_cust_nm2" id="cn_cust_nm2" cols="43" rows="2" style="resize:none;font-family:Courier New; font-size:15px; text-indent:0px;overflow-x:hidden;overflow-y:scroll" class="textarea2" readOnly><%=cnCustNm2%></textarea></td>
						</tr>
						<tr>
							<td style="text-align:right">Address</td>
							<td colspan="6"><textarea name="cn_cust_addr2" id="cn_cust_addr2" cols="43" rows="3" style="resize:none;font-family:Courier New; font-size:15px; text-indent:0px;overflow-x:hidden;overflow-y:scroll" class="textarea2" readOnly><%=cnCustAddr2%></textarea></td>
						</tr>
					</tbody>
				</table>
				<table>
					<colgroup>
						<col width="75">	
						<col width="90">				
						<col width="150">				
						<col width="100">	
						<col width="120">				
						<col width="*">	
					</colgroup>
					<tbody>
						<tr>
							<td></td>
							<th>City/State</th>
							<td><input type="text" name="cn_cust_cty_nm2" id="cn_cust_cty_nm2" style="width:85px;" class="input2" value="<%=cnCustCtyNm2%>" readOnly><!-- 
							 --><input type="text" name="cn_cust_ste_cd2" id="cn_cust_ste_cd2" style="width:40px;" class="input2" value="<%=cnCustSteCd2%>" readOnly></td>
							<th>Country</th>
							<td><input type="text" name="cn_cstms_decl_cnt_cd2" id="cn_cstms_decl_cnt_cd2" style="width:30px;" class="input2" value="<%=cnCstmsDeclCntCd2%>" readOnly><!-- 
							--><strong>Zip CD </strong><!-- 
							--><input type="text" name="cn_cust_zip_id2" id="cn_cust_zip_id2" style="width:60px;" class="input2" value="<%=cnCustZipId2%>" readOnly><!-- 
							 --><button type="button" id="btn_t7CnZipCode" name="btn_t7CnZipCode" class="input_seach_btn"></button></td>
							<td></td>
						</tr>
						<tr>
							<td></td>
							<th>Street/P.O.Box</th>
							<td><input type="text" name="cn_eur_cstms_st_nm2" id="cn_eur_cstms_st_nm2" style="width:130px;" class="input2" value="<%=cnEurCstmsStNm2%>" tabindex=19 dataformat="engup" maxlength=50 style="ime-mode:disabled" readOnly>
							<th>EORI#</th>
							<td><input type="text"  name="cn_eori_no2" id="cn_eori_no2" style="width:163px;" class="input2" value="<%=cnEoriNo2%>" tabindex=20 maxlength=20 style="ime-mode:disabled"  dataformat="engup" readOnly></td>
							<td></td>
						</tr>
						</tbody>
				</table>
				<table>
					<colgroup>
						<col width="75" />	
						<col width="90" />	
						<col width="168" />	
						<col width="82" />	
						<col width="*" />				
				   </colgroup> 
					<tbody>
						<tr>
							<td></td>
							<th>Fax</th>
							<td><input type="text" name="cn_cust_fax_no2" id="cn_cust_fax_no2" style="width:130px;" class="input2" value="<%=cnCustFaxNo2%>" readOnly></td>
							<th>E-mail</th>
							<td><input type="text" name="cn_cust_eml2" id="cn_cust_eml2" style="width:163px;" class="input2" value="<%=cnCustEml2%>" readOnly></td>
						</tr>
					</tbody>
				</table>
				<table class="height_10"><tr><td colspan="7"></td></tr></table>
				<table>
					<colgroup>
						<col width="75"/>
						<col width="70"/>
						<col width="*"/>
					</colgroup>
					<tbody>
						<tr>
							<th>Notify</th>
							<td><input type="text" name="nf_cust_cnt_cd2" id="nf_cust_cnt_cd2" style="width:30px;" class="input2" value="<%=nfCustCntCd2%>" readOnly><!-- 
							 --><input type="text" name="nf_cust_seq2" id="nf_cust_seq2" style="width:55px;" class="input2" value="<%=nfCustSeq2%>" readOnly><!-- 
							 --><input type="text" name="nf_cust_lgl_eng_nm2" id="nf_cust_lgl_eng_nm2" style="width:130px;" class="input2" value="<%=nfCustLglEngNm2%>" readOnly></td>
							<td></td>
						</tr>
					</tbody>
				</table>
				<table>
					<colgroup>
						<col width="75"/>
						<col width="*"/>
					</colgroup>
					<tbody>
						<tr>
							<td style="text-align:right">Name</td>
							<td colspan="6"><textarea name="nf_cust_nm2" id="nf_cust_nm2" cols="43" rows="2" style="resize:none;font-family:Courier New; font-size:15px; text-indent:0px; overflow-x:hidden; overflow-y:scroll" class="textarea2" readOnly><%=nfCustNm2%></textarea></td>
						</tr>
						<tr>
							<td style="text-align:right">Address</td>
							<td colspan="6"><textarea name="nf_cust_addr2" id="nf_cust_addr2" cols="43" rows="3" style="resize:none;font-family:Courier New; font-size:15px; text-indent:0px;overflow-x:hidden;overflow-y:scroll" class="textarea2" readOnly><%=nfCustAddr2%></textarea></td>
						</tr>
					</tbody>
				</table>
				<table>
					<colgroup>
						<col width="75">	
						<col width="90">				
						<col width="150">				
						<col width="100">	
						<col width="120">				
						<col width="*">	
					</colgroup>
					<tbody>	
						<tr>
							<td></td>
							<th>City/State</th>
							<td><input type="text" name="nf_cust_cty_nm2" id="nf_cust_cty_nm2" style="width:85px;" class="input2" value="<%=nfCustCtyNm2%>" readOnly><!-- 
							 --><input type="text" name="nf_cust_ste_cd2" id="nf_cust_ste_cd2" style="width:40px;" class="input2" value="<%=nfCustSteCd2%>" readOnly></td>
							<th>Country</th>
							<td><input type="text" name="nf_cstms_decl_cnt_cd2" id="nf_cstms_decl_cnt_cd2" style="width:30px;" class="input2" value="<%=nfCstmsDeclCntCd2%>" readOnly><!-- 
							--><strong>Zip CD </strong><!-- 
							--><input type="text" name="nf_cust_zip_id2" id="nf_cust_zip_id2" style="width:60px;" class="input2" value="<%=nfCustZipId2%>" readOnly><!-- 
							 --><button type="button" id="btn_t7NfZipCode" name="btn_t7NfZipCode" class="input_seach_btn"></button></td>
							 <td></td>
						</tr>
						<tr>
							<td></td>
							<th>Street/P.O.Box</th>
							<td ><input type="text" name="nf_eur_cstms_st_nm2" id="nf_eur_cstms_st_nm2" style="width:130px;" class="input2" value="<%=nfEurCstmsStNm2%>" tabindex=19 dataformat="exceptengdn" maxlength=50 style="ime-mode:disabled" readOnly>
							<th>EORI#</th>
							<td ><input type="text"  name="nf_eori_no2" id="nf_eori_no2" style="width:163px;" class="input2" value="<%=nfEoriNo2%>" tabindex=20 maxlength=20 style="ime-mode:disabled"  dataformat="engup" readOnly></td>
							<td></td>
						</tr>
					</tbody>
				</table>
				<table>
					<colgroup>
						<col width="75" />	
						<col width="90" />	
						<col width="168" />	
						<col width="82" />	
						<col width="*" />				
				   </colgroup> 
					<tbody>					
						<tr>
							<td></td>
							<th>Fax</th>
							<td><input type="text" name="nf_cust_fax_no2" id="nf_cust_fax_no2" style="width:130px;" class="input2" value="<%=nfCustFaxNo2%>" readOnly></td>
							<th>E-mail</th>
							<td><input type="text" name="nf_cust_eml2" id="nf_cust_eml2" style="width:163px;" class="input2" value="<%=nfCustEml2%>" readOnly></td>
						</tr>
					</tbody>
				</table>
				<table class="height_10"><tr><td colspan="8"></td></tr></table>
				<table>
					<colgroup>
						<col width="75">
						<col width="65">	
						<col width="*">	
					</colgroup>
					<tbody>				
						<tr>
							<th>Forwarder</th>
							<td><input type="text" name="ff_cust_cnt_cd2" id="ff_cust_cnt_cd2" style="width:30px;" class="input2" value="<%=ffCustCntCd2%>" readOnly><!-- 
							 --><input type="text" name="ff_cust_seq2" id="ff_cust_seq2" style="width:55px;" class="input2" value="<%=ffCustSeq2%>" readOnly><!-- 
							 --><input type="text" name="ff_cust_lgl_eng_nm2" id="ff_cust_lgl_eng_nm2" style="width:130px;" class="input2" value="<%=ffCustLglEngNm2%><%//=ffCustAddr2%>" readOnly></td>
							<td></td>
						</tr>
					</tbody>
				</table>
				<table>
					<colgroup>
						<col width="75">
						<col width="*">	
					</colgroup>
					<tbody>			
						<tr>
							<td style="text-align:right" class="stm">Name & <br>Address</td>
							<td colspan="3"><textarea name="ff_cust_nm2" id="ff_cust_nm2" cols="43" rows="5" style="resize:none;font-family:Courier New; font-size:15px; text-indent:0px;overflow-x:hidden;overflow-y:scroll" class="textarea2" readOnly><%=ffCustNm2%></textarea></td>
						</tr>
					</table>
				<table class="height_10"><tr><td colspan="8"></td></tr></table>
				<table>
					<colgroup>
						<col width="75">
						<col width="65">	
						<col width="*">	
					</colgroup>
					<tbody>		
						<tr>
							<th>Also NTFY</th>
							<td><input type="text" name="an_cust_cnt_cd2" id="an_cust_cnt_cd2" style="width:30px;" class="input2" value="<%=anCustCntCd2%>" readOnly><!-- 
							 --><input type="text" name="an_cust_seq2" id="an_cust_seq2" style="width:55px;" class="input2" value="<%=anCustSeq2%>" readOnly>
							 <input type="text" name="an_cust_lgl_eng_nm2" id="an_cust_lgl_eng_nm2" style="width:130px;" class="input2" value="<%=anCustLglEngNm2%><%//=anCustAddr2%>" readOnly></td>
							<td></td>
						</tr>
						<tr>
							<td style="text-align:right">Name & <br>Address</td>
							<td colspan="3"><textarea name="an_cust_nm2" id="an_cust_nm2" cols="43" rows="5" style="resize:none;font-family:Courier New; font-size:15px; text-indent:0px;overflow-x:hidden;overflow-y:scroll" class="textarea2" readOnly><%=anCustNm2%></textarea></td>
						</tr>
					</tbody>
				</table>
				<table class="height_10"><tr><td colspan="8"></td></tr></table>
				<table>
					<colgroup>
						<col width="75">
						<col width="*">	
					</colgroup>
					<tbody>	
						<tr>
							<th>Export <br>Ref.</th>
							<td><textarea name="ex_cust_nm2" id="ex_cust_nm2" cols="43" rows="3" style="resize:none; font-family:Courier New; font-size:15px; text-indent:0px;overflow-x:hidden;overflow-y:scroll" class="textarea2" readOnly><%=exCustNm2%></textarea></td>
						</tr>
						<tr>
							<td style="text-align:right">Country<br>of Origin</td>
							<td><input type="text" style="width:400px;" class="input2" name="org_cnt_nm2" id="org_cnt_nm2" value="<%=orgCntNm2%>" readOnly></td>
						</tr>
					</tbody>
				</table>
				<table class="height_10"><tr><td colspan="8"></td></tr></table>
				<!-- table>
					<colgroup>
						<col width="75">
						<col width="*">	
					</colgroup>
					<tbody>	
						<tr>
							<th>Broker</th>
							<td><input type="text" name="br_cust_cnt_cd2" id="br_cust_cnt_cd2" style="width:130px;" class="input2" value="<%//=brCustCntCd2%>" readOnly></td>
						</tr>
						<tr>
							<td class="stm" rowspan="2"></td>
							<td><textarea name="br_cust_nm2" id="br_cust_nm2" cols="43" rows="4" style="resize:none;font-family:Courier New; font-size:15px; text-indent:0px;overflow-x:hidden;overflow-y:scroll" class="textarea2" readOnly><%//=brCustNm2%></textarea><br></td>
						</tr>
						<tr>
							<td><textarea name="br_cust_addr2" id="br_cust_addr2" cols="43" rows="4" style="resize:none;font-family:Courier New; font-size:15px; text-indent:0px;overflow-x:hidden;overflow-y:scroll" class="textarea2" readOnly><%//=brCustAddr2%></textarea><br></td>
						</tr>
					</tbody>
				</table>
				<table class="height_10"><tr><td colspan="4"></td></tr></table>
				<table>
					<colgroup>
						<col width="75">
						<col width="*">	
					</colgroup>
					<tbody>	
						<tr>
							<th>C.Broker</th> 
							<td><input type="text" name="cbr_cust_cnt_cd" id="cbr_cust_cnt_cd" style="width:250px;" class="input2" value="<%//=cbrCustNm2%>" readOnly></td>
						</tr>
						<tr>								
							<th>Fax No</th>
							<td><input name="cbr_fax12" id="cbr_fax12" style="width:250px;" class="input2" value="<%//=cbrFaxNo12%>" readOnly></td>
						</tr>
						<tr>								
							<td></td>
							<td><input name="cbr_fax22" id="cbr_fax22" style="width:250px;" class="input2" value="<%//=cbrFaxNo22%>" readOnly></td>
						</tr>
						<tr>								
							<td></td>
							<td><input name="cbr_fax32" id="cbr_fax32" style="width:250px;" class="input2" value="<%//=cbrFaxNo32%>" readOnly></td>							
						</tr>
					</tbody>
				</table-->
			</div>
			<!-- opus_design_inquiry(E) -->
		</div>
	</div>
</div>
<!-- layout_wrap(e) -->

<!-- opus_design_grid(S) -->
<div class="opus_design_grid">
	<script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
<!-- opus_design_grid(E) -->

</form>
<%!
    public String getComboString(String name, String style, String css, String script, String selectedValue, String firstOption, List<BkgComboVO> comboList){
        StringBuffer html = new StringBuffer("");
        int len = comboList==null ? 0 : comboList.size();
        html.append("<select name=\""+name+"\" style=\""+style+"\"" + ((css==null || css.equals(""))? "" : " class=\""+css+"\"") + "" + ((script==null || script.equals(""))? "" : " onChange=\""+script+"()\"") + ">\n");
        for(int i=0;i<len;i++){
            BkgComboVO vo = comboList.get(i);
			if ( !"E".equals(vo.getVal()) ) {
	            html.append("<option value=\""+vo.getVal()+"\" "+((vo.getVal().equals(selectedValue))? "selected" : "")+">"+vo.getName()+"</option>\n");
			}
        }
        html.append("</select>\n");
        return html.toString();
    }

	public String getZeroLpad(String src) {
		StringBuffer lpadStr = new StringBuffer();
		if ( src != null && src.length() > 0 ) {
			int lpadCount = 6 - src.length();
			for (int i=0;i<lpadCount;i++) {
				lpadStr.append("0");
//				lpadStr = lpadStr + "0";
			}
		} else src = "";
		return lpadStr.toString()+src;
	}
		
	public String getSpecialChars() {
		return " ~!@#$%^&*()`_+-={}|[]\\\"\\':;,./?"; 
	}
		
%>