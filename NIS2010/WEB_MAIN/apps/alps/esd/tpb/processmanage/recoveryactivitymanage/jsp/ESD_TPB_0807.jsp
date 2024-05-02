<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TPB_0807.jsp
*@FileTitle : Recovery Activity Inquiry / Input
*Open Issues :
*Change history :
*@LastModifyDate : 2009-09-28
*@LastModifier : Jong-Geon Byeon
*@LastVersion : 1.1
* 2009-08-12 O Wan-Ki 			1.0	 최초 생성
* 2009-09-28 Jong-Geon Byeon	1.1 ALPS Migration
=========================================================*/
%> 

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.tpb.processmanage.recoveryactivitymanage.event.EsdTpb0807Event"%>
<%@ page import="com.hanjin.apps.alps.esd.tpb.common.TPBUtils" %>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdTpb0807Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String ofc_cd			= "";
	Logger log = Logger.getLogger("com.hanjin.apps.ProcessManage.RecoveryactivityManage");
	
	String n3pty_no = JSPUtil.getNull(request.getParameter("n3pty_no"));
	String from_n3pty_no = JSPUtil.getNull(request.getParameter("from_n3pty_no")); // Added By Kim Jin-seung In 2007-05-09
	String n3pty_inv_no = JSPUtil.getNull(request.getParameter("n3pty_inv_no"));
	//String file_no = TPBUtils.getInvFileNo(n3pty_inv_no);
	String is_read_only = JSPUtil.getNull(request.getParameter("is_read_only")).trim();

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);

		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		ofc_cd = account.getOfc_cd();


		event = (EsdTpb0807Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
	
	boolean isReadOnly = false;

	if ( is_read_only.trim().equals("Y") ) { // 
		isReadOnly = true;
	} 
%>
<html>
<head>
<title>Recovery Activity Inquiry / Input</title>
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

<input type="hidden" name="iPage">
<input type="hidden" name="s_n3pty_no" value="<%=n3pty_no%>">
<input type="hidden" name="s_from_n3pty_no" value="<%=from_n3pty_no%>">
<input type="hidden" name="s_n3pty_inv_no_origin" value="<%=n3pty_inv_no%>">
<input type="hidden" name="s_user_id" value="<%=strUsr_id%>">
<input type="hidden" name="s_if_ofc_cd" value="<%=ofc_cd%>">
<input type="hidden" name="s_readonly" value="<%=is_read_only%>">
<input type="hidden" name="user_ofc_cd" value="<%=ofc_cd%>">

<!-- OUTER - POPUP (S)tart -->
<table width="1000" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;Recovery Activity</td></tr>
		</table>
		<!-- : ( Title ) (E) -->


		<!-- TABLE '#D' : ( Tab ) (S) Coincidence / Discrepancy / Cost Calculation-->
<!--        <table class="tab">-->
<!--           	<tr><td><script language="javascript">ComTabObject('tab1')</script>-->
<!--		</table>-->
		<!-- TABLE '#D' : ( Tab ) (E) -->

        <div id="tabLayer" style="display:inline">
		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
     	<table class="search" border="0">
       	<tr><td class="bg">

			<table class="height_10"><tr><td></td></tr></table>

			<!-- : ( Grid : Week ) (S) -->


            <table width="100%" height="100%" id="mainTable" border="0">
                <tr><td>
                     <script language="javascript">ComSheetObject('sheet1');</script>
                </td></tr>
            </table>
			<!-- : ( Grid : Week ) (E) -->




			<% if(!isReadOnly){ // %>
			<!-- : ( Button : Sub ) (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
				<tr><td class="btn1_bg">

						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- Repeat Pattern -->

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_add1" id="btn_add1">Row Add</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_save1" id="btn_save1">Save</td><td class="btn1_right"></td></tr></table></td>
							<!-- Repeat Pattern -->

						</tr></table>

				</td></tr>
			</table>
	    	<!-- : ( Button : Sub ) (E) -->
			<% } %>

			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
        </div>

        <div id="tabLayer" style="display:none">
		<!-- TABLE '#D' : ( Tab BG Box 2 ) (S) -->
     	<table class="search" border="0">
       	<tr><td class="bg">

			<table class="height_10"><tr><td></td></tr></table>

			<!-- : ( Invoice No. ) (S) -->
			<table class="search_in" border="0">
			<tr class="h23">
				<td width="12%">&nbsp;Invoice No.</td>
				<td><input type="text" style="width:120;" name="s_n3pty_inv_no" value="<%=n3pty_inv_no%>" readonly required caption="Invoice No."></td>
				<td width="11%" valign="top">File Attached</td>
				<td width="47%" valign="top"><input type="hidden" style="width:330;" name="s_file_no" value="">
					<iframe name="ifr" src="" width="330" height="40" frameborder="0" style="border: #7F9DB9 1px solid"></iframe>
				</td>
				<% if(!isReadOnly){ // %>
				<td width="12%" valign="top"><img class="cursor" src="/hanjin/img/button/btng_filesearch.gif" width="85" height="19" border="0" name="btn_filesearch"></td>
				<% } %>
				</tr>
			</table>
			<!-- : ( Invoice No. ) (E) -->

			<!-- <table class="height_5"><tr><td></td></tr></table> -->

			<!-- : ( Grid : Week ) (S) -->


            <table width="100%" id="mainTable2">
                <tr><td>
                     <script language="javascript">ComSheetObject('sheet2');</script>
                     <!--img class="cursor" src="/hanjin/img/button/btng_filesearch.gif" width="85" height="19" border="0"-->

                </td></tr>
            </table>
			<!-- : ( Grid : Week ) (E) -->

			<% if(!isReadOnly){ // %>
			<!-- : ( Button : Sub ) (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
				<tr><td class="btn1_bg">

						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- Repeat Pattern -->

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_add1" id="btn_add2">Row Add</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_save1" id="btn_save2">Save</td><td class="btn1_right"></td></tr></table></td>
							<!-- Repeat Pattern -->

						</tr></table>

				</td></tr>
			</table>
	    	<!-- : ( Button : Sub ) (E) -->
			<% } %>

			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box 2 ) (E) -->
        </div>

</td></tr>
</table>
<!-- OUTER - POPUP (E)nd -->



<table class="height_10"><tr><td></td></tr></table>


<!-- : ( Button : Sub ) (S) -->
<table width="100%" class="sbutton">
		<tr><td height="71" class="popup">

			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
	       		<tr><td class="btn3_bg">
			    <table border="0" cellpadding="0" cellspacing="0">
			    <tr>

					<!-- Repeat Pattern -->

					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>

					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>
					<!-- Repeat Pattern -->

				</tr>
			</table>

		</td></tr>
</table>
<!-- : ( Button : Sub ) (E) -->

</form>
</body>
</html>