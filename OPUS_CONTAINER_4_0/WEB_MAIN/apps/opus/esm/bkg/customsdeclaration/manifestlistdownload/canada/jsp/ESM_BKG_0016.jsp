<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0016.jsp
*@FileTitle  : ACI_Vessel Information
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/09
=========================================================
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.event.EsmBkg0016Event"%>
<%@ page import="org.apache.log4j.Logger"%>
<%
    EsmBkg0016Event event = null; //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
    String strErrMsg = "";                      //error message
    int rowCount     = 0;                       //count of DB resultSET list

    String successFlag = "";
    String codeList = "";
    String pageRows = "100";

    String strUsr_id = "";
    String strUsr_nm = "";
    Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");

    try
    {
        SignOnUserAccount account = (SignOnUserAccount) session
                .getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();

        event = (EsmBkg0016Event) request.getAttribute("Event");
        serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null)
        {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // If you imported data from the server initialization when loading
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

    }
    catch (Exception e)
    {
        out.println(e.toString());
    }
    String office = "CA";
    if (!"ESM_BKG_0016".equals(request.getParameter("pgmNo")))
    {
        office = "Origin";
    }
%>
<!-- [26/5/2014] @Dung.Nguyen: -->
<!-- Content: Change " 'language="javascript' " to "type=" 'text/javascript' " -->
<script type="text/javascript">
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            showErrMessage(errMessage);
        } // end if
        loadPage();
    }
</script>

<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows"> 
<input type="hidden" name="office" value="<%=office%>"> 

<!-- page_title_area(S) -->
    <div class="page_title_area clear">
        
        <!-- page_title(S) -->
        <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
        <h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
        <!-- page_title(E) -->
             
                    
                    
        <!-- opus_design_btn(S) -->
        <div class="opus_design_btn">
            <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
            <button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--  
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
    <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
    <table>
        <colgroup>
            <col width="80px" />
            <col width="90px" />
            <col width="" />
        </colgroup>
        <tbody>
            <tr class="h23">
                <th>Vessel Code</th>
                <td>
                    <input type="text" style="width: 50px; ime-mode: disabled" class="input1" required minLength="4" maxLength="4" dataformat="engup" name="frm_vsl_cd" caption="Vessel Code">
                </td>

                <td></td>
            </tr>
        </tbody>
    </table>
</div>
</div>
<!-- opus_design_inquiry(E) -->

<div class="wrap_result">
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry wFit">
    <table class="grid2">
        <colgroup>
            <col width="117px" />
            <col width="130px" />
            <col width="120px" />
            <col width="130px" />
            <col width="110px" />
            <col width="" />
        </colgroup>
        <tbody>
            <tr>
                <th style="text-align: center;">Lloyd No.</th>
                <td>
                    <input type="text" style="width: 100%; text-align: center" class="noinput2" readOnly="true" name="frm_lloyd_no">
                </td>
                <th style="text-align: center;">Country</th>
                <td><input type="text" style="width: 100%; text-align: center" class="noinput2" readOnly="true" name="frm_vsl_rgst_cnt_cd"></td>
                <th style="text-align: center;">Name</th>
                <td><input type="text" style="width: 100%; text-align: center" class="noinput2" readOnly="true" name="frm_vsl_eng_nm"></td>
            </tr>
        </tbody>
    </table>
    
    <table class="grid2">
        <colgroup>
            <col width="117px" />
            <col width="130px" />
            <col width="120px" />
            <col width="130px" />
            <col width="110px" />
            <col width="" />
        </colgroup>
        <tbody>
            <tr>
                <th style="text-align: center;">Registry Port</th>
                <td><input type="text" style="width: 100%; text-align: center" class="noinput2" readOnly="true" name="frm_rgst_port_cd"></td>
                <th style="text-align: center;">Registry Official No.</th>
                <td><input type="text" style="width: 100%;text-align:center" class="noinput2" readOnly="true" name="frm_rgst_no"></td>
                <th style="text-align: center;">Registry Date</th>
                <td><input type="text" style="width: 100%; text-align: center" class="noinput2" readOnly="true" name="frm_rgst_dt"></td>
            </tr>
            <tr>
                <th style="text-align: center;">Gross Weight</th>
                <td><input type="text" style="width: 100%; text-align: right" class="noinput2" readOnly="true" name="frm_grs_rgst_tong_wgt"></td>
                <th style="text-align: center;">Net Weight</th>
                <td><input type="text" style="width: 100%; text-align: right" class="noinput2" readOnly="true" name="frm_net_rgst_tong_wgt"></td>
                <th style="text-align: center;">Dead Weight</th>
                <td><input type="text" style="width: 100%; text-align: right" class="noinput2" readOnly="true" name="frm_dwt_wgt"></td>
            </tr>
            <tr>
                <th style="text-align: center;">Crew</th>
                <td><input type="text" style="width: 100%; text-align: right" class="noinput2" readOnly="true" name="frm_crw_knt"></td>
                <th style="text-align: center;">Call Sign</th>
                <td><input type="text" style="width: 100%; text-align: center" class="noinput2" readOnly="true" name="frm_call_sgn_no"></td>
                <th style="text-align: center;">L.O.A.</th>
                <td><input type="text" style="width: 100%; text-align: right" class="noinput2" readOnly="true" name="frm_loa_len"></td>
            </tr>
        </tbody>
    </table>
