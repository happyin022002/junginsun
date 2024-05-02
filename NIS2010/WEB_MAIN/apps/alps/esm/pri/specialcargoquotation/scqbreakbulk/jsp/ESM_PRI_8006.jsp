<%
/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ESM_PRI_8006.jsp
*@FileTitle : Break Bulk Cargo Pricing Application
*Open Issues :
*@Change history :
*@LastModifyDate : 2013.06.26
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2013.02.12 문동선
* 1.0 Creation
=========================================================
* History 
* 2013.06.26 이혜민 [CHM-201325215] Special cargo Quotation System 수정 요청 - Approval, Application 화면에 Approver Name 추가, Request ID는 Requester Name으로 변경
* 2013.07.25 송호진 [CHM-201325102] Approval Cancel 기능 추가
* 2013.08.12 송호진 [CHM-201325335] Container Type & Q'ty 정보 Historical 관리 & Route 별 비용 Local Currency 적용
* 2014.04.01 송호진 [CHM-201429302] SCQ내 BB cargo application의 Excel 변환 기능 개발 요청
* 2014.09.11 송호진 [CHM-201431718] SCQ System 기능 추가 개발 요청 - Actual Customer란
* 2015.04.23 송호진 [CHM-201533702] SCQ내에 Unit Dual (cm/Inch) System 개발 요청
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqbreakbulk.event.EsmPri8006Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.core.config.SiteConfigFactory"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>

<%
  EsmPri8006Event  event = null;          //PDTO(Data Transfer Object including Parameters)
  Exception serverException   = null;     //서버에서 발생한 에러
  String strErrMsg = "";            //에러메세지
  int rowCount   = 0;           //DB ResultSet 리스트의 건수

  String successFlag = "";
  String codeList  = "";
  String pageRows  = "100";

  String strUsr_id    = "";
  String strUsr_nm    = "";
  String strUsr_ofc       = "";//
  String strUsrSrepCd     = "";//
  String[] measSysCd = null;
  
  Logger log = Logger.getLogger("com.hanjin.apps.specialcargo.specialcargo");

  try {
      SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id = account.getUsr_id();
    strUsr_nm = account.getUsr_nm();
    strUsr_ofc = account.getOfc_cd();//
  strUsrSrepCd = account.getSrep_cd();//

    event = (EsmPri8006Event)request.getAttribute("Event");
    serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

    if (serverException != null) {
      strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
    }

    // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
    GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
    
	measSysCd       = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("MEAS_SYS_CD"), false);

  }catch(Exception e) {
    out.println(e.toString());
  }
  
    String pDate2 = "";
  String pDate1 = "";
  String aDate2 = "";
  String aDate1 = "";
  
  // pop_mode
  String popMode = (request.getParameter("pop_mode") == null)? "N": "Y";  
  
  String p_rqstno = (request.getParameter("p_rqstno") == null)? "": request.getParameter("p_rqstno");
  String p_verno = (request.getParameter("p_verno") == null)? "": request.getParameter("p_verno");

  String[] svcScpCd = null;   
%>
<html>
<head>
<title>Break Bulk Cargo Pricing Application</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>

<script language="javascript">
	var server_url = "<%=SiteConfigFactory.get("COM.HANJIN.SYSTEM.DOMAIN_URL") %>";
	var measSysCdValue = "<%=measSysCd[0]%>";
	var measSysCdText = "<%=measSysCd[1]%>";

  function setupPage(){
    var errMessage = "<%=strErrMsg%>";
    if (errMessage.length >= 1) {
      ComShowMessage(errMessage);
    } // end if
    loadPage();
  }
</script>
</head>

<!-- 개발자 작업 -->

<% if (popMode.equals("Y")) { %>

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<table width="100%" class="popup" cellpadding="10" border="0">
  <tr><td class="top"></td></tr>
  <tr>
    <td valign="top">
      <!-- : ( Title ) (S) -->
      <table width="100%" border="0">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Break Bulk Cargo Rate Approval</td></tr>
      </table>
      <!-- : ( Title ) (E) -->

<% } else { %>

<body onLoad="setupPage();">
<form name="form">
<table border="0" cellpadding="0" cellspacing="0" style="padding: 5 0 0 2;">
  <tr>
    <td valign="top">
      <!-- Page Title, Historical (S) -->
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
      </table>
      <!-- Page Title, Historical (E) -->
<% } %>

