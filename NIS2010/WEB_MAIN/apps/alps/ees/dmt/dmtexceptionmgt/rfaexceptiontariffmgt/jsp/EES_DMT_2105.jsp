<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_2105.jsp
*@FileTitle : DAR History
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.24
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.09.24 이성훈
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
<%@ page import="com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.event.EesDmt2105Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt2105Event  event 		= null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg 			= "";						//에러메세지
	int rowCount	 			= 0;						//DB ResultSet 리스트의 건수
	
	String successFlag 			= "";
	String codeList  			= "";
	String pageRows  			= "100";

	String strUsr_id			= "";
	String strUsr_nm			= "";
	String strUsr_ofc			= "";
	Logger log 					= Logger.getLogger("com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt");
	
	String rFANo 				= request.getParameter("rfa_no") 	!= null ? request.getParameter("rfa_no") 	: "" ;
	String propNo 				= request.getParameter("prop_no") 	!= null ? request.getParameter("prop_no") 	: "" ;
	String darNo 				= request.getParameter("dar_no") 	!= null ? request.getParameter("dar_no") 	: "" ;
	String verSeq 				= request.getParameter("ver_seq") 	!= null ? request.getParameter("ver_seq") 	: "" ;
	String custCd 				= request.getParameter("cust_cd") 	!= null ? request.getParameter("cust_cd") 	: "" ;
	String custNm 				= request.getParameter("cust_nm") 	!= null ? request.getParameter("cust_nm") 	: "" ;
	String status 				= request.getParameter("status") 	!= null ? request.getParameter("status") 	: "" ;
	String rowcount 			= request.getParameter("rowcount") 	!= null ? request.getParameter("rowcount") 	: "" ;
	String isCopy				= request.getParameter("is_copy") 	!= null ? request.getParameter("is_copy") 	: "" ;
	
	try {
	   	SignOnUserAccount account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id 				= account.getUsr_id();
		strUsr_nm 				= account.getUsr_nm();
		strUsr_ofc 				= account.getOfc_cd();
		
		event 					= (EesDmt2105Event)request.getAttribute("Event");
		serverException 		= (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

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
<title>DAR History</title>
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
<input type="hidden" name="cust_cd">
<input type="hidden" name="rfa_no">
<input type="hidden" name="prop_no" 	value="<%= propNo %>">
<input type="hidden" name="dar_no" 		value="<%= darNo %>">
<input type="hidden" name="ver_seq" 	value="<%= verSeq %>">
<input type="hidden" name="status" 		value="<%= status %>">
<input type="hidden" name="rowcount" 	value="<%= rowcount %>">
<input type="hidden" name="is_copy" 	value="<%= isCopy %>">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;DAR History</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
			<table class="search"> 
       		<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:880;"> 
					<tr class="h23">
						<td width="300">
							<table class="search_sm" border="0" style="width:250;">
								<tr class="h23">
									<td width="80">DAR History</td>
									<td class="stm"><input type="radio" name="searchType" class="trans" checked onClick="doActionRetrieve()">RFA&nbsp;&nbsp;&nbsp;<input type="radio" name="searchType" class="trans" onClick="doActionRetrieve()">Customer</td>
								</tr>
							</table>
						</td>
						<td width="50">RFA No.</td>
						<td width="110"><input type="text" name="rFANo" style="width:85;" class="input2" value="<%= rFANo %>"></td>
						<td width="50">Customer</td>
						<td width=""><input type="text" name="custCd" style="width:70;" class="input2" value="<%= custCd %>">&nbsp;<input type="text" name="custNm" style="width:290;" class="input2" value="<%= custNm %>"></td>
					</tr>
				</table> 
					
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
	
				<!-- Grid  (S) -->
					<table width="100%"  id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table>
				<!-- Grid  (E) -->	
				
			</td></tr>
		</table>
		<table class="height_5"><tr><td></td></tr></table>
<!-- : ( Search Options ) (E) -->
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
							<td class="btn1" name="btn_Copy">Copy</td>
							<td class="btn1_right">
						</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_Close">Close</td>
							<td class="btn1_right">
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
	</td>
</tr>
</table>
</form>
</body>
</html>
