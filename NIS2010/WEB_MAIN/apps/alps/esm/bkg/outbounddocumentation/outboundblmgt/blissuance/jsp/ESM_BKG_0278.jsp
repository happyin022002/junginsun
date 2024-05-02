<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0278.jsp
*@FileTitle : Group & Multi B/L Print
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.29
*@LastModifier : 박준용
*@LastVersion : 1.0
* 2009.04.29 박준용
* 1.0 Creation
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>


<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event.EsmBkg0278Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
    EsmBkg0278Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount     = 0;                       //DB ResultSet 리스트의 건수
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";
    String strUsr_id = "";
    String strUsr_nm = "";
    Logger log = Logger.getLogger("com.hanjin.apps.OutboundBLMgt.BLIssuance");
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        event = (EsmBkg0278Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (null != serverException) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
    } catch(Exception e) {
        out.println(e.toString());
    }
%>
<html>
<head>
<title>Group & Multi B/L Print</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/hanjin/css/alps_contents.css" type="text/css" rel="stylesheet"/>
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>
<script language="javascript">
    function setupPage() {
        var errMessage = "<%=strErrMsg%>";
        if (1 <= errMessage.length) {
            showErrMessage(errMessage);
        } // end if
        loadPage();
    }
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="strUsr_id" value="<%=strUsr_id%>">

<!-- 개발자 작업 시작 -->

<input type="hidden" name="comboCd" >
<input type="hidden" name="sheet_bl_no_row_chk">
<input type="hidden" name="master_bl_no">
<input type="hidden" name="booking_rcv_term_cd">
<input type="hidden" name="booking_de_term_cd">
<input type="hidden" name="org_sconti_cd">
<input type="hidden" name="desc_sconti_cd">
<input type="hidden" name="org_svc_mod_cd">
<input type="hidden" name="desc_inlnd_svc_mod_cd">
<input type="hidden" name="cust_tp_cd">
<input type="hidden" name="bkg_cgo_tp_cd">
<input type="hidden" name="bkg_sts_cd">
<input type="hidden" name="adv_shtg_cd">
<input type="hidden" name="revenue">
<input type="hidden" name="query_sort">
<input type="hidden" name="rect_top">
<input type="hidden" name="rect_left">
<input type="hidden" name="obl_iss_date">

