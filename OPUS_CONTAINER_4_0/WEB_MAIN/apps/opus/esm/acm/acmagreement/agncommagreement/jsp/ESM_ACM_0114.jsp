<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   :ESM_ACM_0114.jsp 
*@FileTitle  : Agreement Information
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/11
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.acm.acmagreement.agncommagreement.event.EsmAcm0114Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
  EsmAcm0114Event event = null; //PDTO(Data Transfer Object including Parameters)
  Exception serverException = null; //서버에서 발생한 에러
  String strErrMsg = ""; //에러메세지
  int rowCount = 0; //DB ResultSet 리스트의 건수

  String successFlag = "";
  String codeList = "";
  String pageRows = "100";

  String strUsr_id = "";
  String strUsr_nm = "";
  String agnAgmtNo = "";

  Logger log = Logger.getLogger("com.clt.apps.ACMReport.ACMReport");

  try {
    SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id = account.getUsr_id();
    strUsr_nm = account.getUsr_nm();
    event = (EsmAcm0114Event) request.getAttribute("Event");
    serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

    if (serverException != null) {
      strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
    }

    // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
    GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	//ESM_ACM_0101 화면에서 넘어온 파라미터를 받는다.
	agnAgmtNo  = JSPUtil.getParameter(request, "agn_agmt_no");

  } catch (Exception e) {
    out.println(e.toString());
  }
%>



<script type="text/javascript">
//공통코드 combo string 추출
<%=JSPUtil.getIBCodeCombo("acTp", "", "CD03021", 0, "")%>
<%=JSPUtil.getIBCodeCombo("ioBnd", "", "CD00592", 0, "")%>
<%=JSPUtil.getIBCodeCombo("fullMty", "", "CD00748", 0, "")%>
<%=JSPUtil.getIBCodeCombo("commPayTerm", "", "CD03022", 0, "")%>
<%=JSPUtil.getIBCodeCombo("revDiv", "", "CD03023", 0, "")%>
<%=JSPUtil.getIBCodeCombo("ofcSetTp", "", "CD03016", 0, "")%>
<%=JSPUtil.getIBCodeCombo("ofcCvrg", "", "CD03019", 0, "")%>

  function setupPage(){
    var errMessage = "<%=strErrMsg%>";
    if (errMessage.length >= 1) {
      ComShowMessage(errMessage);
    } // end if
    loadPage();
  }
</script>


<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<!-- 개발자 작업 -->

<input type="hidden" name="agn_agmt_no" value="<%= agnAgmtNo %>" id="agn_agmt_no" />

<div class="layer_popup_contents">
	<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<h2 class="page_title"><span>Agreement Information</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_m_close" id="btn_m_close">Close</button><!--
		--></div>
		<!-- opus_design_btn(E) -->
		<!-- page_location(S) -->
		<div class="location">
			<span id="navigation"></span>
		</div>
		<!-- page_location(E) -->
	</div>
	<!-- page_title_area(E) -->
	</div>
	
	<!-- opus_design_grid(S) -->	
	<div class="wrap_result">
		<div class="opus_design_grid clear" id="mainTable" >
				<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>