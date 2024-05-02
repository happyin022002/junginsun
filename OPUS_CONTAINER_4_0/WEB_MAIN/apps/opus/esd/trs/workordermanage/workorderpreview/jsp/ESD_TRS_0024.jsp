<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0024.jsp
*@FileTitle  : W/O Issue Preview
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/09
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.event.EsdTrs0024Event"%>
<%@ page import="java.util.StringTokenizer"%>

<%!
    private ArrayList splitStr(String src, String delim)
    {
        if(src == null || src.equals("")) return null;
        ArrayList returnV = new ArrayList();
        StringTokenizer st = new StringTokenizer(src, delim);
        String tempNo = null;
        while (st.hasMoreTokens()) {
            tempNo = st.nextToken();
            returnV.add(tempNo);
        }
        if (returnV.size() == 0) returnV.add(src);
        return returnV;
    }
%>

<%
    EsdTrs0024Event  event = null;  
    Exception serverException   = null;
    String strErrMsg = "";
    int rowCount     = 0; 
    SignOnUserAccount account = null;
    try {
        account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        event = (EsdTrs0024Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
    } catch(Exception e) {
        out.println(e.toString());
    }
    String today = DateTime.getFormatString("yyyyMMdd");
    String beforeOneMonth = DateTime.addMonths(today, -1);
        
    ArrayList trsp_so_ofc_cty_cd = splitStr(request.getParameter("trsp_so_ofc_cty_cd"),",");
    ArrayList trsp_so_seq = splitStr(request.getParameter("trsp_so_seq"),",");
    ArrayList wo_cancel_flag = splitStr(request.getParameter("wo_cancel_flag"),",");
    ArrayList dtn_use_flg = splitStr(request.getParameter("dtn_use_flg"),",");
    ArrayList wo_bl_no_iss_flg = splitStr(request.getParameter("wo_bl_no_iss_flg"),",");
    ArrayList vndr_seq = splitStr(request.getParameter("vndr_seq"),",");
    ArrayList curr_cd = splitStr(request.getParameter("po_local_curr_cd"),",");
    ArrayList bzc_amt = splitStr(request.getParameter("po_basic_rt"),",");
    ArrayList nego_amt = splitStr(request.getParameter("nego_amt"),",");
    ArrayList etc_add_amt = splitStr(request.getParameter("etc_add_amt"),",");
    ArrayList fuel_scg_amt = splitStr(request.getParameter("po_fuel_scg_rt"),",");
    ArrayList n3pty_bil_flg = splitStr(request.getParameter("n3pty_bil_flg"),",");

    ArrayList po_usd_curr_tot_amt = splitStr(request.getParameter("po_usd_curr_tot_amt"),",");
    ArrayList cust_cnt_cd = splitStr(request.getParameter("cust_cnt_cd"),",");
    ArrayList cust_seq = splitStr(request.getParameter("cust_seq"),",");
    ArrayList cust_nomi_trkr_flg = splitStr(request.getParameter("cust_nomi_trkr_flg"),",");
    ArrayList trsp_agmt_rt_tp_cd = splitStr(request.getParameter("trsp_agmt_rt_tp_cd"),",");
    ArrayList trsp_agmt_wy_tp_cd = splitStr(request.getParameter("trsp_agmt_wy_tp_cd"),",");

    ArrayList trsp_frst_flg = splitStr(request.getParameter("trsp_frst_flg"),",");
    ArrayList trsp_rjct_rsn_cd = splitStr(request.getParameter("trsp_rjct_rsn_cd"),",");
    ArrayList trsp_dflt_vndr_flg = splitStr(request.getParameter("trsp_dflt_vndr_flg"),",");

    ArrayList trsp_wo_ofc_cty_cd = splitStr(request.getParameter("trsp_wo_ofc_cty_cd"),",");
    ArrayList trsp_wo_seq = splitStr(request.getParameter("trsp_wo_seq"),",");

    ArrayList n1st_nod_pln_dt = splitStr(request.getParameter("n1st_nod_pln_dt"),",");
    ArrayList lst_nod_pln_dt = splitStr(request.getParameter("lst_nod_pln_dt"),",");
    ArrayList dor_nod_pln_dt = splitStr(request.getParameter("dor_nod_pln_dt"),",");
    ArrayList inter_rmk = splitStr(request.getParameter("inter_rmk"),",");
    ArrayList spcl_instr_rmk = splitStr(request.getParameter("spcl_instr_rmk"),",");

    ArrayList form_fctry_nm = splitStr(request.getParameter("form_fctry_nm"),",");
    ArrayList form_dor_pst_cd = splitStr(request.getParameter("form_dor_pst_cd"),",");
    ArrayList form_cntc_pson_phn_no = splitStr(request.getParameter("form_cntc_pson_phn_no"),",");
    ArrayList form_cntc_pson_fax_no = splitStr(request.getParameter("form_cntc_pson_fax_no"),",");
    ArrayList form_cntc_pson_nm = splitStr(request.getParameter("form_cntc_pson_nm"),",");

    ArrayList n3pty_cust_cnt_cd = splitStr(request.getParameter("n3pty_cust_cnt_cd"),",");
    ArrayList n3pty_cust_seq = splitStr(request.getParameter("n3pty_cust_seq"),",");
    ArrayList n3pty_desc = splitStr(request.getParameter("n3pty_desc"),",");
    ArrayList n3pty_vndr_seq = splitStr(request.getParameter("n3pty_vndr_seq"),",");
    ArrayList n3pty_ofc_cd = splitStr(request.getParameter("n3pty_ofc_cd"),",");
    ArrayList n3pty_bil_bzc_amt = splitStr(request.getParameter("n3pty_bil_bzc_amt"),",");
    ArrayList n3pty_bil_tp_cd = splitStr(request.getParameter("n3pty_bil_tp_cd"),",");
    ArrayList n3pty_curr_cd = splitStr(request.getParameter("n3pty_curr_cd"),",");
    ArrayList trsp_agmt_ofc_cty_cd = splitStr(request.getParameter("trsp_agmt_ofc_cty_cd"),",");
    ArrayList trsp_agmt_seq = splitStr(request.getParameter("trsp_agmt_seq"),",");

    String eq_mode = "";
    String issued = JSPUtil.getNull(request.getParameter("issued"), "N");
    String scg_grp_seq = JSPUtil.getNull(request.getParameter("scg_grp_seq"));
    String isInquiry = JSPUtil.getNull(request.getParameter("isInquiry"));
    String draft_flg = JSPUtil.getNull(request.getParameter("draft_flg"));
    
    
    ArrayList wgt_meas_ut_cd = splitStr(request.getParameter("wgt_meas_ut_cd"), ",");
    ArrayList cntr_kgs_wgt = splitStr(request.getParameter("cntr_kgs_wgt"), ",");
    ArrayList cntr_lbs_wgt = splitStr(request.getParameter("cntr_lbs_wgt"), ",");
    ArrayList cntr_pkup_no = splitStr(request.getParameter("cntr_pkup_no"), ",");
    ArrayList scg_ind_cd = splitStr(request.getParameter("scg_ind_cd"), ",");
    
    String tro_flg = "";
    String tro_prv_flg = JSPUtil.getNull(request.getParameter("tro_prv_flg")); // TRO 호출시 : 'Y'
    if (tro_prv_flg.equals("Y")) {
        tro_flg = "Y";
    }else{
        tro_flg = "N";
    }
    
    String det = null;
    String bno = null;
    String cancel = null;
    String n3pty_bil_flgStr = null;

    StringBuffer init_searchStr = new StringBuffer();
    StringBuffer init_wo_searchStr = new StringBuffer();

    if(trsp_so_ofc_cty_cd != null && trsp_so_ofc_cty_cd.size()>0 && trsp_so_ofc_cty_cd.size() == trsp_so_seq.size()) {
        eq_mode = request.getParameter("eq_mode");

        for(int i=0; i< trsp_so_ofc_cty_cd.size(); i++) {
            det = (dtn_use_flg==null?null:(String)dtn_use_flg.get(i));
            bno = (wo_bl_no_iss_flg==null?null:(String)wo_bl_no_iss_flg.get(i));
            cancel = (wo_cancel_flag==null?null:(String)wo_cancel_flag.get(i));
            n3pty_bil_flgStr = (n3pty_bil_flg==null||((String)n3pty_bil_flg.get(i)).trim().equals("")?"N":(String)n3pty_bil_flg.get(i));

            if(det != null && det.equals("1")){
                det = "Y";
            }else{
                det = "N";
            }

            if(bno != null && bno.equals("1")){
                bno = "Y";
            }else{
                bno = "N";
            }

            if(cancel != null && cancel.equals("1")){
                cancel = "Y";
            }else{
                cancel = "N";
            }
            init_searchStr.append( "&ibflag=R&trsp_so_ofc_cty_cd="+(String)trsp_so_ofc_cty_cd.get(i));
            init_searchStr.append( "&trsp_so_seq="+(String)trsp_so_seq.get(i));
            init_searchStr.append( "&wo_cxl_flg="+cancel);
            init_searchStr.append( "&dtn_use_flg="+det);
            init_searchStr.append( "&wo_bl_no_iss_flg="+bno);
            init_searchStr.append( "&vndr_seq="+ (vndr_seq==null||vndr_seq.size()<i+1?"":(String)vndr_seq.get(i)));
            init_searchStr.append( "&curr_cd="+ (curr_cd==null||curr_cd.size()<i+1?"":(String)curr_cd.get(i)));
            init_searchStr.append( "&bzc_amt="+ (bzc_amt==null||bzc_amt.size()<i+1?"":(String)bzc_amt.get(i)));
            init_searchStr.append( "&nego_amt="+ (nego_amt==null||nego_amt.size()<i+1?"":(String)nego_amt.get(i)));
            init_searchStr.append( "&etc_add_amt="+ (etc_add_amt==null||etc_add_amt.size()<i+1?"":(String)etc_add_amt.get(i)));
            init_searchStr.append( "&fuel_scg_amt="+ (fuel_scg_amt==null||fuel_scg_amt.size()<i+1?"":(String)fuel_scg_amt.get(i)));
            init_searchStr.append( "&usd_ttl_amt="+ (po_usd_curr_tot_amt==null||po_usd_curr_tot_amt.size()<i+1?"":(String)po_usd_curr_tot_amt.get(i)));
            init_searchStr.append( "&n3pty_bil_flg="+ n3pty_bil_flgStr);
            init_searchStr.append( "&po_usd_curr_tot_amt="+ (po_usd_curr_tot_amt==null?"":(String)po_usd_curr_tot_amt.get(i)));
            init_searchStr.append( "&cust_cnt_cd="+ (cust_cnt_cd==null?"":(String)cust_cnt_cd.get(i)));
            init_searchStr.append( "&cust_seq="+ (cust_seq==null?"":(String)cust_seq.get(i)));
            init_searchStr.append( "&cust_nomi_trkr_flg="+ (cust_nomi_trkr_flg==null?"":(String)cust_nomi_trkr_flg.get(i)));
            init_searchStr.append( "&trsp_agmt_rt_tp_cd="+ (trsp_agmt_rt_tp_cd==null?"":(String)trsp_agmt_rt_tp_cd.get(i)));
            init_searchStr.append( "&trsp_agmt_wy_tp_cd="+ (trsp_agmt_wy_tp_cd==null?"":(String)trsp_agmt_wy_tp_cd.get(i)));
            init_searchStr.append( "&trsp_frst_flg="+ (trsp_frst_flg==null?"":(String)trsp_frst_flg.get(i)));
            init_searchStr.append( "&trsp_rjct_rsn_cd="+ (trsp_rjct_rsn_cd==null?"":(String)trsp_rjct_rsn_cd.get(i)));
            init_searchStr.append( "&trsp_dflt_vndr_flg="+ (trsp_dflt_vndr_flg==null?"":(String)trsp_dflt_vndr_flg.get(i)));

            init_searchStr.append( "&n1st_nod_pln_dt="+ (n1st_nod_pln_dt==null||n1st_nod_pln_dt.size()<i+1?"":(String)n1st_nod_pln_dt.get(i)));
            init_searchStr.append( "&lst_nod_pln_dt="+ (lst_nod_pln_dt==null||lst_nod_pln_dt.size()<i+1?"":(String)lst_nod_pln_dt.get(i)));
            init_searchStr.append( "&dor_nod_pln_dt="+ (dor_nod_pln_dt==null||dor_nod_pln_dt.size()<i+1?"":(String)dor_nod_pln_dt.get(i)));
            init_searchStr.append( "&inter_rmk="+ (inter_rmk==null||inter_rmk.size()<i+1?"":(String)inter_rmk.get(i)));
            init_searchStr.append( "&spcl_instr_rmk="+ (spcl_instr_rmk==null||spcl_instr_rmk.size()<i+1?"":(String)spcl_instr_rmk.get(i)));

            init_searchStr.append( "&fctry_nm="+ (form_fctry_nm==null||form_fctry_nm.size()<i+1?"":(String)form_fctry_nm.get(i)));
            init_searchStr.append( "&dor_pst_cd="+ (form_dor_pst_cd==null||form_dor_pst_cd.size()<i+1?"":(String)form_dor_pst_cd.get(i)));
            init_searchStr.append( "&cntc_pson_phn_no="+ (form_cntc_pson_phn_no==null||form_cntc_pson_phn_no.size()<i+1?"":(String)form_cntc_pson_phn_no.get(i)));
            init_searchStr.append( "&cntc_pson_fax_no="+ (form_cntc_pson_fax_no==null||form_cntc_pson_fax_no.size()<i+1?"":(String)form_cntc_pson_fax_no.get(i)));
            init_searchStr.append( "&cntc_pson_nm="+ (form_cntc_pson_nm==null||form_cntc_pson_nm.size()<i+1?"":(String)form_cntc_pson_nm.get(i)));

            init_searchStr.append( "&n3pty_cust_cnt_cd="+ (n3pty_cust_cnt_cd==null||n3pty_cust_cnt_cd.size()<i+1?"":(String)n3pty_cust_cnt_cd.get(i)));
            init_searchStr.append( "&n3pty_cust_seq="+ (n3pty_cust_seq==null||n3pty_cust_seq.size()<i+1?"":(String)n3pty_cust_seq.get(i)));
            init_searchStr.append( "&n3pty_desc="+ (n3pty_desc==null||n3pty_desc.size()<i+1?"":(String)n3pty_desc.get(i)));
            init_searchStr.append( "&n3pty_vndr_seq="+ (n3pty_vndr_seq==null||n3pty_vndr_seq.size()<i+1?"":(String)n3pty_vndr_seq.get(i)));
            init_searchStr.append( "&n3pty_ofc_cd="+ (n3pty_ofc_cd==null||n3pty_ofc_cd.size()<i+1?"":(String)n3pty_ofc_cd.get(i)));
            init_searchStr.append( "&n3pty_bil_bzc_amt="+ (n3pty_bil_bzc_amt==null||n3pty_bil_bzc_amt.size()<i+1?"":(String)n3pty_bil_bzc_amt.get(i)));
            init_searchStr.append( "&n3pty_bil_tp_cd="+ (n3pty_bil_tp_cd==null||n3pty_bil_tp_cd.size()<i+1?"":(String)n3pty_bil_tp_cd.get(i)));
            init_searchStr.append( "&n3pty_curr_cd="+ (n3pty_curr_cd==null||n3pty_curr_cd.size()<i+1?"":(String)n3pty_curr_cd.get(i)));
            init_searchStr.append( "&trsp_agmt_ofc_cty_cd="+ (trsp_agmt_ofc_cty_cd==null||trsp_agmt_ofc_cty_cd.size()<i+1?"":(String)trsp_agmt_ofc_cty_cd.get(i)));
            init_searchStr.append( "&trsp_agmt_seq="+ (trsp_agmt_seq==null||trsp_agmt_seq.size()<i+1?"":(String)trsp_agmt_seq.get(i)));
            init_searchStr.append( "&wgt_meas_ut_cd="+ (wgt_meas_ut_cd==null||wgt_meas_ut_cd.size()<i+1?"":(String)wgt_meas_ut_cd.get(i)));
            init_searchStr.append( "&cntr_kgs_wgt="+ (cntr_kgs_wgt==null||cntr_kgs_wgt.size()<i+1?"":(String)cntr_kgs_wgt.get(i)));
            init_searchStr.append( "&cntr_lbs_wgt="+ (cntr_lbs_wgt==null||cntr_lbs_wgt.size()<i+1?"":(String)cntr_lbs_wgt.get(i)));
            init_searchStr.append( "&cntr_pkup_no="+ (cntr_pkup_no==null||cntr_pkup_no.size()<i+1 ? "" : (String)cntr_pkup_no.get(i) ));
            init_searchStr.append( "&scg_ind_cd="+ (scg_ind_cd==null||scg_ind_cd.size()<i+1 ? "" : (String)scg_ind_cd.get(i) ));
        }
    }else if(trsp_wo_ofc_cty_cd != null && trsp_wo_ofc_cty_cd.size()>0 && trsp_wo_ofc_cty_cd.size() == trsp_wo_seq.size()) {
        for(int i=0; i< trsp_wo_ofc_cty_cd.size(); i++)
        {
            init_wo_searchStr.append( "&ibflag=R&trsp_wo_ofc_cty_cd="+(String)trsp_wo_ofc_cty_cd.get(i));
            init_wo_searchStr.append( "&trsp_wo_seq="+(String)trsp_wo_seq.get(i));
        }

    }
%>

<script  type="text/javascript" src="/opuscntr/rpt/script/common_rd.js"></script>
<script language="javascript">
    var beforeOneMonth = '<%=beforeOneMonth%>';
    var today = '<%=today%>';
    var init_searchStr = '<%=init_searchStr.toString()%>';
    var init_wo_searchStr = '<%=init_wo_searchStr.toString()%>';
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        }
        loadPage();
    }
