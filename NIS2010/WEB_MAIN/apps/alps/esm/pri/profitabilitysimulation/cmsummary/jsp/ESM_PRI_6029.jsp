<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_6029.jsp
*@FileTitle : SM,OP Summary-Multi Customer
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.08
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.09.08 송민석
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
<%@ page import="com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.event.EsmPri6029Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri6029Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	
	
	String cust_list = null;


	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.ProfitabilitySimulation.CMSummary");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		
		cust_list		= JSPUtil.getParameter(request,"cust_list");

 		event = (EsmPri6029Event)request.getAttribute("Event");
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
<title>SM,OP Summary-Multi Customer</title>
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
<input type="hidden" name="cust_list" value="<%=cust_list %>">
<!-- 개발자 작업	-->

<!-- OUTER - POPUP (S)tart -->
<table width="900" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp CM/OP Summary & Simulation- Multi Customer</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->

			<table class="search"> 
       		<tr><td class="bg">
			
			<table class="search"> 
       		<tr><td width="420" valign="top">
				
				<table class="search_sm2" border="0" style="width:100%;"> 
					<tr class="h23">
						<td width="100">Customer Code</td>
						<td><input type="text" style="width:30;" value="" class="input" name="cust_cnt_cd" dataformat="engup">&nbsp;<input type="text" style="width:60;" value="" class="input" name="cust_seq" dataformat="int"></td>
					</tr>
					<tr class="h23">
						<td>Customer Name</td>
						<td><input type="text" style="width:100%;" value="" class="input" name="cust_lgl_eng_nm" ></td>
					</tr>
				</table>
				<!-- : ( Grid ) (S) -->
						<table width="100%"  id="mainTable"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
						</table>
				<!-- : ( Grid ) (E) -->	
						<table class="search" border="0" style="width:100%;"> 
						<tr class="h23">
							<td width="80" valign="TOP">Remark(s)</td>
							<td class="SM">&raquo; Please send selected customer code to "Multi-customer" grid <BR>
							&nbsp;&nbsp; before clicking 'OK' button.</td>
						</tr>	
						</table>				
				<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
						
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn2_Retrieve" id="btn_Retrieve">Retrieve</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
				
				
			</td>
			<td width="50" align="center"><img class="cursor" src="img/btns_add.gif" width="26" height="26" border="0" align="absmiddle" name="btn_MoveRight"><br><br><img class="cursor" src="img/btns_del.gif" width="26" height="26" border="0" align="absmiddle" name="btn_MoveLeft"></td>
			<td width="400">	
				<table class="search" border="0">
					<tr><td class="title_h"></td>
					<td class="title_s">Multi-Customer</td></tr>
				</table>
				<!-- : ( Grid ) (S) -->
						<table width="100%"  id="mainTable"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet2');</script>
								</td>
							</tr>
						</table>
				<!-- : ( Grid ) (E) -->	
			</td></tr>
			</table> 
			
			</td></tr>
		</table>
		
<!-- : ( Search Options ) (E) -->
</td></tr>
</table> 

<table class="height_5"><tr><td></td></tr></table>
	
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_OK">OK</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			<td class="btn1_line"></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_Close">Close</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
		</td></tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>