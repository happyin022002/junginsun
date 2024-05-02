<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0408.jsp
*@FileTitle  : In-Bond Arrival Manifest (Container Tab)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/06
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page
	import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page
	import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page
	import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page
	import="com.clt.apps.opus.esm.bkg.customsdeclaration.inbondtransmission.usa.event.EsmBkg0408Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0408Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //error from server
	String strErrMsg = ""; //error message

	String strUsr_id = "";
	String strUsr_nm = "";

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0408Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}

		
	} catch (Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			//showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" 		id="f_cmd"> 
<input type="hidden" name="pagerows" 	id="pagerows">
<input type="hidden" name="page_no" 	id="page_no" 		value="ESM_BKG_0408">
<input type="hidden" name="h_vvd" 		id="h_vvd"			value="">
<input type="hidden" name="h_pod" 		id="h_pod" 			value="">
<input type="hidden" name="h_del" 		id="h_del" 			value="">
<input type="hidden" name="h_hub" 		id="h_hub" 			value="">
<input type="hidden" name="h_cstms" 	id="h_cstms" 		value="">
<input type="hidden" name="hubModifyYn" id="hubModifyYn" 	value="">
<input type="hidden" name="cstmsModifyYn" id="cstmsModifyYn" 	value="">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" 		id="btn_Retrieve">Retrieve</button><!--  
		--><button type="button" class="btn_normal" name="btn_Save" 			id="btn_Save">Save</button><!-- 		
		--><button type="button" class="btn_normal" name="btn_PMibAssign" 		id="btn_PMibAssign">P/MIB Assign</button><!-- 		
		--><button type="button" class="btn_normal" name="btn_Transmit" 		id="btn_Transmit">Transmit</button><!-- 
		--><button type="button" class="btn_normal" name="btn_EntryTypeSetUp" 	id="btn_EntryTypeSetUp">Entry Type Set-up</button>	
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry wFit">
	<table>
		<tbody>
			<colgroup>
				<col width="40px"/>
				<col width="100px"/>
				<col width="40px"/>
				<col width="70px"/>
				<col width="90px"/>
				<col width="60px"/>
				<col width="15px"/>
				<col width="80px"/>
				<col width="*" />
		   </colgroup>
			<tr class="h23">
				<th style="text-align:left;">VVD</th>
				<td>
					<input type="text" name="vvd" id="vvd" class="input1" style="width:80px; ime-mode:disabled;" maxlength="9" value="" dataformat="engup" required>
				</td>
				<th title="Port of Discharging">POD</th>
				<td>
					<input type="text" name="pod" id="pod" class="input1" style="width:50px; ime-mode:disabled;" maxlength="5" value="" dataformat="engup" required>
				</td>
				<th>In-bond Type</th>
				<td>
					<select name="ibd_tp_cd" id="ibd_tp_cd" style="width:80px;"class="input1">
						<option value="" selected>ALL</option>
						<option value="61">IT(61)</option>
						<option value="62">T&E(62)</option>
						<option value="63">IE(63)</option>
					</select>
				</td>
				<td></td>
				<td>
					<button type="button" class="btn_etc" name="btn_Mi_History" id="btn_Mi_History">MI History</button>
				</td>
				<td></td>
			</tr>
		</tbody>
	</table>
</div>
<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
<!-- opus_design_grid(S) -->	
<div class="opus_design_grid">
	<script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
<!-- opus_design_grid(E) -->

<!-- opus_tab_btn(S) -->
<div class="opus_design_tab">
	<script type="text/javascript">ComTabObject('tab1')</script>
</div>
<!-- opus_tab_btn(E) -->

<!-- opus_design_grid(S) -->
<div class="opus_design_grid clear" name="tabLayer" id="tabLayer">
	<div class="opus_design_btn">
		<button type="button" class="btn_normal" name="btn_Bl_Inquiry1" id="btn_Bl_Inquiry1">Manifest(B/L)</button>
		<button type="button" class="btn_normal" name="btn_Cntr_Inquiry1" id="btn_Cntr_Inquiry1">C/M Inquiry</button>
		<button type="button" class="btn_normal" name="btn_DownExcel1" id="btn_DownExcel1">Down Excel</button>
	</div>
	<script type="text/javascript">ComSheetObject('t1sheet1');</script>
</div>
<div class="opus_design_grid clear" name="tabLayer" id="tabLayer">
	<div class="opus_design_btn">
		<button type="button" class="btn_normal" name="btn_Bl_Inquiry2" id="btn_Bl_Inquiry2">Manifest(B/L)</button>
		<button type="button" class="btn_normal" name="btn_Cntr_Inquiry2" id="btn_Cntr_Inquiry2">C/M Inquiry</button>
		<button type="button" class="btn_normal" name="btn_DownExcel2" id="btn_DownExcel2">Down Excel</button>
	</div>
	<script type="text/javascript">ComSheetObject('t2sheet1');</script>
</div>	
<div class="opus_design_grid" style="display:none">
	<script type="text/javascript">ComSheetObject('sheet4');</script>
</div>
<!-- opus_design_grid(E) -->	
</div>
</form>