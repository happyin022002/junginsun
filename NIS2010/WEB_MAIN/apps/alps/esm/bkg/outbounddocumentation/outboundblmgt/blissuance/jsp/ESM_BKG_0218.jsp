<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0218.jsp
*@FileTitle : Draft B/L &amp; Waybill (Fax / E-Mail)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.09
*@LastModifier : Ilmin Lee
*@LastVersion : 1.0
* 2009.09.09 Ilmin Lee
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.common.HTMLUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event.EsmBkg0218Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List" %>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %> 
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO" %>
<%
    EsmBkg0218Event  event = null;              //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount     = 0;                       //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id = "";
    String strUsr_nm = "";
	String strOfc_cd = "";
	String strCnt_cd = "";
	String ui_id = "";
	String pgmNo = "";
	String strUserHomerFileSeparator = "";
    Logger log = Logger.getLogger("com.hanjin.apps.OutboundBLMgt.BLDocumentation");
    List<BkgComboVO> bkg_sts_cd = null;
    List<BkgComboVO> bkg_cust_tp_cd = null;
    List<BkgComboVO> fax_sts_cd = null;
    List<BkgComboVO> eml_sts_cd = null;

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		strCnt_cd = account.getCnt_cd();

        event = (EsmBkg0218Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

        bkg_sts_cd = (List<BkgComboVO>) eventResponse.getCustomData("bkg_sts_cd");
        bkg_cust_tp_cd = (List<BkgComboVO>) eventResponse.getCustomData("bkg_cust_tp_cd");
        fax_sts_cd = (List<BkgComboVO>) eventResponse.getCustomData("fax_sts_cd");
        eml_sts_cd = (List<BkgComboVO>) eventResponse.getCustomData("eml_sts_cd");
        ui_id = JSPUtil.getParameter(request,"ui_id"); 
        pgmNo = JSPUtil.getParameter(request,"pgmNo"); 
        
	    String strTemp1 = System.getProperty("user.home");
	    if (strTemp1 != null) {
	    } else {
	    	strTemp1 = "";
	    }
	  	
	    String strTemp2 = System.getProperty("file.separator");
	    if (strTemp2 != null) {
	    } else {
	    	strTemp2 = "";
	    }
	    strUserHomerFileSeparator = strTemp1 + strTemp2;

    } catch(Exception e) {
        out.println(e.toString());
    }
%>
<html>
<head>
<title>Draft B/L &amp; Waybill (Fax / E-Mail)</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>
<script language="javascript">
  var pgmNo="<%=pgmNo%>";
  function setupPage(){
    var errMessage = "<%=strErrMsg%>";
    if (errMessage.length >= 1) {
      ComShowMessage(errMessage);
    } // end if

    loadPage();

  }
</script>
</head>

<body onLoad="setupPage()">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="strUsr_id" value="<%=strUsr_id%>">
<input type="hidden" name="strOfc_cd" value="<%=strOfc_cd%>">
<input type="hidden" name="strCnt_cd" value="<%=strCnt_cd%>">
<input type="hidden" name="ui_id"     value="<%=ui_id%>">
<input type="hidden" name="pgm_no"     value="<%=pgmNo%>">
<!-- 조회조건 -->
<input type="hidden" name="bl_tp_cd">
<input type="hidden" name="vsl_cd">
<input type="hidden" name="skd_voy_no">
<input type="hidden" name="skd_dir_cd">
<input type="hidden" name="pol_cd">
<input type="hidden" name="pod_cd">
<input type="hidden" name="bkg_ofc_cd">
<input type="hidden" name="doc_usr_id">
<input type="hidden" name="bkg_sts_cd">
<input type="hidden" name="bkg_cust_tp_cd">
<input type="hidden" name="cust_cnt_cd">
<input type="hidden" name="cust_seq">
<input type="hidden" name="cust_nm">
<input type="hidden" name="obl_iss_ofc_cd">
<input type="hidden" name="obl_iss_usr_id">
<input type="hidden" name="ob_sls_ofc_cd">
<input type="hidden" name="ob_srep_cd">
<input type="hidden" name="bkg_no">
<input type="hidden" name="bl_no">
<input type="hidden" name="bl_obrd_dt_from">
<input type="hidden" name="bl_obrd_dt_to">
<input type="hidden" name="obl_iss_dt_from">
<input type="hidden" name="obl_iss_dt_to">
<input type="hidden" name="fax_proc_sts_cd">
<input type="hidden" name="eml_proc_sts_cd">
<!--appending by tab2-->
<input type="hidden" name="sc_no">
<input type="hidden" name="rfa_no">
<input type="hidden" name="eta_dt_from">
<input type="hidden" name="eta_dt_to">
<!--appending by remark popup-->
<input type="hidden" name="inter_rmk">

