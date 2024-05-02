<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0950.jsp
*@FileTitle : Relay Vessel Group Assign by Relay Port
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.09.15 최영희
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.event.EsmBkg0950Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0950Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.TransshipmentMgt.TransshipmentMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0950Event)request.getAttribute("Event");
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
<title>Relay Vessel Group Assign by Relay Port</title>
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
<form name="form" onkeyup="ComKeyEnter('lengthnextfocus');">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows"> 
<input type="hidden" name="assignFlag"> 
<input type="hidden" name="newVvd"> 
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
		<!--Page Title, Historical (S)--> 
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
		<!--Page Title, Historical (E)-->
		<!--biz page (S)-->
		
<table class="search" id="mainTable"> 
    <tr><td class="bg">	
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
				<td width="70">Relay Port</td>
				<td width="150"><input type="text" style="width:50;" class="input1" name="loc_cd"  maxlength="5" dataformat="engup">&nbsp;<input type="text" style="width:25;" class="input1" name="loc_yd_cd" maxlength="2" dataformat="engup">&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="btn_relay"></td>
				<td width="90">ETB Duration </td>
				<td width="240"><input type="text" style="width:80;" class="input1" value="" dataformat="ymd" name="dur_from">&nbsp;&nbsp;~&nbsp&nbsp;<input type="text" style="width:80;" class="input1" value="" dataformat="ymd" name="dur_to">&nbsp;<img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="btn_duration"></td>
				<td width="80">Former VVD</td>
				<td width="80"><input type="text" style="width:80;" class="input" name="formerVVD" maxlength="9" dataformat="engup"></td>
				<td width="130" align="left"><input type="checkbox" class="trans"  value="Y" name="blankFormerVVD">Blank Former VVD</td>			
			</tr>
			</table> 
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
				<td width="70">Next VVD</td>
				<td width="150"><input type="text" style="width:103;" class="input" name="nextVVD" maxlength="9" dataformat="engup"></td>
				<td width="90">Next Port</td>
				<td width="125"><input type="text" style="width:60;" class="input" name="nextPort" maxlength="5" dataformat="engup"></td>
				<td width="60">BKG POL</td>
				<td width="80"><input type="text" style="width:60;" class="input" name="pol_cd" maxlength="5" dataformat="engup"></td>
				<td width="60">BKG POD</td>
				<td width="80"><input type="text" style="width:60;" class="input" name="pod_cd" maxlength="5" dataformat="engup"></td>
				<td width="130" align="left"><input type="checkbox" class="trans"  value="Y" name="blankPostVVD">Blank Post VVD</td>
			</tr>
			</table> 
			
			<table class="height_5"><tr><td></td></tr></table>
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table> 
			<!-- Grid  (E) --> 
			
			</td></tr>
		</table>
		<!--biz page (E)--> 
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downexcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<!--<td class="btn1" name="btn_selectall">Select  All</td>-->
					<td class="btn1" name="btn_CheckAll" id="btn_CheckAll">Check All</td>
					<td class="btn1" name="btn_UnCheckAll" id="btn_UnCheckAll">UnCheck All</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_vvdassign">VVD Assign</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
				<table id="mainTable"> 
					<tr><script language="javascript">ComSheetObject('sheet2');</script></tr>
				</table>
				<table id="mainTable"> 
					<tr><script language="javascript">ComSheetObject('sheet3');</script></tr>
				</table></td></tr>
		</table>
	</form>
</body>
</html>
<%@include file="/bizcommon/include/common_alps.jsp"%>