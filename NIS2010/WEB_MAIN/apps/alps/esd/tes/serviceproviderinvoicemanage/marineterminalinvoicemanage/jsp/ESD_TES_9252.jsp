<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_9252.jsp
*@FileTitle : TES 3rd Party Billing Input Popup화면-Marine Terminal Invoice
*Open Issues :
*Change history :
*@LastModifyDate : 2007-03-01
*@LastModifier : kimjinjoo
*@LastVersion : 1.0
* 2007-03-01 kimjinjoo
* 1.0 최초 생성
=========================================================*/
--%>


<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%
	String tml_so_ofc_cty_cd = request.getParameter("tml_so_ofc_cty_cd"	)!=null&&!request.getParameter("tml_so_ofc_cty_cd"	).equals("")?request.getParameter("tml_so_ofc_cty_cd" 	):"";
	String tml_so_seq		 = request.getParameter("tml_so_seq"		)!=null&&!request.getParameter("tml_so_seq"			).equals("")?request.getParameter("tml_so_seq"			):"";
	String tml_so_dtl_seq 	 = request.getParameter("tml_so_dtl_seq"	)!=null&&!request.getParameter("tml_so_dtl_seq"		).equals("")?request.getParameter("tml_so_dtl_seq" 		):"";
	String inv_no		  	 = request.getParameter("inv_no"		 	)!=null&&!request.getParameter("inv_no"				).equals("")?request.getParameter("inv_no"				):"";
	String curr_cd		  	 = request.getParameter("curr_cd"		 	)!=null&&!request.getParameter("curr_cd"			).equals("")?request.getParameter("curr_cd"				):"";
%>
<html>
<head>
<title>TES 3rd Party Billing Input Popup화면-Marine Terminal Invoice </title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
<%= JSPUtil.getIBCodeCombo("combo01", "01", "CD00583", 0, "")%>
	function setupPage(){
		loadPage();
	}
</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="tml_so_ofc_cty_cd"	 	 value="<%=tml_so_ofc_cty_cd%>">
<input type="hidden" name="tml_so_seq"				 value="<%=tml_so_seq		%>">
<input type="hidden" name="tml_so_dtl_seq"		 	 value="<%=tml_so_dtl_seq	%>">
<input type="hidden" name="inv_no"					 value="<%=inv_no			%>">
<input type="hidden" name="curr_cd"					 value="<%=curr_cd			%>">


<!-- OUTER - POPUP (S)tart -->
<table width="800" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;3rd Party Interface</td></tr>
		</table>
		<!-- : ( Title ) (E) -->

		<!-- : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<!-- : ( Year ) (S) -->
				<table class="search" border="0">
				<tr class="h23">
					<td width="10%">Source No.</td>
					<td><input type="text" readOnly style="width:80" value="<%=inv_no%>"></td></tr>
				</table>
				<!-- : ( Year ) (E) -->

			</td></tr>
		</table>
		<!-- : ( Search Options ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>

		<!-- : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<!-- : ( Grid ) (S) -->
                <table width="100%" id="mainTable">
                    <tr><td>
                         <script language="javascript">ComSheetObject('sheet');</script>
                    </td></tr>
                </table>
				<!-- : ( Grid ) (E) -->



				<!-- : ( Button : Sub ) (S) -->
				<table class="button" border="0" width="100%">
					<tr><td class="btn2_bg" class="align">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<!-- Repeat Pattern -->
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btn_close" id="btn_close">Close</td>
								<td class="btn2_right"></td></tr></table>
								</td>
								<!-- Repeat Pattern -->
							</tr>
						</table>
					</td></tr>
				</table>
		    	<!-- : ( Button : Sub ) (E) -->


			</td></tr>
		</table>
		<!-- : ( Search Options ) (E) -->




</td></tr>
</table>
<!-- OUTER - POPUP (E)nd -->



<table class="height_10"><tr><td></td></tr></table>


<!-- : ( Button : Sub ) (S) -->
<!--<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

		<table class="sbutton">
		<tr><td class="p_bt"><img class="cursor" src="/hanjin/img/button/btn_ok.gif" width="66" height="20" border="0" name="btn_ok"></td>
        	<td class="p_bt"><img class="cursor" src="/hanjin/img/button/btn_close.gif" width="66" height="20" border="0" name="btn_close"></td></tr>
		</table>

	</td></tr>
</table>
--><!-- : ( Button : Sub ) (E) -->

</form>
</body>
</html>

