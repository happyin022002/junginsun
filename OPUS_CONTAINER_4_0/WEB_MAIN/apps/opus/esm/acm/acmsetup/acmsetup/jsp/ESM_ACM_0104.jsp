<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_ACM_0104.js
*@FileTitle  : Container Type Selection
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/02
=========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.acm.acmsetup.acmsetup.event.EsmAcm0104Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
  EsmAcm0104Event event = null;        //PDTO(Data Transfer Object including Parameters)
  Exception serverException = null;    //서버에서 발생한 에러
  String strErrMsg = "";               //에러메세지
  int rowCount = 0;                    //DB ResultSet 리스트의 건수

  String successFlag = "";
  String codeList  = "";
  String pageRows  = "100";

  String strUsr_id = "";
  String strUsr_nm = "";

  String row = "";  // Sheet에서 팝업 호출시, Target이 되는 Cell의 row 정보
  String col = "";  // Sheet에서 팝업 호출시, Target이 되는 Cell의 col 정보
  String cntrTp = "";  // Sheet에서 팝업 호출시, Target이 되는 Cell의 Value
  Logger log = Logger.getLogger("com.clt.apps.ACMSetup.ACMSetup");

  try {
    SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id = account.getUsr_id();
    strUsr_nm = account.getUsr_nm();
    event = (EsmAcm0104Event)request.getAttribute("Event");
    serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

    if (serverException != null) {
      strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
    }

    // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
    GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
    row = JSPUtil.getParameter(request, "row");
    col = JSPUtil.getParameter(request, "col");
    cntrTp = JSPUtil.getParameter(request, "fac_spcl_cntr_tp_ctnt");

  } catch(Exception e) {
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
<input type="hidden" name="row" value="<%=row%>" id="row" />
<input type="hidden" name="col" value="<%=col%>" id="col" />
<input type="hidden" name="cntrTp" value="<%=cntrTp%>" id="cntrTp" />
<input type="hidden" name="chg_ddct_grp_id" id="chg_ddct_grp_id" />

<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Container Type Selection</span></h2>
		<!-- page_title(E) -->
		
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn_ok" id="btn_ok" type="button">OK</button><!--
			--><button class="btn_normal" name="btn_close" id="btn_close" type="button">Close</button><!--
			--></div>
		<!-- opus_design_btn (E) -->
	</div>
	<!-- page_title_area(E) -->
</div>

<div class="layer_popup_contents">
<!-- wrap_result(S) -->
<div class="wrap_result">
<!-- opus_design_grid(S) -->
<div class="opus_design_grid">
	<script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
<!-- opus_design_grid(E) -->
</div>
<!-- wrap_result(E) -->
</div>
</form>
