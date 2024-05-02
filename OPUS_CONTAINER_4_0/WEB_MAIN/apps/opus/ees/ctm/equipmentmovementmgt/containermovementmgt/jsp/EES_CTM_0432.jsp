<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CTM_0432.jsp
*@FileTitle  : Detail Information
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/12
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
  Exception serverException = null;    //error from server
  String strErrMsg = "";    //error message
  int rowCount = 0;    //DB ResultSet list count

  String successFlag = "";
  String codeList = "";
  String pageRows  = "100";

  String strUsr_id = "";
  String strUsr_nm = "";
  Logger log = Logger.getLogger("com.clt.apps.EquipmentMovementMgt.ContainerMovementMgt");

  try {
    SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id =  account.getUsr_id();
    strUsr_nm = account.getUsr_nm();

    serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

    if (serverException != null) {
      strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
    }

    
    GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

  } catch(Exception e) {
    out.println(e.toString());
  }


  // ok_count
  String okCount = (request.getParameter("ok_count") == null)? "": request.getParameter("ok_count");
  // error_count
  String errorCount = (request.getParameter("error_count") == null)? "": request.getParameter("error_count");
  // ignored_count
  String ignoredCount = (request.getParameter("ignored_count") == null)? "": request.getParameter("ignored_count");
  // deleted_count
  String deletedCount = (request.getParameter("deleted_count") == null)? "": request.getParameter("deleted_count");
  // total_count
  String totalCount = (request.getParameter("total_count") == null)? "": request.getParameter("total_count");
%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

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
<!-- developer job -->


<input type="hidden" name="ok_count" value="<%=okCount%>">
<input type="hidden" name="error_count" value="<%=errorCount%>">
<input type="hidden" name="ignored_count" value="<%=ignoredCount%>">
<input type="hidden" name="deleted_count" value="<%=deletedCount%>">
<input type="hidden" name="total_count" value="<%=totalCount%>">
<input type="hidden" name="unload_flag" value="reset">
<!-- OUTER - POPUP (S)tart -->

<!-- popup_title_area(S) -->
 <div class="layer_popup_title">
    <!-- page_title_area(S) -->
    <div class="page_title_area clear">
        <!-- page_title(S) -->
        <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
        <h2 class="page_title">
            <span>Message</span>
        </h2>
        <!-- page_title(E) -->
        <!-- opus_design_btn (S) -->
        <div class="opus_design_btn">
            <button type="button" id="btn_close" name="btn_close" class="btn_accent">Close</button>
        </div>
        <!-- opus_design_btn (E) -->
    </div>
    <!-- page_title_area(E) -->
</div>
<!-- popup_title_area(E) -->

<!-- popup_contens_area(S) -->
<div class="layer_popup_contents">
    <div class="wrap_result">
        <div class="opus_design_grid">
            <script type="text/javascript">ComSheetObject('sheet1');</script>
        </div>
    </div>
</div>
<!-- popup_contens_area(E) -->

<!-- end of developer job -->
</form>
