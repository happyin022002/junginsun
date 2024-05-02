<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1607.jsp
*@FileTitle : Doc Surcharge Exemption Approval Remark
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.27
*@LastModifier : Jeongmin CHO
*@LastVersion : 1.0
* 2010.02.12 Jeongmin CHO
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.event.EsmBkg1606Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg1606Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String mstRfaRoutId         = "";
	Logger log = Logger.getLogger("com.hanjin.apps.InboundBLMgt.HoldNotice");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg1606Event)request.getAttribute("Event");
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
<title>Doc Surcharge Exemption Approval Remark</title>
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

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="gubun" value='<%=JSPUtil.getParameter(request, "gubun")%>'> 
<!-- 개발자 작업	-->

<table width="100%" class="popup" cellpadding="10" border="0"> 
    <tr><td class="top"></td></tr>

    <tr>
        <td valign="top">
    
            <!-- : ( Title ) (S) -->
            <table width="100%" border="0">
            <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle" />&nbsp;Doc Surcharge Exemption Approval Remark </td></tr>
            </table>
            <!-- : ( Title ) (E) -->
        
            <!--biz page (S)-->
            <table class="search" id="mainTable"> 
                <tr>
                    <td class="bg">
                                                
 
                        <!-- Grid  (S) -->
                        <table width="100%"  id="mainTable"> 
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
            <!--biz page (E)--> 


<table class="height_5"><tr><td></td></tr></table>
        </td>
    </tr>
</table>
    
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
    <tr>
        <td height="71" class="popup">
    
            <!--Button (S) -->  
            <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
                <tr>
                    <td class="btn3_bg">
                        <table border="0" cellpadding="0" cellspacing="0">
                            <tr>
                            
                               <td>
                               		<div id="DIV_BNT1" style="display:block;">
                                    <table border="0" cellpadding="0" cellspacing="0">
                                        <tr>
                                            <td class="btn1_left"></td>
                                            <td class="btn1" name="btn_Approve">Approve</td>
                                            <td class="btn1_right"></td>
                                        </tr>
                                    </table>
                                    </div>
                             		<div id="DIV_BNT2" style="display:block;">
                                    <table border="0" cellpadding="0" cellspacing="0">
                                        <tr>
                                            <td class="btn1_left"></td>
                                            <td class="btn1" name="btn_Reject">Reject</td>
                                            <td class="btn1_right"></td>
                                        </tr>
                                    </table>
                                    </div>
                                </td>
                                <td class="btn1_line"></td>
                                <td>
                                    <table border="0" cellpadding="0" cellspacing="0">
                                        <tr>
                                            <td class="btn1_left"></td>
                                            <td class="btn1" name="btn_Close">Close</td>
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
</form>
</body>
</html>