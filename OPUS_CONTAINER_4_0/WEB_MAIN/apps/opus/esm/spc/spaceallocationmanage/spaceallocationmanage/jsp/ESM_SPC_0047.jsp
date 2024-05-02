<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SPC_0047.jsp
*@FileTitle  : Control by RHQ
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/06
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.event.EsmSpc0047Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmSpc0047Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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


		event = (EsmSpc0047Event)request.getAttribute("Event");
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
<!-- <form name="form" onsubmit="return false;" onKeyDown="spcKeyAction('ESM_SPC_0047');"> -->
<form name="form" id="form" onsubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />

<input type="hidden" name="uiname" value="ESM_SPC_0047" id="uiname" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><span id="title"></span></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" type="button" name="btn_retrieve" id="btn_retrieve" alt="Alt+R">Retrieve</button><!--
		--><button class="btn_normal" type="button" name="btn_new" id="btn_new" alt="Alt+N">New</button><!--
		--><button class="btn_normal" type="button" name="btn_save" id="btn_save" alt="Alt+S">Save</button><!--
		--><button class="btn_normal" type="button" name="btn_downexcel" id="btn_downexcel">Down Excel</button><!--
		--></div>
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
	<div class="opus_design_inquiry wFit" id="zoomarea0">
		<table>
			<colgroup>
				<col width="85" />				
				<col width="120"/>				
				<col width="70" />				
				<col  width="90"/>		
				<col width="60" />				
				<col  width="120"/>				
				<col width="120" />	
				<col  width="100"/>				
				<col width="100" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
					<th>Start Week</th>
					<td><select class="input1" name="year" id="year" style="width:70px;"></select><!-- 
					 --><select class="input1" name="week" id="week" style="width:55px;"></select></td>
					<th>Duration</th>
					<td><select class="input1" name="duration" id="duration" size="1" style="width:50px;"></select></td>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input class="input1" type="text" name="vvd" size="12" maxlength="9" style="ime-mode:disabled;" onkeypress="eventKeyChangeChar(UPPER_CASE);" id="vvd" /> </td>
					<th>Forecast Qty View</th>
					<td colspan="3"><select name="fcast" id="fcast"><!-- 
						 --><option value="1">F'cast + BKG</option><!-- 
						 --><option value="2">F'cast only</option><!-- 
						 --><option value="3">BKG only</option><!-- 
						 --></select>
					</td>
				</tr>
		
		   		<tr>
					<th>Rep. Trade</th>
					<td><script type="text/JavaScript">ComComboObject("trade", 2, 70, 0, 1);</script></td>
					<th>Sub Trade</th>
					<td><script type="text/JavaScript">ComComboObject("subtrade", 3, 50, 0, 1);</script></td>
					<th>Lane</th>
					<td><script type="text/JavaScript">ComComboObject("lane", 4, 82, 0, 0);</script></td>
					<th>Bound</th>
					<td><select name="bound" id="bound" style="width:50px;"></select></td>
					<th>Origin</th>
					<td><script type="text/JavaScript">ComComboObject("office", 2, 70, 0, 1);</script></td>
				</tr>
		   </tbody>
		</table>
		<table class="height_10"><tr><td></td></tr></table>
		
		
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result"  id="zoomarea1">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" >
		<table>
            <tr><td align="right" id="sheetControlDiv">
	            <button type="button" class="btn_down" id="maxi" name="maxi" sheetId="sheet1" onclick="toggleSheetSize('zoomarea0','zoomarea2');" type="N" alt='Alt+↑'></button>
<!-- 	            <button type="button" name="maxi" id="maxi" class="btn_up" sheetId="sheet1" type="N"  onclick="toggleSheetSize('zoomarea');" alt='Alt+↑'></button> -->
            </td></tr>
        </table>
        <table><tr><td height="5"></td></tr></table>
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->
	<table class="height_10"><tr><td></td></tr></table>
</div>

