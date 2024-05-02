<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0201.jsp
*@FileTitle : USA Rail Billing S/O를 생성
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-23
*@LastModifier : 
*@LastVersion : 1.0
* 2006-11-23 
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

	String s_bkg_no = request.getParameter("s_bkg_no")==null?"":request.getParameter("s_bkg_no");
	String s_cntr_no = request.getParameter("s_cntr_no")==null?"":request.getParameter("s_cntr_no");

	try {
		account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
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
	var s_bkg_no = '<%=s_bkg_no.toString()%>';
	var s_cntr_no = '<%=s_cntr_no.toString()%>';
</script>
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

<script language="javascript">
	<%=JSPUtil.getIBCodeCombo("pck_tp_cd", "01", "CD00935", 0, "")%>
	<%=JSPUtil.getIBCodeCombo("auto_xpt_sys_cd", "01", "CD00850", 0, "")%>
</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="hid_frmdate" value="">
<input type="hidden" name="hid_todate" value="">
<input type="hidden" name="ctrl_ofc_cd" value="<%=account.getOfc_cd()%>">
<input type="hidden" name="ctrl_user_id" value="<%=account.getUsr_id()%>">
<input type="hidden" name="eq_no_verify" value="">
<input type="hidden" name="to_nod_verify" value="">
<input type="hidden" name="bkg_no_verify" value="">

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
							<td width="160">Planned Departure Date</td>
							<td class="stm"><input name="frm_plandate" type="text" style="width:75;" value="" maxlength="8" onFocus="javascript:delHypen(this);" onBlur="javascript:getHypen(this); getDateBetween(this);">&nbsp;~&nbsp;<input name="to_plandate" type="text" style="width:75;" value="" maxlength="8" onFocus="javascript:delHypen(this);" onBlur="javascript:getHypen(this);" onKeyup="javascript:doSearchEnter();"><img src="" width="2" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar"></td>
						</tr>
					</table>
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="46">T.VVD</td>
							<td width="190"><input name="trunk_vvd" type="text" style="width:80;" value="" onKeyup="javascript:doSearchEnter();"><img src="" width="2" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle" name="btns_multivvd"><img src="" width="2" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_tvvd"></td>

							<td width="83">Booking No.</td>
							<td width="191"><input name="bkg_no" type="text" style="width:107;" onKeyup="javascript:doSearchEnter();"><img src="" width="2" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle" name="btns_multibkg"></td>
							<td width="101">Container No.</td>
							<td><input name="cntr_no" type="text" style="width:115;" onKeyup="javascript:doSearchEnter();" onChange="javascript:this.value=cntrCheckDigit(this.value);"><img src="" width="2" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle" name="btns_multicntr"></td>
						</tr>
					</table>
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="46">POR</td>
							<td width="55"><input name="por_node" type="text" style="width:51;" maxlength="5" onChange="getComboList(this, document.por_yard, 'R');" onBlur="setgetUpper(this);"></td>
							<td width="135"><script language="javascript">ComComboObject('por_yard', 1, 48, 0)</script><img src="" width="2" height="2"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_pornode"></td>
							<td width="83">Rail Origin</td>
							<td width="59"><input name="frm_node" type="text" style="width:55;" maxlength="5" onChange="getComboList(this, document.frm_yard, 'F');" onBlur="setgetUpper(this);"></td>
							<td width="132"><script language="javascript">ComComboObject('frm_yard', 1, 50, 0)</script><img src="" width="2" height="2"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_frmnode"></td>
							<td width="101">Rail Destination</td>
							<td width="68"><input name="to_node" type="text" style="width:64;" maxlength="5" onChange="getComboList(this, document.to_yard, 'T');" onBlur="setgetUpper(this);"></td>
							<td width="112"><script language="javascript">ComComboObject('to_yard', 1, 49, 0)</script><img src="" width="2" height="2"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_tonode"></td>
							<td width="30">POL</td>
							<td width="64"><input name="pol_node" type="text" style="width:60;" maxlength="5" onChange="getComboList(this, document.pol_yard, 'L');" value="" onBlur="setgetUpper(this);"><img src="" width="2" height="2"></td>
							<td><script language="javascript">ComComboObject('pol_yard', 1, 47, 0)</script><img src="" width="2" height="2"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_polnode"></td>

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
					<!-- : ( Grid ) (E) -->
					<!-- : ( Button_ Sub ) (S) -->
					<table width="100%" class="button">
				       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>

							<!-- Repeat Pattern -->
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


		<table class="height_5"><tr><td></td></tr></table>

		<!-- : ( Button : BOOKING DETAIL 정보 시트 ) (S) -->
		<table width="100%" class="sbutton">
		<tr><td class="align">

			<table class="sbutton">
			<tr>
				<td class="bt"><img name = "bkg_dtl_upper" class="cursor" src="/hanjin/img/bu_next01.gif" width="20" height="11" border="0" ></td>
				<td class="bt"><img name = "bkg_dtl_downer" class="cursor" src="/hanjin/img/bu_prev01.gif" width="20" height="11" border="0" ></td>
			</tr>
			</table>

		</td></tr>
		</table>
		<!-- : ( Button : Top ) (E) -->


		<div id="bkgdtl" style="display:block">
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

				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Grid BG Box ) (E) -->



		</div>



<script language="javascript">ComSheetObject('sheet3');</script>



</td></tr>
</table>
<!-- Outer Table (E)-->

</form>
</body>
</html>
