<%
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName       : ESM_SPC_XLS.jsp
*@FileTitle      : Excel 저장 방법 선택
*Open Issues     :
*Change history  :
*@LastModifyDate : 2007-03-28
*@LastModifier   : 김원섭
*@LastVersion    : 1.0
* 2007-03-28
* 1.0 최초 생성
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>

<html>
<head>
<title>Excel Down</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function initPage(){
		loadPage();
	}
</script>

</head>

<body onLoad="initPage()">
<form name=form>

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0">
	<tr><td class="top"></td></tr>
	<tr><td valign="top">
			<br>
			
			<table class="search">
				<tr><td class="bg">
						<table border="0" style="width:100%; background-color:white;" class="grid2">
							<tr>
								<td class="tr2_head" width="50%">Data</td>
								<td class="tr2_head" width="50%">Format</td>
							</tr>
							<tr align="center">
								<td style="height:35">
									<input type="radio" name="data" id="data0" value="1" style="border:0" checked><label for="data0">All</label>&nbsp;&nbsp;
									<input type="radio" name="data" id="data1" value="2" style="border:0"><label for="data1">Designed</label>
								</td>
								<td>
									<input type="radio" name="format" id="format0" value="1" style="border:0" checked><label for="format0">Yes</label>&nbsp;&nbsp;
									<input type="radio" name="format" id="format1" value="2" style="border:0"><label for="format1">No</label>
								</td>
							</tr>
						</table>
				</td></tr>
			</table>
			
			<br>
	</td></tr>
</table>
<!-- OUTER - POPUP (E)nd -->
<table class="height_5"><tr><td></td></tr></table>

<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
	<tr><td height="71" class="popup">
	
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
				<tr><td class="btn3_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<!-- Repeat Pattern -->
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td><td class="btn1" name="btn_ok" id="btn_ok">OK</td><td class="btn1_right"></td></tr>
								</table></td>
								
								<td class="btn1_line"></td>
								
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr>
								</table></td>
								<!-- Repeat Pattern -->
							</tr>
						</table>
				</td></tr>
			</table>
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
</form>	

</body>
</html>
