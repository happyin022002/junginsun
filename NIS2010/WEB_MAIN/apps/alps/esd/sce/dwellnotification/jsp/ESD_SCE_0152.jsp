<%/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESD_SCE_0152.jsp
*@FileTitle : SCE
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.25
*@LastModifier : 이수진
*@LastVersion : 1.0
* 2011.07.25 이수진
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.dwellnotification.event.EsdSce0152Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdSce0152Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	
	String cust_cd   = "";
	String sc_no     = "";
	String start_dt  = "";
	String end_dt    = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	
		event = (EsdSce0152Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}	
	
	cust_cd =JSPUtil.getParameter(request, "cust_cd".trim(), "");	
	sc_no =JSPUtil.getParameter(request, "sc_no".trim(), "");	
	start_dt =JSPUtil.getParameter(request, "start_dt".trim(), "");
	end_dt =JSPUtil.getParameter(request, "end_dt".trim(), "");
%>

<html>
<head>
<title>Dwell/Delay Notification Sending Status Detail</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<script language="javascript">
	function setupPage() {
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body  class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0">
  <tr>
    <td class="top"></td>
  </tr>
  <tr>
    <td valign="top"><!-- : ( Title ) (S) -->
      <table width="100%" border="0">
        <tr>
          <td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Dwell/Delay Notification Sending Status Detail</td>
        </tr>
      </table>
      <!-- : ( Title ) (E) -->
      <!-- : ( Search Options ) (S) -->
      <table class="search">
        <tr>
          <td class="bg"><table class="search" border="0" style="width:500;">
              <tr class="h23">
              	<td width="69">Customer</td>
                <td width="102"><input type="text" style="width:80;" class="input2" name="cust_cd" value="<%=cust_cd %>" readonly></td>
                <td width="69">S/C NO :</td>
                <td width="102"><input type="text" style="width:80;" class="input2" name="sc_no" value="" readonly></td>
              </tr>
              <tr class="h23">  
                <td width="70">Period Fm :</td>
                <td width="97"><input type="text" style="width:80;" class="input2" name='start_dt' value="<%=start_dt%>" readonly></td>
                <td width="25">To :</td>
                <td width="136"><input type="text" style="width:80;" class="input2" name='end_dt' value="<%=end_dt%>" readonly></td>
              </tr>
            </table>
            <table class="line_bluedot">
              <tr>
                <td colspan="8"></td>
              </tr>
            </table>

            <!-- Grid  (S) -->
            <table width="100%"  id="mainTable"> 
                <tr>
                    <td width="100%">
                        <script language="javascript">ComSheetObject('sheet1');</script>
                    </td>
                </tr>

            </table>            
            <!-- Grid (E) -->  

        </tr>
      </table>
      <table class="height_5">
        <tr>
          <td></td>
        </tr>
      </table>
      <!-- : ( Search Options ) (E) --></td>
  </tr>
</table>
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
  <tr>
    <td height="71" class="popup"><table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
        <tr>
          <td class="btn3_bg"><table border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td width="72"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_close">Close</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table></td>
              </tr>
            </table></td>
        </tr>
      </table>
      <!--Button (E) --></td>
  </tr>
</table>
<!-- : ( Button : pop ) (E) -->

</form>

</body>
</html>
