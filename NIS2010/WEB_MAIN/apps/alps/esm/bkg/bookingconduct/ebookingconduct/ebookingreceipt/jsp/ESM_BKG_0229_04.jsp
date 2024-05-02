<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0229_04.jsp
*@FileTitle : e-Booking & SI Process Detail(M&D)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.16
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.06.16 전용진
* 1.0 Creation
===============================================================================
 History
 2010.09.13 이일민 [CHM-201005276-01] ALPS-[BKG/DOC]주요UI버턴-단축키 기능개발
 2011.12.06 정선용 [CHM-201114657-01] [ALPS] E-BKG/SI Freight Term Drop Down Box 삭제 요청
 2011.12.20 정선용 [CHM-201115077-01]	[UI_BKG_0361_11] Export/Import information (Turkey) - 터키 Tax ID컬럼 추가
 2012.01.09 정선용 [CHM-201215422-01] Export Information Overwriting Issue 해결을 위한 ALPS 로직 보완
 2012.02.02 변종건 [CHM-201215949-01] e-Booking & SI upload 화면의 USA export 정보 변경 요청
 2012.02.28 정선용 [CHM-201215444-01] [웹 리뉴얼] Rider 및 D/G Rider 항목 보완 (E-bkg/E-SI)
 2012.08.03 이재위 [CHM-201219302] Split 02-[M&D Export&Import Information] Israel VAT ID추가
 2012.10.16 이재위 [CHM-201220620] Split 02-[M&D Export/Import Information] Lebanon의 VAT ID추가
 2012.11.15 김현화 [CHM-201220707] e-booking & e-si upload 화면에 P.O. NO. 입력 필수 validation 및 경고 문구 추가(cntr no 추가 :hidden)
 2012.12.17 김현화 [CHM-201221669] Exception 체크 하지 않을 시, B/L Preview에 행 삭제 요청 : cstms_desc width 수정
 2013.01.07 김현화 [CHM-201222209] BRAZIL TAX ID 추가 요청
 2013.05.20 임재관 [CHM-201324732] Split 01-한국지역 WHF 신고방법 간소화
 2014.01.13 최도순 [CHM-201433292] e-BKg & SI Upload화면 > M&D tap > Ship ID항목 추가
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkg022904Event"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.common.*" %>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO" %>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.*" %>
<%@ page import="com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.MndVO" %>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.core.controller.DefaultViewAdapter" %>
<%@ page import="java.util.List" %>

<%
	EsmBkg022904Event event = null;			//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;		//서버에서 발생한 에러
	String strErrMsg = "";					//에러메세지
	String sXml = "";
	int rowCount = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.hanjin.apps.EBookingConduct.EBookingReceipt");

	List<BkgComboVO> wgt_cd = null;
	List<BkgComboVO> meas_cd = null;
	//List<MndVO> alpsMndList = null;
	MndVO alpsMndVO = null;
	List<XterMndVO> xterMndList = null;
	XterMndVO xterMndVO = null;
	List<XterInnerPackageVO> xterInnerPackageVO = null;
	XterXptLicVO xterXptLicVO = null;
	
	int krXptLicCnt = 0;
	int idXptLicCnt = 0;
	
	
	int xterCntrPoNoVOsCnt = 0;
	int xterPoDtlVOsCnt= 0;
	int xterRqstNoVOsCnt = 0;
	int xterInnerPackageVOsCnt = 0;
	int xterKrWhfBlExptInfoVOsCnt = 0;
	int xterRefDtlVOsCnt= 0;
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg022904Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		DefaultViewAdapter adapter = new DefaultViewAdapter();
		sXml = adapter.makeXML(request, response);

		ExternalRqstMndVO rqstMndVo = (ExternalRqstMndVO) eventResponse.getCustomData("externalRqstMndVO");
		alpsMndVO = (MndVO) eventResponse.getCustomData("MndVO");
		//alpsMndList = rqstMndVo.getAlpsMndVO();
		xterMndList = rqstMndVo.getXterMndVO();
		xterXptLicVO = rqstMndVo.getXterXptLicVO();
		//if (alpsMndList.size() > 0) alpsMndVO = (AlpsMndVO) alpsMndList.get(0);
		if (xterMndList.size() > 0) xterMndVO = (XterMndVO) xterMndList.get(0);

		wgt_cd = (List<BkgComboVO>) eventResponse.getCustomData("wgt_cd");
		meas_cd = (List<BkgComboVO>) eventResponse.getCustomData("meas_cd");
		krXptLicCnt = Integer.parseInt(xterMndVO == null ? "0" :xterMndVO.getKrXptLicCnt());
		idXptLicCnt = Integer.parseInt(xterMndVO == null ? "0" :xterMndVO.getIdXptLicCnt());
		
		xterCntrPoNoVOsCnt = (Integer) eventResponse.getCustomData("xterCntrPoNoVOsCnt");
		xterPoDtlVOsCnt = (Integer) eventResponse.getCustomData("xterPoDtlVOsCnt");
		xterRqstNoVOsCnt = (Integer) eventResponse.getCustomData("xterRqstNoVOsCnt");
		xterInnerPackageVOsCnt = (Integer) eventResponse.getCustomData("xterInnerPackageVOsCnt");
		xterKrWhfBlExptInfoVOsCnt = (Integer) eventResponse.getCustomData("xterKrWhfBlExptInfoVOsCnt");
		xterRefDtlVOsCnt = (Integer) eventResponse.getCustomData("xterRefDtlVOsCnt");
		
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>e-Booking & SI Process Detail(M&D)</title>
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

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="rqst_seq" value="<%=StringUtil.xssFilter(request.getParameter("rqst_seq"))%>">
<input type="hidden" name="sender_id" value="<%=StringUtil.xssFilter(request.getParameter("sender_id"))%>">
<input type="hidden" name="mnd_alps" value="<%=(alpsMndVO==null)?"Y":"N"%>">
<input type="hidden" name="mnd_esvc" value="<%=(xterMndList.size() > 0)?"Y":"N"%>">

<input type="hidden" name="bdr_flg">
<input type="hidden" name="sXml" value="<%=JSPUtil.replace(sXml, "\"", "&quot;")%>">
<input type="hidden" name="cstms_clr_cd">
<input type="hidden" name="cntr_desc" value="<%=alpsMndVO == null ? "" :replaceNull(alpsMndVO.getCntrDesc())%>">
<input type="hidden" name="rc_flg">
<input type="hidden" name="xpt_imp_seq" value="1">
<input type="hidden" name="po_cust_flag" value="<%=alpsMndVO == null ? "" :replaceNull(alpsMndVO.getPoCustFlag())%>">
<input type="hidden" name="po_ref_flag" value="<%=alpsMndVO == null ? "" :replaceNull(alpsMndVO.getPoRefFlag())%>">
<input type="hidden" name="po_ref_dtl_flag" value="<%=alpsMndVO == null ? "" :replaceNull(alpsMndVO.getPoRefDtlFlag())%>">
<input type="hidden" name="obl_iss_flg">
<input type="hidden" name="xpt_imp2" value="<%=xterMndVO == null ? "" :replaceNull(xterMndVO.getXptImp())%>">
<input type="hidden" name="po_no2" value="<%=xterMndVO == null ? "" :replaceNull(xterMndVO.getPoNo())%>">
<input type="hidden" name="misc2" value="<%=xterMndVO == null ? "" :replaceNull(xterMndVO.getMisc())%>">
<input type="hidden" name="rider2" value="<%=xterMndVO == null ? "" :replaceNull(xterMndVO.getRider())%>">
<input type="hidden" name="frt_term_cd"   value=""> <!-- jsy 2011.11.28 -->
<input type="hidden" name="aes_expt_id_tmp" value="<%=replaceNull(xterXptLicVO.getAesExptId2())%>">
<input type="hidden" name="cntr_no">
<input type="hidden" name="brz_decl_no" >
<input type="hidden" name="brz_decl_cpy_desc_flg" >
<input type="hidden" name="shpr_tax_cpy_desc_flg" >
<input type="hidden" name="ntfy_tax_cpy_desc_flg" >
<input type="hidden" name="cnee_tax_cpy_desc_flg" >
<input type="hidden" name="kr_xpt_lic_cnt" value="<%=krXptLicCnt%>">
<input type="hidden" name="id_xpt_lic_cnt" value="<%=idXptLicCnt%>">

