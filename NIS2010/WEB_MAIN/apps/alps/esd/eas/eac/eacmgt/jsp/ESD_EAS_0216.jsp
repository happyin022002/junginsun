<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESD_EAS_0216.jsp
*@FileTitle : EAC Reject
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.03
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2014.12.03 백형인
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
<%@ page import="com.hanjin.apps.alps.esd.eas.eac.eacmgt.event.EsdEas0216Event"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>

<%
	EsdEas0216Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String pageRows  = "100";

	// SignOnUserAccount Info
	String usr_id 					= "";
	String strUsr_nm				= "";
	
	String eac_no				= StringUtil.xssFilter(request.getParameter("EAC_NO"))!=null&&!StringUtil.xssFilter(request.getParameter("EAC_NO")).equals("")?StringUtil.xssFilter(request.getParameter("EAC_NO")):""; 
	String eac_sts_cd			= StringUtil.xssFilter(request.getParameter("EAC_STS_CD"))!=null&&!StringUtil.xssFilter(request.getParameter("EAC_STS_CD")).equals("")?StringUtil.xssFilter(request.getParameter("EAC_STS_CD")):""; 

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_nm 			= account.getUsr_nm();
		usr_id       		= account.getUsr_id();      

		event = (EsdEas0216Event)request.getAttribute("Event");
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
<title>EAC Reject</title>
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
<input type="hidden" name="session_usr_nm" value="<%=strUsr_nm%>">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="code_key">
<input type="hidden" name="ibflag">
<input type="hidden" name="eac_sts_cd" value="<%=eac_sts_cd%>" >
<input type="hidden" name="usr_id" 		value="<%=usr_id%>" >
<!-- 개발자 작업	-->
<table width="100%" class="popup" cellpadding="10">
	<tr><td class="top"></td></tr>
	<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;EAC Reject</td></tr>
		</table>
		<!-- : ( Title ) (E) -->

		
		<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">		
			<!-- biz_1  (S) -->
			<table border="0" width="430">
				<tr class="h23">
					<td width="89">EAC No.</td>
					<td width="105">
						<input type="text" style="width: 100; text-align:center;" class="input2" name="eac_no" value="<%=eac_no%>" readonly="readonly"> 
					</td>
					<td width="235"></td>
                </tr>					
			</table>		
		
			<table border="0" width="430">		
				<tr class="h23">						
					
					<td width="100">Reason of</br>Unapproval</td>
					<td width="300">
						<textarea name="eac_apro_rsn" rows="4" cols="60" ></textarea> 
					</td>
					<td width="29"></td>
				</tr>
			</table>
          </td>
		</tr>
	</table>
	<!-- Grid  (S) -->														
	<table width="100%" id="mainTable"> 
	<tr>
		<td width="100%">
			<script language="javascript">ComSheetObject('sheet1');</script>
		</td>
	</tr>
	</table> 
	<!-- Grid (E) -->
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
		<table class="height_5"><tr><td></td></tr></table>
		
</td></tr>
</table> 
<!-- OUTER - POPUP (E)nd -->

<!-- : ( Button : Sub ) (S) -->
<table width="500" class="sbutton">
<tr><td height="71" class="popup">

	<table class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    	<tr>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
								<td class="btn1" name="btng_reject">Reject</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td class="btn1_line"></td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
								<td class="btn1" name="btng_close">Close</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
				</tr>
				</table>
			
		</td></tr>
	</table>

	</td></tr>
</table>
<!-- : ( Button : Sub ) (E) -->





<!-- 개발자 작업  끝 -->
</form>
</body>
</html>