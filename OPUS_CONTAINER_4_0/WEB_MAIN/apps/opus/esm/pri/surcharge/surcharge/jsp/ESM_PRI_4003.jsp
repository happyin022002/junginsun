<%
/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESM_PRI_4003.jsp
 *@FileTitle  : Surcharge Creation
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/06/04
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.surcharge.surcharge.event.EsmPri4003Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="com.clt.framework.component.common.AbstractValueObject"%>
<%@ page import="java.util.List"%>

<%
    EsmPri4003Event  event = null;              //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
    String strErrMsg = ""; //error message
    int rowCount = 0; //count of DB resultSET list

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String[] svcScpCd = null; 
    String[] chgCd = null; 
    String[] pctBseCd = null;
    String[] scgImdgClssCd = null;
    String[] orgTrspModCd = null;
    String[] destTrspModCd = null;
    String[] usaSvcModCd = null;
    String[] prcRcvTermCd = null;
    String[] prcDeTermCd = null;
    String[] prcHngrBarTpCd = null;
    String[] payTermCd = null;
    String[] ratUtCd = null;
    String[] prcCgoTpCd = null;
    String[] currCd = null;
    String[] dirCallFlg = null;
    String[] socFlg = null;
    String[] ioGaCd = null;
    String[] subTrdCd = null;
    String[] cnlTzCd = null;
    String[] bkgEsvcTpCd = null;    	//B/I
    
    Logger log = Logger.getLogger("com.clt.apps.Surcharge.Surcharge");
    
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();


        event = (EsmPri4003Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

         
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        
        svcScpCd = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("svcScpCd"));
        chgCd = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("chgCd"));
        pctBseCd = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("pctBseCd"), false);
        scgImdgClssCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("scgImdgClssCd"),true,"|","\t","getCode","getName");
        orgTrspModCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("orgTrspModCd"), false,"|","\t","getCode","getName");
        destTrspModCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("destTrspModCd"), false,"|","\t","getCode","getName");
        usaSvcModCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("usaSvcModCd"), false,"|","\t","getCode","getName");
        prcRcvTermCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("prcRcvTermCd"), false,"|","\t","getCode","getName");
        prcDeTermCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("prcDeTermCd"), false,"|","\t","getCode","getName");
        prcHngrBarTpCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("prcHngrBarTpCd"), false,"|","\t","getCode","getName");
        payTermCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("payTermCd"), false,"|","\t","getCode","getName");
        ratUtCd = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("ratUtCd"),false,"|","\t");
        prcCgoTpCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("prcCgoTpCd"), true,"|","\t","getCode","getName");
        currCd = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("currCd"), false,"|","\t");
        dirCallFlg = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("dirCallFlg"), false,"|","\t","getCode","getName");
        socFlg = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("socFlg"), false,"|","\t","getCode","getName");
        ioGaCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("ioGaCd"), false,"|","\t","getCode","getName");
        subTrdCd = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("subTrdCd"), true,"|","\t");
        cnlTzCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("cnlTzCd"), false,"|","\t","getCode","getName");
        bkgEsvcTpCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("BKG_ESVC_TP_CD"), false,"|","\t","getCode","getName");
    
    }catch(Exception e) {
        out.println(e.toString());
    }
%>

