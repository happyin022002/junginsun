<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0079_07.jsp
*@FileTitle : C/M by Booking
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.11
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.06.11 김영출
* 1.0 Creation
===============================================================================
 History
* 2010.09.13 이일민 [CHM-201005276-01] ALPS-[BKG/DOC]주요UI버턴-단축키 기능개발
* 2010.12.07 최도순 [CHM-201007310] BKG C/M 화면에 DG SEQ 선택 필드 (구주 24 HR)
* 2012.11.08 김보배 [CHM-201221406] [BKG] 이란 Sanction 관련 HS Code 삽입 로직 보완 요청
* 2012.11.20 김보배 [CHM-201221505] [BKG] [BKG MAIN] Germany HS code Mandatory 설정 요청
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event.EsmBkg007907Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.core.view.template.Screen"%>
<%@ page import="com.hanjin.framework.core.controller.util.WebKeys"%>

<%
	EsmBkg007907Event  event = null;			//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String isInquiry = "N";	
	Logger log = Logger.getLogger("com.hanjin.apps.OutboundBLMgt.BLDocumentationCM");

	// search Init
	String bkgNo      = "";
	String blNo       = "";
	String blTpCd     = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg007907Event)request.getAttribute("Event");
		bkgNo  = JSPUtil.getParameter(request, "bkg_no");
		blNo       = event.getBlNo();
		blTpCd     = event.getBlTpCd();

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		Screen screen = (Screen) request.getAttribute(WebKeys.CURRENT_SCREEN);
		//inquiry mode
		if (screen.getName().indexOf("Q") >= 0){
			isInquiry = "Y";
		} else {
			isInquiry = "N";			
		}

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>C/M by Booking</title>
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

