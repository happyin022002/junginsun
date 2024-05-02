<%
/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_0229_01.jsp
 *@FileTitle : e-Booking & SI Process Detail(BOOKING)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.02
 *@LastModifier : 전용진
 *@LastVersion : 1.0
 * 2009.07.02 전용진
 * 1.0 Creation
=============================================================================== 
 History
 2010.09.13 이일민 [CHM-201005276-01] ALPS-[BKG/DOC]주요UI버턴-단축키 기능개발
 2010.10.01 이일민 [CHM-201005263] [ESM-BKG] SR 신청 화면 내 고객정보 입력란 추가 요청
 2010.11.04 김영철 [] Booking Creation / Update / Cancel시, Vessel Operation 모듈의 Final CBF 생성 여부를 체크해서 경고 메시지
 2011.02.09 김영철 [CHM-201108366-01,CHM-201108632-01] E-SVC 화면 PICKUP DATE 항목 추가요청, E-BKG & SI Route 데이타 입력 Max값 조정 (25자까지)
 2011.03.30 정선용 [CHM-201109338-01] Split 18-ALPS의 Location 조회불가건 수정 보완 요청.
 2011.05.19 이일민 [CHM-201110187] BKG 조회 및 변경시 ROUTE 정보 비교 로직 보완 - old pctl no 추가
 2011.05.25~06.03 김진승 [CHM-201110982-01] e-SI & DPCS BKG Split & Combine 기능 구현 요청; Split Status 표시, BKG contact, S/I contact 초기 로딩 처리; 
 2011.08.10 정선용 [CHM-201112747-01] Doc requirement상 Issue place 오류 관련 수정 요청
 2011.10.20 정선용 [CHM-201113441-01] BKG 화면의 C.OFC 및 C.REP SELECT POPUP 추가 요청
 2011.11.01 조원주 [CHM-201114224-01][BKG_Charge( RAS )]bkg Main & e-Booking화면에서 Pricing 계약 조회시 Popup 수정 요청
 2011.11.28 정선용 [CHM-201114552-01]	[Simple S/I] 파일 보완 작업 요청
 2011.12.06 정선용 [CHM-201114657-01] [ALPS] E-BKG/SI Freight Term Drop Down Box 삭제 요청
 2012.01.05 금병주 [CHM-201115389-01] bkg 화면에 Port skip일 경우 표기 요청
 2012.11.21 조정민 [CHM-201220708] BOOKNG 생성시나 변경시 S/C 운임 조회 및 G/W 메일 송부 기능 추가 (E-BKG & SI PROCESS)
 2012.12.17 조정민 [CHM-201221684] RFA,TAA 계약에 운임 존재 여부 및 GW 메일 연계 테스트
 2014.10.08 최도순[CHM-201431728] Split 02-SM LINE 조기결산을 위한 개선 방안 중 BKG 관리 프로세스 단축(안) 개발
=========================================================*/
%>
 
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="java.util.List"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkg022901Event"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.common.*"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.*"%>
<%@ page import="com.hanjin.framework.core.controller.DefaultViewAdapter"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.DocRqstVO" %>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.RefNoVO" %>

<%
	EsmBkg022901Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String strOfc_cd = "";
	String StrRhq_ofc_cd= "";
	Logger log = Logger.getLogger("com.hanjin.apps.EBookingConduct.EBookingReceipt");

	List<BkgComboVO> frt_term_cd 		= null;
	List<BkgComboVO> rcv_term 			= null;
	List<BkgComboVO> dlv_term 			= null;
	List<BkgComboVO> wgt_ut_cd 			= null;
	List<BkgComboVO> usa_cstms_file_cd 	= null;
	List<BkgComboVO> cnd_cstms_file_cd 	= null;
	DocRqstVO docRqstVO = null;
	
	String sXml = null;

	XterRqstMstVO rqstVo 	= null;
	//AlpsBkgVO     alpsVo 	= null;
	XterRqstTabVO rqstTabVo = null;
	
	//XterCustChkPntVO xterCustChkPntVO = null;
	//key no
	String bkgNo    = "";
	String blNo     = "";
	String bkgStsCd = "";
	String nonRtStsCd = "";
	String alocStsCd = "";
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
	String vehCmdtFlg	 = "";
	
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
	
	String splitStsCd       = null;
	
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
	
	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		StrRhq_ofc_cd = account.getRhq_ofc_cd();

		event = (EsmBkg022901Event) request.getAttribute("Event");
		
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		frt_term_cd 	  = (List<BkgComboVO>) eventResponse.getCustomData("frt_term_cd");
		rcv_term    	  = (List<BkgComboVO>) eventResponse.getCustomData("rcv_term");
		dlv_term    	  = (List<BkgComboVO>) eventResponse.getCustomData("dlv_term");
		wgt_ut_cd   	  = (List<BkgComboVO>) eventResponse.getCustomData("wgt_ut_cd");
		usa_cstms_file_cd = (List<BkgComboVO>) eventResponse.getCustomData("usa_cstms_file_cd");
		cnd_cstms_file_cd = (List<BkgComboVO>) eventResponse.getCustomData("cnd_cstms_file_cd");
		isVlFlg           = (String) eventResponse.getCustomData("is_vl_flg");

		ExternalRqstBkgVO rqstBkgVo = (ExternalRqstBkgVO) eventResponse.getCustomData("externalRqstBkgVO");
//		xterCustChkPntVO = (XterCustChkPntVO) eventResponse.getCustomData("xterCustChkPntVO");
//		alpsVo    = rqstBkgVo.getAlpsBkgVO();
		rqstVo    = rqstBkgVo.getXterRqstMstVO();
		rqstTabVo = rqstBkgVo.getXterRqstTabVO();

		docRqstVO = (DocRqstVO) eventResponse.getCustomData("DocRqst");
		docTpCd = rqstVo.getDocTpCd();
		
		// Ref
		invRefNo		= eventResponse.getETCData("inv_ref_no");
		bkgRefNo		= eventResponse.getETCData("bkg_ref_no");
		bkgSHRefNo		= eventResponse.getETCData("bkg_sh_ref_no");
		bkgFFRefNo		= eventResponse.getETCData("bkg_ff_ref_no");
		siRefNo			= eventResponse.getETCData("si_ref_no");
		siSHRefNo		= eventResponse.getETCData("si_sh_ref_no");
		siFFRefNo		= eventResponse.getETCData("si_ff_ref_no");
		regBkgNo		= eventResponse.getETCData("reg_bkg_no");
		extMrnNo		= eventResponse.getETCData("ext_mrn_no");
		
		DefaultViewAdapter adapter = new DefaultViewAdapter();
		sXml = adapter.makeXML(request, response);
	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>e-Booking & SI Process Detail(BOOKING)</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

</head>

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="isInquiry">

<!-- Groupmail시 반영될 Hidden --> 
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

<!-- BKG Allocation -->
<input type="hidden" name="aloc_chk_flg">
<input type="hidden" name="bkg_aloc_tp_cd">

<%-- Tab 활성화 여부 확인용 Flag (ESM_BKG_0231) --%>
<input type="hidden" name="save_bkg_flag"  value="<%=("N".equals(replaceNull(rqstTabVo.getAlpsBkg())) && "Y".equals(replaceNull(rqstTabVo.getXterBkg()))) ? "Y" : "N"%>"></input>
<input type="hidden" name="save_cust_flag" value="<%=("Y".equals(replaceNull(rqstTabVo.getAlpsCust())) || "Y".equals(replaceNull(rqstTabVo.getXterCust()))) ? "Y" : "N"%>"></input>
<input type="hidden" name="save_cntr_flag" value="<%=("Y".equals(replaceNull(rqstTabVo.getAlpsCntr())) || "Y".equals(replaceNull(rqstTabVo.getXterCntr()))) ? "Y" : "N"%>"></input>
<input type="hidden" name="save_mnd_flag"  value="<%=("Y".equals(replaceNull(rqstTabVo.getAlpsMnd()))  || "Y".equals(replaceNull(rqstTabVo.getXterMnd()))) ? "Y" : "N"%>"></input>
<input type="hidden" name="save_cm_flag"   value="<%=("Y".equals(replaceNull(rqstTabVo.getAlpsCm()))   || "Y".equals(replaceNull(rqstTabVo.getXterCm()))) ? "Y" : "N"%>"></input>
<input type="hidden" name="save_tro_flag"  value="<%=("Y".equals(replaceNull(rqstTabVo.getAlpsTro()))  || "Y".equals(replaceNull(rqstTabVo.getXterTro()))) ? "Y" : "N"%>"></input>
<input type="hidden" name="save_rf_flag"   value="<%=("Y".equals(replaceNull(rqstTabVo.getAlpsRf()))   || "Y".equals(replaceNull(rqstTabVo.getXterRf()))) ? "Y" : "N"%>"></input>
<input type="hidden" name="save_dg_flag"   value="<%=("Y".equals(replaceNull(rqstTabVo.getAlpsDg()))   || "Y".equals(replaceNull(rqstTabVo.getXterDg()))) ? "Y" : "N"%>"></input>
<input type="hidden" name="save_ak_flag"   value="<%=("Y".equals(replaceNull(rqstTabVo.getAlpsAwk()))  || "Y".equals(replaceNull(rqstTabVo.getXterAwk()))) ? "Y" : "N"%>"></input>
<input type="hidden" name="save_hbl_flag"  value="<%=("Y".equals(replaceNull(rqstTabVo.getAlpsHbl1())) || "Y".equals(replaceNull(rqstTabVo.getXterHbl1()))) ? "Y" : "N"%>"></input>
<input type="hidden" name="save_hbl2_flag" value="<%=("Y".equals(replaceNull(rqstTabVo.getAlpsHbl2())) || "Y".equals(replaceNull(rqstTabVo.getXterHbl2()))) ? "Y" : "N"%>"></input>

<%-- Cutomer Check Point  
<input type="hidden" name="cuYn"  value="<%=xterCustChkPntVO ==null ?"" : xterCustChkPntVO.getCuYn()%>"></input>
<input type="hidden" name="cnYn"  value="<%=xterCustChkPntVO ==null ?"" : xterCustChkPntVO.getCnYn()%>"></input>
<input type="hidden" name="mdYn"  value="<%=xterCustChkPntVO ==null ?"" : xterCustChkPntVO.getMdYn()%>"></input>
<input type="hidden" name="cmYn"  value="<%=xterCustChkPntVO ==null ?"" : xterCustChkPntVO.getCmYn()%>"></input>
<input type="hidden" name="emYn"  value="<%=xterCustChkPntVO ==null ?"" : xterCustChkPntVO.getEmYn()%>"></input>
<input type="hidden" name="raYn"  value="<%=xterCustChkPntVO ==null ?"" : xterCustChkPntVO.getRaYn()%>"></input>
<input type="hidden" name="coYn"  value="<%=xterCustChkPntVO ==null ?"" : xterCustChkPntVO.getCoYn()%>"></input>
 --%>

