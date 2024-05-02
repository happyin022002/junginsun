<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CTM_0442.jsp
*@FileTitle  : Detail Information 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.event.EesCtm0442Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
  EesCtm0442Event  event = null;    //PDTO(Data Transfer Object including Parameters)
  Exception serverException = null;    //error from server
  String strErrMsg = "";    //error message
  int rowCount = 0;    //DB ResultSet list count
  String successFlag = "";
  String codeList = "";
  String pageRows  = "100";
  String strUsr_id = "";
  String strUsr_nm = "";
  Logger log = Logger.getLogger("com.clt.apps.EquipmentMovementMgt.ContainerMovementMgt");
  try {
    SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id =  account.getUsr_id();
    strUsr_nm = account.getUsr_nm();
    event = (EesCtm0442Event)request.getAttribute("Event");
    serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
    if (serverException != null) {
      strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
    }
    GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
  } catch(Exception e) {
    out.println(e.toString());
  }
  // mvmt_edi_msg_area_cd
  String mvmtEdiMsgAreaCd = (request.getParameter("mvmt_edi_msg_area_cd") == null)? "": request.getParameter("mvmt_edi_msg_area_cd");
  // mvmt_edi_msg_seq
  String mvmtEdiMsgSeq = (request.getParameter("mvmt_edi_msg_seq") == null)? "": request.getParameter("mvmt_edi_msg_seq");
  // mvmt_edi_msg_tp_id
  String mvmtEdiMsgTpId = (request.getParameter("mvmt_edi_msg_tp_id") == null)? "": request.getParameter("mvmt_edi_msg_tp_id");
  // mvmt_edi_msg_yrmondy
  String mvmtEdiMsgYrmondy = (request.getParameter("mvmt_edi_msg_yrmondy") == null)? "": request.getParameter("mvmt_edi_msg_yrmondy");
  // mvmt_edi_tp_cd
  String mvmtEdiTpCd = (request.getParameter("mvmt_edi_tp_cd") == null)? "": request.getParameter("mvmt_edi_tp_cd");
%>

<script type="text/javascript">
  function setupPage(){
    var errMessage = "<%=strErrMsg%>";
    if (errMessage.length >= 1) {
      ComShowMessage(errMessage);
    } // end if
    loadPage();
  }
</script>

<form name="form">
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="pagerows" name="pagerows" type="hidden" />
<input id="mvmt_edi_msg_area_cd" value="<%=mvmtEdiMsgAreaCd%>" name="mvmt_edi_msg_area_cd" type="hidden" />
<input id="mvmt_edi_msg_yrmondy" value="<%=mvmtEdiMsgYrmondy%>" name="mvmt_edi_msg_yrmondy" type="hidden" />
<input id="mvmt_edi_msg_seq" value="<%=mvmtEdiMsgSeq%>" name="mvmt_edi_msg_seq" type="hidden" />

<!-- popup_title_area(S) -->
 <div class="layer_popup_title">
    <!-- page_title_area(S) -->
    <div class="page_title_area clear">
        <!-- page_title(S) -->
        <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
        <h2 class="page_title">
            <span>Detail Information</span>
        </h2>
        <!-- page_title(E) -->
        <!-- opus_design_btn (S) -->
        <div class="opus_design_btn">
            <button type="button" id="btn_close" name="btn_close" class="btn_accent">Close</button>
        </div>
        <!-- opus_design_btn (E) -->
    </div>
    <!-- page_title_area(E) -->
</div>
<!-- popup_title_area(E) -->

