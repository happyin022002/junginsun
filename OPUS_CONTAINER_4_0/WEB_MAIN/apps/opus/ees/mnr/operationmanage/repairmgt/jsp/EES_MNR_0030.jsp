<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   EES_MNR_0030.jsp
*@FileTitle  : W/O Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/15
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.event.EesMnr0030Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnr0030Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//Error message
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		event = (EesMnr0030Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	} catch(Exception e) {
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

<!-- <body  onLoad="setupPage();">  -->
<form name="form"> 
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="cost_ofc_cd" id="cost_ofc_cd" value="<%= strOfc_cd%>">
<input type="hidden" name="vndr_seq" id="vndr_seq">
<input type="hidden" name="status" id="status">
<input type="hidden" name="selected_vndr_seq" id="selected_vndr_seq">
<input type="hidden" name="mnr_wo_tp_cd" id="mnr_wo_tp_cd" value="EST">
<input type="hidden" name="sel_type" id="sel_type" value="M">
<input type="hidden" name="pagerows" id="pagerows">
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
	</h2>
<!-- page_title(E) -->
<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrive" id="btn_retrive">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_Creation" id="btn_Creation">W/O Creation</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_DocSend" id="btn_DocSend">W/O Send</button>
	</div>
<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
	<!-- page_location(S) -->
</div>
<!-- page_location(E) -->
<!-- opus_design_inquiry(S) -->
<div class= "wrap_search">
	<div class= "opus_design_inquiry wFit">
		<table>
			<tbody>
				<colgroup>
					<col width="100"/>
					<col width="180"/>
					<col width="70"/>
					<col width="160"/>
					<col width="90"/>
					<col width="180"/>
					<col width="90"/>
					<col width="*" />
				</colgroup>
					<tr>
						<th>Status</th>
						<td><script type="text/javascript">ComComboObject('comboStatus', 1, 120, 1, 1);</script></td>
						<th>EQ Type</th>
						<td><script type="text/javascript">ComComboObject('eq_knd_cd', 1, 100, 1, 1);</script></td>	
						<th>Approval Date</th>
						<td><input type="text" name="apro_dt_fr" id="apro_dt_fr" style="width:75px" class="input1" caption="from date" requred dataformat="ymd" maxlength="10" cofield="apro_dt_to"><!--
						--><span class="dash">~</span><!--
						--><input type="text" name="apro_dt_to" style="width:75px" class="input1" caption="to date" requred dataformat="ymd" maxlength="10" cofield=apro_dt_fr><!--
						--><button type="button" class="calendar ir" name="apro_dt_cal" id="apro_dt_cal"></button></td>
					</tr> 
					<tr>
						<th>Service Provider</th> 
						<td><script type="text/javascript">ComComboObject('comboVndrSeq', 8, 170, 1, 0,0,false,1);</script></td>
						<th>W/O No.</th>
						<td><input type="text" name="wo_no" id="wo_no" style="width:120px;" class="input" dataformat="engup" maxlength="200"><!--
						--><button type="button" name="wo_no_popup" id="wo_no_popup" class="input_seach_btn" onClick="openPopup('cust_cd')"></button></td>
						<th>EQ No.</th>
						<td><input type="text" name="rqst_eq_no" id="rqst_eq_no" style="width:90px" class="input" dataformat="engup" maxlength="20"></td>
						<th>Cost Code</th> 
						<td>
						<script  type="text/javascript">ComComboObject('cost_cd',3, 200, 1, 0,2);</script>
						</td>
					</tr> 
			</tbody>		
		</table>	
	</div>
</div>
<div class="wrap_result">
		<div class="layout_wrap">
			<div class="layout_flex_fixed" style="width:520px">
				<div class="opus_design_grid">
					<h3 class="title_design mar_btm_8">Repair Work Order List</h3>
					<script type="text/javascript">ComSheetObject('sheetMaster');</script>
				</div>
			</div>
			<div class="layout_flex_flex" style="padding-left:528px;">
				<div class="opus_design_grid">
					<div class="opus_design_btn">
						<button type="button" class="btn_normal" name="btn_Detail" id="btn_Detail">Detail</button><!--
						--><button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">DownExcel</button>
					</div>
					<script type="text/javascript">ComSheetObject('sheetDetail');</script>
				</div>
			</div>
		</div>
</div>
</form>
