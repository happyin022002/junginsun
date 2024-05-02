<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_SAQ_0049.jsp
*@FileTitle  : Trade Group 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/13
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.saq.monthlysalesquotaadjustmentinquiry.monthlyquotaadjustmentinquiry.event.EsmSaq0049Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EsmSaq0049Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd        = ""; 
	Logger log = Logger.getLogger("com.clt.apps.MonthlySalesQuotaAdjustmentInquiry.MonthlyQuotaAdjustmentInquiry");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();


		event = (EsmSaq0049Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

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
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
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
					<col width="60px"/>
					<col width="90px"/>
					<col width="100px"/>
					<col width="*"/>
			    </colgroup>
				<tr>
					<th>Origin</th>
					<td><input type="text" class="input1" style="width:90px;" value="<%=strOfc_cd%>" name="org" readonly id="org" /> </td>
					<th>Year</th>
					<td><select class="input1" name="year" id="year" style="width:90px;" onchange="version_change();"></select></td>
					<th>Quarter</th>
					<td><select class="input1" name="bse_quarter" id="bse_quarter" style="width:90px;" onchange="version_change();"></select></td>
					<th>Stage</th>
					<td><input type="radio" name="stage" value="SQ" class="trans" checked="" onclick="version_change();" id="stage" />&nbsp;Sales Quota&nbsp;&nbsp;&nbsp;<!--  
						<input type="radio" name="stage" value="LT" class="trans" onclick="version_change();" id="stage" />&nbsp;Load Target-->
					</td>
				</tr>	
				<tr>
					<th>Target Group</th>
					<td><script type="text/javascript">ComComboObject("targetGrp", 2, 90, 0, 1);</script></td>
					<th>Unit</th>
					<td><select name="unit" id="unit" class="input1" style="width:90px;"></select></td>
					<th>Version</th>
					<td><select name="version" id="version" class="input1" style="width:90px;" onchange="javascript:tgtOrzCd_change();"></select></td>
					<td colspan="2"><script type="text/javascript"> monthlyTgtOrzCdCombo("tgtOrzCd");</script></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->
<div class="wrap_result">
	<!-- opus_tab_btn(S) -->
		<div class="opus_design_tab">
			<script type="text/javascript">ComTabObject('tab')</script>
		</div>
	<!-- opus_tab_btn(E) -->
	
	
	<div id="tabLayer" name="tabLayer" style="display:inline">
		<!-- opus_design_grid(S) -->
			<div class="opus_design_grid clear" >				
				<div class="opus_design_inquiry" >
					<table>
						<tbody>
							<colgroup>
								<col width="50px"/>
								<col width="100px"/>
								<col width="50px"/>
								<col width="100px"/>
								<col width="50px"/>
								<col width="100px"/>
								<col width="50px"/>
								<col width="*"/>
							</colgroup>
							<tr>
								<th>Trade</th>
								<td><select name="trade01" id="trade01" style="width:90px;" onchange="subTrade_change()"></select></td>
								<th>Bound</th>
								<td><select name="dirCd01" id="dirCd01" style="width:90px;"></select></td>
								<th>Item</th>
								<td><script type="text/javascript">ComComboObject("item01", 2, 100, 0, 1, 1);</script></td>
								<td><button type="button" class="btn_etc" name="btn_retrieve" id="btn_retrieve">Go</button></td>
								<td align="right" class="gray">Unit : TEU / USD / USD 1,000*</td>
							</tr>
						</tbody>
					</table>
				</div>
				<script type="text/javascript">ComSheetObject('tradeGroupSheet');</script>
			</div>
		<!-- opus_design_grid(E) -->	
	</div>
	
	<div id="tabLayer" name="tabLayer" style="display:none">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid clear" >				
			<div class="opus_design_inquiry" >
				<table>
					<tbody>
						<colgroup>
							<col width="50px"/>
							<col width="100px"/>
							<col width="50px"/>
							<col width="100px"/>
							<col width="50px"/>
							<col width="100px"/>
							<col width="50px"/>
							<col width="*"/>
			    			</colgroup>
						<tr>
							<th>Trade</th>
							<td><select name="trade02" id="trade02" style="width:90px;" class="input1" onchange="subTrade_change()"></select></td>
							<th>Bound</th>
							<td><select name="dirCd02" id="dirCd02" style="width:90px;"></select></td>
							<th>Item</th>
							<td><script type="text/javascript">ComComboObject("item02", 2, 100, 0, 1, 1);</script></td>
							<td><button type="button" class="btn_etc" name="btn_retrieve" id="btn_retrieve">Go</button></td>
							<td align="right" class="gray">Unit : TEU / USD / USD 1,000*</td>
						</tr>
					</tbody>
				</table>
			</div>
			 <script type="text/javascript">ComSheetObject('laneSheet');</script>	
		</div>
		<!-- opus_design_grid(E) -->	
	</div>
	
	
	<div id="tabLayer" name="tabLayer" style="display:none">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid clear" >				
			<div class="opus_design_inquiry" >
				<table>
					<tbody>
						<colgroup>
							<col width="50px"/>
							<col width="100px"/>
							<col width="50px"/>
							<col width="100px"/>
							<col width="50px"/>
							<col width="100px"/>
							<col width="50px"/>
							<col width="*"/>
			    			</colgroup>
						<tr>
							<th>Trade</th>
							<td><select name="trade03" id="trade03" style="width:90px;" class="input1" onchange="subTrade_change()"></select></td>
							<th>Bound</th>
							<td><select name="dirCd03" id="dirCd03" style="width:90px;"></select></td>
							<th>Item</th>
							<td><script type="text/javascript">ComComboObject("item03", 2, 100, 0, 1, 1);</script></td>
							<td><button type="button" class="btn_etc" name="btn_retrieve" id="btn_retrieve">Go</button></td>
							<td align="right" class="gray">Unit : TEU / USD / USD 1,000*</td>
						</tr>
					</tbody>
				</table>
			</div>
			<script type="text/javascript">ComSheetObject('rhqSheet');</script>
		</div>
		<!-- opus_design_grid(E) -->	
	</div>
	
	<div id="tabLayer" name="tabLayer" style="display:none">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid clear" >				
			<div class="opus_design_inquiry" >
				<table>
					<tbody>
						<colgroup>
							<col width="50px"/>
							<col width="100px"/>
							<col width="50px"/>
							<col width="100px"/>
							<col width="50px"/>
							<col width="100px"/>
							<col width="50px"/>
							<col width="50px"/>
							<col width="100px"/>
							<col width="50px"/>
							<col width="100px"/>
							<col width="*"/>
			    			</colgroup>
						<tr>
							<th>RHQ</th>
							<td><script type="text/javascript">ComComboObject("rhqCd04", 2, 75, 0, 0);</script></td>
							<th>Trade</th>
							<td><select name="trade04" id="trade04" class="input1" style="width:90px;" onchange="subTrade_change('C')"></select></td>
							<th>Sub-Trade</th>
							<td><select name="subTrade04" id="subTrade04" class="input1" style="width:90px;"></select></td>
							<th>Bound</th>
							<td><select name="dirCd04" id="dirCd04" class="input1" style="width:90px;"></select></td>
							<th>Item</th>
							<td><script type="text/javascript">ComComboObject("item04", 2, 100, 0, 1, 1);</script></td>
							<td><button type="button" class="btn_etc" name="btn_retrieve" id="btn_retrieve">Go</button></td>
							<td align="right" class="gray">Unit : TEU / USD / USD 1,000*</td>
						</tr>
					</tbody>
				</table>
			</div>
			<script type="text/javascript">ComSheetObject('cOfficeSheet');</script>
		</div>
		<!-- opus_design_grid(E) -->	
	</div>
	
	<div id="tabLayer" name="tabLayer" style="display:none">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid clear" >				
			<div class="opus_design_inquiry" >
				<table>
					<tbody>
						<colgroup>
							<col width="50px"/>
							<col width="100px"/>
							<col width="50px"/>
							<col width="100px"/>
							<col width="50px"/>
							<col width="100px"/>
							<col width="50px"/>
							<col width="100px"/>
							<col width="50px"/>
							<col width="*"/>
			    		</colgroup>
						<tr>
							<th>RHQ</th>
							<td><script type="text/javascript">ComComboObject("rhqCd05", 2, 100, 0, 0);</script></td>
							<th>Trade</th>
							<td><select name="trade05" id="trade05" class="input1" style="width:60px;" onchange="trade05_OnChange()"></select></td>
							<th>Sub Trade</th>
							<td><select name="subTrade05" id="subTrade05" style="width:90px;"></select></td>
							<th>Lane</th>
							<td><script type="text/javascript">ComComboObject("lane05", 4, 70, 0, 0, 2);</script></td>
							<th>Bound</th>
							<td><select name="dirCd05" id="dirCd05" class="input1" style="width:90px;" onchange="subTrade_change('C2');fromAndToWK_change('C2');"></select></td>
						</tr>
						<tr>
							<th>Item</th>
							<td><script type="text/javascript">ComComboObject("item05", 2, 100, 0, 1, 1);</script></td>
							<th>Duration(Week)</th>
							<td><select name="from_wk05" id="from_wk05" class="input1" style="width:60px;" onchange="week_onChange('C2');"></select>&nbsp;~&nbsp;&nbsp;<select name="to_wk05" id="to_wk05" class="input1" style="width:60px;" onchange="week_onChange('C2');"></select></td>
							<td><div id="week_text05" name="week_text05" style="display:inline"></div></td>
							<td><button type="button" class="btn_etc" name="btn_retrieve" id="btn_retrieve">Go</button></td>
							<td colspan="4" align="right" class="gray">Unit : TEU / USD / USD 1,000*</td>							
						</tr>
					</tbody>
				</table>
			</div>
			<script type="text/javascript">ComSheetObject('cOfficeSheet2');</script>
		</div>
		<!-- opus_design_grid(E) -->	
	</div>
</div>
</form>
