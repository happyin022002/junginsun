<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_LEA_0015.jsp
*@FileTitle : Expense Report Invoice Inquiry
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
<%@ page import="com.clt.apps.opus.esm.coa.common.ComboUtil"%>
<%@ page import="com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.event.EsdLea0015Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdLea0015Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//The count of the DB ResultSet list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.LogisticsExpenseAccrual.AccrualBatchExecuteResult");
	
	String nowYYMM 		= "";
	String exe_yrmon	= "";
	String param_name 	= null;

	nowYYMM = DateTime.addMonths(JSPUtil.getKST("yyyy-MM"),-1,"yyyy-MM"); //Exe Year Month

	java.util.Enumeration enums = request.getParameterNames();
	while (enums.hasMoreElements()){
		param_name = (String)enums.nextElement();
	}

	exe_yrmon	= request.getParameter("exe_yrmon")!=null&&!request.getParameter("exe_yrmon").equals("")?request.getParameter("exe_yrmon"):nowYYMM;

//	String cookieCostTypeM="";
//	String cookieCostTypeF="";
//	Cookie[] cookies = request.getCookies();
//	if (cookies != null) {
//		for (int loop = 0; loop < cookies.length; loop++) {
//				if (cookies[loop].getName().equals("form_lea_cost_type_m")) {
//						 cookieCostTypeM=cookies[loop].getValue();
//				}
//				if (cookies[loop].getName().equals("form_lea_cost_type_f")) {
//						 cookieCostTypeF=cookies[loop].getValue();
//				}
//		}
//	}


	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsdLea0015Event)request.getAttribute("Event");
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
<title>Expense Report Invoice Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
		changeRHQCd(document.form.f_rhq_cd[0].value);
	}
</script>
</head>

<iframe height="0" width="0" name="frmHidden"></iframe>
<body  onLoad="setupPage();">
<form method="post" name="form" >
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="iPage">
<input type="hidden" name="frm_retrieveDiv" value="0">

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
				<td width="114">G/L Year-Month </td>
				<td width="119"><input type="text" class="input1" style="width:55" name="exe_yrmon" valid="1" desc= "Exe Year-Month" value="<%=exe_yrmon%>" onKeyUp="lea_comm_isNumberMessage(this,6);" onBlur="lea_com_convertYymm(this);lea_com_enterKeyEvent('lea_enterRetrieve')"></td>
				<td><input type="checkbox" name="f_vndr" class="trans" value="1" checked>&nbsp;Show S/P Seq. & Name</td></tr>
			</table>

			<table class="search_in" border="0">
			<tr class="h23">
				<td width="60">Report </td>
				<td width="180">
					<SELECT style='width:110' name="f_report" onChange="reportChange(this.value);" class="input1">
					<OPTION value="1">RHQ</OPTION>
					<OPTION value="2">Control Office</OPTION>
					</SELECT>
				</td>
				<td width="35">RHQ</td>
				<td width="140">
					<SELECT style='width:80' name="f_rhq_cd" onChange="changeRHQCd(this.value);" class="input1">
					<OPTION value="HAMUR">HAMUR</OPTION>
					<OPTION value="NYCNA">NYCNA</OPTION>
					<OPTION value="SHAAS">SHAAS</OPTION>
					<OPTION value="SINWA">SINWA</OPTION>
					</SELECT>
				</td>
				<td width="40">Office</td>
				<td width="140">
					<div id="div_office">
					<%= ComboUtil.getCodeCombo("f_ctrl_ofc_cd", "", " style='width:80' disabled", "lgsOFC", "", "All", "") %>
					</div>
				</td>
				<td>
						<table border="0" style="height:23; width:385; background-color: #E9E9E9;">
							<tr class="h23">
								<td style="padding-left:10;">
									<input type="checkbox" name="f_cost_type_f" class="trans" value="1"   onClick="javascript:checkOption('full')">Full Expense&nbsp;&nbsp;
									<input type="checkbox" name="f_cost_type_m" class="trans" value="1"   onClick="javascript:checkOption('empty')">Empty Expense&nbsp;&nbsp;
									<input type="checkbox" name="f_cost_type_v" class="trans" value="1" unchecked  onClick="javascript:checkOption('vol')">Volume Incentive&nbsp;&nbsp;
								</td>
							</tr>
						</table>
				</td>
			</tr>
			</table>
			<!-- : ( Year ) (E) -->

			</td>
		</tr>
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
						<tr><td class="btn2_left"></td><td class="btn2" id="btng_downexcel" name="btng_downexcel">Down Excel</td><td class="btn2_right"></td></tr></table></td>
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
		<tr><td>
			 <script language="javascript">ComSheetObject('hidden_sheet1');</script>
		</td></tr>
	</table>
</div>

</form>
</body>
</html>