<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SPC_0044.jsp
*@FileTitle  : Allocation Control by Main Office
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/24
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.event.EsmSpc0044Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%

	String pop_vvd = JSPUtil.getParameter(request, "vvd"   , "");
	String pop_ofc = JSPUtil.getParameter(request, "office", "");

	EsmSpc0044Event event 		= null;			//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.SpaceAllocationManage.SpaceAllocationManage");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmSpc0044Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		
	}catch(Exception e) {
		out.println(e.toString());
	}
	
	String ofc_cd = event.getSignOnUserAccount().getOfc_cd();
	String rmkFlg = "N";
	
	GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	
	if (serverException == null) {
		// Extracting the data gotten from serve while initial loading ..
		rmkFlg  = eventResponse.getETCData("rmkFlg");
	}
%>

<script type="text/javascript">
    var pop_vvd = "<%=pop_vvd%>";
    var pop_ofc = "<%=pop_ofc%>";
    var rmkFlg  = "<%=rmkFlg%>";
    
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<!-- <form name="form" onsubmit="return false;" onKeyDown="spcKeyAction('ESM_SPC_0044');"> -->
<form name="form" onsubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">

<input type="hidden" name="uiname" id="uiname" value="ESM_SPC_0044">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button" alt="Alt+R">Retrieve</button><!--
		--><button class="btn_normal" name="btn_new" id="btn_new" type="button" alt="Alt+N">New</button><!--
		--><button class="btn_normal" name="btn_save" id="btn_save" type="button">Save</button><!--
		--><button class="btn_normal" name="btn_downexcel" id="btn_downexcel" type="button">Down Excel</button>
	</div>
	<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table id="zoomarea0">
			<tbody>
				<colgroup>
					<col width="60">
					<col width="150">
					<col width="80">
					<col width="90">
					<col width="80">
					<col width="100">
					<col width="80">
					<col width="100">
					<col width="60">
					<col width="*">
				</colgroup>
				<tr>
					<th>Start Week</th>
					<td>
						<select class="input1" name="year" id="year" style="width:70px;"></select><!-- 
						 --><select class="input1" name="week" id="week" style="width:55px;"></select>
					</td>
					<th>Duration</th>
					<td>
						<select class="input1" name="duration" id="duration" size="1"></select>
					</td>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input class="input1" type="text" name="vvd" id="vvd" size="12" maxlength="9" style="ime-mode:disabled;" onkeypress="eventKeyChangeChar(UPPER_CASE);" dataformat="engup"></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<th>Trade</th>
					<td><script type="text/javaScript">ComComboObject("trade", 2, 70, 0, 1);</script></td>
					<th>Sub Trade</th>
					<td><script type="text/javaScript">ComComboObject("subtrade", 3, 50, 0, 0, 1);</script></td>
					<th>Lane</th>
					<td><script type="text/javaScript">ComComboObject("lane", 4, 94, 0, 0, 2);</script></td>
					<th>Bound</th>
					<td><select name="bound" id="bound" style="width:50px;"></select></td>
					<th>Origin</th>
					<td><input class="input1" type="text" size="5" value=<%=ofc_cd%> name="office" id="office" onkeypress="eventKeyChangeChar(UPPER_CASE);" dataformat="engup"></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result" name="mainTable1" id="mainTable1">
<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="zoomarea1">
		<div class="opus_design_data" >
			<table id="sheetControlDiv" style="width:100%" class="search">
				<tr>
					<td style="text-align:right;"><button type="button" class="btn_toggle_hide" name="maxi" alt='Alt+↑' onclick="toggleSheetSize('zoomarea0','zoomarea2');" sheetId="sheet1"></button></td>
				</tr>
				<tr><td height="5"></td></tr>
			</table>
		</div>
	
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>

