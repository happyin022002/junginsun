<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 :  ESM_SPC_0028.js
*@FileTitle  : Inquiry by Sub Office 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/25
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event.EsmSpc0028Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	
    String pop_vvd = JSPUtil.getParameter(request, "vvd"   , "");
    String pop_ofc = JSPUtil.getParameter(request, "office", "");
    
    EsmSpc0028Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.Spacecontrolinquiry.Spacecontrolinquiry");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmSpc0028Event)request.getAttribute("Event");
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
    var pop_vvd = "<%=pop_vvd%>";
    var pop_ofc = "<%=pop_ofc%>";
    
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
		document.form.year1.focus();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" 	id="btn_retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_new" 		id="btn_new">New</button><!--
		--><button type="button" class="btn_normal" name="btn_downexcel"  		id="btn_downexcel">Down Excel</button>	
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<!-- wrap_search (S) -->
<div class="wrap_search" id="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table id="zoomarea1">
			<tbody>
				<colgroup>
					<col width="1"/>
					<col width="100"/>
					<col width="155"/>
					<col width="80"/>
					<col width="80"/>
					<col width="100"/>
					<col width="80"/>
					<col width="*"/>
			    </colgroup>
				<tr>
					<th>Period</th>
					<td colspan="3">
						<select class="input1" name="year1" id="year1" style="width:80px;"></select><!--
						--><select class="input1" name="week1" id="week1" style="width:70px;"></select>~&nbsp;<!--
						--><select class="input1" name="year2" id="year2" style="width:80px;"></select><!--
						--><select class="input1" name="week2" id="week2" style="width:70px;"></select>
					</td>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input class="input1" type="text" name="only_vvd" maxlength="9" style="width:80px;" dataformat="engup" id="only_vvd" /></td>
					<th>Office</th>
					<td><input class="input1" type="text" name="sales_office" style="width:80px;" value="<%=ofc_cd%>" maxlength="6" dataformat="engup" onchange="checkValue();" id="sales_office" /></td>
				</tr>	
				<tr>
					<th>Trade</th>
					<td><script type="text/javascript">ComComboObject("trade", 2, 80, 0, 0);</script></td>
					<th>Sub Trade</th>
					<td><script type="text/javascript">ComComboObject("subtrade", 3, 70, 0, 0, 1);</script></td>
					<th>Lane</th>
					<td><script type="text/javascript">ComComboObject("lane", 4, 80, 0, 0, 2);</script></td>
					<th>Bound</th>
					<td><select name="bound" style="width:80px;"></select></td>	
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<!-- wrap_search (E) -->

<!-- wrap_result1 (S) -->
<div class="wrap_result" id="wrap_result1">
	<!-- opus_design_grid(S) -->
	<div style="text-align: right" class="pad_btm_4">
	<table>
	<tr>
		<td align="right" class="gray">
			<!--<span>Unit : TEU</span>&nbsp;-->
			<button class="btn_up" type="button" name="maxi" id="maxi" sheetId="sheet1" type="N" ></button>
		</td>
	</tr>
	</table>
	</div>
	<div class="opus_design_grid" id="mainTable1">
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->
</div>
<!-- wrap_result1 (E) -->

