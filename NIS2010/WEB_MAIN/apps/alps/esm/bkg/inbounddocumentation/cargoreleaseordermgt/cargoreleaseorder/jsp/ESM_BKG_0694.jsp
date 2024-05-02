<%
/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0694.jsp
 *@FileTitle : DO LIST CHECK REPORT(JAPAN)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.19
 *@LastModifier : 박만건
 *@LastVersion : 1.0
 * 2009.05.19 박만건
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0694Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmBkg0694Event  event = null;        //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;      //서버에서 발생한 에러
    String strErrMsg = "";            //에러메세지
    int rowCount   = 0;            //DB ResultSet 리스트의 건수
    
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";
    
    String strUsr_id    = "";
    String strUsr_nm    = "";
    Logger log = Logger.getLogger("com.hanjin.apps.InboundBLMgtSC.FullReleaseOrderBC");
    
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id =  account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
         
         
        event = (EsmBkg0694Event)request.getAttribute("Event");
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
<title>DO LIST CHECK REPORT(JAPAN)</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
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
      <table class="search"> 
        <tr>
          <td class="bg">

            <!--  biz_1  (S) -->
            <table class="search" border="0" style="width:979;"> 
              <tr class="h23">
                <td width="58">
                  <input type="radio" value="F" class="trans" checked="true" name="rd_flag" >&nbsp;&nbsp;VVD
                </td>
                <td width="95">
                  <input type="text" style="width:80;" class="input1" value="" name="vvd" caption="VVD" minlength="9"
                         maxlength="9" fullfill="true" required="true" style="ime-mode:disabled" >
                  <input type="hidden" name="vsl_cd" />
                  <input type="hidden" name="skd_voy_no" />
                  <input type="hidden" name="skd_dir_cd" />
                </td>
                <td width="30">POD</td>
                <td width="60">
                  <input type="text" style="width:50;" class="input1" value="" name="pod_cd" caption="POD" maxlength="5"
                         fullfill="true" style="ime-mode:disabled" />
                </td>
                <td width="30">D/O</td>
                <td width="60">
                  <select style="width:50;" class="input1" name="rlse_sts_cd">
                    <option value="Y" selected="true" >Yes</option>
                    <option value="N">No</option>
                    <option value="*">All</option>
                  </select>
                </td>
                <td width="105"><input type="radio" value="S" class="trans" name="rd_flag" >&nbsp;Issue Office</td>
                <td width="65">
                  <input type="text" style="width:50;" class="input1" value="" name="evnt_ofc_cd" caption="Issue Office" 
                         maxlength="5" style="ime-mode:disabled" >
                </td>
                <td width="61">D/O Date</td>
                <td width="" class="sm">
                  <input type="text" style="width:75;" class="input1" value="" 
                         name="evnt_dt_start" dataformat="ymd" maxlength="10" caption="D/O Start Date"
                         cofield="evnt_dt_end" style="width:100;ime-mode:disabled" >&nbsp;&nbsp;~&nbsp;
                  <input type="text" style="width:75;" class="input1" value="" 
                         name="evnt_dt_end" dataformat="ymd" maxlength="10" caption="D/O End Date"
                         cofield="evnt_dt_start" style="width:100;ime-mode:disabled" >&nbsp;
                  <img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_evnt_dt">&nbsp;&nbsp;(Only D/O Issue)
                </td>
                
                <td width="50">DOR I/F</td>
                <td width="60">
                  <select style="width:50;" class="input1" name="dor_if">
                    <option value="*">All</option>
                    <option value="Y">Yes</option>
                    <option value="N">No</option>
                  </select>
                </td>
                                
              </tr>
            </table>
          </td>
        </tr>
      </table>  
      <table class="height_8"><tr><td></td></tr></table>
      <table class="search"> 
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
      <!-- Grid BG Box  (S) -->
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
                  <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_Downexcel">Down-Excel</td>
                    <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_cargo">Cargo Release</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td class="btn1_line"></td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_print">Print</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
	            <td class="btn1_line"></td>
	            <td>
	                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
	                <tr><td class="btn1_left"></td>
	                    <td class="btn1" name="btn_if">DOR I/F</td>
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
    </td>
  </tr>
</table>

<!-- 개발자 작업  끝 -->

<%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_CLOSE.jsp" %>

</form>
</body>
</html>