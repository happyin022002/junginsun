<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_2219.jsp
*@FileTitle : S/C Performance Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2016-04-01
*@LastModifier : Jong-Ock KIM
*@LastVersion : 1.0
* 2016-04-01 Jong-Ock KIM
* 1.0 Creation
=========================================================*/

String scNo = "";
String scNo1 = "";
String scNo2 = "";
String srcAddr = "ESM_PRI_2219_01.do";

scNo = JSPUtil.getNull(request.getParameter("cond_sc_no"));

if (scNo != null && scNo !="" && scNo.length() >= 3){
	scNo1 = scNo.substring(0,3);
	scNo2 = scNo.substring(3,scNo.length());
	srcAddr = "ESM_PRI_2219_02.do";
}
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger" %>
<html>
<head>
<title>S/C Performance Summary</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
    function setupPage(){
        loadPage();
    }
</script>
</head>

<body onLoad="setupPage();"> 

<form name="form">
<input type="hidden" name="sc_no1" value="<%= scNo1%>">
<input type="hidden" name="sc_no2" value="<%= scNo2%>">
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">

    <tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0; padding-bottom:2;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
		        
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_bl_list">B/L List</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downexcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	<!--Page Title, Historical (E)-->
		<table class="search">
		<tr>
		<td class="bg">
			<!--  biz_1  (S) -->
			<table class="search_sm2" border="0" style="width:360;"> 
			<tr class="h23" style="height:20">
				<td width="40">Type</td>
				<td class="stm"><input type="radio" class="trans" name="rdoMasterType" value="S" checked>Master RFA Only&nbsp;&nbsp;<input type="radio" class="trans" name="rdoMasterType" value="D">Basic &  Spot & Contract RFA</td>
				</tr>
			</table>
		</td></tr>
		</table>
		<table class="height_8"><tr><td></td></tr></table>		
    	<div style="display:inline;">
			<iframe name="subframe" id="subframe" frameborder="0" scrolling="no" width="100%" height="450" src="<%=srcAddr%>"></iframe>
		</div>
	</td>				
	</tr>
</table>
</form>
</body>
</html>