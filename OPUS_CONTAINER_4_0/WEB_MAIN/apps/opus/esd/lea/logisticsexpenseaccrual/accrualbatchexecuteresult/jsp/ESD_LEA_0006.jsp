<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_LEA_0006.jsp
*@FileTitle : Expense Report by Rev.Month
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
<%@ page import="com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.event.EsdLea0006Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdLea0006Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//The count of DB ResultSet list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.LogisticsExpenseAccrual.AccrualBatchExecuteResult");
	
	String nowYYMM 			= "";
	String revFromYYMM 		= "";
	String revToYYMM 		= "";
	String exe_yrmon		= "";
	String param_name = null;
	String open_div			= "";

	nowYYMM = DateTime.addMonths(JSPUtil.getKST("yyyy-MM"),-1,"yyyy-MM"); //Execute Year Month
	revFromYYMM = nowYYMM.substring(0,4) + "-01";                         //Revenue Year Month(From)
	revToYYMM 	= nowYYMM;                                                //Revenue Year Month(To)


	java.util.Enumeration enums = request.getParameterNames();
	while (enums.hasMoreElements()){
		param_name = (String)enums.nextElement();
	}

	exe_yrmon	 = request.getParameter("exe_yrmon"		)!=null&&!request.getParameter("exe_yrmon"	).equals("")?request.getParameter("exe_yrmon" 	):nowYYMM;
	revFromYYMM	 = request.getParameter("revFromYYMM"	)!=null&&!request.getParameter("revFromYYMM").equals("")?request.getParameter("revFromYYMM"	):revFromYYMM;
	revToYYMM	 = request.getParameter("revToYYMM"		)!=null&&!request.getParameter("revToYYMM"	).equals("")?request.getParameter("revToYYMM" 	):revToYYMM;

	open_div		 	 = request.getParameter("open_div"		)!=null&&!request.getParameter("open_div"		).equals("")?request.getParameter("open_div" 	):"";   

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsdLea0006Event)request.getAttribute("Event");
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
<title>Expense Report by Rev.Month</title>
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


<input type="hidden" name="iPage">
<input type="hidden" name="frm_retrieveDiv" value="0"> 
<input type="hidden" name="winopen_div" value="<%=open_div%>"> 

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>


		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Expense Report by Rev.Month</td></tr>
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
					<td width="160"><input type="text" class="input1" style="width:60;"  name="frm_exe_yrmon"  valid="1" desc= "Exe. Year-Month" value="<%=exe_yrmon%>" onKeyUp="lea_comm_isNumberMessage(this,6);"  onBlur="lea_com_convertYymm(this);lea_com_setRevToYymm(this,document.form.frm_rev_yrmon_from, document.form.frm_rev_yrmon_to);" onKeyDown="lea_setRevToYymm(this,document.form.frm_rev_yrmon_to);lea_com_enterKeyEvent('lea_enterRetrieve')"></td>
					<td width="112">Rev. Year-Month</td>
					<td width="230" class="stm"><input type="text" name="frm_rev_yrmon_from" class="input1" style="width:60;" valid="1" desc= "From Rev. Year-Month"  value="<%=revFromYYMM%>"  onKeyUp="lea_comm_isNumberMessage(this,6);" onBlur="lea_com_convertYymm(this);" onKeyDown="lea_com_enterKeyEvent('lea_enterRetrieve')">&nbsp; ~ &nbsp;<input type="text"  name="frm_rev_yrmon_to" class="input1" style="width:60;" valid="1" desc= "To Rev. Year-Month" value="<%=revToYYMM%>"  onKeyUp="lea_comm_isNumberMessage(this,6);" onFocusOut="lea_com_convertYymm(this);lea_comm_checkFromDateToDate(document.form.frm_rev_yrmon_from,this);" onKeyDown="lea_com_enterKeyEvent('lea_enterRetrieve')" >&nbsp;</td>
					<td>
							<table border="0" style="height:23; width:265; background-color: #E9E9E9;">
							<tr class="h23">
								<td style="padding-left:10;">
									<input type="checkbox" name="f_cost_type_f" class="trans" value="1" checked >Full Expense&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="checkbox" name="f_cost_type_m" class="trans" value="1" checked >Empty Expense</td>
								</tr>
							</table>
					</td>
				</tr>
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