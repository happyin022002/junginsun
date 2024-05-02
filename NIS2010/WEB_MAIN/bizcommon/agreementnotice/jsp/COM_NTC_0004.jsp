<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : COM_NTC_0004.jsp
*@FileTitle : Agreement Expiration Notice
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.28
*@LastModifier : 전윤주
*@LastVersion : 1.0
* 2014.01.28 전윤주
* 1.0 Creation
=========================================================
* History
=========================================================*/
%>
<%@ page import="java.util.List"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.bizcommon.agreementnotice.event.ComNtc0004Event"%>

<%
	ComNtc0004Event  event = null;			    //PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String inlandFlag = "";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	
	String fPgmNo = "";
	
	Logger log = Logger.getLogger("com.hanjin.bizcommon.BizCommonSC.AgreementNoticeBC"); 

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		
		event = (ComNtc0004Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		fPgmNo = JSPUtil.getNull(request.getParameter("f_pgm_no"));
	
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Agreement Expiration Notice</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
 	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="f_pgm_no" value="<%=fPgmNo%>">
<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">

        <!-- : ( Title ) (S) -->
        <table width="100%" border="0">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Agreement Expiration Notice</td></tr>
        </table>
        <!-- : ( Title ) (E) -->

        <!-- : ( Search Options ) (S) -->

            <table class="search">
            <tr><td class="bg">
                <table class="search" border="0" style="width:100%">
               		<tr><td><br>Please be informed <input type="text" class="input1_1" style="width:30;text-align:center;border:0;background:transparent;" name="agmt_cnt" dataformat="int" readonly> contracts will be expired within 3 months.<br><br></td></tr>      		   
        	    	<tr><td><img src="/hanjin/img/ico_star.gif" border=0><strong>&nbsp;If you want to check more detail, Please click excel down button.<br><br></strong></td></tr> 
                </table>
                <table class="height_5"><tr><td></td></tr></table>
                <!-- : ( Grid ) (S) -->
                <table width="100%"  id="mainTable">
                    <tr>
                        <td width="100%">
                            <script language="javascript">ComSheetObject('sheet1');</script>
                        </td>
                    </tr>
                </table>
                <!-- : ( Grid ) (E) -->
            <!-- : ( Button : Grid ) (E) -->

            </td></tr>
        </table>
<!-- : ( Search Options ) (E) -->
</td></tr>
</table>

<table class="height_5" border="0"><tr><td></td></tr></table>


<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="70" class="popup" border="0">

        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
        <tr><td class="btn3_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_Downexcel">Down Excel</td>
                    <td class="btn1_right"></td>
                    </tr></table></td>
                    <td width="72"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_Close">Close</td>
                    <td class="btn1_right"></td>
                    </tr></table></td>
            </tr>
        </table>
    <!--Button (E) -->

    </td></tr>
    <table class="search" border="0" style="width:100%">
        <tr><td height="20" align="center" valign="middle">
         Do not show this message today.<input type="checkbox" name="Notice">
        </td></tr>
    </table>
</table>
<!-- : ( Button : pop ) (E) -->
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>