<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0926.jsp
*@FileTitle : C/M Data Check Set-up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.23
*@LastModifier : 이수빈
*@LastVersion : 1.0
* 2009.04.23 이수빈
* 1.0 Creation
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.controller.util.WebKeys"%>
<%@ page import="com.hanjin.framework.core.view.template.Screen"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.event.EsmBkg0926Event"%>
<%@ page import="com.hanjin.syscommon.common.table.MdmCountryVO" %>
<%@ page import="com.hanjin.syscommon.common.table.MdmPortVO" %>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List" %>

<%
    EsmBkg0926Event  event = null;                    //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;            //서버에서 발생한 에러
    String strErrMsg = "";                        //에러메세지
    int rowCount     = 0;                        //DB ResultSet 리스트의 건수
    
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String strOfc_cd        = "";
    String strPgmNo         = "";
    String screenName       = "";
    Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.ManifestListDownload");

    StringBuffer countryComboText = new StringBuffer();
    StringBuffer portComboText = new StringBuffer();
    
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strOfc_cd = account.getOfc_cd().substring(0,4);
       
       
        event = (EsmBkg0926Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        
        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        strPgmNo = request.getParameter("pgmNo");
        
        Screen screen = (Screen) request.getAttribute(WebKeys.CURRENT_SCREEN);
        screenName = screen.getName();
 
    }catch(Exception e) {
        out.println(e.toString());
    }
%>
<html>
<head>
<title>C/M Data Check Set-up</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
    var userOfficeCode = "<%=strOfc_cd%>";
    var countryComboText = "<%=countryComboText.toString()%>";
    var portComboText = "<%=portComboText.toString()%>";
    
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            showErrMessage(errMessage);
        } // end if
        ComSetObjValue(document.form.screenName,"<%=screenName%>");
        loadPage();
    }
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="screenName">
<input type="hidden" name="comboName">
<input type="hidden" name="cntCd">
<input type="hidden" name="cstms_div_id" value="CTM">
<input type="hidden" name="menuCode" value="<%="ESM_BKG_0926-01".equals(strPgmNo) ? "C" : "R" %>">
<!-- 개발자 작업    -->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;padding-right:5;">

    <tr><td valign="top" width="100%">
        <!--Page Title, Historical (S)-->
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
            <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
            <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title">C/M Data Check Set-up</span></td></tr>
        </table>
        <!--Page Title, Historical (E)-->
    
        <!--biz page (S)-->
        <table class="search"> 
               <tr><td class="bg">

                <!--  biz_1  (S) -->
                <table class="search" border="0" style="width:979;"> 
                <tr class="h23">
                    <td width="55">Country</td>
                    <td width="100"><script language="javascript">ComComboObject('cnt_cd', 3, 50, 0);</script></td>
                    <td width="35">Port</td>
                    <td width="130"><script language="javascript">ComComboObject('loc_cd', 3, 80, 0);</script></td>
                    <td width="">
                        <table class="search_sm2" border="0" style="width:240;"> 
                            <tr class="h23">
                                <td width="110">Including FROB</td>
                                <td class="stm"><input type="radio" name="frob_flg" value="Y" class="trans" onclick="OnClickRadioButton(document.form)" checked>Yes&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="frob_flg" value="N" class="trans" onclick="OnClickRadioButton(document.form)">No</td>
                            </tr>
                        </table>
                    </td>
                </tr>
                </table>
                <!--  biz_1   (E) -->
                
            </td></tr>
        </table>
        <table class="height_8"><tr><td></td></tr></table>
            
        <!-- Tab (S) -->
         <table width="100%" class="tab" border="0" cellpadding="0" cellspacing="0" style="display:inline"> 
               <tr><td><script language="javascript">ComTabObject('tab1')</script></td></tr>
        </table>
        <!-- Tab (E) -->
        