<input type="hidden" name="xterCntrPoNoVOsCnt" value="<%=xterCntrPoNoVOsCnt%>">
<input type="hidden" name="xterPoDtlVOsCnt" value="<%=xterPoDtlVOsCnt%>">
<input type="hidden" name="xterRqstNoVOsCnt" value="<%=xterRqstNoVOsCnt%>">
<input type="hidden" name="xterInnerPackageVOsCnt" value="<%=xterInnerPackageVOsCnt%>">
<input type="hidden" name="xterKrWhfBlExptInfoVOsCnt" value="<%=xterKrWhfBlExptInfoVOsCnt%>">
<input type="hidden" name="xterRefDtlVOsCnt" value="<%=xterRefDtlVOsCnt%>">

<input type="hidden" name="exp_vin_ctnt">
<input type="hidden" name="exp_vin_ctnt2" value="<%=xterXptLicVO.getVinCtnt()%>">

<!-- m&d 화면에  있는 항목 -->
<!-- 개발자 작업	-->
<!-- eSvc쪽 Misc.Information 버튼 클릭시 -->
<div id="showMisc" style="position:absolute;visibility:hidden;z-index:1" style="margin-top:352px;margin-left:496px;">
	<table cellspacing="1" cellpadding="0" width="260" bgcolor="#AAAAAA" >
		<tr><td>
			<table width="100%">
			  <tr bgcolor="#FBFBFB">					
			    <td colspan="2" style="padding:3px; line-height:100px">
			      <textarea name="misc_desc" cols="45" rows="7" class="textarea" readOnly><%=xterMndVO == null ? "" :replaceNull(xterMndVO.getMiscDesc())%></textarea>
			    </td>				
			  </tr>			
			</table>
		</td></tr>
	</table>
</div>

<div id="showXptLicNo" style="position:absolute; visibility:hidden; z-index:1000" style="margin-top:297px; margin-left:15px; height:250px; width:567px" style="overflow-y:scroll;">
	<table cellspacing="1" cellpadding="0" bgcolor="#AAAAAA">
		<tr bgcolor="#D9E0EA"><td>	
			<table class="search" border="0">
				<tr class="h23">
					<td border="1"><input type="text"  style="width:60;" class="input2" value="USA"></td>
				</tr>
				<tr class="h23">
					<td width="150"><input type="checkbox" value="AE" class="trans" name="aes_tp_cd" onClick="javascript:radioBtnSet(this)">&nbsp;AES (AES ITN)</td>
					<td width="90" style="padding-left:2"><input type="text" style="width:90;" class="input2" value="AES ITN" name="aes_inlnd_trns_pfx_ctnt" readOnly></td>
					<td width="183" colspan="3"><input type="text" style="width:183;" class="input" size="15" value="" name="aes_inlnd_trns_no" dataformat="aesno" maxlength="15"></td>
				</tr>
				<tr class="h23">
					<td width="150"><input type="checkbox" value="PA" class="trans" name="aes_tp_cd" onClick="javascript:radioBtnSet(this)">&nbsp;PTA (Post Agent)</td>
					<td width="90" style="padding-left:2"><input type="text" style="width:90;" class="input2" value="AESPOST" name="aes_pta_pfx_ctnt" readOnly></td>
					<td width="90"><input type="text" style="width:90;" class="input" minlength="9" maxlength="11" name="aes_pta_no1" dataformat="int"></td>
					<td width="90"><input type="text" style="width:90;" class="input" minlength="9" maxlength="11" name="aes_pta_no2" dataformat="int"></td>
					<td width="105" align="left"><input type="text" style="width:72;" class="input" name="aes_pta_dt" dataformat="mdy" maxlength="8" ></td>
				</tr>
				<tr class="h23">
					<td width="150"><input type="checkbox" value="PU" class="trans" name="aes_tp_cd" onClick="javascript:radioBtnSet(this)">&nbsp;PTU (Post USPPI)</td>
					<td width="90" style="padding-left:2"><input type="text" style="width:90;" class="input2" value="AESPOST" name="aes_ptu_pfx_ctnt" readOnly></td>
					<td width="90"><input type="text" style="width:90;" class="input" minlength="9" maxlength="11" name="aes_ptu_no" dataformat="int"></td>
					<td width="200" colspan="2"><input type="text" style="width:72;" class="input" name="aes_ptu_dt" dataformat="mdy" maxlength="8">&nbsp;</td>
				</tr>
				<tr class="h23">
					<td width="150"><input type="checkbox" value="DN" class="trans" name="aes_tp_cd" onClick="javascript:radioBtnSet(this)">&nbsp;Down (AES Down)</td>
					<td width="90" style="padding-left:2"><input type="text" style="width:90;" class="input2" value="AESDOWN" name="aes_dwn_pfx_ctnt" readOnly></td>
					<td width="90"><input type="text" style="width:90;" class="input" minlength="9" maxlength="11" name="aes_dwn_no" dataformat="int"></td>
					<td width="200" colspan="2"><input type="text" style="width:72;" class="input" name="aes_dwn_dt" dataformat="mdy" maxlength="8">&nbsp;</td>
				</tr>
				<tr class="h23">
					<td width="150"><input type="checkbox" value="EX" class="trans" name="aes_tp_cd" onClick="javascript:radioBtnSet(this)">&nbsp;Exception</td>
					<td width="300" colspan="4" style="padding-left:4"><script language="javascript">ComComboObject("aes_expt_id", 1, 278, 1);</script></td>
				</tr>
				<tr class="smt">
					<td width="150" align="right">(Manual Input)&nbsp;&nbsp;</td>
					<td width="370" colspan="4"><textarea cols="10" rows="2" style="width:370;" class="" name="aes_expt_ctnt" maxlength="30"></textarea></td>
				</tr>
				<tr class="h23">
					<td width="150">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VIN No.</td>
					<td width="370" colspan="4"><input type="checkbox" value="Y" class="trans" name="vin_exist_flg" disabled>
					<img name="btn_vinNo" class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
				</tr>
			</table>
			<table class="search" border="0">
				<tr class="h23">
					<td border="1"><input type="text"  style="width:60;" class="input2" value="Canada"></td>
				</tr>
				<tr class="h23">
					<td width="150"><input type="checkbox" value="CE" class="trans" name="caed_tp_cd" onClick="javascript:radioBtnSet(this)">&nbsp;CAED No.</td>
					<td width="420"><input type="text" style="width:90;" class="input2" value=" P.O.R: CAED" name="caed_pfx_ctnt" readOnly>&nbsp;
					<input type="text" style="width:248;" class="input" name="caed_ctnt" dataformat="" maxlength="23" onblur="javascript:ChkComIsCaedNo(this);"></td>
				</tr>
				<tr class="h23">
					<td width="150"><input type="checkbox" value="G7" class="trans" name="caed_tp_cd" onClick="javascript:radioBtnSet(this)">&nbsp;G7 EDI No.</td>
					<td width="420"><input type="text" style="width:90;" class="input2" value=" P.O.R: G7 EDI" name="g7_edi_pfx_ctnt" readOnly>&nbsp;
					<input type="text" style="width:248;" class="input" name="g7_edi_ctnt" dataformat="" maxlength="17" onblur="javascript:ChkComIsG7EdiNo(this);"></td>
				</tr>
				<tr class="h23">
					<td width="150"><input type="checkbox" value="SM" class="trans" name="caed_tp_cd" onClick="javascript:radioBtnSet(this)">&nbsp;Summary Report</td>
		 			<td width="420"><input type="text" style="width:90;" class="input2" value=" P.O.R: SUM" name="mf_smry_rpt_pfx_ctnt" readOnly>&nbsp;
		 			<input type="text" style="width:248;" class="input" name="mf_smry_rpt_no" maxlength="4" dataformat="int"></td> 
				</tr>
				<tr class="h23">
					<td width="150"><input type="checkbox" value="EX" class="trans" name="caed_tp_cd" onClick="javascript:radioBtnSet(this)">&nbsp;EXD (Form B13A)</td>
					<td width="420"><input type="text" style="width:90;" class="input2" value=" P.O.R: B13A" name="b13a_xpt_pfx_ctnt" readOnly>&nbsp;
					<input type="text" style="width:248;" class="input" name="b13a_xpt_ctnt" dataformat="" maxlength="21" onblur="javascript:ChkComIsB13aXptNo(this);"></td>
				</tr>
				<tr class="h23">
					<td width="150"><input type="checkbox" value="IT" class="trans" name="caed_tp_cd" onClick="javascript:radioBtnSet(this)">&nbsp;In-Transit Cargo</td>
					<td width="420"><input type="text" style="width:130;" class="input2" value=" P.O.R: In-Bond Cargo" name="cgo_ctrl_pfx_ctnt" readOnly>&nbsp;
					<input type="text" style="width:208;" class="input" name="cgo_ctrl_no" maxlength="18"></td>
				</tr>
				<tr class="h23">
					<td width="150"><input type="checkbox" value="ND" class="trans" name="caed_tp_cd" onClick="javascript:radioBtnSet(this)">&nbsp;No Declaration</td>
					<td width="420" style="padding-left:0"><input type="text" style="width:50;" class="input2" value=" P.O.R:" name="ndr_ref_pfx_ctnt" readOnly>&nbsp;
					<script language="javascript">ComComboObject('ndr_ref_id',3,288,1,0,2);</script></td>
				</tr>
				<tr class="smt">
					<td width="" align="right">(Manual Input)</td>
					<td width="" colspan="4"><textarea cols="10" rows="2" style="width:341;"class="" name="ndr_ref_ctnt"></textarea></td>
				</tr>
			</table>
			<table class="search" border="0">
				<tr class="h23">
					<td border="1"><input type="text"  style="width:60;" class="input2" value="Mexico"></td>
				</tr>
				<tr class="h23">
					<td width="135">&nbsp;Shipper Tax ID</td>
					<td width=""><input type="text" style="width:200;" class="input" name="mx_shpr_tax_id" dataformat="etc"  maxlength="20" value=""></td>
				</tr>
				<tr class="h23">
					<td width="">&nbsp;Consignee Tax ID</td>
					<td width=""><input type="text" style="width:200;" class="input" name="mx_cnee_tax_id" dataformat="etc"  maxlength="20" value=""></td>
				</tr>
				<tr class="h23">
					<td width="">&nbsp;Notify Tax ID</td>
					<td width=""><input type="text" style="width:200;" class="input" name="mx_ntfy_tax_id" dataformat="etc"  maxlength="20" value=""></td>
				</tr>
			</table>
			<table class="search" border="0">
				<tr class="h23">
					<td border="1"><input type="text"  style="width:60;" class="input2" value="Turkey"></td>
				</tr>
				<tr class="h23">
					<td width="135">&nbsp;Shipper Tax ID</td>
					<td width=""><input type="text" style="width:200;" class="input" name="tr_shpr_tax_id" dataformat="etc"  maxlength="20" value=""></td>
				</tr>
				<tr class="h23">
					<td width="">&nbsp;Consignee Tax ID</td>
					<td width=""><input type="text" style="width:200;" class="input" name="tr_cnee_tax_id" dataformat="etc"  maxlength="20" value=""></td>
				</tr>
				<tr class="h23">
					<td width="">&nbsp;Notify Tax ID</td>
					<td width=""><input type="text" style="width:200;" class="input" name="tr_ntfy_tax_id" dataformat="etc"  maxlength="20" value=""></td>
				</tr>
			</table>			
			<table class="search" border="0">
				<tr class="h23">
					<td border="1"><input type="text"  style="width:60;" class="input2" value="Israel"></td>
				</tr>
				<tr class="h23">
					<td width="135">&nbsp;Shipper VAT ID</td>
					<td width=""><input type="text" style="width:200;" class="input" name="il_shpr_tax_id" dataformat="etc"  maxlength="20" value=""></td>
				</tr>
				<tr class="h23">
					<td width="">&nbsp;Consignee VAT ID</td>
					<td width=""><input type="text" style="width:200;" class="input" name="il_cnee_tax_id" dataformat="etc"  maxlength="20" value=""></td>
				</tr>
				<tr class="h23">
					<td width="">&nbsp;Notify VAT ID</td>
					<td width=""><input type="text" style="width:200;" class="input" name="il_ntfy_tax_id" dataformat="etc"  maxlength="20" value=""></td>
				</tr>
			</table>			
			<table class="search" border="0">
				<tr class="h23">
					<td border="1"><input type="text"  style="width:60;" class="input2" value="Lebanon"></td>
				</tr>
				<tr class="h23">
					<td width="135">&nbsp;Shipper VAT ID</td>
					<td width=""><input type="text" style="width:200;" class="input" name="lb_shpr_tax_id" dataformat="etc"  maxlength="20" value=""></td>
				</tr>
				<tr class="h23">
					<td width="">&nbsp;Consignee VAT ID</td>
					<td width=""><input type="text" style="width:200;" class="input" name="lb_cnee_tax_id" dataformat="etc"  maxlength="20" value=""></td>
				</tr>
				<tr class="h23">
					<td width="">&nbsp;Notify VAT ID</td>
					<td width=""><input type="text" style="width:200;" class="input" name="lb_ntfy_tax_id" dataformat="etc"  maxlength="20" value=""></td>
				</tr>
			</table>
			<table class="search" border="0">
				<tr class="h23">
					<td border="1"><input type="text"  style="width:60;" class="input2" value="Brazil"></td>
				</tr>
				<tr class="h23">
					<td width="135">&nbsp;Shipper CNPJ</td>
					<td width=""><input type="text" style="width:200;" class="input" name="br_shpr_tax_id" dataformat="etc"  maxlength="14" value=""></td>
				</tr>
				<tr class="h23">
					<td width="">&nbsp;Consignee CNPJ</td>
					<td width=""><input type="text" style="width:200;" class="input" name="br_cnee_tax_id" dataformat="etc"  maxlength="14" value=""></td>
				</tr>
				<tr class="h23">
					<td width="">&nbsp;Notify CNPJ</td>
					<td width=""><input type="text" style="width:200;" class="input" name="br_ntfy_tax_id" dataformat="etc"  maxlength="14" value=""></td>
				</tr>
			</table>				