<!-- bb cgo 추가 -->
<input type="hidden" name="save_bb_flag"   value="<%=("Y".equals(replaceNull(rqstTabVo.getAlpsBb()))  || "Y".equals(replaceNull(rqstTabVo.getXterBb()))) ? "Y" : "N"%>"></input>

<input type="hidden" name="is_alps_null" value="">
<input type="hidden" name="alps_data_yn_flag"
	value="<%=replaceNull(rqstTabVo.getAlpsCust()) + "|"
					+ replaceNull(rqstTabVo.getAlpsCntr()) + "|"
					+ replaceNull(rqstTabVo.getAlpsMnd())  + "|"
					+ replaceNull(rqstTabVo.getAlpsCm())   + "|"
					+ replaceNull(rqstTabVo.getAlpsTro())  + "|"
					+ replaceNull(rqstTabVo.getAlpsRf())   + "|"
					+ replaceNull(rqstTabVo.getAlpsDg())   + "|"
					+ replaceNull(rqstTabVo.getAlpsAwk())  + "|"
					+ replaceNull(rqstTabVo.getAlpsBb())  + "|"
					+ replaceNull(rqstTabVo.getAlpsHbl1()) + "|"
					+ replaceNull(rqstTabVo.getAlpsHbl2())%>">
<input type="hidden" name="xter_data_yn_flag"
	value="<%=replaceNull(rqstTabVo.getXterCust()) + "|"
					+ replaceNull(rqstTabVo.getXterCntr()) + "|"
					+ replaceNull(rqstTabVo.getXterMnd())  + "|"
					+ replaceNull(rqstTabVo.getXterCm())   + "|"
					+ replaceNull(rqstTabVo.getXterTro())  + "|"
					+ replaceNull(rqstTabVo.getXterRf())   + "|"
					+ replaceNull(rqstTabVo.getXterDg())   + "|"
					+ replaceNull(rqstTabVo.getXterAwk())  + "|"
					+ replaceNull(rqstTabVo.getXterBb())  + "|"
					+ replaceNull(rqstTabVo.getXterHbl1()) + "|"
					+ replaceNull(rqstTabVo.getXterHbl2())%>">

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
<input type="hidden" name="ctrt_ofc_cd">
<input type="hidden" name="hndl_ofc_cd" value="<%=(rqstVo == null) ? "" :replaceNull(rqstVo.getHndlOfcCd())%>">
<!-- Contact Person	(E) -->

<!-- Reference	(S) -->
<input type="hidden" name="xter_inv_ref_no" 	 		value="<%=(rqstVo == null) ? "" :replaceNull(rqstVo.getInvRefNo())%>"> 
<input type="hidden" name="xter_bkg_ref_no" 			value="<%=(rqstVo == null) ? "" :replaceNull(rqstVo.getBkgRefNo())%>">
<input type="hidden" name="xter_bkg_sh_ref_no" 			value="<%=(rqstVo == null) ? "" :replaceNull(rqstVo.getBkgShRefNo())%>"> 
<input type="hidden" name="xter_bkg_ff_ref_no" 			value="<%=(rqstVo == null) ? "" :replaceNull(rqstVo.getBkgFfRefNo())%>"> 
<input type="hidden" name="xter_si_reference_no" 		value="<%=(rqstVo == null) ? "" :replaceNull(rqstVo.getSiRefNo())%>">
<input type="hidden" name="xter_si_sh_ref_no" 			value="<%=(rqstVo == null) ? "" :replaceNull(rqstVo.getSiShRefNo())%>">
<input type="hidden" name="xter_si_ff_ref_no" 			value="<%=(rqstVo == null) ? "" :replaceNull(rqstVo.getSiFfRefNo())%>">
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
<!-- Reference	(E) -->

<!-- BDR, C/A Flag (E) -->

<!-- Individual Person Flag -->
<input type="hidden" name="indiv_pson_flg" value="N">
<input type="hidden" name="veh_cmdt_flg" value="<%=vehCmdtFlg%>">

<!-- 초기값 (S) -->
<input type="hidden" name="dflt_rcv_term_cd" value="Y">
<input type="hidden" name="dflt_de_term_cd"  value="Y">
<input type="hidden" name="dflt_wgt_ut_cd"   value="KGS">
<input type="hidden" name="frt_term_cd"   value=""> <!-- jsy 2011.11.28 -->
<!-- 초기값 (E) -->

<input type="hidden" name="chk_etd_dt">
<input type="hidden" name="si_sys_upld_flg" value="<%=(rqstVo == null) ? "" :replaceNull(rqstVo.getSysUpldFlg())%>">
<input type="hidden" name="si_aud_flg" 	value="<%=(rqstVo == null) ? "" :replaceNull(rqstVo.getSiAudFlg())%>">
<input type="hidden" name="xter_rate_yn">
<input type="hidden" name="cmpb_rt_flg" value="<%=(rqstVo == null) ? "" :replaceNull(rqstVo.getCmpbRtFlg())%>">
<input type="hidden" name="bcc_exist_flg"   value="">
<input type="hidden" name="sXml" value="<%=JSPUtil.replace(sXml, "\"", "&quot;")%>">

<!-- 개발자 작업	-->


