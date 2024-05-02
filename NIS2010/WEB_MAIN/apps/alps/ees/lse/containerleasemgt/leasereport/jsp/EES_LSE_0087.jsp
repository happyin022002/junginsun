<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_LSE_0087.jsp
*@FileTitle : On-Hire Report Summary by RCC
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.03
*@LastModifier : 진준성
*@LastVersion : 1.0
* 2009.09.03 진준성
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
<%@ page import="com.hanjin.apps.alps.ees.lse.containerleasemgt.leasereport.event.EesLse0087Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesLse0087Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.ContainerLeaseMgt.LeaseReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesLse0087Event)request.getAttribute("Event");
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
<title>On-Hire Report Summary by RCC</title>
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
<input type="hidden" name="tysz">
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:;,padding-bottom:2;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
		</td></tr>
		</table>
    <!--Button (E) -->
	</td></tr>
		</table>
	<!-- : ( Search Options ) (S) -->
 <table class="search"> 
       		<tr><td class="bg">
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="50">Period</td>
					<td width="270">
					   <input type="text" name="period_stdt" style="width:80;ime-mode:disabled" value="" class="input1"  maxlength="8" dataformat="ymd" >
					   &nbsp;~&nbsp;
					   <input type="text" name="period_eddt" style="width:80;ime-mode:disabled" value="" class="input1" maxlength="8" dataformat="ymd" >
					   <img class="cursor" src="img/btns_calendar.gif" name="btns_calendar2" width="19" height="20" border="0" align="absmiddle">
					</td>
					<td width="80">Lease Term</td>
					<td width="250" style="padding-left:2">
					    <script language="javascript" >ComComboObject('combo1', 1, 190, 1 );</script>&nbsp
					    <input type="hidden" name="lstm_cd" value="" >
				    </td>
					<td width="">
						<table  border="0" style="width:270;"> 
							<tr class="h23">
								<td width="65">&nbsp;Location</td>
								<td width="" class="stm">
								<select name="loc_tp" dataformat="engup">	
									<option value="" selected>ALL</option>				        
						            <option value="R">RCC</option>						        			
						            <option value="L">LCC</option>		
						            <option value="S">SCC</option>
					            </select>
						        <input type="text" style="width:59" name="loc_cd"  value="" class="input"  dataformat="engup" maxlength="5" fullfill>
					            <img class="cursor" name="btns_search1" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">	
								</td>
							</tr>
						</table>
					</td>
				</tr>				
				<tr class="h23">
					<td width="">Term Change</td>
					<td width="270">
					   <select name="term_change" style="width:82">
						    <option value="">Including</option>
						    <option value="N" selected >Excluding</option>
						    <option value="Y">Only</option>
					   </select>
					</td>
					<td width="80">DII</td>
					<td width="250">
					    <select name="dii">
						    <option value="" selected>Including</option>
						    <option value="N">Excluding</option>
						    <option value="Y">Only</option>
					    </select>
				    </td>
					<td width=""></td>
				</tr>
				
			</table>
			
			<table class="line_bluedot"><tr><td></td></tr></table>
				<!-- : ( Grid ) (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table> 			
				<!-- : ( Grid ) (E) -->	
				
				<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_DownExcel">Down Excel</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
			
			<!-- : ( Search Options ) (E) -->
 
				</td></tr>
		</table>
	<!-- Tab BG Box  (S) -->
	
		</td></tr>
</table>
	<!--biz page (E)-->
	
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>