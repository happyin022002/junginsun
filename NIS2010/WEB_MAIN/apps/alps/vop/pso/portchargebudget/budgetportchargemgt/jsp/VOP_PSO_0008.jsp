<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_pso_0008.jsp
*@FileTitle : Budget Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.20
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2009.06.29 김진일
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
<%@ page import="com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.event.VopPso0008Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopPso0008Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String scn_dt = DateTime.getDateString().substring(0,4);
	Logger log = Logger.getLogger("com.hanjin.apps.PortChargeBudget.BudgetPortChargeMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopPso0008Event)request.getAttribute("Event");
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
<title>Budget Creation</title>
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
<input type="hidden" name="year" />
<!-- 개발자 작업	-->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->
		
		<table class="search" id="mainTable"> 
       		<tr>
       			<td class="bg">
					<table class="search" border="0" style="width:979;"> 
						<tr class="h23">
							<td width="75">Scenario CD</td>
							<td width="150">
								<input type="text" name="scn_dt" style="width:40;text-align:center;" class="input1" caption="Period FM" dataformat="y" size="4" maxlength="4" fulfill required value="<%=scn_dt %>">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendarsn"  id="btns_calendarsn">&nbsp;
								<script language="javascript">ComComboObject('scn_cd',1,50,0,1);</script>
							</td>
							
							<td width="90">Budget Period</td>
							<td width="210">
								<input type="text" name="txtsDate" dataformat="ym" caption="시작년월" maxlength="6" size="10" cofield="txteDate" style="width:60;" class="input1" value="">&nbsp;<img name="btns_calendar_s" src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
								&nbsp;~&nbsp;
								<input type="text" name="txteDate" dataformat="ym" caption="종료년월" maxlength="6" size="10" cofield="txtsDate" style="width:60;" class="input1" value="">&nbsp;<img name="btns_calendar_e" src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
							</td>
							<td width="47">Status</td>
							<td width="200"><input type="text" name="status" class="input2" readonly/></td>
						</tr>
						

					</table>
									
					<table class="line_bluedot"><tr><td></td></tr></table>
					
					<table width="100%"  id="mainTable"> 
						<tr>
							<td width="68%" valign="top"><script language="javascript">ComSheetObject('sheet1');</script></td>
							<td width="2%"></td>
							<td width="30%" valign="top"><script language="javascript">ComSheetObject('sheet2');</script></td>
						</tr>
					</table> 	
					
									<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
					<tr>
						<td class="btn1_bg">
							<table border="0" cellpadding="0" cellspacing="0">
		    					<tr>
		    						<td>
										<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td>
											<td class="btn2" name="btn_down_excel">Down Excel</td>
											<td class="btn2_right"></td>
											</tr>
										</table>
									</td>
								</tr>
							</table>			
						</td>
					</tr>
				</table> 
				
				</td>
			</tr>
		</table>
		
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       		<tr><td class="btn1_bg">
		
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
				<!--  
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				-->
				
				<td class="btn1_line"></td>

				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_creation">Creation</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				</tr>
			</table>
		</td></tr>
	</table>
		
	</td></tr>
</table>
	

		<table style="height:500"><tr><td></td></tr></table>

<!-- : ( Button : pop ) (E) -->
<!-- 서버처리를 위한 Hidden Sheet -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>