<!--TAB Export (S) -->
<div id="tabLayer" style="display:inline">
        <!-- Grid BG Box  (S) -->
         <table class="search" id="mainTable">
           <tr><td class="bg">
           
            <!-- Grid  (S) -->
            <table width="100%" class="grid2"> 
            <input type="hidden" id="hide" name="expMst_xpt_imp_cd" value="E" />
            <input type="hidden" id="hide" name="expMst_bl_tp_cd" value="M" />
            <input type="hidden" id="hide" name="expMst_cnt_cd" value="" />
            <input type="hidden" id="hide" name="expMst_loc_cd" value="" />
            <input type="hidden" id="hide" name="expMst_frob_flg" value="" />
            <input type="hidden" id="hide" name="expMst_cstms_div_id" value="" />
            
            <input type="hidden" id="hide" name="expHus_xpt_imp_cd" value="E" />
            <input type="hidden" id="hide" name="expHus_bl_tp_cd" value="H" />
            <input type="hidden" id="hide" name="expHus_cnt_cd" value="" />
            <input type="hidden" id="hide" name="expHus_loc_cd" value="" />
            <input type="hidden" id="hide" name="expHus_frob_flg" value="" />
            <input type="hidden" id="hide" name="expHus_cstms_div_id" value="" />
                
                <tr class="tr2_head">
                    <td width="12%"></td>
                    <td width="43%">Master B/L    </td>
                    <td width="%">House B/L</td>
                </tr>
                                                        
                <tr align="center">
                    <td class="tr2_head2">Shipper    </td>
                    <td align="left">
                    &nbsp;<input type="checkbox" id="chk" name="expMst_shpr_nm_flg" value="" class="trans">Name&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="expMst_shpr_addr_flg" value="" class="trans">Address&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="expMst_shpr_cty_flg" value="" class="trans">City&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="expMst_shpr_ste_flg" value="" class="trans">State&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="expMst_shpr_cnt_flg" value="" class="trans">Country&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="expMst_shpr_zip_flg" value="" class="trans">ZIP&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="expMst_shpr_st_nm_flg" value="" class="trans">Street<br>
                    &nbsp;&nbsp;<input type="checkbox" id="chk" name="expMst_shpr_eori_no_flg" value="" class="trans">EORI&nbsp;&nbsp;
                    &nbsp;&nbsp;<input type="checkbox" id="chk" name="expMst_shpr_phn_flg" value="" class="trans">Tel&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;<input type="checkbox" id="chk" name="expMst_shpr_fax_flg" value="" class="trans">Fax&nbsp;&nbsp;
                    &nbsp;&nbsp;<input type="checkbox" id="chk" name="expMst_shpr_co_rgst_flg" value="" class="trans">Company Registration No.</td>
                     
                    <td align="left">
                    &nbsp;<input type="checkbox" id="chk" name="expHus_shpr_nm_flg" value="" class="trans">Name&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="expHus_shpr_addr_flg" value="" class="trans">Address&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="expHus_shpr_cty_flg" value="" class="trans">City&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="expHus_shpr_ste_flg" value="" class="trans">State&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="expHus_shpr_cnt_flg" value="" class="trans">Country&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="expHus_shpr_zip_flg" value="" class="trans">ZIP <br>
                    &nbsp;&nbsp;<input type="checkbox" id="chk" name="expHus_shpr_co_rgst_flg" value="" class="trans">Company Registration No.</td>
                </tr>
                                                        
                <tr align="center">
                    <td class="tr2_head2">Consignee</td>
                    <td align="left">
                    &nbsp;<input type="checkbox" id="chk" name="expMst_cnee_nm_flg" value="" class="trans">Name&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="expMst_cnee_addr_flg" value="" class="trans">Address&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="expMst_cnee_cty_flg" value="" class="trans">City&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="expMst_cnee_ste_flg" value="" class="trans">State&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="expMst_cnee_cnt_flg" value="" class="trans">Country&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="expMst_cnee_zip_flg" value="" class="trans">ZIP&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="expMst_cnee_st_nm_flg" value="" class="trans">Street<br>
                    &nbsp;&nbsp;<input type="checkbox" id="chk" name="expMst_cnee_eori_no_flg" value="" class="trans">EORI&nbsp;&nbsp;
                    &nbsp;&nbsp;<input type="checkbox" id="chk" name="expMst_cnee_phn_flg" value="" class="trans">Tel&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;<input type="checkbox" id="chk" name="expMst_cnee_fax_flg" value="" class="trans">Fax&nbsp;&nbsp;
                    &nbsp;&nbsp;<input type="checkbox" id="chk" name="expMst_cnee_co_rgst_flg" value="" class="trans">Company Registration No.</td>
                    
                    <td align="left">
                    &nbsp;<input type="checkbox" id="chk" name="expHus_cnee_nm_flg" value="" class="trans">Name&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="expHus_cnee_addr_flg" value="" class="trans">Address&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="expHus_cnee_cty_flg" value="" class="trans">City&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="expHus_cnee_ste_flg" value="" class="trans">State&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="expHus_cnee_cnt_flg" value="" class="trans">Country&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="expHus_cnee_zip_flg" value="" class="trans">ZIP <br>
                    &nbsp;&nbsp;<input type="checkbox" id="chk" name="expHus_cnee_co_rgst_flg" value="" class="trans">Company Registration No.</td>
                </tr>
                                                        
                <tr align="center">
                    <td class="tr2_head2">Notify</td>
                    <td align="left">
                    &nbsp;<input type="checkbox" id="chk" name="expMst_ntfy_nm_flg" value="" class="trans">Name&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="expMst_ntfy_addr_flg" value="" class="trans">Address&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="expMst_ntfy_cty_flg" value="" class="trans">City&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="expMst_ntfy_ste_flg" value="" class="trans">State&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="expMst_ntfy_cnt_flg" value="" class="trans">Country&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="expMst_ntfy_zip_flg" value="" class="trans">ZIP&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="expMst_ntfy_st_nm_flg" value="" class="trans">Street<br>
                    &nbsp;&nbsp;<input type="checkbox" id="chk" name="expMst_ntfy_eori_no_flg" value="" class="trans">EORI&nbsp;&nbsp;
                    &nbsp;&nbsp;<input type="checkbox" id="chk" name="expMst_ntfy_phn_flg" value="" class="trans">Tel&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;<input type="checkbox" id="chk" name="expMst_ntfy_fax_flg" value="" class="trans">Fax&nbsp;&nbsp;
                    &nbsp;&nbsp;<input type="checkbox" id="chk" name="expMst_ntfy_co_rgst_flg" value="" class="trans">Company Registration No.</td>
                    
                    <td align="left">
                    &nbsp;<input type="checkbox" id="chk" name="expHus_ntfy_nm_flg" value="" class="trans">Name&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="expHus_ntfy_addr_flg" value="" class="trans">Address&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="expHus_ntfy_cty_flg" value="" class="trans">City&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="expHus_ntfy_ste_flg" value="" class="trans">State&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="expHus_ntfy_cnt_flg" value="" class="trans">Country&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="expHus_ntfy_zip_flg" value="" class="trans">ZIP <br>
                    &nbsp;&nbsp;<input type="checkbox" id="chk" name="expHus_ntfy_co_rgst_flg" value="" class="trans">Company Registration No.</td>
                </tr>
                                                        
                <tr align="center">
                    <td class="tr2_head2">B/L Main</td>
                    <td align="left">
                    &nbsp;<input type="checkbox" id="chk" name="expMst_pck_flg" value="" class="trans">Package
                    <input type="checkbox" id="chk" name="expMst_wgt_flg" value="" class="trans">Weight&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="expMst_meas_flg" value="" class="trans">Measure&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="expMst_bl_desc_flg" value="" class="trans">Description&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="expMst_bl_mk_flg" value="" class="trans">Mark</td>
                    
                    <td align="left">
                    &nbsp;<input type="checkbox" id="chk" name="expHus_pck_flg" value="" class="trans">Package
                    <input type="checkbox" id="chk" name="expHus_wgt_flg" value="" class="trans">Weight&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="expHus_meas_flg" value="" class="trans">Measure&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="expHus_bl_desc_flg" value="" class="trans"> Description&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="expHus_bl_mk_flg" value="" class="trans">Mark</td>
                </tr>
                                                        
                <tr align="center">
                    <td class="tr2_head2">Container</td>
                    <td align="left">
                    &nbsp;<input type="checkbox" id="chk" name="expMst_cntr_no_flg" value="" class="trans">Container No&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="expMst_seal_no_flg" value="" class="trans">Seal No&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="expMst_cntr_pck_flg" value="" class="trans">Package&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="expMst_cntr_wgt_flg" value="" class="trans">Weight&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="expMst_cntr_meas_flg" value="" class="trans">Measure</td>
                    
                    <td align="left">
                    &nbsp;<input type="checkbox" id="chk" name="expHus_cntr_no_flg" value="" class="trans">Container No&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="expHus_seal_no_flg" value="" class="trans">Seal No&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="expHus_cntr_pck_flg" value="" class="trans">Package&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="expHus_cntr_wgt_flg" value="" class="trans">Weight&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="expHus_cntr_meas_flg" value="" class="trans">Measure</td>
                </tr>
                <tr align="center">
                    <td class="tr2_head2">C/M</td>
                    <td align="left">
                    &nbsp;<input type="checkbox" id="chk" name="expMst_cntr_mf_pck_flg" value="" class="trans">Package
                    <input type="checkbox" id="chk" name="expMst_cntr_mf_wgt_flg" value="" class="trans">Weight&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="expMst_cntr_mf_meas_flg" value="" class="trans"> Measure&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="expMst_cntr_mf_desc_flg" value="" class="trans"> Description&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="expMst_cntr_mf_mk_flg" value="" class="trans">Mark&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="expMst_cntr_mf_cmdt_flg" value="" class="trans">HTS <br>
                    &nbsp;&nbsp;<input type="checkbox" id="chk" name="expMst_cmdt_hs_cd_flg" value="" class="trans">HS&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;<input type="checkbox" id="chk" name="expMst_cntr_mf_ncm_flg" value="" class="trans">NCM</td> 
                    <td align="left">
                    &nbsp;<input type="checkbox" id="chk" name="expHus_cntr_mf_pck_flg" value="" class="trans">Package
                    <input type="checkbox" id="chk" name="expHus_cntr_mf_wgt_flg" value="" class="trans">Weight&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="expHus_cntr_mf_meas_flg" value="" class="trans"> Measure&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="expHus_cntr_mf_desc_flg" value="" class="trans"> Description&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="expHus_cntr_mf_mk_flg" value="" class="trans">Mark&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="expHus_cntr_mf_cmdt_flg" value="" class="trans">HTS <br>
                    &nbsp;&nbsp;<input type="checkbox" id="chk" name="expHus_cntr_mf_ncm_flg" value="" class="trans">NCM</td> 
                </tr>
                <tr align="center">
                    <td class="tr2_head2">Export/Import Ref #</td>
                    
                    <td align="left">
                    &nbsp;<input type="checkbox" id="chk" name="expMst_xpt_imp_ref_flg1" value="" class="trans">AES &nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="expMst_xpt_imp_ref_flg2" value="" class="trans"> CAED&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="expMst_xpt_imp_ref_flg3" value="" class="trans"> E/L&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="expMst_xpt_imp_ref_flg4" value="" class="trans"> DDE/SD&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="expMst_xpt_imp_ref_flg5" value="" class="trans">PEB&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="expMst_xpt_imp_ref_flg6" value="" class="trans">Tax ID</td> 
                    <td align="left">
                    &nbsp;<input type="checkbox" id="chk" name="expHus_xpt_imp_ref_flg1" value="" class="trans">Manifest File No.</td>
                </tr>
            </table> 
            <!-- Grid (E) -->
        </td></tr>
    </table>
    <!-- Grid BG Box  (S) -->
