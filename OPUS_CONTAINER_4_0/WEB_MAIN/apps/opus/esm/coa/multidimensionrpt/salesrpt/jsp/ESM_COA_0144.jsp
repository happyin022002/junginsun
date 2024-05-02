<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0144.jsp
*@FileTitle  : Shipper Table
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/03
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.event.EsmCoa0144Event"%>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
//  EsmCoa0144Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //Error from server
    String strErrMsg = "";                      //Error message
    int rowCount     = 0;                       //Count of DB resultSET list

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String f_cust_cnt_cd    = "";
    String f_cust_seq       = "";
        
    Logger log = Logger.getLogger("com.clt.apps.MultiDimensionRPT.SalesRPT");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();


//      event = (EsmCoa0144Event)request.getAttribute(Event);
        
        f_cust_cnt_cd = request.getParameter("f_cust_cnt_cd");
        f_cust_seq = request.getParameter("f_cust_seq");
                
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }


    }catch(Exception e) {
        out.println(e.toString());
    }
%>

<script language="javascript">
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        loadPage();
        document.form.f_cust_cnt_cd.focus();
    }
</script>
<!-- 
<iframe height="0" width="0" name="frmHidden"></iframe> -->
<form name="form" onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<!-- layer_popup_title(S) -->
<div class="layer_popup_title">
    <!-- page_title_area(S) -->
    <div class="page_title_area clear">
        <!-- page_title(S) -->
        <h2 class="page_title">
            <span>Shipper Table</span>
        </h2>
        <!-- page_title(E) -->

        <!-- opus_design_btn(S) -->
        <div class="opus_design_btn">
            <button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
            --><button type="button" class="btn_normal" name="btn_confirm" id="btn_confirm">Confirm</button><!--
            --><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
        </div>
        <!-- opus_design_btn(E) --> 
        <!-- page_location(S) -->
        <div class="location">
            <span id="navigation"></span>
        </div>
        <!-- page_location(E) -->
    </div>
    <!-- page_title_area(E) -->
</div>
<!-- layer_popup_title(E) -->

<!-- popup_contens_area(S) -->
<div class="layer_popup_contents" style="overflow:hidden">
<!-- wrap_search(S) -->
<div class="wrap_search">
    <!-- opus_design_inquiry(S) -->
    <div class="opus_design_inquiry wFit">
        <!--  biz_1 (S) -->
        <table>
            <colgroup>
                <col width="100" />
                <col width="50"  />
                <col width="150" />
                <col width=""/>
            </colgroup>
            <tbody>
                <tr>
                    <th id="td1">Shipper Code</th>
                    <td id="td2"><input type="text" class="input1" style="width:30px;" name="f_cust_cnt_cd" value="<%=StringUtil.xssFilter(request.getParameter("f_cust_cnt_cd")) %>" maxlength="2" onKeyPress="ComKeyOnlyAlphabet('upper');" onKeyUp="moveTab(this, f_cust_seq);" style="ime-mode:disabled" dataformat="enguponly"></td>
                    <th id="td3">Shipper Sequence</th>
                    <td id="td4"><input  type="text"  style="width:60px;" name="f_cust_seq" value="<%= StringUtil.xssFilter(request.getParameter("f_cust_seq")) %>" maxlength="6" onkeyPress="ComKeyOnlyNumber(this);" ></td>
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
    <!-- opus_design_grid(S) -->
    <div class="opus_design_grid" id="mainTable1">
        <script language="javascript">ComSheetObject('sheet1');</script>
    </div>
    <!-- opus_design_grid(E) -->
</div>
<!-- wrap_result(E) -->
</div>
<!-- popup_contens_area(E) -->

</form>
