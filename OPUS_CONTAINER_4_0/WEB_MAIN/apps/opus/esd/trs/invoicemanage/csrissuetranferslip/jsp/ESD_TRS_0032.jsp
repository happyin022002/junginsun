<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0032.jsp
*@FileTitle  : Transportation Invoice CSR Creation - Detail
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/29
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.event.EsdTrs0032Event"%>
<%@ page import="com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.basic.CSRIssueTransferSlipManageBCImpl"%>
<%
    EsdTrs0032Event  event      = null;
    Exception serverException   = null;
    String strErrMsg            = "";

    String userId  = "";
    String ofc_cd  = "";
    String usr_eml = "";
    String usr_nm  = "";
    String cnt_cd  = "";

    String inv_cfm_dt       = "";
    String vndr_seq         = "";
    String vndr_seq_name    = "";
    String curr_cd          = "";
    String asanogb          = "";
    String paymenttype      = null;
    String gen_pay_term_cd  = "";
    String pay_term_tp_cd   = "";

    String payment_due_dt   = "";
    String inv_ofc_cd       = null;
    String cost_ofc_cd      = "";
    String inv_sub_sys_cd   = "";   
    String conti_cd = "";

    inv_cfm_dt              = JSPUtil.getParameter(request, "form_inv_cfm_dt    ".trim(), "");
    vndr_seq                = JSPUtil.getParameter(request, "vndr_seq           ".trim(), "");
    vndr_seq_name           = JSPUtil.getParameter(request, "vndr_seq_name      ".trim(), "");
    curr_cd                 = JSPUtil.getParameter(request, "curr_cd            ".trim(), "");
    asanogb                 = JSPUtil.getParameter(request, "asanogb            ".trim(), "");
    paymenttype             = JSPUtil.getParameter(request, "paymenttype        ".trim(), "");
    gen_pay_term_cd         = JSPUtil.getParameter(request, "gen_pay_term_cd    ".trim(), "");
    pay_term_tp_cd          = JSPUtil.getParameter(request, "pay_term_tp_cd     ".trim(), "");
    payment_due_dt          = JSPUtil.getParameter(request, "payment_due_dt     ".trim(), "");
    ofc_cd                  = JSPUtil.getParameter(request, "cost_office_cd     ".trim(), "");
    conti_cd                = JSPUtil.getParameter(request, "conti_cd           ".trim(), "");
    cost_ofc_cd             = JSPUtil.getParameter(request, "cost_ofc_cd        ".trim(), "");
    
    inv_sub_sys_cd      = JSPUtil.getParameter(request, "inv_sub_sys_cd         ".trim(), "");  

    try {

       SignOnUserAccount account    = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
       userId                       = account.getUsr_id();
       usr_nm                       = account.getUsr_nm();
       usr_eml                      = account.getUsr_eml();
       cnt_cd                       = account.getCnt_cd();
     
       inv_ofc_cd                   = account.getOfc_cd();

       CSRIssueTransferSlipManageBCImpl csrBC = new CSRIssueTransferSlipManageBCImpl();
       cnt_cd                       = csrBC.searchOfficeChangedCntCd(ofc_cd);
       
        event                       = (EsdTrs0032Event)request.getAttribute("Event");
        serverException             = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
    }catch(Exception e) {
        out.println(e.toString());
    }
%>

<script language="javascript" src="/opuscntr/rpt/script/common_rd.js"></script>
<script language="javascript">
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        loadPage();
    }
    var cnt_cd = "<%=cnt_cd%>";
</script>

