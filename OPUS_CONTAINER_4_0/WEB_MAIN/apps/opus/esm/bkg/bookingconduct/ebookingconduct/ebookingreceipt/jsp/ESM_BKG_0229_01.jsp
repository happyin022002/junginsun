<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0229_01.jsp
*@FileTitle  : e-Booking & SI Process Detail(BOOKING)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/05
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%@ page import="java.util.List"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkg022901Event"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO"%>
<%@ page import="com.clt.apps.opus.esm.bkg.common.*"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.*"%>
<%@ page import="com.clt.framework.core.controller.DefaultViewAdapter"%>
<%@ page import="com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.DocRqstVO" %>

<%
	EsmBkg022901Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //error from server
	String strErrMsg = ""; //error message
	int rowCount = 0; //count of DB resultSET list

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String strOfc_cd = "";
	Logger log = Logger.getLogger("com.clt.apps.EBookingConduct.EBookingReceipt");

	List<BkgComboVO> frt_term_cd 		= null;
	List<BkgComboVO> rcv_term 			= null;
	List<BkgComboVO> dlv_term 			= null;
	List<BkgComboVO> wgt_ut_cd 			= null;
	List<BkgComboVO> usa_cstms_file_cd 	= null;
	List<BkgComboVO> cnd_cstms_file_cd 	= null;
	DocRqstVO docRqstVO = null;
	
	String sXml = null;

	XterRqstMstVO rqstVo 	= new XterRqstMstVO();
	XterRqstTabVO rqstTabVo = null;

	//key no
	String bkgNo    = "";
	String blNo     = "";
	String bkgStsCd = "";
	String bdrFlg 	= "";
	String caFlg 	= "";
	String mstBkgNo = "";
	String pctlNo   = "";
	String mnlBkgNoFlg = "";
	
	//route
	String vvd 		= "";
	String vslEngNm = "";
	String porCd 	= "";
	String porYdCd	= "";
	String porNm 	= "";
	String polCd 	= "";
	String polYdCd 	= "";
	String polNm    = "";
	String podCd 	= "";
	String podYdCd 	= "";
	String podNm 	= "";
	String delCd 	= "";
	String delYdCd  = "";
	String delNm	= "";
	String rcvTerm  = "";
	String dlvTerm  = "";
	String fnlDestCd= "";
	String fnlDestNm= "";
	String preRlyPortCd = "";
	String pstRlyPortCd = "";
	String mtyPkupYdCd  = "";
	String pkupDate     = "";
	String fullRtnYdCd  = "";
	String doorDate     = "";
	String loadingDate  = "";
	String deliveryDate = "";
	String orgTrnsModCd = "";
	String destTrnsModCd= "";
	String orgScontiCd  = "";
	String destScontiCd = "";
	String orgTrnsSvcModCd  = "";
	String destTrnsSvcModCd = "";
	
	//customer
	String shNm  = "";
	String shCnt = "";
	String shSeq = "";
	String shSub = "";
	String shExist = "";
	String ffCnt = "";
	String ffSeq = "";
	String ffNm  = "";
	String ffSub = "";
	String ffExist = "";
		
	String obSlsOfcCd = "";
	String obSrepCd   = "";
	String cmdtCd 	  = "";
	String cmdtNm     = "";
	String repCmdtCd  = "";
	String repCmdtNm  = "";
	String actWgt     = "";
	String wgtUtCd    = "";
	
	// contact
	String frtTermCd = "";
	String ctrtType  = "";
	String scNo 	 = "";
	String rfaNo     = "";
	String taaNo     = "";
	String ctrtTaa   = "";
	
	//cargo flag
	String dcgoFlg   = "";
	String rcFlg     = "";
	String awkCgoFlg = "";
	String bbCgoFlg  = "";
	String socFlg    = "";
	String spclHideFlg    = "";
	String prctFlg    = "";
	String fdGrdFlg    = "";
	String flexHgtFlg= "";
	String twnSoNo   = "";
	String rdCgoFlg	 = "";
	
	//etc
	String vvdFlg		  = "";
	String isVlFlg        = "";
	String usaCstmsFileCd = "";
	String cndCstmsFileCd = ""; 
	String interRmk       = "";
	String xterRmk        = "";
	String ediHldFlg	  = "";
	String autoNotification    = "";
	String partialVvdAssignFlg = "";
	String premiumAvailableFlg = "";
	
	//contact person
	String bkCntcPsonNm     = "";
	String bkCntcPsonPhnNo  = "";
	String bkCntcPsonMphnNo = "";
	String bkCntcPsonFaxNo  = "";
	String bkCntcPsonEml    = "";
	String siCntcPsonNm     = "";
	String siCntcPsonPhnNo  = "";
	String siCntcPsonMphnNo = "";
	String siCntcPsonFaxNo  = "";
	String siCntcPsonEml    = "";
	
	//eBKG 
	String docTpCd 	        = "";
	String xterBkgRqstCd    = "";
	String xterBkgRqstRefNo = "";
	String siFlg 			= "";
	String xterSiCd 		= "";
	String xterSiRefNo 		= "";
	String bkgUpldStsCd 	= "";
	String bkgUpldStsNm 	= "";

	String scacCd			= "";
	
	// reference No.
	String invRefNo			= "";
	String bkgRefNo			= "";
	String bkgSHRefNo		= "";
	String bkgFFRefNo		= "";
	String siRefNo			= "";
	String siSHRefNo		= "";
	String siFFRefNo		= "";
	String regBkgNo			= "";
	String extMrnNo			= "";
	
	String vScRfa 			= ""; 
	String vDcgoFlg			= "";
	String vRcFlg 			= "";
	String vAwkCgoFlg		= "";
	String vBbCgoFlg		= "";
	String vSocFlg			= ""; 
	String vndrRmk			= "";
	
	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (EsmBkg022901Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		frt_term_cd 	  = (List<BkgComboVO>) eventResponse.getCustomData("frt_term_cd");
		rcv_term    	  = (List<BkgComboVO>) eventResponse.getCustomData("rcv_term");
		dlv_term    	  = (List<BkgComboVO>) eventResponse.getCustomData("dlv_term");
		wgt_ut_cd   	  = (List<BkgComboVO>) eventResponse.getCustomData("wgt_ut_cd");
		usa_cstms_file_cd = (List<BkgComboVO>) eventResponse.getCustomData("usa_cstms_file_cd");
		cnd_cstms_file_cd = (List<BkgComboVO>) eventResponse.getCustomData("cnd_cstms_file_cd");
		isVlFlg           = (String) eventResponse.getCustomData("is_vl_flg");

		ExternalRqstBkgVO rqstBkgVo = (ExternalRqstBkgVO) eventResponse.getCustomData("externalRqstBkgVO");
		rqstVo    = rqstBkgVo.getXterRqstMstVO();
		rqstTabVo = rqstBkgVo.getXterRqstTabVO();
		docRqstVO = (DocRqstVO) eventResponse.getCustomData("DocRqst");
		if (null!=rqstVo) {
			docTpCd = rqstVo.getDocTpCd();
			
			invRefNo		= eventResponse.getETCData("inv_ref_no");
			bkgRefNo		= eventResponse.getETCData("bkg_ref_no");
			bkgSHRefNo		= eventResponse.getETCData("bkg_sh_ref_no");
			bkgFFRefNo		= eventResponse.getETCData("bkg_ff_ref_no");
			siRefNo			= eventResponse.getETCData("si_ref_no");
			siSHRefNo		= eventResponse.getETCData("si_sh_ref_no");
			siFFRefNo		= eventResponse.getETCData("si_ff_ref_no");
			regBkgNo		= eventResponse.getETCData("reg_bkg_no");
			extMrnNo		= eventResponse.getETCData("ext_mrn_no");
			vndrRmk			= eventResponse.getETCData("vndr_rmk");
			if(vndrRmk == null || vndrRmk.equals("null")) vndrRmk = "";
			vScRfa 			= replaceNull(rqstVo.getScRfa());
			vDcgoFlg 		= replaceNull(rqstVo.getDcgoFlg());
			vRcFlg 			= replaceNull(rqstVo.getRcFlg());			
			vAwkCgoFlg 		= replaceNull(rqstVo.getAwkCgoFlg()); 
			vBbCgoFlg 		= replaceNull(rqstVo.getBbCgoFlg()); 
			vSocFlg 		= replaceNull(rqstVo.getSocFlg()); 
		}
		DefaultViewAdapter adapter = new DefaultViewAdapter();
		sXml = adapter.makeXML(request, response);
	} catch (Exception e) {
		out.println(e.toString());
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

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="isInquiry">

<!-- Groupmail Hidden --> 
<input type="hidden" name="gw_subject">
<input type="hidden" name="gw_contents">
<input type="hidden" name="gw_template" value="ESM_BKG_COMM_01T.html">
<input type="hidden" name="gw_args" value="reqcontents;">

<!-- RD -->
<input type="hidden" name="com_mrdPath">
<input type="hidden" name="com_mrdArguments">
<input type="hidden" name="com_mrdBodyTitle" value="e-Booking &amp; SI Preview">
<input type="hidden" name="com_zoomIn" value="3">

<!-- login user -->
<input type="hidden" name="usr_id" value="<%=strUsr_id%>">
<input type="hidden" name="usr_ofc_cd" value="<%=strOfc_cd%>">

<input type="hidden" name="xter_rqst_acpt_cd" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo.getXterRqstAcptCd())%>">
<input type="hidden" name="xter_rqst_acpt_usr_id" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo.getXterRqstAcptUsrId())%>">
<input type="hidden" name="xter_rqst_acpt_usr_nm" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo.getXterRqstAcptUsrNm())%>">

<input type="hidden" name="tro_pkup_dt" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo.getTroPkupDt())%>">

<!-- eBKG -->
<input type="hidden" name="sender_id"  value="<%=StringUtil.xssFilter(request.getParameter("sender_id"))%>">
<input type="hidden" name="rqst_no"    value="<%=StringUtil.xssFilter(request.getParameter("rqst_no"))%>">
<input type="hidden" name="rqst_seq"   value="<%=StringUtil.xssFilter(request.getParameter("rqst_seq"))%>">
<input type="hidden" name="mst_bkg_no" value="<%=mstBkgNo%>">

