<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ui_bkg_1061.jsp
*@FileTitle : ACI_Vessel Information
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.24
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2009.04.24 김민정
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>Notice-Files E-mail Attached Grouping option</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form" method="post">
<input type="hidden" name="f_cmd">

<table width="100%" class="popup" cellpadding="10" border="0"> 
	<tr><td class="top"></td></tr>
	<tr>
		<td valign="top">
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">
				Notice-Files E-mail Attached Grouping option Pop-up</td></tr>
			</table>
			<table class="height_10"><tr><td></td></tr></table>
			<table class="search">
				<tr>
					<td class="bg">
						<table class="search" border="0">
							<tr><td class="title_h"></td>
								<td class="title_s">Among B/Ls you selected for E-mailing, Several B/Ls have same E-mail address.</td></tr>
						</table>
						<table class="search" border="0" style="width:100%;">
							<tr class="h23">
								<td width="130" rowspan="2" style="padding:0, 0, 22, 5">&nbsp;You would like to</td>
								<td width="">
									<table class="search_sm2" border="0" style="width:100%;"> 
									<tr>
									<td width=""><input type="radio" class="trans" name="attach_flg" checked value="1">
									send those Files Separately</td></tr>
									<tr><td width=""><input type="radio" class="trans" name="attach_flg" value="0">
									group
									<input type="text" class="input" style="width:30;" value="10" name="attach_max_cnt" 
										dataformat="int" maxlength="2">
									Files per E-Mail then send </td></tr>
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
<table class="height_10"><tr><td></td></tr></table>
<table width="100%" class="sbutton">
	<tr>
		<td height="71" class="popup">
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
				<tr>
					<td class="btn3_bg">
					    <table border="0" cellpadding="0" cellspacing="0">
						    <tr>
						    	<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td>
									<td class="btn1" name="btn_OK">&nbsp;OK&nbsp;&nbsp;</td>
									<td class="btn1_right"></td>
									</tr></table>
								</td>	
								<td class="btn1_line"></td>	
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td>
									<td class="btn1" name="btn_Close">Close</td>
									<td class="btn1_right"></td>
								</tr></table></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>