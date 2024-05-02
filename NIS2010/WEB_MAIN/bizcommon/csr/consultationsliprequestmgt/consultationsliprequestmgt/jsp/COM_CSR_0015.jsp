<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : COM_CSR_0015.jsp
*@FileTitle : CSR ERP Transfer
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.17
*@LastModifier : kim young shin
*@LastVersion : 1.0
* 2014.12.17 김영신
* 1.0 Creation
*----------------------------------------------------------
* History
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.event.ComCsr0015Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	ComCsr0015Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String ofc_cd  			= ""; 
	String cnt_cd 	 		= "";
	String csr_no   		= "";
	String usr_eml 			= "";
		
	csr_no = JSPUtil.getParameter(request, "csr_no".trim(), "");
	
	Logger log = Logger.getLogger("com.hanjin.apps.ConsultationSlipRequestMgt.ConsultationSlipRequestMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	    ofc_cd	  = account.getOfc_cd();
	    cnt_cd 	  = account.getCnt_cd();
	    usr_eml	  = account.getUsr_eml();
	    
		event = (ComCsr0015Event)request.getAttribute("Event");
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
<title>CSR Interface Status</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" type="text/javascript" src="bizcommon/csr/CoCsr.js"></script>

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
<!-- 개발자 작업	-->
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="csr_no">
<input type="hidden" name="csr_apro_tp_cd">


<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
	    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">   
	        <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
	        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>   
	    </table>   
	<!--Page Title, Historical (E)-->

	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:290;">
						<tr class="h23">													
							<td width="83">CSR NO</td>
						    <td width="200"><input name="search_csr_no" type="text" maxlength=20 style="width:100%" value="<%=csr_no%>" onKeyPress='csr_enterCheck("retrieve");' onBlur='this.value=this.value.trim();'></td>
							<!--  biz_1   (E) -->
						</tr>
				</table> 
		</td></tr>
		</table>
		
		<table class="height_10"><tr><td colspan="8"></td></tr></table>
		<table class="search"> 
       	<tr><td class="bg">
			
			<!-- Grid  (S) -->
			<table width="100%" class="search"  id="mainTable"> 
				<tr>
					<td width="100%">
					<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
			</table> 			
			<!-- Grid (E) -->
			
			</td></tr>
		</table>
		
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       		<tr><td class="btn1_bg">
				<div id='btng_csrcancel_yn' style="display:inline">
				<table border="0" cellpadding="0" cellspacing="0">		
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btng_retrieve">Retrieve</td>
							<td class="btn1_right"></td>
							</tr>
						</table></td>		
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btng_interface">ERP&nbsp;Interface</td>
							<td class="btn1_right"></td>
							</tr>
						</table></td>
						
					</tr>
				</table>
				</div>
       		</td></tr>
		</table>
		<!--Button (E) -->
		
		</td>
	</tr>
</table>	  
</form>
</body>
</html>
