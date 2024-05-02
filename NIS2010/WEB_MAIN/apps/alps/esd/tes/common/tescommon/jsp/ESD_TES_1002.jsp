<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%
	String tml_so_ofc_cty_cd	= request.getParameter("tml_so_ofc_cty_cd")!=null&&!request.getParameter("tml_so_ofc_cty_cd").equals("")?request.getParameter("tml_so_ofc_cty_cd"):"";
	String tml_so_seq			= request.getParameter("tml_so_seq")!=null&&!request.getParameter("tml_so_seq").equals("")?request.getParameter("tml_so_seq"):"";
	String vndr_seq				= request.getParameter("vndr_seq")!=null&&!request.getParameter("vndr_seq").equals("")?request.getParameter("vndr_seq"):"";
	String inv_no				= request.getParameter("inv_no")!=null&&!request.getParameter("inv_no").equals("")?request.getParameter("inv_no"):"";
%>
<html>
<head>
<title>Welcome to ALPS!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	var tml_so_ofc_cty_cd = '<%=tml_so_ofc_cty_cd%>';
	var tml_so_seq = '<%=tml_so_seq%>';
	var vndr_seq = '<%=vndr_seq%>';
	var inv_no = '<%=inv_no%>';
	function setupPage(){
		loadPage();
	}
</script>
</head>
<body onload="javascript:setupPage();">

<form name="form">
<input name='f_cmd' type='hidden'>
<input name='Id' type='hidden' value='fileUpload'>
<input type="hidden" name="tml_so_ofc_cty_cd" value="<%=tml_so_ofc_cty_cd%>">
<input type="hidden" name="tml_so_seq" value="<%=tml_so_seq%>">
<input type="hidden" name="real_file_name" value="">
<input type="hidden" name="saved_file_name" value="">
<input type="hidden" name="saved_path" value="">

<!-- OUTER - POPUP (S)tart -->
<table width="400" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;EDI Invoice View</td></tr>
		</table>
		<!-- : ( Title ) (E) -->



		<!-- TABLE '#D' : ( Search Options : Speed ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<!-- : ( Speed ) (S) -->
				<table border="0" style="width:362;" class="search">
				<tr>
					<td class="align" style="width:300;height:200;text-align:center;">
						<iframe name="ifr_pdf_view_main" src="" width="1000" height="800" scrolling="no" marginwidth="0" marginheight="0" frameborder="0"></iframe>
					</td>
				</tr>
				</table>
				<!-- : ( Speed ) (E) -->

			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options : Speed ) (E) -->

</td></tr>
</table>
<!-- OUTER - POPUP (E)nd -->

<table class="height_10"><tr><td></td></tr></table>

<table width="100%" class="sbutton">
		<tr><td height="71" class="popup">

			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
	       		<tr><td class="btn3_bg">
			    <table border="0" cellpadding="0" cellspacing="0">
			    <tr>

					<!-- Repeat Pattern -->
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="bt_pre" id="bt_pre">Pre</td><td class="btn1_right"></td></tr></table></td>
					<td width="50"></td>
					<td width="200" id=curr_inv align="center"></td>
					<td width="50"></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="bt_next" id="bt_next">Next</td><td class="btn1_right"></td></tr></table></td>
					<!-- Repeat Pattern -->

				</tr>
			</table>

		</td></tr>
</table>


<!-- : ( Button : Sub ) (S) -->
<!--table width="100%" class="sbutton">
<tr><td height="71" class="popup">

		<table class="sbutton">
		<tr><td class="p_bt"><img class="cursor" src="/hanjin/img/button/btn_close.gif" width="66" height="20" border="0" name='btn_close'></td></tr>
		</table>

	</td></tr>
</table-->
<!-- : ( Button : Sub ) (E) -->

<div style="display:none">
<table width="100%" id="mainTable">
	<script language="javascript">ComSheetObject('sheet1');</script>
</table>
</div>


</form>


</body>
</html>