<script type="text/javascript">
    var svcScpComboValue = " |<%=svcScpCd[0]%>";  
    var svcScpComboText = " |<%=svcScpCd[1]%>";
    var chgCdComboValue = " |<%=chgCd[0]%>";
    var chgCdComboText = " |<%=chgCd[1]%>";
    var pctBseCdComboValue = " |<%=pctBseCd[0]%>"; 
    var pctBseCdComboText = " |<%=pctBseCd[1]%>";
    var scgImdgClssCdComboValue = " |<%=scgImdgClssCd[0]%>";
    var scgImdgClssCdComboText = " |<%=scgImdgClssCd[1]%>";
    var orgTrspModCdValue = " |<%=orgTrspModCd[0]%>";
    var orgTrspModCdText = " |<%=orgTrspModCd[1]%>";
    var destTrspModCdValue = " |<%=destTrspModCd[0]%>";
    var destTrspModCdText = " |<%=destTrspModCd[1]%>";
    var usaSvcModCdValue = " |<%=usaSvcModCd[0]%>";
    var usaSvcModCdText = " |<%=usaSvcModCd[1]%>";
    var prcRcvTermCdValue = " |<%=prcRcvTermCd[0]%>";
    var prcRcvTermCdText = " |<%=prcRcvTermCd[1]%>";
    var prcDeTermCdValue = " |<%=prcDeTermCd[0]%>";
    var prcDeTermCdText = " |<%=prcDeTermCd[1]%>";
    var prcHngrBarTpCdValue = " |<%=prcHngrBarTpCd[0]%>";
    var prcHngrBarTpCdText = " |<%=prcHngrBarTpCd[1]%>";
    var payTermCdValue = " |<%=payTermCd[0]%>";
    var payTermCdText = " |<%=payTermCd[1]%>";
    var ratUtCdValue = " |<%=ratUtCd[0]%>";
    var ratUtCdText = " |<%=ratUtCd[1]%>";
    var prcCgoTpCdValue = " |<%=prcCgoTpCd[0]%>";
    var prcCgoTpCdText = " |<%=prcCgoTpCd[1]%>";
    var scgImdgClssCdValue = " |<%=scgImdgClssCd[0]%>";
    var scgImdgClssCdText = " |<%=scgImdgClssCd[1]%>";
    var currCdValue = " |<%=currCd[0]%>";
    var currCdText = " |<%=currCd[1]%>";
    var dirCallFlgValue = " |<%=dirCallFlg[0]%>";
    var dirCallFlgText = " |<%=dirCallFlg[1]%>";
    var socFlgValue = " |<%=socFlg[0]%>";
    var socFlgText = " |<%=socFlg[1]%>";
    var ioGaCdValue = " |<%=ioGaCd[0]%>";
    var ioGaCdText = " |<%=ioGaCd[1]%>";
    var subTrdCdValue = " |<%=subTrdCd[0]%>";
    var subTrdCdText = " |<%=subTrdCd[1]%>";
    var cnlTzCdValue = " |<%=cnlTzCd[0]%>";
    var cnlTzCdText = " |<%=cnlTzCd[1]%>";
    var bkgEsvcTpCdComboValue = " |<%=bkgEsvcTpCd[0]%>";   
    var bkgEsvcTpCdComboText = " |<%=bkgEsvcTpCd[1]%>";
    
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        loadPage();
    }
</script>

<form name="form">
<input type="hidden" name="f_cmd"       id="f_cmd">
<input type="hidden" name="pagerows"    id="pagerows">
 
<input type="hidden" name="cd" id="cd" >

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
    <h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
    <!-- page_title(E) -->
    <!-- opus_design_btn(S) -->
    <div class="opus_design_btn">
         <button type="button" class="btn_accent" name="btn_retrieve"    id="btn_retrieve">Retrieve</button>
         <button type="button" class="btn_normal" name="btn_new"         id="btn_new">New</button> 
         <button type="button" class="btn_normal" name="btn_delete1"     id="btn_delete1">Delete</button> 
         <button type="button" class="btn_normal" name="btn_save"        id="btn_save">Save</button> 
    </div>
    <!-- opus_design_btn(E) -->

    <!-- page_location(S) -->
    <div class="location">
        <!-- location 내용 동적생성 (별도 코딩 불필요) -->
        <span id="navigation"></span>
    </div>
