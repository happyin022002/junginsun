<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : EES_LSE_0055.jsp
*@FileTitle  : On off Hire Audit 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/20
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.lse.containercostanalysis.onoffhireaudit.event.EesLse0055Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesLse0055Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.ContainerCostAnalysis.IOnOffHireAudit");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesLse0055Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//getting data from server when load the initial screen
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
<input type="hidden" name="ref_no" id="ref_no" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" 		id="btn_retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_new" 		id="btn_new">New</button><!--
		--><button type="button" class="btn_normal" name="btn_save" 		id="btn_save">Save</button><!--
		--><button type="button" class="btn_normal" name="btn_file" 		id="btn_file">File Import</button><!--
		--><button type="button" class="btn_normal" name="btn_audit"  		id="btn_audit">Audit & Result</button>	
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->
<!-- opus_design_inquiry(S) -->
<div class= "wrap_search">
	<div class= "opus_design_inquiry">
		<table>
			<tbody>
				<colgroup>
					<col width="80px"/>
					<col width="60px"/>
					<col width="150px"/>
					<col width="60px"/>
					<col width="80px"/>
					<col width="60px"/>
					<col width="80px"/>
					<col width="*"/>
			    </colgroup>
				<tr>
					<th>Lessor</th>
					<td colspan="3">
					    <input type="text" name="vndr_seq" style="width:50px;ime-mode:disabled" value="" class="input1" maxlength="6" dataformat="num" id="vndr_seq" /><!--
					    --><button type="button" id="btns_search1" name="btns_search1" class="input_seach_btn"></button><!--
					    --><input type="text" name="vndr_nm" style="width:250px;" value="" class="input2" id="vndr_nm" />
					</td>
					<th>Version</th>
					<td>
					    <script type="text/javascript">ComComboObject('combo_aud_ver_seq', 1, 50, 1 ,1);</script>					    
					</td>			
					<th>Period</th>
					<td>
					   <input type="text" name="search_stdt" style="width:80px;ime-mode:disabled" value="" class="input1" dataformat="ymd" id="search_stdt" />&nbsp;~&nbsp;<!--
					   --><input type="text" name="search_endt" style="width:80px;ime-mode:disabled" value="" class="input1" dataformat="ymd" id="search_endt" /><!--
					   --><button type="button" id="btns_calendar1" name="btns_calendar1" class="calendar ir"></button>
					</td>		
				</tr>	
				<tr>
					<th>AGMT No</th>
					<td>
					   <input type="text" name="agmt_cty_cd" style="width:50px;text-align:center" value="HHO" maxlength="3" class="input2" readonly="" id="agmt_cty_cd" /><!--
					   --><input type="text" name="agmt_seq" style="width:55px;" value="" maxlength="6" class="input" dataformat="num" id="agmt_seq" /><!--
					   --><button type="button" id="btns_search2" name="btns_search2" class="input_seach_btn"></button>
					</td>
					<th>Term</th>
					<td><input type="text" name="lstm_cd" style="width:38px;" value="" class="input2" readonly id="lstm_cd" /> </td>
					<th>Audit Type</th>
					<td class="sm pad_left_4" colspan="2"><input type="radio" name="audit_tp" value="A" style="visibility:hidden" class="trans" id="audit_tp" /><!--
						--><input type="radio" name="audit_tp" value="N" class="trans" checked="" id="audit_tp" />On Hire&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<!--
						--><input type="radio" name="audit_tp" value="F" class="trans" id="audit_tp" />Off Hire
					</td>	
					<td></td>	
				</tr>
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->
<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<div class="opus_design_grid clear" >
			<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
<!-- opus_design_grid(E) -->
<div class="wrap_result">
	<!-- opus_tab_btn(S) -->
		<div class="opus_design_tab sm">
			<script type="text/javascript">ComTabObject('tab1')</script>
		</div>
	<!-- opus_tab_btn(E) -->
	<div id="tabLayer" style="display:inline">
		<div class="opus_design_grid clear" >
			<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_rowInsertCoincidence" id="btn_rowInsertCoincidence">Insert Row</button><!--
			--><button type="button" class="btn_normal" name="btn_rowDeleteCoincidence" 	id="btn_rowDeleteCoincidence">Delete Row</button><!--
			--><button type="button" class="btn_normal" name="btn_DownExcel1" 	id="btn_DownExcel1">Down Excel</button>
		</div>
			<script type="text/javascript">ComSheetObject('t1sheet1');</script>
		</div>
	</div>
	<div id="tabLayer" style="display:none">
		<div class="opus_design_grid clear" >
			<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_coincidenceDiscrepancy" id="btn_coincidenceDiscrepancy">Coincidence<< Discrepancy</button><!--
			--><button type="button" class="btn_normal" name="btn_DownExcel2" 	id="btn_DownExcel2">Down Excel</button>
		</div>
			<script type="text/javascript">ComSheetObject('t2sheet1');</script>
		</div>
	</div>
	<div id="tabLayer" style="display:none">
		<div class="opus_design_grid clear" >
			<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_coincidenceCOM" id="btn_coincidenceCOM">Coincidence<< COM only</button><!--
			--><button type="button" class="btn_normal" name="btn_DownExcel3" 	id="btn_DownExcel3">Down Excel</button>
		</div>
			<script type="text/javascript">ComSheetObject('t3sheet1');</script>
		</div>
	</div>
	<div id="tabLayer" style="display:none">
		<div class="opus_design_grid clear" >
			<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_coincidenceLessor" id="btn_coincidenceLessor">Coincidence<< Lessor Only</button><!--
			--><button type="button" class="btn_normal" name="btn_DownExcel4" 	id="btn_DownExcel4">Down Excel</button>
		</div>
			<script type="text/javascript">ComSheetObject('t4sheet1');</script>
		</div>
	</div>	
	<div id="tabLayer" style="display:none">
			<script type="text/javascript">ComSheetObject('t5sheet1');</script>
		</div>
	</div>	
</div>
</form>