<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.bizcommon.util.BizComUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%
	String param_name = null;
	java.util.Enumeration enums = request.getParameterNames();
	while (enums.hasMoreElements()){
		param_name = (String)enums.nextElement();
	}

   	String tml_so_ofc_cty_cd	= request.getParameter("tml_so_ofc_cty_cd")!=null&&!request.getParameter("tml_so_ofc_cty_cd").equals("")?request.getParameter("tml_so_ofc_cty_cd"):"";
	String tml_so_seq			= request.getParameter("tml_so_seq")!=null&&!request.getParameter("tml_so_seq").equals("")?request.getParameter("tml_so_seq"):"";
	String yd_cd			= request.getParameter("yd_cd")!=null&&!request.getParameter("yd_cd").equals("")?request.getParameter("yd_cd"):"";
	String bound_lgs_cost_cd	= request.getParameter("bound_lgs_cost_cd")!=null&&!request.getParameter("bound_lgs_cost_cd").equals("")?request.getParameter("bound_lgs_cost_cd"):"";
	String vvd_vsl_cd			= request.getParameter("vvd_vsl_cd")!=null&&!request.getParameter("vvd_vsl_cd").equals("")?request.getParameter("vvd_vsl_cd"):"";
	String vvd_skd_voy_no		= request.getParameter("vvd_skd_voy_no")!=null&&!request.getParameter("vvd_skd_voy_no").equals("")?request.getParameter("vvd_skd_voy_no"):"";
	String vvd_skd_dir_cd		= request.getParameter("vvd_skd_dir_cd")!=null&&!request.getParameter("vvd_skd_dir_cd").equals("")?request.getParameter("vvd_skd_dir_cd"):"";
	String vvd			= request.getParameter("vvd")!=null&&!request.getParameter("vvd").equals("")?request.getParameter("vvd"):"";
	String vvd_atb_dt			= request.getParameter("vvd_atb_dt")!=null&&!request.getParameter("vvd_atb_dt").equals("")?request.getParameter("vvd_atb_dt"):"";
	String vvd_io_bnd_cd			= request.getParameter("vvd_io_bnd_cd")!=null&&!request.getParameter("vvd_io_bnd_cd").equals("")?request.getParameter("vvd_io_bnd_cd"):"";
	String vvd_vsl_cd2			= request.getParameter("vvd_vsl_cd2")!=null&&!request.getParameter("vvd_vsl_cd2").equals("")?request.getParameter("vvd_vsl_cd2"):"";
	String vvd_skd_voy_no2		= request.getParameter("vvd_skd_voy_no2")!=null&&!request.getParameter("vvd_skd_voy_no2").equals("")?request.getParameter("vvd_skd_voy_no2"):"";
	String vvd_skd_dir_cd2		= request.getParameter("vvd_skd_dir_cd2")!=null&&!request.getParameter("vvd_skd_dir_cd2").equals("")?request.getParameter("vvd_skd_dir_cd2"):"";
	String vvd2			= request.getParameter("vvd2")!=null&&!request.getParameter("vvd2").equals("")?request.getParameter("vvd2"):"";
	String vvd_atb_dt2			= request.getParameter("vvd_atb_dt2")!=null&&!request.getParameter("vvd_atb_dt2").equals("")?request.getParameter("vvd_atb_dt2"):"";
	String vvd_io_bnd_cd2			= request.getParameter("io_bnd_cd2")!=null&&!request.getParameter("io_bnd_cd2").equals("")?request.getParameter("io_bnd_cd2"):"";
%>
<html>
<head>
<title>Welcome to ALPS!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
    function setupPage(){
        loadPage();
    }
</script>
</head>

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<!-- 
<input type="hidden" name="pm_tml_so_ofc_cty_cd" value="<%=tml_so_ofc_cty_cd%>">
<input type="hidden" name="pm_tml_so_seq" value="<%=tml_so_seq%>">
<input type="hidden" name="pm_yd_cd" value="<%=yd_cd%>">
<input type="hidden" name="bound_lgs_cost_cd" value="<%=bound_lgs_cost_cd%>">
<input type="hidden" name="pm_vvd_vsl_cd" value="<%=vvd_vsl_cd%>">
<input type="hidden" name="pm_vvd_skd_voy_no" value="<%=vvd_skd_voy_no%>">
<input type="hidden" name="pm_vvd_skd_dir_cd" value="<%=vvd_skd_dir_cd%>">
<input type="hidden" name="pm_vvd" value="<%=vvd%>">
<input type="hidden" name="pm_atb_dt" value="<%=vvd_atb_dt%>">
<input type="hidden" name="pm_io_bnd_cd" value="<%=vvd_io_bnd_cd%>">
<input type="hidden" name="pm_vvd_vsl_cd2" value="<%=vvd_vsl_cd2%>">
<input type="hidden" name="pm_vvd_skd_voy_no2" value="<%=vvd_skd_voy_no2%>">
<input type="hidden" name="pm_vvd_skd_dir_cd2" value="<%=vvd_skd_dir_cd2%>">
<input type="hidden" name="pm_vvd2" value="<%=vvd2%>">
<input type="hidden" name="pm_atb_dt2" value="<%=vvd_atb_dt2%>">
<input type="hidden" name="pm_io_bnd_cd2" value="<%=vvd_io_bnd_cd2%>">
 -->

<input type="hidden" name="tml_so_ofc_cty_cd" value="<%=tml_so_ofc_cty_cd%>">
<input type="hidden" name="tml_so_seq" value="<%=tml_so_seq%>">
<input type="hidden" name="yd_cd" value="<%=yd_cd%>">
<input type="hidden" name="bound_lgs_cost_cd" value="<%=bound_lgs_cost_cd%>">
<input type="hidden" name="vvd_vsl_cd" value="<%=vvd_vsl_cd%>">
<input type="hidden" name="vvd_skd_voy_no" value="<%=vvd_skd_voy_no%>">
<input type="hidden" name="vvd_skd_dir_cd" value="<%=vvd_skd_dir_cd%>">
<input type="hidden" name="vvd" value="<%=vvd%>">
<input type="hidden" name="atb_dt" value="<%=vvd_atb_dt%>">
<input type="hidden" name="io_bnd_cd" value="<%=vvd_io_bnd_cd%>">
<input type="hidden" name="vvd_vsl_cd2" value="<%=vvd_vsl_cd2%>">
<input type="hidden" name="vvd_skd_voy_no2" value="<%=vvd_skd_voy_no2%>">
<input type="hidden" name="vvd_skd_dir_cd2" value="<%=vvd_skd_dir_cd2%>">
<input type="hidden" name="vvd2" value="<%=vvd2%>">
<input type="hidden" name="atb_dt2" value="<%=vvd_atb_dt2%>">
<input type="hidden" name="io_bnd_cd2" value="<%=vvd_io_bnd_cd2%>">


<!-- OUTER - POPUP (S)tart -->
<table width="800" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;Amount Allocation By VVD</td></tr>
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

			</td></tr>
		</table>

		<!-- : ( Search Options ) (E) -->

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
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_confirm" id="btn_confirm">Confirm</td><td class="btn1_right"></td></tr></table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>
					<!-- Repeat Pattern -->

				</tr>
			</table>

		</td></tr>
</table>

</form>

</body>
</html>