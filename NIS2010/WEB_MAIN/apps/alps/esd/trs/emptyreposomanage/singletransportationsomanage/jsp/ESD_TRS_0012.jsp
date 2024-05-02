<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0012.jsp
*@FileTitle : Empty Repo & Drayage for On/Off Hire
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-30
*@LastModifier : kim_sang_geun
*@LastVersion : 1.0
* 2006-10-30 kim_sang_geun
* 1.0 최초 생성 
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
	SignOnUserAccount account = null;
	EsdTrs0012Event  event = null;				//PDTO(Data Transfer Object including Parameters)

	Exception serverException   = null;			//서버에서 발생한 에러
	DBRowSet rowSet	  = null;							   //DB ResultSet
	String strErrMsg = "";								 //에러메세지
	int rowCount	 = 0;								  //DB ResultSet 리스트의 건수

	String selKIND = ""; //Kind
	String selCntrSize = ""; //Cntr Size
	String optionStr = "000020:ALL:ALL";

	String today = DateTime.getFormatString("yyyyMMdd");

	// N200902050050 2009-03-04 Empty repo s/o creation Option 일부 수정 (From / to date : 오늘 기준 +- 7일 )
	String beforeOneMonth = DateTime.addDays(today, -7);
	String afterOneMonth = DateTime.addDays(today, 7);

	try {
		account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		selKIND  = JSPUtil.getCodeCombo("sel_kind", "01", "style=width:160", "CD00812", 0, optionStr);
		selCntrSize  = JSPUtil.getCodeCombo("cntr_size", "01", "style=width:60", "CD00937", 0, optionStr);
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
<title>Empty Repo & Drayage for On/Off Hire</title>
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
<input type="hidden" name="hid_trsp_cost_mod_cd">
<input type="hidden" name="hid_ref_id">
<input type="hidden" name="hid_fm_nod_cd">
<input type="hidden" name="hid_to_nod_cd">
<input type="hidden" name="hid_fm_yard_cd">
<input type="hidden" name="hid_to_yard_cd">
<input type="hidden" name="hid_trsp_crr_mod_cd">
<input type="hidden" name="hid_eq_tpsz_cd">
<input type="hidden" name="hid_cntr_no">
<input type="hidden" name="hid_cntr_tpsz_cd">
<input type="hidden" name="ctrl_ofc_cd" value="<%=account.getOfc_cd()%>">
<input type="hidden" name="ctrl_user_id" value="<%=account.getUsr_id()%>">
<input type="hidden" name="TRSP_SO_EQ_KIND" value="">
<input type="hidden" name="eq_no_verify" value="">
<input type="hidden" name="frm_node_verify" value="">
<input type="hidden" name="old_ofc_cd" value="<%=account.getOfc_cd()%>">
<input type="hidden" name="page_type" value="C">

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

					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_new" name="btn_new">New</td><td class="btn1_right"></td></tr></table></td>

					<td class="btn1_line"></td>

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
					<table class="height_2">
						<tr>
							<td></td>
						</tr>
					</table>
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="100">Departure Date</td>
							<td width="300" class="stm"><input name="frm_reqdate" type="text" style="width:75;" maxlength="8" value="<%=beforeOneMonth%>" onBlur="javascript:getDateBetween(this);">&nbsp;~&nbsp;<input name="to_reqdate" type="text" style="width:75;" maxlength="8" value="<%=afterOneMonth%>" onKeyup="javascript:doSearchEnter();">
								<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar"> </td>

							<td width="33">Kind</td>
							<td width="220"><%=selKIND%></td>
							<td width="124">Service Order Office</td>
<!--							<td>&nbsp;<input name="ctrl_so_office" type="text" style="width:100;" disabled value="<%=account.getOfc_cd()%>"><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_office"></td>  -->
							<td class="sm" align="right"><input name="ctrl_so_office" type="text" style="width:90;" onkeyup="upper(this)" value="<%=account.getOfc_cd()%>"><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_office"><input type="checkbox" name="chk_office" value="Y" class="trans" onClick="javascript:fun_chkOffice();">Incl. Sub OFC</td>


						</tr>
					</table>
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="100">From </td>
							<td width="81"><input name="frm_node" type="text" style="width:75;" maxlength="5" onChange="getComboList(this, document.frm_yard, 'F');" onBlur="setgetUpper(this);"></td>
							<td width="92"><script language="javascript">ComComboObject('frm_yard', 1, 88, 0)</script></td>
							<td width="126"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_frmnode"></td>
							<td width="34">To</td>
							<td width="62"><input name="to_node" type="text" style="width:56;" maxlength="5" onChange="getComboList(this, document.to_yard, 'T');" onBlur="setgetUpper(this);"></td>
							<td width="81"><script language="javascript">ComComboObject('to_yard', 1, 77, 0)</script></td>
							<td width="77"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_tonode"></td>
							<td width="127">Container Type/Size</td>
						<td width="64">
								<select name="cntr_type" style="width:60;" onChange="">
									<option value="ALL" selected>ALL</option>
									<option value="A">A</option>
									<option value="D">D</option>
									<option value="F">F</option>
									<option value="O">O</option>
									<option value="P">P</option>
									<option value="R">R</option>
									<option value="S">S</option>
									<option value="T">T</option>
								</select>
							</td>
							<td><%=selCntrSize%></td>
						</tr>
					</table>

					<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>


					<table class="search_in" border="0">
						<tr class="h23">
							<td width="100">Reference No.</td>
							<td width="242"><input type="text" name="reference_no" style="width:167;" value="" onKeyup="javascript:doSearchEnter();">
							<img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle" name="btns_multireference"></td>


							<td width="91">Container No.</td>
							<td><input type="text" name="cntr_no" style="width:140" value="" onKeyup="javascript:doSearchEnter();" onChange="checkDigit(this);">
								<img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle" name="btns_multicntrno"></td>
						</tr>
					</table>

				</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

        </div>



		<table class="height_5"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Gird BG Box ) (S) -->
		<table class="search" border="0">
			<tr>
				<td class="bg">

				 <table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet1');</script>
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
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_rowadd" name="btng_rowadd">Row Add</td><td class="btn2_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_rowcopy" name="btng_rowcopy">Row Copy</td><td class="btn2_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_delete" name="btng_delete">Delete</td><td class="btn2_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_save" name="btng_save">Save</td><td class="btn2_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_apply" name="btng_apply">Apply</td><td class="btn2_right"></td></tr></table></td>
							<!-- Repeat Pattern -->


						</tr></table>
					</td></tr>
					</table>
					<!-- : ( Button_ Sub ) (E) -->
				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Grid BG Box ) (E) -->
		<table class="height_5">
			<tr>
				<td></td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Tab ) (S) -->
     	<table class="tab">
       	<tr><td><script language="javascript">ComTabObject('tab1' )</script>
		</table>
		<!-- TABLE '#D' : ( Tab ) (E) -->

		<div id="tabLayer" style="display:inline">
		<!-- TABLE '#D' : ( Gird BG Box ) (S) -->
		<table class="search" border="0">
			<tr>
				<td class="bg">

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
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_officetransfer" name="btng_officetransfer">Office Transfer</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_fillincontainers" name="btng_fillincontainers">Fill in CNTR No.</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_downexcel" name="btng_downexcel">Down Excel</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_matchmaking1" name="btng_matchmaking1">Matchmaking for Combined CaseⅠ</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_verify" name="btng_verify">Verify</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_socreation" name="btng_socreation">S/O Creation</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_woissue" name="btng_woissue">W/O Issue</td><td class="btn2_right"></td></tr></table></td>
							
							<!-- Repeat Pattern -->


						</tr></table>
					</td></tr>
					</table>
					<!-- : ( Button_ Sub ) (E) -->
				</td>
			</tr>
		</table>
		</div>

		<div id="tabLayer" style="display:none">
		<!-- TABLE '#D' : ( Gird BG Box ) (S) -->
		<table class="search" border="0">
			<tr>
				<td class="bg">


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
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_separate2" name="btng_separate2">Separate</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_socreation1" name="btng_socreation1">S/O Creation</td><td class="btn2_right"></td></tr></table></td>

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
		<!-- TABLE '#D' : ( Grid BG Box ) (E) -->

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