</div>
<!-- opus_design_inquiry(E) -->

<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry wFit">
    <table class="grid2">
        <colgroup>
            <col width="117px" />
            <col width="130px" />
            <col width="120px" />
            <col width="130px" />
            <col width="110px" />
            <col width="" />
        </colgroup>
        <tbody>
            <tr>
                <th style="text-align: center;">Safety Construction</th>
                <td><input type="text" style="width: 100%; text-align: center; ime-mode: disabled; border-top-color:#7f9db9; border-right-color:#7f9db9; border-bottom-color:#7f9db9; border-left-color:#7f9db9;" class="noinput" name="frm_vsl_sft_cstru_certi_exp_dt" dataformat="ymd" caption="Safety Construction" maxlength="10"></td>
                <th style="text-align: center;">Safety Radio</th>
                <td><input type="text" style="width: 100%; text-align: center; ime-mode: disabled; border-top-color:#7f9db9; border-right-color:#7f9db9; border-bottom-color:#7f9db9; border-left-color:#7f9db9;" class="noinput" name="frm_vsl_sft_rdo_certi_exp_dt" dataformat="ymd" caption="Safety Radio" maxlength="10"></td>
                <th style="text-align: center;">Safety Equipment</th>
                <td><input type="text" style="width: 100%; text-align: center; ime-mode: disabled; border-top-color:#7f9db9; border-right-color:#7f9db9; border-bottom-color:#7f9db9; border-left-color:#7f9db9;" maxlength="10" class="noinput" name="frm_vsl_sft_eq_certi_exp_dt" dataformat="ymd" caption="Safety Equipment"></td>
            </tr>
            <tr>
                <th style="text-align: center;">Loadline</th>
                <td><input type="text" style="width: 100%; text-align: center; ime-mode: disabled;border-top-color:#7f9db9; border-right-color:#7f9db9; border-bottom-color:#7f9db9; border-left-color:#7f9db9;" class="noinput" maxlength="10" name="frm_vsl_lod_line_certi_exp_dt" dataformat="ymd" caption="Loadline"></td>
                <th style="text-align: center;">Derat</th>
                <td><input type="text" style="width: 100%; text-align: center; ime-mode: disabled;border-top-color:#7f9db9; border-right-color:#7f9db9; border-bottom-color:#7f9db9; border-left-color:#7f9db9;" maxlength="10" class="noinput" name="frm_vsl_derat_certi_exp_dt" dataformat="ymd" caption="Derat"></td>
                <th style="text-align: center;">Carrier Code</th>
                <td><input type="text" style="width: 100%; text-align: center" class="noinput2" readOnly="true" name="frm_crr_cd"></td>
            </tr>
        </tbody>
    </table>
</div>
<!-- opus_design_inquiry(E) -->
</div>
<!-- opus_design_grid(S) -->
<div class="opus_design_grid">
    <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
    <!-- [26/5/2014] @Dung.Nguyen: -->
	<!-- Content: Change " 'language="javascript' " to "type=" 'text/javascript' " -->
    <script type="text/javascript">ComSheetObject('sheet1');</script>
    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
</div>
<!-- opus_design_grid(E) -->

</form>