<form method="post" name="form" onSubmit="return false;">
<input  type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="cnt_cd"      value="<%=cnt_cd%>"     >
<input type="hidden" name="asanogb"     value="<%=asanogb%>"    >
<input type="hidden" name="paymenttype" value="<%=paymenttype%>">
<input type="hidden" name="csr_amt">
<input type='hidden' name='pgmNo' value='ESD_TRS_0032'>     
<input type="hidden" name="ap_ofc_cd" >
<input type="hidden" name="usr_eml"     value="<%=usr_eml%>"    >
<input type="hidden" name="usr_nm"      value="<%=usr_nm%>"     >
<input type="hidden" name="cre_usr_id"  value="<%=userId%>"     >
<input type="hidden" name="conti_cd"    value="<%=conti_cd%>"   >
<input type="hidden" name="csr_tp_cd">
<input type="hidden" name="evi_gb">

<input type="hidden" name="tax_naid_flg">
<input type="hidden" name="finance_flg">
<input type="hidden" name="fa_flg">
<input type="hidden" name="tax_type">
<input type="hidden" name="tax_nsl_flg">

<input type="hidden" name="evi_inv_dt">
<input type="hidden" name="evi_comp_no">
<input type="hidden" name="evi_total_net_amt">
<input type="hidden" name="evi_tax_no2">
<input type="hidden" name="evi_total_tax_amt">
<input type="hidden" name="evi_ctnt1">
<input type="hidden" name="evi_ctnt2">
<input type="hidden" name="evi_ctnt3">
<input type="hidden" name="evi_ctnt4">
<input type="hidden" name="evi_ctnt5">
<input type="hidden" name="evi_ctnt6">
<input type="hidden" name="evi_ctnt7">
<input type="hidden" name="evi_ctnt8">
<input type="hidden" name="evi_ctnt9">
<input type="hidden" name="evi_ctnt10">
<input type="hidden" name="evi_ctnt11">
<input type="hidden" name="evi_ctnt12">
<input type="hidden" name="evi_tax_no">
<input type="hidden" name="evi_tax_code">
<input type="hidden" name="eviInputFlg">
<input type="hidden" name="gen_pay_term_cd"  value="<%=gen_pay_term_cd%>">
<input type="hidden" name="pay_term_tp_cd"  value="<%=pay_term_tp_cd%>">
<input type="hidden" name="payment_due_dt"  value="<%=payment_due_dt%>">
<input type="hidden" name="cfm_dt" value="<%=inv_cfm_dt%>">
<input type="hidden" name="asa_no">
<input type="hidden" name="inv_ofc_cd" value="<%=inv_ofc_cd%>">
<input type="hidden" name="wo_vndr_seq">
<input type="hidden" name="type" value="">
<input type="hidden" name="r_inv_no">
<input type="hidden" name="r_inv_vndr_seq">
<input type="hidden"    name="aproSeqKey" value="<%=com.clt.bizcommon.approval.util.ApprovalUtil.getApprovalRoute1(cost_ofc_cd, inv_sub_sys_cd) %>">

<!-- layer_popup_title(S) -->
<div class="layer_popup_title">
    <!-- page_title_area(S) -->
    <div class="page_title_area clear">
        <!-- page_title(S) -->
        <h2 class="page_title">
            <span>CSR Creation (Detail)</span>
        </h2>
        <!-- page_title(E) -->
    
        <!-- page_location(S) -->
        <div class="location">
            <span id="navigation"></span>
        </div>
        <!-- page_location(E) -->
    </div>
<!-- page_title_area(E) -->
</div>
<!-- layer_popup_title(E) -->

