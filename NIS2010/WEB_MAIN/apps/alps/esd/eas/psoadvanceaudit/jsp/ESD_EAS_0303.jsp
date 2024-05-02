<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec 
*@FileName : ESD_EAS_0303.jsp
*@FileTitle : Pre-Audit Criterion setting
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.24
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2014.12.24 백형인
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
<%@ page import="com.hanjin.apps.alps.esd.eas.psoadvanceaudit.event.EsdEas0303Event"%>

<%
	EsdEas0303Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String pageRows  = "100";

	String usr_id 					= "";
	String strUsr_nm				= "";
	String ofc_cd					= "";
	

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_nm 			= account.getUsr_nm();
		usr_id       		= account.getUsr_id();      
		ofc_cd      		= account.getOfc_cd();      
	


		event = (EsdEas0303Event)request.getAttribute("Event");
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
<title>Personnel Config Inquiry</title>
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
<input type="hidden" name="usr_id" 		value="<%=usr_id%>" >
<input type="hidden" name="ofc_cd" 		value="<%=ofc_cd%>" >
<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr>
	<td valign="top">	
	
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->

			
		<!--Button (S) -->
		
	    <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top: 0; padding-bottom: 2;">
		<tr>
			<td class="btn1_bg">
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
					<div id="btnSaveLayer" style="display:inline">
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_save">Save</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
						</div>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_downexcel">DownExcel</td>
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

		<!--biz page (S)-->
		<table class="search"> 
	       	<tr><td class="bg">
				<!-- biz_1  (S) -->
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="35">RHQ</td>
						<td width="100" style="padding-left:1;">
							<script language="javascript">ComComboObject('s_aud_ofc_cd',1,100,1,0,0);</script>
						</td>					
						<td width="30"></td>
						<td width="85">Charge Type</td>
						<td width="180">
							<script language="javascript">ComComboObject('s_chg_tp_cd',1,180,1,0,0);</script>
						</td>
						<td width="30"></td>
						<td width="80">Auto Audit</td>
						<td width="180">
							<script language="javascript">ComComboObject('s_auto_acd',1,180,1,0,0);</script>
						</td>
						<td width="274"></td>
	                </tr>					
				</table>		
	          </td>
			</tr>
		</table>
        <!--biz page (E)-->		 
        
        <table class="height_5"><tr><td></td></tr></table>
		<!-- Grid BG Box  (S) -->
     	<table class="search" id="mainTable">
      	<tr><td class="bg" valign="top">
			<!-- Grid  (S) -->
			
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table> 
			<!-- Grid (E) -->
			

			</td></tr>
		</table>



<!-- 개발자 작업  끝 -->
		</td>
	</tr>
</table>
</form>
</body>
</html>