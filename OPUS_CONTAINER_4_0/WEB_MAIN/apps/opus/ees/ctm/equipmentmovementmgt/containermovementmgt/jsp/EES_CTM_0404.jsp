<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CTM_0404.jsp
*@FileTitle  : Update of EDI Message (All MSG)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.event.EesCtm0404Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
  EesCtm0404Event  event = null;    //PDTO(Data Transfer Object including Parameters)
  Exception serverException = null;    //error from server
  String strErrMsg = "";    //error message
  int rowCount = 0;    //DB ResultSet list count

  String successFlag = "";
  String codeList = "";

  String strUsr_id = "";
  String strUsr_nm = "";
  String mainpage = "";
  Logger log = Logger.getLogger("com.clt.apps.EquipmentMovementMgt.ContainerMovementMgt");

  try {
    SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id = account.getUsr_id();
    strUsr_nm = account.getUsr_nm();
    mainpage = request.getParameter("main_page");
    event = (EesCtm0404Event)request.getAttribute("Event");
    serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

    if (serverException != null) {
      strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
    }

    
    GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

  } catch(Exception e) {
    out.println(e.toString());
  }


  // bkgBl
  String bkgBl = (request.getParameter("bkgBl") == null)? "": request.getParameter("bkgBl");
  // pCntrno
  String pCntrno = (request.getParameter("pCntrno") == null)? "": request.getParameter("pCntrno");
  // checkDigit
  String checkDigit = (request.getParameter("checkDigit") == null)? "": request.getParameter("checkDigit");
  pCntrno = pCntrno + checkDigit;
  // pYard1
  String pYard1 = (request.getParameter("pYard1") == null)? "": request.getParameter("pYard1");
  // tmlNm
  String tmlNm = (request.getParameter("tmlNm") == null)? "": request.getParameter("tmlNm");
  // lccCd
  String lccCd = (request.getParameter("lccCd") == null)? "": request.getParameter("lccCd");
  // rccCd
  String rccCd = (request.getParameter("rccCd") == null)? "": request.getParameter("rccCd");
  // vvdCombo
  String vvdCombo = (request.getParameter("vvdCombo") == null)? "VVD_CD": request.getParameter("vvdCombo");
  // vvdValue
  String vvdValue = (request.getParameter("vvdValue") == null)? "": request.getParameter("vvdValue");
  // cntrTpszCd
  String cntrTpszCd = (request.getParameter("cntrTpszCd") == null)? "": request.getParameter("cntrTpszCd");
  // cntrFullStsCd
  String cntrFullStsCd = (request.getParameter("cntrFullStsCd") == null)? "": request.getParameter("cntrFullStsCd");
  // mvmtEdiMsgAreaCd
  String mvmtEdiMsgAreaCd = (request.getParameter("mvmtEdiMsgAreaCd") == null)? "": request.getParameter("mvmtEdiMsgAreaCd");
  // mvmtEdiMsgTpId
  String mvmtEdiMsgTpId = (request.getParameter("mvmtEdiMsgTpId") == null)? "ALL": request.getParameter("mvmtEdiMsgTpId");
  // mvmtEdiRsltCd
  String mvmtEdiRsltCd = (request.getParameter("mvmtEdiRsltCd") == null)? "N": request.getParameter("mvmtEdiRsltCd");
  // mvmtEdiRmk
  String mvmtEdiRmk = (request.getParameter("mvmtEdiRmk") == null)? "": request.getParameter("mvmtEdiRmk");
  // ediMvmtStsCd
  String ediMvmtStsCd = (request.getParameter("ediMvmtStsCd") == null)? "": "'" + request.getParameter("ediMvmtStsCd") + "'";
  // rtyKnt
  String rtyKnt = (request.getParameter("rtyKnt") == null)? "": request.getParameter("rtyKnt");
  // ediGateIoCd
  String ediGateIoCd = (request.getParameter("ediGateIoCd") == null)? "": "'" + request.getParameter("ediGateIoCd") + "'";
  // mtyPlnNo
  String mtyPlnNo = (request.getParameter("mtyPlnNo") == null)? "": request.getParameter("mtyPlnNo");

  // Duration start date (today in case of no request)
  String pDate1 = (request.getParameter("pDate1") == null)? DateTime.getFormatDate(new java.util.Date(), "yyyy-MM-dd"): request.getParameter("pDate1");
  // Duration end date (today in case of no request)
  String pDate2 = (request.getParameter("pDate2") == null)? DateTime.getFormatDate(new java.util.Date(), "yyyy-MM-dd"): request.getParameter("pDate2");

  String requestYN = "";
  if (request.getParameter("pDate1") != null && request.getParameter("pDate2") != null) requestYN = "Y";

  // pop_mode
  String popMode = (request.getParameter("pop_mode") == null)? "N": "Y";