<%-- Tab activating to check Flag (ESM_BKG_0231) --%>
<input type="hidden" name="save_bkg_flag"  value="<%=null!= rqstTabVo && ("N".equals(replaceNull(rqstTabVo.getOpusBkg())) && "Y".equals(replaceNull(rqstTabVo.getXterBkg()))) ? "Y" : "N"%>"></input>
<input type="hidden" name="save_cust_flag" value="<%=null!= rqstTabVo && ("Y".equals(replaceNull(rqstTabVo.getOpusCust())) || "Y".equals(replaceNull(rqstTabVo.getXterCust()))) ? "Y" : "N"%>"></input>
<input type="hidden" name="save_cntr_flag" value="<%=null!= rqstTabVo && ("Y".equals(replaceNull(rqstTabVo.getOpusCntr())) || "Y".equals(replaceNull(rqstTabVo.getXterCntr()))) ? "Y" : "N"%>"></input>
<input type="hidden" name="save_mnd_flag"  value="<%=null!= rqstTabVo && ("Y".equals(replaceNull(rqstTabVo.getOpusMnd()))  || "Y".equals(replaceNull(rqstTabVo.getXterMnd()))) ? "Y" : "N"%>"></input>
<input type="hidden" name="save_cm_flag"   value="<%=null!= rqstTabVo && ("Y".equals(replaceNull(rqstTabVo.getOpusCm()))   || "Y".equals(replaceNull(rqstTabVo.getXterCm()))) ? "Y" : "N"%>"></input>
<input type="hidden" name="save_tro_flag"  value="<%=null!= rqstTabVo && ("Y".equals(replaceNull(rqstTabVo.getOpusTro()))  || "Y".equals(replaceNull(rqstTabVo.getXterTro()))) ? "Y" : "N"%>"></input>
<input type="hidden" name="save_rf_flag"   value="<%=null!= rqstTabVo && ("Y".equals(replaceNull(rqstTabVo.getOpusRf()))   || "Y".equals(replaceNull(rqstTabVo.getXterRf()))) ? "Y" : "N"%>"></input>
<input type="hidden" name="save_dg_flag"   value="<%=null!= rqstTabVo && ("Y".equals(replaceNull(rqstTabVo.getOpusDg()))   || "Y".equals(replaceNull(rqstTabVo.getXterDg()))) ? "Y" : "N"%>"></input>
<input type="hidden" name="save_ak_flag"   value="<%=null!= rqstTabVo && ("Y".equals(replaceNull(rqstTabVo.getOpusAwk()))  || "Y".equals(replaceNull(rqstTabVo.getXterAwk()))) ? "Y" : "N"%>"></input>
<input type="hidden" name="save_hbl_flag"  value="<%=null!= rqstTabVo && ("Y".equals(replaceNull(rqstTabVo.getOpusHbl1())) || "Y".equals(replaceNull(rqstTabVo.getXterHbl1()))) ? "Y" : "N"%>"></input>
<input type="hidden" name="save_hbl2_flag" value="<%=null!= rqstTabVo && ("Y".equals(replaceNull(rqstTabVo.getOpusHbl2())) || "Y".equals(replaceNull(rqstTabVo.getXterHbl2()))) ? "Y" : "N"%>"></input>

<input type="hidden" name="is_opus_null" value="">
<input type="hidden" name="opus_data_yn_flag"
	value="<%=null!=rqstTabVo ?
			          replaceNull(rqstTabVo.getOpusCust()) + "|"
					+ replaceNull(rqstTabVo.getOpusCntr()) + "|"
					+ replaceNull(rqstTabVo.getOpusMnd())  + "|"
					+ replaceNull(rqstTabVo.getOpusCm())   + "|"
					+ replaceNull(rqstTabVo.getOpusTro())  + "|"
					+ replaceNull(rqstTabVo.getOpusRf())   + "|"
					+ replaceNull(rqstTabVo.getOpusDg())   + "|"
					+ replaceNull(rqstTabVo.getOpusAwk())  + "|"
					+ replaceNull(rqstTabVo.getOpusHbl1()) + "|"
					+ replaceNull(rqstTabVo.getOpusHbl2()) : "N|N|N|N|N|N|N|N|N|N"%>">
<input type="hidden" name="xter_data_yn_flag"
	value="<%=null!=rqstTabVo ?
			          replaceNull(rqstTabVo.getXterCust()) + "|"
					+ replaceNull(rqstTabVo.getXterCntr()) + "|"
					+ replaceNull(rqstTabVo.getXterMnd())  + "|"
					+ replaceNull(rqstTabVo.getXterCm())   + "|"
					+ replaceNull(rqstTabVo.getXterTro())  + "|"
					+ replaceNull(rqstTabVo.getXterRf())   + "|"
					+ replaceNull(rqstTabVo.getXterDg())   + "|"
					+ replaceNull(rqstTabVo.getXterAwk())  + "|"
					+ replaceNull(rqstTabVo.getXterHbl1()) + "|"
					+ replaceNull(rqstTabVo.getXterHbl2()) : "N|N|N|N|N|N|N|N|N|N"%>">

<!-- Contact Person	(S) -->
<input type="hidden" name="bkg_cntc_pson_nm" 	 	value="<%=bkCntcPsonNm%>"> 
<input type="hidden" name="bkg_cntc_pson_phn_no" 	value="<%=bkCntcPsonPhnNo%>"> 
<input type="hidden" name="bkg_cntc_pson_eml" 	 	value="<%=bkCntcPsonEml%>"> 
<input type="hidden" name="bkg_cntc_pson_mphn_no" 	value="<%=bkCntcPsonMphnNo%>"> 
<input type="hidden" name="bkg_cntc_pson_fax_no" 	value="<%=bkCntcPsonFaxNo%>"> 
<input type="hidden" name="si_cntc_pson_nm" 		value="<%=siCntcPsonNm%>"> 
<input type="hidden" name="si_cntc_pson_phn_no" 	value="<%=siCntcPsonPhnNo%>">
<input type="hidden" name="si_cntc_pson_eml" 		value="<%=siCntcPsonEml%>">
<input type="hidden" name="si_cntc_pson_mphn_no" 	value="<%=siCntcPsonMphnNo%>"> 
<input type="hidden" name="si_cntc_pson_fax_no" 	value="<%=siCntcPsonFaxNo%>">

<input type="hidden" name="tmp_bkg_cntc_pson_nm"> 
<input type="hidden" name="tmp_bkg_cntc_pson_phn_no">
<input type="hidden" name="tmp_bkg_cntc_pson_eml">
<input type="hidden" name="tmp_bkg_cntc_pson_mphn_no"> 
<input type="hidden" name="tmp_bkg_cntc_pson_fax_no">
<input type="hidden" name="tmp_si_cntc_pson_nm"> 
<input type="hidden" name="tmp_si_cntc_pson_phn_no">
<input type="hidden" name="tmp_si_cntc_pson_eml">
<input type="hidden" name="tmp_si_cntc_pson_mphn_no"> 
<input type="hidden" name="tmp_si_cntc_pson_fax_no">

<input type="hidden" name="rqst_bl_tp_cd_old" 	 		value="<%=(docRqstVO == null) ? "" :replaceNull(docRqstVO.getRqstBlTpCd())%>"> 
<input type="hidden" name="obl_rt_incl_knt_old" 		value="<%=(docRqstVO == null) ? "" :replaceNull(docRqstVO.getOblRtInclKnt())%>"> 
<input type="hidden" name="obl_rt_xcld_knt_old" 	 	value="<%=(docRqstVO == null) ? "" :replaceNull(docRqstVO.getOblRtXcldKnt())%>"> 
<input type="hidden" name="non_nego_rt_incl_knt_old" 	value="<%=(docRqstVO == null) ? "" :replaceNull(docRqstVO.getNonNegoRtInclKnt())%>"> 
<input type="hidden" name="non_nego_rt_xcld_knt_old" 	value="<%=(docRqstVO == null) ? "" :replaceNull(docRqstVO.getNonNegoRtXcldKnt())%>"> 
<input type="hidden" name="rqst_iss_plc_nm_old" 		value="<%=(docRqstVO == null) ? "" :replaceNull(docRqstVO.getRqstIssPlcNm())%>"> 
<input type="hidden" name="rqst_iss_dt_old" 			value="<%=(docRqstVO == null) ? "" :replaceNull(docRqstVO.getRqstIssDt())%>">
<input type="hidden" name="bl_de_to_cd_old" 			value="<%=(docRqstVO == null) ? "" :replaceNull(docRqstVO.getBlDeToCd())%>">
<input type="hidden" name="bl_de_mzd_cd_old" 			value="<%=(docRqstVO == null) ? "" :replaceNull(docRqstVO.getBlDeMzdCd())%>"> 
<input type="hidden" name="bl_doc_rqst_rmk_old" 		value="<%=(docRqstVO == null) ? "" :replaceNull(docRqstVO.getBlDocRqstRmk())%>">

<!-- Reference	(S) -->
<input type="hidden" name="xter_inv_ref_no" 	 		value="<%=(rqstVo == null) ? "" :replaceNull(rqstVo.getInvRefNo())%>"> 
<input type="hidden" name="xter_bkg_ref_no" 			value="<%=(rqstVo == null) ? "" :replaceNull(rqstVo.getBkgRefNo())%>">
<input type="hidden" name="xter_bkg_sh_ref_no" 			value="<%=(rqstVo == null) ? "" :replaceNull(rqstVo.getBkgSHRefNo())%>"> 
<input type="hidden" name="xter_bkg_ff_ref_no" 			value="<%=(rqstVo == null) ? "" :replaceNull(rqstVo.getBkgFFRefNo())%>"> 
<input type="hidden" name="xter_si_reference_no" 		value="<%=(rqstVo == null) ? "" :replaceNull(rqstVo.getSiRefNo())%>">
<input type="hidden" name="xter_si_sh_ref_no" 			value="<%=(rqstVo == null) ? "" :replaceNull(rqstVo.getSiSHRefNo())%>">
<input type="hidden" name="xter_si_ff_ref_no" 			value="<%=(rqstVo == null) ? "" :replaceNull(rqstVo.getSiFFRefNo())%>">
<input type="hidden" name="xter_reg_bkg_no" 			value="">
<input type="hidden" name="xter_ext_mrn_no" 			value="<%=(rqstVo == null) ? "" :replaceNull(rqstVo.getExtMrnNo())%>">

<input type="hidden" name="bkg_inv_ref_no" 	 			value="<%=invRefNo%>"> 
<input type="hidden" name="bkg_bkg_ref_no" 				value="<%=bkgRefNo%>"> 
<input type="hidden" name="bkg_bkg_sh_ref_no" 			value="<%=bkgSHRefNo%>"> 
<input type="hidden" name="bkg_bkg_ff_ref_no" 			value="<%=bkgFFRefNo%>"> 
<input type="hidden" name="bkg_si_ref_no" 				value="<%=siRefNo%>"> 
<input type="hidden" name="bkg_si_sh_ref_no" 			value="<%=siSHRefNo%>"> 
<input type="hidden" name="bkg_si_ff_ref_no" 			value="<%=siFFRefNo%>">
<input type="hidden" name="bkg_reg_bkg_no" 				value="<%=regBkgNo%>">
<input type="hidden" name="bkg_ext_mrn_no" 				value="<%=extMrnNo%>"> 
<input type="hidden" name="vndr_rmk" 	 				value="<%=vndrRmk%>">
<input type="hidden" name="lst_sav_dt" 					value=""/>
<!-- Reference	(E) -->

<!-- Contact Person	(E) -->

<!-- BDR, C/A Flag (E) -->

<!-- Contract Party (S) -->
<input type="hidden" name="bkg_ctrl_pty_cust_cnt_cd">
<input type="hidden" name="bkg_ctrl_pty_cust_seq"> 
<!-- Contract Party (E) -->

<!-- init data (S) -->
<input type="hidden" name="dflt_rcv_term_cd" value="Y">
<input type="hidden" name="dflt_de_term_cd"  value="Y">
<input type="hidden" name="dflt_wgt_ut_cd"   value="KGS">
<!-- init data (E) -->
<input type="hidden" name="bl_prf_shpr_flg" id="bl_prf_shpr_flg">
<input type="hidden" name="sXml" value="<%=JSPUtil.replace(sXml, "\"", "&quot;")%>">
<input type="hidden" name="usr_toyota_check" id="usr_toyota_check" value="N"/>
<input type="hidden" name="check_confirm" id="check_confirm" value="false"/>
<input type="hidden" name="bl_no_ck" id="bl_no_ck" value=""/>

