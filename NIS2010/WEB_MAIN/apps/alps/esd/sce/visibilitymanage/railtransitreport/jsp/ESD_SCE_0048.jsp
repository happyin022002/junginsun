<%
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0048.jsp
*@FileTitle : Multi Input
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-28
*@LastModifier : Seong-mun Kang
*@LastVersion : 1.0
* 2006-11-28 Seong-mun Kang
* 1.0 최초생성
=========================================================*/
%>

<html>
<head>
<title>Welcome to enis!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">

    function setupPage(){
	    loadPage();

       /*****************************************************************/
    }

</script>

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="type">

<!-- OUTER - POPUP (S)tart -->
<table width="712" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
			<table width="100%" border="0">
				<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;Multi Input</td></tr>
			</table>
		<!-- : ( Title ) (E) -->


		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Tab ) (S) Customer / Service Provider / Hanjin Internal-->
		<table class="tab">
		<tr><td><script language="javascript">ComTabObject('tab1')</script></td></tr>
		</table>
		<!-- TABLE '#D' : ( Tab ) (E) -->
		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
		<table class="search" border="0">
		<tr><td class="bg">
			<!-- TABLE '#D' : ( Button : Sub ) (E) -->
			<table class="height_5"><tr><td></td></tr></table>
				<!-- : ( Speed ) (S) -->
				<table width="100%" id="mainTable">
                        <tr><td>
                        	<div id="tabLayer" style="display:inline">
                             <script language="javascript">ComSheetObject('t1sheet1');</script>
                            </div>
                            <div id="tabLayer" style="display:none">
                            	<script language="javascript">ComSheetObject('t2sheet1');</script>
							</div>
							<div id="tabLayer" style="display:none">
								<script language="javascript">ComSheetObject('t3sheet1');</script>
							</div>
							<div id="tabLayer" style="display:none">
								<script language="javascript">ComSheetObject('t4sheet1');</script>
							</div>

							<div id="tabLayer" style="display:none"> <!-- POL / POD -->
								<script language="javascript">ComSheetObject('t5sheet1');</script>
							</div>

							<div id="tabLayer" style="display:none"> <!-- Origin -->
								<script language="javascript">ComSheetObject('t6sheet1');</script>
							</div>

							<div id="tabLayer" style="display:none"> <!-- Dest -->
								<script language="javascript">ComSheetObject('t7sheet1');</script>
							</div>

							<div id="tabLayer" style="display:none"> <!-- S/C No -->
								<script language="javascript">ComSheetObject('t8sheet1');</script>
							</div>

							<div id="tabLayer" style="display:none"> <!--  CUST Code -->
								<script language="javascript">ComSheetObject('t9sheet1');</script>
							</div>

                        </td></tr>
		            </table>
				<!-- : ( Speed ) (E) -->
				<!-- : ( Button : Sub ) (S) -->
				<table width="100%" class="button">
						<tr><td class="btn2_bg">
							<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<!-- Repeat Pattern -->
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btn_new" id="btn_new">New</td>
								<td class="btn2_right"></td></tr></table></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btng_rowadd" id="btng_rowadd">Row Add</td>
								<td class="btn2_right"></td></tr></table></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btng_fileimport" id="btng_fileimport">File Import</td>
								<td class="btn2_right"></td></tr></table></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btn_verify" id="btn_verify">Verify</td>
								<td class="btn2_right"></td></tr></table></td>
								<!-- Repeat Pattern -->
							</tr></table>
						</td></tr>
					</table>
			<!-- : ( Button : Sub ) (E) -->
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
</form>
</body>
</html>