<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_SCE_3301.jsp
*@FileTitle  : Activity Group
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/19
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.sce.common.manualinput.event.EsdSce3302Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsdSce3302Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //Error On Server Side
    String strErrMsg = "";                      //Error Message
    int rowCount     = 0;                       //DB ResultSet List Count

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    Logger log = Logger.getLogger("com.clt.apps.opus.esd.sce.copreport");
    int rowSize = 3000 ;

    //selected value in exception combo box
    String expt_tp_idx = JSPUtil.getNull(request.getParameter("expt_tp_selected_idx"));

    
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();


        event = (EsdSce3302Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        //The data obtained from the server side on load.
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

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
    }
</script>

<form name="form" id="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="chk_nod_tp_cd">
<input type="hidden" name="chk_bkg_term_cd">
<input type="hidden" name="chk_bfr_trsp_mod_cd">
<input type="hidden" name="chk_aft_trsp_mod_cd">
<input type="hidden" name="chk_trsp_bnd_cd">
<input type="hidden" name="chk_spcl_nod_tp_cd">

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
        --><button type="button" class="btn_normal" name="btn_save"   id="btn_save">Save</button><!--
        --><button type="button" class="btn_normal" name="btn_exceldown"   id="btn_exceldown">Down Excel</button><!--
        --><button type="button" class="btn_normal" name="btn_excelup"   id="btn_excelup">Load Excel</button>
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
<div class="wrap_result">
    <!-- opus_design_grid(S) -->
    <div class="opus_design_grid"  id="mainTable">
        
        <!-- opus_design_btn(S) -->
        <div class="opus_design_btn">
            <!-- 그리드 버튼 영역(데이터 그리드 상단에 위치) -->
            <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
            <button type="button" class="btn_normal" name="btn_RowAdd" id="btn_RowAdd">Row&nbsp;Add</button>
            <button type="button" class="btn_normal" name="btn_RowDel" id="btn_RowDel">Row&nbsp;Delete</button>
        </div>
        <!-- opus_design_btn(E) -->
        
        <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
        <script language="javascript">ComSheetObject('sheet1');</script>
        <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
        
    </div>
    <!-- opus_design_grid(E) -->
</div>
<!-- wrap_search(E) -->
                
</form>