<div id="showBkCntc" style="background-color: white;position: absolute; display: none;z-index:9999; border:solid;border-color:#b8d6f6">
	<table style="width:380px; border:0;" class="grid2">
		<colgroup>
			<col width="80"/>
			<col width="150"/>
			<col width="*" />				
		</colgroup> 
		<tr class="tr2_head">
			<th>Contact<br>Information</th>
			<th>BKG Contact</th>
			<th>S/I Contact</th>
		</tr>
		<tr>
			<th>Name</th>
			<td><span id="bkg_cntc_pson_nm_span"><%=bkCntcPsonNm%></span></td>
			<td><span id="si_cntc_pson_nm_span"><%=siCntcPsonNm%></span></td>
		</tr>
		<tr>
			<th>Tel.</th>
			<td><span id="bkg_cntc_pson_phn_no_span"><%=bkCntcPsonPhnNo%></span></td>
			<td><span id="si_cntc_pson_phn_no_span"><%=siCntcPsonPhnNo%></span></td>
		</tr>
		<tr>
			<th>Mobile</th>
			<td><span id="bkg_cntc_pson_mphn_no_span"><%=bkCntcPsonMphnNo%></span></td>
			<td><span id="si_cntc_pson_mphn_no_span"><%=siCntcPsonMphnNo%></span></td>
		</tr>
		<tr>
			<th>Fax</th>
			<td><span id="bkg_cntc_pson_fax_no_span"><%=bkCntcPsonFaxNo%></span></td>
			<td><span id="si_cntc_pson_fax_no_span"><%=siCntcPsonFaxNo%></span></td>
		</tr>
		<tr>
			<th>E-mail</th>
			<td><span id="bkg_cntc_pson_eml_span"><%=bkCntcPsonEml%></span></td>
			<td><span id="si_cntc_pson_eml_span"><%=siCntcPsonEml%></span></td>
		</tr>
	</table>
</div>
<div id="showXterDocReq" style="background-color: white;position: absolute; display: none;height:138px;z-index:9999;overflow-y:scroll;border:solid;border-color:#b8d6f6;">
	<table style="width:380px;border:0;" class="grid2">
		<colgroup>
			<col width="130"/>
			<col width="*" />				
		</colgroup>
		<tr>
			<th colspan="2">Doc Requirement</th>
		</tr>
		<tr>
			<th>B/L TYPE</th>
			<td><span id="wy_bl_flg"><%=(rqstVo == null) ? "" :replaceNull(rqstVo.getWyBlFlg())%></span></td>
		</tr>
		<tr>
			<th>No of OB/L(Rated)</th>
			<td><span id="incl_rt_bl_knt"><%=(rqstVo == null) ? "" :replaceNull(rqstVo.getInclRtBlKnt())%></span></td>
		</tr>
		<tr>
			<th>No of OB/L(Non-Rated)</th>
			<td><span id="xcld_rt_bl_knt"><%=(rqstVo == null) ? "" :replaceNull(rqstVo.getXcldRtBlKnt())%></span></td>
		</tr>
		<tr>
			<th>N/N Copy(Rated)</th>
			<td><span id="non_nego_rt_incl_knt2"><%=(rqstVo == null) ? "" :replaceNull(rqstVo.getNonNegoRtInclKnt())%></span></td>
		</tr>
		<tr>
			<th>N/N Copy(Non-Rated)</th>
			<td><span id="non_nego_rt_xcld_knt2"><%=(rqstVo == null) ? "" :replaceNull(rqstVo.getNonNegoRtXcldKnt())%></span></td>
		</tr>
		<tr>
			<th>Issue Place</th>
			<td><span id="bl_iss_loc_cd"><%=(rqstVo == null) ? "" :replaceNull(rqstVo.getBlIssLocCd())%></span></td>
		</tr>
		<tr>
			<th>Issue Date</th>
			<td><span id="bl_iss_dt"><%=(rqstVo == null) ? "" :replaceNull(rqstVo.getBlIssDt())%></span></td>
		</tr>
		<tr>
			<th>Deliver To</th>
			<td><span id=""></span></td>
		</tr>
		<tr>
			<th>Method</th>
			<td><span id=""></span></td>
		</tr>
		<tr>
			<th>Remark</th>
			<td><span id="bl_cluz_desc"><%=(rqstVo == null) ? "" :replaceNull(rqstVo.getBlCluzDesc())%></span></td>
		</tr>
	</table>
</div>
<!-- //2015.03.09 Reference No Button -->
<div id="showXterRef" style="background-color: white;position: absolute; display: none;height:138px;z-index:9999;overflow-y:scroll;border:solid;border-color:#b8d6f6;">
	<table style="width:380px;border:0;" class="grid2">
		<colgroup>
			<col width="130"/>
			<col width="*" />				
		</colgroup>
		<tr>
			<th>Invoice Ref. No.</th>
			<td><span id="xter_inv_ref_no_span"><%=(rqstVo == null) ? "" :replaceNull(rqstVo.getInvRefNo())%></span></td>
		</tr>
		<tr>
			<th>BKG Ref.No.</th>
			<td><span id="xter_bkg_ref_no_span"><%=(rqstVo == null) ? "" :replaceNull(rqstVo.getBkgRefNo())%></span></td>
		</tr>
		<tr>
			<th>BKG SH Ref. No.</th>
			<td><span id="xter_bkg_sh_ref_no_span"><%=(rqstVo == null) ? "" :replaceNull(rqstVo.getBkgSHRefNo())%></span></td>
		</tr>
		<tr>
			<th>BKG FF Ref. No.</th>
			<td><span id="xter_bkg_ff_ref_no_span"><%=(rqstVo == null) ? "" :replaceNull(rqstVo.getBkgFFRefNo())%></span></td>
		</tr>
		<tr>
			<th>S/I Ref. No.</th>
			<td><span id="xter_si_ref_no_span"><%=(rqstVo == null) ? "" :replaceNull(rqstVo.getSiRefNo())%></span></td>
		</tr>
		<tr>
			<th>S/I SH Ref. No.</th>
			<td><span id="xter_si_sh_ref_no_span"><%=(rqstVo == null) ? "" :replaceNull(rqstVo.getSiSHRefNo())%></span></td>
		</tr>
		<tr>
			<th>S/I FF Ref. No.</th>
			<td><span id="xter_si_ff_ref_no_span"><%=(rqstVo == null) ? "" :replaceNull(rqstVo.getSiFFRefNo())%></span></td>
		</tr>
		<tr>
			<th>Regional BKG No.</th>
			<td><span id="xter_reg_bkg_no_span"></span></td>
		</tr>
		<tr>
			<th>Export MRN No.</th>
			<td><span id="xter_ext_mrn_no_span"><%=(rqstVo == null) ? "" :replaceNull(rqstVo.getExtMrnNo())%></span></td>
		</tr>
	</table>
</div>

<div id="showBkgDocReq" style="background-color: white;position: absolute; display: none;height:138px;overflow-y:scroll;z-index:9999;border:solid;border-color:#b8d6f6">
	<table style="width:380px;border:0;"class="grid2">
		<colgroup>
			<col width="130"/>
			<col width="*" />				
		</colgroup> 
		<tr>
			<th colspan="2">Doc Requirement</th>
		</tr>
		<tr>
			<th>B/L TYPE</th>
			<td><!-- 
				 --><label for="rqst_bl_tp_cd1"><!-- 
					 --><input type="radio" value="W" <%=(docRqstVO == null) ? "" :"W".equals(replaceNull(docRqstVO.getRqstBlTpCd())) ? "checked" : ""%> name="rqst_bl_tp_cd" id="rqst_bl_tp_cd1" class="trans">Sea Waybill</label> <!--
				--><label for="rqst_bl_tp_cd2"><!--
					--><input type="radio" value="O" <%=(docRqstVO == null) ? "" :"O".equals(replaceNull(docRqstVO.getRqstBlTpCd())) ? "checked" : ""%> name="rqst_bl_tp_cd" id='rqst_bl_tp_cd2' class="trans">O.B/L</label><!--
				--><label for="rqst_bl_tp_cd3"><!--
					--><input type="radio" value="S" <%=(docRqstVO == null) ? "" :"S".equals(replaceNull(docRqstVO.getRqstBlTpCd())) ? "checked" : ""%> name="rqst_bl_tp_cd" id='rqst_bl_tp_cd3' class="trans">Surrender</label><!--
			--></td>
		</tr>
		<tr>
			<th>No of OB/L(Rated)</th>
			<td><input type="text" style="width: 165px; center;" class="input" maxlength="8" dataformat="int" style="ime-mode:disabled" value="<%=(docRqstVO == null) ? "" :replaceNull(docRqstVO.getOblRtInclKnt()) %>" name="obl_rt_incl_knt"></td>
		</tr>
		<tr>
			<th>No of OB/L(Non-Rated)</th>
			<td><input type="text" style="width: 165px;" class="input" maxlength="8" dataformat="int" style="ime-mode:disabled" value="<%=(docRqstVO == null) ? "" :replaceNull(docRqstVO.getOblRtXcldKnt()) %>" name="obl_rt_xcld_knt"></td>
		</tr>
		<tr>
			<th>N/N Copy(Rated)</th>
			<td><input type="text" style="width: 165px;" class="input" maxlength="8" dataformat="int" style="ime-mode:disabled" value="<%=(docRqstVO == null) ? "" :replaceNull(docRqstVO.getNonNegoRtInclKnt()) %>" name="non_nego_rt_incl_knt"></td>
		</tr>
		<tr>
			<th>N/N Copy(Non-Rated)</th>
			<td><input type="text" style="width: 165px;" class="input" maxlength="8" dataformat="int" style="ime-mode:disabled" value="<%=(docRqstVO == null) ? "" :replaceNull(docRqstVO.getNonNegoRtXcldKnt()) %>" name="non_nego_rt_xcld_knt"></td>
		</tr>
		<tr>
			<th>Issue Place</th>
			<td><input type="text" align="center" style="width: 165px;" class="input" maxlength="20" style="ime-mode:disabled" name="rqst_iss_plc_nm" value="<%=(docRqstVO == null) ? "" :replaceNull(docRqstVO.getRqstIssPlcNm())%>">
		</tr>
		<tr>
			<th>Issue Date</th>
			<td><input type="text" align="center" type="text" style="width: 165px;" class="input" maxlength="10" dataformat="ymd" style="ime-mode:disabled" value="<%=(docRqstVO == null) ? "" :replaceNull(docRqstVO.getRqstIssDt())%>" name="rqst_iss_dt" ></td>
		</tr>
		<tr>
			<th>Deliver To</th>
			<td><!--
				--><label for="bl_de_to_cd1"><!--
					--><input type="radio" value="S" <%=(docRqstVO == null) ? "" :"S".equals(replaceNull(docRqstVO.getBlDeToCd())) ? "checked" : ""%> name="bl_de_to_cd" id="bl_de_to_cd1" class="trans">Shipper</label><!--
				--><label for="bl_de_to_cd2"><!--
					--><input type="radio" value="F" <%=(docRqstVO == null) ? "" :"F".equals(replaceNull(docRqstVO.getBlDeToCd())) ? "checked" : ""%> name="bl_de_to_cd" id="bl_de_to_cd2" class="trans">FWDR</label><!--
			--></td>
		</tr>
		<tr>
			<th>Method</th>
			<td><!-- 
				--><label for="bl_de_mzd_cd1"><!--
					--><input type="radio" value="E" <%=(docRqstVO == null) ? "" :"E".equals(replaceNull(docRqstVO.getBlDeMzdCd())) ? "checked" : ""%> name="bl_de_mzd_cd" id="bl_de_mzd_cd1" class="trans">Express Mail</label><!--
				--><label for="bl_de_mzd_cd2"><!--
					--><input type="radio" value="R" <%=(docRqstVO == null) ? "" :"R".equals(replaceNull(docRqstVO.getBlDeMzdCd())) ? "checked" : ""%> name="bl_de_mzd_cd" id="bl_de_mzd_cd2" class="trans">Regular Mail</label><!--
				--><label for="bl_de_mzd_cd3"><!--
					--><input type="radio" value="P" <%=(docRqstVO == null) ? "" :"P".equals(replaceNull(docRqstVO.getBlDeMzdCd())) ? "checked" : ""%> name="bl_de_mzd_cd" id="bl_de_mzd_cd3" class="trans">Pick Up</label><!--
			--></td>
		</tr>
		<tr>
			<th>Remark</th>
			<td><textarea rows="2" style="width: 100%;" name="bl_doc_rqst_rmk" id="bl_doc_rqst_rmk"><%=(docRqstVO == null) ? "" :replaceNull(docRqstVO.getBlDocRqstRmk())%></textarea></td>
		</tr>
	</table>
