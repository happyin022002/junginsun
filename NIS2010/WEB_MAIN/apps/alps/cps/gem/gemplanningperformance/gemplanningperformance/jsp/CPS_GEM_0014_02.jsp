<%/*=========================================================
     *Copyright(c) 2009 CyberLogitec
     *@FileName : cps_gem_0014_02.jsp
     *@FileTitle : [CPS_GEM-0014_02] Request Information
     *Open Issues :
     *Change history :
     *@LastModifyDate : 2009.06.23
     *@LastModifier : 박창준
     *@LastVersion : 1.0
     * 2009.06.23 박창준
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
String plnYrmon = JSPUtil.getParameter(request, "pln_yrmon" , "");
String ofcCd = JSPUtil.getParameter(request, "ofc_cd" , "");
String genExpnCd = JSPUtil.getParameter(request, "gen_expn_cd" , "");
String genExpnRqstTpCd = JSPUtil.getParameter(request, "gen_expn_rqst_tp_cd" , "");
String genExpnRqstSeq = JSPUtil.getParameter(request, "gen_expn_rqst_seq" , "");
String genExpnTrnsDivCd = JSPUtil.getParameter(request, "gen_expn_trns_div_cd" , "");
String genExpnRqstNo = JSPUtil.getParameter(request, "gen_expn_rqst_no" , "");
%>

<html>
<head>
<title>Request Information</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
    function setupPage(){
        loadPage();
    }
</script>
</head>
<body CLASS="popup_bg" onLoad="setupPage();">
<form name="form" method="post">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows"> 
<input type="hidden" name="auth_flg">

<input type="hidden" name="pln_yrmon" value="<%= plnYrmon %>">
<input type="hidden" name="ofc_cd" value="<%= ofcCd %>">
<input type="hidden" name="gen_expn_cd" value="<%= genExpnCd %>">
<input type="hidden" name="gen_expn_rqst_tp_cd" value="<%= genExpnRqstTpCd %>">
<input type="hidden" name="gen_expn_rqst_seq" value="<%= genExpnRqstSeq %>">
<input type="hidden" name="gen_expn_trns_div_cd" value="<%= genExpnTrnsDivCd %>">
<input type="hidden" name="gen_expn_rqst_no" value="<%= genExpnRqstNo %>">

<!-- 개발자 작업 -->

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp; Request Information</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!--biz page (S)-->
		<!-- Grid  (S) -->
			<table width="100%" id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
			</table>
		<!-- Grid (E) -->
		<!--biz page (E)--> 

<table class="height_5"><tr><td></td></tr></table>

</td></tr></table>
	
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
					<td class="btn1" name="btn1_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
				</tr></table></td>	
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_DownExcel">Down Excel</td>
					<td class="btn1_right"></td>
				</tr></table></td>			
			<td class="btn1_line"></td>		
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_Close">Close</td>
					<td class="btn1_right"></td>
				</tr></table></td>
			</tr>
		</table></td>
			</tr>
		</table>
    	<!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

</form>
</body>
</html>