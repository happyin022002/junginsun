<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0109.jsp
*@FileTitle : Forecast Input(Contract)
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.23
*@LastModifier : 
*@LastVersion : 1.0
* 2013.01.23 
* 1.0 Creation
* 2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.event.EsmSpc0110Event"%>

<%@ page import="org.apache.log4j.Logger" %>
<%
	EsmSpc0110Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id	= "";
	String strUsr_nm	= "";
	String strSrep_cd	= "";
	
	String srep_cd    = JSPUtil.getParameter(request, "srep_cd", "");
	String srep_nm    = JSPUtil.getParameter(request, "srep_nm", "");
	String trd_cd     = JSPUtil.getParameter(request, "trd_cd", "");
	String sub_trd_cd = JSPUtil.getParameter(request, "sub_trd_cd", "");
	String rlane_cd   = JSPUtil.getParameter(request, "rlane_cd", "");
	String dir_cd     = JSPUtil.getParameter(request, "dir_cd", "");
	String ioc_ts_cd  = JSPUtil.getParameter(request, "ioc_ts_cd", "");
	String ofc_cd     = JSPUtil.getParameter(request, "ofc_cd", "");
	String sub_ofc_cd = JSPUtil.getParameter(request, "sub_ofc_cd", "");
	//String srep_cd = "KR086";
	//String srep_nm = "Man-Young Hur";
	
	Logger log = Logger.getLogger("com.hanjin.apps.DailyForecast.DailyForecastManage");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmSpc0110Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		

	}catch(Exception e) {
		out.println(e.toString());
	}
	
%>
<html>
<head>
<title>Forecast Input(Contract)</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">

var curPgmNo = "ESM_SPC_0110";
var curTitle = "Forecast Successioin";
var curDescription = "Forecast Successioin";
 
var strUsr_id = "<%=strUsr_id%>";
var strSrep_cd ="<%=strSrep_cd%>";

function setupPage(){
	var errMessage = "";
	
	if (errMessage.length >= 1) {
		ComShowMessage(errMessage);
	} // end if
	
	loadPage();
}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form" onsubmit="return false;" onKeyDown="spcKeyAction('ESM_SPC_0110');">
<input type="hidden" name="f_cmd">
<input type="hidden" name="trd_cd" value="<%=trd_cd%>">
<input type="hidden" name="sub_trd_cd" value="<%=sub_trd_cd%>">
<input type="hidden" name="rlane_cd" value="<%=rlane_cd%>">
<input type="hidden" name="dir_cd" value="<%=dir_cd%>">
<input type="hidden" name="ioc_ts_cd" value="<%=ioc_ts_cd%>">
<input type="hidden" name="ofc_cd" value="<%=ofc_cd%>">
<input type="hidden" name="sub_ofc_cd" value="<%=sub_ofc_cd%>">
<!-- 개발자 작업	-->

<!-- Outer Table (S)-->
<table width="570" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
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
								<td class="btn1_line"></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td><td class="btn1" name="btn_save" id="btn_save">Save</td><td class="btn1_right"></td></tr></table></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>
								<!-- Repeat Pattern -->

							</tr></table>

					</td></tr>
				</table>
    	<!-- TABLE '#D' : ( Button : Main ) (E) -->

	 	<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<!-- : ( Year ) (S) -->
				<table class="search" border="0">
				<tr>
					<td>
					<table class="search" border="0">
					<tr class="h23">
						<td width="30"><img class="nostar">S.Rep</td>
						<td width="50"><input type="text"" name="salesRep" value="<%=srep_cd%>" dataformat="engup" size="5" maxlength="5" readonly style="ime-mode:disabled; text-align:center;"></td>
						<td width="200"><input type="text"" name="srep_nm" value="<%=srep_nm%>" size="60" maxlength="50" readonly style="ime-mode:disabled;" ></td>
						<td></td>
					</tr>
					</table>
					</td>

				</tr>
				<tr>
					<td width="100%" class="gray_tit" align="left">
						<br>
						1. Choose S.REP who do you take over in the below list.
						<br>
						2. Any FCST data inputed by predecessor will automatically be entered your 'FCST Input System' based on selected Week.				
					</td>
				</tr>
				</table>
				<!-- : ( Year ) (E) -->
			</td></tr>
		</table>
		<table class="height_10"><tr><td></td></tr></table>

		<!-- UI_ESM_SPC_0110 : THIS IS 1st TAB -->
		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg" width = "100%">
				<!-- : ( POR ) (S) -->

					<table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet1');</script>
                        </td></tr>
		            </table>
				<!-- : ( POR ) (E) -->
			</td>
			<td width = "10"></td>
		</tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

</td></tr>
</table>
<!-- Outer Table (E)-->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>