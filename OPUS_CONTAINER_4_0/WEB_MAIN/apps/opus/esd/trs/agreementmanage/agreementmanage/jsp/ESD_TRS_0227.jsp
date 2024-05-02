<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0227.jsp
*@FileTitle  : Agreement Rate History Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/07
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%
	Exception					serverException		= null;
	String						strErrMsg			= "";
	String	userId		= "";
	String	ofcCd		= "";

	String optionStr    = "";
	String selTRANSMODE = "";	//Trans Mode Combo
	String selCARGOMODE = "";	//Cargo Type Combo
	String selRAILSVC   = "";	//Rail Service Combo

	selTRANSMODE	= JSPUtil.getCodeCombo("ufm_agmt_trsp_tp_cd", "01"	,"style='width:98' disabled", "CD00283", 0, optionStr);
	selCARGOMODE	= JSPUtil.getCodeCombo("ufm_cgo_tp_cd",	"01"	,"style='width:98;' disabled", "CD00748", 0, optionStr);
	selRAILSVC		= JSPUtil.getCodeCombo("ufm_rail_svc_tp_cd",		"01"	,"style='width:136;' disabled", "CD00916", 1, optionStr);

	String agmt_no            = ((request.getParameter("fm_agmtno")==null )?"":request.getParameter("fm_agmtno"));		
	String trsp_agmt_rt_tp_cd = ((request.getParameter("fm_trsp_agmt_rt_tp_cd")==null )?"":request.getParameter("fm_trsp_agmt_rt_tp_cd"));
	String eq_knd_cd        = ((request.getParameter("fm_eq_knd_cd")==null )?"":request.getParameter("fm_eq_knd_cd"));
	String trsp_cost_mod_cd = ((request.getParameter("chk_trsp_cost_mod_cd")==null)?"":request.getParameter("chk_trsp_cost_mod_cd"));
	String agmt_trsp_tp_cd  = ((request.getParameter("chk_agmt_trsp_tp_cd")==null)?"":request.getParameter("chk_agmt_trsp_tp_cd"));
	String cgo_tp_cd        = ((request.getParameter("chk_cgo_tp_cd")==null)?"":request.getParameter("chk_cgo_tp_cd"));
	String cust_cd          = ((request.getParameter("chk_cust_cd")==null)?"":request.getParameter("chk_cust_cd"));
	String cmdt_grp_cd      = ((request.getParameter("chk_cmdt_grp_cd")==null)?"":request.getParameter("chk_cmdt_grp_cd"));
	String rail_svc_tp_cd   = ((request.getParameter("chk_rail_svc_tp_cd")==null)?"":request.getParameter("chk_rail_svc_tp_cd"));
	String fm_nod_cd        = ((request.getParameter("chk_fm_nod_cd")==null)?"":request.getParameter("chk_fm_nod_cd"));
	String fm_nod_yd        = ((request.getParameter("chk_fm_nod_yd")==null)?"":request.getParameter("chk_fm_nod_yd"));
	String via_nod_cd       = ((request.getParameter("chk_via_nod_cd")==null)?"":request.getParameter("chk_via_nod_cd"));
	String via_nod_yd       = ((request.getParameter("chk_via_nod_yd")==null)?"":request.getParameter("chk_via_nod_yd"));
	String dor_nod_cd       = ((request.getParameter("chk_dor_nod_cd")==null)?"":request.getParameter("chk_dor_nod_cd"));
	String dor_nod_yd       = ((request.getParameter("chk_dor_nod_yd")==null)?"":request.getParameter("chk_dor_nod_yd"));
	String to_nod_cd        = ((request.getParameter("chk_to_nod_cd")==null)?"":request.getParameter("chk_to_nod_cd"));
	String to_nod_yd        = ((request.getParameter("chk_to_nod_yd")==null)?"":request.getParameter("chk_to_nod_yd"));
	String trsp_dist_tp_cd  = ((request.getParameter("chk_trsp_dist_tp_cd")==null)?"":request.getParameter("chk_trsp_dist_tp_cd"));
	String trsp_agmt_dist   = ((request.getParameter("chk_trsp_agmt_dist")==null)?"":request.getParameter("chk_trsp_agmt_dist"));
	String dist_meas_ut_cd  = ((request.getParameter("chk_dist_meas_ut_cd")==null)?"":request.getParameter("chk_dist_meas_ut_cd"));

	try {
		SignOnUserAccount account	= (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   	userId						= account.getUsr_id();
	   	ofcCd						= account.getOfc_cd();

		serverException				= (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">
  var fm_nod_yd = "";
  function setupPage(){
    loadPage();

    var formObject = document.form;
    formObject.ufm_agmtno.value = "<%=agmt_no%>";
    formObject.ufm_trsp_agmt_rt_tp_cd.value = "<%=trsp_agmt_rt_tp_cd%>";
    formObject.ufm_trsp_cost_mod_cd.value = "<%=trsp_cost_mod_cd%>";
    formObject.ufm_agmt_trsp_tp_cd.value = "<%=agmt_trsp_tp_cd%>";
    formObject.ufm_cgo_tp_cd.value = "<%=cgo_tp_cd%>";
    formObject.ufm_cust_cd.value = "<%=cust_cd%>";
    formObject.ufm_cmdt_grp_cd.value = "<%=cmdt_grp_cd%>";
    formObject.ufm_rail_svc_tp_cd.value = "<%=rail_svc_tp_cd%>";

    formObject.fm_eq_knd_cd.value = "<%=eq_knd_cd%>";
    formObject.fm_fm_nod_cd.value = "<%=fm_nod_cd%>";
    formObject.fm_via_nod_cd.value = "<%=via_nod_cd%>";
    formObject.fm_dor_nod_cd.value = "<%=dor_nod_cd%>";
    formObject.fm_to_nod_cd.value = "<%=to_nod_cd%>";
    formObject.fm_trsp_dist_tp_cd.value = "<%=trsp_dist_tp_cd%>";
    formObject.fm_trsp_agmt_dist.value = "<%=trsp_agmt_dist%>";
    formObject.fm_dist_meas_ut_cd.value = "<%=dist_meas_ut_cd%>";

    getComboList(formObject.fm_fm_nod_cd, document.fm_fm_nod_yd, 'F');
    getComboList(formObject.fm_via_nod_cd, document.fm_via_nod_yd, 'V');
    getComboList(formObject.fm_dor_nod_cd, document.fm_dor_nod_yd, 'D');
    getComboList(formObject.fm_to_nod_cd, document.fm_to_nod_yd, 'T');
    formObject.fm_fm_nod_yd.CODE = "<%=fm_nod_yd%>";
    formObject.fm_via_nod_yd.CODE = "<%=via_nod_yd%>";
    formObject.fm_dor_nod_yd.CODE = "<%=dor_nod_yd%>";
    formObject.fm_to_nod_yd.CODE = "<%=to_nod_yd%>";
  }

</script>
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="fm_account_ofc_cd" value="<%=ofcCd%>" id="fm_account_ofc_cd" />
<input type="hidden" name="fm_account_usr_id" value="<%=userId%>" id="fm_account_usr_id" />

<input type="hidden" name="fm_agmtno" value="<%=agmt_no%>" id="fm_agmtno" />
<input type="hidden" name="fm_trsp_agmt_rt_tp_cd" value="<%=trsp_agmt_rt_tp_cd%>" id="fm_trsp_agmt_rt_tp_cd" />
<input type="hidden" name="fm_trsp_cost_mod_cd" value="<%=trsp_cost_mod_cd%>" id="fm_trsp_cost_mod_cd" />
<input type="hidden" name="fm_agmt_trsp_tp_cd" value="<%=agmt_trsp_tp_cd%>" id="fm_agmt_trsp_tp_cd" />
<input type="hidden" name="fm_cgo_tp_cd" value="<%=cgo_tp_cd%>" id="fm_cgo_tp_cd" />
<input type="hidden" name="fm_cust_cd" value="<%=cust_cd%>" id="fm_cust_cd" />
<input type="hidden" name="fm_cmdt_grp_cd" value="<%=cmdt_grp_cd%>" id="fm_cmdt_grp_cd" />
<input type="hidden" name="fm_rail_svc_tp_cd" value="<%=rail_svc_tp_cd%>" id="fm_rail_svc_tp_cd" />

<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="TRSP_SO_EQ_KIND" value="" id="TRSP_SO_EQ_KIND" />

<!-- page_title_area(S) -->
	<div class="page_title_area clear">

		<!-- page_title(S) -->
		<h2 class="page_title"><span>Agreement Rate History Inquiry</span></h2>
		<!-- page_title(E) -->
		
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" type="button" name="btn_retrieve" id="btn_retrieve">Retrieve</button>
		</div>
		<!-- opus_design_btn (E) -->
	</div>
	<!-- page_title_area(E) -->
<div id="MiniLayer" style="display:inline">
<!-- wrap_search(S) -->
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry">
			<table>
				<colgroup>
					<col width="70" />
					<col width="100" />					
					<col width="*" />				
			   </colgroup> 
			   <tbody>
					<tr>
						<th>Agreement No.</th>
                      	<td align="right"><input name="ufm_agmtno" id="ufm_agmtno" type="text" style="width:98px;" readonly></td>
                      	<td></td>
					</tr>
			   </tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
	<!-- wrap_search(E) -->

	<!-- wrap_result(S) -->
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<!-- opus_design_btn (E) -->
			<script type="text/javascript">ComSheetObject('sheet0');</script>		
		</div>
		<!-- opus_design_grid(E) -->
	</div>
	<!-- wrap_result(E) -->
</div>
</form>