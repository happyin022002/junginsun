<%-- =========================================================
*Copyright(c) 2007 CyberLogitec
*@FileName : ESD_SCE_0057.jsp
*@FileTitle : USIOR COLUMN항목 선택 팝업화면
*Open Issues :
*Change history :
*@LastModifyDate : 2007-12-17
*@LastModifier : Jeongseon, An
*@LastVersion : 1.0
* 2007-12-17 Jeongseon, An
* 1.0 최초 생성
=========================================================
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>

<%
String strErrMsg = "";
%>
<html>
<head>
<title>Customized Report Form</title>
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
<!--
showErrMessage를 써주지 않으면 에러 발생시 처리가 불가합니다.
그리고 지금은 showErrMessage()으로 되어있지만 추후에 고객님이 변덕을 일으켜서 웹페이지를 호출하라고 할경우를
대비해서 직접 showErrMessage() 하지 마시고 꼭 showErrMessage를 써주십시오. 한방에 바꾸게요. 표준을 안따르면 나중에 후회합니다.
-->

<body leftmargin="0" topmargin="0" rightmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input    type="hidden" name="f_cmd">
<input    type="hidden" name="report_list" >
<input    type="hidden" name="pgm_no" value="ESD_SCE_0057" >

<!-- OUTER - POPUP (S)tart -->
<table width="500" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Customized Report Form</td></tr>
		</table>
		<!-- : ( Title ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>
		<!-- : ( Search Options ) (S) -->
 		<table class="search" style="width:780;"> 
  		<tr><td class="bg">

			
			<table class="search" border="0" > 
			<tr class="h23">
				<td width="340">
				
					<!-- : ( Grid ) (S) -->
					<table width="100%"  id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table>
					<!-- : ( Grid ) (E) -->	
				</td>
				<td width="50">
					<table class="search" border="0">
						<tr><td align="center"><img class="cursor" src="img/btns_add.gif" width="26" height="26" border="0" align="absmiddle" name="btns_add"></td></tr>
						<tr><td height="10"></td></tr>
						<tr><td align="center"><img class="cursor" src="img/btns_del.gif" width="26" height="26" border="0" align="absmiddle" name="btns_del"></td></tr>
						<tr><td height="10"></td></tr>
						<!-- <tr><td align="center"><img class="cursor" src="img/btn_calendar_next.gif" width="19" height="10" border="0" align="absmiddle" name="btns_up"></td></tr>
						<tr><td height="10"></td></tr>
						<tr><td align="center"><img class="cursor" src="img/btn_calendar_back.gif" width="19" height="10" border="0" align="absmiddle" name="btns_down"></td></tr>
					//-->
					</table>
				</td>
				<td width="340">
				
					<!-- : ( Grid ) (S) -->
					<table width="100%"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet2');</script>
							</td>
						</tr>

					<!-- : ( Grid ) (E) -->	
					
				</td></tr>
		</table>
				<!-- : ( Button : Grid ) (S) -->
				<!--  Button_Sub (S) -->
			
	    	<!-- Button_Sub (E) -->
		    <!-- : ( Button : Grid ) (E) -->	
			
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->
</td></tr>
</table> 

<table class="height_5"><tr><td></td></tr></table>
	
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td width="">
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_ok">Ok</td>
						<td class="btn1_right"></td>
						</tr>
					</table>
				</td>

				<td width="">
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_close">Close</td>
						<td class="btn1_right"></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>

