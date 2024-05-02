<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_904.jsp
*@FileTitle : Total Amount PopUp 화면 - Marine Terminal
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-16
*@LastModifier : parkyeonjin
*@LastVersion : 1.0
* 2006-11-16 parkyeonjin
* 1.0 최초 생성
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%
	String param_name = null;
	java.util.Enumeration enums = request.getParameterNames();
	while (enums.hasMoreElements()){
		param_name = (String)enums.nextElement();
	}

	String tml_inv_tp_cd		 = request.getParameter("tml_inv_tp_cd"			)!=null&&!request.getParameter("tml_inv_tp_cd"		).equals("")?request.getParameter("tml_inv_tp_cd" 		):"";

%>
<html>
<head>
<title>Total Amount PopUp 화면 - Marine Terminal </title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		loadPage();
	}
</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="tml_inv_tp_cd"	 		 value="<%=tml_inv_tp_cd%>">

<!-- OUTER - POPUP (S)tart -->
<table width="500" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;Total Amount</td></tr>
		</table>
		<!-- : ( Title ) (E) -->


		<!-- TABLE '#D' : ( Search Options : Speed ) (S) -->
	     	<table class="search">
	       	<tr><td class="bg">

				<!-- : ( Speed ) (S) -->
		                    <table width="100%" id="mainTable">
		                        <tr><td>
		                             <script language="javascript">ComSheetObject('sheet');</script>
		                        </td></tr>
		                    </table>
				<!-- : ( Speed ) (E) -->

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
