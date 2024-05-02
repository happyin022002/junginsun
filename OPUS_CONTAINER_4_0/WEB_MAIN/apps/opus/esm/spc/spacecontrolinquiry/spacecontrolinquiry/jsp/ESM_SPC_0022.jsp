<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SPC_0022.jsp
*@FileTitle  : Inquiry by Trade
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/26
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event.EsmSpc0022Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmSpc0022Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.Spacecontrolinquiry.Spacecontrolinquiry");
	String ofc_cd = ""; 

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmSpc0022Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		ofc_cd = event.getSignOnUserAccount().getOfc_cd();
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
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
<input type="hidden" name="ofc_cd" value="<%=ofc_cd%>">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" type="button" name="btn_retrieve" id="btn_retrieve" alt="Alt+R">Retrieve</button><!--
		--><button class="btn_normal" type="button" name="btn_new" id="btn_new" alt="Alt+N" >New</button><!--
		--><button class="btn_normal" type="button" name="btn_downexcel" id="btn_downexcel" >Down Excel</button><!--
		--></div>
	<!-- opus_design_btn (E) -->

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
		<table>
			<colgroup>
				<col width="50" />				
				<col width="300" />				
				<col width="40" />				
				<col width="110" />				
				<col width="50" />				
				<col width="160" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
		   			<th>Period</th>
					<td><select class="input1" name="year1" id="year1" style="width:70px;"></select><!--
					--><select class="input1" name="week1" id="week1" style="width:60px;"></select><span class="dash">~</span><!--
					--><select class="input1" name="year2" id="year2" style="width:70px;"></select><!--
					--><select class="input1" name="week2" id="week2" style="width:60px;"></select></td>
					<th>RHQ</th>
					<td><script type="text/javascript">ComComboObject("rhq_txt", 2, 80, 0, 1);</script></td>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input class="input1" type="text" name="only_vvd" value="" maxlength="9" style="width:85px;" dataformat="engup"></td>
					<td colspan="2"></td>
		   		</tr>
		   </tbody>
		</table>
		<table>
			<colgroup>
				<col width="50">				
				<col width="125">				
				<col width="107">				
				<col width="50">				
				<col width="51">				
				<col width="110">				
				<col width="50">				
				<col width="110">				
				<col width="60">				
				<col width="*">				
		   </colgroup> 
		   <tbody>
		   		<tr>
					<th>Trade</th>
					<td><script type="text/javascript">ComComboObject("trade", 2, 60, 0, 0);</script></td>
					<th>Sub Trade</th>
					<td><script type="text/javascript">ComComboObject("subtrade", 3, 50, 0, 0, 1);</script></td>
					<th>Lane</th>
					<td><script type="text/javascript">ComComboObject("lane", 4, 80, 0, 0, 2);</script></td>
					<th>Bound</th>
					<td><select name="bound" id="bound" style="width:50px;"></select></td>
					<th>OCN/IPC</th>
					<td><select name="onc_ipc" id="onc_ipc" style="width:50px;"></select></td>
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
		<button class="btn_up" type="button" name="maxi" id="maxi" alt="Alt+R" sheetId="sheet1" type="N" title='Alt+↑'></button>
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
	
	<!-- UI_ESM_SPC_022 : THIS IS 1st TAB -->
	<div id="tabLayer" style="display:inline">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry">
			<table>
				<colgroup>
					<col width="1" />				
					<col width="100" />				
					<col width="80" />				
					<col width="200" />				
					<col width="300" />				
					<col width="*" />				
			   </colgroup> 
				<tr>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input type="text" name="vvd1" style="width:80px;" value="" readonly id="vvd1" dataformat="engup" /> </td>
					<th>Sales Origin</th>
					<td><input type="radio" name="rhq_gso1" value="RHQ" class="trans" onclick="changeTitle_Colum('1');" id="rhq_gso1" /><label for ="rhq_gso1">Area/RHQ</label><input type="radio" name="rhq_gso1" value="GSO" class="trans" onclick="changeTitle_Colum('1');" checked id="rhq_gso1" /><label for ="rhq_gso1">Office</label></td>
					<td><input type="checkbox" name="weight1" value="1" class="trans" checked onclick="changeTitle1('1', this);" id="weight1" /><label for ="weight1"><b>Weight</b></label><input type="checkbox" name="type1" value="1" class="trans" onclick="changeTitle2('1', this);" id="type1" /><label for ="type1"><b>View by Type/Size</b></label></td>
					<td align="right" class="gray"><span>Unit : TEU,Ton</span>
						<button class="btn_up" type="button" name="maxi" id="maxi" sheetId="t1sheet1" type="N"></button>
				    </td>
				</tr>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
		
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('t1sheet1');</script>
		</div>
		<!-- opus_design_grid(E) -->
	</div>
	
	<!-- UI_ESM_SPC_022_T1 : THIS IS 2st TAB -->
	<div id="tabLayer" style="display:none">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry">
			<table>
				<colgroup>
					<col width="1" />				
					<col width="100" />				
					<col width="80" />				
					<col width="200" />				
					<col width="60" />				
					<col width="160" />				
					<col width="300" />				
					<col width="*" />				
			   </colgroup> 
				<tr>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input type="text" name="vvd2" style="width:80px;" value="" readonly id="vvd2" dataformat="engup" /></td>
					<th>Sales Origin</th>
					<td><input type="radio" name="rhq_gso2" value="RHQ" class="trans" onclick="changeTitle_Colum('2');" checked id="rhq_gso2" /><label for ="rhq_gso2">RHQ</label><input type="radio" name="rhq_gso2" value="GSO" class="trans" onclick="changeTitle_Colum('2');" id="rhq_gso2" /><label for ="rhq_gso2">Office</label></td>
					<th>POL/POD</th>
					<td><input type="radio" name="pol_pod2" value="POL" class="trans" onclick="changeTitle_Colum('2');" checked id="pol_pod2" /><label for ="rhq_gso2">POL</label><input type="radio" name="pol_pod2" value="POD" class="trans" onclick="changeTitle_Colum('2');" id="pol_pod2" /><label for ="rhq_gso2">POD</label></td>
					<td><input type="checkbox" name="weight2" value="1" class="trans" checked onclick="changeTitle1('2', this);" id="weight2" /><label for ="weight2"><b>Weight</b></label><input type="checkbox" name="type2" value="1" class="trans" onclick="changeTitle2('2', this);" id="type2" /><label for ="type2"><b>View by Type/Size</b></label></td>
					<td align="right" class="gray"><span>Unit : TEU,Ton</span>
						<button class="btn_up" type="button" name="maxi" id="maxi" sheetId="t2sheet1" type="N"></button>
				    </td>
				</tr>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
		
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('t2sheet1');</script>
		</div>
		<!-- opus_design_grid(E) -->
	</div>
	
	<!-- UI_ESM_SPC_022_T2 : THIS IS 3st TAB -->
	<div id="tabLayer" style="display:none">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry">
			<table>
				<colgroup>
					<col width="1" />				
					<col width="100" />				
					<col width="80" />				
					<col width="200" />				
					<col width="60" />				
					<col width="160" />				
					<col width="300" />				
					<col width="*" />				
			   </colgroup> 
				<tr>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input type="text" name="vvd3" style="width:80px;" value="" readonly id="vvd3" dataformat="engup" /> </td>
					<th>Sales Origin</th>
					<td><input type="radio" name="rhq_gso3" value="RHQ" class="trans" onclick="changeTitle_Colum('3');" checked id="rhq_gso3" /><label for ="rhq_gso3">RHQ</label><input type="radio" name="rhq_gso3" value="GSO" class="trans" onclick="changeTitle_Colum('3');" id="rhq_gso3" /><label for ="rhq_gso3">Office</label></td>
					<th>POL/POD</th>
					<td><input type="radio" name="pol_pod3" value="POL" class="trans" onclick="changeTitle_Colum('3');" checked id="pol_pod3" /><label for ="pol_pod3">POL</label><input type="radio" name="pol_pod3" value="POD" class="trans" onclick="changeTitle_Colum('3');" id="pol_pod3" /><label for ="pol_pod3">POD</label></td>
					<th><input type="checkbox" name="weight3" value="1" class="trans" checked onclick="changeTitle1('3', this);" id="weight3" /><label for ="weight3">Weight</label><input type="checkbox" name="type3" value="1" class="trans" onclick="changeTitle2('3', this);" id="type3" /><label for ="type3">View by Type/Size</label></th>
					<td align="right" class="gray"><span>Unit : TEU,Ton</span>
						<button class="btn_up" type="button" name="maxi" id="maxi" sheetId="t3sheet1" type="N"></button>
				    </td>
				</tr>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
		
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('t3sheet1');</script>
		</div>
		<!-- opus_design_grid(E) -->
	</div>
	
	<!-- UI_ESM_SPC_022_T2 : THIS IS 4st TAB -->
	<div id="tabLayer" style="display:none">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry">
			<table>
				<colgroup>
					<col width="1" />				
					<col width="100" />				
					<col width="80" />				
					<col width="200" />				
					<col width="60" />				
					<col width="160" />				
					<col width="300" />				
					<col width="*" />			
			   </colgroup> 
				<tr>
						<th title="Vessel Voyage Direction">VVD</th>
						<td><input type="text" name="vvd4" style="width:80px;" value="" readonly id="vvd4" dataformat="engup" /> </td>
						<th>Sales Origin</th>
						<td><input type="radio" name="rhq_gso4" value="RHQ" class="trans" onclick="changeTitle_Colum('4');" checked id="rhq_gso4" /><label for ="rhq_gso4">RHQ</label><input type="radio" name="rhq_gso4" value="GSO" class="trans" onclick="changeTitle_Colum('4');" id="rhq_gso4" /><label for ="rhq_gso4">Office</label></td>
						<th>POL/POD</th>
						<td><input type="radio" name="pol_pod4" value="POL" class="trans" onclick="changeTitle_Colum('4');" checked id="pol_pod4" /><label for ="rhq_gso4">POL</label><input type="radio" name="pol_pod4" value="POD" class="trans" onclick="changeTitle_Colum('4');" id="pol_pod4" /><label for ="pol_pod4">POD</label></td>
						<th><input type="checkbox" name="weight4" value="1" class="trans" checked onclick="changeTitle1('4', this);" id="weight4" /><label for ="weight4">Weight</label><input type="checkbox" name="type4" value="1" class="trans" onclick="changeTitle2('4', this);" id="type4" /><label for ="type4">View by Type/Size</label></th>
						<td align="right" class="gray"><span>Unit : TEU,Ton</span>
							<button class="btn_up" type="button" name="maxi" id="maxi" sheetId="t4sheet1" type="N"></button>
				    	</td>
				</tr>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
		
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('t4sheet1');</script>
		</div>
		<!-- opus_design_grid(E) -->
	</div>
</div>
<!-- wrap_result2 (E) -->

</form>