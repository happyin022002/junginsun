<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_3507.jsp
*@FileTitle  : Tariff Rule Creation &amp; Amendment
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
<%@ page import="com.clt.apps.opus.esm.pri.tariff.tariffrule.event.EsmPri3507Event"%>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmPri3507Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //Error from Server
    String strErrMsg = "";                      //Error Message
    int rowCount     = 0;                       //Number of DB ResultSet List

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String strOfc_cd        = "";
    
    String[] trfRuleChgCd = null;           //Charge Code
    String[] trfRuleAmdtTpCd = null;        //Amend Type
    String[] trfRuleStsCd = null;           //Status
    String[] aproOfcCd = null;              //Approval Office
    String[] tariffCd = null;               //Tariff Code
    
    String trfPfxCd = "";
    String trfNo = "";
    String trfRuleNo = "";
        
    Logger log = Logger.getLogger("com.clt.apps.Tariff.TariffRule");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strOfc_cd = account.getOfc_cd();

        event = (EsmPri3507Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // Adding Logic extracting data from server when loading initial window ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
                
        //COMMBO LIST       
        trfRuleChgCd    = PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("TRF_RULE_CHG_CD"));
        trfRuleAmdtTpCd = PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("TRF_RULE_AMDT_TP_CD"));
        trfRuleStsCd    = PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("TRF_RULE_STS_CD"), false);
        aproOfcCd       = PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("APRO_OFC_CD"), false);
        tariffCd        = PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("TARIFF_CD"));

        trfPfxCd        = JSPUtil.getNull(request.getParameter("trf_pfx_cd"));
        trfNo           = JSPUtil.getNull(request.getParameter("trf_no"));
        trfRuleNo       = JSPUtil.getNull(request.getParameter("trf_rule_no"));
    }catch(Exception e) {
        out.println(e.toString());
    }
%>

<script language="javascript">
    var trfRuleChgCdComboValue = " |<%=trfRuleChgCd[0]%>";
    var trfRuleChgCdComboText = " |<%=trfRuleChgCd[1]%>";
    
    var trfRuleAmdtTpCdComboValue = " |<%=trfRuleAmdtTpCd[0]%>";
    var trfRuleAmdtTpCdComboText = " |<%=trfRuleAmdtTpCd[1]%>";
    
    var trfRuleStsCdComboValue = " |<%=trfRuleStsCd[0]%>";
    var trfRuleStsCdComboText = " |<%=trfRuleStsCd[1]%>";
    
    var aproOfcCdComboValue = " |<%=aproOfcCd[0]%>";
    var aproOfcCdComboText = " |<%=aproOfcCd[0]%>";

    var tariffCdComboValue = " |<%=tariffCd[0]%>";
    var tariffCdComboText = " |<%=tariffCd[1]%>";

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
<input type="hidden" name="strusr_id" value="<%=strUsr_id %>">
<input type="hidden" name="strofc_cd" value="<%=strOfc_cd %>">

<input type="hidden" name="trf_pfx_cd" value="<%=trfPfxCd%>">
<input type="hidden" name="trf_no" value="<%=trfNo%>">
<input type="hidden" name="temp_rule_no" value="<%=trfRuleNo%>">
    
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
        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
        <button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
        --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--
        --><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button>
    </div>
    <!-- opus_design_btn(E) -->
    
    <!-- page_location(S) -->
    <div class="location">
        <!-- location 내용 동적생성 (별도 코딩 불필요) -->
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
                <col width="80"  />
                <col width="100" />
                <col width="80"  />
                <col width="" />
            </colgroup> 
            <tbody>
                <tr>
                    <th>Tariff Code</th>
                    <td><script language="javascript">ComComboObject("tariff_cd", 2, 100, 0, 1, 0, false);</script></td>
                    <th>Tariff Name</th>
                    <td>
                        <input type="text" name="trf_nm" style="width:700px;" class="input2" value="" readonly>
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
        <!-- opus_design_btn(S) -->
        <div class="opus_design_btn">
            <button type="button" class="btn_normal" name="btn_amend" id="btn_amend">Amend</button>
            <button type="button" class="btn_normal" name="btn_amendcancel" id="btn_amendcancel">Amend Cancel</button>
            <button type="button" class="btn_normal" name="btn_rowadd" id="btn_rowadd">Row Add</button>
            <button type="button" class="btn_normal" name="btn_rowdelete" id="btn_rowdelete">Row Delete</button>
            <button type="button" class="btn_normal" name="btn_request" id="btn_request">Request</button>
            <button type="button" class="btn_normal" name="btn_approve" id="btn_approve">Approve</button>
            <button type="button" class="btn_normal" name="btn_publish" id="btn_publish">Publish</button>
            <button type="button" class="btn_normal" name="btn_cancel" id="btn_cancel">Cancel</button>
            <button type="button" class="btn_normal" name="btn_amendcompare" id="btn_amendcompare">Amend Compare</button>
        </div>
        <!-- opus_design_btn(E) -->
        
        <script type="text/javascript">ComSheetObject('sheet1');</script>

    </div>
    <!-- opus_design_grid(E) -->
    
    <!-- opus_design_inquiry(S) -->
    <div class="opus_design_data">
        <!-- layout_flex_fixed(S) -->
        <div class="layout_flex_fixed" style="width:50%">
            <h3 class="title_design">Current</h3>
            <textarea name="bef_trf_rule_ctnt" id="bef_trf_rule_ctnt" class="input2" style="text-indent: 0px;height:190px; font-family:Lucida Console; overflow-y:scroll;" readonly></textarea>
        </div>
        <!-- layout_flex_fixed(E) -->

        <!-- layout_flex_fixed(S) -->
        <div class="pad_left_8 layout_flex_fixed" style="width:50%">
            <h3 class="title_design">Amend</h3>
            <textarea name="trf_rule_ctnt" id="trf_rule_ctnt" class="" style="text-indent: 0px; height:190px;ime-mode:disabled; font-family:Lucida Console; overflow-y:scroll;"></textarea>
        </div>
        <!-- layout_flex_fixed(E) -->
    </div>
    <!-- opus_design_inquiry(E) -->
</div>
<!-- wrap_result(E) -->
</form>