<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="scq_ver_no">
<input type="hidden" name="rout_seq">
<input type="hidden" name="cd">
<input type="hidden" name="p_rqstno" value="<%=p_rqstno%>">
<input type="hidden" name="p_verno" value="<%=p_verno%>">
 
<input type="hidden" name="in_usr_ofc_cd" value="<%=strUsr_ofc%>"> 
<input type="hidden" name="in_usr_srep_cd" value="<%=strUsrSrepCd%>">
<input type="hidden" name="in_usr_nm" value="<%=strUsr_nm%>"> 
<input type="hidden" name="in_usr_id" value="<%=strUsr_id%>">
<input type="hidden" name="oti_eff_dt">
<input type="hidden" name="oti_exp_dt"> 
<input type="hidden" name="oti_amt">
<input type="hidden" name="oti_lic_no">
<input type="hidden" name="first_cre_usr_id">

<input type="hidden" name="send_usr_nm" value="<%=strUsr_nm%>"> 
<input type="hidden" name="gw_subject"> 
<input type="hidden" name="gw_contents"> 
<input type="hidden" name="gw_template">
<input type="hidden" name="gw_args">

      <!-- Button (S) -->
      <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;">
        <tr>
          <td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
              <tr>
              <% if (popMode.equals("Y")) { %>
                <td>
                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_previous">Previous</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_next">Next</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
              <% } %>
                <td>
                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_retrieve">Retrieve</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_new">New</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table></td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_pending">Pending</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_approval">Approval</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_reject">Reject</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_delete">Delete</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_cancel">Cancel</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_sendmail">Send&nbsp;Mail</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_attachfile">Attach&nbsp;File</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_saveasxls">Save&nbsp;As</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
      <!-- Button (E) -->

