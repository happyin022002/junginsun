<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0884.jsp
*@FileTitle : Discharging Cargo Declaration
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.24
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.04.24 박상훈
* 1.0 Creation
=========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<html>
<head>
<title>PSA Import Status I/F Print</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>
<script language="javascript">
	function setupPage(){
		loadPage();
	}
</script>
</head>
<body class="popup_bg" onload="setupPage();">
<table width="100%" class="popup" cellpadding="10" border="0">
	<tr>
		<td class="top"></td>
	</tr>
	<tr>
		<td valign="top">
			<table width="100%" border="0">
				<tr>
					<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="notitle">&nbsp; PSA Import Status I/F Print</span></td>
				</tr>
			</table>
			<table class="search">
				<tr>
					<td class="bg">
						<table class="height_10"><tr><td></td></tr></table>
						<table class="search" border="0" style="width:980;" height="560"> 
							<tr><td><script language='javascript'>comRdObject('csrPrevie');</script></td></tr>
						</table>
					</td>
				</tr>
			</table>
<table class="height_5"><tr><td></td></tr></table>
		</td>
	</tr>
</table>
<table width="100%" class="sbutton">
	<tr>
		<td height="71" class="popup">
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
				<tr>
					<td class="btn3_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
						    	<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Print">Print</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td class="btn1_line"></td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
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
		</td>
	</tr>
</table>
</body>
</html>