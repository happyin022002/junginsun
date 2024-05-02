<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_LEA_0008.jsp
*@FileTitle : Accrual Batch History
*Open Issues :
*Change history : 
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.event.EsdLea0008Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdLea0008Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//The count of DB ResultSet list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id	= "";
	String strUsr_nm	= "";
	Logger log = Logger.getLogger("com.clt.apps.LogisticsExpenseAccrual.AccrualBatchExecuteResult");
	
	String nowExeYYMM 	= "";
	String fmExeYYMM 	= "";
	
	nowExeYYMM = DateTime.addMonths(JSPUtil.getKST("yyyy-MM"),-1,"yyyy-MM");
	fmExeYYMM = nowExeYYMM.substring(0,4) + "-01";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsdLea0008Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Accrual Batch History</title>
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

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>

	<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
	<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
	<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
	</table>
	<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->

	<!--Button_L (S) -->
	<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
       	<tr><td class="btn1_bg">

			<table border="0" cellpadding="0" cellspacing="0">
			<tr>
				<!-- Repeat Pattern -->
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" id="btn_retrieve" name="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>

				<!--  <td class="btn1_line"></td> -->

				<!-- <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">-->
					<!--<tr><td class="btn1_left"></td><td class="btn1" id="btn_reset" name="btn_reset">Reset</td><td class="btn1_right"></td></tr></table></td>-->
					 
				<!-- Repeat Pattern -->

			</tr></table>

		</td></tr>
	</table>
	<!--Button_L (E) -->

	<!-- TABLE '#D' : ( Search Options ) (S) -->
    	<table class="search">
      	<tr><td class="bg">

			<!-- : ( Year ) (S) -->
			<table class="search_in" border="0">
			<tr class="h23">
				<td width="110">Exe. Year-Month</td>
				<td class="stm">
					<input type="text" class="input1" style="width:60;" maxlength="7" name="exe_yrmon_from"  valid="1" value="<%=fmExeYYMM %>" desc= "From Exe. Month"  onKeyUp="lea_comm_isNumberMessage(this,6);" onBlur="lea_com_convertYymm(this);" onKeyDown="lea_com_enterKeyEvent('lea_enterRetrieve')"> ~
					<input type="text" class="input1" style="width:60;" maxlength="7" name="exe_yrmon_to"  valid="1" value="<%=nowExeYYMM %>" desc= "To Exe. Month"  onKeyUp="lea_comm_isNumberMessage(this,6);" onBlur="lea_com_convertYymm(this);"  onKeyDown="lea_com_enterKeyEvent('lea_enterRetrieve')"></td></tr>
			</table>
			<!-- : ( Year ) (E) -->

		</td></tr>
	</table>
	<!-- TABLE '#D' : ( Search Options ) (E) -->

	<table class="height_10"><tr><td></td></tr></table>

	<!-- TABLE '#D' : ( Search Options ) (S) -->
    	<table class="search">
	      	<tr><td class="bg">
	
				<!-- : ( Seq. ) (S) -->
				<table width="100%" id="mainTable">
				       <tr><td>
				           <script language="javascript">ComSheetObject('sheet1');</script>
				       </td></tr>
				</table>
				<!-- : ( Seq. ) (E) -->
		
				<!--  Button_Sub (S) -->
				<table width="100%" class="button">
			       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
			
						<!-- Repeat Pattern -->
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td><td class="btn2" id="btn_downexcel" name="btn_downexcel">Down Excel</td><td class="btn2_right"></td></tr></table></td>
						<!-- Repeat Pattern -->
			
						</tr></table>
					</td></tr>
				</table>
		    	<!-- Button_Sub (E) -->
	
			</td></tr>
		</table>
	<!-- TABLE '#D' : ( Search Options ) (E) -->

</td></tr>
</table>
<!-- Outer Table (E)-->

<div id="hidden_sheets1" style="display:none">
	<!-- : ( Grid ) (S) -->
	<table width="100%"  id="mainTable">
	<tr><td><script language="javascript">ComSheetObject('hidden_sheet1');</script></td></tr></table>
	<!-- : ( Grid ) (E) -->
</div>


</form>
</body>
</html>