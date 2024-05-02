<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0963.jsp
*@FileTitle : Bundling
*Open Issues :
*Change history :
*@LastModifyDate : 2011-04-11
*@LastModifier : Kim Young Chul
*@LastVersion : 1.0
* 1.0 최초 생성
--------------------------------------------------------
history
* 2011.07.03 김영철 [CHM-201111873] 2011.07.14 김영철 [CHM-201110224] [TRS] Flat rack CNTR Bundling 기능 추가요청 - SO화면에서 Bundling Data를 보여줌.
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>

<%
	String mainSheetArrayNo = request.getParameter("mainSheetArrayNo");
%>
<html>
<head>
<title>Bundling</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage() {
		loadPage();
	}
</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="mainSheetArrayNo" value="<%=mainSheetArrayNo%>">

<!-- OUTER - POPUP (S)tart -->
<table width="800" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">


		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp; Bundling</td></tr>
		</table>
		<!-- : ( Title ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>

		<!-- : ( Search Options ) (S) -->
		<table class="search">
			<tr><td class="bg">

					<!-- : ( Grid ) (S) -->
					<table width="100%" >
						<tr class="h23">
							<td ><input type="checkbox" name="auto_flag" value="" class="trans" checked> Number of CNTR for 1 bundle</td>						
						</tr>
						<tr class="h23">
							<td style="padding-left:13;">
								<input type="radio" width="100" name='bundle_radio' value="2" onClick='' class="trans">2&nbsp;&nbsp;
                                <input type="radio" width="100" name='bundle_radio' value="3" onClick='' class="trans">3&nbsp;&nbsp;
                                <input type="radio" width="100" name='bundle_radio' value="4" onClick='' class="trans" checked >4&nbsp;
                            </td>					
						</tr>
					</table>
					<table style="width:750;" class="line_bluedot"><tr><td></td></tr></table>
					<table style="width:750;" class=" "><tr><td></td></tr></table>
					<table width="100%" >
						<tr class="h23">
							<td><input type="checkbox" name="manaul_flag" value="" class="trans"> Manual Designation</td>
						</tr>
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet1');</script>
                        </td></tr>
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet2');</script>
                        </td></tr>
		            </table>
				<!-- : ( Grid ) (E) -->


				</td>
			</tr>
		</table>
		<!-- : ( Search Options ) (E) -->

</td></tr>
</table>
<!-- OUTER - POPUP (E)nd -->


<table class="height_5"><tr><td></td></tr></table>

<!-- : ( Button : Sub ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>

				<!-- Repeat Pattern -->
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_bundling" id="btn_bundling">Bundling</td><td class="btn1_right"></td></tr></table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_remove_bundling" id="btn_remove_bundling">Remove Bundling</td><td class="btn1_right"></td></tr></table></td>
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