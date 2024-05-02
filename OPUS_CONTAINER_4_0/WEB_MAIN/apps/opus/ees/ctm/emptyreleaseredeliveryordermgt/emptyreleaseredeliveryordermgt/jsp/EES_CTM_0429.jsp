<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CTM_0429.jsp
*@FileTitle  : Release/Redelivery History(Europe)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/27
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.event.EesCtm0429Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
  EesCtm0429Event  event = null;    //PDTO(Data Transfer Object including Parameters)
  Exception serverException = null;    //error from server
  String strErrMsg = "";    //error message
  int rowCount = 0;    //DB ResultSet List count

  String successFlag = "";
  String codeList = "";
  String pageRows = "100";

  String strUsr_id = "";
  String strUsr_nm = "";
  Logger log = Logger.getLogger("com.clt.apps.EmptyReleaseRedeliveryOrderMgt.EmptyReleaseRedeliveryOrderMgt");

  try {
    SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id =  account.getUsr_id();
    strUsr_nm = account.getUsr_nm();

    event = (EesCtm0429Event)request.getAttribute("Event");
    serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

    if (serverException != null) {
      strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
    }

    GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

  } catch(Exception e) {
    out.println(e.toString());
  }


  // Duration start date
  String pDate1 = DateTime.addDays(DateTime.getFormatDate(new java.util.Date(), "yyyy-MM-dd"), -7, "yyyy-MM-dd");
  // Duration end date
  String pDate2 = DateTime.addDays(DateTime.getFormatDate(new java.util.Date(), "yyyy-MM-dd"), 7, "yyyy-MM-dd");
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
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- developer job -->
<input type="hidden" name="backendjob_key">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
    <!-- page_title(S) -->
    <h2 class="page_title">
        <button type="button">
            <span id="title"></span>
        </button>
    </h2>
    <!-- page_title(E) -->

    <!-- opus_design_btn(S) -->
    <div class="opus_design_btn">
        <button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button>
        <button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button>
        <button type="button" class="btn_normal" name="btn_downExcel" id="btn_downExcel">Down Excel</button>
        <button type="button" class="btn_normal" name="btn_recovery" id="btn_recovery">Recovery</button>
    </div>
    <!-- opus_design_btn(E) -->

    <!-- page_location(S) -->
    <div class="location">
        <span id="navigation"></span>
    </div>
    <!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry">
    <!-- layout_wrap(S) -->
    <div class="layout_wrap">
        <!-- layout_vertical_3(S) -->
        <div class="layout_vertical_3 pad_rgt_8" style="width:25%">
            <!--  biz_1 (S) -->
            <table class="grid2">
                <colgroup>
                    <col width="80"  />
                    <col width="196" />
                </colgroup>
                <tbody>
                    <tr>
                        <th>Date</th>
                        <td>
                            <input type="text" style="width:78px;ime-mode:disabled;" class="input1" value="<%=pDate1%>" tabindex="1" name="p_date1">~
                            <input type="text" style="width:79px;ime-mode:disabled;" class="input1" value="<%=pDate2%>" tabindex="2" name="p_date2"><!-- 
                             --><button type="button" class="calendar ir" name="btn_Calendar" id="btn_Calendar"></button>
                        </td>
                    </tr>
                    <tr>
                        <th>Territory</th>
                        <td><script language="javascript">ComComboObject('territory', 2, 196, 1, 0, 0, 0, 3)</script><input type="hidden" name="office"></td>
                    </tr>
                    <tr>
                        <th>Type</th>
                        <td>
                            <select style="width:198px;" tabindex="4" name="type">
                                <option value="O" selected>Release</option>
                                <option value="I">Redelivery</option>
                            </select>
                        </td>
                    </tr>
                </tbody>
            </table>
            <!--  biz_1   (E) -->
        </div>
        <!-- layout_vertical_3(E) -->

        <!-- layout_vertical_3(S) -->
        <div class="layout_vertical_3 pad_rgt_8" style="width:20%">
            <!--  biz_1 (S) -->
            <table class="grid2">
                <colgroup>
                    <col width="80"  />
                    <col width="120" />
                </colgroup>
                <tbody>
                    <tr>
                        <th>BKG No.</th>
                        <td><input type="text" style="width:120px;ime-mode:disabled;" class="input" maxlength="13" tabindex="5" name="bkg_no" dataformat ="engup"></td>
                    </tr>
                    <tr>
                        <th>B/L No.</th>
                        <td><input type="text" style="width:120px;ime-mode:disabled;" class="input" maxlength="13" tabindex="5" name="bl_no" dataformat ="engup"></td>
                    </tr>
                    <tr>
                        <th>CNTR No.</th>
                        <td><input type="text" style="width:120px;ime-mode:disabled;" class="input" maxlength="11" tabindex="6" name="cntr_no" dataformat ="engup"></td>
                    </tr>
                </tbody>
            </table>
            <!--  biz_1   (E) -->
        </div>
        <!-- layout_vertical_3(E) -->

        <!-- layout_vertical_3(S) -->
        <div class="layout_vertical_3 pad_rgt_8" style="width:20%">
            <!--  biz_1 (S) -->
            <table class="grid2">
                <colgroup>
                    <col width="80"  />
                    <col width="120" />
                </colgroup>
                <tbody>
                    <tr>
                        <th>LCC</th>
                        <td><input type="text" style="width:125px;ime-mode:disabled;" class="input" maxlength="13" tabindex="7" name="lcc_cd" dataformat ="engup"></td>
                    </tr>
                    <tr>
                        <th>Empty CY</th>
                        <td>
                            <input type="text" style="width:72px;ime-mode:disabled;" class="input" maxlength="5" tabindex="8" name="yd_cd_disp" dataformat ="engup">
                            <input type="hidden" name="p_yard1">
                            <script type="text/javascript">ComComboObject("p_yard2", 2, 45, 0, 0, 0, 0, 9)</script>
                        </td>
                    </tr>
                    <tr>
                        <th>W/O No.</th>
                        <td><input type="text" style="width:125px;ime-mode:disabled;" class="input" maxlength="13" tabindex="10" name="wo_no" dataformat ="engup"></td>
                    </tr>
                </tbody>
            </table>
            <!--  biz_1   (E) -->
        </div>
        <!-- layout_vertical_3(E) -->
    </div>
    <!-- layout_wrap(E) -->
</div>
<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
<!-- opus_design_grid(S) -->
<div class="opus_design_grid" >
    <script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
<!-- opus_design_grid(E) -->
</div>
</form>
