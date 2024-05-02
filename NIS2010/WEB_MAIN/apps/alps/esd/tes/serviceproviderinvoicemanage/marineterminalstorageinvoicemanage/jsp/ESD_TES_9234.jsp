<%--
 ***********************************************************
 *
 * 2009-05-29 [N200905280100]   : TPB I/F 누락 방지 추가
 ***********************************************************
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.bizcommon.util.BizComUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%
   	String tml_inv_tp_cd		= request.getParameter("tml_inv_tp_cd")!=null&&!request.getParameter("tml_inv_tp_cd").equals("")?request.getParameter("tml_inv_tp_cd"):"";
   	String tml_so_ofc_cty_cd	= request.getParameter("tml_so_ofc_cty_cd")!=null&&!request.getParameter("tml_so_ofc_cty_cd").equals("")?request.getParameter("tml_so_ofc_cty_cd"):"";
	String tml_so_seq			= request.getParameter("tml_so_seq")!=null&&!request.getParameter("tml_so_seq").equals("")?request.getParameter("tml_so_seq"):"";
	String tml_so_dtl_seq		= request.getParameter("tml_so_dtl_seq")!=null&&!request.getParameter("tml_so_dtl_seq").equals("")?request.getParameter("tml_so_dtl_seq"):"";
	String calc_cost_grp_cd		= request.getParameter("calc_cost_grp_cd")!=null&&!request.getParameter("calc_cost_grp_cd").equals("")?request.getParameter("calc_cost_grp_cd"):"";
	String calc_tp_cd			= request.getParameter("calc_tp_cd")!=null&&!request.getParameter("calc_tp_cd").equals("")?request.getParameter("calc_tp_cd"):"";
	String vndr_seq				= request.getParameter("vndr_seq")!=null&&!request.getParameter("vndr_seq").equals("")?request.getParameter("vndr_seq"):"";
	String inv_no				= request.getParameter("inv_no")!=null&&!request.getParameter("inv_no").equals("")?request.getParameter("inv_no"):"";
	String param_lgs_cost_cd	= request.getParameter("param_lgs_cost_cd")!=null&&!request.getParameter("param_lgs_cost_cd").equals("")?request.getParameter("param_lgs_cost_cd"):"";
	String param_cntr_tpsz_cd	= request.getParameter("param_cntr_tpsz_cd")!=null&&!request.getParameter("param_cntr_tpsz_cd").equals("")?request.getParameter("param_cntr_tpsz_cd"):"";
	String sheet_curr_row		= request.getParameter("sheet_curr_row")!=null&&!request.getParameter("sheet_curr_row").equals("")?request.getParameter("sheet_curr_row"):"";
	String sheet_idx			= request.getParameter("sheet_idx")!=null&&!request.getParameter("sheet_idx").equals("")?request.getParameter("sheet_idx"):"";
	String param_cntr_no		= request.getParameter("param_cntr_no")!=null&&!request.getParameter("param_cntr_no").equals("")?request.getParameter("param_cntr_no"):"";
	String curr_cd				= request.getParameter("curr_cd")!=null&&!request.getParameter("curr_cd").equals("")?request.getParameter("curr_cd"):"";
	String inv_amt				= request.getParameter("inv_amt")!=null&&!request.getParameter("inv_amt").equals("")?request.getParameter("inv_amt"):"";
	String calc_amt				= request.getParameter("calc_amt")!=null&&!request.getParameter("calc_amt").equals("")?request.getParameter("calc_amt"):"";
    //2008-07-02 3rd party interface 로직변경요청 CSR start
    String yd_cd  				= request.getParameter("yd_cd")!=null&&!request.getParameter("yd_cd").equals("")?request.getParameter("yd_cd"):"";
	String ctrt_rt  			= request.getParameter("ctrt_rt")!=null&&!request.getParameter("ctrt_rt").equals("")?request.getParameter("ctrt_rt"):"";
	String inv_xch_rt			= request.getParameter("inv_xch_rt")!=null&&!request.getParameter("inv_xch_rt").equals("")?request.getParameter("inv_xch_rt"):"1";
    //2008-07-02 3rd party interface 로직변경요청 CSR end
	// 4341.12.23 3rd Parth Interface Amount 산출 로직 변경(전나영 차장님 CSR)
	String ovr_dys				= request.getParameter("ovr_dys")!=null&&!request.getParameter("ovr_dys").equals("")?request.getParameter("ovr_dys"):"1";
%>
<html>
<head>
<title>Welcome to ALPS!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
<%= JSPUtil.getIBCodeCombo("combo01", "01", "CD00583", 0, "")%>
    function setupPage(){
        loadPage();
    }