</script>

<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="FORM_CRE_USR_ID" value="<%=account.getUsr_id()%>" id="FORM_CRE_USR_ID" />
<input type="hidden" name="FORM_USR_OFC_CD" value="<%=account.getOfc_cd()%>" id="FORM_USR_OFC_CD" />
<input type="hidden" name="issued" id="issued" value="<%=issued%>" />
<input type="hidden" name="SCG_GRP_SEQ" id="SCG_GRP_SEQ" value="<%=scg_grp_seq%>"  />
<input type="hidden" name="WO_FMT_TP_CD" id="WO_FMT_TP_CD" />
<input type="hidden" name="WO_PRV_GRP_SEQ" id="WO_PRV_GRP_SEQ" />
<input type="hidden" name="WO_ISS_NO" id="WO_ISS_NO" />
<input type="hidden" name="WO_VNDR_SEQ" id="WO_VNDR_SEQ" />
<input type="hidden" name="WO_ISS_STS_CD" id="WO_ISS_STS_CD" />
<input type="hidden" name="TRSP_WO_OFC_CTY_CD" id="TRSP_WO_OFC_CTY_CD" />
<input type="hidden" name="TRSP_WO_SEQ" id="TRSP_WO_SEQ" />
<input type="hidden" name="TRSP_CRR_MOD_CD" id="TRSP_CRR_MOD_CD" />
<input type="hidden" name="TRSP_COST_DTL_MOD_CD" id="TRSP_COST_DTL_MOD_CD" />

