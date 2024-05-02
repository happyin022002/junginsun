<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_5005.jsp
*@FileTitle  : Service Scope Property Mapping Creation
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
<%@ page import="com.clt.apps.opus.esm.pri.pricommondata.pricommondata.event.EsmPri5005Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmPri5005Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount     = 0;                       //DB ResultSet 리스트의 건수
    
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    Logger log = Logger.getLogger("com.clt.apps.PRIMasterData.RatingUnit");
    
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
       
       
        event = (EsmPri5005Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        
        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        
    }catch(Exception e) {
        out.println(e.toString());
    }
%>

<script type="text/javascript">
    function setupPage(){
        //alert("setupPage");
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            showErrMessage(errMessage);
        } // end if
        loadPage();
    }
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input name="cd" type="hidden" value="">
<input name="locSvcScpCd" type="hidden" value="">

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
         --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--
         --><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button>
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
<div class="opus_design_inquiry">
    <!--  biz_1 (S) -->
    <table>
        <colgroup>
            <col width="90px"  />
            <col width="390px"  />
            <col width=""      />
        </colgroup>
        <tbody>
            <tr>
                <th>Service Scope</th>
                <td>
                    <script type="text/javascript">ComComboObject("svc_scp_cd", 2, 80, 0, 1, 0, false);</script><input name="svc_scp_nm" type="text" style="width:290px;"  value="" class="input2" readonly caption="Service Scope">
                </td>
                <td></td>
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
    <!-- Hidden sheet for Transaction (S) -->
    <script type="text/javascript">ComSheetObject('sheet0');</script>
    <!-- Hidden sheet for Transaction (E) -->

    <!-- opus_grid_btn(S) -->
    <div class="opus_design_btn">
        <button type="button" class="btn_normal" name="btn_add" id="btn_add">Row Add</button>
        <button type="button" class="btn_normal" name="btn_delete" id="btn_delete">Row Delete</button>
    </div>
    <!-- opus_grid_btn(E) -->

    <script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
<!-- opus_design_grid(E) -->
</div>
</form>
