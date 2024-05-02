<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_pso_0203.jsp
*@FileTitle : Bank Information 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.30
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.04.30 김진일
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.portsomasterdatamgt.event.VopPso0203Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopPso0203Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strBankInfo 		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.PortSOMasterDataMgt.PortSOMasterDataMgt");
	
	//String strVndrSeq = request.getParameter("vndrSeq"); //Vendor의 Sequence Number를 받아 온다.
	//if(strVndrSeq == null ) strVndrSeq = "181162"; //TEST CODE BY KJI 
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (VopPso0203Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
	strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		strBankInfo = (String)eventResponse.getCustomData("BANKINFO");
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Bank Information </title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		tblData = "<%=strBankInfo%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- OUTER - POPUP (S)tart -->
<table width="600" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Bank Information </td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			
				<!--  biz_2  (S) -->
					<table class="grid2" border="0" style="width:580;">
						<tr class="tr2_head">
							<td colspan="2" align="left">AGENT BANK ACCOUNT DETAILS AS UNDER</td>
						</tr>
						<tr>
							<td  class="tr2_head2" width="30%">To</td>
							<td  class="" width=""><div id="dbData1"><!-- Commercial International Bank - Port Said Branch  --></div> </td>
						</tr>
						<tr>
							<td  class="tr2_head2" width="30%"> Favour</td>
							<td  class="" width=""><div id="dbData2"><!-- Dominion Shipping Agencies [Egypt] - Port Said  --></div></td>
						</tr>
						<tr>
							<td  class="tr2_head2" width="30%">  Account Number</td>
							<td  class="" width=""><div id="dbData3"><!--  0250308483   --></div></td>
						</tr>
						<tr>
							<td  class="tr2_head2" width="30%">   Through 	</td>
							<td  class="" width=""><div id="dbData4"><!-- Bank of New York - New York  --></div></td>
						</tr>
						<tr>
							<td  class="tr2_head2" width="30%">    Account Number 	</td>
							<td  class="" width=""><div id="dbData5"><!-- 8900045051   --></div></td>
						</tr>
						<tr>
							<td  class="tr2_head2" width="30%"> Swift Code</td>
							<td  class="" width=""><div id="dbData6"><!--  CIBEEGCX002    --></div></td>
						</tr>
					</table>
			
		</td></tr>
		</table>
		<!--biz page (E)--> 

</td></tr></table>

<table class="height_5"><tr><td></td></tr></table>
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

    	<!--Button (S) -->	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr>
			<td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Close">Close</td>
					<td class="btn1_right">
				</tr></table></td>	
			</tr>
		</table>
    	<!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
<!-- 개발자 작업	-->
<!-- Script Error 때문에 가짜로 넣어준 sheet 절대 지우지 말아라 지우면 에러남-->
<div style="height:1px">
<script language="javascript">ComSheetObject('sheet1');</script>
</div>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
<%@include file="/bizcommon/include/common_nis2010.jsp"%>