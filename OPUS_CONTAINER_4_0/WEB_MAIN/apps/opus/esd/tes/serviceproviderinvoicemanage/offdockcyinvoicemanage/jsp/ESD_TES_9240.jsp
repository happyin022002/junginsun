<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%
	String param_name = null;
	java.util.Enumeration enums = request.getParameterNames();
	while (enums.hasMoreElements()){
		param_name = (String)enums.nextElement();
	}

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
	String ot_a_lgs_cost_cd	= request.getParameter("ot_a_lgs_cost_cd")!=null&&!request.getParameter("ot_a_lgs_cost_cd").equals("")?request.getParameter("ot_a_lgs_cost_cd"):"";
	String calcTerminalComboItems = request.getParameter("calcTerminalComboItems")!=null&&!request.getParameter("calcTerminalComboItems").equals("")?request.getParameter("calcTerminalComboItems"):"";
	String cntr_tpsz_cd	= request.getParameter("cntr_tpsz_cd")!=null&&!request.getParameter("cntr_tpsz_cd").equals("")?request.getParameter("cntr_tpsz_cd"):"";
	String cntr_sty_cdCode	= request.getParameter("cntr_sty_cdCode")!=null&&!request.getParameter("cntr_sty_cdCode").equals("")?request.getParameter("cntr_sty_cdCode"):"";
	String sheet_curr_row	= request.getParameter("sheet_curr_row")!=null&&!request.getParameter("sheet_curr_row").equals("")?request.getParameter("sheet_curr_row"):"";
	String fm_prd_dt	= request.getParameter("fm_prd_dt")!=null&&!request.getParameter("fm_prd_dt").equals("")?request.getParameter("fm_prd_dt"):"";
%>
<html>
<head>
<title>Welcome to OPUS!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
    function setupPage(){
		loadPage();
    }
</script>
</head>

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
<input type="hidden" name="ot_a_lgs_cost_cd" value='<%=ot_a_lgs_cost_cd%>'>
<input type="hidden" name="calcTerminalComboItems" value='<%=calcTerminalComboItems%>'>
<input type="hidden" name="cntr_tpsz_cd" value='<%=cntr_tpsz_cd%>'>
<input type="hidden" name="cntr_sty_cdCode" value='<%=cntr_sty_cdCode%>'>
<input type="hidden" name="fm_prd_dt" value='<%=fm_prd_dt%>'>



<div class="layer_popup_title">
	<div class="page_title_area clear"> 
		<h2 class="page_title"><span>Revised Vol.(Volume Adjustment)</span></h2>
		
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button>
			<button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_result">
		<div class="opus_design_grid clear">
			<div class="opus_design_btn" id="div_manual_mode_button" style="display:none;">			
				<button type="button" class="btn_accent" name="btn_rowadd" id="btn_rowadd">Row Add</button>
				<!--<button type="button" class="btn_accent" name="btn_rowdel" 		id="btn_rowdel">Row Del</button>-->
			</div>
			<script type="text/javascript">ComSheetObject('sheet');</script>
		</div>
	</div>
</div>


<!-- : ( Button : Sub ) (E) -->
<div id="div_manual_mode_hidden" style="display:none; width:40%">
<script language="javascript">ComSheetObject('manual_mode_hidden');</script>
</div>

</form>



