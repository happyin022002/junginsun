<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_ACM_0111.jsp
*@FileTitle  : CSR Detail
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/19
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.acm.acmreport.acmreport.event.EsmAcm0111Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
  EsmAcm0111Event event = null; //PDTO(Data Transfer Object including Parameters)
  Exception serverException = null; //서버에서 발생한 에러
  String strErrMsg = ""; //에러메세지
  int rowCount = 0; //DB ResultSet 리스트의 건수

  String successFlag = "";
  String codeList = "";
  String pageRows = "100";

  String strUsr_id = "";
  String strUsr_nm = "";
  String agn_cd = "";
  String csr_no = "";
  String rev_vvd_cd = "";
  String comm_stnd_cost_cd = "";

  Logger log = Logger.getLogger("com.clt.apps.ACMReport.ACMReport");

  try {
    SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id = account.getUsr_id();
    strUsr_nm = account.getUsr_nm();
    event = (EsmAcm0111Event) request.getAttribute("Event");
    serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

    if (serverException != null) {
      strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
    }

    // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
    GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	//ESM_ACM_0034 화면에서 넘어온 파라미터를 받는다.
	agn_cd  = JSPUtil.getParameter(request, "agn_cd");
	csr_no  = JSPUtil.getParameter(request, "csr_no");
	rev_vvd_cd  = JSPUtil.getParameter(request, "rev_vvd_cd");
	comm_stnd_cost_cd  = JSPUtil.getParameter(request, "comm_stnd_cost_cd");

  } catch (Exception e) {
    out.println(e.toString());
  }
%>

<script type="text/javascript">
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

<input type="hidden" name="agn_cd" value="<%= agn_cd %>" id="agn_cd" />
<input type="hidden" name="csr_no" value="<%= csr_no %>" id="csr_no" />
<input type="hidden" name="rev_vvd_cd" value="<%= rev_vvd_cd %>" id="rev_vvd_cd" />
<input type="hidden" name="comm_stnd_cost_cd" value="<%= comm_stnd_cost_cd %>" id="comm_stnd_cost_cd" />

<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	
		<!-- page_title(S) -->
		<h2 class="page_title"><span>CSR Detail</span></h2>
		<!-- page_title(E) -->
		
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_close" 		id="btn_close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->		
		
	</div>
	<!-- page_title_area(E) -->
</div>

<div class="layer_popup_contents">
	
	<div class="wrap_result">
		
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid clear" name="tabLayer" id="tabLayer">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<!-- opus_design_grid(E) -->
		
	</div>	
</div>
</form>