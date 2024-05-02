<%
/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESM_PRI_0125.js
*@FileTitle : Out of Date BKG
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.27
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2012.03.27 조정민
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
<%@ page import="com.hanjin.apps.alps.esm.pri.screport.screport.event.EsmPri0125Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmPri0125Event  event = null;              //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount     = 0;                       //DB ResultSet 리스트의 건수
    
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    
    String ctrtOfcCd = "";
    String ctrtSrepCd = "";
    String bkgFmDt = "";
    String bkgToDt = "";
    String vvd = "";

    Logger log = Logger.getLogger("com.hanjin.apps.SCReport.SCReport");
    
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
       
        event = (EsmPri0125Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        
        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        
        ctrtOfcCd = request.getParameter("ctrt_ofc_cd");
        ctrtSrepCd = request.getParameter("ctrt_srep_cd");
        bkgFmDt = request.getParameter("bkg_from_dt");
        bkgToDt = request.getParameter("bkg_to_dt");
        vvd = request.getParameter("vvd");
        
    }catch(Exception e) {
        out.println(e.toString());
    }
    
%>
<html>
<head>
<title>Out of Date BKG</title>
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

<!-- Form Hidden -->
<input type="hidden" name="ctrt_ofc_cd" value="<%=ctrtOfcCd%>">
<input type="hidden" name="ctrt_srep_cd" value="<%=ctrtSrepCd%>">
<input type="hidden" name="bkg_from_dt" value="<%=bkgFmDt%>">
<input type="hidden" name="bkg_to_dt" value="<%=bkgToDt%>">
<input type="hidden" name="vvd" value="<%=vvd%>">

        
<!-- OUTER - POPUP (S)tart -->
<table width="820" class="popup" cellpadding="10" border="0"> 
	<tr><td class="top"></td></tr>
	<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Out of Date BKG</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
				
				
		<table class="search" border="0"> 
			<tr>
				<td class="bg_b1">			
			<table class="height_10"><tr><td></td></tr></table>
			
				<!-- : ( Grid ) (S) -->
				<table width="100%" id="mainTable">
                       <tr><td>
                            <script language="javascript">ComSheetObject('sheet1');</script>
                       </td></tr>
	            </table>
				<!-- : ( Grid ) (E) -->
	

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
	</td></tr>
</table>

</form>
</body>
</html>