<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_EAS_0911.jsp
*@FileTitle :Office Hierarchy Popup 화면
*Open Issues :
*Change history :
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

	String ofc_cd	 = request.getParameter("ofc_cd"		)!=null&&!request.getParameter("ofc_cd"		).equals("")?request.getParameter("ofc_cd" 		):"";
	String param_nm	 = request.getParameter("param_nm"		)!=null&&!request.getParameter("param_nm"	).equals("")?request.getParameter("param_nm"	):"";
	%><html>
<head>
<title>Welcome to ALPS!</title>
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
<input type="hidden" name="ofc_cd" value="<%=ofc_cd%>">
<input type="hidden" name="param_nm" value="<%=param_nm%>">
<input type="hidden" name="src_ofc" value="">

<!-- OUTER - POPUP (S)tart -->
<table width="400" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="380" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/ico_t1.gif" width="20" height="12">Office Select</td></tr>
		</table>
		<!-- : ( Title ) (E) -->

		<!-- : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg_a">

				<!-- : ( Node / Link ) (S) -->
                    <table width="380" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet');</script>
                        </td></tr>
                    </table>
				<!-- : ( Node / Link ) (E) -->

			</td></tr>
		</table>
		<!-- : ( Search Options ) (E) -->



</td></tr>
</table>
<!-- OUTER - POPUP (E)nd -->




<!-- : ( Button : Sub ) (S) \ -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

		<table class="sbutton">
		<tr>
			<td width="30"><input type="checkbox" value="" class="trans" name="incl_sub"></td>
			<td  width="150">Incl. Sub Office</td>
			<td class="p_bt"><img class="cursor" src="/hanjin/img/button/btn_apply.gif" width="66" height="20" border="0" name="btn_apply"></td>
			<td class="p_bt"><img class="cursor" src="/hanjin/img/button/btn_close.gif" width="66" height="20" border="0" name="btn_close"></td></tr>
		</table>

	</td></tr>
</table>
<!-- : ( Button : Sub ) (E) -->


<div id="hidden_sheet" style="display:none">
<script language="javascript">ComSheetObject('etc_hidden');</script>
</div>
</form>
</body>
</html>