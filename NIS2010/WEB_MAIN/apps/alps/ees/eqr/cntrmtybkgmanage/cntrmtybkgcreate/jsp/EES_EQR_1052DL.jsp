<%/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EES_EQR_1052DL.jsp
*@FileTitle : BKG Split EXCEL FORMAT
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.22
*@LastModifier : 신용찬
*@LastVersion : 1.0
* 2013.08.22 신용찬
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.event.EesEqr1052Event"%>
<%@ page import="com.hanjin.apps.alps.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.vo.EesEqr1052ConditionVO" %>
<%@ page import="org.apache.log4j.Logger" %>
<% 
response.setContentType("application/x-msdownload");
response.setHeader("Content-Disposition", "attachment;filename=Format_Excel.xls;");
%>

<style>
<!--table
	{mso-displayed-decimal-separator:"\.";
	mso-displayed-thousand-separator:"\,";}
@page
	{margin:1.0in .75in 1.0in .75in;
	mso-header-margin:.5in;
	mso-footer-margin:.5in;}
tr
	{mso-height-source:auto;
	mso-ruby-visibility:none;}
col
	{mso-width-source:auto;
	mso-ruby-visibility:none;}
br
	{mso-data-placement:same-cell;}
.style0
	{mso-number-format:General;
	text-align:general;
	vertical-align:middle;
	white-space:nowrap;
	mso-rotate:0;
	mso-background-source:auto;
	mso-pattern:auto;
	color:windowtext;
	font-size:11.0pt;
	font-weight:400;
	font-style:normal;
	text-decoration:none;
	font-family:돋움, monospace;
	mso-font-charset:129;
	border:none;
	mso-protection:locked visible;
	mso-style-name:표준;
	mso-style-id:0;}
td
	{mso-style-parent:style0;
	padding-top:1px;
	padding-right:1px;
	padding-left:1px;
	mso-ignore:padding;
	color:windowtext;
	font-size:13.0pt;
	font-weight:400;
	font-style:normal;
	text-decoration:none;
	font-family:돋움, monospace;
	mso-font-charset:129;
	mso-number-format:General;
	text-align:general;
	vertical-align:middle;
	border:none;
	mso-background-source:auto;
	mso-pattern:auto;
	mso-protection:locked visible;
	white-space:nowrap;
	mso-rotate:0;}
.xl24
	{mso-style-parent:style0;
	mso-number-format:"\@";
	text-align:center;
	border:.0pt solid windowtext;
	background:white;
	mso-pattern:auto none;}
.xl25
	{mso-style-parent:style0;
	mso-number-format:"\@";
	text-align:center;
	border:.5pt solid windowtext;
	background:silver;
	mso-pattern:auto none;
	white-space:normal;}
.xl26
	{mso-style-parent:style0;
	mso-number-format:"\@";
}
.xl27
	{mso-style-parent:style0;
	mso-number-format:"\#\,\#\#0\.00_ ";
	border:.5pt solid windowtext;}
.xl28
	{mso-style-parent:style0;
	mso-number-format:General;
}
ruby
	{ruby-align:left;}
rt
	{color:windowtext;
	font-size:8.0pt;
	font-weight:400;
	font-style:normal;
	text-decoration:none;
	font-family:돋움, monospace;
	mso-font-charset:129;
	mso-char-type:none;
	display:none;}
-->
</style>

<html>
<head>
<title>Mty Booking Split Container Excel Format</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		loadPage();
	}
</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<table width="500" ccellpadding="10">
<tr>
	<td>
       <table width="100%" border=1>
           <tr bgcolor="#9966CC" style="color:#000033;" align=center>
           		<td><b>SEQ</b></td>
           		<td><b>Sel</b></td>
           		<td><b>CNTR No.</b></td>           		
           </tr>
           <tr>
           		<td></td>
           		<td></td>
           		<td bgcolor="#FFFF00" align=center>mandatory</td>
           </tr>
           <tr>
           		<td></td>
           		<td></td>
           		<td bgcolor="#FFFF00" align=center>mandatory</td>
           </tr>           
       </table>
	</td>
</tr>
</table>
</body>
</html>

