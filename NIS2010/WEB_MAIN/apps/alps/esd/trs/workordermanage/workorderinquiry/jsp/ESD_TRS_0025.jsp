<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0025.jsp
*@FileTitle : W/O 발행내역을 조회하는 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-26
*@LastModifier : poong_yeon
*@LastVersion : 1.0
* 2006-12-26 poong_yeon
* 1.0 최초 생성
* 2015.06.23 9014787 [CHM-201535923] W/O Inquiry 개선2
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.trs.workordermanage.workorderinquiry.event.EsdTrs0025Event"%>
<%
	EsdTrs0025Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	DBRowSet rowSet	  = null;							   //DB ResultSet
	String strErrMsg = "";								 //에러메세지
	int rowCount	 = 0;								  //DB ResultSet 리스트의 건수

	SignOnUserAccount account= null;

	try {

		account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);

		event = (EsdTrs0025Event)request.getAttribute("Event");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
	String today = DateTime.getFormatString("yyyyMMdd");
	String beforeOneMonth = DateTime.addMonths(today, -1);
	String optionStr = "000020:ALL:ALL";
	String selCOSTMODE = ""; //Cost Mode
	String selTRANSMODE = ""; //Transportation Mode

	selCOSTMODE  = JSPUtil.getCodeCombo("sel_costmode", "01"	," onChange='bound_OnChange_2(this);', style='width:157'", "CD00958", 0, optionStr);
	selTRANSMODE  = JSPUtil.getCodeCombo("sel_transmode", "01"	," onChange='bound_OnChange_3(this);'", "CD00283", 0, optionStr);
%>
<html>
<head>
<title>W/O History</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">

	var beforeOneMonth = '<%=beforeOneMonth%>';
	var today = '<%=today%>';

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="FORM_CRE_USR_ID" value="<%=account.getUsr_id()%>">
<input type="hidden" name="FORM_USR_OFC_CD" value="<%=account.getOfc_cd()%>">
<input type="hidden" name="TRSP_WO_OFC_CTY_CD">
<input type="hidden" name="TRSP_WO_SEQ">
<input type="hidden" name="WO_ISS_KNT">
<input type="hidden" name="VNDR_SEQ">
<input type="hidden" name="isResend" value='Y'>
<input type="hidden" name="WO_EDI_USE_FLG" value='EDI'>

