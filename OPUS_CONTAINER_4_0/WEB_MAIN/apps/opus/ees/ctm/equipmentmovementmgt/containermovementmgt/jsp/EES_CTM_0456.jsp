<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CTM_0456.jsp
*@FileTitle  : Pre-booked VL/VD Correction
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
<%@ page import="com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.event.EesCtm0456Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
  EesCtm0456Event event = null;        //PDTO(Data Transfer Object including Parameters)
  Exception serverException = null;    //error from server
  String strErrMsg = "";               //error message
  int rowCount = 0;                    //DB ResultSet list count

  String successFlag = "";
  String codeList = "";
  String pageRows = "100";

  String strUsr_id = "";
  String strUsr_nm = "";
  String strUsr_ofc = "";
  Logger log = Logger.getLogger("com.clt.apps.EquipmentMovementMgt.ContainerMovementMgt");

  try {
    SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id = account.getUsr_id();
    strUsr_nm = account.getUsr_nm();
    strUsr_ofc = account.getOfc_cd();

    event = (EesCtm0456Event)request.getAttribute("Event");
    serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

    if (serverException != null) {
      strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
    }

    
    GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

  } catch(Exception e) {
    out.println(e.toString());
  }


  // Duration 시작일(현재일)
  String pDate1 = DateTime.getFormatDate(new java.util.Date(), "yyyy-MM-dd");
  // Duration 종료일(현재일 +7)
  String pDate2 = DateTime.addDays(pDate1, 7, "yyyy-MM-dd");
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
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="error_status" id="error_status">
<!-- developer job -->

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
        <button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
        --><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button><!--
        --><button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button>
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
<div class="opus_design_inquiry wFit">
    <!--  biz_1 (S) -->
    <table>
        <colgroup>
            <col width="80"  />
            <col width="220"  />
            <col width="60"  />
            <col width="70"  />
            <col width="60"  />
            <col width="70"  />
            <col width="60" />
            <col width="130"  />
            <col width="60"  />
            <col width="90"  />
            <col width="60"  />
            <col width="80"  />
            <col width=""    />
        </colgroup>
        <tbody>
            <tr>
                <th>Event Date</th>
                <td>
                    <input type="text" style="width:80px;ime-mode:disabled;" class="input1" value="<%=pDate1%>" tabindex="1" name="p_date1" id="p_date1">~&nbsp;<!-- 
                    --><input type="text" style="width:80px;ime-mode:disabled;" class="input1" value="<%=pDate2%>" tabindex="2" name="p_date2" id="p_date2"><!-- 
                    --><button type="button" class="calendar ir" name="btn_Calendar" id="btn_Calendar"></button>
                <th>Office</th>
                <td><input type="text" style="width:65px;text-align:center;ime-mode:disabled;" class="input1" dataformat="engup" value="<%=strUsr_ofc%>" maxlength="6" tabindex="3" name="office" id="office"></td>
                <th>Status</th>
                <td>
                    <select style="width:55px;"class="input" tabindex="4" name="status" id="status">
                        <option value="VL" selected>VL</option>
                        <option value="VD">VD</option>
                    </select>
                </td>
                <th>Yard</th>
                <td>
                    <input type="text" style="width:55px;ime-mode:disabled;" class="input" dataformat="engup" maxlength="5" tabindex="5" name="yd_cd_disp" id="yd_cd_disp"><!-- 
                    --><input type="hidden" name="p_yard1" id="p_yard1"><script type="text/javascript">ComComboObject("p_yard2", 2, 50, 0, 0, 0, 0, 6)</script></td>
                <th title="Vessel Voyage Direction">VVD</th>
                <td><input type="text" style="width:80px;ime-mode:disabled;" class="input" dataformat="engup" maxlength="9" tabindex="7" name="vvd" id="vvd"></td>
                <th>Type</th>
                <td>
                    <select style="width:65px;"class="input" tabindex="8" name="fm" id="fm">
                        <option value="" selected>All</option>
                        <option value="F">Full</option>
                        <option value="M">Empty</option>
                    </select>
                </td>
                <td><b>Error</b>&nbsp;<input name="error" id="error" type="checkbox" class="trans" value="Y" maxlength="9" tabindex="9"></td>
            </tr>
        </tbody>
    </table>
    <!--  biz_1   (E) -->   
</div>
<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
<!-- opus_design_grid(S) -->
<div class="opus_design_grid" >
    <!-- opus_grid_btn(S) -->
    <div class="opus_design_btn">
        <button type="button" class="btn_normal" name="btn_Delete" id="btn_Delete">Row Delete</button>
    </div>
    <!-- opus_grid_btn(E) -->
    <script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
<!-- opus_design_grid(E) -->
</div>
</form>
