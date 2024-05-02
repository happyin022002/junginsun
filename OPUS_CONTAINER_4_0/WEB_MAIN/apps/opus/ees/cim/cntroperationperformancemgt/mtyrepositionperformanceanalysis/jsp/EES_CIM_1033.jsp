<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CIM_1033.jsp
*@FileTitle  : Repo Result by Port
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/13
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
<%@ page import="com.clt.apps.opus.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.event.EesCim1033Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesCim1033Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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
		event = (EesCim1033Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		xml = HttpUtil.makeXML(request,response);
	} catch(Exception e) {
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

<form name="form" id="form">
<input type="hidden" name="sXml" value="<%=xml%>" id="sXml" />
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="from" id="from" />
<input type="hidden" name="to" id="to" />
<input type="hidden" name="vvd" id="vvd" />

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
	<div class="opus_design_inquiry wFit">
		<div class="layout_wrap">
			<div class="layout_vertical_2 pad_rgt_8 pad_left_8">
		        <!-- opus_design_inquiry(S) -->
				<div class="opus_design_inquiry">
					<table class="mar_btm_4">
						<colgroup>
							<col width="50" />				
							<col width="70" />				
							<col width="70" />				
							<col width="*" />				
					   </colgroup> 
					   <tbody>
					   		<tr>
					   			<th rowspan="2" class="sm">Option</th>
					   			<td class="sm pad_left_8"><input type="radio" value="P" class="trans" checked name="option" id="option" /> Period</td>
								<td class="sm"><!-- 
								--><select style="width:130px;" class="input1" name="period" id="period"><!-- 
									--><option value="M" selected>Month(YYYY-MM)</option><!-- 
									--><option value="W" >Week(YYYY-WW)</option><!-- 
								--></select><!-- 
								--><input type="text" style="width:60px;" class="input1" value="" name="froms" id="froms" required dataformat="ym" maxlength="6"><!-- 
								-->~&nbsp;<!-- 
								--><input type="text" style="width:60px;" class="input1" value="" name="tos" id="tos" required dataformat="ym" maxlength="6"><!-- 
								--><strong class="pad_left_8 pad_rgt_8" style="margin-left:67px">Lane</strong><script type="text/javascript" >ComComboObject('combo_lane', 2, 63, 0,0,0,true);</script></td>
					   		</tr>
					   		<tr>
					   			<td class="sm pad_left_8"><input type="radio" value="V" class="trans" name="option" id="option" /> VVD</td>
								<td class="sm"><!-- 
								--><input type="text" style="width:100px;" class="input1" value="" name="vvd01" disabled dataformat="engup" maxlength="9" id="vvd01" /><!-- 
								--><input type="text" style="width:100px;" class="input" value="" name="vvd02" disabled dataformat="engup" maxlength="9" id="vvd02" /><!-- 
								--><input type="text" style="width:100px;" class="input" value="" name="vvd03" disabled dataformat="engup" maxlength="9" id="vvd03" /><!-- 
								--><input type="text" style="width:100px;" class="input" value="" name="vvd04" disabled dataformat="engup" maxlength="9" id="vvd04" /><!-- 
								--><button type="button" id="btn_vvd" name="btn_vvd" class="input_seach_btn"></button><!-- 
								--></td>
								<td></td>
					   		</tr>
					   </tbody>
					</table>
					<table>
						<colgroup>
							<col width="100" />				
							<col width="120" />				
							<col width="60" />				
							<col width="120" />				
							<col width="60" />				
							<col width="108" />
							<col width="*" />				
					   </colgroup> 
					   <tbody>
					   		<tr>
					   			<th rowspan="2" class="sm" style="text-align: center">Direction<br>Wise<br><!-- 
								--><select style="width:70px;" class="input"  name="directionwise"><!-- 
									--><option value="F">From</option><!-- 
									--><option value="T" selected>To</option><!-- 
								--></select><!-- 
								--></th>
								<td class="sm pad_left_8"><input type="radio" value="R" name="inquirywise" class="trans" checked id="inquirywise" /> <span id="ft">To/From</span></td>
								<td class="sm"><span id="torcc">TO RCC</span></td>
								<td class="sm"><script type="text/javascript" >ComComboObject('rcc01', 1, 100, 0,1,0,true);</script><input type="hidden" name="rccnext" id="rccnext"></td>
								<td class="sm"><span id="fmrcc">FM RCC</span></td>
								<td class="sm"><script type="text/javascript" >ComComboObject('rcc02', 1, 100, 0,0,0,true);</script></td>
					   		</tr>
					   		<tr>
					   			<td class="sm pad_left_8"><input type="radio" value="P" name="inquirywise" class="trans" id="inquirywise" /> <span id="ld">POD/POL</span></td>
								<td class="sm"><span id="pod">POD</span></td>
								<td class="sm"><script type="text/javascript" >ComComboObject('port01', 1, 100, 0, 1,0,true);</script><input type="hidden" name="portnext"></td>
								<td class="sm"><span id="pol">POL</span></td>
								<td class="sm"><script type="text/javascript" >ComComboObject('port02', 1, 100, 0, 0,0,true);</script></td>
								<td></td>
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
								<td class="sm"><!-- 
								--><input type="radio" class="trans" name="tpsz" checked value="A" id="tpsz" />&nbsp;All&nbsp;&nbsp;<!-- 
								--><input type="radio" class="trans" name="tpsz" value="D" id="tpsz" />&nbsp;DRY&nbsp;&nbsp;<!-- 
								--><input type="radio" class="trans" name="tpsz" value="S" id="tpsz" />&nbsp;SPCL&nbsp;&nbsp;<!-- 
								--><input type="radio" class="trans" name="tpsz" value="R" id="tpsz" />&nbsp;Reefer&nbsp;&nbsp;<!-- 
								--><select style="width: 110px;" class="input" name="rdtype" disabled><!-- 
									--><option value="I" selected>Include R/D</option><!-- 
									--><option value="E">Exclude R/D</option><!-- 
									--><option value="O" >Only R/D</option><!-- 
								--></select><!-- 
								--></td>
					   		</tr>
					   		<tr>
					   			<th class="sm">T/S CNTR</th>
								<td class="sm"><!-- 
								--><input type="radio" class="trans" checked name="tscntr" value="O" id="tscntr" />&nbsp;By ORGN / DSTN&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<!-- 
								--><input type="radio" class="trans" name="tscntr" value="T" id="tscntr" />&nbsp;Through &nbsp;&nbsp;<!-- 
								--><select style="width: 110px;" class="input" name="through" disabled><!-- 
									--><option value="I" >Include T/S</option><!-- 
									--><option value="E" > Exclude T/S</option><!-- 
									--><option value="O" >Only T/S</option><!-- 
								--></select><!-- 
								--></td>
					   		</tr>
					   </tbody>
					</table>
					<table>
						<colgroup>
							<col width="80" />				
							<col width="117" />				
							<col width="70" />				
							<col width="*" />				
					   </colgroup> 
					   <tbody>
					   		<tr>
					   			<th>Cargo Type</th>
								<td><!-- 
									--><select style="width:100px;" class="input" name="cargotype" ><!-- 
									--><option value="A">ALL </option><!-- 
									--><option value="F" >Full</option><!-- 
									--><option value="M"  selected>MTY</option><!-- 
									--></select><!-- 
								--></td>
								<th>S.O.C</th>
								<td><!-- 
								--><select style="width:111px;" class="input" name="soc"><!-- 
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
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->
</div>

</form>