<div class="wrap_result" id="zoomarea2">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid"  id="mainTable2">
		<div class="opus_design_data">
			<table>
				<colgroup>
					<col width="90">
					<col width="*">
				</colgroup>
				<tbody>
					<tr id="controlDiv">
						<th nowrap>Control Option</th>
						<td nowrap><span style="display:none;"><input type="checkbox" value="" class="trans" checked name="chkVolume" id="chkVolume" disabled>Volume</span><!-- 
							 --><select name="chkPort" id="chkPort" disabled><!-- 
								 --><option value="O">Office</option><!-- 
								 --><option value="L">POL</option><!-- 
								 --><option value="D">POL/POD</option><!-- 
							 --></select><!-- 
							 --><input type="checkbox" value="" class="trans" checked name="chkHC" id="chkHC" disabled><label for="chkHC">HC</label><!-- 
							 --><input type="checkbox" value="" class="trans" checked name="chk45" id="chk45" disabled><label for="chk45">45'</label><!-- 
							 --><input type="checkbox" value="" class="trans" checked name="chk53" id="chk53" disabled><label for="chk53">53'</label><!-- 
							 --><input type="checkbox" value="" class="trans" checked name="chkRFR" id="chkRFR" disabled><label for="chkRFR">Reefer</label><!-- 
							 --><input type="checkbox" value="" class="trans" checked name="chkWGT" id="chkWGT" disabled><label for="chkWGT">Weight</label>
						</td>
						<td style="display:none;width:200px;"  id="controlOptionButton1"><img class="cursor" src="/opuscntr/img/button/btng_edit.gif" height="19" border="0" name="btng_controlEdit" id="btng_controlEdit"></td>
						<td  style="display:none; width:200px;" nowrap id="controlOptionButton2"><img class="cursor" src="/opuscntr/img/button/btng_save.gif" height="19" border="0" name="btng_controlSave" id="btng_controlSave"><img class="cursor" src="/opuscntr/img/button/btng_cancel.gif" height="19" border="0" name="btng_controlCancel" id="btng_controlCancel"></td>
					</tr>
					<tr>
						<th nowrap>Data Selection</th>
						<td nowrap colspan="3"><!-- 
							--><input type="checkbox" value="" class="trans" checked name="chkOfc" id="chkOfc" id="chkOfc" onclick="return changeSelection();"><label for="chkOfc">Office</label><!--
							--><input type="checkbox" value="" class="trans" checked name="chkPol" id="chkPol" id="chkPol" onclick="return changeSelection();"><label for="chkPol">POL</label><!--
							--><span id="divChkPOD"><input type="checkbox" value="" class="trans" checked name="chkPod" id="chkPod" onclick="return changeSelection();"><label for="chkPod">POD</label></span><!--
							--><span id="divChkOCN"><input type="checkbox" value="" class="trans" checked name="chkOCN" id="chkOCN" onclick="return changeSelection();"><label for="chkOCN">OCN</label></span><!--
							--><span id="divChkIPC"><input type="checkbox" value="" class="trans" checked name="chkIPC" id="chkIPC" onclick="return changeSelection();"><label for="chkIPC">IPC</label></span><!--
							--><span id="divChkTS"><input type="checkbox" value="" class="trans" checked name="chkTS" id="chkTS" onclick="return changeSelection();"><label for="chkTS">T/S</label></span><!--
							--><span id="divChkMT"><input type="checkbox" value="" class="trans" checked name="chkEQ" id="chkEQ" onclick="return changeSelection();"><label for="chkEQ">MT</label></span><!--
							--><input type="checkbox" value="" class="trans" checked name="chkTYP" id="chkTYP" onclick="return changeSelection();"><label for="chkTYP">View by Type / Size</label><!--
							--><input type="checkbox" value="" class="trans" checked name="chkWT" id="chkWT" onclick="return changeSelection();"><label for="chkWT">Weight</label><!--
							--><span><input type="checkbox" style = "display: none" value="" class="trans" name="chkUSG" id="chkUSG" onclick="return changeSelection();"><label for="chkUSG"></label></span><!--
							--><span><input type="checkbox" value="" class="trans" name="chkBKGF" id="chkBKGF" onclick="return changeSelection();"><label for="chkBKGF">Booking(Firm)</label></span><!--
							--><span><input type="hidden" value="" class="trans" name="chkCUS" id="chkCUS" onclick="return changeSelection();"><label for="chkCUS"></label></span><!--
						--></td>
					</tr>
				</tbody>
			</table>
		</div>
		
		<div class="opus_design_btn">
			<button class="btn_accent" name="btng_bottleneck" id="btng_bottleneck" type="button" alt="Alt+B" style="display:none;">Bottle Neck Check</button><!--
			--><button class="btn_normal" name="btng_skd" id="btng_skd" type="button" alt="Alt+K">SKD Inquiry</button><!--
			--><button class="btn_normal" name="btng_bsa" id="btng_bsa" type="button" alt="Alt+M" style="display:none;">BS A Management</button><!--
			--><button class="btn_normal" name="btng_copymodel" id="btng_copymodel" type="button" style="display:none;">Copy Model</button><!--
			--><button type="button" class="btn_toggle_hide" style="margin-left:4px;margin-top:4px" name="maxi" alt='Alt+↓' onclick="toggleSheetSize('zoomarea0','zoomarea1');" sheetId="sheet2"></button>
		</div>
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>