<%
if(krXptLicCnt > 0){
%>						
			<table class="search" border="0">			
				<tr class="h23">
					<td border="1"><input type="text"  style="width:60;" class="input2" value="Korea"></td>
				</tr>
				<tr>
					<td width="500">
						<script language="javascript">ComSheetObject('div1sheet1');</script>
					</td>
				</tr>		   
			</table>
			<table>
				<tr>
					<td width="100"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_krRowAdd">Row Add</td>
						<td class="btn1_right"></td>
					</tr></table></td>
					<td width="100"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_krRowDelete">Delete</td>
						<td class="btn1_right"></td>
					</tr></table></td>
				</tr>
			</table>
<%
}
%>			

<%
if(idXptLicCnt > 0){
%>			
			<table class="search" border="0">
				<tr class="h23">
					<td border="1"><input type="text"  style="width:60;" class="input2" value="Indonesia"></td>
				</tr>
				<tr>
					<td width="500">
						<script language="javascript">ComSheetObject('div8sheet1');</script>
					</td>
				</tr>
			</table>
			<table>
				<tr>
					<td width="100"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_idRowAdd">Row Add</td>
						<td class="btn1_right"></td>
					</tr></table></td>
					<td width="100"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_idRowDelete">Delete</td>
						<td class="btn1_right"></td>
					</tr></table></td>
				</tr>
			</table>
<%
}
%>		
		</td></tr>
	</table>
</div>

