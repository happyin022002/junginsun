<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0041.jsp
*@FileTitle  : Bunker Fee
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/03
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%
    Exception serverException   = null;             //Error from server
    String strErrMsg    = "";                       //Error message
    Logger log = Logger.getLogger("com.clt.apps.opus.esm.coa.ESM_COA_0041");
    try {
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
    } catch(Exception e) {
        log.error("JSP Exception : " + e.toString());
    }
%>

<script type="text/javascript">
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        //form.f_yearweek.select();			//SJH.20141223.MOD
        loadPage();
    }
</script>
<div style="height:0px">
<iframe height="0" width="0" name="frmHidden"></iframe>
</div>
<form method="post" name="form" onKeyDown="ComKeyEnter();">
<input  type="hidden" name="f_cmd">

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
        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
        <button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
        --><button type="button" class="btn_accent" name="btn_Save" id="btn_Save">Save</button><!--
        --><button type="button" class="btn_normal" name="btn_Downexcel"   id="btn_Downexcel">Down Excel</button><!--
        --><button type="button" class="btn_normal" name="btn_Loadexcel"   id="btn_Loadexcel">Load Excel</button>
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
    <div class="opus_design_inquiry">
         <table>
            <tr>
                <td><script type="text/javascript">coaPeriod2("2");</script></td>	<!-- SJH.20150107.ADD -->
            </tr>
        </table> 
        <table>
             <colgroup>
                <col width="85" />
                <col width="200" />
                <col width="100" />
                <col width="200" />
                <col width="50" />
                <col width="*" />
            </colgroup> 
            <tbody>
                <tr>
                    <th>Service Lane</th>
                    <td><script type="text/javascript">ComComboObject('f_selslane',1, 110 , 0 )</script></td>
                    <th>Revenue Lane</th>
                    <td><script type="text/javascript">ComComboObject('f_selrlane',1, 110 , 0 )</script></td>
                    <th>Class</th>
                    <td><script type="text/javascript">ComComboObject('f_selclass',1, 110 , 0 )</script></td>
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
    <div class="opus_design_grid"  id="mainTable">
        <div align="right" class="mar_btm_4">(Metric Ton/Day, USD/Metric Ton)</div>
        <script type="text/javascript">ComSheetObject('sheet1');</script> 
    </div>
    <!-- opus_design_grid(E) -->
</div>
<!-- wrap_result(E) -->
</form>
