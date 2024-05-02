<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CTM_0422.jsp
*@FileTitle  : Restuffing Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/07
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.ctm.restuffingmgt.restuffingcontainerregistration.event.EesCtm0422Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EesCtm0422Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
    String strErrMsg = "";                      //error message
    int rowCount     = 0;                       //DB ResultSet list count
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";
    String strUsr_id        = "";
    String strUsr_nm        = "";
    Logger log = Logger.getLogger("com.clt.apps.RestuffingMgt.ContainerMovementMasterDataMgt");
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        event = (EesCtm0422Event)request.getAttribute("Event");
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
            ComShowMessage(errMessage);
        } // end if
        loadPage();
    }
</script>
<!-- developer job  -->
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
        <button type="button" class="btn_accent" name="btn_new" id="btn_new">New</button><!--  
        --><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button>
    </div>
    <!-- opus_design_btn(E) -->

    <!-- page_location(S) -->
    <div class="location">
        <span id="navigation"></span>
    </div>
    <!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<div class="wrap_search">
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry wFit">
    <table>
        <colgroup>
            <col width="50" />
            <col width="120" />
            <col width="45" />
            <col width="50" />
            <col width="200" />
            <col width="*"/>
        </colgroup>
        <tbody>
            <tr>
                <th>Origin Yard</th>
                <td><input type="text" maxlength="5" style="width:55px;ime-mode:disabled;" name="p_yard1" class="input1" tabindex="1" dataformat="engup" onblur="yard_Change(this);"><script type="text/javascript">ComComboObject('p_yard2', 2, 50 , 0, 1, 0, 0, 2)</script></td>
                <td></td>
                <th>Event date</th>
                <td><input type="text" style="width:75px;ime-mode:disabled" maxlength="10" class="input1"  tabindex="4" name="p_date" onblur="date_Change(this);"><button type="button" class="calendar ir" name="btn_Calendar1" id="btn_Calendar1"></button><input type="text" style="width:50px;ime-mode:disabled" maxlength="5" class="input1" tabindex="5" name="p_time" onblur="time_Change(this);"><input type="hidden" name="p_date0"></td>
                <td></td>
            </tr>
            <tr>
                <th>Reason Code</th>
                <td><input type="text" style="width:68px;display:none;" class="input" name="p_reson" id="p_reson" readonly><span id='m_combo' style="display: inline;"><script type="text/javascript">ComComboObject('p_reson_op', 2, 108 , 0, 1, 0, 0, 6)</script></span></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
        </tbody>
    </table>
    <table>
        <tbody>
        <colgroup>
            <col width="50" />
            <col width="50" />
            <col width="50" />
            <col width="50" />
            <col width="50" />
            <col width="50" />
            <col width="50" />
            <col width="50" />
            <col width="50" />
            <col width="*"/>
        </colgroup>
            <tr height="40px">
                <td></td>
                <th class="sm"><input type="text" readonly style="width:25px;border:0;text-align:left;display:none" name="sm0" id="sm0"></th>
                <td class="sm"><input type="text" style="width:100px;display:none" name="dm0" id="dm0" class="input2"></td>
                <th class="sm"><input type="text" readonly style="width:25px;border:0;text-align:left;display:none" name="sm1" id="sm1"></th>
                <td class="sm"><input type="text" style="width:100px;display:none" name="dm1" id="dm1" class="input2"></td>
                <th class="sm"><input type="text" readonly style="width:25px;border:0;text-align:left;display:none" name="sm2" id="sm2"></th>
                <td class="sm"><input type="text" style="width:100px;display:none" name="dm2" id="dm2" class="input2"></td>
                <th class="sm"><input type="text" readonly style="width:25px;border:0;text-align:left;display:none" name="sm3" id="sm3"></th>
                <td class="sm"><input type="text" style="width:100px;display:none" name="dm3" id="dm3" class="input2"></td>
                <td></td>
            </tr>
        </tbody>
    </table>
</div>
<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
<!-- opus_design_grid(S) -->
<div class="opus_design_grid">
    <!-- opus_grid_title(S) -->
    <h3 class="title_design">Object</h3>
    <!-- opus_grid_title(E) -->
    <!-- opus_grid_btn(S) -->
    <div class="opus_design_btn">
        <button type="button" class="btn_normal" name="btn_mvmt" id="btn_mvmt">MVMT History</button>
    </div>
    <!-- opus_grid_btn(E) -->
    <script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
<table class="line_bluedot"><tr><td></td></tr></table>
<!-- opus_design_grid(E) -->

<!-- opus_design_grid(S) -->
<div class="opus_design_grid">
    <!-- opus_grid_title(S) -->
    <h3 class="title_design">Replace</h3>
    <!-- opus_grid_title(E) -->
    <!-- opus_grid_btn(S) -->
    <div class="opus_design_btn">
        <button type="button" class="btn_normal" name="btn_add" id="btn_add">Row Add</button>
        <button type="button" class="btn_normal" name="btn_del" id="btn_del">Row Delete</button>
    </div>
    <!-- opus_grid_btn(E) -->
    <script type="text/javascript">ComSheetObject('sheet2');</script>

    <table class="grid_2" style="width:650px;">
        <colgroup>
            <col width="50" />
            <col width="*"/>
        </colgroup>
        <tbody>
            <tr>
                <th><strong>Remark(s)</strong></th>
                <td><input type="text" style="width:650px; ime-mode:disabled;" class="input1" name="p_rmk" maxlength="480"></td>
            </tr>
        </tbody>
    </table>
</div>
<!-- opus_design_grid(E) -->
</div>
</form>