<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TES_9030.jsp
*@FileTitle  : Revised Vol.(Volume Adjustment)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/25
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
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

%>

<script type="text/javascript">

    function setupPage(){
		loadPage();
	}

</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="sheet_curr_row" value="<%=sheet_curr_row%>" id="sheet_curr_row" />
<input type="hidden" name="tml_so_ofc_cty_cd" value="<%=tml_so_ofc_cty_cd%>" id="tml_so_ofc_cty_cd" />
<input type="hidden" name="tml_so_seq" value="<%=tml_so_seq%>" id="tml_so_seq" />
<input type="hidden" name="tml_so_dtl_seq" value="<%=tml_so_dtl_seq%>" id="tml_so_dtl_seq" />
<input type="hidden" name="calc_tp_cd" value="<%=calc_tp_cd%>" id="calc_tp_cd" />
<input type="hidden" name="vndr_seq" value="<%=vndr_seq%>" id="vndr_seq" />
<input type="hidden" name="inv_no" value="<%=inv_no%>" id="inv_no" />
<input type="hidden" name="param_lgs_cost_cd" value="<%=param_lgs_cost_cd%>" id="param_lgs_cost_cd" />
<input type="hidden" name="param_cntr_tpsz_cd" value="<%=param_cntr_tpsz_cd%>" id="param_cntr_tpsz_cd" />
<input type="hidden" name="param_dcgo_clss_cd" value="<%=param_dcgo_clss_cd%>" id="param_dcgo_clss_cd" />
<input type="hidden" name="param_rc_flg" value="<%=param_rc_flg%>" id="param_rc_flg" />
<input type="hidden" name="calcTerminalComboItems" value="<%=calcTerminalComboItems%>" id="calcTerminalComboItems" />

<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">

		<!-- page_title(S) -->
		<h2 class="page_title"><span>Revised Vol.(Volume Adjustment)</span></h2>
		<!-- page_title(E) -->
		
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_save" 		id="btn_save">Save</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_close" 			id="btn_close">Close</button>		
		</div>
		<!-- opus_design_btn(E) -->
		
	</div>
	<!-- page_title_area(E) -->
</div>

<div class="layer_popup_contents">	

	<div class="wrap_result">	
		
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">	
			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn" id="div_manual_mode_button" style="display:none;">
				<button type="button" class="btn_accent" name="btn_rowadd" id="btn_rowadd">Row Add</button>
			</div>
			<!-- opus_design_btn(E) -->		
			<script type="text/javascript">ComSheetObject('sheet');</script>		
		</div>
		<!-- opus_design_grid(E) -->
		
	</div>	
</div>
</form>

<div class="opus_design_grid" id="div_manual_mode_hidden" style="display:none;">			
	<script type="text/javascript">ComSheetObject('manual_mode_hidden');</script>
</div>