<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0046.jsp
*@FileTitle : Lane Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.17
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2009.06.02 유혁
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.event.VopVsk0046Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopVsk0046Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB ResultSet list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.vskcommon.vskcodefinder");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopVsk0046Event)request.getAttribute("Event");
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
			<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button>
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
	            <col width="70px" />
	            <col width="100px" />
	            <col width="70px" />
	            <col width="310px" />
	            <col width="120px" />
	            <col width="" />
	        </colgroup>
	        <tbody>
				<tr class="h23">
					<th>Lane Code</td>
					<td><input type="text" style="width:50px;ime-mode:disabled;text-align:center" class="input" name="vsl_slan_cd" tabindex="1" dataformat="engup" maxlength="3"></th>
					<th>Lane Name</th>
					<th><input type="text" style="width:300px;ime-mode:disabled;" class="input" name="vsl_slan_nm" tabindex="2" dataformat="engup" maxlength="50"></th>
										
					<td  class="wrap_search_btn" style="height:25px;padding-left:10">
						<input type="radio" value="A" class="trans" name="vsl_svc_tp_cd" tabindex="3" checked> <b>All</b> &nbsp;&nbsp;
						<input type="radio" name="vsl_svc_tp_cd" value="TRUNK" class="trans"> <b>Trunk</b>&nbsp;&nbsp;
						
						<!-- 20150407 Off-lane -> Feeder 로 수정 by TaeWoong Kim
						 Because of User's Request
			 			-->	
						<input type="radio" name="vsl_svc_tp_cd" value="O" class="trans"> <b>Feeder</b> 
					</td>
					<td></td>
				</tr>
			</tbody>
		</table>
	    <!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

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