</div>
<!-- page_title_area(E) -->
<div class= "wrap_search">
<!-- opus_design_inquiry(S) -->
<div class= "opus_design_inquiry wFit">
    <h3 style="margin-bottom:0" class="title_design">Charge Attribute</h3>
    <table>
        <tbody>
            <colgroup>
                <col width="60">
                <col width="293">
                <col width="50">
                <col width="284">
                <col width="80">
                <col width="80">
                <col width="*">
            </colgroup>
            <tr>
                <th>Service Scope</th>
                <td><script type="text/javascript">ComComboObject('svc_scp_cd', 2, 60, 0, 1, 0, false);</script><input name="svc_scp_nm" id="svc_scp_nm" type="text" style="width:203px;" class="input2" value="" readonly caption="Service Scope"></td>
                <th>Charge</th> 
                <td><script type="text/javascript">ComComboObject('chg_cd', 2, 60, 0, 1, 0, false);</script><input name="chg_nm" id="chg_nm" type="text" style="width:177px;" class="input2" value="" readonly caption="Charge"></td>
                <th>Update Date</th> 
                <td><input name="upd_dt" id="upd_dt" type="text" style="width:75px;" class="input2" readonly caption="Update Date"></td>
                <td></td>
            </tr>
        </tbody>
    </table>
    <table>
        <tbody>
            <colgroup>
                <col width="100">
                <col width="20">
                <col width="230">
                <col width="31">
                <col width="330">
                <col width="80">
                <col width="50">
                <col width="*">
            </colgroup>
            <tr>
                <th class="sm">Application Type</th>
                <td class="sm"></td>
                <td class="sm">
                    <input type="radio" name="flt_pct_tp_cd" id="flt_pct_tp_cd" value="F" class="trans" checked><label for ="flt_pct_tp_cd">Fixed Amount</label>
                    <input type="radio" name="flt_pct_tp_cd" id="flt_pct_tp_cd1" value="P" class="trans"><label for ="flt_pct_tp_cd1">Percentage %</label>
                </td>
                <td></td>
                <td><script type="text/javascript">ComComboObject('pct_bse_cd', 1, 285, 0, 1, 0, false);</script></td>
                <th>Location Group</th>
                <td><button type="button" class="input_seach_btn" name="btn_loc_grp_pop" id="btn_loc_grp_pop"></button></td>
                <td></td>
            </tr>
        </tbody>
    </table>
    <table>
        <tbody>
            <colgroup>
                <col width="150">
                <col width="*">
            </colgroup>
            <tr style="height:25px">
                <th>Application Items - Please check additional items and press "Save" button.</th>
                <td></td>
            </tr>
            <tr>
                <td></td>
                <td></td>
            </tr>
        </tbody>
    </table>
    <table>
        <tbody>
            <colgroup>
                <col width="10">
                <col width="80">
                <col width="50">
                <col width="80">
                <col width="70">
                <col width="90">
                <col width="100">
                <col width="80">
                <col width="100">
                <col width="120">
                <col width="50">
                <col width="10">
                <col width="*">
            </colgroup>
            <tr>
                <td class="sm"></td>
                <td class="sm"><input type="checkbox" name="por_use_flg"            id="por_use_flg" value="Y" class="trans" checked><label for ="por_use_flg">POR</label></td>
                <td class="sm"><input type="checkbox" name="pol_use_flg"            id="pol_use_flg" value="Y" class="trans" checked><label for ="por_use_flg">POL</label></td>
                <td class="sm"><input type="checkbox" name="pod_use_flg"            id="pod_use_flg" value="Y" class="trans" checked><label for ="por_use_flg">POD</label></td>
                <td class="sm"><input type="checkbox" name="del_use_flg"            id="del_use_flg" value="Y" class="trans" checked><label for ="por_use_flg">DEL</label></td>
                <td class="sm"><input type="checkbox" name="rcv_de_term_use_flg"    id="rcv_de_term_use_flg" value="Y" class="trans"><label for ="rcv_de_term_use_flg">R/D term</label></td>
                <td class="sm"><input type="checkbox" name="imdg_clss_use_flg"      id="imdg_clss_use_flg" value="Y" class="trans"><label for ="imdg_clss_use_flg">IMDG Class</label></td>
                <td class="sm"><input type="checkbox" name="cnl_tz_flg"             id="cnl_tz_flg" value="Y" class="trans"><label for ="cnl_tz_flg">Canal</label></td>
                <td class="sm"><input type="checkbox" name="cgo_wgt_use_flg"        id="cgo_wgt_use_flg" value="Y" class="trans"><label for ="cgo_wgt_use_flg">Cargo Weight</label></td>
                <td class="sm"><input type="checkbox" name="trns_mod_use_flg"       id="trns_mod_use_flg" value="Y" class="trans"><label for ="trns_mod_use_flg">Trans mode</label></td>
                <td class="sm"><input type="checkbox" name="hngr_bar_use_flg"       id="hngr_bar_use_flg" value="Y" class="trans"><label for ="hngr_bar_use_flg">Bar Type</label></td>
                <td class="sm"><input type="checkbox" name="esvc_use_flg"           id="esvc_use_flg" value="Y" class="trans"><label for ="esvc_use_flg">S/I</label></td>
                <td></td>
            </tr>
            <tr>
                <td class="sm"></td>
                <td class="sm"><input type="checkbox" name="sub_trd_use_flg"        id="sub_trd_use_flg" value="Y" class="trans"><label for ="sub_trd_use_flg">Sub-trade</label></td>
                <td class="sm"><input type="checkbox" name="slan_use_flg"           id="slan_use_flg" value="Y" class="trans"><label for ="slan_use_flg">Lane</label></td>
                <td class="sm"><input type="checkbox" name="dir_call_use_flg"       id="dir_call_use_flg" value="Y" class="trans"><label for ="dir_call_use_flg">Direct Call</label></td>
                <td class="sm"><input type="checkbox" name="tml_use_flg"            id="tml_use_flg" value="Y" class="trans"><label for ="tml_use_flg">Terminal</label></td>
                <td class="sm"><input type="checkbox" name="cmdt_use_flg"           id="cmdt_use_flg" value="Y" class="trans"><label for ="cmdt_use_flg">Commodity</label></td>
                <td class="sm"><input type="checkbox" name="io_ga_use_flg"          id="io_ga_use_flg" value="Y" class="trans"><label for ="io_ga_use_flg">In/Out Gauge</label></td>
                <td class="sm"><input type="checkbox" name="ts_port_use_flg"        id="ts_port_use_flg" value="Y" class="trans"><label for ="ts_port_use_flg">T/S PORT</label></td>
                <td class="sm"><input type="checkbox" name="soc_use_flg"            id="soc_use_flg" value="Y" class="trans"><label for ="soc_use_flg">S.O.C</label></td>
                <td class="sm"><input type="checkbox" name="gri_cmdt_use_flg"       id="gri_cmdt_use_flg" value="Y" class="trans"><label for ="gri_cmdt_use_flg">Commodity Group</label></td>
                <td class="sm"><input type="checkbox" name="usa_svc_mod_use_flg"    id="usa_svc_mod_use_flg" value="Y" class="trans"><label for ="usa_svc_mod_use_flg">US Service Mode</label></td>
                <td class="sm"></td>
                <td><button type="button" class="btn_etc" name="btn_select_all" id="btn_select_all">Select All</button></td>
            </tr>
        </tbody>
    </table>
    </div>
    <table class="line_bluedot">
    	<tr>
    		<td></td>
    	</tr>
    </table>
    <div class= "opus_design_inquiry wFit">
    <h3 style="margin-bottom:0" class="title_design">Search</h3>
    <table>
        <tbody>
            <colgroup>
                <col width="30">
                <col width="30">
                <col width="80">
                <col width="80">
                <col width="80">
                <col width="80">
                <col width="90">
                <col width="90">
                <col width="*">
            </colgroup>
            <tr>
                <th>Route</th>
                <td></td>
                <td>POR&nbsp;<input type="text" name="por_def_cd" id="por_def_cd" maxlength="5" dataformat="engup" style="ime-mode:disabled; width:50px;"></td>
                <td>POL&nbsp;<input type="text" name="pol_def_cd" id="pol_def_cd" maxlength="5" dataformat="engup" style="ime-mode:disabled; width:50px;"></td>
                <td>POD&nbsp;<input type="text" name="pod_def_cd" id="pod_def_cd" maxlength="5" dataformat="engup" style="ime-mode:disabled; width:50px;"></td>
                <td>DEL&nbsp;<input type="text" name="del_def_cd" id="del_def_cd" maxlength="5" dataformat="engup" style="ime-mode:disabled; width:50px;"></td>
                <th>Access Date</th>
                <td><input type="text" name="eff_dt" id="eff_dt" style="width:80px;" class="input" caption="Expire Date" maxlength="10" dataformat="ymd"><!-- 
                 --><button type="button" class="calendar" name="btns_calendar" id="btns_calendar"></button></td>
                <td></td>
            </tr>
        </tbody>
    </table>
    <table>
        <tbody>
            <colgroup>
                <col width="45">
                <col width="250">
                <col width="80">
                <col width="80">
                <col width="*">
            </colgroup>
            <tr>  
          		           
                <th class="sm">Cargo Type</th>
                <td class="sm"><input type="checkbox" name="prc_cgo_tp_cd_1" id="prc_cgo_tp_cd_1" value="DR" class="trans"><label for ="prc_cgo_tp_cd_1">DR</label><!-- 
                     --><input type="checkbox" name="prc_cgo_tp_cd_1" id="prc_cgo_tp_cd_1" value="RF" class="trans"><label for ="prc_cgo_tp_cd_1">RF</label><!-- 
                     --><input type="checkbox" name="prc_cgo_tp_cd_1" id="prc_cgo_tp_cd_1" value="DG" class="trans"><label for ="prc_cgo_tp_cd_1">DG</label><!-- 
                     --><input type="checkbox" name="prc_cgo_tp_cd_1" id="prc_cgo_tp_cd_1" value="AK" class="trans"><label for ="prc_cgo_tp_cd_1">AK</label><!-- 
                     --><input type="checkbox" name="prc_cgo_tp_cd_1" id="prc_cgo_tp_cd_1" value="BB" class="trans"><label for ="prc_cgo_tp_cd_1">BB</label>
                </td>
                <th>IMDG Class</th> 
                <td><script type="text/javascript">ComComboObject('scg_imdg_clss_cd', 2, 50, 0, 0, 0, false);</script></td>
                <td></td>
            </tr>
        </tbody>
    </table>
