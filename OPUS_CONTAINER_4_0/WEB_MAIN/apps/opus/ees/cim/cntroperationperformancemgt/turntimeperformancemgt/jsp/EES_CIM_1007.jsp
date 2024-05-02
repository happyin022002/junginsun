<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : EES_CIM_1007.js
*@FileTitle  : Turn Time by Lane  VVD
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/26
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.io.HttpUtil"%> 
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.event.EesCim1007Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesCim1007Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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
	   
	   
		event = (EesCim1007Event)request.getAttribute("Event");
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
<SPAN id="cursors">
<form name="form" >
<input type="hidden" name="sXml" value="<%=xml%>" id="sXml" />
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="from" id="from" />
<input type="hidden" name="to" id="to" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" 	id="btn_Retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_new"  		id="btn_new">New</button><!--
		--><button type="button" class="btn_normal" name="btn_downExcel" 		id="btn_downExcel">Down Excel</button>
			
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->
<!-- opus_design_inquiry(S) -->
<div class= "wrap_search_tab">
	<div class= "opus_design_inquiry wFit">
		<table>
			<tbody>
				<colgroup>
					<col width="1"/>
					<col width="320"/>
					<col width="20"/>
					<col width="110"/>
					<col width="80"/>
					<col width="80"/>
					<col width="80"/>
					<col width="60"/>
					<col width="80"/>
					<col width="*"/>
			    </colgroup>
				<tr>
					<th>Period</th>
					<td><select style="width:125;" class="input1" name="period" id="period" ><!--
						--><option value="M" selected>Month(YYYY-MM)</option><!--
						--><option value="W" > Week(YYYY-WW)</option><!--
						--></select><!--
						--><input type="text" style="width:55px;text-align:center;" class="input1" value="" name="froms" caption="FM" required="" dataformat="ym" maxlength="6" id="froms" />~&nbsp;<!--
						--><input type="text" style="width:55px;text-align:center;" class="input1" value="" name="tos" required="" dataformat="ym" caption="TO" maxlength="6" id="tos" />
					</td>
					<td></td>
					<th class="sm pad_left_8">Inquiry Level </th>
					<td colspan="5" class="sm pad_left_8">POL&nbsp;&nbsp;&nbsp;<input type="hidden" name="prepolnext" id="prepolnext" /><script type="text/javascript" >ComComboObject('pol', 1, 85, 0,0,0,true);</script><input type="hidden" name="polnext" id="polnext" onfocus="polnextfocus()">					
					Lane&nbsp;&nbsp;&nbsp;<script type="text/javascript">ComComboObject('lane', 2, 50, 0,0,0,true);</script><input type="hidden" name="lanenext">&nbsp;&nbsp;
					VVD&nbsp;&nbsp;&nbsp;<script type="text/javascript">ComComboObject('vvd', 1, 100, 0,0,0,true);</script></td>
					<td></td>
				</tr>
				<tr>
					<th class="sm">TP/SZ</th>
					<td class="sm pad_left_8"><input type="radio" class="trans" name="tpsz" checked="" value="A" id="tpsz" />All&nbsp;&nbsp;&nbsp;<!--
					--><input type="radio" class="trans" name="tpsz" value="D" id="tpsz" />DRY&nbsp;&nbsp;&nbsp;<!--
					--><input type="radio" class="trans" name="tpsz" value="S" id="tpsz" />SPCL&nbsp;&nbsp;&nbsp;<!--
					--><input type="radio" class="trans" name="tpsz" value="R" id="tpsz" />Reefer&nbsp;&nbsp;&nbsp;<!--
					--><select style="width:90;" class="input" name="rdtype" disabled><!--
					--><option value="I" selected>Include R/D</option><!--
					--><option value="E">Exclude R/D</option><!--
					--><option value="O" >Only R/D</option><!--
					--></select>
					</td>
					<td></td>
					<th>Flow Pattern</th>				
					<td><select style="width:92;" class="input" name="flowpattern"><!--
							--><option value="5" selected>Excl MIMO</option><!--
							--><option value="A">ALL</option><!--
							--><option value="1" >FI -> FO</option><!--
							--><option value="2" >FI -> MO</option><!--
							--><option value="3" >MI -> FO</option><!--
							--><option value="4" >MI -> MO</option><!--
						--></select></td>
					<th>T/S CNTR</th>
					<td><select style="width:70;" class="input" name="tscntr"><!--
						--><option value="E" selected>Exclude</option><!--
						--><option value="I" >Include</option><!--
						--><option value="O" >Only</option><!--
						--></select></td>
					<th>S.O.C </th>
					<td><select style="width:70;" class="input"  name="soc"><!--
						--><option value="E" selected>Exclude</option><!--
						--><option value="I" >Include</option><!--
						--><option value="O" >Only</option><!--
						--></select></td>
					<td></td>
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
		<div class="opus_design_grid clear" >
			<script type="text/javascript">ComSheetObject('t1sheet1');</script>
		</div>
	</div>
	<div id="tabLayer" style="display:none">
		<div class="opus_design_grid clear" >
			<script type="text/javascript">ComSheetObject('t2sheet1');</script>
		</div>
	</div>
</div>
</form>
</SPAN>