<!-- popup_contens_area(S) -->
<div class="layer_popup_contents">
    <div class="wrap_search">
        <div class="opus_design_inquiry">
            <table>
                <colgroup>
                    <col width="50"/>
                    <col width="120"/>
                    <col width="25"/>
                    <col width="50"/>
                    <col width="120"/>
                    <col width="25"/>
                    <col width="50"/>
                    <col width="120"/>
                    <col width="25"/>
                    <col width="50"/>
                    <col width="120"/>
                    <col width="25"/>
                    <col width="50"/>
                    <col width="120"/>
                    <col width="*"/>
                </colgroup>
                <tbody>
                  <tr>
                    <th>Container No.</th>
                    <td><input id="cntr_no" style="width:100px;" class="input2" readonly name="cntr_no" type="text" /> </td>
                    <td></td>
                    <th>Event Date</th>
                    <td><input id="evnt_dt" style="width:130px;" class="input2" readonly name="evnt_dt" type="text" /> </td>
                    <td></td>
                    <th>S/P</th>
                    <td><input id="vndr_seq" style="width:100px;" class="input2" readonly name="vndr_seq" type="text" /> </td>
                    <td></td>
                    <th>Full/MTY</th>
                    <td><input id="cntr_full_sts_cd" style="width:30px;" class="input2" readonly name="cntr_full_sts_cd" type="text" /> </td>
                    <td></td>
                    <th>MSG ID</th>
                    <td><input id="mvmt_edi_msg_tp_id" style="width:50px;" class="input2" readonly value="<%=mvmtEdiMsgTpId%>" name="mvmt_edi_msg_tp_id" type="text" /> </td>
                    <td></td>
                  </tr>
                  <tr>
                    <th>Chassis No.</th>
                    <td><input id="chss_no" style="width:100px;" class="input2" readonly name="chss_no" type="text" /> </td>
                    <td></td>
                    <th>Terminal Name</th>
                    <td><input id="tml_nm" style="width:130px;" class="input2" readonly name="tml_nm" type="text" /> </td>
                    <td></td>
                    <th>Yard</th>
                    <td><input id="evnt_yd_cd" style="width:100px;" class="input2" readonly name="evnt_yd_cd" type="text" /> </td>
                    <td></td>
                    <th>Gate</th>
                    <td><input id="edi_gate_io_cd" style="width:30px;" class="input2" readonly name="edi_gate_io_cd" type="text" /> </td>
                    <td></td>
                    <th>EDI ID</th>
                    <td><input id="mvmt_edi_tp_cd" style="width:50px;" class="input2" readonly value="<%=mvmtEdiTpCd%>" name="mvmt_edi_tp_cd" type="text" /> </td>
                    <td></td>
                  </tr>
                  <tr>
                    <th>M.G Set</th>
                    <td><input id="mgst_no" style="width:100px;" class="input2" readonly name="mgst_no" type="text" /> </td>
                    <td></td>
                    <th>MUID</th>
                    <td><input id="muid" style="width:130px;" class="input2" readonly value="<%=mvmtEdiMsgAreaCd + mvmtEdiMsgYrmondy + mvmtEdiMsgSeq%>" name="muid" type="text" /> </td>
                    <td></td>
                    <th>Seal No.</th>
                    <td><input id="cntr_seal_no" style="width:100px;" class="input2" readonly name="cntr_seal_no" type="text" /> </td>
                    <td></td>
                    <th>Status</th>
                    <td><input id="edi_mvmt_sts_cd" style="width:30px;" class="input2" readonly name="edi_mvmt_sts_cd" type="text" /> </td>
                    <td></td>
                    <th title="Port of Loading">POL</th>
                    <td><input id="bkg_pol_cd" style="width:50px;" class="input2" readonly name="bkg_pol_cd" type="text" /> </td>
                    <td></td>
                  </tr>
                  <tr>
                    <th>VVD Code</th>
                    <td><input id="vvd_cd" style="width:100px;" class="input2" readonly name="vvd_cd" type="text" /> </td>
                    <td></td>
                    <th>Call Sign/Lloyd</th>
                    <td><input id="call_sgn_no" style="width:130px;" class="input2" readonly name="call_sgn_no" type="text" /> </td>
                    <td></td>
                    <th>Waybill</th>
                    <td><input id="wbl_no" style="width:100px;" class="input2" readonly name="wbl_no" type="text" /> </td>
                    <td></td>
                    <th>Mode</th>
                    <td><input id="mvmt_trsp_mod_cd" style="width:30px;" class="input2" readonly name="mvmt_trsp_mod_cd" type="text" /> </td>
                    <td></td>
                    <th title="Port of Discharging">POD</th>
                    <td><input id="bkg_pod_cd" style="width:50px;" class="input2" readonly name="bkg_pod_cd" type="text" /> </td>
                    <td></td>
                  </tr>
                  <tr>
                    <th>B/L No.</th>
                    <td><input id="bl_no" style="width:100px;" class="input2" readonly name="bl_no" type="text" /> </td>
                    <td></td>
                    <th>BKG No.</th>
                    <td><input id="bkg_knt" style="width:15px;" class="input2" readonly name="bkg_knt" type="text" /><input id="bkg_no" style="width:110px;" class="input2" readonly name="bkg_no" type="text" /> </td>
                    <td></td>
                    <th>Pick Up No.</th>
                    <td><input id="pkup_no" style="width:100px;" class="input2" readonly name="pkup_no" type="text" /> </td>
                    <td></td>
                    <th>Damage</th>
                    <td><input id="cntr_dmg_flg" style="width:30px;" class="input2" readonly name="cntr_dmg_flg" type="text" /> </td>
                    <td></td>
                    <th>TOL</th>
                    <td><input id="dest_yd_cd" style="width:50px;" class="input2" readonly name="dest_yd_cd" type="text" /> </td>
                    <td></td>
                  </tr>
                </tbody>
            </table>
            
            <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
            
            <table>
                <colgroup>
                    <col width="25"/>
                    <col width="50"/>
                    <col width="120"/>
                    <col width="25"/>
                    <col width="50"/>
                    <col width="120"/>
                    <col width="25"/>
                    <col width="50"/>
                    <col width="120"/>
                    <col width="*"/>
                </colgroup>
                <tbody>
                     <tr>
                        <td></td>
                       <th>Company</th>
                       <td><input id="cnmv_co_cd" style="width:30px;" class="input2" readonly name="cnmv_co_cd" type="text" /> </td>
                       <td></td>
                       <th>Retry Count</th>
                       <td><input id="edi_rty_knt" style="width:30px;" class="input2" readonly name="edi_rty_knt" type="text" /> </td>
                       <td></td>
                       <th>Result Flag</th>
                       <td><input id="mvmt_edi_rslt_cd" style="width:25px;" class="input2" readonly name="mvmt_edi_rslt_cd" type="text" /> </td>
                       <td></td>
                     </tr>
                </tbody>
            </table>
        </div>
    </div>
    
    <div class="wrap_result">
        <div class="opus_design_grid">
            <script type="text/javascript">ComSheetObject('sheet1');</script>
        </div>
    </div>
</div>
<!-- popup_contens_area(E) -->

</form>