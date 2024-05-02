<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_SCE_0123.jsp
*@FileTitle  : Shippers transport Schedule Management screen
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/18
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.sce.customerscheduleedi.portpairexception.event.EsdSce0123Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsdSce0123Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
    String strErrMsg = "";                      //error message
    int rowCount     = 0;                       //count of DB resultSET list

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();


        event = (EsdSce0123Event)request.getAttribute("Event");
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
<input type="hidden" name="tmp_vsl_slan_cd">
<input type="hidden" name="tmp_vsl_slan_nm">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="partner_id">

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
    <div class="opus_design_btn" id="btnRet">
        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
        <button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
        --><button type="button" class="btn_normal" name="btn_new"   id="btn_new">New</button>
    </div>
    <!-- opus_design_btn(E) -->

    <!-- opus_design_btn(S) -->
    <div class="opus_design_btn" id="btnSave" style="display:none">
        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
        <button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
        -->button type="button" class="btn_normal" name="btn_new"   id="btn_new">New</button><!--
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
                <col width="70" />
                <col width="144" />
                <col width="60"  />
                <col width="130" />
                <col width="70"  />
                <col width="" />
            </colgroup> 
            <tbody>
                <tr>
                    <th>TP ID</th>
                    <td colspan="5">
                        <input name="cust_trd_prnr_id" id="cust_trd_prnr_id" type="text" maxlength="20" value="" tabIndex="1"  caption="TP ID" style="width:100px; text-transform:uppercase;" dataformat="engup" otherchar="\._-" ><!--
                        --><input name="partnerName" id="partnerName" type="text" maxlength="50" style="width:478px" value="" readonly>
                    </td>
                    
                </tr>
                <tr>
                    <th>Location(POL)</th>
                    <td><input type="text" style="width:100px" class="input" name='pol_cd' id="pol_cd" caption='pol_cd' value="" maxlength=5 minlength=5 fullfill style="ime-mode:disabled" dataformat="engup" ></td>
                    <th>Country</th>
                    <td><input name="pol_cnt" id="pol_cnt" type="text"   style="width:100px;"  value="" maxlength=2 minlength=2 fullfill style="ime-mode:disabled" dataformat="engup" ></td>
                    <th>Continent</th>
                    <td>
                        <input name="pol_conti" id="pol_conti" type="text" style="width:45px;"  onfocusout="javascript:resetConti(1)" value="" maxlength=1 minlength=1 fullfill style="ime-mode:disabled" dataformat="engup" ><!--
                        --><button type="button" class="input_seach_btn" name="btns_conti1" id="btns_conti1"></button><!--
                        --><input name="pol_conti_nm" id="pol_conti_nm" type="text" maxlength="10" style="width:100px" value="" readonly>
                    </td>
                </tr>
                <tr>
                    <th>Location(POD)</th>
                    <td><input name="pod_cd" id="pod_cd" type="text" style="width:100px;"   value="" maxlength=5 minlength=5 fullfill style="ime-mode:disabled" dataformat="engup" ></td>
                    <th>Country</th>
                    <td><input name="pod_cnt" id="pod_cnt" type="text" style="width:100px;"  value="" maxlength=5 minlength=5 fullfill style="ime-mode:disabled" dataformat="engup" ></td>
                    <th>Continent</th>
                    <td>
                        <input name="pod_conti" id="pod_conti" type="text" style="width:45px;"  onfocusout="javascript:resetConti(2)" value="" maxlength=5 minlength=5 fullfill style="ime-mode:disabled" dataformat="engup" ><!--
                        --><button type="button" class="input_seach_btn" name="btns_conti2" id="btns_conti2"></button><!--
                        --><input name="pod_conti_nm" id="pod_conti_nm" type="text"   maxlength="10" style="width:100px" value="" readonly>
                    </td>
                </tr>
                <tr id="samLayer" style="display:none">
                    <th>Adjustment Lane</th>
                    <td><input name="slan_cd" id="slan_cd" type="text" maxlength="3" style="width:100px" value="" maxlength=5 minlength=5 fullfill style="ime-mode:disabled" dataformat="engup" ></td>
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
    <div class="opus_design_grid"  id="mainTable1" style="display:none">
        
        <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
        <script type="text/javascript">ComSheetObject('sheet1');</script>
        <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
        
    </div>
    <!-- opus_design_grid(E) -->
    
    <!-- opus_design_grid(S) -->
    <div class="opus_design_grid"  id="mainTable2" style="display:none">
        
        <!-- opus_design_btn(S) -->
        <div class="opus_design_btn" id="btnLayer" style="display:none">
            <!-- 그리드 버튼 영역(데이터 그리드 상단에 위치) -->
            <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
            <button type="button" class="btn_normal" name="btn_RowAdd" id="btn_RowAdd">Row Add</button>
            <button type="button" class="btn_normal" name="btn_RowDelete" id="btn_RowDelete">Row Delete</button>
        </div>
        <!-- opus_design_btn(E) -->
        
        <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
        <script type="text/javascript">ComSheetObject('sheet2');</script>
        <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
        
    </div>
    <!-- opus_design_grid(E) -->
</div>
<!-- wrap_result(E) -->

</form>


