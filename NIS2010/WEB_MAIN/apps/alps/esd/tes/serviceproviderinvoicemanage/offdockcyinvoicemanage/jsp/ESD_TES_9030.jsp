<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_9030.jsp
*@FileTitle :Volume Adjustment PopUp 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2007-03-01
*@LastModifier : kimjinjoo
*@LastVersion : 1.0
* 2007-03-01 kimjinjoo
* 1.0 최초 생성
* 2011.08.08 윤태승 [CHM-201111118-1] MR Invoice Creation & Correction 의 Manual input 보완
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%
	String tml_so_ofc_cty_cd = request.getParameter("tml_so_ofc_cty_cd")!=null&&!request.getParameter("tml_so_ofc_cty_cd").equals("")?request.getParameter("tml_so_ofc_cty_cd"):"";
	String tml_so_seq	= request.getParameter("tml_so_seq")!=null&&!request.getParameter("tml_so_seq").equals("")?request.getParameter("tml_so_seq"):"";
	String tml_so_dtl_seq	= request.getParameter("tml_so_dtl_seq")!=null&&!request.getParameter("tml_so_dtl_seq").equals("")?request.getParameter("tml_so_dtl_seq"):"";
	String calc_tp_cd	= request.getParameter("calc_tp_cd")!=null&&!request.getParameter("calc_tp_cd").equals("")?request.getParameter("calc_tp_cd"):"";
	String vndr_seq = request.getParameter("vndr_seq")!=null&&!request.getParameter("vndr_seq").equals("")?request.getParameter("vndr_seq"):"";
	String inv_no	= request.getParameter("inv_no")!=null&&!request.getParameter("inv_no").equals("")?request.getParameter("inv_no"):"";
	String param_lgs_cost_cd	= request.getParameter("param_lgs_cost_cd")!=null&&!request.getParameter("param_lgs_cost_cd").equals("")?request.getParameter("param_lgs_cost_cd"):"";
	String param_cntr_tpsz_cd	= request.getParameter("param_cntr_tpsz_cd")!=null&&!request.getParameter("param_cntr_tpsz_cd").equals("")?request.getParameter("param_cntr_tpsz_cd"):"";
	String param_dcgo_clss_cd	= request.getParameter("param_dcgo_clss_cd")!=null&&!request.getParameter("param_dcgo_clss_cd").equals("")?request.getParameter("param_dcgo_clss_cd"):"";
	String param_rc_flg	= request.getParameter("param_rc_flg")!=null&&!request.getParameter("param_rc_flg").equals("")?request.getParameter("param_rc_flg"):"";
	String calcTerminalComboItems = request.getParameter("calcTerminalComboItems")!=null&&!request.getParameter("calcTerminalComboItems").equals("")?request.getParameter("calcTerminalComboItems"):"";
	String sheet_curr_row	= request.getParameter("sheet_curr_row")!=null&&!request.getParameter("sheet_curr_row").equals("")?request.getParameter("sheet_curr_row"):"";
	String fm_prd_dt	= request.getParameter("fm_prd_dt")!=null&&!request.getParameter("fm_prd_dt").equals("")?request.getParameter("fm_prd_dt"):"";
	String to_prd_dt	= request.getParameter("to_prd_dt")!=null&&!request.getParameter("to_prd_dt").equals("")?request.getParameter("to_prd_dt"):"";
	String yd_cd	= request.getParameter("yd_cd")!=null&&!request.getParameter("yd_cd").equals("")?request.getParameter("yd_cd"):"";

%>
<html>
<head>
<title>Welcome to YMS!</title>
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
<input type="hidden" name="sheet_curr_row" value='<%=sheet_curr_row%>'>
<input type="hidden" name="tml_so_ofc_cty_cd" value='<%=tml_so_ofc_cty_cd%>'>
<input type="hidden" name="tml_so_seq" value='<%=tml_so_seq%>'>
<input type="hidden" name="tml_so_dtl_seq" value='<%=tml_so_dtl_seq%>'>
<input type="hidden" name="calc_tp_cd" value='<%=calc_tp_cd%>'>
<input type="hidden" name="vndr_seq" value='<%=vndr_seq%>'>
<input type="hidden" name="inv_no" value='<%=inv_no%>'>
<input type="hidden" name="param_lgs_cost_cd" value='<%=param_lgs_cost_cd%>'>
<input type="hidden" name="param_cntr_tpsz_cd" value='<%=param_cntr_tpsz_cd%>'>
<input type="hidden" name="param_dcgo_clss_cd" value='<%=param_dcgo_clss_cd%>'>
<input type="hidden" name="param_rc_flg" value='<%=param_rc_flg%>'>
<input type="hidden" name="calcTerminalComboItems" value='<%=calcTerminalComboItems%>'>
<input type="hidden" name="search_bkg_no">
<input type="hidden" name="rowId">
<input type="hidden" name="cntr_no">
<input type="hidden" name="fm_prd_dt" value='<%=fm_prd_dt%>'>
<input type="hidden" name="to_prd_dt" value='<%=to_prd_dt%>'>
<input type="hidden" name="yd_cd" value='<%=yd_cd%>'>

<!-- OUTER - POPUP (S)tart -->
<table width="600" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;Revised Vol.(Volume Adjustment)</td></tr>
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
				<!-- : ( Button : Sub ) (S) -->
			<table width="100%" class="sbutton">
	       	<tr><td class="align">

			    <table class="sbutton">
			    <tr><td class="bt"><!--img class="cursor" src="/hanjin/img/button/btng_rowadd.gif" width="65" height="19" border="0" name="btng_rowadd"--></td></tr>
				</table>

			</td></tr>
			</table>
	    	<!-- : ( Button : Sub ) (E) -->
			<table width="100%" class="sbutton">
       				<tr><td class="align">
       				<div id="div_manual_mode_button" style="display:none;">
					<table class="sbutton">
		    			<tr>
		    				<td class="bt">
		    					<img class="cursor" src="/hanjin/img/button/btng_rowdel.gif" width="65" height="19" border="0" name="btn_rowdel">
		    					<img class="cursor" src="/hanjin/img/button/btng_rowadd.gif" width="65" height="19" border="0" name="btng_rowadd">
		    				</td>
						</tr>
					</table>
					</div>
				</td></tr>
			</table>
			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options : Speed ) (E) -->

</td></tr>
</table>
<!-- OUTER - POPUP (E)nd -->



<table class="height_10"><tr><td></td></tr></table>


<!-- : ( Button : Sub ) (S) -->
<table width="600" class="sbutton">
		<tr><td height="71" class="popup">

			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
	       		<tr><td class="btn3_bg">
			    <table border="0" cellpadding="0" cellspacing="0">
			    <tr>

					<!-- Repeat Pattern -->					
					
<!-- 				
					<td>
					<div id="div_manual_mode_button" style="display:none;">
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btng_rowadd" id="btng_rowadd">Row Add</td><td class="btn1_right"></td></tr>
						</table>
					</div>
					</td>					
 -->
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_save" id="btn_save">Save</td><td class="btn1_right"></td></tr>
						</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr>
						</table></td>
					<!-- Repeat Pattern -->

				</tr>
				</table>
				</td></tr>
			</table>
			
		</td></tr>
</table>
<!-- : ( Button : Sub ) (E) -->

</form>

</body>
</html>

<div id="div_manual_mode_hidden" style="display:none; width:40%">
<script language="javascript">ComSheetObject('manual_mode_hidden');</script>
</div>

<script>
	//initDTLseq2();
</script>

