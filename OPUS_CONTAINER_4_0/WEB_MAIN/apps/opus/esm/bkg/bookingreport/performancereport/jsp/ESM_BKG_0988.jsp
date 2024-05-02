<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0988.jsp
*@FileTitle : booking report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.11
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.06.11 강동윤
* 1.0 Creation
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
<%@ page import="com.clt.apps.opus.esm.bkg.bookingreport.performancereport.event.EsmBkg0988Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0988Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String title			= "";
	String text			= "";
	String sheetIdx		= "";
	String sheetRow		= "";
	String sheetCol		= "";
	String pgmId		= "";
	
	Logger log = Logger.getLogger("com.clt.apps.BookingReport.PerformanceReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		
		title 		= StringUtil.xssFilter(request.getParameter("title"));
		text		= StringUtil.xssFilter(request.getParameter("text"));
		sheetIdx	= StringUtil.xssFilter(request.getParameter("sheetIdx"));
		sheetRow	= StringUtil.xssFilter(request.getParameter("sheetRow"));
		sheetCol	= StringUtil.xssFilter(request.getParameter("sheetCol"));
		pgmId		= StringUtil.xssFilter(request.getParameter("pgmId"));
		
		
		log.debug("--------idx------>"+sheetIdx);
		log.debug("--------row------>"+sheetRow);
		log.debug("--------col------>"+sheetCol);
		log.debug("--------pgm------>"+pgmId);
		
		
//	    title       = request.getParameter("title");
//	    text        = request.getParameter("text");
		
		if (text == null || text.equals("")) text = "";

		event = (EsmBkg0988Event)request.getAttribute("Event");
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

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<!-- <body  onLoad="setupPage();"> -->
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->

<input type="hidden" name="sr_no" value="<%= title %>">
<input type="hidden" name="sr_knd_cd" value="U">

<input type="hidden" name="sheet_idx" value="<%=sheetIdx%>">
<input type="hidden" name="sheet_row" value="<%=sheetRow%>">
<input type="hidden" name="sheet_col" value="<%=sheetCol%>">
<input type="hidden" name="pgm_id" value="<%=pgmId%>">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><span><%= title %></span></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button type="button" id="btn_Close" name="btn_Close" class="btn_normal">Close</button><!--
		-->
	</div>
	<!-- opus_design_btn (E) -->
</div>
<!-- page_title_area(E) -->

<!-- OUTER - POPUP (S)tart -->
<div class="wrap_result">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<table>
			<tbody>
				<tr class="h23">
					<td align="center"><textarea class="textarea_img1" name="text2" id="text2" rows="15" style="resize:none;width:100%;height:100%" class="input1" wrap=hard><%=text %></textarea></td> 
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<!-- 개발자 작업  끝 -->
</form>