<!-- popup_contens_area(S) -->
<div class="layer_popup_contents">
	<div class="wrap_search">
	    <!-- opus_design_inquiry(S) -->
	    <div class="opus_design_inquiry">
	        <!--  biz_1 (S) -->
	        <table>
	            <tbody>
	                <tr>
	                    <th width="40">Cost Office</th>
	                    <td width="80"><input name="cost_ofc_cd" type="text" style="width:60px;" value="<%=ofc_cd%>"></td>
	                    <th width="40">Payment Service Provider</th>
	                    <td><input name="vndr_seq" type="text" style="width:220px;" value="<%=vndr_seq%>"><!--<img class="cursor" src="/clt/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
	                    --><input name="vndr_seq_name" type="text" style="width:380px" value="<%=vndr_seq_name%>"></td>
	                </tr>
	            </tbody>
	        </table>
	        <!--  biz_1   (E) -->   
	    </div>
	    <!-- opus_design_inquiry(E) -->
    </div>
    
    <div class="wrap_result">
	    <!-- opus_design_grid(S) -->
	    <div class="opus_design_grid" >
	        <!-- opus_grid_btn(S) -->
	        <div class="opus_design_btn"  id="btLayer" style="display:none">
	            <button type="button" class="btn_normal" name="btng_preview" id="btng_preview">Preview</button>
	            <button type="button" class="btn_normal" name="btng_print" id="btng_print">Print</button>
	            <button type="button" class="btn_normal" name="btng_approvalrequest" id="btng_approvalrequest">Approval Request</button>
	            <button type="button" class="btn_normal" name="btng_downexcel1" id="btng_downexcel1">Down Excel</button>
	        </div>
	        <!-- opus_grid_btn(E) -->
	        <script language="javascript">ComSheetObject('sheet1');</script>
	        <div style="display:none">
	            <script language="javascript">ComSheetObject('sheet2');</script>
	            <script language="javascript">ComSheetObject('sheet3');</script>
	        </div>
	    </div>
    <!-- opus_design_grid(E) -->

    <!-- opus_design_inquiry(S) -->
    <div class="opus_design_inquiry">
        <!--  biz_2 (S) -->
        <table class="mar_left_8 bg" style="width:995px;">
            <colgroup>
                <col width="90" />
                <col width="113" />
                <col width="104" />
                <col width="113" />
                <col width="90"  />
                <col width="133" />
                <col width="120" />
                <col width=""/>
            </colgroup>
            <tbody>
                <tr>
                    <th>No. Of Invoice</th>
                    <td><input name="cnt_inv" type="text" style="width:90px;" value=""></td>
                    <th>Invoice Currency</th>
                    <td><input name="curr_cd" type="text" style="width:90px;" value="<%=curr_cd%>"></td>
                    <th>Total Amount</th>
                    <td><input name="total_amt" type="text" style="width:110px;" value=""></td>
                    <td colspan="2">
                        <div id="srLayer" style="display:none">
                            <table>
                                <colgroup>
                                    <col width="120" />
                                    <col width=""/>
                                </colgroup>
                                <tbody>
                                    <tr>
                                        <th>ASA No.</th>
                                        <td>
                                            <script language="javascript">ComComboObject('asa_no_1', 1, 130, 0)</script>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </td>
                </tr>
                <tr>
                    <th>Issue Date</th>
                    <td><input name="max_iss_dt" type="text" style="width:90px;" value="" ></td>
                    <th>Receive Date</th>
                    <td><input name="max_rcv_dt" type="text" style="width:90px;" value="" ></td>
                    <th>Payment Term</th>
                    <td><input name="gen_pay_term_view" type="text" style="width:110px;" value=""></td>
                    <th>Payment Due Date</th>
                    <td><input name="payment_due_dt_view" type="text" style="width:93px;" maxlength="10" value="" ></td>
                </tr>
                <tr style="display: none;">
                    <th>Approval Step</th>
                    <td colspan="7"><input name="apro_step" type="hidden" style="width:866px;" value="<%=com.clt.bizcommon.approval.util.ApprovalUtil.getApprovalRoute(ofc_cd, "TRS") %>">
                    <button type="button" class="input_seach_btn" name="btns_search" id="btns_search"></button>
                </tr>
                <tr>
                    <th>CSR No.</th>
                    <td colspan="7"><input name="csr_no" type="text" style="width:767Px;" value=""></td>
                </tr>
            </tbody>
        </table>
        <!--  biz_2   (E) -->   
    </div>
    <!-- opus_design_inquiry(E) -->
    </div>
</div>
<!-- popup_contens_area(E) -->
</form>
