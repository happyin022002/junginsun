<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_LSE_0044.jsp
*@FileTitle : Receivable Invoice - Container List
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.09
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.09.09 장준우
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
<%@ page import="com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost.event.EesLse0044Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesLse0044Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String editMode	= JSPUtil.getParameter(request,"rcv_rntl_seq").equals("") ? "F" : "T";
	Logger log = Logger.getLogger("com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EesLse0044Event)request.getAttribute("Event");
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
<title>Receivable Invoice - Container List</title>
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
<input type="hidden" name="edit_mode" value="<%= editMode %>">
<input type="hidden" name="cost_yrmon" value="<%= JSPUtil.getParameter(request,"cost_yrmon") %>">
<input type="hidden" name="rcv_rntl_seq" value="<%= JSPUtil.getParameter(request,"rcv_rntl_seq") %>">
<input type="hidden" name="inv_agmt_seq" value="<%= JSPUtil.getParameter(request,"inv_agmt_seq") %>">
<input type="hidden" name="inv_lstm_cd" value="<%= JSPUtil.getParameter(request,"inv_lstm_cd") %>">
<!-- OUTER - POPUP (S)tart -->
<table width="885" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp; Receivable Invoice - container List
</td></tr>
		</table>
		<!-- : ( Title ) (E) -->

		<!-- : ( Search Options ) (S) -->

			<table class="search">
       		<tr><td class="bg">

				<table class="search" border="0" style="width:865;">
				<tr class="h23">
					<td width="90">&nbsp;Invoice No.</td>
					<td width="150"><input type="text" name="inv_no" style="width:100;text-align:center;" class="input2" value="<%= JSPUtil.getParameter(request,"inv_no") %>" readonly></td>
					<td width="60">Lessee</td>
					<td width="300">
						<input type="text" name="vndr_seq" style="width:60;text-align:center;" class="input2" value="<%= JSPUtil.getParameter(request,"inv_vndr_seq") %>" readonly>
						<input type="text" name="vndr_abbr_nm" style="width:190" class="input2" value="<%= JSPUtil.getParameter(request,"inv_vndr_abbr_nm") %>" readonly>
					</td>
					<td width="120">Invoice Amount</td>
					<td width="">
						<input type="text" name="inv_amt" style="width:90;text-align:right" class="input2" value="<%= JSPUtil.getParameter(request,"fm_chg_amt") %>" readonly>
						<input type="text" name="curr_cd" style="width:40;text-align:center" class="input2" value="<%= JSPUtil.getParameter(request,"fm_curr_cd") %>" readonly>
					</td>
				</tr>
				</table>
				<!-- : ( Grid ) (S) -->
				<table class="height_8"><tr><td></td></tr></table>
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- : ( Grid ) (E) -->
				<!-- : ( Button : Grid ) (S) -->
				<!--  Button_Sub (S) -->
			<table width="100%" class="button">
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
<% if(editMode.equals("T")) { %>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_RowAdd">Row Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Delete">Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
<% } %>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_DownExcel">Down Excel</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>


				</table>
			</td></tr>
			</table>


	    	<!-- Button_Sub (E) -->

		    <!-- : ( Button : Grid ) (E) -->

			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->




</td></tr>
</table>

<!-- : ( Button : pop ) (S) -->




<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
		    	<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left">
					<td class="btn1" name="btn_Retrieve">Retrieve</td>
					<td class="btn1_right">
					</tr>
				</table></td>
<% if(editMode.equals("T")) { %>
		    	<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left">
					<td class="btn1" name="btn_Save">Save</td>
					<td class="btn1_right">
					</tr>
				</table></td>
		    	<td class="btn1_line"></td>
<% } %>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left">
					<td class="btn1" name="btn_Close">Close</td>
					<td class="btn1_right">
					</tr>
				</table></td>
		</td></tr>
		</table>
    <!--Button (E) -->

	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

</form>
</body>
</html>
<%@include file="/bizcommon/include/common_alps.jsp" %>