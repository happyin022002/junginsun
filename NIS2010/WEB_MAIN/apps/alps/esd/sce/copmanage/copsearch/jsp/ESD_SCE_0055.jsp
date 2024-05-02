<%
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0055.jsp
*@FileTitle : VVD Update change popup
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-29
*@LastModifier : Yong cheon shin
*@LastVersion : 1.0
* 2006-08-29 Seong-mun Kang
* 1.0 최초 생성
=========================================================*/
%>
<html>
<head>
<title>Supply Chain Event Management</title>
</head>
<%@ page contentType="text/html; charset=UTF-8"%>

<body>
<form name="form">

<!-- OUTER - POPUP (S)tart -->
<table width="400" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="500" border="0">
		<tr><td class="title"><img src="/hanjin/img/ico_t1.gif" width="20" height="12">COP Auto Change - Termonal Change</td></tr>
		</table>
		<!-- : ( Title ) (E) -->




		<!-- TABLE '#D' : ( Search Options : Speed ) (S) -->
     	<table class="search">
       	<tr><td class="bg_a">


				<table class="search" border="0" style="width:500;">
						<tr class="h23">
							<td width="6%">VVD</td>
							<td width="28%">
								&nbsp;<input name="vvd" type="text" class="input" style="width:100; text-transform:uppercase;"  value="">
								&nbsp;<img  onClick="openVVDPop(false,'vvd')" class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
							<td width="11%">&nbsp;Call Port</td>
							<td width="6%">
								<select name="call_port">
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
								</select>
							</td>
							<td width="29%">&nbsp;&nbsp;Terminal To Be Changed</td>
							<td>
							&nbsp;<input name="nod" type="text" class="input" style="width:70; text-transform:uppercase;"  value="">
							&nbsp;<img onClick="openNodePop(false,'nod')"class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
							</td>

						</tr>

					</table>



			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options : Speed ) (E) -->




</td></tr>
</table>
<!-- OUTER - POPUP (E)nd -->



<table class="height_10"><tr><td></td></tr></table>


<!-- : ( Button : Sub ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

		<table class="sbutton">
		<tr><td class="p_bt"><img class="cursor" src="/hanjin/img/button/btn_ok.gif" width="66" height="20" border="0" name="btn_ok"></td>
		<td class="p_bt"><img class="cursor" src="/hanjin/img/button/btn_close.gif" width="66" height="20" border="0" name="btn_close"></td></tr>
		</table>

	</td></tr>
</table>
<!-- : ( Button : Sub ) (E) -->
</form>

</body>
</html>
