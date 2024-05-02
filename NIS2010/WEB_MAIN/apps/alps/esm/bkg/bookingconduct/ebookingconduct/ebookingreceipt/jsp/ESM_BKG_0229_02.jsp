﻿﻿<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0229_02.jsp
*@FileTitle : e-Booking & S/I Detail (Customer)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.08
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.06.08 전용진
* 1.0 Creation
===============================================================================
 History
 2010.09.13 이일민 [CHM-201005276-01] ALPS-[BKG/DOC]주요UI버턴-단축키 기능개발
 2011.01.10 이일민 [CHM-201108147] EU24 관련 Country Code 및 EORI Code Validation 체크 로직
 2011.04.11 정선용 [CHM-201109998-01]구주 24hrs Rule 관련하여 상세 주소 로직 보완 요청 
 2011.05.19 김진승 [CHM-201110734] Save after chanfge of Customer not possible
 2011.11.03 정선용 [CHM-201114137-01] [ALPS] E-BKG/SI Process 화면 EDI REF 추가
 2012.05.31 조정민 [CHM-201218066] [BKG] FMC No 수동 입력 불가능토록 기능 보완 요청
 2012.11.09 김현화 [CHM-201221260]E-BKG/SI Process customer 탭 수정.-shKrCstmsCustTpNm2
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkg022902Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List" %>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO" %>
<%@ page import="com.hanjin.apps.alps.esm.bkg.common.*" %>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstCustVO" %>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.BkgXterCustVO" %>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BlDocCustVO" %>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.CustEtcVO" %>
<%@ page import="com.hanjin.framework.core.controller.DefaultViewAdapter"%>

<%
	EsmBkg022902Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	String sXml		 = "";
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.EBookingConduct.EBookingReceipt");

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
	String shCustFaxNo = "";
	String shCustEml = "";
	String shCustPhnNo = "";
	
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
	String cnCustPhnNo = "";
	
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
	String nfCustPhnNo = "";
	
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
	String exMdmAddress = "";
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

	// 0079-05에서는 입력가능한 field
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
	String shCustFaxNo2 = "";
	String shCustEml2 = "";
	String shCustPhnNo2 = "";
	
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
	String cnCustPhnNo2 = "";
	String cnEurCstmsStNm2 = "";
	String cnEurCstmsPstId2 = "";
	String cnCoChnTpCd2 = "";
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
	String nfCustPhnNo2 = "";
	String nfEurCstmsStNm2 = "";
	String nfEurCstmsPstId2 = "";
	String nfCoChnTpCd2 = "";
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
	String exCustCntCd2 = "";
	String exCustSeq2 = "";
	String exCustLglEngNm2 = "";
	
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
	String shKrCstmsCustTpNm2 = "";
	String sender = StringUtil.xssFilter(request.getParameter("xter_rqst_via_cd"));
	
	String orgCntNm2 = "";
	
	String agmtActCntCd2 = "";
	String agmtActCustSeq2 = "";  

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

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		tp_cd = (List<BkgComboVO>) eventResponse.getCustomData("tp_cd");
		
		ExternalRqstCustVO rqstCustVo = (ExternalRqstCustVO) eventResponse.getCustomData("externalRqstCustVO");
		//blDocCust = rqstCustVo.getBlDocCustVO();
		//custEtcVO = rqstCustVo.getCustEtcVO();
		xterCust = rqstCustVo.getBkgXterCustVO();

		DefaultViewAdapter adapter = new DefaultViewAdapter();
		sXml = adapter.makeXML(request, response);
		// bkg쪽 customer는 js에서 처리
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
			shCustFaxNo2 = xterCust.getShCustFaxNo();
			shCustEml2 = xterCust.getShCustEml();
			shCustPhnNo2 = xterCust.getShCustPhnNo();

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
			cnCustPhnNo2 = xterCust.getCnCustPhnNo();
			cnEurCstmsStNm2 = xterCust.getCnEurCstmsStNm();
			cnEurCstmsPstId2 = xterCust.getCnEurCstmsPstId();
			cnCoChnTpCd2 = xterCust.getCnCoChnTpCd();
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
			nfCustPhnNo2 = xterCust.getNfCustPhnNo();
			nfEurCstmsStNm2 = xterCust.getNfEurCstmsStNm();
			nfEurCstmsPstId2 = xterCust.getNfEurCstmsPstId();
			nfCoChnTpCd2 = xterCust.getNfCoChnTpCd();
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

			shKrCstmsCustTpCd2 = xterCust.getShKrCstmsCustTpCd();
			custToOrdFlg2 = xterCust.getCnCustToOrdFlg();
			rvisCntrCustTpCd2 = xterCust.getRvisCntrCustTpCd();
			
			orgCntNm2 = xterCust.getOrgCntNm();
			
			exCustCntCd2 = xterCust.getExCustCntCd();
			exCustSeq2 = ("0".equals(xterCust.getExCustSeq()))?"":getZeroLpad(xterCust.getExCustSeq());
			exCustLglEngNm2 = xterCust.getExCustLglEngNm();
			// 2012.11.09 추가   
				if( "C".equals(shKrCstmsCustTpCd2)){ 
				   shKrCstmsCustTpNm2 = "Consol.";
				} else if ( "S".equals(shKrCstmsCustTpCd2)){ 
					   shKrCstmsCustTpNm2 = "Simple";
				}else{
					 shKrCstmsCustTpNm2 = "";
				}
			
			
			agmtActCntCd2 = xterCust.getAgmtActCntCd();
			agmtActCustSeq2 = xterCust.getAgmtActCustSeq();  

		}

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>e-Booking & S/I Detail (Customer)</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();

	}
</script>
</head>

<body onLoad="setupPage();">
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;padding-left:0;">	
	<tr><td valign="top">
		<!--biz page (S)-->
		<!-- Grid BG Box  (S) -->
     	<table class="search" id="mainTable" style="width:958;">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="sXml" value="<%=JSPUtil.replace(sXml, "\"", "&quot;")%>">
<input type="hidden" name="sender_id" value="<%=StringUtil.xssFilter(request.getParameter("sender_id"))%>">
<input type="hidden" name="xter_rqst_via_cd" value="<%=StringUtil.xssFilter(request.getParameter("xter_rqst_via_cd"))%>">
<input type="hidden" name="rqst_no" value="<%=StringUtil.xssFilter(request.getParameter("rqst_no"))%>">
<input type="hidden" name="rqst_seq" value="<%=StringUtil.xssFilter(request.getParameter("rqst_seq"))%>">
<input type="hidden" name="cn_cust_to_ord_flg2" value="<%=custToOrdFlg2%>">
<input type="hidden" name="rvis_cntr_cust_tp_cd2" value="<%=rvisCntrCustTpCd2%>">

<input type="hidden" name="cust_nis" value="<%=(blDocCust != null)?"Y":"N"%>">
<input type="hidden" name="cust_esvc" value="<%=(xterCust != null)?"Y":"N"%>">

