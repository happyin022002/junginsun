<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_LEA_0021.jsp
*@FileTitle : Accrual Adjustment
*Open Issues :
*Change history : 
*@LastModifyDate : 2011.10.21
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2011.10.21 민정호
* 1.0 Creation
*
* 2011.10.31 [CHM-201114105] [LEA] ALPS UI에 조정계수 입력화면 Accrual Adjustment 추가
* 2011.12.26 [CHM-201115071] [LEA] Full Volume Incentive Auto 변환 관련 화면변경 요청
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.event.EsdLea0021Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdLea0021Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.LogisticsExpenseAccrual.AccrualBatchExecuteResult");

	String nowYYMM 			= "";
	String revYYMM 	= "";
	String param_name = null;


	nowYYMM = DateTime.addMonths(JSPUtil.getKST("yyyy-MM"),-1,"yyyy-MM");
	revYYMM = nowYYMM;
	
	java.util.Enumeration enums = request.getParameterNames();
	while (enums.hasMoreElements()){
	param_name = (String)enums.nextElement();
	}

	String exe_yrmon		 = request.getParameter("exe_yrmon"		)!=null&&!request.getParameter("exe_yrmon"	).equals("")?request.getParameter("exe_yrmon" ):nowYYMM;
	String open_div		 	 = request.getParameter("open_div"		)!=null&&!request.getParameter("open_div"		).equals("")?request.getParameter("open_div" 	):"";
		
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsdLea0021Event)request.getAttribute("Event");
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
<title>Accrual Adjustment</title>
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
<input type="hidden" name="date_sts">

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
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" id="btn_reset" name="btn_reset">Reset</td><td class="btn1_right"></td></tr></table></td>
				<td class="btn1_line"></td>										
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">				
					<tr><td class="btn1_left"></td><td class="btn1" id="btn_save" name="btn_save">Save</td><td class="btn1_right"></td></tr></table></td>					
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" id="btn_verify" name="btn_verify">Verify</td><td class="btn1_right"></td></tr></table></td>					
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" id="btn_confirm" name="btn_confirm">Confirm</td><td class="btn1_right"></td></tr></table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" id="btn_apply" name="btn_apply">Apply</td><td class="btn1_right"></td></tr></table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" id="btn_finalize" name="btn_finalize">Finalize</td><td class="btn1_right"></td></tr></table></td>																			
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
					<td width="5">&nbsp;</td>
					<td width="110">Exe. Year-Month</td>
					<td><input type="text" style="width:60;" class="input1" name="exe_yrmon"  valid="1" desc= "Exe. Year-Month" value="<%=exe_yrmon%>" onKeyUp="lea_comm_isNumberMessage(this,6);"  onBlur="lea_com_convertYymm(this);lea_com_setRevToYymm(this,document.form.frm_rev_yrmon_from, document.form.frm_rev_yrmon_to);" onKeyDown="lea_setRevToYymm(this,document.form.frm_rev_yrmon_to);lea_com_enterKeyEvent('lea_enterRetrieve')" onClick="lea_com_select(this)"></td>
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
			       	<tr>
			       		<td class="btn2_bg">
							<table border="0">
								<tr class="h23">
									<td width="5%"></td>
									<td width="16%"><input name="confirmInfo" class="transgray" type="text" style="width:200" value="" readonly></td>
									<td width="5%">&nbsp;</td>
									<td width="15%">&nbsp;Apply Started Date </td>
									<td width="16%"><input name="applyStartDate" type="text" style="width:150" value="" readonly></td>
									<td width="3%">&nbsp;</td>							
									<td width="10%">&nbsp;Finished Date </td>
									<td><input name="finishDate" type="text" style="width:150" value="" readonly></td>							
								</tr>
							</table>			       		
			       		</td>
			       	</tr>
			       	<tr>	
			       		<td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btn_downexcel" name="btn_downexcel">Down Excel</td><td class="btn2_right"></td></tr></table></td>	
							<!-- Repeat Pattern -->
					</tr>
					</table>
				</td></tr>
				</table>
		    	<!-- Button_Sub (E) -->
			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->
</td></tr>
</table>
<!-- Outer Table (E)-->
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>