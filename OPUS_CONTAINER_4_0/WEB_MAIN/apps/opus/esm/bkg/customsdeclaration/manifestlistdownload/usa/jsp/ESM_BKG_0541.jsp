<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0541.jsp
*@FileTitle  : US AMS: Main Menu
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/22
=========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount     = 0;                       //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String strOfc_cd        = "";
    String strPgmNo         = "";
    String strOfcType       = "";
    Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");
    
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strOfc_cd = account.getOfc_cd();

        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        
        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        strPgmNo = request.getParameter("pgmNo");
        if("ESM_BKG_0541".equals(strPgmNo)) strOfcType = "Origin";
        if("ESM_BKG_0541_2".equals(strPgmNo)) strOfcType = "US";
        
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
</head>

<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="ofcType" value="<%=strOfcType%>">
<!-- 개발자 작업    -->

<!-- page_title_area(S) -->
<div class="page_title_area clear">
    
    <!-- page_title(S) -->
    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
    <h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
    <!-- page_title(E) -->
    
    <!-- page_location(S) -->
    <div class="location">
        <!-- location 내용 동적생성 (별도 코딩 불필요) -->
        <span id="navigation"></span>
    </div>
    <!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->
    
    <!-- layout_wrap(S) -->
    <div class="layout_wrap">
        <!-- layout_vertical_2(S) -->
        <div class="layout_vertical_2 pad_rgt_8" style="width:50%;">
            <!-- background DIV(S) -->
            <div class="sm pad_rgt_12 pad_left_12 pad_btm_8 pad_top_8 mar_top_12">
            
                <!-- opus_grid_title(S) -->
                <h3 class="title_design">Origin Office</h3>
                <!-- opus_grid_title(E) -->
                <div class="sm" style="height:500px;">
                    <h3>Preparation</h3>
                    <table style="width:100%">
                        <colgroup>
                            <col width="100%" />
                        </colgroup>
                        <tbody>
                            <tr>
                                <td class="pad_btm_4"><button type="button" style="width:100%" class="btn_etc align_left" name="btn_1_1" id="btn_1_1" onmouseover="obj_MouseOver('btn_1_1')" onmouseout="obj_MouseOut('btn_1_1')" >1. Manifest Data Input Cross-Check</button></td>
                            </tr>
                            <tr>
                                <td class="pad_btm_4"><button type="button" style="width:100%" class="btn_etc align_left" name="btn_1_2" id="btn_1_2" onmouseover="obj_MouseOver('btn_1_2')" onmouseout="obj_MouseOut('btn_1_2')" >2. House B/L Data Input Cross-Check</button></td>
                            </tr>
                        </tbody>
                    </table>

                    <h3 class="mar_top_12">Manifest Transmit</h3>
                    <table style="width:100%">
                        <colgroup>
                            <col width="100%" />
                        </colgroup>
                        <tbody>
                            <tr>
                                <td class="pad_btm_4"><button type="button" style="width:100%" class="btn_etc align_left" name="btn_2_1" id="btn_2_1" onmouseover="obj_MouseOver('btn_2_1')" onmouseout="obj_MouseOut('btn_2_1')" >1. Customs Data Download (D/L)</button></td>
                            </tr>
                            <tr>
                                <td class="pad_btm_4"><button type="button" style="width:100%" class="btn_etc align_left" name="btn_2_2" id="btn_2_2" onmouseover="obj_MouseOver('btn_2_2')" onmouseout="obj_MouseOut('btn_2_2')" >2. Manifest Transmit (MI)</button></td>
                            </tr>
                            <tr>
                                <td class="pad_btm_4"><button type="button" style="width:100%" class="btn_etc align_left" name="btn_2_3" id="btn_2_3" onmouseover="obj_MouseOver('btn_2_3')" onmouseout="obj_MouseOut('btn_2_3')" >3. Vessel Departure Transmit (HI)</button></td>
                            </tr>
                        </tbody>
                    </table>

                    <h3 class="mar_top_12">Manifest Amend</h3>
                    <table style="width:100%">
                        <colgroup>
                            <col width="100%" />
                        </colgroup>
                        <tbody>
                            <tr>
                                <td class="pad_btm_4"><button type="button" style="width:100%" class="btn_etc align_left" name="btn_3_1" id="btn_3_1" onmouseover="obj_MouseOver('btn_3_1')" onmouseout="obj_MouseOut('btn_3_1')" >1. Amendment Transmit (AI)</button></td>
                            </tr>
                            <tr>
                                <td class="pad_btm_4"><button type="button" style="width:100%" class="btn_etc align_left" name="btn_3_2" id="btn_3_2" onmouseover="obj_MouseOver('btn_3_2')" onmouseout="obj_MouseOut('btn_3_2')" >2. Manifest Details by B/L (Origin Office)</button></td>
                            </tr>
                        </tbody>
                    </table>

                    <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