<table class="height_8"><tr><td colspan="8"></td></tr></table>
    
      <!-- biz page (S) -->

      
      <!-- biz_1 (S) -->
      <table class="search">
        <tr>
          <td class="bg">
            <table class="search" border="0" style="width:979;">
              <tr class="h23">
                <td width="90">Request OFC.</td>
                <td width="90"><input type="text" style="width: 72;" name="rqst_ofc_cd" dataformat="engup" class="input2" maxlength="5" readonly required></td>
                <td width="70">Sales Rep.</td>
                <td width="66"><script language="javascript">ComComboObject('cmb_prop_srep_cd', 3, 61, 0, 0);</script></td>
                <td width="100"><input type="text" style="width: 83;" name="prop_srep_nm" readonly class="input2"></td>
                <td width="90">Approval OFC.</td>
                <td width="78"><input type="text" style="width: 72;" name="apro_ofc_cd" dataformat="engup" class="input1" maxlength="6" required></td>
                <td width="80">Request No.</td>
                <td width="120"><input type="text" style="width: 110;" name="scq_rqst_no" dataformat="uppernum" class="input" maxlength="15"></td>
                <td width="60"><script language="javascript">ComComboObject('cmb_scq_ver_no', 3, 55, 1, 0);</script></td>
                <td width="105"><input type="text" style="width:100;" class="input2" maxlength="10" name="prog_sts_nm" readonly></td>
              </tr>
            </table>           
          </td>
        </tr>
      </table>
      <!-- biz_1 (E) -->

      <table class="height_8"><tr><td colspan="8"></td></tr></table>
      
      <table class="search">
        <tr>
          <td class="bg" valign="top">
            <table class="search" border="0" style="width:979;" id="mainTable">
              <tr class="h23">
                
                <td width="30">POL</td>
                <td width="105"><input type="text" style="width:50;" class="input1" value="" maxlength="5" dataformat="uppernum" name="pol_cd" style="ime-mode:disabled">
                        <input type="text" style="width:25;" class="input" value="" maxlength="2" dataformat="uppernum" name="pol_yd_cd">
                        <img class="cursor" src="img/btns_search.gif" name="btn_pol_cd" width="19" height="20" border="0" align="absmiddle"></td>
        <td width="60"><table width="99%" border="0" cellpadding="0" cellspacing="0" class="button">
                <tr><td class="btn2_left"></td>
                <td class="btn2" name="btn_pol_info">Info.</td>
                <td class="btn2_right"></td>
                </tr>
                </table></td>
        <td width="10"></td>
        
        <td width="30">POD</td>
                <td width="105"><input type="text" style="width:50;" class="input1" value="" maxlength="5" dataformat="uppernum" name="pod_cd">
                        <input type="text" style="width:25;" class="input" value="" maxlength="2" dataformat="uppernum" name="pod_yd_cd">
                        <img class="cursor" src="img/btns_search.gif" name="btn_pod_cd" width="19" height="20" border="0" align="absmiddle"></td>
        <td width="60"><table width="99%" border="0" cellpadding="0" cellspacing="0" class="button">
                <tr><td class="btn2_left"></td>
                <td class="btn2" name="btn_pod_info">Info.</td>
                <td class="btn2_right"></td>
                </tr>
                </table></td>
                <td width="10"></td>
                
                <td width="60">T/S Port</td>
                <td width="105"><input type="text" style="width:50;" class="input" value="" maxlength="5" dataformat="uppernum" name="ts_loc_cd">
                        <input type="text" style="width:25;" class="input" value="" maxlength="2" dataformat="uppernum" name="ts_yd_cd">
                        <img class="cursor" src="img/btns_search.gif" name="btn_ts_cd" width="19" height="20" border="0" align="absmiddle"></td>
        <td width="60"><table width="99%" border="0" cellpadding="0" cellspacing="0" class="button">
                <tr><td class="btn2_left"></td>
                <td class="btn2" name="btn_pod_info">Info.</td>
                <td class="btn2_right"></td>
                </tr>
                </table></td>
                <td width="20"></td>
                
                <td width="130"><table width="99%" border="0" cellpadding="0" cellspacing="0" class="button">
                <tr><td class="btn2_left"></td>
                <td class="btn2" name="btn_productCatalog">Product Catalog</td>
                <td class="btn2_right"></td>
                </tr>
                </table></td>
                <td width="20"></td>
                
                <!-- td width="20"></td -->
                
                <td width="100">Service Scope</td>
                <td width="70"><script language="javascript">ComComboObject('cmb_svc_scp_cd', 2, 70, 0, 1, 0, false);</script></td>
                
              </tr>
            </table>
            
            <table class="search" border="0" style="width:979;">
              <tr class="h23">
                <td width="101">Target Lane</td>
                <td width="348"><input type="text" style="width:50;" class="input1" value="" maxlength="6" dataformat="int" name="lane_cd">
                <td width="21"></td>
                <td width="132">Target VVD</td>
                <td width="180"><script language="javascript">ComComboObject('cmb_vvd_cd', 2, 160, 0, 0, 0, false);</script></td>
                <td width="29"></td>
                <td width="40">ETA 
                <td width="128"><input type="text" style="width:120;" class="input" value="" maxlength="6" name="vps_eta_dt">
              </tr>
            </table>
            
            <table class="search" border="0" style="width:979;">
              <tr class="h23">
                <td width="101">Customer</td>
                <td width="108"><input type="text" style="width:25;" class="input1" value="" maxlength="2" dataformat="engup" name="cust_cnt_cd">
                                <input type="text" style="width:50;" class="input1" value="" maxlength="6" dataformat="int" name="cust_seq">
                                <img class="cursor" src="img/btns_search.gif" name="btn_customer" width="19" height="20" border="0" align="absmiddle"></td>
                <td width="240"><input type="text" style="width:230;" class="input2" value="" name="ctrt_pty_nm" readonly></td>
                <td width="21"></td>
                <td width="132">Break Bulk Term</td>
                <td width="45"><script language="javascript">ComComboObject('cmb_rcv_term_cd', 2, 40, 0, 0, 0, false);</script></td>
                <td width="45"><script language="javascript">ComComboObject('cmb_de_term_cd', 2, 40, 0, 0, 0, false);</script></td>
                <td width="119"></td>
                <td width="168">AWK/BB Handling Info. 
                                <img class="cursor" src="img/btns_search.gif" name="btn_commonattach" width="19" height="20" border="0" align="absmiddle"></td>           
              </tr>
            </table>

            <table class="search" border="0" style="width:979;">
              <tr class="h23">
                <td width="101">Act. Customer</td>
                <td width="108"><input type="text" style="width:25;" class="input" value="" maxlength="2" dataformat="engup" name="act_cust_cnt_cd">
                                <input type="text" style="width:50;" class="input" value="" maxlength="6" dataformat="int" name="act_cust_seq">
                                <img class="cursor" src="img/btns_search.gif" name="btn_customer2" width="19" height="20" border="0" align="absmiddle"></td>
                <td width="240"><input type="text" style="width:230;" class="input2" value="" name="act_cust_nm" readonly></td>
                <td width="21"></td>
                <td width="132">Bidding Flag</td>
                <td width="90"><script language="javascript">ComComboObject('scq_bid_flg', 2, 80, 1, 0, 0, false);</script></td>
                <td width="119">&nbsp;</td>
                <td width="168">&nbsp;</td>           
              </tr>
            </table>
            
            <table class="search" border="0" style="width:979;">
              <tr class="h23">
                <td width="130">Proposal Duration</td>
                <td width="210"><input type="text" style="width:80;ime-mode:disabled;" class="input1" value="<%=pDate1%>" maxlength="10" dataformat="ymd" name="p_date1">&nbsp;~
                    <input type="text" style="width:80;ime-mode:disabled;" class="input1" value="<%=pDate2%>" maxlength="10" dataformat="ymd" name="p_date2">
                    <img src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" style="cursor:hand;" name="btn_Calendar1"></td>
                <td width="130"></td>
                <td width="130">Approval Duration</td>
                <td width="210"><input type="text" style="width:80;ime-mode:disabled;" class="input2" value="<%=aDate1%>" maxlength="10" dataformat="ymd" name="a_date1">&nbsp;~
                    <input type="text" style="width:80;ime-mode:disabled;" class="input2" value="<%=aDate2%>" maxlength="10" dataformat="ymd" name="a_date2">
                    <img src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" style="cursor:hand;" name="btn_Calendar2"></td>    
                <td width="8"></td>
                <td width="80"> Requester</td>
                <td width="75"><input type="text" style="width:75;ime-mode:disabled;" class="input2" name="first_cre_usr_nm" readonly></td>
              </tr>
            </table>
            
            <table class="search" border="0" style="width:979;">
              <tr class="h23">
                <td width="130">Proposal Rate (USD)</td>
                <td width="210"><input type="text" style="width:80;ime-mode:disabled;" class="input" name="prop_rt_amt" dataformat="int"></td>
                <td width="130"></td>
                <td width="130">Approval Rate (USD)</td>
                <td width="210"><input type="text" style="width:80;ime-mode:disabled;" class="input2" name="apro_rt_amt" dataformat="int"></td>    
                <td width="8"></td>
                <td width="80"> Approver</td>
                <td width="75"><input type="text" style="width:75;ime-mode:disabled;" class="input2" name="apro_usr_nm" readonly></td>
              </tr>
            </table>
            
            <table class="search" border="0" style="width:979;display:none">
              <td><script language="javascript">ComSheetObject('sheet1');</script></td>
            </table>
            
            <table class="height_8"><tr><td colspan="8"></td></tr></table>

            <table class="search" border="0" style="width:979;">
              <tr>
                <td width="490">
                  <table class="search" border="0">
                    <td class="title_h"></td>
                    <td class="title_s" width="230">Detail Information for Cargo</td>
                    <td width="120"><b>Measurement Unit</b></td>
                    <td width="130"><script language="javascript">ComComboObject('meas_sys_cd_vw', 1, 130, 1, 0, 0, false);</script></td>           
                  </table>
                </td>
                <td width="10"></td>
                <td width="199">
                  <table class="search" border="0">
                    <td class="title_h"></td>
                    <td class="title_s">CNTR Tp & Q'ty</td>
                    <td id="cntr_upd_usr_id" align="right"></td>
                  </table>
                </td>
                <td width="10"></td>
                <td width="260">
                  <table class="search" border="0">
                    <td class="title_h"></td>
                    <td class="title_s">Remark</td>
                  </table>
                </td>
              </tr>
              <tr>
                <td><script language="javascript">ComSheetObject('sheet2');</script></td>
                <td></td>
                <td><script language="javascript">ComSheetObject('sheet3');</script></td>
                <td></td>
                <td>
                  <table border="0" style="width:100%; background-color:white;" class="grid2"> 
                    <tr>
                      <td width="15%" class="tr2_head"> Req.</td>
                      <td width="%"> <textarea name="prop_rmk" class="textarea" style="width:100%;height:68"></textarea></td>
                    </tr>
                    <tr>
                      <td width="15%" class="tr2_head"> Appr.</td>
                      <td width="%"> <textarea name="apro_rmk" class="textarea2" style="width:100%;height:68"></textarea></td>
                    </tr>
                  </table>
                </td>
              </tr>
            </table>

            <table class="height_8"><tr><td colspan="8"></td></tr></table>

            <table class="search" border="0" style="width:979;">
              <tr>
                <td width="485">
                  <table class="search" border="0">
                    <td class="title_h"></td>
                    <td class="title_s" width="150" >Handling Cost at POL</td>
                    <td class="title_s" width="80" > Local Curr.</td>
				    <td width="" style="padding-left:2;"><input type="text" name="curr_cd_pol" width=30 ></input></td>
                    <td id="pol_cost_id" align="right"></td>
                  </table>
                </td>
                <td width="10"></td>
                <td width="485">
                  <table class="search" border="0">
                    <td class="title_h"></td>
                    <td class="title_s" width="150" >Handling Cost at POD</td>
                    <td class="title_s" width="80" > Local Curr.</td>
				    <td width="" style="padding-left:2;"><input type="text" name="curr_cd_pod" width=30 ></input></td>
                    <td id="pod_cost_id" align="right"></td>
                  </table>
                </td>
                <td width="10" style="display:none"></td>
                <td width="319" style="display:none" >
                  <table class="search" border="0">
                    <td class="title_h"></td>
                    <td class="title_s" width="180" >Handling Cost at T/S Port</td>
                    <td class="title_s" width="80" > Local Curr.</td>
				    <td width="" style="padding-left:2;"><input type="text" name="curr_cd_ts" width=30 ></input></td>
                    <td id="ts_cost_id" align="right"></td>
                  </table>
                </td>
              </tr>
              <tr>
                <td>
                  <script language="javascript">ComSheetObject('sheet4');</script>
                </td>
                <td></td>
                <td>
                  <script language="javascript">ComSheetObject('sheet5');</script>
                </td>
                <td style="display:none"></td>
                <td style="display:none">
                  <script language="javascript">ComSheetObject('sheet6');</script>
                </td>
              </tr>
              <tr>  
                <td width="485">
                  <table border="0" style="width:100%; background-color:white;" class="grid2"> 
                    <tr>
                      <td width="15%" class="tr2_head"> Rmk.</td>
                      <td width="%"> <textarea name="pol_rmk" style="width:100%;height:50"></textarea></td>
                    </tr>
                  </table>
                </td>
                <td width="10"></td>
                <td width="485">
                  <table border="0" style="width:100%; background-color:white;" class="grid2"> 
                    <tr>
                      <td width="15%" class="tr2_head"> Rmk.</td>
                      <td width="%"> <textarea name="pod_rmk" style="width:100%;height:50"></textarea></td>
                    </tr>
                  </table>
                </td>
                <td width="10" style="display:none"></td>
                <td width="319" style="display:none">
                  <table border="0" style="width:100%; background-color:white;" class="grid2"> 
                    <tr>
                      <td width="15%" class="tr2_head"> Rmk.</td>
                      <td width="%"> <textarea name="ts_rmk" style="width:100%;height:50"></textarea></td>
                    </tr>
                  </table>
                </td>    
              </tr>
            </table>
          </td>
        </tr>
      </table>

		<table > 
			<tr class="tr_head">
				<td width="100%" height="0" ><script language="javascript">comRdObject('report1');</script></td>
			</tr>		
		</table> 

          </td>
        </tr>
      </table>
<% if (popMode.equals("Y")) { %>
      <!-- : ( Button : pop ) (S) -->
      <table width="100%" class="sbutton">
        <tr>
          <td height="71" class="popup"><table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
              <tr>
                <td class="btn3_bg"><table border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="72"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                          <tr>
                            <td class="btn1_left"></td>
                            <td class="btn1" name="btn_close">Close</td>
                            <td class="btn1_right"></td>
                          </tr>
                        </table></td>
                    </tr>
                  </table></td>
              </tr>
            </table></td>
        </tr>
      </table>
      <!-- : ( Button : pop ) (E) -->

<% } %>



<!-- 개발자 작업  끝 -->
</form>
</body>
</html>