<table width="100%" border="0" cellpadding="0" cellspacing="0"	style="padding-top: 0; padding-left: 0;">
	<tr>
		<td valign="top"><!--Page Title, Historical (S)--> <!-- Grid BG Box  (S) -->
		<!-- Contact person -->
		<div id="showBkCntc" style="position: absolute; display: none;" style="margin-top:452px;margin-left:272px;">
		<table border="0" style="width:380; background-color:white;" class="grid2">
			<tr class="tr2_head">
				<td width="80">Contact<br>Information</td>
				<td width="150">BKG Contact</td>
				<td width="150">S/I Contact</td>
			</tr>
			<tr>
				<td class="tr2_head2">Name</td>
				<td class="align_l"><span id="bkg_cntc_pson_nm_span"><%=bkCntcPsonNm%></span></td>
				<td class="align_l"><span id="si_cntc_pson_nm_span"><%=siCntcPsonNm%></span></td>
			</tr>
			<tr>
				<td class="tr2_head2">E-mail</td>
				<td width="165" class="noinput"><input type="text" style="width: 100%; center;" class="input" maxlength="200" style="ime-mode:disabled" value="<%=bkCntcPsonEml%>" name="bkg_cntc_pson_eml_span"></td>
				<td width="165" class="noinput"><input type="text" style="width: 100%; center;" class="input" maxlength="200" style="ime-mode:disabled" value="<%=siCntcPsonEml%>" name="si_cntc_pson_eml_span"></td>
				<%-- <td class="align_l"><span id="bkg_cntc_pson_eml_span"><%=bkCntcPsonEml%></span></td>
				<td class="align_l"><span id="si_cntc_pson_eml_span"><%=siCntcPsonEml%></span></td> --%>
			</tr>
			<tr>
				<td class="tr2_head2">Tel.</td>
				<td class="align_l"><span id="bkg_cntc_pson_phn_no_span"><%=bkCntcPsonPhnNo%></span></td>
				<td class="align_l"><span id="si_cntc_pson_phn_no_span"><%=siCntcPsonPhnNo%></span></td>
			</tr>
			<tr>
				<td class="tr2_head2">Fax</td>
				<td class="align_l"><span id="bkg_cntc_pson_fax_no_span"><%=bkCntcPsonFaxNo%></span></td>
				<td class="align_l"><span id="si_cntc_pson_fax_no_span"><%=siCntcPsonFaxNo%></span></td>
			</tr>
			<tr>
				<td class="tr2_head2">Mobile</td>
				<td class="align_l"><span id="bkg_cntc_pson_mphn_no_span"><%=bkCntcPsonMphnNo%></span></td>
				<td class="align_l"><span id="si_cntc_pson_mphn_no_span"><%=siCntcPsonMphnNo%></span></td>
			</tr>			
		</table>
		</div>
		<div id="showXterDocReq" style="position: absolute; display: none;" style="margin-top:440px;margin-left:498px;height:138px;" style="overflow-y:scroll;">
			<table border="0" style="width: 380; background-color: white; height:10; " class="grid2">
				<tr class="tr2_head">
					<td colspan="2">Doc Requirement</td>
				</tr>
				<tr>
					<td class="tr2_head2" width="130">B/L TYPE</td>
					<td class="align_l"><span id="wy_bl_flg"><%=(rqstVo == null) ? "" :replaceNull(rqstVo.getWyBlFlg())%></span></td>
				</tr>
				<tr>
					<td class="tr2_head2" width="130">No of OB/L(Rated)</td>
					<td class="align_l"><span id="incl_rt_bl_knt"><%=(rqstVo == null) ? "" :replaceNull(rqstVo.getInclRtBlKnt())%></span></td>
				</tr>
				<tr>
					<td class="tr2_head2" width="130">No of OB/L(Non-Rated)</td>
					<td class="align_l"><span id="xcld_rt_bl_knt"><%=(rqstVo == null) ? "" :replaceNull(rqstVo.getXcldRtBlKnt())%></span></td>
				</tr>
				<tr>
					<td class="tr2_head2" width="130">N/N Copy(Rated)</td>
					<td class="align_l"><span id="non_nego_rt_incl_knt2"><%=(rqstVo == null) ? "" :replaceNull(rqstVo.getNonNegoRtInclKnt())%></span></td>
				</tr>
				<tr>
					<td class="tr2_head2" width="130">N/N Copy(Non-Rated)</td>
					<td class="align_l"><span id="non_nego_rt_xcld_knt2"><%=(rqstVo == null) ? "" :replaceNull(rqstVo.getNonNegoRtXcldKnt())%></span></td>
				</tr>
				<tr>
					<td class="tr2_head2" width="130">Issue Place</td>
					<td class="align_l"><span id="bl_iss_loc_cd"><%=(rqstVo == null) ? "" :replaceNull(rqstVo.getBlIssLocCd())%></span></td>
				</tr>
				<tr>
					<td class="tr2_head2" width="130">Issue Date</td>
					<td class="align_l"><span id="bl_iss_dt"><%=(rqstVo == null) ? "" :replaceNull(rqstVo.getBlIssDt())%></span></td>
				</tr>
				<tr>
					<td class="tr2_head2" width="130">Deliver To</td>
					<td class="align_l"><span id=""></span></td>
				</tr>
				<tr>
					<td class="tr2_head2" width="130">Method</td>
					<td class="align_l"><span id=""></span></td>
				</tr>
				<tr>
					<td class="tr2_head2" width="130">Remark</td>
					<td class="align_l"><span id=""></span></td>
				</tr>
			</table>
		</div>
		<div id="showXterRef" style="position: absolute; display: none;" style="margin-top:445px;margin-left:645px;height:133px;" style="overflow-y:scroll;">
			<table border="0" style="width: 250; background-color: white; height:10; " class="grid2">
				<tr>
					<td class="tr2_head2" width="100">Invoice Ref. No.</td>
					<td class="align_l"><span id="xter_inv_ref_no_span"><%=(rqstVo == null) ? "" :replaceNull(rqstVo.getInvRefNo())%></span></td>
				</tr>
				<tr>
					<td class="tr2_head2" width="100">BKG Ref.No.</td>
					<td class="align_l"><span id="xter_bkg_ref_no_span"><%=(rqstVo == null) ? "" :replaceNull(rqstVo.getBkgRefNo())%></span></td>
				</tr>
				<tr>
					<td class="tr2_head2" width="100">BKG SH Ref. No.</td>
					<td class="align_l"><span id="xter_bkg_sh_ref_no_span"><%=(rqstVo == null) ? "" :replaceNull(rqstVo.getBkgShRefNo())%></span></td>
				</tr>
				<tr>
					<td class="tr2_head2" width="100">BKG FF Ref. No.</td>
					<td class="align_l"><span id="xter_bkg_ff_ref_no_span"><%=(rqstVo == null) ? "" :replaceNull(rqstVo.getBkgFfRefNo())%></span></td>
				</tr>
				<tr>
					<td class="tr2_head2" width="100">S/I Ref. No.</td>
					<td class="align_l"><span id="xter_si_ref_no_span"><%=(rqstVo == null) ? "" :replaceNull(rqstVo.getSiRefNo())%></span></td>
				</tr>
				<tr>
					<td class="tr2_head2" width="100">S/I SH Ref. No.</td>
					<td class="align_l"><span id="xter_si_sh_ref_no_span"><%=(rqstVo == null) ? "" :replaceNull(rqstVo.getSiShRefNo())%></span></td>
				</tr>
				<tr>
					<td class="tr2_head2" width="100">S/I FF Ref. No.</td>
					<td class="align_l"><span id="xter_si_ff_ref_no_span"><%=(rqstVo == null) ? "" :replaceNull(rqstVo.getSiFfRefNo())%></span></td>
				</tr>
				<tr>
					<td class="tr2_head2" width="100">Regional BKG No.</td>
					<td class="align_l"><span id="xter_reg_bkg_no_span"></span></td>
				</tr>
				<tr>
					<td class="tr2_head2" width="100">Export MRN No.</td>
					<td class="align_l"><span id="xter_ext_mrn_no_span"><%=(rqstVo == null) ? "" :replaceNull(rqstVo.getExtMrnNo())%></span></td>
				</tr>
			</table>
		</div>
		<div id="showBkgDocReq" style="position: absolute; display: none;" style="margin-top:440px;margin-left:15px;height:138px;" style="overflow-y:scroll;">
			<table border="0" style="width: 380; background-color: white;" class="grid2">
				<tr class="tr2_head">
					<td colspan="2">Doc Requirement</td>
				</tr>
				<tr>
					<td class="tr2_head2" width="130">B/L TYPE</td>
					<td width="" class="stm">
						<label for="rqst_bl_tp_cd">
							<input type="radio" value="W" <%=(docRqstVO == null) ? "" :"W".equals(replaceNull(docRqstVO.getRqstBlTpCd())) ? "checked" : ""%> name="rqst_bl_tp_cd" id="rqst_bl_tp_cd" class="trans">Sea Waybill&nbsp;</label> 
						<label for="rqst_bl_tp_cd">
							<input type="radio" value="O" <%=(docRqstVO == null) ? "" :"O".equals(replaceNull(docRqstVO.getRqstBlTpCd())) ? "checked" : ""%> name="rqst_bl_tp_cd" id='rqst_bl_tp_cd' class="trans">O.B/L</label>
						<label for="rqst_bl_tp_cd">
							<input type="radio" value="S" <%=(docRqstVO == null) ? "" :"S".equals(replaceNull(docRqstVO.getRqstBlTpCd())) ? "checked" : ""%> name="rqst_bl_tp_cd" id='rqst_bl_tp_cd' class="trans">Surrender</label>
					</td>
				</tr>
				<tr>
					<td class="tr2_head2" width="130">No of OB/L(Rated)</td>
					<td width="165" class="noinput"><input type="text" style="width: 100%; center;" class="input" maxlength="8" dataformat="int" style="ime-mode:disabled" value="<%=(docRqstVO == null) ? "" :replaceNull(docRqstVO.getOblRtInclKnt()) %>" name="obl_rt_incl_knt"></td>
				</tr>
				<tr>
					<td class="tr2_head2" width="130">No of OB/L(Non-Rated)</td>
					<td width="165" class="noinput"><input type="text" style="width: 100%;" class="input" maxlength="8" dataformat="int" style="ime-mode:disabled" value="<%=(docRqstVO == null) ? "" :replaceNull(docRqstVO.getOblRtXcldKnt()) %>" name="obl_rt_xcld_knt"></td>
				</tr>
				<tr>
					<td class="tr2_head2" width="130">N/N Copy(Rated)</td>
					<td width="165" class="noinput"><input type="text" style="width: 100%;" class="input" maxlength="8" dataformat="int" style="ime-mode:disabled" value="<%=(docRqstVO == null) ? "" :replaceNull(docRqstVO.getNonNegoRtInclKnt()) %>" name="non_nego_rt_incl_knt"></td>
				</tr>
				<tr>
					<td class="tr2_head2" width="130">N/N Copy(Non-Rated)</td>
					<td width="165" class="noinput"><input type="text" style="width: 100%;" class="input" maxlength="8" dataformat="int" style="ime-mode:disabled" value="<%=(docRqstVO == null) ? "" :replaceNull(docRqstVO.getNonNegoRtXcldKnt()) %>" name="non_nego_rt_xcld_knt"></td>
				</tr>
				<tr>
					<td class="tr2_head2" width="130">Issue Place</td>
					<td width="165"><input type="text" align="center" style="width: 165;" class="input" dataformat="etc" style="ime-mode:disabled" name="rqst_iss_plc_nm" value="<%=(docRqstVO == null) ? "" :replaceNull(docRqstVO.getRqstIssPlcNm())%>">
				</tr>
				<tr>
					<td class="tr2_head2" width="130">Issue Date</td>
					<td width="165" ><input align="center" type="text" style="width: 165;" class="input" maxlength="10" dataformat="ymd" style="ime-mode:disabled" value="<%=(docRqstVO == null) ? "" :replaceNull(docRqstVO.getRqstIssDt())%>" name="rqst_iss_dt" ></td>
				</tr>
				<tr>
					<td class="tr2_head2" width="130">Deliver To</td>
					<td class="stm">
						<label for="bl_de_to_cd1">
							<input type="radio" value="S" <%=(docRqstVO == null) ? "" :"S".equals(replaceNull(docRqstVO.getBlDeToCd())) ? "checked" : ""%> name="bl_de_to_cd" id="bl_de_to_cd1" class="trans">Shipper&nbsp;</label> 
						<label for="bl_de_to_cd2">
							<input type="radio" value="F" <%=(docRqstVO == null) ? "" :"F".equals(replaceNull(docRqstVO.getBlDeToCd())) ? "checked" : ""%> name="bl_de_to_cd" id="bl_de_to_cd2" class="trans">FWDR</label></td>
				</tr>
				<tr>
					<td class="tr2_head2" width="130">Method</td>
					<td class="stm">
						<label for="bl_de_mzd_cd1">
							<input type="radio" value="E" <%=(docRqstVO == null) ? "" :"E".equals(replaceNull(docRqstVO.getBlDeMzdCd())) ? "checked" : ""%> name="bl_de_mzd_cd" id="bl_de_mzd_cd1" class="trans">Express Mail&nbsp;</label>
						<label for="bl_de_mzd_cd2">
							<input type="radio" value="R" <%=(docRqstVO == null) ? "" :"R".equals(replaceNull(docRqstVO.getBlDeMzdCd())) ? "checked" : ""%> name="bl_de_mzd_cd" id="bl_de_mzd_cd2" class="trans">Regular Mail&nbsp;</label>
						<label for="bl_de_mzd_cd3">
							<input type="radio" value="P" <%=(docRqstVO == null) ? "" :"P".equals(replaceNull(docRqstVO.getBlDeMzdCd())) ? "checked" : ""%> name="bl_de_mzd_cd" id="bl_de_mzd_cd3" class="trans">Pick Up</label></td>
				</tr>
				<tr>
					<td class="tr2_head2" width="130">Remark</td>
					<td width="165">
						<textarea rows="2" style="width: 90%;" name="bl_doc_rqst_rmk"><%=(docRqstVO == null) ? "" :replaceNull(docRqstVO.getBlDocRqstRmk())%>
					</textarea></td>
				</tr>
			</table>
		</div>
		<div id="showBkgRef" style="position: absolute; display: none;" style="margin-top:445px;margin-left:175px;height:134px;" style="overflow-y:scroll;">
			<table border="0" style="width: 300; background-color: white; height:10; " class="grid2">
				<tr>
					<td class="tr2_head2" width="100">Invoice Ref. No.</td>
					<td width="150" class="noinput"><input type="text" id="inv_ref_no" style="width: 100%; center;" class="input" maxlength="50" dataformat="engupnum" style="ime-mode:disabled" value="<%=invRefNo%>" name="cust_ref_no_ctnt"><input type="hidden" value="FINV" name="bkg_ref_tp_cd"><input type="hidden" value="" name="ibflag"></td>
				</tr>
				<tr>
					<td class="tr2_head2" width="100">BKG Ref.No.</td>
					<td width="150" class="noinput"><input type="text" style="width: 100%; center;" class="input" maxlength="50" dataformat="engupnum" style="ime-mode:disabled" value="<%=bkgRefNo%>" id="bkg_ref_no" name="cust_ref_no_ctnt"><input type="hidden" value="EBRF" name="bkg_ref_tp_cd"><input type="hidden" value="" name="ibflag"></td>
				</tr>
				<tr>
					<td class="tr2_head2" width="100">BKG SH Ref. No.</td>
					<td width="150" class="noinput"><input type="text" style="width: 100%; center;" class="input" maxlength="50" dataformat="engupnum" style="ime-mode:disabled" value="<%=bkgSHRefNo%>" id="bkg_sh_ref_no" name="cust_ref_no_ctnt"><input type="hidden" value="EBSH" name="bkg_ref_tp_cd"><input type="hidden" value="" name="ibflag"></td>
				</tr>
				<tr>
					<td class="tr2_head2" width="100">BKG FF Ref. No.</td>
					<td width="150" class="noinput"><input type="text" style="width: 100%; center;" class="input" maxlength="50" dataformat="engupnum" style="ime-mode:disabled" value="<%=bkgFFRefNo%>" id="bkg_ff_ref_no" name="cust_ref_no_ctnt"><input type="hidden" value="EBFF" name="bkg_ref_tp_cd"><input type="hidden" value="" name="ibflag"></td>
				</tr>
				<tr>
					<td class="tr2_head2" width="100">S/I Ref. No.</td>
					<td width="150" class="noinput"><input type="text" style="width: 100%; center;" class="input" maxlength="50" dataformat="engupnum" style="ime-mode:disabled" value="<%=siRefNo%>" id="si_ref_no" name="cust_ref_no_ctnt"><input type="hidden" value="ESRF" name="bkg_ref_tp_cd"><input type="hidden" value="" name="ibflag"></td>
				</tr>
				<tr>
					<td class="tr2_head2" width="100">S/I SH Ref. No.</td>
					<td width="150" class="noinput"><input type="text" style="width: 100%; center;" class="input" maxlength="50" dataformat="engupnum" style="ime-mode:disabled" value="<%=siSHRefNo%>" id="si_sh_ref_no" name="cust_ref_no_ctnt"><input type="hidden" value="ESSH" name="bkg_ref_tp_cd"><input type="hidden" value="" name="ibflag"></td>
				</tr>
				<tr>
					<td class="tr2_head2" width="100">S/I FF Ref. No.</td>
					<td width="150" class="noinput"><input type="text" style="width: 100%; center;" class="input" maxlength="50" dataformat="engupnum" style="ime-mode:disabled" value="<%=siFFRefNo%>" id="si_ff_ref_no" name="cust_ref_no_ctnt"><input type="hidden" value="ESFF" name="bkg_ref_tp_cd"><input type="hidden" value="" name="ibflag"></td>
				</tr>
				<tr>
					<td class="tr2_head2" width="100">Regional BKG No.</td>
					<td width="150" class="noinput"><input type="text" style="width: 100%; center;" class="input" maxlength="50" dataformat="engupnum" style="ime-mode:disabled" value="<%=regBkgNo%>" id="reg_bkg_no" name="cust_ref_no_ctnt"><input type="hidden" value="RGBK" name="bkg_ref_tp_cd"><input type="hidden" value="" name="ibflag"></td>
				</tr>
				<tr>
					<td class="tr2_head2" width="100">Export MRN No.</td>
					<td width="150" class="noinput"><input type="text" style="width: 100%; center;" class="input" maxlength="50" dataformat="engupnum" style="ime-mode:disabled" value="<%=extMrnNo%>" id="ext_mrn_no" name="cust_ref_no_ctnt"><input type="hidden" value="XMRN" name="bkg_ref_tp_cd"><input type="hidden" value="" name="ibflag"></td>
				</tr>
			</table>
		</div>
		<div id="showSalesApproval" style="position: absolute; display: none;" style="margin-top:475px;margin-left:140px;height:100px;">
			<table border="0" style="width: 345; background-color: white; height:10; " class="grid2">
			    <tr>
					<td class="tr2_head2" width="100">Sales Approval</td>
			    	<td width="" class="input"><input type="checkbox" name="new_cust_apro_flg" value="Y"  class="trans"></td>
				<tr>
					<td class="tr2_head2" width="100">Commodity Detail</td>
					<td width="" class="input"><input type="text" style="width: 232; center;" class="input" maxlength="200" style="ime-mode:disabled" value="" name="new_cust_apro_cmdt_nm"></td>
				</tr>
				<tr>
					<td class="tr2_head2" width="100">Remark(s)</td>
					<td width="">
						<textarea rows="3" style="width: 232;" name="new_cust_apro_rmk"></textarea></td>
				</tr>
			</table>
		</div>
		<table class="search" id="mainTable" style="width: 958;">
			<tr>
				<td class="bg">
				<table class="search" border="0" style="width: 958;">
					<tr class="h23">
						<td width="470" valign="top">
						<!--  BKG Data (S) -->
						<table class="search" border="0">
							<tr>
								<td class="title_h"></td>
								<td class="title_s">Booking Data ALPS</td>
							</tr>
							<tr>
								<td class="height_5"></td>
							</tr>
						</table>
						<table class="search_ssm" border="0" style="width: 480;">
							<tr class="h23">
								<td>
								<table class="search" border="0">
									<tr class="h23">
										<td width="65">BKG No.</td>
										<td width="110" class="sm">
											<input type="text" name="bkg_no" style="width: 105;" maxlength="13" dataformat="engupnum" class="input" style="background:'#E8E7EC'" value="<%=bkgNo%>">&nbsp;
										</td>
										<td width="140">
											<img src="img/btns_search.gif" name="btn_find_bkg" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">&nbsp;
											(Manual No.<input type="checkbox" name="mnl_bkg_no_flg" value="" class="trans" onClick="javascript:changeBkgNoManual(this)">)
										</td>
										<td width="92">Upload Status</td>
										<td width="">
											<input type="text" name="bkg_sts_nm" style="width: 60;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo.getBkgUpldStsNm())%>" readOnly tabindex="-1">
											<input type="hidden" name="bkg_upld_sts_cd" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo.getBkgUpldStsCd())%>">
										</td>
										<!-- 0079 화면의 표기 우겨 넣을 데 찾아야함 -->
					<!--<td width="40" style="color:blue;"><div style="display:none"  id="split_flg">Split</div></td>-->
									</tr>
									<tr class="h23">
										<td>B/L No.</td>
										<td class="sm">
										<input type="text" name="bl_no" style="width:105" maxlength="12" class="input2" value="<%=blNo%>" readOnly></td>										
										<td><table width="100" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td>
											<td class="btn2" name="btn_gotobkg" id="btn_gotobkg">Go to BKG</td>
											<td class="btn2_right"></td>
											</tr>
										</table></td>
										<td colspan="2">Auto EDI Hold
										<input type="checkbox" name="edi_hld_flg" value="<%=ediHldFlg%>" class="trans"></td>
									</tr>
								</table>
								<table class="search" border="0">
									<tr class="h23">
										<td width="65">Shipper</td>
										<td width="255">
											<input type="text" name="s_cust_cnt_cd" style="width: 25;" maxlength="2" class="input1" dataformat="engup" value="<%=shCnt%>">
											<input type="text" name="s_cust_seq" maxlength=6 style="width: 55;" class="input1" dataformat="engupnum" value="<%=shSeq%>">
											<input type="text" name="s_cust_nm" style="width: 133;" class="input2" value="<%=shNm%>" readOnly tabindex="-1">
											<img src="img/btns_search.gif" name="btn_0652ShprPop" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
										</td>
										<td width="89" align="right">L/Rep.&nbsp;</td>
										<td><input type="hidden" name="ob_sls_ofc_cd" value="<%=obSlsOfcCd%>"></input> 
											<input type="text" name="ob_srep_cd" style="width: 60;" class="input1" maxlength="5" dataformat="engupnum" value="<%=obSrepCd%>" ></input>
										</td>
									</tr>
									<tr class="h23">
										<td>Forwarder</td>
										<td>
											<input type="text" name="f_cust_cnt_cd" style="width: 25;" maxlength="2" class="input" dataformat="engup" value="<%=ffCnt%>">
											<input type="text" name="f_cust_seq" maxlength=6 style="width: 55;" class="input" dataformat="engupnum" value="<%=("0".equals(ffSeq)) ? "" : ffSeq%>">
											<input type="text" name="f_cust_nm" style="width: 133;" class="input2" value="<%=ffNm%>" readOnly tabindex="-1">
											<img src="img/btns_search.gif" name="btn_0652FwdrPop" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
										</td>										
										<td align="right">Status&nbsp;</td>
										<td><input type="text" name="bkg_sts_cd"  style="width: 20;text-align:center;" class="input2" value="<%=bkgStsCd%>" readOnly><input type="text" name="non_rt_sts_cd" style="width:20;" class="input2" value="<%=nonRtStsCd%>" readonly><input type="text" name="aloc_sts_cd"  style="width: 20;text-align:center;" class="input2" value="<%=alocStsCd%>" readOnly></td>
										
									</tr>
								</table>
								<table class="search" border="0">
									<tr class="h23">
										<td width="30">VVD</td>
										<td width="265">
											<input type="text" name="bkg_trunk_vvd" maxlength=9 style="width: 84;" class="input1" dataformat="engupnum" value="<%=vvd%>">
											<input type="text" name="vsl_eng_nm" style="width: 133;" class="input2" value="<%=vslEngNm%>" readOnly tabindex="-1"><img src="img/btns_search.gif" name="btn_0019Pop" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
										<td><table width="110" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td>
											<td class="btn2" name="btn_t1RouteDetail" id="btn_t1RouteDetail">Route Detail</td>
											<td class="btn2_right"></td>
											</tr>
										</table></td>			
										<td><table width="85" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td>
											<td class="btn2" name="btn_allocation" id="btn_allocation">Allocation</td>
											<td class="btn2_right"></td>
											</tr>
										</table></td>		
									</tr>
									<tr class="h23">
										<td>POR</td>
										<td>
											<input type="text" name="bkg_por_cd" style="width: 55;" class="input1" dataformat="engupnum" maxlength="5" value="<%=porCd%>">
											<input type="text" name="bkg_por_yd_cd" style="width: 25;" class="input" dataformat="engupnum" maxlength="2" value="<%=porYdCd%>">
											<input type="text" name="por_nm" style="width: 133;" class="input" dataformat="etc" maxlength="25" value="<%=porNm%>" tabindex="-1"><img src="img/btns_search.gif" name="btn_0083PorPop" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
										<td colspan="2" class="stm">
										<table>
											<tr>
												<td id="unchk" style="display: ">
												<table width="110" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn_copyloc">Copy Loc.</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
												</td>
												<td id="chk" style="display: none">
												<table width="110" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn_canceloc">Cancel Copy</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
												</td>
												<td>(<input type="checkbox" name="incl_code" value="" class="trans">Incl.Code)</td>
											</tr>
										</table>
										</td>
									</tr>
									<tr class="h23">
										<td>POL</td>
										<td>
											<input type="text" name="bkg_pol_cd" style="width: 55;" class="input1" dataformat="engupnum" maxlength="5" value="<%=polCd%>">
											<input type="text" name="bkg_pol_yd_cd" style="width: 25;" class="input" dataformat="engupnum" maxlength="2" value="<%=polYdCd%>">
											<input type="text" name="pol_nm" style="width: 133;" class="input" dataformat="etc" maxlength="25" value="<%=polNm%>" tabindex="-1"><img src="img/btns_search.gif" name="btn_0083PolPop" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
										<td align="right">Pre Port(s)&nbsp;&nbsp;</td>
										<td align="right">
											<input type="text" name="pre_rly_port_cd" style="width: 60;" class="input2" value="<%=preRlyPortCd%>" readOnly>
											<input type="text" name="pre_rly_port_yd_cd" style="width: 25;" class="input2" value="" readonly>
										</td>
									</tr>
									<tr class="h23">
										<td>POD</td>
										<td>
											<input type="text" name="bkg_pod_cd" style="width: 55;" class="input" dataformat="engupnum" maxlength="5" value="<%=podCd%>">
											<input type="text" name="bkg_pod_yd_cd" style="width: 25;" class="input" dataformat="engupnum" maxlength="2" value="<%=podYdCd%>">
											<input type="text" name="pod_nm" style="width: 133;" class="input" dataformat="etc" maxlength="25" value="<%=podNm%>" tabindex="-1"><img src="img/btns_search.gif" name="btn_0083PodPop" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
										<td align="right">Post Port(s)&nbsp;&nbsp;</td>
										<td align="right">
											<input type="text" name="pst_rly_port_cd" style="width: 60;" class="input2" value="<%=pstRlyPortCd%>" readOnly>
											<input type="text" name="pst_rly_port_yd_cd" style="width: 25;" class="input2" value="" readonly>
										</td>
									</tr>
									<tr class="h23">
										<td>DEL</td>
										<td>
											<input type="text" name="bkg_del_cd" style="width: 55;" class="input1" dataformat="engupnum" maxlength="5" value="<%=delCd%>">
											<input type="text" name="bkg_del_yd_cd" style="width: 25;" style="ime-mode:disabled" class="input" dataformat="engupnum"maxlength="2" value="<%=delYdCd%>">
											<input type="text" name="del_nm" style="width: 133;" class="input" dataformat="etc" maxlength="25" value="<%=delNm%>" tabindex="-1"><img src="img/btns_search.gif" name="btn_0083DelPop" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
										<td align="right">Final Dest&nbsp;&nbsp;</td>
										<td align="right">
										<input type="text" name="fnl_dest_nm" style="width: 89;" dataformat="etc" class="input" value="<%=fnlDestNm%>">
										</td>
									</tr>
								</table>
								<table class="search" border="0">
									<tr class="h23">
										<td width="295">Service Term(R/D)&nbsp;
										<script language="javascript">ComComboObject('rcv_term_cd', 2, 75, 1, 0, 1)</script>&nbsp;
										<script language="javascript">ComComboObject('de_term_cd', 2, 75, 1, 0, 1)</script>
										</td>
										<!--td align="right">Freight Term&nbsp;&nbsp;<script language="javascript">ComComboObject('frt_term_cd', 2, 89, 1, 0, 1)</script-->
										<td align="right">Freight Term&nbsp;&nbsp;<input type="text" name="tmp_frt_term_cd" style="width: 89;" class="input2" dataformat="engupnum" maxlength="5" value="" readOnly>
										</td>
									</tr>
								</table>
								
								<table class="search" border="0">
									<tr class="h23">
										<!-- td width="40"></td-->
										<td width="37" align="right"><a href="javascript:comBkgCallPopEsmPri0087();">S / C</a></td>
										<td width="115" align="right">
											<input type="text" style="width:90;" class="input" name="sc_no" dataformat="engupnum" maxlength=9 value="<%=scNo%>">
											<img src="img/btns_search.gif" name="btn_ScNo" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" dataformat="engupnum">
										</td>
										<td width="59" align="right">C/Rep.&nbsp;</td>
										<td><input type="text" name="ctrt_srep_cd" style="width: 54;" class="input2" value="" readOnly>
										<img src="img/btns_search.gif" name="btn_CRep" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" dataformat="engupnum">
										</td>
										<td align="right">S/O No.&nbsp;
											<input type="text" style="width:89;" class="input" name="twn_so_no" maxlength="6"  dataformat="engupnum" value="<%=twnSoNo%>">
										</td>
									</tr>  
								</table>						

								<table class="search" border="0">
									<tr class="h23">
										<td width="114" align="absmiddle">
											<input type="radio" name="ctrt_type" value="TAA" <%=("TAA".equals(ctrtType)) ? "checked" : ""%> class="trans"><a href="javascript:comBkgCallPopEsmPri3019();">TAA</a>
											<input type="radio" name="ctrt_type" value="RFA" <%=("RFA".equals(ctrtType)) ? "checked" : ""%> class="trans"><a href="javascript:comBkgCallPopEsmPri2020();">RFA</a>
										</td>
										<td width="125" align="right">
											<input type="text" name="rfa_no" style="width:100;" class="input" dataformat="engupnum" maxlength=11 value="<%=rfaNo%>"><input type="text" name="taa_no" style="width:100;" class="input" dataformat="engupnum" maxlength=10 value="<%=ctrtTaa%>" style="display:none">
											<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="btn_RfaNo"><img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="btn_TaaNo" style="display:none">
										</td>
										<td align="right">CMDT
											<input type="text" name="cmdt_cd" style="width:50;" class="input1"  maxlength=6 value="<%=cmdtCd%>">
											<input type="text" style="width:82;"  name="cmdt_desc" class="input2" value="<%=cmdtNm%>" readOnly>
											<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle"  name="btn_0656CmdtPop" class="cursor">
											<input type="hidden" name="rep_cmdt_cd" style="width: 34;" class="input" maxlength=4 value="<%=repCmdtCd%>">
											<input type="hidden" name="rep_cmdt_nm" style="width: 68;" class="input2" value="<%=repCmdtNm%>" readOnly>
										</td>
									</tr>
								</table>
								
								<table class="search" border="0">
									<tr class="h23">
										<td>AMS Filer</td>
										<td colspan="" class="stm">
											US&nbsp;<script language="javascript">ComComboObject('usa_cstms_file_cd', 2, 35, 1, 0, 2)</script>&nbsp;
											CA&nbsp;<script language="javascript">ComComboObject('cnd_cstms_file_cd', 2, 35, 1, 0, 2)</script>
										</td>										
										<td align="right">SCAC
											<input type="text" name="scac_cd" style="width: 40; text-align: center" maxlength="4" dataformat="engupnum" class="input" value="<%=scacCd%>">&nbsp;
										</td>
										<td align="right">E.WGT
											<input type="text" name="act_wgt" style="width: 96; text-align: right" maxlength="14" class="input1" value="<%=actWgt%>">
											&nbsp;<script language="javascript">ComComboObject('wgt_ut_cd', 1, 55, 1, 0, 1)</script>
										</td>
									</tr>
								</table>
								<table class="search" border="0">
									<tr class="h23">
										<td width="40">Special</td>
										<td class="stm">
											<input type="checkbox" name="dcgo_flg" value="<%=dcgoFlg%>" <%=("Y".equals(dcgoFlg)) ? "checked" : ""%> class="trans">D/G
											<input type="checkbox" name="rc_flg" value="<%=rcFlg%>" <%=("Y".equals(rcFlg)) ? "checked" : ""%> class="trans">R/F
											<input type="checkbox" name="awk_cgo_flg" value="<%=awkCgoFlg%>"<%=("Y".equals(awkCgoFlg)) ? "checked" : ""%> class="trans">A/K
											<input type="checkbox" name="bb_cgo_flg" value="<%=bbCgoFlg%>" <%=("Y".equals(bbCgoFlg)) ? "checked" : ""%> class="trans">B/B
											<input type="hidden" name="soc_flg" value="<%=socFlg%>" <%//=("Y".equals(socFlg)) ? "checked" : ""%> class="trans">
											<input type="checkbox" name="spcl_hide_flg"  value="" class="trans">HD
											<input type="checkbox" name="prct_flg" value="" class="trans">PC
											<input type="checkbox" name="fd_grd_flg"  value=""  class="trans">FG
											<input type="checkbox" name="flex_hgt_flg" value="<%=flexHgtFlg%>" <%=("Y".equals(flexHgtFlg)) ? "checked" : ""%>  class="trans">F/H
											<!-- <input type="hidden" name="hot_de_flg" class="trans"> -->
											Rail Bulk&nbsp;<script language="javascript" >ComComboObject('rail_blk_cd', 2, 35, 0, 0, 0)</script>
											<input type="hidden" name="stwg_cd_tmp" >
											<input type="hidden" name="stwg_tmp" >
											<input type="hidden" name="prct_tmp" >
											<input type="hidden" name="hide_tmp" >											
										</td>
									</tr>
								</table>
								<table id="eq_qty_tbl" class="search" border="0">
									<tr class="h23">
										<td width="50" align="center" rowspan="1" valign="top">EQ Q'ty<br>
										<table width="50" class="button">
											<tr>
												<td class="btn2_bg">
												<table border="0" cellpadding="0" cellspacing="0">
													<tr>
														<td>
														<table width="100%" border="0" cellpadding="0"
															cellspacing="0" class="button">
															<tr>
																<td class="btn2_left"></td>
																<td class="btn2" name="btn_add">ADD</td>
																<td class="btn2_right"></td>
															</tr>
														</table>
														</td>
													</tr>
												</table>
												</td>
											</tr>
										</table>
										<table width="50" class="button">
											<tr>
												<td class="btn2_bg">
												<table border="0" cellpadding="0" cellspacing="0" width="100%">
													<tr>
														<td>
														<table width="100%" border="0" cellpadding="0"
															cellspacing="0" class="button">
															<tr>
																<td class="btn2_left"></td>
																<td class="btn2" name="btn_del">DEL</td>
																<td class="btn2_right"></td>
															</tr>
														</table>
														</td>
													</tr>
												</table>
												</td>
											</tr>
										</table>
										<table width="50" class="button">
											<tr>
												<td class="btn2_bg">
												<table border="0" cellpadding="0" cellspacing="0" width="100%">
													<tr>
														<td>
														<table width="100%" border="0" cellpadding="0"cellspacing="0" class="button">
															<tr>
																<td class="btn2_left"></td>
																<td class="btn2" name="btn_EqDetail" id="btn_EqDetail">Vol</td>
																<td class="btn2_right"></td>
															</tr>
														</table>
														</td>
													</tr>
												</table>
												</td>
											</tr>
										</table>

										</td>
										<td width="260" rowspan="1"><!-- : ( Grid ) (S) -->
										<table width="98%" id="mainTable">
											<tr>
												<td width="98%"><script language="javascript">ComSheetObject('sheet1');</script>
												</td>
											</tr>
										</table>

										<!-- : ( Grid ) (E) --></td>
										
										<td>
										<table>
											<tr class="h23">
											<td width="70">Door DT</td>
												<td width="">
													<input type="text" name="mty_dor_arr_dt" style="width: 70;" class="input" value="<%=doorDate%>" maxlength=10 dataformat="ymd"><img src="img/btns_calendar.gif" name="btns_DoorDate" width="19" height="20" alt="" border="0" align="absmiddle"class="cursor">
												</td>
											</tr>
											<tr class="h23">
												<td width="">Sailing DT</td>
												<td width="">
													<input type="text" name="lodg_due_dt" style="width: 70;" class="input" value="<%=loadingDate%>" maxlength=10 dataformat="ymd"><img src="img/btns_calendar.gif" name="btns_LoadingDate" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
												</td>
											</tr>
											<tr class="h23">
												<td width="">Delivery DT</td>
												<td width="">
													<input type="text" name="de_due_dt" style="width: 70;" class="input" value="<%=deliveryDate%>" maxlength=10 dataformat="ymd"><img src="img/btns_calendar.gif" name="btns_DeliveryDate" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
												</td>
											</tr>
											<tr class="h23">
												<td>Full RTN CY</td>
												<td width="">
													<input type="text" name="full_rtn_yd_cd" maxlength=7 style="width: 70;" class="input" dataformat="engupnum" value="<%=fullRtnYdCd%>"><img src="img/btns_search.gif" name="btn_0088FullRtnYdCd" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
												</td>
											<tr>
										</table>
										</td>
								</table>
								<table class="search" border="0">
									<tr class="h23">
										<td width="150">P/Up CY&nbsp;
											<input type="text" name="mty_pkup_yd_cd" maxlength=7 style="width: 60;" class="input" dataformat="engupnum" value="<%=mtyPkupYdCd%>">
											<img src="img/btns_search.gif" name="btn_0082MtyPkupYdCd" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
										</td>
										<td width="160">P/Up DT&nbsp;
											<input type="text" name="mty_pkup_dt" style="width: 70;" class="input" value="<%=pkupDate%>" maxlength=10 dataformat="ymd">
											<img src="img/btns_calendar.gif" name="btns_PkupDate" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
										</td>
										<td width="" >
											<table width="" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr>
													<td class="btn2_left"></td>
													<td class="btn2" style="border:0; padding:0;" name="btn_t1SalesApproval" id="btn_t1SalesApproval">Sales&nbsp;Appl</td>
													<td class="btn2_right"></td>
													<td>&nbsp;India&nbsp;<script language="javascript" >ComComboObject('ida_hlg_tp_cd', 2, 35, 0, 0, 0)</script></td>
												</tr>
											</table>
										</td>
									</tr>
								</table>
								
								<table><tr><td class="height_2"></td></tr></table>
								<table class="grid2" border="0" width="100%">
									<tr class="h23">
										<td class="tr2_head" width="50%">External Remark(s)</td>
										<td class="tr2_head" width="50%">Internal Remark(s)</td>
										
									</tr>
									<tr class="h23">
										<td><div id="extDiv" style="display: block"><textarea style="width:100%; height:50;" name="xter_rmk" cols="31" rows="4"><%=xterRmk%></textarea></div></td>
										<td><div id="intDiv" style="display: block"><textarea style="width:100%; height:50;"name="inter_rmk" cols="31" rows="4"><%=interRmk%></textarea>
										</div></td>
									</tr>
								</table>
								<table class="search" border="0">
									<tr class="h23">
										<td width="150">Auto Notification<input type="checkbox" name="auto_notification" value="" class="trans" onClick="javascript:autoNotification();"></td>
										<td width="110">
										<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr>
												<td class="btn2_left"></td>
												<td class="btn2" name="btn_contact">Contact Info.</td>
												<td class="btn2_right"></td>
											</tr>
										</table>
										</td>
										<td class="stm">(<input type="checkbox" name="copy_esvc" value="" class="trans" onClick="javascript:doCopyEsvc();">Copy from e-Service)</td>
										<td><span id="cct_txt">CCT</span>&nbsp;<img src="img/btns_search.gif" name="btn_CctPop" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
									</tr>
								</table>
								<table width="" class="search" border="0">
									<tr class="h23">
										<td ><table width="450" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr>
											<td class="btn2_left" ></td>
											<td class="btn2" style="border:0; padding:0;" name="btn_docRequirement" id="btn_docRequirement">Doc Requirement</td>
											<td class="btn2_right" ></td>
											<td class="stm">(<input type="checkbox" name="copy_esvc_doc" value="" class="trans" onClick="javascript:docReqCopyEsvc();">Copy from e-Service)</td>
											<td class="btn2_left" ></td>
											<td class="btn2" style="border:0; padding:0;" name="btn_ref_bkg" id="btn_ref_bkg">Reference NO.</td>
											<td class="btn2_right" ></td>
											</tr>											
										</table></td>
									</tr>
								</table>
								<table><tr><td class="height_5"></td></tr></table>
								</td>
							</tr>
						</table>
						<!--  BKG Data (E) --></td>						
						<td width="12">&nbsp;</td>
						<td width="479" valign="top">
						<!--  eBKG Data (S) -->
						<table class="search" border="0">
							<tr>
								<td class="title_h"></td>
								<td class="title_s">From e- Service</td>
							</tr>
							<tr>
								<td class="height_5"></td>
							</tr>
						</table>
						<table class="search_ssm1" border="0" style="width: 479;" height="100%">
							<tr class="h23">
								<td valign="top">
								<table class="search" border="0">
									<tr class="h23">
										<td width="50">BKG No.</td>
										<td width="110">
											<input type="text" name="bkg_no2" style="width: 105;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo.getBkgNo())%>"readOnly>
										</td>
										<td width="60" align="right">Req. No.</td>
										<td width="155"> 
											<input type="text" name="rqst_no2" style="width: 120;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo.getXterRqstNo())%>"readOnly>
											<input type="text" name="snaccs_split_no2" style="width: 20;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo.getSnaccsSplitNo())%>"readOnly>
										</td>
										<td align="right">&nbsp;Via&nbsp;&nbsp;
											<input type="text" name="xter_rqst_via_nm" style="width: 54;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo.getXterRqstViaNm())%>"	readOnly>
											<input type="hidden"name="xter_rqst_via_cd" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo.getXterRqstViaCd())%>">
										</td>
									</tr>
								</table>
								<table class="search" border="0">
									<tr class="h23">
										<td width="50">B/L No.</td>
										<td width="110">
											<input type="text" name="bl_no_ctnt2" style="width: 105;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo .getBlNoCtnt())%>" readOnly>
										</td>
										<td width="70" align="right">ALPS&nbsp;
											<input type="text" name="alps2" style="width: 30;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo.getAlps())%>" readOnly>
										</td>
										<td width="112" align="right">No. of H/BL&nbsp;
											<input type="text" name="hbl_knt2" style="width: 26;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo .getHblKnt())%>" readOnly>
										</td>
										<td align="right">Web ID&nbsp;
										<input type="text" name="cust_id2" style="width: 65" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo.getCustId())%>" readOnly>
										</td>
									</tr>
								</table>
								<table class="search" border="0">
									<tr class="h23">
										<td width="55">Shipper</td>
										<td colspan="3">
											<input type="text" name="sh_cnt_cd2" style="width: 30;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo .getShCntCd())%>" readOnly>
											<input type="text" name="sh_cust_seq2" style="width: 55;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo .getShCustSeq())%>" readOnly>
											<input type="text" name="sh_cust_nm2" style="width: 180;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo .getShCustNm())%>" readOnly>
										</td>
										<td align="right">Doc Type&nbsp;
										<input type="text" name="doc_tp_cd" style="width: 26" class="input2" value="<%=docTpCd%>" readOnly>
										</td>
									</tr>
									<tr class="h23">
										<td>Forwarder</td>
										<td colspan="3">
											<input type="text" name="ff_cnt_cd2" style="width: 30;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo .getFfCntCd())%>" readOnly>
											<input type="text" name="ff_cust_seq2" style="width: 55;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo .getFfCustSeq())%>" readOnly>
											<input type="text" name="ff_cust_nm2" style="width: 180;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo .getFfCustNm())%>" readOnly>
										</td>		
										<td width="" align="right">L/Rep.&nbsp;
										<input type="text" name="srep_cd2" style="width: 54;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo .getSrepCd())%>" readOnly>
										</td>
									</tr>
								</table>
								<table class="search" border="0">
									<tr class="h23">
										<td width="35">VVD</td>
										<td width="285" align="left">
											<input type="text" name="vvd2" style="width: 89;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo .getVvd())%>" readOnly>
											<input type="text" name="vsl_nm2" style="width: 180;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo .getVslNm())%>" readOnly>
										</td>
										<%
											splitStsCd = ""; 
											if ( rqstVo!=null ) {
												splitStsCd = rqstVo.getSplitStsCd().trim(); 
												if ( splitStsCd != null && splitStsCd.length() > 0 ){
													splitStsCd = replaceNull(splitStsCd); 
												}
											}
										%>
										<td align="right">Status&nbsp;
											<input type="text"name="xter_bkg_rqst_sts_cd" style="width: 20;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo.getXterBkgRqstStsCd())%>">
										</td>	
									</tr>
									<tr class="h23">									
										<td width="35">POR</td>
										<td width="285">
											<input type="text" name="bkg_por_cd2" style="width: 55;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo .getPorCd())%>" readOnly>
											<input type="text" name="bkg_por_yd_cd2" style="width: 25;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo .getPorYdCd())%>" readOnly>
											<input type="text" name="por_nm2" style="width: 189;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo .getPorNm())%>" readOnly>
										</td>
										<td align="right">Split&nbsp;
											<input type="text" name="split_sts_cd" style="width: 26; color:red" class="input2" value="<%=splitStsCd %>" readOnly>
										</td>
									</tr>
									<tr class="h23">
										<td>POL</td>
										<td>
											<input type="text" name="bkg_pol_cd2" style="width: 55;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo .getPolCd())%>" readOnly>
											<input type="text" name="bkg_pol_yd_cd2" style="width: 25;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo .getPolYdCd())%>" readOnly>
											<input type="text" name="pol_nm2" style="width: 189;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo .getPolNm())%>" readOnly>
										</td>
										<td align="right">Frt as Argn&nbsp;
											<input type="text" name="xter_chg_arr_flg2" style="width: 26;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo .getXterChgArrFlg())%>" readOnly>
										</td>
									</tr>
									<tr class="h23">
										<td>POD</td>
										<td>
											<input type="text" name="bkg_pod_cd2" style="width: 55;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo .getPodCd())%>" readOnly>
											<input type="text" name="bkg_pod_yd_cd2" style="width: 25;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo .getPodYdCd())%>" readOnly>
											<input type="text" name="pod_nm2" style="width: 189;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo .getPodNm())%>" readOnly>
										</td>
										<td align="right">Agent Sign&nbsp;
											<input type="text" name="xter_agn_dp_flg2" style="width: 26;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo .getXterAgnDpFlg())%>" readOnly>
										</td>
										<!-- <td align="right">Final Dest.
											<input type="text" name="fnl_dest_nm2" style="width: 81;" class="input2" value="<%//=(rqstVo == null) ? "" : replaceNull(rqstVo .getFnlDestNm())%>" readOnly>
										</td> -->
									</tr>
									<tr class="h23">
										<td>DEL</td>
										<td>
											<input type="text" name="bkg_del_cd2" style="width: 55;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo .getDelCd())%>" readOnly>
											<input type="text" name="bkg_del_yd_cd2" style="width: 25;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo .getDelYdCd())%>" readOnly>
											<input type="text" name="del_nm2" style="width: 189;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo .getDelNm())%>" readOnly>
										</td>
										<td align="right">Attached&nbsp;
											<input type="text" name="xter_list_dp_flg2" style="width: 26;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo .getXterListDpFlg())%>" readOnly>
										</td>
									</tr>
								</table>
								<table class="search" border="0">
									<tr class="h23">
										<td width="115">Service Term(R/D)</td>
										<td width="130">
											<input type="text" name="rcv_term2" style="width: 45;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo .getRcvTerm())%>" readOnly>
											<input type="text" name="dlv_term2" style="width: 45;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo .getDlvTerm())%>" readOnly>
										</td>
										<td colspan="3" align="right">Final Dest.
											<input type="text" name="fnl_dest_nm2" style="width: 81;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo .getFnlDestNm())%>" readOnly>
										</td>
									</tr>
									<tr class="h23">
									<%
										String scRfa = "";
										if(rqstVo != null){
											scRfa = rqstVo .getScRfa();											
										}
									%>
										<td>
											<input type="radio" name="ctrt_type2" value="SC" <%="SC".equals(scRfa) ? "checked" : ""%> class="trans">S/C&nbsp;
											<input type="radio" name="ctrt_type2" value="RFA" <%="RFA".equals(scRfa) ? "checked" : ""%> class="trans">RFA
										</td> 
										<td width="">
											<input type="text" name="ctrt_no2" style="width: 94;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo .getCtrtNo())%>" readOnly>
										</td>
										<td align="right">Freight Term&nbsp;
											<input type="text" name="frt_term_cd2" style="width: 81;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo .getFrtTermCd())%>" readOnly>
										</td>
									</tr>
								</table>
								<table class="search" border="0">
									<tr class="h23">
										<td width="70">Commodity</td>
										<td colspan="2" width="">
										<input type="text" name="cmdt_cd2" style="width: 60;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo.getCmdtCd())%>" readOnly>
										<input type="text" name="cmdt_desc2" style="width: 130;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo .getCmdtDesc())%>" readOnly>
										</td>										
										<td align="right">S/O No.&nbsp;
											<input type="text" name="twn_so_no2" style="width: 81;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo .getTwnSoNo())%>" readOnly>
										</td>
									</tr>
									<tr class="h23">
										<td>AMS Filer</td>
										<td class="stm">
											US&nbsp;<input type="text" name="usa_cstms_file_ctnt2" style="width: 40;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo.getUsaCstmsFileCtnt())%>" readOnly>&nbsp;
											CA&nbsp;<input type="text" name="cnd_cstms_file_cd2" style="width: 40;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo.getCndCstmsFileCd())%>" readOnly>
										</td>
										<td align="right">SCAC
											<input type="text" name="scac_cd2" style="width: 40; text-align: center" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo .getScacCd())%>" readOnly>
										</td>
										<td align="right">E.WGT
											<input type="text" name="estm_wgt2" style="width: 91; text-align: right" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo .getEstmWgt())%>" readOnly>
											<input type="text" style="width: 55;" name="estm_wgt_ut_cd2" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo .getEstmWgtUtCd())%>" readOnly>
										</td>
									</tr>
								</table>
								<table class="search" border="0">
									<tr class="h23">
										<td width="67">Special</td>
										<td class="stm">
										<%
											String dcgoFlg2 = "";
											String rcFlg2 = "";
											String awkCgoFlg2 = "";
											String bbCgoFlg2 = "";
											String socFlg2 = "";
											String flexHgtFlg2 ="";
											
											if(rqstVo != null){
												dcgoFlg2 = rqstVo.getDcgoFlg();
												rcFlg2 = rqstVo.getRcFlg();
												awkCgoFlg2 = rqstVo.getAwkCgoFlg();
												bbCgoFlg2 = rqstVo.getBbCgoFlg();
												socFlg2 = rqstVo.getSocFlg();	
												flexHgtFlg2 = rqstVo.getFlexHgtFlg();	
											}
										%>
											<input type="checkbox" name="dcgo_flg2" value="<%=dcgoFlg2%>" <%="Y".equals(dcgoFlg2) ? "checked" : "" %> class="trans">D/G&nbsp;
											<input type="checkbox" name="rc_flg2" value="<%=rcFlg2%>" <%="Y".equals(rcFlg2) ? "checked" : "" %> class="trans">R/F&nbsp;
											<input type="checkbox" name="awk_cgo_flg2" value="<%=awkCgoFlg2%>" <%="Y".equals(awkCgoFlg2) ? "checked" : "" %> class="trans">A/K&nbsp;
											<input type="checkbox" name="bb_cgo_flg2" value="<%=bbCgoFlg2%>" <%="Y".equals(bbCgoFlg2) ? "checked" : "" %> class="trans">B/B&nbsp;
											<input type="hidden" name="soc_flg2" value="<%=socFlg2%>" <%="Y".equals(socFlg2) ? "checked" : "" %>class="trans">
											<input type="checkbox" name="spcl_hide_flg2" class="trans">HD
											<input type="checkbox" name="prct_flg2" class="trans">PC
											<input type="checkbox" name="fd_grd_flg2" class="trans">FG
											<input type="checkbox" name="flex_hgt_flg2" value="<%=flexHgtFlg2%>" <%="Y".equals(flexHgtFlg2) ? "checked" : "" %> class="trans">F/H
										</td>
									</tr>
								</table>
								<table class="search" border="0">
									<tr class="h23">
										<td width="50" rowspan="4" valign="top">EQ Q'ty</td>
										<td width="240" rowspan="4" valign="top"><!-- : ( Grid ) (S) -->
										<table width="98%" id="mainTable">
											<tr><td width="100%"><script language="javascript">ComSheetObject('sheet2');</script></td></tr>
										</table></td>
										<td width="85" align="left">Return Date</td>
										<td width="70" align="right"><input type="text" name="return_dt2" style="width: 70;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo.getReturnDt())%>" readOnly></td>
									</tr>
									<tr class="h23" align="left">
										<td width="85">Sailing Date</td>
										<td width="70" align="right"><input type="text" name="departure_dt2" style="width: 70;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo.getDepartureDt())%>" readOnly></td>
									</tr>
									<tr class="h23" align="left">
										<td width="85">Pickup Date</td>
										<td width="70" align="right"><input type="text" name="mty_pkup_dt2" style="width: 70;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo.getMtyPkupDt())%>" readOnly></td>
									</tr>
									<tr class="h23" align="left">
										<td width="85">Delivery Date</td>
										<td width="70" align="right"><input type="text" name="arrival_dt2" style="width: 70;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo.getArrivalDt())%>" readOnly></td>
									</tr>
								</table>
								<!-- 
								<table><tr><td class="height_10"></td></tr></table>
								 -->
								<table class="search" border="0">
									<tr class="h23">
										<td width="270">
											<table width="260" class="grid2" border="0">
												<tr class="h23">
													<td class="tr2_head" width="60%">Remark(s)&nbsp;Instruction</td>
													<td class="tr2_head" width="40%">Space Controller Remark</td>
												</tr>
												<tr class="h23">
													<td class="input2"><textarea style="width:100%;height:73"  class="textarea2" name="rmk2" readOnly><%=(rqstVo == null) ? "" : replaceNull(rqstVo.getRmk())%></textarea></td>
													<td class="input2"><textarea style="width:100%;height:73"  class="textarea2" name="spcCtrlrRmk" readOnly><%=(rqstVo == null) ? "" : replaceNull(rqstVo.getSpcCtrlrRmk())%></textarea></td>
												</tr>
											</table>
											<table width="100%" class="search" border="0">
												<tr>
													<td>
														<table width="271" border="0" cellpadding="0" cellspacing="0" class="button">
															<tr class="h23">
																<td width="123">Auto Notification</td>
																<td width="148"><input type="text" name="auto_notification2" style="width: 40;" class="input2"	value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo.getAutoNotification())%>"	readOnly></td>
															</tr>
														</table>
													</td>
												</tr>
												<tr class="h23">
													<td>
														<table width="271" border="0" cellpadding="0" cellspacing="0" class="button">
															<tr>
																<td class="btn2_left" style="border:0; padding:0;"></td>
																<td class="btn2" style="border:0; padding:0;" name="btn_docRequirement2" id="btn_docRequirement2">Doc Requirement</td>
																<td class="btn2_right" style="border:0; padding:0;"></td>
																<td class="btn2_left" style="border:0; padding:0;"></td>
																<td class="btn2" style="border:0; padding:0;" name="btn_ref_xter" id="btn_ref_xter">Reference NO.</td>
																<td class="btn2_right" style="border:0; padding:0;"></td>
															</tr>
														</table>
													</td>
												</tr>
											</table>
										</td>
										<td rowspan="2" valign="top">
											<input type="radio" name="tmp_radio" id="tmp_radio1" class="trans" onclick="changeCntcLayer(0)" <% if ( docTpCd!=null && docTpCd.equals("B") ) out.print("checked"); %>><label for="tmp_radio1">BKG contact</label>&nbsp;
											<input type="radio" name="tmp_radio" id="tmp_radio2" class="trans" onclick="changeCntcLayer(1)" <% if ( docTpCd==null || !docTpCd.equals("B") ) out.print("checked"); %>><label for="tmp_radio2">S/I contact</label>
											<div id="cntcLayer1" style="display:inline;overflow-y:auto;width:100%;height:116px">
												<table border="0" style="width:100%; background-color:white;" class="grid2">
													<colgroup>
														<col style="width:82px"/>
														<col/>
													</colgroup>
													<tr>
														<td class="tr2_head2">Name</td>
														<td class="align_r"><input type="text" name="cntc_nm2" style="width:132;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo.getCntcNm())%>" readOnly></td>
													</tr>
													<tr>
														<td class="tr2_head2">E-mail</td>
														<td class="align_r"><input type="text" name="cntc_eml2"	style="width:132;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo.getCntcEml())%>" readOnly></td>
													</tr>
													<tr>
														<td class="tr2_head2">Tel.</td>
														<td class="align_r"><input type="text" name="tel2" style="width:132;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo.getTel())%>"	readOnly></td>
													</tr>
													<tr>
														<td class="tr2_head2">Fax</td>
														<td class="align_r"><input type="text" name="fax2" style="width:132;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo.getFax())%>"	readOnly></td>
													</tr>
													<tr>
														<td class="tr2_head2">Mobile</td>
														<td class="align_r"><input type="text" name="mobile2" style="width:132;"	class="input2"	value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo.getMobile())%>" readOnly></td>
													</tr>													
													<tr>
														<td class="tr2_head2">Cust.<br>Ref.No</td>
														<td class="align_r"><input type="text" name="cust_ref_no2" style="width:132;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo.getCustRefNo())%>" readOnly></td>
													</tr>
												</table>
											</div>
											<div id="cntcLayer2" style="display:none;overflow-y:auto;width:100%;height:116px">
												<table border="0" style="width:100%; background-color:white;" class="grid2"> 
													<colgroup>
														<col style="width:82px"/>
														<col/>
													</colgroup>
													<tr>
														<td class="tr2_head2">Name</td>
														<td class="align_r"><input type="text" name="si_cntc_nm2" style="width:132;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo.getSiCntcNm())%>" readOnly></td>
													</tr>
													<tr>
														<td class="tr2_head2">E-mail</td>
														<td class="align_r"><input type="text" name="si_cntc_eml2"	style="width:132;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo.getSiCntcEml())%>" readOnly></td>
													</tr>
													<tr>
														<td class="tr2_head2">Tel.</td>
														<td class="align_r"><input type="text" name="si_tel2" style="width:132;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo.getSiTel())%>"	readOnly></td>
													</tr>
													<tr>
														<td class="tr2_head2">Fax</td>
														<td class="align_r"><input type="text" name="si_fax2" style="width:132;" class="input2" value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo.getSiFax())%>"	readOnly></td>
													</tr>
													<tr>
														<td class="tr2_head2">Mobile</td>
														<td class="align_r"><input type="text" name="si_mobile2" style="width:132;"	class="input2"	value="<%=(rqstVo == null) ? "" : replaceNull(rqstVo.getSiMobile())%>" readOnly></td>
													</tr>													
												</table>
											</div>
											<div id="alocRsn" style="position:absolute;left:0;top:0;width:0;height:0;"></div>
										</td>	
									</tr>
								</table>
							</td>
						</table>
						<!--  biz_2  (E) --></td>
					</tr>
				</table>

				</td>
			</tr>
		</table>
		<!-- Grid BG Box  (S) -->
	<!--biz page (E)--></td>
	</tr>
