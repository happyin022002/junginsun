<%
/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESM_BSA_0042.jsp
*@FileTitle : BSA Inquiry by VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.26
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2011.01.26 이행지
* 1.0 Creation
*=========================================================
* History :
* 2011.01.26 이행지 [CHM-201108497-01] 사업계획 노출 방지를 위한 사업계획용 메뉴 추가 개발
* 2011.04.04 이관샨 [CHM-201109933-01] 화면상 불필요한 선 정리 
* 2011.08.05 이행지 [CHM-201112101-01] Slottage => Slot Price 용어 변경
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.HashMap" %> 
<%@ page import="java.util.List"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bsa.bsayearlyplan.bsayearlyplan.event.EsmBsa0042Event"%>
<%@ page import="com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo.SearchBsaCrrRgstListVO"%>
<%@ page import="com.hanjin.apps.alps.esm.bsa.common.vo.CommonBsaRsVO"%>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%> 

<%
    EsmBsa0042Event event = null;
    Exception serverException = null;
    Logger log = Logger.getLogger("com.hanjin.apps.alps.esm.bsa.ESM_BSA_0042");
    String strErrMsg = "";
    String xml = "";
    
    String userId   = "";
    String userName = "";
    String prevWeek = "";

    try {
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        //추가----------------------------------------------------------------------------------------- START
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        userId    = account.getUsr_id();
        userName  = account.getUsr_nm();

        event = (EsmBsa0042Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        
        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        CommonBsaRsVO commonVO = (CommonBsaRsVO)(eventResponse.getCustomData("rtnVo"));
        prevWeek =eventResponse.getETCData("prevWk");

        xml = HttpUtil.makeXML(request,response); 
        xml = xml.replaceAll("\"", "'");
    } catch(Exception e) {
        log.error("JSP Exception : " + e.toString());
    }
%>

<html>
<head>
<title>Inquire/Edit BSA Table</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
    function setupPage() {
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if

        loadPage();
        
        formObj = document.form;
        formObj.txtYear.focus();      
        formObj.txtYear.value = ComGetNowInfo("yy");  
        formObj.txtFmMonth.value = ComGetNowInfo("mm"); 
        formObj.txtToMonth.value = ComGetNowInfo("mm"); 
        formObj.txtFmMonth.value = ComLpad(formObj.txtFmMonth, 2, '0');
        formObj.txtToMonth.value = ComLpad(formObj.txtToMonth, 2, '0');
        
        formObj.txtFmWeek.value = "<%=prevWeek%>";
        formObj.txtToWeek.value = "<%=prevWeek%>";

        setPeriod(formObj.txtToWeek);
    }
</script>
</head>

<body onload="javascript:setupPage();">
<iframe height="0" width="0" name="frmHidden" id="frmHidden"></iframe>

<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">

<input type="hidden" name="param1"> <!-- Gubun   |   Methode Name   | codeItem     -->
<input type="hidden" name="param2"> <!-- Year    |   vsl_cd         | All /        -->
<input type="hidden" name="param3"> <!--         |   skd_voy_no     | Methode Name -->
<input type="hidden" name="param4"> <!--         |   dir_cd         | trd_cd       -->
<input type="hidden" name="param5"> <!-- fmMonth |                  |              -->
<input type="hidden" name="param6"> <!-- toMonth |                  |              -->
<input type="hidden" name="param7"> <!-- fmWeek  |                  |              -->
<input type="hidden" name="param8"> <!-- toWeek  |                  |              -->

<input type="hidden" name="crr_cnt" value="">
<input type="hidden" name="crr_cd" value="">
<input type="hidden" name="saveNM" value="">
<input type="hidden" name="hValue">
<input type="hidden" name="sXml"          value="<%=xml%>"> 

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
  <tr>
    <td>
      <!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
      </table>
      <!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->

      <!--Button_L (S) -->
      <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
        <tr>
          <td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
              <tr>
                <!-- Repeat Pattern -->
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                      <tr><td class="btn1_left"></td><td class="btn1" id="btn_retrieve" name="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
           
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                      <tr><td class="btn1_left"></td><td class="btn1" id="btn_downexcel" name="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
                <!-- Repeat Pattern -->
              </tr>
            </table>
          </td>
        </tr>
      </table>
      <!--Button_L (E) -->

      <!-- TABLE '#D' : ( Search Options ) (S) -->
      <table class="search">
        <tr>
          <td class="bg">
            <!-- : ( Year ) (S) -->
            <table class="search_in" border="0">
              <tr class="h23">
                <td width="700"><script language="javascript">initPeriod();</script></td>
                <td>Carriers with BSA only<input type="checkbox" name="isExcludZero" value="1" class="trans"></td>
              </tr>
            </table>
            <table class="search_in" border="0">
              <tr><td class="line_bluedot"></td></tr>
            </table>
            <table class="search_in" border="0">
              <tr class="h23">
                <td width="55" style="text-indent:7;">Trade</td>
                <td width="130"><script language="javascript">ComComboObject('cobTrade', 1, 70 , 0 )</script></td>
               
                <td width="35">Lane</td>
                <td width="130"><script language="javascript">ComComboObject('cobLane', 1, 70 , 0 )</script></td>
               
                <td width="60">Direction</td>
                <td width="130"><script language="javascript">ComComboObject('cobDir', 1, 70 , 0 )</script></td>
               
                <td width="30">IOC</td>
                <td width="130"><script language="javascript">ComComboObject('cobIOC', 1, 70 , 0 )</script></td>
               
                <td width="30">VVD</td>
                <td><input type="text" size="4" name="txtVsl_cd"     maxlength="4" onKeyPress="ComKeyOnlyAlphabet('uppernum');" onKeyUp="moveTab(this, txtSkd_voy_no);" style="ime-mode:disabled; width:65;" >
                   <input type="text" size="4" name="txtSkd_voy_no" maxlength="4" onKeyPress="ComKeyOnlyNumber(window);" onKeyUp="moveTab(this, txtDir_cd);" style="ime-mode:disabled; width:65;" >
                   <input type="text" size="1" name="txtDir_cd"     maxlength="1" onKeyPress="ComKeyOnlyAlphabet('upper');" onBlur="chkVVD();" style="ime-mode:disabled; width:30;" ></td>
              </tr>
            </table>
            <!-- : ( Year ) (E) -->
          </td>
        </tr>
      </table>
      <!-- TABLE '#D' : ( Search Options ) (E) -->

      <table class="height_10"><tr><td></td></tr></table>

      <!-- TABLE '#D' : ( Search Options ) (S) -->
      <table class="search">
        <tr>
          <td class="bg">
            <!-- : ( Option ) (S) -->
            <table class="search" border="0" style="width:100%;">
              <tr class="h23">
                <td>
                  <input type="radio" value="D" class="trans" name="rdoPerf" onClick="invOnChange(1);" checked>&nbsp;BSA & Slot Price&nbsp;&nbsp;&nbsp;
                  <input type="radio" value="P" class="trans" name="rdoPerf" onClick="invOnChange(2);">&nbsp;Slot Price Total
                </td>
                <td align="right" class="gray">* Price Currency= USD(U$)</td>
                <td width="30" align="right" valign="bottom" style="padding-right:2;">
                    <div id="div_zoom_in" style="display:inline"> <!-- absolute / relative -->
                    <img class="cursor" src="/hanjin/img/bu_prev01.gif" width="20" height="11" border="0" name="bu_zoom_in" alt="Zoom in(+)">
                    </div>
                    <div id="div_zoom_out" style="display:none">
                    <img class="cursor" src="/hanjin/img/bu_next01.gif" width="20" height="11" border="0" name="bu_zoom_out" alt="Zoom out(-)">
                    </div>
                </td>
              </tr>
              <tr><td class="height_2"></td></tr>
            </table>

	        <!-- : ( Option ) (E) -->
	        <div id="RadioLayer_d" style="display:inline">
              <!-- : ( POR ) (S) -->
              <table width="100%" id="mainTable1">
                <tr>
                  <td>
                    <script language="javascript">ComSheetObject('sheet0');</script>
                  </td>
                </tr>
              </table>
              <!-- : ( POR ) (E) -->
    
              <!--  Button_Sub (S) -->
              <table width="100%" class="button">
                <tr>
                  <td>
                    <table>
                      <tr>
                        <td wdith="50%" class="gray_tit" align="left">
                         * Basic Slots = Basic slot allocation among joint operating carriers
                         <br>
                         * Basic Lease = Slots leased by SML to other carriers
                         <br>
                         * Basic Chartered = Slots chartered by SML from other carriers
                         <br>
                         * Additional Lease = Additional slots leased by SML to other carriers
                         <br>
                         * Additional Chartered = Additional slots chartered by SML from other carriers                      
                        </td>
                      </tr>
                    </table>
                  </td>
                  <td class="btn2_bg" valign="top" >
                    <table border="0" cellpadding="0" cellspacing="0" >
                      <tr>
                        <!-- Repeat Pattern -->
                        <td>
                          <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                            <tr>
                              <td class="btn2_left"></td>
                              <td class="btn2" id="btng_creation" name="btng_creation">Creation</td>
                              <td class="btn2_right"></td>
                            </tr>
                          </table>
                        </td>
                        <!-- Repeat Pattern -->
                      </tr>
                    </table>
                  </td>                                           
                </tr>
              </table>                      
             <!-- Button_Sub (E) -->
            </div>
	       
	       <div id="RadioLayer_p" style="display:none">
              <!-- : ( POR ) (S) -->
              <table width="100%" id="mainTable2">
                <tr>
                  <td>
                    <script language="javascript">ComSheetObject('sheet1');</script>
                  </td>
                </tr>
              </table>
              <!-- : ( POR ) (E) -->
    
              <!--  Button_Sub (S) -->
              <table width="100%" class="button">
                <tr>
                  <td>
                    <table>
                      <tr>
	                    <td wdith="50%" class="gray_tit" align="left">
	                     * Basic Slots = Basic slot allocation among joint operating carriers
	                     <br>
	                     * Basic Lease = Slots leased by SML to other carriers
	                     <br>
	                     * Basic Chartered = Slots chartered by SML from other carriers
	                     <br>
	                     * Additional Lease = Additional slots leased by SML to other carriers
	                     <br>
	                     * Additional Chartered = Additional slots chartered by SML from other carriers                      
	                    </td>
                      </tr>
                    </table>
                  </td>
                  <td class="btn2_bg" valign="top" >
                    <table border="0" cellpadding="0" cellspacing="0" >
                      <tr>
                        <!-- Repeat Pattern -->
                        <td>
                          <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                            <tr>
                              <td class="btn2_left"></td>
                              <td class="btn2" id="btng_creation" name="btng_creation">Creation</td>
                              <td class="btn2_right"></td>
                            </tr>
                          </table>
                        </td>
                        <!-- Repeat Pattern -->
                      </tr>
                    </table>
                  </td>                                           
                </tr>
              </table>                      
             <!-- Button_Sub (E) -->
            </div>
          </td>
        </tr>
      </table>
    <!-- TABLE '#D' : ( Search Options ) (E) -->
    </td>
  </tr>
</table>
<!-- Outer Table (E)-->
</form>
</body>
</html>