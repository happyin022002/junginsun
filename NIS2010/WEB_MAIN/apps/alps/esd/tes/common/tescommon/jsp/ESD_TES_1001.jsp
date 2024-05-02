<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%
	String tml_so_ofc_cty_cd	= request.getParameter("tml_so_ofc_cty_cd")!=null&&!request.getParameter("tml_so_ofc_cty_cd").equals("")?request.getParameter("tml_so_ofc_cty_cd"):"";
	String tml_so_seq			= request.getParameter("tml_so_seq")!=null&&!request.getParameter("tml_so_seq").equals("")?request.getParameter("tml_so_seq"):"";
	String fm_cre_mode			= request.getParameter("fm_cre_mode")!=null&&!request.getParameter("fm_cre_mode").equals("")?request.getParameter("fm_cre_mode"):"";
	String tml_edi_so_ofc_cty_cd	= request.getParameter("tml_edi_so_ofc_cty_cd")!=null&&!request.getParameter("tml_edi_so_ofc_cty_cd").equals("")?request.getParameter("tml_edi_so_ofc_cty_cd"):"";
	String tml_edi_so_seq			= request.getParameter("tml_edi_so_seq")!=null&&!request.getParameter("tml_edi_so_seq").equals("")?request.getParameter("tml_edi_so_seq"):"";

%>
<html>
<head>
<title>Welcome to ALPS!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	var tml_so_ofc_cty_cd = '<%=tml_so_ofc_cty_cd%>'
	var tml_so_seq = '<%=tml_so_seq%>'
	var fm_cre_mode = '<%=fm_cre_mode%>'
	var tml_edi_so_ofc_cty_cd = '<%=tml_edi_so_ofc_cty_cd%>'
	var tml_edi_so_seq = '<%=tml_edi_so_seq%>'

    function setupPage(){
		loadPage();
	}
</script>
</head>

<body onload="javascript:setupPage();">

<form name="form">
<input name='f_cmd' type='hidden'>
<input type="hidden" name="tml_so_ofc_cty_cd" value="<%=tml_so_ofc_cty_cd%>">
<input type="hidden" name="tml_so_seq" value="<%=tml_so_seq%>">
<input type="hidden" name="tml_edi_so_ofc_cty_cd" value="<%=tml_edi_so_ofc_cty_cd%>">
<input type="hidden" name="tml_edi_so_seq" value="<%=tml_edi_so_seq%>">
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

		<!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
				<tr><td class="btn1_bg">
		    
		    			<div id="EDILayer01" style="display:none">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_fileselect" id="btn_fileselect">New</td><td class="btn1_right"></td></tr></table></td>
							<!-- Repeat Pattern -->
						</tr></table>
						</div>

				</td></tr>
				</table>
		<!-- TABLE '#D' : ( Button : Main ) (E) -->

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

<div style="display:none">
<table width="100%" id="mainTable">
	<script language="javascript">ComSheetObject('sheet');</script>
</table>
</div>
