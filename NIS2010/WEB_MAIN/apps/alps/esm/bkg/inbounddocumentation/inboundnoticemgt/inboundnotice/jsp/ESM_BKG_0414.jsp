<%
/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0414.jsp
 *@FileTitle : Pick-Up Notice Sent History
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.08
 *@LastModifier : 박만건
 *@LastVersion : 1.0
 * 2009.10.08 박만건
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg0414Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmBkg0414Event  event = null;                    //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;            //서버에서 발생한 에러
    String strErrMsg = "";                        //에러메세지
    int rowCount     = 0;                        //DB ResultSet 리스트의 건수
    
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "200";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    Logger log = Logger.getLogger("com.hanjin.apps.InboundBLMgt.PickUpNotice");
    
    /* page constant */
    String agentKndCd = "6";
    
    /* user define variable */
    String strOfc_cd = "";
    String strCnt_cd = "";
    String strPodCds = "";
    String strOfcKndCd = "";
    
    /* user parameter variable */
    String parAutoSearchFlg = JSPUtil.getParameter(request, "autoSearchFlg");
    String parSchTp         = JSPUtil.getParameter(request, "sch_tp");
    String parBlNo          = JSPUtil.getParameter(request, "bl_no");
    
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id =    account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
       
        strOfc_cd = account.getOfc_cd();
        strCnt_cd = account.getCnt_cd();
        
        event = (EsmBkg0414Event)request.getAttribute("Event");
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
<title>Pick-Up Notice Sent History</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
    var podCdArr = new Array();
    var strOfc_cd = "<%=strOfc_cd%>";
    var strCnt_cd = "<%=strCnt_cd%>";
    
    var parSchTp = "<%=parSchTp %>";
    var parAutoSearchFlg = "<%=parAutoSearchFlg %>";
    var parBlNo = "<%=parBlNo %>";

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
<input name="f_cmd" type="hidden" />
<input name="pagerows" type="hidden" value="<%=pageRows %>"/>
<input type="hidden" name="usr_ofc_cd"       value="<%=strOfc_cd%>" />
<!-- 개발자 작업    -->

<%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp"%>
<%-- Main & Popup 공통 삭제 처리 
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
    <tr>
        <td valign="top">
            <!--Page Title, Historical (S)-->
            <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
                <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle" /><span id="navigation"></span></td></tr>
                <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle" /><span id="title"></span></td></tr>
            </table>
            <!--Page Title, Historical (E)-->
--%>
      
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
                      <td class="btn1" name="btn_DownExcel">Down Excel</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_UsIor">US IOR</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_MasterData">Master Data</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>

               <!-- td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="">Preview</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td -->
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_PkupSend">Pickup Send</td>
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
        
      <!-- Grid BG Box  (S) -->
        
      <table class="search"> 
        <tr>
          <td class="bg">
            <!--  biz_1  (S) -->
            <table class="search" border="0" style="width:979;"> 
              <tr class="h23">
                <td width="760">
                  <table class="search_sm2" border="0" style="width:100%;"> 
                    <tr class="h23">
                      <td width="100"><input type="radio" class="trans" checked="true" name="sch_tp" value="D" >Sent Date</td>
                      <td width="280"><input type="text" style="width:80" class="input1" name="snd_dt_fm" caption="Sent Date From" cofield="snd_dt_to" dataformat="ymd" />
                         ~&nbsp;<input type="text" style="width:80" class="input1" name="snd_dt_to" caption="Sent Date To" cofield="snd_dt_fm" dataformat="ymd" />
                        <img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_snd_dt" />
                      </td>
                      <td width="80"><input type="radio" class="trans" name="sch_tp" value="B" >B/L No.</td>
                      <td width="140">
                        <input type="text" style="width:100" class="input1" caption="B/L No." name="bl_no" maxlength="13" />
                        </td>
                       <td width="120"><input type="radio" class="trans" name="sch_tp" value="C">Container No.</td>
                      <td width="">
                        <input type="text" style="width:100" class="input1" maxlength="11" caption="Container No." fullfill="true" name="cntr_no" />
                        </td>
                     </tr> 
                  </table>
                </td>
              <td width="23">&nbsp;</td>
              <td width="73">Sent Type</td>
              <td width="">
                  <select style="width:70;" class="input1" name="pkup_ntc_tp_cd">
                    <option value="">All</option>
                    <option value="PP">Time</option>
                    <option value="FC">F/O/C</option>
                    <option value="TO">Truck</option>
                    <option value="MA">Manual</option>
                  </select>
                </td>
             
               
                    
              </tr> 
            </table>                
            
            <table class="height_2"><tr><td></td></tr></table>
            
            <table class="search" border="0" style="width:979;"> 
              <tr class="h23">
                
                <td width="50">&nbsp;MVMT</td>                                            
                <td width="200">
                    <select style="width:95;" class="input1" name="mvmt_cd">
                        <option value="">All</option>
                        <option value="NT">NT</option>
                        <option value="NF">NF</option>
                        <option value="AR">AR</option>
                        <option value="RL">RL</option>
                    </select>
                </td>                                            
                
                <td width="94">&nbsp;&nbsp;Sent Result</td>
                <td width="126">
                  <select style="width:82;" class="input1" name="bkg_ntc_snd_rslt_cd">
                    <option value="" >All</option>
                    <option value="S">Success</option>
                    <option value="F">Failure</option>
                  </select>
                </td>
                
               <td width="55">User ID</td>
                <td width="115"><input type="text" style="width:77;" class="input" name="snd_usr_id" caption="User ID"  maxlength="20" style="ime-mode:disabled" /></td>
                <td width="95">Sent EQ Office</td>
                <td width=""><input type="text" style="width:45;" class="input1" name="ofc_cd" caption="Sent Office" minlength="5" maxlength="6" style="ime-mode:disabled" required="true" /></td>   
              </tr>
            </table>
          </td>
        </tr>
      </table>
            <!--  biz_1   (E) -->

      <table class="height_8"><tr><td></td></tr></table>

      <!--TAB Loading (S) -->
      <table class="search"> 
        <tr>
          <td class="bg">
            <!--Grid (s)-->
            <table width="100%"  id="mainTable">
              <tr>
                <td width="100%">
                  <script language="javascript">ComSheetObject('sheet1');</script>
                  <script language="javascript">ComSheetObject('sheet2');</script>
                </td>
              </tr>
            </table>

            <!--Grid (E)-->
                    
            <!--  Button_Sub (S) -->
                    
            <!-- Button_Sub (E) -->
          </td>
        </tr>
      </table>
      <!-- Grid BG Box  (E) -->
      <!--TAB Loading (E) -->
    </td>
  </tr>
</table>

<%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_CLOSE.jsp"%>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>