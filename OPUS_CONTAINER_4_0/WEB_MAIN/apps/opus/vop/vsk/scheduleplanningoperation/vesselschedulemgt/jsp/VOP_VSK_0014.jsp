<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_VSK_0014.jsp
*@FileTitle  : Coastal SKD Creation by VVD
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/30
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk0014Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopVsk0014Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB ResultSet list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.VSKCommon.VSKCodeFinder");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopVsk0014Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="loc_cd" id="loc_cd" />
<input type="hidden" name="vps_port_cd" id="vps_port_cd" />
<input type="hidden" name="clpt_seq" id="clpt_seq" />
<input type="hidden" name="vps_etb_dt" id="vps_etb_dt" />
<input type="hidden" name="vsl_svc_tp_cd" id="vsl_svc_tp_cd" />
<input type="hidden" name="vsl_slan_dir_cd" id="vsl_slan_dir_cd" />
<input type="hidden" name="act_arr_dt" id="act_arr_dt">
<input type="hidden" name="pre_port_cd" id="pre_port_cd">
<input type="hidden" name="pre_etd_dt" id="pre_etd_dt">
<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
	<button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!--
	--><button class="btn_normal" name="btn_new" id="btn_new" type="button">New</button><!--
	--><button class="btn_normal" name="btn_save" id="btn_save" type="button">Save</button><!--
	--><button class="btn_normal" name="btn_pfsked" id="btn_pfsked" type="button">P/F SKD Use</button><!--
	--></div>
	<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->
<!-- wrap_search(S) -->
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<table>
			<colgroup>
				<col width="85" />				
				<col width="160" />				
				<col width="75" />				
				<col width="90" />				
				<col width="90" />				
				<col width="90" />				
				<col width="91" />				
				<col width="*" />				
		   </colgroup>
		   <tbody>
		   		<tr>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input type="text" name="vsl_cd" style="width:45px;text-align:center;ime-mode:disabled;" class="input1" dataformat="engup" value="" maxlength="4" onfocus="this.select();" id="vsl_cd" /><!-- 
						 --><input type="text" name="skd_voy_no" style="width:45px;text-align:center;ime-mode:disabled;" dataformat="num" class="input1" value="" maxlength="4" onfocus="this.select();" id="skd_voy_no" /><!-- 
						 --><input type="text" name="skd_dir_cd" style="width:20px;text-align:center;ime-mode:disabled;"  dataformat="engup" class="input1" value="" maxlength="1" onfocus="this.select();" id="skd_dir_cd" /><button type="button" id="btn_vvd_search" name="btn_vvd_search" class="input_seach_btn"></button></td>
					<th>Lane Code</th>
					<td><input type="text" name="vsl_slan_cd" style="width:45px;text-align:center;ime-mode:disabled;" dataformat="engup" class="input1" value="" maxlength="3" onfocus="this.select();" id="vsl_slan_cd" /><button type="button" id="btn_vsl_slan_cd" name="btn_vsl_slan_cd" class="input_seach_btn"></button></td>
					<th>P/F SKD Type</th>
					<td><script type="text/javascript">ComComboObject('pf_svc_tp_cd',2,70,1,0);</script></td>
					<th>Created Date</th>
					<td><input type="text" id="cre_dt"     name="cre_dt"     style="width:130px;" class="input2" value="" readonly="readonly" />
					    <input type="text" id="cre_usr_id" name="cre_usr_id" style="width:90px;"  class="input2" value="" readonly="readonly" />
					</td>
					<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<th>Updated Date</th>
					<td><input type="text" id="upd_dt"     name="upd_dt"     style="width:130px;" class="input2" value="" readonly="readonly"  />
					    <input type="text" id="upd_usr_id" name="upd_usr_id" style="width:90px;"  class="input2" value="" readonly="readonly"  /> 
					</td>
		   		</tr>
		   </tbody>
		</table>
		<table>
			<colgroup>
				<col width="85" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
					<th>Remark(s)</th>
					<td><textarea style="ime-mode:disabled;width:825px; height:50px;resize:none" name="skd_rmk" id="skd_rmk"></textarea></td>
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
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn_add" id="btn_add" type="button">Row Add</button><!--
			--><button class="btn_normal" name="btn_insert" id="btn_insert" type="button">Row Insert</button><!--
			--><button class="btn_normal" name="btn_del" id="btn_del" type="button">Row Delete</button><!--
			--></div>
		<!-- opus_design_btn (E) -->
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->
</div>
<!-- wrap_result(E) -->
</form>