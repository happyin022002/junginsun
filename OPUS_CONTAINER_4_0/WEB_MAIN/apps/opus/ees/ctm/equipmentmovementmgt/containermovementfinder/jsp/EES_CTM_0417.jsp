<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : EES_CTM_0417.jsp
*@FileTitle : EDI Error Report
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
<%@ page import="com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.event.EesCtm0417Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
  EesCtm0417Event event = null;        //PDTO(Data Transfer Object including Parameters)
  Exception serverException = null;    //error from server
  String strErrMsg = "";               //error message
  int rowCount = 0;                    //DB ResultSet list count

  String successFlag = "";
  String codeList  = "";
  String pageRows  = "100";

  String strUsr_id    = "";
  String strUsr_nm    = "";
  Logger log = Logger.getLogger("com.clt.apps.EquipmentMovementMgt.LongTxContainerMovementFinder");

  try {
       SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id =  account.getUsr_id();
    strUsr_nm = account.getUsr_nm();

    event = (EesCtm0417Event)request.getAttribute("Event");
    serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

    if (serverException != null) {
      strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
    }

    
    GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

  } catch(Exception e) {
    out.println(e.toString());
  }


  // Duration end date(Today)
  String pDate2 = DateTime.getFormatDate(new java.util.Date(), "yyyy-MM-dd");
  // Duration start date(Today -1 Month)
  String pDate1 = DateTime.addMonths(pDate2, -1, "yyyy-MM-dd");
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
<!-- developer job -->

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
     <!-- biz_1  (S) -->
     <table border="0" >
       <tr>
         <th width="100px">Receiving Date</th>
         <td width="240px"><input type="text" style="width:80px;ime-mode:disabled;" class="input1" value="<%=pDate1%>" tabindex="1" name="p_date1">~
           <input type="text" style="width:80px;ime-mode:disabled;" class="input1" value="<%=pDate2%>" tabindex="2" name="p_date2"><!--
            --><button type="button" class="calendar" name="btn_Calendar" id="btn_Calendar"></button></td>
         <th class="stm" width="60px">Count Solved By</th>
         <td class="stm">
           <input type="radio" name="slvd_cnt_dt" id="slvd_cnt" value="R" class="trans" checked>Receiving Date&nbsp;&nbsp;&nbsp;
           <input type="radio" name="slvd_cnt_dt" id="slvd_cnt" value="S" class="trans">Solved Date&nbsp;&nbsp;&nbsp;
         </td>
       </tr>
     </table>
     <table border="0" > 

       <tr class="h23">
         <th width="100px">RCC</th>
         <td width="106px"><script language="javascript">ComComboObject('rcc_cd', 1, 70, 1, 1, 0, 0, 3)</script></td>
         <th width="20px">LCC</th>
         <td width="100px"><script language="javascript">ComComboObject('lcc_cd', 1, 70, 0, 0, 0, 0, 4)</script></td>
         <th width="30px">Yard</th>
         <td width="55px" style="padding-top:1;"><input type="text" style="width:55;text-align:center;ime-mode:disabled;" class="input" maxlength="5" tabindex="5" name="yd_cd_disp" id="yd_cd_disp" ><input type="hidden" name="p_yard1"></td>
         <td width="60px"><script language="javascript">ComComboObject("p_yard2", 2, 50, 0, 0, 0, 0, 10)</script></td>
         <td width="*"><table class="search" border="0" style="width:370px;">
             <tr class="h23">
               <th class="stm" width="60px">Data By</th>             
               <td class="stm">
                 <input type="radio" name="data_radio" value="RCC" class="trans">RCC&nbsp;&nbsp;&nbsp;
                 <input type="radio" name="data_radio" value="CN" class="trans">CN&nbsp;&nbsp;&nbsp;
                 <input type="radio" name="data_radio" value="LCC" class="trans">LCC&nbsp;&nbsp;&nbsp;
                 <input type="radio" name="data_radio" value="LOC" class="trans">Location&nbsp;&nbsp;&nbsp;
                 <input type="radio" name="data_radio" value="Yard" class="trans" checked> Yard
               </td>
             </tr>
           </table></td>
       </tr>
     </table>
     <!-- biz_1   (E) -->
</div>
<!-- 검색영역 -->
</div>
<div class="wrap_result">
<!-- 시트영역 -->
<div class="opus_design_grid">	
	<script language="javascript">ComSheetObject('sheet1');</script>
    <table class="height_2"><tr><td colspan="8"></td></tr></table>
    <table class="grid2" border="0" style="width:979px;">
      <tr class="h23">
        <th width="10%" class="tr2_head">Summary</th>
        <td width="10%" class="tr2_head2">Remained Error</td>
        <td width="10%" class="noinput2"><input type="text" style="width:100%;text-align:right" class="noinput2" name="corr_err"></td>
        <td width="10%" class="noinput2"><input type="text" style="width:100%;text-align:center" class="noinput2" name="corr_err_ratio"></td>
        <td width="10%" class="tr2_head2">Initial Error</td>
        <td width="10%" class="noinput2"><input type="text" style="width:100%;text-align:right" class="noinput2" name="init_err"></td>
        <td width="10%" class="noinput2"><input type="text" style="width:100%;text-align:center" class="noinput2" name="init_err_ratio"></td>
        <td width="10%" class="tr2_head2">Total</td>
        <td class="noinput2"><input type="text" style="width:100%;text-align:right" class="noinput2" name="init_ttl"></td>
      </tr>
    </table>
</div>
<div class="opus_design_grid">	
	<script language="javascript">ComSheetObject('sheet2');</script>
</div>
<!-- 시트영역 -->
<input type="hidden" name="backendjob_key">
</div>
</form>
