<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CTM_0421.jsp
*@FileTitle  : Restuffing Reason
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/07
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmasterdatamgt.event.EesCtm0421Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.OfficeCodeMgr"%>

<%
  EesCtm0421Event event = null;        //PDTO(Data Transfer Object including Parameters)
  Exception serverException = null;    //error from server
  String strErrMsg = "";               //error message
  int rowCount = 0;                    //DB ResultSet list count

  String successFlag = "";
  String codeList = "";
  String pageRows = "100";

  String strUsr_id = "";
  String strUsr_nm = "";
  String strOfc_cd = "";
  Logger log = Logger.getLogger("com.clt.apps.EquipmentMovementMgt.ContainerMovementMasterDataMgt");

  try {
    SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id = account.getUsr_id();
    strUsr_nm = account.getUsr_nm();
    strOfc_cd = account.getOfc_cd();

    event = (EesCtm0421Event)request.getAttribute("Event");
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

<%=OfficeCodeMgr.getOfficeCodeListToJS("000002", "CTM")%>

  function setupPage() {
    var errMessage = "<%=strErrMsg%>";
    if (errMessage.length >= 1) {
      showErrMessage(errMessage);
    } // end if
    
    strOfcCd = "<%=strOfc_cd%>";
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
        <button type="button" class="btn_normal" name="btn_excel" id="btn_excel">Down Excel</button><!-- 
         --><button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button>
    </div>
    <!-- opus_design_btn(E) -->

    <!-- page_location(S) -->
    <div class="location">
        <span id="navigation"></span>
    </div>
    <!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<!-- opus_design_grid(S) -->
<div class="wrap_result">
<div class="opus_design_grid">
    <!-- opus_grid_btn(S) -->
    <div class="opus_design_btn" id="div_ofc1">
        <button type="button" class="btn_normal" name="btn_add" id="btn_add">Row Add</button><!--  
        --><button type="button" class="btn_normal" name="btn_del" id="btn_del">Row Delete</button>
    </div>
    <!-- opus_grid_btn(E) -->
    <script type="text/javascript">ComSheetObject('sheet1');</script>
</div>

</div>
<!-- opus_design_grid(E) -->
</form>