</div>

<div id="showBkgRef" style="background-color: white;position: absolute; display: none;height:138px;overflow-y:scroll;z-index:9999;border:solid;border-color:#b8d6f6">
	<table style="width:380px;border:0;"class="grid2">
		<colgroup>
			<col width="130"/>
			<col width="*" />				
		</colgroup> 
		<tr>
			<th>Invoice Ref. No.</th>
			<td><input type="text" style="width: 165px; center;" class="input" maxlength="50" style="ime-mode:disabled" value="<%=invRefNo%>" id="inv_ref_no" name="inv_ref_no"></td>
		</tr>
		<tr>
			<th>BKG Ref.No.</th>
			<td><input type="text" style="width: 165px; center;" class="input" maxlength="50" style="ime-mode:disabled" value="<%=bkgRefNo %>" id="bkg_ref_no" name="bkg_ref_no"></td>
		</tr>
		<tr>
			<th>BKG SH Ref. No.</th>
			<td><input type="text" style="width: 165px; center;" class="input" maxlength="50" style="ime-mode:disabled" value="<%=bkgSHRefNo %>" id="bkg_sh_ref_no" name="bkg_sh_ref_no"></td>
		</tr>
		<tr>
			<th>BKG FF Ref. No.</th>
			<td><input type="text" style="width: 165px; center;" class="input" maxlength="50" style="ime-mode:disabled" value="<%=bkgFFRefNo %>" id="bkg_ff_ref_no" name="bkg_ff_ref_no"></td>
		</tr>
		<tr>
			<th>S/I Ref. No.</th>
			<td><input type="text" style="width: 165px; center;" class="input" maxlength="50" style="ime-mode:disabled" value="<%=siRefNo %>" id="si_ref_no" name="si_ref_no"></td>
		</tr>
		<tr>
			<th>S/I SH Ref. No.</th>
			<td><input type="text" style="width: 165px; center;" class="input" maxlength="50" style="ime-mode:disabled" value="<%=siSHRefNo%>" id="si_sh_ref_no" name="si_sh_ref_no">
		</tr>
		<tr>
			<th>S/I FF Ref. No.</th>
			<td><input type="text" style="width: 165px; center;" class="input" maxlength="50" style="ime-mode:disabled" value="<%=siFFRefNo%>" id="si_ff_ref_no" name="si_ff_ref_no" ></td>
		</tr>
		<tr>
			<th>Regional BKG No.</th>
			<td><input type="text" style="width: 165px; center;" class="input" maxlength="50" style="ime-mode:disabled" value="<%=regBkgNo%>" id="reg_bkg_no" name="reg_bkg_no" ></td>
		</tr>
		<tr>
			<th>Export MRN No.</th>
			<td><input type="text" style="width: 165px; center;" class="input" maxlength="50" style="ime-mode:disabled" value="<%=extMrnNo%>" id="ext_mrn_no" name="ext_mrn_no" ></td>
		</tr>
	</table>
</div>


