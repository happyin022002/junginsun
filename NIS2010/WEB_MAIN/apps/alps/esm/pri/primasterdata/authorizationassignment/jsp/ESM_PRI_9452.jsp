<%@page import="com.hanjin.apps.alps.esm.pri.primasterdata.authorizationassignment.event.EsmPri9452Event"%>
<%
/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ESM_PRI_9452.js
*@FileTitle : Retroactive RFA Approval Auth - User Level (History)
*Open Issues :
*Change history :
*@LastModifyDate : 2016-09-02
*@LastModifier : Min-Gyung Lee
*@LastVersion : 1.0
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
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>

<%
    EsmPri9452Event  event = null;              //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount     = 0;                       //DB ResultSet 리스트의 건수
    
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    
    String prcCtrtTpCd = "";
    String prcUsrAuthTpCd = "";
    String authAproUsrId = "";
    String title = "";
    
    Logger log = Logger.getLogger("com.hanjin.apps.PRIMasterData.AuthorizationAssignment");
    
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
       
        event = (EsmPri9452Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        
        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        
        prcCtrtTpCd = StringUtil.xssFilter(request.getParameter("prc_ctrt_tp_cd"));
        prcUsrAuthTpCd = StringUtil.xssFilter(request.getParameter("prc_usr_auth_tp_cd"));
        authAproUsrId = StringUtil.xssFilter(request.getParameter("auth_apro_usr_id"));
        title = StringUtil.xssFilter(request.getParameter("title"));
    }catch(Exception e) {
        out.println(e.toString());
    }
    
%>
<html>
<head>
<title>Retroactive RFA Approval Auth - User Level (History)</title>
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

<body onLoad="setupPage();" style="overflow:hidden"> 

<form name="form"> 
<!--  Office Code Validation 체크를 위한 정의 -->
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="cd">
<input type="hidden" name="backendjob_key">
<!-- Form Hidden -->
<input type="hidden" name="prc_ctrt_tp_cd" value="<%=prcCtrtTpCd%>">
<input type="hidden" name="prc_usr_auth_tp_cd" value="<%=prcUsrAuthTpCd%>">
<input type="hidden" name="auth_apro_usr_id" value="<%=authAproUsrId%>">

<!-- OUTER - POPUP (S)tart -->
<table width="900" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;<%=title%></td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- 1 (S) -->
		<table class="search" id="mainTable"> 
       	<tr><td class="bg">	
				
			<!-- Grid - 2 (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
			<!-- Grid - 2 (E) -->	
			
				
				</td></tr>
			</table>
			<!-- grid box (E) -->
			
			
		</td></tr>
		</table>			
		<!-- 1 (E) -->

</td></tr></table>

<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

    	<!--Button (S) -->	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5; padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
			
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_excel">Down Excel</td>
					<td class="btn1_right"></td>
				</tr></table></td>
			<td class="btn1_line"></td>
			<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right"></td>
				</tr></table></td>
			</tr>
		</table></td>
			</tr>
		</table>
    	<!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

			
</form>
</body>
</html>