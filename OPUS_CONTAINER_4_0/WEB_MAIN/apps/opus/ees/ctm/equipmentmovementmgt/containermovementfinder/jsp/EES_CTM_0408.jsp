<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : EES_CTM_0408.jsp
*@FileTitle : Each Container
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/21
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.event.EesCtm0408Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
  EesCtm0408Event  event = null;       //PDTO(Data Transfer Object including Parameters)
  Exception serverException = null;    //error from server
  String strErrMsg = "";               //error message
  int rowCount   = 0;                  //DB ResultSet list count

  String successFlag = "";
  String codeList = "";
  String pageRows = "100";

  String strUsr_id = "";
  String strUsr_nm = "";
  Logger log = Logger.getLogger("com.clt.apps.EquipmentMovementMgt.ContainerMovementFinder");

  try {
    SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id = account.getUsr_id();
    strUsr_nm = account.getUsr_nm();

    event = (EesCtm0408Event)request.getAttribute("Event");
    serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

    if (serverException != null) {
      strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
    }

    
    GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

  } catch(Exception e) {
    out.println(e.toString());
  }


  // Container No.
  String pCntrno = (request.getParameter("p_cntrno") == null)? "": request.getParameter("p_cntrno");
  // checkDigit
  String checkDigit = (request.getParameter("check_digit") == null)? "": request.getParameter("check_digit");
  pCntrno = pCntrno + checkDigit;
  // ctnrTpszCd
  String ctnrTpszCd = (request.getParameter("ctnr_tpsz_cd") == null)? "": request.getParameter("ctnr_tpsz_cd");

  // Duration end date (Hidden - Today)
  String tempDate2 = DateTime.getFormatDate(new java.util.Date(), "yyyy-MM-dd");
  // Duration start date (Hidden - the date before 6 months)
  String tempDate1 = DateTime.addMonths(tempDate2, -6, "yyyy-MM-dd");

  // Duration end date (tempDate2 in case of no request)
  String pDate2 = (request.getParameter("p_date2") == null)? tempDate2: request.getParameter("p_date2");
  // Duration start date (tempDate1 in case of no request)
  String pDate1 = (request.getParameter("p_date1") == null)? tempDate1: request.getParameter("p_date1");

  // pop_mode
  String popMode = (request.getParameter("pop_mode") == null)? "N": "Y";
%>

<script type="text/javascript">
  function setupPage() {
    var errMessage = "<%=strErrMsg%>";
    if (errMessage.length >= 1) {
      showErrMessage(errMessage);
    } // end if
    loadPage();
  }
</script>

<form name="form">
<% if (popMode.equals("Y")) { %>
<!-- popup_title_area(S) -->
 <div class="layer_popup_title">
    <!-- page_title_area(S) -->
    <div class="page_title_area clear">
        <!-- page_title(S) -->
        <h2 class="page_title"><span>Each Container Inquiry</span></h2>
        <!-- page_title(E) -->
        <!-- opus_design_btn(S) -->
        <div class="opus_design_btn">
            <button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--  
            --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button>
            <button type="button" class="btn_normal" name="btn_cycle_no" id="btn_cycle_no">Cycle No.</button>
            <!--  
            --><button type="button" class="btn_normal" name="btn_eachbkg" id="btn_eachbkg">Each BKG</button><!--  
            --><button type="button" class="btn_normal" name="btn_delhist" id="btn_delhist">DEL History</button><!--  
            --><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
        </div>
        <!-- opus_design_btn(E) --> 
    </div>
    <!-- page_title_area(E) -->
</div>
<!-- popup_title_area(E) -->     

<% } else { %>
<div class="page_title_area clear">
        <h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
        <!-- page_title(E) -->
        <!-- btn_div -->
    <div class="opus_design_btn">
        <button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--  
        --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button>
        <button type="button" class="btn_normal" name="btn_cycle_no" id="btn_cycle_no">Cycle No.</button>
        <!-- 
        --><button type="button" class="btn_normal" name="btn_delhist" id="btn_delhist">DEL History</button>
    </div>

   <!-- page_location(S) -->
   <div class="location">
        <span id="navigation"></span>
   </div>
</div>
<% } %>
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="temp_date1" value="<%=tempDate1%>" id="temp_date1" />
<input type="hidden" name="temp_date2" value="<%=tempDate2%>" id="temp_date2" />

<% if (popMode.equals("Y")) { %>
    <!-- popup_contens_area(S) -->
    <div class="layer_popup_contents">
<% } %>
<div class="wrap_search">
    <div class="opus_design_inquiry wFit">      
          <table>
            <colgroup>
                <col width="80">
                <col width="150">
                <col width="130">
                <col width="*">
            </colgroup>
            <tbody>
                <tr>
                      <th>Container No.</th>
                      <td><input type="text" style="width:90px;ime-mode:disabled;" class="input1" maxlength="11" value="<%=pCntrno%>" tabindex="1" name="p_cntrno" id="p_cntrno" dataformat="engup"><!-- 
                           <input type="text" style="width:20px;" class="input" value="" maxlength="1" name="check_digit" id="check_digit">
                           --><input type="text" style="width:25px;" class="input" readonly="true" value="<%=ctnrTpszCd%>" name="ctnr_tpsz_cd" id="ctnr_tpsz_cd"><!--
                           --><input type="text" style="width:0px;ime-mode:disabled;display:none" maxlength="1" tabindex="2" name="temp_0" id="temp_0">
                      </td>
                      <th>Duration</th>
                      <td><input type="text" style="width:80px;ime-mode:disabled;" class="input1" value="<%=pDate1%>" tabindex="3" name="p_date1" id="p_date1">~ <!-- 
                           --><input type="text" style="width:80px;ime-mode:disabled;" class="input1" value="<%=pDate2%>" tabindex="4" name="p_date2" id="p_date2"><!-- 
                           --><button type="button" class="calendar" name="btn_Calendar" id="btn_Calendar"></button>
                      </td>
                </tr>
             </tbody>
          </table>
    </div>
</div>
<div class="wrap_result">
    <div class="opus_design_grid">  
        <script type="text/javascript">ComSheetObject('sheet1');</script>
    </div>
    <h3 class="title_design">EDI error message</h3>
    <div class="opus_design_grid">       
        <script type="text/javascript">ComSheetObject('sheet2');</script>
    </div>
</div>
<% if (popMode.equals("Y")) { %>
</div>
<!-- popup_contens_area(E) -->
<% } %>

</form>