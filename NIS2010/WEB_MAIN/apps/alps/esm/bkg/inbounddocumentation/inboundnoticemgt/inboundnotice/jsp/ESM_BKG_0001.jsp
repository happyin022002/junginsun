<%
/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0001.jsp
 *@FileTitle : Arrival Notice Notice Sent History
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.28
 *@LastModifier : 박만건
 *@LastVersion : 1.0
 * 2009.04.28 박만건
 * 1.0 Creation
 * 2009.11.05 박만건 수정 - 폼에 javascript 제거
 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg0001Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmBkg0001Event  event = null;                    //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;            //서버에서 발생한 에러
    String strErrMsg = "";                        //에러메세지
    int rowCount     = 0;                        //DB ResultSet 리스트의 건수
    
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "200";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    Logger log = Logger.getLogger("com.hanjin.apps.InboundBLMgt.ArrivalNotice");
    
    /* page constant */
    String agentKndCd = "6";
    
    /* user define variable */
    String strOfc_cd = "";
    String strCnt_cd = "";
    
    /* Param Argument */
    String parAutoSearchFlg = JSPUtil.getParameter(request, "autoSearchFlg");
    String parSchTp = JSPUtil.getParameter(request, "sch_tp");
    String parBlNo  = JSPUtil.getParameter(request, "bl_no");
    String parVvd   = JSPUtil.getParameter(request, "vvd");
    String parPodCd = JSPUtil.getParameter(request, "pod_cd");
    String parNtcKndCd = JSPUtil.getParameter(request, "ntc_knd_cd");
    
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id =    account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
       
        strOfc_cd = account.getOfc_cd();
        strCnt_cd = account.getCnt_cd();
        
        event = (EsmBkg0001Event)request.getAttribute("Event");
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
<title>Arrival Notice Notice Sent History</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
    var podCdArr = new Array();
    var strOfc_cd = "<%=strOfc_cd%>";
    var strCnt_cd = "<%=strCnt_cd%>";
    
    var parAutoSearchFlg = "<%=parAutoSearchFlg %>";
    var parSchTp = "<%=parSchTp %>";
    var parBlNo  = "<%=parBlNo %>";
    var parVvd   = "<%=parVvd %>";
    var parPodCd = "<%=parPodCd %>";
    var parNtcKndCd = "<%=parNtcKndCd %>";

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
<form name="form" >
<input name="f_cmd" value="" type="hidden" />
<input name="pagerows" type="hidden" value="<%=pageRows %>"/>
<input name="login_ofc_cd" type="hidden" value="<%=strOfc_cd%>"/>
<!-- 개발자 작업    -->

<%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp"%>
    
      <!--Button (S) -->
      <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
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
                      <td class="btn1" name="btn_ANSend">A/N Send</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_PrePickup">Pickup</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_PreHold">Hold</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_InboundCS">Inbound C/S</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_DownExcel">Down&nbsp;Excel</td>
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
      <!--biz page (S)-->
      <table class="search"> 
        <tr>
          <td class="bg">
 
            <!--  biz_1  (S) -->
            <table class="search" border="0" style="width:925;"> 
              <tr class="h23">
                <td width="658">
                  <table class="search_sm2" border="0" style="width:658;"> 
                    <tr class="h23">
                      <td width="50"><input type="radio" value="V" class="trans" name="sch_tp" />VVD</td>
                      <td width="85">
                        <input type="text" name="vvd" caption="VVD" style="width:76;" class="input1" 
                               maxlength="9" size="9" style="ime-mode:disabled" fullfill="true" /></td>
                      <td width="85"><input type="radio" value="D" class="trans" name="sch_tp" checked="true" />Sent Date</td>
                      <td width="">
                        <input type="text" style="width:72;ime-mode:disabled" class="input1" dataformat="ymd"
                               maxlength="10" caption="Send Date From" required="true" name="snd_dt_fm" cofield="snd_dt_to" />
                               &nbsp;~&nbsp;
                        <input type="text" style="width:72;ime-mode:disabled" class="input1" dataformat="ymd" 
                               maxlength="10" caption="Send Date To" required="true" name="snd_dt_to" cofield="snd_dt_fm" />
                        <img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btn_snd_dt" />
                      </td>
                     
                      <td width="25">POD</td>
                      <td width="60">
                       <input type="text" style="width:50;" class="input1" name="pod_cd" caption="POD" 
                              minlength="5" maxlength="5" style="ime-mode:disabled" fullfill="true" required="true" />
                      </td>
                
                      <td width="73">Sent Office</td>
                      <td width="">
                       <input type="text" style="width:55;" class="input1" name="ofc_cd" caption="Sent Office" 
                              minlength="5" maxlength="6" style="ime-mode:disabled" required="true" />
                      </td>                
                    </tr>
                  </table>
                </td>              
                
                <td width="25">T/S</td>
                <td width="20" ><input type="checkbox" value="Y" name="ts_flg" caption="T/S" class="trans" />&nbsp;</td>
                <td width="205">
                  <table class="search_sm2" border="0" style="width:195;"> 
                    <tr class="h23">
                      <td width="78"><input type="radio" value="B" class="trans" name="sch_tp" />B/L No.</td>
                      <td width="120">
                         <input type="text" style="width:108;" class="input1" name="bl_no" caption="B/L No." 
                                maxlength="12" style="ime-mode:disabled" />
                      </td>
                    </tr>
                  </table>
                </td>
               
              </tr>    
            </table>
            <table class="search" border="0" style="width:629;"> 
              <tr class="h23">
                <td width="58">&nbsp;P/O No.</td>
                <td width="105"><input type="text" style="width:90;" class="input" value="" name="cust_ref_no" caption="P/O No." maxlength="500" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum');" /></td>
                <td width="48">User ID</td>
                <td width="90"><input type="text" style="width:80;" class="input" value="" name="snd_usr_id" caption="User ID" maxlength="20" style="ime-mode:disabled" /></td>
                <td width="82">Sent Result</td>
                <td width="100">
                  <select style="width:62;" class="input1" name="bkg_ntc_snd_rslt_cd">
                    <option value="" >All</option>
                    <option value="S">Success</option>
                    <option value="F">Fail</option>
                  </select>
                </td>
                <td width="82">Notice Type</td>
                <td width="">
                  <select style="width:100;" class="input1" name="ntc_knd_cd">
                    <option value="" >All</option>
                    <option value="AN">A/N</option>
                    <option value="AV">Advice Note</option>
                    <option value="HN">Hold</option>
                    <option value="DO">Delivery Order</option>
                    <option value="BL">B/L Copy</option>
                  </select>
                </td>
            
              </tr>    
            </table>
            <table class="search" border="0" style="width:979;"><tr class="h23"></tr></table>
            <!--  biz_1   (E) -->
          </td>
        </tr>
      </table>
      <table class="height_10"><tr><td colspan="8"></td></tr></table>
      
      <!-- Grid BG Box  (S) -->
      <table class="search" id="mainTable"> 
        <tr>
          <td class="bg">
            <!-- Grid  (S) -->
            <table width="100%"  id="mainTable">
              <tr>
                <td width="100%">
                    <script language="javascript">ComSheetObject('sheet1');</script>
                    <script language="javascript">ComSheetObject('sheet2');</script>
                </td>
              </tr>
            </table>
            <!-- Grid (E) -->
     
          </td>
        </tr>
      </table>
      <!-- Grid BG Box  (E) -->
    
      <table class="height_10"><tr><td colspan="8"></td></tr></table>
      <!--biz page (E)-->
    
    </td>
  </tr>
</table>
<%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_CLOSE.jsp"%>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>