%>

<script type="text/javascript">
  function setupPage() {
    var errMessage = "<%=strErrMsg%>";
    if (errMessage.length >= 1) {
      ComShowMessage(errMessage);
    } // end if
    loadPage();
  }
</script>
<!-- developer job -->
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="user_svr_id" id="user_svr_id">
<input type="hidden" value="<%=requestYN%>" name="requestYN">
<input type="hidden" name="org_vvd_cd" id="org_vvd_cd">


<% if (popMode.equals("Y")) { %>
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
    <h2 class="page_title"><button type="button"><span id="title">Update of EDI Message - All MSG</span></button></h2>
<% } else { %>

<!-- page_title_area(S) -->
    <div class="page_title_area clear">
       <!-- page_title(S) -->
        <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
        <h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
        <!-- page_title(E) -->

<% } %>

    <!-- opus_design_btn(S) -->
    <div class="opus_design_btn"><!--  
    --><button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--  
    --><button type="button" class="btn_normal" name="btn_save"     id="btn_save">Save</button><!--  
    --><% if(!"true".equals(mainpage)){%><!--  
    --><% if (popMode.equals("Y")) { %><!--  
    --><button type="button" class="btn_normal" name="btn_close"    id="btn_close">Close</button><!--  
    --><% } %><!--  
    --><%} %><!--  
    --></div>
    <!-- opus_design_btn(E) -->

    <!-- page_location(S) -->
    <div class="location">
        <!-- location 내용 동적생성 (별도 코딩 불필요) -->
        <span id="navigation"></span>
    </div>
