<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0273.jsp
*@FileTitle : Full CNTR Release Order History
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.20
*@LastModifier : Son Yun Seuk
*@LastVersion : 1.0
* 2009.07.20 Son Yun Seuk
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0273Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmBkg0273Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount     = 0;                       //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    Logger log = Logger.getLogger("com.hanjin.apps.InboundBLMgtSC.CargoReleaseOrderBC");

    String bl_no = JSPUtil.getNull(request.getParameter("bl_no"));
    String cntr_no = JSPUtil.getNull(request.getParameter("cntr_no"));
    String mode = "";
    if(bl_no.length() >= 12) mode = "POPUP";
    
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();


        event = (EsmBkg0273Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

    }catch(Exception e) {
        out.println(e.toString());
    }
%>
<html>
<head>
<title>Full CNTR Release Order History</title>
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

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="f_rad" value="VVD">
<input type="hidden" name="f_mod" value="<%=mode %>">

<%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp"%>

      <table class="search" id="mainTable"> 
        <tr>
          <td class="bg">
      
            <!--  biz_1  (S) -->
            <table class="search" border="0" style="width:979;"> 
              <tr class="h23">
                 
                <td width="">
                  <table class="search_sm" border="0" style="width:98%;"> 
                    <tr class="h23">
                      
                      <td width="132"><input type="radio" value="" class="trans" name="rad_rlse_dt">&nbsp;Released Date</td>
                      <td width="225"><input type="text" style="width:70;ime-mode:disabled;" caption="Released Date"  class="input1" value="" name="in_cre_dt_from" dataformat="ymd" maxlength="10" required="" fullfill="fullfill">&nbsp;~&nbsp;<input type="text" style="width:70;ime-mode:disabled;" caption="Released Date" class="input1" value="" name="in_cre_dt_to" dataformat="ymd" maxlength="10" required="" fullfill="fullfill">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_dtt"></td>
                     
                     
                      <td width="43"><input type="radio" value="" class="trans" name="rad_vvd">&nbsp;VVD</td>
                      <td width="90"><input type="text" style="width:80;ime-mode:disabled;" caption="VVD" class="input1" value="" name="in_vvd" dataformat="eng"  maxlength="9" required="" fullfill="fullfill"></td>
                      <td width="25">POD</td>
                      <td width="65"><input type="text" style="width:55;ime-mode:disabled;" caption="POD" class="input1" value="" name="in_pod_cd" dataformat="eng"  maxlength="5" required="" fullfill="fullfill"></td>
                      <td width="85"><input type="radio" value="" class="trans" name="rad_bl">&nbsp;B/L No.</td>
                      <td width=""><input type="text" style="width:95;ime-mode:disabled;" caption="B/L No" class="input" value="<%=bl_no %>" name="in_bl_no" dataformat="eng"  maxlength="12" required="" fullfill="fullfill"></td>
                    </tr> 
                  </table>
                </td>
                <td width="25">CNTR</td>
                <td width="95"><input type="text" style="width:90;ime-mode:disabled;" class="input" value="<%=cntr_no %>" name='in_cntr_no' dataformat="eng"  maxlength="14"></td>
                <td width="54">P/Up CY</td>
                <td width="65"><input type="text" style="width:65;ime-mode:disabled;" class="input" value="" name="in_yd_cd" dataformat="eng"  maxlength="7"></td>
              </tr> 
            </table>        
          </td>
        </tr>
      </table>
    
      <table class="height_8"><tr><td></td></tr></table>  
    
      <table class="search" id="mainTable"> 
        <tr>
          <td class="bg">  
            <!-- Grid  (S) -->
            <table width="100%"  id="mainTable">
              <tr>
                <td width="100%">
                  <script language="javascript">ComSheetObject('sheet1');</script>
                </td>
              </tr>
            </table>
            <!-- Grid (E) -->      
          </td>
        </tr>
      </table>
      <!--biz page (E)-->
    </td>
  </tr>
</table>


  
<!--Button (S) -->
<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
  <tr>
    <td class="btn1_bg">

      <table border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td>
            <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
              <tr>
                <td class="btn1_left"></td>
                <td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
                <td class="btn1_right"></td>
              </tr>
            </table>
          </td>
          <td class="btn1_line"></td>
          <td>
            <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
              <tr>
                <td class="btn1_left"></td>
                <td class="btn1" name="btn_DownExcel">Down-Excel</td>
                <td class="btn1_right"></td>
              </tr>
            </table>
          </td>
      
          <td class="btn1_line"></td>
          <td>
            <table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
              <tr>
                <td class="btn1_left"></td>
                <td class="btn1" name="btn_Print">Print</td>
                <td class="btn1_right"></td>
              </tr>
            </table>
          </td>
      
          <%if(bl_no.length() >= 12){ %>
          <td class="btn1_line"></td>
          <td>
            <table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
              <tr>
                <td class="btn1_left"></td>
                <td class="btn1" name="btn_Close">Close</td>
                <td class="btn1_right"></td>
              </tr>
            </table>
          </td>
          <%} %>
        </tr>
      </table>
    </td>
  </tr>
</table>
<!--Button (E) -->
<%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_CLOSE.jsp"%>
</form>
</body>
</html>