<input type="hidden" name="edt_ntc_knd_cd">
<input type="hidden" name="edt_bkg_no_list">
<input type="hidden" name="edt_to_eml">
<input type="hidden" name="edt_cc_eml">
<input type="hidden" name="edt_from_eml">
<input type="hidden" name="edt_subject">
<input type="hidden" name="edt_contents">
<input type="hidden" name="no_sr_flg">
<input type="hidden" name="pol_yd_cd">
<input type="hidden" name="un_pickup_flg">

<%@include file="/apps/alps/esm/bkg/bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp" %>
    <!--Page Title, Historical (E)-->

    <!-- Tab (S) Hire,  Other Exp,  Payment Term,  Redelivery,  CP file up, Certi File up,-->
    <table class="tab" border="0" cellpadding="0" cellspacing="0" width="100%">
        <tr><td width="100%"><script language="javascript">ComTabObject('tab1')</script></td></tr>
    </table>
    <!-- Tab  (E) -->

    <!--TAB Outbound(S) -->
    <div id="tabLayer" style="display:inline">

    <!--biz page (S)-->
    <table class="search">
      <tr><td class="bg">
      <!--  biz_1  (S) -->
      <table class="search" border="0" style="width:979;">
        <tr class="h23">
          <td width="172">
            <table class="search_sm2" border="0" width="165">
              <tr class="h23">
                <td>Type</td>
                <td class="stm">
                  <input type="radio" id="t1_rdo_bl_tp_cd_1" name="t1_rdo_bl_tp_cd" value="D" class="trans" checked><label for="t1_rdo_bl_tp_cd_1">Draft</label>&nbsp;<input
                  	     type="radio" id="t1_rdo_bl_tp_cd_2" name="t1_rdo_bl_tp_cd" value="W" class="trans"><label for="t1_rdo_bl_tp_cd_2">Waybill</label>
                </td>
              </tr>
            </table>
          </td>
          <td width="30">VVD</td>
          <td width="95"><input type="text" name="t1_txt_vvd" style="width:86" value="" class="input1" caption="VVD" minlength="9" maxlength="9" dataformat="eng"></td>
          <td width="112" colspan=2>POL&nbsp;
          <input type="text" name="t1_txt_pol" style="width:50" value="" class="input1" caption="POL" minlength="2" maxlength="5" dataformat="engupnum">
          				 <input type="text" style="width:25" value="" class="input" name="t1_txt_pol_yd_cd" maxlength='2' dataformat='engupnum' style="ime-mode:disabled">
          </td>
          <td width="65">POD</td>
          <td width="65"><input type="text" name="t1_txt_pod" style="width:55" value="" class="input" caption="POD" minlength="2" maxlength="5" dataformat="engupnum"></td>
          <td width="60">BKG OFC</td>
          <td width="60"><input type="text" name="t1_txt_bkg_ofc" style="width:50" value="" class="input" caption="Booking Office" maxlength="5" dataformat="engup"></td>
          <td width="60">BKG Staff</td>
          <td width="70"><input type="text" name="t1_txt_doc_usr_id" style="width:60" value="" class="input" caption="Booking Staff" maxlength="20" dataformat="engnum"></td>
          <td width="50">S/C No.</td>
          <td><input type="text" name="t1_txt_sc_no" style="width:90;" maxlength="11" dataformat="eng" class="input" value=""></td>
        </tr>
        <tr class="h23">
          <td colspan="3">Customer
          <%=HTMLUtil.getComboString("t1_slt_bkg_cust_tp_cd", "width:90;", "", "","","All", bkg_cust_tp_cd)%>
          <input type="text" name="t1_txt_cust_seq1" class="input" caption="Customer Nation" maxlength="2" dataformat="engup" style="width:22;" value=""
          ><input type="text" name="t1_txt_cust_seq2" class="input" caption="Customer Seq" maxlength="6" dataformat="num" style="width:48;margin-left:1;" value="">
          <input type="text" name="t1_txt_cust_nm" class="input" caption="Customer Name" maxlength="30" dataformat="eng" style="width:60;" value=""></td>
          <td>B/L OFC</td>
          <td><input type="text" name="t1_txt_obl_iss_ofc_cd" style="width:50" value="" class="input" caption="B/L Office" maxlength="6" dataformat="engup"></td>
          <td>B/L Staff</td>
          <td><input type="text" name="t1_txt_obl_iss_usr_id" style="width:55" value="" class="input" caption="B/L Staff" maxlength="10" dataformat="engnum"></td>
          <td>Sales OFC</td>
          <td><input type="text" name="t1_txt_ob_sls_ofc_cd" style="width:50" value="" class="input" caption="Sales Office" maxlength="6" dataformat="engup"></td>
          <td>Sales Rep.</td>
          <td><input type="text" name="t1_txt_ob_srep_cd" style="width:60" value="" class="input" caption="Sales Rep." maxlength="5" dataformat="eng"></td>
          <td>RFA No.</td>
		  <td><input type="text" name="t1_txt_rfa_no" style="width:90;" maxlength="11" dataformat="eng" class="input" value=""></td>
        </tr>
      </table>
      <table class="height_2"><tr><td></td></tr></table>
      <table class="search" border="0" style="width:979;">
        <tr class="h23">
          <td width="300">
            <table class="search_sm2" border="0" style="width:290;">
              <tr class="h23">
                <td width="">
                  <input type="radio" id="t1_rdo_bkg_bl_1" name="t1_rdo_bkg_bl" value="BKG" class="trans"><label for="t1_rdo_bkg_bl_1">BKG No.</label>
                  <input type="radio" id="t1_rdo_bkg_bl_2" name="t1_rdo_bkg_bl" value="BL" class="trans" checked><label for="t1_rdo_bkg_bl_2">B/L No.</label>&nbsp;
                  <input type="text" id="t1_txt_bkg_no" name="t1_txt_bkg_no" style="width:102" value="" class="input" caption="BKG No." minlength="11" dataformat="eng" style="display:none"
                  ><input type="text" id="t1_txt_bl_no" name="t1_txt_bl_no" style="width:102" value="" class="input" caption="B/L No." minlength="12" dataformat="eng">
                	&nbsp;<img onClick="openAddPaste('bkg_no')" class="cursor" src="img/button/btng_plus.gif" width="19" height="20" border="0" align="absmiddle" name="">
                </td>
              </tr>
            </table>
          </td>
          <td width="390">
            <table class="search_sm2" border="0" style="width:380;">
              <tr class="h23">
                <td width="180">
                  <input type="radio" id="t1_rdo_date_flg_1" name="t1_rdo_date_flg" value="OnBoard" class="trans" checked><label for="t1_rdo_date_flg_1">On Board</label>&nbsp;&nbsp;
                  <input type="radio" id="t1_rdo_date_flg_2" name="t1_rdo_date_flg" value="Issue" class="trans"><label for="t1_rdo_date_flg_2">B/L Issue</label>
                </td>
                <td width="">
                  <input type="text" name="t1_txt_date_from" style="width:73" value="" class="input" caption="From Date" maxlength="10" dataformat="ymd">&nbsp;~&nbsp;<input type="text" name="t1_txt_date_to" style="width:73" value="" class="input" caption="To Date" maxlength="10" dataformat="ymd">
                  <img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="t1_btn_calendar">
                </td>
              </tr>
            </table>
          </td>
          <td width="57">Fax Sent</td>
          <td width="80" class="sm"><%=HTMLUtil.getComboString("t1_slt_fax_proc_sts_cd", "width:68;", "", "","","All", fax_sts_cd)%></td>
          <td width="73">E-mail Sent</td>
          <td><%=HTMLUtil.getComboString("t1_slt_eml_proc_sts_cd", "width:72;", "", "","","All", eml_sts_cd)%></td>
        </tr>
      </table>
      <table class="height_2"><tr><td></td></tr></table>
      <table class="search" border="0" style="width:979;">
        <tr class="h23">
        <td width="45">Status</td>
        <td width="60"><%=HTMLUtil.getComboString("t1_slt_bkg_sts_cd", "width:50;", "", "","","All", bkg_sts_cd)%></td>
          <td width="640">
		      <table class="search_sm2" border="0" width="630">
		        <tr class="h23">
		          <td width="98">Freight Option</td>
		          <td class="stm" width="">
		            <input type="checkbox" id="t1_chk_opt1" name="t1_chk_opt1" value="Y" class="trans"><label for="t1_chk_opt1">All</label>&nbsp;&nbsp;
		            <input type="checkbox" id="t1_chk_opt2" name="t1_chk_opt2" value="Y" class="trans"><label for="t1_chk_opt2">Collect</label>&nbsp;&nbsp;
		            <input type="checkbox" id="t1_chk_opt3" name="t1_chk_opt3" value="Y" class="trans"><label for="t1_chk_opt3">Prepaid</label>&nbsp;&nbsp;
		            <input type="checkbox" id="t1_chk_opt4" name="t1_chk_opt4" value="Y" class="trans"><label for="t1_chk_opt4">No Charge</label>&nbsp;&nbsp;
		            <input type="checkbox" id="t1_chk_opt5" name="t1_chk_opt5" value="Y" class="trans"><label for="t1_chk_opt5">Freight As Arranged</label>&nbsp;&nbsp;
		          	<input type="checkbox" id="t1_chk_opt_hidden" name="t1_chk_opt_hidden" value="" class="trans">&nbsp;<label for="t1_chk_opt_hidden">Hidden Option</label></td>
		        </tr>
		      </table>
		     </td>
		     <td width="275">
		     	<table>
		     	<tr class="h23">
		          <td><input type="checkbox" id="t1_sr_opt" name="t1_sr_opt" value="Y" class="trans">No S/R</td>
		          <td><input type="checkbox" id="t1_chk_doc_rmd" name="t1_chk_doc_rmd" value="Y" class="trans">Doc cut-off Reminder</td>
		        </tr>
		        <tr class="h23">
		          <td><input type="checkbox" id="t1_un_pickup_flg" name="t1_un_pickup_flg" value="Y" class="trans">Un-Pickup</td>	
		        </tr>  
		        </table> 
	        </td> 
		    </tr>
		   </table>
      <!--  biz_1  (E) -->
      </td></tr>
    </table>

    <table class="height_8"><tr><td></td></tr></table>

    <!-- Grid BG Box  (S) -->
    <table class="search">
      <tr><td class="bg">

      <!--Grid (S)-->
      <table width="100%" class="search"  id="mainTable">
          <tr><td width="100%"><script language="javascript">ComSheetObject('t1sheet1');</script></td></tr>
      </table>
      <!--Grid (E)-->
      <table class="height_8"><tr><td></td></tr></table>
      <table border="0" style="width:979; background-color:white;" class="grid2">
        <tr class="h23">
          <td width="40" class="tr2_head"><b>Fax</b></td>
          <td width="70" class="tr2_head2">B/L Total</td>
          <td width="70"><input type="text" name="faxBlTotal1" style="width:100%;text-align:right" class="noinput" value="" readOnly></td>
          <td width="60" class="tr2_head2">Fax Total</td>
          <td width="70"><input type="text" name="faxTotal1" style="width:100%;text-align:right" class="noinput" value="" readOnly></td>
          <td width="50" class="tr2_head2">Success</td>
          <td width="70"><input type="text" name="faxSuccess1" style="width:100%;text-align:right" class="noinput" value="" readOnly></td>
          <td width="50" class="tr2_head2">Sending</td>
          <td width="70"><input type="text" name="faxSending1" style="width:100%;text-align:right" class="noinput" value="" readOnly></td>
          <td width="50" class="tr2_head2">Un-sent</td>
          <td width="0"><input type="text" name="faxUnSent1" style="width:100%;text-align:right" class="noinput" value="" readOnly></td>
        </tr>
        <tr class="h23">
          <td class="tr2_head"><b>E-mail</b></td>
          <td class="tr2_head2">B/L Total</td>
          <td><input type="text" name="emlBlTotal1" style="width:100%;text-align:right" class="noinput" value="" readOnly></td>
          <td class="tr2_head2">E-Mail Total</td>
          <td><input type="text" name="emlTotal1" style="width:100%;text-align:right" class="noinput" value="" readOnly></td>
          <td class="tr2_head2">Success</td>
          <td><input type="text" name="emlSuccess1" style="width:100%;text-align:right" class="noinput" value="" readOnly></td>
          <td class="tr2_head2">Sending</td>
          <td><input type="text" name="emlSending1" style="width:100%;text-align:right" class="noinput" value="" readOnly></td>
          <td class="tr2_head2">Un-sent</td>
          <td><input type="text" name="emlUnSent1" style="width:100%;text-align:right" class="noinput" value="" readOnly></td>
        </tr>
      </table>

       <!--  Button_Sub (S) -->
      <table width="100%" class="button" border="0" style="width:1035; align:left">
      <tr><td class="btn2_bg">
      <table border="0" cellpadding="0" cellspacing="0"><tr>
        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
        <tr><td class="btn2_left"></td>
        <td class="btn2" name="btn_print_t1sht1">Print</td>
        <td class="btn2_right"></td>
        </tr>
        </table></td>
        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
        <tr><td class="btn2_left"></td>
        <td class="btn2" name="btn_preview_t1sht1">Preview</td>
        <td class="btn2_right"></td>
        </tr>
        </table></td>
        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
        <tr><td class="btn2_left"></td>
		<%
			//2015.10.13 BL Copy Send Fax 전송 기능 삭제
	        if(!"ESM_BKG_0218_02".equals(pgmNo)){
		%>	        	
        <td class="btn2" name="btn_faxemail_t1sht1">Edit Fax/E-mail</td>
		<%
			}else{
		%>
		<td class="btn2" name="btn_faxemail_t1sht1">Edit E-mail</td>
		<%
			}
		%>        
        <td class="btn2_right"></td>
        </tr>
        </table></td>
        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
        <tr><td class="btn2_left"></td>
        <td class="btn2" name="btn_assign_t1sht1">Assign BKG Agent E-mail</td>
        <td class="btn2_right"></td>
        </tr>
        </table></td>
        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
        <tr><td class="btn2_left"></td>
        <td class="btn2" name="btn_remark_t1sht1">Remark(s)</td>
        <td class="btn2_right"></td>
        </tr>
        </table></td>
        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
        <tr><td class="btn2_left"></td>
        <td class="btn2" name="btn_manifest_t1sht1">Manifest(US)</td>
        <td class="btn2_right"></td>
        </tr>
        </table></td>
        <%
			//2015.10.13 BL Copy Send Fax 전송 기능 삭제
	        if(!"ESM_BKG_0218_02".equals(pgmNo)){
	    %>  
        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
        <tr id="btn_Fax1"><td class="btn2_left"></td>
        <td class="btn2" name="btn_fax_t1sht1">Fax</td>
        <td class="btn2_right"></td>
        </tr>
        </table></td>
        <%
	        }
        %>
        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
        <tr><td class="btn2_left"></td>
        <td class="btn2" name="btn_email_t1sht1">E-mail</td>
        <td class="btn2_right"></td>
        </tr>
        </table></td>
        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
        <tr><td class="btn2_left"></td>
        <td class="btn2" name="btn_groupemail_t1sht1">Group E-mail</td>
        <td class="btn2_right"></td>
        </tr>
        </table></td>
		<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
		<tr><td class="btn2_left"></td>
		<td class="btn2" name="btn_EmailEdit_t1sht1">E-mail (Edit)</td>
		<td class="btn2_right"></td> 
		</tr>
		</table></td>
		<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
		<tr><td class="btn2_left"></td>
		<td class="btn2" name="btn_emailSR_t1sht1">E-mail (S/R)</td>
		<td class="btn2_right"></td>
		</tr>
		</table></td>
		<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
		<tr><td class="btn2_left"></td>
		<td class="btn2" name="btn_emailEQ_t1sht1">E-mail (E/Q)</td>
		<td class="btn2_right"></td>
		</tr>
		</table></td>
		</tr>
		</table></td>
      </table>
      </td></tr>
      </table>
      <!-- Button_Sub (E) -->

    </td></tr>
    </table>
    <!-- Grid BG Box  (S) -->
    <!--biz page (E)-->
    </div>
    <!--TAB Outbound(E) -->

    <!--TAB Inbound(S) -->
    <div id="tabLayer" style="display:none">

    <!--biz page (S)-->
    <table class="search">
      <tr><td class="bg">
      <!--  biz_1  (S) -->
      <table class="search" border="0" style="width:979;">
        <tr class="h23">
          <td width="177">
            <table class="search_sm2" border="0" width="170">
              <tr class="h23">
                <td>Type</td>
                <td class="stm">
                  <input type="radio" id="t2_rdo_bl_tp_cd_1" name="t2_rdo_bl_tp_cd" value="D" class="trans" checked><label for="t2_rdo_bl_tp_cd_1">N/N Copy</label><input
                         type="radio" id="t2_rdo_bl_tp_cd_2" name="t2_rdo_bl_tp_cd" value="W" class="trans"><label for="t2_rdo_bl_tp_cd_2">Waybill</label>
                </td>
              </tr>
            </table>
          </td>
          <td width="60">ETA Date</td>
          <td width="200">
            <input type="text" name="t2_txt_date_from" style="width:73" value="2008-10-10" class="input1" caption="ETA From Date" maxlength="10" dataformat="ymd"
            >~<input type="text" name="t2_txt_date_to" style="width:73" value="2008-10-10" class="input1" caption="ETA To Date" maxlength="10" dataformat="ymd">
            <img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="t2_btn_calendar">
          </td>
          <td width="34">VVD</td>
          <td width="103"><input type="text" name="t2_txt_vvd" style="width:85" value="HJPO0009E" class="input" caption="VVD" minlength="9" maxlength="9" dataformat="eng"></td>
          <td width="30">POD</td>
          <td width="93"><input type="text" name="t2_txt_pod" style="width:70" value="KRPUS" class="input" caption="POD" minlength="2" maxlength="5" dataformat="engupnum"></td>
          <td width="30">POL</td>
          <td><input type="text" name="t2_txt_pol" style="width:70" value="BEANR" class="input" caption="POL" minlength="2" maxlength="5" dataformat="engupnum"></td>
          <td class="stm" width="200">&nbsp;&nbsp;
          <input type="checkbox" id="cgo_chk_opt1" name="cgo_chk_opt1" value="F" class="trans">&nbsp;<label for="cgo_chk_opt1">Full</label>&nbsp;&nbsp;
          <input type="checkbox" id="cgo_chk_opt2" name="cgo_chk_opt2" value="P" class="trans">&nbsp;<label for="cgo_chk_opt3">Empty</label></td>
        </tr>
      </table>
      <table class="search" border="0" style="width:1010;">
        <tr class="h23">
          <td width="57">S/C No.</td>
          <td width="118"><input type="text" name="t2_txt_sc_no" caption="S/C No." maxlength="20" dataformat="eng" style="width:108;" class="input" value="AEN001"></td>
          <td width="64">Customer</td>
          <td width="242">
          <%=HTMLUtil.getComboString("t2_slt_bkg_cust_tp_cd", "width:90;", "", "","","All", bkg_cust_tp_cd)%>
          <input type="text" name="t2_txt_cust_seq1" class="input" caption="Customer Nation" maxlength="2" dataformat="engup" style="width:22;" value=""
          ><input type="text" name="t2_txt_cust_seq2" class="input" caption="Customer Seq" maxlength="6" dataformat="num" style="width:48;margin-left:1;" value="">
          <input type="text" name="t2_txt_cust_nm" class="input" caption="Customer Name" maxlength="30" dataformat="eng" style="width:60;" value=""></td>
          <td width="50">B/L No.</td>
          <td width="100"><input type="text" name="t2_txt_bl_no" style="width:95" class="input" caption="B/L No." minlength="12" maxlength="12" dataformat="eng"></td>
          <td width="176">
            <input type="radio" id="t2_rdo_date_flg_1" name="t2_rdo_date_flg" value="OnBoard" class="trans" checked><label for="t2_rdo_date_flg_1">On Board</label>&nbsp;&nbsp;
            <input type="radio" id="t2_rdo_date_flg_2" name="t2_rdo_date_flg" value="Issue" class="trans"><label for="t2_rdo_date_flg_2">B/L Issue</label>
          </td>
          <td>
            <input type="text" name="t2_txt_date_from2" style="width:72" value="2008-10-10" class="input" caption="From Date" maxlength="10" dataformat="ymd">~<input
                type="text" name="t2_txt_date_to2" style="width:72" value="2008-10-10" class="input" caption="To Date" maxlength="10" dataformat="ymd">
            <img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="t2_btn_calendar2">
          </td>
        </tr>
      </table>
      <table class="search" border="0" width="979">
        <tr class="h23">
          <td width="713">
            <table class="search_sm2" border="0" width="690">
              <tr class="h23">
                <td width="98">Freight Option</td>
                <td class="stm" width="">
                  <input type="checkbox" id="t2_chk_opt1" name="t2_chk_opt1" value="Y" class="trans"><label for="t2_chk_opt1">All</label>&nbsp;&nbsp;&nbsp;
                  <input type="checkbox" id="t2_chk_opt2" name="t2_chk_opt2" value="Y" class="trans"><label for="t2_chk_opt2">Collect</label>&nbsp;&nbsp;&nbsp;
                  <input type="checkbox" id="t2_chk_opt3" name="t2_chk_opt3" value="Y" class="trans"><label for="t2_chk_opt3">Prepaid</label>&nbsp;&nbsp;&nbsp;
                  <input type="checkbox" id="t2_chk_opt4" name="t2_chk_opt4" value="Y" class="trans"><label for="t2_chk_opt4">No Charge</label>&nbsp;&nbsp;&nbsp;
                  <input type="checkbox" id="t2_chk_opt5" name="t2_chk_opt5" value="Y" class="trans"><label for="t2_chk_opt5">Freight As Arranged&nbsp;&nbsp;&nbsp;
                  <input type="checkbox" id="t2_chk_opt_hidden" name="t2_chk_opt_hidden" value="" class="trans">&nbsp;<label for="t2_chk_opt_hidden">Hidden Option</label></td>
              </tr>
            </table>
          </td>
          <td width="59">Fax Sent</td>
          <td width="83" class="sm"><%=HTMLUtil.getComboString("t2_slt_fax_proc_sts_cd", "width:68;", "", "","","All", fax_sts_cd)%></td>
          <td width="80">E-mail Sent</td>
          <td><%=HTMLUtil.getComboString("t2_slt_eml_proc_sts_cd", "width:68;", "", "","","All", eml_sts_cd)%></td>
        </tr>
      </table>
      <!--  biz_1   (E) -->
      </td></tr>
    </table>

    <table class="height_8"><tr><td></td></tr></table>

    <!-- Grid BG Box  (S) -->
    <table class="search">
      <tr><td class="bg">

      <!--Grid (S)-->
      <table width="100%" class="search" id="mainTable">
          <tr><td width="100%"><script language="javascript">ComSheetObject('t2sheet1');</script></td></tr>
      </table>
      <!--Grid (E)-->

      <table class="height_8"><tr><td></td></tr></table>
      <table border="0" style="width:979; background-color:white;" class="grid2">
        <tr class="h23">
          <td width="40" class="tr2_head"><b>Fax</b></td>
          <td width="70" class="tr2_head2">B/L Total</td>
          <td width="70"><input type="text" name="faxBlTotal2" style="width:100%;text-align:right" class="noinput" value="" readOnly></td>
          <td width="60" class="tr2_head2">Fax Total</td>
          <td width="70" align="right"><input type="text" name="faxTotal2" style="width:100%;text-align:right" class="noinput" value="" readOnly></td>
          <td width="50" class="tr2_head2">Success</td>
          <td width="70" align="right"><input type="text" name="faxSuccess2" style="width:100%;text-align:right" class="noinput" value="" readOnly></td>
          <td width="50" class="tr2_head2">Sending</td>
          <td width="70" align="right"><input type="text" name="faxSending2" style="width:100%;text-align:right" class="noinput" value="" readOnly></td>
          <td width="50" class="tr2_head2">Un-sent</td>
          <td><input type="text" name="faxUnSent2" style="width:100%;text-align:right" class="noinput" value="" readOnly></td>
        </tr>
        <tr class="h23">
          <td width="40" class="tr2_head"><b>E-mail</b></td>
          <td class="tr2_head2">B/L Total</td>
          <td><input type="text" name="emlBlTotal2" style="width:100%;text-align:right" class="noinput" value="" readOnly></td>
          <td class="tr2_head2">E-mail Total</td>
          <td><input type="text" name="emlTotal2" style="width:100%;text-align:right" class="noinput" value="" readOnly></td>
          <td class="tr2_head2">Success</td>
          <td><input type="text" name="emlSuccess2" style="width:100%;text-align:right" class="noinput" value="" readOnly></td>
          <td class="tr2_head2">Sending</td>
          <td ><input type="text" name="emlSending2" style="width:100%;text-align:right" class="noinput" value="" readOnly></td>
          <td class="tr2_head2">Un-sent</td>
          <td><input type="text" name="emlUnSent2" style="width:100%;text-align:right" class="noinput" value="" readOnly></td>
        </tr>
      </table>

      <!--  Button_Sub (S) -->
      <table width="100%" class="button" border="0">
        <tr><td class="btn2_bg">
        <table border="0" cellpadding="0" cellspacing="0"><tr>
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
			<tr><td class="btn2_left"></td>
			<td class="btn2" name="btn_print_t2sht1">Print</td>
			<td class="btn2_right"></td>
			</tr>
			</table></td>
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
			<tr><td class="btn2_left"></td>
			<td class="btn2" name="btn_preview_t2sht1">Preview</td>
			<td class="btn2_right"></td>
			</tr>
			</table></td>
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
			<tr><td class="btn2_left"></td>
			<%
				//2015.10.13 BL Copy Send Fax 전송 기능 삭제
				if(!"ESM_BKG_0218_02".equals(pgmNo)){
			%>
			<td class="btn2" name="btn_faxemail_t2sht1">Edit Fax/E-mail</td>
			<%
				}else{
			%>
			<td class="btn2" name="btn_faxemail_t2sht1">Edit E-mail</td>
			<%
				}
			%>
			<td class="btn2_right"></td>
			</tr>
			</table></td>
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
			<tr><td class="btn2_left"></td>
			<td class="btn2" name="btn_remark_t2sht1">Remark(s)</td>
			<td class="btn2_right"></td>
			</tr>
			</table></td>
			<%
			//2015.10.13 BL Copy Send Fax 전송 기능 삭제
	        if(!"ESM_BKG_0218_02".equals(pgmNo)){
	        %>        
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
			<tr id="btn_Fax2"><td class="btn2_left"></td>
			<td class="btn2" name="btn_fax_t2sht1">Fax</td>
			<td class="btn2_right"></td>
			</tr>
			</table></td>
			<%
	        }
			%>
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
			<tr><td class="btn2_left"></td>
			<td class="btn2" name="btn_email_t2sht1">E-mail</td>
			<td class="btn2_right"></td>
			</tr>
			</table></td>
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
			<tr><td class="btn2_left"></td>
			<td class="btn2" name="btn_groupemail_t2sht1">Group E-mail</td>
			<td class="btn2_right"></td>
			</tr>
			</table></td>
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
			<tr><td class="btn2_left"></td>
			<td class="btn2" name="btn_EmailEdit_t2sht1">E-mail (Edit)</td>
			<td class="btn2_right"></td>
			</tr>
			</table></td>
        </table>
        </td></tr>
      </table>
      <!-- Button_Sub (E) -->

      </td></tr>
    </table>
    <!-- Grid BG Box  (S) -->
    <!--biz page (E)-->

  </div>

	<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="font:15px;position:absolute;left:10px;"> 
		<tr><td>If you want to receive email copy, please go to “Setup -> Client Default” and select “Receiving mail copy option”</td></tr>
	</table><br>

  <!--Button (S) -->
  <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
    <tr>
      <td class="btn1_bg">
        <table border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
              <tr><td class="btn1_left"></td>
              <td class="btn1" id="btn_retrieve" name="btn_retrieve">Retrieve</td>
              <td class="btn1_right"></td>
              </tr>
            </table></td>
            <td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
              <tr><td class="btn1_left"></td>
              <td class="btn1" name="btn_new">New</td>
              <td class="btn1_right"></td>
              </tr>
            </table></td>
            <td class="btn1_line"></td>
            <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
              <tr><td class="btn1_left"></td>
              <td class="btn1" name="btn_down_excel">Down Excel</td>
              <td class="btn1_right"></td>
              </tr>
            </table></td>
          </tr>
        </table>
      </td>
    </tr>
  </table>
  <!--Button (E) -->
  <table width="100%"  id="rdTable">
    <tr><td width="100%"><script language="javascript">comRdObject('Rd');</script></td></tr>
  </table>

  </td></tr>
