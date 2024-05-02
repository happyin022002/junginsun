<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0246.jsp
*@FileTitle  : Disposal Performance by Buyer
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/01
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.reportmanage.performancereport.event.EesMnr0246Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EesMnr0246Event  event = null;              //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
    String strErrMsg = "";                      //Error message
    int rowCount     = 0;                       //count of DB resultSet list

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String strOfc_cd        = "";
    Logger log = Logger.getLogger("com.clt.apps.opus.ees.mnr.reportmanage.performancereport");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strOfc_cd = account.getOfc_cd();


        event = (EesMnr0246Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // adding logic to get data from sever when first loading
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

    }catch(Exception e) {
        out.println(e.toString());
    }
%>

<script language="javascript">
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        }
        loadPage();
    }
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- Developer's task   -->
<input type="hidden" name="p_rhq_cd">
<input type="hidden" name="p_ofc_cd">
<input type="hidden" name="p_disp_rsn_cd">
<input type="hidden" name="h_etc_params">
<input type="hidden" name="h_cust_cd">
<input type="hidden" name="h_vndr_nm">

<!-- page_title_area(S) -->
<div class="page_title_area clear ">
    <!-- page_title(S) -->
    <h2 class="page_title">
        <button type="button">
            <span id="title"></span>
        </button>
    </h2>
    <!-- page_title(E) -->

    <!-- opus_design_btn(S) -->
    <div class="opus_design_btn">
        <button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
        --><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button><!--
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

<!-- wrap_search(S) -->
<div class="wrap_search">
    <!-- opus_design_inquiry(S) -->
    <div class="opus_design_inquiry wFit">
        <table>
             <colgroup>
                <col width="90"  />
                <col width="230" />
                <col width="90"  />
                <col width="140" />
                <col width="78"  />
                <col width="89"  />
                <col width="" />
            </colgroup> 
            <tbody>
                <tr>
                    <th>Sold Period</th>
                    <td>
                        <input type="text" name="p_str_evnt_dt" caption="Start Duration" style="width:80px;text-align:center;ime-mode:disabled;" class="input1" value="" dataformat="ymd" !cofield="p_end_evnt_dt">~&nbsp;<!--
                        --><input type="text" name="p_end_evnt_dt" caption="End Duration" style="width:80px;text-align:center;ime-mode:disabled;" class="input1" value="" dataformat="ymd" !cofield="p_str_evnt_dt"><!--
                        --><button type="button" class="calendar ir" name="btns_calendar" id="btns_calendar"></button>
                    </td>
                    <th>EQ Type</th>
                    <td>
                        <select name="p_eq_knd_cd" caption="EQ Type" style="width:90px;" class="input1">
                            <option value="U" selected>Container</option>
                            <option value="Z">Chassis</option>
                            <option value="G">M.G.Set</option>
                        </select>
                    </td>
                    <th>Office By</th>
                    <td><script language="javascript">ComComboObject('combo1',1, 88, 1,0);</script></td>
                    <td><script language="javascript">ComComboObject('combo2',2, 247 , 0,0,'',0,'');</script></td>
                </tr>
                <tr>
                    <th>Disposal Kind</th>
                    <td colspan="3">
                        <script language="javascript">ComComboObject('combo3', 1, 201, 1, 0);</script>
                    </td>
                    <th>Buyer By</th>
                    <td colspan="2">
                        <input type="text" name="p_cust_cd" caption="Buyer" style="width:65px;text-align:center" class="input" dataformat="engup" maxlength="8"><!--
                        --><button type="button" class="input_seach_btn" name="btns_search" id="btns_search"></button><!--
                        --><input type="text" name="p_vndr_nm" style="width:247px" class="input2" readOnly="true">
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
    <!-- opus_design_inquiry(E) -->
</div>
<!-- wrap_search(E) -->

<!-- wrap_result(S) -->
<div class="wrap_result">
    <!-- opus_design_grid(S) -->
    <div class="opus_design_grid">
        <script language="javascript">ComSheetObject('sheet1');</script>
    </div>
    <!-- opus_design_grid(E) -->
</div>
<!-- wrap_result(E) -->

<!-- Developer's task   -->
</form>
