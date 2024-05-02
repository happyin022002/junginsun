<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SAQ_0088.jsp
*@FileTitle  : Monthly sales target lookup(RHQ) 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/11
=========================================================
*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.saq.monthlysalesquotaadjustmentinquiry.monthlyquotaadjustmentinquiry.event.EsmSaq0088Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmSaq0088Event  event = null;				//PDTO(Data Transfer Object including Parameters)
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
		event = (EsmSaq0088Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	} catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	function setupPage(){

		loadPage();
	}
</script>

<form name="form">
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="pagerows" name="pagerows" type="hidden" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
	</h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button>
		<button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location"><span id="navigation"></span></div>
</div>
<!-- page_title_area(E) -->


<!-- wrap_search (S) -->
<div class="wrap_search_tab">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<tbody>
				<colgroup>
					<col width="90px"/>
					<col width="120px"/>
					<col width="50px"/>
					<col width="130px"/>
					<col width="70px"/>
					<col width="150px"/>
					<col width="50px"/>
					<col width="150px"/>
					<col width="*" />
				</colgroup>
				<tr class="h23">

					<th>Origin</th>
					<td><input id="rhqCd" class="input1" style="width: 70px;" value="<%=strOfc_cd%>" name="rhqCd" readonly type="text" /> </td>
					<th>Year</th>
					<td><select class="input1" name="year" id="year" style="width: 70px;" onchange="version_change();"></select></td>
					<th>Quarter</th>
					<td><select class="input1" name="bse_quarter" id="bse_quarter" style="width: 90px;" onchange="version_change();"></select></td>
					<th>Stage</th>
					<td><label></label><input id="stage" name="stage" value="SQ" class="trans" checked onclick="version_change();" type="radio" /> Sales Quota
					      <!--  <label></label><input id="stage" name="stage" value="LT" class="trans" onclick="version_change();" type="radio" /> Load Target--></td>
					<td></td>
				</tr>
			</tbody>
		</table>
		<table>
			<tbody>
				<colgroup>

					<col width="90px"/>
					<col width="120px"/>
					<col width="50px"/>
					<col width="130px"/>
					<col width="70px"/>
					<col width="250px"/>
					<col width="50px"/>
					<col width="150px"/>
					<col width="*" />
				</colgroup>
				<tr class="h23">

					<th>Target Group</th>
					<td><script type="text/javascript">ComComboObject("targetGrp", 2, 70, 0, 1);</script></td>
					<th>Unit</th>
					<td><select name="unit" id="unit" class="input1" style="width: 70px;"></select></td>
					<th>Version</th>
					<td><select name="version" id="version" class="input1" style="width: 90px;" onchange="javascript:tgtOrzCd_change();"></select><script type="text/javascript">monthlyTgtOrzCdCombo("tgtOrzCd");</script></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<!-- wrap_search (E) -->
		
