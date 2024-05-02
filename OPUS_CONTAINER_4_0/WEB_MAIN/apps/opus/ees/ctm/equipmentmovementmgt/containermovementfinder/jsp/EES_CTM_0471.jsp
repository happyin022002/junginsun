<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : EES_CTM_0471.jsp
*@FileTitle : Deleted CNTR MVMT History
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/23
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.event.EesCtm0471Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
  EesCtm0471Event event = null;        //PDTO(Data Transfer Object including Parameters)
  Exception serverException = null;    //error from server
  String strErrMsg = "";               //error message
  int rowCount = 0;                    //DB ResultSet list count

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

    event = (EesCtm0471Event)request.getAttribute("Event");
    serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

    if (serverException != null) {
      strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
    }

    GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

  } catch(Exception e) {
    out.println(e.toString());
  }

  // Bkg No.
  String pBkgno = (request.getParameter("bkg_no") == null)? "": request.getParameter("bkg_no");
  // pop_mode
%>

<script type="text/javascript">
  function setupPage() {
    var errMessage = "<%=strErrMsg%>";
    if (errMessage.length >= 1) {
      showErrMessage(errMessage);
    } // end if
    loadPage();
  }
</script>

<form name="form">
<!-- popup_title_area(S) -->
 <div class="layer_popup_title">
    <!-- page_title_area(S) -->
    <div class="page_title_area clear">
        <!-- page_title(S) -->
        <h2 class="page_title"><span>&nbsp;VVD Detail</span></h2>
        <!-- page_title(E) -->
            
        <!-- opus_design_btn(S) -->
        <div class="opus_design_btn" >
        	<button type="button" class="btn_accent" name="btn_back" id="btn_back">Back</button>&nbsp;<!--
            --><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button>&nbsp;<!--
        	--><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
        </div>
        <!-- opus_design_btn(E) --> 
    </div>
    <!-- page_title_area(E) -->
</div>
<!-- popup_title_area(E) -->


<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<!-- 검색영역 -->
<div class="layer_popup_contents">
<div class="wrap_search">
    <div class="opus_design_inquiry">       
         <!-- biz_1 (S) -->
         <table border="0" style="width:819px;">
           <tr>
             <th width="90px" class="align_left">Booking No.</th>
             <td width="180px">
                <input type="text" style="width:100px;" class="input1"  value="<%=pBkgno%>" maxlength="12"  tabindex="1" style="ime-mode:disabled;" name="bkg_no"  readOnly dataformat="engup"><!--
                -->
            </td>
            <td></td>
           </tr>
         </table>
         <!-- biz_1 (E) -->
    </div>
</div>
<!-- 검색영역 -->

<!-- 시트영역 -->
<div class="wrap_result">
<!-- opus_design_grid(S) -->
<div class="opus_design_grid" >
    <!-- opus_grid_btn(S) -->
    <div class="opus_design_btn">
        <button type="button" class="btn_normal" name="btn_add" id="btn_add">Row Add</button>
        <button type="button" class="btn_normal" name="btn_del" id="btn_del">Row Delete</button>
    </div>
    <!-- opus_grid_btn(E) -->
    <script language="javascript">ComSheetObject('sheet1');</script>
</div>
<!-- opus_design_grid(E) -->
</div>

</form>