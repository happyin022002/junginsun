<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : vop_opf_0054.jsp
*@FileTitle  : Stevedore Damage History
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/21
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.event.VopOpf0054Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopOpf0054Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.StevedoreDamageMgt.StevedoreDamageMgt");

	String stvDmgNo = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopOpf0054Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// adding logic to get data from server when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		stvDmgNo = request.getParameter("stv_dmg_no");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<!-- Input Box for Report Designer  -->
<input type="hidden" name="com_mrdPath" id="com_mrdPath" />
<input type="hidden" name="com_mrdArguments" id="com_mrdArguments" />
<input type="hidden" name="com_mrdSaveDialogDir" value="c:\\MyFolder\\" id="com_mrdSaveDialogDir" />
<input type="hidden" name="com_mrdSaveDialogFileName" value="StevedoreDamageHistory" id="com_mrdSaveDialogFileName" />
<input type="hidden" name="com_mrdSaveDialogFileExt" value="pdf" id="com_mrdSaveDialogFileExt" />
<input type="hidden" name="com_mrdSaveDialogFileExtLimit" value="xls@pdf@bmp@tif" id="com_mrdSaveDialogFileExtLimit" />
<input type="hidden" name="com_mrdDisableToolbar" id="com_mrdDisableToolbar" />
<input type="hidden" name="com_mrdTitle" value="Stevedore Damage History" id="com_mrdTitle" />
<input type="hidden" name="com_mrdBodyTitle" value="Stevedore Damage History" id="com_mrdBodyTitle" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><span>Stevedore Damage History</span></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Print" 			id="btn_Print">Print</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_Close" 		id="btn_Close">Close</button>		
	</div>
	<!-- opus_design_btn(E) -->
	
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="70">
				<col width="120">
				<col width="100">
				<col width="120">
				<col width="100">
				<col width="80">
				<col width="78">
				<col width="*">				
			</colgroup>
			<tbody>
				<tr class="h23">
					<th>VVD CD</th>
					<td><input type="text" name="vsl_cd" style="width:55px;" class="input2" readonly id="vsl_cd" /><input type="text" name="skd_voy_no" style="width:40px;" class="input2" readonly id="skd_voy_no" /><input type="text" name="skd_dir_cd" style="width:25px;" class="input2" readonly id="skd_dir_cd" /></td>
					<th>Port</th>
					<td><input type="text" name="vps_port_cd" style="width:100px;" class="input2" readonly id="vps_port_cd" /></td>
					<th>Damage Date</th>
					<td><input type="text" name="stv_dmg_evnt_dt" style="width:80px;" class="input2" readonly id="stv_dmg_evnt_dt" /></td>
					<th>Lane</th>
					<td><input type="text" name="slan_cd" style="width:40px;" class="input2" readonly id="slan_cd" /></td>
				</tr>
			</tbody>
		</table>
		<table>
			<colgroup>				
				<col width="70">
				<col width="120">
				<col width="100">
				<col width="120">
				<col width="150">
				<col width="*">				
			</colgroup> 
			<tbody>
				<tr class="h23">
					<th>SDMS No.</th>
					<td><input type="text" name="stv_dmg_no" style="width:128px;" class="input2" value="<%=StringUtil.xssFilter(stvDmgNo)%>" readonly id="stv_dmg_no" /></td>
					<th>Report No.</th>
					<td><input type="text" name="stv_dmg_ref_no" style="width:100px;" class="input2" readonly id="stv_dmg_ref_no" /></td>
					<th>Claim Handling Office</th>
					<td><input type="text" name="clm_hndl_ofc_cd" style="width:155px;" class="input2" readonly id="clm_hndl_ofc_cd" /></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">	
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear" name="tabLayer" id="tabLayer">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->	
	
</div>
</form>