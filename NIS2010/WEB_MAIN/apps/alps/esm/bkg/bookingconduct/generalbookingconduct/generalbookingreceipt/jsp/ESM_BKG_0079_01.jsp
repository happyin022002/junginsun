<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0079_01.jsp
*@FileTitle : BKG Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.14
*@LastModifier : KimByungKyu
*@LastVersion : 1.0
* 2009.05.14 KimByungKyu
* 1.0 Creation
===============================================================================
 * History
 * 2010.09.13 이일민 [CHM-201005276-01] ALPS-[BKG/DOC]주요UI버턴-단축키 기능개발
 * 2010.11.04 김영철 [] Booking Creation / Update / Cancel시, Vessel Operation 모듈의 Final CBF 생성 여부를 체크해서 경고 메시지
 * 2011.04.19 이일민 [CHM-201110187] BKG 조회 및 변경시 ROUTE 정보 비교 로직 보완
 * 2011.05.11 이일민 [CHM-201110114] BKG Charge Screen 상 운임회수 점소 pre-paid office was auto-changed as booking office again
 * 2011.10.10 전성진 [CHM-201111889] T.VVD 변경시, Post VVD 변경 및 관련 Alert Message 처리 요청.
 * 2011.10.20 정선용 [CHM-201113441-01] BKG 화면의 C.OFC 및 C.REP SELECT POPUP 추가 요청
 * 2011.11.01 조원주 [CHM-201114224-01][BKG_Charge( RAS )]bkg Main & e-Booking화면에서 Pricing 계약 조회시 Popup 수정 요청
 * 2012.01.05 금병주 [CHM-201115389-01] bkg 화면에 Port skip일 경우 표기 요청
 * 2012.10.05 조정민 [CHM-201219854] [BKG] BKG 생성시 S/C 에 운임 조회 후 부재시 G/W 메일 SALES REP/PRICING STAFF 전송 기능 추가
 * 2012.10.29 조정민 [CHM-201220826] [BKG] BKG CRAETION 화면에 기존 부킹 조회및 편집 후 신규 부킹 생성 가능토록 Copy버튼 추가 (버튼명 사후결정)
 * 2012.11.01 조정민 [CHM-201220905] [BKG] 미주 Add S/I Status in DPCS in BKG Main screen  보완 요청
 * 2012.11.29 조정민 [CHM-201221300] TAA 계약 존재시 bkg 생성및 변경시점 Rate 유무 체크 및 G/W 연계 요청
 * 2013.01.07 조정민 [CHM-201221997] Split 02-Email 접수 Draft B/L Correction 분류 시스템 개발
 * 2013.04.04 류대영 [CHM-201323757] T/S 화물에 대한  CLL 마감 이후 CLOSING 기능 로직 변경
 * 2014.07.18 문동선 [CHM-201431092] SOC by Shipping Lines flag 추가 및 CCAM 전송 block
 * 2014.07.25 문동선 [CHM-201430707] FumigationHide liner 버튼 및 팝업창 구현, BST 조회 로직
 * 2014.08.11 문동선 [CHM-201431490] Outbound B/L issue 화면에서 KR 화주 대상 DEM/DET OTS 보여주기 기능 요청
 * 2014.12.29 문동선 [CHM-201432358] Booking에 정보 추가 요청
 * 2015.03.30 양동훈 STATUS 옆 돋보기 팝업 추가(ESTIMATED CMPB화면)
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.framework.core.controller.util.WebKeys"%>
<%@ page import="com.hanjin.framework.core.view.template.Screen"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.event.EsmBkg007901Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.core.controller.DefaultViewAdapter"%>

