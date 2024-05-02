<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : COM_ENS_0F1.jsp
*@FileTitle : VVD Exchange Rate Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-24
*@LastModifier : Hyung Choon_Roh
*@LastVersion : 1.0
* 2006-10-24 Hyung Choon_Roh
* 1.0 최초 생성
=========================================================*/ 
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.bizcommon.exrate.vvd.event.ComEns0F1Event"%>
<%
	ComEns0F1Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	int rowCount	 = 0;								  //DB ResultSet 리스트의 건수
	String main_page = "";
	String strErrMsg = "";
	
	try {

		event = (ComEns0F1Event)request.getAttribute("Event");
		
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		main_page = JSPUtil.getParameter(request, "main_page".trim(), "");
        
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>VVD Exchange Rate</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
        	ComShowMessage(errMessage);
        } // end if
        
		// 탭을 사용하는 화면인 경우 추가한다.
        // InitTab();
        loadPage(<%=main_page%>);
    }
</script>
</head>
<!-- 
showErrMessage를 써주지 않으면 에러 발생시 처리가 불가합니다.
그리고 지금은 showErrMessage()으로 되어있지만 추후에 고객님이 변덕을 일으켜서 웹페이지를 호출하라고 할경우를 
대비해서 직접 showErrMessage() 하지 마시고 꼭 showErrMessage를 써주십시오. 한방에 바꾸게요. 표준을 안따르면 나중에 후회합니다.  
-->

<!-- OUTER - POPUP (S)tart -->

<%if(main_page.equals("true")){ %>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd"> 
<input type="hidden" name="iPage"> 
		
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->
		
<%} else { %>
<body class="popup_bg" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd"> 
<input type="hidden" name="iPage"> 
		
<table width="755" class="popup" cellpadding="10"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="735" border="0">
		<tr><td height="79" class="title"><img src="img/icon_title_dot.gif" align="absmiddle"> VVD Exchange Rate Inquiry</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
	<%} %>	


		
		<!-- TABLE '#D' : ( Search Options : Scenario ID ) (S) -->
		<table class="search"> 
			<tr>
				<td class="bg">


				<!-- : ( Scenario ID ) (S) -->
				<table class="search" border="0" style="width:735;"> 
				<tr class="h23">
					<td width="4%">VVD</td>
					<td width="12%">&nbsp;<input type="text" name="vvd_cd" style="width:70" maxlength="9" onKeyUp="javascript:upper(this);"></td>
					<td width="4%">Port</td>
					<td width="10%">&nbsp;<input type="text" name="port_cd" style="width:50" maxlength="5" onKeyUp="javascript:upper(this);"></td>
					<td width="10%">Charge Cur</td>
					<td width="13%">
						<%= com.hanjin.bizcommon.util.BizComUtil.getCodeCombo("chg_curr_cd", "", "", "CURR", 2, "0: :ALL") %>
					</td>
					<td width="10%">Local Cur</td>
					<td width="13%">
						<%= com.hanjin.bizcommon.util.BizComUtil.getCodeCombo("locl_curr_cd", "", "", "CURR", 2, "0: :ALL") %>
					</td>
					<td width="5%">Scope</td>
					<td width="8%"><input type="text" name="svc_scp_cd" style="width:30" maxlength="3" onKeyUp="javascript:upper(this);"></td>
					<td width="5%">Bound</td>
					<td width="20%"><select name="io_bnd_cd" style="width:70;">
							<option value="" selected>All</option>
							<option value="O" selected>O/B</option>
							<option value="I" selected>I/B</option>
							</select></td></tr> 
					
				
				</table>
				<!-- : ( Scenario ID ) (E) -->
				
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			
			<!-- : ( Grid ) (S) -->
					<table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet');</script>
                        </td></tr>
		            </table>
			<!-- : ( Grid ) (E) -->
					<table width="100%" class="button"> 
			       		<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<td width="100"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn2_Down_Excel">Down Excel</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
					</table>
				</td>
			</tr>
		</table>				
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->

</td></tr>
</table> 
<!-- OUTER - POPUP (E)nd -->


<%if(!main_page.equals("true")){ %>
<!-- : ( Button : Sub ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_New">New</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_OK">OK</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td class="btn1_line"></td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_Close">Close</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
				</tr>
				</table>
			</td>
			</tr>
		</table>

	</td></tr>
</table>
<!-- : ( Button : Sub ) (E) -->
<%}else{ %>
<!--Button (S) -->
<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
     	<tr><td class="btn1_bg">

    <table border="0" cellpadding="0" cellspacing="0">
    <tr><td>
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
			<tr><td class="btn1_left"></td>
				<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
				<td class="btn1_right"></td>
			</tr>
		</table>
		</td>
		<td>
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                <tr><td class="btn1_left"></td>
                <td class="btn1" name="btn_New">New</td>
                <td class="btn1_right"></td>
                </tr>
            </table>
        </td>
		<td>
		</td>
		</tr>
	</table>
</td></tr>
</table>
<%} %>

</form>
</body>
</html>

 <%@include file="../../../include/common_alps.jsp"%>