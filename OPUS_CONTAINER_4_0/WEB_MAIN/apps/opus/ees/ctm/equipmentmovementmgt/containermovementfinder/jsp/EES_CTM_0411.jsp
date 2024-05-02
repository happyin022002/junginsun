<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : EES_CTM_0411.jsp
*@FileTitle : Detail Form
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
<%@ page import="com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.event.EesCtm0411Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EesCtm0411Event  event = null;         //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;    //error from server
    String strErrMsg = "";                 //error message
    int rowCount     = 0;                    //DB ResultSet list count
    String successFlag = "";
    String codeList = "";
    String pageRows = "100";
    String strUsr_id = "";
    String strUsr_nm = "";
    String mainPage = JSPUtil.getNull(request.getParameter("mainPage"));
    Logger log = Logger.getLogger("com.clt.apps.EquipmentMovementMgt.ContainerMovementFinder");
    SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    try {
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        event = (EesCtm0411Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
    } catch(Exception e) {
        out.println(e.toString());
    }
  // current date
  String strEnddate = DateTime.getFormatDate(new java.util.Date(), "yyyy-MM-dd");
  // the date before 6 month
  String strStartdate = DateTime.addMonths(strEnddate, -6, "yyyy-MM-dd");
  String cntrNo = (request.getParameter("cntrNo") == null)? "": request.getParameter("cntrNo");
  String checkDigit = (request.getParameter("checkDigit") == null)? "": request.getParameter("checkDigit");
  cntrNo = cntrNo + checkDigit;
  String typeSize = (request.getParameter("typeSize") == null)? "": request.getParameter("typeSize");
  // pop_mode
  String popMode = (request.getParameter("pop_mode") == null)? "N": "Y";
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

<%if(mainPage.equals("false")){%>

<!-- popup_title_area(S) -->
 <div class="layer_popup_title">
    <!-- page_title_area(S) -->
    <div class="page_title_area clear">
        <!-- page_title(S) -->
        <h2 class="page_title"><span> Detail Form Inquiry</span></h2>
        <!-- page_title(E) -->
            
        <!-- opus_design_btn(S) -->
        <div class="opus_design_btn">
            <button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--  
            --><button type="button" class="btn_normal" name="btn_eachbkg" id="btn_eachbkg">Each BKG</button><!-- 
            --><button type="button" class="btn_normal" name="btn_del" id="btn_del">DEL History</button><!-- 
            --><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button><!-- 
            --><button type="button" class="btn_normal" name="btn_clm" id="btn_clm">CLM</button><!-- 
            --><button type="button" class="btn_normal" name="btn_print" id="btn_print">Print</button><!-- 
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
        --><button type="button" class="btn_normal" name="btn_eachbkg" id="btn_eachbkg">Each BKG</button><!--
        --><button type="button" class="btn_normal" name="btn_del" id="btn_del">DEL History</button><!--
        --><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button><!--
        --><button type="button" class="btn_normal" name="btn_clm" id="btn_clm">CLM</button><!--
        --><button type="button" class="btn_normal" name="btn_print" id="btn_print">Print</button>
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
<input type="hidden" name="user_id" value="<%=account.getUsr_id()%>">
<input type="hidden" name="ofc_cd" value="<%=account.getOfc_cd()%>">
<input type="hidden" name="cnt_cd">

<%if(mainPage.equals("false")){%>
    <!-- popup_contens_area(S) -->
    <div class="layer_popup_contents">
<% } %>

<!-- opus_design_inquiry(S) -->
<div class="wrap_search">
<div class="opus_design_inquiry wFit">  
    <!--  biz_1  (S) -->
    <table class="search" border="0" style="width:979px;">
       <tr class="h23">
         <th width="90px">Container No.</th>
         <td width="220px"><input type="text" style="width:90px;" tabindex="1" name="p_cntrno" id="p_cntrno" class="input1" maxlength='11' dataformat="engup" value="<%=cntrNo%>"><!-- <input type="text" style="width:20px;" class="input" value="" maxlength="1" name="check_digit">--><input type="text" style="width:25px;" class="input" readonly value="<%=typeSize %>" name="ctnr_tpsz_cd"></td>
         <th width="60px">Duration</th>
         <td><input type="text" style="width:80px;" class="input1" value="<%=strStartdate%>"  tabindex="4" name="p_date1">~ 
           <input type="text" style="width:80px;" class="input1" value="<%=strEnddate%>" tabindex="5" name="p_date2"><button type="button" class="calendar ir" name="btn_Calendar2" id="btn_Calendar2"></button></td>
       </tr>
     </table>
     <!--  biz_1   (E) -->
</div>
</div>
<!-- opus_design_inquiry(E) -->

<!-- opus_design_grid(S) -->
<div class="wrap_result">
    <div class="opus_design_grid">
        <h3 class="title_design mar_btm_8">VVD/BKG History</h3>
        <br/>
        <script type="text/javascript">ComSheetObject('sheet1');</script>
    </div>
    
    <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
    
    <div class="opus_design_grid">
        <h3 class="title_design mar_btm_8">Movement History</h3>
        <br/>
        <script type="text/javascript">ComSheetObject('sheet2');</script>
    </div>
    <!-- opus_design_grid(E) -->
</div>
<% if(mainPage.equals("false")){%>
</div>
<!-- popup_contens_area(E) -->
<% } %>

</form>