</table>

<!--TAB BKG Creation (E) -->
<input type="hidden" name="old_bkg_no" value="<%=bkgNo%>">
<input type="hidden" name="old_bl_no" >
<input type="hidden" name="orgBlNo" >
<input type="hidden" name="userInfo"   		value="">
<input type="hidden" name="bkg_ofc_cd" 		value="<%=strOfc_cd%>">
<input type="hidden" name="rhq_ofc_cd"      value = "<%=StrRhq_ofc_cd%>">

<!-- route 정보 -->
<input type="hidden" name="prd_params"><!-- 0079엔 없음 -->
<input type="hidden" name="pctl_no" value="<%=pctlNo%>">
<input type="hidden" name="pctl_no_old">
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
<input type="hidden" name="svc_scp_cd">
<input type="hidden" name="org_trns_svc_mod_cd" value="<%=orgTrnsSvcModCd%>">
<input type="hidden" name="dest_trns_svc_mod_cd"value="<%=destTrnsSvcModCd%>">
<input type="hidden" name="check_ts_close_flag">
<input type="hidden" name="ocp_cd">
	
<!-- customer 정보 -->
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
<input type="hidden" name="rfaNoValid" > <!-- 유효한 RfaNo 번호인지 확인(CMDT PopUp 호출시 사용) -->
<input type="hidden" name="sc_no_old" value="<%=scNo%>">
<input type="hidden" name="sc_rfa" value="<%=rqstVo == null ? "" :replaceNull(rqstVo .getScRfa())%>">

