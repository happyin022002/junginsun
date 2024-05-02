<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_pso_0216.jsp
*@FileTitle : TPB Interface
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.26
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2012.11.12 진마리아
* 1.0 Creation
*
* History
* 2012.11.26 진마리아 CHM-201220618-01 TPB 비용 정보 지정시 해당 정보를 TPB IF용 테이블에 저장하고 제어함
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.event.VopPso0216Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	VopPso0216Event  event = null;					//PDTO(Data Transfer Object including Parameters)
    Exception serverException = null;
    String strErrMsg = "";
    int rowCount = 0; 

    String successFlag = "";
    String codeList = "";
    String pageRows = "100";

    String userId = "";
    String userName = "";
    String userOffice = "";
    String vvd       = "";
    String ifAmt     = "";
    String ifCurrCd    = "";
    String n3ptyBilTpCd = "";
    String ifRmk  = "";
    String n3ptyVndrSeq  = "";
    
    Logger log = Logger.getLogger("com.hanjin.apps.alps.vop.pso.EstimateInvoiceAudit.GeneralInvoiceAudit");
    
    
    try
    {
        SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        userId = account.getUsr_id();
        userName = account.getUsr_nm();
        userOffice = account.getOfc_cd();
        
        event = (VopPso0216Event) request.getAttribute("Event");
        serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null)
        {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        
        vvd         = StringUtil.xssFilter((String) request.getParameter("vvd"));
        ifAmt       = StringUtil.xssFilter((String) request.getParameter("ifAmt"));
        ifCurrCd    = StringUtil.xssFilter((String) request.getParameter("ifCurrCd"));
        n3ptyBilTpCd = StringUtil.xssFilter((String) request.getParameter("n3ptyBilTpCd"));
        ifRmk    = StringUtil.xssFilter((String) request.getParameter("ifRmk"));
        n3ptyVndrSeq    = StringUtil.xssFilter((String) request.getParameter("n3ptyVndrSeq"));
	
		
    }
    catch (Exception e)
    {
        out.println(e.toString());
    }
    
%>

<%@page import="com.hanjin.framework.component.util.StringUtil"%><html>
<head>
<title>3rd Party Interface</title>
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
<input type="hidden" name="if_amt" value="<%=ifAmt%>">
<input type="hidden" name="n3pty_bil_tp_cd" value="<%=n3ptyBilTpCd%>">
<input type="hidden" name="if_rmk" value="<%=ifRmk%>">
<input type="hidden" name="n3pty_vndr_seq" value="<%=n3ptyVndrSeq%>">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
    
        <!-- : ( Title ) (S) -->
        <table width="100%" border="0">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp; 3rd Party Interface</td></tr>
        </table>
        <!-- : ( Title ) (E) -->
        
        <!-- : ( Search Options ) (S) -->
        <table class="search"> 
            <tr><td class="bg">
            
         <!-- Grid  (S) -->
				<table class="search" border="0" style="width:100%;"> 
					<tr class="h23">
						<td width="100"> &nbsp; VVD</td>
						<td width="600"><input type="text" name="vvd" style="width:130;text-align:center" class="input2" value="<%=vvd%>" readonly></td>
					</tr>
					<tr class="h23">
						<td width="100"> &nbsp; Currency</td>
						<td width="600"><input type="text" name="if_curr_cd" style="width:130;text-align:center" class="input2" value="<%=ifCurrCd%>" readonly></td>
					</tr>
				</table>
					          
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
            	<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_Close">Close</td>
                    <td class="btn1_right"></td>
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