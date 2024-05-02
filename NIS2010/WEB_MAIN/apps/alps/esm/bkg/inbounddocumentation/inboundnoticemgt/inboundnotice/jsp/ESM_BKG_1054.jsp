<%
/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_1054.jsp
 *@FileTitle : Arrival Notice - Customer Code Validate
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.03
 *@LastModifier : 박만건
 *@LastVersion : 1.0
 * 2009.06.03 박만건
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg1054Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmBkg1054Event  event = null;        //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;      //서버에서 발생한 에러
    String strErrMsg = "";            //에러메세지
    int rowCount   = 0;            //DB ResultSet 리스트의 건수
    
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";
    
    String strUsr_id    = "";
    String strUsr_nm    = "";
    String strUsr_email      = "";
    String strOfc_cd    = "";
    String strBizOfc_cd    = ""; //@ OFFICE 비교를 위한 변수
    
    Logger log = Logger.getLogger("com.hanjin.apps.InboundBLMgt.ArrivalNotice");
    // Login사용자용 추가 변수
    String strCntCd = "";
    
    // 다른화면에서 부터 요청받았을 때 처리할 변수 목록 (시작)
    String parAutoSearchFlg = JSPUtil.getParameter(request, "autoSearchFlg");
    String parVvd   = JSPUtil.getParameter(request, "vvd");
    String parVpsEtaDtStart = JSPUtil.getParameter(request, "vps_eta_dt_start");
    String parVpsEtaDtEnd   = JSPUtil.getParameter(request, "vps_eta_dt_end");
    String parPodCd = JSPUtil.getParameter(request, "pod_cd");
    String parPolCd = JSPUtil.getParameter(request, "pol_cd");
    String parDelCd = JSPUtil.getParameter(request, "del_cd");
    String parBlNo  = JSPUtil.getParameter(request, "bl_no");
    String parOfcCd = JSPUtil.getParameter(request, "ofc_cd");
    String parSchTp = JSPUtil.getParameter(request, "sch_tp");
    String parTsFlg = JSPUtil.getParameter(request, "ts_flg");
    // 다른화면에서 부터 요청받았을 때 처리할 변수 목록 (끝)
    
    
    String code = "";
    String value = "";
    
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id =  account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strUsr_email = account.getUsr_eml();
        strOfc_cd = account.getOfc_cd();
        strBizOfc_cd = account.getOfc_cd();
        strCntCd = account.getCnt_cd();
        
        if("US".equals(strCntCd)){
        	//strBizOfc_cd ="PHXSC"; // 2015.08.03 한진그룹 코드 표준화
        	strBizOfc_cd ="PHXSA";
        }
          
         
        event = (EsmBkg1054Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
      
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        
        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        code = eventResponse.getETCData("code");
        value = eventResponse.getETCData("value");
    }catch(Exception e) {
        out.println(e.toString());
    }
%>
<html>
<head>
<title>Arrival Notice - Customer Code Validate</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
    var strUsr_id    = "<%=strUsr_id %>";
    var strUsr_nm    = "<%=strUsr_nm %>";
    var strUsr_email = "<%=strUsr_email %>";
    var strOfc_cd    = "<%=strOfc_cd %>";
    var strBizOfc_cd    = "<%=strBizOfc_cd %>";
    var strCntCd     = "<%=strCntCd %>"; 
    
    // 다른화면에서 부터 요청받았을 때 처리할 변수 목록 (시작)
    var parAutoSearchFlg = "<%=parAutoSearchFlg %>";
    var parVvd           = "<%=parVvd %>";
    var parVpsEtaDtStart = "<%=parVpsEtaDtStart %>";
    var parVpsEtaDtEnd   = "<%=parVpsEtaDtEnd %>";
    var parPodCd         = "<%=parPodCd %>";
    var parPolCd         = "<%=parPolCd %>";
    var parDelCd         = "<%=parDelCd %>";
    var parBlNo          = "<%=parBlNo %>";
    var parOfcCd         = "<%=parOfcCd %>";
    var parSchTp         = "<%=parSchTp %>";
    var parTsFlg         = "<%=parTsFlg %>";
    // 다른화면에서 부터 요청받았을 때 처리할 변수 목록 (끝)
    
    var evtCode = "-|<%=code %>";
    var evtValue = " |<%=value %>";
    
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
<input name="f_cmd" type="hidden" />
<input type="hidden" name="pagerows" value="<%=pageRows %>">

