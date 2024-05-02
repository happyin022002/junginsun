<%
/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_SPC_0124.js
 *@FileTitle : Space Control Container Type/Size
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.07.29
 *@LastModifier :
 *@LastVersion : 1.0
 * 2015.07.29 
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
<%@ page import="com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.event.EsmSpc0124Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EsmSpc0124Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String cntr_tpsz_cd	= "";
	String org_row	= "";
	String targetColume	= "";
	String loc_multi_cd	= "";
	String tabNo	= "";
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EsmSpc0124Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		//GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		cntr_tpsz_cd 	=  JSPUtil.getParameter(request, "cntr_tpsz_cd");
		org_row			= JSPUtil.getNull(request.getParameter("org_row"));
		targetColume		= JSPUtil.getNull(request.getParameter("targetColume"));
		loc_multi_cd			= JSPUtil.getNull(request.getParameter("loc_multi_cd"));
		tabNo					= JSPUtil.getNull(request.getParameter("tabNo"));
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Container Type/Size</title>
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
<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="org_row" value="<%=org_row%>">
<input type="hidden" name="cntr_tpsz_cd" value= "<%=cntr_tpsz_cd%>">
<input type="hidden" name="targetColume" value="<%=targetColume%>"> <!-- 대상 팝업 컬럼 명  -->
<input type="hidden" name="loc_multi_cd" value="<%=loc_multi_cd%>">
<input type="hidden" name="tab_no" value="<%=tabNo%>">
<!-- 개발자 작업	-->
<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp; Container Type/Size</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		<!-- : ( Search Options ) (S) -->
			<table class="search" width="384">
       		<tr><td class="bg">
       			 <!-- Grid  (S) -->
                    <table width="100%" class="search"  id="mainTable">
                        <tr>
                            <td width="100%">
                            <script language="javascript">ComSheetObject('sheet1');</script>
                            </td>
                        </tr>
                    </table>
		    <!-- : ( Button : Grid ) (E) -->
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->
<table class="height_5"><tr><td></td></tr></table>
</td></tr>
</table>
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_confirm">Select</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right"></td>
				</tr></table></td>
			</tr>
		</table></td>
			</tr>
		</table>
    <!--Button (E) -->
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
<%@include file="/bizcommon/include/common_alps.jsp"%>