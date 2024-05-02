<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : EES_CIM_1001.js
*@FileTitle  : Turn Time by PORT
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/18
=========================================================*/%> 

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.io.HttpUtil"%> 
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.event.EesCim1001Event"%>
<%@ page import="org.apache.log4j.Logger" %> 

<%
 	EesCim1001Event  event = null;					//PDTO(Data Transfer Object including Parameters)
 	Exception serverException   = null;			//error from server
 	String strErrMsg = "";						//error message
 	int rowCount	 = 0;						//count of DB ResultSet list
 	
 	String successFlag = "";
 	String codeList  = "";
 	String pageRows  = "100";

 	String strUsr_id		= "";
 	String strUsr_nm		= "";
 	Logger log = Logger.getLogger("com.clt.apps.CNTROperatioNPerformanceMgt.TurnTimePerformanceMgt");
	String xml = "";
 	
 	try {
 	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
 		strUsr_id =	account.getUsr_id();
 		strUsr_nm = account.getUsr_nm();
 	   
 	   
 		event = (EesCim1001Event)request.getAttribute("Event");
 		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

 		if (serverException != null) {
 			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
 		}
 		
 		// adding logic to get data from server when first loading
 		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		xml = HttpUtil.makeXML(request,response);
 		
 	}catch(Exception e) {
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
<form name="form" >
<input type="hidden" name="sXml" id="sXml" value="<%=xml%>">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="from" id="from">
<input type="hidden" name="to" id="to">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--
		--><button type="button" class="btn_normal" name="btn_downExcel" id="btn_downExcel">Down Excel</button>	
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->
<!-- opus_design_inquiry(S) -->
<div class= "wrap_search_tab">
	<div class= "opus_design_inquiry wFit">
		<table>
			<tbody>
				<colgroup>
					<col width="60"/>
					<col width="120"/>
					<col width="180"/>
					<col width="85"/>
					<col width="160"/>
					<col width="60"/>
					<col width="100"/>
					<col width="80"/>
					<col width="*"/>
			    </colgroup>
				<tr>
					<th>Period</th>
					<td><select style="width:125;" class="input1" name="period" ><!--
						--><option value="M" selected>Month(YYYY-MM)</option><!--
						--><option value="W" > Week(YYYY-WW)</option><!--
						--></select></td>
					<td><input type="text" style="width:54px" class="input1" value="" name="froms" id="froms" caption="FM" required dataformat="ym" maxlength="6">~&nbsp;<!--
						--><input type="text" style="width:54px" class="input1" value="" name="tos" id="tos" required dataformat="ym" caption="TO" maxlength="6"></td>
					<th>Location </th>
					<td><select style="width:90px;" class="input" name="inquiryLevel" id="inquiryLevel">
						<option value="A" selected></option>
						<option value="R" >RCC</option>
						<option value="C" >Country</option>
						<option value="P" >POL</option>
						</select><input type="text"  disabled style="width:55px;" class="input"  name="location" id="location" value="" dataformat="engup" style="ime-mode:disabled" maxLength ="5"><button type="button" id="btn_loc_cd" name="btn_loc_cd" class="input_seach_btn"></button></td>
					<th>Port Com</th>
					<td><select style="width:90px;" class="input" name="portcom" id="portcom">
						<option value="A" selected></option>
						<option value="S" >Same</option>
						<option value="D" >Different</option>
						</select></td>
					<th>Flow Pattern</th>	
					<td><select style="width:100px;" class="input" name="flowpattern" id="flowpattern">
						<option value="5" selected>Excl MIMO</option>
						<option value="A">ALL</option>
						<option value="1" >FI -> FO</option>
						<option value="2" >FI -> MO</option>
						<option value="3" >MI -> FO</option>
						<option value="4" >MI -> MO</option>
						</select></td>
				</tr>
				<tr>
					<th>TP/SZ</th>
					<td class="sm pad_left_8" colspan="2">
						<input type="radio" id="tpsz_all" name="tpsz" checked value="A"><label for="tpsz_all">All</label><!--
						--><input type="radio" id="tpsz_dry" name="tpsz" value="D"><label for="tpsz_dry">DRY</label><!--
						--><input type="radio" id="tpsz_spcl" name="tpsz" value="S"><label for="tpsz_spcl">SPCL</label><!--
						--><input type="radio" id="tpsz_reefer" name="tpsz" value="R"><label for="tpsz_reefer">Reefer</label><!--
						--><select style="width:100px;" class="input" name="rdtype" id="rdtype" disabled>
							<option value="I" selected>Include R/D</option>
							<option value="E">Exclude R/D</option>
							<option value="O">Only R/D</option>
							</select></td>
					<th>T/S CNTR</th>
					<td><select style="width:90px;" class="input" name="tscntr" id="tscntr">
						<option value="E" selected>Exclude</option>
						<option value="I">Include</option>
						<option value="O">Only</option>
						</select></td>
					<th>S.O.C </th>
					<td colspan="3"><select style="width:90px;" class="input"  name="soc" id="soc">
						<option value="E" selected>Exclude</option>
						<option value="I">Include</option>
						<option value="O">Only</option>
						</select></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->

<div class="wrap_result">
	<!-- opus_tab_btn(S) -->
		<div class="opus_design_tab sm">
			<script type="text/javascript">ComTabObject('tab1')</script>
		</div>
	<!-- opus_tab_btn(E) -->
	<div id="tabLayer" style="display:inline">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid clear" >
				<script type="text/javascript">ComSheetObject('t1sheet1');</script>
		</div>
		<!-- opus_design_grid(E) -->
	</div>
	<div id="tabLayer" style="display:none">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid clear" >
				<script type="text/javascript">ComSheetObject('t2sheet1');</script>
		</div>
		<!-- opus_design_grid(E) -->
	</div>
</div>
</form>
