<%
	/*=========================================================
	 * Copyright(c) 2006 CyberLogitec
	 * @FileName : ESM_COA_3002.jsp
	 * @FileTitle : Excel Download
	 * Open Issues :
	 * Change history :
	 * @LastModifyDate : 2007-04-13
	 * @LastModifier : Kim Jong Beom
	 * @LastVersion : 1.0
	 *  2007-04-13 Kim Jong Beom
	 *  2009-08-28 임옥영 ALPS UI Name변경
	 =========================================================)*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>Excel Download</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<script>
window.returnValue = "CANCEL";
function keyEnter() {
	if (event.keyCode == 27) { // Esc
		window.returnValue = "CANCEL";
		self.close();
	}
	if (event.keyCode == 13) { // Enter
		processButtonClick();
	}
}

document.onclick = processButtonClick;
function processButtonClick() {
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {

			case "btn_ok":
				var data = "";
				if(formObject.data[0].checked){
					data = "A";
				}
				if(formObject.data[1].checked){
					data = "D";
				}
				var format = "";
				if(formObject.format[0].checked){
					format = "Y";
				}
				if(formObject.format[1].checked){
					format = "N";
				}

				window.returnValue = data+format;
				close();
				break;

			case "btn_close":
				window.returnValue = "CANCEL";
				close();
				break;
		} // end switch
	} catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	}
}
</script>

<body >
<form method="post" name="form" onSubmit="return false;"
	onKeyDown="ComKeyEnter();">

<table width="300" class="popup" cellpadding="10" border="0">
	<tr>
		<td class="top"></td>
	</tr>
	<tr>
		<td valign="top"><!-- : ( Title ) (S) -->
		<table width="100%" border="0">
			<tr>
				<td height="79" class="title"><img
					src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;				Excel Download</td>
			</tr>
		</table>
		<!-- : ( Title ) (E) -->

		<table class="search" border="0">
			<tr>
				<td align="center" class="bg">

				<table width="250" class="search">
					<tr height="25">
						<td width="50"></td>
						<td width="100"><b>Data</b></td>
						<td width="100"><b>Format</b></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="radio" name="data" id="data0" value="1"							style="border: 0"> <label for="data0">All</label></td>
						<td><input type="radio" name="format" id="format0" value="1"							style="border: 0"> <label for="format0">Yes</label></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="radio" name="data" id="data1" value="2"							style="border: 0" checked> <label for="data1">Designed</label>
						</td>
						<td><input type="radio" name="format" id="format1" value="2"							style="border: 0" checked> <label for="format1">No</label>
						</td>
					</tr>
				</table>

				</td>
			</tr>
		</table>

		</td>
	</tr>
</table>

<table class="height_5">
	<tr>
		<td></td>
	</tr>
</table>

<!-- : ( Button : pop ) (S) -->
<table width="300"  class="sbutton">
	<tr>
		<td height="71" class="popup"  align="right">

		<table width="100%" class="button"  cellpadding="0"	 cellspacing="0" style="padding-top: 5; padding-bottom: 10;">
			<tr>
				<td class="btn3_bg">
				<table border="0" cellpadding="0" cellspacing="0"  border="5" >
					<tr>

						<!-- Repeat Pattern -->
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_ok" id="btn_ok">OK</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>

						<td class="btn1_line"></td>

						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_close" id="btn_close">Close</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<!-- Repeat Pattern -->

					</tr>
				</table>

				</td>
			</tr>
		</table>
		</td>
	</tr>
</table>
<!-- : ( Button : pop ) (E) --></form>
</body>
</html>