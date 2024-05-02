<%
/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0936.jsp
 *@FileTitle : DO Receiver and Ultimate Consignee(Incl. House BL No) Setting
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.09
 *@LastModifier : 박만건
 *@LastVersion : 1.0
 * 2009.07.09 박만건
 * 1.0 Creation
 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0936Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoRcvrVO" %>
<%@ page import="java.util.List" %>

<%
    EsmBkg0936Event  event = null;                //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;            //서버에서 발생한 에러
    String strErrMsg = "";                        //에러메세지
    int rowCount     = 0;                        //DB ResultSet 리스트의 건수
    
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    Logger log = Logger.getLogger("com.hanjin.apps.InboundBLMgtSC.FullReleaseOrderBC");
    
    // Local에 사용할 변수 선언
    String doNo = "";
    String bkgNo = "";
    String inDoOdcyAddrCd ="";
    String evntDt ="";
    int iSize = 0;
    
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id =    account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
       
       
        event = (EsmBkg0936Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        if (strErrMsg == null || strErrMsg.equals("")) {
        
            // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
            GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
            doNo            = JSPUtil.getParameter(request, "do_no");
            bkgNo           = JSPUtil.getParameter(request, "bkg_no");
            inDoOdcyAddrCd  = JSPUtil.getParameter(request, "in_do_odcy_addr_cd");
            evntDt          = JSPUtil.getParameter(request, "evnt_dt");
        }
        
    }catch(Exception e) {
        out.println(e.toString());
    }
%>
<html>
<head>
<title>DO Receiver and Ultimate Consignee(Incl. House BL No) Setting</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
    var parDoNo       = "<%=doNo%>";

    var errMessage = "<%= strErrMsg == null ? "" : StringUtil.xssFilter(strErrMsg)%>";
    
    function setupPage(){
//        if (errMessage.length >= 1) {
//            //ComShowMessage(errMessage);
//        } // end if
        loadPage();
    }
</script>
</head>

<body  class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="bkg_no" value="<%=bkgNo%>">
<input type="hidden" name="in_do_odcy_addr_cd" value="<%=inDoOdcyAddrCd%>">
<input type="hidden" name="evnt_dt" value="<%=evntDt%>">
<!-- 개발자 작업    -->
  
<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
  <tr><td class="top"></td></tr>
  <tr>
    <td valign="top">
    
      <!-- : ( Title ) (S) -->
      <table width="100%" border="0">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Receiver Info.</td></tr>
      </table>
      <!-- : ( Title ) (E) -->
      
      <!-- : ( Search Options ) (S) -->
      <table class="search"> 
        <tr>
          <td class="bg">
            <table class="search" border="0"> 
              <tr class="h23">
                <td width="60">&nbsp;&nbsp;D/O No.</td> 
                <td width="">
                  <input type="text" name="do_no" minlength="10" maxlength="12" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum');" readonly="true" style="width:100;text-align:center;" class="input2" value="">
                </td>
              </tr>
            </table>
            <table class="grid2" border="0" style="width:100%;"> 
              <tr class="h23">
                <td width="120" class="tr2_head">House B/L No.</td> 
                <td colspan="3"><input type="text" name="hbl_no" maxlength="30" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum','32|47');" style="width:100%" class="input" value=""></td>  
       
              </tr>
              <tr class="h23">
                <td width="" class="tr2_head">Ultimate Consignee</td> 
                <td colspan="3"><input type="text" name="rcvr_cnee_nm" maxlength="500" style="width:100%" class="input" value=""></td>
              </tr>
              <tr class="h23">
                <td width="" class="tr2_head">Receipt Company</td> 
                <td colspan="3"><input type="text" name="rcvr_co_nm" maxlength="50" style="width:100%" class="input" value=""></td>
              </tr>
              <tr class="h23">
                <td width="" class="tr2_head">Address</td> 
                <td colspan="3"><textarea style="width:99.2%; height:30" name="rcvr_cnee_addr" onKeyDown="fncTextareaMaxLine(this.value)"></textarea></td>
              </tr>
              <tr class="h23">
                <td width="120" class="tr2_head">Contact Phone</td> 
                <td width="200"><input type="text" name="rcvr_phn_no" style="ime-mode:disabled"  maxlength="20" style="width:100%" class="input" value=""></td>
                <td width="80" class="tr2_head">PIC</td> 
                <td width=""><input type="text" name="pic_nm" maxlength="100" style="width:100%" class="input" value=""></td>
              </tr>
              <tr class="h23">
                <td width="" class="tr2_head">Customer E-Mail</td> 
                <td><input type="text" name="rcvr_eml" style="ime-mode:disabled" maxlength="200" style="width:100%" class="input1" value=""></td>
                <td class="tr2_head">Order B/L</td> 
                <td width="" class="noinput2"><input type="text" name="cust_to_ord_flg_nm" style="width:100%" class="noinput2" value=""></td>
              </tr>
              <tr class="h23">
                <td width="" class="tr2_head">CFS E-Mail</td> 
                <td><input type="text" name="cfs_eml" style="ime-mode:disabled" maxlength="200" style="width:100%" class="input1" value=""></td>
                <td width="120" class="tr2_head">Empty Yard E-Mail</td> 
                <td width="" class="noinput"><input type="text" name="mty_yd_eml" style="width:100%" class="input" value=""></td>
              </tr>
            </table>
            <table>
			<tr class="h23">
                <td width="140" >Attached survey letter</td> 
                <td><input name="atch_svey_ltr_flg" class="trans" type="checkbox" value="Y"/></td>
              </tr>                       
            </table>
          </td>
        </tr>
      </table>
      <!-- : ( Search Options ) (E) -->
      <table class="height_5"> <tr> <td></td></tr></table>
    </td>
  </tr>
</table> 


  
    
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
  <tr>
    <td height="71" class="popup">
    
      <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
        <tr>
          <td class="btn3_bg">
            <table border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_Mail_Send">Email Send</td>
                      <td class="btn1_right"/>
                    </tr>
                  </table>
                </td>
                <td class="btn1_line"/>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_Save">Save</td>
                      <td class="btn1_right"/>
                    </tr>
                  </table>
                </td>
                <td class="btn1_line"/>
                <td>
                  <table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_Close">Close</td>
                      <td class="btn1_right"/>
                    </tr>
                  </table>
                </td> <!-- add -->
              </tr> <!-- add -->
            </table> <!-- add -->
          </td>
        </tr>
      </table>
      <!--Button (E) -->
    
    </td>
  </tr>
</table>
<!-- : ( Button : pop ) (E) -->
  <table >
  <tr>
    <td>
      <script language="javascript">ComSheetObject('sheet1');</script>
    </td>
  </tr>
</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>