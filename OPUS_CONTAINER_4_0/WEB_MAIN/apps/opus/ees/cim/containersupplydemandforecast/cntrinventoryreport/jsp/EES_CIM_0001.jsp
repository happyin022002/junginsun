<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : EES_CIM_0001.jsp
*@FileTitle  : EQ Operation Trend (Inventory Trend)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/16
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.event.EesCim0001Event"%>
<%@ page import="org.apache.log4j.Logger" %> 

<%
	EesCim0001Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EesCim0001Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="inquiryLevel" value="" id="inquiryLevel" />
<input type="hidden" name="location" value="" id="location" />
<input type="hidden" name="cntr_tpsz_cd" id="cntr_tpsz_cd" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" 	id="btn_Retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_new" 		id="btn_new">New</button><!--
		--><button type="button" class="btn_normal" name="btn_DownExcel"  		id="btn_DownExcel">Down Excel</button><!--
		--><button type="button" class="btn_normal" name="btn_turn_time"  		id="btn_turn_time">Turn Time</button><!--
		--><button type="button" class="btn_normal" name="btn_match_back" 		id="btn_match_back">Match Back</button>
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
	<div class= "opus_design_inquiry">
		<table>
			<tbody>
				<colgroup>
					<col width="80"/>
					<col width="300"/>
					<col width="40"/>
					<col width="350"/>
					<col width="45"/>
					<col width="*"/>
			    </colgroup>
				<tr>
					<th>Location by</th>
					<td>
						<select style="width:115px;" name="loc_type_code" id="loc_type_code" class="input" ><!-- LOC_TYPE_CODE -->
							<option value="" selected>All (by RCC)</option>
							<option value="1">RCC (by LCC)</option>
							<option value="7">RCC (by ECC)</option>
							<option value="8">RCC (by SCC)</option>
							<option value="2">LCC (by ECC)</option>
							<option value="3">LCC (by SCC)</option>
							<option value="4">ECC (by SCC)</option>
							<option value="5">Country</option>
							<option value="6">SCC</option>
							<!-- loc_cd --> 
						</select><input type="text" class="input2" name="loc_cd" readonly="true" style="ime-mode:inactive" dataformat="engup" size="5" maxlength="5" fulfill="" value="" id="loc_cd" /><button type="button" id="btn_loc_cd" name="btn_loc_cd" class="input_seach_btn"></button>
					</td>
					<th>Period</th>
					<td>
						<select name="op_trnd_tp_cd" id="op_trnd_tp_cd" style="width:150px;" class="input1">
							<option value="IM" selected>Month(YYYY-MM)</option>
							<option value="IW">Week(YYYY-WW)</option>
						</select><input type="text" name="from_bse_dt" id="from_bse_dt" required maxlength="6" style="width:60px;" dataformat="ym"  class="input1"  value="">&nbsp;~ <input type="text" id="to_bse_dt" name="to_bse_dt" style="width:60px;" required maxlength="6" dataformat="ym"  class="input1" value="">
					</td>
					<th>TP/SZ</th>
					<td>
						<script type="text/javascript">ComComboObject('com_cntr_tpsz_cd', 1, 115, 1);</script>				
					</td>			
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
		<div class="opus_design_inquiry" >
			<table>
				<colgroup>
					<col width="70px"/>
					<col width="120px"/>
					<col width="*"/>
			    </colgroup>
				<tr>
					<th>Full/MTY</th>
					<td class="sm">&nbsp;&nbsp;<input type="radio" id="long_stay_cd" name="long_stay_cd" checked value="ALL" class="trans">All  <!--
					-->&nbsp;&nbsp;<input type="radio" name="long_stay_cd" id="long_stay_cd" value="FULL" class="trans">Full  <!--
					-->&nbsp;&nbsp;<input type="radio" name="long_stay_cd" id="long_stay_cd" value="MTY" class="trans">MTY</td>
					<td></td>
				</tr>
			</table>
		</div>
			<script type="text/javascript">ComSheetObject('t2sheet1');</script>
		</div>
	</div>
</div>
</form>
