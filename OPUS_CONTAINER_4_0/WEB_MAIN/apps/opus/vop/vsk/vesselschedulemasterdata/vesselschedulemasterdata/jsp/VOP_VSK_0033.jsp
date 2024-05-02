<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_VSK_0033.jsp
*@FileTitle  : Monitoring Port Registration
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/26
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.event.VopVsk0033Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    VopVsk0033Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
    String strErrMsg = "";                      //error message
    int rowCount     = 0;                       //count of DB ResultSet list
    
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    Logger log = Logger.getLogger("com.clt.apps.VesselScheduleMasterData.VesselScheduleMasterData");
    
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
       
       
        event = (VopVsk0033Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        
    }catch(Exception e) {
        out.println(e.toString());
    }
%>

<script language="javascript">
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

<!-- layer_popup_title(S) -->
<div class="layer_popup_title">
    <!-- page_title_area(S) -->
    <div class="page_title_area clear">
        <!-- page_title(S) -->
        <h2 class="page_title">
            <span>Monitoring Port Registration</span>
        </h2>
        <!-- page_title(E) -->
    
        <!-- opus_design_btn(S) -->
        <div class="opus_design_btn">
            <button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button>
            <button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button>
            <button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
        </div>
        <!-- opus_design_btn(E) -->
    
        <!-- page_location(S) -->
        <div class="location">
            <span id="navigation"></span>
        </div>
        <!-- page_location(E) -->
    </div>
    <!-- page_title_area(E) -->
</div>
<!-- layer_popup_title(E) -->

<!-- popup_contens_area(S) -->
<div class="layer_popup_contents">
    <!-- opus_design_inquiry(S) -->
    <div class="opus_design_inquiry">
        <table> 
            <colgroup>
                <col width="90"  />
                <col width="100" />
                <col width="30"  />
                <col width="100" />
                <col width="92"  />
                <col width="" />
            </colgroup>
            <tbody>
                <tr>
                    <th>Country Code</th>
                    <td>
                        <input type="text" tabIndex="1" style="width:30px;text-align:center;ime-mode:disabled"  class="input1" name="cnt_cd" dataformat="engup" maxlength="2" value="">
                        <button type="button" class="input_seach_btn" name="btn_pop_ctn" id="btn_pop_ctn"></button>
                    </td>
                    <th>Port</th>
                    <td><input type="text" tabIndex="2" style="width:63px;text-align:center;ime-mode:disabled" class="input"  name="loc_cd" dataformat="engup" maxlength="5" value=""></td>
                    <th>Port Name</th>
                    <td><input type="text" tabIndex="3" style="width:400px;text-align:left;ime-mode:disabled" class="input" name="loc_nm" dataformat="engup"  maxlength="50"value=""></td>
                </tr>
            </tbody>
        </table>
    </div>
    <!-- opus_design_inquiry(E) -->

    <!-- opus_design_grid(S) -->
    <div class="opus_design_grid" >
        <script language="javascript">ComSheetObject('sheet1');</script>
    </div>
    <!-- opus_design_grid(E) -->
</div>
<!-- popup_contens_area(E) -->
</form>