<input type="hidden" name="scp_from_ctrt">
<input type="hidden" name="cmdt_cd_old" 		value="<%=cmdtCd%>">
<input type="hidden" name="rep_cmdt_cd" 		value="<%=repCmdtCd%>">
<input type="hidden" name="validPrecaution">
<input type="hidden" name="befUsaCstmsFileCd">
<input type="hidden" name="act_wgt_old" value="<%=actWgt%>">

<input type="hidden" name="chk_oft">
<input type="hidden" name="application_dt">
<input type="hidden" name="cntr_del" value="N">
<!-- cargo -->
<input type="hidden" name="total_vol">
<input type="hidden" name="dcgo_flg_old" 	value="<%=dcgoFlg%>">
<input type="hidden" name="hcdg_flag" 		>
<input type="hidden" name="rc_flg_old" 		value="<%=rcFlg%>">
<input type="hidden" name="awk_cgo_flg_old" value="<%=awkCgoFlg%>">
<input type="hidden" name="bb_cgo_flg_old" 	value="<%=bbCgoFlg%>">
<input type="hidden" name="allMotorLoc" >
<input type="hidden" name="flexHeightLoc" >
<input type="hidden" name="rd_cgo_flg" 		value="<%=rdCgoFlg%>">   <!-- Save시 변경-->
<input type="hidden" name="soc_flg_old" 	value="<%=socFlg%>">     <!-- Save시 변경 -->
<input type="hidden" name="eq_subst_flg" 	>
<input type="hidden" name="dg_flg" 			>
<input type="hidden" name="rf_flg" 			>
<input type="hidden" name="awk_flg" 		>
<input type="hidden" name="bb_flg" 			>
<input type="hidden" name="stwg_flg" 		>
<input type="hidden" name="hngr_flg" 		>
<input type="hidden" name="stop_off_flg" 	>
<input type="hidden" name="blck_stwg_cd" 	>
<input type="hidden" name="bkg_cgo_tp_cd" 	>

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
<input type="hidden" name="ts_close_bkg_flag" 		value="">
<input type="hidden" name="closed_ts_vvd" 			value="">
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
<input type="hidden" name="port_skp_flg">
<input type="hidden" name="cust_ntc_flg">
<input type="hidden" name="vsl_cng_rsn">
<input type="hidden" name="pgm_no" value="ESM_BKG_0229_01">

