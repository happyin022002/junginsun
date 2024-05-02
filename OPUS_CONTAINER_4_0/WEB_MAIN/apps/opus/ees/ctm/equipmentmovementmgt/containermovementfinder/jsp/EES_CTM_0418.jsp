<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : EES_CTM_0418.jsp
*@FileTitle : MVMT Timely Update Ratio
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/26
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.backend.support.BackEndJobResult"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.event.EesCtm0418Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
    EesCtm0418Event event = null;    //PDTO(Data Transfer Object including Parameters)
    Exception serverException  = null;    //error from server
    String strErrMsg = "";    //error message
    int rowCount  = 0;    //DB ResultSet list count

    String successFlag = "";
    String codeList = "";
    String pageRows = "100";

    String strUsr_id  = "";
    String strUsr_nm  = "";

    try {
        SignOnUserAccount account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();

        event = (EesCtm0418Event)request.getAttribute("Event");
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
    // the date before 1 month
    String strStartdate = DateTime.addMonths(strEnddate, -1, "yyyy-MM-dd");
    // ediMvmtStsCd
    String ediMvmtStsCd = (request.getParameter("ediMvmtStsCd") == null)? "": "'" + request.getParameter("ediMvmtStsCd") + "'";
%>
<script language="javascript">
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
<input type="hidden" name="edi_type">
<input type="hidden" name="time_off">
<input type="hidden" name="p_yard">
<input type="hidden" name="backendjob_key">
<!-- developer job  -->

<!-- 제목 -->
<div class="page_title_area clear">
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->

		<!-- btn_div -->
	<div class="opus_design_btn">
	    <button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--  
	    --><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button>
	</div>

   <!-- page_location(S) -->
   <div class="location">
		<span id="navigation"></span>
   </div>
</div>
<!-- 제목 -->
<div class="wrap_search">
<!-- 검색영역 -->
<div class="opus_design_inquiry wFit">		
	<!--  biz_1 (S) -->
       <table border="0" >
               <tr class="h23">
                 <th width="70">Event Date</th>
                 <td width="220"><input type="text" style="width:80px;ime-mode:disabled;" class="input1" value="<%=strStartdate%>" tabindex="1" name="p_date1">&nbsp;~
                   <input type="text" style="width:80px;ime-mode:disabled;" class="input1" value="<%=strEnddate%>" tabindex="2" name="p_date2"><button type="button" name="btn_Calendar" class="calendar" ></button>&nbsp;&nbsp;</td>
                 <th width="50">Status</th>
                 <td width="110"><script type="text/javascript">ComComboObject("statusCombo", 1, 50, 1, 0, 0, 0, 3);</script><input type="hidden" name="sts_cd">&nbsp;&nbsp;</td>
                 <th width="50">F/M</th>
                 <td width="*"><!-- <select style="width:50px;" tabindex="4" name="fcntr_flg">
                   <option value="" selected>ALL</option>
                   <option value="Y">F</option>
                   <option value="N">M</option>
                 </select> -->
                 <script type="text/javascript">ComComboObject("fcntr_flg", 1, 50, 1, 0, 0, 0, 3);</script>
                 </td>
              
           
           <td width="*">
           	 <table class="search" border="0">
               <tr class="h23">
                 <th width="52px" style="text-align:left">&nbsp;GAP</th>
                 <td class="stm" style="text-align:left"><input type="radio" value="0" name="gap" class="trans" checked onClick="gap_Change();">&nbsp;ALL&nbsp;&nbsp;
                   <input type="radio" value="12" name="gap" class="trans" onClick="gap_Change();">&nbsp;12 Hour&nbsp;&nbsp;
                   <input type="radio" value="24" name="gap" class="trans" onClick="gap_Change();">&nbsp;24 Hour&nbsp;&nbsp;
                   <input type="radio" value="48" name="gap" class="trans" onClick="gap_Change();">&nbsp;48 Hour&nbsp;&nbsp;
                   </td>
               </tr>
             </table>
           </td>
         </tr>
           </table>
          <table class="search" border="0">
               <tr class="h23">
                 <th width="70px">RCC</th>
                 <td width="98px"><script language="javascript">ComComboObject('rcc_cd', 1, 70, 1, 1, 0, 0, 5)</script></td>
                 <th width="33px">LCC</th>
                 <td width="99px"><script language="javascript">ComComboObject('lcc_cd', 1, 70, 0, 0, 0, 0, 6)</script></td>
                 <th width="32px">Yard</th>
                 <td width="273px" style="padding-top:1;"><input type="text" maxlength="5" style="width:55px;" class="input" tabindex="5" name="p_yard1" id="p_yard1" dataformat ="engup" ><!-- 
                  --><script language="javascript">ComComboObject('p_yard2', 2, 50 , 0, 0, 0, 0, 7)</script></td>
               
           <td>
           	 <table border="0"">
               <tr class="h23">
                 <th width="52px" style="text-align:left">&nbsp;Data By</th>
               	   <td width="*" class="stm"><input type="radio" value="1" name="data_by" class="trans">&nbsp;RCC&nbsp;&nbsp;
                   <input type="radio" value="5" name="data_by" class="trans">&nbsp;CN&nbsp;&nbsp;
                   <input type="radio" value="2" name="data_by" class="trans">&nbsp;LCC&nbsp;&nbsp;
                   <input type="radio" value="3" name="data_by" class="trans">&nbsp;Location&nbsp;&nbsp;
                   <input type="radio" value="4" name="data_by" class="trans" checked>&nbsp;Yard&nbsp;&nbsp;
                   </td>
               </tr>
           </table>
           </td>
         </tr>
       </table>
     <!--  biz_1   (E) -->
</div>
<!-- 검색영역 -->
</div>
<div class="wrap_result">
<!-- 시트영역 -->
<div class="opus_design_grid">	
	<script language="javascript">ComSheetObject('sheet1');</script>
	<table class="height_2"><tr><td colspan="8"></td></tr></table>
    <table class="grid2" border="0" style="width:1024px;">
      <tr class="h23">
        <th width="65px" class="tr2_head">Summary</th>
        <td width="60px" class="tr2_head2">12 Hour</td>
        <td width="82px" class="noinput2"><input type="text" style="width:80px;text-align:right" class="noinput2" readonly="true" name="c12"></td>
        <td width="57px" class="noinput2"><input type="text" style="width:55px;text-align:center" class="noinput2" readonly="true" name="p12"></td>
        <td width="60px" class="tr2_head2">24 Hour</td>
        <td width="82px" class="noinput2"><input type="text" style="width:80px;text-align:right" class="noinput2" readonly="true" name="c24"></td>
        <td width="57px" class="noinput2"><input type="text" style="width:55px;text-align:center" class="noinput2" readonly="true" name="p24"></td>
        <td width="60px" class="tr2_head2">48 Hour</td>
        <td width="82px" class="noinput2"><input type="text" style="width:80px;text-align:right" class="noinput2" readonly="true" name="c48"></td>
        <td width="57px" class="noinput2"><input type="text" style="width:55px;text-align:center" class="noinput2" readonly="true" name="p48"></td>
        <td width="45px" class="tr2_head2">Over</td>
        <td width="82px" class="noinput2"><input type="text" style="width:80px;text-align:right" class="noinput2" readonly="true" name="c72"></td>
        <td width="57px" class="noinput2"><input type="text" style="width:55px;text-align:center" class="noinput2" readonly="true" name="p72"></td>
        <td width="45px" class="tr2_head2">Total</td>
        <td class="noinput2"><input type="text" style="width:80px;text-align:right" class="noinput2" readonly="true" name="c_a"></td>
      </tr>
    </table>
</div>

<div style="display:none">
	<script language="javascript">ComSheetObject('sheet2');</script>
</div>
<!-- 시트영역 -->
</div>
<!-- end of developer job -->
</form>