<div class="wrap_search" id="zoomarea2">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" >
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table >
			<colgroup>
				<col width="50" />				
				<col width="70" />				
				<col width="40" />				
				<col width="70" />
				<col width="70" />				
				<col width="80" />
				<col width="70" />				
				<col width="90" />				
				<col width="290" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		
				<tr>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input type="text" style="width:80px; text-align:center;" value="" readonly id="idTxtVVD" /> </td>
					<th>WK</th>
					<td><input type="text" style="width:60px; text-align:center;" value="" readonly id="idTxtWeek" /> </td>
					<th>Loadable</th>
					<td><input type="text" style="width:60px; text-align:center;" value="" readonly name="fm_load" id="fm_load" /> </td>
				 	<th id="controlDiv" name="controlDiv" >Control Option</th>
					<td align="left" style="display:;" id="controlDiv" nowrap>
							<span style="display:none;"><input type="checkbox" value="" class="trans" checked name="chkVolume" id="chkVolume" disabled><label for="chkVolume">Volume&nbsp;&nbsp;&nbsp;</label></span>
							<select name="chkPort" disabled><option value="O">Office</option><option value="L">POL</option><option value="D">POL/POD</option></select>&nbsp;&nbsp;&nbsp;
							<input type="checkbox" value="" class="trans" checked name="chkHC" id="chkHC" disabled><label for="chkHC">HC</label>&nbsp;&nbsp;&nbsp;
							<input type="checkbox" value="" class="trans" checked name="chk45" id="chk45" disabled><label for="chk45">45'</label>&nbsp;&nbsp;&nbsp;
							<input type="checkbox" value="" class="trans" checked name="chk53" id="chk53" disabled><label for="chk53">53'</label>&nbsp;&nbsp;&nbsp;
							<input type="checkbox" value="" class="trans" checked name="chkRFR" id="chkRFR" disabled><label for="chkRFR">Reefer</label>&nbsp;&nbsp;&nbsp;
							<input type="checkbox" value="" class="trans" checked name="chkWGT" id="chkWGT" disabled><label for="chkWGT">Weight</label>
						</td>
					<td id="controlOptionButton1"><button class="btn_etc" type="button" name="btng_controlEdit" id="btng_controlEdit" alt="Alt+I">Edit</button><!-- 
					 --><div align="left" nowrap style="display:none;" id="controlOptionButton2">
							<!-- opus_design_btn (S) -->
							<div class="opus_design_btn">
								<button class="btn_accent" type="button" name="btng_controlSave" id="btng_controlSave" alt="Alt+S">Save</button><!--
								--><button class="btn_normal" type="button" name="btng_controlCancel" id="btng_controlCancel" alt="Alt+X">Cancel</button><!--
								--></div>
							<!-- opus_design_btn (E) -->
	
						</div><!-- 
						 --><span id="sheetControlDiv" style=""><button type="button" name="maxi" id="maxi"class="btn_down" sheetId="sheet2" type="N" onclick="toggleSheetSize('zoomarea0','zoomarea1');" alt='Alt+↓'></button></span>
					</td>
				</tr>
			</tbody>
		</table>
		<table>
			<colgroup>
				<col width="100" />								
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
					<td nowrap><b>Data Selection</b></td>
					<td align="left" colspan="3" nowrap>
						<input type="checkbox" value="" class="trans" checked name="chkOfc" id="chkOfc" onclick="return changeSelection();"><label for="chkOfc">Office</label>&nbsp;&nbsp;&nbsp;
						<input type="checkbox" value="" class="trans" checked name="chkPol" id="chkPol" onclick="return changeSelection();"><label for="chkPol">POL</label>&nbsp;&nbsp;&nbsp;
						<span id="divChkPOD"><input type="checkbox" value="" class="trans" checked name="chkPod" id="chkPod" onclick="return changeSelection();"><label for="chkPod">POD</label>&nbsp;&nbsp;&nbsp;</span>
						<span id="divChkOCN"><input type="checkbox" value="" class="trans" checked name="chkOCN" id="chkOCN" onclick="return changeSelection();"><label for="chkOCN">OCN</label>&nbsp;&nbsp;&nbsp;</span>
						<span id="divChkIPC"><input type="checkbox" value="" class="trans" checked name="chkIPC" id="chkIPC" onclick="return changeSelection();"><label for="chkIPC">IPC</label>&nbsp;&nbsp;&nbsp;</span>
						<span id="divChkTS"><input type="checkbox" value="" class="trans" checked name="chkTS" id="chkTS" onclick="return changeSelection();"><label for="chkTS">T/S</label>&nbsp;&nbsp;&nbsp;</span>
						<span id="divChkMT"><input type="checkbox" value="" class="trans" checked name="chkEQ" id="chkEQ" onclick="return changeSelection();"><label for="chkEQ">MT</label>&nbsp;&nbsp;&nbsp;</span>
						<input type="checkbox" value="" class="trans" checked name="chkTYP" id="chkTYP" onclick="return changeSelection();"><label for="chkTYP">View by Type / Size</label>
						<input type="checkbox" value="" class="trans" checked name="chkWT" id="chkWT" onclick="return changeSelection();"><label for="chkWT">Weight</label>
						<span><input type="checkbox" value="" class="trans" name="chkUSG" id="chkUSG" onclick="return changeSelection();"><label for="chkUSG">Final load</label></span>
						<span><input type="hidden" value="" class="trans" name="chkCUS" id="chkCUS" onclick="return changeSelection();"><label for="chkCUS"></label></span>
						<span><input type="checkbox" value="" class="trans" name="chkBKGF" id="chkBKGF" onclick="return changeSelection();"><label for="chkBKGF">Booking(Firm)</label></span>
					</td>
				</tr>
		   </tbody>
		</table>
		
	</div>
	<!-- opus_design_inquiry(E) -->
	
	
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" type="button" name="btng_bottleneck" id="btng_bottleneck" alt="Alt+B">Bottle Neck Check</button><!--
			--><button class="btn_normal" type="button" name="btng_skd" id="btng_skd" alt="Alt+K">SKD Inquiry</button><!--
			--><button class="btn_normal" type="button" name="btng_bsa" id="btng_bsa" alt="Alt+M">BSA Management</button><!--
			--><!-- button class="btn_normal" type="button" name="btng_copymodel" id="btng_copymodel">Copy Model</button--><!--
			--></div>
		<!-- opus_design_btn (E) -->
		<script type="text/javascript">ComSheetObject('sheet2');</script>		
	</div>
	<!-- opus_design_grid(E) -->
	
</div>

</form>
