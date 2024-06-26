<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BIS_0001.jsp
*@FileTitle : BIS-B/L Information
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.22
*@LastModifier : 김태경
*@LastVersion : 1.0
*2010.01.22 김태경
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
<%@ page import="com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.event.EsmBis0001Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBis0001Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	String bkgRptKndCd 		= "C";
	
	Logger log = Logger.getLogger("com.hanjin.apps.BookingReport.PerformanceReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBis0001Event)request.getAttribute("Event");
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
<title>BIS Error Monitor</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<script language="javascript">

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		}
		loadPage();
	}
</script>

<body  onLoad="setupPage();"> 

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--top menu (S)-->
			<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->
	
	</td></tr>
	<tr><td valign="top">
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				
				<tr class="h23">
					<td width="44">YYYYMMDD</td>
					<td width=""><input type="text" style="width:75" value="" class="input1" name ="from_dt" id="from_dt" dataformat ="ymd" caption="BKG From Date" maxlength='10' cofield="from_dt" onblur="changedate(this)">
						<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"  onClick="callDatePop('BKG_DATE')">&nbsp;~
							<input type="text" style="width:75" value="" class="input1" name="to_dt" id ="to_dt" dataformat ="ymd" caption="BKG To Date" maxlength='10' cofield="to_dt" onblur="changedate(this)">
							<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" style="cursor:hand" style="cursor:hand" onClick="callDatePop('BKG_DATE')"></td>
					</tr> 
				</table>				
				<!--  biz_1   (E) -->
			
		</td></tr></table>
		
		<table class="height_8"><tr><td></td></tr></table>	
		
		<table class="search" id="mainTable"> 
       	<tr><td class="bg">	
			
				
			<!-- Grid  (S) -->
					<table width="100%"  id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table>
			<!-- Grid (E) -->			
			
			<!--  Button_Sub (S) -->
			
	    	<!-- Button_Sub (E) -->
			
			
			</td></tr>
		</table>
		<!--biz page (E)-->

	
	
	</td></tr>
		</table>
	

	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Print">print</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    	<!--Button (E) -->


<!-- Copyright(E)-->

</form>
</body>
</html>


