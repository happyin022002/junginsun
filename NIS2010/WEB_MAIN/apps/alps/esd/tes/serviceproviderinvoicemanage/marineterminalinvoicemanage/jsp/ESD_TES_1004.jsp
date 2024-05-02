<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%
   	String tml_so_ofc_cty_cd	= request.getParameter("tml_so_ofc_cty_cd")!=null&&!request.getParameter("tml_so_ofc_cty_cd").equals("")?request.getParameter("tml_so_ofc_cty_cd"):"";
	String tml_so_seq			= request.getParameter("tml_so_seq")!=null&&!request.getParameter("tml_so_seq").equals("")?request.getParameter("tml_so_seq"):"";
	String tml_so_dtl_seq		= request.getParameter("tml_so_dtl_seq")!=null&&!request.getParameter("tml_so_dtl_seq").equals("")?request.getParameter("tml_so_dtl_seq"):"";
	String curr_cd		= request.getParameter("curr_cd")!=null&&!request.getParameter("curr_cd").equals("")?request.getParameter("curr_cd"):"";
	String yd_cd		= request.getParameter("yd_cd")!=null&&!request.getParameter("yd_cd").equals("")?request.getParameter("yd_cd"):"";
%>
<html>
<head>
<title>Welcome to nis2010!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
    function setupPage(){
        loadPage();
    }
</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="tml_so_ofc_cty_cd" value="<%=tml_so_ofc_cty_cd%>">
<input type="hidden" name="tml_so_seq" value="<%=tml_so_seq%>">
<input type="hidden" name="tml_so_dtl_seq" value='<%=tml_so_dtl_seq%>'>
<input type="hidden" name="curr_cd" value='<%=curr_cd%>'>
<input type="hidden" name="yd_cd" value='<%=yd_cd%>'>
<input type="hidden" name="tmp_mgst_no" value=''>
<input type="hidden" name="tmp_mgst_no_result" value=''>
<input type="hidden" name="isExcel" value=''>

<!-- OUTER - POPUP (S)tart -->
<table width="790" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;Fueling Charge Creation</td></tr>
		</table>
		<!-- : ( Title ) (E) -->

		<!-- : ( Search Options ) (S) -->

			<table class="search">
       		<tr><td class="bg">

				<!-- : ( Grid ) (S) -->
                <table width="100%" id="mainTable">
                    <tr><td>
                         <script language="javascript">ComSheetObject('sheet1');</script>
                    </td></tr>
                </table>
				<!-- : ( Grid ) (E) -->
				
				<!-- : ( Button : Grid ) (S) -->
				<!--  Button_Sub (S) -->
				<table width="100%" class="button" border="0">
		       		<tr><td class="btn2_bg">
					<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- Repeat Pattern -->
							<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button"><tr>
									<td class="btn2_left"></td>
									<td class="btn2" name="btng_rowadd" id="btng_rowadd">Row Add</td>
									<td class="btn2_right"></td>
								</tr></table>
							</td>
							<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button"><tr>
									<td class="btn2_left"></td>
									<td class="btn2" name="btng_rowdel" id="btng_rowdel">Delete</td>
									<td class="btn2_right"></td>
								</tr></table>
							</td>
							<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button"><tr>
									<td class="btn2_left"></td>
									<td class="btn2" name="btng_loadexcel" id="btng_loadexcel">Load Excel</td>
									<td class="btn2_right"></td>
								</tr></table>
							</td>
							<!-- Repeat Pattern -->
						</tr>
					</table>
					</td></tr>
				</table>
	    	<!-- Button_Sub (E) -->
		    <!-- : ( Button : Grid ) (E) -->

			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->

</td></tr>
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
				<td width="72">
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_new">New</td><td class="btn1_right"></td></tr>
					</table>
				</td>


				<td width="72">
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_save">Save</td><td class="btn1_right"></td></tr>
					</table>
				</td>
				<td class="btn1_line"></td>

				<td width="72">
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_close">Close</td><td class="btn1_right"></td></tr>
					</table>
				</td>
				<!-- Repeat Pattern -->

				</tr>
			</table>

		</td></tr>
		</table>

</td>
</tr></table>
<!-- : ( Button : pop ) (E) -->

</form>
</body>
</html>
