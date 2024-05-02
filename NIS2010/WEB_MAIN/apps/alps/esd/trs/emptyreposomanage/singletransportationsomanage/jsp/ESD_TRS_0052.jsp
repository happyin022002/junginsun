<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0052.jsp
*@FileTitle : Empty Repo & S/T On/Off Hire S/O Correction
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-30
*@LastModifier : kim_sang_geun
*@LastVersion : 1.0
* 2006-10-30 kim_sang_geun
* @history
  N200902050050 2009-03-04 Empty repo s/o creation Option 일부 수정 (From / to date : 오늘 기준 +- 7일 )
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.trs.emptyreposomanage.singletransportationsomanage.event.EsdTrs0012Event"%>

<%
	SignOnUserAccount account = null; //Session 정보
	EsdTrs0012Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	
	Exception serverException   = null;			//서버에서 발생한 에러
	DBRowSet rowSet	  = null;							   //DB ResultSet
	String strErrMsg = "";								 //에러메세지
	int rowCount	 = 0;								  //DB ResultSet 리스트의 건수

	String selKIND = ""; //Kind
	String selTRANSMODE = ""; //Transportation Mode
	String optionStr = "000020:ALL:ALL";

	String today = DateTime.getFormatString("yyyyMMdd");

	// N200902050050 2009-03-04 Empty repo s/o creation Option 일부 수정 (From / to date : 오늘 기준 +- 7일 )
	String beforeOneMonth = DateTime.addDays(today, -7);
	String afterOneMonth = DateTime.addDays(today, 7);

	try {
		account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		selKIND  = JSPUtil.getCodeCombo("sel_kind", "01", "style='width:100'", "CD00812", 0, optionStr);
		selTRANSMODE  = JSPUtil.getCodeCombo("sel_transmode", "01", "style='width:80'", "CD00283", 0, optionStr);

		event = (EsdTrs0012Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Empty Repo & S/T On/Off Hire S/O Creation</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		// InitTab();
		loadPage();
	}
</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="cbstatus">
<input type="hidden" name="hid_frmreqdate">
<input type="hidden" name="hid_toreqdate">
<input type="hidden" name="hid_cntr_no">
<input type="hidden" name="hid_cntr_tpsz_cd">
<input type="hidden" name="frm_node_verify">
<input type="hidden" name="eq_no_verify">
<input type="hidden" name="ctrl_ofc_cd" value="<%=account.getOfc_cd()%>">
<input type="hidden" name="TRSP_SO_EQ_KIND" value="">
<input type="hidden" name="page_type" value="U">


<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>


		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->

		<!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
	       	<tr><td class="btn1_bg">

				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
				<!-- Repeat Pattern -->
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" id="btn_retrieve" name="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>

				<td class="btn1_line"></td>

				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" id="btn_new" name="btn_reset">Reset</td><td class="btn1_right"></td></tr></table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" id="btn_minimize" name="btn_minimize">Minimize</td><td class="btn1_right"></td></tr></table></td>
				<!-- Repeat Pattern -->

				</tr></table>

			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Button : Main ) (E) -->


		<div id="MiniLayer" style="display:inline">
		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
			<tr>
				<td class="bg">
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="50">Date</td>
							<td width="510">
								<table border="0" style="height:25; width:500;background-color: #E9E9E9;">
									<tr>
										<td width="300" class="sm" style="padding-left:10;">
											<input type="radio" name="rad_date" class="trans" value="R" checked>Requested&nbsp;&nbsp;
											<input type="radio" name="rad_date" value="S" class="trans">Service Order Created
											<input type="radio" name="rad_date" value="B" class="trans">Due Date
										</td>
										<td class="stm">
											<input name="frm_reqdate" class="input1" type="text" style="width:75;" value="<%=beforeOneMonth%>" maxlength="8" onFocus="javascript:delHypen(this);" onBlur="javascript:getHypen(this); getDateBetween(this);">&nbsp;~&nbsp;<input name="to_reqdate" class="input1" type="text" style="width:74;" value="<%=afterOneMonth%>" maxlength="8"  onFocus="javascript:delHypen(this);" onBlur="javascript:getHypen(this);" onKeyup="javascript:doSearchEnter();"><img src="/hanjin/img/blank.gif" width="4" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar">
										</td>
									</tr>
								</table>
							</td>
							<td width="50">Kind</td>
							<td><%=selKIND%></td>
						</tr>
					</table>
					
					<table height="2"><tr><td></td></tr></table>

					<table class="search_in" border="0">
						<tr class="h23">
						<td width="50">From </td>
						<td width="76"><input name="frm_node" type="text" style="width:70;" maxlength="5" onChange="getComboList(this, document.frm_yard, 'F');" onBlur="setgetUpper(this);"></td>
						<td width="100"><script language="javascript">ComComboObject('frm_yard', 1, 59, 0)</script><img src="/hanjin/img/blank.gif" width="4" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name='btns_frmnode'></td>

						<td width="30">To </td>
						<td width="80"><input name="to_node" type="text" style="width:74;" maxlength="5" onChange="getComboList(this, document.to_yard, 'T');" onBlur="setgetUpper(this);"></td>
						<td width="100"><script language="javascript">ComComboObject('to_yard', 1, 60, 0);</script><img src="/hanjin/img/blank.gif" width="4" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name='btns_tonode'></td>

						<td width="80">Trans Mode</td>
						<td width="110"><%=selTRANSMODE%></td>
						<td width="30">Bid.</td>
						<td width="75">
							<SELECT name = "spot_bid_flg" >	
							    <OPTION  value=""> ALL</OPTION>
	                            <OPTION  value="Y">Y</OPTION>
	                            <OPTION  value="N">N</OPTION>
                             </SELECT>
                         </td>
						<td width ="300"></td>
						</tr>
					</table>
					<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="90">Reference No.</td>
							<td width="160">
								<input type="text" style="width:133;" value="" name="reference_no" onKeyup="javascript:doSearchEnter();">
								<img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle" name="btns_multirefno">
							</td>
							<td width="95">Container No.</td>
							<td width="170">
								<input name="cntr_no" type="text" style="width:139;" onKeyup="javascript:doSearchEnter();" onChange="checkDigit(this);">
							    <img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle" name="btns_multicntr">
							</td>
							<td width="45">Bid No.</td>
							<td width="130">
								<input name="spot_bid_no" type="text" style="width:130;" value="" onKeyup="javascript:doSearchEnter();" onBlur="setgetUpper(this);" maxlength=15>
							</td>
							<td width ="200"></td>
						</tr>
					</table>
				</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->
		</div>


		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Tab ) (S) -->
		<table class="tab">
			<tr><td><script language="javascript">ComTabObject('tab1')</script>
			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Tab ) (E) -->
		<div id="tabLayer" style="display:inline">
		<!-- TABLE '#D' : ( Gird BG Box ) (S) -->
		<table class="search" border="0">
			<tr>
				<td class="bg">
					<!-- : ( Grid ) (S) -->
					<table width="100%" id="mainTable">
						<tr><td>
							 <script language="javascript">ComSheetObject('t1sheet1');</script>
						</td></tr>
					</table>
					<!-- : ( Grid ) (E) -->
					<!-- : ( Button_ Sub ) (S) -->
					<table width="100%" class="button">
				       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_sodelete" name="btng_sodelete">S/O Delete</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_downexcel1" name="btng_downexcel1">Down Excel</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_fillincontainers" name="btng_fillincontainers">Fill in CNTR No.</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_separate0" name="btng_separate0">Separate</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_matchmaking1" name="btng_matchmaking1">Matchmaking for Combined Case 1</td><td class="btn2_right"></td></tr></table></td>
							<!-- Repeat Pattern -->
						</tr></table>
					</td></tr>
					</table>
					<table width="100%" class="button">
				       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_verify" name="btng_verify">Verify</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_socreation1" name="btng_socreation1">S/O Correction</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_woissue1" name="btng_woissue1">W/O Issue</td><td class="btn2_right"></td></tr></table></td>
							<!-- Repeat Pattern -->
						</tr>
						</table>
					</td></tr>
					</table>
					<!-- : ( Button_ Sub ) (E) -->
				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Grid BG Box ) (E) -->
		</div>


		<div id="tabLayer" style="display:none">
		<!-- TABLE '#D' : ( Gird BG Box ) (S) -->
		<table class="search" border="0">
			<tr>
				<td class="bg">


					<!-- : ( Grid ) (S) -->
					<table width="100%" id="mainTable">
						<tr><td>
							 <script language="javascript">ComSheetObject('t2sheet1');</script>
						</td></tr>
					</table>
					<!-- : ( Grid ) (E) -->
					<!-- : ( Button_ Sub ) (S) -->

					<table width="100%" class="button">
				       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>

							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_downexcel2" name="btng_downexcel2">Down Excel</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_separate1" name="btng_separate1">Separate</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_socreation2" name="btng_socreation2">S/O Correction</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_woissue2" name="btng_woissue2">W/O Issue</td><td class="btn2_right"></td></tr></table></td>
							<!-- Repeat Pattern -->


						</tr></table>
					</td></tr>
					</table>
					<!-- : ( Button_ Sub ) (E) -->

				</td>
			</tr>
		</table>
		</div>
		<!-- TABLE '#D' : ( Gird BG Box ) (E) -->
<script language="javascript">ComSheetObject('sheet2');</script><!--W/O Issue-->
<script language="javascript">ComSheetObject('sheet3');</script><!-- CNTR verify 용 IB SHEET -->

</td></tr>
</table>
<!-- Outer Table (E)-->

</form>
<form name='woForm' method='POST'>
	<input type='hidden' name='trsp_so_ofc_cty_cd'>
	<input type='hidden' name='trsp_so_seq'>
	<input type='hidden' name='eq_mode'>
	<input	type="hidden" name="sysCommUiTitle" value="Issue">
	<input	type="hidden" name="sysCommUiNavigation" value="Trans S/O > Work Order">
	<input type="hidden" name="pgmNo" value='ESD_TRS_0023'>
</form>
</body>
</html>