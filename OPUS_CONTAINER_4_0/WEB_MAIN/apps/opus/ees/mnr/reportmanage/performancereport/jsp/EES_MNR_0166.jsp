<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0166.js
*@FileTitle  : Disposal Performance by Equipment
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.reportmanage.performancereport.event.EesMnr0166Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnr0166Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Occurred error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//Row count of retrieved database data

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	Logger log = Logger.getLogger("com.clt.apps.opus.ees.mnr.reportmanage.performancereport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();


		event = (EesMnr0166Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//Extracting retrieved data from server on load screen
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
		}
		loadPage();
	}
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="p_disp_rsn_cd" id="p_disp_rsn_cd">
<input type="hidden" name="hid_rulabel_type" id="hid_rulabel_type" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!-- 
	 --><button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
	  --><button type="button" class="btn_normal" name="btn_New"  	id="btn_New">New</button><!-- 
	  --><button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button>
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>

	<!-- page_title_area(E) -->
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit" id="mainTable">
		<table>
		<tbody>
			<tr>
				<th width="80">Sold Period</th>
				<td width="200"><!-- 
				 --><input type="text" name="p_str_evnt_dt" id="p_str_evnt_dt" style="width:80px;" class="input1" dataformat="ymd"  caption="From Date">&nbsp;~&nbsp;<!-- 
				  --><input type="text" name="p_end_evnt_dt" id="p_end_evnt_dt" style="width:80px;" class="input1" dataformat="ymd"  caption="To Date" onChange="javascript:obj_change();"><!-- 
				   --><button type="button" class="calendar ir" name="btns_calendar" id="btns_calendar"></button>
				</td>
				<th width="60">EQ Type</th>
				<td width="120">
					<select name="p_eq_knd_cd" id="p_eq_knd_cd" caption="EQ Type" style="width:110px;" class="input1" onChange="javascript:obj_change();">
						<option value="U" selected>Container</option>
						<option value="Z">Chassis</option>
						<option value="G">M.G.Set</option>
					</select>
				</td>
				<th width="78">Location By</th>
				<td> 
					 <select name="p_loc_tp" id="p_loc_tp" style="width:65px;" dataformat="engup" onChange="javascript:obj_change();">
					 <option value="" selected>ALL</option>
					 <option value="RCC">RCC</option>
					 <option value="LCC">LCC</option>
					 <option value="SCC">SCC</option>
					 </select>
				    <input type="text" name="p_loc_cd" id="p_loc_cd" caption="Location" style="width:70px;" value="" class="input2"  onChange="javascript:obj_change();" maxlength="5"  ><!-- 
				    --><button type="button" name="btns_search" id="btns_search" class="input_seach_btn"></button>
				    <input type="checkbox" name="p_chk_usd" id="p_chk_usd"><label for="p_chk_usd">Disposal USD Only</label>
				</td>
			</tr>
			<tr>
				<th>Disposal Kind</th>
				<td><script type="text/javascript">ComComboObject('combo1', 1, 177, 1, 0);</script></td>
				<th>Asset Kind</th>
				<td><script type="text/javascript">ComComboObject('aset_knd', 1, 130, 1, 0);</script></td>
				<th>Buyer By</th>
				<td> <!-- 
				 --><input type="text" name="p_cust_cd" id="p_cust_cd" caption="Buyer" style="width:65px;text-align:center" onChange="javascript:obj_change();" class="input" maxlength="8"><!-- 
				  --><button type="button" name="btns_search2" id="btns_search2" class="input_seach_btn"></button>&nbsp;<!-- 
				   --><input type="text" name="p_vndr_nm" id="p_vndr_nm" style="width:247px" class="input2" readOnly="true">
				</td>
				
				<th>RU Label</th>
				<td><input type="text"  name="rstr_usg_lbl" id="rstr_usg_lbl"   style="ime-mode:inactive;background-color:#ffffff"  style="width:150px;" class="input" value=""> <button type="button" id="btn_rulabel_cd" name="btn_rulabel_cd" class="input_seach_btn"></button></td>
				
			</tr>
		</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<!-- opus_design_btn(E) -->
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>