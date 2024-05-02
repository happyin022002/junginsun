<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_3509.jsp
*@FileTitle  : Tariff Rule History
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
<%@ page import="com.clt.apps.opus.esm.pri.tariff.tariffrule.event.EsmPri3509Event"%>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmPri3509Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //server error
    String strErrMsg = "";                      //error message
    int rowCount     = 0;                       //DB ResultSet list count

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";

    //String[] trfRuleChgCd = null;         //Charge Code
    //String[] trfRuleAmdtTpCd = null;      //Amend Type
    String[] trfRuleStsCd = null;           //Status
    //String[] aproOfcCd = null;                //Approval Office
    String[] tariffCd = null;               //Tariff Code
    String trfPfxCd = "";
    String trfNo = "";
    String trfRuleNo = "";
    
    Logger log = Logger.getLogger("com.clt.apps.Tariff.TariffRule");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();


        event = (EsmPri3509Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

        //COMMBO LIST       
        //trfRuleChgCd  = PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("TRF_RULE_CHG_CD"));
        //trfRuleAmdtTpCd = PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("TRF_RULE_AMDT_TP_CD"));
        trfRuleStsCd    = PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("TRF_RULE_STS_CD"), false);
        //aproOfcCd         = PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("APRO_OFC_CD"), false);
        tariffCd        = PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("TARIFF_CD"));
        
        trfPfxCd        = JSPUtil.getNull(request.getParameter("trf_pfx_cd"));
        trfNo           = JSPUtil.getNull(request.getParameter("trf_no"));
        trfRuleNo       = JSPUtil.getNull(request.getParameter("trf_rule_no"));
        
    }catch(Exception e) {
        out.println(e.toString());
    }
%>

<script language="javascript">
    var trfRuleStsCdComboValue = "<%=trfRuleStsCd[0]%>";
    var trfRuleStsCdComboText = "<%=trfRuleStsCd[1]%>";
    
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
<input type="hidden" name="trf_pfx_cd" value="<%=trfPfxCd%>">
<input type="hidden" name="trf_no" value="<%=trfNo%>">
<input type="hidden" name="trf_rule_no" value="<%=trfRuleNo%>">

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
        --><button type="button" class="btn_normal" name="btn_print" id="btn_print">Print</button>
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
<!-- inquiry_area(S) -->
<div class="opus_design_inquiry wFit">
    <!--  biz_1 (S) -->
    <table>
        <colgroup>
            <col width="75px"  />
            <col width="120px"  />
            <col width="55px"  />
            <col width="110px"  />
            <col width="80px"  />
            <col width="160px"  />
            <col width="75px"  />
            <col width="110px"  />
            <col width=""      />
        </colgroup>
        <tbody>
            <tr>
                <th>Tariff Code</th>
                <td><script language="javascript">ComComboObject("tariff_cd", 2, 100, 0, 1, 0, false);</script></td>
                <th>Rule No.</th>
                <td><input type="text" name="rule_no" maxlength="10" style="width:90px;text-align: center;" class="input" value=""></td>
                <th>Search Word</th>
                <td><input type="text" name="rule_nm" maxlength="50" style="width:140px;ime-mode:disabled;" class="input" value=""></td>
                <th>Access Date</th>
                <td>
                    <input type="text" name="access_dt" style="width:80px;text-align:center;" class="" value="" caption="Access Date" maxlength="10" dataformat="ymd" ><!--
                    --><button type="button" class="calendar ir" name="btn_calendar" id="btn_calendar"></button>
                <td>&nbsp;</td>
            </tr>
        </tbody>
    </table>
    <!--  biz_1   (E) -->   
</div>
<!-- inquiry_area(E) -->
</div>

<div class="wrap_result">
<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
	    <script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	
	<div class="opus_design_grid">
	    <div class="opus_design_btn">
	        <button type="button" class="btn_normal" name="btn_amendcompare" id="btn_amendcompare">Amend Compare</button>
	    </div>

   		<script type="text/javascript">ComSheetObject('sheet2');</script>

	    <!-- opus_grid_title(S) -->
	    <h3 class="grid_heading_clear title_design mar_btm_8 mar_top_4">Rule Detail</h3>
	    <!-- opus_grid_title(E) -->

	    <table>
	        <tbody>
	            <tr>
	                <td><textarea name="rule_ctnt" id="rule_ctnt" class="" style="text-indent:0px; width:100%; height:160px; font-family:Lucida Console; padding-right:500px; overflow-y:scroll;" readonly></textarea></td>
	            </tr>
	        </tbody>
	    </table>
	</div>
<!-- opus_design_grid(E) -->
</div>
</form>
