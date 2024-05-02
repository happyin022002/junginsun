<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_pso_0009.jsp
*@FileTitle : Estimate VVD Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.event.VopPso0009Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopPso0009Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.PortChargeBudget.BudgetPortChargeMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopPso0009Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	    
	    <!-- page_title(S) -->
	    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	    <h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	    <!-- page_title(E) -->
	         
	   
	    <!-- opus_design_btn(S) -->
	    <div class="opus_design_btn">
	        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
			<button type="button" class="btn_accent" name="btn_retrieve"     id="btn_retrieve">Retrieve</button>
			<button type="button" class="btn_normal" name="btn_creation"          id="btn_creation">Creation</button>
	    </div>
	    <!-- opus_design_btn(E) -->
	    
	    
	    <!-- page_location(S) -->
	    <div class="location">
	        <!-- location 내용 동적생성 (별도 코딩 불필요) -->
	        <span id="navigation"></span>
	    </div>
	    <!-- page_location(E) -->
	</div>
	<!-- page_title_area(E) -->
	
	
<div class="wrap_search">	
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
	    <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <table>
	        <colgroup>
	        	<col width="100px" />
	            <col width="120px" />
	            <col width="35px" />
	            <col width="100px" />
	            <col width="35px" />
	            <col width="100px" />
	            <col width="" />
	        </colgroup>
	        <tbody>
				<tr>
					<th>Accrual Month</th>
					<td>
							<input name="rev_yrmon" dataformat="ym" maxlength="6" type="text" style="ime-mode:disabled; width:65px; text-align:center;" class="input1" value=""><button type="button" id="btns_calendar_s" name="btns_calendar_s" class="calendar ir"></button>
					</td>
					<th>Lane</th>
					<td><input type="text" name="vsl_slan_cd" dataformat="engup" maxlength="3" style="ime-mode:disabled; width:45px; text-align:center;" class="input" value=""><!-- 
					 --><button type="button" class="input_seach_btn" name="btns_search" id="btns_search"></button></td>
					<th>Status</th>						
					<td width=""><input type="text" name="status" class="input2" readonly/></td>
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
		
		<!-- opus_grid_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_down_excel" id="btn_down_excel">Down Excel</button><!--
			--></div>
		<!-- opus_grid_btn(E) -->
			
			
	    <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <script language="javascript">ComSheetObject('sheet1');</script>
	    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	<!-- opus_design_grid(E) -->
</div>	

</form>