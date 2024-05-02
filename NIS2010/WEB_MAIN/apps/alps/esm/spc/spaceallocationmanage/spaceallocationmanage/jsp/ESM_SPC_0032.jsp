<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0032.jsp
*@FileTitle : Status by Load Office
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.12
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2013.03.12 진마리아
* 1.0 Creation
* 2013.03.12 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.event.EsmSpc0032Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%

	EsmSpc0032Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	String week = null;
	String trdCd = null;
	String subTrdCd = null;
	String ofcCd = null;
	
	Logger log = Logger.getLogger("com.hanjin.apps.spaceallocationmanage.spaceallocationmanage");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		
		week = JSPUtil.getParameter(request, "week", "");
		trdCd = JSPUtil.getParameter(request, "trd_cd", "");
		subTrdCd = JSPUtil.getParameter(request, "sub_trd_cd", "");
		ofcCd = JSPUtil.getParameter(request, "ofc_cd", "");
		
		week = week==null?"":week;
		trdCd = trdCd==null?"":trdCd;
		subTrdCd = subTrdCd==null?"":subTrdCd;
		ofcCd = ofcCd==null?"":ofcCd;
		
		event = (EsmSpc0032Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

	}catch(Exception e) {
		out.println(e.toString());
	}
	
	String ofc_cd	 = event.getSignOnUserAccount().getOfc_cd();
	String ofc_tp_cd = "";
%>

<html>
<head>
<title>Status by Load Office</title>
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
<!-- 개발자 작업	-->
<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>

		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
     	<table width="950" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Status by Load Office</td></tr>
		</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->


		<!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
			<tr><td class="btn1_bg">
					<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>
						<!-- Repeat Pattern -->

					</tr></table>

			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table width="700" class="search" id="searchCondition">
			<tr><td class="bg">
				<table class="search" border="0">
					<tr class="h23">
						<td width="50"><img class="nostar">Week</td>
						<td width="80"><input type="text" name="week" class="input2" style="width:60;text-align:center" value="<%=week%>" readonly="readonly"></td>
						<td width="55"><img class="nostar">Office</td>
						<td width="80"><input type="text" name="ofc_cd" class="input2" style="width:60;text-align:center" value="<%=ofcCd%>" readonly="readonly"></td>
						<td width="55"><img class="nostar">Trade</td>
						<td width="80"><input type="text" name="trd_cd" class="input2" style="width:60;text-align:center" value="<%=trdCd%>" readonly="readonly"></td>
						<td width="80"><img class="nostar">Sub Trade</td>
						<td width="80"><input type="text" name="sub_trd_cd" class="input2" style="width:60;text-align:center" value="<%=subTrdCd%>" readonly="readonly"></td>
						<td width="140"></td>
					</tr>
				</table>
			</td></tr>
		</table>	
    	<!-- TABLE '#D' : ( Button : Main ) (E) -->
     	<table class="search">
       	<tr><td class="bg">
				<table class="height_5"><tr><td></td></tr></table>
					<table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet1');</script>
                        </td></tr>
		            </table>
			</td></tr>
		</table>

</td></tr>
</table>
<!-- Outer Table (E)-->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
<%@include file="/bizcommon/include/common_alps.jsp"%>