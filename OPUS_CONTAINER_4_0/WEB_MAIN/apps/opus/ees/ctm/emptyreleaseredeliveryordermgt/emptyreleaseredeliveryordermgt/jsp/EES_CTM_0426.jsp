<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CTM_0426.jsp
*@FileTitle  : Release/Re-delivery Order
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.config.SiteConfigFactory"%>
<%@ page import="com.clt.framework.core.layer.event.EventResponse"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.event.EesCtm0426Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
  EesCtm0426Event  event = null;    //PDTO(Data Transfer Object including Parameters)
  Exception serverException = null;    //error from server
  String strErrMsg = "";    //error message
  int rowCount = 0;    //DB ResultSet List count

  String successFlag = "";
  String codeList = "";
  String pageRows = "100";

  String strUsr_id = "";
  String strUsr_nm = "";
  String strUsr_eml = "";
  String strUsr_ofc = "";
  List<String> mailKey = new ArrayList();

  Logger log = Logger.getLogger("com.clt.apps.EmptyReleaseRedeliveryOrderMgt.EmptyReleaseRedeliveryOrderMgt");

  try {
    SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id =  account.getUsr_id();
    strUsr_nm = account.getUsr_nm();
    strUsr_eml = account.getUsr_eml();
    strUsr_ofc = account.getOfc_cd();

    event = (EesCtm0426Event)request.getAttribute("Event");
    serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

    if (serverException != null) {
      strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
    }

    if(request.getAttribute("EventResponse") != null){
     
      GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
      mailKey = (List<String>)eventResponse.getCustomData(SiteConfigFactory.get("COM.MAIL.KEYS"));
    }

  } catch(Exception e) {
    out.println(e.toString());
  }


  // Duration start date
  String pDate1 = DateTime.addDays(DateTime.getFormatDate(new java.util.Date(), "yyyy-MM-dd"), -7, "yyyy-MM-dd");
  // Duration end date
  String pDate2 = DateTime.addMonths(pDate1, 1, "yyyy-MM-dd");

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


<input type="hidden" name="mail_key" value="<%=mailKey%>">
<input type="hidden" name="sub_sys_cd" value="CTM">                    <!-- Mail Module -->
<input type="hidden" name="sender_usr_id" value="<%=strUsr_id%>">      <!-- RD/Mail Sender ID -->
<input type="hidden" name="sender_usr_nm" value="<%=strUsr_nm%>">      <!-- Mail Sender Name -->
<input type="hidden" name="sender_usr_eml" value="<%=strUsr_eml%>">    <!-- Mail Sender E-Mail -->
<input type="hidden" name="sender_usr_ofc" value="<%=strUsr_ofc%>">    <!-- RD/Fax Sender Office -->
<input type="hidden" name="sender_usr_cnt">                            <!-- RD User Country -->
<input type="hidden" name="receiver_eml">                              <!-- Mail Receiver E-Mail -->
<input type="hidden" name="receiver_fax">                              <!-- FAX Receiver Fax No. -->
<input type="hidden" name="tmpl_mrd" value="EES_CTM_0451.mrd">         <!-- Mail Template MRD -->
<input type="hidden" name="issue_flag">
<input type="hidden" name="issue_type">
<input type="hidden" name="tmpl_param">
<input type="hidden" name="rd_content">

<!-- page_title_area(S) -->
<div class="page_title_area clear ">
    <!-- page_title(S) -->
    <h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
    <!-- page_title(E) -->
        
    <!-- opus_design_btn(S) -->
    <div class="opus_design_btn">
        <button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
        --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--
        --><button type="button" class="btn_normal" name="btn_downExcel" id="btn_downExcel">Down Excel</button><!--
        --><button type="button" class="btn_normal" name="btn_settled" id="btn_settled">Settled</button><!--
        --><button type="button" class="btn_normal" name="btn_preview" id="btn_preview">Preview</button>
    </div>
    <!-- opus_design_btn(E) -->
        
    <!-- page_location(S) -->
    <div class="location">
    <!-- location 내용 동적생성 (별도 코딩 불필요) -->
    <span id="navigation"></span>
    </div>
    
</div>
<!-- page_title_area(E) -->


<!-- wrap_search(S) -->
<div class="wrap_search">
    <div class="opus_design_inquiry wFit">   <!-- no TAB  -->
        <table>
             <tr>
               <th>Date</th>
               <td colspan="3">
                  <input type="text" style="width:84px;ime-mode:disabled;" class="input1" value="<%=pDate1%>" tabindex="1" id="p_date1" name="p_date1" dataformat="ymd" cofield="p_date2"><!--
                  --><span class="dash">-</span><!--
                  --><input type="text" style="width:85px;ime-mode:disabled;" class="input1" value="<%=pDate2%>" tabindex="2" id="p_date2" name="p_date2" dataformat="ymd" cofield="p_date1"><!--
                  --><button type="button" class="calendar ir" name="btn_Calendar" id="btn_Calendar"></button>
               </td>
               <th id="bkg_no_head">BKG No.</th>
               <td><input type="text" style="width:120px;ime-mode:disabled;" class="input" maxlength="13" tabindex="6" name="bkg_no" dataformat="engup"></td>
               <th>LCC</th>
               <td><input type="text" style="width:121px;ime-mode:disabled;" class="input" maxlength="13" tabindex="8" name="lcc_cd"></td>
             </tr>
             
             
             <tr>
               <th>Territory</th>
               <td colspan="3"><script type="text/javascript">ComComboObject("territory", 2, 214, 1, 0, 0, 0, 3)</script><input type="hidden" name="office"></td>
               <th id="bl_no_head">B/L No.</th>
               <td><input type="text" style="width:120px;ime-mode:disabled;" class="input" maxlength="13" tabindex="6" name="bl_no" dataformat="engup"></td>
               <th>Empty CY</th>
               <td><input type="text" style="width:72px;ime-mode:disabled;" class="input" maxlength="5" tabindex="9" name="yd_cd_disp" dataformat="engup" onBlur="obj_onkeyup();"><!--
                 --><input type="hidden" name="p_yard1"><!--
                 --><script type="text/javascript">ComComboObject("p_yard2", 2, 45, 0, 0, 0, 0, 10)</script></td>
             </tr>
             <tr>
               <th width="70">Type</th>
               <td width="100"><select style="width:95px;" tabindex="4" name="type" onchange="obj_onchange()">
                   <option value="RLS" selected>Release</option>
                   <option value="RDV">Redelivery</option>
                 </select></td>
               <th width="45">Issued</th>
               <td width="130"><select style="width:61px;" tabindex="5" name="issued" onchange="obj_onchange()">
                   <option value="N" selected>No</option>
                   <option value="Y">Yes</option>
                 </select></td>
               <th width="90">CNTR No.</th>
               <td width="170"><input type="text" style="width:120px;ime-mode:disabled;" class="input" maxlength="11" tabindex="7" name="cntr_no" dataformat="engup"></td>
               <th width="90">W/O No.</th>
               <td><input type="text" style="width:121px;ime-mode:disabled;" class="input" maxlength="13" tabindex="11" name="wo_no"></td>
             </tr>
        </table>
    </div>
</div>
<!-- wrap_search(E) -->



<!-- wrap_result(S) -->
<div class="wrap_result" >

    <!-- opus_design_grid(S) -->
    <div class="opus_design_grid">
    
        <script type="text/javascript">ComSheetObject('sheet1');</script>
        <script type="text/javascript">ComSheetObject('sheet2');</script>
        
    </div>
    <!-- opus_design_grid(E) -->
    
    
</div>
<!-- wrap_result(E) -->


</form>
