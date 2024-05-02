<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ui_mnr_0135.jsp
*@FileTitle : Equipment Repair Approval Authority Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/14
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.generalmanage.officegeneralinfomgt.event.EesMnr0135Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnr0135Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//count of DB resultSet list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String rhqOfcCd         = "";
	String currOfcCd       = "";
	String currOfcEngNm     = "";
	Logger log = Logger.getLogger("com.clt.apps.opus.ees.mnr.generalmanage.officegeneralinfomgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id         =	account.getUsr_id();
		strUsr_nm       = account.getUsr_nm(); 
		rhqOfcCd        = account.getRhq_ofc_cd();
		currOfcCd       = account.getOfc_cd();
		currOfcEngNm = account.getOfc_eng_nm();
		
		event = (EesMnr0135Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// adding logic to get data from sever when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script language="javascript"> 
    var currOfcCd = '<%=currOfcCd %>';
    var rhqOfcCd  = '<%=rhqOfcCd %>';
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- Developer's task	-->

<!-- page_title_area(S) -->
	<div class="page_title_area clear">

	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
		<button type="button" class="btn_accent" name="btn_Retrive" id="btn_Retrive">Retrieve</button>
		<button type="button" class="btn_normal" name="btn_New"   id="btn_New">New</button>
		<button type="button" class="btn_normal" name="btn_Excel"   id="btn_Excel">Down Excel</button>
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
			<!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
<div class="opus_design_inquiry wFit">
	<table>
		 <colgroup>
			<col width="70px" />
			<col width="160px" />
			<col width="70px" />
			<col width="160px" />
			<col width="70px" />
			<col width="" />
		</colgroup> 
		<tbody>
			<tr class="h23"> 
				<th>Regional HQ</th>
				<td>
					<script language="javascript">ComComboObject('combo1',2, 120 , 1);</script>
				</td>
				<th>Operation Office</th>
				<td>
					<script language="javascript">ComComboObject('combo2',2, 120 , 1);</script>
				</td>
				<th>Equipment Type</th>
				<td>
					<script language="javascript">ComComboObject('combo3',2, 120 , 1);</script>
				</td>
			</tr>
		</tbody>
	</table>
</div>
</div>
<!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
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