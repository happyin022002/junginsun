<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CPS_CNI_0040.jsp
*@FileTitle : CCC Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.17
*@LastModifier : 정행룡
*@LastVersion : 1.0
* 2009.10.17 정행룡
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
    Exception serverException = null;
    String strErrMsg = "";

    String pageRows = "100";

    String userId = "";
    String userName = "";
    String userOffice = "";
    String userArea = "";
    
    Logger log = Logger.getLogger("com.hanjin.apps.alps.cps.cni.containercargoclaim.ContainerCargoClaimSC");
    
    String pop_flag = JSPUtil.getNull(request.getParameter("pop_flag"));
    String pop_title = JSPUtil.getNull(request.getParameter("pop_title"));
    String pop_desc = JSPUtil.getNull(request.getParameter("pop_desc"));
    String pop_cont_col = JSPUtil.getNull(request.getParameter("pop_cont_col"));
    String pop_cont = JSPUtil.getNull(request.getParameter(pop_cont_col));
    try
    {
        SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        userId = account.getUsr_id();
        userName = account.getUsr_nm();
        userOffice = account.getOfc_cd();
        
        serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null)
        {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        
      
    } catch (Exception e) {
        out.println(e.toString());
    }
%>
<html>
<head>
<title>CCC Detail</title>
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
<input type="hidden" name="pop_cont_col" value="<%=pop_cont_col%>">
<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;CCC Detail</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!--biz page (S)-->
		
<table class="search" id="mainTable"> 
    <tr><td class="bg">	
			<table class="grid2" border="0" style="width:100%;"> 
			<tr class="tr2_head"><td><%=pop_title.replace("_","&")%></td>
			</tr>
			<tr class="h23">
				<td><textarea style="width:100%" name="contents" rows="30"><%=pop_cont%></textarea></td>
			</tr>
			</table> 
				
		</td></tr>
		</table>	
	
</td></tr>
		</table>
<table class="height_5"><tr><td></td></tr></table>
	
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right">
				</tr></table></td>
				<td class="btn1_line">
				
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right">
				</tr></table></td>
			</tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
</td></tr>
</table>			
			
</form>
</body>
</html>