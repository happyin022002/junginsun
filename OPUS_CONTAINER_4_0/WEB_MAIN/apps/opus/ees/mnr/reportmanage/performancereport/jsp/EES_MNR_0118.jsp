<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0118.jsp
*@FileTitle  : MNR PFMC by EQ
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
<%@ page import="com.clt.apps.opus.ees.mnr.reportmanage.performancereport.event.EesMnr0118Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EesMnr0118Event  event = null;               //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
    String strErrMsg = "";                      //Error message
    int rowCount     = 0;                       //count of DB resultSet list

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    Logger log = Logger.getLogger("com.clt.apps.ReportManage.PerformanceReport");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();


        event = (EesMnr0118Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // adding logic to get data from sever when first loading
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
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="pagerows" name="pagerows" type="hidden" />
<input id="curr_cd" name="curr_cd" type="hidden" />
<input id="mnr_warr_flg" name="mnr_warr_flg" type="hidden" />


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
        <button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
        --><button type="button" class="btn_normal" name="btn_New"   id="btn_New">New</button>
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
                <col width="90"  />
                <col width="170" />
                <col width="50"  />
                <col width="340" />
                <col width="60"  />
                <col width="170" />
                <col width="50"  />
                <col width="" />
            </colgroup> 
            <tbody>
                <tr>
                    <th>Report Type</th>
                    <td><script type="text/javascript">ComComboObject('report_type',1, 140 , 1,1)</script></td>
                    <th>Period</th>
                    <td>
                        <script type="text/javascript">ComComboObject('report_period_type',2, 110 , 1,1)</script><!--
                        --><input required type="text" name="fm_dt" id="fm_dt" dataformat="ymd"  maxlength="10"  size="10"  cofield="to_dt" value="" class="input1">~&nbsp;<!--
                        --><input required type="text" name="to_dt" id="to_dt" dataformat="ymd"  maxlength="10"  size="10"  cofield="fm_dt" class="input1"><!--
                        --><button type="button" class="calendar ir" name="btn_calendar" id="btn_calendar"></button>
                    </td>
                    <th>EQ Type</th>
                    <td><script type="text/javascript">ComComboObject('eq_type',2, 140, 1, 0, 0);</script></td>
                    <th>TP/SZ</th>
                    <td><script type="text/javascript">ComComboObject('tp_sz_cd', 2, 100 ,0);</script></td>
                </tr>
            </tbody>
        </table>
        <!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
        
        <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
        <table>
             <colgroup>
                <col width="90"  />
                <col width="170" />
                <col width="50"  />
                <col width="149" />
                <col width="110" />
                <col width="316" />
                <col width="50"  />
                <col width="" />
            </colgroup> 
            <tbody>
                <tr>
                    <th>Regional HQ</th>
                    <td><script type="text/javascript">ComComboObject('rhq',2, 100, 0, 0);</script></td>
                    <th>Office</th>
                    <td><script type="text/javascript">ComComboObject('ofc_cd',2, 100 ,0, 0,'',0,'');</script></td>
                    <th>Service Provider</th>
                    <td>
                        <input type="text" name="vndr_seq" id="vndr_seq" caption="Service Provider" style="width:57px;text-align:left;" class="input" value="" dataformat="num" maxlength="6"><!--
                        --><button type="button" class="input_seach_btn" name="btn_provider_popup" id="btn_provider_popup"></button><!--
                        --><input type="text" name="vndr_lgl_eng_nm" id="vndr_lgl_eng_nm" caption="Service Provider" style="width:204px;" class="input2" value="" readonly>
                    </td>
                    <th>USD Only</th>
                    <td><input name="check_usd_only" id="check_usd_only" type="checkbox" class="trans"></td>
                </tr>
            </tbody>
        </table>
        <!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
        
        <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
        <table>
             <colgroup>
                <col width="162" />
                <col width="297" />
                <col width="110" />
                <col width="150" />
                <col width="50"  />
                <col width="" />
            </colgroup> 
            <tbody>
                <tr>
                    <th>EQ Manufacturing Period</th>
                    <td>
                        <input type="text" name="manu_yr_fr" id="manu_yr_fr" style="width:50px;text-align:center" class="input" maxlength="4" dataformat="yyyy"><!--
                        --><button type="button" class="calendar ir" name="manu_yr_fr_cal" id="manu_yr_fr_cal"></button>~&nbsp;<!--
                        --><input type="text" name="manu_yr_to" id="manu_yr_to" style="width:50px;text-align:center" class="input" maxlength="4" dataformat="yyyy"><!--
                        --><button type="button" class="calendar ir" name="manu_yr_to_cal" id="manu_yr_to_cal"></button>
                    </td>
                    <th>EQ Term</th>
                    <td><script type="text/javascript">ComComboObject('lstm_cd',2, 140,0);</script></td>
                    <th>Warranty</th>
                    <td><input name="check_warranty" id="check_warranty" type="checkbox" class="trans"></td>
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
    <div class="opus_design_grid"  id="mainTable">
        
        <!-- opus_design_btn(S) -->
        <div class="opus_design_btn">
            <!-- 그리드 버튼 영역(데이터 그리드 상단에 위치) -->
            <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
            <button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button>
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
