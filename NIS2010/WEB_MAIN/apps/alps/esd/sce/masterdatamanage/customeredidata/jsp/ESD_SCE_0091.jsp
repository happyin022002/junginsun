<%
/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : ESD_SCE_0091.jsp
*@FileTitle : Row Limited
*Open Issues :
*Change history :
*@LastModifyDate : 2008-09-02
*@LastModifier : Sang-hyun Kim
*@LastVersion : 1.0
* 2008-09-02 Sang-hyun Kim
* 1.0 최초 생성
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<html>
<head>
<title>Microsoft Internet Explorer</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<body>
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">

<!-- OUTER - POPUP (S)tart -->
<table width="600" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
<tr><td valign="top">

			<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
				<table width="100%" border="0">
				<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;Over 100 rows</td></tr>
				</table>
			<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->

					<table class="search" border="0">
						<tr>
							<td class="bg">
								<table class="height_10"><tr><td></td></tr></table>

			                    <table width="100%" id="mainTable">
			                        <tr>
			                        	<td>
			                             	Over 100 rows. Please define the rows you select. From
			                             	&nbsp;<input name="from_row"  type="text" class="input" style="width:70" onKeyUp='isNum(this);' value="" >
			                             	To
			                             	&nbsp;<input name="end_row"  type="text" class="input" style="width:70" onKeyUp='isNum(this);'  value="" >
			                        	</td>
			                        </tr>
			                    </table>
							<!-- : ( Speed ) (E) -->

						</td></tr>
					</table>

		</td>
	</tr>
</table>
<!-- : ( Button : Sub ) (S) -->
<table width="100%" class="sbutton">
		<tr><td height="71" class="popup">

			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
	       		<tr><td class="btn3_bg">
			    <table border="0" cellpadding="0" cellspacing="0">
			    <tr>

					<!-- Repeat Pattern -->
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_ok" id="btn_ok">Ok</td><td class="btn1_right"></td></tr></table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>
					<!-- Repeat Pattern -->

				</tr>
			</table>

		</td></tr>
</table>
<!-- : ( Button : Sub ) (E) -->

</body>

</html>