</table>

<%@include file="/apps/alps/esm/bkg/bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_CLOSE.jsp" %>

<input type="hidden" name="com_mrdPath">
<input type="hidden" name="com_mrdArguments">
<input type="hidden" name="com_mrdSaveDialogDir" value="<%=strUserHomerFileSeparator%>">
<input type="hidden" name="com_mrdSaveDialogFileName">
<input type="hidden" name="com_mrdSaveDialogFileExt" value="pdf">
<input type="hidden" name="com_mrdSaveDialogFileExtLimit" value="xls@pdf@bmp@tif">
<input type="hidden" name="com_mrdTitle">
<input type="hidden" name="com_mrdDisableToolbar" value="3">
<input type="hidden" name="com_mrdBodyTitle">
<input type="hidden" name="com_zoomIn">
<input type="hidden" name="com_isBatch" value="N">
</form>

<!--form name="form2" method="post">
  <input type="hidden" name="bl_tp_cd">
  <input type="hidden" name="bkg_no">
  <input type="hidden" name="bl_no">
  <input type="hidden" name="fax_no">
  <input type="hidden" name="email">
  <input type="hidden" name="form_remark">
  <input type="hidden" name="form_level">
  <input type="hidden" name="form_hiddeData">
</form-->

<form name="form3" method="post">
  <input type="hidden" name="pop_mode">
  <input type="hidden" name="display">
  <input type="hidden" name="func">
  <input type="hidden" name="row">
  <input type="hidden" name="col">
  <input type="hidden" name="sheetIdx">
  <input type="hidden" name="bkg_no">
  <input type="hidden" name="bl_no">
  <input type="hidden" name="ok_hidden">
  <input type="hidden" name="send_hidden">
  <input type="hidden" name="form_type">
  <input type="hidden" name="form_dataOnly">
  <input type="hidden" name="form_manifest">
  <input type="hidden" name="form_hiddeData">
  <input type="hidden" name="form_mainOnly">
  <input type="hidden" name="form_level">
  <input type="hidden" name="form_remark">
  <input type="hidden" name="form_Cntr">
  <input type="hidden" name="form_CorrNo">
  <input type="hidden" name="form_his_cntr">
  <input type="hidden" name="form_his_bkg">
  <input type="hidden" name="form_his_mkd">
  <input type="hidden" name="form_his_xpt">
  <input type="hidden" name="form_his_bl">
  <input type="hidden" name="rp">
  <input type="hidden" name="ntc_knd_cd">
   <%
	//2015.10.13 BL Copy Send Fax 전송 기능 삭제
  if("ESM_BKG_0218_02".equals(pgmNo)){
  %>  
  <input type="hidden" name="fax_email"   value="IBSENDEMAIL">
  <%
  }else{
  %>
  <input type="hidden" name="fax_email"   value="">
  <%
  }
  %>
</form>

<form name="form4" method="post">
  <input type="hidden" name="f_cmd">
  <input type="hidden" name="bkg_no">
</form>

</body>
</html>
