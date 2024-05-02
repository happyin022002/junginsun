<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CTM_0462.jsp
*@FileTitle  : Auto-created Status Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/28
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.event.EesCtm0462Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EesCtm0462Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
    String strErrMsg = "";                      //error message
    int rowCount     = 0;                       //DB ResultSet list count

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    Logger log = Logger.getLogger("com.clt.apps.EquipmentMovementMgtSC.ContainerMovementMgt");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();


        event = (EesCtm0462Event)request.getAttribute("Event");
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
<input type="hidden" name="backendjob_key">
<input type="hidden" name="sts_cd">


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
         --><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button><!-- 
         --><button type="button" class="btn_normal" name="btn_eachcntr" id="btn_eachcntr">History</button><!-- 
         --><button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button><!-- 
         --><button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button><!-- 
     --></div>
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
            <col width="75"/>
            <col width="260"/>
            <col width="250"/>
            <col width="60"/>
            <col width="70"/>
            <col width="90"/>
            <col width="*"/>
        </colgroup>
        <tbody>
            <tr>
                <th>Event Date</th>
                <td>
                    <input type="text" tabindex="1" style="width:80px;text-align:center;" class="input1" name="p_date1" dataformat="ymd">~<!-- 
                     --><input type="text" style="width:80px; text-align:center;" tabindex="2" class="input1" name="p_date2" dataformat="ymd"><!-- 
                     --><button type="button" class="calendar ir" name="btn_Calendar" id="btn_Calendar"></button><!-- 
                 --></td>
                <td>
                    <input type="radio" class="trans" border="0" checked name="loc_type" id="loc_type1" value="1" tabindex="3"><label for="loc_type1">LCC</label><!--
                     --><input type="radio" name="loc_type" id="loc_type2" value="2" class="trans" border="0" tabindex="4"><label for="loc_type2">Location</label><!--
                     --><input type="text" style="width:70px;text-align:center;" dataformat="engup" tabindex="5" class="input1" name="loc_cd" maxlength="7" id="loc_cd" OnChange="yard_Change();"><!-- 
                 --></td>
                <th>Modified</th>
                <td>
                    <select style="width:60px;"class="input" name="cre_tp_cd" tabindex="6">
                        <option value="A" selected>N</option>
                        <option value="N">Y</option>
                    </select>
                </td>
                <th>Status</th>
                <td>
                    <script type="text/javascript">ComComboObject("stsCombo", 2, 120, 1, 0, 0, 0, 18)</script>
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
    <script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
<!-- opus_design_grid(E) -->
</div>
</form>
