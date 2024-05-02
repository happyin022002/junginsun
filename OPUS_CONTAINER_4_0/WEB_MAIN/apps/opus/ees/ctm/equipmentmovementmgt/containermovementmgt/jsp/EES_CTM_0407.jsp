<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CTM_0407.jsp
*@FileTitle  : Domestic MVMT
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/06
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.event.EesCtm0407Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EesCtm0407Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount     = 0;                       //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    Logger log = Logger.getLogger("com.clt.apps.EquipmentMovementMgt.ContainerMovementMgt");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();


        event = (EesCtm0407Event)request.getAttribute("Event");
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
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        loadPage();
    }
</script>
</head>


<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<!-- 개발자 작업    -->
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
    <h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
    <!-- page_title(E) -->
    <!-- opus_design_btn(S) -->
    <div class="opus_design_btn"><!-- 
         --><button type="button" class="btn_accent" name="btn_new"  id="btn_new">New</button><!-- 
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

<div class="wrap_search">
    <!-- opus_design_inquiry(S) -->
    <div class="opus_design_inquiry">
        <table>
            <colgroup>
                <col width="50">
                <col width="70">
                <col width="60">
                <col width="150">
                <col width="60">
                <col width="*">
            </colgroup>
            <tbody>
                <tr>
                    <th>Status</th>
                    <td><select style="width:50px;" class="input1" name="p_status" id="p_status" tabindex="1" onchange="status_Change(this);">
                        <option value="CP" selected>CP</option>
                        <option value="CO">CO</option>
                        <option value="CI">CI</option>
                        <option value="CD">CD</option>
                        <option value="CM">CM</option>
                        <option value="CE">CE</option>
                        <option value="CT">CT</option>
                        </select></td>
                    <th>Origin Yard</th>
                    <td><input type="text" style="width:60px;ime-mode:disabled" maxlength="5" dataformat="engup" class="input1" name="p_yard1" tabindex="2" OnChange="yard_Change(this);"><script type="text/javascript">ComComboObject('p_yard2', 2, 50 , 0, 0, 0, 0, 3)</script></td>
                    <th>Event date</th>
                    <td><input type="text" style="width:75px;ime-mode:disabled" dataformat="ymd" maxlength="10" class="input1" tabindex="4" name="p_date" id="p_date" /><!--  
                        --><button type="button" id="btn_Calendar1" name="btn_Calendar1" class="calendar ir"></button><!-- 
                        --><input type="text" style="width:50px;ime-mode:disabled" maxlength="5" class="input1" tabindex="5" name="p_time" id="p_time" /><!-- 
                        --><input type="hidden" style="width:112px;ime-mode:disabled" maxlength="16" class="input1" name="p_date0" id="p_date0" />
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
    <!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
    <!-- opus_design_grid(S) -->
    <div class="opus_design_grid">
        <div class="opus_design_btn"><!-- 
             --><button type="button" class="btn_normal" name="btn_add"     id="btn_add">Row Add</button><!-- 
             --><button type="button" class="btn_normal" name="btn_delete"      id="btn_delete">Row Delete</button><!-- 
             --><button type="button" class="btn_normal" name="btn_loadExcel"   id="btn_loadExcel">Load Excel</button>
        </div>
        <script type="text/javascript">ComSheetObject('sheet');</script>
    </div>
    <!-- opus_design_grid(S) -->
</div>
<!-- 개발자 작업  끝 -->
</form>