<div id="showXptLicNo2" style="position:absolute; visibility:hidden; z-index:2" style="margin-top:235px; margin-left:425px; height:250px; width:567px" style="overflow-y:scroll;">
	<table cellspacing="1" cellpadding="0" bgcolor="#AAAAAA">
		<tr bgcolor="#D9E0EA"><td>	
			<table class="search" border="0">
				<tr class="h23">
					<td border="1"><input type="text"  style="width:60;" class="input2" value="USA"></td>
				</tr>
				<tr class="h23">
					<td width="150">&nbsp;AES (AES ITN)</td>
					<td width="90" style="padding-left:2"><input type="text" style="width:90;" class="input2" value="AES ITN" name="aes_inlnd_trns_pfx_ctnt2" readOnly></td>
					<td width="183" colspan="3"><input type="text" style="width:183;" class="input2" size="15" value="<%=xterXptLicVO.getAesInlndTrnsNo2() %>" name="aes_inlnd_trns_no2" dataformat="aesno" maxlength="15"></td>
				</tr>
				<tr class="h23">
					<td width="150">&nbsp;PTA (Post Agent)</td>
					<td width="90" style="padding-left:2"><input type="text" style="width:90;" class="input2" value="AESPOST" name="aes_pta_pfx_ctnt2" readOnly></td>
					<td width="90"><input type="text" style="width:90;" class="input2" minlength="9" maxlength="11" value="<%=xterXptLicVO.getAesPtaNo12() %>" name="aes_pta_no12" dataformat="int"></td>
					<td width="90"><input type="text" style="width:90;" class="input2" minlength="9" maxlength="11" value="<%=xterXptLicVO.getAesPtaNo22() %>" name="aes_pta_no22" dataformat="int"></td>
					<td width="105" align="left"><input type="text" style="width:72;" class="input2" value="<%=xterXptLicVO.getAesPtaDt2() %>" name="aes_pta_dt2" dataformat="mdy" maxlength="8" ></td>
				</tr>
				<tr class="h23">
					<td width="150">&nbsp;PTU (Post USPPI)</td>
					<td width="90" style="padding-left:2"><input type="text" style="width:90;" class="input2" value="AESPOST" name="aes_ptu_pfx_ctnt2" readOnly></td>
					<td width="90"><input type="text" style="width:90;" class="input2" minlength="9" maxlength="11" value="<%=xterXptLicVO.getAesPtuNo2() %>" name="aes_ptu_no2" dataformat="int"></td>
					<td width="200" colspan="2"><input type="text" style="width:72;" class="input2" value="<%=xterXptLicVO.getAesPtuDt2() %>" name="aes_ptu_dt2" dataformat="mdy" maxlength="8">&nbsp;</td>
				</tr>
				<tr class="h23">
					<td width="150">&nbsp;Down (AES Down)</td>
					<td width="90" style="padding-left:2"><input type="text" style="width:90;" class="input2" value="AESDOWN" name="aes_dwn_pfx_ctnt2" readOnly></td>
					<td width="90"><input type="text" style="width:90;" class="input2" minlength="9" maxlength="11" value="<%=xterXptLicVO.getAesDwnNo2() %>" name="aes_dwn_no2" dataformat="int"></td>
					<td width="200" colspan="2"><input type="text" style="width:72;" class="input2" value="<%=xterXptLicVO.getAesDwnDt2() %>" name="aes_dwn_dt2" dataformat="mdy" maxlength="8">&nbsp;</td>
				</tr>
				<tr class="h23">
					<td width="150">&nbsp;Exception</td>
					<td width="370" colspan="4" style="padding-left:4"><script language="javascript">ComComboObject("aes_expt_id2", 1, 278, 1);</script></td>
				</tr>
				<tr class="h23">
					<td width="150"></td>
					<td width="370" colspan="4" style="padding-left:2"><input type="text" style="width:278;" value="<%=xterXptLicVO.getAesExptCtnt2() %>" class="input2" name="aes_expt_ctnt2"></td>
				</tr>
				<tr class="h23">
					<td width="150">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VIN No.</td>
					<td width="370" colspan="4"><input type="checkbox" value="Y" class="trans" name="vin_exist_flg2" disabled>
					<img name="btn_vinNo2" class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
				</tr>					
			</table>
			<table class="search" border="0">
				<tr class="h23">
					<td border="1"><input type="text"  style="width:60;" class="input2" value="Canada"></td>
				</tr>
				<tr class="h23">
					<td width="150">&nbsp;CAED No.</td>
					<td width="350"><input type="text" style="width:90;" class="input2" value=" P.O.R: CAED" name="caed_pfx_ctnt2" readOnly>&nbsp;
					<input type="text" style="width:248;" class="input2" value="<%=xterXptLicVO.getCaedCtnt2()%>" name="caed_ctnt2" dataformat="" maxlength="23" ></td>
				</tr>
				<tr class="h23">
					<td width="150">&nbsp;G7 EDI No.</td>
					<td width="350"><input type="text" style="width:90;" class="input2" value=" P.O.R: G7 EDI" name="g7_edi_pfx_ctnt2" readOnly>&nbsp;
					<input type="text" style="width:248;" class="input2" value="<%=xterXptLicVO.getG7EdiNo2()%>" name="g7_edi_no2" dataformat="" maxlength="17"></td>
				</tr>
				<tr class="h23">
					<td width="150">&nbsp;Summary Report</td>
		 			<td width="420"><input type="text" style="width:90;" class="input2" value=" P.O.R: SUM" name="mf_smry_rpt_pfx_ctnt2" readOnly>&nbsp;
		 			<input type="text" style="width:248;" class="input2" value="<%=xterXptLicVO.getSmryRptCtnt2()%>" name="mf_smry_rpt_ctnt2" maxlength="4" dataformat="int"></td> 
				</tr>
				<tr class="h23">
					<td width="150">&nbsp;EXD (Form B13A)</td>
					<td width="350"><input type="text" style="width:90;" class="input2" value=" P.O.R: B13A" name="b13a_xpt_pfx_ctnt" readOnly>&nbsp;
					<input type="text" style="width:248;" class="input2" value="<%=xterXptLicVO.getB13aCtnt2()%>" name="b13a_xpt_ctnt2" dataformat="" maxlength="21"></td>
				</tr>
				<tr class="h23">
					<td width="150">&nbsp;In-Transit Cargo</td>
					<td width="350"><input type="text" style="width:130;" class="input2" value=" P.O.R: In-Bond Cargo" name="cgo_ctrl_pfx_ctnt2" readOnly>&nbsp;
					<input type="text" style="width:208;" class="input2" value="<%=xterXptLicVO.getInlndTzCgoCtnt2()%>" name="cgo_ctrl_no2" maxlength="18"></td>
				</tr>
				<tr class="h23">
					<td width="150">&nbsp;No Declaration</td>
					<td width="350" style="padding-left:0"><input type="text" style="width:50;" class="input2" value=" P.O.R:" name="ndr_ref_pfx_ctnt2" readOnly>&nbsp;
					<input type="text" style="width:288;" class="input2" value="<%=xterXptLicVO.getNonDeclCtnt2()%>" name="ndr_ref_id2"></td>
				</tr>
				<tr class="smt">
					<td width="" align="right">(Manual Input)</td>
					<td width="" colspan="4"><input type="text" style="width:341;" value="<%=xterXptLicVO.getMnlInpCtnt2()%>" class="input2" name="ndr_ref_ctnt2" ></td>
				</tr>
			</table>					
			<table class="search" border="0">
				<tr class="h23">
					<td border="1"><input type="text"  style="width:60;" class="input2" value="Mexico"></td>
				</tr>
				<tr class="h23">
					<td width="135">&nbsp;Shipper Tax ID</td>
					<td width=""><input type="text" style="width:200;" class="input" value="<%=xterXptLicVO.getShprTaxNo2() %>" name="mx_shpr_tax_id2" dataformat="etc"  maxlength="20" value=""></td>
				</tr>
				<tr class="h23">
					<td width="">&nbsp;Consignee Tax ID</td>
					<td width=""><input type="text" style="width:200;" class="input" value="<%=xterXptLicVO.getCneeTaxNo2() %>" name="mx_cnee_tax_id2" dataformat="etc"  maxlength="20" value=""></td>
				</tr>
				<tr class="h23">
					<td width="">&nbsp;Notify Tax ID</td>
					<td width=""><input type="text" style="width:200;" class="input" value="<%=xterXptLicVO.getNtfyTaxNo2() %>" name="mx_ntfy_tax_id2" dataformat="etc"  maxlength="20" value=""></td>
				</tr>				
			</table>
			<table class="search" border="0">
				<tr class="h23">
					<td border="1"><input type="text"  style="width:60;" class="input2" value="Turkey"></td>
				</tr>
				<tr class="h23">
					<td width="135">&nbsp;Shipper Tax ID</td>
					<td width=""><input type="text" style="width:200;" class="input" value="<%=xterXptLicVO.getTrShprTaxId() %>" name="tr_shpr_tax_id2" dataformat="etc"  maxlength="20" value=""></td>
				</tr>
				<tr class="h23">
					<td width="">&nbsp;Consignee Tax ID</td>
					<td width=""><input type="text" style="width:200;" class="input" value="<%=xterXptLicVO.getTrCneeTaxId() %>" name="tr_cnee_tax_id2" dataformat="etc"  maxlength="20" value=""></td>
				</tr>
				<tr class="h23">
					<td width="">&nbsp;Notify Tax ID</td>
					<td width=""><input type="text" style="width:200;" class="input" value="<%=xterXptLicVO.getTrNtfyTaxId() %>" name="tr_ntfy_tax_id2" dataformat="etc"  maxlength="20" value=""></td>
				</tr>				
			</table>			
			<table class="search" border="0">
				<tr class="h23">
					<td border="1"><input type="text"  style="width:60;" class="input2" value="Israel"></td>
				</tr>
				<tr class="h23">
					<td width="135">&nbsp;Shipper VAT ID</td>
					<td width=""><input type="text" style="width:200;" class="input" value="<%=xterXptLicVO.getIlShprTaxId() %>" name="il_shpr_tax_id2" dataformat="etc"  maxlength="20" value=""></td>
				</tr>
				<tr class="h23">
					<td width="">&nbsp;Consignee VAT ID</td>
					<td width=""><input type="text" style="width:200;" class="input" value="<%=xterXptLicVO.getIlCneeTaxId() %>" name="il_cnee_tax_id2" dataformat="etc"  maxlength="20" value=""></td>
				</tr>
				<tr class="h23">
					<td width="">&nbsp;Notify VAT ID</td>
					<td width=""><input type="text" style="width:200;" class="input" value="<%=xterXptLicVO.getIlNtfyTaxId() %>" name="il_ntfy_tax_id2" dataformat="etc"  maxlength="20" value=""></td>
				</tr>				
			</table>			
			<table class="search" border="0">
				<tr class="h23">
					<td border="1"><input type="text"  style="width:60;" class="input2" value="Lebanon"></td>
				</tr>
				<tr class="h23">
					<td width="135">&nbsp;Shipper VAT ID</td>
					<td width=""><input type="text" style="width:200;" class="input" value="<%=xterXptLicVO.getLbShprTaxId() %>" name="lb_shpr_tax_id2" dataformat="etc"  maxlength="20" value=""></td>
				</tr>
				<tr class="h23">
					<td width="">&nbsp;Consignee VAT ID</td>
					<td width=""><input type="text" style="width:200;" class="input" value="<%=xterXptLicVO.getLbCneeTaxId() %>" name="lb_cnee_tax_id2" dataformat="etc"  maxlength="20" value=""></td>
				</tr>
				<tr class="h23">
					<td width="">&nbsp;Notify VAT ID</td>
					<td width=""><input type="text" style="width:200;" class="input" value="<%=xterXptLicVO.getLbNtfyTaxId() %>" name="lb_ntfy_tax_id2" dataformat="etc"  maxlength="20" value=""></td>
				</tr>				
			</table>
			<table class="search" border="0">
				<tr class="h23">
					<td border="1"><input type="text"  style="width:60;" class="input2" value="Brazil"></td>
				</tr>
				<tr class="h23">
					<td width="135">&nbsp;Shipper CNPJ</td>
					<td width=""><input type="text" style="width:200;" class="input" value="<%=xterXptLicVO.getBrShprTaxId() %>" name="br_shpr_tax_id2" dataformat="etc"  maxlength="14" value=""></td>
				</tr>
				<tr class="h23">
					<td width="135">&nbsp;Consignee CNPJ</td>
					<td width=""><input type="text" style="width:200;" class="input" value="<%=xterXptLicVO.getBrCneeTaxId() %>" name="br_cnee_tax_id2" dataformat="etc"  maxlength="14" value=""></td>
				</tr>
				<tr class="h23">
					<td width="135">&nbsp;Notify CNPJ</td>
					<td width=""><input type="text" style="width:200;" class="input" value="<%=xterXptLicVO.getBrNtfyTaxId() %>" name="br_ntfy_tax_id2" dataformat="etc"  maxlength="14" value=""></td>
				</tr>				
			</table>			
