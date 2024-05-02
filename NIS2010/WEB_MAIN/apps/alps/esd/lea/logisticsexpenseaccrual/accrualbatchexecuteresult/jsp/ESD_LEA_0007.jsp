<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_LEA_0007.jsp
*@FileTitle : Expense Report by Exe.Month
*Open Issues :
*Change history :2007.01 Park Yeon Jin 최초생성
*@LastModifyDate : 2009.09.08
*@LastModifier : 전재홍
*@LastVersion : 1.0
* 2009.09.08 전재홍
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
<%@ page import="com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.event.EsdLea0007Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.apps.alps.esd.lea.common.CodeComboUtil"%>

<%
	EsdLea0007Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.LogisticsExpenseAccrual.AccrualBatchExecuteResult");
	
	String nowYYMM 		= "";
	String exeFromYYMM 	= "";
	String exeToYYMM 	= "";
	String rev_yrmon	= "";
	String param_name 	= null;

	nowYYMM 	= DateTime.addMonths(JSPUtil.getKST("yyyy-MM"),-1,"yyyy-MM");
	//exeFromYYMM = DateTime.getYear()+"-01";
	exeFromYYMM = nowYYMM.substring(0,4) + "-01";
	exeToYYMM 	= nowYYMM;

	java.util.Enumeration enums = request.getParameterNames();
	while (enums.hasMoreElements()){
		param_name = (String)enums.nextElement();
	}

	rev_yrmon	= request.getParameter("rev_yrmon"		)!=null&&!request.getParameter("rev_yrmon"	).equals("")?request.getParameter("rev_yrmon" 	):nowYYMM;
	exeFromYYMM	= request.getParameter("exeFromYYMM"	)!=null&&!request.getParameter("exeFromYYMM").equals("")?request.getParameter("exeFromYYMM"	):exeFromYYMM;
	exeToYYMM	= request.getParameter("exeToYYMM"		)!=null&&!request.getParameter("exeToYYMM"	).equals("")?request.getParameter("exeToYYMM" 	):exeToYYMM;

	

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsdLea0007Event)request.getAttribute("Event");
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
<title>Expense Report by Exe.Month</title>
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

<input type="hidden" name="iPage">
<input type="hidden" name="frm_retrieveDiv" value="0"> <!-- 조회구분 -->


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
					<td width="112">Rev. Year-Month</td>
					<td width="90"><input type="text" class="input1" style="width:60;" name="frm_rev_yrmon" valid="1" desc= "Rev. Year-Month" value="<%=rev_yrmon%>" onKeyUp="lea_comm_isNumberMessage(this,6);" onBlur="lea_com_convertYymm(this);lea_com_setRevToYymm(this,document.form.frm_exe_yrmon_from, document.form.frm_exe_yrmon_to);" onKeyDown="lea_setRevToYymm(this,document.form.frm_exe_yrmon_to);lea_com_enterKeyEvent('lea_enterRetrieve')"></td>
					<td width="112">Exe. Year-Month</td>
					<td width="180" class="stm"><input type="text" name="frm_exe_yrmon_from" class="input1" style="width:60;" valid="1" desc= "From Exe. Year-Month" value="<%=exeFromYYMM%>" onKeyUp="lea_comm_isNumberMessage(this,6);" onBlur="lea_com_convertYymm(this);" onKeyDown="lea_com_enterKeyEvent('lea_enterRetrieve')">&nbsp; ~ &nbsp;<input type="text"  name="frm_exe_yrmon_to" class="input1" style="width:60;" valid="1" desc= "To Exe. Year-Month" value="<%=exeToYYMM%>"  onKeyUp="lea_comm_isNumberMessage(this,6);" onBlur="lea_com_convertYymm(this);lea_comm_checkFromDateToDate(document.form.frm_exe_yrmon_from,this);" onKeyDown="lea_com_enterKeyEvent('lea_enterRetrieve')" ></td>
					<td>
							<table border="0" style="height:23; width:500; background-color: #E9E9E9;">
							<tr class="h23">
								<td style="padding-left:10;">
									<input type="checkbox" name="f_cost_type_f" class="trans" value="1" checked  onClick="javascript:checkOption('full')">Full Expense&nbsp;
									<input type="checkbox" name="f_cost_type_m" class="trans" value="1" checked  onClick="javascript:checkOption('empty')">Empty Expense&nbsp;
									<input type="checkbox" name="f_cost_type_c" class="trans" value="1"   onClick="javascript:checkOption('chassis')">Chassis Expense&nbsp;
									<input type="checkbox" name="f_cost_type_v" class="trans" value="1"   onClick="javascript:checkOption('vol')">Volume Incentive&nbsp;
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


<!-- 개발자 작업  끝 -->
</form>
</body>
</html>