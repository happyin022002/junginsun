﻿<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1049.jsp
*@FileTitle : Error Details
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.05
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2009.10.05 김대호
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.event.EsmBkg1049Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmBkg1049Event  event = null;              //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount     = 0;                       //DB ResultSet 리스트의 건수
    
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    
    String blNo = "";
    String bkgNo = "";
    String umchBkgSeq = "";
    
    Logger log = Logger.getLogger("com.hanjin.apps.RevenueAudit.UnmatchBL");
    
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
       
        event = (EsmBkg1049Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        
        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        
        blNo = JSPUtil.replaceForHTML(request.getParameter("bl_no"));
        bkgNo = JSPUtil.replaceForHTML(request.getParameter("bkg_no"));
        umchBkgSeq = JSPUtil.replaceForHTML(request.getParameter("umch_bkg_seq"));
        
    }catch(Exception e) {
        out.println(e.toString());
    }
    
%>
<html>
<head>
<title>Error Details</title>
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
<!--  Office Code Validation 체크를 위한 정의 -->
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="cd">
<input type="hidden" name="backendjob_key">
<!-- Form Hidden -->
<input type="hidden" name="bkg_no" value="<%=bkgNo%>">
<input type="hidden" name="umch_bkg_seq" value="<%=umchBkgSeq%>">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
    <tr><td class="top"></td></tr>
    <tr>
        <td valign="top">
	
			<!-- : ( Title ) (S) -->
			<table width="100%" border="0">
	    		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Error Details</td></tr>
			</table>
			<!-- : ( Title ) (E) -->
		
			<!--biz page (S)-->
			<table class="search" id="mainTable"> 
	       		<tr>
	       		  <td class="bg">
				    <table class="search" border="0" style="width:100%;">
					   <tr class="h23">
							<td width="55">&nbsp;B/L No.</td>
							<td width=""><input type="text" name="bl_no" style="width:120;text-align:center;" class="input1" value="<%=blNo%>" readonly></td>
		                    <td width="540">&nbsp;</td>
		                    <td width="100">&nbsp;Audit Result</td>
		                    <td width=""><input type="text" name="audit_result" style="width:120;text-align:center;" class="input1" value="" readonly></td>
    					</tr>
	       			</table>
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
<tr><td height="71" class="popup">

    	<!--Button (S) -->	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5; padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
			<td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
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