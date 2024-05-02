<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ui_bkg_0450.jsp
*@FileTitle : Transmit History
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.02
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.06.08 임재택
* 1.0 Creation
* 2015.04.20 [CHM-201534307] [ROCS] 네덜란드 세관 더블콜링 보완 관련  
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>

<%
 
Exception serverException   = null;			//서버에서 발생한 에러
String strErrMsg = "";						//에러메세지
int rowCount	 = 0;						//DB ResultSet 리스트의 건수

String successFlag = "";
String codeList  = "";
String pageRows  = "100";

String strUsr_id		= "";
String strUsr_nm		= "";
String ofc_cd           = "";
String from_vvd_number       = "";
String from_pod_cd           = "";
String from_pod_clpt_ind_seq = "";

Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.ManifestListDownload");

try {
   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
   	 
	strUsr_id =	account.getUsr_id();
	ofc_cd    = account.getOfc_cd();  
	strUsr_nm = account.getUsr_nm();
	
	from_vvd_number = StringUtil.xssFilter(request.getParameter("from_vvd_number"))==null?"":StringUtil.xssFilter(request.getParameter("from_vvd_number"));
	from_pod_cd = StringUtil.xssFilter(request.getParameter("from_pod_cd"))==null?"":StringUtil.xssFilter(request.getParameter("from_pod_cd"));
	from_pod_clpt_ind_seq = StringUtil.xssFilter(request.getParameter("from_pod_clpt_ind_seq"))==null?"":StringUtil.xssFilter(request.getParameter("from_pod_clpt_ind_seq"));
	
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
<title>ROCS:Transmit History</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="f_flag" value ="SEARCH">
<input type="hidden" name="pagerows">
<input type="hidden" name="vsl_cd"> 
<input type="hidden" name="skd_voy_no"> 
<input type="hidden" name="skd_dir_cd">
<input type="hidden" name="mt_flag">
<input type="hidden" name="bkg_no">
<input type="hidden" name="msg_type">
<input type="hidden" name="from_vvd_number" value ="<%=from_vvd_number%>">
<input type="hidden" name="from_pod_cd" value ="<%=from_pod_cd%>">
<input type="hidden" name="from_pod_clpt_ind_seq" value ="<%=from_pod_clpt_ind_seq%>">
<input type="hidden" name="sheet_vvd_number">
<input type="hidden" name="sheet_pol_cd">
<input type="hidden" name="sheet_pod_cd">
<input type="hidden" name="sheet_bl_no">
<input type="hidden" name="sheet_msg_snd_dt">
<input type="hidden" name="date_gubun" value="1">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--top menu (S)-->
		 <!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<% if (request.getParameter("pop_up") == null) { %>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			<% } else { %>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;ROCS:Transmit History</td></tr>
			<% }  %>
			
		</table>
	<!--Page Title, Historical (E)-->
		<table class="search"> 
       	<tr><td class="bg">

				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="600">
						<table class="search_sm" border="0" style="width:580;"> 
							<tr class="h23">
								<td width="160">
								<input type="radio" name="gubun" value="1" class="trans" checked>VVD&nbsp;
								<input name="vvd_number"  style="ime-mode: disabled" dataformat="uppernum" style="ime-mode: disabled" maxlength="9"  type="text" style="width:80" value="" class="input1"></td>
								<td>								
								<input type="radio"  name="gubun" value="2" class="trans">Sent Date&nbsp;
								
								<input type="text"
							style="width: 70; ime-mode: disabled" class="input1" value="<%=JSPUtil.replace(DateTime.getDateString(),".","-")%>"
							dataformat="ymd" maxlength="10" name="vps_eta_start_dt" caption="ETA" cofield="vps_eta_end_dt" disabled>&nbsp;																 
								<input type="text" dataformat="hm" maxlength="5" name="fromtime" maxlength="5" class="input1" style="width:40" value="00:00" disabled>&nbsp;								 
								<input type="text"
							style="width: 70; ime-mode: disabled" class="input1"  value="<%=JSPUtil.replace(DateTime.getDateString(),".","-")%>"
							dataformat="ymd" maxlength="10" name="vps_eta_end_dt" caption="ETA" cofield="vps_eta_start_dt" disabled>&nbsp;
								 
								<input type="text" dataformat="hm" maxlength="5" name="totime" class="input1" style="width:40" value="23:59" disabled>&nbsp;
								<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_calendar"></td>
							</tr>
						</table>
					</td>
					<td width="30">POL</td>
					<td width="70"><input type="text" name="pol_cd" style="width:60; ime-mode: disabled;" class="input"
                        dataformat="engupnum" maxlength="5" fullfill caption="POL"></td>
					<td width="30">POD</td>
					<td width="70"><input type="text" name="pod_cd" style="width:60; ime-mode: disabled;" class="input"
                        dataformat="engupnum" maxlength="5" fullfill caption="POD"></td> 
                    <td width="110">POD Calling Seq.</td>
					<td width=""><input type="text" name="pod_clpt_ind_seq" style="width:20; ime-mode: disabled;" class="input"
                        dataformat="int" maxlength="1" caption="POD Calling Seq"></td> 
				</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					
					<td width="80">&nbsp;&nbsp;&nbsp;MSG Type</td>
					<td width="108"><select style="width:80;" name = "sel_msg_type">						 
						<option value="" selected>All</option>
						<option value="1">Cancel</option>
						<option value="9">Original</option>
						<option value="5">Replace</option>
						</select></td>
					<td width="53">User ID</td>
					<td width="110"><input name ="user_id" type="text" dataformat="uppernum"  style="width:75; ime-mode: disabled" value=""></td>	
					<td width="50">B/L No.</td>
					<td width=""><input name ="bl_no" dataformat="uppernum"  type="text" style="width:112; ime-mode: disabled" maxlength="12"  value=""></td>
				</tr>
				</table>
				<!--  biz_1   (E) -->
												
				
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>	
				
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>	
				<div style="display:none">
				<script language="javascript">ComSheetObject('sheet2');</script>
				</div>		
				<div style="display:none">
				<script language="javascript">ComSheetObject('sheet3');</script>
				</div>		
			<!-- Grid (E) -->
												
				
				
				</td></tr>
			</table>
				
		
			<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
					
				<td class="btn1_line"></td>
				<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_view">View Sent File</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>		
				<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_history">History</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downexcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_print">Print</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
			</td></tr>
		</table>
	<!-- Grid BG Box  (S) -->
	<!--biz page (E)-->
	<table class="height_10"><tr><td colspan="8"></td></tr></table>
	</td></tr>
		</table>
</form>
</body>
</html>