<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0018.jsp
*@FileTitle  : M&R Agreement List
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/13
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.agreementmanage.ratemgt.event.EesMnr0018Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EesMnr0018Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
    String strErrMsg = "";                      //Error message
    int rowCount     = 0;                       //count of DB resultSet list

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String strOfc_cd        = "";
    String rhqOfcCd         = "";
    String strVndr_seq      = "";
    String strVndr_nm       = "";   
    String strAccess_system     = "";   

    Logger log = Logger.getLogger("com.clt.apps.test.test");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strOfc_cd = account.getOfc_cd();
        rhqOfcCd  = account.getRhq_ofc_cd();
        strVndr_seq = account.getOfc_eng_nm();
        strVndr_nm  = account.getOfc_krn_nm();      
        strAccess_system = account.getAccess_system();

        event = (EesMnr0018Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

    }catch(Exception e) {
        out.println(e.toString());
    }
%>

<!-- common use in MNR -->        
<script type="text/javascript">   
    var currOfcCd = '<%=strOfc_cd %>';
    var rhqOfcCd  = '<%=rhqOfcCd %>';
    function setupPage(){    
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            showErrMessage(errMessage);
        } // end if
        loadPage();
    }
</script>



<form name="form" id="form"> 
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="agmt_eq_type" id="agmt_eq_type" />
<input type="hidden" name="ofc_cd" value="<%=strOfc_cd%>" id="ofc_cd" />
<input type="hidden" name="ar_hd_qtr_cd" id="ar_hd_qtr_cd" />
<input type="hidden" name="cost_ofc_cd" id="cost_ofc_cd" />
<input type="hidden" name="agmt_ofc_cd" id="agmt_ofc_cd" />
<input type="hidden" name="strAccess_system" value="<%= strAccess_system%>" id="strAccess_system" />
<input type="hidden" name="strVndr_seq" value="<%= strVndr_seq%>" id="strVndr_seq" />
<input type="hidden" name="strVndr_nm" value="<%= strVndr_nm%>" id="strVndr_nm" />


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
        --><button type="button" class="btn_normal" name="btn_new"   id="btn_new">New</button>
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
                <col width="80"  />
                <col width="200" />
                <col width="120" />
                <col width="250" />
                <col width="80"  />
                <col width="" />
            </colgroup>
            <tbody>
                <tr class="h23">
                    <th>EQ Type</th>
                    <td>
                        <script type="text/javascript">ComComboObject('combo1',1, 90 , 1,1)</script>
                    </td>
                    <th>Effective Period</th>
                    <td>
                        <input type="text" style="width:80px;" class="input1" name="agmt_fm_dt" dataformat="ymd" maxlength="10" cofield="agmt_to_dt" id="agmt_fm_dt" /><!-- 
                        --><input type="text" style="width:80px;" class="input1" name="agmt_to_dt" dataformat="ymd" maxlength="10" cofield="agmt_fm_dt" id="agmt_to_dt" /><!-- 
                        --><button type="button" id="cre_dt_cal" name="cre_dt_cal" class="calendar ir"></button>
                    </td>
                    <th>Service Provider</th>
                    <td>
                        <input type="text" style="width:70px;" class="input" name="vndr_seq" value="" maxlength="6" dataformat="num" id="vndr_seq" /><!-- 
                        --><button type="button" id="btn_popup" name="btn_popup" class="input_seach_btn"></button><!-- 
                        --><input type="text" style="width:140px;" class="input2" readonly="" name="vndr_lgl_eng_nm" id="vndr_lgl_eng_nm" />
                    </td>
                </tr>

                <tr class="h23">
                    <th>Regional HQ</th>
                    <td>
                        <script type="text/javascript">ComComboObject('combo2',2, 90 , 0);</script>
                    </td>
                    <th>Agreement Office</th>
                    <td>
                        <script type="text/javascript">ComComboObject('combo3',2, 80 , 0,'','',0,'');</script>
                    </td>
                    <th>Cost CTRL Office</th>
                    <td>
                        <script type="text/javascript">ComComboObject('combo4',2, 94 , 0);</script>
                    </td>
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
    <div class="opus_design_grid">

        <!-- opus_design_btn(S) -->
        <div class="opus_design_btn">
            <!-- 그리드 버튼 영역(데이터 그리드 상단에 위치) -->
            <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
            <button type="button" class="btn_normal" name="btn_detail" id="btn_detail">Detail(s)</button>
            <button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
        </div>
        <!-- opus_design_btn(E) -->

        <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
        <script type="text/javascript">ComSheetObject('sheet1');</script>
        <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->

    </div>
    <!-- opus_design_grid(E) -->
</div>
<!-- wrap_result(E) -->

</form>