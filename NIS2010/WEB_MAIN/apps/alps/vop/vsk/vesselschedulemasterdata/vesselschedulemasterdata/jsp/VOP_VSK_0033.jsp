<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0033.jsp
*@FileTitle :  Monitoring Port Registration  
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.04
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2009.06.04 서창열
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
<%@ page import="com.hanjin.apps.alps.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.event.VopVsk0033Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopVsk0033Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.VesselScheduleMasterData.VesselScheduleMasterData");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (VopVsk0033Event)request.getAttribute("Event");
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
<title>Monitoring Port Registration</title>
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
<input type="hidden" name="vop_port_rhq_cd">
<!-- 개발자 작업	-->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">

	<!-- : ( Title ) (S) -->
	<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Monitoring Port Registration </td></tr>
	</table>
	<!-- : ( Title ) (E) -->
	
	
	<!--biz page (S)-->
	<table class="search"> 
    	<tr><td class="bg">
		<!--  biz_1  (S) -->
			<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="90">Country Code</td>
					<td width="100"><input type="text" tabIndex="1" style="width:30;text-align:center;ime-mode:disabled"  class="input1" name="cnt_cd" dataformat="engup" maxlength="2" value="">&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_pop_ctn"></td>
					<td width="30">Port</td>
					<td width="100"><input type="text" tabIndex="2" style="width:63;text-align:center;ime-mode:disabled" class="input"  name="loc_cd" dataformat="engup" maxlength="5" value=""></td>
					<td width="92">Location Name</td>
					<td width=""><input type="text" tabIndex="3" style="width:100%;text-align:left;ime-mode:disabled" class="input" name="loc_nm" dataformat="engup"  maxlength="50"value=""></td>
				</tr>
			</table>
		<!--  biz_1   (E) -->
	
	<table class="line_bluedot"><tr><td></td></tr></table>
		<!--  biz_2  (S) -->
			<table class="search" style="width:684;">
				<tr><td width="100%">
					
					<!-- Grid  (S) -->
					<table width="100%" class="search" id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table> 						
					<!-- Grid (E) -->
				</td></tr>
			</table>
		<!--  biz_2   (E) -->
		</td></tr>
	</table>
	<!--biz page (E)-->
	<table class="height_5"><tr><td></td></tr></table>
</td></tr>
	</table>	
	<!--Button (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right"></td>
				</tr></table></td>
			</tr>
			</table>
		</td></tr>
	</table>
		</td></tr>
	</table>
    <!--Button (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>