<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0079_04.jsp
*@FileTitle : Container Information - Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.05.19 김영출
* 1.0 Creation
===============================================================================
 History
 2010.09.13 이일민 [CHM-201005276-01] ALPS-[BKG/DOC]주요UI버턴-단축키 기능개발
 2011.04.12 정선용 [CHM-201109867-01] China 24HR Container Seal Kind/Code로직 추가
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event.EsmBkg007904Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List" %>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO" %>
<%@ page import="com.hanjin.apps.alps.esm.bkg.common.*" %>

<%
	EsmBkg007904Event  event = null;			//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.OutboundBLMgt.BLDocumentation");

	// search Init
	String bkgNo      = "";
	String blNo       = "";
	String scrnAuth   = "";

	//List<BkgComboVO> frt_terms = null;
	List<BkgComboVO> wgt_units = null;
	List<BkgComboVO> meas_units = null;

	try {

	   	SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg007904Event)request.getAttribute("Event");
		bkgNo      = event.getBkgNo();
		blNo       = event.getBlNo();
		
		scrnAuth   = (String)event.getAttribute("SCRN_AUTH");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        //frt_terms = (List<BkgComboVO>) eventResponse.getCustomData("frt_terms");
        wgt_units = (List<BkgComboVO>) eventResponse.getCustomData("wgt_units");
        meas_units = (List<BkgComboVO>) eventResponse.getCustomData("meas_units");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Container Information - Creation</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		// 글로벌 변수
		cur_usr_id = "<%=strUsr_id%>";
		scrnAuth = "<%=scrnAuth%>";
	    rcv_term_str = "Y|D|S|T|I";
	    del_term_str = "Y|D|S|T|O";
	    seal_knd_str = " |M|E";
	    seal_pty_tp_str = " |SH|CA|AA|CU|AB|AC|TO";

		// 화면 초기화
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
<!-- 개발자 작업	-->
<input type="hidden" name="dirty_flag">
<input type="hidden" name="bdr_flg">
<input type="hidden" name="corr_flg">
<input type="hidden" name="ca_exist_flg">
<input type="hidden" name="fnl_cfm_flg">
<input type="hidden" name="modify_fnl_cfm_flg">
<input type="hidden" name="cn_flg">
<input type="hidden" name="not_updated_flg">
<input type="hidden" name="flex_hgt_flg">
<input type="hidden" name="obl_iss_flg">
<input type="hidden" name="bl_tp_cd">
<input type="hidden" name="not_crd_flg">
<input type="hidden" name="cn_dir_flg">
<input type="hidden" name="old_bkg_no" value="<%= bkgNo%>">
<input type="hidden" name="bkg_pck_qty">
<input type="hidden" name="bkg_wgt_qty">
<input type="hidden" name="bkg_meas_qty">
<input type="hidden" name="stwg_cd">

