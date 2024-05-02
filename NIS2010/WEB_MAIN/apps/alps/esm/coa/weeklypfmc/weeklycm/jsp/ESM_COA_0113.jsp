<%
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_COA_0113.jsp
*@FileTitle : Select Creation Type
*Open Issues :
*Change history : 2006.11.06 박은주 최초 생성
                : 2009.09.11 박수훈 New FrameWork 적용
*@LastModifyDate : 2009.09.11
*@LastModifier : 박수훈
*@LastVersion : 1.0
*=========================================================
* History
* 2011.04.18 이행지 [CHM-201110235-01] Radio버튼명 변경 ( Weekly -> VVD )
*=========================================================*/
%>
<html>
<head>
<title>Select Creation Type</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>


<script>
function Exit() {
	//ComShowMessage(self.screenTop);
    //if (self.screenTop > 9000) {
    	//opener.location.reload();
    	//ComShowMessage(dialogArguments.document.location);
    	var frm = document.form;

    	for(i=0; i<frm.length; i++){
    		//if(frm.rdoType[i].checked) dialogArguments.callCreation(frm.rdoType[i].value);
    		if(frm.rdoType[i].checked) window.returnValue = frm.rdoType[i].value;

    	}
    	//self.close();
    	//opener.location.href=opener.document.location;
    //}
}
</script>
<script language="javascript" event="onunload" for="window">
    Exit();
</script>
<script language="javascript">

	function setupPage(){
		//loadPage();
	}

</script>

<body onLoad="setupPage();">
<form name="form" onKeyDown="ComKeyEnter();">

<!-- OUTER - POPUP (S)tart -->
<table width="300" class="popup" cellpadding="10" border="0">
	<tr><td class="top"></td></tr>
	<tr>
		<td valign="top">


		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp; Select Creation Type</td></tr>
		</table>
		<!-- : ( Title ) (E) -->



			<!-- : ( Search Options ) (S) -->
			<table class="search">
				<tr>
					<td class="bg">

						<!-- : ( Grid ) (S) -->
						<table class="search" align="center" style="width:150;">
							<tr class="h23">
								<td width="80"><input type="radio" name="rdoType" value="BSA" class="trans" checked> VVD</td>
								<td><input type="radio" name="rdoType" value="COA" class="trans"> Weekly</td>
							</tr>
						</table>
						<!-- : ( Grid ) (E) -->

					</td>
				</tr>
			</table>
			<!-- : ( Search Options ) (E) -->


		</td>
	</tr>
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
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_Close" id="btn_Close">Close</td><td class="btn1_right"></td></tr></table></td>
				<!-- Repeat Pattern -->

			</tr>
		</table>

	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->


</form>
</body>
</html>