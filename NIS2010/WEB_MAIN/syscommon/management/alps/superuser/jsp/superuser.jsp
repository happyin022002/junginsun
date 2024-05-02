<%
/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ACCESSHISTORY.jsp
*@FileTitle : AccessHistory
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.01
*@LastModifier : 김경범
*@LastVersion : 1.0
* 2010.02.01 김경범
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
<%@ page import="com.hanjin.syscommon.management.alps.superuser.event.SuperUserEvent"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	SuperUserEvent  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strSubSysCd		= "";
	String strUsr_Auth		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.AccessHistory.AccessHistory");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_Auth = account.getUsr_auth_tp_cd();


		event = (SuperUserEvent)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		strSubSysCd = eventResponse.getETCData("sub_sys_cd");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>AccessHistory</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	var subSysCd = "<%=strSubSysCd%>";
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
    function popCal(calObj){
    	 //달력 열기
    	var cal = new ComCalendar();
    	cal.select(calObj, 'yyyy-MM-dd');
    }

</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">

		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->

		<!-- 1 (S) -->
		<table class="search" id="mainTable">
       		<tr><td class="bg">

				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td>User ID</td>
					<td><input name="usrId" type="text" style="width:100;" class="input"></td>
					<td>User Name</td>
					<td><input name="usrNm" type="text" style="width:100;" class="input"></td>
					<td>Module</td>
					<td>
						<script language="javascript">ComComboObject('subSys', 1, 120, 1);</script>
					</td>
					<td>Admin</td>
					<td><select name="admin" style="width:80;" class="input1">
						<option value="" selected>All</option>
						<option value="Y">Yes</option>
						<option value="N">No</option>
						</select></td>
				</tr>
				<tr class="h23">
					<td>RHQ</td>
					<td><select name="rhq" style="width:80;" class="input1">
						<option value="" selected>All</option>
						<option value="SELHO">SELHO</option>
						<option value="HAMUR">HAMUR</option>
						<option value="SINWA">SINWA</option>
						<option value="SHAAS">SHAAS</option>
						<option value="NYCNA">NYCNA</option>
						</select>
					</td>
					<td>Office</td>
					<td><input name="ofcCd" dataformat="engup" type="text" style="width:100;" class="input" onKeyPress="javascript:ComKeyOnlyAlphabet('uppernum');">&nbsp;<img class="cursor" src="img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_ofc_cd"></td>
					<td>Program ID</td>
					<td><input name="pgmNo" dataformat="engup" type="text" style="width:100;" class="input" onKeyPress="javascript:ComKeyOnlyAlphabet('uppernum','95');"></td>
					<td>Program Name</td>
					<td><input name="pgmNm" type="text" style="width:100;" class="input"></td>
				</tr>
				<tr class="h23">
					<td colspan="8">
						<table class="search_sm2" border="0"> 
							<tr class="h23">
							<td width="35">Option</td>
							<td class="stm"><input type="radio" name="opt" value="S" class="trans" checked>&nbsp;Summary&nbsp;&nbsp;<input type="radio" name="opt" value="D" class="trans">&nbsp;Detail</td>
							</tr> 
						</table>
					</td>
				</tr>
				</table>
				<!--  biz_1   (E) -->

				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>

				<!-- Grid (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- Grid (E) -->

				<table class="sbutton" width="100%" > 
			    <tr>
				<td class="align">
			    	<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><input type="text" name="addrows" size="3" value="1"></td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btng_rowadd">Row&nbsp;Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
				</td></tr></table>

		</td></tr></table>
		<!-- 1 (E) -->


		<!--biz page (E)-->

		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
       	<tr><td class="btn1_bg">

		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<%
				// Only Almighty 
				if( strUsr_Auth != null && strUsr_Auth.equals("A") )
				{
				%>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_Save" id="btn_Retrieve">Save</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
				<%
				}
				%>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_DownExcel">Down Excel</td>
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

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>