<!-- Popup에서 작업한 정보 담는 Hidden(Sheet 제외) -->
<!-- ESM-BKG_0090 Special Stowage Request -->
<input type="hidden" name="stwg_cd">
<input type="hidden" name="stwg_rmk"> 

<!-- BDR, C/A Flag (S) -->
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

<!-- RouteDetail시 반영될 Hidden Sheet -->
<input type="hidden" name="org_trns_mod_cd"  value="<%=orgTrnsModCd%>"> 
<input type="hidden" name="dest_trns_mod_cd" value="<%=destTrnsModCd%>"> 

<!-- BKG 생성 경로 (S) -->
<input type="hidden" name="xter_bkg_rqst_cd"     value="<%=xterBkgRqstCd%>">
<input type="hidden" name="xter_bkg_rqst_ref_no" value="<%=xterBkgRqstRefNo%>">

<!-- SI 생성 경로 (S) -->
<input type="hidden" name="si_flg"         value="<%=siFlg%>">
<input type="hidden" name="xter_si_cd"     value="<%=xterSiCd%>">
<input type="hidden" name="xter_si_ref_no" value="<%=xterSiRefNo%>">

<!-- : ( Grid ) (S) -->
<table width="98%" id="mainTable">
	<tr>
		<td width="98%"><script language="javascript">ComSheetObject('sheet3');</script>
		</td>
	</tr>
