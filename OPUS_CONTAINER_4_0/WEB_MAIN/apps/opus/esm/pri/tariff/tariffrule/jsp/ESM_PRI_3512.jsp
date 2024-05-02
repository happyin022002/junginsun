<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_3512.jsp
*@FileTitle  : Tariff Rule Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/13
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.tariff.tariffrule.event.EsmPri3512Event"%>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmPri3512Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
    String strErrMsg = "";                      //error message
    int rowCount     = 0;                       //count of DB resultSET list

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";

    String[] trfRuleChgCd = null;           //Charge Code
    String[] trfRuleAmdtTpCd = null;        //Amend Type
    String[] trfRuleStsCd = null;           //Status
    String[] aproOfcCd = null;              //Approval Office
    String[] tariffCd = null;               //Tariff Code
    
    Logger log = Logger.getLogger("com.clt.apps.Tariff.TariffRule");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();


        event = (EsmPri3512Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // adding logic to get data from server when first loading
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

        //COMMBO LIST       
        trfRuleChgCd    = PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("TRF_RULE_CHG_CD"));
        trfRuleAmdtTpCd = PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("TRF_RULE_AMDT_TP_CD"));
        trfRuleStsCd    = PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("TRF_RULE_STS_CD"), false);
        aproOfcCd       = PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("APRO_OFC_CD"), false);
        tariffCd        = PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("TARIFF_CD"));

    }catch(Exception e) {
        out.println(e.toString());
    }
%>

<script language="javascript">
    var trfRuleChgCdComboValue = "|<%=trfRuleChgCd[0]%>";
    var trfRuleChgCdComboText = "|<%=trfRuleChgCd[1]%>";
    
    var trfRuleAmdtTpCdComboValue = "|<%=trfRuleAmdtTpCd[0]%>";
    var trfRuleAmdtTpCdComboText = "|<%=trfRuleAmdtTpCd[1]%>";
    
    var trfRuleStsCdComboValue = "|<%=trfRuleStsCd[0]%>".replace("|R", ""); 
    var trfRuleStsCdComboText = "|<%=trfRuleStsCd[1]%>".replace("|Returned","");
    
    var aproOfcCdComboValue = "|<%=aproOfcCd[0]%>";
    var aproOfcCdComboText = "|<%=aproOfcCd[0]%>";
    
    var tariffCdComboValue = "<%=tariffCd[0]%>";
    var tariffCdComboText = "<%=tariffCd[1]%>";

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
<input type="hidden" name="trf_pfx_cd">
<input type="hidden" name="trf_no">

<!-- developer performance  -->

<!-- page_title_area(S) -->
<div class="page_title_area clear ">
    <!-- page_title(S) -->
    <h2 class="page_title"><button type="button"><span id="title"></span></button>
    </h2>
    <!-- page_title(E) -->

        <!-- opus_design_btn(S) -->
        <div class="opus_design_btn">
            <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
            <button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
            --><button type="button" class="btn_normal" name="btn_new"   id="btn_new">New</button><!--
            --><button type="button" class="btn_normal" name="btn_openc"   id="btn_openc">Open Creation</button><!--
            --><button type="button" class="btn_normal" name="btn_history"   id="btn_history">History</button><!--
            --><button type="button" class="btn_normal" name="btn_print"   id="btn_print">Print</button>
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

<div class="wrap_search">   
    <!-- opus_design_inquiry(S) -->
    <div class="opus_design_inquiry wFit">
        <!--biz page (S)-->
        <table>
            <colgroup>
                <col width="80"  />
                <col width="110" />
                <col width="50"  />
                <col width="120" />
                <col width="55"  />
                <col width="110" />
                <col width="85"  />     
                <col width="" />
            </colgroup>
            <tbody>
                <tr>
                    <th>Tariff Code</th>
                    <td><script language="javascript">ComComboObject("tariff_cd", 2, 100, 0, 1, 0, false);</script></td>
                    <th>Status</th>
                    <td><script language="javascript">ComComboObject("trf_rule_sts_cd", 1, 100, 0, 0, 0, false);</script></td>
                    <th>Rule No.</th>
                    <td><input type="text" name="trf_rule_no" maxlength="10" style="width:100px;text-align: center;ime-mode:disabled;" class="input" value=""></td>
                    <th>Search Word</td>
                    <td><input type="text" name="trf_rule_ctnt" maxlength="50" style="width:250px;ime-mode:disabled;" class="input" value=""></td>
                </tr>
            <tbody>
        </table>
    </div>
</div>

<div class="wrap_result">
    <!-- opus_design_grid(S) -->
    <div class="opus_design_grid" id="mainTable" >                                  
        <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
        <script language="javascript">ComSheetObject('sheet1');</script>
        <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
    </div>
    <!-- opus_design_grid(E) -->
    <div class="opus_design_inquiry wFit">
        <h3 class="title_design">Rule Detail</h3>
        <textarea name="rule_ctnt" id="rule_ctnt" class="" style="text-indent:0px; width:100%; height:190px; font-family:Lucida Console; padding-right:500px; overflow-y:scroll;" readonly></textarea>
    </div>
    <!-- opus_design_inquiry(E) --> 
</div>
<!-- developer performance  end -->
</form>
