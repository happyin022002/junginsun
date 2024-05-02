<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_ACM_0032.jsp
*@FileTitle  : Batch Management
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/11
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.acm.acmrequest.batmanagement.event.EsmAcm0032Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
  EsmAcm0032Event event = null;        //PDTO(Data Transfer Object including Parameters)
  Exception serverException = null;    //서버에서 발생한 에러
  String strErrMsg = "";               //에러메세지
  int rowCount = 0;                    //DB ResultSet 리스트의 건수

  String successFlag = "";
  String codeList  = "";
  String pageRows  = "100";

  String strUsr_id = "";
  String strUsr_nm = "";
  String strOfc_cd = "";
  String pop_yn    = "";
  Logger log = Logger.getLogger("com.clt.apps.ACMRequest.BATManagement");

  try {
    SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id = account.getUsr_id();
    strUsr_nm = account.getUsr_nm();
    strOfc_cd = account.getOfc_cd();
    event = (EsmAcm0032Event)request.getAttribute("Event");
    serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

    if (serverException != null) {
      strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
    }

    // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
    GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	pop_yn      = request.getParameter("pop_mode")==null?"N":"Y";

  } catch(Exception e) {
    out.println(e.toString());
  }
%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	var preConds = {
		pop_yn       : "<%=pop_yn%>"
	}

// 공통코드 combo string 추출
  function setupPage(){
    var errMessage = "<%=strErrMsg%>";
    if (errMessage.length >= 1) {
      ComShowMessage(errMessage);
    } // end if
    loadPage();
  }

</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<!-- 개발자 작업 -->

<input name="usr_id" id="usr_id" type="hidden" value="<%=strUsr_id%>"><!-- 로그인 한 사용자 id -->

<% if (pop_yn=="Y") { %>
	<div class="layer_popup_contents">		
		<div class="layer_popup_title">
			<div class="page_title_area clear">
				<h2 class="page_title"><span>Batch Management</span></h2>
				<!-- page_title(E) -->
				<!-- opus_design_btn(S) -->
				<div class="opus_design_btn">
					<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button>
				</div>
				<!-- opus_design_btn(E) -->
			</div>
		</div>

<%}else{%>

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
	</h2>
<!-- page_title(E) -->
<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button>
	</div>
<!-- opus_design_btn(E) -->
<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_location(E) -->
<%}%>
<div class="wrap_result">
<div class="opus_design_grid"  >
<h3 style="margin-bottom:0" class="title_design">Mass Calculation Batch List</h3>
<div class="opus_design_btn">
		  <button type="button" class="btn_normal" name="btng_cancel_cal" id="btng_cancel_cal">Cancel Batch</button>
	</div>
	
	<script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
<div class="opus_design_grid"  >
<h3 style="margin-bottom:0" class="title_design">Simulation Batch List</h3>
<div class="opus_design_btn">
		  <button type="button" class="btn_normal" name="btng_cancel_sim" id="btng_cancel_sim">Cancel Batch</button>
	</div>
	
	<script type="text/javascript">ComSheetObject('sheet2');</script>
</div>
</div>
<% if (pop_yn=="Y") { %></div><%}%>
</form>