<!-- layout_wrap (S) -->
<div class="layout_wrap" id="layout_wrap">
 	<div class="layout_vertical_2 pad_rgt_8"> <!-- style="width:600px;" -->
		<div class="wrap_search sm">
			<div class="opus_design_grid">
				<h3 class="title_design">Booking Data OPUS</h3>
			</div>
			<div class="opus_design_inquiry">
				<table>
					<colgroup>
						<col width="80" />
						<col width="260" />
						<col width="100" />
						<col width="*" />
					</colgroup>
					<tbody>
						<tr>
							<th>BKG No.</th>
							<td><input type="text" name="bkg_no" style="width: 105px;" maxlength="12" dataformat="engup" class="input" value="<%=bkgNo%>" id="bkg_no" /><!--
							--><button type="button" id="btn_find_bkg" name="btn_find_bkg" class="input_seach_btn"></button><!--
							--><strong>(<label for="mnl_bkg_no_flg">Manual No.</label></strong><input type="checkbox" name="mnl_bkg_no_flg" id="mnl_bkg_no_flg" value="" class="trans" onClick="javascript:changeBkgNoManual(this)"><!--
							--><strong>)</strong></td>
							<th>Upload Status</th>
							<td><!--
							--><input type="text" name="bkg_sts_nm" id="bkg_sts_nm" style="width: 60px;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo.getBkgUpldStsNm())%>" readonly tabindex="-1"><!--
							--><input type="hidden" name="bkg_upld_sts_cd" id="bkg_upld_sts_cd" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo.getBkgUpldStsCd())%>">
							</td>
						</tr>
						<tr>
							<th>B/L No.</th>
							<td><input type="text" name="bl_no" id="bl_no" style="width:105px" maxlength="12" class="input2" value="<%=blNo%>" readonly><!--
							--><button class="btn_etc" name="btn_gotobkg" id="btn_gotobkg" type="button">Go to BKG</button>
								<label for="bkg_wt_chk_flg"><font style="font-weight: bold">Wait</font></label><input type="checkbox" name="bkg_wt_chk_flg" id="bkg_wt_chk_flg" value="Y" class="trans" onclick="ediHldFlgChecked()">
							</td>
							<th><label for="edi_hld_flg">Auto EDI Hold</label></th>
							<td>
								<input type="checkbox" name="edi_hld_flg" id="edi_hld_flg" value="Y" class="trans" onclick="userCheck()">
								<label for="bkg_ty_flg"><font style="font-weight: bold;margin-left: 10px">For 10-digit BL No.</font></label>
								<input type="checkbox" name="bkg_ty_flg" id="bkg_ty_flg" value="Y" class="trans" onclick="toyotaClick()">
							</td>
						</tr>
						<tr>
							<th>Shipper</th>
							<td><!--
							--><input type="text" name="s_cust_cnt_cd" style="width: 25px;" maxlength="2" class="input1" dataformat="engup" value="<%=shCnt%>" id="s_cust_cnt_cd" /><!--
							--><input type="text" name="s_cust_seq" maxlength="6" style="width: 55px;" class="input1" dataformat="num" value="<%=shSeq%>" id="s_cust_seq" /><!--
							--><input type="text" name="s_cust_nm" style="width: 133px;" class="input2" value="<%=shNm%>" readonly tabindex="-1" id="s_cust_nm" /><!--
							--><button type="button" id="btn_0652ShprPop" name="btn_0652ShprPop" class="input_seach_btn"></button>
							</td>
							<th>L/Rep.</th>
							<td><!--
							--><input type="hidden" name="ob_sls_ofc_cd" value="<%=obSlsOfcCd%>" id="ob_sls_ofc_cd" /><!--
							--><input type="text" name="ob_srep_cd" style="width: 60px;" class="input1" maxlength="5" dataformat="engup" value="<%=obSrepCd%>" id="ob_srep_cd" />
							</td>
						</tr>
						<tr>
							<th>Forwarder</th>
							<td><!--
							--><input type="text" name="f_cust_cnt_cd" style="width: 25px;" maxlength="2" class="input" dataformat="engup" value="<%=ffCnt%>" id="f_cust_cnt_cd" /><!--
							--><input type="text" name="f_cust_seq" maxlength="6" style="width: 55px;" class="input" dataformat="num" value="<%=("0".equals(ffSeq)) ? "" : ffSeq%>" id="f_cust_seq" /><!--
							--><input type="text" name="f_cust_nm" style="width: 133px;" class="input2" value="<%=ffNm%>" readonly tabindex="-1" id="f_cust_nm" /><!--
							--><button type="button" id="btn_0652FwdrPop" name="btn_0652FwdrPop" class="input_seach_btn"></button>
							</td>										
							<th>Status</th>
							<td><input type="text" name="bkg_sts_cd" style="width: 20px;" class="input2" value="<%=bkgStsCd%>" readonly id="bkg_sts_cd" /></td>
						</tr>
					</tbody>
				</table>
				<table>
					<colgroup>
						<col width="30" />
						<col width="*" />
					</colgroup>
					<tbody>
						<tr>
							<th title="Vessel Voyage Direction">VVD</th>
							<td><!--
							--><input type="text" name="bkg_trunk_vvd" style="width: 84px;" value="<%=vvd%>" id="bkg_trunk_vvd" readonly="readonly"/><!--
							--><input type="text" name="vsl_eng_nm" style="width: 133px;" class="input" value="<%=vslEngNm%>" tabindex="-1" id="vsl_eng_nm" /><!--
							--><button type="button" id="btn_0019Pop" name="btn_0019Pop" class="input_seach_btn"></button><!--
							--><button class="btn_etc" name="btn_t1RouteDetail" id="btn_t1RouteDetail" type="button">Route Detail</button><!--
							--><button class="btn_etc" name="btn_allocation" id="btn_allocation" type="button" style="margin-right: 0px;">Allocation</button>
							   <button class="btn_etc" name="btn_vessel" id="btn_vessel" type="button">Copy Vessel</button>
							<!--
							--></td>
						</tr>
						<tr>
							<th title="Place of Receipt">POR</th>
							<td><!--
							--><input type="text" name="bkg_por_cd" style="width: 55px;" class="input1" dataformat="engup" maxlength="5" value="<%=porCd%>" id="bkg_por_cd" /><!--
							--><input type="text" name="bkg_por_yd_cd" style="width: 25px;" class="input" dataformat="engup" maxlength="2" value="<%=porYdCd%>" id="bkg_por_yd_cd" /><!--
							--><input type="text" name="por_nm" style="width: 133px;" class="input" dataformat="engup" otherchar="<%=getSpecialChars()%>" value="<%=porNm%>" tabindex="-1" id="por_nm" /><!--
							--><button type="button" id="btn_0083PorPop" name="btn_0083PorPop" class="input_seach_btn"></button><!--
							--><button class="btn_etc" name="btn_copyloc" id="btn_copyloc" type="button" style="display:inline;">Copy Loc.</button><!--
							--><button class="btn_etc" name="btn_canceloc" id="btn_canceloc" type="button" style="display:none;">Cancel Copy</button><!--
							--><strong>(<input type="checkbox" name="incl_code" id="incl_code" value="" class="trans"><label for="incl_code">Incl.Code</label>)</strong><!--
							--></td>
						</tr>
					</tbody>
				</table>
				<table>
					<colgroup>
						<col width="30" />
						<col width="260" />
						<col width="100" />
						<col width="*" />
					</colgroup>
					<tbody>
						<tr>
							<th title="Port of Loading">POL</th>
							<td><!--
							--><input type="text" name="bkg_pol_cd" style="width: 55px;" class="input" dataformat="engup" maxlength="5" value="<%=polCd%>" id="bkg_pol_cd" /><!--
							--><input type="text" name="bkg_pol_yd_cd" style="width: 25px;" class="input" dataformat="engup" maxlength="2" value="<%=polYdCd%>" id="bkg_pol_yd_cd" /><!--
							--><input type="text" name="pol_nm" style="width: 133px;" class="input" dataformat="engup" otherchar="<%=getSpecialChars()%>" value="<%=polNm%>" tabindex="-1" id="pol_nm" /><!--
							--><button type="button" id="btn_0083PolPop" name="btn_0083PolPop" class="input_seach_btn"></button><!--
							--></td>
							<th>Pre Port(s)</th>
							<td><!--
							--><input type="text" name="pre_rly_port_cd" style="width: 60px;" class="input2" value="<%=preRlyPortCd%>" readonly="" id="pre_rly_port_cd" /><!--
							--><input type="text" name="pre_rly_port_yd_cd" style="width: 25px;" class="input2" value="" readonly="" id="pre_rly_port_yd_cd" />
							</td>
						</tr>
						<tr>
							<th title="Port of Discharging">POD</th>
							<td><!--
							--><input type="text" name="bkg_pod_cd" style="width: 55px;" class="input" dataformat="engup" maxlength="5" value="<%=podCd%>" id="bkg_pod_cd" /><!--
							--><input type="text" name="bkg_pod_yd_cd" style="width: 25px;" class="input" dataformat="engup" maxlength="2" value="<%=podYdCd%>" id="bkg_pod_yd_cd" /><!--
							--><input type="text" name="pod_nm" style="width: 133px;" class="input" dataformat="engup" otherchar="<%=getSpecialChars()%>" value="<%=podNm%>" tabindex="-1" id="pod_nm" /><!--
							--><button type="button" id="btn_0083PodPop" name="btn_0083PodPop" class="input_seach_btn"></button><!--
							--></td>
							<th>Post Port(s)</th>
							<td><!--
							--><input type="text" name="pst_rly_port_cd" style="width: 60px;" class="input2" value="<%=pstRlyPortCd%>" readonly="" id="pst_rly_port_cd" /><!--
							--><input type="text" name="pst_rly_port_yd_cd" style="width: 25px;" class="input2" value="" readonly="" id="pst_rly_port_yd_cd" />
							</td>
						</tr>
						<tr>
							<th title="Place of Delivery">DEL</th>
							<td><!--
							--><input type="text" name="bkg_del_cd" style="width: 55px;" class="input1" dataformat="engup" maxlength="5" value="<%=delCd%>" id="bkg_del_cd" /><!--
							--><input type="text" name="bkg_del_yd_cd" style="width: 25px;" class="input" dataformat="engup" maxlength="2" value="<%=delYdCd%>" id="bkg_del_yd_cd" /><!--
							--><input type="text" name="del_nm" style="width: 133px;" class="input" dataformat="engup" otherchar="<%=getSpecialChars()%>" value="<%=delNm%>" tabindex="-1" id="del_nm" /><!--
							--><button type="button" id="btn_0083DelPop" name="btn_0083DelPop" class="input_seach_btn"></button><!--
							--></td>
							<th>Final Dest</th>
							<td><input type="text" name="fnl_dest_nm" style="width: 89px;" dataformat="engup" class="input" value="<%=fnlDestNm%>" id="fnl_dest_nm" /></td>
						</tr>
					</tbody>
				</table>
				<table>
					<colgroup>
						<col width="120" />
						<col width="170" />
						<col width="100" />
						<col width="*" />
					</colgroup>
					<tbody>
						<tr>
							<th>Service Term(R/D)</th>
							<td><!--
							--><script type="text/javascript">ComComboObject('rcv_term_cd', 2, 75, 1, 0, 1)</script><!--
							--><script type="text/javascript">ComComboObject('de_term_cd', 2, 75, 1, 0, 1)</script><!--
							--></td>
							<th>Freight Term</th>
							<td><script type="text/javascript">ComComboObject('frt_term_cd', 2, 89, 1, 0, 1)</script></td>
						</tr>
						<tr>
							<th><a href="javascript:comBkgCallPopEsmPri0004();">S / C</a></th>
							<td><!--
							--><input type="text" style="width:100px;" class="input" name="sc_no" dataformat="engup" maxlength="9" value="<%=scNo%>" id="sc_no" /><!--
							--><button type="button" id="btn_ScNo" name="btn_ScNo" class="input_seach_btn"></button>
							</td>
							<th>S/O No.</th>
							<td><input type="text" style="width:89px;" class="input" name="twn_so_no" maxlength="6" dataformat="engup" value="<%=twnSoNo%>" id="twn_so_no" /></td>
						</tr>
					</tbody>
				</table>
				<table>
					<colgroup>
						<col width="120" />
						<col width="170" />
						<col width="60" />
						<col width="*" />
					</colgroup>
					<tbody>
						<tr>
							<th><!--
							--><input type="radio" name="ctrt_type" id="ctrt_type" value="TAA" <%=("TAA".equals(ctrtType)) ? "checked" : ""%> class="trans"><a href="javascript:comBkgCallPopEsmPri3007();">TAA</a><!--
							--><input type="radio" name="ctrt_type" id="ctrt_type" value="RFA" <%=("RFA".equals(ctrtType)) ? "checked" : ""%> class="trans"><a href="javascript:comBkgCallPopEsmPri2019();">RFA</a><!--
							--></th>
							<td><input type="text" name="rfa_no" style="width:100px;" class="input" dataformat="engup" maxlength="11" value="<%=rfaNo%>" id="rfa_no" /><!--
							--><input type="text" name="taa_no" style="width:100px;" class="input" dataformat="engup" maxlength=10 value="<%=ctrtTaa%>" style="display:none"><!--
							--><button type="button" id="btn_RfaNo" name="btn_RfaNo" class="input_seach_btn"><!--
							--></button><button type="button" id="btn_TaaNo" name="btn_TaaNo" class="input_seach_btn" style="display:none"></button></td>
							<th>CMDT</th>
							<td><!--
							--><input type="text" name="cmdt_cd" style="width:50px;" class="input1" maxlength="6" value="<%=cmdtCd%>" id="cmdt_cd" /><!--
							--><input type="text" style="width:82px;" name="cmdt_desc" class="input2" value="<%=cmdtNm%>" readonly="" id="cmdt_desc" /><!--
							--><button type="button" id="btn_0656CmdtPop" name="btn_0656CmdtPop" class="input_seach_btn"></button><!--
							--><input type="hidden" name="rep_cmdt_cd" style="width: 34px;" class="input" maxlength="4" value="<%=repCmdtCd%>" id="rep_cmdt_cd" /><!--
							--><input type="hidden" name="rep_cmdt_nm" style="width: 68px;" class="input2" value="<%=repCmdtNm%>" readonly="" id="rep_cmdt_nm" /><!--
							--></td>
						</tr>
					</tbody>
				</table>
				<table>
					<colgroup>
						<col width="60" />
						<col width="150" />
						<col width="40" />
						<col width="50" />
						<col width="50" />
						<col width="*" />
					</colgroup>
					<tbody>
						<tr>
							<th>AMS Filer</th>
							<td><!--
							--><label class="pad_rgt_2">US</label><script type="text/javascript">ComComboObject('usa_cstms_file_cd', 2, 45, 1, 0, 0)</script><!--
							--><label class="pad_rgt_2">CA</label><script type="text/javascript">ComComboObject('cnd_cstms_file_cd', 2, 45, 1, 0, 0)</script>
							</td>
							<th>SCAC</th>
							<td><input type="text" name="scac_cd" style="width: 40px; text-align: center" maxlength="4" dataformat="engup" class="input" value="<%=scacCd%>" id="scac_cd" /></td>
							<th>E.WGT</th>
							<td><!--
							--><input type="text" name="act_wgt" style="width: 96px; text-align: right" maxlength="14" class="input1" value="<%=actWgt%>" id="act_wgt" /><!--
							--><script type="text/javascript">ComComboObject('wgt_ut_cd', 1, 55, 1, 0, 0)</script>
							</td>
						</tr>
					</tbody>
				</table>
				<table>
					<colgroup>
						<col width="60" />
						<col width="150" />
						<col width="40" />
						<col width="50" />
						<col width="50" />
						<col width="*" />
					</colgroup>
					<tbody>
						<tr>
							<th>Special</th>
							<td><!--
							--><input type="checkbox" name="dcgo_flg" id="dcgo_flg" onclick="waitChecked()" value="<%=dcgoFlg%>" <%=("Y".equals(dcgoFlg)) ? "checked" : ""%> class="trans"><label for="dcgo_flg">D/G</label><!--
							--><input type="checkbox" name="rc_flg" id="rc_flg" onclick="waitChecked()" value="<%=rcFlg%>" <%=("Y".equals(rcFlg)) ? "checked" : ""%> class="trans"><label for="rc_flg">R/F</label><!--
							--><input type="checkbox" name="awk_cgo_flg" id="awk_cgo_flg" onclick="waitChecked()" value="<%=awkCgoFlg%>"<%=("Y".equals(awkCgoFlg)) ? "checked" : ""%> class="trans"><label for="awk_cgo_flg">A/K</label><!--
							--><input type="checkbox" name="bb_cgo_flg" id="bb_cgo_flg" onclick="waitChecked()" value="<%=bbCgoFlg%>" <%=("Y".equals(bbCgoFlg)) ? "checked" : ""%> class="trans"><label for="bb_cgo_flg">B/B</label><!--
							--><input type="hidden" name="soc_flg" id="soc_flg" value="<%=socFlg%>" <%//=("Y".equals(socFlg)) ? "checked" : ""%> class="trans" /><!--
							--><input type="checkbox" name="spcl_hide_flg" id="spcl_hide_flg"  value="" class="trans"><label for="spcl_hide_flg">HD</label><!--
							--><input type="checkbox" name="prct_flg" id="prct_flg" value="" class="trans"><label for="prct_flg">PC</label><!--
							--><input type="checkbox" name="fd_grd_flg" id="fd_grd_flg" value=""  class="trans"><label for="fd_grd_flg">FG</label><!--
							--><input type="checkbox" name="flex_hgt_flg" id="flex_hgt_flg" value="<%=flexHgtFlg%>" <%=("Y".equals(flexHgtFlg)) ? "checked" : ""%>  class="trans"><label for="flex_hgt_flg">F/H</label><!--
							--><input type="hidden" name="hot_de_flg" class="trans" /><!--
							--></td>
						</tr>
					</tbody>
				</table>
				
				<!-- layout_wrap (S) -->
				<div class="layout_wrap" style="height:130px">
					<div class="layout_flex_fixed floatR" style="width:200px;">
						<table>
							<colgroup>
								<col width="80" />
								<col width="*" />
							</colgroup>
							<tbody>
								<tr>
									<th>Door DT</th>
									<td><input type="text" name="mty_dor_arr_dt" style="width: 80px;" class="input" value="<%=doorDate%>" maxlength="10" dataformat="ymd" id="mty_dor_arr_dt" /><!--
									--><button type="button" id="btns_DoorDate" name="btns_DoorDate" class="calendar ir"></button></td>
								</tr>
								<tr>
									<th>Sailing DT</th>
									<td><input type="text" name="lodg_due_dt" style="width: 80px;" class="input" value="<%=loadingDate%>" maxlength="10" dataformat="ymd" id="lodg_due_dt" /><!--
									--><button type="button" id="btns_LoadingDate" name="btns_LoadingDate" class="calendar ir"></button></td>
								</tr>
								<tr>
									<th>Delivery DT</th>
									<td><input type="text" name="de_due_dt" style="width: 80px;" class="input" value="<%=deliveryDate%>" maxlength="10" dataformat="ymd" id="de_due_dt" /><!--
									--><button type="button" id="btns_DeliveryDate" name="btns_DeliveryDate" class="calendar ir"></button></td>
								</tr>
								<tr>
									<th>Full RTN CY</th>
									<td><!--
									--><input type="text" name="full_rtn_yd_cd" maxlength="7" style="width: 80px;" class="input" dataformat="engup" value="<%=fullRtnYdCd%>" id="full_rtn_yd_cd" /><!--
									--><button type="button" id="btn_0088FullRtnYdCd" name="btn_0088FullRtnYdCd" class="input_seach_btn"></button><!--
									--></td>
								</tr>
							</tbody>
						</table>
					</div>
					<div class="layout_flex_flex" style="padding-right:258px">
						<div class="layout_wrap">
							<div class="layout_flex_fixed" style="width:50px">
								<table>
									<colgroup>
										<col width="*" />
									</colgroup>
									<tbody>
										<tr>
											<td><strong>EQ Q'ty</strong></td>
										</tr>
										<tr>
											<td><button class="btn_etc" name="btn_add" id="btn_add" type="button">ADD</button></td>
										</tr>
										<tr>
											<td><button class="btn_etc" name="btn_del" id="btn_del" type="button">DEL</button></td>
										</tr>
										<tr>
											<td><button class="btn_etc" name="btn_EqDetail" id="btn_EqDetail" type="button">Vol</button></td>
										</tr>
									</tbody>
								</table>
							</div>
							<div class="layout_flex_flex" style="margin-left:58px;">
								<div class="opus_design_grid"><script type="text/javascript">ComSheetObject('sheet1');</script></div>
							</div>
						</div>
					</div>
				</div>
				<!-- layout_wrap (E) -->
				<table>
					<colgroup>
						<col width="58">
						<col width="120">
						<col width="50">
						<col width="*">
					</colgroup>
					<tbody>
						<tr>
							<th>P/Up CY</th>
							<td><!--
							--><input type="text" name="mty_pkup_yd_cd" maxlength="7" style="width: 60px;" class="input" dataformat="engup" value="<%=mtyPkupYdCd%>" id="mty_pkup_yd_cd" /><!--
							--><button type="button" id="btn_0082MtyPkupYdCd" name="btn_0082MtyPkupYdCd" class="input_seach_btn"></button><!--
							--></td>
							<th>P/Up DT</th>
							<td><!--
							--><input type="text" name="mty_pkup_dt" style="width: 80px;" class="input" value="<%=pkupDate%>" maxlength="10" dataformat="ymd" id="mty_pkup_dt" /><!--
							--><button type="button" id="btns_PkupDate" name="btns_PkupDate" class="calendar ir"></button><!--
							--></td>
						</tr>
					</tbody>	
				</table>
				
				<table class="grid2">
					<tbody>
						<tr>
							<th style="text-align:center">External Remark(s)</th>
							<th style="text-align:center">Internal Remark(s)</th>
						</tr>
						<tr>
							<td><div id="extDiv" style="display: block"><textarea style="width:100%; height:50px;resize: none;" name="xter_rmk" id="xter_rmk" cols="31" rows="4" onBlur="javascript:getMakeBrExter();" maxlength="4000"><%=xterRmk%></textarea></div></td>
							<td><div id="intDiv" style="display: block"><textarea style="width:100%; height:50px;resize: none;" name="inter_rmk" id="inter_rmk" cols="31" rows="4" onBlur="javascript:getMakeBrInter();" maxlength="4000"><%=interRmk%></textarea></div></td>
						</tr>
					</tbody>
				</table>
				<table>
					<colgroup>
						<col width="100" />
						<col width="90" />
						<col width="110" />
						<col width="70" />
						<col width="*" />
					</colgroup>
					<tbody>
						<tr> 
							<th><label for="auto_notification">Auto Notification</label><!--
							--><input type="checkbox" name="auto_notification" id="auto_notification" value="" class="trans" onClick="javascript:autoNotification();"></th>
							<td><button class="btn_etc" name="btn_contact" id="btn_contact" type="button">Contact Info.</button></td>
							<td>(<input type="checkbox" name="copy_esvc" id="copy_esvc" value="" class="trans" onClick="javascript:doCopyEsvc();" checked="checked"><label for="copy_esvc">Copy from e-Service</label>)</td>
							<th>CCT</th>
							<td><button type="button" id="btn_CctPop" name="btn_CctPop" class="input_seach_btn"></button></td>
						</tr>
						<tr>
							<td><button class="btn_etc" name="btn_docRequirement" id="btn_docRequirement" type="button">Doc Requirement</button></td>
							<td>(<input type="checkbox" name="copy_esvc_doc" id="copy_esvc_doc" value="" class="trans" onClick="javascript:docReqCopyEsvc();"><label for="copy_esvc_doc">Copy from e-Service</label>)</td>
							<td><button class="btn_etc" name="btn_ref_bkg" id="btn_ref_bkg" type="button">Reference NO.</button></td>
							
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
 	<div id="div_right" class="layout_vertical_2"> <!--style="width:600px;" -->
		<div class="wrap_search bg">
			<div class="opus_design_grid">
				<h3 class="title_design">From e- Service</h3>
			</div>
			<div class="opus_design_inquiry">
				<table>
					<colgroup>
						<col width="80" />
						<col width="110" />
						<col width="60" />
						<col width="150" />
						<col width="40" />
						<col width="*" />
					</colgroup>
					<tbody>
						<tr>
							<th>BKG No.</th>
							<td><input type="text" name="bkg_no2" style="width: 105px;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo.getBkgNo())%>" id="bkg_no2" /></td>
							<th>Req. No.</th>
							<td><!--
							--><input type="text" name="rqst_no2" style="width: 120px;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo.getXterRqstNo())%>" id="rqst_no2" readonly /><!--
							--><input type="text" name="snaccs_split_no2" style="width: 20px;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo.getSnaccsSplitNo())%>" id="snaccs_split_no2" readonly />
							</td>
							<th>Via</th>
							<td><!--
							--><input type="text" name="xter_rqst_via_nm" style="width: 54px;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo.getXterRqstViaNm())%>" id="xter_rqst_via_nm" readonly /><!--
							--><input type="hidden" name="xter_rqst_via_cd" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo.getXterRqstViaCd())%>" id="xter_rqst_via_cd"/></td>
						</tr>
					</tbody>
				</table>
				<table>
					<colgroup>
						<col width="80" />
						<col width="110" />
						<col width="60" />
						<col width="40" />
						<col width="80" />
						<col width="50" />
						<col width="60" />
						<col width="*" />
					</colgroup>
					<tbody>
						<tr>
							<th>B/L No.</th>
							<td><input type="text" name="bl_no_ctnt2" style="width: 105px;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo .getBlNoCtnt())%>" id="bl_no_ctnt2" readonly /></td>
							<th>OPUS</th>
							<td><input type="text" name="opus2" id="opus2" style="width: 30px;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo.getOpus())%>" readonly></td>
							<th>No. of H/BL</th>
							<td><input type="text" name="hbl_knt2" style="width: 26px;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo .getHblKnt())%>" readonly></td>
							<th>Doc Type</th>
							<td><input type="text" name="doc_tp_cd" id="doc_tp_cd" style="width: 26px" class="input2" value="<%=docTpCd%>" readonly></td>
						</tr>
					</tbody>
				</table>
				<table>
					<colgroup>
						<col width="80" />
						<col width="260" />
						<col width="100" />
						<col width="*" />
					</colgroup>
					<tbody>
						<tr>
							<th>Shipper</th>
							<td><!--
							--><input type="text" name="sh_cnt_cd2" style="width: 30px;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo .getShCntCd())%>" readonly><!--
							--><input type="text" name="sh_cust_seq2" style="width: 55px;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo .getShCustSeq())%>" readonly><!--
							--><input type="text" name="sh_cust_nm2" style="width: 180px;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo .getShCustNm())%>" readonly><!--
							--></td>
							<th>L/Rep.</th>
							<td><input type="text" name="srep_cd2" style="width: 54px;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo .getSrepCd())%>" readonly></td>
						</tr>
						<tr>
							<th>Forwarder</th>
							<td><!--
							--><input type="text" name="ff_cnt_cd2" style="width: 30px;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo .getFfCntCd())%>" readonly><!--
							--><input type="text" name="ff_cust_seq2" style="width: 55px;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo .getFfCustSeq())%>" readonly><!--
							--><input type="text" name="ff_cust_nm2" style="width: 180px;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo .getFfCustNm())%>" readonly><!--
							--></td>										
							<th>Status</th>
							<td><input type="text"name="xter_bkg_rqst_sts_cd" style="width: 20px;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo.getXterBkgRqstStsCd())%>" readonly /></td>
						</tr>
					</tbody>
				</table>
				<table>
					<colgroup>
						<col width="30" />
						<col width="300" />
						<col width="80" />
						<col width="*" />
					</colgroup>
					<tbody>
						<tr>
							<th title="Vessel Voyage Direction">VVD</th>
							<td><input type="text" name="vvd2" style="width: 89px;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo .getVvd())%>" id="vvd2" readonly /><!--
							--><input type="text" name="vsl_nm2" style="width: 130px;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo .getVslNm())%>" id="vsl_nm2" readonly />
								<input type="text" name="cssm_voy_no" style="width: 50px;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo.getCssmVoyNo())%>" id="cssm_voy_no" readonly />
							</td>
							<th title="Vessel Voyage Direction">Cust ID</th>
							<td><input type="text" name="cust_id2" style="width: 100px;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo.getCustId())%>" id="cust_id2" readonly></td>
						</tr>
						<tr>
							<th title="Place of Receipt">POR</th>
							<td><input type="text" name="bkg_por_cd2" style="width: 60px;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo .getPorCd())%>" id="bkg_por_cd2" readonly /><!--
							--><input type="text" name="por_nm2" style="width: 209px;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo .getPorNm())%>" id="por_nm2" readonly /></td>
							<th>Frt as Argn</th>
							<td><input type="text" name="xter_chg_arr_flg2" style="width: 26px;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo .getXterChgArrFlg())%>" id="xter_chg_arr_flg2" readonly /></td>
						</tr>
						<tr>
							<th title="Port of Loading">POL</th>
							<td><input type="text" name="bkg_pol_cd2" style="width: 60px;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo .getPolCd())%>" id="bkg_pol_cd2" readonly /><!--
							--><input type="text" name="pol_nm2" style="width: 209px;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo .getPolNm())%>" id="pol_nm2" readonly /></td>
							<th>Agent Sign</th>
							<td><input type="text" name="xter_agn_dp_flg2" style="width: 26px;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo .getXterAgnDpFlg())%>" id="xter_agn_dp_flg2" readonly /></td>
						</tr>
						<tr>
							<th title="Port of Discharging">POD</th>
							<td><!--
							--><input type="text" name="bkg_pod_cd2" style="width: 60px;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo .getPodCd())%>" id="bkg_pod_cd2" readonly /><!--
							--><input type="text" name="pod_nm2" style="width: 209px;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo .getPodNm())%>" id="pod_nm2" readonly /></td>
							<th>Attached</th>
							<td><input type="text" name="xter_list_dp_flg2" style="width: 26px;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo .getXterListDpFlg())%>" id="xter_list_dp_flg2" readonly /></td>
						</tr>
						<tr>
							<th title="Place of Delivery">DEL</th>
							<td><input type="text" name="bkg_del_cd2" style="width: 60px;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo .getDelCd())%>" id="bkg_del_cd2" readonly /><!--
							--><input type="text" name="del_nm2" style="width: 209px;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo .getDelNm())%>" id="del_nm2" readonly /></td>
							<th>Final Dest.</th>
							<td><input type="text" name="fnl_dest_nm2" id="fnl_dest_nm2" style="width: 81px;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo .getFnlDestNm())%>" readonly></td>
						</tr>
					</tbody>
				</table>
				<table>
					<colgroup>
						<col width="120" />
						<col width="170" />
						<col width="100" />
						<col width="*" />
					</colgroup>
					<tbody>
						<tr>
							<th>Service Term(R/D)</th>
							<td><input type="text" name="rcv_term2" id="rcv_term2" style="width: 45px;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo.getRcvTerm())%>" readonly /><!--
								--><input type="text" name="dlv_term2" id="dlv_term2" style="width: 45px;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo.getDlvTerm())%>" readonly /></td>
							<th>Freight Term</th>
							<td><input type="text" name="frt_term_cd2" id="frt_term_cd2" style="width: 81px;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo.getFrtTermCd())%>" readonly></td>
						</tr>
						<tr>
							<th><input type="radio" name="ctrt_type2" id="ctrt_type2_1" value="SC" <%=("SC".equals(vScRfa)) ? "checked" : ""%> class="trans"><label for="ctrt_type2_1">S/C</label><!--
							--><input type="radio" name="ctrt_type2" id="ctrt_type2_2"  value="RFA" <%=("RFA".equals(vScRfa)) ? "checked" : ""%> class="trans"><label for="ctrt_type2_2">RFA</label></th>
							<td><input type="text" name="ctrt_no2" id="ctrt_no2" style="width: 94px;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo.getCtrtNo())%>" readonly></td>
							<th>S/O No.</th>
							<td><input type="text" name="twn_so_no2" id="twn_so_no2" style="width: 81px;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo.getTwnSoNo())%>" readonly></td>
						</tr>
					</tbody>
				</table>
				<table>
					<colgroup>
						<col width="80" />
						<col width="220" />
						<col width="50" />
						<col width="*" />
						<col width="*" />
					</colgroup>
					<tbody>
						<tr>
							<th>Commodity</th>
							<td><input type="text" name="cmdt_cd2" id="cmdt_cd2" style="width: 60px;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo.getCmdtCd())%>" readOnly><!--
							--><input type="text" name="cmdt_desc2" id="cmdt_desc2" style="width: 130px;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo .getCmdtDesc())%>" readOnly></td>
							<th>N.WGT</th>
							<td><input type="text" name="net_wgt" id="net_wgt" style="width: 91px; text-align: right" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo.getNetWgt())%>" readOnly><!--
							--><input type="text" name="net_wgt_ut_cd" id="net_wgt_ut_cd" style="width: 55px;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo .getNetWgtUtCd())%>" readOnly></td>
						</tr>
					</tbody>
				</table>
				<table>
					<colgroup>
						<col width="60" />
						<col width="150" />
						<col width="40" />
						<col width="50" />
						<col width="50" />
						<col width="*" />
					</colgroup>
					<tbody>
						<tr>
							<td>AMS Filer</td>
							<td><label for="usa_cstms_file_ctnt2">US</label><input type="text" name="usa_cstms_file_ctnt2" id="usa_cstms_file_ctnt2" style="width: 40px;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo.getUsaCstmsFileCtnt())%>" readOnly><!--
							--><label for="cnd_cstms_file_cd2">CA</label><input type="text" name="cnd_cstms_file_cd2" id="cnd_cstms_file_cd2" style="width: 40px;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo.getCndCstmsFileCd())%>" readOnly></td>
							<th>SCAC</th>
							<td><input type="text" name="scac_cd2" id="scac_cd2" style="width: 40px; text-align: center" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo .getScacCd())%>" readOnly></td>
							<th>E.WGT</th>
							<td><input type="text" name="estm_wgt2" style="width: 91px; text-align: right" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo .getEstmWgt())%>" readOnly><!--
							--><input type="text" style="width: 55px;" name="estm_wgt_ut_cd2" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo .getEstmWgtUtCd())%>" readOnly></td>
						</tr>
					</tbody>
				</table>
				<table>
					<colgroup>
						<col width="80" />
						<col width="*" />
					</colgroup>
					<tbody>
						<tr>
							<th>Special</th>
							<td><input type="checkbox" name="dcgo_flg2" id="dcgo_flg2" value="<%=vDcgoFlg%>" <%=("Y".equals(vDcgoFlg)) ? "checked" : ""%> class="trans"><label for="dcgo_flg2">D/G</label><!--
							--><input type="checkbox" name="rc_flg2" id="rc_flg2" value="<%=vRcFlg%>" <%=("Y".equals(vRcFlg)) ? "checked" : ""%> class="trans"><label for="rc_flg2">R/F</label><!--
							--><input type="checkbox" name="awk_cgo_flg2" id="awk_cgo_flg2" value="<%=vAwkCgoFlg%>" <%=("Y".equals(vAwkCgoFlg)) ? "checked" : ""%> class="trans"><label for="awk_cgo_flg2">A/K</label><!--
							--><input type="checkbox" name="bb_cgo_flg2" id="bb_cgo_flg2" value="<%=vBbCgoFlg%>" <%=("Y".equals(vBbCgoFlg)) ? "checked" : ""%> class="trans"><label for="bb_cgo_flg2">B/B</label><!--
							--><input type="hidden" name="soc_flg2" id="soc_flg2" value="<%=vSocFlg%>" <%=("Y".equals(vSocFlg)) ? "checked" : ""%>class="trans"><!--
							--><input type="checkbox" name="spcl_hide_flg2" id="spcl_hide_flg2" class="trans"><label for="spcl_hide_flg2">HD</label><!--
							--><input type="checkbox" name="prct_flg2" id="prct_flg2" class="trans"><label for="prct_flg2">PC</label><!--
							--><input type="checkbox" name="fd_grd_flg2" id="fd_grd_flg2" class="trans"><label for="fd_grd_flg2">FG</label></td>
						</tr>
					</tbody>
				</table>
				<!-- layout_wrap (S) -->
				<div class="layout_wrap" style="height:130px">
 					<div class="layout_flex_fixed floatR"> <!-- style="width:200px;" -->
						<table>
							<colgroup>
								<col width="90" />
								<col width="*" />
							</colgroup>
							<tbody>
								<tr>
									<th>Return Date</th>
									<td><input type="text" name="return_dt2" id="return_dt2" style="width: 75px;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo.getReturnDt())%>" readOnly /></td>
								</tr>
								<tr>
									<th>Sailing Date</th>
									<td><input type="text" name="departure_dt2" id="departure_dt2" style="width: 75px;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo.getDepartureDt())%>" readOnly /></td>
								</tr>
								<tr>
									<th>Delivery Date</th>
									<td><input type="text" name="arrival_dt2" id="arrival_dt2" style="width: 75px;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo.getArrivalDt())%>" readOnly /></td>
								</tr>
								<tr>
									<th>Pickup Date</th>
									<td><input type="text" name="mty_pkup_dt2" id="mty_pkup_dt2" style="width: 75px;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo.getMtyPkupDt())%>" readOnly /></td>
								</tr>
							</tbody>
						</table>
					</div>
					<div class="layout_flex_flex" style="padding-right:258px">
						<div class="layout_wrap">
							<div class="layout_flex_fixed" style="width:50px">
								<table>
									<colgroup>
										<col width="*" />
									</colgroup>
									<tbody>
										<tr>
											<td><strong>EQ Q'ty</strong></td>
										</tr>
									</tbody>
								</table>
							</div>
							<div class="layout_flex_flex" style="margin-left:58px;">
								<div class="opus_design_grid"><script type="text/javascript">ComSheetObject('sheet2');</script></div>
							</div>
						</div>
					</div>
				</div>
				<!-- layout_wrap (E) -->
				
				<!-- layout_wrap (S) -->
				<div class="layout_wrap">
					<div class="layout_vertical_2 pad_rgt_8">
						<table class="grid_2">
							<tbody>
								<tr>
									<th style="text-align: center"><b>Remark(s) Instruction</b></th>
								</tr>
								<tr>
									<td><textarea style="height:73px;width:100%;resize:none"  class="textarea2" name="rmk2" id="rmk2" class="wAuto" readOnly><%=(rqstVo == null) ? "" : replaceNull(rqstVo.getRmk())%></textarea></td>
								</tr>
							</tbody>
						</table>	
						<table>
							<colgroup>
								<col width="100" />
								<col width="*" />
							</colgroup>
							<tbody>
								<tr>
									<th>Auto Notification</th>
									<td><input type="text" name="auto_notification2" id="auto_notification2" style="width: 40px;" class="input2" class="mar_left_12" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo.getAutoNotification())%>"	readOnly /></td>
								</tr>
								<tr>
									<td><button class="btn_etc" name="btn_docRequirement2" id="btn_docRequirement2" type="button">Doc Requirement</button></td>
									<td><button class="btn_etc" name="btn_ref_xter" id="btn_ref_xter" type="button">Reference NO.</button></td>
								</tr>
							</tbody>
						</table>
					</div>
					<div class="layout_vertical_2">
						<table>
							<tr>
								<th colspan="2" style="text-align: center"><input type="radio" name="tmp_radio" id="tmp_radio1" class="trans" onclick="changeCntcLayer(0)" checked><label for="tmp_radio1"><b>BKG contact</b></label><!--
								--><input type="radio" name="tmp_radio" id="tmp_radio2" class="trans" onclick="changeCntcLayer(1)"><label for="tmp_radio2"><b>S/I contact</b></label></th>
							</tr>
						</table>
						<div id="cntcLayer1" name="cntcLayer1" style="display:inline;overflow-y:auto;width:100%;height:116px">
							<table class="grid2">
								<tbody>
									<tr>
										<th>Name</th>
										<td><input type="text" name="cntc_nm2" style="width:100%;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo.getCntcNm())%>" readOnly></td>
									</tr>
									<tr>
										<th>Tel.</th>
										<td><input type="text" name="tel2" style="width:100%;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo.getTel())%>"	readOnly></td>
									</tr>
									<tr>
										<th>Mobile</th>
										<td><input type="text" name="mobile2" style="width:100%;"	class="input2"	value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo.getMobile())%>" readOnly></td>
									</tr>
									<tr>
										<th>Fax</th>
										<td><input type="text" name="fax2" style="width:100%;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo.getFax())%>"	readOnly></td>
									</tr>
									<tr>
										<th>E-mail</th>
										<td><input type="text" name="cntc_eml2"	style="width:100%;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo.getCntcEml())%>" readOnly></td>
																					</tr>
																					<tr>
										<th>Cust.Ref.No</th>
										<td><input type="text" name="cust_ref_no2" style="width:100%;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo.getCustRefNo())%>" readOnly></td>
									</tr>
								</tbody>
							</table>
						</div>
						<div id="cntcLayer2" name="cntcLayer2" style="display:none;overflow-y:auto;width:100%;height:116px">
							<table class="grid2"> 
								<tbody>
									<tr>
										<th>Name</th>
										<td class="align_r"><input type="text" name="si_cntc_nm2" style="width:100%;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo.getSiCntcNm())%>" readOnly></td>
									</tr>
									<tr>
										<th>Tel.</th>
										<td><input type="text" name="si_tel2" style="width:100%;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo.getSiTel())%>"	readOnly></td>
									</tr>
									<tr>
										<th>Mobile</th>
										<td><input type="text" name="si_mobile2" style="width:100%;"	class="input2"	value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo.getSiMobile())%>" readOnly></td>
									</tr>
									<tr>
										<th>Fax</th>
										<td><input type="text" name="si_fax2" style="width:100%;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo.getSiFax())%>"	readOnly></td>
									</tr>
									<tr>
										<th>E-mail</th>
										<td><input type="text" name="si_cntc_eml2"	style="width:100%;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo.getSiCntcEml())%>" readOnly></td>
									</tr>
								<tbody>
							</table>
						</div>
					</div>
				</div>
				<!-- layout_wrap (E) -->
			</div>
		</div>
	</div>