<input type="hidden" name="FAX_SYS_CD" value="TRS" id="FAX_SYS_CD" />
<input type="hidden" name="FAX_APP_CD" id="FAX_APP_CD" />
<input type="hidden" name="FAX_BATCH_IND" value="N" id="FAX_BATCH_IND" />
<input type="hidden" name="FAX_TITLE" value="NYK LINE Work Order" id="FAX_TITLE" />
<input type="hidden" name="FAX_PARAM" id="FAX_PARAM" />
<input type="hidden" name="FAX_RCV_INFO" id="FAX_RCV_INFO" />

<input type="hidden" name="EMAIL_TITLE" id="EMAIL_TITLE" />
<input type="hidden" name="EMAIL_CONTENTS" id="EMAIL_CONTENTS" />
<input type="hidden" name="CONTI_CD" id="CONTI_CD" />
<input type="hidden" name="WO_CXL_FLG" value="<%=cancel==null?"":cancel%>" id="WO_CXL_FLG" />
<input type="hidden" name="isInquiry" value="<%=isInquiry%>" id="isInquiry" />

<input type="hidden" name="draft_flg" value="<%=draft_flg%>" id="draft_flg" />
<input type="hidden" name="rdserver_ip" value="" />

<!-- layer_popup_title(S) -->
<div class="layer_popup_title">
    <!-- page_title_area(S) -->
    <div class="page_title_area clear">
        <!-- page_title(S) -->
        <h2 class="page_title">
            <span>W/O Preview</span>
        </h2>
        <!-- page_title(E) -->