<%
	EsmBkg007901Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String strUsr_id	= "";
	String strUsr_nm	= "";
	String strUsr_ofc   = "";
	String strUsr_tel   = "";
	String strUsr_eml   = "";
	String strUsr_info  = "";
	String strUsr_cntCd = "";
	String showUsrInfo  = "";
	String StrRhq_ofc_cd= "";
	
	String bkgNo = "";
	String isInquiry = "N";	
	String caNewCreationFlag = "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.GeneralBookingConduct.GeneralBookingReceipt");
	
	String sXml = null;
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();
		strUsr_tel = account.getMphn_no();
		strUsr_eml = account.getUsr_eml();
		strUsr_cntCd = account.getCnt_cd();
		StrRhq_ofc_cd = account.getRhq_ofc_cd();
		//strUsr_info = strUsr_nm + "&#13" + strUsr_ofc + "&#13" + strUsr_tel + "&#13" + strUsr_eml;
		strUsr_info = "ID : " + strUsr_nm + "<br>BKG OFC : " + strUsr_ofc + "<br>TEL : " + strUsr_tel + "<br>E-mail : " + strUsr_eml;
		
		event = (EsmBkg007901Event)request.getAttribute("Event");
		
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		bkgNo  = JSPUtil.getParameter(request, "bkg_no");
		
		Screen screen = (Screen) request.getAttribute(WebKeys.CURRENT_SCREEN);
		//inquiry mode
		if (screen.getName().indexOf("Q") >= 0){
			isInquiry = "Y";
		} else {
			isInquiry = "N";			
		}
		
		//ca new creation
		if (screen.getName().indexOf("C") >= 0){
			caNewCreationFlag = "Y";
		} else {
			caNewCreationFlag = "N";
		}
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		DefaultViewAdapter adapter = new DefaultViewAdapter();
		sXml = adapter.makeXML(request, response);		
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>BKG Creation</title>
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
<input type="hidden" name="isInquiry" value="<%=isInquiry%>">
<input type="hidden" name="sXml" value="<%=JSPUtil.replace(sXml, "\"", "&quot;")%>">
<input type="hidden" name="usr_ofc_cd" value="<%=strUsr_ofc%>">
<!-- Groupmail시 반영될 Hidden --> 
<input type="hidden" name="gw_subject">
<input type="hidden" name="gw_contents">
<input type="hidden" name="gw_template" value="ESM_BKG_COMM_01T.html">
<input type="hidden" name="gw_args" value="reqcontents;">
<!-- 개발자 작업	-->
<!--TAB BKG Creation (S) -->
<%if("Y".equals(caNewCreationFlag)){ %>
<!--Page Title, Historical (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"> Booking Creation After BDR </td></tr>
	</table>
<%} %>
		
		<div id="showSalesApproval" style="position: absolute; display: none;" style="margin-top:295px;margin-left:645px;height:100px;">
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
		
		<!-- Grid BG Box  (S) -->
     	<table class="search"  style="width:100%;">
       	<tr><td class="bg">
			<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="50">BKG No.</td>
					<td width="130"><input type="text" name="bkg_no" maxlength=13 style="width:103;" class="input" value="<%= bkgNo%>" style="ime-mode:disabled"  dataformat="engupnum" tabindex=1>
											<img class="cursor" src="img/btns_inquiry.gif" width="19" height="20" border="0" align="absmiddle" name="btn_splitPop">
					</td>
					<td width="70"><input type="checkbox" name="mnl_bkg_no_flg" value=""  class="trans"  tabindex=2>Manual</td>
					<td width="40" style="color:blue;"><div style="display:none"  id="split_flg"><input type="text" style="width:35;" name ="split_info" class="transgray" readOnly></div></td>
					<td width="138"><input type="checkbox" name="edi_hld_flg" value="Y"  class="trans" >Auto EDI Hold</td>
					<td width="47">B/L No.</td>
					<td width="110"><input type="text" name="bl_no" maxlength=13 style="width:105;" class="input" style="ime-mode:disabled"  dataformat="engupnum"   tabindex=3></td>
					<td width="30"><div style="display:none"  id="org_bl"><img class="cursor" src="img/btns_inquiry.gif" width="19" height="20" border="0" align="absmiddle" name="btn_OrgBlPop"></div>
					</td>
					<td width="40"><input type="checkbox" name="si_flg" value="Y" class="trans"  tabindex=4>SI</td>
					<td width="60"><input type="checkbox" name="bdr_flg" value="Y" class="transgray" disabled>BDR</td>
					<td width="45">Status</td>
					<td width="20"><input type="text" name="bkg_sts_cd" style="width:20;" class="input2" value="" readonly></td>
					<td width="20" onmousemove="noratemsgmove();" onmouseover='noratemsgset("No Rate");return true;'  onmouseout="noratemsghide();return true;"><input type="text" name="non_rt_sts_cd" style="width:20;" class="input2" value="" readonly></td>
					<td width="20"><input type="text" name="aloc_sts_cd" style="width:20;" class="input2" value="" readonly></td>
					<td width=""><img class="cursor" src="img/btns_search.gif" name="btn_CMPB_popup" border="0" style="width:20;margin-left: 2.5;visibility:hidden;"></td>
					<td style="color:#ff0000;" width="" align="right"><div id="wait_rsn"></div></td></tr>
				</table>
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
				<td width="385" valign="top">
						<table class="search_sm2" border="0" style="width:100%;"> 
						<tr class="h23">
						<td>
							<table class="search" border="0" style="width:100%;"> 
								<tr class="h23">
									<td width="45">T/VVD</td>
									<td width="122"><input type="text" name="bkg_trunk_vvd" maxlength=9 style="width:80;" class="input" value="" style="ime-mode:disabled"  dataformat="engupnum"  tabindex=11>
													<img src="img/btns_search.gif" name='btn_0019Pop' width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
									<td ><table width="110" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td>
										<td class="btn2" name="btn_t1RouteDetail" id="btn_t1RouteDetail">Route Detail</td>
										<td class="btn2_right"></td>
										</tr>
									</table></td>
									<td><table width="85" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td>
										<td class="btn2" name="btn_allocation" id="">Allocation</td>
										<td class="btn2_right"></td>
										</tr>
									</table></td>
								</tr>
							</table>
							<table class="search" border="0" style="width:100%;"> 
								<tr class="h23">
									<td width="26">POR</td>
									<td width="124"><input type="text" name="bkg_por_cd" style="width:47;" class="input1" value="" maxlength=5 style="ime-mode:disabled"  dataformat="engupnum" tabindex=12>
													<input type="text" name="bkg_por_yd_cd" style="width:25;" class="input" value="" maxlength=2 style="ime-mode:disabled"  dataformat="engupnum" tabindex=13>
													<img src="img/btns_search.gif" name="btn_0083PorPop" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
									<td width="26">POL</td>
									<td width="122"><input type="text" name="bkg_pol_cd" style="width:47;" class="input1" value="" maxlength=5 style="ime-mode:disabled"  dataformat="engupnum" tabindex=14>
													<input type="text" name="bkg_pol_yd_cd" style="width:25;" class="input" value="" maxlength=2 style="ime-mode:disabled"  dataformat="engupnum" tabindex=15>
													<img src="img/btns_search.gif" name="btn_0083PolPop" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
									<td width="" rowspan="2">
										
										<table class="grid2" border="0" style="width:90;"> 
										<tr class="tr2_head">
											<td colspan="2">R/D Term</td>
										</tr>
										<tr class="h23">
											<td width="45" ><script language="javascript" >ComComboObject('rcv_term_cd', 2, 40, 1, 0, 2)</script>
											<!-- select name="rcv_term_cd" style="width:100%;"><option value="0" selected>Y-CY</option><option value="1" selected>D-Door</option><option value="1" selected>S-CFS</option><option value="1" selected>H-C' Haul on CY</option><option value="1" selected>T-Tackle</option><option value="1" selected>I-Free In</option><option value="1" selected>M-Mixed</option></select--></td>
											<td width="45"><script language="javascript" >ComComboObject('de_term_cd', 2, 40, 1, 0, 2)</script><!-- select name="de_term_cd" style="width:100%;"><option value="0" selected>Y-CY</option><option value="1" selected>D-Door</option><option value="1" selected>S-CFS</option><option value="1" selected>H-C' Haul on CY</option><option value="1" selected>T-Tackle</option><option value="1" selected>I-Free In</option><option value="1" selected>M-Mixed</option></select--></td>
										</tr>
										</table>
									</td>
								</tr>
							
								<tr class="h23">
									<td width="26">POD</td>
									<td width="124"><input type="text" name="bkg_pod_cd" style="width:47;" class="input" value="" maxlength=5 style="ime-mode:disabled"  dataformat="engupnum" tabindex=16>
													<input type="text" name="bkg_pod_yd_cd" style="width:25;" class="input" value="" maxlength=2 style="ime-mode:disabled"  dataformat="engupnum" tabindex=17>
													<img src="img/btns_search.gif" name="btn_0083PodPop" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
									<td width="26">DEL</td>
									<td width=""><input type="text" name="bkg_del_cd" style="width:47;" class="input1" value="" maxlength=5 style="ime-mode:disabled"  dataformat="engupnum" tabindex=18>
												 <input type="text" name="bkg_del_yd_cd" style="width:25;" class="input" value="" maxlength=2 style="ime-mode:disabled"  dataformat="engupnum" tabindex=19>
												 <img src="img/btns_search.gif" name="btn_0083DelPop" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
								</tr>
							</table>
							
							<table class="search" border="0" style="width:100%;"> 
								<tr class="h23">
									<td width="26">Pre</td>
									<td width="165"><input type="text" name="pre_rly_port_cd" style="width:47;" class="input2" value="" readonly tabindex=-1>&nbsp;<input type="text" name="pre_rly_port_yd_cd" style="width:25;" class="input2" value="" readonly tabindex=-1>&nbsp;<input type="text" name="pre_vvd_cd" style="width:77;" class="input2" value="" readonly tabindex=-1></td>
									<td width="30">Post</td>
									<td width=""><input type="text" name="pst_rly_port_cd"  style="width:47;" class="input2" value="" readonly tabindex=-1>&nbsp;<input type="text" name="pst_rly_port_yd_cd" style="width:25;" class="input2" value="" readonly tabindex=-1>&nbsp;<input type="text" name="pst_vvd_cd" style="width:70;" class="input2" value="" readonly tabindex=-1></td>
								</tr>
							</table>
						</td>
						</tr>
						</table>
					</td>
					<td width="9"></td>
					<td width="" valign="top">
						<table class="search_sm2" border="0" style="width:100%;"> 
						<tr class="h23">
						<td>
							<table class="search" border="0" style="width:100%;"> 
								<tr class="h23">
									<td width="37">SHPR</td>
									<td width="290"><input type="text" name="s_cust_cnt_cd" style="width:21;" class="input1" value="" maxlength=2 style="ime-mode:disabled"  dataformat="engup" tabindex=31>
													<input type="text" name="s_cust_seq" style="width:50;" class="input1" value="" maxlength=6 style="ime-mode:disabled"  dataformat="int" tabindex=32>
													<input type="text" name="s_cust_nm" style="width:180;" class="input2" value="" readonly tabindex=-1>
													<img src="img/btns_search.gif" name="btn_0652ShprPop" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
									<td width="">Filer</td>
									<td width=""><input type="text" name="" style="width:21;" class="input2" value="US" readonly  tabindex=-1>&nbsp;
												 <script language="javascript" >ComComboObject('usa_cstms_file_cd', 2, 35, 1, 0, 2)</script>&nbsp;													  
												 <input type="text" style="width:21;" class="input2" value="CA" readonly  tabindex=-1>&nbsp;
												 <script language="javascript" >ComComboObject('cnd_cstms_file_cd', 2, 35, 1, 0, 2)</script>
 									</td>
									<td width="">SCAC</td>
									<td width=""><input type="text" name="scac_cd" style="width:33;" class="input" value="" maxlength=4 style="ime-mode:disabled"  dataformat="etc" tabindex=37>
													  <img src="img/btns_search.gif" name="btn_0744Pop" width="19" height="20" alt="" border="0" align="absmiddle"  class="cursor"></td>
								</tr>
							</table>
							<table class="search" border="0" style="width:100%;"> 
								<tr class="h23">
									<td width="37">FWDR</td>
									<td width="289"><input type="text"  name="f_cust_cnt_cd" style="width:21;" class="input1" value="" maxlength=2 style="ime-mode:disabled"  dataformat="engup" tabindex=33>
													<input type="text"  name="f_cust_seq" style="width:50;" class="input1" value="" maxlength=6 style="ime-mode:disabled"  dataformat="int" tabindex=34>
													<input type="text" name="f_cust_nm" style="width:180;" class="input2" value="" readonly  tabindex=-1>
													<img src="img/btns_search.gif" name="btn_0652FwdrPop"  width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
									<td width="87">A/Cust
													<img src="img/btns_search.gif" name="btn_t1Sa0190" width="19" height="20" alt="" border="0" style="border:2 solid #F3F2F8" align="absmiddle" class="cursor"><input type="text" name=act_cust_list_exist_flg style="width:16;text-align:center;" class="input2" value="" readonly>
													</td>
									<td width="53" align=right><a href="javascript:comBkgCallPopEsmPri0087();">S/C No.</a></td>
									<td width=""><input type="text" name="sc_no" style="width:85;" class="input" value="" maxlength=9 style="ime-mode:disabled"  dataformat="engupnum" tabindex=38>
												 <!-- input type="text" name="sc_no1" style="width:30;" class="input" value="" maxlength=3 style="ime-mode:disabled"  dataformat="engup" tabindex=38>
												 <input type="text" name="sc_no2" style="width:75;" class="input" value="" maxlength=6 dataformat="int" tabindex=39-->
											     <img src="img/btns_search.gif" name="btn_ScNo" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>															

								</tr>
							</table>
							<table class="search" border="0" style="width:100%;"> 
								<tr class="h23">
									<td width="37">CNEE</td>
									<td width="284"><input type="text" name="c_cust_cnt_cd" style="width:21;" class="input" value="" maxlength=2 style="ime-mode:disabled"  dataformat="engup" tabindex=35>
													<input type="text" name="c_cust_seq" style="width:50;" class="input" value="" maxlength=6 dataformat="int" tabindex=36>
													<input type="text" name="c_cust_nm" style="width:180;" class="input2" value=""  readonly  tabindex=-1>
													<img src="img/btns_search.gif" name="btn_EsmBkg1159Pop" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
									<td width="75"><input type="radio" name="chkTaaRfaNo" value="T" class="trans" onClick="javascript:chkTaaRfa('T');"><a href="javascript:comBkgCallPopEsmPri3019();">TAA No.</a></td>
									<td width="70"><input type="radio" name="chkTaaRfaNo" value="R" class="trans" checked onClick="javascript:chkTaaRfa('R');"><a href="javascript:comBkgCallPopEsmPri2020();">RFA No.</a></td>
									<td width="">
												<div id="taaNoDiv"  style="display:none">
												   	<input type="text" name="taa_no" style="width:85;" class="input" value=""  maxlength=10 style="ime-mode:disabled"  dataformat="engupnum" tabindex=40>
												  	<img src="img/btns_search.gif" name="btn_TaaNo" width="19" height="20" alt="" border="0" align="absmiddle"  class="cursor">
												</div>
												<div id="rfaNoDiv"  style="display:block">														
													<input type="text" name="rfa_no" style="width:85;" class="input" value=""  maxlength=11 style="ime-mode:disabled"  dataformat="engupnum" tabindex=40>
												  	<!-- input type="text" name="rfa_no1" style="width:30;" class="input1" value=""  maxlength=3 style="ime-mode:disabled"  dataformat="engupnum" tabindex=40>
												  	<input type="text" name="rfa_no2" style="width:75;" class="input1" value=""  maxlength=8 style="ime-mode:disabled"  dataformat="engupnum" tabindex=41-->
												  	<img src="img/btns_search.gif" name="btn_RfaNo" width="19" height="20" alt="" border="0" align="absmiddle"  class="cursor">
												</div>
									</td>		
								</tr>								
							</table>
							<table class="search" border="0" style="width:100%;"> 
								<tr class="h23">
									<td width="200"><div style="display:none;width:199;color:blue;" id="tro_flg"></div></td>
									<td width="40"></td>
									<td width="37">CMDT</td>
									<td><input type="text" name="cmdt_cd" style="width:50;" class="input1" value="" maxlength=6 dataformat="int" tabindex=42>										 
										 <input type="text" name="cmdt_desc" style="width:220;" class="input2" value="" readonly  tabindex=-1>
										 <img src="img/btns_search.gif" name="btn_CmdtPop" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
								</tr>
							</table>
						</td>
						</tr>
						</table>
					</td>
				</tr>
				</table>
		
			<!--  biz_1  (E) -->
			<table class="line_bluedot"><tr><td></td></tr></table>
			<!--  biz_2  (S) -->
			
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="350">
						<table class="search_sm" border="0" width="350"><tr><td>
						<table class="search" border="0"> 
							<tr class="h23">
								<td width="70">Total Vol.</td>
								<td><input type="text" name="total_vol" style="width:100%;" class="input2" value="" readonly></td>
							</tr>
						</table>
					<!-- : ( Grid ) (S) -->
					<table width="100%"  id="mainTable">
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('t1sheet1');</script>
							</td>
						</tr>
					</table>
				<!-- : ( Grid ) (E) -->	
				<!--  Button_Sub (S) -->
				<table width="100%" class="button"> 
	       		<tr><td class="btn2_bg">
					<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><input type="checkbox" class="trans" name="flex_hgt_flg" value="Y"><b>F.H.</b>&nbsp;</td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_EqDetail">Vol Detail</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_t1TPSZ">TP/SZ</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>						
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_t1RowAdd">Row&nbsp;Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_t1Delete">Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>

					</table>
				</td></tr>
				</table>
				</td></tr></table>
	    		<!-- Button_Sub (E) -->
				</td>
				<td width="9"></td>
				<td width="610" valign="top">
					<table class="search_sm" border="0"><tr><td>
					<table class="search" border="0"> 
						<tr class="h23">
							<td width="58">&nbsp;&nbsp;Weight</td>
							<td width="170"><input type="text" name="act_wgt" style="width:100;text-align:right;" class="input1" value="" dataformat="float" maxlength=14 tabindex=51>&nbsp;
											<script language="javascript" >ComComboObject('wgt_ut_cd', 1, 50, 1, 0, 1)</script>
							</td>
							<td width="70">C.OFC/Rep.</td>
							<td width="145"><input type="text" name="ctrt_ofc_cd" style="width:50;" class="input2" value="" readonly>&nbsp;<input type="text" name="ctrt_srep_cd" style="width:45;" class="input2" value="" readonly>
							<img src="img/btns_search.gif" name="btn_CRep" width="0" height="0" alt="" border="0" align="absmiddle" class="cursor" dataformat="engupnum"></td>
							<td width="70">L.OFC/Rep.</td>
							<td><input type="text" name="ob_sls_ofc_cd" style="width:50;" class="input2" value=""  readonly>&nbsp;<input type="text" name="ob_srep_cd" style="width:45;" class="input1" value="" dataformat="engupnum" maxlength=5 tabindex=52></td>
						</tr>
					</table>
					<table class="search" border="0" style="width:610;"> 
						<tr class="h23">
							<td width="20"><input type="checkbox" name="dcgo_flg" value="Y" class="trans" ></td>
							<td width="115"><table width="90%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td><td class="btn2" name="btn_t1Danger" id="btn_t1Danger">Danger</td><td class="btn2_right"></td></tr></table></td>
							<td width="118"><table width="97%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td><td class="btn2" name="btn_t1Stowage" id="btn_t1Stowage">Stowage</td><td class="btn2_right"></td></tr></table></td>
							<td width="128"><input type="checkbox" name="prct_flg" value="Y"  class="trans" disabled>Precaution</td>
							<td width="51">S/O No.</td>
							<td width="65"><input type="text" name="twn_so_no" style="width:60;" class="input" value="" dataformat="engupnum" maxlength=6 tabindex=81></td>
							<td width="65">Dest. OCP</td>
							<td>&nbsp;<input type="text" name="ocp_cd" style="width:45;" class="input" value="" dataformat="engup" maxlength=5 tabindex=82></td>
						</tr>
						
						<tr class="h23">
							<td><input type="checkbox" name="rc_flg" value="Y"  class="trans"></td>
							<td width="115"><table width="90%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td><td class="btn2" name="btn_t1Reefer" id="btn_t1Reefer">Reefer</td><td class="btn2_right"></td></tr></table></td>
						<td width="118"><table width="97%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td><td class="btn2" name="btn_t1Hanger" id="btn_t1Hanger">Hanger</td><td class="btn2_right"></td></tr></table></td>
							<td><input type="checkbox" name="spcl_hide_flg" value="Y" class="trans">Hide
							<input type="checkbox" name="spcl_hide_lnr_flg" value="Y" class="trans">H.Liner</td>
							<td>DPCS</td>
							<td colspan="3"><table width="90%" border="0" cellpadding="0" cellspacing="0" class="search">
						<tr class="h23">
							<td width="8">I</td>
							<td width="20"><input type="text" style="width:20;" value="" class="input2" name="bl_doc_inp_flg" readonly></td>
							<td width="8">R</td>
							<td width="20"><input type="text" style="width:20;" value="" class="input2" name="bl_rt_flg" readonly></td>
							<td width="8">Q</td>
							<td width="20"><input type="text" style="width:20;" value="" class="input2" name="bl_aud_flg" readonly></td>
							<td width="8">F</td>
							<td width="20"><input type="text" style="width:20;" value="" class="input2" name="bl_drft_fax_out_flg" readonly></td>
							<td width="8">FO</td>
							<td width="20"><input type="text" style="width:20;" value="" class="input2" name="bl_fnt_ofc_flg" readonly></td>
							</tr></table></td>
							
						</tr>
				
						<tr class="h23">
							<td><input type="checkbox" name="awk_cgo_flg" value="Y"  class="trans"></td>
							<td width="115"><table width="90%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td><td class="btn2" name="btn_t1Awkward" id="btn_t1Awkward">Awkward</td><td class="btn2_right"></td></tr></table></td>
							<td><table width="97%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td><td class="btn2" name="btn_t1StopOffCargo"  id="btn_t1StopOffCargo">Stop&nbsp;Off&nbsp;Cargo</td><td class="btn2_right"></td></tr></table></td>
							<td><input type="checkbox" name="chk_veh_cmdt_flg" value="Y"  class="trans">Vehicle
							<!--<input type="checkbox" name="hot_de_flg" value="Y"  class="trans">Premium</td> -->
							<td colspan="2"><table width="90%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td><td class="btn2" name="btn_t1Constraints"  id="btn_t1Constraints">Constraints</td><td class="btn2_right"></td></tr></table></td>
							<td colspan="3">
								<table><tr class="h23">	<td>Return</td>
											<td><input type="text" style="width:45;" value="" class="input2" name="return_cd" readonly></td>
											<td>&nbsp;<img class="cursor" name="btn_0422Pop" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
										</tr>
								</table>
							</td>
						</tr>
						
						<tr class="h23">
							<td><input type="checkbox" name="bb_cgo_flg" value="Y" class="trans"></td>
							<td width="115"><table width="90%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btn_t1BreakBulk" id="btn_t1BreakBulk">Break&nbsp;Bulk</td><td class="btn2_right"></td></tr></table></td>
							<td width="118"><table width="97%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btn_t1Fumigation" id="btn_t1Fumigation">Fumigation</td><td class="btn2_right"></td></tr></table></td>
							<td><input type="checkbox" name="fd_grd_flg" value="Y"  class="trans">Food Grade</td>
							<td colspan="4"><input type="checkbox" name="bkg_cgo_tp_cd" value="R" class="trans" disabled="true">Rev. MT &nbsp;<input type="checkbox" name="chk_crr_soc_flg" value="Y" class="trans">SOC fm Shipping Ln.</td>
						</tr>
						
						<tr class="h23">
							  <td colspan="2" width="130" onmousemove="obdmtmsgmove()" onmouseover='obdmtmsgset("O/B DEM/DET TTL OUTSTANDING");return true;'  onmouseout="obdmtmsghide();return true;">
								&nbsp;<input type="text" style="width:97;text-align:right;" value="" class="input2" name="ob_dmt" value="" readonly>
								<img class="cursor" name="btn_t1Dmdt" id="btn_t1Dmdt" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
								</td>
							<td width="118">
							<table width="100%" border="0" cellpadding="0" cellspacing="0" class="search">
									<tr class="h23"><td>&nbsp;Rail Bulk&nbsp;
										<script language="javascript" >ComComboObject('rail_blk_cd', 2, 35, 0, 0, 0)</script>
							</td></tr></table>
							</td>
							<td>
							<input type="checkbox" name="chk_non_dg_chem_flg" id="chk_non_dg_chem_flg" value="Y" class="trans">Non DG Chem.
							</td>
							<td colspan="4">
								<table class="grid2" border="0" style="width:228;"> 
								<tr class="tr2_head">
									<td width="110">Origin&nbsp;
										<input type="text" name="por_cost_sts" style="width:60;" class="input2" value="" readonly></td>
									<td width="110">&nbsp;Dest&nbsp;&nbsp;
										<input type="text" name="del_cost_sts" style="width:60;" class="input2" value="" readonly></td>
									</tr>
								</table>
							</td>
							
						</tr>
					</table>
				</td>
			</tr>
			</table>
			</td></tr></table>
			<!--  biz_2  (E) -->
			<table class="line_bluedot"><tr><td></td></tr></table>
			<!--  biz_3  (S) -->
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="215" rowspan="2">
						<table border="0" style="width:209; background-color:white;" class="grid2"> 
							<tr class="tr2_head">
								<td colspan="2">Planned Delivery Schedule</td></tr>
							<tr><td class="tr2_head2">M’ty DR Arrival Date</td>
								<td class="align_r"><input type="text" name="mty_dor_arr_dt" style="width:74;" class="noinput" value=""  maxlength=10 dataformat="ymd"  tabindex=61>&nbsp;<img class="cursor" name="btns_MtDorArrCalendar" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" class="cursor"></td></tr>
							<tr><td class="tr2_head2">Sailing Due Date</td>
								<td class="input1" align=right><input type="text" name="lodg_due_dt" style="width:74;" class="input1" value="" maxlength=10 dataformat="ymd"  tabindex=62>&nbsp;<img class="cursor" name="btns_LodgDueCalendar" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td></tr>
							<tr><td class="tr2_head2">Delivery DT</td>
								<td class="align_r"><input type="text" name="de_due_dt" style="width:74;" class="noinput" value="" maxlength=10 dataformat="ymd"  tabindex=63>&nbsp;<img class="cursor" name="btns_DeDueCalendar" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td></tr>
						</table>
					</td>
					<td width="195" rowspan="2">
						<table border="0" style="width:185; background-color:white;" class="grid2"> 
							<tr class="tr2_head">
								<td colspan="2">Empty CNTR P/Up & RTN CY</td></tr>
							<tr><td class="tr2_head2">M'ty Pick up CY</td>
								<td class="align_r"><input type="text" name="mty_pkup_yd_cd" style="width:75;" class="noinput" value=""  maxlength=7 dataformat="engupnum" style="ime-mode:disabled"   tabindex=64>
															<img class="cursor" name="btn_0082Pop" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td></tr>
							<tr><td class="tr2_head2">M'ty Pick up DT</td>
								<td class="align_r"><input type="text" name="mty_pkup_dt" style="width:75;" class="noinput" value="" maxlength=10 dataformat="ymd"  tabindex=65>&nbsp;<img class="cursor" name="btns_MtPickUpCalendar" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td></tr>
							<tr><td class="tr2_head2">Full Return CY</td>
								<td class="align_r"><input type="text" name="full_rtn_yd_cd" style="width:75;" class="noinput" value="" maxlength=7 dataformat="engupnum" style="ime-mode:disabled"   tabindex=66>
															<img class="cursor" name="btn_0088Pop" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td></tr>
						</table>
					</td>
					<td width="230" rowspan="2" valign="top">
						
						<!-- Tab ) (S) -->
				     		<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%> 
				       		<tr><td width="215">
										<script language="javascript">ComTabObject('tab1')</script>
										<!-- img src="img/sub_tab.gif" alt="" width="998" height="23" border="0" -->
									</td></tr>
								</table>
						<!-- Tab ) (E) -->
						
					<!--TAB  (S) -->
					<div id="tabLayer" style="display:inline">						
						<!-- : ( Grid ) (S) -->
						<table width="215"  id="mainTable">
							<tr>
								<td width="100%">
									<div name="tab1Div" style="overflow:auto;width:97%;height:72px">
									<table border="0" style="width:189; background-color:white;" class="grid2"> 
										<tr>
											<td class="tr2_head2">Contact</td>
											<td class="align_r"><input type="text" name="bkg_cntc_pson_nm" style="width:135;" class="noinput" value="" maxlength=50 tabindex=71></td>
										</tr>	
										<tr>
											<td class="tr2_head2">E-mail</td>
											<td class="align_r"><input type="text" name="bkg_cntc_pson_eml" style="width:135;" class="noinput" value="" maxlength=200 tabindex=73></td>
										</tr>			
										<tr>
											<td class="tr2_head2">Tel.</td>
											<td class="align_r"><input type="text" name="bkg_cntc_pson_phn_no" style="width:135;" class="noinput" value="" maxlength=30 tabindex=72 dataformat="saupja"></td>
										</tr>		
										<tr>
											<td class="tr2_head2">Fax</td>
											<td class="align_r"><input type="text" name="bkg_cntc_pson_fax_no" style="width:135;" class="noinput" value="" maxlength=30 tabindex=75 dataformat="saupja"></td>
										</tr>		
										<tr>
											<td class="tr2_head2">Mobile</td>
											<td class="align_r"><input type="text" name="bkg_cntc_pson_mphn_no" style="width:135;" class="noinput" value="" maxlength=30 tabindex=74 dataformat="saupja"></td>
										</tr>		
									</table>
									</div>
									<!--script language="javascript">ComSheetObject('t1sheet2');</script-->
								</td>
							</tr>
						</table>
						<!-- : ( Grid ) (E) -->
					</div>
					<!--TAB  (E) --> 		


					<!--TAB  (S) -->
					<div id="tabLayer" style="display:none">						
						<table width="215"  id="mainTable">
							<tr>
								<td width="100%">
									<div name="tab2Div" style="overflow:auto;width:97%;height:72px">
									<table border="0" style="width:189; background-color:white;" class="grid2"> 
										<tr>
											<td class="tr2_head2">Contact</td>
											<td class="align_r"><input type="text" name="si_cntc_pson_nm" style="width:135;" class="noinput" value="" maxlength=50 tabindex=76></td>
										</tr>			
										<tr>
											<td class="tr2_head2">E-mail</td>
											<td class="align_r"><input type="text" name="si_cntc_pson_eml" style="width:135;" class="noinput" value="" maxlength=200 tabindex=78></td>
										</tr>		
										<tr>
											<td class="tr2_head2">Tel.</td>
											<td class="align_r"><input type="text" name="si_cntc_pson_phn_no" style="width:135;" class="noinput" value="" maxlength=30 tabindex=77 dataformat="saupja"></td>
										</tr>		
										<tr>
											<td class="tr2_head2">Fax</td>
											<td class="align_r"><input type="text" name="si_cntc_pson_fax_no" style="width:135;" class="noinput" value="" maxlength=30 tabindex=80 dataformat="saupja"></td>
										</tr>		
										<tr>
											<td class="tr2_head2">Mobile</td>
											<td class="align_r"><input type="text" name="si_cntc_pson_mphn_no" style="width:135;" class="noinput" value="" maxlength=30 tabindex=79 dataformat="saupja"></td>
										</tr>		
									</table>
									</div>
								</td>
							</tr>
						</table>
					</div>
					<!--TAB  (E) --> 
					</td>
					<td width="180" valign="top">
						<table border="0" style="width:170;  class="search"> 
							<tr class="h23">
								<td><table width="95%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td><td class="btn2" name="btn_t1SVCModeRoute">SVC&nbsp;Mode&nbsp;&&nbsp;Route</td><td class="btn2_right"></td></tr></table></td></tr>
							<tr class="h23"><td><table width="95%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td><td class="btn2" name="btn_t1ReferenceNo" id="btn_t1ReferenceNo">Reference&nbsp;No.</td><td class="btn2_right"></td></tr></table></td></tr>
							<tr class="h23">
								<td><table width="95%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td><td class="btn2" name="btn_t1CargoClosingTime" id="btn_t1CargoClosingTime">Cut&nbsp;Off&nbsp;Time</td><td class="btn2_right"></td></tr></table></td></tr>
							<tr class="h23">
								<td><table width="95%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td><td class="btn2" name="btn_t1RollOverInformation" id="btn_t1RollOverInformation">Roll&nbsp;Over&nbsp;Information</td><td class="btn2_right"></td></tr></table></td></tr>
						</table>
					</td>
					<td width="159" valign="top">
						
						<table border="0" style="width:150;  class="search">
							<tr class="h23">
								<td colspan="2" width="">B.OFC&nbsp;&nbsp;&nbsp;<input type="text" name="bkg_ofc_cd" style="width:50;" class="input2" value="<%=strUsr_ofc %>" readonly></td></tr>
							<tr class="h23" onmousemove="msgmove()" onmouseover="msgset(document.form.userInfo.value);return true;"  onmouseout="msghide();return true;">
								<td colspan="2" width="">B.Staff&nbsp;<input type="text" name="usr_nm" value="<%= strUsr_nm%>" style="width:109;" class="input2" readonly></td></tr>
							<tr class="h23">
								<td colspan="2" width="">BKG&nbsp;<input type="text" name="xter_bkg_rqst_cd" style="width:45;" class="input2" value="" readonly>&nbsp;&nbsp;&nbsp;S/I&nbsp;<input type="text" name="xter_si_cd" style="width:47;" class="input2" value=" " readonly></td></tr>
							<tr class="h23">
								<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td><td class="btn2" name="btn_t1SalesApproval" id="btn_t1SalesApproval">Sales&nbsp;Appl</td><td class="btn2_right"></td></tr></table>
								</td>
								<td>&nbsp;ID&nbsp;<script language="javascript" >ComComboObject('ida_hlg_tp_cd', 2, 35, 0, 0, 0)</script>
								</td>	
							</tr>	
						</table>
					</td>
				</tr>
				
			</table>
			
				
			<!--  biz_3  (E) -->
			<table class="line_bluedot"><tr><td></td></tr></table>
			<!--  biz_4  (S) -->
			<table class="grid2" border="0" style="width:979;"> 
				<tr class="h23">
					<td class="tr2_head_l" width="60">&nbsp;&nbsp;Ext <img src="img/btns_search.gif"  name="btn_0976Pop" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"><br>&nbsp;&nbsp;&nbsp;Remark</td>
					<td><textarea  name="xter_rmk" style="width:480;height:60;" tabindex=91></textarea></td>
					<td class="tr2_head_l" width="60">&nbsp;&nbsp;Int <img src="img/btns_search.gif"  name="btn_0976Pop" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"><br>&nbsp;&nbsp;&nbsp;Remark</td>
					<td><textarea  name="inter_rmk" style="width:360;height:60;" tabindex=92></textarea></td>						
				</tr>
			</table>
			<!--  biz_4  (E) -->
			</td></tr>
		</table>
		
			
			<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;" align="right"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_t1Retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_t1New" id="btn_t1New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_t1Save" id="btn_t1Save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_t1GoIBCS">Go to I/B CS</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td width="20" id="bottom_space"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_t1EasyCopy">Easy&nbsp;Copy</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_t1Copy">Copy</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_t1BKGCancel">BKG&nbsp;Cancel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td>
					<table width="100%" border="0" cellpadding="0" cellspacing="0" >
						<tr>
							<td>
								<table border="0" cellpadding="0" cellspacing="0" class="button"  id="WaitToFirm" style="display:none">
									<tr><td class="btn1_left"></td>
									<td class="btn1" name="btn_t1Holding">Waiting&nbsp;->&nbsp;Firm</td>
									<td class="btn1_right"></td>
									</tr>
								</table>				
							</td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" id="FirmToWait" style="display:block">
									<tr><td class="btn1_left"></td>
										<td class="btn1" name="btn_t1Waiting">Firm&nbsp;->&nbsp;Waiting</td>
										<td class="btn1_right"></td>
									</tr>
								</table>
							</td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td>
										<td class="btn1" name="btn_t1FaxEDI">Fax/EDI</td>
										<td class="btn1_right"></td>
									</tr>
								</table>
							</td>	
							<td id="btn_AlocReason"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" id="AlocReason" style="display:block">
									<tr><td class="btn1_left"></td>
										<td class="btn1" name="btn_AlocReason">Standby Detail</td>
										<td class="btn1_right"></td>
									</tr>
								</table>
							</td>
						</tr>					
					</table>
				</td>				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_t1Split">Split</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
