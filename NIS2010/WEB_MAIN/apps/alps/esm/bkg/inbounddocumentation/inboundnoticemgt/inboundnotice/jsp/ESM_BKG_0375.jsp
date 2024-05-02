<%
/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0375.jsp
 *@FileTitle : Arrival Notice Form Setting
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.28
 *@LastModifier : 박만건
 *@LastVersion : 1.0
 * 2009.04.28 박만건
 * 1.0 Creation
 * 2009.06.30 박성호 수정
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg0375Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmBkg0375Event  event = null;          //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;      //서버에서 발생한 에러
    String strErrMsg = "";            //에러메세지
    int rowCount   = 0;            //DB ResultSet 리스트의 건수
    
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";
    
    String strUsr_id    = "";
    String strUsr_nm    = "";
    Logger log = Logger.getLogger("com.hanjin.apps.InboundBLMgt.ArrivalNotice");
    
    /* page constant */
    String agentKndCd = "6";
    
    /* user define variable */
    String strOfc_cd = "";
    String strCnt_cd = "";
    String strPodCds = "";
    String strOfcKndCd = "";
    // 다른화면에서 부터 요청받았을 때 처리할 변수 목록 (시작)
    String parAutoSearchFlg = JSPUtil.getParameter(request, "autoSearchFlg");
    
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id =  account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
         
        strOfc_cd = account.getOfc_cd();
        strCnt_cd = account.getCnt_cd();
        
        event = (EsmBkg0375Event)request.getAttribute("Event");
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
<title>Arrival Notice Form Setting</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
    var strOfc_cd = "<%=strOfc_cd%>";
    var strCnt_cd = "<%=strCnt_cd%>";
    
    // 다른화면에서 부터 요청받았을 때 처리할 변수 목록 (시작)
    var parAutoSearchFlg = "<%=parAutoSearchFlg %>";

    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            showErrMessage(errMessage);
        } // end if
        
        var formObject = document.form;
        formObject.ofc_cd.value =strOfc_cd;
        loadPage();
    }
</script>
</head>

<body onLoad="setupPage();">
<form name="form" >
<input name="f_cmd" value="" type="hidden" />
<input name="pagerows" type="hidden" />
<input name="login_ofc_cd" type="hidden" value="<%=strOfc_cd%>"/>
<!-- 개발자 작업  -->

