<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_4008.jsp
*@FileTitle  : Surcharge Commodity Group Creation 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.surcharge.surchargegroupcommodity.event.EsmPri4008Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmPri4008Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //Error from Server
    String strErrMsg = "";                      //Error Message
    int rowCount     = 0;                       //Number of DB ResultSet List

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

        event = (EsmPri4008Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // Adding Logic extracting data from server when loading initial window ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

    }catch(Exception e) {
        out.println(e.toString());
    }
%>

<script language="javascript">
    function setupPage(){
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
<input type="hidden" name="scg_grp_cmdt_seq" value="">
<input name="cd" type="hidden" value="">
<input type="hidden" name="max_seq" value="0">
<input type="hidden" name="chg_cd" value="OFT" />

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
        --><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button>
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
    <!--  MiniLayer (S) -->
    <table>
        <colgroup>
            <col width="90" />
            <col width="" />
        </colgroup>
        <tbody>
            <tr class="h23">
                <th>Service Scope</tH>
                <td>
                    <script language="javascript">ComComboObject('svc_scp_cd', 2, 60, 0, 1, 0, true);</script>
                    <input name="svc_scp_nm" type="text" style="width:300px;"  value="" class="input2" readonly>
                </td>
            </tr>
        </tbody>
    </table>
    <!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
</div>
</div>
<!-- opus_design_inquiry(E) -->

<!-- opus_design_grid(S) -->
<div class="wrap_result">
    <div class="layout_wrap">
        <div style="display:none">
            <script language="javascript">ComSheetObject('sheet0');</script>
        </div>
        
        <div class="layout_vertical_2 pad_rgt_8" style="width:35%">
            <div class="opus_design_grid">
                <!-- opus_grid_btn(S) -->
                <div class="opus_design_btn">
                    <button type="button" class="btn_normal" name="btn_add" id="btn_add">Row Add</button>
                    <button type="button" class="btn_normal" name="btn_del" id="btn_del">Row Delete</button>
                </div>
                <!-- opus_grid_btn(E) -->
            
                <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
                <script language="javascript">ComSheetObject('sheet1');</script>
                <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
            </div>
        </div>
        
        <div class="layout_vertical_2" style="width:65%">
            <div class="opus_design_grid">
                <!-- opus_grid_btn(S) -->
                <div class="opus_design_btn">
                    <button type="button" class="btn_normal" name="btn_add2" id="btn_add2">Row Add</button>
                    <button type="button" class="btn_normal" name="btn_del2" id="btn_del2">Row Delete</button>
                    <button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
                </div>
                <!-- opus_grid_btn(E) -->
            
                <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
                <script language="javascript">ComSheetObject('sheet2');</script>
                <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
            </div>
        </div>
        
        <div id="hiddenSheetLayer" style="display:none">
            <script language="javascript">ComSheetObject('sheet3');</script>
        </div>
    </div>
</div>
<!-- opus_design_grid(E) -->
<!-- page(E) -->

</form>