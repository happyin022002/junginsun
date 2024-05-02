<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SAQ_0048.jsp
*@FileTitle  : Monthly Quota Adjustment
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/07
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>

<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttrade.event.EsmSaq0048Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmSaq0048Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String loginOfcCd       = "";
	Logger log = Logger.getLogger("com.clt.apps.MonthlySalesQuotaManage.MonthlyQuotaAdjustmentTrade");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		loginOfcCd = account.getOfc_cd();		


		event = (EsmSaq0048Event)request.getAttribute("Event");
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

<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="glineVerNo" id="glineVerNo" />
<input type="hidden" name="mQtaVerNo" id="mQtaVerNo" />
<input type="hidden" name="mQtaStepCd" id="mQtaStepCd" />
<input type="hidden" name="mqtaMdlVerNo" id="mqtaMdlVerNo" />
<input type="hidden" name="slsFcastPubNo" id="slsFcastPubNo" />
<input type="hidden" name="inclPortFlag" id="inclPortFlag" />
<!-- Outer Table (S)-->
<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" type="button" id="btn_retrieve" name="btn_retrieve">Retrieve</button>
		<button class="btn_normal" type="button" id="btn_new" name="btn_new">New</button>
		<button class="btn_normal" type="button" id="btn_save" name="btn_save">Save</button>
		<button class="btn_normal" type="button" id="btn_saveasnew" name="btn_saveasnew">Save As New Version</button>
		<button class="btn_normal" type="button" id="btn_cancelcurrent" name="btn_cancelcurrent">Cancel Current Version</button>
		<button class="btn_normal" type="button" id="btn_confirmdraft" name="btn_confirmdraft">Confirm</button>
		<button class="btn_normal" type="button" id="btn_cancelconfirmation" name="btn_cancelconfirmation">Cancel Confirmation</button>
		<button class="btn_normal" type="button" id="btn_notifydraft" name="btn_notifydraft">Notify</button>
		<button class="btn_normal" type="button" id="btn_cancelnotification" name="btn_cancelnotification">Cancel Notification</button>
		</div>
	<!-- opus_design_btn (E) -->
	
	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_search_tab">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<table>
			<colgroup>
				<col width="70" />				
				<col width="70" />
				<col width="70" />				
				<col width="70" />
				<col width="70" />				
				<col width="80" />				
				<col width="70" />				
				<col width="200" />				
				<col width="50" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
					<th>Origin</th>
					<td><input class="input1" style="width:70px;" name="ofcCd" value="<%=loginOfcCd%>" readonly id="ofcCd" /> </td>
					<th>Year</th>
					<td><select class="input1" name="year" id="year" style="width:70px;" onchange="year_OnChange(this);"></select></td>
					<th>Quarter</th>
					<td colspan="5"><select class="input1" name="bse_quarter" id="bse_quarter" style="width:60px;" onchange="bse_quarter_onChange(this);"></select></td>
				</tr>
				<tr>
					<th>Target Group</th>
					<td><script type="text/javaScript">ComComboObject("trade_group", 2, 70, 0, 1);</script></td>
					<th>Trade</th>
					<td><select name="trade" id="trade" class="input1" style="width:70px;" onchange="trade_OnChange(this);"></select></td>
					<th>Bound</th>
					<td><select name="bound" id="bound" class="input1" style="width:60px;" onchange="bound_OnChange(this);"></select></td>
					<th>Version</th>
					<td><SELECT name="version" class="input1" style="width:170px;"></SELECT>&nbsp;<img class="cursor" src="/opuscntr/img/button/btns_info2.gif" align="absmiddle" name="help">
					<th>Unit</th>
					<td><select name="unit" id="unit" class="input1" style="width:70px;"></select></td>
				</tr>
		   </tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_tab(S) -->
	<div class="opus_design_tab">
		<script type="text/javascript">ComTabObject('tab')</script>
	</div>
	<!-- opus_design_tab(E) -->
	
	<div id="tabLayer" style="display:inline">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<table>
				<colgroup>
					<col width="120" />				
					<col width="500" />						
					<col width="*" />		
							
			   </colgroup> 
			   <tbody>
			   		<tr>
			   			<th>Performance Period</th>
						<td>
							<select class="input1" name="pfmc_fr_year" id="pfmc_fr_year" style="width:70px;"></select><!-- 
							 --><select class="input1" name="pfmc_fr_month" id="pfmc_fr_month" style="width:55px;"></select>~&nbsp;<!-- 
							 --><select class="input1" name="pfmc_to_year" id="pfmc_to_year" style="width:70px;"></select><!-- 
							 --><select class="input1" name="pfmc_to_month" id="pfmc_to_month" style="width:55px;"></select><!-- 
							 --><button class="btn_etc" type="button" id="btng_go" name="btng_go">Go</button></td>
						<td class="gray" id="sheet_unit" align="right">Unit : TEU / USD / USD 1,000*</td>
			   		</tr>
			   </tbody>
			</table>
			<table>
				<tr><td height="5"></td>
					<td align="right">
					<div class="opus_design_btn"><button class="btn_normal" type="button" id="btng_downexcel" name="btng_downexcel">Down Excel</button>&nbsp;<!-- 
							 --><div id="div_zoom_in1"  style="display:inline" class="grid_option_right"><button type="button" class="btn_down" name="bu_zoom_in1" title="Zoom in(+)"></button></div><!-- 
        					 --><div id="div_zoom_out1" style="display:none"   class="grid_option_right"><button type="button" class="btn_up"   name="bu_zoom_out1"  title="Zoom out(-)" ></button></div>
        			</div>
        			<td>
				</tr>
			</table>
			<script type="text/javascript">ComSheetObject('t1sheet1');</script>		
		</div>
		<div class="opus_design_data" >
			<table>
				<tbody> 	
		       	 	<tr><td colspan=2>
		       	      * Numbers in Tabs above are updated at the time,</td></tr>
				 <tr><td> </td>
				 	 <td>
				 	   - Trade/Bound that you are currently working on : Whenever you save. <br>
					   - Other Trade(s)/Bound(s) : When the status of Version(s) is(are)  "Confirmed", or "Notified".</td></tr>
		       	 <tr><td colspan=2>
				</tbody>
			</table>
			<table><tr><td height="10"></td></tr></table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
	
	
	<div id="tabLayer" style="display:none">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<table>
				<colgroup>
					<col width="90" />				
					<col width="500" />						
					<col width="900" />				
					<col width="*" />				
			   </colgroup>  
			   <tbody>
			   		<tr>
						<th>Performance </th>
						<td>
							<select class="input1" name="pfmc_fr_year" id="pfmc_fr_year" style="width:70px;"></select><!-- 
						 --><select class="input1" name="pfmc_fr_month" id="pfmc_fr_month" style="width:55px;"></select>~&nbsp;<!-- 
						 --><select class="input1" name="pfmc_to_year" id="pfmc_to_year" style="width:70px;"></select><!-- 
						 --><select class="input1" name="pfmc_to_month" id="pfmc_to_month" style="width:55px;"></select><!-- 
						 --><button class="btn_etc" type="button" id="btng_go" name="btng_go">Go</button></td>
						<td class="gray" id="sheet_unit" align="right">Unit : TEU / USD / USD 1,000*</td>
			   		</tr>
			   </tbody>
			</table>
			<table>
				<tr><td height="5"></td>
					<td align="right">
					<div class="opus_design_btn"><button class="btn_normal" type="button" id="btng_downexcel" name="btng_downexcel">Down Excel</button>&nbsp;<!-- 
							 --><div id="div_zoom_in2" style="display:inline" class="grid_option_right"><button type="button" class="btn_down" name="bu_zoom_in2" title="Zoom in(+)"></button></div><!-- 
        					 --><div id="div_zoom_out2" style="display:none" class="grid_option_right"><button type="button" class="btn_up" name="bu_zoom_out2"  title="Zoom out(-)" ></button></div>
        			</div>
        			<td>
				</tr>
			</table>
			
			<script type="text/javascript">ComSheetObject('t2sheet1');</script>		
			</div>
			<!-- opus_design_grid(E) -->
			
			<!-- opus_design_inquiry(S) -->
			<div class="opus_design_data">
				<table>
			   		<tr><td  colspan=2>
							* Numbers in Tabs above are updated at the time,</td></tr>
				   	<tr><td> </td>
				   	   	<td>
				   	   		- Trade/Bound that you are currently working on : Whenever you save. <br>
				   			- Other Trade(s)/Bound(s) : When the status of Version(s) is(are)  "Confirmed", or "Notified".</td></tr>
       		    	<tr><td colspan=2>
				</table>
				<table><tr><td height="10"></td></tr></table>
			</div>
			<!-- opus_design_inquiry(E) -->
	</div>
	
	<div id="tabLayer" style="display:none">
		<!-- opus_design_grid(S) -->
			<div class="opus_design_grid" >
				<table>
					<colgroup>
						<col width="90" />				
						<col width="500" />						
						<col width="900" />				
						<col width="*" />				
				   </colgroup> 
				   <tbody>
				   		<tr>
							<th>Performance </th>
							<td><select class="input1" name="pfmc_fr_year" id="pfmc_fr_year" style="width:70px;"></select><!-- 
							 --><select class="input1" name="pfmc_fr_month" id="pfmc_fr_month" style="width:55px;"></select>~&nbsp;<!-- 
							 --><select class="input1" name="pfmc_to_year" id="pfmc_to_year" style="width:70px;"></select><!-- 
							 --><select class="input1" name="pfmc_to_month" id="pfmc_to_month" style="width:55px;"></select><!-- 
							 --><button class="btn_etc" type="button"  id="btng_go" name="btng_go">Go</button>
							</td>
							<td class="gray" id="sheet_unit" align="right">Unit : TEU / USD / USD 1,000*</td>
	    				</tr>
				   </tbody>
				</table>
				<table>
					<tr><td height="5"></td>
						<td align="right">
						<div class="opus_design_btn"><button class="btn_normal" type="button" id="btng_downexcel" name="btng_downexcel">Down Excel</button>&nbsp;<!-- 
								 --><div id="div_zoom_in3" style="display:inline" class="grid_option_right"><button type="button" class="btn_down" name="bu_zoom_in3" title="Zoom in(+)"></button></div><!-- 
	        					 --><div id="div_zoom_out3" style="display:none" class="grid_option_right"><button type="button" class="btn_up" name="bu_zoom_out3"  title="Zoom out(-)" ></button></div>
	        			</div>
	        			<td>
					</tr>
				</table>
				<script type="text/javascript">ComSheetObject('rhqLaneSheet');</script>		
				</div>
				<!-- opus_design_grid(E) -->
				<!-- opus_design_inquiry(S) -->
				<div class="opus_design_data" >
					<table>
				   		<tr><td colspan=2>* Numbers in Tabs above are updated at the time, </td></tr>
					   	<tr><td>- Trade/Bound that you are currently working on : Whenever you save. <br><!--
								 -->- Other Trade(s)/Bound(s) : When the status of Version(s) is(are)  "Confirmed", or "Notified".</td>
						</tr>
					</table>
					<table><tr><td height="10"></td></tr></table>
				</div>
				<!-- opus_design_inquiry(E) -->
	</div>
