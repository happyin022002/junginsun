<%
/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CPS_GEM_0035.jsp
*@FileTitle : Consultation Slip
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.17
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.17 
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.cps.gem.gemconsultationslip.gemconsultationslip.event.CpsGem0035Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	CpsGem0035Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String usrAuthTpCd = "";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.GEMConsultationSlip.GEMConsultationSlip");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
        usrAuthTpCd = account.getUsr_auth_tp_cd();

		event = (CpsGem0035Event)request.getAttribute("Event");
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
<title>Consultation Slip</title>
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
<input type="hidden" name="auth_flg">
<input type="hidden" name="usr_auth_tp_cd" value="<%=usrAuthTpCd%>">
<input type="hidden" name="subs_ofc_cd">
<input type="hidden" name="hpln_yr">
<input type="hidden" name="hpln_mon">
<input type="hidden" name="pln_yr">
<input type="hidden" name="pln_mon">
<input type="hidden" name="login_ofc_cd">
<!-- 개발자 작업	-->

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
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrive" id="btn_retrive">Retrieve</td><td class="btn1_right"></td></tr></table></td>
							
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_new">New</td><td class="btn1_right"></td></tr></table></td>
							
						<!--	<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_print" id="btn_print">Print</td><td class="btn1_right"></td></tr></table></td> -->

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Load</td><td class="btn1_right"></td></tr></table></td>
							<!-- Repeat Pattern -->

						</tr></table>

				</td></tr>
		</table>
    	<!-- TABLE '#D' : ( Button : Main ) (E) -->

	 	<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<!-- : ( Year ) (S) -->
				<table class="search_in" border="0">
				<tr class="h23">
						<td  colspan="8" align="left">
					 	<input type="radio" value="I" name="gen_expn_rqst_tp_cd" class="trans" onclick="onChagnetypeCd()" checked > Input date
						<input type="radio" value="E" name="gen_expn_rqst_tp_cd" class="trans" onclick="onChagnetypeCd()" >Invoice Date
						<input type="radio" value="A" name="gen_expn_rqst_tp_cd" class="trans" onclick="onChagnetypeCd()" >Approval Date &nbsp;&nbsp;
						<input type="text" name="period_stdt" style="width:70;ime-mode:disabled" value="" class="input1"  maxlength="8" dataformat="ymd" >&nbsp;~&nbsp;<input type="text" name="period_eddt" style="width:70;ime-mode:disabled" value="" class="input1" maxlength="8" dataformat="ymd" >&nbsp;<img class="cursor" src="img/btns_calendar.gif" name="btns_calendar2" width="19" height="20" border="0" align="absmiddle">
					     <input type="radio" value="C" name="gen_expn_rqst_tp_cd" class="trans" onclick="onChagnetypeCd()">
					     CSR No &nbsp;
						<input type="text" style="width:150;ime-mode:disabled;" name="csr_no" value="" maxlength="20">
					
				</tr>
				<tr class="h23">
				    <td width="150">
				    <input type="checkbox" value="" class="trans" checked disabled>BU 
					<input type="checkbox" value="N" class="trans" name="sls_ofc_div_cd" onclick="setHOHQ01('HO');selLevelChange('GEM_COMMONGS.do','SEARCHLIST03','sheet1','sls_ofc_div_cd','1','document.form.ofc_lvl');">HO 
					<input type="checkbox" value="Y" class="trans" name="sls_ofc_div_cd" onclick="setHOHQ01('HQ');selLevelChange('GEM_COMMONGS.do','SEARCHLIST03','sheet1','sls_ofc_div_cd','1','document.form.ofc_lvl');">HQ
				    </td>
				    <td width="320">
				    	<select style="width:80;" class="input" name="ofc_lvl1" onchange="selLevelChange('GEM_COMMONGS.do','SEARCHLIST03','sheet1','sls_ofc_div_cd','1','document.form.ofc_lvl');">
						</select>&nbsp;
						<select style="width:80;" class="input" name="ofc_lvl2" onchange="selLevelChange('GEM_COMMONGS.do','SEARCHLIST04','sheet1','sls_ofc_div_cd','2','document.form.ofc_lvl');" onmousedown="selLevelChange2('GEM_COMMONGS.do','SEARCHLIST04','sheet1','sls_ofc_div_cd','2','document.form.ofc_lvl');">
						</select>&nbsp;
						<select style="width:80;" class="input" name="ofc_lvl3">
						</select>&nbsp;</td>
					<td width="80" align="right">Pay To</td>
					<td width="150" align="left">
						<input name="subs_expn_nm" type="text" style="width:150;text-align:center;" class="input" value="" dataformat="ymd" required>&nbsp;&nbsp;&nbsp;
					</td>
					<td width="100" align="right">Expense Type</td>
					<td width="100" align="left">
						 <select name="expn_div_cd" style="width:95;">
						    <option value ="" selected>All </option>
							<option value="S">Salary & Allowance</option>
							<option value="W">Welfare</option>
							<option value="E">Enterainment</option>
							<option value="M">Management & Other</option>
				        </select> 
					 </td>
					<td width="80" align="right">Status</td>
					   <td  align="left">
						<select name="status" style="width:95;">
						    <option value ="" selected>All </option>
							<option value="X">Saved</option>
							<option value="C">Deleted</option>
							<option value="N">Rejected</option>
							<option value="Y">Approved</option>
							<option value='P'>Submitted</option>
							<option value='E'>Error</option>
				        </select> 
					</td>
					</tr>
				</tr>
				</table>
				<!-- : ( Year ) (E) -->
			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->
		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

			<!-- : ( grid ) (S) -->
			<table  border="0" class="search">
				<tr><td>
					<table width="100%" id="mainTable">
						<tr><td>
							 <script language="javascript">ComSheetObject('sheet1');</script>
						</td></tr>
					</table>
				</td></tr>
			</table>
			<!-- : ( grid ) (E) -->
			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->
</td></tr>
</table>
<!-- Outer Table (E)-->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>