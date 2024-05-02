<%--
/*=========================================================
*Copyright(c) 2009 CyberLogitec 
*@FileName : EES_DOD_0008.jsp
*@FileTitle : DOD Collection Audit
*Open Issues :
*Change history :
*@LastModifyDate : 2015-11-04
*@LastModifier : Jeong-Min Park
*@LastVersion : 1.0
* 1.0 최초 생성 
-------------------------------------------------------------------
* History

=========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.dod.doddropoff.dropoffinquiry.event.EesDod0004Event"%>
<%
	String loginOfcCd = "";
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		loginOfcCd = account.getOfc_cd();
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Collection Audit</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">

	var loginOfcCd = "<%=loginOfcCd%>";
	function setupPage(){
		loadPage();
	}
</script>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="backendjob_key" />
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
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_save">New</td><td class="btn1_right"></td></tr></table></td>
							<td class="btn1_line"></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
							<!-- Repeat Pattern -->
						</tr></table>
				</td></tr>
			</table>
			<!-- TABLE '#D' : ( Button : Main ) (E) -->

			<!-- TABLE '#D' : ( Search Options ) (S) -->
	     	<table width="100%" class="search" border="0">
		       	<tr>
		       		<td class="bg">
						<!-- : ( Week ) (S) -->
							<!-- [1]--------------------------------------------------------- -->
						<table class="search_in" border="0">
							<tr class="h23">
								<td width="120">Office</td>
								<td width="180"><input type="text" name="s_ofc_cd" style="width:70;text-align:center;" dataformat="engup" maxlength="6" class="input1" value="<%=loginOfcCd%>">
								</td>
								<td width="160" colspan="2">Period(MT Return Date)</td>
								<td width="230">
									<input type="text" style="width:75; text-align:Center" name="s_eq_rtn_from_dt" value="" dataformat="ymd" maxlength="10" class="input1">
									<img name="btn_eq_rtn_from_dt" src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
									&nbsp;~&nbsp;
									<input type="text" style="width:75; text-align:Center" name="s_eq_rtn_to_dt" value="" dataformat="ymd" maxlength="10" class="input1">
									<img name="btn_eq_rtn_to_dt" src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
								</td>
								<td width="85">A/R I/F</td>
								<td width="" style="padding-left:2"><script language="javascript">ComComboObject('s_ar_if_yn',1,80,0,0);</script>
								</td>
							</tr>								
							<tr class="h23">
								<td width="120">Return Location</td>
								<td width="180">
									<select style="width:54;" name="s_loc_tp_cd" class="input" ><!-- LOC_TYPE_CODE -->
										<option value="1"> RCC</option>
										<option value="2"> LCC</option>
										<option value="3"> ECC</option>
										<option value="4"> SCC</option>
										<option value="5"> Yard</option>
									</select> <input type="text" class="input1" name="s_loc_cd" style="ime-mode:inactive" dataformat="engup" size="7" maxlength="7" fulfill  style="width:65;" value=""> <img class="cursor" src="img/btns_search.gif" name="btn_location" width="19" height="20" border="0" align="absmiddle">
								</td>
								<td width="95">Customer</td>
								<td width="295" colspan="2"><input type="text" name="s_cust_cd" dataformat="uppernum" maxlength="8" style="width:80;text-align:center;ime-mode:disabled;" class="input" value="">&nbsp;<img class="cursor" src="img/btns_search.gif" name="btn_customer" width="19" height="20" alt="" border="0" align="absmiddle">
									<input type="text" name="s_cust_nm" style="width:130;text-align:left;" class="input2" value="" readonly>
								</td>
								<td width="85">Exemption</td>
								<td width="" style="padding-left:2"><script language="javascript">ComComboObject('s_exemption_yn',1,80,0,0);</script>
								</td>
							</tr>								
							<tr class="h23">
								<td width="120">BKG No.</td>
								<td width="180"><input name="s_bkg_no" type="text" dataformat="engup" style="width:150;text-align:Center" maxlength="20" class="input">
								</td>
								<td width="95">CNTR No.</td>
								<td width="295" colspan="2"><input name="s_cntr_no" type="text" dataformat="engup" style="width:150;text-align:Center" maxlength="20" class="input"></td>
								<td width="85">Unmatch</td>
								<td width="" style="padding-left:2"><script language="javascript">ComComboObject('s_unmatch_yn',1,80,0,0);</script>
								</td>
							</tr>	
							<tr class="h23">
								<td width="120">RFA No.</td>
								<td width="180"><input name="s_rfa_no" type="text" dataformat="engup" style="width:150;text-align:Center" maxlength="20" class="input">
								</td>
								<td width="95">S/C No.</td>
								<td width="295" colspan="4"><input name="s_sc_no" type="text" dataformat="engup" style="width:150;text-align:Center" maxlength="20" class="input"></td>
							</tr>	
						</table>
						<!-- : ( Week ) (E) -->
					</td>
				</tr>
			</table>
			<!-- TABLE '#D' : ( Search Options ) (E) -->			

			<table class="height_10"><tr><td></td></tr></table>

			<!-- TABLE '#D' : ( Grid ) (S) -->
	     	<table class="search">
	       		<tr><td class="bg">
					<!-- <table class="height_10"><tr><td></td></tr></table> -->
					<!-- : ( POR ) (S) -->
					<table width="100%" id="mainTable">
			              <tr><td>
			                     <script language="javascript">ComSheetObject('sheet1');</script>
			              </td></tr>
					</table>
					<!-- : ( POR ) (E) -->

				</td></tr>
			</table>
			<!-- TABLE '#D' : ( Grid ) (E) -->

    </td></tr>
</table>
<table width="100%" style="display:none"> 
	<tr>
		<td width="100%">
			<script language="javascript">ComSheetObject('sheet2');</script>
		</td>
	</tr>
</table> 
<!-- Outer Table (E)-->

</form>
</body>
</html>