<!-- wrap_result2 (S) -->
<div class="wrap_result" id="wrap_result2">
	<!-- opus_tab_btn(S) -->
	<div class="opus_design_tab" id="tabArea">
		<script type="text/javascript"> ComTabObject ('tab1')</script>
	</div>
	<!-- opus_tab_btn(E) -->
	<div id="tabLayer" name="tabLayer" style="display:inline">
		<div class="opus_design_inquiry" id="zoomarea4">
			<table>
				<tbody>
					<colgroup>
						<col width="30">
						<col width="90">
						<col width="90">
						<col width="400">
						<col width="*">
				    </colgroup>
					<tr>
						<th title="Vessel Voyage Direction">VVD</th>
						<td><input type="text" name="vvd" style="width:80px;" value="" readonly id="vvd" /></td>
						<th  id="controlDiv" name="controlDiv" >Control Option</th>
						<td style="display:;font-weight: bold;" id="controlDiv" nowrap><!-- 
							 --><span style="display:none;"><input type="checkbox" value="" class="trans" checked name="chkVolume" disabled>Volume&nbsp;&nbsp;&nbsp;</span><!-- 
							 --><select name="chkPort" disabled><option value="O">Office</option><option value="L">POL</option><option value="D">POL/POD</option></select>&nbsp;&nbsp;&nbsp;<!-- 
							 --><input type="checkbox" value="" class="trans" checked name="chkHC40" disabled id="chkHC40" />HC&nbsp;&nbsp;&nbsp;<!-- 
							 --><input type="checkbox" value="" class="trans" checked name="chkHC45" disabled id="chkHC45" />45'&nbsp;&nbsp;&nbsp;<!-- 
							 --><input type="checkbox" value="" class="trans" checked name="chk53FT" disabled id="chk53FT" />53'&nbsp;&nbsp;&nbsp;<!-- 
							 --><input type="checkbox" value="" class="trans" checked name="chkRFR" disabled id="chkRFR" />Reefer&nbsp;&nbsp;&nbsp;<!-- 
							 --><input type="checkbox" value="" class="trans" checked name="chkWGT" disabled id="chkWGT" />Weight
						</td>
						<td></td>
						</tr>
				</tbody>
			</table>
			<table>
				<tbody>
					<colgroup>
						<col width="1">
						<col width="30">
						<col width="90">
						<col width="90">
						<col width="400">
						<col width="*">
				    </colgroup>		
					<tr>
						<td></td>
						<td></td>
						<th>Data Selection</th>
						<td style="font-weight: bold;">
							 <!-- 20160317.MOD : 인수 -->
							 <input type="checkbox" value="" class="trans" checked="" name="chkPol" id="chkPol" onclick="return changePort(this);" /><label for="chkPol">POL</label>&nbsp;&nbsp;&nbsp;
							 <input type="checkbox" value="" class="trans" checked="" name="chkPod" id="chkPod" onclick="return changePort(this);" /><label for="chkPod">POD</label>&nbsp;&nbsp;&nbsp; 
							 <input type="checkbox" value="" class="trans" checked="" name="chkTYP" id="chkTYP" onclick="return selectChange();" /><label for="chkTYP">View by Type / Size</label> 
							 <input type="checkbox" value="" class="trans" checked="" name="chkWT" id="chkWT" onclick="return selectChange();" /><label for="chkWT">Weight</label>
						</td>
						<td align="right" class="gray"><span>Unit : TEU,Ton</span>&nbsp;
							<button class="btn_up" type="button" name="maxi" id="maxi" sheetId="t1sheet1" type="N"></button>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="opus_design_grid clear" >
			<script type="text/javascript">ComSheetObject('t1sheet1');</script>
		</div>
	</div>
	
	<div id="tabLayer" name="tabLayer" style="display:none">
		<div class= "opus_design_inquiry" id="zoomarea5">
			<table>
				<tbody>
					<colgroup>
						<col width="30">
						<col width="90">
						<col width="90">
						<col width="400">
						<col width="*">
				    </colgroup>
					<tr>
						<th title="Vessel Voyage Direction">VVD</th>
						<td><input type="text" name="vvd" style="width:80px;" value="" readonly id="vvd" /> </td>
						<th>Data Selection</th>
						<td style="font-weight: bold;"><!-- 
							 --><input type="radio" value="" class="trans" checked name="chkPolPodS" id="chkPolPodS1" onclick="return changePolPod();"><label for="chkPolPodS1">POL</label>&nbsp;&nbsp;&nbsp;<!-- 
							 --><input type="radio" value="" class="trans" name="chkPolPodS" id="chkPolPodS2" onclick="return changePolPod();"><label for="chkPolPodS2">POD</label>&nbsp;&nbsp;&nbsp;<!-- 
							 --><input type="checkbox" value="" class="trans" checked name="chkTYP" id="chkTYP2" onclick="return selectChange();"><label for="chkTYP2">View by Type / Size</label><!-- 
							 --><input type="checkbox" value="" class="trans" checked name="chkWT" id="chkWT2" onclick="return selectChange();"><label for="chkWT2">Weight</label>
						</td>
						<td align="right" class="gray"><span>Unit : TEU,Ton</span>&nbsp;
							<button class="btn_up" type="button" name="maxi" id="maxi" sheetId="t1sheet2" type="N"></button>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="opus_design_grid clear" >
			<script type="text/javascript">ComSheetObject('t1sheet2');</script>
		</div>
	</div>
	
	<div id="tabLayer" name="tabLayer" style="display:none">
		<div class= "opus_design_inquiry" id="zoomarea6">
			<table >
				<tbody>
					<colgroup>
						<col width="1">
						<col width="30"/>
						<col width="90"/>
						<col width="90"/>
						<col width="400"/>
						<col width="*"/>
				    </colgroup>
					<tr>
						<th title="Vessel Voyage Direction">VVD</th>
						<td><input type="text" name="vvd" style="width:80px;" value="" readonly id="vvd" /> </td>
						<th>Data Selection</th>
						<td style="font-weight: bold;"><!-- 
							 --><input type="radio" value="" class="trans" checked name="chkPolPodC" id="chkPolPodC1" onclick="return changePolPod();"><label for="chkPolPodC1">POL</label>&nbsp;&nbsp;&nbsp;<!-- 
							 --><input type="radio" value="" class="trans" name="chkPolPodC" id="chkPolPodC2" onclick="return changePolPod();"><label for="chkPolPodC2">POD</label>&nbsp;&nbsp;&nbsp;<!-- 
							 --><input type="checkbox" value="" class="trans" checked name="chkTYP" id="chkTYP3" onclick="return selectChange();"><label for="chkTYP3">View by Type / Size</label><!-- 
							 --><input type="checkbox" value="" class="trans" checked name="chkWT" id="chkWT3" onclick="return selectChange();"><label for="chkWT3">Weight</label>
						</td>
						<td align="right" class="gray"><span>Unit : TEU,Ton</span>&nbsp;
							<button class="btn_up" type="button" name="maxi" id="maxi" sheetId="t1sheet3" type="N"></button>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="opus_design_grid clear" >
			<script type="text/javascript">ComSheetObject('t1sheet3');</script>
		</div>
	</div>
</div>
</form>