</script>
</head>

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="sheet_idx" value='<%=sheet_idx%>'>
<input type="hidden" name="sheet_curr_row" value='<%=sheet_curr_row%>'>
<input type="hidden" name="tml_inv_tp_cd" value="<%=tml_inv_tp_cd%>"> <!--// TM, OF, ON, ST //-->
<input type="hidden" name="tml_so_ofc_cty_cd" value="<%=tml_so_ofc_cty_cd%>">
<input type="hidden" name="tml_so_seq" value="<%=tml_so_seq%>">
<input type="hidden" name="tml_so_dtl_seq" value='<%=tml_so_dtl_seq%>'>
<input type="hidden" name="calc_cost_grp_cd" value="<%=calc_cost_grp_cd%>"> <!--// TM, SD, SP //-->
<input type="hidden" name="calc_tp_cd" value="<%=calc_tp_cd%>"> <!--// A, M //-->
<input type="hidden" name="vndr_seq" value="<%=vndr_seq%>">
<input type="hidden" name="inv_no" value="<%=inv_no%>">
<input type="hidden" name="param_lgs_cost_cd" value="<%=param_lgs_cost_cd%>">
<input type="hidden" name="param_cntr_tpsz_cd" value="<%=param_cntr_tpsz_cd%>">
<input type="hidden" name="param_cntr_no" value="<%=param_cntr_no%>">
<input type="hidden" name="n3pty_bil_cs_cd" value="">
<input type="hidden" name="curr_cd" value="<%=curr_cd%>">
<input type="hidden" name="inv_amt" value="<%=inv_amt%>">
<input type="hidden" name="calc_amt" value="<%=calc_amt%>">
<!-- 2008-07-02 3rd party interface 로직변경요청 CSR start -->
<input type="hidden" name="yd_cd" value="<%=yd_cd%>">
<input type="hidden" name="ctrt_rt" value="<%=ctrt_rt%>">
<input type="hidden" name="inv_xch_rt" value="<%=inv_xch_rt%>">
<!-- 2008-07-02 3rd party interface 로직변경요청 CSR end -->
<!-- 4341.12.23 3rd Parth Interface Amount 산출 로직 변경(전나영 차장님 CSR) -->
<input type="hidden" name="ovr_dys" value="<%=ovr_dys%>">

<!-- TPB I/F N3PTY FLG 누락방지 ( 200-06-02 )	-->
<input type="hidden" name="del_if_seq">
<input type="hidden" name="del_cntr_seq">

<!-- TPB I/F TPB Use BillingCase Code Get Temp ( 2009-09-18 )	-->
<input type="hidden" name="n3pty_bil_tp_cd_tmp"		value="">

<!-- OUTER - POPUP (S)tart -->
<table width="700" class="popup" cellpadding="10">
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
					<td width="11%">Source No.</td>
					<td><input type="text" name='inv_no' style="width:150" value="<%=inv_no%>" class="input2" readonly></td></tr>
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
                         <script language="javascript">ComSheetObject('sheet1');</script>
                    </td></tr>
                </table>
				<!-- : ( Grid ) (E) -->



				<!-- : ( Button : Sub ) (S) -->
				<table class="button" border="0" width="100%">
					<tr><td class="btn2_bg" class="align">
						<div id='enableRowButton' style="display:inline">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<!-- Repeat Pattern -->
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btng_rowadd" id="btng_rowadd">Row Add</td>
								<td class="btn2_right"></td></tr></table></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btng_rowdel" id="btng_rowdel">Delete</td>
								<td class="btn2_right"></td></tr></table></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btng_interfaceto3rd" id="btng_interfaceto3rd">Ok</td>
								<td class="btn2_right"></td></tr></table></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btn_close" id="btn_close">Close</td>
								<td class="btn2_right"></td></tr></table></td>
								<!-- Repeat Pattern -->
							</tr>
						</table>
						</div>
						<div id='disableRowButton' style="display:none">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<!-- Repeat Pattern -->
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btng_interfaceto3rd" id="btng_interfaceto3rd">Ok</td>
								<td class="btn2_right"></td></tr></table></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btn_close" id="btn_close">Close</td>
								<td class="btn2_right"></td></tr></table></td>
								<!-- Repeat Pattern -->
							</tr>
						</table>
						</div>
					</td></tr>
				</table>
		    	<!-- : ( Button : Sub ) (E) -->

			</td></tr>
		</table>
		<!-- : ( Search Options ) (E) -->

</td></tr>
</table>
<!-- OUTER - POPUP (E)nd -->

</form>

</body>
</html>
