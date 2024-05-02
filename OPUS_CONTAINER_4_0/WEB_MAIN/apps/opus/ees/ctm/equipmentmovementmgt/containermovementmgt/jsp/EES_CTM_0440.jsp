<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CTM_0440.jsp
*@FileTitle  : VL/VD correction by VVD
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/27
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.event.EesCtm0440Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EesCtm0440Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
    String strErrMsg = "";                      //error message
    int rowCount     = 0;                       //DB ResultSet list count

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    Logger log = Logger.getLogger("com.clt.apps.EquipmentMovementMgt.IManifestListDownload");

    String strEnddate = DateTime.getFormatDate(new java.util.Date(), "yyyy-MM-dd");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();


        event = (EesCtm0440Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

    }catch(Exception e) {
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
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
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
        <button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
        --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--
        --><button type="button" class="btn_normal" name="btn_update" id="btn_update">Save</button>
    </div>
    <!-- opus_design_btn(E) -->

    <!-- page_location(S) -->
    <div class="location">
        <span id="navigation"></span>
    </div>
    <!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry">
    <!--  biz_1 (S) -->
    <table>
        <colgroup>
            <col width="40"  />
            <col width="90"  />
            <col width="30"  />
            <col width="140"  />
            <col width="70"  />
            <col width="130" />
            <col width="60"  />
            <col width="110" />
            <col width="35"  />
            <col width=""    />
        </colgroup>
        <tbody>
            <tr>
                <th>Status</th>
                <td>
                    <select style="width:70px;" tabindex="1"  class="input" name="p_status">
                        <option value="VL" selected>VL</option>
                        <option value="VD">VD</option>
                    </select>
                </td>
                <th>Yard</th>
                <td><input type="text" style="width:55px;text-align:center;" class="input1" dataformat="engup" tabindex="2" maxlength="5" name="p_yard1" id="p_yard1" onchange="yard_Change()"><script type="text/javascript">ComComboObject('p_yard2', 2, 50 , 0, '', 0, 0, 3)</script></td>
                <th>Event Date</th>
                <td><input type="text" style="width:75px;" class="input1" tabindex="4"  maxlength="10" name="p_date0" value="<%=strEnddate%>"><!--
                    --><button type="button" class="calendar ir" name="btn_Calendar1" id="btn_Calendar1"></button>
                </td>
                <th>VVD Code</th>
                <td><input type="text" style="width:80px;" class="input1" tabindex="5" dataformat="engup" maxlength="9" name="p_vvdcd"></td>
                <th>Type</th>
                <td>
                    <select style="width:70px;" class="input" tabindex="6" name="p_type">
                        <option value="" selected>All</option>
                        <option value="F">Full</option>
                        <option value="P">Empty</option>
                    </select>
                </td>
            </tr>
        </tbody>
    </table>
    <!--  biz_1   (E) -->   
</div>
<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
<!-- opus_design_grid(S) -->
<div class="opus_design_grid" >
    <!-- opus_grid_btn(S) -->
    <div class="opus_design_btn">
        <button type="button" class="btn_normal" name="btn_delete" id="btn_delete">Row Delete</button>
    </div>
    <!-- opus_grid_btn(E) -->
    <script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
<!-- opus_design_grid(E) -->
</div>
</form>
