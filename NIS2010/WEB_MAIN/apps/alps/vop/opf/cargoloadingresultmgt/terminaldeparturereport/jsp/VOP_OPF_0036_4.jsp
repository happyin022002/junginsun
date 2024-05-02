<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_opf_0036_4.jsp
*@FileTitle : TDR Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.06
*@LastModifier : 장석현
*@LastVersion : 1.0
* 2009.07.06 장석현
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
<%@ page import="com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.event.VopOpf0036Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>
<%
	VopOpf0036Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.CargoLoadingResultMgt.TerminalDepartureReport");
	String btnDis			= "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		btnDis = StringUtil.xssFilter(request.getParameter("btnDis"));


		event = (VopOpf0036Event)request.getAttribute("Event");
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
<title>TDR Creation</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage("<%=btnDis%>");
	}
</script>
</head>

<body  onLoad="setupPage();" topmargin="0" leftmargin="0">

<form name="form">
<!-- TAB [ Disch. Vol. ] (S) -->
		<table class="search" id="mainTable">
       	<tr><td class="bg">

			<!-- Title - 1 -->
			<table class="search_sm2" border="0" style="width:420;">
			<tr class="h23">
				<td><input type="radio" value="" class="trans" name="chk_LoadVol" checked>&nbsp;Ocean&nbsp;&nbsp;&nbsp;
					<input type="radio" value="" class="trans" name="chk_LoadVol">&nbsp;Inter Port&nbsp;&nbsp;&nbsp;
					<input type="radio" value="" class="trans" name="chk_LoadVol">&nbsp;Special Cargo&nbsp;&nbsp;&nbsp;
					<input type="radio" value="" class="trans" name="chk_LoadVol">&nbsp;Break-Bulk</td>
			</tr>
			</table>
			<table class="height_5"><tr><td></td></tr></table>
			<!-- Title - 1 -->

<%
for( int cnt = 1; cnt < 5; cnt++){
%>
			<!-- Grid - 1 : Total Volume (S) --> 
				<SPAN id="t4sheetDiv" style="display:<%=(cnt == 1 ? "inline" : "none")%>">
					<table width="100%"  id="mainTable">
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('t4sheet<%=cnt%>');</script>
							</td>
						</tr>
					</table>
				</SPAN>
			<!-- Grid - 1 : Total Volume (E) --> 
<%
}
%>

<%
	if(btnDis != null && btnDis.equals("Y")){
%>

			<!--  Button_Sub (S) -->
			<table width="100%" class="button">
			<tr>
			<td>
			    <!-- <td width="180">
			    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_t4Import">Import BKG data for ref.</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td></td> -->
				<td width="180"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_t4ImportPart" id="btn_t4ImportPart">Import BKG data for ref.</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td></td>

	       		<td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_t4RowAdd">Row Add</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_t4RowInsert">Row Insert</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_t4RowCopy">Row Copy</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_t4Delete">Row Delete</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>

					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
<%
}
%>


			</td></tr>
		</table>
		<!--biz page (E)-->
<!-- TAB [ Disch. Vol. ] (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
