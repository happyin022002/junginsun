<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   EES_MNR_0027.jsp
*@FileTitle  : Repair Cancellation & Deletion
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/15
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.event.EesMnr0027Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnr0027Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Occurred error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//Row count of retrieved database data

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	Logger log = Logger.getLogger("com.clt.apps.OperationManage.RepairMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	    strOfc_cd = account.getOfc_cd();

		event = (EesMnr0027Event)request.getAttribute("Event");
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

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--Use a common at MNR  -->
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<script type="text/javascript">ComSheetObject('sheet1');</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">

<!-- Variable for written estimates and inspection divide -->
<input type="hidden" name="cost_ofc_cd" id="cost_ofc_cd" value="<%=strOfc_cd%>">
<input type="hidden" name="tpb_only" id ="tpb_only" value="N">
<input type="hidden" name="edi_error_only" id="edi_error_only" value="N">
<input type="hidden" name="new_port_only" id="new_port_only" value="N">
<input type="hidden" name="sol_only" id="sol_only" value="N">
<input type="hidden" name="screen_flag" id="screen_flag" value="DEL">
<!-- Developer's task	-->
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
	</h2>
	<!-- page_title(E) -->
<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Cancel</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_Delete" id="btn_Delete">Delete</button><!-- 
	 --></div>
<!-- opus_design_btn(E) -->
<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
<!-- page_location(E) -->
</div>
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<table>
			<tbody>
				<colgroup>
					<col width="100"/>				
					<col width="150"/>
					<col width="80"/>
					<col width="170"/>
					<col width="60"/>
					<col width="160"/>
					<col width="60"/>			
					<col width="*" />
				</colgroup>
					<tr>
						<th>W/O Type </th>
						<td class = "input1"><script type="text/javascript">ComComboObject('wo_type', 1, 130, 1, 1,0,false,0);</script></td>
						<th>EQ Type</th>
						<td><script type="text/javascript">ComComboObject('eq_knd_cd', 1, 130, 1, 1,0,false,0);</script></td>
						<th>Input Date</th>
						<td><span class="inquiry_calendar"><!-- 
								 --><input type="text" name="fm_est_dt" id="fm_est_dt" dataformat="ymd"    caption="from date"        maxlength="10"  size="10"  cofield="to_est_dt" value="" class="input"><!-- 
								 --><span class="dash">-</span><!-- 
		                       	 --><input type="text" name="to_est_dt" dataformat="ymd"    caption="to date"        maxlength="10"  size="10"  cofield="fm_est_dt" class="input"><!-- 
		                       	 --><a class="calendar ir" name="btn_calendar" id="btn_calendar" style="cursor:pointer">calendar</a></span></td>
						<th>Status</th>
						<td><script type="text/javascript">ComComboObject('status_cd', 1, 140, 1, 1,0,false,0);</script></td>													
					</tr>
			</tbody>		
		</table>	
		<table>
			<tbody>
				<colgroup>
					<col width="100"/>				
					<col width="150"/>
					<col width="80"/>
					<col width="178"/>
					<col width="60"/>
					<col width="160"/>
					<col width="60"/>			
					<col width="*" />
				</colgroup>
					<tr>
						<th>EQ No.</th>
						<td><input name="rqst_eq_no" id="rqst_eq_no" type="text" style="width:105px" class="input" dataformat="engup" value=""><button type="button" class="multiple_inq ir" name="eq_no_multi1" id="eq_no_multi1"></button></td>
						<th>EST No.</th>
						<td><input name="rqst_ref_no" id="rqst_ref_no" type="text" style="width:105px" class="input" dataformat="engup" value=""><button type="button" class="multiple_inq ir" name="eq_no_multi2" id="eq_no_multi2"></button></td>
						<th>W/O No.</th>
						<td><input name="wo_no" id="wo_no" type="text" style="width:100px" class="input" dataformat="engup" value=""><button type="button" class="multiple_inq ir" name="eq_no_multi3" id="eq_no_multi3"></button></td>
						<th>TPB Request Only&nbsp;<input name="temp_tpb_only" id="temp_tpb_only" type="checkbox" value="Y" class="trans"></th>	
						<td></td>
					</tr>
			</tbody>		
		</table>	
		<table>
			<tbody>
				<colgroup>
					<col width="100"/>				
					<col width="400"/>
					<col width="198"/>
					<col width="198"/>
					<col width="*" />
				</colgroup>
				<tr>
					<th>Service Provider</th>
					<td><input type="text" name="vndr_seq" id="vndr_seq" caption="Service Provider" style="width:55px;text-align:left;" class="input" value="" dataformat="num" maxlength="6"><!-- 
						 --><button type="button" name="btn_vndr" id="btn_vndr" class="input_seach_btn"></button><!-- 
						 --><input type="text" name="vndr_nm" id="vndr_nm" caption="Service Provider" style="width:241px;" class="input2" value="" readonly></td>
					<td><b>EDI Error Only</b>&nbsp;&nbsp;<input name="temp_edi_error_only" id="temp_edi_error_only" type="checkbox" value="Y" class="trans"></td>
					<td><b>New Port Invoice include</b>&nbsp;&nbsp;<input name="temp_new_port_only" id="temp_new_port_only" type="checkbox" value="Y" class="trans"></td>
					<td><b>SOL Invoice include</b>&nbsp;&nbsp;<input name="temp_sol_only" id="temp_sol_only" type="checkbox" value="Y" class="trans"></td>
				</tr>
				</tbody>		
		</table>
	</div>
</div>
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear" >
	<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_Detail" id="btn_Detail">Detail(s)</button>
	</div>
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>