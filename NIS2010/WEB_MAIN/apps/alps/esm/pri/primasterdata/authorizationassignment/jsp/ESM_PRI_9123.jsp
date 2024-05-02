<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_9123.jsp
*@FileTitle : Change Session
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.05
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2011.08.05 송민석
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
<%@ page import="com.hanjin.apps.alps.esm.pri.primasterdata.authorizationassignment.event.EsmPri9123Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="java.util.List"%>
<%
    EsmPri9123Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount     = 0;                       //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String strOfc_cd        = "";
    String[] svcScpCds = null;
    Logger log = Logger.getLogger("com.hanjin.apps.PRIMasterData.AuthorizationAssignment");

    try {
    	



        event = (EsmPri9123Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        SignOnUserAccount newAccount = (SignOnUserAccount)event.getAttribute("NEW_SIGN_ON_USER_ACCOUNT");
        String msg = (String)event.getAttribute("NEW_SIGN_ON_USER_ACCOUNT_MSG");
        
        if( newAccount != null   ){
        	session.setAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT,newAccount);
        	//event.setAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT,null);
%>
<script>
	parent.callbackFunction("Y","Your session has been changed.\nYou are <%=newAccount.getUsr_id()%> .");
</script>
<%        	
 
        	return;
        }else if(msg != null && msg.length() != 0){
        	%>
        	<script>
        		parent.callbackFunction("N","<%=msg%>");
        	</script>
        	<%     
        	return;
        }
        
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strOfc_cd = account.getOfc_cd();

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
<title>Change User</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
    var strUsr_id = "<%=strUsr_id%>";
	var strUsr_nm = "<%=strUsr_nm%>";
	var strOfc_cd = "<%=strOfc_cd%>";
	
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
<input type="hidden" name="is_inq" value="Y">
<!-- 개발자 작업 -->


<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">

    <tr><td valign="top">
    <!--Page Title, Historical (S)-->
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
            <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
            <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"> Change User </td></tr>
        </table>
    <!--Page Title, Historical (E)-->


    <!--biz page (S)-->

                <!--  biz_1   (E) -->
                <table class="height_8"><tr><td></td></tr></table>

    <table class="search">
        <tr><td class="bg">

                <!--  biz_2  (S) -->
  

                <table class="line_bluedot"><tr><td colspan="8"></td></tr></table>

    <table class="search" border="0" style="width:100%;">
        <tr class="h23">
 
        <td width="73%" valign="">

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

            <!--  biz_2   (E) -->

            </td></tr>
            </table>
                <!--Button (S) -->
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
        <tr><td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_change" id="btn_change">Change</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table>
            </td>
            </tr>
            </table>
        </td></tr>
        </table>
    <!--Button (E) -->

            </td>
            </tr>
        </table>

		<div id="tabLayer" style="display: none">
		<iframe name="changeIframe" id="changeIframe" frameborder="1" scrolling="no" width="100%" height="100" src="about:blank"></iframe></div>
    <!--biz page (E)-->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>