</div>
<% if (popMode.equals("Y")) { %>
    <!-- popup_contens_area(S) -->
    <div class="layer_popup_contents">
<% } %>
<!-- layout_wrap(S) -->
<div class="wrap_search">
    <div class="opus_design_inquiry wFit">
        <div class="layout_wrap">
            <!-- layout_vertical_2(S) -->
            <div class="layout_vertical_2" style="width: 220px;">
                <table class="grid_2">
                    <tr>
                      <th colspan="2"><!--  
                        --><input type="radio" name="event_receive" id="event_receive1" value="EVENT" class="trans" checked><label for="event_receive1">Event</label><!--  
                        --><input type="radio" name="event_receive" id="event_receive2" value="RECEIVE" class="trans"><label for="event_receive1">Receiving</label><!-- 
                        --><input type="checkbox" style="width:10px;ime-mode:disabled" class="input" name="null_flg"  value=""><label for="null">Null Incl.
                      </th>
                    </tr>
                    <tr>
                        <th>From</th>
                        <td class="noinput1"><input type="text" style="width:75px;ime-mode:disabled;" class="input1" value="<%=pDate1%>" tabindex="1" name="p_date1" id="p_date1" dataformat ="ymd"></td>
                    </tr>
                    <tr>
                        <th>To</th>
                        <td class="noinput1"><!--  
                        --><input type="text" style="width:75px;ime-mode:disabled;" class="input1" value="<%=pDate2%>" tabindex="2" name="p_date2" id="p_date2" dataformat ="ymd"><!--  
                        --><button type="button" class="calendar ir" name="btn_Calendar" id="btn_Calendar"></button><!--  
                        --><input type="hidden" name="p_date3" id="p_date3"></td>
                    </tr>
                </table>
            </div>
            <!-- layout_vertical_2(E) -->

            <!-- layout_vertical_2(S) -->
            <div class="layout_vertical_2 pad_left_8">
                <table>
                    <colgroup>
                        <col width="60">
                        <col width="130">
                        <col width="70">
                        <col width="130">
                        <col width="90">
                        <col width="90">
                        <col width="70">
                        <col width="90">
                        <col width="90">
                        <col width="90">
                        <col width="90">
                        <col width="*">
                    </colgroup>
                    <tr>
                        <th>BKG or B/L No.</th>
                        <td><input type="text" style="width:110px;ime-mode:disabled;" class="input" dataformat="engup" maxlength="13" tabindex="3" value="<%=bkgBl%>" name="bkg_bl" id="bkg_bl"></td>
                        <th>Terminal</th>
                        <td><input type="text" style="width:125px;ime-mode:disabled;" class="input" maxlength="20" tabindex="7" value="<%=tmlNm%>" name="tml_nm" id="tml_nm"></td>
                        <th>TP/SZ</th>
                        <td><script type="text/javascript">ComComboObject("tpszCombo", 1, 65, 1, 0, 0, 0, 11);</script><!--  
                        --><input type="hidden" value="<%=cntrTpszCd%>" name="cntr_tpsz_cd" id="cntr_tpsz_cd"></td>
                        <th>Area</th>
                        <td>
                            <select style="width:80px;" tabindex="14" name="mvmt_edi_msg_area_cd" id="mvmt_edi_msg_area_cd">
                                <option value="KOR">KR / JP</option>
                                <option value="CHN">CHN</option>
                                <option value="SWA">SWA</option>
                                <option value="EUR">EUR</option>
                                <option value="USA">USA</option>
                                <option value="">ALL</option>
                            </select><!--
                            --><input type="hidden" value="<%=mvmtEdiMsgAreaCd%>" name="mvmtEdiMsgAreaCd">
                        </td>
                        <th>Status</th>
                        <td><script type="text/javascript">ComComboObject("statusCombo", 1, 70, 1, 0, 0, 0, 17);</script><!--  
                        --><input type="hidden" value="<%=ediMvmtStsCd%>" name="edi_mvmt_sts_cd" id="edi_mvmt_sts_cd"></td>
                        <th>MSG TP</th>
                        <td>
							<select style="width:70px;" tabindex="15" name="flt_file_ref_no" id="flt_file_ref_no">
                                <option value="">ALL</option>
                                <option value="EDI">EDI</option>
                                <option value="SPP">SPP</option>
                                <option value="IEM">IEM</option>
                            </select>                        
                        </td>      
                        <th>Error with succeeding OK </th>
                        <td>
							<select style="width:70px;" tabindex="15" name="err_wt_ok" id="err_wt_ok">
                                <option value="">ALL</option>
                                <option value="Y">YES</option>
                                <option value="N">NO</option>
                            </select>                        
                        </td>                  
                    </tr>
                    
                    <tr>
                        <th>Container No.</th>
                        <td><input type="text" style="width:110px; ime-mode:disabled;" class="input" maxlength="11" tabindex="4" value="<%=pCntrno%>" name="cntrno_disp" id="cntrno_disp"><input type="hidden" value="<%=pCntrno%>" name="p_cntrno"><!-- 
                           <input type="text" style="width:20px;" class="input" readonly="true" value="" name="check_digit" id="check_digit">--></td>
                        <th>LCC</th>
                        <td><input type="text" style="width:50px; ime-mode:disabled;" class="input" maxlength="5" tabindex="8" value="<%=lccCd%>" name="lcc_cd" id="lcc_cd" dataformat ="engup"></td>
                        <th>RCC</th>
                        <td><input type="text" style="width:65px; ime-mode:disabled;" class="input" maxlength="5" tabindex="12" value="<%=rccCd%>" name="rcc_cd" id="rcc_cd" dataformat ="engup"></td>
                        <th>MSG ID</th>
                        <td><script type="text/javascript">ComComboObject("mvmt_edi_msg_tp_id", 1, 80, 1, 0, 0, 0, 15);</script><!--  
                        --><input type="hidden" value="<%=mvmtEdiMsgTpId%>" name="mvmtEdiMsgTpId" id="mvmtEdiMsgTpId"></td>
                        <th>Retry</th>
                        <td>
                            <select style="width:70px;" tabindex="18" name="rty_knt" id="rty_knt">
                                <option value="" selected>ALL</option>
                                <option value="0">0</option>
                                <option value="1">More</option>
                            </select><!--  
                            --><input type="hidden" value="<%=rtyKnt%>" name="rtyKnt" id="rtyKnt">
                        </td>
                        <th>EQR Ref. No.</th>
                        <td><input type="text" style="width:110px;" dataformat="engup" maxlength="13" tabindex="21" value="<%=mtyPlnNo%>" name="mty_pln_no" id="mty_pln_no"></td>
                    </tr>
                    
                    <tr>
                        <th>Origin Yard</th>
                        <td><input type="text" style="width:60px; ime-mode:disabled;" class="input" maxlength="5" tabindex="5" value="<%=pYard1%>" name="yd_cd_disp" id="yd_cd_disp" dataformat ="engup"><!--  
                            --><input type="hidden" value="<%=pYard1%>" name="p_yard1" id="p_yard1"><!-- 
                           --><script type="text/javascript">ComComboObject("p_yard2", 2, 45, 0, 0, 0, 0, 6);</script></td>
                        <td>
                            <select style="width:70px; font-weight:bold; color:#000000;" tabindex="9" name="vvd_combo" id="vvd_combo" OnChange="vvd_combo_onchange();">
                                <option value="VVD_CD">VVD</option>
                                <option value="CALL_SGN_NO">Call Sign</option>
                                <option value="LLOYD_NO">Lloyd</option>
                            </select><!--  
                            --><input type="hidden" value="<%=vvdCombo%>" name="vvdCombo" id="vvdCombo">
                        </td>
                        <td><input type="text" style="width:125px; ime-mode:disabled;" class="input" maxlength="20" tabindex="10" value="<%=vvdValue%>" name="vvd_value" id="vvd_value"></td>
                        <th>F/M</th>
                        <td>
                            <select style="width:65px;" tabindex="13" name="cntr_full_sts_cd" id="cntr_full_sts_cd">
                                <option value="" selected>ALL</option>
                                <option value="F">F</option>
                                <option value="M">M</option>
                            </select><!--
                            --><input type="hidden" value="<%=cntrFullStsCd%>" name="cntrFullStsCd" id="cntrFullStsCd">
                        </td>
                        <th>Result</th>
                        <td><select style="width:80px;" tabindex="16" name="mvmt_edi_rslt_cd" id="mvmt_edi_rslt_cd">
                                <option value="ALL">ALL (Except Deleted)</option>
                                <option value="N" selected>Error</option>
                                <option value="Y">OK</option>
                                <option value="X">Ignored</option>
                                <option value="D">Deleted</option>
                            </select><!--
                            --><input type="hidden" value="<%=mvmtEdiRsltCd%>" name="mvmtEdiRsltCd" id="mvmtEdiRsltCd">
                        </td>
                        <th>I/O Status</th>
                        <td><script type="text/javascript">ComComboObject("ioStatusCombo", 2, 70, 1, 0, 0, 0, 19);</script><!--  
                        --><input type="hidden" value="<%=ediGateIoCd%>" name="edi_gate_io_cd" id="edi_gate_io_cd">
                        </td>
                        <th>Error Message</th>
                        <td><input type="text" style="width:110px;" dataformat="engup" otherchar="% " tabindex="22" value="<%=mvmtEdiRmk%>" name="mvmt_edi_rmk" id="mvmt_edi_rmk"></td>
                    </tr>
                    
                </table>
            </div>
        </div>
    </div>
