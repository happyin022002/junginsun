<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ui_bkg_0448_1.jsp
*@FileTitle : Rocs Receive History Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.24
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.04.24 임재택
* 1.0 Creation
=========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>Rocs Receive History Report</title>
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
			<table class="search">
				<tr>
					<td class="bg">
						<table class="height_10"><tr><td></td></tr></table>
						<table class="search" border="0" style="width:980;" height="620"> 
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
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
				<tr>
					<td class="btn3_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td>
										<td class="btn1" name="btn_Close" onClick="self.close()">Close</td>
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