<%
if(krXptLicCnt > 0){
%>			
			<table class="search" border="0">
				<tr class="h23">
					<td border="1"><input type="text"  style="width:60;" class="input2" value="Korea"></td>
				</tr>
				<tr>
					<td width="500">
						<script language="javascript">ComSheetObject('div2sheet1');</script>
					</td>
				</tr>
			</table>
<%
}
%>			
	
<%
if(idXptLicCnt > 0){
%>			
			<table class="search" border="0">
				<tr class="h23">
					<td border="1"><input type="text"  style="width:60;" class="input2" value="Indonesia"></td>
				</tr>
				<tr>
					<td width="500">
						<script language="javascript">ComSheetObject('div8sheet2');</script>
					</td>
				</tr>
			</table>
<%
}
%>		
		</td></tr>
	</table>
</div>


<div id="innerPackage" style="position:absolute; visibility:hidden; z-index:1" style="margin-top:345px; margin-left:695px; height:108px; width:305px">
	<table cellspacing="1" cellpadding="0" bgcolor="#AAAAAA">
		<tr bgcolor="#D9E0EA"><td>		
			<table width="100%"  id="mainTable">
				<tr>
					<td width="300">
						<%
										if(xterInnerPackageVOsCnt > 0){
						%>
						<script language="javascript">ComSheetObject('sheet2');</script>
						<%
										}
						%>	
						
					</td>
				</tr>
			</table>
		</td></tr>
	</table>
</div>

<div id="poOther" style="position:absolute; visibility:hidden; z-index:1" style="margin-top:310px; margin-left:15px; height:235px; width:667px">	
	<table cellspacing="1" cellpadding="0" bgcolor="#AAAAAA">
		<tr bgcolor="#D9E0EA"><td>
			<table class="search" border="0">
				<tr class="h23">
					<td width="100">&nbsp;P/O No.</td>	
					<td width="90"><input type="text" style="width:100;" class="input" name="bkpo" maxlength="50" value=""></td>		
					<td class="stm" width="110"><input type="checkbox" value="" name='check_bkpo' class="trans" onClick="javascript:copyToDesc(this);">&nbsp;copy to desc </td>						
					<td width="100">&nbsp;L/C No.</td>	
					<td width="90"><input type="text" style="width:100;" class="input" name="lcno" maxlength="50" value=""></td>	
					<td width=""></td>		
					<td class="stm" width="110"><input type="checkbox" value="" name='check_lcno' class="trans" onClick="javascript:copyToDesc(this);">&nbsp;copy to desc </td>						
				</tr>
				<tr class="h23">
					<td width="">&nbsp;Invoice No.</td>	
					<td width=""><input type="text" style="width:100;" class="input" name="hinv" maxlength="50" value=""></td>		
					<td class="stm"><input type="checkbox" value="" name='check_hinv' class="trans" onClick="javascript:copyToDesc(this);">&nbsp;copy to desc </td>						
					<td width="">&nbsp;L/C Date</td>	
					<td width=""><input type="text" style="width:100;" class="input" name="lcdt" value="" maxlength="10" dataformat="ymd" style="ime-mode:disabled" caption="L/C Date"  ></td>
					<td width="">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btn_Calendar"></td>		
					<td class="stm"><input type="checkbox" value="" name='check_lcdt' class="trans" onClick="javascript:copyToDesc(this);">&nbsp;copy to desc </td>						
				</tr>
				<tr class="h23">
					<td width="">&nbsp;Department No.</td>	
					<td width=""><input type="text" style="width:100;" class="input" name="hpdp" maxlength="50" value=""></td>		
					<td class="stm"><input type="checkbox" value="" name='check_hpdp' class="trans" onClick="javascript:copyToDesc(this);">&nbsp;copy to desc </td>						
					<td width="">&nbsp;Other Ref. No.</td>	
					<td width=""><input type="text" style="width:100;" class="input" name="othr" maxlength="50" value=""></td>		
					<td width=""></td>	
					<td class="stm"><input type="checkbox" value="" name='check_othr' class="trans" onClick="javascript:copyToDesc(this);">&nbsp;copy to desc </td>	
				</tr> 
				</table>	       	
				<table class="search" border="0">
					<tr class="h23">
						<td width="220" valign="top">
							<table width="100%"  id="mainTable"> 
								<tr><td width="100%">
									<script language="javascript">ComSheetObject('div3sheet1');</script>
								</td></tr>
							</table>			
			       		</td>
			       		<td width="10"></td>
			       		<td width="" valign="top">
							<table width="100%"  id="mainTable"> 
								<tr><td width="100%">
									<script language="javascript">ComSheetObject('div3sheet2');</script>
								</td></tr>
							</table>			
							<table width="100%" class="button"> 
						       	<tr><td class="btn2_bg">
									<table border="0" cellpadding="0" cellspacing="0"><tr>
										<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td>
											<td class="btn2" name="btn_Po_Add">Row&nbsp;Add</td>
											<td class="btn2_right"></td>
											</tr>
										</table></td>
										<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td>
											<td class="btn2" name="btn_Po_Delete">Row Delete</td>
											<td class="btn2_right"></td>
											</tr>
										</table></td>
									</tr></table>
								</td></tr>
							</table>
						</td>							
			       		<td width="" valign="top">
							<table width="100%"  id="mainTable"> 
								<tr><td width="100%">
									<script language="javascript">ComSheetObject('div3sheet3');</script>
								</td></tr>
							</table>	
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</div>

