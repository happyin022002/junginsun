<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0387.jsp
*@FileTitle  :  Next VVD Assign I (by VVD POD)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/20
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.event.EsmBkg0387Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmBkg0387Event  event = null;              //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
    String strErrMsg = "";                      //Error message
    int rowCount     = 0;                       //DB ResultSet list count

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String strRelay         = "";
    String strEtbFrom       = "";
    String strEtbTo         = "";
    String strNextVvd       = "";
    Logger log = Logger.getLogger("com.clt.apps.TransshipmentMgt.TransshipmentMgt");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();

        event = (EsmBkg0387Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        
        strRelay=event.getRelay();
        strEtbFrom = event.getEtbFrom();
        strEtbTo =event.getEtbTo();
        strNextVvd =event.getNextVvd();

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        //Add logic information data from the server when loading the initial screen
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

<form name="form"  onkeyup="ComKeyEnter('lengthnextfocus');" id="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="nextVvdFor">
<input type="hidden" name="oldRelayPort">
<input type="hidden" name="baseRelayPort">
<input type="hidden" name="relay" value="<%=strRelay%>">
<input type="hidden" name="etbFrom" value="<%=strEtbFrom%>">
<input type="hidden" name="etbTo" value="<%=strEtbTo%>">
<input type="hidden" name="nextVvd" value="<%=strNextVvd%>">

        
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
        --><button type="button" class="btn_normal" name="btn_DownExcel"   id="btn_DownExcel">Down Excel</button><!--
        --><button type="button" class="btn_normal" name="btn_cancelassign"   id="btn_cancelassign">Cancel&nbsp;Assign</button><!--
        --><button type="button" class="btn_normal" name="btn_vvdassign"   id="btn_vvdassign">VVD&nbsp;Assign</button>
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
                <col width="120" />
                <col width="80"  />
                <col width="120" />
                <col width="80"  />
                <col width="120" />
                <col width="80"  />
                <col width="120" />
                <col width="70"  />
                <col width="" />
            </colgroup> 
            <tbody>
                <tr>
                    <th>Relay Port</th>
                    <td><input type="text" style="width:60px;" class="input1" name="relay_port" id="relay_port" maxlength="7" dataformat="engup" ></td>
                    <th>Former VVD</th>
                    <td><input type="text" style="width:90px;" class="input" name="former_vvd" id="former_vvd" maxlength="9" dataformat="engup"></td>
                    <th>ETB Duration</th>
                    <td colspan="3">
                        <input type="text" style="width:80px;" class="input1" value="" dataformat="ymd" name="etb_from">~&nbsp;<!--
                        --><input type="text" style="width:80px;" class="input1" value="" dataformat="ymd" name="etb_to"><!--
                        --><button type="button" class="calendar ir" name="btn_duration" id="btn_duration"></button>
                    </td>
                    <th class="sm">Special</th>
                    <td class="sm">
                        <input type="checkbox" value="Y" class="trans" name="rc_flg" id="rc_flg"><label for="rc_flg">RF</label><!--
                        --><input type="checkbox" value="Y" class="trans" name="dcgo_flg" id="dcgo_flg"><label for="dcgo_flg">DG</label><!--
                        --><input type="checkbox" value="Y" class="trans" name="awk_cgo_flg" id="awk_cgo_flg"><label for="awk_cgo_flg">AK</label><!--
                        --><input type="checkbox" value="Y" class="trans" name="rd_cgo_flg" id="rd_cgo_flg"><label for="rd_cgo_flg">RD</label>
                    </td>
                </tr>
                <tr>
                    <th title="Port of Loading">POL</th>
                    <td><input type="text" style="width:80px;" class="input" name="pol_cd" maxlength="5" dataformat="engup"></td>
                    <th>Next Port</th>
                    <td><input type="text" style="width:80px;" class="input" name="next_port" maxlength="7" dataformat="engup"></td>
                    <th title="Port of Discharging">POD</th>
                    <td><input type="text" style="width:80px"  class="input" name="pod_cd" maxlength="5" dataformat="engup"></td>
                    <th>Next VVD</th>
                    <td><input type="text" style="width:80px" class="input" name="next_vvd" maxlength="9" dataformat="engup"></td>
                    <th class="sm">Option</th>
                    <td class="sm">
                        <input type="radio" value="All" class="trans" checked name="next_vvd_select" id="next_vvd_select1"><label for="next_vvd_select1">All</label><!--
                        --><input type="radio" value="Assigned" class="trans" name="next_vvd_select" id="next_vvd_select2"><label for="next_vvd_select2">Assigned</label><!--
                        --><input type="radio" value="Not Assigned" class="trans" name="next_vvd_select" id="next_vvd_select3"><label for="next_vvd_select3">Not Assigned</label>
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
    <!-- layout_wrap(S) -->
    <div class="layout_wrap">
        <!-- layout_vertical_2(S) -->
        <div class="layout_vertical_2 pad_rgt_8" style="width:40%">
            <!-- opus_design_grid(S) -->
            <div class="opus_design_grid">
                <h3 class="title_design">Former VVD</h3>
            </div>
            <div class="opus_design_grid">
                <script language="javascript">ComSheetObject('sheet1');</script>
            </div>
            <!-- opus_design_grid(E) -->
        </div>
        <!-- layout_vertical_2(E) -->
        
        <!-- layout_vertical_2(S) -->
        <div class="layout_vertical_2" style="width:60%">
            <!-- opus_design_grid(S) -->
            <div class="opus_design_grid">
                <h3 class="title_design">NEXT VVD SELECTION</h3>
            </div>
            <div class="opus_design_grid">
                <script language="javascript">ComSheetObject('sheet2');</script>
            </div>
            <!-- opus_design_grid(E) -->
        </div>
        <!-- layout_vertical_2(E) -->
    </div>
    <!-- layout_wrap(E) -->
    
    <!-- opus_tab_btn(S) -->
    <div class="opus_design_tab">
        <script language="javascript">ComTabObject('tab1')</script>
    </div>
    <!-- opus_tab_btn(E) -->

    <!--TAB File1 (S) -->
    <div id="tabLayer" style="display:inline">
        <div class="opus_design_grid"  id="receivedTabSCTariffLayer" style="display:block">
            <!-- opus_design_inquiry(S) -->
            <div class="opus_design_inquiry wFit">
                <table>
                    <colgroup>
                        <col width="200" />
                        <col width="200" />
                        <col width="" />
                    </colgroup> 
                    <tbody>
                        <tr>
                            <td>
                                <input type="text" style="width:150px;" class="input2" name="vsl_nm" readOnly>
                            </td>
                            <td>
                                <input type="text" style="width:50px;text-align:center;" class="input2" value="ETA" readOnly><!--
                                --><input type="text" style="width:90px;text-align:center;" class="input2" name="eta" readOnly>
                            </td>
                            <td>
                                <input type="text" style="width:50px;text-align:center;" class="input2" value="ETD" readOnly><!--
                                --><input type="text" style="width:90px;text-align:center;" class="input2" name="etd" readOnly>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <!-- opus_design_inquiry(E) -->
                   
            <script language="javascript">ComSheetObject('t1sheet1');</script>
            
            <!-- opus_design_inquiry(S) -->
            <div class="opus_design_inquiry wFit">
                <table style="margin-top:8px !important;">
                    <colgroup>
                        <col width="110" />
                        <col width="" />
                    </colgroup> 
                    <tbody>
                        <tr>
                            <th>Total</th>
                            <td>
                                <input type="text" style="width:30px;text-align:center;" class="input2" name="t20" readOnly value="20'"><!--
                                --><input type="text" style="width:88px;text-align:right;" class="input2" name="total20" readOnly><!--
                                --><input type="text" style="width:30px;text-align:center;" class="input2" name="t40" readOnly value="40'"><!--
                                --><input type="text" style="width:98px;text-align:right;" class="input2" name="total40" readOnly>
                            </td>
                        </tr>
                        <tr>
                            <th>Selected Volume</th>
                            <td>
                                <input type="text" style="width:30px;text-align:center;" class="input2" name="s20" readOnly value="20'"><!--
                                --><input type="text" style="width:88px;text-align:right;" class="input2"  name="selVVD20" readOnly><!--
                                --><input type="text" style="width:30px;text-align:center;" class="input2" name="s40" readOnly value="40'"><!--
                                --><input type="text" style="width:98px;text-align:right;" class="input2"  name="selVVD40" readOnly>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <!-- opus_design_inquiry(E) -->
        </div>
        <!-- opus_design_grid(E) -->
    </div>
    <!--TAB File1 (E) --> 

    <!--TAB File2 (S) -->
    <div id="tabLayer" style="display:none">
        <!-- opus_design_grid(S) -->
        <div class="opus_design_grid"  id="sentTabSCTariffLayer" style="display:block">

            <script language="javascript">ComSheetObject('t2sheet1');</script><!--W/O Issue-->
            
            <!-- opus_design_inquiry(S) -->
            <div class="opus_design_inquiry wFit">
                <table style="margin-top:8px !important;"> 
                    <colgroup>
                        <col width="110" />
                        <col width="" />
                    </colgroup> 
                    <tbody>
                    <tr>
                        <th>Selected Volume</th>
                        <td>
                            <input type="text" style="width:88px;text-align:right;" class="input2" name="selBKG20" readOnly><!--
                            --><input type="text" style="width:98px;text-align:right;" class="input2" name="selBKG40" readOnly>
                        </td>
                    </tr>
                </table>
            </div>
            <!-- opus_design_inquiry(E) -->
        </div>
        <!-- opus_design_grid(E) -->
    </div>
    <!--TAB File2 (E) --> 

    <!-- opus_design_grid(S) -->
    <div class="opus_design_grid"  id="mainTable3" border=2>
        <script language="javascript">ComSheetObject('sheet3');</script>
    </div>
    <!-- opus_design_grid(E) -->
</div>
<!-- wrap_result(E) -->
    
</form>