<input type="hidden" name="sh_mdm_address" value="<%=shMdmAddress%>">
<input type="hidden" name="ff_mdm_address" value="<%=ffMdmAddress%>">
<input type="hidden" name="cn_mdm_address" value="<%=cnMdmAddress%>">
<input type="hidden" name="nf_mdm_address" value="<%=nfMdmAddress%>">
<input type="hidden" name="an_mdm_address" value="<%=anMdmAddress%>">
<input type="hidden" name="ex_mdm_address" value="<%=exMdmAddress%>">

<input type="hidden" name="modify_flag" value="N">
<input type="hidden" name="same_as_flag" >
<input type="hidden" name="order_found_flag" >
<input type="hidden" name="ca_manifest_flag" >
<input type="hidden" name="frob_flag" value="<%=(frobFlag==null||frobFlag=="")?"N":frobFlag%>">
			
<input type="hidden" name="por_cd" value="<%=porCd%>">
<input type="hidden" name="pol_cd" value="<%=polCd%>">
<input type="hidden" name="pod_cd" value="<%=podCd%>">
<input type="hidden" name="del_cd" value="<%=delCd%>">
<!-- 0079-05에서는 입력가능한 field -->
<input type="hidden" name="ff_ref_no" value="<%=ffRefNo%>">
<!-- input type="hidden" name="ex_cust_cnt_cd" value="<%=exCustCntCd%>">
<input type="hidden" name="ex_cust_seq" value="<%=exCustSeq%>"-->
<input type="hidden" name="sam_cnee_ntfy_flg" value="<%=(samCneeNtfyFlg==null||samCneeNtfyFlg=="")?"N":samCneeNtfyFlg%>">
<input type="hidden" name="cust_to_ord_flg" value="<%=(custToOrdFlg==null||custToOrdFlg=="")?"N":custToOrdFlg%>">
<input type="hidden" name="an_cust_eml" value="<%=anCustEml %>">
<input type="hidden" name="an_cust_fax_no" value="<%=anCustFaxNo %>">

<!--  A/Customer Pop-up 을 띄우기 위한 parameter 보관 (S)-->
<input type="hidden" name="sc_no" value="<%=scNo%>">
<input type="hidden" name="rfa_no" value="<%=rfaNo%>">
<input type="hidden" name="svc_scp_cd" value="<%=svcScpCd%>">
<input type="hidden" name="appl_dt" value="<%=applDt%>">
<!--  A/Customer Pop-up 을 띄우기 위한 parameter 보관 (E)-->

<!--  India GST No (S)-->
<input type="hidden" name="sh_ida_gst_rgst_no" >
<input type="hidden" name="cn_ida_gst_rgst_no" >
<input type="hidden" name="nf_ida_gst_rgst_no" >
<!--  India GST No (E)-->

<!-- China USCI/ORG/B.License Code Code (S) -->
<input type="hidden" name="sh_co_chn_no" >
<input type="hidden" name="cn_co_chn_no" >
<input type="hidden" name="nf_co_chn_no" >
<!-- China USCI/ORG/B.License Code Code (E) -->

<input type="hidden" name="nl_flag">
<input type="hidden" name="eu24_flg">

<input type="hidden" name="indiv_pson_flg">

