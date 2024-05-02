<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0726.jsp
*@FileTitle : Group Update for B/L Issue And Onboard Date
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.15
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.07.15 김영출
* 1.0 Creation
* --------------------------------------------------------
* History
* 2011.04.11 이일민 [CHM-201109940-01] B/L Issue & Onboard date update 보완 요청
* 2012.11.20 이준근 [CHM-201221047-01] B/L Type의 예외적 처리를 위한 변경 요청
* 2013.01.10 조정민 [CHM-201222115][BL Issue&Print기능] (1) BL Status Report-GSO추가 (2) BL Issue&Onboard Date Update-FWDR정보 추가
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event.EsmBkg0726Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0726Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc_cd    = "";
	Logger log = Logger.getLogger("com.hanjin.apps.OutboundBLMgt.BLIssuance");
	
	String tVvd = "";
	String polCd = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc_cd = account.getOfc_cd();

		event = (EsmBkg0726Event)request.getAttribute("Event");
		tVvd = event.getTVvd();
		polCd = event.getPolCd();
		
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
<title>Group Update for B/L Issue And Onboard Date</title>
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
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->

<input type="hidden" name="chkd_iss">

<input type="hidden" name="hrdCdgId" value="BL_ISS_VAL">
<input type="hidden" name="attrCtnt1" value="">
<input type="hidden" name="attrCtnt2" value="">
<input type="hidden" name="attrCtnt3" value="">
<input type="hidden" name="swbPntFlg" value="N">
<input type="hidden" name="blNoStr" value="">
<input type="hidden" name="usrOfcCd" value=<%=strUsr_ofc_cd %>>

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<!--table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="/img/icon_history_dot.gif" align="absmiddle">&nbsp;Sales > FMS > Agreement Inquiry</td></tr>
			<tr><td class="title"><img src="/img/icon_title_dot.gif" align="absmiddle">&nbsp;  Group Update for B/L Issue &amp; Onboard Date</td></tr>
		</table-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>		
	<!--Page Title, Historical (E)-->
	
	
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">

				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="70">1st VVD</td>
					<td width="105"><input type="text" name="vvd" value="<%=tVvd%>" style="ime-mode:disabled;width:90;" dataformat="engupnum" class="input1"></td>
					<td width="70">T.VVD</td>
					<td width="105"><input type="text" name="trunk_vvd" style="ime-mode:disabled;width:90;" dataformat="engupnum" class="input"></td>
					<td width="40">POL</td>
					<td width="65" style="padding-left:2;"><input type="text" name="pol_cd" value="<%=polCd%>" style="ime-mode:disabled;width:50;" dataformat="engupnum" class="input1"></td> 
					<td width="75">Calling Seq.</td>
					<td width="70" style="padding-left:2;"><input type="text" name="pol_clpt_ind_seq" value="1" maxlength="1" style="ime-mode:disabled;text-align:right;width:25;" dataformat="int" class="input1"></td> 
					<td width="30">ETA</td>
					<td width="100"><input type="text" name="act_arr_dt" style="ime-mode:disabled;width:90;" class="input2" readOnly ></td>
					<td width="30">ETD</td>
					<td width="100"><input type="text" name="act_dep_dt" style="ime-mode:disabled;width:90;" class="input2" readOnly ></td> 
					<td width="50">L. REP</td>
					<td width="105"><input type="text" name="ob_srep_cd" style="ime-mode:disabled;width:90;" dataformat="engupnum" class="input"></td> 
					<td width="60">BKG OFC</td>
					<td><input type="text" name="bkg_ofc_cd" style="ime-mode:disabled;width:60;" maxlength="6" dataformat="engupnum" class="input"></td>
				</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="70">BKG No.</td>
					<td width="130"><input type="text" id="bkg_no" name="bkg_no" style="width:90;" maxlength="13" dataformat="engup" class="input1" value="">&nbsp;<img onClick="openAddPaste('bkg_no')" class="cursor" src="img/button/btng_plus.gif" width="19" height="20" border="0" align="absmiddle" name=""></td>
					<td width="470"><table class="search_sm" border="0" width="460">
							<tr class="h23">
								<td width="40">Date</td>
								<td class="stm">(<input type="radio" name="type_date" value="B" class="trans" checked>BKG Date&nbsp;
								<input type="radio" name="type_date" value="O" class="trans">Onboard Date)</td>
								<td width="210"><input type="text" style="width:75" maxlength="10" class="input" name="bkg_from_dt" caption="BKG DT" dataformat="ymd">&nbsp;&nbsp;~&nbsp;&nbsp;<input type="text" style="width:75" maxlength="10" class="input" name="bkg_to_dt" caption="BKG DT" dataformat="ymd">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar"></td>
								</table></td>
					<td width="55">S/C No.</td>
					<td width="100"><input type="text" name="sc_no" style="width:85;" class="input" value="" maxlength=10 style="ime-mode:disabled"  dataformat="engupnum" tabindex=38></td>
					<td width="60">RFA No.</td>
					<td><input type="text" name="rfa_no" style="width:85;" class="input" value="" maxlength=11style="ime-mode:disabled"  dataformat="engupnum" tabindex=38></td>
				</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="70">Shpr Code</td>
					<td width="95"><input type="text" name="shipper_cd" style="ime-mode:disabled;width:75;" maxlength="8" dataformat="engupnum" class="input"></td>
					<td width="76">Cnee Code</td>
					<td width="105"><input type="text" name="cnee_cd" style="ime-mode:disabled;width:85;" maxlength="8" dataformat="engupnum" class="input"></td>
					<td width="80">Fwdr Code</td>
					<td width="105"><input type="text" name="fwdr_cd" style="ime-mode:disabled;width:85;" maxlength="8" dataformat="engupnum" class="input"></td> 
					<td width="85">BL Complete</td>
					<td width="73" style="padding-left:2;">
						<select name="bl_rdy_flg" style="width:50;">
						<option value="N" selected>N</option>
						<option value="Y">Y</option>
						<option value="A">All</option>
						</select></td> 
					<td width="70">B/L Issue</td>
					<td width="73" style="padding-left:2;">
						<select name="obl_iss_flg" style="width:50;">
						<option value="N" selected>N</option>
						<option value="Y">Y</option>
						<option value="A">All</option>
						</select></td> 
					<td width="85">B/L Release</td>
					<td>
						<select name="obl_rlse_flg" style="width:50;">
						<option value="N" selected>N</option>
						<option value="Y">Y</option>
						<option value="A">All</option>
						</select></td> 
				</tr>
				</table>
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="500"><font style="background-color: yellow;font-size: 12">B/L DATA COMPLETE (M&D, Container, Customer)</font><input type="checkbox" name="chk_all_iss_bkg" id="chk_all_iss_bkg" value="N" class="trans" style="background-color: yellow;" onclick="chkAllIssBkg()">
					</td>
				</tr>
				</table>
				
				
				<!--  biz_1   (E) -->

				</td></tr>
			</table>
			<table class="height_8"><tr><td></td></tr></table>
			

		<!-- Grid BG Box  (S) -->
     	<table class="search" id="mainTable">
       	<tr><td class="bg">

				<!--Grid (S)-->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!--Grid (E)-->
				
				
			</td></tr>
		</table>
	<!-- Grid BG Box  (S) -->
	<!--biz page (E)-->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_SaveIssue">Save & Issue</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_blComplete">B/L Complete</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_faxEml">Go to Fax/E-mail</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_SWBRelease">SWB Release</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_DownExcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<!--
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Print">Print</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Select">Select</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Deselect">Deselect</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				-->
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_AdjustDate">Adjust Date</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
						<td>
							<div id="DIV_btn_BlPrint" style="display:none;">
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td>
									<td class="btn1" name="btn_BlPrint">B/L Print</td>
									<td class="btn1_right"></td>
									</tr>
								</table>
							</div>
						</td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>

<!-- 개발자 작업  끝 -->
</form>
<form name="form2" method="POST">
<input type="hidden" name="bkg_no">
<input type="hidden" name="param_ui_id">
</form>
</body>
</html>