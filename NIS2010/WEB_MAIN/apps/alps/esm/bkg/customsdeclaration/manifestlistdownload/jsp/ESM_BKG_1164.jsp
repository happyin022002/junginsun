<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1164.jsp
*@FileTitle : Feeder BL Print(Russia)
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.08
*@LastModifier : WONJOO CHO
*@LastVersion : 1.0
* 2013.07.08 WONJOO CHO
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.russia.event.EsmBkg1164Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List" %>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO" %>
<%
    EsmBkg1164Event  event = null;              //PDTO(Data Transfer Object including Parameters)
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
	Logger log = Logger.getLogger("com.hanjin.apps.esm.bkg.customsdeclaration.manifestListDownload.russia");
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

        event = (EsmBkg1164Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
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
<title>Feeder BL Print</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>
<script language="javascript">
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




	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
	<!--Page Title, Historical (E)-->



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
                  <input type="radio" id="t1_rdo_bl_tp_cd_1" name="tp_cd" value="F" class="trans" checked><label for="t1_rdo_bl_tp_cd_1">Full</label>&nbsp;<input
                  	     type="radio" id="t1_rdo_bl_tp_cd_2" name="tp_cd" value="P" class="trans"><label for="t1_rdo_bl_tp_cd_2">Empty</label>
                </td>
              </tr>
            </table>
          </td>
          <td width="30">VVD</td>
          <td width="100"><input type="text" name="t1_txt_vvd" style="width:86" value="" class="input1" caption="VVD" minlength="9" maxlength="9" dataformat="eng"></td>
          <td width="65">V.POL</td>
          <td width="70"><input type="text" name="t1_txt_pol" style="width:50" value="" class="input1" caption="POL" minlength="2" maxlength="5" dataformat="engupnum"></td>
          <td width="65">V.POD</td>
          <td width="77"><input type="text" name="t1_txt_pod" style="width:55" value="" class="input1" caption="POD" minlength="2" maxlength="5" dataformat="engupnum"></td>
          
          <td width="400">
            <table class="search_sm2" border="0" style="width:390;">
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
          
        </tr>
         </table>
        <table class="search" border="0" style="width:979;">
        <tr class="h23">
          

          <td>BKG No.</td>
          <td><input type="text" name="t1_txt_bkg_no" style="width:102" value="" class="input" caption="BKG No." minlength="11"  maxlength="13" dataformat="eng" ></td> 
          <td>B/L No.</td>
          <td><input type="text" name="t1_txt_bl_no" style="width:102" value="" class="input" caption="B/L No." minlength="12" maxlength="12" dataformat="eng"></td>
          <td>Sales OFC</td>
          <td><input type="text" name="t1_txt_ob_sls_ofc_cd" style="width:50" value="" class="input" caption="Sales Office" maxlength="6" dataformat="engup"></td>
          <td>Sales Rep.</td>
          <td><input type="text" name="t1_txt_ob_srep_cd" style="width:60" value="" class="input" caption="Sales Rep." maxlength="5" dataformat="eng"></td>
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
      

       <!--  Button_Sub (S) -->
      <table width="100%" class="button" border="0" style="width:1005; align:left">
      <tr><td class="btn2_bg">
      <table border="0" cellpadding="0" cellspacing="0"><tr>     
        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
        <tr><td class="btn2_left"></td>
        <td class="btn2" name="btn_edit_cust_info">Edit Customer</td>
        <td class="btn2_right"></td>
        </tr>
        </table></td>
        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
        <tr><td class="btn2_left"></td>
        <td class="btn2" name="btn_Print">Print</td>
        <td class="btn2_right"></td>
        </tr>
        </table></td>
        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
        <tr><td class="btn2_left"></td>
        <td class="btn2" name="btn_PDFPrint">PDF</td>
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
    <!--TAB Outbound(E) -->

    <!--TAB Inbound(S) -->
   
      <!-- Button_Sub (E) -->

      </td></tr>
    </table>
    <!-- Grid BG Box  (S) -->
    <!--biz page (E)-->

  </div>

	

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
             <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
              <tr><td class="btn1_left"></td>
              <td class="btn1" id="btn_retrieve" name="btn_save">Save</td>
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
  

  </td></tr>
</table>




</form>


<form name="form2" method="POST">
<input type="hidden" name="bkg_no">
<input type="hidden" name="param_ui_id">
</form>

<form name="form3" method="post">
  <input type="hidden" name="pop_mode">
  <input type="hidden" name="display">
  <input type="hidden" name="func">
  <input type="hidden" name="row">
  <input type="hidden" name="col">
  <input type="hidden" name="sheetIdx">
  <input type="hidden" name="bkg_no">
  <input type="hidden" name="bl_no">
  <input type="hidden" name="sh_cust_nm">
  <input type="hidden" name="sh_cust_addr">
  <input type="hidden" name="cn_cust_nm">
  <input type="hidden" name="cn_cust_addr">
  <input type="hidden" name="nf_cust_nm">
  <input type="hidden" name="nf_cust_addr">
  <input type="hidden" name="ex_cust_nm">
  
  
</form>


</body>
</html>
