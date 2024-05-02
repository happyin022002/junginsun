<%/*=========================================================
     *Copyright(c) 2009 CyberLogitec
     *@FileName : COM_CSR_0016.jsp
     *@FileTitle :  [COM_CSR_0016] Request No. Reference
     *Open Issues :
     *Change history :
     *@LastModifyDate : 2009.04.21
     *@LastModifier : 진윤오
     *@LastVersion : 1.0
     * 2009.04.17 진윤오
     * 1.0 Creation
     =========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="com.hanjin.bizcommon.csr.csrcommon.csrcommonmanagement.event.ComCsr0016Event"%>
<%
	ComCsr0016Event event = null; //PDTO(Data Transfer Object including Parameters)
    Exception serverException = null; //서버에서 발생한 에러
    String strErrMsg = ""; //에러메세지
    int rowCount = 0; //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList = "";
    String pageRows = "100";

    String strUsr_id = "";
    String strUsr_nm = "";
    Logger log = Logger.getLogger("com.hanjin.bizcommon.csr.csrcommon.csrcommonmanagement.CSRApprovalCommonManagementBC");
    
    String ofc_cd = ""; 

    try
    {
        SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        ofc_cd	  = account.getOfc_cd();
        
        event = (ComCsr0016Event) request.getAttribute("Event");
        serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null)
        {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

    }
    catch (Exception e)
    {
        out.println(e.toString());
    }
%>




<html>
<head>
<title>CSR Approval Type Selection</title>
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
<form name="form" method="post">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows"> 

<!-- 개발자 작업 -->
<%-- <input type="hidden" name="rqst_ofc_cd" value="<%=rqst_ofc_cd%>"> --%>
<input type="hidden" name="apro_tp_cd">
<input type="hidden" name="csr_no" value="<%=JSPUtil.getParameter(request, "csr_no")%>">
<input type="hidden" name="ofc_cd" value="<%=ofc_cd%>">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
    
        <!-- : ( Title ) (S) -->
        <table width="100%" border="0">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;CSR Approval Type Selection</td></tr>
        </table>
        <!-- : ( Title ) (E) -->
        
        <!--biz page (S)-->
        <table class="search" id="mainTable"> 
            <tr><td class="bg">
            	<table class="search" border="0" width="100%">
					<tr>   							
       					<td width="40%"><strong>Approval Type</strong></td>
       					<td width="30%"><input type="radio" name="apro_tp_cd" value="AL" class="trans" checked>&nbsp;ALPS</td>
       					<td width="30%"><input type="radio" name="apro_tp_cd" value="GW" class="trans" >&nbsp;Groupware</td>
       				</tr>	 
	        	</table>
                <!-- Grid  (S) -->
             <div style="display:none">
             <table width="100%" id="mainTable"> 
                <tr>
                    <td width="100%">
                        <script language="javascript">ComSheetObject('sheet1');</script>
                    </td>
                </tr>
            </table> 
            </div>
                <!-- Grid (E) -->   
            
        </td></tr></table>
        <!--biz page (E)--> 

<table class="height_5"><tr><td></td></tr></table>

</td></tr></table>
    
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

        <!--Button (S) -->  
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
        <tr><td class="btn3_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn1_Select">Select</td>
                    <td class="btn1_right"></td>
                </tr></table></td>  
            </tr>
        </table>
        <!--Button (E) -->        </td>
        
        </tr>
        </table>
        
</td>
</tr>
</table>    
<!-- : ( Button : pop ) (E) -->
 <script language="javascript" type="text/javascript" src="bizcommon/csr/CoCsr.js"></script>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>