</div>
<!-- layout_wrap (E) -->


<!--TAB BKG Creation (E) -->
<input type="hidden" name="old_bkg_no" value="<%=bkgNo%>">
<input type="hidden" name="old_bl_no" >
<input type="hidden" name="orgBlNo" >
<input type="hidden" name="userInfo"   		value="">
<input type="hidden" name="bkg_ofc_cd" 		value="<%=strOfc_cd%>">

<!-- route Info -->
<input type="hidden" name="prd_params">
<input type="hidden" name="pctl_no" value="<%=pctlNo%>">
<input type="hidden" name="bkg_trunk_vvd_old" value="<%=vvd%>">
<input type="hidden" name="por_conti_cd">	
<input type="hidden" name="del_conti_cd">
<input type="hidden" name="por_cd_old" 		value="<%=porCd%>">
<input type="hidden" name="por_yd_cd_old"  	value="<%=porYdCd%>">
<input type="hidden" name="pol_cd_old"  	value="<%=polCd%>">
<input type="hidden" name="pol_yd_cd_old"  	value="<%=polYdCd%>">
<input type="hidden" name="pod_cd_old"  	value="<%=podCd%>">
<input type="hidden" name="pod_yd_cd_old"  	value="<%=podYdCd%>">
<input type="hidden" name="del_cd_old"  	value="<%=delCd%>">
<input type="hidden" name="del_yd_cd_old"  	value="<%=delYdCd%>">
<input type="hidden" name="rcv_term_cd_old" value="<%=rcvTerm%>">
<input type="hidden" name="de_term_cd_old"  value="<%=dlvTerm%>">
<input type="hidden" name="mty_dor_arr_dt_old" 	value="<%=doorDate%>">
<input type="hidden" name="lodg_due_dt_old" 	value="<%=loadingDate%>">
<input type="hidden" name="de_due_dt_old" 		value="<%=deliveryDate%>">
<input type="hidden" name="mty_pkup_yd_cd_old" 	value="<%=mtyPkupYdCd%>">
<input type="hidden" name="mty_pkup_dt_old" 	value="<%=pkupDate%>">
<input type="hidden" name="full_rtn_yd_cd_old" 	value="<%=fullRtnYdCd%>">
<input type="hidden" name="org_sconti_cd" 		value="<%=orgScontiCd%>">
<input type="hidden" name="dest_sconti_cd" 		value="<%=destScontiCd%>">
<input type="hidden" name="org_trns_svc_mod_cd" value="<%=orgTrnsSvcModCd%>">
<input type="hidden" name="dest_trns_svc_mod_cd"value="<%=destTrnsSvcModCd%>">
	
