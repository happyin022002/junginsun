<%  
/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0272.jsp
 *@FileTitle : Full CNTR Release Order
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.14
 *@LastModifier : 손윤석
 *@LastVersion : 1.0
 * 2009.07.14  손윤석
 * 1.0 Creation
 =========================================================*/
%>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0272Event"%>
<%
  String bl_no = JSPUtil.getNull(request.getParameter("bl_no"));
  String cntr_no = JSPUtil.getNull(request.getParameter("cntr_no"));
  
  EsmBkg0272Event event     = null;
  Exception serverException = null;         //서버에서 발생한 에러
  String strErrMsg = "";                    //에러메세지
  int rowCount     = 0;                     //DB ResultSet 리스트의 건수

  String successFlag = "";
  String codeList    = "";
  String pageRows    = "100";

  String strUsr_id   = "";
  String strUsr_nm   = "";
  String strOfcCd    = "";
  String strCntCd    = "";

  try {
      SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
      strUsr_id = account.getUsr_id();
      strUsr_nm = account.getUsr_nm();
      strOfcCd  = account.getOfc_cd();
      strCntCd  = account.getCnt_cd();


      event = (EsmBkg0272Event)request.getAttribute("Event");
      serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

      if (serverException != null) {
          strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
      }

      // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가.
      GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

  }catch(Exception e) {
      out.println(e.toString());
  }
%>

<html>
<head>
<title>Full CNTR Release Order</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">

    function setupPage()
    {  
      loadPage();
    }

</script>

</head>
<body  onLoad="setupPage();"> 

<form name="form">
<input type="hidden" name="f_cmd" value="">
<input type="hidden" name="in_option" value="VVD">
<input type="hidden" name="pre_bl_no" value="<%=bl_no%>">
<input type="hidden" name="in_checktype" value="">

<input type="hidden" name="p_row" value="">
<input type="hidden" name="p_diff_rmk" value="">
<input type="hidden" name="p_err" value="">
<input type="hidden" name="p_bl_no" value="">
<input type="hidden" name="p_bkg_no" value="">
<input type="hidden" name="p_cntr_no" value="">
<input type="hidden" name="p_cntr_tpsz_cd" value="">
<input type="hidden" name="p_cust_nm" value="">
<input type="hidden" name="p_cust_eml" value="">
<input type="hidden" name="p_yd_cd" value="">
<input type="hidden" name="p_vvd" value="">
<input type="hidden" name="p_pol_cd" value="">
<input type="hidden" name="p_pod_cd" value="">
<input type="hidden" name="p_do_no_yn" value="">
<input type="hidden" name="p_do_no" value="">
<input type="hidden" name="p_do_iss_dt" value="">
<input type="hidden" name="p_fax_no" value="">
<input type="hidden" name="p_bkg_trsp_mod_cd" value="">
<input type="hidden" name="p_cgo_pkup_dt" value="">
<input type="hidden" name="p_cxl_flg" value="">
<input type="hidden" name="p_de_term_cd" value="">
<input type="hidden" name="p_sent_flg" value="">
<input type="hidden" name="p_send_date" value="">
<input type="hidden" name="mailcontent" value="">
<input type="hidden" name="p_pin_no" value="">

<input type="hidden" name="p_yd_nm" value="">
<input type="hidden" name="p_yd_eml" value="">
<input type="hidden" name="p_phn_no" value="">
<input type="hidden" name="p_vsl_nm" value="">
<input type="hidden" name="p_loc_nm" value="">
<input type="hidden" name="ofc_cd" value="<%=strOfcCd%>">
<input type="hidden" name="upd_ofc_flg" value="">

<input type="hidden" name="mailXml" value="">

<%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp"%>


      <!-- Grid BG Box  (S) -->
    
      <table class="search"> 
        <tr>
          <td class="bg">
            <table class="search" border="0" style="width:979;"> 
              <tr class="h23">
                <td width="570">
                  <table class="search_sm" border="0">
                    <tr class="h23">
                      <td width="60"><input type="radio" value="" class="trans" name="rad_vvd">&nbsp;&nbsp;VVD</td>
                      <td width="100"><input type="text" style="width:80;ime-mode:disabled;" caption="VVD" class="input1" value="" name='in_vvd' dataformat="eng"  maxlength="9" required="" fullfill="fullfill"></td>
                      <td width="30">POD</td>
                      <td width="80"><input type="text" style="width:60;ime-mode:disabled;" caption="POD" class="input1" value="" name="in_pod" dataformat="eng"  maxlength="5" required="" fullfill="fullfill"></td>
                      <td width="30">DEL</td>
                      <td width="80"><input type="text" style="width:60;ime-mode:disabled;" class="input" caption="DEL"  value="" name="in_del" dataformat="eng"  maxlength="5"  minlength="2"></td>
                      <td width="100"><input type="radio" value=""class="trans" name="rad_bl">&nbsp;&nbsp;B/L No</td>
                      <td width="105"><input type="text" style="width:105;ime-mode:disabled;" caption="B/L No" class="input" value="<%=bl_no %>" name="in_bl_no" dataformat="eng"  maxlength="13" required="" /></td>
                    </tr>
                  </table>
                </td>
                <td width="40">CNTR</td>
                <td width="120"><input type="text" style="width:90;ime-mode:disabled;" class="input" value="<%=cntr_no %>" name="in_cntr_no" dataformat="eng"  maxlength="14"></td>
                <td width="30">D/O</td>
                <td width="">
                  <select style="width:70;" name="in_do_no">
                    <option value="" selected>All</option>
                    <option value="Y" >Yes</option>
                    <option value="N" >No</option>
                  </select>
                </td>
                <td width="30">Sent</td>
                <td width="">
                  <select style="width:70;" name="sent_flg">
                    <option value="A" selected>All</option>
                    <option value="Y" >Yes</option>
                    <option value="N" >No</option>
                  </select>
                </td>
              </tr>
            </table>
        
            <!--Grid (s)-->
            <table width="100%"  id="mainTable">
              <tr>
                <td width="100%">
                  <script language="javascript">ComSheetObject('sheet1');</script>
                </td>
              </tr>
            </table>
            <table width="100%"  id="mainTable">
              <tr>
                <td width="100%">
                  <script language="javascript">ComSheetObject('sheet2');</script>
                </td>
              </tr>
            </table>
            <!--Grid (E)-->

          </td>
        </tr>
      </table>
      <!-- Grid BG Box  (S) -->
  
      <!--biz page (E)-->
      
      <!--Button (S) -->
      <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
        <tr>
          <td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td class="btn1_line"></td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_DownExcel">Down Excel</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_CNTRMvmt">CNTR MVMT</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_Remark">Remark(s)</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_EMail_TMNL">E-mail for TMNL</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_EMail_CUST">E-mail for CUST</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_EDI">EDI</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_CargoRelease">Cargo Release</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td class="btn1_line"></td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_Print">Print</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
      <!--Button (E) -->
    </td>
  </tr>
</table>
<%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_CLOSE.jsp"%>
</form>
</body>
</html>
