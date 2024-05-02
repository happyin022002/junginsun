<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SPC_0042.jsp
*@FileTitle  : Control by HO
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/23
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.event.EsmSpc0042Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmSpc0042Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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
		
		event = (EsmSpc0042Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
	
	String ofc_cd = event.getSignOnUserAccount().getOfc_cd();
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
<!-- <form name="form" onsubmit="return false;" onKeyDown="spcKeyAction('ESM_SPC_0042');"> -->
<form name="form" onsubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">

<input type="hidden" name="uiname" id="uiname" value="ESM_SPC_0042">
<input type="hidden" name="ofc_cd" value="<%=ofc_cd%>">

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

<div class="wrap_search" >
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit" id="zoomarea0">
		<table>
			<colgroup>
				<col width="90">
				<col width="140">
				<col width="70">
				<col width="80">
				<col width="50">
				<col width="110">
				<col width="100">
				<col width="110">
				<col width="50">
				<col width="">
			</colgroup>
			<tbody>
				<tr>
					<th>Start Week</th>
					<td>
						<select class="input1" name="year" id="year" style="width:80px;"></select><!-- 
						 --><select class="input1" name="week" id="week" style="width:57px;"></select>
					</td>
					<th>Duration</th>
					<td>
						<select class="input1" name="duration" id="duration" size="1" style="width:52px"></select>
					</td>
					<th title="Vessel Voyage Direction">VVD</th>
					<td>
						<input class="input1" type="text" dataformat="engup" name="vvd" id="vvd"  style="width:90px"" maxlength="9" style="ime-mode:disabled;" onkeypress="eventKeyChangeChar(UPPER_CASE);">
					</td>
					<th>Forecast Qty View</th>
					<td colspan="3">
						<select name="fcast" id="fcast"><!-- 
							 --><option value="1">F'cast + BKG</option><!-- 
							 --><option value="2" selected>F'cast only</option><!-- 
							 --><option value="3">BKG only</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>Rep. Trade</th>
					<td>
						<script type="text/javascript">ComComboObject("trade", 2, 80, 0, 1);</script>
					</td>
					<th>Rep. Sub Trade</th>
					<td>
						<script type="text/javascript">ComComboObject("subtrade", 3, 52, 0, 1 , 1);</script>
					</td>
					<th>Lane</th>
					<td>
						<script type="text/javascript">ComComboObject("lane", 4, 90, 0, 0, 2);</script>
					</td>
					<th>Bound</th>
					<td>
						<select name="bound" id="bound" style="width:50px;"></select>
					</td>
					<th>Origin</th>
					<td>
						<script type="text/javascript">ComComboObject("office", 2, 85, 0, 1);</script>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result" id="zoomarea4">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<div class="opus_design_data">
			<table id="sheetControlDiv">
				<tbody>
					<tr>
						<td style="text-align: right;"><button type="button" class="btn_toggle_hide" id="btn_zoom_in" name="maxi" title="Alt+↑" onclick="toggleSheetSize('zoomarea0','zoomarea1');" sheetId="sheet1"></button></td>
					</tr>
					<tr><td height="7"></td></tr>
				</tbody>
			</table>			
		</div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
<div class="wrap_result" id="zoomarea1">
	<div class="opus_design_grid">
		<div class="opus_design_data" id="zoomarea2">
			<table>
				<colgroup>
					<col width="40">
					<col width="90">
					<col width="40">
					<col width="70">
					<col width="70">
					<col width="80">
					<col width="90">
					<col width="390">
					<col width="50">
					<col width="150">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th title="Vessel Voyage Direction">VVD</th>
						<td><input type="text" style="width:80px; text-align:center;"   value="" readonly name="idTxtVVD" id="idTxtVVD"></td>
						<th>WK</th>
						<td><input type="text" style="width:60px; text-align:center;"   value="" readonly name="idTxtWeek" id="idTxtWeek"></td>
						<th>Loadable</th>
						<td><input type="text"  style="width:60px; text-align:center;" value="" readonly  name="fm_load" id="idTxtLoadable" dataformat="float"></td>
					 	<th style="display:;" id="controlDiv" width="110" nowrap>Control Option</th>
					 	<td align="left" style="display:;" id="controlDiv" nowrap>
							<span style="display:none;"><input type="checkbox" value="" class="trans" checked name="chkVolume" id="chkVolume" disabled><label for="chkVolume">Volume&nbsp;&nbsp;&nbsp;</label></span><!-- 
							 --><select name="chkPort" disabled>
								<option value="O">Office</option>
								<option value="L">POL</option>
								<option value="D">POL/POD</option>
							</select><!-- 
							 --><input type="checkbox" value="" class="trans" checked name="chkHC" id="chkHC" disabled><label for="chkHC">HC</label>&nbsp;&nbsp;&nbsp;<!-- 
							 --><input type="checkbox" value="" class="trans" checked name="chk45" id="chk45" disabled><label for="chk45">45'</label>&nbsp;&nbsp;&nbsp;<!-- 
							 --><input type="checkbox" value="" class="trans" checked name="chk53" id="chk53" disabled><label for="chk53">53'</label>&nbsp;&nbsp;&nbsp;<!-- 
							 --><input type="checkbox" value="" class="trans" checked name="chkRFR" id="chkRFR" disabled><label for="chkRFR">Reefer</label>&nbsp;&nbsp;&nbsp;<!-- 
							 --><input type="checkbox" value="" class="trans" checked name="chkWGT" id="chkWGT" disabled><label for="chkWGT">Weight</label>
						</td>
						<td width="50" id="controlOptionButton1">
							<table width="100%" border="0" cellpadding="0" cellspacing="0">
								<tr>
									<td><button class="btn_etc" name="btng_controlEdit" id="btng_controlEdit" type="button">Edit</button>
							    </tr>
							</table>

						</td>
						<td align="left" width="150" nowrap style="display:none;" id="controlOptionButton2">
							<table width="100%" border="0" cellpadding="0" cellspacing="0">
								<tr>
									<button class="btn_normal" name="btng_controlSave" id="btng_controlSave">Save</button><!--
									--><button class="btn_normal" name="btng_controlCancel" id="btng_controlCancel">Cancel</button>
							
								</tr>
							</table>
						</td>
						<!--<td style="text-align: right;"><a id="sheetControlDiv"><button type="button" class="btn_up mar_left_4" id="btn_zoom_in" name="maxi" title="Alt+↓" onclick="toggleSheetSize('zoomarea0','zoomarea4');" sheetId="sheet2"></button></a></td>-->
						<td style="text-align: right;"><button type="button" class="btn_toggle_hide" id="btn_zoom_in" name="maxi" onclick="toggleSheetSize('zoomarea0','zoomarea4');" sheetId="sheet2"></button></td>
				 	</tr>
				</tbody>
			</table>
			<table><tr><td height="5"></td></tr></table>
			<table>
				<colgroup>
					<col width="100">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th nowrap>Data Selection</th>
						<td nowrap>
							<input type="checkbox" value="" class="trans" checked name="chkOfc" id="chkOfc" onclick="return changeSelection();"><label for="chkOfc">Office</label>&nbsp;&nbsp;&nbsp;<!-- 
							 --><input type="checkbox" value="" class="trans" checked name="chkPol" id="chkPol" onclick="return changeSelection();"><label for="chkPol">POL</label>&nbsp;&nbsp;&nbsp;<!-- 
							 --><span id="divChkPOD"><input type="checkbox" value="" class="trans" checked name="chkPod" id="chkPod" onclick="return changeSelection();"><label for="chkPod">POD</label>&nbsp;&nbsp;&nbsp;</span><!-- 
							 --><span id="divChkOCN"><input type="checkbox" value="" class="trans" checked name="chkOCN" id="chkOCN" onclick="return changeSelection();"><label for="chkOCN">OCN</label>&nbsp;&nbsp;&nbsp;</span><!-- 
							 --><span id="divChkIPC"><input type="checkbox" value="" class="trans" checked name="chkIPC" id="chkIPC" onclick="return changeSelection();"><label for="chkIPC">IPC</label>&nbsp;&nbsp;&nbsp;</span><!-- 
							 --><span id="divChkTS"><input type="checkbox" value="" class="trans" checked name="chkTS" id="chkTS" onclick="return changeSelection();"><label for="chkTS">T/S</label>&nbsp;&nbsp;&nbsp;</span><!-- 
							 --><span id="divChkMT"><input type="checkbox" value="" class="trans" checked name="chkEQ" id="chkEQ" onclick="return changeSelection();"><label for="chkEQ">MT</label>&nbsp;&nbsp;&nbsp;</span><!-- 
							 --><input type="checkbox" value="" class="trans" checked name="chkTYP" id="chkTYP" onclick="return changeSelection();"><label for="chkTYP">View by Type / Size</label><!-- 
							 --><input type="checkbox" value="" class="trans" checked name="chkWT" id="chkWT" onclick="return changeSelection();"><label for="chkWT">Weight</label><!-- 
							 --><span style="display:none;"><input type="checkbox" value="" class="trans" name="chkUSG" id="chkUSG" onclick="return changeSelection();"><label for="chkUSG">Final load</label></span><!-- 
							 --><span><input type="hidden" value="" class="trans" name="chkMDL" id="chkMDL" onclick="return changeSelection();"><label for="chkMDL"></label></span> <!-- Model --><!-- 
							 --><span><input type="checkbox" value="" class="trans" name="chkBKGF" id="chkBKGF" onclick="return changeSelection();"><label for="chkBKGF">Booking(Firm)</label></span><!-- 
							 --><span><input type="hidden" value="" class="trans" name="chkCUS" id="chkCUS" onclick="return changeSelection();"><label for="chkCUS"></label></span> <!-- Customer Guarantee -->
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="opus_design_btn">
			<button class="btn_normal" name="btng_bottleneck" id="btng_bottleneck" type="button" alt="Alt+B">Bottle Neck Check</button><!--
			--><button class="btn_normal" name="btng_skd" id="btng_skd" type="button" alt="Alt+K">SKD Inquiry</button><!--
			--><button class="btn_normal" name="btng_bsa" id="btng_bsa" type="button" alt="Alt+M">BSA Management</button><!--
			--><button class="btn_normal" name="btng_copymodel" id="btng_copymodel" type="button" style="display:none">Copy Model</button>
		</div>
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>