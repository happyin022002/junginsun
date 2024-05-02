<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_vsk_0241.jsp
*@FileTitle : P/F SKD Type Help (Pop-Up) 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.30
*@LastModifier : 서창열
*@LastVersion : 1.0
* 2009.04.30 서창열
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.event.VopVsk0241Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopVsk0241Event  	event 			= null;		//PDTO(Data Transfer Object including Parameters)
	Exception 			serverException = null;		//서버에서 발생한 에러
	String 				strErrMsg 		= "";		//에러메세지
	int 				rowCount	 	= 0;		//DB ResultSet 리스트의 건수
	
	String 				successFlag 	= "";
	String 				codeList  		= "";
	String 				pageRows  		= "100";

	String 				strUsr_id		= "";
	String 				strUsr_nm		= "";
	String 				vsl_slan_cd 	= "";
	String 				pf_skd_tp_cd	= "";
	String 				read_only 		= "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.SchedulePlanningOperation.ProformaScheduleMgt");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id 		=	account.getUsr_id();
		strUsr_nm 		= account.getUsr_nm();	   
	   
		event 			= (VopVsk0241Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		vsl_slan_cd 	= JSPUtil.replaceForHTML(request.getParameter("vsl_slan_cd"));		
		vsl_slan_cd 	= vsl_slan_cd==null?"":vsl_slan_cd;
		
		pf_skd_tp_cd 	= JSPUtil.replaceForHTML(request.getParameter("pf_skd_tp_cd"));		
		pf_skd_tp_cd 	= pf_skd_tp_cd==null?"":pf_skd_tp_cd;		
		
		read_only 		= JSPUtil.replaceForHTML(request.getParameter("read_only"));		
		read_only 		= read_only==null?"":read_only;		

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
<title>P/F SKD Type Help (Pop-Up) </title>
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
<input type="hidden" name="pf_svc_tp_cd" 	value="<%=pf_skd_tp_cd%>">
<input type="hidden" name="read_only" 		value="<%=read_only%>">

<!-- 개발자 작업	-->
<table width="100%" class="popup" cellpadding="10" border="0"> 
	<tr>
		<td class="top"></td>
	</tr>
	<tr>
		<td valign="top">
			<!-- : ( Title ) (S) -->
			<table width="100%" border="0">
				<tr>
					<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;P/F SKD Type Inquiry </td>
				</tr>
			</table>
			<!-- : ( Title ) (E) -->
			<!-- : ( Search Options ) (S) -->
			<table class="search"> 
       			<tr>
       				<td class="bg">
						<!--  biz_1  (S) -->
						<table class="search" border="0" style="width:384;"> 
							<tr class="h23">
								<td width="65">Lane Code</td>   
								<td><input type="text" style="width:40;text-align:center;ime-mode:disabled;" class="input1" name="vsl_slan_cd" maxlength="3" dataformat="uppernum" value="<%=vsl_slan_cd%>" onKeyPress="if(event.keyCode==13) Search();">&nbsp;<img src="img/btns_search.gif" name="btn_search" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
							</tr>
						</table>
						<!--  biz_1   (E) -->
						<!-- : ( Grid ) (S) -->
						<table width="100%"  id="mainTable"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
						</table>
						<!-- : ( Grid ) (E) -->	
					</td>
				</tr>
			</table>

		<table class="height_5"><tr><td></td></tr></table>
		</td>
	</tr>
</table> 
	
<table width="100%" class="sbutton">
	<tr>
		<td height="71" class="popup">
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       			<tr>
       				<td class="btn3_bg">
		    			<table border="0" cellpadding="0" cellspacing="0">
		    				<tr>
		    					<td>
		    						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_retrieve">Retrieve</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_new">New</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Select">Select</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
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
    					<!--Button (E) -->
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>			
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
<%@include file="/bizcommon/include/common_alps.jsp"%>