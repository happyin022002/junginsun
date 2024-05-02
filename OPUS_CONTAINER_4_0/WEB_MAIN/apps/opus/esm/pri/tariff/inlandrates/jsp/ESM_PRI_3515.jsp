<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_3515.jsp
*@FileTitle  : Inland Rates Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.tariff.inlandrates.event.EsmPri3515Event"%>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmPri3515Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
    String strErrMsg = "";                      //error message
    int rowCount     = 0;                       //count of DB resultSET list

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";
    
    String[] tariffCd         = null;               //Tariff Code
    String[] trfInlndStsCd    = null;               //Status
    String[] trfInlndAmdtTpCd = null;               //Amend Type
        
    Logger log = Logger.getLogger("com.clt.apps.Tariff.InlandRates");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);

        event = (EsmPri3515Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        
        //COMMBO LIST
        tariffCd         = PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("TARIFF_CD"));
        trfInlndStsCd    = PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("TRF_INLND_STS_CD"), false);
        trfInlndAmdtTpCd = PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("TRF_INLND_AMDT_TP_CD"), false);
        
    }catch(Exception e) {
        out.println(e.toString());
    }
%>

<script type="text/javascript">
    var tariffCdValue           = " |<%=tariffCd[0]%>";
    var tariffCdText            = " |<%=tariffCd[1]%>";
    var trfInlndStsCdComboValue = " |<%=trfInlndStsCd[0]%>".replace("|R", "");  //except Returned item
    var trfInlndStsCdComboText  = " |<%=trfInlndStsCd[1]%>".replace("|Returned","");//except Returned item
    var trfInlndAmdtTpCdComboValue  = " |<%=trfInlndAmdtTpCd[0]%>";
    var trfInlndAmdtTpCdComboText   = " |<%=trfInlndAmdtTpCd[1]%>";
    
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
<input type="hidden" name="trf_pfx_cd" value="">
<input type="hidden" name="trf_no" value="">
<input type="hidden" name="tariff_nm" value="">

<!-- page(S) -->
<!-- page_title_area(S) -->
<div class="page_title_area clear">
    
    <!-- page_title(S) -->
    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
    <h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
    <!-- page_title(E) -->

    <!-- opus_design_btn(S) -->
    <div class="opus_design_btn">
        <button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
        --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--
        --><button type="button" class="btn_normal" name="btn_creation" id="btn_creation">Open Creation</button><!--
        --><button type="button" class="btn_normal" name="btn_history" id="btn_history">History</button><!--
        --><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
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

<!-- opus_design_inquiry(S) -->
<div class="wrap_search">
    <div class="opus_design_inquiry wFit">
        <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
        <table>
            <colgroup>
                <col width="85px" />
                <col width="130px" />
                <col width="60px" />
                <col width="" />
            </colgroup>
            <tbody>
                <tr>
                    <th>Tariff Code</th>
                    <td><script type="text/javascript">ComComboObject("tariff_cd", 2, 100, 0, 1, 0, false);</script></td>
                    <th>Status</th>
                    <td><script type="text/javascript">ComComboObject("trf_inlnd_sts_cd", 1, 100, 0, 0, 0, false);</script></td>
                </tr>
            </tbody>
        </table>
        <!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
    </div>
</div>
<!-- opus_design_inquiry(E) -->

<!-- opus_design_grid(S) -->
<div class="wrap_result">
    <div class="opus_design_grid">
        <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
        <script type="text/javascript">ComSheetObject('sheet1');</script>
        <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
    </div>
<!-- opus_design_grid(E) -->
	<table class="line_bluedot"><tr><td></td></tr></table>
<!-- opus_design_inquiry(S) -->
    <div class="opus_design_data">
        <h3 class="title_design">Publishing Information</h3>
        <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
        <table>
            <colgroup>
                <col width="95px" />
                <col width="125px" />
                <col width="90px" />
                <col width="125px" />
                <col width="100px" />
                <col width="125px" />
                <col width="85px" />
                <col width="125px" />
                <col width="85px" />
                <col width="*" />
            </colgroup>
            <tbody>
                <tr>
                    <th>Creation Date</th>
                    <td><input type="text" name="cre_dt" maxlength="10" dataformat="ymd" style="width:110px; text-align:center;" class="input2" readonly></td>
                    <th>Effective Date</th>
                    <td><input type="text" name="eff_dt" maxlength="10" dataformat="ymd" style="width:110px; text-align:center;" class="input2" readonly></td>
                    <th>Expiration Date</th>
                    <td><input type="text" name="exp_dt" maxlength="10" dataformat="ymd" style="width:110px; text-align:center;" class="input2" readonly></td>
                    <th>Publish Date</th>
                    <td><input type="text" name="pub_dt" maxlength="10" dataformat="ymd" style="width:110px; text-align:center;" class="input2" readonly></td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <th>Request Office</th>
                    <td><input type="text" name="rqst_ofc_cd" style="width:110px; text-align:center;" class="input2" readonly></td>
                    <th>Creation Staff</th>
                    <td><input type="text" name="cre_usr_id" style="width:110px; text-align:center;" class="input2" readonly></td>
                    <th>Approval Office</th>
                    <td><input type="text" name="apro_ofc_cd" style="width:110px; text-align:center;" class="input2" readonly></td>
                    <th>Amend Type</th>
                    <td><input type="text" name="trf_inlnd_amdt_tp_cd" style="width:110px; text-align:center;" class="input2" readonly></td>
                    <th>Attached File</th>
                    <td><div style="width:300px"><script type="text/javascript">ComSheetObjectInput('sheet2');</script></div></td>
                </tr>
            </tbody>
        </table>
        <!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
    </div>


<!-- opus_design_grid(S) -->
    <table class="line_bluedot"><tr><td></td></tr></table>
    <h3 class="title_design">Location Information (by Inland Name)</h3>
    <div class="opus_design_grid">
        <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
        <script type="text/javascript">ComSheetObject('sheet3');</script>
        <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
    </div>
</div>
<!-- opus_design_grid(E) -->

</form>