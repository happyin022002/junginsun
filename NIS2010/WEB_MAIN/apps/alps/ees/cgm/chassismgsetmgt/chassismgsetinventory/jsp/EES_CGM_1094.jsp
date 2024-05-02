<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CGM_1094.jsp
*@FileTitle : Chassis Long Staying Environment
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.22
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2009.07.22 조재성
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
<%@ page import="com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.event.EesCgm1094Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%>

<%
	EesCgm1094Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.ChassisMgsetMgt.ChassisMgsetInventory");

	String xml = HttpUtil.makeXML(request,response);
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EesCgm1094Event)request.getAttribute("Event");
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
<title>Chassis Long Staying Environment</title>
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
<form name="form2">
<input type="hidden" name="sXml" value="<%=xml.replace("\"","'")%>">
</form>
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<!-- OUTER - POPUP (S)tart -->
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
	
				<table class="search" border="0" style="width:584;"> 
				<tr class="h23">
					<td width="160">Long Staying Days Period</td>
					<td><input name="staying_days" type="text" style="width:60;text-align:right;ime-mode:disabled" class="input1" value="0" dataformat="int" maxlength="5"></td></tr>
				</table>
				
				<table class="line_bluedot"><tr><td></td></tr></table>
				
				
				<table class="search" border="0" style="width:584;"> 
				<tr class="h23">
					<td width="25">1st</td>
					<td width="170" class="stm">
					<input name="n1st_inq_fm_dys" type="text" style="width:50;text-align:right;ime-mode:disabled" class="input2" value="0" dataformat="int" maxlength="5" disabled>&nbsp;~&nbsp;
					<input name="n1st_inq_to_dys" type="text" style="width:50;text-align:right;ime-mode:disabled" class="input" value="15" dataformat="int" maxlength="5"></td>
					<td width="25">2nd</td>
					<td width="170" class="stm">
					<input name="n2nd_inq_fm_dys" type="text" style="width:50;ime-mode:disabled;text-align:right;" class="input2" value="16" dataformat="int" maxlength="5" disabled>&nbsp;~&nbsp;
					<input name="n2nd_inq_to_dys" type="text" style="width:50;text-align:right;ime-mode:disabled" class="input" value="30" dataformat="int" maxlength="5"></td>
					<td width="25">3rd</td>
					<td class="stm">
					<input name="n3rd_inq_fm_dys" type="text" style="width:50;text-align:right;ime-mode:disabled" class="input2" value="31" dataformat="int" maxlength="5" disabled>&nbsp;~&nbsp;
					<input name="n3rd_inq_to_dys" type="text" style="width:50;text-align:right;ime-mode:disabled" class="input" value="50" dataformat="int" maxlength="5"></td>
				</tr>
				<tr class="h23">
					<td width="25">4th</td>
					<td width="170" class="stm">
					<input name="n4th_inq_fm_dys" type="text" style="width:50;text-align:right;ime-mode:disabled" class="input2" value="51" dataformat="int" maxlength="5" disabled>&nbsp;~&nbsp;
					<input name="n4th_inq_to_dys" type="text" style="width:50;text-align:right;ime-mode:disabled" class="input" value="100" dataformat="int" maxlength="5"></td>
					<td width="25">5th</td>
					<td width="170" class="stm">
					<input name="n5th_inq_fm_dys" type="text" style="width:50;text-align:right;ime-mode:disabled" class="input2" value="101" dataformat="int" maxlength="5" disabled>&nbsp;~&nbsp;
					<input name="n5th_inq_to_dys" type="text" style="width:50;text-align:right;ime-mode:disabled" class="input" value="180" dataformat="int" maxlength="5"></td>
					<td width="25">6th</td>
					<td class="stm">
					<input name="n6th_inq_fm_dys" type="text" style="width:50;text-align:right;ime-mode:disabled" class="input2" value="181" dataformat="int" maxlength="5" disabled>&nbsp;~&nbsp;&nbsp;or Over</td>
				</tr>
				</table>
			</td></tr>
		</table>
		<!-- : ( Search Options ) (E) -->
	
		
		
</td></tr>
</table> 

	<!--biz page (E)-->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve" id="btn_Retrieve">Pre-Set Env.</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	


<div id="tabLayer" style="display:none">
<!-- div style="display:none;" -->
	<!-- Grid  (S) -->
		<table width="100%"  id="mainTable"> 
			<tr>
				<td width="100%">
					<script language="javascript">ComSheetObject('sheet1');</script>
				</td>
			</tr>
		</table>
	<!-- Grid  (E) -->
<!-- /div -->

<!-- div style="display:none;" -->
	<!-- Grid  (S) -->
		<table width="100%" id="mainTable" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td width="100%">
					<script language="javascript">ComSheetObject('sheet2');</script>
				</td>
			</tr>
		</table>
<!-- Grid (E) -->
<!-- /div -->
</div>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>