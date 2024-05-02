<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_JOO_0111.jsp
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.30
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2009.05.19 민정호
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
<%@ page import="com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.event.FnsJoo0111Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
  FnsJoo0111Event  event = null;       //PDTO(Data Transfer Object including Parameters)
  Exception serverException = null;    //서버에서 발생한 에러
  String strErrMsg = "";               //에러메세지
  int rowCount   = 0;                  //DB ResultSet 리스트의 건수

  String successFlag = "";
  String codeList = "";
  String pageRows = "100";

  String strUsr_id = "";
  String strUsr_nm = "";
  Logger log = Logger.getLogger("com.hanjin.apps.EquipmentMovementMgt.ContainerMovementFinder");
  String strFromyyyyMMdd = "";
  String strToyyyyMMdd = "";

  try {
    SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id = account.getUsr_id();
    strUsr_nm = account.getUsr_nm();

    event = (FnsJoo0111Event)request.getAttribute("Event");
    serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
    strFromyyyyMMdd = DateTime.getFormatDate( DateTime.addMonths( JSPUtil.getKST("yyyyMMdd"), -1 ), "yyyyMMdd", "yyyy-MM-dd" );
    strToyyyyMMdd   = DateTime.getFormatDate( JSPUtil.getKST("yyyyMMdd"), "yyyyMMdd", "yyyy-MM-dd");

    if (serverException != null) {
      strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
    }

    // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
    GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

  } catch(Exception e) {
    out.println(e.toString());
  }
%>
<html>
<head>
<title>Each Container</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
  function setupPage() {
    var errMessage = "<%=strErrMsg%>";
    if (errMessage.length >= 1) {
      showErrMessage(errMessage);
    } // end if
    loadPage();
  }
</script>
</head>
<!-- 개발자 작업 -->
<body onLoad="setupPage();">
<form name="form">
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
  <tr>
    <td valign="top">
      <!-- Page Title, Historical (S) -->
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
      </table>
      <!-- Page Title, Historical (E) -->
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- BackEndJob을 위한 Field -->
<input type="hidden" name="key">

      <!-- biz page (S) -->
      <table class="search">
        <tr>
          <td class="bg">
            <!-- biz_1 (S) -->
            <table class="search" border="0" style="width:979;">
                <tr class="h23">
                    <td width="45">Period&nbsp;</td>
                    <td width="250"><input type="text" style="width:80" class="input1" required dataformat="ymd"  maxlength="8" caption="Period From" name="pre_fr" value="<%=strFromyyyyMMdd%>" cofield="pre_to">&nbsp;<img src="img/btns_calendar.gif" align="absmiddle" name="btns_calendar_from" style="cursor:hand">&nbsp;~
                                    <input type="text" style="width:80" class="input1" required dataformat="ymd"  maxlength="8"  caption="Period To" name="pre_to" value="<%=strToyyyyMMdd%>" cofield="pre_fr">&nbsp;<img src="img/btns_calendar.gif" align="absmiddle" name="btns_calendar_to" style="cursor:hand"></td>
                    <td align="right">Lane&nbsp;</td>
                    <td><input type="text" style="width:50;ime-mode:disabled" class="input"  dataformat="uppernum"  maxlength="3" fullfill caption="Lane" name="rlane_cd">&nbsp;<img class="cursor" src="img/btns_search.gif" name="srch_rlane_cd" width="19" height="20" border="0" align="absmiddle"></td>
                    <td>&nbsp;&nbsp;</td>                    
                    <td align="right">Dir.&nbsp;</td>
                    <td><script language="javascript">ComComboObject("skd_dir_cd", 1, 60, 1, 0, 0);</script></td>
                    <td>&nbsp;&nbsp;</td>
                    <td align="right">VVD&nbsp;</td>
                    <td><input type="text" style="width:80" class="input" name="vvd" dataformat="uppernum" caption="VVD" maxlength="9" minlength="4" fullfill style="ime-mode:disabled"></td>
                    <td>&nbsp;&nbsp;</td>                    
					<td>&nbsp;</td>                    
					<td align="right">&nbsp;</td>
					<td></td>					                                        
					<td align="right"></td>
					<td></td>					                                        
					<td align="right"></td>					                    
                    <td width="300"></td>                    
                </tr>

			</table>
            <!-- biz_1 (E) -->
          </td>
        </tr>
      </table>

      <table class="height_8"><tr><td colspan="8"></td></tr></table>

      <table class="search">
        <tr>
          <td class="bg"  valign="top">
            <!-- biz_2 (S) -->
            <!-- Grid (S) -->
            <table width="100%"  border="0" id="mainTable">
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
      <!-- biz page (E) -->

      <!-- Button (S) -->
<table width="100% " class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr>
        <tr><td>
            <table border="0">
            <tr><td>
			</td></tr></table>          
		   </td>		          	
       	<td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    	<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
				</tr></table></td> 				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downexcel">Down Excel</td>
					<td class="btn1_right"></td>
				</tr></table></td>
			</tr>
		</table></td>
	</tr>
</table>
      <!-- Button (E) -->
      
    </td>
  </tr>
</table>
<!-- 개발자 작업 끝 -->
</form>
</body>
</html>