<!-- customer Info -->
<input type="hidden" name="s_cust_cnt_cd_old" value="<%=shCnt%>"> 
<input type="hidden" name="s_cust_seq_old"    value="<%=shSeq%>">
<input type="hidden" name="s_cust_subst_flg"  value="<%=shSub%>">
<input type="hidden" name="s_cust_exist_flg"  value="<%=shExist%>">
<input type="hidden" name="f_cust_cnt_cd_old" value="<%=ffCnt%>">
<input type="hidden" name="f_cust_seq_old"    value="<%=ffSeq%>">
<input type="hidden" name="f_cust_subst_flg"  value="<%=ffSub%>">
<input type="hidden" name="f_cust_exist_flg"  value="<%=ffExist%>">
<input type="hidden" name="c_cust_cnt_cd_old" >
<input type="hidden" name="c_cust_seq_old" >
<input type="hidden" name="c_cust_subst_flg" >
<input type="hidden" name="c_cust_exist_flg" >
<input type="hidden" name="fmc_no">

<!-- ctrt -->
<input type="hidden" name="rfa_no_old" value="<%=rfaNo%>">
<input type="hidden" name="taa_no_old" value="<%=taaNo%>">
<input type="hidden" name="rfaNoValid" > <!-- checking valid RfaNo (CMDT PopUp) -->
<input type="hidden" name="sc_no_old" value="<%=scNo%>">
<input type="hidden" name="sc_rfa" value="<%=null==rqstVo ? "" : replaceNull(rqstVo .getScRfa())%>">


