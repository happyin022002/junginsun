<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CIM_1020.js
*@FileTitle  : Lane M/B by Logistics-Wise
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/23 
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
<%@ page import="com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.event.EesCim1020Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesCim1020Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.CNTROperatioNPerformanceMgt.EQMatchBackNLoadFactorMgt");
	String xml = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesCim1020Event)request.getAttribute("Event");
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
<form name="form"  >
<input type="hidden" name="sXml" value="<%=xml%>" id="sXml" />
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="etcDataValue" value="" id="etcDataValue" />
<input type="hidden" name="from" id="from" />
<input type="hidden" name="to" id="to" />

<!-- page_title_area(S) -->
<div class="page_title_area clear ">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button><!--
			--><button class="btn_normal" name="btn_new" id="btn_new" type="button">New</button><!--
			--><button class="btn_normal" name="btn_downexcel" id="btn_downexcel" type="button">Down Excel</button><!--
			--></div>
		<!-- opus_design_btn (E) -->
	    <!-- page_location(S) -->
	<div class="location">
    <!-- location 내용 동적생성 (별도 코딩 불필요) -->
    <span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="50px" />
				<col width="50px" />
				<col width="180px" />
				<col width="50px" />
				<col width="50px" />
				<col width="50px" />
				<col width="50px" />
				<col width="50px" />
				<col width="50px" />
				<col width="50px" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr >
					<th>Period</th>
					<td>
						<select style="width:130px;" class="input1" name="period" >
							<option value="M" selected>Month(YYYY-MM)</option>
							<option value="W">Week(YYYY-WW)</option>
						</select>
					</td>
					<td>
						<input type="text" style="width:55px;text-align:center;" class="input1" value="" name="froms"id="froms" caption="FM" required dataformat="ym">~ <!-- 
 						--><input type="text" style="width:55px;text-align:center;" class="input1" value="" name="tos" id="tos" required dataformat="ym" caption="TO">
					</td>
					<th class="pad_left_12 sm">Inquiry Level</th>
					<td class="pad_left_12 sm">
						Port<!-- 
						 --><input type="hidden" name="prepolnext" id="prepolnext">
					</td>
					<td class="sm">
						<script type="text/javascript">ComComboObject('pol', 1, 80, 0,0,0,true);</script><!-- 
						 --><input type="hidden" name="polnext" id="polnext">
					</td>
					<td class="sm">Lane</td>
					<td class="sm">
						<script type="text/javascript">ComComboObject('lane', 2, 50, 0,0,0,true);</script><!-- 
						 --><input type="hidden" name="lanenext" id="lanenext">
					</td>
					<td class="sm">VVD</td>
					<td class="sm"><script type="text/javascript">ComComboObject('vvd', 1, 100, 0,0,0,true);</script></td>
					<td></td>
				</tr> 
			</tbody>
		</table>
		<table>
			<colgroup>
				<col width="50px" />
				<col width="50px" />
				<col width="80px" />
				<col width="50px" />
				<col width="50px" />
				<col width="50px" />
				<col width="50px" />
				<col width="50px" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr >
					<th>TP/SZ </th>
					<td><input type="radio" class="trans" name="tpsz" checked="" value="A" id="tpsz" /><label>All</label><input type="radio" class="trans" name="tpsz" value="D" id="tpsz" /><label>DRY</label><input type="radio" class="trans" name="tpsz" value="S" id="tpsz" /><label>SPCL</label><input type="radio" class="trans" name="tpsz" value="R" id="tpsz" /><label>Reefer  </label><select style="width:90;" class="input" name="rdtype" disabled><option value="I" selected>Include R/D</option><option value="E">Exclude R/D</option><option value="O" >Only R/D</option></select></td>
					<th>Cargo Type</th>
					<td ><select style="width:60;" class="input" name="cargotype"><option value="A" selected></option><option value="F">FULL</option><option value="M">MTY</option></select></td>
					<th>T/S CNTR</th>
					<td><select style="width:74;" class="input" name="tscntr"><option value="E" selected>Exclude</option><option value="I" >Include</option><option value="O" >Only</option></select></td>
					<th>S.O.C</th>
					<td><select style="width:82;" class="input" name="soc"><option value="E"selected>Exclude</option><option value="I" >Include</option><option value="O" >Only</option></select></td>
					<td></td>
				</tr> 
			</tbody>
		</table>
	<!-- opus_design_inquiry(E) -->
	</div>
</div>
<!-- wrap_area(E) -->

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	<!-- opus_design_grid(E) -->
</div>
<!-- result_area(E) -->
</form>
</SPAN>