<input type="hidden" name="com_mrdPath">
<input type="hidden" name="com_mrdArguments">
<input type="hidden" name="bkgNoList">
<input type="hidden" name="com_mrdSaveDialogDir" value="<%=System.getProperty("user.home")+System.getProperty("file.separator")%>">
<input type="hidden" name="com_mrdSaveDialogFileName">
<input type="hidden" name="com_mrdSaveDialogFileExt" value="pdf">
<input type="hidden" name="com_mrdSaveDialogFileExtLimit" value="xls@pdf@bmp@tif">
<input type="hidden" name="com_mrdTitle">
<input type="hidden" name="com_mrdDisableToolbar" value="3">
<input type="hidden" name="com_mrdBodyTitle">
<input type="hidden" name="com_zoomIn">
<input type="hidden" name="com_isBatch" value="N">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
  <tr><td valign="top">

    <!--Page Title, Historical (S)-->
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
      <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
      <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
    </table>
    <!--Page Title, Historical (E)-->

    <!--biz page (S)-->

    <!-- Tab (S) -->
    <table class="tab" border="0" cellpadding="0" cellspacing="0" width="100%">
      <tr><td width="100%"><script language="javascript">ComTabObject('tab1')</script></td></tr>
    </table>
    <!-- Tab (E) -->

    <!-- Tab Search (S) -->
    <div id="tabLayer" style="display:inline">
      <table border="0" class="search" id="mainTable1" width="100%">
        <tr>
          <td class="bg">
            <table class="search" border="0" width="100%">
              <tr class="h23">
                <!--  biz_1  (S) -->
                <td width="480" valign="top">
                  <table class="search_" border="0" style="width:480;">
                    <tr class="h23">
                      <td>
                        <table class="search" border="0">
                          <tr class="h23">
                            <td width="40">VVD</td>
                            <td width="182" colspan="2"><input type="text" name="vvd" style="width:80;" class="input1" value="" required maxlength="9" dataformat="engupnum"></td>
                            <td colspan="3" width="258">Trunk only&nbsp;&nbsp;<input type="checkbox" name="vsl_pre_pst_cd" class="trans" value="Y"></td>
                          </tr>
                          <tr class="h23">
                            <td width="">POL</td>
                            <td width="32"><input type="text" name="vvd_pol_cd" style="width:50;" class="input" value="" maxlength="5" dataformat="engup"></td>
                            <td width="" class="stm">(<input type="checkbox" name="vvd_pol_local" value="Y" class="trans">&nbsp;Local&nbsp;&nbsp;&nbsp;<input type="checkbox" name="vvd_pol_ts" value="Y" class="trans">&nbsp;T/S)</td>
                            <td width="30">POD</td>
                            <td width="57"><input type="text" name="vvd_pod_cd" style="width:50;" class="input" value="" maxlength="5" dataformat="engup"></td>
                            <td class="stm" width="171">(<input type="checkbox" name="vvd_pod_local" value="Y" class="trans">&nbsp;Local&nbsp;&nbsp;&nbsp;<input type="checkbox" name="vvd_pod_ts" value="Y" class="trans">&nbsp;T/S)</td>
                          </tr>
                        </table>
                        <table class="search" border="0">
                          <tr class="h23">
                            <td width="100">Pre VVD</td>
                            <td width="110"><input type="text" name="vvd_pre_vvd" style="width:80;" class="input" value="" maxlength="9" dataformat="engupnum"></td>
                            <td width="100">Pre POL</td>
                            <td width=""><input type="text" name="vvd_pre_pol" style="width:80;" class="input" value="" maxlength="9" dataformat="engup"></td>
                          </tr>
                          <tr class="h23">
                            <td width="">Post VVD</td>
                            <td width=""><input type="text" name="vvd_post_vvd" style="width:80;" class="input" value="" maxlength="9" dataformat="engupnum"></td>
                            <td width="">Post POD</td>
                            <td width=""><input type="text" name="vvd_post_pod" style="width:80;" class="input" value="" maxlength="9" dataformat="engup"></td>
                          </tr>
                          <tr class="h23">
                            <td width="">Booking Route</td>
                            <td width="" colspan="3"><input type="text" name="booking_por_cd" style="width:50;" class="input" value="" maxlength="5" dataformat="engup">&nbsp;<input type="text" name="booking_pol_cd" style="width:50;" class="input" value="" maxlength="5" dataformat="engup">&nbsp;<input type="text" name="booking_pod_cd" style="width:50;" class="input" value="" maxlength="5" dataformat="engup">&nbsp;<input type="text" name="booking_del_cd" style="width:50;" class="input" value=""" maxlength="5" dataformat="engup"></td>
                          </tr>
                          <tr class="h23">
                            <td colspan="8">
                              <table class="height_10"><tr><td colspan="8"></td></tr></table>
                            </td>
                          </tr>
                          <tr class="h23">
                            <td colspan="8">
                              <table class="height_10"><tr><td colspan="8"></td></tr></table>
                            </td>
                          </tr>
                          <tr class="h23">
                            <td width="">R/D Term</td>
                            <td width="" colspan="3">
                              <script language="javascript">ComComboObject('tb1_Mbooking_rcv_term_cd', 1, 80, 0);</script>
                              <!--img src="img/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle"-->&nbsp;
                              <script language="javascript">ComComboObject('tb1_Mbooking_de_term_cd', 1, 80, 0);</script>
                              <!--img src="img/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle"-->
                            </td>
                          </tr>
                        </table>
                        <table class="search" border="0">
                          <tr class="h23">
                            <td width="115">EQ Control Office</td>
                            <td class="stm"width="116"><input type="checkbox" name="eq_por_cd" value="Y" class="trans">&nbsp;POR&nbsp;&nbsp;&nbsp;<input type="checkbox" name="eq_del_cd" value="Y" class="trans">&nbsp;DEL</td>
                            <td width=""><input type="text" name="eq_ctrl_ofc_cd" style="width:55;" class="input" value="" maxlength="6" dataformat="engup"></td>
                          </tr>
                          <tr class="h23">
                            <td colspan="8">
                              <table class="height_10"><tr><td colspan="8"></td></tr></table>
                            </td>
                          </tr>
                          <tr class="h23">
                            <td colspan="8">
                              <table class="height_10"><tr><td colspan="8"></td></tr></table>
                            </td>
                          </tr>
                        </table>
                        <table class="search" border="0">
                          <tr class="h23">
                            <!--td width="164">B/L Release (Issue) Date</td-->
                            <td width="194">B/L (<input type="radio" name="obl_iss_chk" value="R" class="trans" checked>Release
                                                 <input type="radio" name="obl_iss_chk" value="I" class="trans">Issue) Date</td>
                            <td width="" colspan="2"><input type="text" name="obl_iss_from_dt" style="width:81;" class="input1" value="" maxlength="10" dataformat="ymd" cofield="obl_iss_to_dt" caption="B/L Release sdate">&nbsp;~&nbsp;<input type="text" name="obl_iss_to_dt" style="width:82;" class="input1" value="" maxlength="10" dataformat="ymd" cofield="obl_iss_from_dt" caption="B/L Release edate">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" style="cursor:hand" name="tb1_btn_calendar"></td>
                          </tr>
                        </table>
                        <table class="search" border="0">
                          <tr class="h23">
                            <td width="98" valign="top">B/L No.</td>
                            <td width="" colspan="3" valign="top">
                              <table class="search" border="0">
                                <tr class="h23">
                                  <td valign="top" id="td_bl_no" width="123">
                                    <div id="bl_input" style="display:block;">
                                      <input type="text" name="input_bl_no" style="width:121;" class="input1" value="" maxlength="12" dataformat="engupnum">
                                    </div>
                                    <div id="bl_sheet" style="display:none;width:123px;height:150px;position:absolute;left:0px;top:0px;">
                                      <script language="javascript">ComSheetObject('t1sheet1');</script>
                                    </div>
                                 </td>
                                 <td style="width:2"></td>
                                  <td width=""><table width="115" border="0" cellpadding="0" cellspacing="0" class="button">
                                		<tr><td class="btn2_left"></td>
                               				 <td class="btn2" id="tb1_btn_input_bl_no" name="tb1_btn_input_bl_no">Multi B/L No.</td>
                               				 <td class="btn2_right"></td>
                                		</tr></table>
                                	</td>
                                 </tr>
                              </table>
                            </td>
                          </tr>
                          <tr class="h23">
                            <td width="98">Booking Office</td>
                            <td width="120"><input type="text" name="bkg_ofc_cd" style="width:55;" class="input" value="" maxlength="6" dataformat="engup"></td>
                            <td width="98">Booking Staff</td>
                            <td width=""><input type="text" name="doc_usr_cd" style="width:170;" class="input" value="" maxlength="20" dataformat="etc"></td>
                          </tr>
                          <tr class="h23">
                            <td width="98">Sales Office</td>
                            <td width="120"><input type="text" name="ob_sls_ofc_cd" style="width:55;" class="input" value="" maxlength="6" dataformat="engupnumspc"></td>
                            <td width="98">Sales Rep.</td>
                            <td width=""><input type="text" name="ob_srep_cd" style="width:50;" class="input" value="" maxlength="5" dataformat="engupnum"></td>
                          </tr>
                          <tr class="h23">
                            <td width="98">B/L Office</td>
                            <td width="120"><input type="text" name="obl_iss_ofc_cd" style="width:55;" class="input" value="" maxlength="6" dataformat="engup"></td>
                            <td width="98">B/L Staff</td>
                            <td width=""><input type="text" name="obl_iss_usr_id" style="width:170;" class="input" value="" maxlength="20" dataformat="etc"></td>
                          </tr>
                        </table>
                      </td>
                    </tr>
                  </table>
                </td>
                <!--  biz_1  (E) -->
                <td width="12">&nbsp;</td>
                <!--  biz_2  (S) -->
                <td width="480" valign="top">
                  <table class="search_" border="0" style="width:480;">
                    <tr class="h23">
                      <td>
                        <table class="search" border="0">
                          <tr class="h23">
                            <td width="110">Rep. Commodity </td>
                            <td width="95"><input type="text" name="rep_cmdt_cd" style="width:42;" class="input" value="" maxlength="4" dataformat="engup">&nbsp;<img name="tb1_btn_rep_cmdt_cd" id="btn_rep_cmdt_cd" class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
                            <td width="90">Commodity</td>
                            <td width=""><input type="text" name="cmdt_cd" style="width:55;" class="input" value="" maxlength="6" dataformat="engup">&nbsp;<input type="text" name="cmdt_nm" style="width:55;" class="input" value="" maxlength="200" dataformat="engup">&nbsp;<img name="tb1_btn_cmdt_cd" id="btn_cmdt_cd" class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
                          </tr>
                          <tr class="h23">
                            <td width="110">S/O No.</td>
                            <td width=""><input type="text" name="twn_so_no" style="width:42;" class="input" value="" maxlength="4" dataformat="engup"></td>
                            <td width="">Regional Booking No.</td>
                            <td width=""><input type="text" name="cust_ref_no" style="width:139;" class="input" value="" maxlength="50" dataformat="engup"></td>
                          </tr>
                        </table>
                        <table class="height_5"><tr><td colspan="8"></td></tr></table>
                        <table class="search_sm" border="0" style="width:100%;">
                          <tr class="h23">
                            <td width="170"><input type="radio" name="sc_rfa_chk" value="sc" class="trans" checked>&nbsp;S/C&nbsp;
                                            <input type="radio" name="sc_rfa_chk" value="rfa" class="trans">&nbsp;RFA&nbsp;
                                            <input type="radio" name="sc_rfa_chk" value="taa" class="trans">&nbsp;TAA&nbsp;</td>
                            <td width=""><input type="text" name="sc_rfa_no" style="width:170;" class="input" value="" maxlength="20" dataformat="engup">&nbsp;<img name="tb1_btn_sc_rfa_no" id="btn_sc_rfa_no" class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
                          </tr>
                        </table>
                        <table class="height_5"><tr><td colspan="8"></td></tr></table>
                        <table class="search" border="0">
                          <tr class="h23">
                            <td width="60">S.Route</td>
                            <td width="180">
                              <script language="javascript">ComComboObject('tb1_Morg_sconti_cd', 1, 60, 1);</script>
                              <!--img src="img/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle"-->&nbsp;
                              <script language="javascript">ComComboObject('tb1_Mdesc_sconti_cd', 1, 60, 1);</script>
                              <!--img src="img/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle"-->
                            </td>
                            <td width="60">S.Mode</td>
                            <td width="180">
                              <script language="javascript">ComComboObject('tb1_Morg_svc_mod_cd', 1, 60, 1);</script>
                              <!--img src="img/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle"-->&nbsp;
                              <script language="javascript">ComComboObject('tb1_Mdesc_inlnd_svc_mod_cd', 1, 60, 1);</script>
                              <!--img src="img/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle"-->
                            </td>
                          </tr>
                        </table>
                        <table class="height_5"><tr><td colspan="8"></td></tr></table>
                        <table class="search_sm" border="0">
                          <tr class="h23">
                            <td width="478" colspan="7">
                              <table class="search" border="0">
                                <tr>
                                  <td class="title_h"></td>
                                  <td class="title_s">Customer</td>
                                </tr>
                              </table>
                            </td>
                          </tr>
                          <tr class="sm">
                            <td width="72"><input type="checkbox" name="cust_tp_cd_s" value="Y"class="trans">&nbsp;Shipper</td>
                            <td width="60"><input type="checkbox" name="cust_tp_cd_c" value="Y"class="trans">&nbsp;Consignee</td>
                            <td width="60"><input type="checkbox" name="cust_tp_cd_n" value="Y"class="trans">&nbsp;Notify</td>
                            <td width="60"><input type="checkbox" name="cust_tp_cd_f" value="Y"class="trans">&nbsp;Forwarder</td>
                            <td width="100"><input type="checkbox" name="cust_tp_cd_a" value="Y"class="trans">&nbsp;Also Notify</td>
                          </tr>
                          <tr class="h23">
                            <td width="" colspan="5"><input type="text" name="cust_cnt_cd" style="width:25;" class="input" value="" maxlength="2" dataformat="engup">&nbsp;<input type="text" name="cust_seq" style="width:55;" class="input" value="" maxlength="6" dataformat="int">&nbsp;<input type="text" name="cust_nm" style="width:330;" class="input" value="" dataformat="engup">&nbsp;<img name="tb1_btn_cust_cd" id="btn_cust_cd" class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
                          </tr>
                        </table>
                        <table class="height_5"><tr><td colspan="8"></td></tr></table>
                        <table class="search_sm" border="0">
                          <tr class="h23">
                            <td width="478" colspan="7">
                              <table class="search" border="0">
                                <tr>
                                  <td class="title_h"></td>
                                  <td class="title_s">Special Cargo</td>
                                </tr>
                              </table>
                            </td>
                          </tr>
                          <tr class="sm">
                            <td width="72"><input type="checkbox" name="dcgo_flg" value="Y"class="trans">&nbsp;Danger</td>
                            <td width="65"><input type="checkbox" name="rc_flg" value="Y"class="trans">&nbsp;Reefer</td>
                            <td width="60"><input type="checkbox" name="awk_cgo_flg" value="Y"class="trans">&nbsp;Awkward</td>
                            <td width="" colspan="2"><input type="checkbox" name="bb_cgo_flg" value="Y"class="trans">&nbsp;Break Bulk</td>
                          </tr>
                          <tr class="sm">
                            <td width=""><input type="checkbox" name="hngr_flg" value="Y"class="trans">&nbsp;Hanger</td>
                            <td width=""><input type="checkbox" name="shpr_ownr_cntr_flg" value="Y"class="trans">&nbsp;S.O.C</td>
                            <td width=""><input type="checkbox" name="eq_subst_flg" value="Y"class="trans">&nbsp;EQ Sub</td>
                            <td width="90"><input type="checkbox" name="rd_cgo_flg" value="Y"class="trans">&nbsp;Reefer Dry</td>
                            <td width=""><input type="checkbox" name="rail_blk_cd" value="Y"class="trans">&nbsp;Rail Bulk</td>
                          </tr>
                          <tr class="sm">
                            <td width=""><input type="checkbox" name="stwg_cd" value="Y"class="trans">&nbsp;Stowage</td>
                            <td width=""><input type="checkbox" name="prct_flg" name="dcgo_flg" value="Y"class="trans">&nbsp;Pre-caution</td>
                            <td width=""><input type="checkbox" name="fd_grd_flg" value="Y"class="trans">&nbsp;Food Grade</td>
                            <td width=""><input type="checkbox" name="spcl_hide_flg" value="Y"class="trans">&nbsp;Hide</td>
                          </tr>
                        </table>
                        <table class="height_5"><tr><td colspan="8"></td></tr></table>
                        <table class="search_sm" border="0" width="478">
                          <tr class="h23">
                            <td width="95">Cargo Type</td>
                            <td width="" class="sm"><input type="checkbox" name="bkg_cgo_tp_cd_f" value="F"class="trans">&nbsp;&nbsp;Full&nbsp;&nbsp;&nbsp;<input type="checkbox" name="bkg_cgo_tp_cd_p" value="P"class="trans">&nbsp;&nbsp;Empty (for EQ reposition)&nbsp;&nbsp;&nbsp;<input type="checkbox" name="bkg_cgo_tp_cd_r" value="R"class="trans">&nbsp;&nbsp;Revenue Empty</td>
                          </tr>
                        </table>
                        <table class="height_5"><tr><td colspan="8"></td></tr></table>
                        <table class="search_sm" border="0" width="478">
                          <tr class="h23">
                            <td width="95">Booking Status</td>
                            <td width="" class="sm"><input type="checkbox" name="bkg_sts_cd_f" value="F"class="trans">&nbsp;F-Firm &nbsp;<input type="checkbox" name="bkg_sts_cd_w" value="W"class="trans">&nbsp;W-Waiting(<input type="checkbox" name="bkg_rsn_spcl_cgo_flg" value="Y"class="trans" disabled>&nbsp;Non approval of special cargo<input type="checkbox" name="wt_rsn_hld_flg"value="Y"class="trans" disabled>Holding)</td>
                          </tr>
                        </table>
                        <table class="height_5"><tr><td colspan="8"></td></tr></table>
                        <table class="search" border="0" width="478">
                          <tr class="h23">
                            <td width="47%">
                              <table class="search_sm" border="0" width="100%">
                                <tr class="h23">
                                  <td width="96">Memo B/L Type</td>
                                  <td width="" class="sm"><input type="checkbox" name="adv_shtg_cd_a" value="A"class="trans">&nbsp;ahead&nbsp;<input type="checkbox" name="adv_shtg_cd_s" value="S"class="trans">&nbsp;short</td>
                                </tr>
                              </table>
                            </td>
                            <td width="1%"></td>
                            <td width="50%">
                              <table class="search_sm" border="0" width="100%">
                                <tr class="h23">
                                  <td width="60">Revenue</td>
                                  <td width="" class="sm"><input type="checkbox" name="revenue_r" value="F|B|R"class="trans">&nbsp;Revenue&nbsp;<input type="checkbox" name="revenue_n" value="P"class="trans">&nbsp;Non-Revenue</td>
                                </tr>
                              </table>
                            </td>
                          </tr>
                        </table>
                        <table class="height_5"><tr><td colspan="8"></td></tr></table>
                        <table class="search" border="0" width="478">
                          <tr class="h23">
                            <td width="48%">
                              <table class="search_sm" border="0" width="100%">
                                <tr class="h23">
                                  <td width="95">ITN</td>
                                  <td width="" class="sm"><input type="checkbox" name="aes_itn_y" value="Y"class="trans">&nbsp;Yes&nbsp;<input type="checkbox" name="aes_itn_n" value="Y"class="trans">&nbsp;No</td>
                                </tr>
                              </table>
                            </td>
                            <td width="1%"></td>
                            <td>
                              <table class="search_sm" border="0" width="100%">
                                <tr class="h23">
                                  <td width="100%"><input type="checkbox" name="stop_cargo" value="Y"class="trans">&nbsp;&nbsp;&nbsp;Stop Cargo</td>
                                </tr>
                              </table>
                            </td>
                          </tr>
                        </table>
                      </td>
                    </tr>
                  </table>
                </td>
                <!--  biz_2  (E) -->
              </tr>
            </table>
          </td>
        </tr>
      </table>
      <!--Button (S) -->
      <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;">
        <tr>
          <td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="tb1_btn_Retrieve" id="tb1_btn_Retrieve">Retrieve</td>
                    <td class="btn1_right"></td>
                    </tr></table></td>
                <td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="tb1_btn_New">New</td>
                    <td class="btn1_right"></td>
                    </tr></table></td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
      <!--Button (E) -->
    </div>
    <!-- TAB Search (E) -->

    <!-- TAB Result (S) -->
    <div id="tabLayer" style="display:none">
      <!-- Grid BG Box  (S) -->
      <table class="search">
        <tr>
          <td class="bg">
            <!--Grid (S)-->
            <table width="100%"  id="mainTable2">
              <tr><td width="100%">
                <script language="javascript">ComSheetObject('t2sheet1');</script>
              </td></tr>
            </table>
            <!--Grid (E)-->
             <table width="100%"  id="mainTable2">
              <tr><td width="100%">
                <script language="javascript">ComSheetObject('t2sheet2');</script>
              </td></tr>
             </table>
              <!--  Button_Sub (S) -->
            <table width="100%" class="button" border="0">
              <tr>
                <td class="btn2_bg">
                  <table border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                          <tr>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="tb2_btn_BLPDFPrint">B/L PDF View</td>
								<td class="btn2_right"></td>
								</tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="tb2_btn_BLPreview">B/L Preview</td>
								<td class="btn2_right"></td>
								</tr></table></td>				
                            <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                <tr><td class="btn2_left"></td>
                                <td class="btn2" name="tb2_btn_BLPrint">B/L Print</td>
                                <td class="btn2_right"></td>
                                </tr></table></td>
                            <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                <tr><td class="btn2_left"></td>
                                <td class="btn2" name="tb2_btn_EIR">EIR (HKG)</td>
                                <td class="btn2_right"></td>
                                </tr></table></td>
                            <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                <tr><td class="btn2_left"></td>
                                <td class="btn2" name="tb2_btn_Manifest">Manifest(US)</td>
                                <td class="btn2_right"></td>
                                </tr></table></td>
                            <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                <tr><td class="btn2_left"></td>
                                <td class="btn2" name="tb2_btn_dovn">D/O(VN)</td>
                                <td class="btn2_right"></td>
                                </tr></table></td>
                            <td class="btn2_left"></td>
                            <td class="btn2" name="tb2_btn_Sort">Sort</td>
                            <td class="btn2_right"></td>
                          </tr>
                        </table>
                      </td>
                    </tr>
                  </table>
                </td>
              </tr>
            </table>
            <!-- Button_Sub (E) -->
               <table class="height_5"><tr><td colspan="8"></td></tr></table>
            <table class="search" border="0" style="width:979;">
              <tr class="h23">
                <td width="80">Booking Q'ty</td>
                <td width="120"><input type="text" name="bookingCnt" style="width:88;text-align:right;" class="input" value="" readonly></td>
                <td width="60">B/L Q'ty</td>
                <td width="120"><input type="text" name="bldocCnt" style="width:88;text-align:right;" class="input" value=""readonly></td>
                <td width="85">Weight(TON)</td>
                <td width="120"><input type="text" name="weightTon" style="width:88;text-align:right;" class="input" value="" readonly></td>
                <td width="50">Measure</td>
                <td width=""><input type="text" name="Measure" style="width:88;text-align:right;" class="input" value="" readonly></td>
              </tr>
            </table>
          
          </td>
        </tr>
      </table>
      <!-- Grid BG Box  (S) -->
      <!--Button (S) -->
      <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
        <tr>
          <td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="tb2_btn_DownExcel">B/L List Down Excel</td>
                    <td class="btn1_right"></td>
                    </tr></table></td>
                <td class="btn1_line"></td>
                <td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="tb2_btn_Back">Back</td>
                    <td class="btn1_right"></td>
                    </tr></table></td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
      <!--Button (E) -->
      <table class="height_10" border="0"><tr><td height="59" colspan="8"></td></tr></table>
    </div>
    <!-- TAB Result (E) -->

    <!--biz page (E)-->
    </td>
  </tr>
  <tr><td height="0" width="0"><script language="javascript">comRdObject('report1');</script></td></tr>
</table>

<!-- 개발자 작업 끝 -->

</form>
<form name="form2" method="POST">
<input type="hidden" name="bkg_no">
<input type="hidden" name="param_ui_id">
</form>
</body>
</html>