<!-- 개발자 작업	-->
			<tr><td class="bg">
				<table class="search" border="0" style="width:958;"> 
				<tr class="h23">
					<td width="480" valign="top">
					<!--  biz_1  (S) -->
					<table class="search" border="0">
						<tr>
							<td width="240"><table class="search" border="0">
									<tr><td class="title_h"></td>
										<td class="title_s">Booking Data ALPS</td></tr>
									<tr><td class="height_5"></td></tr>
								</table>
							</td>
							<td  width="240" align="right"><table width="150"  border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn_cancelcopydata">Cancel&nbsp;Copy&nbsp;Data</td>
								<td class="btn2_right"></td>
								</tr>
							</table></td>
						</tr>
					</table>
					
					<table class="search_ssm" border="0" style="width:480;">
					<tr class="h23"><td valign="top">
						<table class="search" border="0">
							<tr class="h23">
								<td width="200" colspan="4">Booking No.&nbsp;&nbsp;<input type="text" name="bkg_no" style="width:105;" class="input2" value="<%=(!"".equals(bkgNo))?bkgNo:StringUtil.xssFilter(request.getParameter("bkg_no"))%>"></td>
								<td width="200">A/Customer 
								<input type="text" name="agmt_act_cnt_cd" style="width:23;" class="input2" value="<%=agmtActCntCd%>"  maxlength=2 dataformat="engup" readOnly>
								<input type="text" name="agmt_act_cust_seq" style="width:50;" class="input2" value="<%=agmtActCustSeq%>" maxlength=6 dataformat="int" readOnly>
								<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_t7Sa0190"  id="btn_t7Sa0190"></td>
								<td name="td_t7Delete" id="td_t7Delete" style="display:none;"><table width="90%" border="0" cellpadding="0" cellspacing="0" class="button" id = "del_btn">
										<tr><td class="btn2_left"></td><td class="btn2_3" name="btn_t7Delete"  id="btn_t7Delete">Del</td><td class="btn2_right"></td></tr></table>
								</td>
							</tr>
						</table>
						<table class="search" border="0">
							<tr class="h23">
								<td width="60">Shipper</td>
								<td width="350">
								<input type="text" name="sh_cust_cnt_cd" style="width:25;" maxlength="2" dataformat="engup" class="input" value="<%=shCustCntCd%>"></input>
								<img src="img/btns_search.gif" name="btn_t7Sh0192" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></img>
								<input type="text" name="sh_cust_seq" style="width:55;" maxlength="6" dataformat="engup" class="input" value="<%=shCustSeq%>"></input>
								<img class="cursor" src="img/btns_inquiry.gif" name="btn_t7ShMdmCustNm" width="19" height="20" border="0" align="absmiddle" name="btn_splitPop"></img>
								<input type="text" name="sh_cust_lgl_eng_nm" style="width:140;" class="input2" value="<%=shCustLglEngNm%>" readOnly></input>
								<input type="text" style="width:25;" class="input2" value="<%=shCustTp%>" readonly name="sh_cust_tp">
								</td>
								<!--<td class="2" align="right"><%//=getComboString("kr_cstms_cust_tp_cd", "width:85;", "", "",KrCstmsCustTpCd, "All", tp_cd)%>-->
								<td>
								<script language="javascript" >ComComboObject('kr_cstms_cust_tp_cd', 2, 90, 1, 0, 2)</script> 
								</td>
							</tr>
							<tr class="h23">
								<td class="stm">Name</td>
								<td colspan="3"><textarea class="textarea_img2" rows="2" cols="35" style="font-family:Courier New; font-size:15px; text-indent:0px;overflow-x:hidden;overflow-y:scroll"  wrap="physical" dataformat="etc" name="sh_cust_nm"><%=shCustNm%></textarea></td><!-- onBlur="javascript:validateCols('2','35',this);" -->
						</tr>
							<tr class="h23">
								<td class="stm" rowspan="2" valign="top">Address<br>(Print<input type="checkbox" name="sh_addr_prn_flg" value="Y" class="trans" <%=("Y".equals(shAddrPrnFlg))?"checked":""%>>)</td>
								<td colspan="3"><textarea cols="35" name="sh_cust_addr" style="font-family:Courier New; font-size:15px; text-indent:0px;overflow-x:hidden;overflow-y:scroll" class="textarea_img3" dataformat="etc" rows="3"><%=shCustAddr%></textarea></td><!-- onBlur="javascript:validateCols('3','35',this);" -->
							</tr>
							<tr class="h23">
								<td colspan="3">
									<table class="search" border="0">
										<tr class="h23">
											<td width="60">City/State</td>
											<td width="110" style="padding-left:1"><input type="text" name="sh_cust_cty_nm" style="width:60;" dataformat="etc" class="input" value="<%=shCustCtyNm%>">
											<input type="text" name="sh_cust_ste_cd" style="width:30;" maxlength="2" dataformat="engup" class="input" value="<%=shCustSteCd%>"></td>
											<td width="50">Country</td>
											<td width="40" style="padding-left:1"><input type="text" name="sh_cstms_decl_cnt_cd" style="width:30;" maxlength="2" dataformat="engup" class="input" value="<%=shCstmsDeclCntCd%>"></td>
											<td>Zip CD</td>
											<td><input type="text" name="sh_cust_zip_id" style="width:69;" maxlength="10" dataformat="etc" class="input" value="<%=shCustZipId%>">&nbsp;<img src="img/btns_search.gif" name="btn_t7ShZipCode" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
										</tr>
									</table>
									<table class="search" border="0">
										<tr class="h23">
											<td width="80">Street/P.O.Box</td>
											<td width="180" style="padding-left:1"><input type="text" name="sh_eur_cstms_st_nm" style="width:110;" class="input" value="" tabindex=19 dataformat="etc" maxlength=50 style="ime-mode:disabled" ></td>
											<td width="120" id="sh_jpt_gst_man">JAPAN Tel#<br>/GST No</td>
											<td width="85"><input type="text"  name="sh_eori_no" style="width:100;" class="input" value="" tabindex=20 maxlength=20 style="ime-mode:disabled"  dataformat="engup"></td>
										</tr>
									</table>
									<!-- 2018.05.11 : 중국 해관 56호령 관련 컬럼 추가 (S) -->
									<table class="search" border="0">
										<tr class="h23">
											<td width="200" colspan="2">Fax&nbsp;<input type="text" name="sh_cust_fax_no" style="width:163;" dataformat="etc" class="input" maxlength="20" value="<%=shCustFaxNo%>"></td>
											<td colspan="5">E-mail&nbsp;<input type="text" name="sh_cust_eml" style="width:168;" dataformat="etc" class="input" value="<%=shCustEml%>"></td>
										</tr>
									</table>
									<table class="search" border="0">
										<tr class="h23">
											<td width="200" colspan="2">Tel&nbsp;&nbsp;<input type="text" name="sh_cust_phn_no" style="width:163;" dataformat="etc" class="input" maxlength="20" value="<%=shCustPhnNo%>"></td>
										</tr>
									</table>
									<!-- 2018.05.11 : 중국 해관 56호령 관련 컬럼 추가 (E) -->
								</td>
							</tr>
						</table>
						<table class="height_10"><tr><td colspan="8"></td></tr></table>
						
						<table class="search" border="0">
							<tr class="h23">
								<td width="60">Consignee</td>
								<td width="280">
									<input type="text" name="cn_cust_cnt_cd" style="width:25;" maxlength="2" dataformat="engup" class="input" value="<%=cnCustCntCd%>"></input>
									<img src="img/btns_search.gif" name="btn_t7Cn0192" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></img>
									<input type="text" name="cn_cust_seq" style="width:55;" maxlength="6" dataformat="engup" class="input" value="<%=cnCustSeq%>"></input>
									<img class="cursor" src="img/btns_inquiry.gif" name="btn_t7CnMdmCustNm" width="19" height="20" border="0" align="absmiddle" name="btn_splitPop"></img>
									<input type="text" name="cn_cust_lgl_eng_nm" style="width:130;" class="input2" value="<%=cnCustLglEngNm%>" readOnly></input>&nbsp;
								</td>
								<td align="right">B/L TP
								<select style="width:80;" name="bl_tp_cd">
									<option value="N" <%=("N".equals(custToOrdFlg))?"selected":""%>>Straight</option>
									<option value="Y" <%=("Y".equals(custToOrdFlg))?"selected":""%>>Order</option>
								</select>&nbsp;</td>
							</tr>
							<tr class="h23">
								<td class="stm">Name</td>
								<td colspan="3"><textarea name="cn_cust_nm" style="font-family:Courier New; font-size:15px; text-indent:0px;overflow-x:hidden;overflow-y:scroll" class="textarea_img2" dataformat="etc" cols="35" rows="2"><%=cnCustNm%></textarea></td><!-- onBlur="javascript:validateCols('2','35',this);"  -->
							</tr>
							<tr class="h23">
								<td class="stm" rowspan="2" valign="top">Address<br>(Print<input type="checkbox" name="cn_addr_prn_flg" value="Y" class="trans" <%=("Y".equals(cnAddrPrnFlg))?"checked":""%>>)</td>
								<td colspan="3"><textarea name="cn_cust_addr" style="font-family:Courier New; font-size:15px; text-indent:0px;overflow-x:hidden;overflow-y:scroll" class="textarea_img3" dataformat="etc" cols="35" rows="3"><%=cnCustAddr%></textarea></td> <!-- onBlur="javascript:validateCols('3','35',this);"  -->
							</tr>
							<tr class="h23">
								<td colspan="3">
									<table class="search" border="0">
										<tr class="h23">
											<td width="60">City/State</td>
											<td width="110"><input type="text" name="cn_cust_cty_nm" style="width:60;" dataformat="etc" class="input" value="<%=cnCustCtyNm%>">
											<input type="text" name="cn_cust_ste_cd" style="width:30;" maxlength="2" dataformat="engup" class="input" value="<%=cnCustSteCd%>"></td>
											<td width="50">Country</td>
											<td width="40"><input type="text" name="cn_cstms_decl_cnt_cd" style="width:30;" maxlength="2" dataformat="engup" class="input" value="<%=cnCstmsDeclCntCd%>"></td>
											<td>Zip CD</td>
											<td><input type="text" name="cn_cust_zip_id" style="width:69;" maxlength="10" dataformat="etc" class="input" value="<%=cnCustZipId%>">&nbsp;<img src="img/btns_search.gif" name="btn_t7CnZipCode" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
										</tr>
									</table>										
									<table class="search" border="0">
										<tr class="h23">
											<td width="100">Street/P.O.Box</td>
											<td width="" style="padding-left:1"><input type="text" name="cn_eur_cstms_st_nm" style="width:110;" class="input" value="" tabindex=19 dataformat="etc" maxlength=50 style="ime-mode:disabled" >
										</tr>
									</table>
									<table class="search" border="0">
										<tr class="h23">
											<td width="100" id="cn_jpt_gst_man">JAPAN Tel#<br />/GST No</td>
											<td>
												<select name="cn_co_chn_tp_cd" style="display:none;">
													<option value="U">USCI Code</option>
													<option value="O">Org. Code</option>
													<option value="B">Business License No</option>
												</select>
											</td>
											<td width=""><input type="text"  name="cn_eori_no" style="width:160;" class="input" value="" tabindex=20 maxlength=20 style="ime-mode:disabled"  dataformat="engup"></td>
										</tr>
									</table>
									<table class="search" border="0">
										<tr class="h23">
											<td width="200" colspan="2">IEC/Fax&nbsp;<input type="text" name="cn_cust_fax_no" style="width:140;" dataformat="etc" class="input" maxlength="20" value="<%=cnCustFaxNo%>"></td>
											<td colspan="5">E-mail&nbsp;<input type="text" name="cn_cust_eml" style="width:165;" dataformat="etc" class="input" value="<%=cnCustEml%>"></td>
										</tr>
									</table>
									<!-- 2018.05.11 : 중국 해관 56호령 관련 컬럼 추가 (S) -->
									<table class="search" border="0">
										<tr class="h23">
											<td width="49">Tel</td>
											<td width=""><input type="text" name="cn_cust_phn_no" style="width:140;" dataformat="etc" class="input" maxlength="20" value="<%=cnCustPhnNo%>"></td>
										</tr>
									</table>
									<!-- 2018.05.11 : 중국 해관 56호령 관련 컬럼 추가 (E) -->
								</td>
							</tr>
						</table>
						
						<table class="height_10"><tr><td colspan="8"></td></tr></table>
						
						<table class="search" border="0">
							<tr class="h23">
								<td width="60">Notify</td>
								<td width="280">
									<input type="text" name="nf_cust_cnt_cd" style="width:25;" maxlength="2" dataformat="engup" class="input" value="<%=nfCustCntCd%>"></input>
									<img src="img/btns_search.gif" name="btn_t7Nf0192" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></img>
									<input type="text" name="nf_cust_seq" style="width:55;" maxlength="6" dataformat="engup" class="input" value="<%=nfCustSeq%>"></input>
									<img class="cursor" src="img/btns_inquiry.gif" name="btn_t7NfMdmCustNm" width="19" height="20" border="0" align="absmiddle" name="btn_splitPop"></img>
									<input type="text" name="nf_cust_lgl_eng_nm" style="width:130;" class="input2" value="<%=nfCustLglEngNm%>" readOnly></input>
								</td>
								<td align="right"></td>
							</tr>
							<tr class="h23">
								<td class="stm">Name</td>
								<td colspan="3"><textarea name="nf_cust_nm" style="font-family:Courier New; font-size:15px; text-indent:0px;overflow-x:hidden;overflow-y:scroll" class="textarea_img2" dataformat="etc" cols="35" rows="2"><%=nfCustNm%></textarea></td><!-- onBlur="javascript:validateCols('2','35',this);" -->
							</tr>
							<tr class="h23">
								<td class="stm" rowspan="2" valign="top">Address<br>(Print<input type="checkbox" name="nf_addr_prn_flg" value="Y" class="trans" <%=("Y".equals(nfAddrPrnFlg))?"checked":""%>>)</td>
								<td colspan="3"><textarea name="nf_cust_addr" style="font-family:Courier New; font-size:15px; text-indent:0px;overflow-x:hidden;overflow-y:scroll" class="textarea_img3" dataformat="etc" cols="35" rows="3"><%=nfCustAddr%></textarea></td><!--  onBlur="javascript:validateCols('3','35',this);" -->							</tr>
							<tr class="h23">
								<td colspan="3">
									<table class="search" border="0">
										<tr class="h23">
											<td width="60">City/State</td>
											<td width="110"><input type="text" name="nf_cust_cty_nm" style="width:60;" dataformat="etc" class="input" value="<%=nfCustCtyNm%>">
											<input type="text" name="nf_cust_ste_cd" style="width:30;" maxlength="2" dataformat="engup" class="input" value="<%=nfCustSteCd%>"></td>
											<td width="50">Country</td>
											<td width="40"><input type="text" name="nf_cstms_decl_cnt_cd" style="width:30;" maxlength="2" dataformat="engup" class="input" value="<%=nfCstmsDeclCntCd%>"></td>
											<td>Zip CD</td>
											<td><input type="text" name="nf_cust_zip_id" style="width:69;" maxlength="10" dataformat="etc" class="input" value="<%=nfCustZipId%>">&nbsp;<img src="img/btns_search.gif" name="btn_t7NfZipCode" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></img></td>
										</tr>			
									</table>
									<table class="search" border="0">							
										<tr class="h23">
											<td width="100">Street/P.O.Box</td>
											<td width="" style="padding-left:1"><input type="text" name="nf_eur_cstms_st_nm" style="width:110;" class="input" value="" tabindex=19 dataformat="etc" maxlength=50 style="ime-mode:disabled" ></td>
										</tr>
									</table>
									<table class="search" border="0">
										<tr class="h23">
											<td width="100" id="nf_jpt_gst_man">JAPAN Tel#<br />/GST No</td>
											<td>
												<select name="nf_co_chn_tp_cd" style="display:none;">
													<option value="U">USCI Code</option>
													<option value="O">Org. Code</option>
													<option value="B">Business License No</option>
												</select>
											</td>
											<td width=""><input type="text"  name="nf_eori_no" style="width:160;" class="input" value="" tabindex=20 maxlength=20 style="ime-mode:disabled"  dataformat="engup"></td>
										</tr>
									</table>
									<table class="search" border="0">
										<tr class="h23">
											<td width="200" colspan="2">Fax&nbsp;<input type="text" name="nf_cust_fax_no" style="width:163;" dataformat="etc" class="input"  maxlength="20"  value="<%=nfCustFaxNo%>"></td>
											<td colspan="5">E-mail&nbsp;<input type="text" name="nf_cust_eml" style="width:168;" dataformat="etc" class="input" value="<%=nfCustEml%>"></td>
										</tr>
									</table>
									<!-- 2018.05.11 : 중국 해관 56호령 관련 컬럼 추가 (S) -->
									<table class="search" border="0">
										<tr class="h23">
											<td width="200" colspan="2">Tel&nbsp;&nbsp;<input type="text" name="nf_cust_phn_no" style="width:163;" dataformat="etc" class="input" maxlength="20" value="<%=nfCustPhnNo%>"></td>
										</tr>
									</table>
									<!-- 2018.05.11 : 중국 해관 56호령 관련 컬럼 추가 (E) -->
								</td>
							</tr>
						</table>
						
						<table class="height_10"><tr><td colspan="8"></td></tr></table>
						
						<table class="search" border="0">
							<tr class="h23">
								<td width="60">Forwarder</td>
								<td width="280">
									<input type="text" name="ff_cust_cnt_cd" style="width:25;" maxlength="2" dataformat="engup" class="input" value="<%=ffCustCntCd%>"></input>
									<img src="img/btns_search.gif" name="btn_t7Ff0192" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></img>
									<input type="text" name="ff_cust_seq" style="width:55;" maxlength="6" dataformat="engup" class="input" value="<%=ffCustSeq%>"></input>
									<img class="cursor" src="img/btns_inquiry.gif" name="btn_t7FfMdmCustNm" width="19" height="20" border="0" align="absmiddle" name="btn_splitPop"></img>
									<input type="text" name="ff_cust_lgl_eng_nm" style="width:130;" class="input2" value="<%=ffCustLglEngNm%><%=ffCustAddr%>" readOnly></input>
									
								</td>
								<td align="right">FMC No.<input type="text" readonly name="fmc_cd" style="width:65;" class="input2" value="<%=fmcCD%>" tabindex=63></input></td>
							</tr>
							<tr class="h23">
								<td class="stm">Name & <br>Address<br>(Print<input type="checkbox" name="ff_addr_prn_flg" value="Y" class="trans" <%=("Y".equals(ffAddrPrnFlg))?"checked":""%>>)</td>
								<td colspan="3"><textarea name="ff_cust_nm" style="font-family:Courier New; font-size:15px; text-indent:0px;overflow-x:hidden;overflow-y:scroll" class="textarea_img5" dataformat="etc" cols="35" rows="5"><%=ffCustNm%></textarea></td><!-- onBlur="javascript:validateCols('5','35',this);"  -->
							</tr>
						</table>
						
						<table class="height_10"><tr><td colspan="8"></td></tr></table>
						
						<table class="search" border="0">
							<tr class="h23">
								<td width="60">Also NTFY</td>
								<td width="280px">
								<input type="text" name="an_cust_cnt_cd" style="width:25;" maxlength="2" dataformat="engup" class="input" value="<%=anCustCntCd%>"></input>
								<img src="img/btns_search.gif" name="btn_t7An0192" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></img>
								<input type="text" name="an_cust_seq" style="width:55;" maxlength="6" dataformat="engup" class="input" value="<%=anCustSeq%>"></input>
								<img class="cursor" src="img/btns_inquiry.gif" name="btn_t7AnMdmCustNm" width="19" height="20" border="0" align="absmiddle" name="btn_splitPop"></img>
								<input type="text" name="an_cust_lgl_eng_nm" style="width:130;" class="input2" value="<%=anCustLglEngNm%><%=anCustAddr%>" readOnly></input>
								</td>
								<td align="right"></td>
							</tr>
							<tr class="h23">
								<td class="stm">Name & <br>Address<br>(Print<input type="checkbox" name="an_addr_prn_flg" value="Y" class="trans" <%=("Y".equals(anAddrPrnFlg))?"checked":""%>>)</td>
								<td colspan="3"><textarea name="an_cust_nm" style="font-family:Courier New; font-size:15px; text-indent:0px;overflow-x:hidden;overflow-y:scroll" class="textarea_img5" dataformat="etc"  cols="35" rows="5"><%=anCustNm%></textarea></td><!-- onBlur="javascript:validateCols('5','35',this);" -->
							</tr>
						</table>
						
						<table class="height_10"><tr><td colspan="8"></td></tr></table>
						
						<table class="search" border="0">
							<tr class="h23">
								<td width="50">Export<br>Ref.</td>
								<td width="280px" rowspan="2"><textarea name="ex_cust_nm" style="font-family:Courier New; font-size:15px; text-indent:0px;overflow-x:hidden;overflow-y:scroll" class="textarea_img3" dataformat="etc" cols="35" rows="3"><%=exCustNm%></textarea></td><!-- onBlur="javascript:validateCols('3','35',this);"  -->
							</tr>
							<tr class="h23">
								<td width="50" class="stm">Print<input type="checkbox" name="ex_addr_prn_flg" value="Y" class="trans" <%=("Y".equals(exAddrPrnFlg))?"checked":""%>></td>
							</tr>
						</table>
						<table class="search" border="0">
							<tr class="h23">
								<td width="60" class="stm">EDI Ref.</td>
								<td width="">
									<input type="text" style="width:30;" class="input" value="" name="ex_cust_cnt_cd" maxlength=2 dataformat="engup" >
									<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_t7Ex0192"  id="btn_t7Ex0192">
									<input type="text" style="width:58;" class="input" value="" name="ex_cust_seq"   maxlength=6 style="ime-mode:disabled"  dataformat="int">&nbsp;
									<input type="text" style="width:200;" class="input2" value="" name="ex_cust_lgl_eng_nm"  readonly></td>
							</tr>
						</table>
						<table class="search" border="0"> 
							<tr class="h23">
								<td width="50" class="stm">Country<br>of Origin</td>
								<td width="280" ><input type="text" name="org_cnt_nm" style="width:330;" dataformat="etc" class="input" maxlength=32 value="<%=orgCntNm%>"></td>
							</tr>
						</table>
						
						<table class="height_10"><tr><td colspan="8"></td></tr></table>
						
						<table class="search" border="0">
							<tr class="h23">
								<td width="50">Broker</td>
								<td width="280" ><input type="text" name="br_cust_cnt_cd" style="width:250;" dataformat="etc" class="input" value="<%=brCustNm%>"></td>
							</tr>
							<tr class="h23">
								<td class="stm" rowspan="2"></td>
								<td width="280"><textarea name="br_cust_nm" dataformat="etc" style="font-family:Courier New; font-size:15px; text-indent:0px;overflow-x:hidden;overflow-y:scroll" cols="35" rows="4"><%=brCustNm%></textarea><br></td><!-- onBlur="javascript:validateCols('4','35',this);"  -->
							</tr>
							<tr class="h23">
								<td width="280"><textarea name="br_cust_addr" dataformat="etc" style="font-family:Courier New; font-size:15px; text-indent:0px;overflow-x:hidden;overflow-y:scroll" cols="35" rows="4"><%=brCustAddr%></textarea><br></td><!-- onBlur="javascript:validateCols('5','35',this);"  -->
							</tr>
						</table>

					</td></tr>
					</table>
					<!--  biz_1  (E) -->
					</td>
					<td width="12">&nbsp;</td>
					<td width="479" valign="top">
					<!--  biz_2  (S) -->
					<table class="search" border="0">
						<tr>
							<td width="240"><table class="search" border="0">
									<tr><td class="title_h"></td>
										<td class="title_s">From e- Service</td></tr>
									<tr><td class="height_5"></td></tr>
								</table>
							</td>
							<td  width="240" align="right"><table width="150" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn_datacopytoalps">Data&nbsp;Copy&nbsp;to&nbsp;ALPS</td>
								<td class="btn2_right"></td>
								</tr>
								</table>
							</td>
							</tr>
					</table>
					
					<table class="search_ssm1" border="0" style="width:479;">
					<tr class="h23"><td valign="top">
						<table class="search" border="0">
							<tr class="h23">
								<td width="80">Request No.</td>
								<td width="200"><input type="text" name="xter_rqst_no" style="width:105;" class="input2" value="<%=xterRqstNo%>" readOnly></td>
								<td width="200" colspan="2">A/Customer 
								<input type="text" name="agmt_act_cnt_cd2" style="width:23;" class="input2" value="<%=agmtActCntCd2%>"  readOnly>
								<input type="text" name="agmt_act_cust_seq2" style="width:50;" class="input2" value="<%=agmtActCustSeq2%>" readOnly></td>
							</tr>
						</table>
						<table class="search" border="0">
							<tr class="h23">
								<td width="60">Shipper</td>
								<td width="340"><input type="text" name="sh_cust_cnt_cd2" style="width:25;" class="input2" value="<%=shCustCntCd2%>" readOnly>
								<input type="text" name="sh_cust_seq2" style="width:55;" class="input2" value="<%=shCustSeq2%>" readOnly>
								<input type="text" name="sh_cust_lgl_eng_nm2" style="width:140;" class="input2" value="<%=shCustLglEngNm2%>" readOnly>
								<input type="text" name="sh_kr_cstms_cust_tp_cd2" style="width:20;" class="input2" value="<%=shKrCstmsCustTpCd2%>" readOnly>