<div id="msg" style="position:absolute;left:0;top:0;width:0;height:0;"></div>
<div id="alocRsn" style="position:absolute;left:0;top:0;width:0;height:0;"></div>
<div id="orgBlNo" style="position:absolute;left:0;top:0;width:0;height:0;"></div> 	 	
<div id="obDmt" style="position:absolute;left:0;top:0;width:0;height:0;"></div> 	
<div id="nonRateStsMsg" style="position:absolute;left:0;top:0;width:0;height:0;"></div> 	
<div id="agmtCustMsg" style="position:absolute;left:0;top:0;width:0;height:0;"></div> 	
	<!-- Grid BG Box  (E) -->	
<!--TAB BKG Creation (E) -->
<input type="hidden" name="rhq_ofc_cd" value = "<%=StrRhq_ofc_cd%>">
<input type="hidden" name="old_bkg_no" value="<%= bkgNo%>">
<input type="hidden" name="old_bl_no">
<input type="hidden" name="data_yn" value="N">
<input type="hidden" name="orgBlNo">
<input type="hidden" name="userInfo"  value="<%= strUsr_info%>">
<input type="hidden" name="save_mode_cd">
<!-- route 정보 -->
<input type="hidden" name="pctl_no_old">
<input type="hidden" name="pctl_no" >
<input type="hidden" name="por_conti_cd">
<input type="hidden" name="del_conti_cd">
<input type="hidden" name="bkg_trunk_vvd_old">
<input type="hidden" name="por_cd_old">
<input type="hidden" name="por_yd_cd_old">
<input type="hidden" name="pol_cd_old">
<input type="hidden" name="pol_yd_cd_old">
<input type="hidden" name="pod_cd_old">
<input type="hidden" name="pod_yd_cd_old">
<input type="hidden" name="del_cd_old">
<input type="hidden" name="del_yd_cd_old">
<input type="hidden" name="rcv_term_cd_old">
<input type="hidden" name="de_term_cd_old">
<input type="hidden" name="mty_dor_arr_dt_old">	
<input type="hidden" name="lodg_due_dt_old">
<input type="hidden" name="de_due_dt_old">
<input type="hidden" name="mty_pkup_yd_cd_old">
<input type="hidden" name="mty_pkup_dt_old">
<input type="hidden" name="full_rtn_yd_cd_old">
<input type="hidden" name="full_pkup_yd_cd">
<input type="hidden" name="mty_rtn_yd_cd">
<input type="hidden" name="org_sconti_cd">
<input type="hidden" name="dest_sconti_cd">
<input type="hidden" name="svc_scp_cd">
<input type="hidden" name="org_trns_svc_mod_cd">
<input type="hidden" name="dest_trns_svc_mod_cd">
<!-- customer 정보 -->
<input type="hidden" name="s_cust_cnt_cd_old"> 
<input type="hidden" name="s_cust_seq_old">
<input type="hidden" name="s_cust_subst_flg">
<input type="hidden" name="s_cust_exist_flg">
<input type="hidden" name="f_cust_cnt_cd_old">
<input type="hidden" name="f_cust_seq_old">
<input type="hidden" name="f_cust_subst_flg">
<input type="hidden" name="f_cust_exist_flg">
<input type="hidden" name="c_cust_cnt_cd_old">
<input type="hidden" name="c_cust_seq_old">
<input type="hidden" name="c_cust_subst_flg">
<input type="hidden" name="c_cust_exist_flg">
<input type="hidden" name="fmc_no">
<input type="hidden" name="agmt_act_cnt_cd">
<input type="hidden" name="agmt_act_cust_seq">
<!-- CTRT -->
<input type="hidden" name="rfa_no_old">
<input type="hidden" name="rfaNoValid"> <!-- 유효한 RfaNo 번호인지 확인(CMDT PopUp 호출시 사용) -->
<input type="hidden" name="sc_no_old">
<input type="hidden" name="taa_no_old">
<input type="hidden" name="cmdt_cd_old">
<input type="hidden" name="scp_from_ctrt">
<input type="hidden" name="rep_cmdt_cd">
<!-- <input type="hidden" name="premium_available_flg"> -->
<input type="hidden" name="validPrecaution">
<input type="hidden" name="befUsaCstmsFileCd">
<!-- cargo -->
<input type="hidden" name="dcgo_flg_old">
<input type="hidden" name="rc_flg_old">
<input type="hidden" name="awk_cgo_flg_old">
<input type="hidden" name="bb_cgo_flg_old">
<input type="hidden" name="allMotorLoc">
<input type="hidden" name="flexHeightLoc">
<input type="hidden" name="rd_cgo_flg"> <!-- Save시 변경-->
<input type="hidden" name="soc_flg"> <!-- Save시 변경 -->
<input type="hidden" name="eq_subst_flg"> <!-- Save시 변경 -->
<input type="hidden" name="dg_flg">
<input type="hidden" name="hcdg_flag">
<input type="hidden" name="rf_flg">
<input type="hidden" name="awk_flg">
<input type="hidden" name="bb_flg">
<input type="hidden" name="stwg_flg">
<input type="hidden" name="hngr_flg">
<input type="hidden" name="stop_off_flg">
<input type="hidden" name="fumg_flg">
<input type="hidden" name="blck_stwg_cd">
<!-- Popup에서 작업한 정보 담는 Hidden(Sheet 제외) -->
<!-- ESM-BKG_0090 Special Stowage Request -->
<input type="hidden" name="stwg_cd">
<input type="hidden" name="stwg_rmk">
<!-- ESM-BKG_0658 Stop Off Cargo Order-->
<input type="hidden" name="stop_off_loc_cd">
<input type="hidden" name="stop_off_cntc_phn_no">
<input type="hidden" name="stop_off_cntc_pson_nm">
<input type="hidden" name="stop_off_diff_rmk">
<!-- ESM-BKG_1181 Fumigation -->
<input type="hidden" name="fumg_loc_cd">
<input type="hidden" name="fumg_cntc_phn_no">
<input type="hidden" name="fumg_cntc_pson_nm">
<input type="hidden" name="fumg_diff_rmk">
<!-- C/A Flag -->
<input type="hidden" name="ca_flg">
<input type="hidden" name="ca_user" >
<input type="hidden" name="ca_remark" >
<input type="hidden" name="ca_rsn_cd" >
<input type="hidden" name="ca_new_creation_flag" value="<%=caNewCreationFlag %>">

