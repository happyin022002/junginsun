<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_SAQ_0156.jsp
*@FileTitle  : Monthly Quota Adjustment 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/23
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentslsrhq.event.EsmSaq0156Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmSaq0156Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String loginOfcCd       = "";
	
	Logger log = Logger.getLogger("com.clt.apps.MonthlySalesQuotaManage.MonthlyQuotaAdjustmentSlsRHQ");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id  = account.getUsr_id();
		strUsr_nm  = account.getUsr_nm();
		loginOfcCd = account.getOfc_cd();


		event = (EsmSaq0156Event)request.getAttribute("Event");
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
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="glineVerNo" id="glineVerNo" />
<input type="hidden" name="mQtaVerNo" id="mQtaVerNo" />
<input type="hidden" name="mQtaStepCd" id="mQtaStepCd" />
<input type="hidden" name="mqtaMdlVerNo" id="mqtaMdlVerNo" />
<input type="hidden" name="slsFcastPubNo" id="slsFcastPubNo" />
<input type="hidden" name="qta_mst_ver_no" id="qta_mst_ver_no" />
<input type="hidden" name="inclPortFlag" id="inclPortFlag" />
<input type="hidden" name="trade" id="trade" />
<input type="hidden" name="bound" id="bound" />
<input type="hidden" name="trade_group_cd" id="trade_group_cd" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" 	id="btn_retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_new" 		id="btn_new">New</button><!--
		--><button type="button" class="btn_normal" name="btn_save" 		id="btn_save">Save</button><!--
		--><button type="button" class="btn_normal" name="btn_saveasnew" 		id="btn_saveasnew">Save As New Version</button><!--
		--><button type="button" class="btn_normal" name="btn_cancelcurrent"  		id="btn_cancelcurrent">Cancel Current Version</button><!--
		   --><button type="button" class="btn_normal" name="btn_confirmdraft" 	id="btn_confirmdraft">Confirm</button><!--		
		--><button type="button" class="btn_normal" name="btn_cancelconfirmation" 		id="btn_cancelconfirmation">Cancel Confirmation</button><!--
		--><button type="button" class="btn_normal" name="btn_notifydraft" 		id="btn_notifydraft">Notify</button><!--
		--><button type="button" class="btn_normal" name="btn_cancelnotification"  		id="btn_cancelnotification">Cancel Notification</button>	
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
	<div class= "opus_design_inquiry">
		<table>
			<tbody>
				<colgroup>
					<col width="1"/>
					<col width="100"/>
					<col width="100"/>
					<col width="200"/>
					<col width="100"/>
					<col width="*"/>
			    </colgroup>
				<tr>
					<th>Origin</th>
					<td><input style="width:80px;" class="input1" name="ofcCd" value="<%=loginOfcCd%>" readonly id="ofcCd" /> </td>
					<th>Year</th>
					<td><select class="input1" name="year" id="year" style="width:80px;" onchange="year_OnChange(this);"></select></td>
					<th>Quarter</th>
					<td><select class="input1" name="bse_qtr_cd" id="bse_qtr_cd" style="width:80px;" onchange="bse_qtr_cd_onChange(this);"></select></td>
				</tr>	
				<tr>
					<th>Trade-Bound</th>
					<td><select name="combo_tradeDir" id="combo_tradeDir" style="width:80px;" class="input1" onchange="change_tradeDir();"></select></td>
					<th>Version</th>
					<td><SELECT name="version" id="version" class="input1" style="width:190px;"></SELECT><img class="cursor" src="/opuscntr/img/button/btns_info2.gif" align="absmiddle" name="help" id="help">
					<th>Unit</th>
					<td><select name="unit" id="unit" class="input1" style="width:80px;"></select></td>
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
	<div id="tabLayer" style="display:inline">
		<div class= "opus_design_inquiry">
			<table>
				<tbody>
					<colgroup>
						<col width="100"/>
						<col width="300"/>
						<col width="80"/>
						<col width="*"/>
						<col width="20"/>
					</colgroup>
					<tr>
						<th>Performance Period</th>
						<td>
							<select class="input1" name="pfmc_fr_year" id="pfmc_fr_year" style="width:80px;"></select><!--
							--><select class="input1" name="pfmc_fr_month" id="pfmc_fr_month" style="width:60px;"></select>~ <!--
							--><select class="input1" name="pfmc_to_year" id="pfmc_to_year" style="width:80px;"></select><!---
							--><select class="input1" name="pfmc_to_month" id="pfmc_to_month" style="width:60px;"></select>
						</td>
						<td><button type="button" class="btn_etc" name="btng_go"  id="btng_go">Go</button></td>
						<td align="right" class="gray" id="sheet_unit" name="sheet_unit">Unit : TEU / USD / USD 1,000*</td>
					</tr>					
				</tbody>
			</table>
		</div>
		<!-- opus_design_grid(S) -->
			<div class="opus_design_grid clear" >
				<table>
					<tr><td height="5"></td>
						<td align="right">
						<div class="opus_design_btn"><button type="button" class="btn_normal" id="btn_downexcel" name="btn_downexcel">Down Excel</button>&nbsp;<!-- 
								 --><div id="div_zoom_in1" style="display:inline" class="grid_option_right"><button type="button" class="btn_down" name="bu_zoom_in1" title="Zoom in(+)"></button></div><!-- 
	        					 --><div id="div_zoom_out1" style="display:none" class="grid_option_right"><button type="button" class="btn_up" name="bu_zoom_out1"  title="Zoom out(-)" ></button></div>
	        			</div>
	        			<td>
					</tr>
				</table>				
				<script type="text/javascript">ComSheetObject('t1sheet1');</script>
			</div>
		<!-- opus_design_grid(E) -->
		<div class="opus_design_data" >
		 <table>
			<tr><td  colspan=2>* Numbers in Tabs above are updated at the time, </td></tr>
			<tr><td >- Trade/Bound that you are currently working on : Whenever you save. <br>
							   - Other Trade(s)/Bound(s) : When the status of Version(s) is(are)  "Confirmed", or "Notified".</td></tr>
		</table>
		<table><tr><td height="10"></td></tr></table>
		</div>
	</div>
	
	<div id="tabLayer" style="display:none">
	<div class= "opus_design_inquiry">
			<table>
				<tbody>
					<colgroup>
						<col width="80"/>
						<col width="300"/>
						<col width="80"/>
						<col width="*"/>
						<col width="20"/>
					</colgroup>
					<tr>
						<th>Performance</th>
						<td>
							<select class="input1" name="pfmc_fr_year" id="pfmc_fr_year" style="width:80px;"></select><!--
							--><select class="input1" name="pfmc_fr_month" id="pfmc_fr_month" style="width:60px;"></select>~ <!--
							--><select class="input1" name="pfmc_to_year" id="pfmc_to_year" style="width:80px;"></select><!---
							--><select class="input1" name="pfmc_to_month" id="pfmc_to_month" style="width:60px;"></select>
						</td>
						<td><button type="button" class="btn_etc" name="btng_go"  id="btng_go">Go</button></td>
						<td align="right" class="gray" id="sheet_unit" name="sheet_unit">Unit : TEU / USD / USD 1,000*</td>
					</tr>					
				</tbody>
			</table>
		</div>
		<!-- opus_design_grid(S) -->
			<div class="opus_design_grid clear" >
				<table>
					<tr><td height="5"></td>
						<td align="right">
						<div class="opus_design_btn"><button type="button" class="btn_normal" id="btn_downexcel" name="btn_downexcel">Down Excel</button>&nbsp;<!-- 
								 --><div id="div_zoom_in2" style="display:inline" class="grid_option_right"><button type="button" class="btn_down" name="bu_zoom_in2" title="Zoom in(+)"></button></div><!-- 
	        					 --><div id="div_zoom_out2" style="display:none" class="grid_option_right"><button type="button" class="btn_up" name="bu_zoom_out2"  title="Zoom out(-)" ></button></div>
	        			</div>
	        			<td>
					</tr>
				</table>				
				<script type="text/javascript">ComSheetObject('t2sheet1');</script>
			</div>
		<!-- opus_design_grid(E) -->
		<div class="opus_design_data" >
			 <table>
				<tr><td  colspan=2>* Numbers in Tabs above are updated at the time, </td></tr>
				<tr><td >- Trade/Bound that you are currently working on : Whenever you save. <br>
								   - Other Trade(s)/Bound(s) : When the status of Version(s) is(are)  "Confirmed", or "Notified".</td></tr>
			</table>
			<table><tr><td height="10"></td></tr></table>
		</div>
	</div>
	<div id="tabLayer" style="display:none">
		<div class= "opus_design_inquiry">
			<table>
				<tbody>
					<colgroup>
						<col width="80"/>
						<col width="300"/>
						<col width="80"/>
						<col width="*"/>
						<col width="20"/>
					</colgroup>
					<tr>
						<th>Performance</th>
						<td>
							<select class="input1" name="pfmc_fr_year" id="pfmc_fr_year" style="width:80px;"></select><!--
							--><select class="input1" name="pfmc_fr_month" id="pfmc_fr_month" style="width:60px;"></select>~ <!--
							--><select class="input1" name="pfmc_to_year" id="pfmc_to_year" style="width:80px;"></select><!---
							--><select class="input1" name="pfmc_to_month" id="pfmc_to_month" style="width:60px;"></select>
						</td>
						<td><button type="button" class="btn_etc" name="btng_go"  id="btng_go">Go</button></td>
						<td align="right" class="gray" id="sheet_unit" name="sheet_unit">Unit : TEU / USD / USD 1,000*</td>
					</tr>					
				</tbody>
			</table>
		</div>
		<!-- opus_design_grid(S) -->
			<div class="opus_design_grid clear" >
				<table>
					<tr><td height="5"></td>
						<td align="right">
						<div class="opus_design_btn"><button type="button" class="btn_normal" id="btn_downexcel" name="btn_downexcel">Down Excel</button>&nbsp;<!-- 
								 --><div id="div_zoom_in3" style="display:inline" class="grid_option_right"><button type="button" class="btn_down" name="bu_zoom_in3" title="Zoom in(+)"></button></div><!-- 
	        					 --><div id="div_zoom_out3" style="display:none" class="grid_option_right"><button type="button" class="btn_up" name="bu_zoom_out3"  title="Zoom out(-)" ></button></div>
	        			</div>
	        			<td>
					</tr>
				</table>				
				<script type="text/javascript">ComSheetObject('rhqLaneSheet');</script>
			</div>
		<!-- opus_design_grid(E) -->
		 <table>
			<tr><td colspan=2>* Numbers in Tabs above are updated at the time, </td></tr>
			<tr><td >- Trade/Bound that you are currently working on : Whenever you save. <br>
							   - Other Trade(s)/Bound(s) : When the status of Version(s) is(are)  "Confirmed", or "Notified".</td></tr>
		</table>
		<table><tr><td height="10"></td></tr></table>
	</div>
	
