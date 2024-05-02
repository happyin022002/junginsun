<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_5001.jsp
*@FileTitle : RDN Receipt by Office Print View
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2009.10.12 김대호
* 1.0 Creation
=========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    
    String successFlag = "";
    String codeList  = "";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    Logger log = Logger.getLogger("com.hanjin.apps.RevenueAudit.RevenueDebitNote");
    
    String progId = "";    
    
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
       
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        
        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

        progId = JSPUtil.replaceForHTML(request.getParameter("progId"));
        
    }catch(Exception e) {
        out.println(e.toString());
    }
%>

<html>
<head>
<title>RDN Receipt by Office Print ViewR</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>

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

<body onload="setupPage();">

<form name="form">

    <input type="hidden" name="prog_id" value="<%=progId%>">    

<table width="100%" class="popup" cellpadding="10">
	<tr>
		<td valign="top">
			<table width="100%" border="0">
				<tr>
					<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Revenue Debit Note</td>
				</tr>
			</table>
			<table class="search">
				<tr>
					<td class="bg">
						<table class="height_10"><tr><td></td></tr></table>
						<table class="search" border="0" style="width:980;" height="610"> 
							<tr><td><script language='javascript'>comRdObject('rd1');</script></td></tr>
						</table>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<!-- table class="height_5"><tr><td></td></tr></table-->
<table width="100%" border="0" class="sbutton">
    <tr>
        <td height="71" class="popup">
            <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" !style="padding-top:5;padding-bottom:10;">
                <tr>
                    <td class="btn3_bg">
                        <table border="0" cellpadding="0" cellspacing="0">
                            <tr>
                                <td>
                                    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                        <tr>
                                            <td class="btn1_left"></td>
                                            <td class="btn1" name="btn_Print">Print</td>
                                            <td class="btn1_right"></td>
                                        </tr>
                                    </table>
                                </td>
                                <td class="btn1_line"></td>
                                <td>
                                    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
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
        </td>
    </tr>
</table>

</form>

</body>
</html>