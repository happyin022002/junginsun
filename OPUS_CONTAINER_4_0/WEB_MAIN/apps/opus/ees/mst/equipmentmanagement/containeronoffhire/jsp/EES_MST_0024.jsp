<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ees_mst_0024.jsp
*@FileTitle  : Container Status Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/04
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.event.EesMst0024Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.OfficeCodeMgr"%>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr"%>

<%
	EesMst0024Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_off_cd = "";
	Logger log = Logger.getLogger("com.clt.apps.EquipmentManagement.ContainerOnOffHire");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_off_cd = account.getOfc_cd();
		event = (EesMst0024Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		// adding logic to get data from server when first loading ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	} catch(Exception e) {
		out.println(e.toString());
	}
	String st_cd    = JSPUtil.getCodeCombo("st_cd", "", "width='80' class='input1' style='text-align:center'", "CD20096", 0, "");
%>


<script type="text/javascript">
<%=OfficeCodeMgr.getOfficeCodeListToJS("000001", "LSE")%>
<%=ConstantMgr.getBaseLocationCodeToJS()%>

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="hidden_curdate" id="hidden_curdate" />
<input type="hidden" name="hid_cntr_no" id="hid_cntr_no" />
<input type="hidden" name="usr_ofc_cd" value="<%= strUsr_off_cd %>" id="usr_ofc_cd" />

<input type="hidden" name="eff_dt" id="eff_dt" />
<input type="hidden" name="exp_dt" id="exp_dt" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--  
		--><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--
		--><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button>
	</div>
	<!-- opus_design_btn(E) -->
	<div class="location"><span id="navigation"></span></div>
	
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry wFit">
	<table>
		<tbody>
			<colgroup>
				<col width="10px" />
				<col width="50px" />
				<col width="200px" />
				<col width="50px" />
				<col width="150px" />
				<col width="50px" />
				<col width="100px"/>
				<col width="105px"/>
				<col width="95px"/>
				<col width="*" />
			</colgroup>
			<tr>
				<td></td>
				<th>Status Code</th>
				<!--  
				<select style="width: 70px;" class="input1" name="st_cd" id="st_cd" style="text-align:center">
						<option value="0" selected >LSO</option>
						<option value="1" >SBO</option>
						<option value="2" >SBI</option>
						<option value="3" >MUO</option>
						<option value="4" >MUI</option>
						<option value="5" >SRO</option>
						<option value="6" >SRI</option>
				</select> 
				-->
				<td><%=st_cd%></td>
				<th>Date</th>
				<td><input type="text" style="width: 80px;text-align:center;" class="input1" dataformat="ymd" name="hire_date" maxlength="10" id="hire_date" /><button type="button" id="cal_img" name="cal_img" class="calendar ir"></button></td>
				<th>Yard</th>
				<td colspan="3"><input type="text" style="width: 105px;text-align:center;" class="input1" dataformat="engup" name="sts_evnt_yd_cd" id="sts_evnt_yd_cd" maxlength="7" id="sts_evnt_yd_cd" /><!-- 
				--><button type="button" id="ComOpenPopupWithTargetYard" name="ComOpenPopupWithTargetYard" class="input_seach_btn"></button><!-- 
				--><input type="text" style="width: 225px;" class="input2" readonly value="" name="yd_cd_nm" id="yd_cd_nm" /></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<th>AGMT No.</th>
				<td><input type="text" style="width: 40px;" class="input" dataformat="engup" name="agmt_cty_cd" maxlength="3" value="HHO" id="agmt_cty_cd" disabled="disabled"/><input type="text" style="width: 80px;" class="input" dataformat="num" name="agmt_seq" maxlength="6" id="agmt_seq" /><button type="button" id="ComOpenPopupWithTargetAgmtNo" name="ComOpenPopupWithTargetAgmtNo" class="input_seach_btn"></button></td>
				<th>Contract No.</th>
				<td><input type="text" style="width: 109px;" class="input2" dataformat="engup" value="" readonly name="ref_no" maxlength="12" id="ref_no" /></td>
				<th>Lessor</th>
				<td colspan="3"><input type="text" style="width: 50px;" class="input2" name="vndr_seq" dataformat="engup" readonly maxlength="6" id="vndr_seq" /><input type="text" style="width: 50px;" readonly class="input2" name="vndr_abbr" id="vndr_abbr" /><input type="text" style="width: 255px;" class="input2" name="vndr_nm" readonly id="vndr_nm" /></td>
				<td></td>
			</tr>
			<tr id="auth_display" style="display:none">
				<td></td>
				<th>Auth No.</th>
				<td><script type="text/javascript">ComComboObject('approval_no', 16, 160, 1);</script></td>
				<th>TP/SZ</th>
				<td><input type="text" style="width:73px;text-align:center;" class="input2"  value=""  ReadOnly name="tpsz_cd" id="tpsz_cd"></td>
				<th>Auth Vol.</th>
				<td><input type="text" style="width:73px;text-align:right;" class="input2"   value="" ReadOnly name="approval_vol" id="approval_vol"></td>
				<th>Pick up Vol.</th>
				<td><input type="text" style="width:75px;text-align:right;" class="input2" value=""  ReadOnly name="pick_up_vol" id="pick_up_vol"></td>
				<th>Pick up Period</th>
				<td><input type="text" style="width: 75px;text-align:center;" class="input2"  value="" ReadOnly name="pkup_fm_dt" id="pkup_fm_dt">~&nbsp;<!--
                --><input type="text" style="width: 75px;text-align:center;" class="input2"  value="" ReadOnly name="pick_up_due_date" id="pick_up_due_date"></td>
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
	    <div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_master" id="btn_master">Master</button>
			<button type="button" class="btn_normal" name="btn_add" id="btn_add">Row Add</button>
			<button type="button" class="btn_normal" name="btn_loadexcel" id="btn_loadexcel">Load Excel</button>
			<button type="button" class="btn_normal" name="btn_delete" id="btn_delete">Delete</button>
		</div>	
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
	 <!-- opus_design_grid(S) -->
	<div class="opus_design_grid wFit" style="display: none;">
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
	<!-- opus_design_grid(E) -->	
</div>        
</form>