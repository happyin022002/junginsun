<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_pso_0217.jsp
*@FileTitle : Add information
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.25
*@LastModifier : kwkim
*@LastVersion : 1.0
* 1.0 Creation
* User가 직접 add info정보를 입력할 수 있도록 함.
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.event.VopPso0217Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	VopPso0217Event  event = null;					//PDTO(Data Transfer Object including Parameters)
    Exception serverException = null;
    String strErrMsg = "";
    int rowCount = 0; 

    String successFlag = "";
    String codeList = "";
    String pageRows = "100";

    String userId      = "";
    String userName    = "";
    String userOffice  = "";
    String vvd         = "";
    String ydcd        = "";
    String io          = "";
    String ydChgNo     = "";
    String ydChgVerSeq = "";
    
    Logger log = Logger.getLogger("com.hanjin.apps.alps.vop.pso.EstimateInvoiceAudit.GeneralInvoiceAudit");
    
    
    try
    {
        SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        userId = account.getUsr_id();
        userName = account.getUsr_nm();
        userOffice = account.getOfc_cd();
        
        event = (VopPso0217Event) request.getAttribute("Event");
        serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null)
        {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        
        vvd         = StringUtil.xssFilter((String) request.getParameter("vvd"));
        ydcd        = StringUtil.xssFilter((String) request.getParameter("yd_cd"));
        io          = StringUtil.xssFilter((String) request.getParameter("io"));
        ydChgNo     = StringUtil.xssFilter((String) request.getParameter("yd_chg_no"));
        ydChgVerSeq = StringUtil.xssFilter((String) request.getParameter("yd_chg_ver_seq"));
		
    }
    catch (Exception e)
    {
        out.println(e.toString());
    }
    
%>

<%@page import="com.hanjin.framework.component.util.StringUtil"%><html>
<head class="ui-dialog-title;ui-dialog-titlebar;ui-dialog-titlebar-close; ">

<title>Add Information </title>
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

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows">

<!-- 개발자 작업 -->

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
    

        
        <!-- : ( Search Options ) (S) -->
        <table class="search"> 
            <tr><td class="bg">
            
         <!-- Grid  (S) -->
				<table class="search" border="0" style="width:100%;"> 
					<tr class="h23">
					    <% if("IN".equals(io)){ %>
						<td width="470"> How many used No. or Hour of TUG when arrived? </td>
						<% } else { %>
						<td width="470"> How many used No. or Hour of TUG when departed?</td>
						<% } %>
						<td><input type="hidden" name="vvd"        value="<%=vvd%>" ></td>
						<td><input type="hidden" name="yd_cd"      value="<%=ydcd%>" ></td>
						<td><input type="hidden" name="io"         value="<%=io%>" ></td>
						<td><input type="hidden" name="yd_chg_no"  value="<%=ydChgNo%>" ></td>
						<td><input type="hidden" name="yd_chg_ver_seq"  value="<%=ydChgVerSeq%>" ></td>
					</tr>
					
				</table>
			    <br>		          
	            <table width="100%"  id="mainTable"> 
	                <tr>
	                    <td width="100%">
	                        <script language="javascript">ComSheetObject('sheet1');</script>
	                    </td>
	                </tr>
	            </table> 
            <!-- Grid (E) -->
            </td></tr>
        </table>
<!-- : ( Search Options ) (E) -->

<table class="height_5"><tr><td></td></tr></table>
</td></tr>
</table> 
    
    
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
    
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
        <tr><td class="btn3_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr>
            	<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_OK">OK</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
            <!-- <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_Close">Close</td>
                    <td class="btn1_right"></td> -->	
                	</tr>
                </table></td>
            </tr>
        </table>
    <!--Button (E) -->
    
    </td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
</td></tr>
</table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
 <%@include file="/bizcommon/include/common_alps.jsp"%>