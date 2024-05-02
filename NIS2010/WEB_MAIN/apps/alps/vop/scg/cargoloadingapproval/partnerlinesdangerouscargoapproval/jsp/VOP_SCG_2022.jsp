<%/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VOP_SCG_2022.jsp
*@FileTitle : Remark
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.08
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2014.07.08 
* 1.0 Creation
*----------------------------------------------------------
* History
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.event.VopScg2022Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	VopScg2022Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String remark = StringUtil.xssFilter(request.getParameter("email_info"));
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (VopScg2022Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>INFORMATION</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	var sFunc       = "<%=JSPUtil.getParameter(request, "func")%>";
	var sCaller     = "<%=JSPUtil.getParameter(request, "caller")%>";
	var invNo       = "<%=JSPUtil.getParameter(request, "inv_no")%>";
	
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
	<tr>
		<td class="top"></td>
	</tr>
	<tr>
		<td valign="top">
			<!-- : ( Title ) (S) -->
			<table width="100%" border="0">
				<tr>
					<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp; Info </td>
				</tr>
			</table>
			<!-- : ( Title ) (E) -->
			<!--biz page (S)-->
			<table class="search" id="mainTable"> 
		    	<tr>
		    		<td class="bg">
		       		
						<!-- Grid_1 (S) -->
						<table width="100%"  id="mainTable"> 
							<tr>
								<td width="100%">
						        		<input type="hidden" name="info" style="width:400;height:100" class="input2" readonly value="<%=remark %>">
						        		<textarea name="remark" dataformat="engup3" style="width:100%;height:240;" class="textarea1"></textarea>
						        	 
								</td>
							</tr>
						</table>				
						<!-- Grid_1 (E) -->		
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
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       		<tr>
       			<td class="btn3_bg">
		    		<table border="0" cellpadding="0" cellspacing="0">
		    			<tr>
		    					
							<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr>
										<td class="btn1_left"></td>
										<td class="btn1" name="btn_close">Close</td>
										<td class="btn1_right"></td>	
									</tr>
								</table>
							</td>	
						</tr>
					</table>
				</td>	
			</tr>
		</table>
    	<!--Button (E) -->
	
		<table width="100%"  id="mainTable" style="display:none;"><!-- Dummy Sheet -->	
			<tr>
				<td width="100%">
					<script language="javascript">ComSheetObject('sheet1');</script>
				</td>
			</tr>
		</table>	
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
</body>
</html>