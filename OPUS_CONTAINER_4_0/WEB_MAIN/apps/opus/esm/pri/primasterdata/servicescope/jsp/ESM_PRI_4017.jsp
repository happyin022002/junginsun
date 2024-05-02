<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_PRI_4017.jsp
*@FileTitle  : Service Scope Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/22
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.primasterdata.servicescope.event.EsmPri4017Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri4017Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.PRIMasterData.ServiceScope");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmPri4017Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// adding logic to get data from server when first loading
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
<!-- developer performance	-->
<input type="hidden" name="cd">

	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		
		<!-- page_title(S) -->
	    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->
	
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button>
			<button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button>			
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
	
<!-- opus_design_inquiry(S) -->
<div class="wrap_search">
	<div class="opus_design_inquiry">
		<!--  MiniLayer (S) -->
		<table>
			<colgroup>
	            <col width="40px" />
	            <col width="250px" />
	            <col width="80px" />
	            <col width="200px" />	            
	            <col width="" />
			</colgroup>
			<tbody>
				<tr>
					<th>Origin</th>
					<td>
						<select name="org_tp_cd" style="width:90px;"class="input">
							<option value="L" selected>Location</option>
							<option value="R">Region</option>
							<option value="C">Country</option>
							<option value="S">S-Conti</option>
						</select>&nbsp;
						<input type="text" name="org_cd" style="width:100px; ime-mode:disabled;" dataformat="engup" minlength="2" maxlength="5" class="input1" required caption="ORIGIN CODE">
					</td>
					<th>Destination</th>
					<td>
						<select name="dest_tp_cd" style="width:90px;"class="input">
							<option value="L" selected>Location</option>
							<option value="R">Region</option>
							<option value="C">Country</option>
							<option value="S">S-Conti</option>
						</select>&nbsp;
						<input type="text" name="dest_cd" style="width:100px; ime-mode:disabled;" dataformat="engup" minlength="2" maxlength="5" class="input1" required caption="DESTINAITON CODE">
					</td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>

	<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<div class="opus_design_grid" id="mainTable">
		<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <script language="javascript">ComSheetObject('sheet1');</script>
	    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
</div>
	
<div class="wrap_result">
	<div class="opus_design_grid" id="mainTable">
		<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <script language="javascript">ComSheetObject('sheet2');</script>
	    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
</div>
	
	<!-- layout_wrap(S) -->
<div class="layout_wrap">
    <div class="layout_vertical_3" style="width: 50%">
		<div class="wrap_result">
			<div class="opus_design_grid" id="mainTable">
				<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
			    <script language="javascript">ComSheetObject('sheet3');</script>
			    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
			</div>
		</div>
	</div>
		
	<div class="layout_vertical_3"  style="width: 50%">
		<div class="wrap_result">
			<div class="opus_design_grid" id="mainTable">
				<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
			    <script language="javascript">ComSheetObject('sheet4');</script>
			    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
			</div>
		</div>
	</div>
</div>
	
	<div class="opus_design_grid" id="mainTable" style="display:none">
		<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <script language="javascript">ComSheetObject('sheet5');</script>
	    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
<!-- opus_design_grid(E) -->
</form>
