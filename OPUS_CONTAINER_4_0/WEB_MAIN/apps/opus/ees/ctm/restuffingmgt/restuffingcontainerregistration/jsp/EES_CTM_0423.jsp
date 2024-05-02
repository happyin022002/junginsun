<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CTM_0423.jsp
*@FileTitle  : Restuffing Inquiry
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
<%@ page import="com.clt.apps.opus.ees.ctm.restuffingmgt.restuffingcontainerregistration.event.EesCtm0423Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EesCtm0423Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
    String strErrMsg = "";                      //error message
    String strUsr_ofc = null;
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);

        strUsr_ofc = account.getOfc_cd();
        event = (EesCtm0423Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
    }catch(Exception e) {
        out.println(e.toString());
    }
      // current date
      String strEnddate = DateTime.getFormatDate(new java.util.Date(), "yyyy-MM-dd");
      // the date before 6 month
      String strStartdate = DateTime.addMonths(strEnddate, -6, "yyyy-MM-dd");

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
        --><button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button>
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
<div class="opus_design_inquiry wFit">
    <table>
        <colgroup>
            <col width="40px"  />
            <col width="70px"  />
            <col width="30px"  />
            <col width="130px"  />
            <col width="60px"  />
            <col width="250px" />
            <col width="90px"  />
            <col width="130px" />
            <col width="50px"  />
            <col width="" />
        </colgroup>
        <tbody>
            <tr>
                <th>Office</th>
                <td><input type="text" style="width:50px;ime-mode:disabled;" tabindex="1" class="input1" maxlength="6" value="<%=strUsr_ofc%>" name="p_office" onblur="ofcCheck();"></td>
                <th> Yard</th>
                <td>
                    <input type="text" style="width:55px;ime-mode:disabled;" tabindex="2" class="input" maxlength="5" name="p_yard1" dataformat="engup"><!--
                    --><script language="javascript">ComComboObject('p_yard2', 2, 50 , 0, '', 0, 0, 3)</script></td>
                <th>Duration</th>
                <td><input type="text" style="width:80px;ime-mode:disabled;" tabindex="4" class="input1" value="<%=strStartdate%>" name="p_date1">~&nbsp;<!--
                    --><input type="text" style="width:80px;ime-mode:disabled;" tabindex="5" class="input1" value="<%=strEnddate%>" name="p_date2"><!--
                    --><button type="button" class="calendar ir" name="btn_Calendar2" id="btn_Calendar2"></button>
                <th>Container No.</th>
                <td><input type="text" style="width:90px; ime-mode:disabled;" class="input" maxlength="11" tabindex="6" name="cntrno_disp" onBlur="obj_onkeyup();"><!--
                    --><input type="hidden" name="p_cntrno"><!--
                    <input type="text" style="width:17px;" class="input" readonly name="check_digit">-->
                </td>
                <th>Reason</thd>
                <td>
                    <input type="text" style="width:60px;display:none;" class="input" name="p_reson"  id="p_reson" readonly>
                    <script language="javascript">ComComboObject('p_reson_op', 2, 160 , 0, '', 0, 0, 7)</script>
                </td>
            </tr>
        </tbody>
    </table>
</div>
<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
<!-- opus_design_grid(S) -->
<div class="opus_design_grid">
    <script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
<!-- opus_design_grid(E) -->
</div>
</form>
