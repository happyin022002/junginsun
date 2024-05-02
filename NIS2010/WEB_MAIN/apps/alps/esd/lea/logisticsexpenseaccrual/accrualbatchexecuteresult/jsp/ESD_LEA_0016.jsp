<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_LEA_0016.jsp
*@FileTitle : Accessorial Cost Budget Management
*Open Issues :
*Change history :2015.04 Hyun Sung Gil 최초생성
*@LastModifyDate : 2015.04.08
*@LastModifier : 현성길
*@LastVersion : 1.0
* 1.0 Creation
**********************************************************************************
* 2015.11.11 김현화 [CHM-201538864]블라디보스톡 Combo Box 추가 관련- VVOIA RHQ 추가
* 2016.01.26 Budget Creation 권한 사번 추가(원종민대리/강춘수사원)
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.lea.common.CodeComboUtil"%>
<%@ page import="com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.event.EsdLea0016Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.StringUtil"%>
<%
	EsdLea0016Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String ofcCd		= "";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.LogisticsExpenseAccrual.AccrualBatchExecuteResult");
	
	String nowYYMM 		= "";
	String exe_yrmon	= "";
	String param_name 	= null;
	String ofc_cd	= "";
	String exeFromYYMM 	= "";
	String exeToYYMM 	= "";
	String strUsr_ofc_cd = "";
	String strUsr_rhq_ofc_cd = "";
	


	nowYYMM = DateTime.addMonths(JSPUtil.getKST("yyyy-MM"),-1,"yyyy-MM"); //Exe Year Month
	
	exeFromYYMM = nowYYMM.substring(0,4) + "-01";
	exeToYYMM 	= nowYYMM;
	
	java.util.Enumeration enums = request.getParameterNames();
	while (enums.hasMoreElements()){
		param_name = (String)enums.nextElement();
	}

	exe_yrmon	= StringUtil.xssFilter(request.getParameter("exe_yrmon")!=null&&!request.getParameter("exe_yrmon").equals("")?request.getParameter("exe_yrmon"):nowYYMM );
	exeFromYYMM	= StringUtil.xssFilter(request.getParameter("exeFromYYMM")!=null&&!request.getParameter("exeFromYYMM").equals("")?request.getParameter("exeFromYYMM"):exeFromYYMM );
	exeToYYMM	= StringUtil.xssFilter(request.getParameter("exeToYYMM")!=null&&!request.getParameter("exeToYYMM").equals("")?request.getParameter("exeToYYMM"):exeToYYMM );
	


	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		ofcCd = account.getOfc_cd();
		strUsr_ofc_cd = account.getOfc_cd();
		strUsr_rhq_ofc_cd = account.getRhq_ofc_cd();

		event = (EsdLea0016Event)request.getAttribute("Event");
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
<title>Expense Report Invoice Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
		//changeRHQCd1(document.form.f_rhq_cd[0].value);
	}
</script>
</head>

