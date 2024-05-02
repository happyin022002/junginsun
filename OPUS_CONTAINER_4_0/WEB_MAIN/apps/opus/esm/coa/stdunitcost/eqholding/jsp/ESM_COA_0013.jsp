<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0013.jsp
*@FileTitle  : EQ Holding Cost
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/24
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.coa.stdunitcost.eqholding.event.EsmCoa0013Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
//  EsmCoa0013Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //Error from server
    String strErrMsg = "";                      //Error message
    int rowCount     = 0;                       //Count of DB resultSET list

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    Logger log = Logger.getLogger("com.clt.apps.STDUnitCost.EQHolding");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();


//      event = (EsmCoa0013Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

//      GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

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
        document.form.f_cost_yrmon.focus();
    }
</script>

<form method="post" name="form" onSubmit="return false;" onKeyDown="ComKeyEnter();" id="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

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
        --><button type="button" class="btn_normal" name="btn_downexcel"   id="btn_downexcel">Down Excel</button><!--
        --><button type="button" class="btn_normal" name="btn_LoadExcel"   id="btn_LoadExcel">Load Excel</button>
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
        <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
        <table>
             <colgroup>
                <col width="60"  />
                <col width="90"  />
                <col width="60"  />
                <col width="" />
            </colgroup> 
            <tbody>
                <tr>
                    <th>YYYY-MM</th>
                    <td><input type="text" name="f_cost_yrmon" class="input1" style="width:60px;" value="" maxlength="6" dataformat="ym" onKeyDown="ComKeyEnter();" id="f_cost_yrmon" /></td>
                    <th>TP/SZ</th>
                    <td><script type="text/javascript">ComComboObject('f_cntr_tpsz_cd', 1, 100 , 0 )</script></td>
                </tr>
            </tbody>
        </table>
        <!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
    </div>
    <!-- opus_design_inquiry(E) -->
</div>
<!-- wrap_search(E) -->

<!-- wrap_result(S) -->
<div class="wrap_result">
    <!-- opus_design_grid(S) -->
    <h3 class="title_design">EQ Holding Cost</h3>
    <div class="opus_design_grid" style="position:relative; ">
    <div style="position:absolute; width:91%;" class="mar_top_4" >
        <table>
             <colgroup>
                <col width="140" />
                <col width=""    />
                <col width="45"  />
            </colgroup> 
            <tbody>
                <tr>
                    <th>
                        <input type="radio" value="CNTR" class="trans" name="f_calc_term_cd" id="f_calc_term_cd1" onClick="LayerView(1)" checked><label for="f_calc_term_cd1">Container</label><!--
                        --><input type="radio" value="CHSS" class="trans" name="f_calc_term_cd" id="f_calc_term_cd2" onClick="LayerView(2)"><label for="f_calc_term_cd2">CHZ</label>
                    </th>
                    <td>&nbsp;</td>
                    <td class=" mar_top_4">&nbsp;(USD)</td>
                </tr>
            <tbody>
        </table>
        </div>

        <div id="RadioLayer" style="display:inline">
       	   <!-- opus_design_btn(S) -->
             <div class="opus_design_btn"><!-- 
                  --><button type="button" class="btn_normal" name="btng_add" id="btng_add">Row Add</button><!-- 
                  --><button type="button" class="btn_normal" name="btng_save" id="btng_save">Save</button>
             </div>
             <!-- opus_design_btn(E) -->
            <script type="text/javascript">ComSheetObject('sheet1');</script>
        </div>
        
        <div id="RadioLayer1" style="display:none">
        	<!-- opus_design_btn(S) -->
             <div class="opus_design_btn"><!-- 
                  --><button type="button" class="btn_normal" name="btng_add1" id="btng_add1">Row Add</button><!-- 
                  --><button type="button" class="btn_normal" name="btng_save1" id="btng_save1">Save</button>
             </div>
             <!-- opus_design_btn(E) -->
            <script type="text/javascript">ComSheetObject('sheet2');</script>
        </div>
    </div>
    <!-- opus_design_grid(E) -->
</div>
<!-- wrap_result(E) -->
</form>
