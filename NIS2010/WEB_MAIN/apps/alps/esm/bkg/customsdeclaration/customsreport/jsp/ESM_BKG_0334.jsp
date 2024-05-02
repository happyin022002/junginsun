<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.framework.core.controller.util.WebKeys"%>
<%@ page import="com.hanjin.framework.core.view.template.Screen"%>
<html>
<head>
<title>Discharge CY by Country Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">

    function setupPage(){  

	    loadPage();
    }

</script>
</head>
<%
	String country 	= request.getParameter("country");
	String viewType = request.getParameter("view_type");
	String otrDchgCd= request.getParameter("otr_dchg_cd");
	if (viewType==null) viewType = "inquiry";
	if (otrDchgCd==null) otrDchgCd = "";
	SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);	
	if (country==null) country = account.getCnt_cd(); //자신의 국가를 넣어야 함
	
	Screen screen = (Screen) request.getAttribute(WebKeys.CURRENT_SCREEN);
	String screenName = screen.getName();
%>	
<body  onLoad="setupPage();"> 

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="loc_cd">
<input type="hidden" name="view_type" value="<%=viewType%>"> 

<!-- OUTER - POPUP (S)tart -->

		<!-- : ( Title ) (S) -->
		<%@include file="../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TITLE.jsp"%>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
			<table class="search"> 
       		<tr><td class="bg">
			<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Search Option</td></tr>
				</table>
				
				<table class="search" border="0" style="width:666;"> 
				<tr class="h23">
					<td width="100">Country</td>
					<td width="100"><input type="text" name="country" style="width:80;" class="input1" value="<%=country%>" maxlength="2" style="ime-mode:disabled" dataformat="engup"></td>
					<td width="75">CY Code</td>
					<td width="120"><input type="text" name="otr_dchg_cd" style="width:100;" class="input" style="ime-mode:disabled" dataformat="engupnum" value="<%=otrDchgCd%>"></td>
					<td width="60">CY Name</td>
					<td width=""><input type="text" style="width:100%;" class="input" name="loc_nm" style="ime-mode:disabled" dataformat="engupspace"></td></tr>
				<tr class="h23">
					<td width="">ALPS Yard Code</td>
					<td width=""><input type="text" style="width:80;" class="input" name="yd_cd" style="ime-mode:disabled" dataformat="engupnum"></td>
					<td width="">CY Loc Code</td>
					<td width=""><input type="text" style="width:100;" class="input" name="loc_full_cd" style="ime-mode:disabled" dataformat="engupnum" maxlength="5"></td>
					<td width="">Port</td>
					<td width=""><input type="text" style="width:100;" class="input" name="port_cd" maxlength="5" style="ime-mode:disabled" dataformat="engupnum"></td></tr>
				</table>
				
				<table class="height_8"><tr><td></td></tr></table>
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">CY Information</td></tr>
				</table>
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
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Add">Row&nbsp;Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Del">Row&nbsp;Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->	
			
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->


	
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" id="btn_retrieve" name="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr></table>
				</td>
				<% if (screenName.indexOf("Q") < 0){ %>
				<td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1_1" name="btn_Save">Save</td>
					<td class="btn1_right"></td>
					</tr></table>
				</td>
				<% } %>
				<td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Select">Select</td>
					<td class="btn1_right"></td>
					</tr></table>
				</td>
				<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downexcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
		</table></td>
			</tr>
		</table>
    <!--Button (E) -->
</td></tr>
</table> 
	<%@include file="../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_BOTTOM.jsp"%>
	
<!-- : ( Button : pop ) (E) -->
			
</form>
</body>
</html>