<body  onLoad="setupPage();">
<!-- parameter 값이 커서 POST 방식으로 팝업을 띄우기 위함 -->
<form name="form2">
<input type="hidden" name="func">
<input type="hidden" name="mk_desc">
<input type="hidden" name="gds_desc">
</form>
<!--  -->
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="dirty_flag">
<input type="hidden" name="bkg_pck_qty">
<input type="hidden" name="bkg_pck_unit">
<input type="hidden" name="bkg_wgt_qty">
<input type="hidden" name="bkg_wgt_unit">
<input type="hidden" name="bkg_meas_qty">
<input type="hidden" name="bkg_meas_unit">
<input type="hidden" name="bkg_mk_desc">
<input type="hidden" name="bkg_cstms_desc">
<input type="hidden" name="bkg_cfm_flg">
<input type="hidden" name="cntr_no">
<input type="hidden" name="cntr_mf_flag">
<input type="hidden" name="mf_cfm_flg">
<input type="hidden" name="pre_rly_port_cd">
<input type="hidden" name="pst_rly_port_cd">
<input type="hidden" name="bkg_sts_cd">
<input type="hidden" name="bdr_flg">
<input type="hidden" name="corr_flg">
<input type="hidden" name="ca_exist_flg">
<input type="hidden" name="hts_flg">
<input type="hidden" name="mypkg_flg">
<input type="hidden" name="isInquiry" value="<%=isInquiry%>">
<input type="hidden" name="obl_iss_flg">
<input type="hidden" name="bl_tp_cd" value="<%=blTpCd%>">
<input type="hidden" name="eur_flg">
<input type="hidden" name="old_bkg_no" value="<%=bkgNo%>">
<input type="hidden" name="de_flg">
<input type="hidden" name="tr_flg">
<input type="hidden" name="ru_flg">
<input type="hidden" name="hs_eu_flg">
<input type="hidden" name="us_frob_flg">
<input type="hidden" name="stwg_cd">
<!-- Origin 이 브라질 일 경우 Weight 이 1000 이하 경우에 대한 Validation 확인 유무	-->
<input type="hidden" name="br_wgt_chk_flg" value="N">

		<!--biz page (S)-->
		<table class="search" id="mainTable"  style="width:998;">
       		<tr><td class="bg">

				<!--  biz-1 (S) -->
				<table class="search" border="0" style="width:979;">
					<tr class="h23">
						<td width="80">Booking No.</td>
						<td width="172"><input type="text" id="bkg_no" name="bkg_no" style="ime-mode:disabled;width:110px;" dataformat="engupnum" value="<%=bkgNo%>" class="input1">
						<img class="cursor" src="img/btns_inquiry.gif" width="19" height="20" border="0" align="absmiddle" name="btn_splitPop">
						</td>
						<td width="50">B/L No.</td>
						<td width="215"><input name="bl_no" type="text" style="ime-mode:disabled;width:110px;" dataformat="engupnum" value="<%=blNo%>" class="input1">
							<!--select name="bl_tp_cd" style="width:40;" class="input2" readOnly>
								<option value="W">W</option>
								<option value="F">F</option>
								<option value="A">A</option>
								<option value="S">S</option>
							</select--></td>
						<td width="43">T/VVD</td>
						<td width="150"><input type="text" name="t_vvd" size="14" class="input2" readOnly><input type="hidden" name="vsl_cd"><input type="hidden" name="skd_voy_no"><input type="hidden" name="skd_dir_cd"></td>
						<td width="75">Cargo Type</td>
						<td width=""><input name="bkg_cgo_tp_cd" type="text" style="ime-mode:disabled;width:30;" dataformat="engupnum" class="input2" readOnly></td>
					</tr>
				</table>
				<table border="0" class="search" style="width:979;">
					<tr class="h23">
						<td width="80">Route</td>
						<td width="256">
						<input name="por_cd" type="text" style="ime-mode:disabled;width:50;" dataformat="engupnum" class="input2"  readOnly>
						<input name="pol_cd" type="text" style="ime-mode:disabled;width:50;" dataformat="engupnum" class="input2"  readOnly>
						<input name="pod_cd" type="text" style="ime-mode:disabled;width:50;" dataformat="engupnum" class="input2"  readOnly>
						<input name="del_cd" type="text" style="ime-mode:disabled;width:50;" dataformat="engupnum" class="input2"  readOnly>&nbsp;</td>
						<td width="66">R/D Term</td>
						<td width="84">
						<input name="bkg_rcv_term_cd" type="text" style="ime-mode:disabled;width:20;" dataformat="engupnum" class="input2"  readOnly>
						<input name="bkg_de_term_cd" type="text" style="ime-mode:disabled;width:20;" dataformat="engupnum" class="input2"  readOnly></td>
						<td width="70">Commodity</td>
						<td width=""><input name="cmdt_cd" type="text" style="ime-mode:disabled;width:50;" dataformat="engupnum" class="input2" readOnly>
						<!--input name="rep_cmdt_cd" type="text" style="width:25;" class="input2" readOnly-->
						<input name="cmdt_nm" type="text" style="ime-mode:disabled;width:350;" dataformat="engupnumspc" class="input2" readOnly></td>
					</tr>
					<tr class="h23">
						<td>Shipper</td>
						<td colspan="3"><input name="shpr_cnt_cd" type="text" style="ime-mode:disabled;width:25;" dataformat="engupnum" class="input2" readOnly>
						<input name="shpr_seq" type="text" style="ime-mode:disabled;width:50; text-align:right;" dataformat="engupnum" class="input2" readOnly>
						<input name="shpr_nm" type="text" style="ime-mode:disabled;width:311;" dataformat="engupnumspc" class="input2" readOnly></td>
						<td>Consignee</td>
						<td><input name="cnee_cnt_cd" type="text" style="ime-mode:disabled;width:25;" dataformat="engupnum" class="input2" readOnly>
						<input name="cnee_seq" type="text" style="ime-mode:disabled;width:50;text-align:right;" dataformat="engupnum" class="input2" readOnly>
						<input name="cnee_nm" type="text" style="ime-mode:disabled;width:321;" dataformat="engupnumspc" class="input2" readOnly></td>
					</tr>
				</table>
				<!--  biz-1 (E) -->

				<table class="line_bluedot"><tr><td></td></tr></table>

			<!-- grid box (S) -->
			<table class="search">
			<tr><td valign="top" width="190">

					<!-- Grid-1  (S) -->
					<table width="100%"  id="mainTable">
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('t9sheet1');</script>
							</td>
						</tr>
					</table>
					<!-- Grid-1 (E) -->

					<!--  Button_Sub (S) -->
					<table width="100%" class="button"table border="0">
			       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_t9AllConfirm">All Confirm</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_t9AllRelease">All Release</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
						</tr>
						</table>

					</td></tr>
					</table>
			    	<!-- Button_Sub (E) -->


				</td>

				<td valign="top" style="padding-left:10px;">
					<table class="height_5"><tr><td></td></tr></table>

					
					<!--  biz-1 (S) -->
					<table class="search" border="0" style="width:779px;"> 
						<tr class="h23">
							<td width="55">TP/SZ</td>
							<td width="70"><input name="cntr_tpsz_cd" type="text" style="ime-mode:disabled;width:40;" dataformat="engupnum" class="input2" readOnly></td>
							<td width="53">Seal No.</td>
							<td width="145"><select name="cntr_seal_no" style="width:120;" class="input2" readOnly></select></td>
							<td width="73">R/D Term</td>
							<td width="80"><input name="rcv_term_cd" type="text" style="ime-mode:disabled;width:20;" dataformat="engupnum" class="input2" readOnly>&nbsp;<input name="de_term_cd" type="text" style="ime-mode:disabled;width:20;" dataformat="engupnum" class="input2" readOnly></td>
							<td width="" align="right">DG<input name="dcgo_flg" type="checkbox" class="trans">&nbsp;
							                           BB<input name="bb_cgo_flg" type="checkbox" class="trans">&nbsp;
													   AK<input name="awk_cgo_flg" type="checkbox" class="trans">&nbsp;
													   RF<input name="rc_flg" type="checkbox" class="trans">&nbsp;
													   RD<input name="rd_cgo_flg" type="checkbox" class="trans">&nbsp;
													   HG<input name="hngr_flg" type="checkbox" class="trans"></td>							
						
						</tr>
					</table>
					<table class="search" border="0" style="width:779px;"> 
						<tr class="h23">
							<td width="55">Volume</td>
							<td width="70"><input name="cntr_vol_qty" type="text" style="ime-mode:disabled;width:40;" class="input2" readOnly></td>
							<td width="" align="right">Ahead / Short-ship&nbsp;<input name="adv_shtg_cd" type="text" style="ime-mode:disabled;width:35;" dataformat="engupnum" class="input2" readOnly></td>
					  </tr>
					</table>	
					<table class="search" border="0" style="width:779px;"> 
						<tr class="h23">
							<td width="55">Package</td>
							<td width="170"><input name="pck_qty" type="text" style="width:60; text-align:right" class="input2" readOnly dataformat="int" maxlength="7">&nbsp;<input name="pck_tp_cd" type="text" style="ime-mode:disabled;width:25;" dataformat="engup" maxlength="2" class="input2" readOnly></td>
							<td width="55">Weight</td>
							<td width="255"><input name="cntr_wgt" type="text" style="width:120; text-align:right" class="input2" readOnly dataformat="float" maxlength="13" pointcount="3">&nbsp;<input name="wgt_ut_cd" type="text" style="ime-mode:disabled;width:35;" dataformat="engupnum" class="input2" readOnly></td>
							<td width="60">Measure</td>
							<td align="right"><input name="meas_qty" type="text" style="width:120; text-align:right" class="input2" readOnly dataformat="float" maxlength="9" pointcount="3">&nbsp;<input name="meas_ut_cd" type="text" style="ime-mode:disabled;width:35;" dataformat="engupnum" class="input2" readOnly></td>
						</tr>
					</table>		
					<!--  biz-1 (E) -->
					
					<table class="line_bluedot"><tr><td height="25"></td></tr></table>

					<!-- Grid_2 (S) -->
					<table width="100%"  id="mainTable">
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('t9sheet2');</script>
								<script language="javascript">ComSheetObject('t9sheet3');</script>
								<script language="javascript">ComSheetObject('t9sheet4');</script>
							</td>
						</tr>
					</table>
					<!-- Grid_2 (E) -->
					<!--  Button_Sub (S) -->
					<table width="100%" class="button"table border="0">
			       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_t9Add">Row Add</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_t9Del">Row Delete</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_t9CopyMnd">Copy from M&amp;D</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
						</tr>
						</table>

					</td></tr>
					</table>
					<!--  -->
					<table class="height_10"><tr><td colspan="8"></td></tr></table>
					<table class="search" border="0">
						<tr class="h23">
							<td width="100">Total Package</td>
							<td width="150"><input name="cm_pck_qty" type="text" style="width:90; text-align:right" class="input2" readOnly dataformat="int" maxlength="7"></td>
							<td width="100">Total Weight</td>
							<td width="150"><input name="cm_cntr_wgt" type="text" style="width:90; text-align:right" class="input2" readOnly dataformat="float" maxlength="13" pointcount="3"></td>
							<td width="100">Total Measure</td>
							<td><input name="cm_meas_qty" type="text" style="width:90; text-align:right" class="input2" readOnly dataformat="float" maxlength="9" pointcount="3"></td>
						</tr>
					</table>
					<!--  -->

					
			    	<!-- Button_Sub (E) -->

					

				</td></tr>
			</table>
		</td></tr>
		</table>
			<!-- grid box (E) -->
<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
       	<tr><td class="btn1_bg">

		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_t9Retrieve" id="btn_t9Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_t9Save" id="btn_t9Save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_t9CMCopyCM">Copy C/M</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_t9CopyFmCntr">Copy from CNTR</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_t9CMbyCntr">C/M by CNTR</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<!--  
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_t9NVOHBL">NVOCC H.B/L</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				-->
				</tr>
			</table>
		</td></tr>
		</table>
    	<!--Button (E) -->
		<!-- 1 (E) -->
		<!--biz page (E)-->

		</td></tr>
		</table>
<!-- 개발자 작업  끝 -->
<div id="layList" name="layList" style="position:absolute;z-index:999;display:none" CELLPADDING=5 CELLSPACING=0 BORDER=0/>

<IFRAME id="ifrm" name="ifrm" src="apps/alps/esm/bkg/bookingcommon/bookingutil/jsp/esm_booking_split_no.html"  frameborder=0 marginHeight=0 marginWidth=0 width=115 height=82  style="position:absolute;border:1 #e9e9e9 solid" CELLSPACING=0 scrolling="no"/>
</form>
</body>
</html>