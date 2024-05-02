<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_SPC_9010DL.jsp
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014-09-12
*@LastModifier : PARK CHAE HEUNG
*@LastVersion : 1.0
* 2014-09-12 
* 1.0 최초 생성
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<% 
response.setContentType("application/x-msdownload");
response.setHeader("Content-Disposition", "attachment;filename=sample_down.xls;");
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
<title>On-dock Rail Charge Invoice 등록 및 Confirm화면-Coincidence</title>
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
           <tr bgcolor="#B2CCFF" style="color:#000033;" align=center>
           		<td><b>Seq</b></td>
           		<td><b>Trade</b></td>
           		<td><b>Sub Trade</b></td>
           		<td><b>Lane</b></td>
           		<td><b>VVD</b></td>
           		
           		<td><b>OCN/IPC/TS</b></td>
           		<td><b>Sales Rep</b></td>
           		<td><b>CUST_CNT</b></td>
           		<td><b>CUST_SEQ</b></td>
           		<td><b>Pol</b></td>
           		<td><b>Pod</b></td>
           		<td><b>Office</b></td>
           		<td><b>Cust Type</b></td>
           		<td><b>Fcast TEU</b></td>
           		<td><b>40</b></td>
           		<td><b>45</b></td>
           		<td><b>RF</b></td>
           		<td><b>Fcast WT</b></td>
           		<td><b>Remark</b></td>
           </tr>
           <tr>
           		<td></td>
           		<td></td>
           		<td></td>
           		<td></td>
           		<td></td>
           		
           		<td></td>
           		<td></td>
           		<td></td>
           		<td></td>
           		<td></td>
           		<td></td>
           		<td></td>
           		<td></td>
           		<td></td>
           		<td></td> 
           		<td></td>
           		<td></td>
           		<td></td>
           		<td></td>
           </tr>
           <tr>
           		<td></td>
           		<td></td>
           		<td></td>
           		<td></td>
           		<td></td>
           		
           		<td></td>
           		<td></td>
           		<td></td>
           		<td></td>
           		<td></td>
           		<td></td>
           		<td></td>
           		<td></td>
           		<td></td>
           		<td></td> 
           		<td></td>
           		<td></td>
           		<td></td>
           		<td></td>           		
           </tr>           
       </table>
	</td>
</tr>
</table>
</body>
</html>

