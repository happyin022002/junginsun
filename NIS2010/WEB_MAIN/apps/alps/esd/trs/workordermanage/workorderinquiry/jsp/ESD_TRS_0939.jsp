<%/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ESD_TRS_0939.jsp
*@FileTitle : Authorization W/O Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.21
*@LastModifier : 9014787
*@LastVersion : 1.0
* 2015.07.21 9014787
* 1.0 Creation
*----------------------------------------------------------
* History
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.trs.workordermanage.workorderinquiry.event.EsdTrs0939Event"%> 
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil"%>
<%
	EsdTrs0939Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	GeneralEventResponse eventResponse = null;	//RDTO(Data Transfer Object including DB ResultSet)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";								 //에러메세지
	int rowCount	 = 0;								  //DB ResultSet 리스트의 건수

	try {

		event = (EsdTrs0939Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
			eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
		} // end else
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<html>
<head>
<title>Authorization W/O Detail</title>
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

<body class="popup_bg" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="iPage">
<input type="hidden" name="auth_apro_rqst_no" value="<%=event.getAuthAproRqstNo()%>">
<input type="hidden" name="btn_flag">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="img/ico_t1.gif" width="20" height="12">Authorization W/O Detail</td></tr>
		</table>
		<!-- : ( Title ) (E) -->



		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
		<table class="search" border="0">
			<tr>
				<td class="bg">



			<!-- : ( Grid ) (S) -->
					<table width="100%" id="mainTable">
	                                      <tr><td>
	                                             <script language="javascript">ComSheetObject('sheet1');</script>
	                                      </td></tr>
	                </table>
			<!-- : ( Grid ) (E) -->

				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->



<table class="height_5"><tr><td></td></tr></table>


</td></tr>
</table>
<!-- OUTER - POPUP (E)nd -->




<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
		    	<td id="td_btn_save" style="display:none"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_save" id="btn_save">Save</td><td class="btn1_right"></td></tr></table></td>
		    	<td id="td_btn_confirm" style="display:none"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_confirm" id="btn_confirm">Confirm</td><td class="btn1_right"></td></tr></table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>
			</tr>
		</table></td>
			</tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : Sub ) (E) -->
</form>
</body>
<script type="text/javascript">
var btn_flag = "<%=StringUtil.xssFilter(request.getParameter("confirm"))%>";	
if(btn_flag == "Y"){
	var target;

	target = document.getElementById('td_btn_save');
	target.style.display = "block";
	
	target = document.getElementById('td_btn_confirm');
	target.style.display = "block";
	
	// 플레그를 이용해서..comment 저장을 막는다.
	var target_btn_flag = document.getElementById('btn_flag');
	target_btn_flag.value = "Y";
}
</script>
</html>