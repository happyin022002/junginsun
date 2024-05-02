<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_S042.js
*@FileTitle  : MNR Invoice Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/02
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.accountmanage.expensemgt.event.EesMnrS042Event" %>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnrS042Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd        = "";
	String strRhq_ofc_cd         = "";
	String strVndr_seq		= "";
	String strVndr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.test.test");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		strRhq_ofc_cd  = account.getRhq_ofc_cd();
		strVndr_seq = account.getOfc_eng_nm();
		strVndr_nm 	= account.getOfc_krn_nm();

		event = (EesMnrS042Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}

%>   
<script type="text/javascript">   

	var currOfcCd = '<%=strOfc_cd %>';
	var rhqOfcCd  = '<%=strRhq_ofc_cd %>';

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
<input type="hidden" name="key_value" id="key_value" />
<input type="hidden" name="inv_sch_type_code" id="inv_sch_type_code" />
<input type="hidden" name="input_date_type_code" id="input_date_type_code" />
<input type="hidden" name="input_type_code" id="input_type_code" />
<input type="hidden" name="mnr_inv_sts_cd" id="mnr_inv_sts_cd" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_New" id="btn_New" type="button">New</button><!--
		--><button class="btn_normal" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button><!--
		--></div>
	<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="70" />				
				<col width="110" />				
				<col width="50" />				
				<col width="150" />				
				<col width="50" />		
				<col width="150" />				
				<col width="60" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
		   			<th>Date</th>
					<td colspan="3"><script type="text/javascript">ComComboObject('combo1',1, 100 , 0,1);</script><!-- 
					 --><input type="text" style="width:80px;" class="input1" name="from_dt" id="from_dt" /><span class="dash">~</span><input type="text" style="width:80px;" class="input1" name="to_dt" id="to_dt" /><button type="button" id="btn_calendar" name="btn_calendar" class="calendar ir"></button></td>
    				<th>Status</th>
					<td><script type="text/javascript">ComComboObject('combo3',1, 100 , 0,0);</script></td>
					<th>INV OFC</th>
					<td><input type="text" style="width:90px;" class="input2" readonly="true" name="user_ofc_cd" value="<%=strOfc_cd %>" id="user_ofc_cd" />  </td>
		   		</tr>
		   		<tr>
		   			<th>S/Provider</th>
					<td><input type="text" name="vndr_seq" style="width:60px;text-align:center" class="input2" dataformat="num" value="<%=strVndr_seq %>" readonly="true" id="vndr_seq" /><input type="text" name="vndr_lgl_eng_nm" style="width:121px;" class="input2" value="<%=strVndr_nm %>" readonly="true" id="vndr_lgl_eng_nm" /> </td>
					<th>INV No.</th>
					<td><input type="text" style="width:80px;" dataformat="engup" class="input" name="inv_no" id="inv_no" /><button type="button" id="btn_inv_no_multy" name="btn_inv_no_multy" class="multiple_inq ir"></button></td>
					<th>W/O No.</th>
					<td><input type="text" style="width:80px;" dataformat="engup" class="input" name="inv_wo_no" id="inv_wo_no" /><button type="button" id="btn_wo_no_multy" name="btn_wo_no_multy" class="multiple_inq ir"></button></td>
					<th>CSR No.</th>
					<td><input type="text" style="width:70px;" dataformat="engup" class="input" name="csr_no" id="csr_no" /><button type="button" id="btn_csr_no_multy" name="btn_csr_no_multy" class="multiple_inq ir"></button></td>
		   		</tr>
		   	</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<table>
			<colgroup>
				<col width="150" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
				<tr><td><h3 class="title_design mar_top_12 mar_btm_8">M&R Invoice List</h3></td>
					<td>
						<!-- opus_design_btn (S) -->
						<div class="opus_design_btn">
							<button class="btn_accent" name="btn_DetailRetrieve" id="btn_DetailRetrieve" type="button">Invoice Detail(s)</button><!--
							--><button class="btn_normal" name="btn_DownExcel" id="btn_DownExcel" type="button">Down Excel</button><!--
							--></div>
						<!-- opus_design_btn (E) -->
					</td>
				</tr>
			</tbody>
		</table>
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<h3 class="title_design mar_top_12 mar_btm_8">M&R Invoice Detail Information</h3>
		<script type="text/javascript">ComSheetObject('sheet2');</script>		
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>

