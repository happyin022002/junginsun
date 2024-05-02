<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_FMS_0076.jsp
*@FileTitle : Item Name
*Open Issues :
*Change history :
*@LastModifyDate : 2009.03.24
*@LastModifier : 손진환
*@LastVersion : 1.0
* 2009.03.24 
* 1.0 Creation 
=========================================================*/
%>

<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>

<%
	Exception serverException = null;			
	String strErrMsg = "";	

	String usrId = "";

	Logger log = Logger.getLogger("com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   	usrId = account.getUsr_id();
		
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
	}catch(Exception e) {
		log.error(e.getMessage(),e);
	}
%>

<html>
<head>
<title>Item Name</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<%
	String fletAcctCateCd = JSPUtil.replaceForHTML(request.getParameter("flet_acct_cate_cd"));
%>

<script language="javascript">

    function setupPage(){  
    	var errMessage = "<%=strErrMsg%>";
    	
    	if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		
        loadPage();
    }

</script>


<body class="popup_bg" onLoad="setupPage();"> 

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="ibflag">
<input type="hidden" name="pagerows">
<input type="hidden" name="flet_acct_cate_cd" value="<%=fletAcctCateCd%>">

<!-- OUTER - POPUP (S)tart -->
<table width="550" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
    
        <!-- : ( Title ) (S) -->
        <table width="100%" border="0">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Item List Selection</td></tr>
        </table>
        <!-- : ( Title ) (E) -->
        <table class="search"> 
        <tr><td class="bg">        
		        <!--  biz_1  (S) -->
		        <table class="search" border="0" style="width:484;"> 
		        <tr class="h23">
		            <td width="50">Item</td>
		            <td width="">&nbsp;<input type="text" style="width:250;" class="input" name="acct_itm_nm"></td>
				</tr>
		        </table>
		        <!--  biz_1  (E) -->                        
                <table class="height_8"><tr><td colspan="6"></td></tr></table>		        
		        <!-- Grid  (S) -->
		            <table width="100%" class="search"   id="mainTable"> 
		                <tr>
		                    <td width="100%">
		                    <script language="javascript">ComSheetObject('sheet1');</script>
		                    </td>
		            </table> 
		        <!-- Grid (E) -->       
            </td></tr>
        </table>
<!-- : ( Search Options ) (E) -->
	<table class="height_5"><tr><td></td></tr></table>
</td></tr>
</table>     
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
                    <td class="btn1" name="btn1_Retrieve">Retrieve</td>
                    <td class="btn1_right"></td>
                </tr></table></td>            
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn1_Confirm">Confirm</td>
                    <td class="btn1_right"></td>
                </tr></table></td>
                <td class="btn1_line"></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn1_Close">Close</td>
                    <td class="btn1_right">
                </tr></table></td></td>
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
<%@include file="/bizcommon/include/common_alps.jsp"%>