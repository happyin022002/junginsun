<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_MAS_0010.jsp
*@FileTitle : MT CNTR MVMT History
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.10
*@LastModifier : 장영석
*@LastVersion : 1.0
* 2009.09.10 장영석
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.mas.stdunitcost.mtcost.event.EsmMas0010Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EsmMas0010Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	//부모창에서 받은 변수
	String f_cost_yrmon= JSPUtil.getNullNoTrim(request.getParameter("f_cost_yrmon"));
	String f_from_ecc= JSPUtil.getNullNoTrim(request.getParameter("f_from_ecc"));
	String f_to_ecc= JSPUtil.getNullNoTrim(request.getParameter("f_to_ecc"));
	String f_cntr_tpsz_cd= JSPUtil.getNullNoTrim(request.getParameter("f_cntr_tpsz_cd"));
	String f_ori_dest= JSPUtil.getNullNoTrim(request.getParameter("f_ori_dest"));
	
	Logger log = Logger.getLogger("com.hanjin.apps.STDUnitCost.MTCost");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmMas0010Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
        log.error("Exception : " + e.toString());
	}
%>
<html>
<head>
<title>ECC별 MT 표준단가&MT Turntime 생성 팝업</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
		setRetrieveAction();
	}
</script>
</head>

<body onload="setupPage();">
<form method="post" name="form">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="f_cost_yrmon" value="<%= f_cost_yrmon %>">
<input type="hidden" name="f_from_ecc"  value="<%= f_from_ecc %>">
<input type="hidden" name="f_to_ecc"  value="<%= f_to_ecc %>">
<input type="hidden" name="f_cntr_tpsz_cd"  value="<%= f_cntr_tpsz_cd %>">
<input type="hidden" name="f_ori_dest"  value="<%= f_ori_dest %>">




  <!-- OUTER - POPUP (S)tart -->
  <table width="100%" class="popup" cellpadding="10" border="0">
    <tr><td class="top"></td></tr>
    <tr><td valign="top">

			<!-- : ( Title ) (S) -->
			<table width="100%" border="0">
			<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp; Inquire MT CNTR MVMT History</td></tr>
			</table>
			<!-- : ( Title ) (E) -->

		<!-- : ( Search Options ) (S) -->
		<table class="search">
		<tr><td class="bg">


				<!-- : ( Grid ) (S) -->
				<table width="100%" id="mainTable">
					<tr><td>
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td></tr>
				</table>
				<!-- : ( Grid ) (E) -->

			</td></tr>
		</table>
		<!-- : ( Search Options ) (E) -->


</td></tr>
</table>
<!-- OUTER - POPUP (E)nd -->

<table class="height_5"><tr><td></td></tr></table>


<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>

				<!-- Repeat Pattern -->
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_DownExcel" id="btn_DownExcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>

				<td class="btn1_line"></td>

				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_Close" id="btn_Close">Close</td><td class="btn1_right"></td></tr></table></td>
				<!-- Repeat Pattern -->

			</tr>
		</table>

	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->


</form>
</body>
</html>