<div id="poOther2" style="position:absolute; visibility:hidden; z-index:1" style="margin-top:<%=xterCntrPoNoVOsCnt > 0?"250":"395"%>px; margin-left:435px; height:255px; width:667px">	
	<table cellspacing="1" cellpadding="0" bgcolor="#AAAAAA">
		<tr bgcolor="#D9E0EA">
			<td>
				<table class="search" border="0">
					<tr class="h23">
						<td width="100">&nbsp;P/O No.</td>	
						<td width="90"><input type="text" style="width:100;" class="input2" name="bkpo2" maxlength="50" value="<%=xterMndVO == null ? "" :replaceNull(xterMndVO.getBkpo2())%>"></td>		
						<td class="stm" width="20"></td>
						<td width="100">&nbsp;L/C No.</td>	
						<td width="90"><input type="text" style="width:130;" class="input2" name="lcno2" maxlength="50" value="<%=xterMndVO == null ? "" :replaceNull(xterMndVO.getLcno2())%>"></td>	
						<td width=""></td>		
						<td class="stm" width="120"></td>						
					</tr>
					<tr class="h23">
						<td width="">&nbsp;Invoice No.</td>	
						<td width=""><input type="text" style="width:100;" class="input2" name="hinv2" maxlength="50" value="<%=xterMndVO == null ? "" :replaceNull(xterMndVO.getHinv2())%>"></td>								
						<td class="stm"></td>
						<td width="">&nbsp;L/C Date</td>	
						<td width=""><input type="text" style="width:100;" class="input2" name="lcdt2" value="<%=xterMndVO == null ? "" :replaceNull(xterMndVO.getLcdt2())%>" maxlength="10" dataformat="ymd" style="ime-mode:disabled" caption="L/C Date"  ></td>						
						<td class="stm"></td>						
						<td width=""></td>		
					</tr>
					<tr class="h23">
						<td width="">&nbsp;Department No.</td>	
						<td width=""><input type="text" style="width:100;" class="input2" name="hpdp2" maxlength="50" value=""></td>								
						<td class="stm"></td>	
						<td width="">&nbsp;Other Ref. No.</td>	
						<td width=""><input type="text" style="width:100;" class="input2" name="othr2" maxlength="50" value=""></td>	
						<td class="stm"></td>						
						<td width=""></td>		
					</tr> 
				</table>	       	
				<table class="search" border="0">
					<tr class="h23">
						<td width="220" valign="top">
							<table width="100%"  id="mainTable"> 
								<tr>
									<td width="100%">
									<%
									if(xterCntrPoNoVOsCnt > 0){
									%>
										<script language="javascript">ComSheetObject('div4sheet1');</script>
									<%} %>
									</td>
								</tr>
							</table>			
			       		</td>
			       		<td width="10"></td>
			       		<td width="320" valign="top">
							<table width="100%"  id="mainTable"> 
								<tr>
									<td width="100%">
									<%
									if(xterPoDtlVOsCnt > 0){
									%>
										<script language="javascript">ComSheetObject('div4sheet2');</script>
									<%} %>
									</td>
								</tr>
							</table>			
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</div>
<div id="blRider" style="position:absolute; visibility:hidden; z-index:1" style="margin-top:340px; margin-left:15px; height:255px; width:667px">	
	<table cellspacing="1" cellpadding="0" bgcolor="#AAAAAA">
		<tr bgcolor="#D9E0EA">
			<td>
				<table class="search" border="0" style="width:430;"> 
				<tr class="h23">
					<td width="45">&nbsp;Type</td>
					<td class="stm">
						<input type="radio" name='ridr_tp_cd' value="G" class="trans" onClick="fn_ridr_Tp_Change(this)" checked disabled>General &nbsp;&nbsp;
						<input type="radio" name='ridr_tp_cd' value="C" class="trans" onClick="fn_ridr_Tp_Change(this)" disabled>Certificate
					</td>
					</tr>
				</table>
							
				<!--  biz_1   (E) -->
			
				<!-- Grid_1 (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('div5sheet1');</script>
						</td>
					</tr>
				</table>				
				
				<!-- Grid_1 (E) -->	
			</td>
		</tr>
	</table>
</div>
<div id="blRider2" style="position:absolute; visibility:hidden; z-index:1" style="margin-top:<%=xterRqstNoVOsCnt > 0?"275":"462" %>px; margin-left:497px; height:255px; width:667px">	
	<table cellspacing="2" cellpadding="0" bgcolor="#AAAAAA">
		<tr bgcolor="#D9E0EA">
			<td>
				<table class="search" border="0" style="width:496px;"> 
				<tr class="h23">
					<td width="45">&nbsp;Type</td>
					<td class="stm">
						<input type="radio" name='ridr_tp_cd2' value="G" class="trans" onClick="fn_ridr_Tp_Change(this)" checked disabled>General &nbsp;&nbsp;
						<input type="radio" name='ridr_tp_cd2' value="C" class="trans" onClick="fn_ridr_Tp_Change(this)" disabled>Certificate
					</td>
					</tr>
				</table>
							
				<!--  biz_1   (E) -->
			
				<!-- Grid_1 (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
									<%
									if(xterRqstNoVOsCnt > 0){
									%>
							<script language="javascript">ComSheetObject('div6sheet1');</script>
									<%} %>
						</td>
					</tr>
				</table>				
				
				<!-- Grid_1 (E) -->	
			</td>
		</tr>
	</table>
</div>
<div id="blSurcharge" style="position:absolute; visibility:hidden; z-index:1" style="margin-top:360px; margin-left:15px; height:400px; width:667px">	
	<table cellspacing="1" cellpadding="0" bgcolor="#AAAAAA">
		<tr bgcolor="#D9E0EA">
			<td>
				<table class="search" border="0" style="width:250;"> 
				<tr class="h23">
					<td width="100"> ALPS Wharfage</td>
				</tr>
				</table>
							
				<!--  biz_1   (E) -->
			
				<!-- Grid_1 (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('div7sheet1');</script>
						</td>
					</tr>
				</table>				
				
				<!-- Grid_1 (E) -->	
			</td>
		</tr>
	</table>
</div>
<div id="blSurcharge2" style="position:absolute; visibility:hidden; z-index:1" style="margin-top:390px; margin-left:500px; height:200px; width:400px">	
	<table cellspacing="1" cellpadding="0" bgcolor="#AAAAAA">
		<tr bgcolor="#D9E0EA">
			<td>
				<table class="search" border="0" style="width:250;"> 
				<tr class="h23">
					<td width="60"> Wharfage</td>
				</tr>
				</table>
							
				<!--  biz_1   (E) -->
			
				<!-- Grid_1 (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
									<%
									if(xterKrWhfBlExptInfoVOsCnt > 0){
									%>
							<script language="javascript">ComSheetObject('div7sheet2');</script>
									<%} %>
						</td>
					</tr>
				</table>				
				
				<!-- Grid_1 (E) -->	
			</td>
		</tr>
	</table>
</div>
<div id="shipId" style="position:absolute; visibility:hidden; z-index:1" style="margin-top:360px; margin-left:195px; height:400px; width:400px">	
	<table cellspacing="1" cellpadding="0" bgcolor="#AAAAAA">
		<tr bgcolor="#D9E0EA">
			<td>
				<table class="search" border="0" style="width:250;"> 
				<tr class="h23">
					<td width="100"> Ship ID</td>
				</tr>
				</table>
							
				<!--  biz_1   (E) -->
			
				<!-- Grid_1 (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('div9sheet1');</script>
						</td>
					</tr>
				</table>				
				
				<!-- Grid_1 (E) -->	
			</td>
		</tr>
	</table>
</div>
<div id="shipId2" style="position:absolute; visibility:hidden; z-index:1" style="margin-top:<%=xterRefDtlVOsCnt > 0?"300":"485" %>px; margin-left:700px; height:400px; width:400px">	
	<table cellspacing="1" cellpadding="0" bgcolor="#AAAAAA">
		<tr bgcolor="#D9E0EA">
			<td>
				<table class="search" border="0" style="width:250;"> 
				<tr class="h23">
					<td width="60"> Ship ID</td>
				</tr>
				</table>
							
				<!--  biz_1   (E) -->
			
				<!-- Grid_1 (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
									<%
									if(xterRefDtlVOsCnt > 0){
									%>
							<script language="javascript">ComSheetObject('div9sheet2');</script>
									<%} %>
						</td>
					</tr>
				</table>				
				
				<!-- Grid_1 (E) -->	
			</td>
		</tr>
	</table>
</div>
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;padding-left:0;">	
	<tr><td valign="top">
		<!--biz page (S)-->
		<!-- Grid BG Box  (S) -->
     	<table class="search" id="mainTable" style="width:995;height:600;">
       		<tr><td class="bg" valign="top">
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
							</table></td>
							<td width="240" align="right"><table width="150"  border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn_cancelcopydata">Cancel&nbsp;Copy&nbsp;Data</td>
								<td class="btn2_right"></td>
								</tr>
							</table></td>
						</tr>
					</table>
					<table class="search_ssm" border="0" style="width:480;">
					<tr class="h23"><td>
						<table class="search" border="0">
							<tr class="h23">
								<td width="420" colspan="4">Booking No.&nbsp;&nbsp;<input type="text" name="bkg_no" style="width:105;" class="input2" value="<%=StringUtil.xssFilter(request.getParameter("bkg_no"))%>" readOnly></td>
							</tr>
						</table>
						<table class="search" border="0">
							<tr class="h23">
								<td width="270">Mark & NOS<br><textarea name="mk_desc" style="font-family:Courier New; font-size:15px; text-indent:0px; overflow-x:hidden;overflow-y:scroll;" wrap="hard" dataformat="etc" cols="22" rows="7" class="textarea" ><%=alpsMndVO == null ? "" :replaceNull(alpsMndVO.getMkDesc())%></textarea></td>
								<td valign="top"><br>
									<table class="search" border="0">
										<tr class="h23">
											<td width="50">Package</td>
											<td><input type="text" name="pck_qty" style="width:80;text-align:right" maxlength="9" dataformat="int" class="input" value="<%=alpsMndVO == null ? "" :replaceNull(alpsMndVO.getPckQty())%>">
											  <input type="text" name="pck_tp_cd" style="width:30;text-align:left" maxlength="2" dataformat="engup" class="input" value="<%=alpsMndVO == null ? "" :replaceNull(alpsMndVO.getPckTpCd())%>">
											  <img src="img/btns_search.gif" name="btn_find_package" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
											  <input type="hidden" name="pck_nm" value="<%=alpsMndVO == null ? "" :replaceNull(alpsMndVO.getPckNm())%>">
											</td>
										</tr>
										<tr class="h23">
											<td>Weight</td>
											<td><input type="text" name="act_wgt" style="width:80;text-align:right" maxlength="12" onBlur="makeComma2(this)" dataformat="float" pointcount="3" class="input" value="<%=alpsMndVO == null ? "" :replaceNull(alpsMndVO.getActWgt())%>">
											<%=HTMLUtil.getComboString("wgt_ut_cd", "width:55;", "", "",alpsMndVO == null ? "" :replaceNull(alpsMndVO.getWgtUtCd()), "", wgt_cd)%>
											<%//=HTMLUtil.getComboString("wgt_ut_cd", "width:55;", "", "", "", "", wgt_cd)%>
											</td>
										</tr>
										<tr class="h23">
											<td></td>
											<td align="right">(Print<input type="checkbox" name="act_wgt_prn_flg" class="trans" value="Y" <%=alpsMndVO == null ? "" :replaceNull(alpsMndVO.getActWgtPrnFlg()).equals("Y") ? "checked=\"checked\"" : ""%>>)</td>
										</tr>
										<tr class="h23">
											<td>Measure</td>
											<td><input type="text" name="meas_qty" style="width:80;text-align:right" maxlength="12" onBlur="makeComma2(this)" dataformat="float" pointcount="3" class="input" value="<%=alpsMndVO == null ? "" :replaceNull(alpsMndVO.getMeasQty())%>">
											<%=HTMLUtil.getComboString("meas_ut_cd", "width:55;", "", "",alpsMndVO == null ? "" :replaceNull(alpsMndVO.getMeasUtCd()), "", meas_cd)%>
											<%//=HTMLUtil.getComboString("meas_ut_cd", "width:55;", "", "", "", "", meas_cd)%>
											</td>
										</tr>										
										<tr class="h23">
											<!--td colspan="2">Frt Term&nbsp;<script language="javascript">ComComboObject('frt_term_cd', 2, 80, 1, 0, 1)</script-->
											<td>Frt Term</td>
											<td><input type="text" name="tmp_frt_term_cd" style="width:80;text-align:left" class="input2" readOnly></td>											
										</tr>
									</table>
								</td>
							</tr>
						</table>
						<table class="search" border="0">
							<tr class="h23">
								<td colspan="2">Description of Goods</td>
							</tr>
							<tr class="h23">
								<td colspan="2">
								<table width="100%">
									<tr>
									<td style="width:100px">No. of PKG/CNTR</td>
									<td><input type="text" name="pck_cmdt_desc" class="input" style="ime-mode:disabled;width:100%" dataformat="etc" value="<%=alpsMndVO == null ? "" :replaceNull(alpsMndVO.getPckCmdtDesc())%>"></td>
									</tr>
									<tr class="tr2_head">
									<td align="center">
										<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left" style="border:0; padding:0;"></td>
											<td class="btn2" style="border:0; padding:0;" name="btn_copy">Copy</td>
											<td class="btn2_right" style="border:0; padding:0;"></td></tr>
										</table>
									</td>
									<td><input type="text" name="cntr_cmdt_desc" class="input" style="ime-mode:disabled;width:100%;" dataformat="etc" value="<%=alpsMndVO == null ? "" :replaceNull(alpsMndVO.getCntrCmdtDesc())%>"></td>
									</tr>
								</table>
								</td>
							</tr>

							<tr class="h23">
								<td colspan="2" align="right">
								<textarea name="dg_cmdt_desc" cols="49" rows="6" style="font-family:Courier New;font-size:15px; text-indent:0px; overflow-x:hidden;overflow-y:scroll" wrap="hard" class="textarea" dataformat="etc"><%=alpsMndVO == null ? "" :replaceNull(alpsMndVO.getDgCmdtDesc())%></textarea>
								</td>
							</tr>
							<tr class="h23">
								<td colspan="2">Clause Lock</td>
							</tr>	
							<tr class="h23">
								<td valign="top" colspan="2">
									<div id="cluzLock">
									<table width="100%"  style="z-index:-1"> 
										<tr><td width="100%">
											<script language="javascript">ComSheetObject('div10sheet1');</script>
										</td></tr>
									</table>	
									</div>
									<table width="100%" class="button"> 
								       	<tr>
								       		<td class="btn2_bg">								       		
											<table border="0" cellpadding="0" cellspacing="0" width="100%">
												<tr>
												<td style="float:left">This clause lock is reserved for WEB SI auto upload project.</td>
												<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr><td class="btn2_left"></td>
													<td class="btn2" name="btn_Clz_Add">Add</td>
													<td class="btn2_right"></td>
													</tr>
												</table></td>
												<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr><td class="btn2_left"></td>
													<td class="btn2" name="btn_Clz_Delete">Delete</td>
													<td class="btn2_right"></td>
													</tr>
												</table></td>
												</tr></table>
											</td>
										</tr>
									</table>		
					       		</td>
			       			</tr>
							<tr class="h23">
								<td colspan="2">Customs Description</td>
							</tr>							
							<tr class="h23">
								<td width="5"></td>
								<td width="465" align="right"><input type="text" name="cstms_desc" style="width:465;" dataformat="etc" class="input1" value="<%=alpsMndVO == null ? "" :replaceNull(alpsMndVO.getCstmsDesc())%>"></td>
							</tr>							
							<tr class="h23">
								<td colspan="2">Total No. of PKG/CNTR in Word</td>
							</tr>							
							<tr class="h23">
								<td width="5"></td>
								<td width="465"><input type="text" name="ttl_pck_desc" class="input" style="ime-mode:disabled;width:100%" dataformat="etc" value = "<%=alpsMndVO == null ? "" :replaceNull(alpsMndVO.getTtlPckDesc())%>">
								</td>
							</tr>
						</table>
						<table class="search" border="0" >
							<tr class="h23">
								<td>
									<table width="180" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left" style="border:0; padding:0;"></td>
										<td class="btn2" style="border:0; padding:0;" name="btn_ExportInfo">Export Information</td>
										<td class="btn2_right" style="border:0; padding:0;"></td></tr>
									</table>
								</td>
								<td>
									<table width="150" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left" style="border:0; padding:0;"></td>
										<td class="btn2" style="border:0; padding:0;" name="btn_POOtherNo">P/O Other(s) No.</td>
										<td class="btn2_right" style="border:0; padding:0;"></td></tr>
									</table>
								</td>
								<td>
									<table width="150" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left" style="border:0; padding:0;"></td>
										<td class="btn2" style="border:0; padding:0;" name="btn_BLRider">B/L Rider</td>
										<td class="btn2_right" style="border:0; padding:0;"></td></tr>
									</table>
								</td>
							</tr>
						</table>
						<table class="search" border="0">
							<tr class="h23">
								<td>
									<table width="180" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left" style="border:0; padding:0;"></td>
										<td class="btn2" style="border:0; padding:0;" name="btn_Surcharge">Surcharge Adjustment</td>
										<td class="btn2_right" style="border:0; padding:0;"></td></tr>
									</table>
								</td>
								<td>
									<table width="150" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left" style="border:0; padding:0;"></td>
										<td class="btn2" style="border:0; padding:0;" name="btn_RefDtl">Ship ID</td>
										<td class="btn2_right" style="border:0; padding:0;"></td></tr>
									</table>
								</td>
								<td><table width="150"></table></td>
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
								<td width="480">Request No.&nbsp;<input type="text" name="rqst_no" style="width:105;" class="input2" value="<%=StringUtil.xssFilter(request.getParameter("rqst_no"))%>" readOnly></td>
								<td colspan="2" align="right">
									<table width="150"  border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td>
										<td class="btn2" name="btn_datacopyfromcm">Copy from C/M</td>
										<td class="btn2_right"></td>
										</tr>
									</table>
								</td>							
							</tr>
						</table>
						<table class="search" border="0">
							<tr class="h23">
								<td width="270">Mark & NOS<br><textarea name="mk_desc2" style="font-family:Courier New; font-size:15px; text-indent:0px;" wrap="hard" cols="22" rows="7" class="textarea2" readOnly><%=xterMndVO == null ? "" :replaceNull(xterMndVO.getMkDesc())%></textarea></td>
								<td valign="top"><br>
									<table class="search" border="0">
										<tr class="h23">
											<td>Package</td>
											<td><input type="text" name="pck_qty2" style="width:80;text-align:right" class="input2" value="<%=xterMndVO == null ? "" :replaceNull(xterMndVO.getPckQty())%>" readOnly>&nbsp;<input type="text" name="pck_tp_cd2" style="width:52;" class="input2" value="<%=xterMndVO == null ? "" :replaceNull(xterMndVO.getPckTpCd())%>" readOnly></td>
										</tr>
										<tr class="h23">
											<td>Weight</td>
											<td><input type="text" name="act_wgt2" style="width:80;text-align:right" class="input2" value="<%=xterMndVO == null ? "" :replaceNull(xterMndVO.getActWgt())%>" readOnly>&nbsp;<input type="text" name="wgt_ut_cd2" style="width:52;" class="input2" value="<%=xterMndVO == null ? "" :replaceNull(xterMndVO.getWgtUtCd())%>" readOnly></td>
										</tr>
										<tr class="h23"><td></td>
										</tr>
										<tr class="h23">
											<td>Measure</td>
											<td><input type="text" name="meas_qty2" style="width:80;text-align:right" class="input2" value="<%=xterMndVO == null ? "" :replaceNull(xterMndVO.getMeasQty())%>" readOnly>&nbsp;<input type="text" name="meas_ut_cd2" style="width:52;" class="input2" value="<%=xterMndVO == null ? "" :replaceNull(xterMndVO.getMeasUtCd())%>" readOnly></td>
										</tr>
										<tr class="h23">
											<td>Frt.Term</td>
											<td><input type="text" name="frt_term_cd2" style="width:80;text-align:left" class="input2" readOnly></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
						<table class="search" border="0">
							<tr class="h23">
								<td>Description of Goods</td>
							</tr>
							<tr class="h23" height="500">
								<td><textarea name="dg_cmdt_desc2" cols="49" rows="7" style="font-family:Courier New; font-size:15px; text-indent:0px;" wrap="hard" class="textarea2" readOnly><%=xterMndVO == null ? "" :replaceNull(xterMndVO.getCmdtDesc())%></textarea></td>
							</tr>
						</table>
						<table class="search" border="0"><br><br><br>
							<tr class="h23">
								<td colspan="2">Customs Description</td>
							</tr>							
							<tr class="h23">
								<td width="5"></td>
								<td width="465" align="right"><input type="text" name="cstms_desc2" style="width:465;" dataformat="etc" class="input1" value="<%=xterMndVO == null ? "" :replaceNull(xterMndVO.getCstmsDesc())%>" readOnly></td>
							</tr>	
						</table>
						<br><br>
						<table class="search" border="0">
							<tr class="h23"><td>
								<td><table width="200" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left" style="border:0; padding:0;"></td>
									<td class="btn2" style="border:0; padding:0;" name="btn_MiscInfo2" id="btn_MiscInfo2">Misc. Information</td>
									<td class="btn2_right" style="border:0; padding:0;"></td></tr>
								</table></td>
								<td><table width="150" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left" style="border:0; padding:0;"></td>
									<td class="btn2" style="border:0; padding:0;" name="btn_InnerPackage2" id="btn_InnerPackage2">Inner Package</td>
									<td class="btn2_right" style="border:0; padding:0;"></td></tr>
								</table></td>
								<td><table width="150"></table></td>
							</td></tr>
						</table>
						<table class="search" border="0">
							<tr class="h23">
								<td><table width="200" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left" style="border:0; padding:0;"></td>
									<td class="btn2" style="border:0; padding:0;" name="btn_ExportInfo2" id="btn_ExportInfo2">Export Information</td>
									<td class="btn2_right" style="border:0; padding:0;"></td></tr>
								</table></td>
								<td><table width="150" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left" style="border:0; padding:0;"></td>
									<td class="btn2" style="border:0; padding:0;" name="btn_POOtherNo2" id="btn_POOtherNo2">P/O Other(s) No.</td>
									<td class="btn2_right" style="border:0; padding:0;"></td></tr>
								</table></td>
								<td><table width="150" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left" style="border:0; padding:0;"></td>
									<td class="btn2" style="border:0; padding:0;" name="btn_BLRider2" id="btn_BLRider2">B/L Rider</td>
									<td class="btn2_right" style="border:0; padding:0;"></td></tr>
								</table></td>
							</tr>
						</table>
						<table class="search" border="0">
							<tr class="h23">
								<td><table width="200" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left" style="border:0; padding:0;"></td>
									<td class="btn2" style="border:0; padding:0;" name="btn_Surcharge2" id="btn_Surcharge2">Surcharge Adjustment</td>
									<td class="btn2_right" style="border:0; padding:0;"></td></tr>
								</table></td>
								<td><table width="150" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left" style="border:0; padding:0;"></td>
									<td class="btn2" style="border:0; padding:0;" name="btn_RefDtl2" id="btn_RefDtl2">Ship ID</td>
									<td class="btn2_right" style="border:0; padding:0;"></td></tr>
								</table></td>
								<td><table width="150"></table></td>
							</tr>
						</table>						
					<!--  biz_2  (E) -->
					</td></tr>
					</table>
					<!-- Grid BG Box  (S) -->
				<!--biz page (E)-->
				</td></tr>
				</table>
				<!--Button (S) -->
				<!-- <table width="980" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
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
					</table></td>
				</tr>
				</table> -->
	   			<!--Button (E) -->	
		<table width="1000"  id="mainTable">
			<tr>
				<td width="100%">
					<script language="javascript">ComSheetObject('sheet1');</script>
				</td>
			</tr>
		</table>	
			</td></tr>
		</table>
	</td></tr>
</table>																						

</form>
<iframe name="hiddenFrame" style="visibility:hiddden" height="0" width="0"></iframe>
</body>
</html>
<%!    public String replaceNull(String str) {
        return (str==null)?"":str;
    }%>