<!-- 개발자 작업  -->
<input type="hidden" name="an_seq" value="" />
<input type="hidden" name="strUsr_nm" value="" />
<input type="hidden" name="strUsr_email" value="" />
<input type="hidden" name="strOfc_cd" value="" />
<input type="hidden" name="gw_subject" value="" />
<input type="hidden" name="gw_contents" value="" />
<input type="hidden" name="gw_template" value="ESM_BKG_1054_01T.html" />
<input type="hidden" name="gw_args" value="" />
<input type="hidden" name="gw_args" value="" />                
<input type="hidden" name="gw_args" value="" />                
<input type="hidden" name="gw_args" value="" />                
<input type="hidden" name="gw_args" value="" />                
<input type="hidden" name="gw_args" value="" />
<%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp" %>  
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
                    <td class="btn1" name="btn_DownExcel">Down Excel</td>
                    <td class="btn1_right"></td>
                  </tr>
                </table>
              </td>
          
              <td>
                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                  <tr>
                    <td class="btn1_left"></td>
                    <td class="btn1" name="btn_Save">Save</td>
                    <td class="btn1_right"></td>
                  </tr>
                </table>
              </td>
              <td>
                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                  <tr>
                    <td class="btn1_left"></td>
                    <td class="btn1" name="btn_ANSetup">A/N Setup</td>
                    <td class="btn1_right"></td>
                  </tr>
                </table>
              </td>
              <td>
                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                  <tr>
                    <td class="btn1_left"></td>
                    <td class="btn1" name="btn_ANSend">A/N Send</td>
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
    <table class="search" id="mainTable"> 
      <tr>
        <td class="bg">
      
          <!--  biz_1  (S) -->
          <table class="search" border="0" style="width:989;"> 
          <tr class="h23">
            <td>
              <table class="search_sm" border="0">
                <tr class="h23">
                  <td width="145">
                    <input type="radio" value="V" class="trans" name="sch_tp" >VVD
                    <input type="text" style="width:80;" class="input1" name="vvd" caption="VVD" 
                           maxlength="9" size="9" style="ime-mode:disabled" fullfill="true" />
                  </td>
                  <td width="90"><input type="radio" value="D" name="sch_tp" class="trans" checked="true" >POD ETA</td>
                  <td width="210">
                    <input type="text" style="width:75" dataformat="ymd" maxlength="10" value="" class="input1" 
                           caption="POD ETA Start Date" required="true" name="vps_eta_dt_start" 
                           cofield="vps_eta_dt_end" style="width:100;ime-mode:disabled" />&nbsp;&nbsp;~&nbsp;
                    <input type="text" style="width:75" dataformat="ymd" maxlength="10" value="" class="input1" 
                           name="vps_eta_dt_end" cofield="vps_eta_dt_start" caption="POD ETA End Date" 
                           required="true" style="ime-mode:disabled" />
                    <img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_vps_eta_dt" />
                  </td>
                  <td width="30">POD</td>
                  <td width="60">
                    <input type="text" style="width:50;" class="input1" name="pod_cd" id="pod_cd" caption="POD" maxlength="5" style="ime-mode:disabled" fullfill="true" />
                  </td>
                  <td name="btn_pod_pop" class="btn1" width="25">
	                    <img src="./img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="btn_pod_pop" id="btn_pod_pop">
                  </td>
                  <td width="25">T/S</td>
                  <td width="20" ><input type="checkbox" value="Y" name="ts_flg" caption="T/S" class="trans" />&nbsp;</td>
                  <td width="30">DEL</td>
                  <td width=""><input type="text" style="width:60;" class="input" name="del_cd" caption="DEL" minlength="2" maxlength="5" style="ime-mode:disabled" /></td>
                </tr>
              </table>
            </td>
            <td width="95">
              <table class="search" border="0" style="width:90">
                <tr class="h23">
                  <td width="20">POL</td>
                  <td width="70"><input type="text" style="width:60;" class="input" name="pol_cd" caption="POL" minlength="5" maxlength="5" style="ime-mode:disabled" /></td>
                </tr>
              </table>
            </td>
            <td width="">
              <table class="search_sm" border="0" style="width:100%;">
                <tr class="h23">
                  <td width="75"><input type="radio" value="B" class="trans" name="sch_tp" >B/L No.</td>
                  <td><input type="text" style="width:105;" class="input1" value="" name="bl_no" caption="B/L No." maxlength="12" style="ime-mode:disabled" /></td>
                </tr>
              </table>
            </td>
          </tr>
          </table>
          <!--  biz_1   (E) -->
              
        </td>
      </tr>
    </table>
    <table class="height_8"><tr><td></td></tr></table>  
    
    <!-- Tab (S) -->
    <table class="tab" border="0" cellpadding="0" cellspacing="0" width="100%" > 
      <tr>
        <td width="100%">
          <script language="javascript">ComTabObject('tab1')</script>
        </td>
      </tr>
    </table>
    <!-- Tab (E) -->

    <!--TAB Unmatch (S) -->
    <div id="tabLayer" style="display:inline">
      <table class="search" id="mainTable"> 
        <tr>
          <td class="bg">  
      
            <!-- Grid  (S) -->
            <table width="100%"  id="mainTable">
              <tr>
                <td width="100%">
                  <script language="javascript">ComSheetObject('t1sheet1');</script>
                </td>
              </tr>
            </table>
            <!-- Grid (E) -->      
          </td>
        </tr>
      </table>
      <!--biz page (E)-->
    </div>
    <!--TAB Unmatch (E) -->

    <!--TAB Match (S) -->
    <div id="tabLayer" style="display:none">
      <!-- Grid BG Box  (S) -->
      <table class="search" id="mainTable">
        <tr>
          <td class="bg">
            <!-- Grid  (S) -->
            <table width="100%" class="search"  id="mainTable"> 
              <tr>
                <td width="100%">
                <script language="javascript">ComSheetObject('t2sheet1');</script>
                </td>
              </tr>
            </table> 
            <!-- Grid (E) -->
            <script language="javascript">ComSheetObject('t1excel');</script>
            <script language="javascript">ComSheetObject('t2excel');</script>
          </td>
        </tr>
      </table>
      <!-- Grid BG Box  (S) -->
    </div>
    <!--TAB Match (E) -->
  </tr>
</table>
<!-- 개발자 작업  끝 -->
<%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_CLOSE.jsp" %>
</form>
</body>
</html>