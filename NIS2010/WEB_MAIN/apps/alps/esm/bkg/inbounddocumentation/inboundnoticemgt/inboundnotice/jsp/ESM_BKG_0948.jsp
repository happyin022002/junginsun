<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0948.jsp
*@FileTitle : Hold Mail/Alert Set-Up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.06
*@LastModifier : 박미옥
*@LastVersion : 1.0
* 2009.05.06 박미옥
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg0948Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0948Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_eml       = "";
	String strCnt_cd        = "";
	Logger log = Logger.getLogger("com.hanjin.apps.InboundBLMgt.HoldNotice");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_eml = account.getUsr_eml();
		strCnt_cd = account.getCnt_cd();
	   
	   
		event = (EsmBkg0948Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

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
<title>Hold Mail/Alert Set-Up</title>
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
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->

<input type="hidden" name="user_id"  value="<%=strUsr_id %>">
<input type="hidden" name="user_eml" value="<%=strUsr_eml %>">
<input type="hidden" name="cnt_cd"   value="US">

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
                
            <!-- : ( Search Options ) (S) --> 
            <table class="search"> 
                <tr>
                    <td class="bg">                                
                        <table class="search" border="0" style="width:;"> 
                            <tr class="h23">
                                <td width="115">Customs Location</td> 
                                <td width="" align="left">
                                    <input type="text" style="width:53;ime-mode:disabled;" class="input1" name="loc_cd" value="" 
                                        caption="Customs Location" maxlength="5" minlength="5" dataformat="eng" required="" fullfill="fullfill" />
                                </td>
                                                             
                            </tr>
                        </table>
                        
                        <!-- : ( Grid ) (S) -->
                        <table width="100%"  id="mainTable"> 
                            <tr>
                                <td width="100%">
                                    <script language="javascript">ComSheetObject('sheet1');</script>
                                </td>
                            </tr>
                        </table>
                        <!-- : ( Grid ) (E) --> 
                        
                        <!--  Button_Sub (S) -->
                        <table width="100%" class="button"> 
                            <tr>
                                <td class="btn2_bg">
                                    <table border="0" cellpadding="0" cellspacing="0">
                                        <tr>
                                            <td>
                                                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                    <tr>
                                                        <td class="btn2_left"></td>
                                                        <td class="btn2" name="btn2_Add">Row Add</td>
                                                        <td class="btn2_right"></td>
                                                    </tr>
                                                </table>
                                            </td>
                                            <td>
                                                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                    <tr>
                                                        <td class="btn2_left"></td>
                                                        <td class="btn2" name="btn2_Delete">Row Delete</td>
                                                        <td class="btn2_right"></td>
                                                    </tr>
                                                </table>
                                            </td>                                                
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                        </table>
                        <!-- Button_Sub (E) -->
                        
                    </td>
                </tr>
            </table>
            <!-- : ( Search Options ) (E) -->

        </td>
    </tr>
</table>
<!-- Grid BG Box  (E) -->


<!--Button (S) -->
<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
    <tr>
        <td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
                <tr> 
                    <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                            <tr><td class="btn1_left"></td>
                                <td class="btn1" name="btn1_Retrieve">Retrieve</td>
                                <td class="btn1_right"></td>
                            </tr>
                        </table>
                    </td>
                    <td class="btn1_line"></td>
                    <td>
                        <table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
                            <tr>
                                <td class="btn1_left"></td>
                                <td class="btn1" name="btn1_Save">Save</td>
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

<%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_CLOSE.jsp"%>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>