<input type="hidden" name="hid_costmode">
<input type="hidden" name="hid_transmode">
<input type="hidden" name="wo_no_a">
<!-- 
<input type="hidden" name="search_fm_loc" value=''>
<input type="hidden" name="search_fm_yard" value=''>
<input type="hidden" name="search_via_loc" value=''>
<input type="hidden" name="search_via_yard" value=''>
<input type="hidden" name="search_to_loc" value=''>
<input type="hidden" name="search_to_yard" value=''>
<input type="hidden" name="search_door_loc" value=''>
<input type="hidden" name="search_door_yard" value=''>
-->

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>

		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
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
							<tr><td class="btn1_left"></td><td class="btn1" id="btn_reset" name="btn_reset">Reset</td><td class="btn1_right"></td></tr></table></td>
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
							<td width="155">Work Order Issue Date</td>
							<td width="235" class="stm">
								<input name="fmdate" type="text" maxlength="8" style="width:75">&nbsp;~&nbsp;<input name="todate" type="text" maxlength="8" style="width:75"><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><img class="cursor" img src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" name='btns_calendar' align="absmiddle"></td>
							<td width="100">Service Provider</td>
							<td align="right"><input type='text' name='combo_svc_provider'  style="width:82;" onChange='getTextVendorSeq(sheetObjects[0], document.form, this.value)' onKeyup='enterCheck(this)'><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><input type="text" name='svc_provider' ReadOnly class="input2" style="width:377;"><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name='btng_provider'></td>
						</tr>
					</table>
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="155">Work Order No. </td>
							<td width="190">
								<input name="wo_no" type="text" onBlur='javascript:this.value=this.value.toUpperCase();' style="width:93;" maxlength='180'><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><img class="cursor" img src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle" name='btns_wo_no'></td>
							<td width="150">Work Order Issue Office </td>
							<td width="130">
								<input name="wo_issue_office" type="text" onBlur='javascript:this.value=this.value.toUpperCase();'style="width:82;" value='<%=account.getOfc_cd()%>' maxlength='5' onBlur='value_upper(this)'><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><img class="cursor" img src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name='btns_wo_issue_office' onClick="ofc_OnPopupClick()"></td>
							<td width="143">Work Order Issue User</td>
							<td width="125"><input name="wo_issue_user" type="text" style="width:100;" maxlength='20'></td>
							<td width="30">ETS</td>
							<td align="right">
								<select name="sel_ets">
								<option value=""  selected></option>
								<option value="N" >No</option>
								<option value="Y" >Yes</option></td>
						</tr>
					</table>

			<!-- 조회옵션 추가부분  -->
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="155">Work Order Issue Status</td>
							<td width="190">
                                            <select name="wo_iss_sts" style="width:93;">
											<option value=""  selected>ALL</option>
											<option value="I" >Issued</option>
											<option value="R" >Reissued</option>
											<option value="C" >Correction</option>
											<option value="N" >Cancellation</option></select>
											</td>
							<td width="75">Cost Mode</td>
							<td width="207"><%=selCOSTMODE%></td>



							<td width="70">Issue type</td>
							<td width="149">
                                            <select name="issue_type" style="width:72;">
											<option value=""  selected></option>
											<option value="PR" >PRN</option>
											<option value="FA" >FAX</option>
											<option value="EM" >EML</option>
											<option value="ED" >EDI</option></select>
											</td>

                            <td width="80">Trans Mode</td>
							<td align="right"><%=selTRANSMODE%></td>


						</tr>
					</table>
					</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->
		</div>

		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Gird BG Box ) (S) -->
		<table class="search" border="0">
			<tr>
				<td class="bg">


				<table width="100%" id="mainTable">
            		      <tr><td>
            		          <script language="javascript">ComSheetObject('sheet1');</script>
            		      </td></tr>
            		</table>
					<table width="100%" id="hiddenTable">
            		      <tr><td>
            		          <script language="javascript">ComSheetObject('sheet2');</script>
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
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_downexcel" name="btng_downexcel">Down Excel</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_detailinquiry" name="btng_detailinquiry">Detail Inquiry</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_wopreview" name="btng_wopreview">W/O Preview</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_edi" name="btng_edi">EDI</td><td class="btn2_right"></td></tr></table></td>
							<!-- Repeat Pattern -->


						</tr></table>
					</td></tr>
					</table>
					<!-- : ( Button_ Sub ) (E) -->
					
					<table width="80%" id="subTable">
            		      <tr><td>
            		          <script language="javascript">ComSheetObject('sheet3');</script>
            		      </td></tr>
            		</table>
					<!-- : ( Grid ) (E) -->


					<!-- : ( Button_ Sub ) (S) -->
					<table width="80%" class="button">
				       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>

							<!-- Repeat Pattern -->
							
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_sohistory" name="btng_sohistory">S/O History</td><td class="btn2_right"></td></tr></table></td>
							<!-- Repeat Pattern -->

						</tr></table>
					</td></tr>
					</table>
					<!-- : ( Button_ Sub ) (E) -->


				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Grid BG Box ) (E) -->


</td></tr>
</table>
<!-- Outer Table (E)-->

</form>

<form name='woForm' method='POST' action='ESD_TRS_0024.screen'>
<input type="hidden" name="pgmNo" >
<input type='hidden' name='trsp_so_ofc_cty_cd'>
<input type='hidden' name='trsp_so_seq'>
<input type='hidden' name='wo_cancel_flag'>
<input type='hidden' name='detain'>
<input type='hidden' name='bno_issue'>
<input type='hidden' name='sowonumber'>
<input type='hidden' name='eq_mode' value='IS'>
<input type='hidden' name='issued'>
<input type='hidden' name='wo_check'>
<input type='hidden' name='isInquiry' value='Y'>
<input	type="hidden" name="sysCommUiTitle" value="Preview">
<input	type="hidden" name="sysCommUiNavigation" value="Trans S/O > Work Order">
</form>
</body>
</html>
