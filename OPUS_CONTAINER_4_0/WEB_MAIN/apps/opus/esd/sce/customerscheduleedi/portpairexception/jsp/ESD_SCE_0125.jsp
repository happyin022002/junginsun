<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_SCE_0125.jsp
*@FileTitle  : Route Exception
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
<%@ page import="com.clt.apps.opus.esd.sce.customerscheduleedi.portpairexception.event.EsdSce0125Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
    EsdSce0125Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
    String strErrMsg = "";                      //error message
    int rowCount     = 0;                       //count of DB resultSET list

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    Logger log = Logger.getLogger("com.clt.apps.opus.esd.sce.customerscheduleedi.portpairexception");
    
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();


        event = (EsdSce0125Event)request.getAttribute("Event");
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
            ComShowMessage(errMessage);
        } // end if
        loadPage();
    }
</script>
<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="partner_id" id="partner_id" />
<input type="hidden" name="usr_id" value="<%= strUsr_id %>" id="usr_id" />
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
        --><button type="button" class="btn_normal" name="btn_new"   id="btn_new">New</button><!--
        --><button type="button" class="btn_normal" name="btn_save"   id="btn_save">Save</button>
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
                <col width="50"  />
                <col width="120" />
                <col width="50"  />
                <col width="120" />
                <col width="50"  />
                <col width="120" />
                <col width="50"  />
                <col width="" />
            </colgroup> 
            <tbody>
                <tr>
                    <th>TP ID</th>
                    <td colspan="7"><input name="cust_trd_prnr_id" id="cust_trd_prnr_id" type="text" maxlength="20" value="" caption="TP ID" style="width:100px; text-transform:uppercase;" dataformat="engup" otherchar="\._-"><!--
                        --><input name="partnerName" id="partnerName" type="text"   maxlength="50" style="width:325px" value="" readonly>
                    </td>
                </tr>
                <tr>
                    <th title="Place of Receipt">POR</th>
                    <td><input type="text" name="por_port_cd" id="por_port_cd" value="" style="width:60px" dataformat="engup"><!--
                        --><button type="button" class="input_seach_btn" name="btn_por_port_cd" id="btn_por_port_cd" ></button>
                    </td>
                    <th title="Port of Loading">POL</th>
                    <td><input type="text" name="pol_port_cd" id="pol_port_cd" value="" style="width:60px" dataformat="engup"><!--
                        --><button type="button" class="input_seach_btn" name="btn_pol_port_cd" id="btn_pol_port_cd" 	></button>
                    </td>
                    <th title="Port of Discharging">POD</th>
                    <td><input type="text" name="pod_port_cd" id="pod_port_cd" value="" style="width:60px" dataformat="engup"><!--
                        --><button type="button" class="input_seach_btn" name="btn_pod_port_cd" id="btn_pod_port_cd" 	></button>
                    <th title="Place of Delivery">DEL</th>
                    <td><input type="text" name="del_port_cd" id="del_port_cd" value="" style="width:60px" dataformat="engup"><!--
                        --><button type="button" class="input_seach_btn" name="btn_del_port_cd" id="btn_del_port_cd" 	></button>
                    </td>
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
        <!-- opus_design_btn(S) -->
        <div class="opus_design_btn"><!-- 
             --><button type="button" class="btn_normal" name="btn_RowAdd" id="btn_RowAdd">Row Add</button><!-- 
             --><button type="button" class="btn_normal" name="btn_RowCopy" id="btn_RowCopy">Row Copy</button><!-- 
         --></div>
        <!-- opus_design_btn(E) -->
        <script type="text/javascript">ComSheetObject('sheet1');</script>
    </div>
    <!-- opus_design_grid(E) -->
</div>
<!-- wrap_result(E) -->

</form>