<%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp" %>
  
      <!--Button (S) -->
      <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:10;"> 
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
                <td>
                  <table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_New" >New</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td class="btn1_line"></td>
                <td>
                  <table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_Save" >Save</td>
                    <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="72" border="0" cellpadding="0" cellspacing="0" class="button" >
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_Del" >Delete</td>
                    <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_ANSetup">A/N Setup</td>
                    <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
              </tr>
            </table>
        
      <!--Button (E) -->
       <table class="height_2"><tr><td colspan="8"></td></tr></table>
      <!--biz page (S)-->
      <table class="search"> 
        <tr>
          <td class="bg">
      
            <!--  biz_1  (S) -->
            <table class="search" border="0" style="width:979;"> 
              <tr class="h23">
                <td width="40">Office</td>
                <td width="90" >
                  <input name="an_seq" value="" type="hidden" />
                  <input name="an_tp_cd" value="ARN" required="true" type="hidden" /> 
                  <input name="ofc_cd" caption="Office" dataformat="" minlength="5" maxlength="6" 
                         type="text" style="width:60;" class="input1" required="true" style="ime-mode:disabled" 
                         onKeyPress="objEnter(this);" id="ofc_cd"
                         />
                </td>
                <td width="30">POD</td>
                <td width="160">
                  <input name="pod_cd" type="text" value="" caption="POD" maxlength="5" size="5" style="ime-mode:disabled" onKeyPress="objEnter(this);"/>              
                  <select name="pod_cd_combo" caption="POD" style="width:70;" class="input" ></select>      
                </td>
                <td width="40">AGENT</td>
                <td width=" ">
                  <input name="chn_agn_cd" type="text" caption="AGENT" maxlength="2" fullfill="true" size="2" style="ime-mode:disabled" onKeyPress="objEnter(this);"/>
                  <select name="chn_agn_cd_combo" caption="AGENT" style="width:70;" class="input" ></select>
                </td>
              </tr>
            </table>

            <table class="search" border="0" style="width:979;"> 
              <tr class="h23">
                <td width="400">
                  <table class="search_sm2" border="0" style="width:380;"> 
                    <tr class="h23">
                      <td>A/N Preview Form</td>
                      <td class="stm">
                        <input name="arr_prv_fom_cd" caption="A/N Preview Form" value="GE" type="radio" class="trans" checked="true" >General&nbsp;&nbsp;&nbsp;&nbsp;
                        <input name="arr_prv_fom_cd" caption="A/N Preview Form"  value="BL" type="radio" class="trans">B/L Form&nbsp;&nbsp;&nbsp;&nbsp;
                        <input name="arr_prv_fom_cd" caption="A/N Preview Form"  value="NL" type="radio" class="trans" >Notify Letter
                      </td>
                    </tr>
                  </table>
                </td>
                <td width="100">A/N Language</td>
                <td width="170">
                  <select name="locl_lang_flg" caption="A/N Language"  style="width:140;" class="input">
                    <option value="N">English</option>
                    <option value="Y">Local Language</option>
                  </select>
                </td>
                <td width="110">Enclose B/L Copy</td>
                <td width="">
                  <select name="eclz_bl_cpy_flg" caption="Enclose B/L Copy" style="width:90;" class="input">
                    <!-- <option value=""></option> -->
                    <option value="N" selected="true" >No</option>
                    <option value="Y">Yes </option>
                  </select>
                </td>
              </tr>
            </table>
            <!--  biz_1   (E) -->
          </td>
        </tr>
      </table>
    </td>
      
       
      
    <!-- Tab ) (S) -->
    <table class="tab" border="0" cellpadding="0" cellspacing="0" width="100%" > 
      <tr>
        <td width="100%">
          <script language="javascript">ComTabObject('tab1')</script>
          <!-- img src="img/sub_tab.gif" alt="" width="998" height="23" border="0" -->
        </td>
      </tr>
    </table>
    <!-- Tab ) (E) -->  
      <table class="search"> 
        <tr>
          <td class="bg">
    <!--TAB General (S) -->
    <div id="tabLayer" style="display:inline">
      <!-- Grid BG Box  (S) -->
      
            <!-- Biz 2  (S) -->
            <table width="100%" class="grid2"> 
              <tr class="tr2_head"><td align="left">Address</td></tr>
              <tr class=""><td><input type="text" name="ge_addr_ctnt" style="width:100%;height:22;" maxlength="500" /></td></tr>
            </table> 
            <table class="line_bluedot"><tr><td></td></tr></table>
            <table width="100%" class="grid2"> 
              <tr class="tr2_head"><td align="left">Important Notice</td></tr>
              <tr class="">
                <td><textarea name="ge_impt_ntc_rmk" caption="'General' Important Notice" style="width:100%;height:250;" ></textarea></td>
              </tr>
            </table> 
            <!-- Biz 2  (S) -->
         
      <!-- Grid BG Box  (S) -->
      <!--biz page (E)-->
    </div>
    <!--TAB General (E) -->   

    <!--TAB Door (S) -->
    <div id="tabLayer" style="display:none">
      <!-- Grid BG Box  (S) -->
      
            <!-- Biz 2  (S) -->
            <table width="100%" class="grid2"> 
              <tr class="tr2_head"><td align="left">Address</td></tr>
              <tr class=""><td><input type="text" name="dr_addr_ctnt" style="width:100%;height:22;" maxlength="500" /></td></tr>
            </table> 
            <table class="line_bluedot"><tr><td></td></tr></table>
            <table width="100%" class="grid2"> 
              <tr class="tr2_head"><td align="left">Important Notice</td></tr>
              <tr class="">
                <td><textarea name="dr_impt_ntc_rmk" caption="'Door' Important Notice" maxlength="4000" style="width:100%;height:250;"></textarea></td>
              </tr>
            </table> 
            <!-- Biz 2  (S) -->
         
      <!-- Grid BG Box  (S) -->
    </div>
    <!--TAB Door (E) --> 

    <!--TAB CY (S) -->
    <div id="tabLayer" style="display:none">
      <!-- Grid BG Box  (S) -->
     
            <!-- Biz 2  (S) -->
            <table width="100%" class="grid2"> 
              <tr class="tr2_head"><td align="left">Address</td></tr>
              <tr class=""><td><input type="text" name="cy_addr_ctnt" style="width:100%;height:22;" maxlength="500" /></td></tr>
            </table> 
            <table class="line_bluedot"><tr><td></td></tr></table>
            <table width="100%" class="grid2"> 
              <tr class="tr2_head"><td align="left">Important Notice</td></tr>
              <tr class="">
                <td><textarea name="cy_impt_ntc_rmk" caption="'CY' Important Notice" maxlength="4000" style="width:100%;height:250;"></textarea></td>
              </tr>
            </table> 
            <!-- Biz 2  (S) -->
        
      <!-- Grid BG Box  (S) -->

    </div>
    <!--TAB CY (E) --> 

    <!-- (TAB) CFS Cargo (S) -->
    <div id="tabLayer" style="display:none">
      <!-- Grid BG Box  (S) -->
      
          <!-- Biz 2  (S) -->
            <table width="100%" class="grid2"> 
              <tr class="tr2_head"><td align="left">Address</td></tr>
              <tr class=""><td><input type="text" name="cf_addr_ctnt" style="width:100%;height:22;" maxlength="500" /></td></tr>
            </table>
            <table class="line_bluedot"><tr><td></td></tr></table>
            <table width="100%" class="grid2"> 
              <tr class="tr2_head"><td align="left">Important Notice</td></tr>
              <tr class="">
                <td><textarea name="cf_impt_ntc_rmk" caption="'CFS' Important Notice" maxlength="4000" style="width:100%;height:250;"></textarea></td>
              </tr>
            </table> 
            <!-- Biz 2  (S) -->
         
      <!-- Grid BG Box  (S) -->
    </div>
    <!-- (TAB) CFS Cargo (E) -->   

    <!-- (TAB) Special Cargo (S) -->
    <div id="tabLayer" style="display:none">
      <!-- Grid BG Box  (S) -->
    
            <!-- Biz 2  (S) -->
            <table width="100%" class="grid2"> 
              <tr class="tr2_head"><td align="left">Address</td></tr>
              <tr class=""><td><input type="text" name="sp_addr_ctnt" style="width:100%;height:22;" maxlength="500" /></td></tr>
            </table> 
            <table class="line_bluedot"><tr><td></td></tr></table>
            <table width="100%" class="grid2"> 
              <tr class="tr2_head"><td align="left">Important Notice</td></tr>
              <tr class="">
                <td><textarea name="sp_impt_ntc_rmk" caption="'Special Cargo' Important Notice" maxlength="4000" style="width:100%;height:250;"></textarea></td>
              </tr>
            </table> 
            <!-- Biz 2  (S) -->
         
      <!-- Grid BG Box  (S) -->
    </div>
    <!-- (TAB) Special Cargo (E) -->  

    <!-- (TAB) Event (S) -->
    <div id="tabLayer" style="display:none">
      <!-- Grid BG Box  (S) -->
    
            <!-- Biz 2  (S) -->
            <table width="100%" class="grid2"> 
              <tr class="tr2_head"><td align="left">Address</td></tr>
              <tr class=""><td><input type="text" name="e1_addr_ctnt" style="width:100%;height:22;" maxlength="500" /></td></tr>
            </table> 
            <table class="line_bluedot"><tr><td></td></tr></table>
            <table width="100%" class="grid2"> 
              <tr class="tr2_head"><td align="left">Important Notice</td></tr>
              <tr class="">
                <td><textarea name="e1_impt_ntc_rmk" caption="'Event' Important Notice" maxlength="4000" style="width:100%;height:250;"></textarea></td>
              </tr>
            </table> 
            <!-- Biz 2  (S) -->
         
      <!-- Grid BG Box  (S) -->
      <!--biz page (E)-->
    </div>
    <!-- (TAB) Event (E) -->  

    <!-- Grid  (S) -->
    <table width="100%"  id="mainTable" style="display:none">
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
    <table class="height_5"><tr><td colspan="8"></td></tr></table>
  </tr>
</table>
<!-- 개발자 작업  끝 -->

<%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_CLOSE.jsp" %>

</form>
</body>
</html>