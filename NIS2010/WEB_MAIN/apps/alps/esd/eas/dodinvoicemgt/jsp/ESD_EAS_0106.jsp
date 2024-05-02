<%
/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ESD_EAS_0106.jsp
*@FileTitle : (KOR) DOD Tariff Creation 
*Open Issues :
*Change history :
*@LastModifyDate : 2016-03-17
*@LastModifier : songji
*@LastVersion : 1.0
* 2016-03-15 songji
* 1.0 Creation
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.eas.dodinvoicemgt.event.EsdEas0106Event"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%
	SignOnUserAccount account = null; //Session 정보
	EsdEas0106Event  event = null; //
	Exception serverException   = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	try {
		account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		event = (EsdEas0106Event)request.getAttribute("Event");
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
<title>(KOR) DOD Tariff Creation</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		}

		loadPage();
	}

</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="ctrl_user_id" value="<%=account.getUsr_id()%>">
<input type="hidden" name="ctrl_ofc_cd" value="<%=account.getOfc_cd()%>">

<input type="hidden" name="sel_cntr_tpsz_cds">

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
										<tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_new">New</td><td class="btn1_right"></td></tr></table></td>

									<td class="btn1_line"></td>

									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn1_left"></td><td class="btn1" name="btn_save" id="btn_save">Save</td><td class="btn1_right"></td></tr></table></td>
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
						
									<!-- Repeat Pattern -->

								</tr></table>

						</td></tr>
					</table>
    	<!-- TABLE '#D' : ( Button : Main ) (E) -->


		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">
				<!-- : ( Week ) (S) -->
				<table class="search_in" border="0">
					<tr class="h23">
						<td width="70">
							<img class="nostar">Office
						</td>
						<td width="250" style="padding-left:1;">
							<!-- <input  class="input2" type="text" style="width:99;" value="<%=account.getOfc_cd()%>" required caption="Office" name="sel_ofc_cd" readonly> -->
							<SELECT name="sel_ofc_cd" style='width:80' onChange="sel_ofc_cd_OnChange(this.value)">
							<OPTION value="INCKS" selected >INCKS</OPTION>
							<OPTION value="KANKS">KANKS</OPTION>
							<OPTION value="PUSSC">PUSSC</OPTION>
					</SELECT>
						</td>
						<td width="100">
						<img class="nostar">Effective
						</td>
						<td width="" style="padding-left:2"><script language="javascript">ComComboObject('sel_eff_dt', 1, 95, 1, 0);</script>
						</td>
					 	<td width="20">
						</td>
					</tr>

				<tr class="h23">
					<td width="">
						<img class="nostar">Origin
					</td>
					<td width="">
						<select class="input1" name="sel_pol_conti_cd" style="width:100;" required caption="Origin" onchange="getEffDate(this.form)">
						<option value='A'>Asia</option>
						<option value='M'>America</option>
						<option value='E'>Europe</option>
						<option value='F'>Africa</option>
					</td>
					
					<td width=""><img class="nostar">New Effective</td>
					<td style="padding-left:1;">
 						<input type="text" name="new_eff_dt" style="width:76" value="" data_format="ymd"  caption='Date' onKeyUp="chkField(this, 'date', false, null, null, '-')" onBlur="chkField(this, 'date', false, null, null, '-')">						 
						<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_calendar">
<!-- 						<img class="cursor" src="/hanjin/img/button/btn_apply.gif" width="60" height="20" border="0" align="absmiddle" name="btn_aply_new_eff_dt"> -->
						<input type="button" style="font-weight:bold;border-width:1px;background:spacer.gif" name="btn_aply_new_eff_dt" value="Apply">
					</td>
					<td width="">
					</td> 												
				</tr>

				</table>
				<!-- : ( Week ) (E) -->

			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->



		<table class="height_10"><tr><td></td></tr></table>


		<!-- TABLE '#D' : ( Tab ) (S) Coincidence / Discrepancy / Cost Calc.(TMNL) / Cost Calc.(SR by FD) / Cost Calc.(SR by FP) / -->

		<!-- TABLE '#D' : ( Tab ) (E) -->

		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
     	<table class="search" border="0">
       	<tr><td class="bg">




			<table class="height_10"><tr><td></td></tr></table>


					<table width="100%" id="mainTable">
					<tr>
						<td>
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
					</table>

			<!-- : ( Grid : Week ) (S) -->
			<!-- 'HEAD1-BGCOLOR : 203 240 169' , 'HEAD2-BGCOLOR : 222 251 248' , 'BORDER 1-outside : 88 152 164' ,
				 'BORDER 2-inside : 202 226 233' , 'HEAD-FONT : 39 95 101' , 'SELETED ROW BG : 252 255 233' -->

			<!-- : ( Grid : Week ) (E) -->




			<!-- : ( Button : Sub ) (S) -->
				<table width="100%" class="button">
						<tr><td class="btn2_bg">
							<table border="0" cellpadding="0" cellspacing="0">
								<tr>

								<!-- Repeat Pattern -->
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btn_add" id="btn_add">Row Add</td>
								<td class="btn2_right"></td></tr></table></td>
								
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btn_del" id="btn_del">Row Delete</td>
								<td class="btn2_right"></td></tr></table></td>
								
								<!-- Repeat Pattern -->

								</tr>
							</table>
						</td></tr>
					</table>
	    	<!-- : ( Button : Sub ) (E) -->


			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->

    </td></tr>
</table>
<!-- Outer Table (E)-->

</form>
</body>
</html>
