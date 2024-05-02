<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ees_mnr_0215.js
*@FileTitle  : MNR Local Tariff Creation & Verify
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/13
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.event.EesMnr0215Event"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnr0215Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Occurred error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//Row count of retrieved database data

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	String trf_no			= "";
	if(request.getParameter("trf_no")!=null){
		trf_no = StringUtil.xssFilter(request.getParameter("trf_no"));
	}

	Logger log = Logger.getLogger("com.clt.apps.AgreementManage.TariffMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();


		event = (EesMnr0215Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//Extracting retrieved data from server on load screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

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

<div style="display:none">
	<script language="javascript">ComSheetObject('sheet1');</script>
</div>

<form name="form">
	<input type="hidden" name="f_cmd">
	<input type="hidden" name="pagerows">
	
	<!-- page_title_area(S) -->
	<div class="layer_popup_title">
		<div class="page_title_area clear">
			<!-- page_title(S) -->
			<h2 class="page_title"><span>Tariff Detail Information</span></h2>
			<!-- page_title(E) -->
			
			<!-- opus_design_btn (S) -->
			<div class="opus_design_btn">
				<button class="btn_accent" name="btn_DownExcel" id="btn_DownExcel" type="button">Down Excel</button><!--
				--><button class="btn_normal" name="btn_Close" id="btn_Close" type="button">Close</button><!--
				--></div>
			<!-- opus_design_btn (E) -->
		</div>
	</div>
	
	<div class="layer_popup_contents">
		<div class="wrap_search">
			<div class="opus_design_inquiry wFit">
				<table>
					<colgroup>
						<col width="70" >
						<col width="150" >
						<col width="*" />
					</colgroup>
					<tbody>
						<tr>
							<th>Tariff No.</th>
							<td><input name="search_trf_no" type="text" style="width:130px;" class="input2" value="<%=trf_no%>" id="search_trf_no" /></td>
							<td></td>
						</tr>
					</tbody>
				</table>
				<table>
					<colgroup>
						<col width="70">
						<col width="120">
						<col width="100">
						<col width="150">
						<col width="100">
						<col width="300">
						<col width="70">
						<col width="150">
						<col width="*">
					</colgroup>
					<tbody>
						<tr >
							<th>Eff. from </th>
							<td><input type="text" name="eff_dt" style="width:80px;text-align:center" class="input2" id="eff_dt" /></td>
							<th>Tariff Office</th>
							<td><input type="text" name="rqst_ofc_cd" style="width:70px;" class="input2" id="rqst_ofc_cd" /></td>
							<th>S/Provider Code</th>
							<td><input type="text" name="vndr_seq" style="width:60px;text-align:center" class="input2" dataformat="num" maxlength="6" id="vndr_seq" /><input type="text" name="vndr_nm" style="width:180px;" class="input2" readonly="readonly" id="vndr_nm" /></td>
							<th>Status</th>
							<td><script type="text/javascript">ComComboObject('combo1', 1, 145, 1, 0);</script></td>
							<td></td>
						</tr>
					</tbody>
				</table>
				<table>
					<colgroup>
						<col width="70">
						<col width="120">
						<col width="100">
						<col width="122">
						<col width="106">
						<col width="100">
						<col width="70">
						<col width="123">
						<col width="70">
						<col width="150">
						<col width="*">
					</colgroup>
					<tbody>
						<tr >
							<th>EQ Type </th>
							<td><script type="text/javascript">ComComboObject('combo2', 1, 80, 1, 0);</script></td>
							<th>Unit Of Measure</th>
							<td><script type="text/javascript">ComComboObject('combo3', 1, 70, 1, 0);</script></td>
							<th>Currency</th>
							<td><script type="text/javascript">ComComboObject('combo4', 1, 80, 1, 0);</script></td>
							<th>Creation Date</th>
							<td><input type="text" name="cre_dt" style="width:80px;text-align:center" class="input2" readonly="readonly" id="cre_dt" /></td>
							<th>Creation User</th>
							<td><input type="text" name="cre_usr_id" style="width:145px;text-align:left" class="input2" readonly="readonly" id="cre_usr_id" /></td>
							<td></td>
						</tr>
					</tbody>
				</table>
				
			</div>
		</div>
		<div class="wrap_result">
			<div class="opus_design_tab">
				<script type="text/javascript">ComTabObject('tab1')</script>
			</div>
			<!-- TAB Dry All (S) -->
			<div id="tabLayer" style="display:inline">
				<div class="opus_design_grid">
					<script type="text/javascript">ComSheetObject('t1sheet1');</script>
				</div>
			</div>
			<!-- TAB Dry All (E) -->
			
			<!-- TAB Reefer Box (S) -->
			<div id="tabLayer" style="display:none">
				<div class="opus_design_grid">
					<script type="text/javascript">ComSheetObject('t2sheet1');</script>
				</div>
			</div>
			<!-- TAB Reefer Box (E) -->
			
			
			<!-- TAB Reefer Unit (S) -->
			<div id="tabLayer" style="display:none">
				<div class="opus_design_grid">
					<script type="text/javascript">ComSheetObject('t3sheet1');</script>
				</div>
			</div>
			<!-- TAB Reefer Box (E) -->
			
			<!-- TAB Reefer Unit (S) -->
			<div id="tabLayer" style="display:none">
				<div class="opus_design_grid">
					<script type="text/javascript">ComSheetObject('t4sheet1');</script>
				</div>
			</div>
			<!-- TAB Reefer Box (E) -->
			
			<!-- TAB Chassis (S) -->
			<div id="tabLayer" style="display:none">
				<div class="opus_design_grid">
					<script type="text/javascript">ComSheetObject('t5sheet1');</script>
				</div>
			</div>
			<!-- TAB Chassis (E) -->
			<!-- TAB MG Set (S) -->
			<div id="tabLayer" style="display:none">
				<div class="opus_design_grid">
					<script type="text/javascript">ComSheetObject('t6sheet1');</script>
				</div>
			</div>
			<!-- TAB MG Set (E) -->
			<table class="line_bluedot"><tr><td></td></tr></table>
			<table class="grid_2">
			<table>
				<colgroup>
					<col width="100" >
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<th>Remark(s)</th>
						<td><textarea name="mnr_trf_rmk" wrap="off" style="width:100%;height:60px;resize:none" readOnly></textarea></td>
					</tr>
				</tbody>
			</table>
			</table>
		</div>
	</div>
</form>
