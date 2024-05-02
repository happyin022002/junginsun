<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0119.jsp
*@FileTitle  : PFMC by CEDEX Code
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
<%@ page import="com.clt.apps.opus.ees.mnr.reportmanage.performancereport.event.EesMnr0119Event"%>
<%@ page import="org.apache.log4j.Logger" %>
 
<%
    EesMnr0119Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
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


        event = (EesMnr0119Event)request.getAttribute("Event");
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

<script language="javascript">

    function setupPage(){

        loadPage();
    }

</script>

<form name="form" id="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">


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
        --><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button>
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
                <col width="70"  />
                <col width="145" />
                <col width="80"  />
                <col width="80"  />
                <col width="80"  />
                <col width="80"  />
                <col width="110" />
                <col width="80"  />
                <col width="80"  />
                <col width="" />
            </colgroup> 
            <tbody>
                <tr>
                    <th>Period</th>
                    <td colspan="3">
                        <script language="javascript">ComComboObject('report_period_type',2, 110 , 1,1)</script><!--
                        --><input required type="text" name="fm_dt" id="fm_dt" dataformat="ymd" caption="from date" maxlength="10"  style="width:80px;"  cofield="to_dt"  value="" class="input1">~&nbsp;<!--
                        --><input required type="text" name="to_dt" id="to_dt" dataformat="ymd" caption="to date" maxlength="10" style="width:80px;"  cofield="fm_dt" class="input1"><!--
                        --><button type="button" class="calendar ir" name="btn_calendar" id="btn_calendar"></button>
                    </td>
                    <td>
                        <label for="currency_ck"><b>USD Only</b></label><!--
                        --><input type="checkbox" name="currency_ck" id="currency_ck" class="trans"><!--
                        --><input type="hidden" name="currency" id="currency">
                    </td>
                    <td>
                        <label for="qty_ck"><b>QTY Only</b></label><!--
                        --><input type="checkbox" name="qty_ck" id="qty_ck" class="trans"><!--
                        --><input type="hidden" name="qty" id="qty">
                    </td>
                    <td colspan="4"></td>
                </tr>
                <tr>
                    <th>EQ Type</th>
                    <td><script language="javascript">ComComboObject('eq_type',2, 110, 1, 0);</script></td>
                    <th>Regional HQ</th>
                    <td><script language="javascript">ComComboObject('rhq',2, 80, 0, 0);</script></td>
                    <th>Office</th>
                    <td><script language="javascript">ComComboObject('ofc_cd',2, 80 ,0, 0,'',0,'');</script></td>
                    <th>Service Provider</th>
                    <td colspan="3">
                        <input type="text" name="vndr_seq" id="vndr_seq" caption="Service Provider" style="width:57px;text-align:left;" class="input" value="" dataformat="num" maxlength="6"><!--
                        --><button type="button" class="input_seach_btn" name="btn_provider_popup" id="btn_provider_popup"></button><!--
                        --><input type="text" name="vndr_lgl_eng_nm" id="vndr_lgl_eng_nm" caption="Service Provider" style="width:157px;" class="input2" value="" readonly>
                    </td>
                </tr>
                <tr>
                    <th>Location</th>
                    <td>
                        <input type="text" name="location_cd" id="location_cd" dataformat="engup" style="width:82px;" class="input" maxlength="4"><!--
                        --><button type="button" class="input_seach_btn" name="btn_location" id="btn_location"></button>
                    </td>
                    <th>Component</th>
                    <td><script language="javascript">ComComboObject('component', 2, 80, 0, 0);</script></td>
                    <th>Repair</th>
                    <td><script language="javascript">ComComboObject('repair', 2, 80, 0, 0);</script></td>
                    <th>Division</th>
                    <td><script language="javascript">ComComboObject('division', 2, 80, 0, 0);</script></td>
                    <th>Damage</th>
                    <td><script language="javascript">ComComboObject('damage', 2, 80, 0, 0);</script></td>
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
        <h3 class="title_design">M &amp; R Performance Detail</h3>
            </tr>
        </table>
                
        <!-- opus_design_btn(S) -->
        <div class="opus_design_btn">
            <!-- 그리드 버튼 영역(데이터 그리드 상단에 위치) -->
            <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
            <button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button>
        </div>
        <!-- opus_design_btn(E) -->
        
        <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
        <script language="javascript">ComSheetObject('sheet1');</script>
        <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
        
    </div>
    <!-- opus_design_grid(E) -->
</div>
<!-- wrap_result(E) -->

</form>
