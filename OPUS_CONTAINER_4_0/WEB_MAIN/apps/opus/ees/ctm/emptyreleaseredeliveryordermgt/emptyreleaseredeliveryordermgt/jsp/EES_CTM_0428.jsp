<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CTM_0428.jsp
*@FileTitle  : Territories Management
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/08
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.event.EesCtm0428Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
  EesCtm0428Event event = null;        //PDTO(Data Transfer Object including Parameters)
  Exception serverException = null;    //error from server
  String strErrMsg = "";               //error message
  int rowCount = 0;                    //DB ResultSet List count
  String successFlag = "";
  String codeList = "";
  String pageRows = "100";
  String strUsr_id = "";
  String strUsr_nm = "";
  Logger log = Logger.getLogger("com.clt.apps.EquipmentMovementMgt.ContainerMovementMasterDataMgt");
  try {
    SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id = account.getUsr_id();
    strUsr_nm = account.getUsr_nm();
    event = (EesCtm0428Event)request.getAttribute("Event");
    serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
    if (serverException != null) {
      strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
    }
    GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
  } catch(Exception e) {
    out.println(e.toString());
  }
%>

<script type="text/javascript">
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
<!-- developer job -->

<!-- page_title_area(S) -->
<div class="page_title_area clear">
    <!-- page_title(S) -->
    <h2 class="page_title">
        <button type="button">
            <span id="title"></span>
        </button>
    </h2>
    <!-- page_title(E) -->

    <!-- opus_design_btn(S) -->
    <div class="opus_design_btn">
        <button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!--  
        --><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
    </div>
    <!-- opus_design_btn(E) -->

    <!-- page_location(S) -->
    <div class="location">
        <span id="navigation"></span>
    </div>
    <!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
	    <!-- opus_grid_btn(S) -->
	    <div class="opus_design_btn">
	        <button type="button" class="btn_normal" name="btn_add" id="btn_add">Row Add</button>
	        <button type="button" class="btn_normal" name="btn_del" id="btn_del">Row Delete</button>
	    </div>
	    <!-- opus_grid_btn(E) -->
	    <script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>
<!-- end of developer job -->
</form>
