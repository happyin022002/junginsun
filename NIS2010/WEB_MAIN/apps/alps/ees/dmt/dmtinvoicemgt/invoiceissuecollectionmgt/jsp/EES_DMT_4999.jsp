<%
/*=========================================================
*Copyright(c) 2018 SM Lines
*@FileName : EES_DMT_4999.jsp
*@FileTitle : Send Invoice To To A/R & ERP By Manual
*Open Issues :
*Change history :
*@LastModifyDate : 2018.03.27
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2018.03.27 이성훈
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
<%@ page import="com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt4999Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt4999Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc		= "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();


		event = (EesDmt4999Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} 
	catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Send Invoice To To A/R & ERP By Manual</title>
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
<input type="hidden" name="pagerows">

<!-- 개발자 작업	-->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
	</table>
	<!--Page Title, Historical (E)-->
	
	<table class="search"> 
       		<tr><td class="bg">
				
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="40">Office</td>
						<td width="110"></td>
					</tr>
				</table>
				<!--  biz_1  (E) -->
		
			</td></tr>
		</table>	
		<table class="height_8"><tr><td colspan="6"></td></tr></table>
		<table class="search"> 
       		<tr><td class="bg">
       		
				<!-- Grid  (S) -->
				<!-- AR Invoice Main [S] -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<table width="100%" class="button"> 
       			<tr><td class="btn1_bg">
					<table border="0" cellpadding="0" cellspacing="0">
					<tr><td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_loadexcel1">Load Excel (A/R Main)</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
					</td></tr>
					</table>
				</td></tr>
				</table>		
				<!-- AR Invoice Main [E] -->
				
				<table class="height_8"><tr><td colspan="6"></td></tr></table>
				
				<!-- AR Invoice Charge [S] -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>
				<table width="100%" class="button"> 
       			<tr><td class="btn1_bg">
					<table border="0" cellpadding="0" cellspacing="0">
					<tr><td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_loadexcel2">Load Excel (A/R Charge)</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
					</td></tr>
					</table>
				</td></tr>
				</table>
				<!-- AR Invoice Charge [E] -->
				
				<table class="height_8"><tr><td colspan="6"></td></tr></table>
				
				<!-- AR Invoice Container [S] -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet3');</script>
						</td>
					</tr>
				</table>				
				<table width="100%" class="button"> 
       			<tr><td class="btn1_bg">
					<table border="0" cellpadding="0" cellspacing="0">
					<tr><td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_loadexcel3">Load Excel (A/R Container)</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
					</td></tr>
					</table>
				</td></tr>
				</table>
				<!-- AR Invoice Container [E] -->
								
			</td></tr>
		</table>
		
<!-- : ( Search Options ) (E) -->
			
		</td></tr>
	</table>
	<!-- Tab BG Box  (S) -->
	<!--biz page (E)-->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_send">Send Invoice to A/R & ERP</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</td></tr>
			</table>
	    <!--Button (E) -->
		</td></tr>
	</table>

<!-- Copyright (S) -->

<!-- Copyright(E)-->
<div id="topdeck" style="position:absolute;visibility:hidden;z-index:200;"></div>
<!-- 개발자 작업  끝 -->
</form>

</body>
</html>