</div>
</div>
<!-- opus_design_inquiry(E) -->
<div class="wrap_result">
<!-- opus_design_grid(S) -->
<div class="opus_design_grid" style="display:none;" id="tempTable">
    <script type="text/javascript">ComSheetObject('sheet0');</script>
</div>
<div class="opus_design_grid" style="display:none;" id="tempTable">
    <script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
<div class="opus_design_grid">
<h3 style="margin-bottom:0" class="title_design">Entry</h3>
    <div class="opus_design_btn"> 
        <button type="button" class="btn_accent" name="btn_copy"        id="btn_copy">Row Copy</button><!-- 
         --><button type="button" class="btn_accent" name="btn_add"         id="btn_add">Row Add</button><!-- 
         --><button type="button" class="btn_accent" name="btn_delete2"     id="btn_delete2">Delete</button><!-- 
         --><button type="button" class="btn_accent" name="btn_downexcel"   id="btn_downexcel">Down Excel</button><!-- 
         --><button type="button" class="btn_accent" name="btn_loadexcel"   id="btn_loadexcel">Load Excel</button>  
    </div>
    <script type="text/javascript">ComSheetObject('sheet2');</script>
</div>
<div class="opus_design_grid" style="display:none;" id="tempTable">
    <script type="text/javascript">ComSheetObject('sheet3');</script>
</div>
<!-- opus_design_grid(S) -->
</div>
</form>