<iframe height="0" width="0" name="frmHidden"></iframe>
<body  onLoad="setupPage();">
<form method="post" name="form" >
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="iPage">
<input type="hidden" name="param1"> 
<input type="hidden" name="param2"> 
<input type="hidden" name="param3"> 
<input type="hidden" name="param4"> 
<input type="hidden" name="param5"> 
<input type="hidden" name="param6"> 
<input type="hidden" name="param7"> 
<input type="hidden" name="param8"> 
<input type="hidden" name="frm_retrieveDiv" value="0"> <!-- 조회구분 -->
<input type="hidden" name="usr_ofc_cd"		value="<%=strUsr_ofc_cd%>">
<input type="hidden" name="usr_rhq_ofc_cd"	value="<%=strUsr_rhq_ofc_cd%>">
<input type="hidden" name="ofc_type">
<input type="hidden" name="bind_ofc_cd">
<input type="hidden" name="bind_sub_ofc_cd">
<input type="hidden" name="acct_rhq_ofc_cd">
<input type="hidden" name="lstyr_from">
<input type="hidden" name="lstyr_to">
<input type="hidden" name="usr_id" value="<%=strUsr_id%>">

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
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_retrieve" name="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
<% if (strUsr_id.equals("jaeh605") || strUsr_id.equals("1110251")|| strUsr_id.equals("2006614")|| strUsr_id.equals("2006810")|| strUsr_id.equals("1410010")){ %>
					<td class="btn1_line"></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					    <tr><td class="btn1_left"></td><td class="btn1" id="btn_budget" name="btn_budget">MonthlyBudget</td><td class="btn1_right"></td></tr></table></td>
<%}else{%>
					<td class="btn1_line" style="display:none"></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" style="display:none">
					    <tr><td class="btn1_left"></td><td class="btn1" id="btn_budget" name="btn_budget" style="display:none">MonthlyBudget</td><td class="btn1_right"></td></tr></table></td>
<%} %>					    
				</tr></table>

			</td></tr>
		</table>
		<!--Button_L (E) -->


		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

			<!-- : ( Year ) (S) -->
			<table class="search_in" border="0" >
			<tr class="h23">
				<td width="80">G/L Month </td>
				<td width="200" ><input type="text" class="input1" style="width:55" name="gl_mon_from" valid="1" desc= "Exe Year-Month" value="<%=exeToYYMM%>" onKeyUp="lea_comm_isNumberMessage(this,6);" onBlur="lea_com_convertYymm(this);lea_com_enterKeyEvent('lea_enterRetrieve')" onClick="lea_com_select(this)">
												<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar1">&nbsp; ~ &nbsp;
												<input type="text" class="input1" style="width:55" name="gl_mon_to" valid="1" desc= "Exe Year-Month" value="<%=exeToYYMM%>" onKeyUp="lea_comm_isNumberMessage(this,6);" onBlur="lea_com_convertYymm(this);lea_com_enterKeyEvent('lea_enterRetrieve')" onClick="lea_com_select(this)">
												<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar2"></td>
				<td ><table border="0" style="height:23; width:700; background-color: #E9E9E9;">
							<tr class="h23">
								<td style="padding-left:10;">
									<input type="checkbox" name="f_cost_type_f" class="trans" value="1" checked  onClick="javascript:checkOption('full')">Full Expense&nbsp;
									<input type="checkbox" name="f_cost_type_m" class="trans" value="1" checked  onClick="javascript:checkOption('empty')">Empty Expense&nbsp;
									</td></tr>
			</table>
					</td>
							</tr>
						</table>

			<table class="search_in" border="0">
			<tr class="h23">
				<td width="60">Report </td>
				<td width="118">
					<SELECT style='width:110' name="f_report" onChange="changeReport(this.value);" class="input1">
					<OPTION value="1">RHQ</OPTION>
					<OPTION value="2">Control Office</OPTION>
					</SELECT>
				</td>
				<td width="35">RHQ</td>
				<td width="65">
					<SELECT style='width:70' name="f_rhq_cd" onChange="changeRHQCd1(this.value);" class="input1">
					<!--<OPTION value="">ALL</OPTION>  -->
					<OPTION value="HAMRU">HAMRU</OPTION>
                    <OPTION value="NYCRA">NYCRA</OPTION>
                    <OPTION value="SHARC">SHARC</OPTION>
                    <OPTION value="SINRS">SINRS</OPTION>
					<OPTION value="SELIB">SELIB</OPTION>
					<OPTION value="TYOIB">TYOIB</OPTION>
					<OPTION value="VVOIA">VVOIA</OPTION>
					</SELECT>
				</td>
				<td width="30">Parent&nbsp;Office</td>
				<td width="65">
					<div id="div_office">
						<SELECT style='width:75' name="f_ofc_cd" class="input" disabled></SELECT>
					</div>
				</td>
				<td width="30">Control&nbsp;Office</td>
				<td width="50">
					<SELECT style='width:75' name="f_sub_ofc_cd" class="input"></SELECT>
				</td>
				<td width= "145"></td>
				
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
				        </td>
				    </tr>
		         </table>	
	    	<!-- Button_Sub (E) -->

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