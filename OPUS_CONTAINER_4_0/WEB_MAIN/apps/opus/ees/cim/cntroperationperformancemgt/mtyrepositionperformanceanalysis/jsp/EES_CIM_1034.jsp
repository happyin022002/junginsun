<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CIM_1034.jsp
*@FileTitle  : Repo Result by Location
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/17
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.io.HttpUtil"%> 
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.event.EesCim1034Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesCim1034Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			// error from server
	String strErrMsg = "";						// error message
	int rowCount	 = 0;						// count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.CNTROperatioNPerformanceMgt.MTYRepositionPerformanceAnalysis");
	String xml = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesCim1034Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//adding logic to get data from server when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		xml = HttpUtil.makeXML(request,response);

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<head>
<title>Repo Result by Location</title>


<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="sXml" value="<%=xml%>" id="sXml" />
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<!-- developer job	-->
<input type="hidden" name="from" id="from" />
<input type="hidden" name="to" id="to" />
<input type="hidden" name="inquiryLevel" value="O" id="inquiryLevel" />
<input type="hidden" name="location" id="location" />

<!-- page_title_area(S) -->
<div class="page_title_area">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_new" id="btn_new" type="button">New</button><!--
		--><button class="btn_normal" name="btn_DownExcel" id="btn_DownExcel" type="button">Down Excel</button><!--
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
	<div class="layout_wrap wFit">
		<div class="layout_vertical_2 pad_rgt_8 pad_left_8">
	        <!-- opus_design_inquiry(S) -->
			<div class="opus_design_inquiry wFit">
				<table class="mar_btm_4">
					<colgroup>
						<col width="50" />				
						<col width="*" />				
				   </colgroup> 
				   <tbody>
				   		<tr>
				   			<th>Period</th>
							<td><!-- 
							--><select style="width:130px;" class="input1" name="period" id="period"><!-- 
								--><option value="M" selected>Month(YYYY-MM)</option><!-- 
								--><option value="W" >Week(YYYY-WW)</option>
								</select>
								<input type="text" style="width:55px;" class="input1" value="" name="froms" id="froms" required dataformat="ym" maxlength="6">
								~ <input type="text" style="width:55px;" class="input1" value="" name="tos" id="tos" required dataformat="ym" maxlength="6"></td>
				   		</tr>
				   </tbody>
				</table>
				<table class="mar_btm_4">
					<colgroup>
						<col width="110" />				
						<col width="100" />				
						<col width="50" />				
						<col width="130" />
						<col width="50" />						
						<col width="*" />				
				   </colgroup> 
				   <tbody>
				   		<tr>
				   			<th rowspan="2" class="sm" style="text-align: center"><!-- 
							-->Direction Wise<br><!-- 
							--><select style="width:90px;" class="input"  name="directionwise" id="directionwise"><!-- 
								--><option value="F">From</option><!-- 
								--><option value="T" selected>To</option><!-- 
							--></select><!-- 
							--></th>
							<td class="sm"><input type="radio" value="R" name="inquirywise" id="inquirywise_R" checked/><label for="inquirywise_R">Within</label></td>
							<td class="sm">RCC</td>
							<td class="sm">
								<script type="text/javascript" >ComComboObject('rcc', 1, 70, 0,0,0,true);</script>
							</td>
							<td class="sm"></td>
				   		</tr>
				   		<tr>
				   			<td class="sm"><input type="radio" value="L" name="inquirywise" id="inquirywise_L" /><label for="inquirywise_L">Location</label></td>
							<td class="sm"><span id="tt">To</span></td>
							<td class="sm"><!-- 
							--><input type="text" style="width:70px;" value="" name="loccode1" dataformat="engup" maxlength="5" id="loccode1" /><!-- 
							--><button type="button" id="btn_location1" name="btn_location1" class="input_seach_btn"></button><!-- 
							--></td>
							<td class="sm"><!-- 
							--><span id="ff">From</span> <input type="text" style="width:67px;" value="" name="loccode2" dataformat="engup" maxlength="5" id="loccode2" /><!-- 
							--><button type="button" id="btn_location2" name="btn_location2" class="input_seach_btn"></button><!-- 
							--></td>
							<td></td>
				   		</tr>
				   </tbody>
				</table>
				<table>
					<colgroup>
						<col width="90" />				
						<col width="425" />				
						<col width="*" />				
				   </colgroup> 
				   <tbody>
				   		<tr>
				   			<th class="sm">Inquiry Level</th>
							<td class="sm">
								<input type="radio" name="inquirylevel" value="L" id="inquirylevel_L" checked/><label for="inquirylevel_L">By LCC</label><!-- 
							 --><input type="radio" name="inquirylevel" value="E" id="inquirylevel_E"/><label for="inquirylevel_E">By ECC</label><!-- 
							 --><input type="radio" name="inquirylevel" value="S" id="inquirylevel_S"/><label for="inquirylevel_S">By SCC</label>
							</td>
							<td></td>
				   		</tr>
				   </tbody>
				</table>
			</div>
			<!-- opus_design_inquiry(E) -->
	    </div>
	    <div class="layout_vertical_2 pad_rgt_8 pad_left_8">
	        <!-- opus_design_inquiry(S) -->
			<div class="opus_design_inquiry">
				<table class="mar_btm_4">
					<colgroup>
						<col width="70" />				
						<col width="*" />				
				   </colgroup> 
				   <tbody>
				   		<tr>
				   			<th class="sm">TP/SZ</th>
							<td class="sm">
								<input type="radio" name="tpsz" checked value="A" id="tpsz_A"/><label for="tpsz_A">All</label><!-- 
							 --><input type="radio" name="tpsz" value="D" id="tpsz_D"/><label for="tpsz_D">DRY</label><!-- 
							 --><input type="radio" name="tpsz" value="S" id="tpsz_S"/><label for="tpsz_S">SPCL</label><!-- 
							 --><input type="radio" name="tpsz" value="R" id="tpsz_R"/><label for="tpsz_R">Reefer</label>
								<select style="width:100px;" class="input" name="rdtype" disabled>
									<option value="I" selected>Include R/D</option>
									<option value="E">Exclude R/D</option>
									<option value="O" >Only R/D</option>
								</select>
							</td>
				   		</tr>
				   </tbody>
				</table>
				<table>
					<colgroup>
						<col width="103" />				
						<col width="100" />				
						<col width="80" />				
						<col width="*" />				
				   </colgroup> 
				   <tbody>
				   		<tr>
				   			<th>Cargo Type</th>
							<td><!-- 
								--><select style="width:100px;" class="input" name="cargotype" ><!-- 
								--><option value="A">ALL </option><!-- 
								--><option value="F" >Full</option><!-- 
								--><option value="E"  selected>Empty</option><!-- 
								--></select><!-- 
							--></td>
							<th>S.O.C</th>
							<td><!-- 
							--><select style="width:100px;" class="input" name="soc"><!-- 
								--><option value="E" selected>Exclude</option><!-- 
								--><option value="I" >Include</option><!-- 
								--><option value="O" >Only</option><!-- 
							--></select>
							</td>
				   		</tr>
				   </tbody>
				</table>
			</div>
			<!-- opus_design_inquiry(E) -->
	    </div>
	</div>
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->
</div>

</form>