<!-- RD Param Start -->
<input type="hidden" name="com_mrdPath">
<input type="hidden" name="com_mrdArguments">
<input type="hidden" name="com_mrdDisableToolbar">
<input type="hidden" name="com_mrdTitle">
<input type="hidden" name="com_mrdBodyTitle">
<input type="hidden" name="save_seal_flg" value="Y">
<!-- RD Param End -->

	<!--biz page (S)-->
		<table class="search" id="mainTable"  style="width:979;"> 
   		<tr><td class="bg">	   		

	<!--  biz_1  (S) -->
	<table class="search" border="0" style="width:979;">
	<tr class="h23">
		<td width="50">BKG No.</td>
		<td width="200">
		<input type="text" id="bkg_no" name="bkg_no" maxlength=13 style="ime-mode:disabled;width:120px;" dataformat="engupnum" class="input1" value="<%=bkgNo%>"> 
		<img class="cursor" src="img/btns_inquiry.gif" width="19" height="20" border="0" align="absmiddle" name="btn_splitPop">
		</td>
		<td width="55">B/L No.</td>
		<td width="160"><input type="text" name="bl_no" maxlength=13 style="ime-mode:disabled;width:110px;" dataformat="engupnum" class="input" value="<%=blNo%>"></td>
		<td width="55">BKG STS</td>
		<td width="78"><input type="text" name="bkg_sts_cd" style="ime-mode:disabled;width:20;" dataformat="engupnum" class="input2" readOnly></td>
		<td width="73">Cargo Type</td>
		<td width=""><input type="text" name="bkg_cgo_tp_cd" style="ime-mode:disabled;width:25;" dataformat="engupnum" class="input2" readOnly></td>
	</tr>
	</table>
	<table class="line_bluedot"><tr><td></td></tr></table>
	<table class="search" border="0" style="width:979;">
	<tr class="h23">
		<td width="50">T/VVD</td>
		<td width="200"><input type="text" name="t_vvd" size="14" class="input2" readOnly></td>
		<td width="45">Route</td>
		<td width="306">
		<input type="text" name="por_cd" style="ime-mode:disabled;width:60;" dataformat="engupnum" class="input2" readOnly>
		<input type="text" name="pol_cd" style="ime-mode:disabled;width:60;" dataformat="engupnum" class="input2" readOnly>
		<input type="text" name="pod_cd" style="ime-mode:disabled;width:57;" dataformat="engupnum" class="input2" readOnly>
		<input type="text" name="del_cd" style="ime-mode:disabled;width:57;" dataformat="engupnum" class="input2" readOnly></td>
		<td width="70">R/D Term</td>
		<td width="100">
		<input type="text" name="rcv_term_cd" style="ime-mode:disabled;width:25;" dataformat="engupnum" class="input2" readOnly>
		<input type="text" name="de_term_cd" style="ime-mode:disabled;width:25;" dataformat="engupnum" class="input2" readOnly></td>
		<td><!--table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
			<tr><td class="btn2_left"></td>
			<td class="btn2" name="btn_CargoDtl">Cargo DTL</td>
			<td class="btn2_right"></td>
			</tr>
			</table--></td>
		<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
			<tr><td class="btn2_left"></td>
			<td class="btn2" name="btn_VarianceDtl">Vol. Difference</td>
			<td class="btn2_right"></td>
			</tr>
			</table></td>
		</tr>
	</table>

		<table class="height_5"><tr><td></td></tr></table>

		<table class="search" border="0" style="width:979;">
		<tr class="h23">
		<td width="300">

		<!-- BKG Qty data -->
		<table width="100%"  id="mainTable">
			<tr>
				<td width="100%">
					<script language="javascript">ComSheetObject('t6sheet1');</script>
				</td>
			</tr>
		</table>
		<!-- BKG Qty data -->

		<td width="10">&nbsp;</td>
		<td width="550"><table border="0" style="width:100%;height:100%;background-color:white;" class="grid2">
					<tr class="tr2_head">
						<td width="12%">Total</td>
						<td width="12%">Quantity</td>
						<!--td width="16%">SPC CGO CNTR</td-->
						<td width="12%">Package</td>
						<td width="12%">Weight</td>
						<td width="12%" id="wgt_ut_cd" class="input2" readOnly></td>
						<td width="12%">Measure</td>
						<td width="12%" id="meas_ut_cd" class="input2" readOnly></td>
				</tr>
				<tr><td class="tr2_head2">Booking</td>
					<td align="right" id="bkg_qty" class="input2" readOnly></td>
					<!--td align="right" id="bkg_spc_qty" class="input2" readOnly></td-->
					<td align="right" id="ori_bkg_pck_qty" class="input2" readOnly></td>
					<td colspan="2" align="right" id="ori_bkg_act_wgt" class="input2" readOnly></td>
					<td colspan="2" align="right" id="ori_bkg_meas_qty" class="input2" readOnly></td>
				</tr>
				<tr><td class="tr2_head2">Container</td>
					<td align="right" id="cntr_qty" class="input2" readOnly></td>
					<!--td align="right" id="cntr_spc_qty" class="input2" readOnly></td-->
					<td align="right" id="cntr_pck_qty" class="input2" readOnly></td>
					<td colspan="2" align="right" id="cntr_act_wgt" class="input2" readOnly></td>
					<td colspan="2" align="right" id="cntr_meas_qty" class="input2" readOnly></td>
				</tr>
				<tr><td class="tr2_head2">Variance</td>
					<td align="right" id="var_qty"  class="input2"></td>
					<!--td align="right" id="var_spc_qty" class="input2"></td-->
					<td align="right" id="var_pck_qty" class="input2"></td>
					<td colspan="2" align="right" id="var_act_wgt" class="input2"></td>
					<td colspan="2" align="right" id="var_meas_qty" class="input2"></td>
				</tr>
				</table>
		</td>
		<td width="10">&nbsp;</td>
		<td width=""><table border="0" style="width:100%;height:100%;background-color:white;" class="grid2"> 
					<tr class="tr2_head">
						<td width="100%">Weight</td>
					</tr>
					<tr>
						<td class="input">
						<%=HTMLUtil.getComboString("bkg_wgt_ut_cd", "width:98%;", "input", "", wgt_units)%>
						<!--select style="width:98%;" class="input">
						<option value="0" selected>KGB</option>
						<option value="1"></option>
						<option value="2"></option></select--></td>
					</tr>
					<tr class="tr2_head">
						<td width="100%">Measure</td>
					</tr>
					<tr>
						<td class="input">
						<%=HTMLUtil.getComboString("bkg_meas_ut_cd", "width:98%;", "input", "", meas_units)%>
						<!--select style="width:98%;" class="input">
						<option value="0" selected>CBM</option>
						<option value="1"></option>
						<option value="2"></option></select--></td>
					</tr>
				</table>
		</td>
		</tr>
		</table>
		<table class="height_5"><tr><td></td></tr></table>
		<!--  biz_1   (E) -->


		<!-- Container data -->
			<table width="100%"  id="mainTable">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('t6sheet2');</script>
					</td>
				</tr>
			</table>
		<!-- Container data -->

		<!-- seal no -->
			<table width="100%"  id="mainTable">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('t6sheet3');</script>
					</td>
				</tr>
			</table>

			<!-- term qty -->
			<table width="100%"  id="mainTable">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('t6sheet4');</script>
					</td>
				</tr>
			</table>

			<!-- term qty -->
			<table width="100%"  id="mainTable">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('t6sheet5');</script>
					</td>
				</tr>
			</table>
				
		<!--  Button_Sub (S) -->
		<table width="100%" class="button">
		<tr><td class="btn2_bg">
			<table border="0" cellpadding="0" cellspacing="0"><tr>
					<td width="" style="font-weight: bold;">Show VGM
					<input type="checkbox" name="chk_show_vgm" style="ime-mode:disabled;width:30px;" class="input2"onclick="javascript:checkShowVGM();" ></td>
			        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_t6gridcntrodcy">CNTR&nbsp;Info&nbsp;from&nbsp;ODCY</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_t6gridcntrirr">CRD&nbsp;P/Up</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_t6gridadd">Row&nbsp;Add</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_t6griddel">Row&nbsp;Delete</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_t6gridmove">Copy & Move</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><!--td>&nbsp;</td-->
					<td class="btn2" name="btn_t6sequp"><img src="img/btn_2_left_up.gif" name="btn_t6sequp" width="17" height="19" alt="" border="0"></td>
					<!--td class="btn2" name="btn_t6sequp">Seq.&nbsp;Up</td-->
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><!--td>&nbsp;</td-->
					<td class="btn2" name="btn_t6seqdown"><img src="img/btn_2_left_down.gif" name="btn_t6seqdown" width="17" height="19" alt="" border="0"></td>
					<!--td class="btn2" name="btn_t6seqdown">Seq.&nbsp;Down</td-->
					<td class="btn2_right"></td>
					</tr>
					</table></td>
				</tr></table>
		</td></tr>
		</table>
		<!-- Button_Sub (E) -->
		<table class="height_5"><tr><td colspan="8"></td></tr></table>

		<table class="search" border="0" style="width:979;">
			<tr class="h23">
				<td width="320">Final Confirm
				<input type="text" name="evnt_usr_id" style="ime-mode:disabled;width:100px;" class="input2" readOnly>
				<input type="text" name="evnt_dt" style="ime-mode:disabled;width:120px;" class="input2" readOnly></td>
				<td width="">Cargo Receiving Date
				<input type="text" name="cgo_rcv_dt" style="ime-mode:disabled;width:120px;" class="input2" readOnly></td></tr>
		</table>
		</td></tr>
	</table>
<!--biz page (E)-->
<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
		<tr><td class="btn1_bg">
			<table border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_t6retrieve" id="btn_t6retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_t6save" id="btn_t6save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_t6cntrconfirm" id="btn_t6cntrconfirm">Container Confirmation</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_t6cntrrelease">Cancel Confirmation</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_t6cntrhist">CNTR History</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_t6notupdated">Not Updated CNTR</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>

				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_t6downexcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_t6print">Print</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
		<!--Button (E) -->

<!-- 개발자 작업  끝 -->
<div id="layList" name="layList" style="position:absolute;z-index:999;display:none" CELLPADDING=5 CELLSPACING=0 BORDER=0/>
<IFRAME id="ifrm" name="ifrm" src="apps/alps/esm/bkg/bookingcommon/bookingutil/jsp/esm_booking_split_no.html"  frameborder=0 marginHeight=0 marginWidth=0 width=115 height=82  style="position:absolute;border:1 #e9e9e9 solid" CELLSPACING=0 scrolling="no"/>
</form>
</body>
</html>