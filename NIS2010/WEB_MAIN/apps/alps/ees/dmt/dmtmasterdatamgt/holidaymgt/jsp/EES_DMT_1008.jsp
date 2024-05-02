<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_1008.jsp
*@FileTitle : Holiday by Country Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.05.04 이성훈
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.holidaymgt.event.EesDmt1008Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt1008Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.DMTMasterDataMgt.HolidayMgt");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EesDmt1008Event)request.getAttribute("Event");
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
<title>Holiday by Country Inquiry</title>
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
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="svr_id">
<input type="hidden" name="hol_yr">
<input type="hidden" name="cnt_cd">
<input type="hidden" name="rgn_cd">
<input type="hidden" name="ste_cd">
<input type="hidden" name="loc_cd">
<input type="hidden" name="wknd_tp_cd">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
	<!--Page Title, Historical (E)-->	
	
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="25">RHQ</td>
					<td width="100">&nbsp;<select name="rhq" style="width:70;" class="input1" OnChange="searchCountryByRHQ()">
						<option value="" selected>All</option>
						<option value="USA">NYCRA</option>
						<option value="EUR">HAMRU</option>
						<option value="CHN">SHARC</option>
						<option value="KOR">SELIB</option>
						<option value="JPN">TYOIB</option>
						<option value="SWA">SINRS</option>
						<option value="VVO">VVOIA</option>
						</select></td>
					<td width="30">Year</td>
					<td width="100">&nbsp;<select name="year" style="width:60;" class="input"></select></td>
					<td width="50">Country</td>
					<td width="100">&nbsp;
						<script language="javascript">ComComboObject('cboCountry', 2, 60, 0, 0)</script>
					</td>
					<td width="40"><span id="Region">Region</span></td>
					<td width="100">&nbsp;
						<script language="javascript">ComComboObject('cboRegion', 2, 60 , 0, 0, 0, true)</script>
					</td>
					<td width="45">Location</td>
					<td width="">&nbsp;<input type="text" name="location" style="width:60;" class="input" value="" dataformat="engup" maxlength="5" OnKeyUp="checkLocation()"></td>
				</tr>
				</table>
				<!--  biz_1   (E) -->
				
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			
			<!-- biz_2  (S) -->
					<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>					
					<!--grid (E)-->
				
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="130" valign="top">
					
					<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="80%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>					
					<!--grid (E)-->
					</td>
					<td width="19">&nbsp;&nbsp;</td>
					<td width="130" valign="top">
					
					<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet3');</script>
						</td>
					</tr>
				</table>					
					<!--grid (E)-->
					
					
					</td>
					<td width="20">&nbsp;&nbsp;</td>
					<td width="680" valign="top">
					
					<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet4');</script>
						</td>
					</tr>
				</table>					
					<!--grid (E)-->
					
					
					
					</td>
				</tr>
				</table>
			<!-- biz_2 (E) -->
					
					
					</td></tr>
			</table>
			
			
			</td></tr>
		</table>
	<!-- Tab BG Box  (S) -->
	<!--biz page (E)-->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
                <td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_DownExcel">Down&nbsp;Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		
    <!--Button (E) -->
	</td></tr>
</table>
</form>
</body>
</html>