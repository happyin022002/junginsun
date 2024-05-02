<%--
/*=========================================================
*Copyright(c) 2007 CyberLogitec
*@FileName : ESD_SCE_0102.jsp
*@FileTitle : Send Mail
*Open Issues :
*Change history :
*@LastModifyDate : 2008-04-21
*@LastModifier : YuJin
*@LastVersion : 1.0
* 1.0
=========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.common.popup.event.CommonPopUpManageEvent"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	CommonPopUpManageEvent  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	String rsnNames = "";
	String szSendValue = null;
	String szBkgNoValue = null;
	String szBkgNoSplitValue = null;
	String bkgPsonEml="";
	
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.common.popup");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   	strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		
		event = (CommonPopUpManageEvent)request.getAttribute("Event");
		
		szSendValue  = request.getParameter("send_val");
		szBkgNoValue = request.getParameter("szBkgNo");
		
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
<title>Welcome to NMS!</title>
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
<base target="_self"/>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">

<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="expt_no" value ="<%= szSendValue%>">
<input type="hidden" name="subject" value="">
<input type="hidden" name="contents" value="">
<input type="hidden" name="attachnm" value="">
<input type="hidden" name="send_eml3" value="">
<input type="hidden" name="szBkgNo" value="<%=szBkgNoValue%>">
<input type="hidden" name="usr_id" value="<%=strUsr_id%>">




<!-- OUTER - POPUP (S)tart -->
<table width="500" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
<tr><td valign="top">

			<!-- : ( Title ) (S) -->
			<table width="100%" border="0">
			<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;Send Mail</td></tr>
			</table>
			<!-- : ( Title ) (E) -->
		</td>
		</tr>
   		<tr><td>
   			<table class="search" border="0"><tr><td class="bg">
   			<input type="radio" name ="selection" value ="location" class="trans" checked>&nbsp;To SM LINE
			<input type="radio" name ="selection" value ="node" class="trans">&nbsp;To Customer
			</table>
		</td></tr>
		<!-- : ( Search Options ) (S) -->
		<tr><td>
			<div id="location">
			<table class="search">
				<tr><td class="bg">
	     			<table class="search">
	       				<tr><td class="bg">
							<!-- : ( Forecast Data Type ) (S) -->
							<table class="search" border="0">
								<tr><td colspan ="2"  align="center">
									<table class="search" border="0">
										<tr><td class="title_h"></td>
											<td class="title_s">Exception Notification - Send
										</td></tr>
										<tr><td class="height_5"></td></tr>
									</table>
								</td></tr>
								<tr class="h23"><td width="100">To SM LINE</td>
												<td>&nbsp;<input id="send_eml" name="send_eml1" type="text" style="width:336" value="" >
												<img onClick="openStaffPop(true,'')" class="cursor"  src="/hanjin/img/button/btns_search.gif" width="19"  name = "btn_search"  height="20" border="0" align="absmiddle">
								</td></tr>
								<tr class="h23"><td width="100">Subject</td>
												<td>&nbsp;<input name="subject1" type="text" style="width:360" value="Exception Notification">
								</td></tr>
								<tr class="h23"><td valign="top" width="100">Note</td>
												<td ><textarea name="contents1" rows="5" style="width:360;"><%=rsnNames%> </textarea>
								</td></tr>
								<tr class="h23"><td valign="top" rowspan="2" width="100">File</td>
												<td >&nbsp;<input name="attachNm1" value = "Exception_Notification.xls" style="width:360;" readonly>
								</td></tr>
							</table>
							<!-- : ( Forecast Data Type ) (E) -->
						</td></tr>
					</table>
	 			</td></tr>
	 		</table>
			</div>
		</td></tr>
			<!-- : ( Search Options ) (E) -->

		<!-- : ( Search Options ) (S) -->
		<tr><td>
			<div id="node" style="display:none">
			<table class="search">
				<tr><td class="bg">
	     			<table class="search">
	       				<tr><td class="bg">
							<!-- : ( Forecast Data Type ) (S) -->
							<table class="search" border="0">
								<tr><td colspan ="2"  align="center">
									<table class="search" border="0">
										<tr><td class="title_h"></td>
											<td class="title_s">Exception Notification - Send
										</td></tr>
										<tr><td class="height_5"></td></tr>
									</table>
								</td></tr>
								<tr class="h23"><td width="100" >To Customer</td>
												<td>&nbsp;<input id="send_eml2" name="send_eml2" type="text" style="width:360" value="<%=bkgPsonEml%>" >
								</td></tr>
								<tr class="h23"><td width="100" >Subject</td>
												<td>&nbsp;<input name="subject2" type="text" style="width:360" value="Exception Notification">
								</td></tr>
								<tr class="h23"><td valign="top" width="100">Note</td>
												<td ><textarea name="contents2" rows="5" style="width:360;"><%=rsnNames%> </textarea>
								</td></tr>
								<tr class="h23"><td valign="top" rowspan="2" width="100">File</td>
												<td >&nbsp;<input name="attachNm2" value = "Exception_Notification.xls" style="width:360;" readonly>
								</td></tr>
							</table>
							<!-- : ( Forecast Data Type ) (E) -->
						</td></tr>
					</table>
	 			</td></tr>
	 		</table>
			</div>
		</td></tr>
			<!-- : ( Search Options ) (E) -->

</table>
<!-- OUTER - POPUP (E)nd -->

<table class="height_10"><tr><td></td></tr></table>
<%--script language ="javascript">
function insert() {
alert( "test 용! 한정우에게 메일보내기~");
//	document.getElementById("send_id").value = "minestar;";
//	document.getElementById("send_nm").value = "minestar;";
	document.getElementById("send_eml").value ="minestar@cyberlogitec.com;";
}
</script>
<div onclick="javascript:insert();">_</div--%>

<!-- : ( Button : Sub ) (S) -->
<table width="100%" class="sbutton">
		<tr><td height="71" class="popup">

			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
	       		<tr><td class="btn3_bg">
			    <table border="0" cellpadding="0" cellspacing="0">
			    <tr>

					<!-- Repeat Pattern -->
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_send" id="btn_send">Send</td><td class="btn1_right"></td></tr></table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>
					<!-- Repeat Pattern -->

				</tr>
			</table>

		</td></tr>
</table>
<!-- : ( Button : Sub ) (E) -->
</form>
<!-- form for Adding a file  -->
	<form method="post" name="form1" ENCTYPE="multipart/form-data">
		<input type="hidden" id="fileParameterNames" name="fileParameterNames" value="fileObj"><!-- file oblect id names, delimiter : '|'  -->
		<input type="hidden" id="f_cmd" name="f_cmd" value=""><!-- command -->
		<input type="hidden" id="fileNo" name="fileNo" value=""><!-- fileNo -->
		<input type="hidden" id="tpbNo" name="tpbNo" value=""><!-- tpbNo -->
		<input type="hidden" id="invNo" name="invNo" value=""><!-- invNo -->
		<input type="hidden" name="send_eml" value="">
		<input type="hidden" name="subject" value="">
		<input type="hidden" name="contents" value="">
		<input type="hidden" name="attachNm" value="">
		<span id="spanFile" style="position:absolute;width:7px;height:7px;background-color:;clip:rect(2 43 25 2);
		z-index:9;cursor:hand;overflow-x:hidden;overflow-y:hidden;vertical-align:middle;align:center;"
		onclick=""><input type="file" id="fileObj" name="fileObj" style="cursor:hand;width:0px;height:100px;background-color:gold;filter:alpha(opacity=0);
		border-bottom:0px; border-left:0px; border-right:0px; border-top:0px;margin-bottom:0px; margin-left:0px; margin-right:0px; margin-top:0px;" onclick="disappearPoint();" onchange="fileObj_onchange();"></span>
	</form>
	
	<!-- : ( Speed ) (S) -->
				<table border="0" style="display:none;">
				<tr>
					<td>
                      <script language="javascript">ComSheetObject('sheet');</script>
                    </td>
                 </tr>
				 </table>
				<!-- : ( Speed ) (E) -->
</body>
</html>
