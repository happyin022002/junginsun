<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_4019.jsp
*@FileTitle  : Surcharge Commodity Group Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/6/24
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.surcharge.surchargegroupcommodity.event.EsmPri4019Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmPri4019Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
    String strErrMsg = "";                      //error message
    int rowCount     = 0;                       //count of DB resultSET list

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    Logger log = Logger.getLogger("com.clt.apps.Surcharge.CommonGroupCommodity");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();


        event = (EsmPri4019Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }


        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

    }catch(Exception e) {
        out.println(e.toString());
    }
%>
<script type="text/javascript">
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            showErrMessage(errMessage);
        } // end if
        loadPage();
    }
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="scg_grp_cmdt_seq" value="" id="scg_grp_cmdt_seq" />
<input name="cd" type="hidden" value="" id="cd" />
<input type="hidden" name="chg_cd" value="OFT" id="chg_cd" />

<div class="page_title_area clear">
   <!-- page_title(S) -->
    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
    <h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
    <!-- page_title(E) -->
    <!-- opus_design_btn(S) -->
    <div class="opus_design_btn">
    	<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button>  
    </div>
    <!-- opus_design_btn(E) -->

    <!-- page_location(S) -->
    <div class="location">
        <!-- location 내용 동적생성 (별도 코딩 불필요) -->
        <span id="navigation"></span>
    </div>
</div>
<div class="wrap_search">
    <div class="opus_design_inquiry wFit">
        <table>
            <colgroup>
                <col width="80">
                <col width="*">
            </colgroup>
            <tr>
                <th>Service Scope</th>
                <td><script type="text/javascript">ComComboObject('svc_scp_cd', 2, 60, 0, 1, 0, false);</script><input name="svc_scp_nm" type="text" style="width:200px;"  value="" class="input2" readonly id="svc_scp_nm"></td>
            </tr>
        </table>
    </div>
</div>

<div class="wrap_result">
    <div class="layout_wrap">
        <div class="layout_vertical_2 pad_rgt_8" style="width: 35%">
            <div class="opus_design_grid" id="mainTable">
                <script type="text/javascript">ComSheetObject('sheet1');</script>
            </div>
        </div>
        <div class="layout_vertical_2" style="width: 65%">
            <div class="opus_design_grid" id="mainTable">
                <script type="text/javascript">ComSheetObject('sheet2');</script>
            </div>
        </div>
    </div>
    <div class="opus_design_grid" style="display: none;">
        <script type="text/javascript">ComSheetObject('sheet0');</script>
    </div>
</div>
</form>