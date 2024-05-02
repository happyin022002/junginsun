<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SAM_0007.jsp
*@FileTitle  : Sales Activity Management
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/23
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.sam.salesactivitymanage.salesactivitymanage.event.EsmSam0007Event"%>
<%@ page import="org.apache.log4j.Logger" %> 

<%
	EsmSam0007Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	String strSrep_cd		= "";
	String pSlsActSeq 		= "";
	String opn				= "";

	Logger log = Logger.getLogger("com.clt.apps.SalesActivityManage.SalesActivityManage");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		strSrep_cd = account.getSrep_cd();
		opn = request.getParameter("opn");

		event = (EsmSam0007Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
		strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		pSlsActSeq = JSPUtil.getNull(request.getParameter("sls_act_seq"));



		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<head>
<title>Sales Activity Management</title>


<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="hidden_ofc_cd" id="hidden_ofc_cd" />
<input type="hidden" name="usr_id" value="<%=strUsr_id%>" id="usr_id" />
<input type="hidden" name="srep_cd" value="<%=strSrep_cd%>" id="srep_cd" />
<input type="hidden" name="sls_code" value="<%=strSrep_cd%>" id="sls_code" />
<input type="hidden" name="open_page" value="<%=StringUtil.xssFilter(opn)%>" id="open_page" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_new" id="btn_new" type="button">New</button><!--
		--><button class="btn_normal" name="btn_sls_report" id="btn_sls_report" type="button">Sales Report</button><!--
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
				<col width="100" />				
				<col width="120" />				
				<col width="100" />				
				<col width="350" />				
				<col width="100" />				
				<col width="120" />				
				<col width="120" />				
				<col width="100" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
		   			<th>Office Code</th>
					<td><input type="text" style="width:100px;text-align:center;ime-mode:disabled;" name="office_cd" id="office_cd" class="input2" value="<%=strOfc_cd%>" onkeyup="javascript:searchOfficeCodeName(this);" dataformat="engup" maxlength="6" readonly="readonly" id="office_cd" /><button type="button" id="btn_office_code" name="btn_office_code" class="input_seach_btn"></button></td>
					<th>Team Code</th>
					<!-- 2014.08.01 김용습 - width 변경(70 -> 73) -->
					<td><input type="text" style="width:73px;ime-mode:disabled;text-align:center;" name="team_cd" id="team_cd" maxlength="3" class="input" onkeyup="javascript:searchOfficeCodeName(this);" dataformat="engup" id="team_cd" /></td>
					<th>Status</th>
					<td><script type="text/javascript">ComComboObject("combo_status", 1, 73, 1, 0, 0, false); </script></td>
					<th>Activity #</th>
					<td><input type="text" style="width:70px; text-align:center;" name="activity" id="activity" value="<%=pSlsActSeq%>" dataformat="engup" maxlength="8" class="input" id="activity" /></td>
		   		</tr>
		   		<tr>
		   			<th>Sales Rep. Code</th>
		   			<!-- 2014.08.01 김용습 - width 변경(120 -> 129) -->
					<td><input type="text" style="width:129px; text-align:center;" name="sales_rep_cd" id="sales_rep_cd" dataformat="engup" value="<%=strSrep_cd%>" onkeyup="javascript:searchOfficeCodeName(this);" maxlength="5" class="input1" readonly="readonly" id="sales_rep_cd" /></td>
					<th>Search Type</th>
					<td><!-- 
					--><script type="text/javascript">ComComboObject("search_type", 1, 73, 1, 1, 0, false); </script><!-- 
					-->
					
					<!-- 2014.08.01 김용습 - 달력 스타일 변경 -->
					<!-- <input type="text" name="from_date" maxlength="10" dataformat="ymd" style="width: 72px; text-align: center;" readonly="readonly" class="input" id="from_date" />
					<button type="button" id="btns_calendar1" name="btns_calendar1" class="calendar ir"></button>~&nbsp;
					<input type="text" name="to_date" maxlength="10" dataformat="ymd" style="width: 72px; text-align: center;" readonly="readonly" class="input" id="to_date" />
					<button type="button" id="btns_calendar2" name="btns_calendar2" class="calendar ir"></button>
					 -->					
					<input type="text" style="width:80px;ime-mode:disabled;" class="input" name="from_date" dataformat="ymd" maxlength="8" size="10" id="from_date" />~ <!-- 
			        --><input type="text" style="width:80px;ime-mode:disabled;" class="input" name="to_date" dataformat="ymd" maxlength="8" size="10" id="to_date" /><!-- 
			        --><button type="button" class="calendar" name="btn_Calendar" id="btn_Calendar"></button><!-- 
					-->		
					</td>
					<th>Customer Code</th>
					<td><input type="text" style="width:73px; text-align: center;" name="customer_cd" id="customer_cd" dataformat="engup" maxlength="8" onkeyup="javascript:searchOfficeCodeName(this);" class="input" id="customer_cd" /></td>
					<td></td>
					<td></td>
		   		</tr>
		   </tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->
	
	<div class="opus_design_grid">
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_create" id="btn_create" type="button">Create</button><!--
		--><button class="btn_normal" name="btn_new_down" id="btn_new_down" type="button">New</button><!--
		--><button class="btn_normal" name="btn_save" id="btn_save" type="button">Save</button><!--
		--></div>
	<!-- opus_design_btn (E) -->
	</div>
	<div class="opus_design_inquiry ">
	<table>
		<colgroup>
			<col width="100" />				
			<col width="500" />				
			<col width="100" />				
			<col width="*" />				
	   </colgroup> 
	   <tbody>
	   		<tr style="height:30px;">
				<th>Customer</th>
				<td><input type="text" name="cus_code" id="cus_code" style="width:125px; text-align:center;" class="input1" maxlength="8" onkeyup="javascript:searchOfficeCodeName(this);" dataformat="engup" id="cus_code" /><button type="button" id="btn_customer_code" name="btn_customer_code" class="input_seach_btn"></button><input type="text" name="cus_name" style="width:300px;" class="input2" maxlength="100" readonly="readonly" id="cus_name" /></td>
				<th>Created Date</th>
				<td><input type="text" name="cre_dt" id="cre_dt" style="width:131px; text-align:center;" dataformat="ymd" maxlength="10" class="input2" value="" readonly="readonly" id="cre_dt" /></td>		   			
	   		</tr>
	   		<tr style="height:30px;">
				<th>Purpose</th>
				<td><script type="text/javascript">ComComboObject("purpose1", 1, 150, 1, 1, 0, false); </script><script type="text/javascript">ComComboObject("purpose2", 1, 200, 1, 1, 0, false); </script></td>
				<th>Planned Date</th>
				<!-- 2014.08.01 김용습 - width 변경 -->
				<td><input type="text" name="plan_dt" id="plan_dt" style="width:105px; text-align:center;" dataformat="ymd" maxlength="10" class="input1" value="" id="plan_dt" /><button type="button" id="btn_plan_dt" name="btn_plan_dt" class="calendar ir"></button></td>
	   		</tr>
	   		<tr  style="height:30px;">
				<th>Channel</th>
				<td><script type="text/javascript">ComComboObject("channel", 1, 150, 1, 1, 0, false); </script></td>
				<th>Actual Date</th>
				<td><input type="text" name="actual_dt" id="actual_dt" style="width:131px; text-align:center;" dataformat="ymd" maxlength="10" class="input2" value="" readonly="readonly" id="actual_dt" /></td>	   			
	   		</tr>
	   		<tr style="height:30px;">
	   			<td></th>
	   			<td></td>
	   			<th>Create User ID</th>
				<td><input type="text" name="cre_usr_id" id="cre_usr_id" style="width:131px; text-align:center;" maxlength="10" class="input2" readonly="readonly" id="cre_usr_id" /></td>
	   		</tr>
	   </tbody>
	</table>
	
	<table>
		<colgroup>
			<col width="100" />				
			<col width="*" />				
	   </colgroup> 
	   <tbody>
	   		<tr style="height:60px;">
	   			<th>Sales Rep Comment</th>
				<td><textarea type="text" name="srep_cmt_desc" id="srep_cmt_desc" class="input" style="text-indent: 0px;width:855px; height:50px; font-family:Arial; overflow-y:scroll;"></textarea></td>
	   		</tr>
	   		<tr>
	   			<th>Manager Comment</th>
				<td><textarea type="text" name="sls_mgr_cmt_desc" id="sls_mgr_cmt_desc" class="input" style="text-indent: 0px;width:855px; height:50px; font-family:Arial; overflow-y:scroll;"></textarea></td>
	   		</tr>
	   </tbody>
	</table>
	</div>
</div>

</form>