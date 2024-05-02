<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0240.jsp
*@FileTitle : Service Provider Group Registration (Pop-up)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.24
*@LastModifier : 서창열
*@LastVersion : 1.0
* 2009.08.24 서창열
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
<%@ page import="com.hanjin.apps.alps.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.event.VopVsk0240Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopVsk0240Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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


		event = (VopVsk0240Event)request.getAttribute("Event");
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
<title>Service Provider Group Registration (Pop-up)</title>
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

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="vndr_seq">
<input type="hidden" name="eventNav">
<input type="hidden" name="delFlg">
<!-- 개발자 작업	-->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
	<!-- : ( Title ) (S) -->
	<table width="100%" border="0">
	<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Service Provider Group Registration  </td></tr>
	</table>
	<!-- : ( Title ) (E) -->
		
	<!-- : ( Search Options ) (S) -->
 			
	<table class="search"> 
		<tr><td class="bg">
		
			<!-- : ( Grid ) (S) -->
			<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
			</table>
			<!-- : ( Grid ) (E) -->	
		
			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       		<tr><td class="btn2_bg">
					<table border="0" cellpadding="0" cellspacing="0">
					<tr><td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_add">Row Add</td>
							<td class="btn2_right"></td>
							</tr>
							</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn_del">Row Delete</td>
								<td class="btn2_right"></td>
							</tr>
						</table>
					</td></tr>
					</table>
				</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
			
		</td></tr>
	</table>
	<!-- : ( Search Options ) (E) -->

	<table class="height_8"><tr><td></td></tr></table>

	<!-- : ( Search Options ) (S) -->
	<table class="search"> 
      	<tr><td class="bg">
      		
			<!--  biz_1  (S) -->
			<table class="search" border="0" style="width:780;"> 
				<tr class="h23"><td width="300" valign="top">
				
					<!-- : ( Grid ) (S) -->
					<table width="100%"  id="mainTable"> 
						<tr><td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td></tr>
					</table>					
					<!-- : ( Grid ) (E) -->	
				
				</td> 
				<td width="60" align="center">
					<img src="img/btns_add.gif" name="btn_rAdd" width="26" height="26" alt="" border="0">
					<br><br>
					<img src="img/btns_del.gif" name="btn_rDel" width="26" height="26" alt="" border="0"></td>   
				<td width="420" valign="top">
					<table width="100%"  id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet3');</script>
							</td>
						</tr>
					</table>
			
			
					<!--  Button_Sub (S) -->
					<table width="100%" class="button"> 
			       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0"><tr>
							<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_retrieve">Retrieve</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
							<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_save">Save</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
							<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_new">New</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
						</tr></table>
					</td></tr>
					</table>
			    	<!-- Button_Sub (E) -->
				
				</td>   
			</tr>
			</table>
			<!--  biz_1   (E) -->
				
			<table class="height_5"><tr><td></td></tr></table>
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
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<!-- <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_test">Test</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td> -->
			</tr>
			</table>
		</td></tr>
	</table>
    <!--Button (E) -->
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
	
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
<%@include file="/bizcommon/include/common_alps.jsp" %>