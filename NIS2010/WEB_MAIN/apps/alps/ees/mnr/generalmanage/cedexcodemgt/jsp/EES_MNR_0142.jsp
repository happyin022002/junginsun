<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_mnr_0142.jsp
*@FileTitle : Pop Up_Tariff Code Finding
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.10
*@LastModifier : 정영훈
*@LastVersion : 1.0
* 2009.06.10 정영훈
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.mnr.generalmanage.cedexcodemgt.event.EesMnr0142Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnr0142Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String rhqOfcCd         = "";
	String currOfcCd       = "";
	String currOfcEngNm     = "";
	Logger log = Logger.getLogger("com.hanjin.apps.alps.ees.mnr.generalmanage.cedexcodemgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id    =	account.getUsr_id();
		strUsr_nm    = account.getUsr_nm(); 
		rhqOfcCd     = account.getRhq_ofc_cd();
		currOfcCd    = account.getOfc_cd();
		currOfcEngNm = account.getOfc_eng_nm();
		
		event = (EesMnr0142Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
	strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
	
	String tct = JSPUtil.getParameter(request, "tct");
	if(tct == null) tct = "";
%>
<html>
<head>
<title>Tariff Code Finding</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript"> 
    var tct          = '<%=tct %>';
    var currOfcCd = '<%=currOfcCd %>';
    var rhqOfcCd  = '<%=rhqOfcCd %>';
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body  class="popup_bg"  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="retfld">
<!-- 개발자 작업	-->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">   Tariff Code Finding</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="110">Tariff Code Type</td>
					<td><script language="javascript">ComComboObject('combo1',2, 150 , 1);</script></td>
				</tr> 
				</table>				
				<!--  biz_1   (E) -->
				
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- Grid (E) -->	
			


		</td></tr></table>
		<!--biz page (E)--> 
<table class="height_5"><tr><td></td></tr></table>
</td></tr></table>
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

    	<!--Button (S) -->	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>	
			<td class="btn3_bg">
		    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_OK">Ok</td>
					<td class="btn1_right">
				</tr></table></td>	
			<td class="btn1_line"></td>		
			<td class="btn3_bg">
		    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Close">Close</td>
					<td class="btn1_right">
				</tr></table></td>
			</tr>
		</table></td>		
			</tr>
		</table>
    	<!--Button (E) -->
	
	</td></tr>
</table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
<%@include file="/bizcommon/include/common_alps.jsp" %>