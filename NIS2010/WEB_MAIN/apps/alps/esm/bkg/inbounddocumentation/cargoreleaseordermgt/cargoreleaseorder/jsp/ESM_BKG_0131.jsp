<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0131.jsp
*@FileTitle : Cargo Release Order_Do List Check Report
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0131Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmBkg0131Event  event = null;                    //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;            //서버에서 발생한 에러
    String strErrMsg = "";                        //에러메세지
    int rowCount     = 0;                        //DB ResultSet 리스트의 건수
    
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    Logger log = Logger.getLogger("com.hanjin.apps.InboundBLMgtSC.FullReleaseOrderBC");
    
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id =    account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
       
       
        event = (EsmBkg0131Event)request.getAttribute("Event");
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
<title>Cargo Release Order_Do List Check Report</title>
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

<!-- 개발자 작업    -->
 
<%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp" %>
        
  <!--biz page (S)-->
  <table class="search" id="mainTable"> 
    <tr>
      <td class="bg">
      
        <!--  biz_1  (S) -->
        <table class="search" border="0" style="width:972;"> 
          <tr class="h23">
            <td width="475">
              <table class="search_sm" border="0" style="width:465;"> 
                <tr class="h23">
                  <td width="105"><input type="radio" value="F" class="trans" name="rd_flag" >Release Date</td>
                  <td width="195">
                    <input type="text" style="width:70" class="input1" name="evnt_dt_fm" dataformat="ymd" 
                           maxlength="10" caption="Release Date From" 
                           cofield="evnt_dt_to" required="true" style="width:100;ime-mode:disabled" />&nbsp;~
                    <input type="text" style="width:70" class="input1" name="evnt_dt_to" dataformat="ymd" 
                           maxlength="10" caption="Release Date To" 
                           cofield="evnt_dt_fm" required="true" style="width:100;ime-mode:disabled" />
                    <img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_evnt_dt" >
                  </td>
                  <td width="22">OFC</td>
                  <td width="60">
                    <input type="text" style="width:50;" class="input" name="evnt_ofc_cd" caption="OFC" 
                           minlength="5" maxlength="6" style="ime-mode:disabled" >
                  </td>
                  <td width="17">ID</td>
                  <td width="">
                    <input type="text" style="width:50;" class="input" name="evnt_usr_id" caption="ID" maxlength="20" style="ime-mode:disabled" >
                  </td>
                </tr>
              </table>
            </td> 
            <td width="325">
              <table class="search_sm" border="0" style="width:315;"> 
                <tr class="h23">
                <td width="50"><input type="radio" value="T" class="trans" name="rd_flag" checked="true">VVD</td>
                <td width="100">
                  <input type="text" style="width:80" class="input1" name="vvd" caption="VVD" 
                         minlength="9" maxlength="9" fullfill="true" style="ime-mode:disabled" >
                  <input type="hidden" name="vsl_cd" />
                  <input type="hidden" name="skd_voy_no" />
                  <input type="hidden" name="skd_dir_cd" />
                </td>
                <td width="30">POD</td>
                <td width="75">
                  <input type="text" style="width:55" class="input1" name="pod_cd" caption="POD" maxlength="5" fullfill="true"
                         style="ime-mode:disabled" />
                </td>
                <td width="25">DEL</td>
                <td width="75">
                  <input type="text" style="width:50" class="input" name="del_cd" cpation="DEL" 
                         minlength="5" maxlength="5" fullfill="true" style="ime-mode:disabled" ></td>
                </tr>
              </table>
            </td>
            <td width="180">
              <table class="search_sm" border="0" style="width:180;"> 
                <tr class="h23">
                  <td width="80"><input type="radio" value="S" class="trans" name="rd_flag" >B/L No.</td>
                  <td width="">
                    <input type="text" style="width:95;" class="input1" name="bl_no" caption="B/L No." 
                           maxlength="12" style="ime-mode:disabled" >
                  </td>
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
        
        <table border="0" style="width:979"> 
				<tr class="h23">
					<td width="135">No. of released B/L</td>
					<td width="60"><input type="text" style="width:40;text-align:right;padding-right: 5px"  class="input" ID="tot_cnt" value=""></td> 
					<td width="25">TEU</td>
					<td width="75"><input type="text" style="width:60;text-align:right;padding-right: 5px" class="input" ID="tot_teu" value=" "></td> 
					<td width="25">FEU</td>
					<td width="75"><input type="text" style="width:60;text-align:right;padding-right: 5px" class="input" ID="tot_feu" value=""></td>
					<td width="55">TOT TEU</td>
					<td width=""><input type="text" style="width:60;text-align:right;padding-right: 5px" class="input" ID="tot_all_teu" value=""></td>					 
			  	 </tr>
				</table>
        
        <!-- Grid (E) -->            
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
            <!-- td>
              <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                <tr>
                  <td class="btn1_left"></td>
                  <td class="btn1" name="btn_FullCNTRRelease">Full CNTR Release</td>
                  <td class="btn1_right"></td>
                </tr>
              </table>
            </td-->
            <td>
              <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                <tr>
                  <td class="btn1_left"></td>
                  <td class="btn1" name="btn_CargoRelease">Cargo Release</td>
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
          </tr>
        </table>
      </td>
    </tr>
  </table>
  <!--Button (E) -->

</table>

<%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_CLOSE.jsp" %>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>