<%
/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ESM_SPC_0114.jsp
*@FileTitle : Import Control Option Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.02
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.02 
* 1.0 Creation
*  2015.01.02 [CHM-201433401]Control Option Registration - Upload기능 추가 요청
* 2015.02.17 Arie Im [CHM-201534437]Control Option Registration 기능 보완 - del all check, 상단 검색조건 추가
* 2015.07.24 Arie [CHM-201537010] Control Option Management 및 VVD별 EDIT기능 보완 - 패키지 이동
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.event.EsmSpc0114Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%

	EsmSpc0114Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.BasicDataManage.ConstraintMaster");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmSpc0114Event)request.getAttribute("Event");
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
<title>Import Control Option Detail</title>
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

<body class="popup_bg" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="is_upload"  value="Y">

<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td height="10"></tr>
		</table>
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Import Control Option Detail</td></tr>
		</table>

		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->

		<!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
			<tr><td class="btn1_bg">
					<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
						<!-- 
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td><td class="btn1" name="btn_add" id="btn_add">Row Add</td><td class="btn1_right"></td></tr></table></td> -->
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td><td class="btn1" name="btn_save" id="btn_save">Save</td><td class="btn1_right"></td></tr></table></td>

						<td class="btn1_line"></td>

						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td><td class="btn1" name="btn_upload" id="btn_upload">Upload</td><td class="btn1_right"></td></tr></table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td><td class="btn1" name="btn_template_down" id="btn_template_down">Template Down</td><td class="btn1_right"></td></tr></table></td>

						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>
					</tr></table>

			</td></tr>
		</table>

    	<!-- TABLE '#D' : ( Button : Main ) (E) -->
	 	<!-- TABLE '#D' : ( Search Options ) (S) -->

		<table width="100%" class="search" id="searchCondition">
			<tr><td class="bg">
				<table class="search" border="0">
						<tr class="h23">
						<td width="80"><img class="nostar">Rep. Trade</td>
						<td width="100">&nbsp;
							<script language="JavaScript">ComComboObject("trade", 2, 60, 0, 0);</script>
						</td>
						<td width="70">Sub Trade</td>
						<td width="100">&nbsp;
							<script language="JavaScript">ComComboObject("subtrade", 3, 50, 0, 0);</script>
						</td>
						<td width="45">Lane</td>
						<td width="100" style="padding-left:2" >
							<script language="JavaScript">ComComboObject("lane", 4, 80, 0, 0);</script>
						</td>
						<td width="50">Bound</td>
						<td width="140">&nbsp;
							<select name="bound" style="width:50;"></select>
						</td>
						<td></td>
					</tr>
				</table>
			</td></tr>
		</table>

		<table class="height_10"><tr><td></td></tr></table>
		
		<!-- TABLE '#D' : ( Tab ) (S) -->
     	<table class="search">
       	<tr><td class="bg">
				<!-- <table class="height_5"><tr><td></td></tr></table> -->
					<table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet1');</script>
                        </td></tr>
		            </table>
					<table width="100%" id="mainTable2" style="display:none;">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet2');</script>
                        </td></tr>
		            </table>
			</td></tr>
		</table>

<!-- : ( Search Options ) (E) -->
<table class="height_5"><tr><td></td></tr></table>
</td></tr>
</table> 
<!-- Outer Table (E)-->
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
<%@include file="/bizcommon/include/common_alps.jsp"%>