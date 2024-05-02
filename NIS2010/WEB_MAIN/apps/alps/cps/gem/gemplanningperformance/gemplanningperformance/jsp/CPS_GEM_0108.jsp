<%/*=========================================================
     *Copyright(c) 2009 CyberLogitec
     *@FileName : cps_gem_0108.jsp
     *@FileTitle : [CPS_GEM-0108] Performance Inquiry_Additional
     *Open Issues :
     *Change history :
     *@LastModifyDate : 2009.06.25
     *@LastModifier : 박창준
     *@LastVersion : 1.0
     * 2009.06.25 박창준
     * 1.0 Creation
     =========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
String fmOfcCd = JSPUtil.getParameter(request, "fm_ofc_cd" , "");
String toOfcCd = JSPUtil.getParameter(request, "to_ofc_cd" , "");
String fmGenExpnCd = JSPUtil.getParameter(request, "fm_gen_expn_cd" , "");
String toGenExpnCd = JSPUtil.getParameter(request, "to_gen_expn_cd" , "");
String plnYrmon = JSPUtil.getParameter(request, "pln_yrmon" , "");

%>

<html>
<head>
<title>Performance Inquiry_Additional</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>
<script language="javascript">
    function setupPage(){
        loadPage();
    }
</script>
</head>
<body onLoad="setupPage();">
<form name="form" method="post">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows"> 
<input type="hidden" name="auth_flg">

<input type="hidden" name="fm_ofc_cd" value="<%= fmOfcCd %>">
<input type="hidden" name="to_ofc_cd" value="<%= toOfcCd %>">
<input type="hidden" name="fm_gen_expn_cd" value="<%= fmGenExpnCd %>">
<input type="hidden" name="to_gen_expn_cd" value="<%= toGenExpnCd %>">
<input type="hidden" name="pln_yrmon" value="<%= plnYrmon %>">
<input type="hidden" name="gen_expn_rqst_tp_cd" value="EA">

<!-- 개발자 작업 -->

<!-- OUTER - POPUP (S)tart -->
<table width="800" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Performance Inquiry</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			
				<!--  biz_1  (S) -->
				<table class="search_sm2" border="0" style="width:200;"> 
					<tr class="h23">
						<td><input type="radio" value="" class="trans" checked>Additional&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" value="" class="trans" disabled>Transfer</td>
					</tr>
				</table> 
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="85">&nbsp;&nbsp;RQST Office</td>
					<td width="90"><input type="text" style="width:50;" class="input" value="<%= fmOfcCd %>" readonly></td>
					<td width="130">RQST Expense Code</td>
					<td width=""><input type="text" style="width:50;" class="input" value="<%= fmGenExpnCd %>" readonly></td>
							
				</tr> 
				</table>				
				<!--  biz_1   (E) -->
				
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				
				<!-- Grid  (S) -->
				<table width="100%" id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- Grid (E) -->	
			
		</td></tr></table>
		<!--biz page (E)--> 

</td></tr></table>

<table class="height_5"><tr><td></td></tr></table>
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

    	<!--Button (S) -->	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_Print">Print</td>
					<td class="btn1_right">
				</tr></table></td>		
			<td class="btn1_line"></td>		
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_Close">Close</td>
					<td class="btn1_right">
				</tr></table></td>
				
			</tr>
		</table>
    	<!--Button (E) -->
	
	</td></tr>
	<tr>
		<td height="0" width="0">
			<script language="javascript">comRdObject('report1');</script>
			</td>
		</tr>
</table>
<!-- : ( Button : pop ) (E) -->

</form>
</body>
</html>