<% if ("WEB".equals(sender)){
%>
								<input type="text" name="sh_kr_cstms_cust_tp_nm" style="width:50;" class="input2" value="<%=shKrCstmsCustTpNm2%>" readOnly>
<%} else{
%>		
                                <input type="hidden" name="sh_kr_cstms_cust_tp_nm" style="width:50;" class="input2" value="<%=shKrCstmsCustTpNm2%>" readOnly>
<% } %>                                						
								</td>
								<td class="2" align="right"></td> 
								
							</tr>
							<tr class="h23">
								<td class="stm">Name</td>
								<td colspan="3"><textarea name="sh_cust_nm2" cols="43" rows="2" style="font-family:Courier New; font-size:15px; text-indent:0px;overflow-x:hidden;overflow-y:scroll" class="textarea2" readOnly><%=shCustNm2%></textarea></td>								
							</tr>
							<tr class="h23">
								<td class="stm" rowspan="2" valign="top">Address</td>
								<td colspan="3"><textarea name="sh_cust_addr2" cols="43" rows="3" style="font-family:Courier New; font-size:15px; text-indent:0px;overflow-x:hidden;overflow-y:scroll" class="textarea2" readOnly><%=shCustAddr2%></textarea></td>
							</tr>
							<tr class="h23">
								<td colspan="3">
									<table class="search" border="0">
										<tr class="h23">
											<td width="60">City/State</td>
											<td width="110"><input type="text" name="sh_cust_cty_nm2" style="width:60;" class="input2" value="<%=shCustCtyNm2%>" readOnly>
											<input type="text" name="sh_cust_ste_cd2" style="width:30;" class="input2" value="<%=shCustSteCd2%>" readOnly></td>
											<td width="50">Country</td>
											<td width="50"><input type="text" name="sh_cstms_decl_cnt_cd2" style="width:30;" class="input2" value="<%=shCstmsDeclCntCd2%>" readOnly></td>
											<td>Zip CD</td>
											<td><input type="text" name="sh_cust_zip_id2" style="width:60;" class="input2" value="<%=shCustZipId2%>" readOnly>&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_t7ShZipCode"  id="btn_t7ShZipCode"></td>
										</tr>
									</table>
									<table class="search" border="0">
										<tr class="h23">
											<td width="80">Street/P.O.Box</td>
											<td width="180" style="padding-left:1"><input type="text" name="sh_eur_cstms_st_nm2" style="width:110;" class="input2" value="<%=shEurCstmsStNm2%>" readOnly></td>
											<td width="120" id="sh_jpt_gst_man2">JAPAN Tel#<br>/GST No</td>
											<td width="85"><input type="text"  name="sh_eori_no2" style="width:100;" class="input2" value="<%=shEoriNo2%>" tabindex=20 maxlength=20 style="ime-mode:disabled"  dataformat="etc" readOnly></td>
										</tr>
									</table>
									<!-- 2018.05.11 : 중국 해관 56호령 관련 컬럼 추가 (S) -->
									<table class="search" border="0">
										<tr class="h23">
											<td width="200" colspan="2">Fax&nbsp;<input type="text" name="sh_cust_fax_no2" style="width:160;" class="input2" value="<%=shCustFaxNo2%>" readOnly></td>
											<td colspan="5">E-mail&nbsp;<input type="text" name="sh_cust_eml2" style="width:160;" class="input2" value="<%=shCustEml2%>" readOnly></td>
										</tr>
									</table>
									<table class="search" border="0">
										<tr class="h23">
											<td width="200" colspan="2">Tel&nbsp;&nbsp;<input type="text" name="sh_cust_phn_no2" style="width:160;" class="input2" value="<%=shCustPhnNo2%>" readOnly></td>
										</tr>
									</table>
									<!-- 2018.05.11 : 중국 해관 56호령 관련 컬럼 추가 (E) -->
								</td>
							</tr>
						</table>
						<table class="height_10"><tr><td colspan="8"></td></tr></table>
						
						<table class="search" border="0">
							<tr class="h23">
								<td width="60">Consignee</td>
								<td width="260"><input type="text" name="cn_cust_cnt_cd2" style="width:25;" class="input2" value="<%=cnCustCntCd2%>" readOnly>
								<input type="text" name="cn_cust_seq2" style="width:55;" class="input2" value="<%=cnCustSeq2%>" readOnly>
								<input type="text" name="cn_cust_lgl_eng_nm2" style="width:130;" class="input2" value="<%=cnCustLglEngNm2%>" readOnly></td>
								<td align="right"></td>
							</tr>
							<tr class="h23">
								<td class="stm">Name</td>
								<td colspan="3"><textarea name="cn_cust_nm2" cols="43" rows="2" style="font-family:Courier New; font-size:15px; text-indent:0px;overflow-x:hidden;overflow-y:scroll" class="textarea2" readOnly><%=cnCustNm2%></textarea></td>
							</tr>
							<tr class="h23">
								<td class="stm" rowspan="2" valign="top">Address</td>
								<td colspan="3"><textarea name="cn_cust_addr2" cols="43" rows="3" style="font-family:Courier New; font-size:15px; text-indent:0px;overflow-x:hidden;overflow-y:scroll" class="textarea2" readOnly><%=cnCustAddr2%></textarea></td>
							</tr>
							<tr class="h23">
								<td colspan="3">
									<table class="search" border="0">
										<tr class="h23">
											<td width="60">City/State</td>
											<td width="110"><input type="text" name="cn_cust_cty_nm2" style="width:60;" class="input2" value="<%=cnCustCtyNm2%>" readOnly>
											<input type="text" name="cn_cust_ste_cd2" style="width:30;" class="input2" value="<%=cnCustSteCd2%>" readOnly></td>
											<td width="50">Country</td>
											<td width="50"><input type="text" name="cn_cstms_decl_cnt_cd2" style="width:30;" class="input2" value="<%=cnCstmsDeclCntCd2%>" readOnly></td>
											<td>Zip CD</td>
											<td><input type="text" name="cn_cust_zip_id2" style="width:60;" class="input2" value="<%=cnCustZipId2%>" readOnly>&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_t7CnZipCode" id="btn_t7CnZipCode"></td>
										</tr>
									</table>
									<table class="search" border="0">
										<tr class="h23">
											<td width="80">Street/P.O.Box</td>
											<td width="180" style="padding-left:1"><input type="text" name="cn_eur_cstms_st_nm2" style="width:110;" class="input2" value="<%=cnEurCstmsStNm2%>" tabindex=19 dataformat="etc" maxlength=50 style="ime-mode:disabled" readOnly></td>
											<td width="120" id="cn_jpt_gst_man2">JAPAN Tel#<br>/GST No</td>
											<td width="85"><input type="text"  name="cn_co_chn_tp_cd2" style="width:20;" class="input2" value="<%=cnCoChnTpCd2%>" tabindex=20 maxlength=20 style="ime-mode:disabled"  dataformat="etc" readOnly></td>
											<td width="85"><input type="text"  name="cn_eori_no2" style="width:100;" class="input2" value="<%=cnEoriNo2%>" tabindex=20 maxlength=20 style="ime-mode:disabled"  dataformat="etc" readOnly></td>
										</tr>
									</table>
									<table class="search" border="0">
										<tr class="h23">
											<td width="200" colspan="2">IEC/Fax&nbsp;<input type="text" name="cn_cust_fax_no2" style="width:140;" class="input2" value="<%=cnCustFaxNo2%>" readOnly></td>
											<td colspan="5">E-mail&nbsp;<input type="text" name="cn_cust_eml2" style="width:165;" class="input2" value="<%=cnCustEml2%>" readOnly></td>
										</tr>
									</table>
									<!-- 2018.05.11 : 중국 해관 56호령 관련 컬럼 추가 (S) -->
									<table class="search" border="0">
										<tr class="h23">
											<td width="49">Tel</td>
											<td width=""><input type="text" name="cn_cust_phn_no2" style="width:140;" class="input2" value="<%=cnCustPhnNo2%>" readOnly></td>
										</tr>
									</table>
									<!-- 2018.05.11 : 중국 해관 56호령 관련 컬럼 추가 (E) -->
								</td>
							</tr>
						</table>
						
						<table class="height_10"><tr><td colspan="8"></td></tr></table>
						
						<table class="search" border="0">
							<tr class="h23">
								<td width="60">Notify</td>
								<td width="260"><input type="text" name="nf_cust_cnt_cd2" style="width:25;" class="input2" value="<%=nfCustCntCd2%>" readOnly>
								<input type="text" name="nf_cust_seq2" style="width:55;" class="input2" value="<%=nfCustSeq2%>" readOnly>&nbsp;<input type="text" name="nf_cust_lgl_eng_nm2" style="width:130;" class="input2" value="<%=nfCustLglEngNm2%>" readOnly></td>
								<td align="right"></td>
							</tr>
							<tr class="h23">
								<td class="stm">Name</td>
								<td colspan="3"><textarea name="nf_cust_nm2" cols="43" rows="2" style="font-family:Courier New; font-size:15px; text-indent:0px; overflow-x:hidden; overflow-y:scroll" class="textarea2" readOnly><%=nfCustNm2%></textarea></td>
							</tr>
							<tr class="h23">
								<td class="stm" rowspan="2" valign="top">Address</td>
								<td colspan="3"><textarea name="nf_cust_addr2" cols="43" rows="3" style="font-family:Courier New; font-size:15px; text-indent:0px;overflow-x:hidden;overflow-y:scroll" class="textarea2" readOnly><%=nfCustAddr2%></textarea></td>
							</tr>
							<tr class="h23">
								<td colspan="3">
									<table class="search" border="0">
										<tr class="h23">
											<td width="60">&nbsp;&nbsp;City/State</td>
											<td width="110"><input type="text" name="nf_cust_cty_nm2" style="width:60;" class="input2" value="<%=nfCustCtyNm2%>" readOnly>
											<input type="text" name="nf_cust_ste_cd2" style="width:30;" class="input2" value="<%=nfCustSteCd2%>" readOnly></td>
											<td width="50">Country</td>
											<td width="50"><input type="text" name="nf_cstms_decl_cnt_cd2" style="width:30;" class="input2" value="<%=nfCstmsDeclCntCd2%>" readOnly></td>
											<td>Zip CD</td>
											<td><input type="text" name="nf_cust_zip_id2" style="width:60;" class="input2" value="<%=nfCustZipId2%>" readOnly>&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_t7NfZipCode"  id="btn_t7NfZipCode"></td>
										</tr>
									</table>
									<table class="search" border="0">
										<tr class="h23">
											<td width="80">Street/P.O.Box</td>
											<td width="180" style="padding-left:1"><input type="text" name="nf_eur_cstms_st_nm2" style="width:110;" class="input2" value="<%=nfEurCstmsStNm2%>" tabindex=19 dataformat="etc" maxlength=50 style="ime-mode:disabled" readOnly></td>
											<td width="120" id="nf_jpt_gst_man2">JAPAN Tel#<br>/GST No</td>
											<td width="85"><input type="text"  name="nf_co_chn_tp_cd2" style="width:20;" class="input2" value="<%=nfCoChnTpCd2%>" tabindex=20 maxlength=20 style="ime-mode:disabled"  dataformat="etc" readOnly></td>
											<td width="85"><input type="text"  name="nf_eori_no2" style="width:100;" class="input2" value="<%=nfEoriNo2%>" tabindex=20 maxlength=20 style="ime-mode:disabled"  dataformat="etc" readOnly></td>
										</tr>
									</table>
									<table class="search" border="0">
										<tr class="h23">
											<td width="210" colspan="2">&nbsp;&nbsp;Fax&nbsp;<input type="text" name="nf_cust_fax_no2" style="width:160;" class="input2" value="<%=nfCustFaxNo2%>" readOnly></td>
											<td colspan="5">E-mail&nbsp;<input type="text" name="nf_cust_eml2" style="width:160;" class="input2" value="<%=nfCustEml2%>" readOnly></td>
										</tr>
									</table>
									<!-- 2018.05.11 : 중국 해관 56호령 관련 컬럼 추가 (S) -->
									<table class="search" border="0">
										<tr class="h23">
											<td width="210" colspan="2">&nbsp;&nbsp;Tel&nbsp;&nbsp;<input type="text" name="nf_cust_phn_no2" style="width:160;" class="input2" value="<%=nfCustPhnNo2%>" readOnly></td>
										</tr>
									</table>
									<!-- 2018.05.11 : 중국 해관 56호령 관련 컬럼 추가 (E) -->
								</td>
							</tr>
						</table>
						
						<table class="height_10"><tr><td colspan="8"></td></tr></table>
						
						<table class="search" border="0">
							<tr class="h23">
								<td width="60">Forwarder</td>
								<td width="260"><input type="text" name="ff_cust_cnt_cd2" style="width:25;" class="input2" value="<%=ffCustCntCd2%>" readOnly>
								<input type="text" name="ff_cust_seq2" style="width:55;" class="input2" value="<%=ffCustSeq2%>" readOnly>
								<input type="text" name="ff_cust_lgl_eng_nm2" style="width:130;" class="input2" value="<%=ffCustLglEngNm2%><%=ffCustAddr2%>" readOnly></td>
								<td align="right"></td>
							</tr>
							<tr class="h23">
								<td class="stm">Name & <br>Address</td>
								<td colspan="3"><textarea name="ff_cust_nm2" cols="43" rows="5" style="font-family:Courier New; font-size:15px; text-indent:0px;overflow-x:hidden;overflow-y:scroll" class="textarea2" readOnly><%=ffCustNm2%></textarea></td>
							</tr>
						</table>
						
						<table class="height_10"><tr><td colspan="8"></td></tr></table>
						
						<table class="search" border="0">
							<tr class="h23">
								<td width="60">Also NTFY</td>
								<td width="260"><input type="text" name="an_cust_cnt_cd2" style="width:25;" class="input2" value="<%=anCustCntCd2%>" readOnly>
								<input type="text" name="an_cust_seq2" style="width:55;" class="input2" value="<%=anCustSeq2%>" readOnly>&nbsp;<input type="text" name="an_cust_lgl_eng_nm2" style="width:130;" class="input2" value="<%=anCustLglEngNm2%><%=anCustAddr2%>" readOnly></td>
								<td align="right"></td>
							</tr>
							<tr class="h23">
								<td class="stm">Name & <br>Address</td>
								<td colspan="3"><textarea name="an_cust_nm2" cols="43" rows="5" style="font-family:Courier New; font-size:15px; text-indent:0px;overflow-x:hidden;overflow-y:scroll" class="textarea2" readOnly><%=anCustNm2%></textarea></td>
							</tr>
						</table>
						
						<table class="height_10"><tr><td colspan="8"></td></tr></table>
						
						<table class="search" border="0">
							<tr class="h23">
								<td width="60">Export <br>Ref.</td>
								<td width="260" rowspan="2"><textarea name="ex_cust_nm2" cols="43" rows="3" style="font-family:Courier New; font-size:15px; text-indent:0px;overflow-x:hidden;overflow-y:scroll" class="textarea2" readOnly><%=exCustNm2%></textarea></td>
							</tr>
						</table>
						
						<table class="search" border="0">
							<tr class="h23">
								<td width="60" class="stm">EDI Ref.</td>
								<td width="">
									<input type="text" style="width:30;" class="input2" value="<%=exCustCntCd2%>" name="ex_cust_cnt_cd2" maxlength=2 style="ime-mode:disabled"  dataformat="engup" >&nbsp;
									<input type="text" style="width:58;" class="input2" value="<%=exCustSeq2%>" name="ex_cust_seq2"   maxlength=6 style="ime-mode:disabled"  dataformat="int" >&nbsp;
									<input type="text" style="width:200;" class="input2" value="<%=exCustLglEngNm2%>" name="ex_cust_lgl_eng_nm2"  readonly>
								</td>
									
							</tr>
						</table>
						
						<table class="search" border="0" style="width:460;"> 
							<tr class="h23">
								<td width="120" class="stm">Country<br>of Origin</td>
								<td width=""> <input type="text" style="width:400;" class="input2" name="org_cnt_nm2" value="<%=orgCntNm2%>" readOnly></td>
							</tr>
						</table>
						
						<table class="height_10"><tr><td colspan="8"></td></tr></table>
						
						<table class="search" border="0">
							<tr class="h23">
								<td width="60">Broker</td>
								<td width="260"><input type="text" name="br_cust_cnt_cd2" style="width:130;" class="input2" value="<%=brCustCntCd2%>" readOnly></td>
							</tr>
							<tr class="h23">
								<td class="stm" rowspan="2"></td>
								<td width="260"><textarea name="br_cust_nm2" cols="43" rows="4" style="font-family:Courier New; font-size:15px; text-indent:0px;overflow-x:hidden;overflow-y:scroll" class="textarea2" readOnly><%=brCustNm2%></textarea><br></td>
							</tr>
							<tr class="h23">
								<td width="260"><textarea name="br_cust_addr2" cols="43" rows="4" style="font-family:Courier New; font-size:15px; text-indent:0px;overflow-x:hidden;overflow-y:scroll" class="textarea2" readOnly><%=brCustAddr2%></textarea><br></td>
							</tr>
						</table>
						
						<table class="height_10"><tr><td colspan="4"></td></tr></table>
						
						<table class="search" border="0">
							<tr class="h23">
								<td width="60">C.Broker</td> 
								<td align="left"><input type="text" name="cbr_cust_cnt_cd" style="width:250;" class="input2" value="<%=cbrCustNm2%>" readOnly></td>
							</tr>
							<tr class="h23">								
								<td width="50">Fax No</td>
								<td align="left"><input name="cbr_fax12" style="width:250;" class="input2" value="<%=cbrFaxNo12%>" readOnly></td>
							</tr>
							<tr class="h23">								
								<td width="50"></td>
								<td align="left"><input name="cbr_fax22" style="width:250;" class="input2" value="<%=cbrFaxNo22%>" readOnly></td>
							</tr>
							<tr class="h23">								
								<td width="50"></td>
								<td align="left"><input name="cbr_fax32" style="width:250;" class="input2" value="<%=cbrFaxNo32%>" readOnly></td>							
							</tr>
						</table>
					</td></tr>
					</table>
					<!--  biz_2  (E) -->					
					</td></tr>
				</table>
			</td></tr>
		</table>
	<!-- Grid BG Box  (S) --><!--Button (S) -->
	<!-- 	<table width="980" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_upload">Upload</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table> -->
    <!--Button (E) --><!--biz page (E)-->		
		<table width="100%"  id="mainTable"> 
			<tr>
				<td width="100%">
					<script language="javascript">ComSheetObject('sheet1');</script>
				</td>
			</tr>
		</table> 
		</td></tr>
	</table>
</form>
</body>
</html>
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
			String lpadStr = "";
			if ( src != null && src.length() > 0 ) {
				int lpadCount = 6 - src.length();
				for (int i=0;i<lpadCount;i++) {
					//lpadStr = lpadStr + "0";	
					StringBuffer tmpBuffer = new StringBuffer(lpadStr).append("0");
					lpadStr = tmpBuffer.toString();
				}
			} else src = "";
			return lpadStr+src;
		}
%>