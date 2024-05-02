<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : ESM_SAQ_0089.jsp
*@FileTitle      : Monthly Quota Inquiry(RHQ)
*Open Issues     :
*Change history  :
*@LastModifyDate : 
*@LastModifier   : 
*@LastVersion    :
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.saq.monthlysalesquotaadjustmentinquiry.monthlyquotaadjustmentinquiry.event.EsmSaq0089Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmSaq0089Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	Logger log = Logger.getLogger("com.clt.apps.MonthlySalesQuotaAdjustmentInquiry.MonthlyQuotaAdjustmentInquiry");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (EsmSaq0089Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" 	id="btn_retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_downexcel" 		id="btn_downexcel">Down Excel</button>
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
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
					<col width="90px"/>
					<col width="130px"/>
					<col width="40px"/>
					<col width="130px"/>
					<col width="55px"/>
					<col width="94px"/>
					<col width="100px"/>
					<col width="*"/>
			    </colgroup>
				<tr>
					<th>Origin</th>
					<td><input type="text" class="input1" style="width:90px;" value="<%=strOfc_cd%>" name="ofcCd" readonly id="ofcCd" /> </td>
					<th>Year</th>
					<td><select class="input1" name="year" id="year" style="width:90px;" onchange="version_change();"></select></td>
					<th>Quarter</th>
					<td><select class="input1" name="bse_quarter" id="bse_quarter" style="width:90px;" onchange="version_change();"></select></td>
					<th>Stage</th>
					<td>
						 <!--  <input type="radio" name="stage" id="stage_sq" value="SQ" onclick="version_change();" checked/><label for="stage_sq">Sales Quota</label>--> 
						<input type="radio" name="stage" id="stage_lt" value="LT" checked = "" onclick="version_change();"/><label for="stage_lt">Load Target</label>
					</td>
				</tr>
				<tr>
					<th>Target Group</th>
					<td><script language="JavaScript">ComComboObject("targetGrp", 2, 90, 0, 1);</script></td>
					<th>Unit</th>
					<td><select name="unit" id="unit" class="input1" style="width:90px;"></select></td>
					<th>Version</th>
					<td><select name="version" id="version" class="input1" style="width:90px;" onchange="javascript:tgtOrzCd_change();"></select></td>
					<td colspan="2"><script type="text/javascript">monthlyTgtOrzCdCombo("tgtOrzCd");</script></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->

<div class="wrap_result">
	<!-- opus_tab_btn(S) -->
		<div class="opus_design_tab">
			<script type="text/javascript">ComTabObject('tab1')</script>
		</div>
	<!-- opus_tab_btn(E) -->
	<div id="tabLayer" name="tabLayer" style="display:inline">
	<!-- opus_design_grid(S) -->
		<div class="opus_design_inquiry" >
			<table style="width:100%;">
					<tbody>
						<colgroup>
							<col width="50px"/>
							<col width="90px"/>
							<col width="50px"/>
							<col width="90px"/>
							<col width="50px"/>
							<col width="110px"/>
							<col width="50px"/>
							<col width="*"/>
			    		</colgroup>
						<tr>
							<th>Trade</th>
							<td><select name="trade01" id="trade01" style="width:80px;"></select></td>
							<th>Bound</th>
							<td><select name="dirCd01"  id="dirCd01" style="width:80px;"></select></td>
							<th>Item</th>
							<td><script language="JavaScript">ComComboObject("item01", 2, 100, 0, 1, 1);</script></td>
							<td><button type="button" class="btn_etc" name="btn_retrieve" id="btn_retrieve">Go</button></td>
							<td align="right" class="gray">Unit : TEU / USD / USD 1,000*</td>
						</tr> 
					</tbody>
				</table>
			</div>		
			<!-- opus_design_inquiry(E) -->	
			<!-- opus_design_grid(S) -->
        <div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('tradeGroupSheet');</script>
		</div>
		<!-- opus_design_grid(E) -->
	</div>
	
	
	<div id="tabLayer" name="tabLayer" style="display:none">
		<div class="opus_design_inquiry" >
			<table style="width:100%;">
					<tbody>
						<colgroup>
							<col width="50px"/>
							<col width="90px"/>
							<col width="50px"/>
							<col width="90px"/>
							<col width="50px"/>
							<col width="110px"/>
							<col width="50px"/>
							<col width="*"/>
			    		</colgroup>
						<tr>
							<th>Trade</th>
							<td><select name="trade02" id="trade02" style="width:60px;" class="input1"></select></td>
							<th>Bound</th>
							<td><select name="dirCd02"  id="dirCd02" style="width:60px;"></select></td>
							<th>Item</th>
							<td><script language="JavaScript">ComComboObject("item02", 2, 100, 0, 1, 1);</script></td>
							<td><button type="button" class="btn_etc" name="btn_retrieve" id="btn_retrieve">Go</button></td>
							<td align="right" class="gray">Unit : TEU / USD / USD 1,000*</td>
						</tr> 
					</tbody>
				</table>	
				</div>		
	<!-- opus_design_grid(S) -->
		<div class="opus_design_grid " >
			<script type="text/javascript">ComSheetObject('laneSheet');</script>
		</div>
	<!-- opus_design_grid(E) -->
	</div>
	
	<div id="tabLayer" name="tabLayer" style="display:none">
	<!-- opus_design_grid(S) -->
			<div class="opus_design_inquiry" >
			<table>
					<tbody>
			    		<tr>
			    			<th width="50">Trade</th>
							<td width="110"><select name="trade04" id="trade04" class="input1" style="width:100px;" width="100" onchange="trade04_OnChange()"></select></td>
							<th width="110">Bound</th>
							<td width="80"><select name="dirCd04" id="dirCd04" class="input1" style="width:60px;" onchange="subTrade_change('L2');fromAndToWK_change('L2');"></select></td>
							<th width="40">Sub Trade</th>
							<td width="90"><select name="subTrade04" id="subTrade04" style="width:60px;"></select></td>
							<th width="30">Lane</th>
							<td><script language="JavaScript">ComComboObject("lane04", 4, 100, 0, 0);</script></td>
			    		</tr>
			 		</tbody>
			 </table>
			 <table>
					<tbody>
						<tr>
							<th width="50">Item</th>
							<td width="80"><script language="JavaScript">ComComboObject("item04", 2, 100, 0, 1, 1);</script></td>
							<th width="116">Duration(Week)</th>
							<td width="150"><select name="from_wk04" id="from_wk04" class="input1" style="width:60px;" onchange="week_onChange('L2');"></select> ~ <select name="to_wk04" id="to_wk04" class="input1" style="width:60px;" onchange="week_onChange('L2');"></select></td>
							<td width="1"><div id="week_text04" style="display:inline"></div>
							<td width="50"><button type="button" class="btn_etc" name="btn_retrieve" id="btn_retrieve">Go</button></td>
							<td colspan="3" align="right" class="gray">Unit : TEU / USD / USD 1,000*</td>
						</tr> 
					</tbody>
				</table>
				</div>			
	<!-- opus_design_grid(S) -->
		<div class="opus_design_grid " >
			<script type="text/javascript">ComSheetObject('lOfficeSheet2');</script>
		</div>
	<!-- opus_design_grid(E) -->
	</div>	
</div>
</form>