</table>
<table width="98%" id="mainTable">
	<tr>
		<td width="98%"><script language="javascript">ComSheetObject('sheet4');</script>
		</td>
	</tr>
</table>
<!-- : ( Grid ) (E) -->
<table width="98%" id="mainTable">
	<tr>
		<td width="98%"><script language="javascript">ComSheetObject('sheet5');</script>
		</td>
	</tr>
</table>
</form>
<form name="form2">
	<input type="hidden" name="bkg_por_cd"></input>
	<input type="hidden" name="bkg_por_yd_cd"></input>
	<input type="hidden" name="por_nm"></input>
	<input type="hidden" name="bkg_pol_cd"></input>
	<input type="hidden" name="bkg_pol_yd_cd"></input>
	<input type="hidden" name="pol_nm"></input>
	<input type="hidden" name="bkg_pod_cd"></input>
	<input type="hidden" name="pod_nm"></input>
	<input type="hidden" name="bkg_del_cd"></input>
	<input type="hidden" name="del_nm"></input>

	<input type="hidden" name="mty_pkup_yd_cd"></input>
	<input type="hidden" name="full_rtn_yd_cd"></input>
	<input type="hidden" name="mty_pkup_dt"></input>
</form>
</body>
</html>
<%!public String replaceNull(String str) {
		return (str == null || str.trim().length() == 0 || "null".equals(str)) ? ""
				: str;
	}%>