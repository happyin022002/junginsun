<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_EQR_5005.jsp
*@FileTitle  : Forecast Accuracy Review (By Week)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/14
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.event.EesEqr5005Event"%>
<%@ page import="com.clt.apps.opus.ees.eqr.common.eqrcommon.basic.CommonBC"%>
<%@ page import="com.clt.apps.opus.ees.eqr.common.eqrcommon.basic.CommonBCImpl"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesEqr5005Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String loc_tp_cd        = "";
	Logger log = Logger.getLogger("com.clt.apps.MTYEquipmentForecast.MTYEquipmentForecast");
	
	CommonBC tpszUtil = new CommonBCImpl(); 	//Combo BOX
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesEqr5005Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// adding logic to get data from server when first loading ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		String optionStr = "";
		loc_tp_cd    = JSPUtil.getCodeCombo("loc_tp_cd", "", "style='width:75px'", "CD00242", 0, optionStr);

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">
	<%= tpszUtil.getTpSzCodeCombo("eqr", "hidtpszall", "", "", "", "Y", "")%>
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
<input type="hidden" name="search_flag" id="search_flag" />
<input type="hidden" name="inquiryLevel" value="" id="inquiryLevel" />
<input type="hidden" name="location" value="" id="location" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
	<button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!--
	--><button class="btn_normal" name="btn_new" id="btn_new" type="button">New</button><!--
	--><button class="btn_normal" name="btn_downexcel" id="btn_downexcel" type="button">Down Excel</button><!--
	--></div>
	<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->
<!-- wrap_search(S) -->
<div class="wrap_search_tab">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="50" />				
				<col width="72" />				
				<col width="110" />				
				<col width="35" />				
				<col width="160" />				
				<col width="60" />				
				<col width="100" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
					<th>Location</th><!--
					--><td><%=loc_tp_cd%></td><!--
					--><td><input type="text" dataformat="engup" size="5" maxlength="5" caption="Location CD" fulfill="" required style="width:50px;" class="input1" name="loc_cd" value="" id="loc_cd" /><button type="button" id="btn_loc_cd" name="btn_loc_cd" class="input_seach_btn"></button></td>
					<th>Week</th>
					<td><input type="text" style="width:60px;" required maxlength="7" caption="Week From" class="input1" name="fm_week" value="" id="fm_week" dataformat="yw"/>~ <input type="text" style="width:60px;" required maxlength="7" caption="Week To" class="input1" name="to_week" value="" id="to_week" dataformat="yw"/>  </td>
					<th>Forecast</th>
					<td width="100"><select style="width:80px;" class="input" name="bound"><!--
					--><option value="O" selected>O/B</option><!--
					--><option value="I">I/B</option><!--
					--><option value="A">ALL</option><!--
					--></select></td>
					<td><button class="btn_etc" name="btn_t1detail" id="btn_t1detail" type="button">Evaluation Rule</button></td>
		   		</tr>
		   </tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<div class="opus_design_tab">
		<script type="text/javascript"> ComTabObject ('tab1')</script>
	</div>
	<div id="tabLayer" style="display:inline">
		<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('t1sheet1');</script>		
		<h3 class="title_design">Accuracy Ranking</h3>
		<script type="text/javascript">ComSheetObject('t2sheet1');</script>		
		</div>
	</div>
	<div id="tabLayer" style="display:none">
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="370" />				
					<col width="*" />				
				</colgroup> 
				<tbody>
					<tr>
					<td class="sm pad_left_8"><input type="radio" name="view_flag" checked value="" class="trans" id="view_flag" /> All   <input type="radio" name="view_flag" value="1" class="trans" id="view_flag" /> FCST   <input type="radio" name="view_flag" value="2" class="trans" id="view_flag" /> PFMC   <input type="radio" name="view_flag" value="3" class="trans" id="view_flag" /> Diff.Vol   <input type="radio" name="view_flag" value="4" class="trans" id="view_flag" /> Diff.(%)   <input type="radio" name="view_flag" value="5" class="trans" id="view_flag" /> Evaluation</td>
					<td></td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('t1sheet2');</script>		
		</div>
	</div>
</div>
</form>