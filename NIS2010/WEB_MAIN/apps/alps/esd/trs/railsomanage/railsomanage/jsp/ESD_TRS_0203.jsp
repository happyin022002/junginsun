<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0203.jsp
*@FileTitle : USA Rail Billing Empty Repo를 생성
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-23
*@LastModifier : kim_sang_geun
*@LastVersion : 1.0
* 2006-11-23 kim_sang_geun
* 1.0 최초 생성
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.trs.railsomanage.railsomanage.event.EsdTrs0201Event"%>
<%
	SignOnUserAccount account = null; //Session 정보
	EsdTrs0201Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";								 //에러메세지

	String today = DateTime.getFormatString("yyyyMMdd");
	String beforeOneMonth = DateTime.addDays(today, +14);
	String selKIND = ""; //Kind
	String selCntrSize = ""; //Cntr Size
	String optionStr = "000020:ALL:ALL";
	try {
		account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		selKIND  = JSPUtil.getCodeCombo("sel_kind", "01", "style=width:152", "CD00812", 0, optionStr);
		selCntrSize  = JSPUtil.getCodeCombo("cntr_size", "01", "style=width:58", "CD00937", 0, optionStr);
		event = (EsdTrs0201Event)request.getAttribute("Event");
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
<title>USA Rail Billing S/O Creation</title>
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
<input type="hidden" name="hid_frmdate" value="">
<input type="hidden" name="hid_todate" value="">
<input type="hidden" name="ctrl_ofc_cd" value="<%=account.getOfc_cd()%>">
<input type="hidden" name="hid_trsp_cost_mod_cd">
<input type="hidden" name="hid_ref_id">
<input type="hidden" name="hid_fm_nod_cd">
<input type="hidden" name="hid_to_nod_cd">
<input type="hidden" name="hid_eq_tpsz_cd">
<input type="hidden" name="rail_billing_type" value="M">
<input type="hidden" name="eq_no_verify" value="">
<input type="hidden" name="frm_node_verify" value="">
<input type="hidden" name="hid_cntr_no" value="">
<input type="hidden" name="hid_cntr_tpsz_cd" value="">
<input type="hidden" name="hid_more_qty" value="">
<input type="hidden" name="hid_curr_dt" value="">
<input type="hidden" name="page_type" value="">
<input type="hidden" name="to_nod_verify" value="">


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
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_reset" name="btn_reset">New</td><td class="btn1_right"></td></tr></table></td>
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
						    <td width="97">Departure Date</td>
							<td width="370" class="stm"><input name="frm_plandate" type="text" style="width:75;" value="<%=today%>" maxlength="8" onFocus="javascript:delHypen(this);" onBlur="javascript:getHypen(this); getDateBetween(this);">&nbsp;~&nbsp;<input name="to_plandate" type="text" style="width:75;" value="<%=beforeOneMonth%>" maxlength="8" onFocus="javascript:delHypen(this);" onBlur="javascript:getHypen(this);" onKeyup="javascript:doSearchEnter();"><img src="" width="2" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar"></td>
							<td width="98">Reference No.</td>
							<td width="151"><input name="refer_no" type="text" style="width:117;" value=""><img src="" width="2" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle" name="btns_multirefer"></td>
							<td width="124">Container No.</td>
							<td align="right"><input name="cntr_no" type="text" style="width:118;" value="" onKeyup="javascript:doSearchEnter();" onChange="javascript:this.value=cntrCheckDigit(this.value);"><img src="" width="2" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle" name="btns_multicntr"></td>

						</tr>
					</table>
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="96">Kind</td>
						    <td width="169"><%=selKIND%></td>
							<td width="63">Rail Origin</td>
							<td width="54"><input name="frm_node" type="text" style="width:50;" maxlength="5" onChange="getComboList(this, document.frm_yard, 'F');" onBlur="setgetUpper(this);"></td>
							<td width="83"><script language="javascript">ComComboObject('frm_yard', 1, 49, 0)</script><img src="" width="2" hight="1"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_frmnode"></td>
							<td width="98">Rail Destination</td>
							<td width="54"><input name="to_node" type="text" style="width:50;" maxlength="5" onChange="getComboList(this, document.to_yard, 'T');" onBlur="setgetUpper(this);"></td>
							<td width="97"><script language="javascript">ComComboObject('to_yard', 1, 65, 0)</script><img src="" width="2" hight="1"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_tonode"></td>
							<td width="124">Container Type/Size</td>
							<td width="60"><select name="cntr_type" style="width:58;" onChange="">
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


					<!-- : ( Grid ) (S) -->
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

		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Gird BG Box ) (S) -->
		<table class="search" border="0">
			<tr>
				<td class="bg">



					<!-- : ( Grid ) (S) -->
					<table width="100%" id="mainTable">
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
							<%
								if( "PHXSA".equals(account.getOfc_cd()) ){
							%>	
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_fillincontainers" name="btng_fillincontainers">Fill in CNTR No.</td><td class="btn2_right"></td></tr></table></td>
							<%
								}
							%>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_verify" name="btng_verify">Verify</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_irgadjust" name="btng_irgadjust">IRG Adjust</td><td class="btn2_right"></td></tr></table></td>

							<%
								if( "PHXSA".equals(account.getOfc_cd()) ){
							%>	
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_socreation" name="btng_socreation">S/O Creation</td><td class="btn2_right"></td></tr></table></td>
							<%
								}
							%>
							<!-- Repeat Pattern -->


						</tr></table>
					</td></tr>
					</table>
					<!-- : ( Button_ Sub ) (E) -->


				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Grid BG Box ) (E) -->

<script language="javascript">ComSheetObject('sheet3');</script>


</td></tr>
</table>
<!-- Outer Table (E)-->


</form>
</body>
</html>
