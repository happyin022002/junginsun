<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0003.jsp
*@FileTitle  : CY & Door S/O Creation Detail Input
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/05
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.trs.cydoorsomanage.singletransportationsomanage.event.EsdTrs0002Event"%>
<%
	EsdTrs0002Event  			event 				= null;
	Exception 					serverException   	= null;
	DBRowSet 					rowSet	  			= null;
	String 						strErrMsg 			= "";
	int 						rowCount	 		= 0;
	String 						trsp_crr_mod_cd 	= "";
	String 						dor_svc_tp_cd 		= "";
	String	sCostModeCd		= JSPUtil.getNull(request.getParameter("cost_mode_cd")		);
	try {
		trsp_crr_mod_cd  = JSPUtil.getCodeCombo("trsp_crr_mod_cd", "01", "style='width:150'", "CD00283", 0, "");
		if( !"CY".equals(sCostModeCd) )		dor_svc_tp_cd  = JSPUtil.getCodeCombo("dor_svc_tp_cd", "01", "style='width:150'", "CD00284", 0, "");
		event = (EsdTrs0002Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">
<!--
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		}
		getParamInfo();
		loadPage();
	}
//-->
</script>
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="CONTI_CD" id="CONTI_CD" />
<input type="hidden" name="act_cust_cnt_cd" id="act_cust_cnt_cd" />
<input type="hidden" name="act_cust_seq" id="act_cust_seq" />
<input type="hidden" name="act_cust_addr_seq" id="act_cust_addr_seq" />
<input type="hidden" name="factory_zip_code" id="factory_zip_code" />
<input type="hidden" name="factory_addr" id="factory_addr" />
<input type="hidden" name="factory_tel_no" id="factory_tel_no" />
<input type="hidden" name="factory_fax_no" id="factory_fax_no" />
<input type="hidden" name="pic_nm" id="pic_nm" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><span>Detail Input</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
    <div class="opus_design_btn">
    	<button type="button" class="btn_accent" name="btn_apply" id="btn_apply">Apply</button><!-- 
     --><button type="button" class="btn_normal"  name="btn_close" id="btn_close">Close</button>
    </div>
	 <!-- opus_design_btn(E) -->
</div>

