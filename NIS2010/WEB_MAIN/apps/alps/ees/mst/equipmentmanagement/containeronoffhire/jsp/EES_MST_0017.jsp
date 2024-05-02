<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_mst_0017.jsp
*@FileTitle : ERP Interface - OW Master / Term Change
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.12
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2009.08.12 이호선
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.event.EesMst0017Event"%>
<%@ page import="org.apache.log4j.Logger" %>


<%
	EesMst0017Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.EquipmentManagement.ContainerOnOffHire");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesMst0017Event)request.getAttribute("Event");
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
<title>::</title>
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
<input type="hidden" name="hid_type">
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
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="95">Delivery Month</td>
					<td width="130"><input type="text" style="width:70" dataformat="ym" maxlength="7" class="input1" value="" name="de_yrmon">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" onClick="popCalendar('calendarPopup2')"></td>
					<td>
						<table class="search_sm2" width="450">
							<tr class="h23">
								<td width="40">&nbsp;Type</td>
								<td width="200" class="stm"><input type="radio" class="trans" checked name="type">Ow&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" class="trans" name="type">Term Change</td>
								<td width="50">Option</td>
								<td width="">
								<select style="width:120;" class="input" name="if_cd">
								<option value="0" selected>All</option>
								<option value="1">Not Interface</option>
								<option value="2">Interface</option>
								</select>
								</td>								
							</tr>
						</table>
					</td>
				</tr> 
				</table>
				
			<!-- : ( Search Options ) (E) -->

			</td></tr>
		</table>
		<!--biz page (E)-->
	<table class="height_8"><tr><td></td></tr></table>
	
			<!-- Tab ) (S) -->
     		<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%> 
       		<tr><td width="100%">
						<script language="javascript">ComTabObject('tab1')</script>
						<!-- img src="/img/sub_tab.gif" alt="" width="998" height="23" border="0" -->
					</td></tr>
				</table>
		<!-- Tab ) (E) -->

<!--TAB OW Master (S) -->
<div id="tabLayer" style="display:inline">
	<table class="search"> 
       		<tr><td class="bg" style="height:420;" valign="top">

    			<!-- Grid  (S) -->
    			<table width="100%"  id="mainTable"> 
    				<tr>
    					<td width="100%">
    						<script language="javascript">ComSheetObject('t1sheet1');</script>
    					</td>
    				</tr>
    			</table>
    			<!-- Grid (E) -->	
    			
					<!--  Button_Sub (S) -->
					<table width="100%" class="button"> 
			       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn_t1downexcel">Down Excel</td>
								<td class="btn2_right"></td>
								</tr>
								</table></td>
								
						</table>
					</td></tr>
					</table>
			    <!-- Button_Sub (E) -->
			</td></tr>
		</table>
	<!--biz page (E)-->
</div>
<!--TAB OW Master (E) --> 		

<!--TAB Term Change Master (S) -->
<div id="tabLayer" style="display:none">
	<table class="search"> 
       		<tr><td class="bg" style="height:420;" valign="top">
					<!-- Grid  (S) -->
    			<table width="100%"  id="mainTable"> 
    				<tr>
    					<td width="100%">
    						<script language="javascript">ComSheetObject('t2sheet1');</script>
						    <div style="display: none;"><script language="javascript">ComSheetObject('t1sheet2');</script></div>					
							<div style="display: none;"><script language="javascript">ComSheetObject('t2sheet2');</script></div>						    
    					</td>
    				</tr>
    			</table>					
					<!-- Grid (E) -->

					<!--  Button_Sub (S) -->
					<table width="100%" class="button"> 
			       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
									<td class="btn2" name="btn_t2downexcel">Down Excel</td>
									<td class="btn2_right"></td>
								</tr>
								</table>
							</td>
						</tr>	
						</table>
					</td></tr>
					</table>
			    	<!-- Button_Sub (E) -->
			</td></tr>
		</table>
	<!--biz page (E)-->
</div>
<!--TAB Term Change Master (E) -->		
		
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table>
				</td>
		</td></tr>
		</table>
    <!--Button (E) -->
	</td></tr>
</table>
	</td></tr>
</table>
</form>
</body>
</html>
