<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TES_1003.jsp
*@FileTitle  : 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/27
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.bizcommon.util.BizComUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
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
<script type="text/javascript">
    function setupPage(){
        loadPage();
    }
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<!-- 
<input type="hidden" name="pm_tml_so_ofc_cty_cd" value="<%=tml_so_ofc_cty_cd%>" id="pm_tml_so_ofc_cty_cd" />
<input type="hidden" name="pm_tml_so_seq" value="<%=tml_so_seq%>" id="pm_tml_so_seq" />
<input type="hidden" name="pm_yd_cd" value="<%=yd_cd%>" id="pm_yd_cd" />
<input type="hidden" name="bound_lgs_cost_cd" value="<%=bound_lgs_cost_cd%>" id="bound_lgs_cost_cd" />
<input type="hidden" name="pm_vvd_vsl_cd" value="<%=vvd_vsl_cd%>" id="pm_vvd_vsl_cd" />
<input type="hidden" name="pm_vvd_skd_voy_no" value="<%=vvd_skd_voy_no%>" id="pm_vvd_skd_voy_no" />
<input type="hidden" name="pm_vvd_skd_dir_cd" value="<%=vvd_skd_dir_cd%>" id="pm_vvd_skd_dir_cd" />
<input type="hidden" name="pm_vvd" value="<%=vvd%>" id="pm_vvd" />
<input type="hidden" name="pm_atb_dt" value="<%=vvd_atb_dt%>" id="pm_atb_dt" />
<input type="hidden" name="pm_io_bnd_cd" value="<%=vvd_io_bnd_cd%>" id="pm_io_bnd_cd" />
<input type="hidden" name="pm_vvd_vsl_cd2" value="<%=vvd_vsl_cd2%>" id="pm_vvd_vsl_cd2" />
<input type="hidden" name="pm_vvd_skd_voy_no2" value="<%=vvd_skd_voy_no2%>" id="pm_vvd_skd_voy_no2" />
<input type="hidden" name="pm_vvd_skd_dir_cd2" value="<%=vvd_skd_dir_cd2%>" id="pm_vvd_skd_dir_cd2" />
<input type="hidden" name="pm_vvd2" value="<%=vvd2%>" id="pm_vvd2" />
<input type="hidden" name="pm_atb_dt2" value="<%=vvd_atb_dt2%>" id="pm_atb_dt2" />
<input type="hidden" name="pm_io_bnd_cd2" value="<%=vvd_io_bnd_cd2%>" id="pm_io_bnd_cd2" />
 -->

<input type="hidden" name="tml_so_ofc_cty_cd" value="<%=tml_so_ofc_cty_cd%>" id="tml_so_ofc_cty_cd" />
<input type="hidden" name="tml_so_seq" value="<%=tml_so_seq%>" id="tml_so_seq" />
<input type="hidden" name="yd_cd" value="<%=yd_cd%>" id="yd_cd" />
<input type="hidden" name="bound_lgs_cost_cd" value="<%=bound_lgs_cost_cd%>" id="bound_lgs_cost_cd" />
<input type="hidden" name="vvd_vsl_cd" value="<%=vvd_vsl_cd%>" id="vvd_vsl_cd" />
<input type="hidden" name="vvd_skd_voy_no" value="<%=vvd_skd_voy_no%>" id="vvd_skd_voy_no" />
<input type="hidden" name="vvd_skd_dir_cd" value="<%=vvd_skd_dir_cd%>" id="vvd_skd_dir_cd" />
<input type="hidden" name="vvd" value="<%=vvd%>" id="vvd" />
<input type="hidden" name="atb_dt" value="<%=vvd_atb_dt%>" id="atb_dt" />
<input type="hidden" name="io_bnd_cd" value="<%=vvd_io_bnd_cd%>" id="io_bnd_cd" />
<input type="hidden" name="vvd_vsl_cd2" value="<%=vvd_vsl_cd2%>" id="vvd_vsl_cd2" />
<input type="hidden" name="vvd_skd_voy_no2" value="<%=vvd_skd_voy_no2%>" id="vvd_skd_voy_no2" />
<input type="hidden" name="vvd_skd_dir_cd2" value="<%=vvd_skd_dir_cd2%>" id="vvd_skd_dir_cd2" />
<input type="hidden" name="vvd2" value="<%=vvd2%>" id="vvd2" />
<input type="hidden" name="atb_dt2" value="<%=vvd_atb_dt2%>" id="atb_dt2" />
<input type="hidden" name="io_bnd_cd2" value="<%=vvd_io_bnd_cd2%>" id="io_bnd_cd2" />

<!-- layer_popup_title(S) -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<!-- page_title(S) -->
			<h2 class="page_title"><span>Amount Allocation By VVD</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
		    <button type="button" class="btn_accent" name="btn_confirm" id="btn_confirm">Confirm</button><!-- 
		     --><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->
	</div>
	<!-- page_title_area(E) -->
</div>
<!-- layer_popup_title(E) -->

<!-- layer_popup_contents(S) -->
<div class="layer_popup_contents">
	<div class="wrap_result"> 
		<div class="opus_design_grid" id="mainTable">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>	
</div>
<!-- layer_popup_contents(E) -->
</form>