<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_OPF_0020.jsp
*@FileTitle  : CBF for Partner Line’s Booking (Creation) 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/19
=========================================================
*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.event.VopOpf0020Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr"%>
<%
	VopOpf0020Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	String successFlag = "";
	String codeList    = "";
	String pageRows    = "100";
	String strUsr_id   = "";
	String strUsr_nm   = "";
	String upd_usr_id  = "";
	String upd_dt      = "";
	Logger log = Logger.getLogger("com.clt.apps.CargoLoadingPlanMgt.OwnContainerBookingForecastMgt");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (VopOpf0020Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		// adding logic to get data from server when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	} catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
<%=ConstantMgr.getCompanyCodeToJS()%>
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<form name="form">
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="pagerows" name="pagerows" type="hidden" />
<input id="cntr_tpsz_cd" name="cntr_tpsz_cd" type="hidden" />
<input id="cntr_grs_wgt" name="cntr_grs_wgt" type="hidden" />
<input id="cntr_qty" name="cntr_qty" type="hidden" />
<input id="full_mty_cd" name="full_mty_cd" type="hidden" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
	</h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn"><!--
	--><button type="button" id="btn_Retrieve" name="btn_Retrieve" class="btn_accent">Retrieve</button><!--
	--><button type="button" id="btn_New" name="btn_New" class="btn_normal">New</button><!--
	--><button type="button" id="btn_Save" name="btn_Save" class="btn_normal">Save</button>
	</div>
	<!-- opus_design_btn (E) -->
	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->

<div class="wrap_search_tab">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<tbody>
				<colgroup>
					<col width="50" />
					<col width="250" />
					<col width="50" />
					<col width="350" />
					<col width="50" />
					<col width="150" />
					<col width="*" />
				</colgroup>
				<tr>
					<th>VVD CD</th>
					<td><input id="vsl_cd" name="vsl_cd" required fullfill="" style="width:55px;" class="input1" value="" caption="VVD CD" maxlength="4" dataformat="engup" type="text" /><!--
					--><input id="skd_voy_no" name="skd_voy_no" required fullfill="" style="width:40px;" class="input1" value="" caption="VVD CD" maxlength="4" dataformat="num" type="text" /><!--
					--><input id="skd_dir_cd" name="skd_dir_cd" required fullfill="" style="width:20px;" class="input1" value="" caption="VVD CD" maxlength="1" dataformat="enguponly" type="text" /><!--
					--><button class="input_seach_btn" name="btn_vvd" id="btn_vvd" type="button"></button><input id="vsl_eng_nm" name="vsl_eng_nm" style="width:150px;" class="input2" value="" readonly="readonly" type="text" /></td>
					<th title="Port of Loading">POL</th>
					<td><script type="text/javascript">ComComboObject('yd_cd', 1, 80, 0);</script><input id="loc_nm" style="width: 70px;" class="input2" name="loc_nm" type="text" /><input id="yd_nm" style="width:180px;" class="input2" name="yd_nm" type="text" /></td>
					<th>ETA</th>
					<td><input id="eta" style="width: 110px;" class="input2" name="eta" type="text"/></td>
				</tr>
				<tr>
					<th>Lane</th>
					<td><input id="slan_cd" name="slan_cd" style="width: 40px;" class="input2" value="" readonly="readonly" type="text" /><input id="slan_nm" name="slan_nm" style="width: 247px;" class="input2" value="" readonly="readonly" type="text" />  </td>
					<th>Last Created</th>
					<td><input id="upd_usr_id" style="width: 70px; text-align:center;" class="input2" name="upd_usr_id" type="text" /><input id="upd_dt" style="width:110px;text-align:center;" class="input2" name="upd_dt" type="text" />  </td>
					<th>OPR</th>
					<td><input id="crr_cd" name="crr_cd" required style="width: 40px;" class="input1" value="" caption="Cargo OPR" maxlength="4" dataformat="engup" size="4" type="text" /><button class="input_seach_btn" name="btn_opr" id="btn_opr" type="button"></button></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td><button type="button" class="btn_etc" name="btn_LoadFile" id="btn_LoadFile">Load File</button><button type="button" class="btn_etc" name="btn_SummaryPreview" id="btn_SummaryPreview">Summary Preview</button></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<div class="wrap_result">
	<!-- opus_tab_btn(S) -->
		<div class="opus_design_tab">
			<script type="text/javascript">ComTabObject('tab1')</script>
		</div>
	<!-- opus_tab_btn(E) -->

	<div class="opus_design_grid" id="tabLayer">
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button type="button" id="t1btn_RowAdd" name="t1btn_RowAdd" class="btn_accent">Row Add</button><!--
			--><button type="button" id="t1btn_RowInsert" name="t1btn_RowInsert" class="btn_normal">Row Insert</button><!--
			--><button type="button" id="t1btn_Delete" name="t1btn_Delete" class="btn_normal">Row Delete</button><!--
			--><button type="button" id="t1btn_LoadFileTemplate" name="t1btn_LoadFileTemplate" class="btn_normal">Load File Template</button><!--
			--><button type="button" id="t1btn_WGPCalcu" name="t1btn_WGPCalcu" class="btn_normal">WGP Calcu. for Load File</button><!--
			--></div>
		<!-- opus_design_btn (E) -->
		<script type="text/javascript">ComSheetObject('t1sheet1');</script>
	</div>
	
	<div class="opus_design_grid" id="tabLayer">
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button type="button" id="t2btn_RowAdd" name="t2btn_RowAdd" class="btn_accent">Row Add</button><!--
			--><button type="button" id="t2btn_CntrAdd" name="t2btn_CntrAdd" class="btn_normal">CNTR Seq. Add</button><!--
			--><button type="button" id="t2btn_CgoAdd" name="t2btn_CgoAdd" class="btn_normal">CGO Seq. Add</button><!--
			--><button type="button" id="t2btn_RowCopy" name="t2btn_RowCopy" class="btn_normal">Row Copy</button><!--
			--><button type="button" id="t2btn_Delete" name="t2btn_Delete" class="btn_normal">Row Delete</button><!--
			--><button type="button" id="t2btn_LoadFileTemplate" name="t2btn_LoadFileTemplate" class="btn_normal">Load File Template</button><!--
			--></div>
		<!-- opus_design_btn (E) -->
		<script type="text/javascript">ComSheetObject('t2sheet1');</script>
	</div>
</div>	
</form>