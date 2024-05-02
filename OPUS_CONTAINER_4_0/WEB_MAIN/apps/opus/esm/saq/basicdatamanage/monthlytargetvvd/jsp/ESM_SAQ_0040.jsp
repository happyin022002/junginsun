<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SAQ_0040.jsp
*@FileTitle  :  Target VVD/Supply Management
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/30
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.saq.basicdatamanage.monthlytargetvvd.event.EsmSaq0040Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmSaq0040Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.BasicDataManage.MonthlyTargetVVD");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmSaq0040Event)request.getAttribute("Event");
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
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!--  
	--><button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--  
	--><button type="button" class="btn_normal" name="btn_new"  	id="btn_new">New</button><!--  
	--><button type="button" class="btn_normal" name="btn_save" 	id="btn_save">Save</button><!--  
	--><button type="button" class="btn_normal" name="btn_downexcel"  	id="btn_downexcel">Down Excel</button><!--  
	--><button type="button" class="btn_normal" name="btn_confirm" 	id="btn_confirm">Confirm</button><!--  
	--><button type="button" class="btn_normal" name="btn_cancelconfirmation" 	id="btn_cancelconfirmation">Cancel Confirmation</button><!-- 
	--><button type="button" class="btn_normal" name="btn_skdcopy" id="btn_skdcopy">Notify</button><!--  
	--></div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->

<!-- opus_design_inquiry(S) -->
<div class="wrap_search_tab">
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="40">
				<col width="100">
				<col width="50">
				<col width="80">
				<col width="50">
				<col width="90">
				<col width="50">
				<col width="80">
				<col width="50">
				<col width="90">
				<col width="50">
				<col width="*">
			</colgroup>
	        <tr>
                <th>Year</th>
				<td><select class="input1" name="year" id="year" style="width:70px;"></select></td>
				<th>Quarter</th>
				<td><select class="input1" name="quarter" id="quarter" style="width:60px;"></select></td>
				<th>Trade</th>
				<td><script type="text/javascript">ComComboObject('trade', 2, 60, 0, 0);</script></td>
				<th>Bound</th>
				<td><select name="bound" id="bound" style="width:60px;"></select></td>
				<th>Status</th>
				<td><select name="status_code" id="status_code" style="width:100px;" disabled></select></td>
				<th>Unit</th>
				<td><select name="unit" id="unit" class="input1" style="width:70px;"></select></td>
             </tr>
        </table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<div class="wrap_result">
	<div class="opus_design_tab">
		<script type="text/javascript">ComTabObject('tab1')</script>
	</div>
	<div id="tabLayer" style="display:none" id="mainTable">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn"><!--  
			--><button type="button" class="btn_normal" name="btng_skd" id="btng_skd">SKD Inquiry</button><!--  
			--><button type="button" class="btn_normal" name="btng_update"  	id="btng_update">Update</button><!--  
			--></div>
			<!-- opus_design_btn(E) -->
			<script type="text/javascript">ComSheetObject('sheet2');</script>
		</div>
		<!-- opus_design_grid(E) -->
		<div class="opus_design_data">
			<table>
				<colgroup>
					<col width="190">
					<col width="">
				</colgroup>
		       	<tr>
		       		<td >* Click "<img src="/opuscntr/img/opus/ico_filter.gif" border="0" align="absmiddle" >"  to filter items.</td>
		       		<td>&nbsp;</td>
		       	</tr>
	       	</table>
		</div>
	</div>
	<div id="tabLayer" style="display:inline" id="mainTable">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn"><!--  
			--><button type="button" class="btn_normal" name="btng_disable" id="btng_disable">Disable Lane Selection</button><!--  
			--><button type="button" class="btn_normal" name="btng_skd"  	id="btng_skd">SKD Inquiry</button><!--  
			--><button type="button" class="btn_normal" name="btng_edit" id="btng_edit">Edit</button><!--  
			--><button type="button" class="btn_normal" name="btng_ok"  	id="btng_ok">Apply</button><!--  
			--><button type="button" class="btn_normal" name="btng_cancel" id="btng_cancel">Cancel</button><!--  
			--></div>
			<!-- opus_design_btn(E) -->
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<!-- opus_design_grid(E) -->
		<div class="opus_design_data">
			<table>
				<colgroup>
					<col width="190">
					<col width="">
				</colgroup>
		       	<tr>
		       		<td >* Click "<img src="/opuscntr/img/opus/ico_filter.gif" border="0" align="absmiddle" >"  to filter items.</td>
		       		<td>&nbsp;</td>
		       	</tr>
	       	</table>
		</div>
	</div>
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="mainTable" style="display: none;">
		<script type="text/javascript">ComSheetObject('sheet4');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>
<!-- opus_tab_btn(E) -->
</form>