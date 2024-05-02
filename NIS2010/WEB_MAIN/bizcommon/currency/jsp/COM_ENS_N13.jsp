<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : COM_ENS_N13.jsp
*@FileTitle : Currency Code
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.22
*@LastModifier : 박의수
*@LastVersion : 1.0
* 2009.04.22 박의수
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.bizcommon.currency.event.ComEnsN13Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    ComEnsN13Event  event = null;               //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount = 0;                           //DB ResultSet 리스트의 건수

    String strUsr_id        = "";
    String strUsr_nm        = "";
    Logger log = Logger.getLogger("com.hanjin.apps.BizCommon.Currency");
    String main_page = "";
    String cntCd = "";
    String currCd = "";
    String currDesc = "";
    
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        main_page = JSPUtil.getParameter(request, "main_page".trim(), "");
        event = (ComEnsN13Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        
        cntCd = JSPUtil.getParameter(request, "cnt_cd".trim(), "");
        currCd = JSPUtil.getParameter(request, "curr_cd".trim(), "");
        currDesc = JSPUtil.getParameter(request, "curr_desc".trim(), "");
        
    }catch(Exception e) {
        log.error(e.toString());
    }
%>
<html>
<head>
<title>Currency Code</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="/hanjin/css/alps_contents.css" type="text/css" rel="stylesheet"/>

<script language="javascript">
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        loadPage(<%=main_page%>);
    }
</script>
</head>

<!-- 개발자 작업 -->


<!-- OUTER - POPUP (S)tart -->
<%if(main_page.equals("true")){ %>
<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->
		
<%} else { %>
<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
    
            
        <!-- : ( Title ) (S) -->
        <table width="100%" border="0">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Currency Code</td></tr>
        </table>
        <!-- : ( Title ) (E) -->
<%} %>       
        <!-- : ( Search Options ) (S) -->
 
            <table class="search"> 
            <tr><td class="bg">
                
                <table width="100%" border="0" class="search">
                    <tr class="h23">
                        <td width="50">Country</td>
                        <td width="10"><input type="text" name="cnt_cd" style="width:20;ime-mode:disabled" dataformat="engup" class="input" value="<%=cntCd%>">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                        <td width="50">Currency</td>
                        <td width="15"><input type="text" name="curr_cd" style="width:30;ime-mode:disabled" dataformat="engup" class="input" value="<%=currCd%>">&nbsp;&nbsp;&nbsp;</td>
                        <td width="70">Description</td>
                        <td width=""><input type="text" name="curr_desc" style="width:200;" class="input"  value="<%=currDesc%>"></td>
                    </tr>
                </table>
                
                <table class="line_bluedot"><tr><td></td></tr></table>
                <!-- Grid  (S) -->
                <table width="100%"  id="mainTable"> 
                    <tr>
                        <td width="100%">
                            <script language="javascript">ComSheetObject('sheet1');</script>
                        </td>
                    </tr>
                </table>                
                <!-- Grid  (E) -->

            </td></tr>
        </table>
        
        
<table class="height_5"><tr><td></td></tr></table>
         
<!-- : ( Search Options ) (E) -->
</td></tr>
</table> 
   
    <%if(!main_page.equals("true")){ %>
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
    

            <table border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_downexcel">Down Excel</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                 
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_select">OK</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
               
               		 <td class="btn1_line"></td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_Close">Close</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
				
        </td></tr>
        </table></td>

    <!--Button (E) -->
    
    </td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
<%}else{ %>
<!--Button (S) -->
<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
     	<tr><td class="btn1_bg">

    <table border="0" cellpadding="0" cellspacing="0">
    <tr><td>
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
			<tr><td class="btn1_left"></td>
				<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
				<td class="btn1_right"></td>
			</tr>
		</table>
		</td>
		<td>
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                <tr><td class="btn1_left"></td>
                <td class="btn1" name="btn_downexcel">Down Excel</td>
                <td class="btn1_right"></td>
                </tr>
            </table>
        </td>
		<td>
		</td>
		</tr>
	</table>
</td></tr>
</table>
<%} %>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>

<%@include file="../../include/common_alps.jsp"%>
