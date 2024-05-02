<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%
	String inv_no		= request.getParameter("inv_no")!=null&&!request.getParameter("inv_no").equals("")?request.getParameter("inv_no"):"";
	String inv_vndr_seq	= request.getParameter("inv_vndr_seq")!=null&&!request.getParameter("inv_vndr_seq").equals("")?request.getParameter("inv_vndr_seq"):"";

%>
<html>
<head>
<title>Welcome to ALPS!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	var inv_no = '<%=inv_no%>'
	var inv_vndr_seq = '<%=inv_vndr_seq%>'

    function setupPage(){
		loadPage();
	}
</script>
</head>

<body onload="javascript:setupPage();">

<form name="form">
<input name='f_cmd' type='hidden'>
<input type="hidden" name="FORM_INV_NO" value="<%=inv_no%>">
<input type="hidden" name="FORM_INV_VNDR_SEQ" value="<%=inv_vndr_seq%>">
<input type="hidden" name="real_file_name" value="">
<input type="hidden" name="saved_file_name" value="">
<input type="hidden" name="saved_path" value="">

<!-- OUTER - POPUP (S)tart -->
<table width="400" class="popup" cellpadding="10">
	<tr><td class="top"></td></tr>
	<tr>
		<td valign="top">
			<table width="100%" border="0">
			<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;EDI Invoice View</td></tr>
			</table>
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
				<tr>
					<td class="btn1_bg">
				    	<div id="EDILayer01" style="display:none">
							<table border="0" cellpadding="0" cellspacing="0">
								<tr>
									<!-- Repeat Pattern -->
									<td>
										<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr>
												<td class="btn1_left">
												</td><td class="btn1" name="btn_fileselect" id="btn_fileselect">New</td>
												<td class="btn1_right"></td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
						</div>
					</td>
				</tr>
			</table>
		    <table class="search">
		    	<tr>
		    		<td class="bg">
						<table border="0" style="width:362;" class="search">
							<tr>
								<td class="align" style="width:300;height:200;text-align:center;">
									<iframe name="ifr_pdf_view_main" src="" width="1000" height="800" scrolling="no" marginwidth="0" marginheight="0" frameborder="0"></iframe>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<table class="height_10"><tr><td></td></tr></table>
<table width="100%" class="sbutton">
	<tr>
		<td height="71" class="popup">
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
	       		<tr>
	       			<td class="btn3_bg">
					    <table border="0" cellpadding="0" cellspacing="0">
						    <tr>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_close" id="btn_close">Close</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</form>
</body>
</html>

<div style="display:none">
	<table width="100%" id="mainTable">
		<script language="javascript">ComSheetObject('sheet');</script>
	</table>
</div>
