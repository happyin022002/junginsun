<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0235.jsp
*@FileTitle  : Agreement Rate Inquiry Detail
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/08
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%> 
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%
	Exception serverException = null;	//Server Exception
	String	  strErrMsg	= "";			//Error Message

	String fm_rail_svc_tp_cd         = request.getParameter("fm_rail_svc_tp_cd")!=null?request.getParameter("fm_rail_svc_tp_cd"):"";
	String fm_agmt_trsp_tp_cd        = request.getParameter("fm_agmt_trsp_tp_cd_sheet")!=null?request.getParameter("fm_agmt_trsp_tp_cd_sheet"):"";
	String fm_trsp_agmt_ofc_cty_cd   = request.getParameter("fm_trsp_agmt_ofc_cty_cd")!=null?request.getParameter("fm_trsp_agmt_ofc_cty_cd"):"";
	String fm_trsp_agmt_seq          = request.getParameter("fm_trsp_agmt_seq")!=null?request.getParameter("fm_trsp_agmt_seq"):"";
	String fm_trsp_agmt_rt_tp_ser_no = request.getParameter("fm_trsp_agmt_rt_tp_ser_no")!=null?request.getParameter("fm_trsp_agmt_rt_tp_ser_no"):"";
	String fm_vndr_seq               = request.getParameter("fm_vndr_seq")!=null?request.getParameter("fm_vndr_seq"):"";
	String fm_ctrt_ofc_cd            = request.getParameter("fm_ctrt_ofc_cd")!=null?request.getParameter("fm_ctrt_ofc_cd"):"";
	String fm_eq_knd_cd              = request.getParameter("fm_eq_knd_cd")!=null?request.getParameter("fm_eq_knd_cd"):"";
	String fm_trsp_agmt_eq_tp_sz_cd  = request.getParameter("fm_trsp_agmt_eq_tp_sz_cd")!=null?request.getParameter("fm_trsp_agmt_eq_tp_sz_cd"):"";
	String fm_cgo_tp_cd              = request.getParameter("fm_cgo_tp_cd")!=null?request.getParameter("fm_cgo_tp_cd"):"";

	String fm_trsp_cost_mod_cd       = request.getParameter("fm_trsp_cost_mod_cd")!=null?request.getParameter("fm_trsp_cost_mod_cd"):"";
	String fm_trsp_bnd_cd            = request.getParameter("fm_trsp_bnd_cd")!=null?request.getParameter("fm_trsp_bnd_cd"):"";
	
	String fm_fm_nod_cd              = request.getParameter("fm_fm_nod_cd")!=null?request.getParameter("fm_fm_nod_cd"):"";
	String fm_via_nod_cd             = request.getParameter("fm_via_nod_cd")!=null?request.getParameter("fm_via_nod_cd"):"";
	String fm_dor_nod_cd             = request.getParameter("fm_dor_nod_cd")!=null?request.getParameter("fm_dor_nod_cd"):"";
	String fm_to_nod_cd              = request.getParameter("fm_to_nod_cd")!=null?request.getParameter("fm_to_nod_cd"):"";
	String fm_trsp_agmt_bdl_qty      = request.getParameter("fm_trsp_agmt_bdl_qty")!=null?request.getParameter("fm_trsp_agmt_bdl_qty"):"";
	String fm_wgt_meas_ut_cd         = request.getParameter("fm_wgt_meas_ut_cd")!=null?request.getParameter("fm_wgt_meas_ut_cd"):"";
	String fm_basic_rt               = request.getParameter("fm_basic_rt")!=null?request.getParameter("fm_basic_rt"):"";
	String fm_curr_cd                = request.getParameter("fm_curr_cd")!=null?request.getParameter("fm_curr_cd"):"";
	String fm_way                    = request.getParameter("fm_way")!=null?request.getParameter("fm_way"):"";

	try {		
		serverException				= (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
  function setupPage(){
    loadPage();
  }
</script>

<form method="post" name="form" onSubmit="return false;">

<input type="hidden" name="fm_rail_svc_tp_cd" value="<%=fm_rail_svc_tp_cd%>" id="fm_rail_svc_tp_cd" />
<input type="hidden" name="fm_agmt_trsp_tp_cd" value="<%=fm_agmt_trsp_tp_cd%>" id="fm_agmt_trsp_tp_cd" />
<input type="hidden" name="fm_trsp_agmt_ofc_cty_cd" value="<%=fm_trsp_agmt_ofc_cty_cd%>" id="fm_trsp_agmt_ofc_cty_cd" />
<input type="hidden" name="fm_trsp_agmt_seq" value="<%=fm_trsp_agmt_seq%>" id="fm_trsp_agmt_seq" />
<input type="hidden" name="fm_trsp_agmt_rt_tp_ser_no" value="<%=fm_trsp_agmt_rt_tp_ser_no%>" id="fm_trsp_agmt_rt_tp_ser_no" />
<input type="hidden" name="fm_vndr_seq" value="<%=fm_vndr_seq%>" id="fm_vndr_seq" />
<input type="hidden" name="fm_ctrt_ofc_cd" value="<%=fm_ctrt_ofc_cd%>" id="fm_ctrt_ofc_cd" />
<input type="hidden" name="fm_eq_knd_cd" value="<%=fm_eq_knd_cd%>" id="fm_eq_knd_cd" />
<input type="hidden" name="fm_trsp_agmt_eq_tp_sz_cd" value="<%=fm_trsp_agmt_eq_tp_sz_cd%>" id="fm_trsp_agmt_eq_tp_sz_cd" />
<input type="hidden" name="fm_cgo_tp_cd" value="<%=fm_cgo_tp_cd%>" id="fm_cgo_tp_cd" />

<input type="hidden" name="fm_trsp_cost_mod_cd" value="<%=fm_trsp_cost_mod_cd%>" id="fm_trsp_cost_mod_cd" />
<input type="hidden" name="fm_trsp_bnd_cd" value="<%=fm_trsp_bnd_cd%>" id="fm_trsp_bnd_cd" />

<input type="hidden" name="fm_fm_nod_cd" value="<%=fm_fm_nod_cd%>" id="fm_fm_nod_cd" />
<input type="hidden" name="fm_via_nod_cd" value="<%=fm_via_nod_cd%>" id="fm_via_nod_cd" />
<input type="hidden" name="fm_dor_nod_cd" value="<%=fm_dor_nod_cd%>" id="fm_dor_nod_cd" />
<input type="hidden" name="fm_to_nod_cd" value="<%=fm_to_nod_cd%>" id="fm_to_nod_cd" />
<input type="hidden" name="fm_trsp_agmt_bdl_qty" value="<%=fm_trsp_agmt_bdl_qty%>" id="fm_trsp_agmt_bdl_qty" />
<input type="hidden" name="fm_wgt_meas_ut_cd" value="<%=fm_wgt_meas_ut_cd%>" id="fm_wgt_meas_ut_cd" />
<input type="hidden" name="fm_curr_cd" value="<%=fm_curr_cd%>" id="fm_curr_cd" />
<input type="hidden" name="fm_basic_rt" value="<%=fm_basic_rt%>" id="fm_basic_rt" />
<input type="hidden" name="fm_way" value="<%=fm_way%>" id="fm_way" />
<input type="hidden" name="f_cmd" id="f_cmd" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><span>Agreement Rate Inquiry Detail</span></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btng_close" id="btng_close" type="button">Close</button><!--
		--></div>
	<!-- opus_design_btn (E) -->


	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->
</div>


</form>