</div>

<!-- opus_design_inquiry(S) -->
<div class= "wrap_result">
	<div class= "opus_design_inquiry">
		<table>
			<tbody>
				<colgroup>
					<col width="45"/>
					<col width="80"/>
					<col width="67"/>
					<col width="80"/>
					<col width="33"/>
					<col width="50"/>
					<col width="180"/>
					<col width="100"/>
					<col width="86"/>
					<col width="50"/>
					<col width="*"/>
					<col width="20"/>
			    </colgroup>
				<tr>
					<th class="sm">Month</th>
					<td class="sm"><select name="target_month" id="target_month" class="input1" style="width:60px" onchange="target_month_onChange()"></select></td>
					<th class="sm">Sub Trade</th>
					<td class="sm"><select name="search_sub_trd_cd" id="search_sub_trd_cd" style="width:60px" onchange="rlane_cd_change()"></select></td>
					<th class="sm">Lane</th>
					<td class="sm"><select name="search_rlane_cd" id="search_rlane_cd" style="width:70px"></select></td>
					<td class="sm"><button type="button" class="btn_etc" name="btn_go_retrieve"  id="btn_go_retrieve">Go</button></td>
					<th class="sm">Edit Mode</th>
					<td class="sm"><input type="radio" name="edit_mode" id="edit_mode" value="load" class="trans" checked>Volume&nbsp;&nbsp;&nbsp;<!--
						--><input type="radio" name="edit_mode" id="edit_mode" value="rev" class="trans">G.REV&nbsp;&nbsp;&nbsp;<!--
						--><input type="radio" name="edit_mode" id="edit_mode" value="rpb" class="trans">G.RPB&nbsp;&nbsp;</td>
					<td class="sm"><button type="button" class="btn_etc" name="btng_monthly_adj"  id="btng_monthly_adj">Monthly Adj.</button></td>
					<td class="sm" colspan="2"></td>
				</tr>
				<tr>
					<th class="sm" colspan="8">Calculation</th>
					<td class="sm"><div id="calc1_div" name="calc1_div" style="display:display">
						<input type="radio" name="calc1" id="calc1" value="load" class="trans" checked>Volume</div>
						<div id="calc2_div" style="display:none">
						<input type="radio" name="calc2" id="calc2" value="amount" class="trans" checked>Amount
						<input type="radio" name="calc2" id="calc2" value="percent" class="trans">%</div></td>
					<td class="sm"><input type="text" style="width:85px;ime-mode:disabled;text-align:right;" value="10" name="calc_value" id="calc_value" /><button type="button" class="btn_etc" name="btng_apply"  id="btng_apply">Apply</button></td>
					<td class="sm" colspan="2"></td>
				</tr>
			</tbody>
		</table>	
		<table>
			<tbody>
				<colgroup>
					<col width="*"/>
					<col width="20"/>
			    </colgroup>
			<tr>
			<td align="right" class="gray" id="adj_sheet_unit">Unit : TEU / USD </td>
				</tr>
			</tbody>
		</table>	
	</div>
	<div class="opus_design_grid clear" >
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_retrieve2" id="btn_retrieve2">Retrieve</button><!--
			--><button type="button" class="btn_normal" name="btn_save1" 	id="btn_save1">Save</button><!--
			--><button type="button" class="btn_normal" name="btng_officeadd" 	id="btng_officeadd">Office Add</button><!--
			--><button type="button" class="btn_normal" name="btng_excelimportexport" 	id="btng_excelimportexport">Excel Import/Export</button><!--
			--><button type="button" class="btn_normal" name="btng_adj_downexcel" 	id="btng_adj_downexcel">Down Excel</button>&nbsp;<!-- 
			--><div id="div_zoom_in4" style="display:inline" class="grid_option_right"><button type="button" class="btn_down" name="bu_zoom_in4" title="Zoom in(+)"></button></div><!-- 
    		--><div id="div_zoom_out4" style="display:none"  class="grid_option_right"><button type="button" class="btn_up" name="bu_zoom_out4"  title="Zoom out(-)" ></button></div>
		</div>
		<script type="text/javascript">ComSheetObject('rhqAdjSheet');</script>
	</div>
	<table>
		<tr>
			<td >
	       		* Quarterly Quota is provided based on Weekly Average for reference.<br>
		    	* Click "<img src="/opuscntr/img/opus/ico_filter.gif" border="0" align="absmiddle">"  to filter items.
		   	</td>
    	</tr>
	</table>
</div>
<!-- opus_design_grid(S) -->
<div id="hiddenLayer2" style="display:none">
<div class="wrap_result">
	<div class="opus_design_grid clear" >
			<script type="text/javascript">ComSheetObject('rmkSheet');</script>
	</div>
</div>
<!-- opus_design_grid(E) -->
</div>
</form>