<%
        if (tro_flg.equals("N")) {
%>
        <!-- opus_design_btn(S) -->
        <div class="opus_design_btn">
            <button type="button" class="btn_normal" name="btn_reset" id="btn_reset">Reset</button><!--
            --><button type="button" class="btn_normal" name="btn_confirm" id="btn_confirm">Confirm</button><!--
            --><button type="button" class="btn_normal" name="btn_confirm_all" id="btn_confirm_all">Confirm All</button><!--
            --><button type="button" class="btn_normal" name="btn_print" id="btn_print">Print</button><!--
            --><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
        </div>
        <!-- opus_design_btn(E) --> 
<%
        }
%>

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
<!-- wrap_search(S) -->
<div class="wrap_search">
    <!-- opus_design_inquiry(S) -->
    <div class="opus_design_inquiry wFit">
        <!--  biz_1 (S) -->
        <table>
            <colgroup>
                <col width="150"  />
                <col width=""/>
            </colgroup>
            <tbody>
                <tr>
                    <th>Number Of W/O To Issue</th>
                    <td style="font-size: 120%; font-weight: bold; vertical-align: bottom;"><script language="javascript">ComComboObject('wo_group_no', 1, 150, 1);</script><label id="total_page">/ </label></td>
                </tr>
            </tbody>
        </table>
        <!--  biz_1   (E) -->   
        <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
        <!--  biz_1 (S) -->
        <table>
            <colgroup>
                <col width="100" />
                <col width="200" />
                <col width="60"  />
                <col width="100" />
                <col width="80" />
                <col width="60" />
                <col width=""/>
            </colgroup>
            <tbody>
                <tr>
                    <th>Issue Type</th>
                    <td>
                        <input type="checkbox" name='WO_PRN_USE_FLG' id='WO_PRN_USE_FLG' value='PRN' class="trans" /><label for="WO_PRN_USE_FLG">Print Out</label><!--
                        --><input type="checkbox" name='WO_EML_USE_FLG' id='WO_EML_USE_FLG' value='EML' class="trans" /><label for="WO_EML_USE_FLG">E-Mail</label><!--
                        --><input type="checkbox" name='WO_FAX_USE_FLG' id='WO_FAX_USE_FLG' value='FAX' class="trans" /><label for="WO_FAX_USE_FLG">Fax</label><!--
                        --><input type="checkbox" name='WO_EDI_USE_FLG' id='WO_EDI_USE_FLG' value='EDI' class="trans" /><label for="WO_EDI_USE_FLG">EDI</label><!--
                        --><input type="checkbox" name='WO_DTL_USE_FLG' id='WO_DTL_USE_FLG' value='DTL' class="trans" onClick='rdOpen(document.form);setWoDtlUseFlg(this);' /><label for="WO_DTL_USE_FLG">Detail Form</label>
                    </td>
                    <th>Rate</th>
                    <td>
                        <input type="radio" name='RT_DP_USE_FLG' value='Y' class="trans" onClick='rdOpen(document.form)' checked /><label for="RT_DP_USE_FLG">Show</label><!--
                        --><input type="radio" name='RT_DP_USE_FLG' value='N' class="trans" onClick='rdOpen(document.form)' /><label for="RT_DP_USE_FLG">Hide</label>
                    </td>
                    <th>Commodity</th>
                    <td colspan="2"><input type="checkbox" name='CMDT_DP_USE_FLG' value="Y" class="trans" /><label for="CMDT_DP_USE_FLG">FAK</label></td>
                    <!-- td><label for="PRE_DIS_USE_FLG"><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Pre-Dispatch</b></label><input type="checkbox" name='PRE_DIS_USE_FLG' value="Y" class="trans" onClick='clickPreDisPatch(this)'></td> -->
                </tr>
                <tr>
                    <th>W/O Instruction</th>
                    <td colspan="5"><input type="text" name='WO_RMK' style="width:464px;" onBlur='setRmk(this)' maxlength='255' /></td>

                    <!-- 2015.02.25    Hyungwook Choi -->
                    <!-- 
                    <td><label for="INTER_USE_FLG"><b>Internal Use Only</b></label><input type="checkbox" name='INTER_USE_FLG' value="Y" class="trans" onClick='clickInterUse(this)' /></td>
                    -->

                </tr>
                <tr>
                    <th>E-mail Address</th>
                    <td colspan="6">
                        <input type="text" name='WO_N1ST_EML' maxlength="200" onBlur="setEmailToSheet(this, 'eml1')" style="width:230px;" /><!--
                        --><input type="text" name='WO_N2ND_EML' maxlength="200" onBlur="setEmailToSheet(this, 'eml2')" style="width:230px;" /><!--
                        --><input type="text" name='WO_N3RD_EML' maxlength="200" onBlur="setEmailToSheet(this, 'eml3')" style="width:230px;" />
                    </td>
                </tr>
                <tr>
                    <th>Fax Number</th>
                    <td colspan="6">
                        <input type="text" name='WO_N1ST_FAX_NO' maxlength="18" onBlur="setFaxToSheet(this, 'fax1')" dataformat="num" otherchar="-" style="width:230px;" /><!--
                        --><input type="text" name='WO_N2ND_FAX_NO' maxlength="18" onBlur="setFaxToSheet(this, 'fax2')" dataformat="num" otherchar="-" style="width:230px;" /><!--
                        --><input type="text" name='WO_N3RD_FAX_NO' maxlength="18" onBlur="setFaxToSheet(this, 'fax3')" dataformat="num" otherchar="-" style="width:230px;" />
                    </td>
                </tr>
            </tbody>
        </table>
        <!--  biz_1   (E) -->   
    </div>
    <!-- opus_design_inquiry(E) -->
</div>
<!-- wrap_search(E) -->

<!-- wrap_result(S) -->
<div class="wrap_result">
    <div class="opus_design_grid" style="height: 600px">
        <script language="javascript">rdViewerObject();</script>
    </div>
</div>
<!-- wrap_search(E) -->
<!-- wrap_result(S) -->
<div class="wrap_result" style="display:none" > 
    <!-- opus_design_grid(S) -->
    <div class="opus_design_grid" >
        <div>
            <script language="javascript">ComSheetObject('sheet');</script>
            <script language="javascript">ComSheetObject('sheet2');</script>
            <script language="javascript">ComSheetObject('sheet3');</script>
            <!-- Confirm All -->
            <script language="javascript">ComSheetObject('sheet4');</script>
        </div>
    </div>
    <!-- opus_design_grid(E) -->
</div>
<!-- wrap_result(E) -->
</div>
<!-- popup_contens_area(E) -->
</form>