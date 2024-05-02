<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TES_9140.jsp
*@FileTitle  : ESD_TES_9140
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/07
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%
	Exception serverException   = null;			//Server Exception
	String strErrMsg = "";						//Error Message

	try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}

	String tml_so_ofc_cty_cd = request.getParameter("tml_so_ofc_cty_cd")!=null&&!request.getParameter("tml_so_ofc_cty_cd").equals("")?request.getParameter("tml_so_ofc_cty_cd"):"";
	String tml_so_seq	= request.getParameter("tml_so_seq")!=null&&!request.getParameter("tml_so_seq").equals("")?request.getParameter("tml_so_seq"):"";
	String vndr_seq		= request.getParameter("vndr_seq")!=null&&!request.getParameter("vndr_seq").equals("")?request.getParameter("vndr_seq"):"";
	String inv_no		= request.getParameter("inv_no")!=null&&!request.getParameter("inv_no").equals("")?request.getParameter("inv_no"):"";
	String yd_cd		= request.getParameter("yd_cd")!=null&&!request.getParameter("yd_cd").equals("")?request.getParameter("yd_cd"):"";
	String fm_prd_dt	= request.getParameter("fm_prd_dt")!=null&&!request.getParameter("fm_prd_dt").equals("")?request.getParameter("fm_prd_dt"):"";
	String to_prd_dt	= request.getParameter("to_prd_dt")!=null&&!request.getParameter("to_prd_dt").equals("")?request.getParameter("to_prd_dt"):"";
	String rcv_dt		= request.getParameter("rcv_dt")!=null&&!request.getParameter("rcv_dt").equals("")?request.getParameter("rcv_dt"):"";
	String tml_cost_grp_cd		= request.getParameter("tml_cost_grp_cd")!=null&&!request.getParameter("tml_cost_grp_cd").equals("")?request.getParameter("tml_cost_grp_cd"):"";
	String tml_calc_ind_cd		= request.getParameter("tml_calc_ind_cd")!=null&&!request.getParameter("tml_calc_ind_cd").equals("")?request.getParameter("tml_calc_ind_cd"):"";
	String sto_dys_ind_cd		= request.getParameter("sto_dys_ind_cd")!=null&&!request.getParameter("sto_dys_ind_cd").equals("")?request.getParameter("sto_dys_ind_cd"):"";
	String cntr_tpsz_cd		= request.getParameter("cntr_tpsz_cd")!=null&&!request.getParameter("cntr_tpsz_cd").equals("")?request.getParameter("cntr_tpsz_cd"):"";
	String agmt_ftr_inv_tp_cd		= request.getParameter("agmt_ftr_inv_tp_cd")!=null&&!request.getParameter("agmt_ftr_inv_tp_cd").equals("")?request.getParameter("agmt_ftr_inv_tp_cd"):"";
	//2016.09.09 AGMT COST CD Add
	String cost_cd_ftr_rmk		= request.getParameter("cost_cd_ftr_rmk")!=null&&!request.getParameter("cost_cd_ftr_rmk").equals("")?request.getParameter("cost_cd_ftr_rmk"):"";
	
  %>


<script type="text/javascript">
	<%= JSPUtil.getIBCodeCombo("cntr_sty_cd"	, "01", "CD00136", 0, "")%>
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		}
		loadPage();
	}
</script>



<form name="form">
<input name="f_cmd" type="hidden" id="f_cmd" />
<input type="hidden" name="tml_so_ofc_cty_cd" value="<%=tml_so_ofc_cty_cd%>" id="tml_so_ofc_cty_cd" />
<input type="hidden" name="tml_so_seq" value="<%=tml_so_seq%>" id="tml_so_seq" />
<input type="hidden" name="vndr_seq" value="<%=vndr_seq%>" id="vndr_seq" />
<input type="hidden" name="inv_no" value="<%=inv_no%>" id="inv_no" />
<input type="hidden" name="yd_cd" value="<%=yd_cd%>" id="yd_cd" />
<input type="hidden" name="fm_prd_dt" value="<%=fm_prd_dt%>" id="fm_prd_dt" />
<input type="hidden" name="to_prd_dt" value="<%=to_prd_dt%>" id="to_prd_dt" />
<input type="hidden" name="rcv_dt" value="<%=rcv_dt%>" id="rcv_dt" />
<input type="hidden" name="fileup_min_gt_in_dt" value="" id="fileup_min_gt_in_dt" />
<input type="hidden" name="fileup_max_gt_out_dt" value="" id="fileup_max_gt_out_dt" />
<input type="hidden" name="tml_cost_grp_cd" value="<%=tml_cost_grp_cd%>" id="tml_cost_grp_cd" />
<input type="hidden" name="tml_calc_ind_cd" value="<%=tml_calc_ind_cd%>" id="tml_calc_ind_cd" />
<input type="hidden" name="sto_dys_ind_cd" value="<%=sto_dys_ind_cd%>" id="sto_dys_ind_cd" />
<input type="hidden" name="cntr_tpsz_cd" value="<%=cntr_tpsz_cd%>" id="cntr_tpsz_cd" />
<input type="hidden" name="agmt_ftr_inv_tp_cd" value="<%=agmt_ftr_inv_tp_cd%>" id="agmt_ftr_inv_tp_cd" />
<input type="hidden" name="cost_cd_ftr_rmk" value="<%=cost_cd_ftr_rmk%>" id="cost_cd_ftr_rmk" /><!-- 2016.09.09 AGMT COST CD Add -->


<input type="hidden" name="cntr_no" id="cntr_no" />
<input type="hidden" name="tmp_cntr_tpsz_cd" id="tmp_cntr_tpsz_cd" />
<input type="hidden" name="row" id="row" />

<div class="layer_popup_contents">
	<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<h2 class="page_title"><span>File Import</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_loadexcel" 	id="btn_loadexcel">Load Excel</button><!--
			--><button type="button" class="btn_normal" name="btn_rowadd" 	id="btn_rowadd">Row Add</button><!--
			--><button type="button" class="btn_normal" name="btn_chkdigit" id="btn_chkdigit">CHK Digit</button><!--
			--><button type="button" class="btn_normal" name="btn_verify" id="btn_verify">Verify</button><!--
			--><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button><!--
		--></div>
		<!-- opus_design_btn(E) -->
		<!-- page_location(S) -->
		<div class="location">
			<span id="navigation"></span>
		</div>
		<!-- page_location(E) -->
	</div>
	<!-- page_title_area(E) -->
	</div>
	
	<div class= "wrap_search">
		<div class= "opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="70" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<th>Manual Input</th>
						<td>
							<input type="radio" name="manual_input_yn" value="Y" class="trans" id="manual_input_yn1" /> <label for="manual_input_yn1">Yes</label><!-- 
							 --><input type="radio" name="manual_input_yn" value="N" class="trans" id="manual_input_yn2" /> <label for="manual_input_yn2">No</label>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>		
	<!-- opus_design_grid(S) -->	
	<div class="wrap_result">
		<div class="opus_design_grid clear" id="mainTable" >
				<script type="text/javascript">ComSheetObject('sheet');</script>
		</div>
	</div>
	<!-- opus_design_grid(E) -->
</div>
	</form>