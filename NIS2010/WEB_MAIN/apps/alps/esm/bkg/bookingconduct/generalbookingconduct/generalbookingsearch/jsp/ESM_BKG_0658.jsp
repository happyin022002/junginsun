<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ui_bkg_0658.jsp
*@FileTitle : Stop Off Cargo Order
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.13
*@LastModifier : KimByungKyu
*@LastVersion : 1.0
* 2009.05.13 KimByungKyu
* 1.0 Creation
* 2011.03.30 정선용 [CHM-201109338-01] Split 18-ALPS의 Location 조회불가건 수정 보완 요청.
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg0658Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0658Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String calllFunc 		= "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmBkg0658Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		calllFunc  = JSPUtil.getParameter(request, "func");
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Stop Off Cargo Order</title>
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
<input type="hidden" name="calllFunc" value="<%=calllFunc%>">
<!-- 개발자 작업	-->
<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Stop Off Cargo Order</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
			<table class="search"> 
       		<tr><td class="bg">
			
			<table class="search" border="0" style="width:497;"> 
				<tr class="h23">
					<td width="88">Location</td> 
					<td width="150"><input type="text" name="stop_off_loc_cd" style="width:100" class="input" maxlength=5 style="ime-mode:disabled"  dataformat="engupnum"></td>
					<td width="20">Tel</td> 
					<td width=""><input type="text" name="stop_off_cntc_phn_no" style="width:100%" class="input" maxlength=20></td>
				</tr>
				<tr class="h23">
					<td width="">Contact Point</td> 
					<td width="" colspan="3"><input type="text" name="stop_off_cntc_pson_nm" style="width:100%" class="input" maxlength=30></td>
				</tr></table>
				<!-- : ( Grid ) (S) -->
				<table border="0" style="width:100%; background-color:white;" class="grid2"> 
				<tr>
				<td  class="tr2_head" width="18%"> Remark(s)</td>
				<td align="center"><textarea rows="6" style="width:100%" name="stop_off_diff_rmk"></textarea></td>
				</tr>
				
				</table> 
				<!-- : ( Grid ) (E) -->	
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
					<td class="btn1" name="btn_Save">OK</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				
				<td class="btn1_line">
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Close">Close</td>
					<td class="btn1_right"></td>
				</tr></table></td>
			</tr>
		</table></td></tr>
</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
<table width="50%"  id="mainTable">
	<tr>
		<td width="50%">
			<script language="javascript">ComSheetObject('sheet1');</script>
		</td>
	</tr>
</table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>