<!-- RouteDetail시 반영될 Hidden Sheet -->
<input type="hidden" name="org_trns_mod_cd">
<input type="hidden" name="dest_trns_mod_cd">
<!-- Etc flag -->
<input type="hidden" name="cgo_dtl_auto_flg">
<input type="hidden" name="carge_detail_pop">
<input type="hidden" name="partial_vvd_assign_flg">
<input type="hidden" name="partial_vvd_opened_flg">
<input type="hidden" name="ctrt_modify_flag">
<input type="hidden" name="route_modify_flag">
<input type="hidden" name="qty_modify_flag">
<input type="hidden" name="customer_modify_flag">
<input type="hidden" name="contact_modify_flag">
<input type="hidden" name="close_bkg_flag">
<input type="hidden" name="check_ts_close_flag">
<input type="hidden" name="ts_close_bkg_flag">
<input type="hidden" name="closed_ts_vvd">
<input type="hidden" name="cbf_bkg_flag">
<input type="hidden" name="ib_modify_flag">
<input type="hidden" name="tvvd_modify_flg">
<input type="hidden" class="noinput" name="modify_flag">
<input type="hidden" name="have_route_flag">
<input type="hidden" name="psdo_bkg_flg">
<input type="hidden" name="pc_inq_flag">
<input type="hidden" name="tro_un_cfm_flag">
<input type="hidden" name="is_vl_flg">
<input type="hidden" name="cntr_flg">
<input type="hidden" name="usr_cnt_cd" value="<%=strUsr_cntCd %>">

