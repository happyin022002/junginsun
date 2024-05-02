<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_ctm_0442.jsp
*@FileTitle : Detail Information
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.20
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2009.06.20 김상수
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.event.EesCtm0442Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
  EesCtm0442Event  event = null;    //PDTO(Data Transfer Object including Parameters)
  Exception serverException = null;    //서버에서 발생한 에러
  String strErrMsg = "";    //에러메세지
  int rowCount = 0;    //DB ResultSet 리스트의 건수

  String successFlag = "";
  String codeList = "";
  String pageRows  = "100";

  String strUsr_id = "";
  String strUsr_nm = "";
  Logger log = Logger.getLogger("com.hanjin.apps.EquipmentMovementMgt.ContainerMovementMgt");

  try {
    SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id =  account.getUsr_id();
    strUsr_nm = account.getUsr_nm();

    event = (EesCtm0442Event)request.getAttribute("Event");
    serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

    if (serverException != null) {
      strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
    }

    // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
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
<html>
<head>
<title>Detail Information</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

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

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업 -->


<input type="hidden" value="<%=mvmtEdiMsgAreaCd%>" name="mvmt_edi_msg_area_cd">
<input type="hidden" value="<%=mvmtEdiMsgYrmondy%>" name="mvmt_edi_msg_yrmondy">
<input type="hidden" value="<%=mvmtEdiMsgSeq%>" name="mvmt_edi_msg_seq">
<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0">
  <tr><td class="top"></td></tr>
  <tr><td valign="top">

      <!-- : ( Title ) (S) -->
      <table width="100%" border="0">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Detail Information</td></tr>
      </table>
      <!-- : ( Title ) (E) -->

      <!-- : ( Search Options ) (S) -->
      <table class="search">
        <tr>
          <td class="bg">
            <table class="search" border="0" style="width:100%;">
              <tr class="h23">
                <td>Container No.</td>
                <td style="padding-right:20"><input type="text" style="width:100;" class="input2" readonly name="cntr_no"></td>
                <td>Event Date</td>
                <td style="padding-right:20"><input type="text" style="width:130;" class="input2" readonly name="evnt_dt"></td>
                <td>S/P</td>
                <td style="padding-right:20"><input type="text" style="width:100;" class="input2" readonly name="vndr_seq"></td>
                <td>Full/MTY</td>
                <td style="padding-right:20"><input type="text" style="width:30;" class="input2" readonly name="cntr_full_sts_cd"></td>
                <td>MSG ID</td>
                <td><input type="text" style="width:50;" class="input2" readonly value="<%=mvmtEdiMsgTpId%>" name="mvmt_edi_msg_tp_id"></td>
              </tr>
              <tr class="h23">
                <td>Chassis No.</td>
                <td><input type="text" style="width:100;" class="input2" readonly name="chss_no"></td>
                <td>Terminal Name</td>
                <td><input type="text" style="width:130;" class="input2" readonly name="tml_nm"></td>
                <td>Yard</td>
                <td><input type="text" style="width:100;" class="input2" readonly name="evnt_yd_cd"></td>
                <td>Gate</td>
                <td><input type="text" style="width:30;" class="input2" readonly name="edi_gate_io_cd"></td>
                <td>EDI ID</td>
                <td><input type="text" style="width:50;" class="input2" readonly value="<%=mvmtEdiTpCd%>" name="mvmt_edi_tp_cd"></td>
              </tr>
              <tr class="h23">
                <td>M.G Set</td>
                <td><input type="text" style="width:100;" class="input2" readonly name="mgst_no"></td>
                <td>MUID</td>
                <td><input type="text" style="width:130;" class="input2" readonly value="<%=mvmtEdiMsgAreaCd + mvmtEdiMsgYrmondy + mvmtEdiMsgSeq%>" name="muid"></td>
                <td>Seal No.</td>
                <td><input type="text" style="width:100;" class="input2" readonly name="cntr_seal_no"></td>
                <td>Status</td>
                <td><input type="text" style="width:30;" class="input2" readonly name="edi_mvmt_sts_cd"></td>
                <td>POL</td>
                <td><input type="text" style="width:50;" class="input2" readonly name="bkg_pol_cd"></td>
              </tr>
              <tr class="h23">
                <td>VVD Code</td>
                <td><input type="text" style="width:100;" class="input2" readonly name="vvd_cd"></td>
                <td>Call Sign/Lloyd</td>
                <td><input type="text" style="width:130;" class="input2" readonly name="call_sgn_no"></td>
                <td>Waybill</td>
                <td><input type="text" style="width:100;" class="input2" readonly name="wbl_no"></td>
                <td>Mode</td>
                <td><input type="text" style="width:30;" class="input2" readonly name="mvmt_trsp_mod_cd"></td>
                <td>POD</td>
                <td><input type="text" style="width:50;" class="input2" readonly name="bkg_pod_cd"></td>
              </tr>
              <tr class="h23">
                <td>B/L No.</td>
                <td><input type="text" style="width:100;" class="input2" readonly name="bl_no"></td>
                <td>BKG No.</td>
                <td><input type="text" style="width:15;" class="input2" readonly name="bkg_knt">&nbsp;<input type="text" style="width:110;" class="input2" readonly name="bkg_no"></td>
                <td>Pick Up No.</td>
                <td><input type="text" style="width:100;" class="input2" readonly name="pkup_no"></td>
                <td>Damage</td>
                <td><input type="text" style="width:30;" class="input2" readonly name="cntr_dmg_flg"></td>
                <td>TOL</td>
                <td><input type="text" style="width:50;" class="input2" readonly name="dest_yd_cd"></td>
              </tr>
            </table>

            <table class="line_bluedot"><tr><td></td></tr></table>
            <table class="search" border="0" style="width:100%;">
              <tr class="h23">
                <td width="60">Company</td>
                <td width="60"><input type="text" style="width:30;" class="input2" readonly name="cnmv_co_cd"></td>
                <td width="80">Retry Count</td>
                <td width="60"><input type="text" style="width:30;" class="input2" readonly name="edi_rty_knt"></td>
                <td width="70">Result Flag</td>
                <td><input type="text" style="width:25;" class="input2" readonly name="mvmt_edi_rslt_cd"></td>
              </tr>
            </table>
            <table class="height_5"><tr><td></td></tr></table>

            <table width="882" id="mainTable">
              <tr>
                <td width="100%"><script language="javascript">ComSheetObject('sheet1');</script></td>
              </tr>
            </table>
        <!-- : ( Button : Grid ) (E) -->

          </td>
        </tr>
      </table>
      <!-- : ( Search Options ) (E) -->

      <table class="height_5"><tr><td></td></tr></table>
    </td>
  </tr>
</table>

<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
  <tr>
    <td height="71" class="popup">
      <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
        <tr>
          <td class="btn3_bg">
            <table border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td width="72">
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_close">Close</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
<!-- : ( Button : pop ) (E) -->

    </td>
  </tr>
</table>


<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