<input type="hidden" name="cmdt_cd_old" 		value="<%=cmdtCd%>">
<%-- <input type="hidden" name="rep_cmdt_cd" id="rep_cmdt_cd"		value="<%=repCmdtCd%>"> --%>
<input type="hidden" name="validPrecaution">
<input type="hidden" name="befUsaCstmsFileCd">
<input type="hidden" name="premium_available_flg" value="<%=premiumAvailableFlg%>">
<input type="hidden" name="act_wgt_old" value="<%=actWgt%>">

<!-- cargo -->
<input type="hidden" name="modify_cargo_flg">
<input type="hidden" name="total_vol">
<input type="hidden" name="dcgo_flg_old" 	value="<%=dcgoFlg%>">
<input type="hidden" name="hcdg_flag" 		>
<input type="hidden" name="rc_flg_old" 		value="<%=rcFlg%>">
<input type="hidden" name="awk_cgo_flg_old" value="<%=awkCgoFlg%>">
<input type="hidden" name="bb_cgo_flg_old" 	value="<%=bbCgoFlg%>">
<input type="hidden" name="allMotorLoc" >
<input type="hidden" name="flexHeightLoc" >
<input type="hidden" name="rd_cgo_flg" 		value="<%=rdCgoFlg%>">   <!-- change when it saved-->
<input type="hidden" name="soc_flg_old" 	value="<%=socFlg%>">     <!-- change when it saved -->
<input type="hidden" name="eq_subst_flg" 	>
<input type="hidden" name="dg_flg" 			>
<input type="hidden" name="rf_flg" 			>
<input type="hidden" name="awk_flg" 		>
<input type="hidden" name="bb_flg" 			>
<input type="hidden" name="stwg_flg" 		>
<input type="hidden" name="hngr_flg" 		>
<input type="hidden" name="stop_off_flg" 	>
<input type="hidden" name="blck_stwg_cd" 	>

<!-- Etc flag -->
<input type="hidden" name="cgo_dtl_auto_flg"    	value="N">
<input type="hidden" name="carge_detail_pop"		value="N">
<input type="hidden" name="partial_vvd_assign_flg" 	value="<%=partialVvdAssignFlg%>">
<input type="hidden" name="partial_vvd_opened_flg"  value="N">
<input type="hidden" name="ctrt_modify_flag" 		value="N">
<input type="hidden" name="route_modify_flag" 		value="N">
<input type="hidden" name="qty_modify_flag" 		value="N">
<input type="hidden" name="customer_modify_flag" 	value="N">
<input type="hidden" name="contact_modify_flag" 	value="N">
<input type="hidden" name="close_bkg_flag" 			value="">
<input type="hidden" name="cbf_bkg_flag" 			value="">
<input type="hidden" name="ib_modify_flag" 			value="N">
<input type="hidden" name="modify_flag" 			value="N">
<input type="hidden" name="have_route_flag" 		value="N">
<input type="hidden" name="psdo_bkg_flg"    		value="N">
<input type="hidden" name="pc_inq_flag" 			value="N">
<input type="hidden" name="tro_un_cfm_flag" 		value="N">
<input type="hidden" name="is_vl_flg"				value="<%=isVlFlg%>">
<input type="hidden" name="vvd_flg"				    value="<%=vvdFlg%>">
<input type="hidden" name="cntr_flg">
<input type="hidden" name="is_rated_flg">

<!-- ESM-BKG_0090 Special Stowage Request -->
<input type="hidden" name="stwg_cd">
<input type="hidden" name="stwg_rmk"> 

<!-- BDR, C/A Flag (S)  -->
<input type="hidden" name="ca_user" >
<input type="hidden" name="bdr_flg" value="<%=bdrFlg%>">
<input type="hidden" name="ca_flg"  value="<%=caFlg%>">
<input type="hidden" name="ca_rsn_cd" > 
<input type="hidden" name="bkg_corr_rmk">

<!-- ESM-BKG_0658 Stop Off Cargo Order-->
<input type="hidden" name="stop_off_loc_cd">
<input type="hidden" name="stop_off_cntc_phn_no">
<input type="hidden" name="stop_off_cntc_pson_nm">
<input type="hidden" name="stop_off_diff_rmk"> 

<!-- RouteDetail Hidden Sheet -->
<input type="hidden" name="org_trns_mod_cd"  value="<%=orgTrnsModCd%>"> 
<input type="hidden" name="dest_trns_mod_cd" value="<%=destTrnsModCd%>"> 

<!-- BKG creation route (S) -->
<input type="hidden" name="xter_bkg_rqst_cd"     value="<%=xterBkgRqstCd%>">
<input type="hidden" name="xter_bkg_rqst_ref_no" value="<%=xterBkgRqstRefNo%>">

<!-- SI creation route (S) -->
<input type="hidden" name="si_flg"         value="<%=siFlg%>">
<input type="hidden" name="xter_si_cd"     value="<%=xterSiCd%>">
<input type="hidden" name="xter_si_ref_no" value="<%=xterSiRefNo%>">

<!-- opus_design_grid (S) -->
<div class="opus_design_grid" style="display:none">
	<script type="text/javascript">ComSheetObject('sheet3');</script>
	<script type="text/javascript">ComSheetObject('sheet4');</script>
	<script type="text/javascript">ComSheetObject('sheet5');</script>
</div>
<!-- opus_design_grid (E) -->
</form>
<form name="form2">
	<input type="hidden" name="bkg_por_cd"></input>
	<input type="hidden" name="por_nm"></input>
	<input type="hidden" name="bkg_pol_cd"></input>
	<input type="hidden" name="pol_nm"></input>
	<input type="hidden" name="bkg_pod_cd"></input>
	<input type="hidden" name="pod_nm"></input>
	<input type="hidden" name="bkg_del_cd"></input>
	<input type="hidden" name="del_nm"></input>
</form>
<%!
public String replaceNull(String str) {
		return (str == null || str.trim().length() == 0 || "null".equals(str)) ? "" : str;
}
public String getSpecialChars() {
	return " ~!@#$%^&*()`_+-={}|[]\\\"\\':;,./?"; 
}
%>