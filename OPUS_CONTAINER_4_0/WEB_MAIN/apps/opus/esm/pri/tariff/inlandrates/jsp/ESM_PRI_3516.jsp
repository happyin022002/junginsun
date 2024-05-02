<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_3516.jsp
*@FileTitle  : Inland Rates History
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/21
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.tariff.inlandrates.event.EsmPri3516Event"%>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmPri3516Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
    String strErrMsg = "";                      //error message
    int rowCount     = 0;                       //count of DB resultSET list

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";
    
    String[] tariffCd         = null;               
    String[] trfInlndStsCd    = null;           
    String[] trfInlndAmdtTpCd = null;               
    String   trfPfxCd         = null;               
    String   trfNo            = null;           
    String   trfInlndSeq      = null;               
    String   amdtSeq          = null;               
        
    Logger log = Logger.getLogger("com.clt.apps.Tariff.InlandRates");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);

        event = (EsmPri3516Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        
        trfPfxCd    = JSPUtil.getNull(request.getParameter("trfPfxCd"));
        trfNo       = JSPUtil.getNull(request.getParameter("trfNo"));
        trfInlndSeq = JSPUtil.getNull(request.getParameter("trfInlndSeq"));
        amdtSeq     = JSPUtil.getNull(request.getParameter("amdtSeq"));

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // adding logic to get data from server when first loading
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        
        //COMMBO LIST
        tariffCd         = PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("TARIFF_CD"));
        trfInlndStsCd    = PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("TRF_INLND_STS_CD"), false);
        trfInlndAmdtTpCd = PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("TRF_INLND_AMDT_TP_CD"), false);
        
    }catch(Exception e) {
        out.println(e.toString());
    }
%>

<script language="javascript">
    var tariffCdValue           = " |<%=tariffCd[0]%>";
    var tariffCdText            = " |<%=tariffCd[1]%>";
    var trfInlndStsCdComboValue = " |<%=trfInlndStsCd[0]%>";
    var trfInlndStsCdComboText  = " |<%=trfInlndStsCd[1]%>";
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
<input type="hidden" name="trf_pfx_cd" value="<%=trfPfxCd %>">
<input type="hidden" name="trf_no" value="<%=trfNo %>">
<input type="hidden" name="trf_inlnd_seq" value="<%=trfInlndSeq %>">
<input type="hidden" name="amdt_seq" value="<%=amdtSeq %>">

<!-- developer performance  -->
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
        --><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
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
        <!--  biz_1 (S) -->
        <table>
            <colgroup>
                <col width="85"  />
                <col width="130" />
                <col width="85"  />
                <col width="488" />
                <col width="85"  />
                <col width="" />
            </colgroup>
            <tbody>
                <tr>
                    <th>Tariff Code</th>
                    <td><script language="javascript">ComComboObject("tariff_cd", 2, 100, 0, 1, 0, false);</script></td>
                    <th>Tariff Name</th>
                    <td><input type="text" name="tariff_nm" style="width:460px; text-align:left;" class="input2" readOnly></td>
                    <th>Access Date</th>
                    <td>
                        <input type="text" name="access_dt" style="width:80px;text-align:center;" class="" value="" caption="Access Date" maxlength="10" dataformat="ymd" ><!--
                        --><button type="button" class="calendar ir" name="btns_calendar" id="btns_calendar"></button>
                    </td>
                </tr>
            </tbody>
        </table>
        <!--  biz_1   (E) -->   
    </div>
    <!-- opus_design_inquiry(E) -->
</div>
<!-- wrap_search(E) -->

<!-- wrap_result(S) -->
<div class="wrap_result">
    <!-- layout_wrap(S) -->
    <div class="layout_wrap">
        <!-- layout_vertical_2(S) -->
        <div class="layout_vertical_2 pad_rgt_8" style="width:30%">
            <script type="text/javascript">ComSheetObject('sheet1');</script>
        </div>
        <!-- layout_vertical_2(E) -->

        <!-- layout_vertical_2(S) -->
        <div class="layout_vertical_2" style="width:70%">
            <script type="text/javascript">ComSheetObject('sheet2');</script>
        </div>
        <!-- layout_vertical_2(E) -->
    </div>
    <!-- layout_wrap(E) -->
	
	<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
    
    <!-- opus_design_data(S) -->
    <div class="opus_design_data">
        <!--  biz_1 (S) -->
        <table>
            <colgroup>
                <col width="120" />
                <col width="420" />
                <col width="80"  />
                <col width="168" />
                <col width="60"  />
                <col width="" />
            </colgroup>
            <tbody>
                <tr>
                    <th>Inland Rates Name</th>
                    <td><input type="text" name="trf_inlnd_nm" style="width:370px;" class="input2" readonly></td>
                    <th>Amend No.</th>
                    <td><input type="text" name="amend_seq" style="width:120px; text-align:center;" class="input2" readonly></td>
                    <th>Status</th>
                    <td><input type="text" name="status" style="width:130px; text-align:center;" class="input2" readonly></td>
                </tr>
            </tbody>
        </table>
        <!--  biz_1   (E) -->

        <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>

        <!--  biz_1 (S) -->
        <h3 class="title_design">Publishing Information</h3>
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
                <col width="250px" />
                <col />
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
                    <td style="padding-bottom:0px"><div style="width:300px"><script type="text/javascript">ComSheetObjectInput('sheet3');</script></div></td>
                    <td></td>
                </tr>
            </tbody>
        </table>
        <!--  biz_1   (E) -->
    </div>
	
	<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
	
    <!-- opus_design_grid(S) -->
    <h3 class="title_design">Location Information (by Inland Name)</h3>
    <div class="opus_design_grid" >
        <script type="text/javascript">ComSheetObject('sheet4');</script>
    </div>
    <!-- opus_design_grid(E) -->
</div>
<!-- wrap_result(E) -->

</form>