</div>

<div class="wrap_result">
    <div class="opus_design_grid">
        <div class="opus_design_btn"><!--  
        --><button type="button" class="btn_accent" name="btn_more" id="btn_more">More</button><!--  
        --><button type="button" class="btn_normal" name="btn_detail"   id="btn_detail">Detail Info</button><!--  
        --><button type="button" class="btn_normal" name="btn_downexcel"    id="btn_downexcel">Down Excel</button><!--  
        --></div>
        <script type="text/javascript">ComSheetObject('sheet1');</script>
    </div>
    <div class="opus_design_data">
        <table>
            <colgroup>
                <col width="70px">
                <col width="30px">
                <col width="70px">
                <col width="30px">
                <col width="70px">
                <col width="30px">
                <col width="30px">
                <col width="30px">
                <col width="30px">
                <col width="*">
            </colgroup>
            <tr>
               <th>Total&nbsp;</th>
               <td><input type="text" style="width:60px;text-align:right;" class="input2" readonly="true" name="disp_total" id="disp_total"></td>
               <th>R/Total&nbsp;</th>
               <td><input type="text" style="width:60px;text-align:right;" class="input2" readonly="true" name="rtv_total" id="rtv_total"></td>
               <th>G/Total&nbsp;</th>
               <td><input type="text" style="width:60px;text-align:right;font-weight:bold;" class="input2" readonly="true" name="gnd_total" id="gnd_total"></td>
               <td><select style="width:100px; font-weight:bold; color:#000000;" tabindex="19" name="vvdsts_change_combo" id="vvdsts_change_combo">
                       <option value="CNTR">CNTR No.</option>
                       <option value="YARD">ORG YD</option>
                       <option value="BKG">BKG No.</option>
                       <option value="VVD" selected>VVD</option>
                       <option value="STATUS">Status</option>
                       <option value="FM">F/M</option>
                       <option value="REMARK">Remarks</option>
                   </select>
               </td>
               <td><input type="text" style="width:120px; ime-mode:disabled;" class="input" maxlength="9" tabindex="20" name="vvdcd_change" id="vvdcd_change"></td> 
               <td><select style="width:80px; display:none;" tabindex="20" name="stscd_change" id="stscd_change">
                      <option value="OP" selected>OP</option>
                      <option value="EN">EN</option>
                      <option value="TN">TN</option>
                      <option value="OC">OC</option>
                      <option value="VL">VL</option>
                      <option value="VD">VD</option>
                      <option value="IC">IC</option>
                      <option value="ID">ID</option>
                      <option value="MT">MT</option>
                      <option value="TS">TS</option>
                      <option value="CP">CP</option>
                      <option value="CT">CT</option>
                      <option value="CE">CE</option>
                      <option value="CO">CO</option>
                      <option value="CI">CI</option>
                      <option value="CD">CD</option>
                      <option value="CM">CM</option>
                   </select>
                </td>
                <td>
                	<button type="button" class="btn_etc" name="btn_vvdchange" id="btn_vvdchange">Edit</button>
                	<button type="button" class="btn_etc" name="btn_delete" id="btn_delete">Delete</button>
                </td>
           </tr>
       </table>
    </div>
</div>
<% if (popMode.equals("Y")) { %>
</div>
<!-- popup_contens_area(E) -->
<% } %>

<!-- end of developer job -->
</form>