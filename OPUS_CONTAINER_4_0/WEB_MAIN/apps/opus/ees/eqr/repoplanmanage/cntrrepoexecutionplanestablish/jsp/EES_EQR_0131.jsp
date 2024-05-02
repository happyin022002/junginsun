<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_EQR_0131.jsp
*@FileTitle  : Send Fax or e-mail
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/06
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.event.EesEqr0131Event"%>
<%@ page import="com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0131ConditionVO"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.apps.opus.ees.eqr.common.Constants"%>

<%
    EesEqr0131Event  event = null;              //PDTO(Data Transfer Object including Parameters)
    GeneralEventResponse eventResponse = null;  //RDTO(Data Transfer Object including DB ResultSet)
    Exception serverException   = null;         
    DBRowSet rowSet   = null;                              //DB ResultSet
    String strErrMsg = "";                               
    int rowCount     = 0;                                 //DB ResultSet
    //String user_id = "";
    String user_name = "";
    //String user_email = "";
    String user_ofc = "";

    String sendMode   = "";
    String btn_mode  = "";
    //String week = "";


    try {

        event = (EesEqr0131Event)request.getAttribute("Event");
        EesEqr0131ConditionVO conditionVO = event.getEesEqr0131ConditionVO();
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        //user_id = event.getSignOnUserAccount().getUsr_id();
        //user_name = event.getSignOnUserAccount().getUsr_name();
        //user_email = event.getSignOnUserAccount().getUsr_email();
        btn_mode = conditionVO.getBtnMode();
        user_name = event.getSignOnUserAccount().getUsr_nm();
        user_ofc = event.getSignOnUserAccount().getOfc_cd();

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }else{
            eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
            if (eventResponse != null) {
                rowSet = eventResponse.getRs();
                if(rowSet != null){
                     rowCount = rowSet.getRowCount();
                } // end if

                sendMode = (String)eventResponse.getCustomData("sendMode");

                if("email".equals(sendMode)) {
%>
                <script>
                    ComShowCodeMessage("COA10006");
                    window.close();
                </script>
<%
                } else if("fax".equals(sendMode)) {
%>
                <script>
                    ComShowCodeMessage("COA10006");
                    window.close();
                </script>
<%
                }
            } // end if
        } // end else
    }catch(Exception e) {
        out.println(e.toString());
    }

%>
<script type="text/javascript" src="/opuscntr/rpt/script/common_rd.js"></script>

<script>
function setupPage(){
    var errMessage = "<%=strErrMsg%>";
    if (errMessage.length >= 1) {
        ComShowMessage(errMessage);
    } // end if

    // InitTab();
    loadPage();

}
</script>
<form  name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="linkType" value = "">
<input type="hidden" name="repo_pln_id" value = "">
<input type="hidden" name="ref_id" value = "">
<input type="hidden" name="tpsz" value = "">
<input type="hidden" name="send_mode" value = "">
<input type="hidden" name="btn_mode"  value="<%= btn_mode %>">
<input type="hidden" name="user_name"  value="<%= user_name %>">
<input type="hidden" name="user_ofc"  value="<%= user_ofc %>">
<input type="hidden" name="week" value = "">
<div class="layer_popup_title">
<!-- page_title_area(S) -->
<div class="page_title_area clear">
    <!-- page_title(S) -->
    <h2 class="page_title"><span>Preview</span></h2>
    <!-- page_title(E) -->
    <!-- opus_design_btn(S) -->
    <div class="opus_design_btn"><!-- 
         --><button type="button" class="btn_accent" name="btn_send" id="btn_send">Send</button>
    </div>
    <!-- opus_design_btn(E) -->
</div>
<!-- page_title_area(E) -->
</div>

<div class="layer_popup_contents">
<!-- opus_design_inquiry(S) -->
<div class= "wrap_search">
    <div class="opus_design_inquiry wFit">
        <table>
            <colgroup>
                <col width="50">
                <col width="*">
            </colgroup>
            <tbody>
                <tr>
                    <th>Issue Type</th>
                    <td><input type="checkbox" id=radio_chk_email class="trans" name="chk_email"><label for="radio_chk_email">E-Mail</label>  <input type="checkbox" id=radio_chk_fax class="trans" name="chk_fax"><label for="radio_chk_fax">Fax</label></td>
                </tr>

                <tr>
                    <th>E-mail Address</th>
                    <td><input name="email"  id="email" type="text" style="width:600px;ime-mode:disabled;"><!-- 
                         --><button type="button" class="input_seach_btn" name="btn_email" id="btn_email"></button></td>
                </tr>

                <tr>
                    <th>Fax Number</th>
                    <td><input name="fax" id="fax" type="text" style="width:600px;ime-mode:disabled;"><!-- 
                        --><button type="button" class="input_seach_btn" name="btn_fax" id="btn_fax"></button></td>
                </tr>
            </tbody>
        </table>
    </div>
</div>
<!-- opus_design_inquiry(E) -->
<div class="wrap_result">
    <div class="opus_design_RD" id="mainTable">
        <script type="text/javascript">rdViewerObject()('execu_report');</script>
    </div>
</div>
</div>
</form>
<iframe name="iframe_rdsend" style="display:none" id="iframe_rdsend"></iframe>