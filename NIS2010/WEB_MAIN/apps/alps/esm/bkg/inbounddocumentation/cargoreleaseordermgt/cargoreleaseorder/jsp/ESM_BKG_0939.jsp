<%
/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0939.jsp
 *@FileTitle : India Cargo Release Order list Inquery
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.18
 *@LastModifier : 박만건
 *@LastVersion : 1.0
 * 2009.08.18 박만건
 * 1.0 Creation
 * ------------------------------------------------------
 * History
 * 2009.11.05 박만건 수정 - 폼에 javascript 제거
 * 2012.05.08 김보배 [CHM-201217621] [BKG] India Cargo Release Performance 기능 보완
 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0939Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmBkg0939Event  event = null;          //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;      //서버에서 발생한 에러
    String strErrMsg = "";            //에러메세지
    int rowCount   = 0;            //DB ResultSet 리스트의 건수
    
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";
    
    String strUsr_id    = "";
    String strUsr_nm    = "";
    String strOfcCd     = "";
    Logger log = Logger.getLogger("com.hanjin.apps.InboundBLMgtSC.FullReleaseOrderBC");
    
    String dmdtCode = "";
    String dmdtValue = "";

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id =  account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strOfcCd  = account.getOfc_cd();
       
       
        event = (EsmBkg0939Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
    
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
      
        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        dmdtCode = eventResponse.getETCData("dmdt_code");
        dmdtValue = eventResponse.getETCData("dmdt_value");
      
    }catch(Exception e) {
        out.println(e.toString());
    }
%>
<html>
<head>
<title>India Cargo Release Order list Inquery</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
    var strOfcCd = "<%=strOfcCd %>";

    var gDmdtCode = "<%=dmdtCode %>|";
    var gDmdtValue = "<%=dmdtValue %>|";

    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            showErrMessage(errMessage);
        } // end if
        loadPage();
    }
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows" value="<%=pageRows %>">
<!-- 개발자 작업  -->
<%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp" %>
  <!--biz page (S)-->
  <table class="search" id="mainTable" width="989"> 
    <tr>
      <td class="bg">  
        <table class="search" border="0" style="width:979;"> 
          <tr class="h23">
            <td width="130">DMDT Payment Type</td>
            <td width="100">
              <select style="width:90;" class="input1" name="dmdt_pay_tp_cd">
                <option value="" selected="true">All</option>
                <option value="G">General</option>
                <option value="T">Extension</option>
                <option value="A">Examination</option>
              </select>
            </td>
            <td>
              <table class="search_sm2" border="0" style="450;"> 
                <tr class="h23">
                  <td width="310">
                    <input type="radio" value="F" class="trans" name="rd_flag" checked="true" />Release Date&nbsp
                    <input type="text" style="width:75;" class="input1" value="" name="evnt_dt_fm" dataformat="ymd" maxlength="10" 
                            caption="Release Date From" cofield="evnt_dt_to" required="true" style="width:100;ime-mode:disabled" />&nbsp;~
                    <input type="text" style="width:75;" class="input1" value="" name="evnt_dt_to" dataformat="ymd" maxlength="10"
                            caption="Release Date To" cofield="evnt_dt_fm" required="true" style="width:100;ime-mode:disabled" />
                    <img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle"
                         class="cursor" name="btn_evnt_dt" />
                  </td>
                  <td width="">
                    <input type="radio" value="S" class="trans" name="rd_flag" />Year&nbsp;Month
                    <input type="text" style="width:60;" class="input1" value="" name="evnt_dt_ym" dataformat="ym" maxlength="7"
                           caption="(Release) Year Month" style="ime-mode:disabled" />
                    <img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" 
                         class="cursor" name="btn_evnt_dt_ym" />&nbsp;
                  </td>
                </tr>
              </table> 
            </td>
          </tr>
        </table> 
        <table class="search" border="0" style="width:979;"> 
          <tr class="h23">
            <td width="50">B/L No.</td>
            <td width="180">
              <input type="text" style="width:100;" class="input" name="bl_no" caption="B/L No." maxlength="12"
                     style="ime-mode:disabled" >
            </td>
            <td width="50">Container</td>
            <td width="180">
              <input type="text" style="width:89;" class="input" name="cntr_no" caption="Container" maxlength="11" style="ime-mode:disabled" />
            </td>
            <td width="90">Release Office</td>
            <td width="">
              <input type="text" style="width:60;" class="input" value="" name="evnt_ofc_cd" caption="Release Office" 
                     minlength="5" maxlength="6" style="ime-mode:disabled" >
            </td>
          </tr>
        </table> 
        <table class="line_bluedot"><tr><td></td></tr></table>
        <!-- Grid  1(S) -->
        <table   id="mainTable"> 
          <tr>
            <td width="100%"><script language="javascript">ComSheetObject1('sheet1');</script></td>
          </tr>
        </table>
        <!-- Grid  1(E) -->
      
        <!--  Button_Sub (S) -->
        <table width="100%" class="button"> 
          <tr>
            <td class="btn2_bg">
              <table border="0" cellpadding="0" cellspacing="0">
                <tr>
                  <td>
                    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                      <tr>
                        <td class="btn2_left"></td>
                        <td class="btn2" name="btn_DownExcelWeeklyReport">Down Excel</td>
                        <td class="btn2_right"></td>
                      </tr>
                    </table>
                  </td>
                </tr>
              </table>
            </td>
          </tr>
        </table>
        <!-- Button_Sub (E) -->
        <table class="line_bluedot"><tr><td></td></tr></table>
        <!-- Grid  2(S) -->
        <table width="100%"  id="mainTable"> 
          <tr width="100%">
            <td width="100%">
              <script language="javascript">ComSheetObject('sheet2');</script>
            </td>
          </tr>
        </table>
        <!-- Grid  (E) -->
        <!--  Button_Sub (S) -->
        <table width="100%" class="button"> 
          <tr>
            <td class="btn2_bg">
              <table border="0" cellpadding="0" cellspacing="0">
                <tr>
                  <td>
                    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                      <tr>
                        <td class="btn2_left"></td>
                        <td class="btn2" name="btn_DownExcelDoRlseList">Down Excel</td>
                        <td class="btn2_right"></td>
                      </tr>
                    </table>
                  </td>
                </tr>
              </table>
            </td>
          </tr>
        </table>
        <!-- Button_Sub (E) -->
      </td>
    </tr>
  </table>
  <!--biz page (E)-->
  
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
                  <td class="btn1" name="btn_Retrieve" id="btn_Retrieve" >Retrieve</td>
                  <td class="btn1_right"></td>
                </tr>
              </table>
            </td>
            <td class="btn1_line"></td>
            <td>
              <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                <tr>
                  <td class="btn1_left"></td>
                  <td class="btn1" name="btn_CargoRelease">Cargo Release</td>
                  <td class="btn1_right"></td>
                </tr>
              </table>
            </td>
          </tr>
        </table>
      </td>
    </tr>
  </table>
  <!--Button (E) -->
</table>
<!-- 개발자 작업  끝 -->
<%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_CLOSE.jsp" %>
</form>
</body>
</html>