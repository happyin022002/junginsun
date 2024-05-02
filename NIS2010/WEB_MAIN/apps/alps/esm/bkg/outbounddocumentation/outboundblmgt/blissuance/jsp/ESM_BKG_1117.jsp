<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1117.jsp
*@FileTitle : Reject Message Edit
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.25
*@LastModifier : Ilmin Lee
*@LastVersion : 1.0
* 2010.05.25 Ilmin Lee
* 1.0 Creation
=========================================================*/%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event.EsmBkg1117Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
    EsmBkg1117Event event = null;              //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount = 0;                       //DB ResultSet 리스트의 건수
    String bkgNo = "";
   	Logger log = Logger.getLogger("com.hanjin.apps.OutboundBLMgt.BLDocumentation");
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        event = (EsmBkg1117Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        bkgNo = JSPUtil.getParameter(request, "bkg_no");
    } catch(Exception e) {
        out.println(e.toString());
    }
%>
<html>
<head>
<title>Reject Message Edit</title>
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
<input type="hidden" name="f_cmd">
<input type="hidden" name="bkg_no" value="<%=bkgNo%>">
<input type="hidden" name="sr_sts_cd" value="R">

<!-- OUTER - POPUP (S)tart -->
<table width="600" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Reject Message Edit</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			
			<table class="grid2" border="0" style="width:100%;"> 
			<tr>
				<td width=""><textarea name="remark" id="remark" style="width:99%;height:220;"></textarea> <!-- Grid  (E) --></td>
			</tr>    
			</table>
				
		</td></tr></table>
		<!--biz page (E)--> 

</td></tr></table>

<table class="height_5"><tr><td></td></tr></table>

<!--Grid (S)-->
<table width="0" id="mainTable" style="display:hidden"> 
	<tr>
		<td width="0">
			<script language="javascript">ComSheetObject('sheet1');</script>
		</td>
	</tr>
</table> 
<!--Grid (E)-->
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

    	<!--Button (S) -->	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       		<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
			<td><table border="0" cellpadding="0" cellspacing="0">
				<tr><td class="btn1_left"></td>
				<td class="btn1" name="btn_Reject">Reject</td>
				<td class="btn1_right"></td>
				</tr></table></td>
			<td class="btn1_line"></td>	
			<td><table border="0" cellpadding="0" cellspacing="0">
				<tr><td class="btn1_left"></td>
				<td class="btn1" name="btn_Close">Close</td>
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