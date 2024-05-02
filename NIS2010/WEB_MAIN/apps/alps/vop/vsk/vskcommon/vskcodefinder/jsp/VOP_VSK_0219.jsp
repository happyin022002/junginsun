<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_vsk_0219.jsp
*@FileTitle : VSL Code Help
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.11
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.04.27 서창열
* 1.0 Creation
*
* History
* 2011.04.11 진마리아 CHM-201109577-01 Delete Vessel Code에 대한 조회 로직 보완
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.event.VskGloEvent"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List" %>

<%
	VskGloEvent  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.vskcommon.vskcodefinder");
	
	String vslCd = null;
	String incDelVslPop = null;
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (VskGloEvent)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		vslCd = JSPUtil.replaceForHTML(request.getParameter("vsl_cd"));
		vslCd = vslCd==null?"":vslCd;
		incDelVslPop = JSPUtil.replaceForHTML(request.getParameter("inc_del_vsl_pop"));
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>VSL Code Help</title>
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
<input type="hidden" name="inc_del_vsl" value="<%=incDelVslPop%>">

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
					<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Vessel Code Inquiry</td>
				</tr>
			</table>
			<!-- : ( Title ) (E) -->
			<!-- : ( Search Options ) (S) -->
			<table class="search"> 
       			<tr>
       				<td class="bg">
						<!--  biz_1  (S) -->
						<table class="search" border="0" style="width:420;">
							<tr class="h23">
								<td width="80">Vessel Code</td>   
								<td width=""><input type="text" style="width:40;text-align:center;ime-mode:disabled;" class="input" maxlength=4 name="vsl_cd" value="<%=vslCd %>" tabindex="1"></td>
							</tr>
							<tr class="h23">
								<td>Vessel Name</td>   
								<td><input type="text" style="width:320;ime-mode:disabled;" class="input" value="" maxlength=50 name="vsl_eng_nm" tabindex="2"></td>
							</tr>
							<tr class="h23">
								<td>Carrier Code</td>   
								<td><input type="text" style="width:40;text-align:center;ime-mode:disabled;" class="input" value="" maxlength=4 name="crr_cd" tabindex="3"></td>
							</tr>
						</table>
						<!--  biz_1   (E) -->
					</td>
				</tr>
			</table>
			<!-- : ( Search Options ) (E) -->
			<table class="height_8"><tr><td></td></tr></table>
			
			<!-- : ( Data ) (S) -->
			<table class="search"> 
       			<tr><td class="bg">
						
					<!-- : ( Grid ) (S) -->
					<table width="100%"  id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table>
					<!-- : ( Grid ) (E) -->	
					
				    <!-- : ( Button : Grid ) (S) -->
				    <!-- : ( Button : Grid ) (E) -->
					    
				</td></tr>
			</table>
			<!-- : ( Data ) (E) -->

			<table class="height_5"><tr><td></td></tr></table>

</td></tr>
</table> 
	
	
<!-- : ( Button : pop ) (S) -->
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
											<td class="btn1" name="btn_Retrieve" id="btn_Retrieve" tabindex="4">Retrieve</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_ok">OK</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td class="btn1_line"></td>
								<td>
									<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_close">Close</td>
											<td class="btn1_right">
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
    <!--Button (E) -->
		</td>
	</tr>
</table>
<!-- : ( Button : pop ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
<%@include file="/bizcommon/include/common_alps.jsp"%>