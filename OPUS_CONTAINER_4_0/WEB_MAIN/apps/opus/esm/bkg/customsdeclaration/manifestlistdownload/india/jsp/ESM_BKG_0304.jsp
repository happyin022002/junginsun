<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0304.jsp
*@FileTitle  : Vessel Information & IGM No. Set-Up
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/01
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.india.event.EsmBkg0304Event"%>

<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmBkg0304Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
    String strErrMsg = "";                      //error message
    int rowCount     = 0;                       //count of DB resultSET list
    
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");

    
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
       
       
        event = (EsmBkg0304Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        
        // getting data from server when load the initial screen
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

<form name="form" id="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="f_cmd_detail">

    
<!-- page_title_area(S) -->
<div class="page_title_area clear ">
    <!-- page_title(S) -->
    <h2 class="page_title">
        <button type="button">
            <span id="title">Vessel Information & IGM No. Set-Up</span>
        </button>
    </h2>
    <!-- page_title(E) -->

    <!-- opus_design_btn(S) -->
    <div class="opus_design_btn">
        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
        <button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
        --><button type="button" class="btn_normal" name="btn_new"   id="btn_new">New</button><!--
        --><button type="button" class="btn_normal" name="btn_save"   id="btn_save">Save</button><!--
        --><button type="button" class="btn_normal" name="btn_delete"   id="btn_delete">Delete</button>
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
        <table>
             <colgroup>
                <col width="150" />
                <col width="200" />
                <col width="150" />
                <col width="" />
            </colgroup> 
            <tbody>
                <tr>
                    <th>VVD CODE</th>
                    <td>
                        <input type="text" style="width:80px;ime-mode: disabled" class="input1" name="form1_vvd_cd" id="form1_vvd_cd" required dataformat="engup" maxlength="9" fullfill caption="VVD CODE" ><!--
                        --><input type="hidden" style="width:80px;ime-mode: disabled" class="input1" name="vvd_cd" id="vvd_cd">
                    </td>
                    <th title="Port of Discharging">POD</th>
                    <td>
                        <input type="text" style="width:80px;ime-mode: disabled" class="input1" name="form1_pod_cd" id="form1_pod_cd" required dataformat="engup" maxlength="5" fullfill caption="POD" ><!--
                        --><input type="hidden" style="width:60px;ime-mode: disabled" class="input1" name="pod_cd" id="pod_cd">
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
    <!-- opus_design_inquiry(S) -->
    <div class="opus_design_inquiry ">
        <table>
             <colgroup>
                <col width="100" />
                <col width="200" />
                <col width="150" />
                <col width="" />
            </colgroup> 
            <tbody>
                <tr>
                    <th>IGM No.</th>
                    <td>
                        <input type="text" style="width:80px;ime-mode: disabled" class="input" name="form1_ida_decl_vsl_no" id="form1_ida_decl_vsl_no" dataformat="engup" maxlength="7"><!--
                        --><input type="text" style="width:25px;ime-mode:disabled;" class="input" name="form1_ida_yr_no" id="form1_ida_yr_no" dataformat="num" maxlength="2" caption="IGM YEAR">
                    </td>
                    <th>IGM Date</th>
                    <td><input type="text" style="width:80px; ime-mode: disabled" class="input" name="form1_vsl_decl_dt" id="form1_vsl_decl_dt" dataformat="ymd" caption="IGM Date" maxlength="10"></td>
                </tr>
                <tr>
                    <th>Vessel Name</th>
                    <td colspan="3">
                        <input type="text" style="width:430px;" class="input2" readOnly="true" name="form1_vsl_nm" id="form1_vsl_nm" maxlength="50">
                    </td>
                </tr>
                <tr>
                    <th>VSL Code(Call Sign)</th>
                    <td colspan="3">
                        <input type="text" style="width:430px;ime-mode: disabled" class="input1" name="form1_call_sgn_no" id="form1_call_sgn_no" dataformat="engup" maxlength="15" caption="VSL Code(Call Sign)">
                    </td>
                    
                </tr>
                <tr>
                    <th>Voyage</th>
                    <td><input type="text" style="width:80px;ime-mode: disabled" class="input1" name="form1_ida_voy_no" id="form1_ida_voy_no" dataformat="engup" maxlength="5" caption="Voyage"></td>
                    <th>Line Code</th>
                    <td><input type="text" style="width:80px;ime-mode: disabled" class="input" name="form1_ida_line_no" id="form1_ida_line_no" dataformat="engup" maxlength="5" caption="Line Code"></td>
                </tr>
                <tr>
                    <th>Agent Code</th>
                    <td><input type="text" style="width:80px;ime-mode: disabled" class="input1" name="form1_crr_agn_cd" id="form1_crr_agn_cd" dataformat="engup" maxlength="6" caption="Agent Code"></td>
                    <th>Nationality</th>
                    <td><input type="text" style="width:80px;ime-mode: disabled" class="input2" readOnly="true" name="form1_cnt_cd" id="form1_cnt_cd" maxlength="2"></td>
                </tr>
                <tr>
                    <th>Port of Arrival</th>
                    <td>
                        <input type="text" style="width:80px;ime-mode: disabled" class="input1" name="form1_port_cd" id="form1_port_cd" dataformat="engup" maxlength="10" caption="Port of Arrival"><!--
                        --><button type="button" class="input_seach_btn" name="btn_popup1" id="btn_popup1"></button>
                    </td>
                    <th>Arrival Date</th>
                    <td><input type="text" style="width:80px;ime-mode: disabled" class="input" name="form1_arr_dt" id="form1_arr_dt" dataformat="ymd" caption="Arrival Date" maxlength="10"></td>
                </tr>
                <tr>
                    <th>GLD</th>
                    <td><input type="text" style="width:80px;ime-mode: disabled" class="input" name="form1_arr_dt2" id="form1_arr_dt2" dataformat="ymd" caption="GLD" maxlength="10"></td>
                    <th>CFS Code</th>
                    <td>
                        <input type="text" style="width:80px;ime-mode: disabled" class="input1" name="form1_ida_cfs_id" id="form1_ida_cfs_id" dataformat="engup" maxlength="10" caption="CFS Code"><!--
                        --><button type="button" class="input_seach_btn" name="btn_popup2" id="btn_popup2"></button>
                    </td>
                </tr>
                <tr>
                    <td colspan="2"></td>
                    <th>Bond Code</th>
                    <td><input type="text" style="width:80px;ime-mode: disabled" class="input" name="form1_bd_area_cd" id="form1_bd_area_cd" dataformat="engup" caption="Bond Code"></td>
                </tr>
            </tbody>
        </table>
    </div>
    <!-- opus_design_inquiry(E) -->
<table><tr><td class="line_bluedot"></td></tr></table>
    <!-- opus_design_inquiry(S) -->
    <div class="opus_design_inquiry ">
        <h3 class="title_design">T/P Information</h3>
        <table> 
             <colgroup>
                <col width="120" />
                <col width="" />
            </colgroup> 
            <tbody>
                <tr>
                    <th>TP Bond No.</th>
                    <td><input type="text" style="width:160px" class="input" name="form1_ibd_no" id="form1_ibd_no" dataformat="engup" caption="TP Bond No." maxlength="9"></td>
                </tr> 
                <tr>    
                    <th>Trans Operator</th>
                    <td><input type="text" style="width:160px" class="input" name="form1_trns_opr_id" id="form1_trns_opr_id" dataformat="engup" caption="Trans Operator"  maxlength="10"></td>
                </tr> 
                <tr>    
                    <th>MLO Code</th>
                    <td><input type="text" style="width:160px" class="input" name="form1_ida_mrn_line_opr_cd" id="form1_ida_mrn_line_opr_cd" dataformat="engup" caption="MLO Code" maxlength="5"></td>
                </tr> 
            </tbody>
        </table>
    </div>
    <!-- opus_design_inquiry(E) -->
    
    <!-- opus_design_grid(S) -->
    <div class="opus_design_grid"  id="mainTable">
        <script language="javascript">ComSheetObject('sheet1');</script> 
    </div>
    <!-- opus_design_grid(E) -->
</div>
<!-- wrap_result(E) -->
</form>