</div>	

<!-- layout_wrap(S) -->
<div class="wrap_result">
	<div class="opus_design_inquiry">
		<table>
			<tbody>
				<colgroup>
					<col width="50" />				
					<col width="70" />				
					<col width="80" />				
					<col width="70" />				
					<col width="50" />	
					<col width="70" />				
					<col width="250" />				
					<col width="110" />								
					<col width="*" />				
			   </colgroup> 
		   		<tr>
					<th class="sm">Month</th>
					<td class="sm"><select name="target_month" class="input1" style="width:70px" onchange="target_month_onChange()"></select></td>
					<th class="sm">Sub Trade</th>
					<td class="sm"><select name="search_sub_trd_cd" style="width:70px" onchange="rlane_cd_change()"></select></td>
					<th class="sm">Lane</th>
					<td class="sm"><select name="search_rlane_cd" style="width:80px"></select><button class="btn_etc" type="button" name="btn_go_retrieve" id="btn_go_retrieve">Go</button> </td>
					<th class="sm">Edit Mode</th>
					<td class="sm"><input type="radio" name="edit_mode" value="load" class="trans" checked="" id="edit_mode" />&nbsp;&nbsp;<b>Volume</b>&nbsp;&nbsp;&nbsp;<!-- 
					 --><input type="radio" name="edit_mode" value="rev" class="trans" id="edit_mode" />&nbsp;<b>G.REV</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<!-- 
					 --><input type="radio" name="edit_mode" value="rpb" class="trans" id="edit_mode" />&nbsp;<b>G.RPB</b>
					</td>
					<td class="sm"><button class="btn_etc" type="button" name="btng_monthly_adj" id="btng_monthly_adj">Monthly Adj.</button>
					<td class="sm"></td>			
				</tr>
				<tr>
					<th colspan="7" class="sm">Calculation</th>
					<td class="sm">
						<div id="calc1_div" style="display:display">
							<input type="radio" name="calc1" id="calc1" value="load" class="trans" checked>&nbsp;&nbsp;<b>Volume</b>&nbsp;&nbsp;
							<input type="radio" name="calc1" id="calc1" value="percent" class="trans">&nbsp;<b>Volume(%)</b>&nbsp;&nbsp;&nbsp;
							<input type="radio" name="calc1" id="calc1" value="lf" class="trans">&nbsp;<b>L/F</b>
						</div>
						<div id="calc2_div" style="display:none">
							<input type="radio" name="calc2" id="calc2" value="amount" class="trans" checked>&nbsp;&nbsp;<b>Amount</b>&nbsp;&nbsp;&nbsp;<!-- 
							 --><input name="calc2" name="calc2" type="radio" value="percent" class="trans">&nbsp;<b>%</b></div>
					</td>
					<td class="sm" ><input type="text" style="width:86px;ime-mode:disabled;text-align:right;" value="10" name="calc_value" id="calc_value" /><button class="btn_etc" type="button" id="btng_apply" name="btng_apply">Apply</button></td>
					<td class="sm"></td>
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
					<td class="gray" id="adj_sheet_unit"  align="right" >Unit : TEU / USD </td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear" >
		<div class="opus_design_btn">
			<button class="btn_accent" type="button" id="btn_retrieve2" name="btn_retrieve2">Retrieve</button><!--
			--><button class="btn_normal" type="button" id="btn_save1" name="btn_save1">Save</button><!--
			--><button class="btn_normal" type="button" id="btng_setfinal" name="btng_setfinal">Set Final</button><!--
			--><div id="excel_div" style="display:inline">
			   <button class="btn_normal" type="button" id="btng_excelimportexport" name="btng_excelimportexport">Excel Import/Export</button>
			   </div><!--
			--><button class="btn_normal" type="button" id="btng_adj_downexcel" name="btng_adj_downexcel">Down Excel</button>&nbsp;<!-- 
			--><div id="div_zoom_in4" style="display:inline" class="grid_option_right"><button type="button" class="btn_down" name="bu_zoom_in4" title="Zoom in(+)"></button></div><!-- 
    		--><div id="div_zoom_out4" style="display:none" class="grid_option_right"><button type="button" class="btn_up" name="bu_zoom_out4"  title="Zoom out(-)" ></button></div>
		</div>
		<!-- opus_design_btn (E) -->
		<script type="text/javascript">ComSheetObject('trdGrpAdjSheet');</script>
		<div class="opus_design_data" >
			<tr>* Quarterly Quota is provided based on Weekly Average for reference.<br><!--
	      		-->* Click "<img src="/opuscntr/img/opus/ico_filter.gif" border="0" align="absmiddle" >"  to filter items.</tr>		
		</div>
	</div>
	<!-- opus_design_grid(E) -->
</div>

<div id="hiddenLayer2" style="display:none">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
	      <script type="text/javascript">ComSheetObject('rmkSheet');</script>
    </div>
    <!-- opus_design_grid(E) -->
</div>

</form>
