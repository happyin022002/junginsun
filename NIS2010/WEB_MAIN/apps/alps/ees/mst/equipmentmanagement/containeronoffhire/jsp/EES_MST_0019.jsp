<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_mst_0004.jsp
*@FileTitle : Container Master Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.04
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2009.06.04 이호선
* 1.0 Creation
* history 
* 2013.07.23 채창호 [CHM-201325661] ALPS Master-Master Inquiry 및 Status Update/Inquiry화면에서  컨테이너 번호 입력란 로직 변경
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.event.EesMst0019Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMst0019Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String popup_mode = "";
	popup_mode = JSPUtil.getParameter(request, "popup_mode".trim(), "");
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.EquipmentManagement.ContainerOnOffHire");
	String cntr_no = "";
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesMst0019Event)request.getAttribute("Event");
		cntr_no = (String) JSPUtil.getParameter(request ,"cntr_no".trim(), "");
		if (cntr_no == null) cntr_no ="";
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

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
<title>Container Master Inquiry</title>
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

<body <%if(popup_mode.equals("Y")){ %> class="popup_bg" <%} %>  onLoad="setupPage();">
<form name="form" accept-charset=”UTF-8”>
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="hid_off_hire_avail">
<!-- 개발자 작업	-->

<!-- OUTER - POPUP (S)tart -->
<%if(popup_mode.equals("Y")){ %>
<table width="100%" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
<tr><td valign="top">
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;&nbsp;Container Master Inquiry</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
<%} else { %>
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"> Container Master Inquiry</td></tr>
		</table>
		<!--Page Title, Historical (E)-->
<%} %>
	<!--Page Title, Historical (E)-->
			<table class="search"> 
			<tr><td class="bg">

				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="85">CNTR No.</td>
					<td width="182"><input type="text" style="width:90;ime-mode:disabled;text-align:center;text-transform:uppercase;" class="input1" dataformat="engup" maxlength="10" name = "cntr_no" value="<%=cntr_no%>">&nbsp;<input type="text" style="width:13;" class="input"  name = "chk_dgt" dataformat="int" maxlength="1" value="">
                    <div id="div_dcond1" style="display:inline">					
					<input type="text" style="width:53;" class="input"  readOnly value="" name = "aciac_div_cd1" style="text-align:center">
					</div>
					<div id="div_dcond2" style="display:none">
					<input type="text" style="width:53;" class="input"  readOnly value="" name = "aciac_div_cd2" style="text-align:center;color:yellow;background-color:FF0000;font-weight:bold;">
					</div>
					&nbsp;</td>
					<td width="45">TP/SZ</td>
					<td width="45"><input type="text" style="width:30;" class="input"  readOnly value="" name = "cntr_tpsz_cd" style="text-align:center"></td>
					<td width="65">ISO Code</td>
					<td width="85"><input type="text" style="width:38;" class="input"  readOnly value="" name = "cntr_tpsz_iso_cd" style="text-align:center"></td>
					<td width="55">Material</td>
					<td width="100"><input type="text" style="width:80;" class="input"  readOnly value="" name = "cntr_mtrl_cd" style="text-align:center"></td>
					<td width="80">Tare Weight</td>
					<td width="" class="sm"><input type="text" style="width:60;" class="input"  readOnly value="" name = "tare_wgt" style="text-align:right"> KG &nbsp;&nbsp;&nbsp;<input type="text" style="width:60;" class="input"  readOnly value="" name = "tare_wgt_lbs" dataformat="int" style="text-align:right"> LBS<input type="hidden" name = "cntr_spec_no"></td>
				</tr> 
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="85">Lease Term</td>
					<td width="95"><input type="text" style="width:90;" class="input"  readOnly value="" name = "sub_lstm_cd" style="text-align:center"></td>
					<td width="117">Owner Lease Term</td>
					<td width="210"><input type="text" style="width:110;" class="input"  readOnly value="" name = "lstm_cd" style="text-align:center"></td>
					<td width="55">Current</td>
					<td width="99"><input type="text" style="width:80;" class="input"  readOnly value="" name = "cntr_use_co_cd" style="text-align:center"></td>
					<td width="80">Ownership</td>
					<td style="padding-left:1;"><input type="text" style="width:60;" class="input"  readOnly value="" name = "ownr_co_cd" style="text-align:center">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input style="color:red;font-weight:bold;width:60;text-decoration:blink;" type="text" class="input" readOnly value="" name = "cntr_rsk_flg" style="text-align:center"></td>
				</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="85">Manufacturer</td>
					<td width="360"><input type="text" style="width:90;" class="input"  readOnly value="" name = "vndr_abbr_nm" style="text-align:center">&nbsp;<input type="text" style="width:228;" class="input"  readOnly value="" name = "vndr_lgl_eng_nm" style="text-align:left"></td>
					<td width="117">Manufacture Date</td>
					<td width="95"><input type="text" style="width:80;" class="input"  readOnly value="" name = "mft_dt" style="text-align:center"></td>
					<td><input type="checkbox" class="trans"  readOnly name="d2_payld_flg" onClick="return false">D2-LP</td>
					<td width="" align="left"><input style="color:red;background-color:D3DBFF;font-weight:bold;width:247;text-decoration:blink;" type="text" class="input" readOnly value="" name = "off_hire_avail" style="text-align:center"></td>
				</tr></table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
				<tr class="h23">
					<td width="85">BKG Info.</td>
					<td width="360"><input type="text" style="width:110;text-decoration:underline;color:blue;cursor:hand;" class="input"  readOnly value="" name = "bkg_no1" style="text-align:center">&nbsp;<input type="text" style="width:110;text-decoration:underline;color:blue;cursor:hand;" class="input"  readOnly value="" name = "bkg_no2" style="text-align:center">&nbsp;<input type="text" style="width:110;text-decoration:underline;color:blue;cursor:hand;" class="input"  readOnly value="" name = "bkg_no3" style="text-align:center"></td>
					<td width="82" align="center">CSC No.</td>
					<td><input type="text" style="width:115" style="text-align:center" class="input" value="" name="apro_csc_no" readOnly></td>
					<td width="58" align="center">TIR No.</td>
					<td><input type="text" style="width:115" style="text-align:center" class="input" value="" name="apro_tir_no" readOnly></td>
					<td width="70" align="center">CERTI No.</td>
					<td><input type="text" style="width:70" style="text-align:center" class="input" value="" name="certi_no" readOnly></td>
				</tr>
				</table>
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<div style="display: none;"><script language="javascript">ComSheetObject('sheet1');</script></div>
						</td>
					</tr>
				</table>				
				<!--  biz_1  (E) -->

				<table class="line_bluedot"><tr><td></td></tr></table>


				<!--  biz_2  (S) -->
				<table class="search" border="0">
					<tr><td class="title_h"></td>
					<td class="title_s">RF Unit</td></tr>
				</table>
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="35">Type</td>
					<td width="70"><input type="text" style="width:50;" class="input"  readOnly value="" name = "rf_tp_cd" style="text-align:center"></td>
					
					<td width="45">Maker</td>
					<td width="170"><input type="text" style="width:150;" class="input"  readOnly value="" name = "rf_mkr_seq" style="text-align:Left"></td>
					<td width="65">Model No.</td>
					<td width="160"><input type="text" style="width:150;" class="input"  readOnly value="" name = "rf_mdl_nm" style="text-align:Left"></td>
					<td width="75">Refrigerant</td>
					<td width="120"><input type="text" style="width:100;" class="input"  readOnly value="" name = "rf_rfr_no" style="text-align:Left"></td>
					<td width="90">Temperature</td>
					<td width=""><input type="text" style="width:50;" class="input"  readOnly value="" name = "min_temp" style="text-align:Right"> ~ <input type="text" style="width:50;" class="input"  readOnly value="" name = "max_temp" style="text-align:Right">&nbsp;℃</td>
				</tr>
				</table>
				<!--  biz_2  (E) -->
			</td></tr>
			</table>
			
			<table class="height_8"><tr><td></td></tr></table>

			<table class="search"> 
			<tr><td class="bg">

				<!--  biz_2  (S) -->
				<table class="search" border="0">
					<tr><td class="title_h"></td>
					<td class="title_s">Current Status</td></tr>
				</table>
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="110">Movement Status</td>
					<td width="80">&nbsp;<input type="text" style="width:53;" class="input"  readOnly value="" name = "cnmv_sts_cd" style="text-align:center"></td>
					<td width="30">Yard</td>
					<td width="160"><input type="text" style="width:80;" class="input"  readOnly value="" name = "crnt_yd_cd" style="text-align:center"></td>
					<td width="75">VVD Code</td>
					<td width="167"><input type="text" style="width:50;" class="input"  readOnly value="" name = "vsl_cd" style="text-align:center">&nbsp;<input type="text" style="width:50;" class="input"  readOnly value="" name = "skd_voy_no" style="text-align:center">&nbsp;<input type="text" style="width:25;" class="input"  readOnly value="" name = "skd_dir_cd" style="text-align:center"></td>
					<td width="60">Act Date</td>
					<td width=""><input type="text" style="width:120;" class="input"  readOnly value="" name = "cnmv_dt" style="text-align:center"></td>
				</tr> 
				<tr><td height="3"></td></tr>
				</table>

			
				<table class="search_sm2" border="0" style="width:900;">
					<tr class="h23">
							<td width="60"><input type="checkbox" value="Y" class="trans" name="full_flg" onClick="return false">Full</td>
							<td width="100"><input type="checkbox" value="Y" class="trans" name="dmg_flg" onClick="return false">Damaged</td>
							<td width="130"><input type="checkbox" value="Y" class="trans" name="imdt_ext_flg" onClick="return false">Immediate Exit</td>
							<td width="70">H/Rack TP</td>
							<td width="70"><input type="text" style="width:50;" class="input" readOnly name="cntr_hngr_rck_cd" style="text-align:center"></td>
							<td width="50">H/B TP</td>
							<td width="70"><input type="text" style="width:50;" class="input" readOnly name="mnr_hngr_bar_tp_cd" style="text-align:center"></td>
							<td width="55">H/B Qty</td>
							<td width="50"><input type="text" style="width:30;" class="input" readOnly name="cntr_hngr_bar_atch_knt" style="text-align:right"></td>
							<td width="60"><input type="checkbox" value="Y" class="trans" name="plst_flr_flg" onClick="return false">P/F</td>
							<td width="65"><input type="checkbox" value="Y" class="trans" name="disp_flg" onClick="return false">DISP</td>
							<td width="62"><input type="checkbox" value="Y" class="trans" name="ls_flg" onClick="return false">L/S</td>
							<td width=""><input type="checkbox" value="Y" class="trans" name="uc_flg" onClick="return false">U/C</td>
					</tr>
				</table>
				
				<!--  biz_2  (E) -->
				<table class="line_bluedot"><tr><td></td></tr></table>


				<!--  biz_3  (S) -->
				<table class="search" border="0">
					<tr><td class="title_h"></td>
					<td class="title_s">Entry</td></tr>
					
				</table>
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="40">Date</td>
					<td width="110"><input type="text" style="width:80;" class="input"  readOnly value="" name = "onh_dt" style="text-align:center"></td>
					<td width="45">Status</td>
					<td width="70"><input type="text" style="width:40;" class="input"  readOnly value="" name = "onh_cntr_sts_cd" style="text-align:center"></td>
					<td width="62">AGMT No.</td>
					<td width="120"><input type="text" style="width:90;" class="input"  readOnly value="" name = "onh_agmt_no" style="text-align:center"></td>
					<td colspan="5"></td>
					<!--<td width="130"></td>
					<td width="50"></td>
					<td width=""></td>-->
				</tr> 
				<tr class="h23">
					<td width="40">Lessor</td>
					<td colspan="7"><input type="text" style="width:80;" class="input"  readOnly value="" name = "vndr_seq" style="text-align:Center">&nbsp;<input type="text" style="width:293;" class="input"  readOnly value="" name = "lessor_nm" style="text-align:Left"></td>
					<td width="30">URL</td>
					<td width="180" colspan="3"><input type="text" class="input"  readOnly value="" name = "lse_vndr_url" style="width:270;text-decoration:underline;color:blue;cursor:hand;text-align:left;"></td>
					<!--td width="30">DPP</td>
					<td width="180" ><input type="text" style="width:50;" class="input"  readOnly value="" name = "dpp_tp_cd" style="text-align:center"></td>
					<td width="93">DPP Coverage</td>
					<td width=""><input type="text" style="width:100;" class="input"  readOnly value="" style="text-align:right" name = "dpp_amt" style="text-align:center"></td-->					
				</tr>
				</table>
				<!--  biz_3  (E) -->

				<table class="line_bluedot"><tr><td></td></tr></table>

				<!--  biz_4  (S) -->
				<table class="search" border="0">
					<tr><td class="title_h"></td>
					<td class="title_s">Exit</td></tr>
					
				</table>
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="40">Date</td>
					<td width="110"><input type="text" style="width:80;" class="input"  readOnly value="" name = "cntr_sts_evnt_dt" style="text-align:center"></td>
					<td width="45">Status</td>
					<td width="70"><input type="text" style="width:40;" class="input"  readOnly value="" name = "cntr_sts_cd" style="text-align:center"></td>
					<td width="62">AGMT No.</td>
					<td width="120"><input type="text" style="width:90;" class="input"  readOnly value="" name = "exit_agmt_no" style="text-align:center"></td>
					<td colspan="5"></td>
					<!--<td width="180"></td>
					<td width="93"></td>
					<td width=""></td>-->
				</tr> 
				<tr class="h23">
				    <td width="40">Lessor</td>	
					<td colspan="5"><input type="text" style="width:80;" class="input"  readOnly value="" name = "exit_vndr_seq" style="text-align:Center">&nbsp;<input type="text" style="width:293;" class="input"  readOnly value="" name = "exit_vndr_eng_nm" style="text-align:Left"></td>
					<td width="30">DPP</td>
					<td width="180"><input type="text" style="width:50;" class="input"  readOnly value="" name = "dpp_tp_cd" style="text-align:center"></td>
					<td width="93">DPP Coverage</td>
					<td width=""><input type="text" style="width:100;" class="input"  readOnly value="" style="text-align:right" name = "dpp_amt" style="text-align:center"></td>
				</tr> 				
				</table>
				<!--  biz_4  (E) -->
			</td></tr>
			</table>

			<table class="height_8"><tr><td></td></tr></table>

			<table class="search"> 
			<tr><td class="bg">

				<!--  biz_5  (S) -->
				<table class="search" border="0">
					<tr><td class="title_h"></td>
					<td class="title_s">Value & Cost</td></tr>
					
				</table>
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="50">D/Value</td>
					<td width="100"><input type="text" style="width:70;" class="input"  readOnly value="" name = "dpc_val" style="text-align:right"></td>
					<!-- 
					<td width="55">B/Value</td>
					<td width="100"><input type="text" style="width:80;" class="input"  readOnly value="" name = "bpc_val" style="text-align:right"></td>
					-->
					<td width="105">Total Using Days</td>
					<td width="195"><input type="text" style="width:65;" class="input"  readOnly value="" name = "using_days" style="text-align:right"></td>
					<td width="124">Total Rental Charge </td>
					<td width="80"><input type="text" style="width:65;" class="input"  readOnly value="" name = "rntl_chg_amt" style="text-align:right"></td>
					<td width="100">Total M&R Cost</td>
					<td width=""><input type="text" style="width:100;" class="input"  readOnly value="" name = "cost_amt" style="text-align:right"></td>
				</tr> 
				</table>
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
				</tr> 
				</table>
				<!--  biz_5  (E) -->
			</td></tr>
			</table>

			<table class="height_8"><tr><td></td></tr></table>

			<table class="search"> 
			<tr><td class="bg">

				<!--  biz_6  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="50">Created</td>
					<td width="402"><input type="text" style="width:70;" class="input"  readOnly value="" name = "cre_dt" style="text-align:center">&nbsp;<input type="text" style="width:120;" class="input"  readOnly value="" name = "cre_usr_id" style="text-align:center"></td>
					<td width="50">Updated</td>
					<td><input type="text" style="width:70;" class="input"  readOnly value="" name = "upd_dt" style="text-align:center">&nbsp;<input type="text" style="width:120;" class="input"  readOnly value="" name = "upd_usr_id" style="text-align:center"></td>
				</tr>
				 </table>
				<!--  biz_6  (E) -->
				
			</td></tr>
		</table>
	<!--biz page (E)-->
		
		
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				
				<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_spec">SPEC</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_mvmt">Movement</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_status">Status</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_mnr">M&R</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_doldoc">AGMT</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
		</td></tr>
		</table>
    <!--Button (E) -->
    <table class="height_5"><tr><td></td></tr></table>
	</td></tr>
</table>
	</td></tr>
</table>
	<%if(popup_mode.equals("Y")){ %>
	<!-- : ( Button : pop ) (S) -->
	<table width="100%" class="sbutton">
	<tr><td height="71" class="popup">
	
	    	<!--Button (S) -->	
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
	       		<tr><td class="btn3_bg">
			    <table border="0" cellpadding="0" cellspacing="0">
			    <tr>
			    	<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_close">Close</td>
						<td class="btn1_right">
					</tr></table></td>
				</tr>
				</table></td>
				</tr>
			</table>
	    	<!--Button (E) -->
		
		</td></tr>
	</table>
	<% } %>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
