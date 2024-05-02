<%--
=========================================================
*Copyright(c) 2015 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_2004_01.jsp
*@FileTitle  : Hard Coding Setup 
*@author     : CLT
*@version    : 1.0
*@since      : 2015/06/24
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.framework.core.view.template.Screen"%>
<%@ page import="com.clt.framework.core.controller.util.WebKeys"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg200401Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg200401Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String strOfc_cd = "";
	String screenName		= "";

	Logger log = Logger
	.getLogger("com.clt.apps.BookingMasterData.BookingMasterData");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
		.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (EsmBkg200401Event) request.getAttribute("Event");
		serverException = (Exception) request
		.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
	strErrMsg = new ErrorHandler(serverException)
			.loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request
		.getAttribute("EventResponse");
		Screen screen = (Screen) request.getAttribute(WebKeys.CURRENT_SCREEN);
		screenName = screen.getName();
		

	} catch (Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	function setupPage(){
		var formObj = document.form;
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		ComSetObjValue(formObj.screenName,"<%=screenName%>");
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="frm_hrd_cdg_id" id="frm_hrd_cdg_id" />
<input type="hidden" name="screenName" id="screenName" />

	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	    <!-- page_title(S) -->
	    <h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	    <!-- page_title(E) -->
	    <!-- opus_design_btn(S) -->
	    <div class="opus_design_btn">
	        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
			<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button><!-- 		
			 --><button type="button" class="btn_normal" name="btn_Detail" id="btn_Detail">Detail</button><!-- 
	     --></div>
	    <!-- opus_design_btn(E) -->
	    
	    
	    <!-- page_location(S) -->
	    <div class="location">
	        <!-- location 내용 동적생성 (별도 코딩 불필요) -->
	        <span id="navigation"></span>
	    </div>
	    <!-- page_location(E) -->
	</div>
	<!-- page_title_area(E) -->	
<div class= "wrap_search">
		<div class= "opus_design_inquiry wFit">	
	    <table>
	        <colgroup>
	            <col width="20" />
	            <col width="50" />
	            <col width="90" />
	            <col width="50" />	            	            
	            <col width="*" />
	        </colgroup>
	        <tbody>
				<tr>
					<th>ID</th>
					<td><input type="text" style="width:100px; ime-mode:disabled;text-transform:uppercase;" dataformat="engup" otherchar="_-" name="hrd_cdg_id" id="hrd_cdg_id" class="input"  maxlength="20" ></td>
					<th>Description</th>
					<td><input type="text" style="width:300px; ime-mode:disabled;" name="hrd_cdg_desc" id="hrd_cdg_desc" class="input"  maxlength="400"></td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<!-- opus_design_btn(S) -->

		<!-- opus_design_btn(E) -->
	    <script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>