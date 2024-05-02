<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0034.jsp
*@FileTitle : B/L Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 이수빈
*@LastVersion : 1.0
* 2009.05.04 이수빈
* 1.0 Creation
* -----------------------------------------------------
* History
* 2012.05.10 김보배 [CHM-201217461] [BKG] [ACE M1] US AMS 전송후 1J 이후 Diversion 요청 기능 추가
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.event.EsmBkg0034Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0034Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strCnt_cd		= "";

	String strBlNo		  = "";
	String strBkgNo		 = "";
	String strVvd		   = "";
	String strPod		   = "";
	String strEta		   = "";

	String strPgmNo		 = "";
	String strOffice		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.ManifestListDownload");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strCnt_cd = account.getCnt_cd();


		event = (EsmBkg0034Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		strBlNo = JSPUtil.getNull(request.getParameter("bl_no"));
		strBkgNo = JSPUtil.getNull(request.getParameter("bkg_no"));
		
		if(strBlNo == null ||  strBlNo == "" ) {
			strBlNo = "";
			strVvd = JSPUtil.getNull(request.getParameter("vvd"));
			strPod = JSPUtil.getNull(request.getParameter("pod"));
			strEta = JSPUtil.getNull(request.getParameter("eta"));
			if(!"".equals(strEta) && strEta.length() > 8){
				StringBuffer sb = new StringBuffer();
		   		sb.append(strEta.substring(0,4)).append("-");
				sb.append(strEta.substring(4,6)).append("-");
				sb.append(strEta.substring(6,8)).append(" ");
				sb.append(strEta.substring(9,11)).append(":");
				sb.append(strEta.substring(11));
				strEta = sb.toString();
			}
		}
		strPgmNo = request.getParameter("pgmNo");
		strOffice = "ESM_BKG_0034-01".equals(strPgmNo) ? "Origin" : "US";

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>B/L Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>
<script language="javascript">
	var strCntCd = "<%=strCnt_cd%>";
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
<input type="hidden" name="pagerows" value="<%=pageRows %>">
<input type="hidden" name="ibflag">
<input type="hidden" name="tab_no" value="0">
<input type="hidden" name="office" value="<%=strOffice %>">

<input type="hidden" name="bl_no" value="<%=strBlNo%>">
<input type="hidden" name="bkg_no" value="<%=strBkgNo%>">
<input type="hidden" name="sc_no">
<input type="hidden" name="bl_tp_cd">
<input type="hidden" name="bkg_cust_tp_cd">
<input type="hidden" name="trnk_bdr_flg">
<input type="hidden" name="cstms_clr_cd">
<input type="hidden" name="locl_trns_cd">
<input type="hidden" name="bak_bl_no">
<input type="hidden" name="vps_eta_dt">
<input type="hidden" name="full_mty_cd">
<input type="hidden" name="diff_rmk">
<input type="hidden" name="hbl_cnt">
<input type="hidden" name="bl_cnt">
<input type="hidden" name="page_gubun" value="ESM_BKG_0034">
<input type="hidden" name="open_tab" value="<%= (request.getParameter("open_tab") == null) ? "" : request.getParameter("open_tab") %>">

<!-- 유저의 수정 권한 저장 -->
<input type="hidden" name="bl_vvd">
<input type="hidden" name="bl_pod">
<input type="hidden" name="bl_del">
<input type="hidden" name="bl_hub">
<input type="hidden" name="bl_cstms">
<input type="hidden" name="bl_fpo">
<input type="hidden" name="bl_mib">
<input type="hidden" name="bl_ptt">
<input type="hidden" name="bl_ftz">
<input type="hidden" name="bl_div">

<input type="hidden" name="div_ind">

<%@include file="/apps/alps/esm/bkg/bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp" %>

<table class="search">
	<tr>
		<td class="bg">
			<table class="search" border="0" style="width:970;">
				<tr class="h23">
					<td width="50">B/L No.</td>
					<td width="140"><input type="text" name="bl_nos" style="width:115; ime-mode: disabled;" class="input1"
					dataformat="eng" maxlength="13" required caption="B/L No." value="<%=strBlNo%>">&nbsp;
					<!-- <input type="text" name="bl_tp_cd" style="width:25;text-align:center;" readonly class="input2">&nbsp; --></td>
					<td width="40">Filer</td>
					<td width="40"><input type="text" name="cstms_file_tp_cd" style="width:25;text-align:center;" readonly class="input2"></td>
					<td width="70" align="center"><span id="mf_sts_cd"></span><input type="hidden" name="mf_sts_code"></td>
					<td width="80" align="right">Entry Type&nbsp;</td>
					<td width="100" align="right">
						&nbsp;<script language="javascript">ComComboObject('combo_t_cd', 1, 100, 1, 0, 1);</script>
					</td>
					<td width="100" align="center">Empty<input type="checkbox" name="full_mty_chk" class="trans" disabled></td>
					<td width="40">Stage</td>
					<td width="50"><input type="text" name="cstms_mf_tp_cd" style="width:30;text-align:center;text-indent:0px" readonly class="input2"></td>
					<td width="25">ISF</td>
					<td width="50"><input type="text" name="isf_act_cd" style="width:20;" readonly class="input2"></td>
					<td width="15">F</td>
					<td width="40"><input type="text" name="frt_clt_flg" style="width:20;" readonly class="input2"></td>
					<td width="15">O</td>
					<td width="40"><input type="text" name="obl_rdem_flg" style="width:20;" readonly class="input2"></td>
					<td width="15">C</td>
					<td width=""><script language="javascript">ComComboObject('combo_c_cd', 2, 40, 1, 3);</script>&nbsp;<span id="cgor_team_cd"></span>
					</td>
				</tr>
				<tr class="h23">
					<td>M.B/L</td>
					<td><input type="text" name="mbl_no" style="width:115;" class="input2" readonly></td>
					<td width="40">T.BDR</td>
					<td width="40"><input type="text" name="trnk_bdr_flg" style="width:25;text-align:center;" readonly class="input2"></td>
					<td colspan="2" align="right">Original File No.</td>
					<td align="right"><input type="text" name="pre_mf_no" style="width:100;" class="input"
						dataformat="eng" maxlength="12" fullfill caption="Original File No."></td>

				</tr>
			</table>
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			<table class="search" border="0" style="width:970;">
				<tr class="h23">
					<td width="30">VVD</td>
					<td width="90"><input type="text" name="vvd" style="width:80; ime-mode: disabled" readonly class="input2"
						dataformat="eng" maxlength="9" fullfill caption="VVD" value="<%=strVvd%>">
					<input type="hidden" name="vsl_eng_nm" style="width:120;" readonly class="input2"></td>
					<td width="26">POL</td>
					<td width="70"><input type="text" name="pol_cd" style="width:50; ime-mode: disabled" readonly class="input2"
						dataformat="eng" maxlength="5" fullfill caption="POL"></td>
					<td width="29">POD</td>
					<td width="70"><input type="text" name="pod_cd" style="width:50; ime-mode: disabled" readonly class="input2"
						dataformat="eng" maxlength="5" fullfill caption="POD" value="<%=strPod%>"></td>
					<td width="25">ETA</td>
					<td width="100"><input type="text" name="vps_eta_dt2" style="width:130; ime-mode: disabled" readonly class="input2"
						 value="<%=strEta%>"></td>
					<td width="30" align="right">DEL</td>
					<td width="60">&nbsp;<input type="text" name="del_cd" style="width:50; ime-mode: disabled" readonly class="input2"
						dataformat="eng" maxlength="5" fullfill caption="DEL"></td>
					<td width="100" align="right">Customs Loc</td>
					<td width="70">&nbsp;<input type="text" name="cstms_loc_cd" style="width:50; ime-mode: disabled" readonly class="input2"
						dataformat="eng" maxlength="5" fullfill caption="Customs HUB"></td>
					<td width="30">HUB</td>
					<td width="70"><input type="text" name="hub_loc_cd" style="width:50; ime-mode: disabled" readonly class="input2"
						dataformat="eng" maxlength="5" fullfill caption="HUB"></td>
					<td width="25">L.USA</td>
					<td width="70"><input type="text" name="usa_lst_loc_cd" style="width:50;  ime-mode: disabled" class="input"
						dataformat="eng" maxlength="5" fullfill caption="L.USA"></td>
					<td width="25">F.POD</td>
					<td width=""><input type="text" name="f_pod" style="width:50;  ime-mode: disabled" class="input2"
						dataformat="eng" maxlength="5" fullfill caption="F.POD"></td>
				</tr>
			</table>
			<table class="search" border="0" style="width:970;">
				<tr class="h23">
					<td width="115">Actual Filing VVD</td>
					<td width="107"><input type="text" name="act_file_vvd" style="width:90; ime-mode: disabled;" class="input2"
						dataformat="eng" maxlength="9" caption="Actual Filing VVD"></td>
					<td width="56">Customs</td>
					<td width="65"><input type="text" name="customs" style="width:50; ime-mode: disabled" readonly class="input2"
						dataformat="eng" maxlength="5" fullfill caption="Customs"></td>
					<td width="80" align="right">P/MIB No.&nbsp;</td>
					<td width="151"><input type="text" name="ibd_trsp_no" style="width:130;" readonly class="input2"
						dataformat="eng" maxlength="17" caption="P/MIB No."></td>
					<td width="30">Type</td>
					<td width="83"><input type="text" name="ibd_tp_cd" style="width:60;" readonly class="input2"></td>
					<td width="60">R/D Term</td>
					<td width="80"><input type="text" name="rcv_term_cd" style="width:20;text-align:center;" readonly class="input2">
						<input type="text" name="de_term_cd" style="width:20;text-align:center;" readonly class="input2"></td>
					<td width="25">FTZ</td>
					<td width=""><script language="javascript">ComComboObject('free_trd_zn_flg', 1, 40, 1, 0, 1);</script></td>						
				</tr>
			</table>
			<table class="search" border="0" style="width:970;">
				<tr class="h23">
					<td width="31">Q'ty</td>
					<td width="119"><input type="text" name="pck_qty" style="width:55;text-align:right;direction:rtl;" class="input"
						dataformat="int" maxlength="7" caption="Q'ty">
					<input type="text" name="ams_pck_tp_cd" style="width:38;text-align:center;" class="input"
						dataformat="eng" maxlength="3" caption="Q'ty Code"></td>
					<td width="33">WGT</td>
					<td width="190">
						<input type="text" name="cgo_wgt" style="width:105;text-align:right;direction:rtl;" class="input"	dataformat="float" maxlength="15" caption="WGT">&nbsp;&nbsp;
						<script language="javascript">ComComboObject('wgt_ut_cd', 1, 60, 1, 3);</script>
					<!-- <input type="text" name="wgt_ut_cd" style="width:38;text-align:center;" class="input"
						dataformat="eng" maxlength="3" caption="WGT Code"> -->
					</td>
					<td width="100">Direct Delivery</td>
					<td width=""><input type="text" name = "dir_de_flg" style="width:36;" class="input2" value="" readonly="true"></td>
					<td align="right">
						<table border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_edit">Edit</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				</tr>
			</table>
		</td>
	</tr>
</table>

<table width="100%" class="button" border="0">
	<tr>
		<td class="btn2_bg">
			<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_customer">Customer Master</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_container">Container</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_cm">C/M</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_blcharge">B/L Charge</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
				</tr>
			</table>
		</td>
	</tr>
</table>

<!-- Hidden sheet for Transaction (S) -->
<table width="100%" id="mainTable">
	<tr>
		<td width="100%"><script language="javascript">ComSheetObject('t0sheet1');</script></td>
	</tr>
</table>
<!-- Hidden sheet for Transaction (E) -->

<!--biz page 2 (S)-->
<table border="0" width="100%" height="0" style="display:inline">
	<tr>
		<td><script language="javascript">comRdObject('report1');</script></td>
	</tr>
</table>
<!--biz page 2 (E)-->

<!-- Tab ) (S) -->
<table class="tab" border="0" cellpadding="0" cellspacing="0" width="100%">
<tr>
	<td width="100%">
		<script language="javascript">ComTabObject('tab1')</script>
	</td>
