<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : EES_CTM_0415.jsp
*@FileTitle : Deleted CNTR MVMT History
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/23
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.event.EesCtm0415Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
  EesCtm0415Event event = null;        //PDTO(Data Transfer Object including Parameters)
  Exception serverException = null;    //error from server
  String strErrMsg = "";               //error message
  int rowCount = 0;                    //DB ResultSet list count

  String successFlag = "";
  String codeList = "";
  String pageRows = "100";

  String strUsr_id = "";
  String strUsr_nm = "";
  Logger log = Logger.getLogger("com.clt.apps.EquipmentMovementMgt.ContainerMovementMasterDataMgt");

  try {
    SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id = account.getUsr_id();
    strUsr_nm = account.getUsr_nm();

    event = (EesCtm0415Event)request.getAttribute("Event");
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
  // Duration end date (today in case of no request)
  String pDate2 = (request.getParameter("p_date2") == null)? DateTime.getFormatDate(new java.util.Date(), "yyyy-MM-dd"): request.getParameter("p_date2");
  // Duration start date (the date before 6 month in case of no request )
  String pDate1 = (request.getParameter("p_date1") == null)? DateTime.addMonths(DateTime.getFormatDate(new java.util.Date(), "yyyy-MM-dd"), -6, "yyyy-MM-dd"): request.getParameter("p_date1");

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
        <h2 class="page_title"><span>&nbsp;Deleted CNTR MVMT history Inquiry</span></h2>
        <!-- page_title(E) -->
            
        <!-- opus_design_btn(S) -->
        <div class="opus_design_btn">
            <button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
            --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--
            --><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
        </div>
        <!-- opus_design_btn(E) --> 
    </div>
    <!-- page_title_area(E) -->
</div>
<!-- popup_title_area(E) -->

     
<% } else { %>

<!-- 제목 -->
<div class="page_title_area clear">
        <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
        <h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
        <!-- page_title(E) -->

        <!-- btn_div -->
    <div class="opus_design_btn">
        <button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
        --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button>
    </div>

   <!-- page_location(S) -->
   <div class="location">
        <span id="navigation"></span>
   </div>
</div>

<!-- 제목 -->
<% } %>

<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<!-- 검색영역 -->
<% if (popMode.equals("Y")) { %>
<div class="layer_popup_contents">
<% } %>
<div class="wrap_search">
    <div class="opus_design_inquiry">       
         <!-- biz_1 (S) -->
         <table border="0" style="width:979px;">
           <tr>
             <th width="90px" class="align_left">Container No.</th>
             <td width="180px">
                <input type="text" style="width:90px;" class="input1"  value="<%=pCntrno%>" maxlength="11"  tabindex="1" style="ime-mode:disabled;" name="p_cntrno" dataformat="engup"><!--
                <input type="text" style="width:18px;" class="input"  value="" readonly="true" name="check_digit" >
                --><input type="text" style="width:28px;" class="input"  value="<%=ctnrTpszCd%>" readonly="true" name="ctnr_tpsz_cd">
            </td>
             <th width="50px" class="align_left">Duration</th>
             <td>
                <input type="text" style="width:75px;" class="input1" value="<%=pDate1%>" style="ime-mode:disabled;" tabindex="2" name="p_date1">~
                <input type="text" style="width:75px;" class="input1" value="<%=pDate2%>" style="ime-mode:disabled;" tabindex="3" name="p_date2"><!--
                --><button type="button" class="calendar" name="btn_Calendar" id="btn_Calendar"></button></td>
           </tr>
         </table>
         <!-- biz_1 (E) -->
    </div>
</div>
<!-- 검색영역 -->

<!-- 시트영역 -->
<div class="wrap_result">
    <div class="opus_design_grid">      
        <script type="text/javascript">ComSheetObject('sheet1');</script>
    </div>
</div>
<!-- 시트영역 -->
<% if (popMode.equals("Y")) { %>
</div>
<% } %>

</form>