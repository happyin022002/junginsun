<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName	 : ESM_BKG_0568.jsp
*@FileTitle  : C/A Report 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/02
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingreport.performancereport.event.EsmBkg0568Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.HashMap" %>

<%
	EsmBkg0568Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_cnt		= "";
	String navigation 		= "";
	String description		= "";
	Logger log = Logger.getLogger("com.clt.apps.BookingReport.PerformanceReport");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		//strUsr_cnt= account.getCnt_cd();
		event = (EsmBkg0568Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		// get data from server when load page ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		/*
		description = (String) request.getAttribute("UI_DESCRIPTION");
		navigation = ((String) request.getAttribute("UI_NAVIGATION")).substring(10);
		if (navigation.indexOf("US") > -1){
			strUsr_cnt = "US";
		}else if (navigation.indexOf("Canada") > -1){
			
			strUsr_cnt = "CA";
		}else{
			
			strUsr_cnt = "KR";
		}
		*/
		
		String strPgmNo = request.getParameter("pgmNo");
		if (strPgmNo.startsWith("ESM_BKG_0568-1")) {
			strUsr_cnt = "US";
		} else if (strPgmNo.startsWith("ESM_BKG_0568-2")) {
			strUsr_cnt = "CA";
		} else {
			strUsr_cnt = "KR";
		}
		

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
			document.form.pod_cd.focus();
		}
	</script>
<form name="form">
<input type="hidden" id="f_cmd" name="f_cmd">
<input type="hidden" id="pagerows" name="pagerows">
<input type="hidden" id="bkg_no" name="bkg_no">
<input type="hidden" id="bl_no2" name="bl_no2">
<input type="hidden" id="corr_no" name="corr_no">
<input type="hidden" id="cnt_cd" name="cnt_cd" value="<%= strUsr_cnt %>">
<input type="hidden" id="from_dt" name="from_dt">
<input type="hidden" id="to_dt" name="to_dt">
<input type="hidden" id="manifest" name="manifest">
<input type="hidden" id="vvd2" name="vvd2">
<input type="hidden" id="pol" name="pol">
<input type="hidden" id="pod" name="pod">
<input type="hidden" id="com_mrdTitle" name="com_mrdTitle">
<input type="hidden" id="com_mrdBodyTitle" name="com_mrdBodyTitle">
<input type="hidden" id="com_mrdPath" name="com_mrdPath">
<input type="hidden" id="com_mrdArguments" name="com_mrdArguments">
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_new"  	id="btn_new">New</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_save" 	id="btn_save">Save</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_CheckAll" 	id="btn_CheckAll">Check All</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_UncheckAll" 	id="btn_UncheckAll">Uncheck All</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_print" 	id="btn_print">Print</button>
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
	<div class="opus_design_inquiry wFit">
		<table>
			<tbody>
				<tr>
					<th width="120"><input type="radio" id="pk_tp_ca" name="pk_tp" value="date" checked><label for="pk_tp_ca"><strong>C/A Issue Date</strong></label></th>
					<td width="300"><input type="text" name="from_date" style="width:80px" class="input1" value=""  maxlength="10" size="10" dataformat="ymd" onClick="javascript:changeTP('0')" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)"><!--
						--><input type="text" name="from_time" style="width:40px" class="input1" value=""  maxlength="5" size="5" onClick="javascript:changeTP('0')" OnBeforeDeactivate="ComAddSeparator(this,'hm')" OnBeforeActivate="ComClearSeparator(this,'hm')">~ <input type="text" name="to_date" style="width:80px" class="input1" value=""  maxlength="10" size="10" dataformat="ymd" onClick="javascript:changeTP('0')" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)"><!--
						--><input type="text" name="to_time" style="width:40px" class="input1" value=""  maxlength="5" size="5" onClick="javascript:changeTP('0')" OnBeforeDeactivate="ComAddSeparator(this,'hm')" OnBeforeActivate="ComClearSeparator(this,'hm')"><!--
						--><button type="button" class="calendar ir" name="btn_calendar" id="btn_calendar"></button>
					</td>
					<th width="70"><input type="radio" id="pk_tp_vvd" name="pk_tp"value="vvd"><label for="pk_tp_vvd"><strong>VVD</strong></label></th>
					<td width="90"><input type="text" name="vvd" dataformat="engup" maxlength="9" style="width:80px" class="input1" value="" onClick="javascript:changeTP('1')"></td> 
					<th width="25">POD</th>
					<td width="50"><input type="text" name="pod_cd"  dataformat="engup" maxlength="5" style="width:55px;" class="input1" value=""></td>
					<th width="30">DEL</th>
					<td width="70"><input type="text" name="del_cd" dataformat="engup" maxlength="5" style="width:55px;" class="input" value="" onClick="javascript:changeTP('1')"></td>
					<th width="80"><input type="radio" id="pk_tp_bl" name="pk_tp" value="bl"><label for="pk_tp_bl"><strong>B/L No</strong></label></th>
					<td><input type="text" name="bl_no" dataformat="engup" maxlength="12" style="width:100px" class="input1" value="" onClick="javascript:changeTP('2')"></td>
				</tr> 
			</tbody>
		</table>		
	</div>
</div>

<div class="wrap_result">	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_excel" 	id="btn_excel">Down Excel</button>
		</div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_inquiry(E) -->
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<div class="opus_design_btn">
		<%
		if(strUsr_cnt == "US" || strUsr_cnt == "CA"){
		%>
			<button type="button" class="btn_accent" name="btn_BLInquiry" id="btn_BLInquiry">Manifest Details by B/L</button>
	    <%
		}
		else{
		%>
		  <button type="button" class="btn_accent" name="btn_BLInquiry" id="btn_BLInquiry">B/L Inquiry</button>
		 <%
		}
		%> 
			 <button type="button" class="btn_normal" name="btn_CntrInquiry" id="btn_CntrInquiry">CNTR Inquiry</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_DownExcel2" 	id="btn_DownExcel2">Down Excel</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_print2" 	id="btn_print2">Preview</button>
		</div> 
			<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
<!-- opus_design_grid(E) -->	
</div>
</form>