</tr>
</table>
<!-- Tab ) (E) -->

<!-- iFrame (S) -->
<div id="tabLayer" style="display:none">
<iframe name="t1frame" id="t1frame" frameborder="0" scrolling="no" width="998" height="310" src="about:blank"></iframe>
</div>
<div id="tabLayer" style="display:none">
<iframe name="t2frame" id="t2frame" frameborder="0" scrolling="no" width="998" height="310" src="about:blank"></iframe>
</div>
<div id="tabLayer" style="display:none">
<iframe name="t3frame" id="t3frame" frameborder="0" scrolling="no" width="998" height="310" src="about:blank"></iframe>
</div>
<div id="tabLayer" style="display:none">
<iframe name="t4frame" id="t4frame" frameborder="0" scrolling="no" width="998" height="310" src="about:blank"></iframe>
</div>
<div id="tabLayer" style="display:none">
<iframe name="t5frame" id="t5frame" frameborder="0" scrolling="no" width="998" height="310" src="about:blank"></iframe>
</div>
<div id="tabLayer" style="display:none">
<iframe name="t6frame" id="t6frame" frameborder="0" scrolling="no" width="998" height="310" src="about:blank"></iframe>
</div>
<div id="tabLayer" style="display:none">
<iframe name="t7frame" id="t7frame" frameborder="0" scrolling="no" width="998" height="310" src="about:blank"></iframe>
</div>
<!-- iFrame (E) -->

<!--Button (S) -->
<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:;">
	<tr>
		<td class="btn1_bg">
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
				<tr><td>
				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td class="btn1_line"></td>
					<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_save">Save</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_del">Delete</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_reactivate">Reactivate</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_print">Print</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
				</tr>
				</table>
				</td>
				<td align="right">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td id="btn_div_dp"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_div">DIV</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_view">View Receive File</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_transmit">Transmit AI</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_trans_ptt">Transmit PTT</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_trans_isf">Transmit ISF</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td>
						<select name="sel_isf_act_cd">
							<option value="A">A:Add</option>
							<option value="D">D:Delete</option>
							<option value="R">R:Replace</option>
						</select>
					</td>
				</tr>
				</table>
				</td></tr>
			</table>
		</td>
	</tr>
</table>
<!--Button (E) -->

</td>
</tr>
</table>

<%@include file="/apps/alps/esm/bkg/bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_CLOSE.jsp" %>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>