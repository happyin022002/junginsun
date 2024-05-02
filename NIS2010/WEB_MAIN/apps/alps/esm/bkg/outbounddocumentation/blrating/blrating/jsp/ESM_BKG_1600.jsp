<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_1600.jsp
*@FileTitle : C/A Issue Reason Selection
*Open Issues : ESM_BKG_1600 화면
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.13 
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.event.EsmBkg1600Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg1600Event  event           = null;	//PDTO(Data Transfer Object including Parameters)
	Exception        serverException = null;	//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	Logger log = Logger.getLogger("com.hanjin.apps.BlRating.BlRating");
	
	try {	
		event = (EsmBkg1600Event)request.getAttribute("Event");		
		GeneralEventResponse eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
	        strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title><%=JSPUtil.getParameter(request, "chg_cd")%> Exemption Request</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		}
		loadPage();
	}
</script>
</head>

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<!-- 개발자 작업	-->
<input type="hidden" name="bkg_no" value="<%=JSPUtil.getParameter(request, "bkg_no")%>">
<input type="hidden" name="chg_cd" value="<%=JSPUtil.getParameter(request, "chg_cd")%>">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		    <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp; <%=JSPUtil.getParameter(request, "chg_cd")%> Exemption Request</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
		<table class="search">
		   <tr><td class="bg">
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
						To exempt the amount of the charges, please fill in below:
						</td>
					</tr>
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table> 	
							
				
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table> 				
			    <!-- : ( Button : Grid ) (E) -->
			    
				<table class="height_5"><tr><td></td></tr></table>
				
				
				
				<table border="0" style="width:410;height:90;background-color:white" class="grid2"> 
					<tr><td width="80" class="tr2_head">Remark</td>
						<td><textarea name="chg_amd_rmk" cols="43" rows="5" style="font-family:Courier New; font-size:12px; text-indent:0px;overflow-y:scroll;overflow-x:hidden" class="textarea_img5" wrap="physical" dataformat="etc" onBlur="javascript:validateCols('5','40',this);" wrap="hard" maxlength="1000" Caption="Remark"></textarea></td>
					</tr>
				</table>
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->

<table class="height_5"><tr><td></td></tr></table>
<table class="height_5"><tr><td></td></tr></table>
</td></tr>
</table> 
	
				
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" > 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					    <tr><td class="btn1_left"></td>
					        <td class="btn1" name="btn_request">Request</td>
					        <td class="btn1_right"></td>
				        </tr></table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_cancel">Cancel</td>
						<td class="btn1_right"></td>
					</tr></table>
			</td></tr>
			</table>
			</td></tr>
		</table>
    <!--Button (E) -->	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
<!-- Grid  (S) -->
<script language="javascript">ComSheetObject('h1sheet1');</script>
<script language="javascript">ComSheetObject('h1sheet2');</script>
<!-- Grid (E) -->
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
<%@include file="/bizcommon/include/common_alps.jsp"%>