<input type="hidden" name="split_rsn_cd">
<input type="hidden" name="adv_shtg_cd">

<input type="hidden" name="old_cmdt_cd">
<input type="hidden" name="chk_oft">
<input type="hidden" name="cntr_del" value="N">
<input type="hidden" name="application_dt">

<input type="hidden" name="port_skp_flg"> 
<input type="hidden" name="cust_ntc_flg">
<input type="hidden" name="vsl_cng_rsn">
<input type="hidden" name="pgm_no" value="ESM_BKG_0079_01">
<input type="hidden" name="aloc_chk_flg">
<input type="hidden" name="bkg_aloc_tp_cd">

<input type="hidden" name="kr_cstms_cust_tp_cd">
<input type="hidden" name="is_rated_flg">
<input type="hidden" name="crr_soc_flg">
<input type="hidden" name="veh_cmdt_flg">
<input type="hidden" name="non_dg_chem_flg">

<table width="100%" id="mainTable">
	<tr>
		<td width="100%">
			<script language="javascript">ComSheetObject('t1sheet2');</script>
		</td>
	</tr>
</table>
<table width="100%" id="mainTable">
	<tr>
		<td width="100%" >
			<script language="javascript">ComSheetObject('t1sheet3');</script>
		</td>
	</tr>
</table>
<table width="100%" id="mainTable">
	<tr>
		<td width="100%" >
			<script language="javascript">ComSheetObject('t1sheet4');</script>
		</td>
	</tr>
</table>
<div style="display:none">
	<script language="javascript">ComSheetObject('bkgChgOfcSheet');</script>
</div>

<%if("Y".equals(caNewCreationFlag)){ %>
	</td></tr>
</table>
<%} %>

<!-- 개발자 작업  끝 -->
<div id="layList" name="layList" style="position:absolute;z-index:999;display:none" CELLPADDING="5" CELLSPACING="0" BORDER="0"/>
	<IFRAME id="ifrm" name="ifrm" src="apps/alps/esm/bkg/bookingcommon/bookingutil/jsp/esm_booking_split_no.html"  frameborder="0" marginHeight="0' marginWidth="0" width="115" height="82"  style="position:absolute;border:1 #e9e9e9 solid" CELLSPACING="0" scrolling="no"/>
	</IFRAME>
</div>
</form>
</body>
</html>