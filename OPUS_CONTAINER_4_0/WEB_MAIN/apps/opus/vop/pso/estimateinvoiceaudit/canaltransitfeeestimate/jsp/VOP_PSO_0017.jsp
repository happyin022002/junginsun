<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_pso_0017.jsp
*@FileTitle : Canal Invoice
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
<%@ page import="com.clt.apps.opus.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.event.VopPso0017Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopPso0017Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.EstimateInvoiceAudit.CanalTransitFeeBalance");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopPso0017Event)request.getAttribute("Event");
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
<input type="hidden" name="vndr_seq" />
<input type="hidden" name="loc_cd" />
    
    
<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	    
	    <!-- page_title(S) -->
	    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	    <h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	    <!-- page_title(E) -->
	
	    <!-- opus_design_btn(S) -->
	    <div class="opus_design_btn">
	        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
			<button type="button" class="btn_accent" name="btn_Retrieve"     id="btn_Retrieve">Retrieve</button>
			<button type="button" class="btn_normal" name="btn_New"          id="btn_New">New</button>
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
	        	<col width="45px" />
	            <col width="30px" />       
	            <col width="57px" />
	            <col width="100px" />	            
	            <col width="100px" />
	            <col width="170px" />          
	            <col width="70px" />
	            <col width="" />
	        </colgroup>
	        <tbody>
				<tr>
					<th>Month</th>
					<td><input name="revyrmon" type="text" dataformat="ym" maxlength="6" style="ime-mode:disabled;width:55;text-align:center;" class="input1" value=""><button type="button" id="btns_calendar" name="btns_calendar" class="calendar ir"></button></td>
					<th>Port</th>
					<td><select name="port_cd" style="width:70px;" class="input">
						<option value="All" selected>All</option>
						<option value="EGSCA10">EGSCA</option>
						<option value="PAPCA10">PAPCA</option>
						</select></td>
					<th>Service Provider</th>
					<td>
						<script language="javascript">ComComboObject('combo1');</script></td>
						
					<th>Lane Code</th>
					<td><input name="vsl_slan_cd" dataformat="engup" maxlength="3" type="text" style="width:44px;text-align:center;" class="input" value=""><!-- 
					 --><button type="button" class="input_seach_btn" name="btns_search" id="btns_search"></button></td>

				</tr>
				
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>	
<!-- wrap_result(S) -->
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		
	    <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <script language="javascript">ComSheetObject('sheet1');</script>
	    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	<!-- opus_design_grid(E) -->
</div>	
	
</form>