<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_data">
			 <table> 
	            <colgroup>
	                <col width="70">
	                <col width="*">
	            </colgroup>
	            <tbody>
		             <tr>
							<th>Cost Mode</th>
							<td>
								<input name="trsp_cost_dtl_mod_cd" id="trsp_cost_dtl_mod_cd" type="text" style="width:260px;" value="" disabled>
							</td>
						</tr>
				</tbody>
			</table>
			<table class="line_bluedot"><tr><td></td></tr></table>
			<table class="grid_2"> 
				<colgroup>
	                <col width="160">
	                <col width="180">
	                <col width="100">
	                <col width="160">
	                <col width="*">
	            </colgroup>
	            <tbody>
	          		<tr>
						<th></th>
						<th colspan="2"><strong>Preset (From COP)</strong></th>
						<th colspan="2" ><strong>Actual</strong></th>
					</tr>
					<tr>
						<th><b>From Node</b></th>
						<td><input name="old_fm_nod_cd" id="old_fm_nod_cd" type="text" class="noinput" style="width:170px;" disabled></td>
						<td><input name="old_fm_nod_yard" id="old_fm_nod_yard" type="text" class="noinput" style="width:90px;" disabled></td>
						<td><input name="fm_nod_cd"  id="fm_nod_cd" type="text" class="noinput" style="width:155px;" value="" onChange="getComboList(this, fm_nod_yard, 'F');" maxlength="5" dataformat="engup"></td>
						<td><script type="text/javascript">ComComboObject('fm_nod_yard', 1, 78, 0)</script><!-- 
							 --><button type="button" class="input_seach_btn" name="btns_frmnode" id="btns_frmnode"></button>
						</tr>
					<tr>
						<th><strong>Via Node</strong></th>
						<td><input name="old_via_nod_cd" id="old_via_nod_cd" type="text" class="noinput" style="width:170px;" disabled></td>
						<td><input name="old_via_nod_yard" id="old_via_nod_yard" type="text" class="noinput" style="width:90px;" disabled></td>
						<td><input name="via_nod_cd" id="via_nod_cd" type="text" class="noinput" style="width:155px;" value="" onChange="getComboList(this, via_nod_yard, 'V');" maxlength="5" dataformat="engup"></td>
						<td><script type="text/javascript">ComComboObject('via_nod_yard', 1, 78, 0)</script><!-- 
							 --><button type="button" class="input_seach_btn" name="btns_vianode" id="btns_vianode"></button>
						</tr>
					<tr>
						<th><strong>To Node</strong></th>
						<td><input name="old_to_nod_cd" id="old_to_nod_cd" type="text" class="noinput" style="width:170px;" disabled></td>
						<td><input name="old_to_nod_yard"  id="old_to_nod_yard" type="text" class="noinput" style="width:90px;" disabled></td>
						<td><input name="to_nod_cd" id="to_nod_cd" type="text" class="noinput" style="width:155px;" value="" onChange="getComboList(this, to_nod_yard, 'T');" maxlength="5" dataformat="engup"></td>
						<td><script type="text/javascript">ComComboObject('to_nod_yard', 1, 78, 0)</script><!-- 
							 --><button type="button" class="input_seach_btn" name="btns_tonode" id="btns_tonode"></button>
					</tr>
					<tr>
						<th><strong>Door Location</strong></th>
						<td><input name="old_dor_nod_cd" id="old_dor_nod_cd" type="text" class="noinput" style="width:170px;" disabled></td>
						<td><input name="old_dor_nod_yard" id="old_dor_nod_yard" type="text" class="noinput" style="width:90px;" disabled></td>
						<td><input name="dor_nod_cd" id="dor_nod_cd" type="text" class="noinput" style="width:155px;" value="" onChange="getComboList(this, dor_nod_yard, 'D');" maxlength="5" dataformat="engup"></td>
						<td><%
								if( !"CY".equals(sCostModeCd) )	{
							%><script type="text/javascript">ComComboObject('dor_nod_yard', 1, 78, 0)</script><%
								}
							%><button type="button" class="input_seach_btn" name="btns_dorloc" id="btns_dorloc"></button>
					</tr>
					<tr>
						<th><strong>Actual Customer</strong></th><!--old no-->
						<td colspan="2"><input name="factory_nm" id="factory_nm" type="text" class="noinput" style="width:270px;" value=""></td>
						<td colspan="2"><input name="act_cust_cd" id="act_cust_cd" type="text" class="noinput" style="width:242px;" value=""><!-- 
							 --><button type="button" class="input_seach_btn" name="btns_actualcust" id="btns_actualcust"></button>
					</tr>
					<tr>
						<th><strong>Door Service Type</strong></th><!--old no-->
						<td colspan="2"><input name="org_dor_svc_tp_cd" id="org_dor_svc_tp_cd" type="text" class="noinput" style="width:270px;" disabled></td>
						<td colspan="2"  style="padding-left:3;width:150px"><%=dor_svc_tp_cd%></td>
					</tr>

					<tr>
						<th><strong>Trans Mode</strong></th>
						<td colspan="2"><input name="org_trsp_crr_mod_cd" id="org_trsp_crr_mod_cd" type="text" class="noinput" style="width:270px;" disabled></td>
						<td colspan="2" style="padding-left:3;width:150px"><%=trsp_crr_mod_cd%></td>
						</tr>
					<tr>
						<th><strong>Remarks</strong></th>
						<td colspan="4"><input name="remark" id="remark" type="text" class="noinput" style="width:99%;" value=""></td>
					</tr>
				</tbody>
			</table>
		</div>   
		<!-- opus_design_inquiry(E) -->
</div>
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="mainTable" >	
		<script type="text/javascript">ComSheetObject('sheet');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>