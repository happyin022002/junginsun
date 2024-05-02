<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : COM_RD_COMMON_POPUP.jsp
	 *@FileTitle : COM_RD_COMMON_POPUP
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2009.08.14
	 *@LastModifier : 김정훈
	 *@LastVersion : 1.0
	 * 2009.08.14 김정훈
	 * 1.0 Creation
	 =========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/hanjin/css/alps_contents.css" rel="stylesheet" type="text/css">
<script language="javascript">
	function setupPage(){
		setModalValues();
		rdOpen();
	}
</script>
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>
<script language="javascript" src="/hanjin/syscommon/common/reportdesigner/commonpopup/script/COM_RD_COMMON_POPUP_MODAL.js"></script>
</head>

<body class="popup_bg" onload="javascript:setupPage();">
<form name="form">
<input type="hidden" id="f_cmd"> 
<input type="hidden" id="pagerows">
<input type="hidden" id="com_mrdSaveDialogDir">
<input type="hidden" id="com_mrdSaveDialogFileName" >
<input type="hidden" id="com_mrdSaveDialogFileExt">
<input type="hidden" id="com_mrdSaveDialogFileExtLimit">
<input type="hidden" id="com_mrdDisableToolbar">
<input type="hidden" id="com_zoomIn">
<input type="hidden" id="com_isBatch">
<input type="hidden" id="com_mrdPath">
<input type="hidden" id="com_mrdArguments">
<input type="hidden" id="com_mrdPrintPaperSize">
<!-- OUTER - POPUP (S)tart -->
<table class="popup" cellpadding="10" width="100%" height="600"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;<span style=&quot;color:red&quot; id="com_mrdBodyTitle"></span></td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		<table id="rdTable" width="100%" height="94%">
			<tr>
				<td height="100%" ><script language="javascript">
					comRdObjectPopup("Rdviewer");
				</script></td>
			</tr>
		</table>
		
		<!-- TABLE '#D' : ( Search Options : Scenario ID ) (S) -->

<table class="height_5"><tr><td></td></tr></table> 

<!-- OUTER - POPUP (E)nd -->
</td></tr>
</table> 

	
	
<!-- : ( Button : Sub ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_Close" onclick="self.close()">Close</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
				</tr>
				</table>
			</td>
			</tr>
		</table>

	</td></tr>
</table>
<!-- : ( Button : Sub ) (E) -->
</form>
</body>
</html>