<div class="wrap_result">
	<!-- opus_tab_btn(S) -->
	<div class="opus_design_tab">
		<script type="text/javascript">ComTabObject('tab')</script>
	</div>
	<!-- opus_tab_btn(E) -->
	
	<div id="tabLayer" name="tabLayer" style="display:inline">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry">
			<table>
				<tbody>
					<colgroup>
						<col width="10px"/>
						<col width="100px"/>
						<col width="50px"/>
						<col width="100px"/>
						<col width="50px"/>
						<col width="100px"/>
						<col width="70px"/>
						<col width="300px"/>
						<col width="*" />
					</colgroup>
					<tr class="h23">
						<th>Trade</th>
						<td><select name="trade01" id="trade01" style="width: 60px;" ></select></td>
						<th>Bound</th>
						<td><select name="dirCd01" id="dirCd01" style="width: 60px;"></select></td>
						<th>Item</th>
						<td><script type="text/javascript">ComComboObject("item01", 2, 100, 0, 1 , 1);</script><button type="button" class="btn_etc" name="btn_retrieve" id="btn_retrieve">Go</button></td>
						<td></td>
						<td></td>
						<td align="right">
							<table>
							<tr><td class="gray" id="sheet_unit" align="right">Unit : TEU / USD / USD 1,000*</td>
							</tr>
							</table>
						</td>
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
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry">
			<table>
				<tbody>
					<colgroup>
						<col width="10px"/>
						<col width="100px"/>
						<col width="50px"/>
						<col width="100px"/>
						<col width="50px"/>
						<col width="100px"/>
						<col width="70px"/>
						<col width="300px"/>
						<col width="*" />
					</colgroup>
					<tr class="h23">
						<th>Trade</th>
						<td><select name="trade02" id="trade02" style="width: 60px;" class="input1" ></select></td>
						<th>Bound</th>
						<td><select name="dirCd02" id="dirCd02" style="width: 60px;"></select></td>
						<th>Item</th>
						<td><script type="text/javascript">ComComboObject("item02", 2, 100, 0, 1, 1);</script><button type="button" class="btn_etc" name="btn_retrieve" id="btn_retrieve">Go</button></td>
						<td></td>
						<td></td>
						<td align="right">
							<table>
							<tr><td class="gray" id="sheet_unit" align="right">Unit : TEU / USD / USD 1,000*</td>
							</tr>
							</table>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
		
		 <!-- opus_design_grid(S) -->
	      <div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('laneSheet');</script>
	    </div>
	    <!-- opus_design_grid(E) -->
	</div>
	
	
	<div id="tabLayer" name="tabLayer" style="display:none">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry">
			<table>
				<tbody>
					<colgroup>
						<col width="10px"/>
						<col width="100px"/>
						<col width="50px"/>
						<col width="100px"/>
						<col width="50px"/>
						<col width="100px"/>
						<col width="70px"/>
						<col width="300px"/>
						<col width="*" />
					</colgroup>
					<tr class="h23">
						<th>Trade</th>
						<td><select name="trade03" id="trade03" style="width: 60px;" class="input1" ></select></td>
						<th>Bound</th>
						<td><select name="dirCd03" id="dirCd03" style="width: 60px;"></select></td>
						<th>Item</th>
						<td><script type="text/javascript">ComComboObject("item03", 2, 100, 0, 1, 1);</script><button type="button" class="btn_etc" name="btn_retrieve" id="btn_retrieve">Go</button></td>
						<td></td>
						<td></td>
						<td align="right">
							<table>
							<tr><td class="gray" id="sheet_unit" align="right">Unit : TEU / USD / USD 1,000*</td>
							</tr>
							</table>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
		
		 <!-- opus_design_grid(S) -->
	      <div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('rhqSheet');</script>
	    </div>
	    <!-- opus_design_grid(E) -->
	</div>
	
	
	<div id="tabLayer" name="tabLayer" style="display:none">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry">
			<table>
				<tbody>
					<colgroup>
					    <col width="10px"/>
						<col width="100px"/>
						<col width="50px"/>
						<col width="100px"/>
						<col width="50px"/>
						<col width="100px"/>
						<col width="70px"/>
						<col width="50px"/>
						<col width="150px"/>
						<col width="70px"/>
						<col width="*"/>
						<col width="*" />
					</colgroup>
					<tr class="h23">
						<th>Trade</th>
						<td><select name="trade04" id="trade04" style="width: 60px;" class="input1" onchange="subTrade_change('C')"></select></td>
						<th>Sub-Trade</th>
						<td><select name="subTrade04" id="subTrade04" style="width: 60px;"></select></td>
						<th>Bound</th>
						<td><select name="dirCd04" id="dirCd04" style="width: 60px;" class="input1"></select></td>
						<th>Item</th>
						<td><script type="text/javascript">ComComboObject("item04", 2, 100, 0, 1, 1);</script><button type="button" class="btn_etc" name="btn_retrieve" id="btn_retrieve">Go</button></td>
						<td></td>
						<td></td>
						<td align="right">
							<table>
							<tr><td class="gray" id="sheet_unit" align="right">Unit : TEU / USD / USD 1,000*</td>
							</tr>
							</table>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
		
		 <!-- opus_design_grid(S) -->
	      <div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('cOfficeSheet');</script>
	    </div>
	    <!-- opus_design_grid(E) -->
	</div>
	
	
	<div id="tabLayer" name="tabLayer" style="display:none" >
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry">
			<table>
				<tbody>
					<colgroup>
				        <col width="10px"/>
						<col width="100px"/>
						<col width="50px"/>
						<col width="100px"/>
						<col width="50px"/>
						<col width="100px"/>
						<col width="70px"/>
						<col width="50px"/>
						<col width="180px"/>
						<col width="200px"/>
						<col width="*" />
					</colgroup>
					<tr class="h23">
						<th>Trade</th>
						<td><select name="trade05" id="trade05" style="width: 60px;" class="input1" onchange="trade05_OnChange()"></select></td>
						<th>Sub-Trade</th>
						<td><select name="subTrade05" id="subTrade05" style="width: 60px;"></select></td>
						<th>Lane</th>
						<td><script type="text/javascript">ComComboObject("lane05", 4, 100, 0, 0 , 2);</script></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>		
						<th>Area Director</th>
						<td><select name="aqCd05" id="aqCd05" style="width: 110px;"></select></td>
						<th>Bound</th>
						<td><select name="dirCd05" id="dirCd05" class="input1" style="width: 65px;" onchange="subTrade_change('C2');fromAndToWK_change('C2');"></select></td>
						<th>Item</th>
						<td><script language="JavaScript">ComComboObject("item05", 2, 100, 0, 1, 1);</script></td>
						<th>Duration(Week)</th>
						<td><select name="from_wk05" id="from_wk05" class="input1" style="width: 60px;" onchange="week_onChange('C2');"></select> ~ <select name="to_wk05" class="input1" style="width: 60px;" onchange="week_onChange('C2');"></select><button type="button" class="btn_etc" name="btn_retrieve" id="btn_retrieve">Go</button></td>
						<td><div id="week_text05" name="week_text05" style="display:inline"></div></td>
						<td></td>
						<td align="right">
							<table>
							<tr><td class="gray" id="sheet_unit" align="right">Unit : TEU / USD / USD 1,000*</td>
							</tr>
							</table>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
		
		 <!-- opus_design_grid(S) -->
	      <div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('cOfficeSheet2');</script>
	    </div>
	    <!-- opus_design_grid(E) -->
	</div>
</div>	
</form>