</div>
<!--TAB Export (E) -->
    
<!--TAB Import (S) -->
<div id="tabLayer" style="display:none">
        <!-- Grid BG Box  (S) -->
         <table class="search" id="mainTable">
           <tr><td class="bg">
           
            <!-- Grid  (S) -->
            <table width="100%" class="grid2"> 
            <input type="hidden" id="hide" name="impMst_xpt_imp_cd" value="I" />
            <input type="hidden" id="hide" name="impMst_bl_tp_cd" value="M" />
            <input type="hidden" id="hide" name="impMst_cnt_cd" value="" />
            <input type="hidden" id="hide" name="impMst_loc_cd" value="" />
            <input type="hidden" id="hide" name="impMst_frob_flg" value="" />
            <input type="hidden" id="hide" name="impMst_cstms_div_id" value="" />
            
            <input type="hidden" id="hide" name="impHus_xpt_imp_cd" value="I" />
            <input type="hidden" id="hide" name="impHus_bl_tp_cd" value="H" />
            <input type="hidden" id="hide" name="impHus_cnt_cd" value="" />
            <input type="hidden" id="hide" name="impHus_loc_cd" value="" />
            <input type="hidden" id="hide" name="impHus_frob_flg" value="" />
            <input type="hidden" id="hide" name="impHus_cstms_div_id" value="" />
                
                <tr class="tr2_head">
                    <td width="12%"></td>
                    <td width="43%">Master B/L    </td>
                    <td width="%">House B/L</td>
                </tr>
                                                        
                <tr align="center">
                    <td class="tr2_head2">Shipper    </td>
                    <td align="left">
                    &nbsp;<input type="checkbox" id="chk" name="impMst_shpr_nm_flg" value="" class="trans">Name&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="impMst_shpr_addr_flg" value="" class="trans">Address&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="impMst_shpr_cty_flg" value="" class="trans">City&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="impMst_shpr_ste_flg" value="" class="trans">State&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="impMst_shpr_cnt_flg" value="" class="trans">Country&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="impMst_shpr_zip_flg" value="" class="trans">ZIP&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="impMst_shpr_st_nm_flg" value="" class="trans">Street<br>
                    &nbsp;&nbsp;<input type="checkbox" id="chk" name="impMst_shpr_eori_no_flg" value="" class="trans">EORI&nbsp;&nbsp;
                    &nbsp;&nbsp;<input type="checkbox" id="chk" name="impMst_shpr_phn_flg" value="" class="trans">Tel&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="impMst_shpr_fax_flg" value="" class="trans">Fax&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="impMst_shpr_co_rgst_flg" value="" class="trans">Company Registration No.</td>
                    
                    <td align="left">
                    &nbsp;<input type="checkbox" id="chk" name="impHus_shpr_nm_flg" value="" class="trans">Name&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="impHus_shpr_addr_flg" value="" class="trans">Address&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="impHus_shpr_cty_flg" value="" class="trans">City&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="impHus_shpr_ste_flg" value="" class="trans">State&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="impHus_shpr_cnt_flg" value="" class="trans">Country&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="impHus_shpr_zip_flg" value="" class="trans">ZIP <br>
                    &nbsp;&nbsp;<input type="checkbox" id="chk" name="impHus_shpr_co_rgst_flg" value="" class="trans">Company Registration No.</td>
                </tr>
                                                        
                <tr align="center">
                    <td class="tr2_head2">Consignee</td>
                    <td align="left">
                    &nbsp;<input type="checkbox" id="chk" name="impMst_cnee_nm_flg" value="" class="trans">Name&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="impMst_cnee_addr_flg" value="" class="trans">Address&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="impMst_cnee_cty_flg" value="" class="trans">City&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="impMst_cnee_ste_flg" value="" class="trans">State&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="impMst_cnee_cnt_flg" value="" class="trans">Country&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="impMst_cnee_zip_flg" value="" class="trans">ZIP&nbsp;&nbsp
                    &nbsp;<input type="checkbox" id="chk" name="impMst_cnee_st_nm_flg" value="" class="trans">Street<br>
                    &nbsp;&nbsp;<input type="checkbox" id="chk" name="impMst_cnee_eori_no_flg" value="" class="trans">EORI&nbsp;&nbsp;
                    &nbsp;&nbsp;<input type="checkbox" id="chk" name="impMst_cnee_phn_flg" value="" class="trans">Tel&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="impMst_cnee_fax_flg" value="" class="trans">Fax&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="impMst_cnee_co_rgst_flg" value="" class="trans">Company Registration No.</td>
                    
                    <td align="left">
                    &nbsp;<input type="checkbox" id="chk" name="impHus_cnee_nm_flg" value="" class="trans">Name&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="impHus_cnee_addr_flg" value="" class="trans">Address&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="impHus_cnee_cty_flg" value="" class="trans">City&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="impHus_cnee_ste_flg" value="" class="trans">State&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="impHus_cnee_cnt_flg" value="" class="trans">Country&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="impHus_cnee_zip_flg" value="" class="trans">ZIP <br>
                    &nbsp;&nbsp;<input type="checkbox" id="chk" name="impHus_cnee_co_rgst_flg" value="" class="trans">Company Registration No.</td>
                </tr>
                                                        
                <tr align="center">
                    <td class="tr2_head2">Notify</td>
                    <td align="left">
                    &nbsp;<input type="checkbox" id="chk" name="impMst_ntfy_nm_flg" value="" class="trans">Name&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="impMst_ntfy_addr_flg" value="" class="trans">Address&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="impMst_ntfy_cty_flg" value="" class="trans">City&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="impMst_ntfy_ste_flg" value="" class="trans">State&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="impMst_ntfy_cnt_flg" value="" class="trans">Country&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="impMst_ntfy_zip_flg" value="" class="trans">ZIP&nbsp;&nbsp;
					&nbsp;<input type="checkbox" id="chk" name="impMst_ntfy_st_nm_flg" value="" class="trans">Street<br>
                    &nbsp;&nbsp;<input type="checkbox" id="chk" name="impMst_ntfy_eori_no_flg" value="" class="trans">EORI&nbsp;&nbsp;
                    &nbsp;&nbsp;<input type="checkbox" id="chk" name="impMst_ntfy_phn_flg" value="" class="trans">Tel&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="impMst_ntfy_fax_flg" value="" class="trans">Fax&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="impMst_ntfy_co_rgst_flg" value="" class="trans">Company Registration No.</td>
                    
                    <td align="left">
                    &nbsp;<input type="checkbox" id="chk" name="impHus_ntfy_nm_flg" value="" class="trans">Name&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="impHus_ntfy_addr_flg" value="" class="trans">Address&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="impHus_ntfy_cty_flg" value="" class="trans">City&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="impHus_ntfy_ste_flg" value="" class="trans">State&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="impHus_ntfy_cnt_flg" value="" class="trans">Country&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="impHus_ntfy_zip_flg" value="" class="trans">ZIP <br>
                    &nbsp;&nbsp;<input type="checkbox" id="chk" name="impHus_ntfy_co_rgst_flg" value="" class="trans">Company Registration No.</td>
                </tr>
                                                        
                <tr align="center">
                    <td class="tr2_head2">B/L Main</td>
                    <td align="left">
                    &nbsp;<input type="checkbox" id="chk" name="impMst_pck_flg" value="" class="trans">Package
                    <input type="checkbox" id="chk" name="impMst_wgt_flg" value="" class="trans">Weight&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="impMst_meas_flg" value="" class="trans">Measure&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="impMst_bl_desc_flg" value="" class="trans">Description&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="impMst_bl_mk_flg" value="" class="trans">Mark</td>
                    
                    <td align="left">
                    &nbsp;<input type="checkbox" id="chk" name="impHus_pck_flg" value="" class="trans">Package
                    <input type="checkbox" id="chk" name="impHus_wgt_flg" value="" class="trans">Weight&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="impHus_meas_flg" value="" class="trans">Measure&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="impHus_bl_desc_flg" value="" class="trans"> Description&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="impHus_bl_mk_flg" value="" class="trans">Mark</td>
                </tr>
                                                        
                <tr align="center">
                    <td class="tr2_head2">Container</td>
                    <td align="left">
                    &nbsp;<input type="checkbox" id="chk" name="impMst_cntr_no_flg" value="" class="trans">Container No&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="impMst_seal_no_flg" value="" class="trans">Seal No&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="impMst_cntr_pck_flg" value="" class="trans">Package&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="impMst_cntr_wgt_flg" value="" class="trans">Weight&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="impMst_cntr_meas_flg" value="" class="trans">Measure</td>
                    
                    <td align="left">
                    &nbsp;<input type="checkbox" id="chk" name="impHus_cntr_no_flg" value="" class="trans">Container No&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="impHus_seal_no_flg" value="" class="trans">Seal No&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="impHus_cntr_pck_flg" value="" class="trans">Package&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="impHus_cntr_wgt_flg" value="" class="trans">Weight&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="impHus_cntr_meas_flg" value="" class="trans">Measure</td>
                </tr>
                <tr align="center">
                    <td class="tr2_head2">C/M</td>
                    <td align="left">
                    &nbsp;<input type="checkbox" id="chk" name="impMst_cntr_mf_pck_flg" value="" class="trans">Package
                    <input type="checkbox" id="chk" name="impMst_cntr_mf_wgt_flg" value="" class="trans">Weight&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="impMst_cntr_mf_meas_flg" value="" class="trans"> Measure&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="impMst_cntr_mf_desc_flg" value="" class="trans"> Description&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="impMst_cntr_mf_mk_flg" value="" class="trans">Mark&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="impMst_cntr_mf_cmdt_flg" value="" class="trans">HTS <br>
                    &nbsp;&nbsp;<input type="checkbox" id="chk" name="impMst_cmdt_hs_cd_flg" value="" class="trans">HS&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;<input type="checkbox" id="chk" name="impMst_cntr_mf_ncm_flg" value="" class="trans">NCM</td> 
                    <td align="left">
                    &nbsp;<input type="checkbox" id="chk" name="impHus_cntr_mf_pck_flg" value="" class="trans">Package
                    <input type="checkbox" id="chk" name="impHus_cntr_mf_wgt_flg" value="" class="trans">Weight&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="impHus_cntr_mf_meas_flg" value="" class="trans"> Measure&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="impHus_cntr_mf_desc_flg" value="" class="trans"> Description&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="impHus_cntr_mf_mk_flg" value="" class="trans">Mark&nbsp;&nbsp;&nbsp;
                    &nbsp;<input type="checkbox" id="chk" name="impHus_cntr_mf_cmdt_flg" value="" class="trans">HTS <br>
                    &nbsp;&nbsp;<input type="checkbox" id="chk" name="impHus_cntr_mf_ncm_flg" value="" class="trans">NCM</td> 
                </tr>
                <tr align="center">
                    <td class="tr2_head2">Export/Import Ref #</td>
                    <td align="left">&nbsp;<input type="checkbox" id="chk" name="impMst_xpt_imp_ref_flg7" value="" class="trans">IEC&nbsp;&nbsp;&nbsp; 
                    &nbsp;<input type="checkbox" id="chk" name="impMst_xpt_imp_ref_flg6" value="" class="trans">Tax ID</td> 
                    <td align="left">&nbsp;<input type="checkbox" id="chk" name="impHus_xpt_imp_ref_flg1" value="" class="trans">Manifest File No.</td>
                </tr>
            </table> 
            <!-- Grid (E) -->
        </td></tr>
    </table>
    <!-- Grid BG Box  (S) -->
</div>
<!--TAB Import (E) -->
    
    <!--biz page (S)-->
    <table width="100%" id="mainTable" style="display:none">
        <tr>
            <td width="100%"><script language="javascript">ComSheetObject('sheet1');</script></td>
        </tr>
    </table>
    <!--biz page (E)-->
    <!--biz page (E)-->
    
    <!--Button (S) -->
    <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
           <tr><td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                
            <% if (screenName.indexOf("Q") < 0){ %>
                <td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_New">New</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td class="btn1_line"></td>
                
                <td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_Save">Save</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_Delete">Delete</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
            <% } %>
                
            </tr>
            </table>
        </td></tr>
    </table>
    <!--Button (E) -->
    
    </td></tr>
</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>