<%--
                    <h3 class="mar_top_12">Stowage Plan</h3>
                    <table style="width:100%">
                        <colgroup>
                            <col width="100%" />
                        </colgroup>
                        <tbody>
                            <tr>
                                <td class="pad_btm_4"><button type="button" style="width:100%" class="btn_etc align_left" name="btn_4_1" id="btn_4_1" onmouseover="obj_MouseOver('btn_4_1')" onmouseout="obj_MouseOut('btn_4_1')" >1. Vessel Stowage Plan Transmit (BAPLIE)</button></td>
                            </tr>
                        </tbody>
                    </table>
 --%>
                    <h3 class="mar_top_12">Report</h3>
                    <table style="width:100%">
                        <colgroup>
                            <col width="100%" />
                        </colgroup>
                        <tbody>
                            <tr>
                                <td class="pad_btm_4"><button type="button" style="width:100%" class="btn_etc align_left" name="btn_AMS_1" id="btn_AMS_1" onmouseover="obj_MouseOver('btn_AMS_1')" onmouseout="obj_MouseOut('btn_AMS_1')" >1. Transmission History</button></td>
                            </tr>
                            <tr>
                                <td class="pad_btm_4"><button type="button" style="width:100%" class="btn_etc align_left" name="btn_AMS_2" id="btn_AMS_2" onmouseover="obj_MouseOver('btn_AMS_2')" onmouseout="obj_MouseOut('btn_AMS_2')" >2. Receiving History</button></td>
                            </tr>
                            <tr>
                                <td class="pad_btm_4"><button type="button" style="width:100%" class="btn_etc align_left" name="btn_AMS_3" id="btn_AMS_3" onmouseover="obj_MouseOver('btn_AMS_3')" onmouseout="obj_MouseOut('btn_AMS_3')" >3. Transmission Status Cross-Check</button></td>
                            </tr>
                            <tr>
                                <td class="pad_btm_4"><button type="button" style="width:100%" class="btn_etc align_left" name="btn_AMS_4" id="btn_AMS_4" onmouseover="obj_MouseOver('btn_AMS_4')" onmouseout="obj_MouseOut('btn_AMS_4')" >4. AMS Report</button></td>
                            </tr>
                            <tr>
                                <td class="pad_btm_4"><button type="button" style="width:100%" class="btn_etc align_left" name="btn_AMS_5" id="btn_AMS_5" onmouseover="obj_MouseOver('btn_AMS_5')" onmouseout="obj_MouseOut('btn_AMS_5')" >5. Auto Filing NVOCC Transmission Status</button></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <!-- background DIV(E) -->
        </div>
        <!-- layout_vertical_2(E) -->
    
        <!-- layout_vertical_2(S) -->
        <div class="layout_vertical_2 pad_rgt_8" style="width:50%;">
            <!-- background DIV(S) -->
            <div class="sm pad_rgt_12 pad_left_12 pad_btm_8 pad_top_8 mar_top_12">
                <!-- opus_grid_title(S) -->
                <h3 class="title_design">U.S. Office</h3>
                <!-- opus_grid_title(E) -->
                <div class="sm" style="height:500px;">
                    <h3>I/B Documentation</h3>
                    <table style="width:100%">
                        <colgroup>
                            <col width="100%" />
                        </colgroup>
                        <tbody>
                            <tr>
                                <td class="pad_btm_4"><button type="button" style="width:100%" class="btn_etc align_left" name="btn_IB_1" id="btn_IB_1" onmouseover="obj_MouseOver('btn_IB_1')" onmouseout="obj_MouseOut('btn_IB_1')" >1. Customs Data Download (D/L)</button></td>
                            </tr>
                            <tr>
                                <td class="pad_btm_4"><button type="button" style="width:100%" class="btn_etc align_left" name="btn_IB_2" id="btn_IB_2" onmouseover="obj_MouseOver('btn_IB_2')" onmouseout="obj_MouseOut('btn_IB_2')" >2. Manifest Transmit (MI)</button></td>
                            </tr>
                            <tr>
                                <td class="pad_btm_4"><button type="button" style="width:100%" class="btn_etc align_left" name="btn_IB_3" id="btn_IB_3" onmouseover="obj_MouseOver('btn_IB_3')" onmouseout="obj_MouseOut('btn_IB_3')" >3. EDA Adjust</button></td>
                            </tr>
                            <tr>
                                <td class="pad_btm_4"><button type="button" style="width:100%" class="btn_etc align_left" name="btn_IB_4" id="btn_IB_4" onmouseover="obj_MouseOver('btn_IB_4')" onmouseout="obj_MouseOut('btn_IB_4')" >4. Vessel Arrival Transmit (HI)</button></td>
                            </tr>
                            <tr>
                                <td class="pad_btm_4"><button type="button" style="width:100%" class="btn_etc align_left" name="btn_IB_5" id="btn_IB_5" onmouseover="obj_MouseOver('btn_IB_5')" onmouseout="obj_MouseOut('btn_IB_5')" >5. C/A Report (I/B)</button></td>
                            </tr>
                            <tr>
                                <td class="pad_btm_4"><button type="button" style="width:100%" class="btn_etc align_left" name="btn_IB_6" id="btn_IB_6" onmouseover="obj_MouseOver('btn_IB_6')" onmouseout="obj_MouseOut('btn_IB_6')" >6. Amendment Transmit (AI)</button></td>
                            </tr>
                            <tr>
                                <td class="pad_btm_4"><button type="button" style="width:100%" class="btn_etc align_left" name="btn_IB_7" id="btn_IB_7" onmouseover="obj_MouseOver('btn_IB_7')" onmouseout="obj_MouseOut('btn_IB_7')" >7. Manifest Details by B/L (US Office)</button></td>
                            </tr>
                            <tr>
                                <td class="pad_btm_4"><button type="button" style="width:100%" class="btn_etc align_left" name="btn_IB_8" id="btn_IB_8" onmouseover="obj_MouseOver('btn_IB_8')" onmouseout="obj_MouseOut('btn_IB_8')" >8. B/L Inquiry by Container</button></td>
                            </tr>
                            <tr>
                                <td class="pad_btm_4"><button type="button" style="width:100%" class="btn_etc align_left" name="btn_IB_9" id="btn_IB_9" onmouseover="obj_MouseOver('btn_IB_9')" onmouseout="obj_MouseOut('btn_IB_9')" >9. Hold Notice Send</button></td>
                            </tr>
                        </tbody>
                    </table>

                    <h3 class="mar_top_12">In-Bond Trans.</h3>
                    <table style="width:100%">
                        <colgroup>
                            <col width="100%" />
                        </colgroup>
                        <tbody>
                            <tr>
                                <td class="pad_btm_4"><button type="button" style="width:100%" class="btn_etc align_left" name="btn_IT_1" id="btn_IT_1" onmouseover="obj_MouseOver('btn_IT_1')" onmouseout="obj_MouseOut('btn_IT_1')" >1. P/MIB Generate</button></td>
                            </tr>
                            <tr>
                                <td class="pad_btm_4"><button type="button" style="width:100%" class="btn_etc align_left" name="btn_IT_2" id="btn_IT_2" onmouseover="obj_MouseOver('btn_IT_2')" onmouseout="obj_MouseOut('btn_IT_2')" >2. P/MIB Arrival & Export Transmit</button></td>
                            </tr>
                        </tbody>
                    </table>

                    <h3 class="mar_top_12">Code / Setup</h3>
                    <table style="width:100%">
                        <colgroup>
                            <col width="100%" />
                        </colgroup>
                        <tbody>
                            <tr>
                                <td class="pad_btm_4"><button type="button" style="width:100%" class="btn_etc align_left" name="btn_CS_1" id="btn_CS_1" onmouseover="obj_MouseOver('btn_CS_1')" onmouseout="obj_MouseOut('btn_CS_1')" >1. Entry Type Setup</button></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <!-- background DIV(E) -->
        </div>
        <!-- layout_vertical_2(E) -->
    </div>
    <!-- layout_wrap(E) -->
</form>
